package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import tech.mcsp.mcsp.client.model.T90aGreenModel;
import tech.mcsp.mcsp.entity.T90aGreenEntity;

public class T90aGreenRenderer extends VehicleRenderer<T90aGreenEntity> {
    public T90aGreenRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new T90aGreenModel());
    }

    @Override
    public RenderType getRenderType(T90aGreenEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
