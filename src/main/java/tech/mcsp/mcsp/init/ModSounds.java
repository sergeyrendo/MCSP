package tech.mcsp.mcsp.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.mcsp.mcsp.MCSP;

/**
 * Класс для регистрации звуков, используемых в моде
 */
public class ModSounds {
    // Создаем регистр для звуков
    public static final DeferredRegister<SoundEvent> REGISTRY = 
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MCSP.MOD_ID);
    
    // Звуки для YX-100 CAD System
    public static final RegistryObject<SoundEvent> YX_100_FIRE_1P = register("yx_100_fire_1p");
    public static final RegistryObject<SoundEvent> YX_100_FIRE_3P = register("yx_100_fire_3p");
    public static final RegistryObject<SoundEvent> YX_100_FAR = register("yx_100_far");
    public static final RegistryObject<SoundEvent> YX_100_VERY_FAR = register("yx_100_veryfar");
    public static final RegistryObject<SoundEvent> YX_100_RELOAD = register("yx_100_reload");
    
    // Звуки для Тайфунов ВДВ
    public static final RegistryObject<SoundEvent> TAIFUN_ENGINE = register("taifun_engine");

    // Звуки для 30мм пушки ВДВ
    public static final RegistryObject<SoundEvent> VDV_CANNON_FIRE = register("vdv_cannon_fire");
    public static final RegistryObject<SoundEvent> VDV_CANNON_FIRE_1P = register("vdv_cannon_fire_1p");
    public static final RegistryObject<SoundEvent> VDV_CANNON_FIRE_3P = register("vdv_cannon_fire_3p");
    public static final RegistryObject<SoundEvent> VDV_CANNON_FIRE_FAR = register("vdv_cannon_fire_far");
    public static final RegistryObject<SoundEvent> VDV_CANNON_FIRE_VERYFAR = register("vdv_cannon_fire_veryfar");
    
    // Звук для выскакивания дыма
    public static final RegistryObject<SoundEvent> SMOKE_FIRE = register("smoke_fire");

    // Звуки для БМД-4
    public static final RegistryObject<SoundEvent> M1128_RELOAD = register("m1128_reload");
    public static final RegistryObject<SoundEvent> M1128_3P = register("m1128_3p");
    public static final RegistryObject<SoundEvent> M1128_FAR = register("m1128_far");
    public static final RegistryObject<SoundEvent> M1128_VERYFAR = register("m1128_veryfar");
    // Звуки для зума
    public static final RegistryObject<SoundEvent> SPRUTFIRE_FAR = register("sprutfire_far");
    public static final RegistryObject<SoundEvent> SPRUTFIRE_3P = register("sprutfire_3p");

    // Bradley (M3A3) specific sounds
    public static final RegistryObject<SoundEvent> BRADLEY_ENGINE = register("bradley_engine");
    public static final RegistryObject<SoundEvent> M242_FIRE_1P = register("m242_fire_1p");
    public static final RegistryObject<SoundEvent> M242_FIRE_3P = register("m242_fire_3p");
    public static final RegistryObject<SoundEvent> M242_FIRE_FAR = register("m242_fire_far");
    public static final RegistryObject<SoundEvent> BRADLEY_TURRET_RELOAD = register("bradley_turret_reload");
    
    /**
     * Вспомогательный метод для регистрации звуков
     * @param name Название звука (без пространства имен)
     * @return RegistryObject для звукового события
     */
    private static RegistryObject<SoundEvent> register(String name) {
        return REGISTRY.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MCSP.MOD_ID, name)));
    }
} 