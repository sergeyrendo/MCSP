package tech.mcsp.mcsp.client.model;

import tech.mcsp.mcsp.entity.Typhoon30Entity;
import com.atsuishio.superbwarfare.client.model.entity.VehicleModel;

public class Typhoon30Model extends VehicleModel<Typhoon30Entity> {

    @Override
    public boolean hideForTurretControllerWhileZooming() {
        return true;
    }
}
