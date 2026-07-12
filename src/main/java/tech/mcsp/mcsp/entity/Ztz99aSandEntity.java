package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.entity.vehicle.base.GeoVehicleEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import tech.mcsp.mcsp.client.model.Ztz99aSandModel;

public class Ztz99aSandEntity extends GeoVehicleEntity {

    public Ztz99aSandEntity(EntityType<Ztz99aSandEntity> type, Level world) {
        super(type, world);
    }

    @Override
    public int getTrackAnimationLength() {
        return Ztz99aSandModel.TRACK_COUNT * 2;
    }
}
