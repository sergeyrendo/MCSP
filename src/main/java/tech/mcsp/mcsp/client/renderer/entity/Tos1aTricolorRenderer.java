package tech.mcsp.mcsp.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.mcsp.mcsp.client.model.Tos1aTricolorModel;
import tech.mcsp.mcsp.entity.Tos1aTricolorEntity;

public class Tos1aTricolorRenderer extends Tos1aRenderer<Tos1aTricolorEntity> {
    public Tos1aTricolorRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new Tos1aTricolorModel());
    }
}
