package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.mcsp.mcsp.client.model.M3A3Model;
import tech.mcsp.mcsp.entity.M3A3Entity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class M3A3Renderer extends VehicleRenderer<M3A3Entity> {
    public M3A3Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new M3A3Model());
    }

    @Override
    public RenderType getRenderType(M3A3Entity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));

    }
}
