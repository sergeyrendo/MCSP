package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import tech.mcsp.mcsp.client.model.UralTricolorModel;
import tech.mcsp.mcsp.entity.UralTricolorEntity;

public class UralTricolorRenderer extends VehicleRenderer<UralTricolorEntity> {
    public UralTricolorRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new UralTricolorModel());
    }

    @Override
    public RenderType getRenderType(UralTricolorEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
