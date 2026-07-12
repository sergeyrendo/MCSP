package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.entity.vehicle.base.GeoVehicleEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import tech.mcsp.mcsp.client.model.Zbd04aSandModel;

public class Zbd04aSandEntity extends GeoVehicleEntity {

    public Zbd04aSandEntity(EntityType<Zbd04aSandEntity> type, Level world) {
        super(type, world);
    }

    @Override
    public int getTrackAnimationLength() {
        return Zbd04aSandModel.TRACK_COUNT * 2;
    }
}
