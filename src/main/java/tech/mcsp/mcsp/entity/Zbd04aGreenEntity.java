package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.entity.vehicle.base.GeoVehicleEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import tech.mcsp.mcsp.client.model.Zbd04aGreenModel;

public class Zbd04aGreenEntity extends GeoVehicleEntity {

    public Zbd04aGreenEntity(EntityType<Zbd04aGreenEntity> type, Level world) {
        super(type, world);
    }

    @Override
    public int getTrackAnimationLength() {
        return Zbd04aGreenModel.TRACK_COUNT * 2;
    }
}
