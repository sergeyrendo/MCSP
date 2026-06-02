package tech.mcsp.mcsp.client.renderer.armor;

import software.bernie.geckolib.renderer.GeoArmorRenderer;
import tech.mcsp.mcsp.client.model.armor.AirFrameHelmetModel;
import tech.mcsp.mcsp.item.armor.AirFrameHelmetItem;

public class AirFrameHelmetRenderer extends GeoArmorRenderer<AirFrameHelmetItem> {
    public AirFrameHelmetRenderer() {
        super(new AirFrameHelmetModel());
        // Используются стандартные имена костей GeckoLib: "armorHead", ...
    }
}

