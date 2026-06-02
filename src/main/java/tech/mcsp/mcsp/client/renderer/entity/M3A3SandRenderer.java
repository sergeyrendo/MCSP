package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.mcsp.mcsp.client.model.M3A3SandModel;
import tech.mcsp.mcsp.entity.M3A3SandEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class M3A3SandRenderer extends VehicleRenderer<M3A3SandEntity> {
    public M3A3SandRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new M3A3SandModel());
    }

    @Override
    public RenderType getRenderType(M3A3SandEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));

    }
}
