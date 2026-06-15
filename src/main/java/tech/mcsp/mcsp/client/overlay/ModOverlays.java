package tech.mcsp.mcsp.client.overlay;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.mcsp.mcsp.MCSP;
import tech.mcsp.mcsp.client.overlay.Tos1aBarrelOverlay;
import tech.mcsp.mcsp.client.overlay.Tos1aHudOverlay;

// Аннотация @Mod.EventBusSubscriber автоматически регистрирует этот класс.
// bus = Bus.MOD означает, что мы слушаем события инициализации мода (включая регистрацию).
// value = Dist.CLIENT означает, что код будет выполняться только на клиенте (защита от крашей на сервере).
@Mod.EventBusSubscriber(modid = MCSP.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOverlays {

    @SubscribeEvent
    public static void registerOverlays(RegisterGuiOverlaysEvent event) {
        // Регистрируем наш HUD (прицел, дальность и т.д.)
        // Мы рендерим его "поверх" стандартного прицела (CROSSHAIR) или хотбара (HOTBAR)
        event.registerAbove(VanillaGuiOverlay.CROSSHAIR.id(), Tos1aHudOverlay.ID, new Tos1aHudOverlay());

        // Регистрируем оверлей ствола с патронами
        event.registerAbove(VanillaGuiOverlay.CROSSHAIR.id(), Tos1aBarrelOverlay.ID, new Tos1aBarrelOverlay());
    }
}