package tech.mcsp.mcsp.client;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;
import tech.mcsp.mcsp.MCSP;
import tech.mcsp.mcsp.client.overlay.APSWarningOverlay;

@EventBusSubscriber(modid = MCSP.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ModClientEvents {
    private static final ResourceLocation APS_WARNING_LAYER = ResourceLocation.fromNamespaceAndPath(MCSP.MOD_ID, "aps_warning");

    private ModClientEvents() {
    }

    @SubscribeEvent
    public static void registerGuiLayers(RegisterGuiLayersEvent event) {
        event.registerAbove(VanillaGuiLayers.CROSSHAIR, APS_WARNING_LAYER, APSWarningOverlay::render);
    }
}
