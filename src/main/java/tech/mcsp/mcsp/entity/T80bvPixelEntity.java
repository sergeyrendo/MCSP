package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.entity.vehicle.base.GeoVehicleEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import tech.mcsp.mcsp.client.model.T80bvPixelModel;

public class T80bvPixelEntity extends GeoVehicleEntity {

    public T80bvPixelEntity(EntityType<T80bvPixelEntity> type, Level world) {
        super(type, world);
    }

    @Override
    public int getTrackAnimationLength() {
        return T80bvPixelModel.TRACK_COUNT * 2;
    }
}
