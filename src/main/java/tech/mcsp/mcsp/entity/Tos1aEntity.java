package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.data.gun.GunData;
import com.atsuishio.superbwarfare.entity.vehicle.base.ArtilleryEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import com.atsuishio.superbwarfare.init.ModItems;
import com.atsuishio.superbwarfare.init.ModSerializers;
import com.atsuishio.superbwarfare.init.ModSounds;
import com.atsuishio.superbwarfare.init.ModTags;
import com.atsuishio.superbwarfare.tools.OBB;
import com.atsuishio.superbwarfare.tools.VectorTool;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.FakePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4d;
import org.joml.Quaterniond;
import org.joml.Vector3d;
import org.joml.Vector4d;
import tech.mcsp.mcsp.item.MlrsRocketItem;

import java.util.ArrayList;
import java.util.List;

public class Tos1aEntity extends ArtilleryEntity {

    public static final int SHELL_COUNT = 21;

    public static final EntityDataAccessor<List<Integer>> LOADED_AMMO = SynchedEntityData.defineId(Tos1aEntity.class, ModSerializers.INT_LIST_SERIALIZER.get());

    private static final double OBB_Z = 2.8125;
    private static final double[][] OBB_POSITIONS = {
            {0.9375, 0.71875, OBB_Z}, {0.625, 0.71875, OBB_Z}, {0.3125, 0.71875, OBB_Z}, {0, 0.71875, OBB_Z},
            {-0.3125, 0.71875, OBB_Z}, {-0.625, 0.71875, OBB_Z}, {-0.9375, 0.71875, OBB_Z},
            {0.9375, 1.03125, OBB_Z}, {0.625, 1.03125, OBB_Z}, {0.3125, 1.03125, OBB_Z}, {0, 1.03125, OBB_Z},
            {-0.3125, 1.03125, OBB_Z}, {-0.625, 1.03125, OBB_Z}, {-0.9375, 1.03125, OBB_Z},
            {0.9375, 1.34375, OBB_Z}, {0.625, 1.34375, OBB_Z}, {0.3125, 1.34375, OBB_Z}, {0, 1.34375, OBB_Z},
            {-0.3125, 1.34375, OBB_Z}, {-0.625, 1.34375, OBB_Z}, {-0.9375, 1.34375, OBB_Z}
    };

    public OBB[] barrelOBB = new OBB[SHELL_COUNT];
    public int interactCooldown;
    private int currentShootSlot = -1;

    private boolean firstTick = true;
    private boolean loadedFromNBT = false;

    private final Vector4d tempWorldPos = new Vector4d();

