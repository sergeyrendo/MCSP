package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import tech.mcsp.mcsp.client.model.Ztz99aSandModel;
import tech.mcsp.mcsp.entity.Ztz99aSandEntity;

public class Ztz99aSandRenderer extends VehicleRenderer<Ztz99aSandEntity> {
    public Ztz99aSandRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new Ztz99aSandModel());
    }

    @Override
    public RenderType getRenderType(Ztz99aSandEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
