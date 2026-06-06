package tech.mcsp.mcsp.client.renderer.armor;

import tech.mcsp.mcsp.client.model.armor.OpsCore2HelmetModel;
import tech.mcsp.mcsp.item.armor.OpsCore2HelmetItem;

public class OpsCore2HelmetRenderer extends McspGeoArmorRenderer<OpsCore2HelmetItem> {
    public OpsCore2HelmetRenderer() {
        super(new OpsCore2HelmetModel());
        // используем стандартную кость "armorHead"
    }
}