    public Tos1aEntity(EntityType<?> type, Level world) {
        super(type, world);
        initBarrelOBBs();

        List<Integer> animList = new ArrayList<>(SHELL_COUNT);
        for (int i = 0; i < SHELL_COUNT; i++) {
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
            list.add(-1);
        }
        this.entityData.define(LOADED_AMMO, list);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        List<Integer> list = entityData.get(LOADED_AMMO);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        compound.putIntArray("LoadedAmmo", arr);
    }

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        loadedFromNBT = true;
        if (compound.contains("LoadedAmmo")) {
            int[] arr = compound.getIntArray("LoadedAmmo");
            List<Integer> list = new ArrayList<>(arr.length);
            for (int val : arr) {
                list.add(val);
            }
            entityData.set(LOADED_AMMO, list);
        }
        syncAmmoFromItems();
    }

    @Override
    public int getContainerSize() {
        return SHELL_COUNT;
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }

    public boolean canPlaceItem(int slot, @NotNull ItemStack stack) {
        return false;
    }

    public boolean canTakeItem(@NotNull Container target, int slot, @NotNull ItemStack stack) {
        return false;
    }

    @Override
    public boolean hasMenu() {
        return false;
    }

    private List<Integer> buildLoadedAmmoList() {
        List<Integer> list = new ArrayList<>(SHELL_COUNT);
        for (int i = 0; i < SHELL_COUNT; i++) {
            ItemStack stack = getItem(i);
            if (stack.getItem() instanceof MlrsRocketItem) {
                list.add(0);
            } else {
                list.add(-1);
            }
        }
        return list;
    }

    public int countLoadedShells() {
        if (level().isClientSide) {
            int loadedCount = 0;
            for (int value : entityData.get(LOADED_AMMO)) {
                if (value >= 0) {
                    loadedCount++;
                }
            }
            return loadedCount;
        }
        int loadedCount = 0;
        for (int i = 0; i < SHELL_COUNT; i++) {
            if (!getItem(i).isEmpty()) {
                loadedCount++;
            }
        }
        return loadedCount;
    }

    public void syncAmmoFromItems() {
        if (level().isClientSide) {
            return;
        }
        entityData.set(LOADED_AMMO, buildLoadedAmmoList());
        final int count = countLoadedShells();
        modifyGunData("TOS", data -> data.ammo.set(count));
        modifyGunData(0, data -> data.ammo.set(count));
    }

    @Override
    public int getAmmoCount(@NotNull String weaponName) {
        if ("TOS".equals(weaponName)) {
            return countLoadedShells();
        }
        return super.getAmmoCount(weaponName);
    }

    @Override
    public int getAmmoCount(@NotNull LivingEntity living) {
        if (living.getVehicle() == this) {
            return countLoadedShells();
        }
        return super.getAmmoCount(living);
    }

    @Override
    public int getAmmo(@Nullable GunData gunData) {
        int loaded = countLoadedShells();
        if (loaded > 0) {
            return loaded;
        }
        return super.getAmmo(gunData);
    }

    @Override
    public boolean canShoot(@NotNull LivingEntity living) {
        if (countLoadedShells() <= 0) {
            return false;
        }
        if (!level().isClientSide) {
            syncAmmoFromItems();
        }
        return super.canShoot(living);
    }

    @Override
    public void setChanged() {
        if (!level().isClientSide) {
            syncAmmoFromItems();
            super.setChanged();
        }
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

        double reach = player.getEntityReach();
        OBB lookingObb = OBB.getLookingObb(player, reach);
        int lookingShellIndex = getLookingShellIndex(player);

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
                    setChanged();
                    player.swing(InteractionHand.MAIN_HAND);
                    return InteractionResult.SUCCESS;
                }
                return InteractionResult.SUCCESS;
            }
        }

        if (stack.isEmpty() && !player.isShiftKeyDown() && interactCooldown == 0 && lookingShellIndex >= 0) {
            if (!getItem(lookingShellIndex).isEmpty()) {
                if (level() instanceof ServerLevel serverLevel) {
                    player.addItem(getItem(lookingShellIndex).copyWithCount(1));
                    Vector3d c = barrelOBB[lookingShellIndex].center;
                    serverLevel.playSound(null, c.x, c.y, c.z, ModSounds.TYPE_63_RELOAD.get(), SoundSource.PLAYERS, 1f, random.nextFloat() * 0.1f + 0.9f);
                    interactCooldown = 5;
                    setItem(lookingShellIndex, ItemStack.EMPTY);
                    setChanged();
                    player.swing(InteractionHand.MAIN_HAND);
                    return InteractionResult.SUCCESS;
                }
                return InteractionResult.SUCCESS;
            }
        }

        if (player.getMainHandItem().getItem() == ModItems.FIRING_PARAMETERS.get() && player.isShiftKeyDown()) {
            setTarget(player.getMainHandItem(), player, "TOS");
            return InteractionResult.SUCCESS;
        }
        if (player.getOffhandItem().getItem() == ModItems.FIRING_PARAMETERS.get() && player.isShiftKeyDown()) {
            setTarget(player.getOffhandItem(), player, "TOS");
            return InteractionResult.SUCCESS;
        }

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
    protected void addPassenger(@NotNull Entity passenger) {
        super.addPassenger(passenger);
        if (!level().isClientSide) {
            syncAmmoFromItems();
        }
    }

    @Override
    public void baseTick() {
        super.baseTick();

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

        for (int i = 0; i < SHELL_COUNT; i++) {
            transformPositionInto(transform, OBB_POSITIONS[i][0], OBB_POSITIONS[i][1], OBB_POSITIONS[i][2], tempWorldPos);
            barrelOBB[i].setCenter(new Vector3d(tempWorldPos.x, tempWorldPos.y, tempWorldPos.z));
            barrelOBB[i].updateRotation(rotation);
        }
    }

    public int getLookingShellIndex(Player player) {
        double reach = player.getEntityReach();
        Vec3 eyePos = player.getEyePosition();
        Vec3 endPos = eyePos.add(player.getLookAngle().scale(reach));

        Vector3d start = new Vector3d(eyePos.x, eyePos.y, eyePos.z);
        Vector3d end = new Vector3d(endPos.x, endPos.y, endPos.z);

        double closestDist = Double.MAX_VALUE;
        int closestIndex = -1;

        for (int i = 0; i < SHELL_COUNT; i++) {
            if (barrelOBB[i] == null) continue;
            var hit = barrelOBB[i].clip(start, end);
            if (hit.isPresent()) {
                double dist = hit.get().distanceSquared(start);
                if (dist < closestDist) {
                    closestDist = dist;
                    closestIndex = i;
                }
            }
        }

        return closestIndex;
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

        List<Integer> barrelAnimList = entityData.get(BARREL_ANIM);
        int[] barrelAnim = new int[barrelAnimList.size()];
        for (int i = 0; i < barrelAnimList.size(); i++) barrelAnim[i] = barrelAnimList.get(i);

        if (currentShootSlot < barrelAnim.length) {
            barrelAnim[currentShootSlot] = data.compute().getShootAnimationTime();
            List<Integer> newList = new ArrayList<>(barrelAnim.length);
            for (int val : barrelAnim) newList.add(val);
            entityData.set(BARREL_ANIM, newList);
        }
    }

    @Override
    public void afterShoot(GunData gunData, Vec3 shootVec) {
        if (currentShootSlot >= 0 && !level().isClientSide && gunData != null) {
            if (super.getAmmo(gunData) < countLoadedShells()) {
                setItem(currentShootSlot, ItemStack.EMPTY);
                syncAmmoFromItems();
            }
        }
        currentShootSlot = -1;
        super.afterShoot(gunData, shootVec);
    }
}
