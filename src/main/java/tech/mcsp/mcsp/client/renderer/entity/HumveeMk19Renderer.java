package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.mcsp.mcsp.client.model.HumveeMk19Model;
import tech.mcsp.mcsp.entity.HumveeMk19Entity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class HumveeMk19Renderer extends VehicleRenderer<HumveeMk19Entity> {
    public HumveeMk19Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HumveeMk19Model());
    }

    @Override
    public RenderType getRenderType(HumveeMk19Entity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
