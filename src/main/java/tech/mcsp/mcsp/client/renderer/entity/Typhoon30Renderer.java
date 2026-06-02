package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.mcsp.mcsp.client.model.Typhoon30Model;
import tech.mcsp.mcsp.entity.Typhoon30Entity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class Typhoon30Renderer extends VehicleRenderer<Typhoon30Entity> {
    public Typhoon30Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new Typhoon30Model());
    }

    @Override
    public RenderType getRenderType(Typhoon30Entity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
