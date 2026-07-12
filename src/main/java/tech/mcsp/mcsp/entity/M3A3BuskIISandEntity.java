package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.entity.vehicle.base.GeoVehicleEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import tech.mcsp.mcsp.client.model.M3A3BuskIISandModel;

public class M3A3BuskIISandEntity extends GeoVehicleEntity {

    public M3A3BuskIISandEntity(EntityType<M3A3BuskIISandEntity> type, Level world) {
        super(type, world);
    }

    @Override
    public int getTrackAnimationLength() {
        return M3A3BuskIISandModel.TRACK_COUNT * 2;
    }

}
