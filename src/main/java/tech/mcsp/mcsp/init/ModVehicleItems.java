package tech.mcsp.mcsp.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import tech.mcsp.mcsp.MCSP;
import tech.mcsp.mcsp.item.VehicleSpawnItem;

public class ModVehicleItems {
    public static final DeferredRegister<Item> VEHICLE_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            MCSP.MOD_ID);

    public static final RegistryObject<Item> TYPHOON_TRICOLOR_30_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "typhoon_tricolor_30_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.TYPHOON_TRICOLOR_30,
                    new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> TYPHOON_30_SPAWN_ITEM = VEHICLE_ITEMS.register("typhoon_30_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.TYPHOON_30, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HUMVEE_STANDART_CAMO_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "humvee_standart_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.HUMVEE_STANDART_CAMO,
                    new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HUMVEE_CARC_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "humvee_carc_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.HUMVEE_CARC, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HUMVEE_SAND_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "humvee_sand_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.HUMVEE_SAND, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HUMVEE_MK19_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "humvee_mk19_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.HUMVEE_MK19, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> BMD_4_SPAWN_ITEM = VEHICLE_ITEMS.register("bmd_4_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.BMD_4, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BMD_4_CAMO_SPAWN_ITEM = VEHICLE_ITEMS.register("bmd_4_camo_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.BMD_4_CAMO, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SPRUT_SPAWN_ITEM = VEHICLE_ITEMS.register("sprut_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.SPRUT, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SPRUT_CAMO_SPAWN_ITEM = VEHICLE_ITEMS.register("sprut_camo_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.SPRUT_CAMO, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> M3A3_SPAWN_ITEM = VEHICLE_ITEMS.register("m3a3_bradley_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.M3A3_BRADLEY, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> M3A3_SAND_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "m3a3_bradley_sand_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.M3A3_BRADLEY_SAND, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> M3A3_BUSK_II_SAND_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "m3a3_bradley_busk_ii_sand_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.M3A3_BRADLEY_BUSK_II_SAND,
                    new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> M3A3_BUSK_III_SAND_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "m3a3_bradley_busk_iii_sand_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.M3A3_BRADLEY_BUSK_III_SAND,
                    new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> M3A3_BUSK_II_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "m3a3_bradley_busk_ii_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.M3A3_BRADLEY_BUSK_II,
                    new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> M3A3_BUSK_III_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "m3a3_bradley_busk_iii_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.M3A3_BRADLEY_BUSK_III,
                    new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> M1A2_SPAWN_ITEM = VEHICLE_ITEMS.register("m1a2_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.M1A2, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> M1A2_SEP_SPAWN_ITEM = VEHICLE_ITEMS.register("m1a2_sep_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.M1A2_SEP, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> M1A2_SAND_SPAWN_ITEM = VEHICLE_ITEMS.register("m1a2_sand_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.M1A2_SAND, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> M1A2_SEP_SAND_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "m1a2_sep_sand_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.M1A2_SEP_SAND, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> URAL_TRICOLOR_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "ural_tricolor_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.URAL_TRICOLOR, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> URAL_GREEN_SPAWN_ITEM = VEHICLE_ITEMS.register("ural_green_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.URAL_GREEN, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> TOS_1A_TRICOLOR_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "tos_1a_tricolor_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.TOS_1A_TRICOLOR, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> TOS_1A_GREEN_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "tos_1a_green_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.TOS_1A_GREEN, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> T90A_GREEN_SPAWN_ITEM = VEHICLE_ITEMS.register("t90a_green_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.T90A_GREEN, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> T90A_TRICOLOR_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "t90a_tricolor_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.T90A_TRICOLOR, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> ZTZ99A_SAND_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "ztz99a_sand_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.ZTZ99A_SAND, new Item.Properties().stacksTo(1)));

    // T-80U spawn items
    public static final RegistryObject<Item> T80U_GREEN_SPAWN_ITEM = VEHICLE_ITEMS.register("t80u_green_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.T80U_GREEN, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> T80U_CAMO_SPAWN_ITEM = VEHICLE_ITEMS.register("t80u_camo_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.T80U_CAMO, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> T80U_PIXEL_SPAWN_ITEM = VEHICLE_ITEMS.register("t80u_pixel_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.T80U_PIXEL, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> T80U_KANTEMIR_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "t80u_kantemir_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.T80U_KANTEMIR, new Item.Properties().stacksTo(1)));

    // T-80BV spawn items
    public static final RegistryObject<Item> T80BV_GREEN_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "t80bv_green_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.T80BV_GREEN, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> T80BV_CAMO_SPAWN_ITEM = VEHICLE_ITEMS.register("t80bv_camo_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.T80BV_CAMO, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> T80BV_PIXEL_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "t80bv_pixel_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.T80BV_PIXEL, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> T80BV_KANTEMIR_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "t80bv_kantemir_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.T80BV_KANTEMIR, new Item.Properties().stacksTo(1)));

    // ZBD-04A spawn items
    public static final RegistryObject<Item> ZBD04A_SAND_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "zbd04a_sand_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.ZBD04A_SAND, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ZBD04A_GREEN_SPAWN_ITEM = VEHICLE_ITEMS.register(
            "zbd04a_green_spawn_item",
            () -> new VehicleSpawnItem<>(ModEntities.ZBD04A_GREEN, new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        VEHICLE_ITEMS.register(eventBus);
    }
}