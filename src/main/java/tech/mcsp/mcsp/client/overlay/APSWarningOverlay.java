package tech.mcsp.mcsp.client.overlay;

import com.atsuishio.superbwarfare.entity.vehicle.base.VehicleEntity;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public final class APSWarningOverlay {
    private static Component message;
    private static long showTime;
    private static int duration;

    private APSWarningOverlay() {
    }

    public static void show(Component msg, int durationTicks) {
        message = msg;
        showTime = System.currentTimeMillis();
        duration = durationTicks * 50;
    }

    public static void render(GuiGraphics guiGraphics, DeltaTracker deltaTracker) {
        if (message == null) {
            return;
        }

        long elapsed = System.currentTimeMillis() - showTime;
        if (elapsed > duration) {
            message = null;
            return;
        }

        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null || !(player.getVehicle() instanceof VehicleEntity)) {
            return;
        }

        float progress = (float) elapsed / duration;
        float alpha = Mth.clamp(1.0f - progress, 0.0f, 1.0f);

        int screenWidth = guiGraphics.guiWidth();
        int screenHeight = guiGraphics.guiHeight();
        int textWidth = minecraft.font.width(message);
        int x = (screenWidth - textWidth) / 2;
        int y = screenHeight / 2 + 30;

        guiGraphics.setColor(1.0f, 1.0f, 1.0f, alpha);
        guiGraphics.drawString(minecraft.font, message, x, y, 0xFFFFFF, false);
        guiGraphics.setColor(1.0f, 1.0f, 1.0f, 1.0f);
    }
}
