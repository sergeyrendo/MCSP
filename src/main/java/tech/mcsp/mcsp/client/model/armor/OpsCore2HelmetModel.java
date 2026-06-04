package tech.mcsp.mcsp.client.model.armor;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import tech.mcsp.mcsp.MCSP;
import tech.mcsp.mcsp.item.armor.OpsCore2HelmetItem;

public class OpsCore2HelmetModel extends GeoModel<OpsCore2HelmetItem> {
    @Override
    public ResourceLocation getModelResource(OpsCore2HelmetItem object) {
        return ResourceLocation.fromNamespaceAndPath(MCSP.MOD_ID, "geo/opscore2_helmet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OpsCore2HelmetItem object) {
        return ResourceLocation.fromNamespaceAndPath(MCSP.MOD_ID, "textures/armor/texture_armour.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OpsCore2HelmetItem animatable) {
        return null;
    }
}

