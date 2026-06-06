package tech.mcsp.mcsp.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.mcsp.mcsp.MCSP;
import tech.mcsp.mcsp.client.overlay.APSWarningOverlay;
import tech.mcsp.mcsp.client.overlay.Tos1aBarrelOverlay;
import tech.mcsp.mcsp.client.overlay.Tos1aHudOverlay;

@Mod.EventBusSubscriber(modid = MCSP.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ModClientEvents {

    private ModClientEvents() {
    }

    @SubscribeEvent
    public static void registerOverlays(RegisterGuiOverlaysEvent event) {
        event.registerAbove(VanillaGuiOverlay.CROSSHAIR.id(), APSWarningOverlay.ID, APSWarningOverlay.INSTANCE);
        event.registerAbove(VanillaGuiOverlay.CROSSHAIR.id(), Tos1aHudOverlay.ID, Tos1aHudOverlay.INSTANCE);
        event.registerAbove(VanillaGuiOverlay.CROSSHAIR.id(), Tos1aBarrelOverlay.ID, Tos1aBarrelOverlay.INSTANCE);
    }
}
