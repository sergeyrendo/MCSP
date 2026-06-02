package tech.mcsp.mcsp.init;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tech.mcsp.mcsp.client.renderer.entity.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEntityRenderers {

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {

		event.registerEntityRenderer(ModEntities.HUMVEE_STANDART_CAMO.get(), HumveeStandartCamoRenderer::new);
		event.registerEntityRenderer(ModEntities.HUMVEE_CARC.get(), HumveeCarcRenderer::new);
		event.registerEntityRenderer(ModEntities.HUMVEE_MK19.get(), HumveeMk19Renderer::new);
		event.registerEntityRenderer(ModEntities.HUMVEE_SAND.get(), HumveeSandRenderer::new);


        event.registerEntityRenderer(ModEntities.BMD_4.get(), Bmd4Renderer::new);
        event.registerEntityRenderer(ModEntities.BMD_4_CAMO.get(), Bmd4CamoRenderer::new);
        event.registerEntityRenderer(ModEntities.SPRUT.get(), SprutRenderer::new);
        event.registerEntityRenderer(ModEntities.SPRUT_CAMO.get(), SprutCamoRenderer::new);
        event.registerEntityRenderer(ModEntities.M3A3_BRADLEY.get(), M3A3Renderer::new);
        event.registerEntityRenderer(ModEntities.M3A3_BRADLEY_BUSK_II.get(), M3A3BuskIIRenderer::new);
        event.registerEntityRenderer(ModEntities.M3A3_BRADLEY_BUSK_III.get(), M3A3BuskIIIRenderer::new);
        event.registerEntityRenderer(ModEntities.M3A3_BRADLEY_SAND.get(), M3A3SandRenderer::new);
        event.registerEntityRenderer(ModEntities.M3A3_BRADLEY_BUSK_II_SAND.get(), M3A3BuskIISandRenderer::new);
        event.registerEntityRenderer(ModEntities.M3A3_BRADLEY_BUSK_III_SAND.get(), M3A3BuskIIISandRenderer::new);

        // M1A2 Abrams
        event.registerEntityRenderer(ModEntities.M1A2.get(), M1A2Renderer::new);
        event.registerEntityRenderer(ModEntities.M1A2_SEP.get(), M1A2SepRenderer::new);
        event.registerEntityRenderer(ModEntities.M1A2_SAND.get(), M1A2SandRenderer::new);
        event.registerEntityRenderer(ModEntities.M1A2_SEP_SAND.get(), M1A2SepSandRenderer::new);

        event.registerEntityRenderer(ModEntities.T80BV_CAMO.get(), T80bvCamoRenderer::new);
        event.registerEntityRenderer(ModEntities.T80BV_GREEN.get(), T80bvGreenRenderer::new);
        event.registerEntityRenderer(ModEntities.T80BV_KANTEMIR.get(), T80bvKantemirRenderer::new);
        event.registerEntityRenderer(ModEntities.T80BV_PIXEL.get(), T80bvPixelRenderer::new);

        event.registerEntityRenderer(ModEntities.T80U_CAMO.get(), T80uCamoRenderer::new);
        event.registerEntityRenderer(ModEntities.T80U_GREEN.get(), T80uGreenRenderer::new);
        event.registerEntityRenderer(ModEntities.T80U_KANTEMIR.get(), T80uKantemirRenderer::new);
        event.registerEntityRenderer(ModEntities.T80U_PIXEL.get(), T80uPixelRenderer::new);

        event.registerEntityRenderer(ModEntities.T90A_GREEN.get(), T90aGreenRenderer::new);
        event.registerEntityRenderer(ModEntities.T90A_TRICOLOR.get(), T90aTricolorRenderer::new);

        event.registerEntityRenderer(ModEntities.TOS_1A_GREEN.get(), Tos1aGreenRenderer::new);
        event.registerEntityRenderer(ModEntities.TOS_1A_TRICOLOR.get(), Tos1aTricolorRenderer::new);

        event.registerEntityRenderer(ModEntities.TYPHOON_30.get(), Typhoon30Renderer::new);
        event.registerEntityRenderer(ModEntities.TYPHOON_TRICOLOR_30.get(), TyphoonTricolor30Renderer::new);

        event.registerEntityRenderer(ModEntities.URAL_GREEN.get(), UralGreenRenderer::new);
        event.registerEntityRenderer(ModEntities.URAL_TRICOLOR.get(), UralTricolorRenderer::new);

        event.registerEntityRenderer(ModEntities.ZBD04A_GREEN.get(), Zbd04aGreenRenderer::new);
        event.registerEntityRenderer(ModEntities.ZBD04A_SAND.get(), Zbd04aSandRenderer::new);
        event.registerEntityRenderer(ModEntities.ZTZ99A_SAND.get(), Ztz99aSandRenderer::new);
    }

    @SubscribeEvent
    public static void addLayers(EntityRenderersEvent.AddLayers event) {
        // Начиная с GeckoLib 4.4.x, регистрация делается через initializeClient в самом предмете.
        // Этот метод оставлен пустым намеренно.
    }

    /**
     * Регистрация всех рендереров сущностей
     * @deprecated Используйте метод registerEntityRenderers с аннотацией @SubscribeEvent
     */
    @Deprecated
    public static void register() {
        // Эта функция больше не используется
        // Все регистрации перенесены в метод registerEntityRenderers
    }
}

