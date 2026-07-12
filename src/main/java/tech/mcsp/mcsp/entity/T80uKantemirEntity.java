package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.entity.vehicle.base.GeoVehicleEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import tech.mcsp.mcsp.client.model.T80uKantemirModel;

public class T80uKantemirEntity extends GeoVehicleEntity {

    public T80uKantemirEntity(EntityType<T80uKantemirEntity> type, Level world) {
        super(type, world);
    }

    @Override
    public int getTrackAnimationLength() {
        return T80uKantemirModel.TRACK_COUNT * 2;
    }

}
