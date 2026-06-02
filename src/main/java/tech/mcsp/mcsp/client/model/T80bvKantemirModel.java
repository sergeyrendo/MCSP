package tech.mcsp.mcsp.client.model;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import tech.mcsp.mcsp.MCSP;
import tech.mcsp.mcsp.entity.T80bvKantemirEntity;

public class T80bvKantemirModel extends GeoModel<T80bvKantemirEntity> {
    @Override
    public ResourceLocation getModelResource(T80bvKantemirEntity entity) {
        return new ResourceLocation(MCSP.MOD_ID, "geo/t80_bv.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T80bvKantemirEntity entity) {
        return new ResourceLocation(MCSP.MOD_ID, "textures/entity/t80_kantemir.png");
    }

    @Override
    public ResourceLocation getAnimationResource(T80bvKantemirEntity entity) {
        return new ResourceLocation(MCSP.MOD_ID, "animations/t80_bv.animation.json");
    }
}
