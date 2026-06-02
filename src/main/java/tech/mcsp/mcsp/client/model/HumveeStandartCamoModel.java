package tech.mcsp.mcsp.client.model;

import tech.mcsp.mcsp.entity.HumveeStandartCamoEntity;
import com.atsuishio.superbwarfare.client.model.entity.VehicleModel;
import net.minecraft.resources.ResourceLocation;

public class HumveeStandartCamoModel extends VehicleModel<HumveeStandartCamoEntity> {

    @Override
    public boolean hideForTurretControllerWhileZooming() {
        return true;
    }
}
