package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.mcsp.mcsp.client.model.TyphoonTricolor30Model;
import tech.mcsp.mcsp.entity.TyphoonTricolor30Entity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class TyphoonTricolor30Renderer extends VehicleRenderer<TyphoonTricolor30Entity> {
    public TyphoonTricolor30Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TyphoonTricolor30Model());
    }

    @Override
    public RenderType getRenderType(TyphoonTricolor30Entity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}

