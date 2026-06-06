package tech.mcsp.mcsp.client.overlay;

import com.atsuishio.superbwarfare.tools.FormatTool;
import com.atsuishio.superbwarfare.tools.RangeTool;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import tech.mcsp.mcsp.MCSP;
import tech.mcsp.mcsp.entity.Tos1aEntity;

@OnlyIn(Dist.CLIENT)
public class Tos1aHudOverlay implements IGuiOverlay {

    public static final Tos1aHudOverlay INSTANCE = new Tos1aHudOverlay();
    public static final String ID = MCSP.MOD_ID + "_tos1a_hud";

    @Override
    public void render(ForgeGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        Minecraft mc = gui.getMinecraft();
        Player player = mc.player;

        if (player == null) return;
        if (!(player.getVehicle() instanceof Tos1aEntity tos)) return;
        if (mc.options.getCameraType() != CameraType.FIRST_PERSON) return;

        int color = tos.getHudColor();

        float pitch = tos.getTurretXRot();
        float yaw = tos.getTurretYRot();

        var gunData = tos.getGunData(player);
        double velocity = gunData != null ? gunData.compute().velocity : 8;
        double gravity = gunData != null ? gunData.compute().getGravity() : 0.04;
        double range = RangeTool.getRange(-pitch, velocity, gravity);

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
