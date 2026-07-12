package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.entity.vehicle.base.GeoVehicleEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import tech.mcsp.mcsp.client.model.M1A2SepSandModel;

public class M1A2SepSandEntity extends GeoVehicleEntity {

    public M1A2SepSandEntity(EntityType<M1A2SepSandEntity> type, Level world) {
        super(type, world);
    }

    @Override
    public int getTrackAnimationLength() {
        return M1A2SepSandModel.TRACK_COUNT * 2;
    }
}
