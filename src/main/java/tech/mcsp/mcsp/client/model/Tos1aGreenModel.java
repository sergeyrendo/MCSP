package tech.mcsp.mcsp.client.model;

import net.minecraft.resources.ResourceLocation;
import tech.mcsp.mcsp.entity.Tos1aGreenEntity;

public class Tos1aGreenModel extends Tos1aModel<Tos1aGreenEntity> {
    private static final ResourceLocation MODEL = new ResourceLocation("mcsp", "geo/tos-1a.geo.json");
    private static final ResourceLocation TEXTURE = new ResourceLocation("mcsp", "textures/entity/t90a.png");

    @Override
    public ResourceLocation getModelResource(Tos1aGreenEntity vehicle) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(Tos1aGreenEntity vehicle) {
        return TEXTURE;
    }
}
