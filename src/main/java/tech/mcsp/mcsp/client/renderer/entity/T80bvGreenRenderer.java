package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import tech.mcsp.mcsp.client.model.T80bvGreenModel;
import tech.mcsp.mcsp.entity.T80bvGreenEntity;

public class T80bvGreenRenderer extends VehicleRenderer<T80bvGreenEntity> {
    public T80bvGreenRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new T80bvGreenModel());
    }

    @Override
    public RenderType getRenderType(T80bvGreenEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
