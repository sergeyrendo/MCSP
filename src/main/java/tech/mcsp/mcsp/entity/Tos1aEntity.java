package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.data.gun.GunData;
import com.atsuishio.superbwarfare.entity.vehicle.base.ArtilleryEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import com.atsuishio.superbwarfare.entity.vehicle.utils.VehicleVecUtils;
import com.atsuishio.superbwarfare.init.ModItems;
import com.atsuishio.superbwarfare.init.ModSerializers;
import com.atsuishio.superbwarfare.init.ModSounds;
import com.atsuishio.superbwarfare.init.ModTags;
import tech.mcsp.mcsp.item.MlrsRocketItem;
import com.atsuishio.superbwarfare.tools.OBB;
import com.atsuishio.superbwarfare.tools.VectorTool;
import tech.mcsp.mcsp.init.MCSPMenuTypes;
import tech.mcsp.mcsp.menu.Tos1aMenu;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.FakePlayer;
import org.joml.Matrix4d;
import org.joml.Quaterniond;
import org.joml.Vector3d;
import org.joml.Vector4d;

import java.util.ArrayList;
import java.util.List;

public class Tos1aEntity extends ArtilleryEntity {

    public static final int SHELL_COUNT = 21;

    public static final EntityDataAccessor<List<Integer>> LOADED_AMMO = SynchedEntityData.defineId(Tos1aEntity.class, ModSerializers.INT_LIST_SERIALIZER.get());

    // Cached OBB positions (relative to barrel transform)
    private static final double OBB_Z = 2.8125;
    private static final double[][] OBB_POSITIONS = {
            // Row 1 (y=0.71875, 7 shells)
            {0.9375, 0.71875, OBB_Z}, {0.625, 0.71875, OBB_Z}, {0.3125, 0.71875, OBB_Z}, {0, 0.71875, OBB_Z},
            {-0.3125, 0.71875, OBB_Z}, {-0.625, 0.71875, OBB_Z}, {-0.9375, 0.71875, OBB_Z},
            // Row 2 (y=1.03125, 7 shells)
            {0.9375, 1.03125, OBB_Z}, {0.625, 1.03125, OBB_Z}, {0.3125, 1.03125, OBB_Z}, {0, 1.03125, OBB_Z},
            {-0.3125, 1.03125, OBB_Z}, {-0.625, 1.03125, OBB_Z}, {-0.9375, 1.03125, OBB_Z},
            // Row 3 (y=1.34375, 7 shells)
            {0.9375, 1.34375, OBB_Z}, {0.625, 1.34375, OBB_Z}, {0.3125, 1.34375, OBB_Z}, {0, 1.34375, OBB_Z},
            {-0.3125, 1.34375, OBB_Z}, {-0.625, 1.34375, OBB_Z}, {-0.9375, 1.34375, OBB_Z}
    };

    public OBB[] barrelOBB = new OBB[SHELL_COUNT];
    public int interactCooldown;
    private int currentShootSlot = -1;

    // Флаги для определения, был ли транспорт только что поставлен или загружен из мира
    private boolean firstTick = true;
    private boolean loadedFromNBT = false;

    private final Vector4d tempWorldPos = new Vector4d();

    public Tos1aEntity(EntityType<?> type, Level world) {
        super(type, world);
        initBarrelOBBs();

        List<Integer> animList = new ArrayList<>(SHELL_COUNT);
        for(int i = 0; i < SHELL_COUNT; i++) {
            animList.add(0);
        }
        this.entityData.set(BARREL_ANIM, animList);
        resizeItems();
    }

    @Override
    public int getMaxBarrel() {
        return SHELL_COUNT;
    }

    private void initBarrelOBBs() {
        Vector3d halfSize = new Vector3d(0.125, 0.125, 2.03125);
        for (int i = 0; i < SHELL_COUNT; i++) {
            barrelOBB[i] = new OBB(
                    new Vector3d(this.getX(), this.getY(), this.getZ()),
                    halfSize,
                    new Quaterniond(),
                    OBB.Part.INTERACTIVE
            );
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        List<Integer> list = new ArrayList<>(SHELL_COUNT);
        for (int i = 0; i < SHELL_COUNT; i++) {
            list.add(-1); // -1 означает что слот визуально пуст
        }
        this.entityData.define(LOADED_AMMO, list);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        List<Integer> list = entityData.get(LOADED_AMMO);
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        compound.putIntArray("LoadedAmmo", arr);
    }

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        loadedFromNBT = true; // Отмечаем, что машина загружена из сохранения
        if (compound.contains("LoadedAmmo")) {
            int[] arr = compound.getIntArray("LoadedAmmo");
            List<Integer> list = new ArrayList<>(arr.length);
            for(int val : arr) {
                list.add(val);
            }
            entityData.set(LOADED_AMMO, list);
        }
        syncAmmoFromItems();
    }

