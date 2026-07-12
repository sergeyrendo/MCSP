package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.entity.vehicle.base.GeoVehicleEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import tech.mcsp.mcsp.client.model.T80bvKantemirModel;

public class T80bvKantemirEntity extends GeoVehicleEntity {

    public T80bvKantemirEntity(EntityType<T80bvKantemirEntity> type, Level world) {
        super(type, world);
    }

    @Override
    public int getTrackAnimationLength() {
        return T80bvKantemirModel.TRACK_COUNT * 2;
    }
}
