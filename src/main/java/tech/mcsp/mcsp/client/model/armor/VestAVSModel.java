package tech.mcsp.mcsp.client.model.armor;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import tech.mcsp.mcsp.MCSP;
import tech.mcsp.mcsp.item.armor.VestAVSItem;

public class VestAVSModel extends GeoModel<VestAVSItem> {
    @Override
    public ResourceLocation getModelResource(VestAVSItem object) {
        return new ResourceLocation(MCSP.MOD_ID, "geo/vest_avs.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VestAVSItem object) {
        return new ResourceLocation(MCSP.MOD_ID, "textures/armor/texture_armour.png");
    }

    @Override
    public ResourceLocation getAnimationResource(VestAVSItem animatable) {
        return null;
    }
}

