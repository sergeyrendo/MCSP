package tech.mcsp.mcsp.item.armor;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;
import tech.mcsp.mcsp.init.ModArmorMaterials;

import java.util.function.Consumer;

public class VestAVSItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public VestAVSItem(Item.Properties properties) {
        // Незеритовая защита: используем материал OPSCORE2
        super(ModArmorMaterials.OPSCORE2, Type.CHESTPLATE, properties);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) { }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() { return cache; }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public @Nullable HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                // Fail-safe: если нет geo/текстуры, не используем GeckoLib, чтобы не падать
                ResourceLocation modelLoc = new ResourceLocation("mcsp", "geo/vest_avs.geo.json");
                if (Minecraft.getInstance().getResourceManager().getResource(modelLoc).isEmpty()) {
                    return original;
                }
                GeoArmorRenderer<?> renderer = new tech.mcsp.mcsp.client.renderer.armor.VestAVSRenderer();
                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return (HumanoidModel<?>) renderer;
            }
        });
    }
}

