package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.entity.vehicle.base.GeoVehicleEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import tech.mcsp.mcsp.client.model.M3A3BuskIIModel;

public class M3A3BuskIIEntity extends GeoVehicleEntity {

    public M3A3BuskIIEntity(EntityType<M3A3BuskIIEntity> type, Level world) {
        super(type, world);
    }

    @Override
    public int getTrackAnimationLength() {
        return M3A3BuskIIModel.TRACK_COUNT * 2;
    }
}
