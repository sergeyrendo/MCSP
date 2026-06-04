package tech.mcsp.mcsp;

import com.mojang.logging.LogUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import org.slf4j.Logger;
import tech.mcsp.mcsp.config.MCSPConfig;
import tech.mcsp.mcsp.init.MCSPMenuTypes;
import tech.mcsp.mcsp.init.ModEntities;
import tech.mcsp.mcsp.init.ModItems;
import tech.mcsp.mcsp.init.ModSounds;
import tech.mcsp.mcsp.init.ModTabs;
import tech.mcsp.mcsp.init.ModVehicleItems;

@Mod(MCSP.MOD_ID)
public class MCSP {
    public static final String MOD_ID = "mcsp";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MCSP(IEventBus modEventBus, ModContainer modContainer) {
        ModEntities.REGISTRY.register(modEventBus);
        ModItems.register(modEventBus);
        ModVehicleItems.register(modEventBus);
        ModTabs.TABS.register(modEventBus);
        ModSounds.REGISTRY.register(modEventBus);
        MCSPMenuTypes.REGISTRY.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modContainer.registerConfig(ModConfig.Type.COMMON, MCSPConfig.COMMON_CONFIG);

        NeoForge.EVENT_BUS.addListener(this::onItemTooltip);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", net.minecraft.world.level.block.Blocks.DIRT);
    }

    private void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (!(stack.getItem() instanceof BlockItem)) {
            return;
        }
        var blockEntityData = stack.get(DataComponents.BLOCK_ENTITY_DATA);
        if (blockEntityData == null) {
            return;
        }
        CompoundTag tag = blockEntityData.copyTag();
        if (tag.contains("EntityType")) {
            String entityType = tag.getString("EntityType");
            if (entityType.startsWith(MOD_ID + ":vdv_")) {
                event.getToolTip().add(Component.translatable("tooltip.mcsp.usage_restriction").withStyle(ChatFormatting.RED));
            }
        }
    }
}
