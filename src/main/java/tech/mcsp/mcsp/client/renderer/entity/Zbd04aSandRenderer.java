package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.mcsp.mcsp.client.model.Zbd04aSandModel;
import tech.mcsp.mcsp.entity.Zbd04aSandEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class Zbd04aSandRenderer extends VehicleRenderer<Zbd04aSandEntity> {
    public Zbd04aSandRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new Zbd04aSandModel());
    }

    @Override
    public RenderType getRenderType(Zbd04aSandEntity animatable, ResourceLocation texture,
            MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
