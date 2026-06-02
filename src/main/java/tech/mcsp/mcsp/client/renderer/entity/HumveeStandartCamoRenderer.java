package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.mcsp.mcsp.client.model.HumveeStandartCamoModel;
import tech.mcsp.mcsp.entity.HumveeStandartCamoEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class HumveeStandartCamoRenderer extends VehicleRenderer<HumveeStandartCamoEntity> {
    public HumveeStandartCamoRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HumveeStandartCamoModel());
    }

    @Override
    public RenderType getRenderType(HumveeStandartCamoEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));

    }
}
