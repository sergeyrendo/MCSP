package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.mcsp.mcsp.client.model.SprutCamoModel;
import tech.mcsp.mcsp.entity.SprutCamoEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class SprutCamoRenderer extends VehicleRenderer<SprutCamoEntity> {
    public SprutCamoRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SprutCamoModel());
    }

    @Override
    public RenderType getRenderType(SprutCamoEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
