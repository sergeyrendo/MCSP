package tech.mcsp.mcsp.client.renderer.armor;

import tech.mcsp.mcsp.client.model.armor.OpsCoreHelmetModel;
import tech.mcsp.mcsp.item.armor.OpsCoreHelmetItem;

public class OpsCoreHelmetRenderer extends McspGeoArmorRenderer<OpsCoreHelmetItem> {
    public OpsCoreHelmetRenderer() {
        super(new OpsCoreHelmetModel());
        // стандартная кость головы: "armorHead"
    }
}

