package tech.mcsp.mcsp.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import tech.mcsp.mcsp.MCSP;
import tech.mcsp.mcsp.item.VehicleSpawnItem;
import tech.mcsp.mcsp.init.ModItems;
import tech.mcsp.mcsp.init.ModVehicleItems;

@SuppressWarnings("unused")
public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            MCSP.MOD_ID);

    /**
     * Adds an item to the creative tab output if it's not a hidden variant.
     * Items that are variants in a camo group are hidden from the creative tab
     * and only accessible through the CamoSelectorScreen popup.
     *
     * @param output The creative tab output
     * @param item   The item to potentially add
     */


    // Вкладка с транспортом MCSP
    public static final RegistryObject<CreativeModeTab> VEHICLES = TABS.register("mcsp_vehicle_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModVehicleItems.TYPHOON_TRICOLOR_30_SPAWN_ITEM.get())) // Используем один
                    // из предметов как
                    // иконку вкладки
                    .title(Component.translatable("item_group.mcsp.vehicles"))
                    .displayItems((parameters, output) -> {
                        // Ammo
                        output.accept(ModItems.BULLET_762.get());
                        output.accept(ModItems.AMMO_25MM_AP.get());
                        output.accept(ModItems.AMMO_30MM_AP.get());
                        output.accept(ModItems.AMMO_40MM_EXPLOSIVE.get());
                        output.accept(ModItems.AMMO_40MM_SMOKE.get());
                        output.accept(ModItems.AMMO_120MM_BULLETMORTAR.get());
                        output.accept(ModItems.AMMO_125MM_AP.get());
                        output.accept(ModItems.AMMO_125MM_HE.get());
                        output.accept(ModItems.TOW_2.get());
                        output.accept(ModItems.MLRS_SHELLS.get());
                        // Crafting Components
                        output.accept(ModItems.ARMOR_PLATE.get());
                        output.accept(ModItems.BASE_CARTRIDGE.get());
                        output.accept(ModItems.BLOWTORCH.get());
                        output.accept(ModItems.CIRCUIT.get());
                        output.accept(ModItems.COPPER_WIRE.get());
                        output.accept(ModItems.EXPLOSIVES.get());
                        output.accept(ModItems.FUZE_IMPACT.get());
                        output.accept(ModItems.FUZE_PROXY.get());
                        output.accept(ModItems.HEADLIGHT.get());
                        output.accept(ModItems.IR_SENSOR.get());
                        output.accept(ModItems.METAL_TUBE.get());
                        output.accept(ModItems.PLASTIC.get());
                        output.accept(ModItems.PLATING.get());
                        output.accept(ModItems.PROCESSOR.get());
                        output.accept(ModItems.REPAIR_KIT.get());
                        output.accept(ModItems.SMALL_ARMS_CARTRIDGE.get());
                        output.accept(ModItems.SPARK_PLUG.get());
                        output.accept(ModItems.SPRING.get());
                        // Vehicles
                        output.accept(ModVehicleItems.TYPHOON_TRICOLOR_30_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.TYPHOON_30_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.HUMVEE_STANDART_CAMO_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.HUMVEE_CARC_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.HUMVEE_SAND_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.HUMVEE_MK19_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.BMD_4_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.BMD_4_CAMO_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.SPRUT_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.SPRUT_CAMO_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.M3A3_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.M3A3_BUSK_II_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.M3A3_BUSK_III_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.M3A3_SAND_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.M3A3_BUSK_II_SAND_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.M3A3_BUSK_III_SAND_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.M1A2_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.M1A2_SEP_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.M1A2_SAND_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.M1A2_SEP_SAND_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.URAL_TRICOLOR_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.URAL_GREEN_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.TOS_1A_TRICOLOR_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.TOS_1A_GREEN_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.T90A_GREEN_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.T90A_TRICOLOR_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.ZTZ99A_SAND_SPAWN_ITEM.get());
                        // T-80U
                        output.accept(ModVehicleItems.T80U_CAMO_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.T80U_GREEN_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.T80U_PIXEL_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.T80U_KANTEMIR_SPAWN_ITEM.get());
                        // T-80BV
                        output.accept(ModVehicleItems.T80BV_CAMO_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.T80BV_GREEN_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.T80BV_PIXEL_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.T80BV_PIXEL_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.T80BV_KANTEMIR_SPAWN_ITEM.get());
                        // ZBD-04A
                        output.accept(ModVehicleItems.ZBD04A_SAND_SPAWN_ITEM.get());
                        output.accept(ModVehicleItems.ZBD04A_GREEN_SPAWN_ITEM.get());
                    })
                    .build());

    // Вкладка с броней MCSP
    public static final RegistryObject<CreativeModeTab> ARMOR = TABS.register("mcsp_armor_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.AIRFRAME_HELMET.get()))
                    .title(Component.translatable("item_group.mcsp.armor"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.AIRFRAME_HELMET.get());
                        output.accept(ModItems.VEST_CPC.get());
                        output.accept(ModItems.OPSCORE2_HELMET.get());
                        output.accept(ModItems.OPSCORE_HELMET.get());
                        output.accept(ModItems.VEST_AVS.get());
                        output.accept(ModItems.HELMET_TOR.get());
                        output.accept(ModItems.VEST_CPC2.get());
                    })
                    .build());

    /**
     * Event for adding items to creative tabs
     */
    @Mod.EventBusSubscriber(modid = MCSP.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration {
        @SubscribeEvent
        public static void register(BuildCreativeModeTabContentsEvent event) {
            // Этот метод больше не нужен для добавления предметов, так как они добавлены
            // через .displayItems()
        }
    }
}