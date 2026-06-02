package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.mcsp.mcsp.client.model.Tos1aEntityModel;
import tech.mcsp.mcsp.client.model.Tos1aModel;
import tech.mcsp.mcsp.entity.Tos1aEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class Tos1aRenderer<T extends Tos1aEntity> extends VehicleRenderer<T> {
    public Tos1aRenderer(EntityRendererProvider.Context renderManager, GeoModel<T> model) {
        super(renderManager, model);
    }

    @SuppressWarnings("unchecked")
    public Tos1aRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, (GeoModel<T>) new Tos1aEntityModel());
    }

    @Override
    public RenderType getRenderType(T animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
