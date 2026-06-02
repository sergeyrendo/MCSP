package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.mcsp.mcsp.client.model.HumveeSandModel;
import tech.mcsp.mcsp.entity.HumveeSandEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class HumveeSandRenderer extends VehicleRenderer<HumveeSandEntity> {
    public HumveeSandRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HumveeSandModel());
    }
    @Override
    public RenderType getRenderType(HumveeSandEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));

    }
}
