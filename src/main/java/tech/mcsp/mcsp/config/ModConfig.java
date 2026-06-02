package tech.mcsp.mcsp.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.ModLoadingContext;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModConfig {
    public static final ForgeConfigSpec COMMON_CONFIG;
    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        COMMON_CONFIG = builder.build();
        ModLoadingContext.get().registerConfig(Type.COMMON, COMMON_CONFIG);
    }
} 