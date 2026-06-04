package tech.mcsp.mcsp.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class AmmoItem extends Item {
    public AmmoItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltip, flag);
        String itemId = stack.getItem().getDescriptionId();
        if (itemId.startsWith("item.")) {
            itemId = itemId.substring(5);
        }
        String descriptionKey = "des." + itemId;
        Component description = Component.translatable(descriptionKey);
        if (!description.getString().equals(descriptionKey) && !description.getString().isEmpty()) {
            String fullText = description.getString();
            if (Screen.hasShiftDown()) {
                tooltip.add(Component.literal(fullText).withStyle(ChatFormatting.GRAY));
            } else {
                String preview = fullText.length() > 15 ? fullText.substring(0, 15) + "..." : fullText;
                tooltip.add(Component.literal(preview).withStyle(ChatFormatting.GRAY));
                tooltip.add(Component.translatable("tooltip.mcsp.hold_shift").withStyle(ChatFormatting.DARK_GRAY));
            }
        }
    }
}
