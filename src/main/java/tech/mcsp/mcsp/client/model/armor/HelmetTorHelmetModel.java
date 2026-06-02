package tech.mcsp.mcsp.client.model.armor;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import tech.mcsp.mcsp.MCSP;
import tech.mcsp.mcsp.item.armor.HelmetTorHelmetItem;

public class HelmetTorHelmetModel extends GeoModel<HelmetTorHelmetItem> {
    @Override
    public ResourceLocation getModelResource(HelmetTorHelmetItem object) {
        return new ResourceLocation(MCSP.MOD_ID, "geo/helmettor_helmet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HelmetTorHelmetItem object) {
        return new ResourceLocation(MCSP.MOD_ID, "textures/armor/texture_armour.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HelmetTorHelmetItem animatable) {
        return null;
    }
}

