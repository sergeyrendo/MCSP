package tech.mcsp.mcsp.item;

import net.minecraft.world.item.Item;

/**
 * MLRS rocket item for TOS-1A loading system.
 */
public class MlrsRocketItem extends AmmoItem {

    public MlrsRocketItem() {
        super(new Item.Properties().stacksTo(8));
    }
}
