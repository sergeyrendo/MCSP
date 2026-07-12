package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.entity.vehicle.base.GeoVehicleEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import tech.mcsp.mcsp.client.model.M1A2Model;

public class M1A2Entity extends GeoVehicleEntity {

    public M1A2Entity(EntityType<M1A2Entity> type, Level world) {
        super(type, world);
    }

    @Override
    public int getTrackAnimationLength() {
        return M1A2Model.TRACK_COUNT * 2;
    }
}
