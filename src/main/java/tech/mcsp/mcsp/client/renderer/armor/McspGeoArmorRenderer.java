package tech.mcsp.mcsp.client.renderer.armor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.world.item.Item;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

/**
 * GeckoLib вызывает {@link #renderToBuffer} для блика/тримов без {@code prepForRender},
 * из-за чего {@code currentEntity} остаётся null и клиент падает.
 */
public abstract class McspGeoArmorRenderer<T extends Item & GeoItem> extends GeoArmorRenderer<T> {

    protected McspGeoArmorRenderer(GeoModel<T> model) {
        super(model);
    }

    @Override
    public void renderToBuffer(
            PoseStack poseStack,
            VertexConsumer buffer,
            int packedLight,
            int packedOverlay,
            float red,
            float green,
            float blue,
            float alpha) {
        if (getCurrentEntity() == null) {
            return;
        }
        super.renderToBuffer(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
