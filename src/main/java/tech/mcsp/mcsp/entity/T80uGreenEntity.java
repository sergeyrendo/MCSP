package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.entity.vehicle.base.GeoVehicleEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import tech.mcsp.mcsp.client.model.T80uGreenModel;

public class T80uGreenEntity extends GeoVehicleEntity {

    public T80uGreenEntity(EntityType<T80uGreenEntity> type, Level world) {
        super(type, world);
    }

    @Override
    public int getTrackAnimationLength() {
        return T80uGreenModel.TRACK_COUNT * 2;
    }
}
