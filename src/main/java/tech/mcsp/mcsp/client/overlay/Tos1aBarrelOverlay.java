package tech.mcsp.mcsp.client.overlay;

import com.atsuishio.superbwarfare.tools.OBB;
import com.atsuishio.superbwarfare.tools.VectorToolKt;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import tech.mcsp.mcsp.MCSP;
import tech.mcsp.mcsp.entity.Tos1aEntity;
import tech.mcsp.mcsp.init.ModItems;

import static tech.mcsp.mcsp.entity.Tos1aEntity.LOADED_AMMO;

@OnlyIn(Dist.CLIENT)
public class Tos1aBarrelOverlay implements IGuiOverlay {

    public static final Tos1aBarrelOverlay INSTANCE = new Tos1aBarrelOverlay();
    public static final String ID = MCSP.MOD_ID + "_tos1a_barrel";

    private static final ItemStack MLRS = ModItems.MLRS_SHELLS.get().getDefaultInstance();
    private static final double MAX_DISPLAY_DISTANCE = 4.0;

    @Override
    public void render(ForgeGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        Minecraft mc = gui.getMinecraft();
        Player player = mc.player;
        if (player == null) return;
        if (player.getVehicle() instanceof Tos1aEntity) return;

        Tos1aEntity tos = findLookingTos(player);
        if (tos == null) return;

        int lookingIndex = tos.getLookingShellIndex(player);
        if (lookingIndex < 0) return;

        var items = tos.getEntityData().get(LOADED_AMMO);
        if (lookingIndex >= items.size()) return;

        int type = items.get(lookingIndex);
        ItemStack stack = type >= 0 ? MLRS : ItemStack.EMPTY;

        var obb = tos.barrelOBB[lookingIndex];
        Vec3 center = OBB.vector3dToVec3(obb.center);
        Vec3 barrelDir = tos.getBarrelVector(partialTick);
        double halfLength = obb.extents().z;
        Vec3 pos = center.subtract(barrelDir.scale(halfLength));

        if (pos.distanceTo(player.getEyePosition()) > MAX_DISPLAY_DISTANCE) return;
        if (!VectorToolKt.canSee(pos)) return;

        Vec3 point = VectorToolKt.worldToScreen(pos);

        PoseStack poseStack = guiGraphics.pose();
        poseStack.pushPose();
        float x = (float) point.x;
        float y = (float) point.y;

        Component component = stack.isEmpty()
                ? Component.translatable("tips.superbwarfare.barrel_empty")
                : stack.getHoverName();

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

    private static Tos1aEntity findLookingTos(Player player) {
        double reach = player.getEntityReach() + 2.0;
        AABB box = player.getBoundingBox().inflate(reach);

        Tos1aEntity closest = null;
        double closestDist = Double.MAX_VALUE;

        for (Entity entity : player.level().getEntities(player, box)) {
            if (!(entity instanceof Tos1aEntity tos)) continue;
            if (tos.getLookingShellIndex(player) < 0) continue;

            double dist = entity.distanceToSqr(player);
            if (dist < closestDist) {
                closestDist = dist;
                closest = tos;
            }
        }

        return closest;
    }
}
