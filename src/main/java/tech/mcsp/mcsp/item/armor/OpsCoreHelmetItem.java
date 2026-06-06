package tech.mcsp.mcsp.item.armor;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;
import tech.mcsp.mcsp.client.GeoArmorClientExtensions;
import tech.mcsp.mcsp.client.renderer.armor.OpsCoreHelmetRenderer;
import tech.mcsp.mcsp.init.ModArmorMaterials;

import java.util.function.Consumer;

public class OpsCoreHelmetItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public OpsCoreHelmetItem(Item.Properties properties) {
        super(ModArmorMaterials.OPSCORE2, Type.HELMET, properties);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        GeoArmorClientExtensions.registerArmorRenderer(consumer, OpsCoreHelmetRenderer::new);
    }
}
