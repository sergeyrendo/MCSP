package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import tech.mcsp.mcsp.client.model.UralGreenModel;
import tech.mcsp.mcsp.entity.UralGreenEntity;

public class UralGreenRenderer extends VehicleRenderer<UralGreenEntity> {
    public UralGreenRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new UralGreenModel());
    }

    @Override
    public RenderType getRenderType(UralGreenEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
