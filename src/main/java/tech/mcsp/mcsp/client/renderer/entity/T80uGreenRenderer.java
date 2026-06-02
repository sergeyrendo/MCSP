package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import tech.mcsp.mcsp.client.model.T80uGreenModel;
import tech.mcsp.mcsp.entity.T80uGreenEntity;

public class T80uGreenRenderer extends VehicleRenderer<T80uGreenEntity> {
    public T80uGreenRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new T80uGreenModel());
    }

    @Override
    public RenderType getRenderType(T80uGreenEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
