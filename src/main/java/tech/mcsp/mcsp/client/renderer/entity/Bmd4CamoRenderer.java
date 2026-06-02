package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.mcsp.mcsp.client.model.Bmd4CamoModel;
import tech.mcsp.mcsp.entity.Bmd4CamoEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class Bmd4CamoRenderer extends VehicleRenderer<Bmd4CamoEntity> {
    public Bmd4CamoRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new Bmd4CamoModel());
    }

    @Override
    public RenderType getRenderType(Bmd4CamoEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
