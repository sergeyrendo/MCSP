package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.entity.vehicle.base.GeoVehicleEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import tech.mcsp.mcsp.client.model.T90aTricolorModel;

public class T90aTricolorEntity extends GeoVehicleEntity {

    public T90aTricolorEntity(EntityType<T90aTricolorEntity> type, Level world) {
        super(type, world);
    }

    @Override
    public int getTrackAnimationLength() {
        return T90aTricolorModel.TRACK_COUNT * 2;
    }
}
