package tech.mcsp.mcsp.client.model.armor;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import tech.mcsp.mcsp.MCSP;
import tech.mcsp.mcsp.item.armor.OpsCoreHelmetItem;

public class OpsCoreHelmetModel extends GeoModel<OpsCoreHelmetItem> {
    @Override
    public ResourceLocation getModelResource(OpsCoreHelmetItem object) {
        return ResourceLocation.fromNamespaceAndPath(MCSP.MOD_ID, "geo/opscore_helmet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OpsCoreHelmetItem object) {
        return ResourceLocation.fromNamespaceAndPath(MCSP.MOD_ID, "textures/armor/texture_armour.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OpsCoreHelmetItem animatable) {
        return null;
    }
}

