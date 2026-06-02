package tech.mcsp.mcsp.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.mcsp.mcsp.client.model.Tos1aGreenModel;
import tech.mcsp.mcsp.entity.Tos1aGreenEntity;

public class Tos1aGreenRenderer extends Tos1aRenderer<Tos1aGreenEntity> {
    public Tos1aGreenRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new Tos1aGreenModel());
    }
}
