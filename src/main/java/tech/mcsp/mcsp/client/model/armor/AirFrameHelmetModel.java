package tech.mcsp.mcsp.client.model.armor;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import tech.mcsp.mcsp.MCSP;
import tech.mcsp.mcsp.item.armor.AirFrameHelmetItem;

public class AirFrameHelmetModel extends GeoModel<AirFrameHelmetItem> {
    @Override
    public ResourceLocation getModelResource(AirFrameHelmetItem object) {
        // имя файла модели в нижнем регистре
        return new ResourceLocation(MCSP.MOD_ID, "geo/airframe_helmet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AirFrameHelmetItem object) {
        // текстура в assets/mcsp/textures/armor/texture_armour.png
        return new ResourceLocation(MCSP.MOD_ID, "textures/armor/texture_armour.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AirFrameHelmetItem animatable) {
        // без анимаций — можно вернуть несуществующий пустой файл или null; геометрия статична
        return null;
    }
}

