package tech.mcsp.mcsp.client.model;

import com.atsuishio.superbwarfare.client.model.entity.VehicleModel;
import net.minecraft.util.Mth;
import software.bernie.geckolib.core.animation.AnimationState;
import tech.mcsp.mcsp.entity.UralTricolorEntity;

public class UralTricolorModel extends VehicleModel<UralTricolorEntity> {

    @Override
    public boolean hideForTurretControllerWhileZooming() {
        return true;
    }
}
