package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.entity.vehicle.base.GeoVehicleEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import tech.mcsp.mcsp.client.model.M1A2SepModel;

public class M1A2SepEntity extends GeoVehicleEntity {

    public M1A2SepEntity(EntityType<M1A2SepEntity> type, Level world) {
        super(type, world);
    }

    @Override
    public int getTrackAnimationLength() {
        return M1A2SepModel.TRACK_COUNT * 2;
    }

}
