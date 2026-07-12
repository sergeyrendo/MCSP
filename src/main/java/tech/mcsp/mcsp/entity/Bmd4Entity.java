package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.entity.vehicle.base.GeoVehicleEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import tech.mcsp.mcsp.client.model.Bmd4Model;

public class Bmd4Entity extends GeoVehicleEntity {

    public Bmd4Entity(EntityType<Bmd4Entity> type, Level world) {
        super(type, world);
    }

    @Override
    public int getTrackAnimationLength() {
        return Bmd4Model.TRACK_COUNT * 2;
    }
}
