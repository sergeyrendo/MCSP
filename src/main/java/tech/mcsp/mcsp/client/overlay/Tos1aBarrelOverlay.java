package tech.mcsp.mcsp.client.overlay;

import com.atsuishio.superbwarfare.tools.OBB;
import com.atsuishio.superbwarfare.tools.VectorToolKt;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import tech.mcsp.mcsp.entity.Tos1aEntity;
import tech.mcsp.mcsp.init.ModItems;

import static tech.mcsp.mcsp.entity.Tos1aEntity.LOADED_AMMO;

@OnlyIn(Dist.CLIENT)
public final class Tos1aBarrelOverlay {
    private static final ItemStack MLRS = ModItems.MLRS_SHELLS.get().getDefaultInstance();
    private static final double MAX_DISPLAY_DISTANCE = 4.0;
    private static final double SEARCH_RADIUS = 12.0;

    private Tos1aBarrelOverlay() {
    }

    public static void render(GuiGraphics guiGraphics, DeltaTracker deltaTracker) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null) {
            return;
        }
        if (player.getVehicle() instanceof Tos1aEntity) {
            return;
        }

        float partialTick = deltaTracker.getGameTimeDeltaPartialTick(false);
        Tos1aEntity tos = findLookingTos1a(player);
        if (tos == null) {
            return;
        }

        int shellIndex = tos.getLookingShellIndex(player);
        if (shellIndex < 0) {
            return;
        }

        var items = tos.getEntityData().get(LOADED_AMMO);
        int type = items.get(shellIndex);
        ItemStack stack = type >= 0 ? MLRS : ItemStack.EMPTY;

        OBB obb = tos.barrelOBB[shellIndex];
        Vec3 center = OBB.vector3dToVec3(obb.center);
        Vec3 barrelDir = tos.getBarrelVector(partialTick);
        Vec3 pos = center.subtract(barrelDir.scale(obb.extents().z));

        if (pos.distanceTo(player.getEyePosition()) > MAX_DISPLAY_DISTANCE) {
            return;
        }
        if (!VectorToolKt.canSee(pos)) {
            return;
        }

        Vec3 point = VectorToolKt.worldToScreen(pos);
        Component component = stack.isEmpty()
                ? Component.translatable("tips.superbwarfare.barrel_empty")
                : stack.getHoverName();

        PoseStack poseStack = guiGraphics.pose();
        poseStack.pushPose();
        float x = (float) point.x;
        float y = (float) point.y;

        if (stack.isEmpty()) {
            int width = mc.font.width(component);
            poseStack.translate(x - width / 2F, y, 0);
            guiGraphics.drawString(mc.font, component, 0, 0, -1, false);
        } else {
            int width = mc.font.width(component) + 20;
            poseStack.translate(x - width / 2F, y, 0);
            guiGraphics.renderFakeItem(stack, 0, 0);
            poseStack.translate(20, 4, 0);
            guiGraphics.drawString(mc.font, component, 0, 0, -1, false);
        }

        poseStack.popPose();
    }

    private static Tos1aEntity findLookingTos1a(Player player) {
        AABB searchBox = player.getBoundingBox().inflate(SEARCH_RADIUS);
        Tos1aEntity closest = null;
        double closestDist = Double.MAX_VALUE;

        for (Tos1aEntity tos : player.level().getEntitiesOfClass(Tos1aEntity.class, searchBox)) {
            int index = tos.getLookingShellIndex(player);
            if (index < 0) {
                continue;
            }

            OBB obb = tos.barrelOBB[index];
            Vec3 pos = OBB.vector3dToVec3(obb.center);
            double dist = pos.distanceToSqr(player.getEyePosition());
            if (dist < closestDist) {
                closestDist = dist;
                closest = tos;
            }
        }

        return closest;
    }
}
