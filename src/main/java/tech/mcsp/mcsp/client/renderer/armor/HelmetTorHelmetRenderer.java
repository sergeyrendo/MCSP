package tech.mcsp.mcsp.client.renderer.armor;

import software.bernie.geckolib.renderer.GeoArmorRenderer;
import tech.mcsp.mcsp.client.model.armor.HelmetTorHelmetModel;
import tech.mcsp.mcsp.item.armor.HelmetTorHelmetItem;

public class HelmetTorHelmetRenderer extends GeoArmorRenderer<HelmetTorHelmetItem> {
    public HelmetTorHelmetRenderer() {
        super(new HelmetTorHelmetModel());
        // кость головы: "armorHead"
    }
}

