package tech.mcsp.mcsp.client.model;

import com.atsuishio.superbwarfare.client.model.entity.VehicleModel;
import net.minecraft.util.Mth;
import software.bernie.geckolib.animation.AnimationState;
import tech.mcsp.mcsp.entity.UralGreenEntity;

public class UralGreenModel extends VehicleModel<UralGreenEntity> {

    @Override
    public boolean hideForTurretControllerWhileZooming() {
        return true;
    }
}
