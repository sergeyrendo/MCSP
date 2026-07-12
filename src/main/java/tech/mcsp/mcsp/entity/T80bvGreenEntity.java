package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.entity.vehicle.base.GeoVehicleEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import tech.mcsp.mcsp.client.model.T80bvGreenModel;

public class T80bvGreenEntity extends GeoVehicleEntity {

    public T80bvGreenEntity(EntityType<T80bvGreenEntity> type, Level world) {
        super(type, world);
    }

    @Override
    public int getTrackAnimationLength() {
        return T80bvGreenModel.TRACK_COUNT * 2;
    }

}
