package tech.mcsp.mcsp.item.armor;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import software.bernie.geckolib.animatable.GeoItem;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;
import tech.mcsp.mcsp.client.GeoArmorClientExtensions;
import tech.mcsp.mcsp.client.renderer.armor.VestAVSRenderer;
import tech.mcsp.mcsp.init.ModArmorMaterials;

import java.util.function.Consumer;

public class VestAVSItem extends ArmorItem implements GeoItem {
    private static final ResourceLocation MODEL = ResourceLocation.fromNamespaceAndPath("mcsp", "geo/vest_avs.geo.json");

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public VestAVSItem(Item.Properties properties) {
        super(ModArmorMaterials.OPSCORE2, Type.CHESTPLATE, properties);
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
        GeoArmorClientExtensions.registerArmorRenderer(consumer, VestAVSRenderer::new, MODEL);
    }
}
