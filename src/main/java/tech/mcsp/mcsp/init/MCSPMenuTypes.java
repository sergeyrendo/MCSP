package tech.mcsp.mcsp.init;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.mcsp.mcsp.MCSP;
import tech.mcsp.mcsp.menu.Tos1aMenu;

public class MCSPMenuTypes {
    public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MCSP.MOD_ID);

    public static final RegistryObject<MenuType<Tos1aMenu>> TOS1A_MENU = REGISTRY.register("tos1a_menu",
            () -> IForgeMenuType.create((windowId, inv, data) -> Tos1aMenu.create(windowId, inv)));
}
