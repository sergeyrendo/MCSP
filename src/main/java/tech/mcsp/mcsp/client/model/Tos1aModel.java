package tech.mcsp.mcsp.client.model;

import com.atsuishio.superbwarfare.client.model.entity.VehicleModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;
import tech.mcsp.mcsp.entity.Tos1aEntity;

import java.util.regex.Pattern;

import static tech.mcsp.mcsp.entity.Tos1aEntity.LOADED_AMMO;

public class Tos1aModel<T extends Tos1aEntity> extends VehicleModel<T> {

    private ResourceLocation lastModel = null;

    @Override
    public ResourceLocation getModelResource(T vehicle) {
        ResourceLocation model = super.getModelResource(vehicle);
        if (lastModel != null && !lastModel.equals(model)) {
            resetTransformCache();
        }
        lastModel = model;
        return model;
    }

    private void resetTransformCache() {
        setInit(false);
        getTRANSFORMS().clear();
    }

    private static final Pattern SHELL_PATTERN = Pattern.compile("^shell(?<id>\\d+)$");
    private static final Pattern WHEEL_PATTERN = Pattern.compile("^wheel(?<direction>[LR]).*$");

    @Override
    public boolean hideForTurretControllerWhileZooming() {
        return false;
    }

    public static final int TRACK_COUNT = 60;
    private static final int MAX_IDX = 60;
    private static final float[][] KEYFRAMES = {
        {176.94f, 19.50f, 47.00f},
        {143.28f, 18.21f, 50.72f},
        {104.12f, 14.89f, 52.83f},
        {64.95f, 10.97f, 52.44f},
        {31.97f, 8.12f, 49.71f},
        {31.97f, 6.00f, 46.31f},
        {31.97f, 3.87f, 42.91f},
        {31.67f, 1.75f, 39.50f},
        {2.96f, 0.51f, 35.75f},
        {0.00f, 0.50f, 31.74f},
        {0.00f, 0.50f, 27.72f},
        {0.00f, 0.50f, 23.71f},
        {0.00f, 0.50f, 19.70f},
        {0.00f, 0.50f, 15.69f},
        {0.00f, 0.50f, 11.68f},
        {0.00f, 0.50f, 7.67f},
        {0.00f, 0.50f, 3.66f},
        {0.00f, 0.50f, -0.35f},
        {0.00f, 0.50f, -4.36f},
        {0.00f, 0.50f, -8.37f},
        {0.00f, 0.50f, -12.39f},
        {0.00f, 0.50f, -16.40f},
        {0.00f, 0.50f, -20.41f},
        {0.00f, 0.50f, -24.42f},
        {0.00f, 0.50f, -28.43f},
        {0.00f, 0.50f, -32.44f},
        {0.00f, 0.50f, -36.45f},
        {-15.89f, 0.78f, -40.44f},
        {-34.83f, 2.74f, -43.91f},
        {-34.83f, 5.03f, -47.20f},
        {-34.83f, 7.32f, -50.49f},
        {-34.83f, 9.61f, -53.79f},
        {-43.75f, 11.96f, -57.03f},
        {-93.29f, 15.58f, -58.50f},
        {-137.89f, 19.15f, -56.92f},
        {-179.94f, 20.46f, -53.25f},
        {177.31f, 20.29f, -49.24f},
        {177.14f, 20.09f, -45.24f},
        {177.14f, 19.89f, -41.23f},
        {177.14f, 19.69f, -37.23f},
        {179.28f, 19.50f, -33.22f},
        {-180.00f, 19.50f, -29.21f},
        {-180.00f, 19.50f, -25.20f},
        {-180.00f, 19.50f, -21.19f},
        {-180.00f, 19.50f, -17.18f},
        {-180.00f, 19.50f, -13.16f},
        {-180.00f, 19.50f, -9.15f},
        {-180.00f, 19.50f, -5.14f},
        {-180.00f, 19.50f, -1.13f},
        {-180.00f, 19.50f, 2.88f},
        {-180.00f, 19.50f, 6.89f},
        {-180.00f, 19.50f, 10.90f},
        {-180.00f, 19.50f, 14.91f},
        {-180.00f, 19.50f, 18.92f},
        {-180.00f, 19.50f, 22.93f},
        {-180.00f, 19.50f, 26.95f},
        {-180.00f, 19.50f, 30.96f},
        {-180.00f, 19.50f, 34.97f},
        {-180.00f, 19.50f, 38.98f},
        {-180.00f, 19.50f, 42.99f},
        {176.94f, 19.50f, 47.00f}
    };

    private static final float START_Y = 19.50f;
    private static final float START_Z = 47.00f;

    private float getKeyframeValue(float t, int component) {
        int wrapRange = TRACK_COUNT * 2;
        float normalized = (t / wrapRange) * MAX_IDX;
        int idx1 = Mth.clamp((int) normalized, 0, MAX_IDX);
        int idx2 = Mth.clamp(idx1 + 1, 0, MAX_IDX);
        float frac = normalized - (int) normalized;

        float p1 = KEYFRAMES[idx1][component];
        float p2 = KEYFRAMES[idx2][component];

        if (component == 0) {
            float diff = p2 - p1;
            if (diff > 180f) p2 -= 360f;
            else if (diff < -180f) p2 += 360f;
        }

        return Mth.lerp(frac, p1, p2);
    }

    @Override
    public float getBoneRotX(float t) {
        return getKeyframeValue(t, 0);
    }

    @Override
    public float getBoneMoveY(float t) {
        return getKeyframeValue(t, 1) - START_Y;
    }

    @Override
    public float getBoneMoveZ(float t) {
        return getKeyframeValue(t, 2) - START_Z;
    }

    @Override
    public @Nullable TransformContext<T> collectTransform(String boneName) {
        var shellMatcher = SHELL_PATTERN.matcher(boneName);
        if (shellMatcher.matches()) {
            final int shellIndex = Integer.parseInt(shellMatcher.group("id"));
            return (bone, vehicle, state) -> {
                var items = vehicle.getEntityData().get(LOADED_AMMO);
                if (shellIndex < items.size()) {
                    bone.setHidden(items.get(shellIndex) == -1);
                }
            };
        }

        var wheelMatcher = WHEEL_PATTERN.matcher(boneName);
        if (wheelMatcher.matches()) {
            boolean isL = wheelMatcher.group("direction").equals("L");
            if (boneName.endsWith("Turn")) {
                return (bone, vehicle, state) -> {
                    bone.setRotX(1.5f * (isL ? getRightWheelRot() : getLeftWheelRot()));
                    bone.setRotY(Mth.lerp(state.getPartialTick(), vehicle.getRudderRotO(), vehicle.getRudderRot()));
                };
            }
            return (bone, vehicle, state) -> {
                bone.setRotX(1.5f * (isL ? getRightWheelRot() : getLeftWheelRot()));
            };
        }

        return super.collectTransform(boneName);
    }
}
