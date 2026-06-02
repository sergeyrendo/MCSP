package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.mcsp.mcsp.client.model.M1A2SandModel;
import tech.mcsp.mcsp.entity.M1A2SandEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class M1A2SandRenderer extends VehicleRenderer<M1A2SandEntity> {
    public M1A2SandRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new M1A2SandModel());
    }

    @Override
    public RenderType getRenderType(M1A2SandEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
