package tech.mcsp.mcsp.client.renderer.armor;

import software.bernie.geckolib.renderer.GeoArmorRenderer;
import tech.mcsp.mcsp.client.model.armor.VestCPC2Model;
import tech.mcsp.mcsp.item.armor.VestCPC2Item;

public class VestCPC2Renderer extends GeoArmorRenderer<VestCPC2Item> {
    public VestCPC2Renderer() {
        super(new VestCPC2Model());
        // кости корпуса: "armorBody", "armorLeftArm", "armorRightArm"
    }
}

