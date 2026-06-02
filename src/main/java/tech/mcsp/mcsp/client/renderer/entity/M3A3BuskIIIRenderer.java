package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.mcsp.mcsp.client.model.M3A3BuskIIIModel;
import tech.mcsp.mcsp.entity.M3A3BuskIIIEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;


public class M3A3BuskIIIRenderer extends VehicleRenderer<M3A3BuskIIIEntity> {
    public M3A3BuskIIIRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new M3A3BuskIIIModel());
    }

    @Override
    public RenderType getRenderType(M3A3BuskIIIEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));

    }
}
