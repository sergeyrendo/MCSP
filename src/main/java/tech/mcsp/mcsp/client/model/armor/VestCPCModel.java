package tech.mcsp.mcsp.client.model.armor;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import tech.mcsp.mcsp.MCSP;
import tech.mcsp.mcsp.item.armor.VestCPCItem;

public class VestCPCModel extends GeoModel<VestCPCItem> {
    @Override
    public ResourceLocation getModelResource(VestCPCItem object) {
        return ResourceLocation.fromNamespaceAndPath(MCSP.MOD_ID, "geo/vest_cpc.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VestCPCItem object) {
        return ResourceLocation.fromNamespaceAndPath(MCSP.MOD_ID, "textures/armor/texture_armour.png");
    }

    @Override
    public ResourceLocation getAnimationResource(VestCPCItem animatable) {
        return null;
    }
}

