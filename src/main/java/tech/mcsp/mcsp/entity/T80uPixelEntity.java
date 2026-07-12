package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.entity.vehicle.base.GeoVehicleEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import tech.mcsp.mcsp.client.model.T80uPixelModel;

public class T80uPixelEntity extends GeoVehicleEntity {

    public T80uPixelEntity(EntityType<T80uPixelEntity> type, Level world) {
        super(type, world);
    }

    @Override
    public int getTrackAnimationLength() {
        return T80uPixelModel.TRACK_COUNT * 2;
    }
}
