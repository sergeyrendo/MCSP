package tech.mcsp.mcsp.init;

import com.atsuishio.superbwarfare.entity.projectile.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tech.mcsp.mcsp.MCSP;
import tech.mcsp.mcsp.entity.*;
import tech.mcsp.mcsp.entity.Tos1aTricolorEntity;
import tech.mcsp.mcsp.entity.Tos1aGreenEntity;
import tech.mcsp.mcsp.entity.T90aGreenEntity;
import tech.mcsp.mcsp.entity.T90aTricolorEntity;
import tech.mcsp.mcsp.entity.Ztz99aSandEntity;
import tech.mcsp.mcsp.entity.T80uGreenEntity;
import tech.mcsp.mcsp.entity.T80uCamoEntity;
import tech.mcsp.mcsp.entity.T80uPixelEntity;
import tech.mcsp.mcsp.entity.T80bvGreenEntity;
import tech.mcsp.mcsp.entity.T80bvCamoEntity;
import tech.mcsp.mcsp.entity.T80bvPixelEntity;
import tech.mcsp.mcsp.entity.T80uKantemirEntity;
import tech.mcsp.mcsp.entity.T80bvKantemirEntity;

//import tech.mcsp.mcsp.entity.projectile.VehicleJavelinMissileDirEntity;
//import tech.mcsp.mcsp.entity.projectile.VehicleJavelinMissileTopEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister
            .create(ForgeRegistries.ENTITY_TYPES, MCSP.MOD_ID);

    public static final RegistryObject<EntityType<TyphoonTricolor30Entity>> TYPHOON_TRICOLOR_30 = register(
            "typhoon_tricolor_30",
            EntityType.Builder.<TyphoonTricolor30Entity>of(TyphoonTricolor30Entity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.4f, 3.0f));

    public static final RegistryObject<EntityType<Typhoon30Entity>> TYPHOON_30 = register("typhoon_30",
            EntityType.Builder.<Typhoon30Entity>of(Typhoon30Entity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.4f, 3.8f));

    public static final RegistryObject<EntityType<HumveeStandartCamoEntity>> HUMVEE_STANDART_CAMO = register(
            "humvee_standart_camo",
            EntityType.Builder.<HumveeStandartCamoEntity>of(HumveeStandartCamoEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(2.8f, 2.3f));

    public static final RegistryObject<EntityType<HumveeCarcEntity>> HUMVEE_CARC = register("humvee_carc",
            EntityType.Builder.<HumveeCarcEntity>of(HumveeCarcEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(2.8f, 2.3f));

    public static final RegistryObject<EntityType<HumveeSandEntity>> HUMVEE_SAND = register("humvee_sand",
            EntityType.Builder.<HumveeSandEntity>of(HumveeSandEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(2.8f, 2.3f));

    public static final RegistryObject<EntityType<HumveeMk19Entity>> HUMVEE_MK19 = register("humvee_mk19",
            EntityType.Builder.<HumveeMk19Entity>of(HumveeMk19Entity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(2.8f, 2.3f));

    public static final RegistryObject<EntityType<Bmd4Entity>> BMD_4 = register("bmd_4",
            EntityType.Builder.<Bmd4Entity>of(Bmd4Entity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.875f, 2.8125f));

    public static final RegistryObject<EntityType<Bmd4CamoEntity>> BMD_4_CAMO = register("bmd_4_camo",
            EntityType.Builder.<Bmd4CamoEntity>of(Bmd4CamoEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.875f, 2.8125f));

    public static final RegistryObject<EntityType<SprutEntity>> SPRUT = register("sprut",
            EntityType.Builder.<SprutEntity>of(SprutEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.75f, 3.125f));

    public static final RegistryObject<EntityType<SprutCamoEntity>> SPRUT_CAMO = register("sprut_camo",
            EntityType.Builder.<SprutCamoEntity>of(SprutCamoEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.75f, 3.125f));

    public static final RegistryObject<EntityType<M3A3Entity>> M3A3_BRADLEY = register("m3a3_bradley",
            EntityType.Builder.<M3A3Entity>of(M3A3Entity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(4.1f, 3.2f));

    public static final RegistryObject<EntityType<M3A3BuskIIEntity>> M3A3_BRADLEY_BUSK_II = register(
            "m3a3_bradley_busk_ii",
            EntityType.Builder.<M3A3BuskIIEntity>of(M3A3BuskIIEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(4.1f, 3.2f));

    public static final RegistryObject<EntityType<M3A3SandEntity>> M3A3_BRADLEY_SAND = register("m3a3_bradley_sand",
            EntityType.Builder.<M3A3SandEntity>of(M3A3SandEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(4.1f, 3.2f));

    public static final RegistryObject<EntityType<M3A3BuskIISandEntity>> M3A3_BRADLEY_BUSK_II_SAND = register(
            "m3a3_bradley_busk_ii_sand",
            EntityType.Builder.<M3A3BuskIISandEntity>of(M3A3BuskIISandEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(4.1f, 3.2f));

    public static final RegistryObject<EntityType<M3A3BuskIIISandEntity>> M3A3_BRADLEY_BUSK_III_SAND = register(
            "m3a3_bradley_busk_iii_sand",
            EntityType.Builder.<M3A3BuskIIISandEntity>of(M3A3BuskIIISandEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(4.1f, 3.2f));

    public static final RegistryObject<EntityType<M3A3BuskIIIEntity>> M3A3_BRADLEY_BUSK_III = register(
            "m3a3_bradley_busk_iii",
            EntityType.Builder.<M3A3BuskIIIEntity>of(M3A3BuskIIIEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(4.1f, 3.2f));

    public static final RegistryObject<EntityType<tech.mcsp.mcsp.entity.M1A2Entity>> M1A2 = register("m1a2",
            EntityType.Builder.<tech.mcsp.mcsp.entity.M1A2Entity>of(tech.mcsp.mcsp.entity.M1A2Entity::new,
                            MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(4.125f, 2.6875f));

    public static final RegistryObject<EntityType<tech.mcsp.mcsp.entity.M1A2SepEntity>> M1A2_SEP = register(
            "m1a2_sep",
            EntityType.Builder.<tech.mcsp.mcsp.entity.M1A2SepEntity>of(
                            tech.mcsp.mcsp.entity.M1A2SepEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(4.125f, 2.6875f));

    public static final RegistryObject<EntityType<tech.mcsp.mcsp.entity.M1A2SandEntity>> M1A2_SAND = register(
            "m1a2_sand",
            EntityType.Builder.<tech.mcsp.mcsp.entity.M1A2SandEntity>of(
                            tech.mcsp.mcsp.entity.M1A2SandEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(4.125f, 2.6875f));

    public static final RegistryObject<EntityType<tech.mcsp.mcsp.entity.M1A2SepSandEntity>> M1A2_SEP_SAND = register(
            "m1a2_sep_sand",
            EntityType.Builder.<tech.mcsp.mcsp.entity.M1A2SepSandEntity>of(
                            tech.mcsp.mcsp.entity.M1A2SepSandEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(4.125f, 2.6875f));

    public static final RegistryObject<EntityType<UralTricolorEntity>> URAL_TRICOLOR = register("ural_tricolor",
            EntityType.Builder.<UralTricolorEntity>of(UralTricolorEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.0f, 3.5f));

    public static final RegistryObject<EntityType<UralGreenEntity>> URAL_GREEN = register("ural_green",
            EntityType.Builder.<UralGreenEntity>of(UralGreenEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.0f, 3.5f));

    public static final RegistryObject<EntityType<Tos1aTricolorEntity>> TOS_1A_TRICOLOR = register(
            "tos_1a_tricolor",
            EntityType.Builder.<Tos1aTricolorEntity>of(Tos1aTricolorEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.5f, 3.0f));

    public static final RegistryObject<EntityType<Tos1aGreenEntity>> TOS_1A_GREEN = register("tos_1a_green",
            EntityType.Builder.<Tos1aGreenEntity>of(Tos1aGreenEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.5f, 3.0f));

    public static final RegistryObject<EntityType<T90aGreenEntity>> T90A_GREEN = register("t90a_green",
            EntityType.Builder.<T90aGreenEntity>of(T90aGreenEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.5f, 2.8f));

    public static final RegistryObject<EntityType<T90aTricolorEntity>> T90A_TRICOLOR = register("t90a_tricolor",
            EntityType.Builder.<T90aTricolorEntity>of(T90aTricolorEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.5f, 2.8f));

    public static final RegistryObject<EntityType<Ztz99aSandEntity>> ZTZ99A_SAND = register("ztz99a_sand",
            EntityType.Builder.<Ztz99aSandEntity>of(Ztz99aSandEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.5f, 2.8f));

    // T-80U variants
    public static final RegistryObject<EntityType<T80uGreenEntity>> T80U_GREEN = register("t80u_green",
            EntityType.Builder.<T80uGreenEntity>of(T80uGreenEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.5f, 2.8f));

    public static final RegistryObject<EntityType<T80uCamoEntity>> T80U_CAMO = register("t80u_camo",
            EntityType.Builder.<T80uCamoEntity>of(T80uCamoEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.5f, 2.8f));

    public static final RegistryObject<EntityType<T80uPixelEntity>> T80U_PIXEL = register("t80u_pixel",
            EntityType.Builder.<T80uPixelEntity>of(T80uPixelEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.5f, 2.8f));

    public static final RegistryObject<EntityType<T80uKantemirEntity>> T80U_KANTEMIR = register("t80u_kantemir",
            EntityType.Builder.<T80uKantemirEntity>of(T80uKantemirEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.5f, 2.8f));

    // T-80BV variants
    public static final RegistryObject<EntityType<T80bvGreenEntity>> T80BV_GREEN = register("t80bv_green",
            EntityType.Builder.<T80bvGreenEntity>of(T80bvGreenEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.5f, 2.8f));

    public static final RegistryObject<EntityType<T80bvCamoEntity>> T80BV_CAMO = register("t80bv_camo",
            EntityType.Builder.<T80bvCamoEntity>of(T80bvCamoEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.5f, 2.8f));

    public static final RegistryObject<EntityType<T80bvPixelEntity>> T80BV_PIXEL = register("t80bv_pixel",
            EntityType.Builder.<T80bvPixelEntity>of(T80bvPixelEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.5f, 2.8f));

    public static final RegistryObject<EntityType<T80bvKantemirEntity>> T80BV_KANTEMIR = register("t80bv_kantemir",
            EntityType.Builder.<T80bvKantemirEntity>of(T80bvKantemirEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .sized(3.5f, 2.8f));

    public static final RegistryObject<EntityType<Zbd04aSandEntity>> ZBD04A_SAND = register("zbd04a_sand",
            EntityType.Builder.<Zbd04aSandEntity>of(Zbd04aSandEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.5f, 2.8f));

    public static final RegistryObject<EntityType<Zbd04aGreenEntity>> ZBD04A_GREEN = register("zbd04a_green",
            EntityType.Builder.<Zbd04aGreenEntity>of(Zbd04aGreenEntity::new, MobCategory.MISC)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .fireImmune()
                    .sized(3.5f, 2.8f));

    public static final RegistryObject<EntityType<SmallCannonShellEntity>> SMALL_CANNON_SHELL = REGISTRY.register(
            "small_cannon_shell",
            () -> EntityType.Builder
                    .<SmallCannonShellEntity>of(SmallCannonShellEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .build("small_cannon_shell"));

    public static final RegistryObject<EntityType<CannonShellEntity>> CANNON_SHELL = REGISTRY.register(
            "cannon_shell",
            () -> EntityType.Builder.<CannonShellEntity>of(CannonShellEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .build("cannon_shell"));

    public static final RegistryObject<EntityType<ProjectileEntity>> PROJECTILE = REGISTRY.register("projectile",
            () -> EntityType.Builder.<ProjectileEntity>of(ProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .build("projectile"));

    public static final RegistryObject<EntityType<Mk82Entity>> MK82 = REGISTRY.register("mk82",
            () -> EntityType.Builder.<Mk82Entity>of(Mk82Entity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .build("mk82"));

    public static final RegistryObject<EntityType<Agm65Entity>> AGM65 = REGISTRY.register("agm65",
            () -> EntityType.Builder.<Agm65Entity>of(Agm65Entity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .build("agm65"));

    public static final RegistryObject<EntityType<SwarmDroneEntity>> SWARM_DRONE = REGISTRY.register("swarm_drone",
            () -> EntityType.Builder.<SwarmDroneEntity>of(SwarmDroneEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .build("swarm_drone"));

//    public static final RegistryObject<EntityType<VehicleJavelinMissileTopEntity>> VEHICLE_JAVELIN_MISSILE_TOP = REGISTRY
//            .register("vehicle_javelin_missile_top",
//                    () -> EntityType.Builder
//                            .<VehicleJavelinMissileTopEntity>of(
//                                    VehicleJavelinMissileTopEntity::new,
//                                    MobCategory.MISC)
//                            .setShouldReceiveVelocityUpdates(false)
//                            .setTrackingRange(64)
//                            .setUpdateInterval(1)
//                            .noSave()
//                            .sized(0.5f, 0.5f)
//                            .build("vehicle_javelin_missile_top"));
//
//    public static final RegistryObject<EntityType<VehicleJavelinMissileDirEntity>> VEHICLE_JAVELIN_MISSILE_DIR = REGISTRY
//            .register("vehicle_javelin_missile_dir",
//                    () -> EntityType.Builder
//                            .<VehicleJavelinMissileDirEntity>of(
//                                    VehicleJavelinMissileDirEntity::new,
//                                    MobCategory.MISC)
//                            .setShouldReceiveVelocityUpdates(false)
//                            .setTrackingRange(64)
//                            .setUpdateInterval(1)
//                            .noSave()
//                            .sized(0.5f, 0.5f)
//                            .build("vehicle_javelin_missile_dir"));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name,
                                                                             EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(name, () -> entityTypeBuilder.build(name));
    }
}