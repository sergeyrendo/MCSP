package tech.mcsp.mcsp.item.armor;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;
import tech.mcsp.mcsp.client.GeoArmorClientExtensions;
import tech.mcsp.mcsp.client.renderer.armor.VestCPC2Renderer;
import tech.mcsp.mcsp.init.ModArmorMaterials;

import java.util.function.Consumer;

public class VestCPC2Item extends ArmorItem implements GeoItem {
    private static final ResourceLocation MODEL = new ResourceLocation("mcsp", "geo/vest_cpc2.geo.json");

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public VestCPC2Item(Item.Properties properties) {
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
        GeoArmorClientExtensions.registerArmorRenderer(consumer, VestCPC2Renderer::new, MODEL);
    }
}
