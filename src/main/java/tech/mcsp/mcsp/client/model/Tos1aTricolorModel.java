package tech.mcsp.mcsp.client.model;

import net.minecraft.resources.ResourceLocation;
import tech.mcsp.mcsp.entity.Tos1aTricolorEntity;

public class Tos1aTricolorModel extends Tos1aModel<Tos1aTricolorEntity> {
    private static final ResourceLocation MODEL = ResourceLocation.fromNamespaceAndPath("mcsp", "geo/tos-1a.geo.json");
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("mcsp", "textures/entity/t90a_camo.png");

    @Override
    public ResourceLocation getModelResource(Tos1aTricolorEntity vehicle) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(Tos1aTricolorEntity vehicle) {
        return TEXTURE;
    }
}
