package tech.mcsp.mcsp;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import tech.mcsp.mcsp.init.ModEntities;
import tech.mcsp.mcsp.init.ModTabs;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import tech.mcsp.mcsp.init.ModItems;
import tech.mcsp.mcsp.init.ModVehicleItems;

@Mod(MCSP.MOD_ID)
public class MCSP {
    public static final String MOD_ID = "mcsp";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MCSP() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Регистрируем сущности до предметов, которые на них ссылаются
        ModEntities.REGISTRY.register(modEventBus);

        ModItems.register(modEventBus);
        tech.mcsp.mcsp.init.ModVehicleItems.register(modEventBus);
        ModTabs.TABS.register(modEventBus);
        tech.mcsp.mcsp.init.ModSounds.REGISTRY.register(modEventBus);
        tech.mcsp.mcsp.init.MCSPMenuTypes.REGISTRY.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(this::onItemTooltip);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", net.minecraft.world.level.block.Blocks.DIRT);
    }

    private void onItemTooltip(ItemTooltipEvent event) {
        if (event.getItemStack().getItem() instanceof BlockItem && event.getItemStack().hasTag()) {
            CompoundTag tag = BlockItem.getBlockEntityData(event.getItemStack());
            if (tag != null && tag.contains("EntityType")) {
                String entityType = tag.getString("EntityType");
                if (entityType.startsWith(MOD_ID + ":vdv_")) {
                    // event.getToolTip().add(Component.translatable("tooltip.mcsp.model_author"));
                    event.getToolTip().add(Component.translatable("tooltip.mcsp.usage_restriction").withStyle(net.minecraft.ChatFormatting.RED));
                }
            }
        }
    }
}
