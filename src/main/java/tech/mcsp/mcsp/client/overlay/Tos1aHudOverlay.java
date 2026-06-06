package tech.mcsp.mcsp.client.overlay;

import com.atsuishio.superbwarfare.data.gun.GunData;
import com.atsuishio.superbwarfare.data.gun.GunProp;
import com.atsuishio.superbwarfare.tools.FormatTool;
import com.atsuishio.superbwarfare.tools.RangeTool;
import net.minecraft.client.CameraType;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import tech.mcsp.mcsp.entity.Tos1aEntity;

@OnlyIn(Dist.CLIENT)
public final class Tos1aHudOverlay {
    private Tos1aHudOverlay() {
    }

    public static void render(GuiGraphics guiGraphics, DeltaTracker deltaTracker) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null) {
            return;
        }
        if (!(player.getVehicle() instanceof Tos1aEntity tos)) {
            return;
        }
        if (mc.options.getCameraType() != CameraType.FIRST_PERSON) {
            return;
        }

        int color = tos.getHudColor();
        float pitch = tos.getTurretXRot();
        float yaw = tos.getTurretYRot();

        GunData gunData = tos.getGunData(player);
        double velocity = 8;
        double gravity = 0.04;
        if (gunData != null) {
            velocity = gunData.get(GunProp.VELOCITY);
            gravity = gunData.get(GunProp.GRAVITY);
        }
        double range = RangeTool.getRange(-pitch, velocity, gravity);

        int screenWidth = guiGraphics.guiWidth();
        int screenHeight = guiGraphics.guiHeight();
        int x = screenWidth / 2 - 165;
        int y = screenHeight / 2 - 16;

        guiGraphics.drawString(mc.font, Component.translatable("tips.superbwarfare.mortar.pitch")
                .append(Component.literal(FormatTool.format2D(-pitch, "°"))), x, y, color, false);
        guiGraphics.drawString(mc.font, Component.translatable("tips.superbwarfare.mortar.yaw")
                .append(Component.literal(FormatTool.format2D(-yaw, "°"))), x, y + 10, color, false);
        guiGraphics.drawString(mc.font, Component.translatable("tips.superbwarfare.mortar.range")
                .append(Component.literal(FormatTool.format1D(Math.max((int) range, 0), "m"))), x, y + 20, color, false);
    }
}
