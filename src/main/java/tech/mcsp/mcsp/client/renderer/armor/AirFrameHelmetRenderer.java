package tech.mcsp.mcsp.client.renderer.armor;

import tech.mcsp.mcsp.client.model.armor.AirFrameHelmetModel;
import tech.mcsp.mcsp.item.armor.AirFrameHelmetItem;

public class AirFrameHelmetRenderer extends McspGeoArmorRenderer<AirFrameHelmetItem> {
    public AirFrameHelmetRenderer() {
        super(new AirFrameHelmetModel());
        // Используются стандартные имена костей GeckoLib: "armorHead", ...
    }
}