    public static final int BATTERY_SLOT_START = SHELL_COUNT;
    public static final int BATTERY_SLOT_COUNT = 9;

    public int getContainerSize() { return SHELL_COUNT + BATTERY_SLOT_COUNT; }
    public int getMaxStackSize() { return 64; }

    public boolean canPlaceItem(int slot, @NotNull ItemStack stack) {
        if (slot < BATTERY_SLOT_START) return false;
        return stack.getCapability(ForgeCapabilities.ENERGY).isPresent();
    }

    public boolean canTakeItem(@NotNull Container target, int slot, @NotNull ItemStack stack) {
        if (slot < BATTERY_SLOT_START) return false;
        return true;
    }

    public boolean hasMenu() { return true; }

    @Nullable
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        if (!pPlayer.isSpectator()) {
            return new Tos1aMenu(MCSPMenuTypes.TOS1A_MENU.get(), pContainerId, pPlayerInventory,
                    new Tos1aBatteryContainer(this));
        }
        return null;
    }

    public static class Tos1aBatteryContainer implements Container {
        private final Tos1aEntity vehicle;
        public Tos1aBatteryContainer(Tos1aEntity vehicle) { this.vehicle = vehicle; }
        @Override public int getContainerSize() { return BATTERY_SLOT_COUNT; }
        @Override public boolean isEmpty() {
            for (int i = 0; i < BATTERY_SLOT_COUNT; i++) {
                if (!getItem(i).isEmpty()) return false;
            }
            return true;
        }
        @Override public @NotNull ItemStack getItem(int slot) { return vehicle.getItem(BATTERY_SLOT_START + slot); }
        @Override public @NotNull ItemStack removeItem(int slot, int amount) { return vehicle.removeItem(BATTERY_SLOT_START + slot, amount); }
        @Override public @NotNull ItemStack removeItemNoUpdate(int slot) {
            ItemStack stack = getItem(slot);
            if (stack.isEmpty()) return ItemStack.EMPTY;
            setItem(slot, ItemStack.EMPTY);
            return stack;
        }
        @Override public void setItem(int slot, @NotNull ItemStack stack) { vehicle.setItem(BATTERY_SLOT_START + slot, stack); }
        @Override public void setChanged() { vehicle.setChanged(); }
        @Override public boolean stillValid(@NotNull Player player) { return vehicle.isAlive() && vehicle.distanceToSqr(player) < 64.0; }
        @Override public void clearContent() {
            for (int i = 0; i < BATTERY_SLOT_COUNT; i++) setItem(i, ItemStack.EMPTY);
        }
    }

    private List<Integer> buildLoadedAmmoList() {
        List<Integer> list = new ArrayList<>(SHELL_COUNT);
        for (int i = 0; i < SHELL_COUNT; i++) {
            ItemStack stack = getItem(i);
            if (stack.getItem() instanceof MlrsRocketItem) {
                list.add(0); // Тип снаряда загружен
            } else {
                list.add(-1); // Пусто
            }
        }
        return list;
    }

    public void syncAmmoFromItems() {
        entityData.set(LOADED_AMMO, buildLoadedAmmoList());

        int loadedCount = 0;
        for (int i = 0; i < SHELL_COUNT; i++) {
            if (!getItem(i).isEmpty()) loadedCount++;
        }
        final int count = loadedCount;
        modifyGunData("TOS", data -> data.ammo.set(count));
    }

    @Override
    public void setChanged() {
        syncAmmoFromItems();
    }

    @Override
    public @NotNull InteractionResult interact(Player player, @NotNull InteractionHand hand) {
        if (player.getVehicle() == this) return InteractionResult.PASS;
        ItemStack stack = player.getMainHandItem();

        if (player.isShiftKeyDown() && stack.is(ModTags.Items.TOOLS_CROWBAR) && this.getPassengers().isEmpty()) {
            for (var item : getRetrieveItems()) {
                net.minecraftforge.items.ItemHandlerHelper.giveItemToPlayer(player, item);
            }
            this.remove(RemovalReason.DISCARDED);
            this.discard();
            return InteractionResult.SUCCESS;
        }

        // Используем метод мода для получения точного OBB, на который смотрит игрок (работает безупречно)
        double reach = player.getEntityReach();
        OBB lookingObb = OBB.getLookingObb(player, reach);
        int lookingShellIndex = -1;

        if (lookingObb != null) {
            for (int i = 0; i < SHELL_COUNT; i++) {
                if (lookingObb == barrelOBB[i]) {
                    lookingShellIndex = i;
                    break;
                }
            }
        }

        // Заряжание ракеты (если игрок смотрит прямо на ствол и держит ракету)
        if (stack.getItem() instanceof MlrsRocketItem && interactCooldown == 0 && lookingShellIndex >= 0) {
            if (getItem(lookingShellIndex).isEmpty()) {
                if (level() instanceof ServerLevel serverLevel) {
                    setItem(lookingShellIndex, stack.copyWithCount(1));
                    if (!player.isCreative()) {
                        stack.shrink(1);
                    }
                    Vector3d c = barrelOBB[lookingShellIndex].center;
                    serverLevel.playSound(null, c.x, c.y, c.z, ModSounds.TYPE_63_RELOAD.get(), SoundSource.PLAYERS, 1f, random.nextFloat() * 0.1f + 0.9f);
                    interactCooldown = 5;
                    setChanged(); // Это обновит визуальную модель
                }
                player.swing(InteractionHand.MAIN_HAND);
                return InteractionResult.SUCCESS;
            }
        }

        // Разряжание ракеты (если в руке пусто)
        if (stack.isEmpty() && !player.isShiftKeyDown() && interactCooldown == 0 && lookingShellIndex >= 0) {
            if (!getItem(lookingShellIndex).isEmpty()) {
                if (level() instanceof ServerLevel serverLevel) {
                    player.addItem(getItem(lookingShellIndex).copyWithCount(1));
                    Vector3d c = barrelOBB[lookingShellIndex].center;
                    serverLevel.playSound(null, c.x, c.y, c.z, ModSounds.TYPE_63_RELOAD.get(), SoundSource.PLAYERS, 1f, random.nextFloat() * 0.1f + 0.9f);
                    interactCooldown = 5;
                    setItem(lookingShellIndex, ItemStack.EMPTY);
                    setChanged();
                }
                player.swing(InteractionHand.MAIN_HAND);
                return InteractionResult.SUCCESS;
            }
        }

        // Параметры стрельбы
        if (player.getMainHandItem().getItem() == ModItems.FIRING_PARAMETERS.get() && player.isShiftKeyDown()) {
            setTarget(player.getMainHandItem(), player, "TOS");
            return InteractionResult.SUCCESS;
        }
        if (player.getOffhandItem().getItem() == ModItems.FIRING_PARAMETERS.get() && player.isShiftKeyDown()) {
            setTarget(player.getOffhandItem(), player, "TOS");
            return InteractionResult.SUCCESS;
        }

        // Логика посадки
        boolean lookingAtInteractive = lookingShellIndex >= 0;
        if (!lookingAtInteractive && lookingObb != null) {
            if (lookingObb.part == OBB.Part.TURRET || lookingObb.part == OBB.Part.INTERACTIVE) {
                lookingAtInteractive = true;
            }
        }

        if (!lookingAtInteractive && !player.isShiftKeyDown() && this.getMaxPassengers() > 0) {
            if (this.getFirstPassenger() == null) {
                if (player instanceof FakePlayer) return InteractionResult.PASS;
                player.setYRot(this.getYRot());
                player.setXRot(this.getXRot());
                player.yHeadRot = this.getYRot();
                player.setSprinting(false);
                if (player.level() instanceof ServerLevel) {
                    return player.startRiding(this) ? InteractionResult.CONSUME : InteractionResult.PASS;
                }
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    public void baseTick() {
        super.baseTick();

        // Логика очистки инвентаря при спавне (если это новый транспорт, удаляем все ракеты чтобы заряжать вручную)
        if (firstTick && !level().isClientSide) {
            firstTick = false;
            if (!loadedFromNBT) {
                for (int i = 0; i < SHELL_COUNT; i++) {
                    setItem(i, ItemStack.EMPTY);
                }
            }
            syncAmmoFromItems();
        }

        if (interactCooldown > 0) {
            interactCooldown--;
        }

        updateOBB();
    }

    @Override
    public List<OBB> getOBBs() {
        // Мы добавляем ракеты в общий пул OBB, чтобы встроенный метод OBB.getLookingObb мог их находить
        List<OBB> obbs = new ArrayList<>(super.getOBBs());
        for (int i = 0; i < SHELL_COUNT; i++) {
            if (barrelOBB[i] != null) {
                obbs.add(barrelOBB[i]);
            }
        }
        return obbs;
    }

    public List<OBB> getAllOBBsForRender() {
        return getOBBs();
    }

    @Override
    public void updateOBB() {
        super.updateOBB();

        Matrix4d transform = getBarrelTransform(1);
        var rotation = VectorTool.combineRotationsBarrel(1, this);
        Vector3d halfSize = new Vector3d(0.125, 0.125, 2.03125);

        for (int i = 0; i < SHELL_COUNT; i++) {
            transformPositionInto(transform, OBB_POSITIONS[i][0], OBB_POSITIONS[i][1], OBB_POSITIONS[i][2], tempWorldPos);
            barrelOBB[i] = new OBB(
                    new Vector3d(tempWorldPos.x, tempWorldPos.y, tempWorldPos.z),
                    halfSize,
                    rotation,
                    OBB.Part.INTERACTIVE
            );
        }
    }

    private void transformPositionInto(Matrix4d transform, double x, double y, double z, Vector4d dest) {
        dest.set(x, y, z, 1.0);
        transform.transform(dest);
    }

    @Override
    public DamageModifier getDamageModifier() {
        return super.getDamageModifier()
                .custom((source, damage) -> getSourceAngle(source, 0.35f) * damage);
    }

    public boolean canBind() {
        return true;
    }

    @Override
    public @NotNull List<ItemStack> getRetrieveItems() {
        return List.of(com.atsuishio.superbwarfare.item.container.ContainerBlockItem.createInstance(this));
    }

    public int getFirstLoadedSlot() {
        for (int i = 0; i < SHELL_COUNT; i++) {
            if (!getItem(i).isEmpty()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Vec3 getShootPos(net.minecraft.world.entity.Entity entity, float ticks) {
        int slot = currentShootSlot >= 0 ? currentShootSlot : getFirstLoadedSlot();
        if (slot >= 0) return getShootPosForSlot(slot, ticks);
        return super.getShootPos(entity, ticks);
    }

    @Override
    public Vec3 getShootPos(String weaponName, float ticks) {
        int slot = currentShootSlot >= 0 ? currentShootSlot : getFirstLoadedSlot();
        if (slot >= 0) return getShootPosForSlot(slot, ticks);
        return super.getShootPos(weaponName, ticks);
    }

    @SuppressWarnings("deprecation")
    private Vec3 getShootPosForSlot(int slot, float ticks) {
        var data = getGunData("TOS");
        if (data != null && data.compute().getShootPos().getPositions().size() > slot) {
            var vec3 = data.compute().getShootPos().getPositions().get(slot);
            var worldPosition = transformPosition(
                    this.getTransformFromString(data.compute().getShootPos().getTransform(), ticks),
                    vec3.x, vec3.y, vec3.z);
            return new Vec3(worldPosition.x, worldPosition.y, worldPosition.z);
        }
        return getEyePosition(ticks);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void beforeShoot(LivingEntity living) {
        var data = getGunData("TOS");
        if (data == null) return;

        currentShootSlot = getFirstLoadedSlot();
        if (currentShootSlot < 0) return;

        setItem(currentShootSlot, ItemStack.EMPTY);
        entityData.set(LOADED_AMMO, buildLoadedAmmoList());

        List<Integer> barrelAnimList = entityData.get(BARREL_ANIM);
        int[] barrelAnim = new int[barrelAnimList.size()];
        for(int i = 0; i < barrelAnimList.size(); i++) barrelAnim[i] = barrelAnimList.get(i);

        if (currentShootSlot < barrelAnim.length) {
            barrelAnim[currentShootSlot] = data.compute().getShootAnimationTime();
            List<Integer> newList = new ArrayList<>(barrelAnim.length);
            for(int val : barrelAnim) newList.add(val);
            entityData.set(BARREL_ANIM, newList);
        }
    }

    @Override
    public void afterShoot(GunData gunData, Vec3 shootVec) {
        super.afterShoot(gunData, shootVec);
        currentShootSlot = -1;
    }
}