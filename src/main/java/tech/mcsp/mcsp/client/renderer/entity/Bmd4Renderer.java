package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.mcsp.mcsp.client.model.Bmd4Model;
import tech.mcsp.mcsp.entity.Bmd4Entity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class Bmd4Renderer extends VehicleRenderer<Bmd4Entity> {
    public Bmd4Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new Bmd4Model());
    }

    @Override
    public RenderType getRenderType(Bmd4Entity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
