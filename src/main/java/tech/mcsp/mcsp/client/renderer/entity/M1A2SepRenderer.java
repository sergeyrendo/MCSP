package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.mcsp.mcsp.client.model.M1A2SepModel;
import tech.mcsp.mcsp.entity.M1A2SepEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class M1A2SepRenderer extends VehicleRenderer<M1A2SepEntity> {
    public M1A2SepRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new M1A2SepModel());
    }

    @Override
    public RenderType getRenderType(M1A2SepEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
