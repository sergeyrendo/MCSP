package tech.mcsp.mcsp.client.renderer.armor;

import tech.mcsp.mcsp.client.model.armor.HelmetTorHelmetModel;
import tech.mcsp.mcsp.item.armor.HelmetTorHelmetItem;

public class HelmetTorHelmetRenderer extends McspGeoArmorRenderer<HelmetTorHelmetItem> {
    public HelmetTorHelmetRenderer() {
        super(new HelmetTorHelmetModel());
        // кость головы: "armorHead"
    }
}

