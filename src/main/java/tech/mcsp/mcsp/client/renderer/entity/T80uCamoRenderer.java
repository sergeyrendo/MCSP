package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import tech.mcsp.mcsp.client.model.T80uCamoModel;
import tech.mcsp.mcsp.entity.T80uCamoEntity;

public class T80uCamoRenderer extends VehicleRenderer<T80uCamoEntity> {
    public T80uCamoRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new T80uCamoModel());
    }

    @Override
    public RenderType getRenderType(T80uCamoEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
