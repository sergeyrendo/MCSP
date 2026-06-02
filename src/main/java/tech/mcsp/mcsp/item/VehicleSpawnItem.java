package tech.mcsp.mcsp.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.network.chat.Component;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;

public class VehicleSpawnItem<T extends Entity> extends Item {
    private final RegistryObject<EntityType<T>> entityTypeRegistryObject;

    public VehicleSpawnItem(RegistryObject<EntityType<T>> entityTypeRegistryObject, Properties properties) {
        super(properties);
        this.entityTypeRegistryObject = entityTypeRegistryObject;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        ItemStack itemstack = context.getItemInHand();
        BlockPos blockpos = context.getClickedPos();

        EntityType<T> entitytype = this.entityTypeRegistryObject.get();
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
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        
        // Получаем ключ локализации для описания
        String itemId = stack.getItem().getDescriptionId();
        // Убираем префикс "item." если он есть
        if (itemId.startsWith("item.")) {
            itemId = itemId.substring(5);
        }
        String descriptionKey = "des." + itemId;
        Component description = Component.translatable(descriptionKey);
        
        // Проверяем, есть ли перевод для этого ключа
        if (!description.getString().equals(descriptionKey)) {
            tooltip.add(Component.literal(description.getString()).withStyle(net.minecraft.ChatFormatting.GRAY));
        }
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack);
    }
} 