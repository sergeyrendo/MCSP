package tech.mcsp.mcsp.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import tech.mcsp.mcsp.client.model.T80bvKantemirModel;
import tech.mcsp.mcsp.entity.T80bvKantemirEntity;

public class T80bvKantemirRenderer extends GeoEntityRenderer<T80bvKantemirEntity> {
    public T80bvKantemirRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new T80bvKantemirModel());
    }
}
