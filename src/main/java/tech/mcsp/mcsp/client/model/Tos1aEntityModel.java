package tech.mcsp.mcsp.client.model;

import net.minecraft.resources.ResourceLocation;
import tech.mcsp.mcsp.entity.Tos1aEntity;

public class Tos1aEntityModel extends Tos1aModel<Tos1aEntity> {
    private static final ResourceLocation MODEL = ResourceLocation.fromNamespaceAndPath("mcsp", "geo/tos-1a.geo.json");
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("mcsp", "textures/entity/tos1a.png");

    @Override
    public ResourceLocation getModelResource(Tos1aEntity vehicle) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(Tos1aEntity vehicle) {
        return TEXTURE;
    }
}
