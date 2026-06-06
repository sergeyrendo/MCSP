package tech.mcsp.mcsp.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import tech.mcsp.mcsp.client.renderer.armor.McspGeoArmorRenderer;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * GeckoLib 4.7: кэшированный {@link GeoArmorRenderer} с {@code prepForRender} при наличии сущности.
 * Без prepForRender модель не рисуется; NPE при блике/тримах блокируется в {@link McspGeoArmorRenderer}.
 */
public final class GeoArmorClientExtensions {

    private GeoArmorClientExtensions() {
    }

    public static void registerArmorRenderer(
            Consumer<IClientItemExtensions> consumer,
            Supplier<? extends GeoArmorRenderer<?>> rendererFactory) {
        registerArmorRenderer(consumer, rendererFactory, null);
    }

    public static void registerArmorRenderer(
            Consumer<IClientItemExtensions> consumer,
            Supplier<? extends GeoArmorRenderer<?>> rendererFactory,
            @Nullable ResourceLocation requiredModelGeo) {
        consumer.accept(new IClientItemExtensions() {
            @Nullable
            private GeoArmorRenderer<?> renderer;

            @Override
            public @Nullable HumanoidModel<?> getHumanoidArmorModel(
                    LivingEntity livingEntity,
                    ItemStack itemStack,
                    EquipmentSlot equipmentSlot,
                    HumanoidModel<?> original) {
                if (livingEntity == null) {
                    return original;
                }
                if (requiredModelGeo != null
                        && Minecraft.getInstance().getResourceManager().getResource(requiredModelGeo).isEmpty()) {
                    return original;
                }
                if (renderer == null) {
                    renderer = rendererFactory.get();
                }
                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return renderer;
            }
        });
    }
}
