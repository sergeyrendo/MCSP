package tech.mcsp.mcsp.client.overlay;

import com.atsuishio.superbwarfare.entity.vehicle.base.VehicleEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import tech.mcsp.mcsp.MCSP;

@OnlyIn(Dist.CLIENT)
public class APSWarningOverlay implements IGuiOverlay {

    public static final APSWarningOverlay INSTANCE = new APSWarningOverlay();
    public static final String ID = MCSP.MOD_ID + "_aps_warning";

    private static Component message = null;
    private static long showTime = 0;
    private static int duration = 0;

    public static void show(Component msg, int durationTicks) {
        message = msg;
        showTime = System.currentTimeMillis();
        duration = durationTicks * 50;
    }

    @Override
    public void render(ForgeGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        if (message == null) return;

        long elapsed = System.currentTimeMillis() - showTime;
        if (elapsed > duration) {
            message = null;
            return;
        }

        Player player = gui.getMinecraft().player;
        if (player == null) return;
        if (!(player.getVehicle() instanceof VehicleEntity)) return;

        float progress = (float) elapsed / duration;
        float alpha = Mth.clamp(1.0f - progress, 0.0f, 1.0f);

        int textWidth = Minecraft.getInstance().font.width(message);
        int x = (screenWidth - textWidth) / 2;
        int y = screenHeight / 2 + 30;

        int baseColor = 0xFFFFFF;
        guiGraphics.setColor(1.0f, 1.0f, 1.0f, alpha);
        guiGraphics.drawString(Minecraft.getInstance().font, message, x, y, baseColor, false);
        guiGraphics.setColor(1.0f, 1.0f, 1.0f, 1.0f);
    }
}
