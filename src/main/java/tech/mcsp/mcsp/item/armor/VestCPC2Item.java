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

public class VestCPC2Item extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public VestCPC2Item(Item.Properties properties) {
        // Незеритовый уровень защиты (тот же материал)
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
                // Fail-safe, чтобы не падать, если geo ещё не добавили
                ResourceLocation modelLoc = new ResourceLocation("mcsp", "geo/vest_cpc2.geo.json");
                if (Minecraft.getInstance().getResourceManager().getResource(modelLoc).isEmpty()) {
                    return original;
                }
                GeoArmorRenderer<?> renderer = new tech.mcsp.mcsp.client.renderer.armor.VestCPC2Renderer();
                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return (HumanoidModel<?>) renderer;
            }
        });
    }
}

