package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import tech.mcsp.mcsp.client.model.T80bvPixelModel;
import tech.mcsp.mcsp.entity.T80bvPixelEntity;

public class T80bvPixelRenderer extends VehicleRenderer<T80bvPixelEntity> {
    public T80bvPixelRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new T80bvPixelModel());
    }

    @Override
    public RenderType getRenderType(T80bvPixelEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
