package tech.mcsp.mcsp.client.model;

import tech.mcsp.mcsp.entity.HumveeMk19Entity;
import com.atsuishio.superbwarfare.client.model.entity.VehicleModel;

public class HumveeMk19Model extends VehicleModel<HumveeMk19Entity> {

    @Override
    public boolean hideForTurretControllerWhileZooming() {
        return true;
    }
}
