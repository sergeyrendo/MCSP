package tech.mcsp.mcsp.init;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.bus.api.IEventBus;
import tech.mcsp.mcsp.MCSP;
import tech.mcsp.mcsp.item.armor.AirFrameHelmetItem;
import tech.mcsp.mcsp.item.armor.VestCPCItem;
import tech.mcsp.mcsp.item.armor.OpsCore2HelmetItem;
import tech.mcsp.mcsp.item.armor.OpsCoreHelmetItem;
import tech.mcsp.mcsp.item.armor.VestAVSItem;
import tech.mcsp.mcsp.item.armor.VestCPC2Item;
import tech.mcsp.mcsp.item.armor.HelmetTorHelmetItem;
import tech.mcsp.mcsp.item.AmmoItem;
import tech.mcsp.mcsp.item.CraftingItem;
import tech.mcsp.mcsp.item.MlrsRocketItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(MCSP.MOD_ID);

    // Armor
    public static final DeferredHolder<Item, ? extends Item> AIRFRAME_HELMET = ITEMS.register("airframe_helmet", () -> (Item) new AirFrameHelmetItem(new Item.Properties()));
    public static final DeferredHolder<Item, ? extends Item> VEST_CPC = ITEMS.register("vest_cpc", () -> (Item) new VestCPCItem(new Item.Properties()));
    public static final DeferredHolder<Item, ? extends Item> OPSCORE2_HELMET = ITEMS.register("opscore2_helmet", () -> (Item) new OpsCore2HelmetItem(new Item.Properties()));
    public static final DeferredHolder<Item, ? extends Item> OPSCORE_HELMET = ITEMS.register("opscore_helmet", () -> (Item) new OpsCoreHelmetItem(new Item.Properties()));
    public static final DeferredHolder<Item, ? extends Item> VEST_AVS = ITEMS.register("vest_avs", () -> (Item) new VestAVSItem(new Item.Properties()));
    public static final DeferredHolder<Item, ? extends Item> HELMET_TOR = ITEMS.register("helmettor_helmet", () -> (Item) new HelmetTorHelmetItem(new Item.Properties()));
    public static final DeferredHolder<Item, ? extends Item> VEST_CPC2 = ITEMS.register("vest_cpc2", () -> (Item) new VestCPC2Item(new Item.Properties()));

    // Ammo
    public static final DeferredHolder<Item, ? extends Item> AMMO_25MM_AP = ITEMS.register("25mm_ap", () -> new AmmoItem(new Item.Properties().stacksTo(16)));
    public static final DeferredHolder<Item, ? extends Item> AMMO_30MM_AP = ITEMS.register("30mm_ap", () -> new AmmoItem(new Item.Properties().stacksTo(16)));
    public static final DeferredHolder<Item, ? extends Item> AMMO_40MM_EXPLOSIVE = ITEMS.register("40mm_explosive", () -> new AmmoItem(new Item.Properties().stacksTo(16)));
    public static final DeferredHolder<Item, ? extends Item> AMMO_40MM_SMOKE = ITEMS.register("40mm_smoke", () -> new AmmoItem(new Item.Properties().stacksTo(16)));
    public static final DeferredHolder<Item, ? extends Item> AMMO_120MM_BULLETMORTAR = ITEMS.register("120mm_bulletmortar", () -> new AmmoItem(new Item.Properties().stacksTo(16)));
    public static final DeferredHolder<Item, ? extends Item> AMMO_125MM_AP = ITEMS.register("125mm_ap", () -> new AmmoItem(new Item.Properties().stacksTo(16)));
    public static final DeferredHolder<Item, ? extends Item> AMMO_125MM_HE = ITEMS.register("125mm_he", () -> new AmmoItem(new Item.Properties().stacksTo(16)));
    public static final DeferredHolder<Item, ? extends Item> BULLET_762 = ITEMS.register("bullet762", () -> new AmmoItem(new Item.Properties().stacksTo(64)));
    public static final DeferredHolder<Item, ? extends Item> TOW_2 = ITEMS.register("tow_2", () -> new AmmoItem(new Item.Properties().stacksTo(8)));
    public static final DeferredHolder<Item, ? extends Item> MLRS_SHELLS = ITEMS.register("mlrs_shells", MlrsRocketItem::new);

    // Crafting Components
//    public static final DeferredHolder<Item, ? extends Item> ARMOR_PLATE = ITEMS.register("armorplate", () -> new CraftingItem(new Item.Properties().stacksTo(64)));
//    public static final DeferredHolder<Item, ? extends Item> BASE_CARTRIDGE = ITEMS.register("basecartridge", () -> new CraftingItem(new Item.Properties().stacksTo(64)));
//    public static final DeferredHolder<Item, ? extends Item> BLOWTORCH = ITEMS.register("blowtorch", () -> new CraftingItem(new Item.Properties().stacksTo(16)));
//    public static final DeferredHolder<Item, ? extends Item> CIRCUIT = ITEMS.register("circuit", () -> new CraftingItem(new Item.Properties().stacksTo(64)));
//    public static final DeferredHolder<Item, ? extends Item> COPPER_WIRE = ITEMS.register("copperwire", () -> new CraftingItem(new Item.Properties().stacksTo(64)));
//    public static final DeferredHolder<Item, ? extends Item> EXPLOSIVES = ITEMS.register("explosives", () -> new CraftingItem(new Item.Properties().stacksTo(64)));
//    public static final DeferredHolder<Item, ? extends Item> FUZE_IMPACT = ITEMS.register("fuzeimpact", () -> new CraftingItem(new Item.Properties().stacksTo(64)));
//    public static final DeferredHolder<Item, ? extends Item> FUZE_PROXY = ITEMS.register("fuzeproxy", () -> new CraftingItem(new Item.Properties().stacksTo(64)));
//    public static final DeferredHolder<Item, ? extends Item> HEADLIGHT = ITEMS.register("headlight", () -> new CraftingItem(new Item.Properties().stacksTo(64)));
//    public static final DeferredHolder<Item, ? extends Item> IR_SENSOR = ITEMS.register("irsensor", () -> new CraftingItem(new Item.Properties().stacksTo(64)));
//    public static final DeferredHolder<Item, ? extends Item> METAL_TUBE = ITEMS.register("metaltube", () -> new CraftingItem(new Item.Properties().stacksTo(64)));
//    public static final DeferredHolder<Item, ? extends Item> PLASTIC = ITEMS.register("plastic", () -> new CraftingItem(new Item.Properties().stacksTo(64)));
//    public static final DeferredHolder<Item, ? extends Item> PLATING = ITEMS.register("plating", () -> new CraftingItem(new Item.Properties().stacksTo(64)));
//    public static final DeferredHolder<Item, ? extends Item> PROCESSOR = ITEMS.register("processor", () -> new CraftingItem(new Item.Properties().stacksTo(64)));
//    public static final DeferredHolder<Item, ? extends Item> REPAIR_KIT = ITEMS.register("repairkit", () -> new CraftingItem(new Item.Properties().stacksTo(16)));
//    public static final DeferredHolder<Item, ? extends Item> SMALL_ARMS_CARTRIDGE = ITEMS.register("smallarmscartridge", () -> new CraftingItem(new Item.Properties().stacksTo(64)));
//    public static final DeferredHolder<Item, ? extends Item> SPARK_PLUG = ITEMS.register("sparkplug", () -> new CraftingItem(new Item.Properties().stacksTo(64)));
//    public static final DeferredHolder<Item, ? extends Item> SPRING = ITEMS.register("spring", () -> new CraftingItem(new Item.Properties().stacksTo(64)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}