package tech.mcsp.mcsp.client.model;

import tech.mcsp.mcsp.entity.HumveeCarcEntity;
import com.atsuishio.superbwarfare.client.model.entity.VehicleModel;
import net.minecraft.resources.ResourceLocation;

public class HumveeCarcModel extends VehicleModel<HumveeCarcEntity> {

    @Override
    public boolean hideForTurretControllerWhileZooming() {
        return true;
    }
}
