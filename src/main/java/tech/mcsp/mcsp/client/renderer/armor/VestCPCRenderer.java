package tech.mcsp.mcsp.client.renderer.armor;

import software.bernie.geckolib.renderer.GeoArmorRenderer;
import tech.mcsp.mcsp.client.model.armor.VestCPCModel;
import tech.mcsp.mcsp.item.armor.VestCPCItem;

public class VestCPCRenderer extends GeoArmorRenderer<VestCPCItem> {
    public VestCPCRenderer() {
        super(new VestCPCModel());
        // Используются стандартные имена костей GeckoLib для корпуса: "armorBody", "armorLeftArm", "armorRightArm"
    }
}

