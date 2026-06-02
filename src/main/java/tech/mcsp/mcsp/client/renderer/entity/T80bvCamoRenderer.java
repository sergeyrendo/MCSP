package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import tech.mcsp.mcsp.client.model.T80bvCamoModel;
import tech.mcsp.mcsp.entity.T80bvCamoEntity;

public class T80bvCamoRenderer extends VehicleRenderer<T80bvCamoEntity> {
    public T80bvCamoRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new T80bvCamoModel());
    }

    @Override
    public RenderType getRenderType(T80bvCamoEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
