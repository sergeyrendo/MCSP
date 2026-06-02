package tech.mcsp.mcsp.client.model;

import tech.mcsp.mcsp.entity.HumveeSandEntity;
import com.atsuishio.superbwarfare.client.model.entity.VehicleModel;
import net.minecraft.resources.ResourceLocation;

public class HumveeSandModel extends VehicleModel<HumveeSandEntity> {

    @Override
    public boolean hideForTurretControllerWhileZooming() {
        return true;
    }
}
