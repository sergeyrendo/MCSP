package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.entity.vehicle.base.GeoVehicleEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import tech.mcsp.mcsp.client.model.T80bvCamoModel;

public class T80bvCamoEntity extends GeoVehicleEntity {

    public T80bvCamoEntity(EntityType<T80bvCamoEntity> type, Level world) {
        super(type, world);
    }

    @Override
    public int getTrackAnimationLength() {
        return T80bvCamoModel.TRACK_COUNT * 2;
    }

}
