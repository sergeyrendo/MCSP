package tech.mcsp.mcsp.client.model;

import tech.mcsp.mcsp.entity.TyphoonTricolor30Entity;
import com.atsuishio.superbwarfare.client.model.entity.VehicleModel;

public class TyphoonTricolor30Model extends VehicleModel<TyphoonTricolor30Entity> {

    @Override
    public boolean hideForTurretControllerWhileZooming() {
        return true;
    }
}
