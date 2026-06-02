package tech.mcsp.mcsp.client.renderer.entity;

import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import tech.mcsp.mcsp.client.model.T80uKantemirModel;
import tech.mcsp.mcsp.entity.T80uKantemirEntity;

public class T80uKantemirRenderer extends VehicleRenderer<T80uKantemirEntity> {
    public T80uKantemirRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new T80uKantemirModel());
    }

    @Override
    public RenderType getRenderType(T80uKantemirEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutout(getTextureLocation(animatable));
    }
}
