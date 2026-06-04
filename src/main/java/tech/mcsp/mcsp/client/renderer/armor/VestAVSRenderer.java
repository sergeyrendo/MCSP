package tech.mcsp.mcsp.client.renderer.armor;

import tech.mcsp.mcsp.client.model.armor.VestAVSModel;
import tech.mcsp.mcsp.item.armor.VestAVSItem;

public class VestAVSRenderer extends McspGeoArmorRenderer<VestAVSItem> {
    public VestAVSRenderer() {
        super(new VestAVSModel());
    }
}
