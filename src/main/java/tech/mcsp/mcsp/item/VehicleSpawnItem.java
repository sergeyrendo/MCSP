package tech.mcsp.mcsp.item;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VehicleSpawnItem<T extends Entity> extends Item {
    private final DeferredHolder<EntityType<?>, EntityType<T>> entityType;

    public VehicleSpawnItem(DeferredHolder<EntityType<?>, EntityType<T>> entityType, Properties properties) {
        super(properties);
        this.entityType = entityType;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        ItemStack itemstack = context.getItemInHand();
        BlockPos blockpos = context.getClickedPos();

        EntityType<T> entitytype = this.entityType.get();
        Entity vehicle = entitytype.create(level);
        if (vehicle != null) {
            Vec3 spawnPos = Vec3.atBottomCenterOf(blockpos).add(0, 1.0, 0);
            vehicle.setPos(spawnPos);
            level.addFreshEntity(vehicle);

            if (!context.getPlayer().getAbilities().instabuild) {
                itemstack.shrink(1);
            }
            level.gameEvent(context.getPlayer(), GameEvent.ENTITY_PLACE, blockpos);
            return InteractionResult.CONSUME;
        }

        return InteractionResult.FAIL;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltip, flag);

        String itemId = stack.getItem().getDescriptionId();
        if (itemId.startsWith("item.")) {
            itemId = itemId.substring(5);
        }
        String descriptionKey = "des." + itemId;
        Component description = Component.translatable(descriptionKey);

        if (!description.getString().equals(descriptionKey)) {
            tooltip.add(Component.literal(description.getString()).withStyle(net.minecraft.ChatFormatting.GRAY));
        }
    }
}
