package tech.mcsp.mcsp.client.renderer.armor;

import software.bernie.geckolib.renderer.GeoArmorRenderer;
import tech.mcsp.mcsp.client.model.armor.VestAVSModel;
import tech.mcsp.mcsp.item.armor.VestAVSItem;

public class VestAVSRenderer extends GeoArmorRenderer<VestAVSItem> {
    public VestAVSRenderer() {
        super(new VestAVSModel());
        // кости корпуса: "armorBody", "armorLeftArm", "armorRightArm"
    }
}

