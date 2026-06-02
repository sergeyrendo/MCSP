package tech.mcsp.mcsp.menu;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import org.jetbrains.annotations.NotNull;
import tech.mcsp.mcsp.init.MCSPMenuTypes;

public class Tos1aMenu extends AbstractContainerMenu {

    private final Container container;

    public static Tos1aMenu create(int containerId, Inventory playerInventory) {
        return new Tos1aMenu(MCSPMenuTypes.TOS1A_MENU.get(), containerId, playerInventory,
                new net.minecraft.world.SimpleContainer(9));
    }

    public Tos1aMenu(MenuType<?> type, int containerId, Inventory playerInventory, Container container) {
        super(type, containerId);
        checkContainerSize(container, 9);
        this.container = container;
        container.startOpen(playerInventory.player);

        // Vehicle battery slots (1 row of 9) - y=18 matches generic_54 first row
        for (int i = 0; i < 9; i++) {
            this.addSlot(new BatterySlot(container, i, 8 + i * 18, 18));
        }

        // Player inventory (3 rows) - y=50 (35 top + 15 gap)
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 50 + row * 18));
            }
        }

        // Player hotbar - y=108
        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 108));
        }
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        ItemStack result = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack stack = slot.getItem();
            result = stack.copy();

            if (index < 9) {
                // From vehicle to player
                if (!this.moveItemStackTo(stack, 9, 45, true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                // From player to vehicle (only batteries)
                if (stack.getCapability(ForgeCapabilities.ENERGY).isPresent()) {
                    if (!this.moveItemStackTo(stack, 0, 9, false)) {
                        return ItemStack.EMPTY;
                    }
                } else {
                    return ItemStack.EMPTY;
                }
            }

            if (stack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return result;
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return container.stillValid(player);
    }

    @Override
    public void removed(@NotNull Player player) {
        super.removed(player);
        container.stopOpen(player);
    }

    private static class BatterySlot extends Slot {
        public BatterySlot(Container container, int slot, int x, int y) {
            super(container, slot, x, y);
        }

        @Override
        public boolean mayPlace(@NotNull ItemStack stack) {
            return stack.getCapability(ForgeCapabilities.ENERGY).isPresent();
        }
    }
}