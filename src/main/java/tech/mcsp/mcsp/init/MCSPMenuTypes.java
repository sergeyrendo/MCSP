package tech.mcsp.mcsp.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredRegister;
import tech.mcsp.mcsp.MCSP;

public class MCSPMenuTypes {
    public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, MCSP.MOD_ID);
}
