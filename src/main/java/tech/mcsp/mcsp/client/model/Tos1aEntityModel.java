package tech.mcsp.mcsp.client.model;

import net.minecraft.resources.ResourceLocation;
import tech.mcsp.mcsp.entity.Tos1aEntity;

public class Tos1aEntityModel extends Tos1aModel<Tos1aEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("mcsp", "textures/entity/tos1a.png");

    @Override
    public ResourceLocation getTextureResource(Tos1aEntity vehicle) {
        return TEXTURE;
    }
}
