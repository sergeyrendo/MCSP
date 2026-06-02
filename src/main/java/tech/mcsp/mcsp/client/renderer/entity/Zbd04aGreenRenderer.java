package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.mcsp.mcsp.client.model.Zbd04aGreenModel;
import tech.mcsp.mcsp.entity.Zbd04aGreenEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class Zbd04aGreenRenderer extends VehicleRenderer<Zbd04aGreenEntity> {
    public Zbd04aGreenRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new Zbd04aGreenModel());
    }

    @Override
    public RenderType getRenderType(Zbd04aGreenEntity animatable, ResourceLocation texture,
            MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
