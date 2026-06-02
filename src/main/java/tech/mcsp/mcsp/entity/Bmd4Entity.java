package tech.mcsp.mcsp.entity;

import com.atsuishio.superbwarfare.entity.vehicle.base.GeoVehicleEntity;
import com.atsuishio.superbwarfare.entity.vehicle.damage.DamageModifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class Bmd4Entity extends GeoVehicleEntity {

    public Bmd4Entity(EntityType<Bmd4Entity> type, Level world) {
        super(type, world);
    }

//    @Override
//    public DamageModifier getDamageModifier() {
//        return super.getDamageModifier()
//                .custom((source, damage) -> getSourceAngle(source, 0.4f) * damage);
//    }
//
//    @Override
//    public void baseTick() {
//        super.baseTick();
//    }
}
