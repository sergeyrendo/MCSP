package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.mcsp.mcsp.client.model.HumveeCarcModel;
import tech.mcsp.mcsp.entity.HumveeCarcEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class HumveeCarcRenderer extends VehicleRenderer<HumveeCarcEntity> {
    public HumveeCarcRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HumveeCarcModel());
    }

    @Override
    public RenderType getRenderType(HumveeCarcEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));

    }
}
