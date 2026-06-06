package tech.mcsp.mcsp.client;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;
import tech.mcsp.mcsp.MCSP;
import tech.mcsp.mcsp.client.overlay.APSWarningOverlay;
import tech.mcsp.mcsp.client.overlay.Tos1aBarrelOverlay;
import tech.mcsp.mcsp.client.overlay.Tos1aHudOverlay;

@EventBusSubscriber(modid = MCSP.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ModClientEvents {
    private static final ResourceLocation APS_WARNING_LAYER = ResourceLocation.fromNamespaceAndPath(MCSP.MOD_ID, "aps_warning");
    private static final ResourceLocation TOS1A_HUD_LAYER = ResourceLocation.fromNamespaceAndPath(MCSP.MOD_ID, "tos1a_hud");
    private static final ResourceLocation TOS1A_BARREL_LAYER = ResourceLocation.fromNamespaceAndPath(MCSP.MOD_ID, "tos1a_barrel");

    private ModClientEvents() {
    }

    @SubscribeEvent
    public static void registerGuiLayers(RegisterGuiLayersEvent event) {
        event.registerAbove(VanillaGuiLayers.CROSSHAIR, APS_WARNING_LAYER, APSWarningOverlay::render);
        event.registerAbove(VanillaGuiLayers.CROSSHAIR, TOS1A_HUD_LAYER, Tos1aHudOverlay::render);
        event.registerAbove(VanillaGuiLayers.CROSSHAIR, TOS1A_BARREL_LAYER, Tos1aBarrelOverlay::render);
    }
}
