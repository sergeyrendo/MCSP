package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.entity.vehicle.base.GeoVehicleEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import tech.mcsp.mcsp.client.model.T90aGreenModel;

public class T90aGreenEntity extends GeoVehicleEntity {

    public T90aGreenEntity(EntityType<T90aGreenEntity> type, Level world) {
        super(type, world);
    }

    @Override
    public int getTrackAnimationLength() {
        return T90aGreenModel.TRACK_COUNT * 2;
    }
}
