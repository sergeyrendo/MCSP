package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.mcsp.mcsp.client.model.SprutModel;
import tech.mcsp.mcsp.entity.SprutEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class SprutRenderer extends VehicleRenderer<SprutEntity> {
    public SprutRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SprutModel());
    }

    @Override
    public RenderType getRenderType(SprutEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
