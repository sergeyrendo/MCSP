package tech.mcsp.mcsp.client.model;

import com.atsuishio.superbwarfare.client.model.entity.VehicleModel;
import com.atsuishio.superbwarfare.entity.vehicle.base.VehicleEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import tech.mcsp.mcsp.entity.Zbd04aSandEntity;

import java.util.regex.Pattern;

public class Zbd04aSandModel extends VehicleModel<Zbd04aSandEntity> {


    @Override
    public boolean hideForTurretControllerWhileZooming() {
        return true;
    }
    public static final int TRACK_COUNT = 84;
    private static final int MAX_IDX = 84;
    private static final float[][] KEYFRAMES = {
            { 175.16f, 17.50f, 57.00f },
            { 143.24f, 16.63f, 59.82f },
            { 108.93f, 14.31f, 61.66f },
            { 74.62f, 11.37f, 61.87f },
            { 40.31f, 8.82f, 60.38f },
            { 25.32f, 7.38f, 57.77f },
            { 25.32f, 6.09f, 55.06f },
            { 25.32f, 4.81f, 52.35f },
            { 25.32f, 3.53f, 49.64f },
            { 25.32f, 2.25f, 46.93f },
            { 22.99f, 0.96f, 44.22f },
            { 0.00f, 0.50f, 41.29f },
            { 0.00f, 0.50f, 38.29f },
            { 0.00f, 0.50f, 35.30f },
            { 0.00f, 0.50f, 32.30f },
            { 0.00f, 0.50f, 29.30f },
            { 0.00f, 0.50f, 26.30f },
            { 0.00f, 0.50f, 23.30f },
            { 0.00f, 0.50f, 20.31f },
            { 0.00f, 0.50f, 17.31f },
            { 0.00f, 0.50f, 14.31f },
            { 0.00f, 0.50f, 11.31f },
            { 0.00f, 0.50f, 8.31f },
            { 0.00f, 0.50f, 5.32f },
            { 0.00f, 0.50f, 2.32f },
            { 0.00f, 0.50f, -0.68f },
            { 0.00f, 0.50f, -3.68f },
            { 0.00f, 0.50f, -6.67f },
            { 0.00f, 0.50f, -9.67f },
            { 0.00f, 0.50f, -12.67f },
            { 0.00f, 0.50f, -15.67f },
            { 0.00f, 0.50f, -18.67f },
            { 0.00f, 0.50f, -21.66f },
            { 0.00f, 0.50f, -24.66f },
            { 0.00f, 0.50f, -27.66f },
            { 0.00f, 0.50f, -30.66f },
            { 0.00f, 0.50f, -33.66f },
            { 0.00f, 0.50f, -36.65f },
            { -15.50f, 0.73f, -39.63f },
            { -26.57f, 1.97f, -42.35f },
            { -26.57f, 3.31f, -45.04f },
            { -26.57f, 4.65f, -47.72f },
            { -26.57f, 5.99f, -50.40f },
            { -29.66f, 7.35f, -53.07f },
            { -58.74f, 9.45f, -55.16f },
            { -88.43f, 12.30f, -55.99f },
            { -118.13f, 15.20f, -55.36f },
            { -147.83f, 17.44f, -53.41f },
            { -172.58f, 18.46f, -50.63f },
            { -174.63f, 18.76f, -47.65f },
            { -173.66f, 19.09f, -44.67f },
            { -173.66f, 19.42f, -41.69f },
            { -173.66f, 19.75f, -38.71f },
            { -173.66f, 20.09f, -35.73f },
            { -175.24f, 20.42f, -32.75f },
            { -178.42f, 20.50f, -29.75f },
            { -180.00f, 20.50f, -26.76f },
            { -180.00f, 20.50f, -23.76f },
            { -180.00f, 20.50f, -20.76f },
            { -180.00f, 20.50f, -17.76f },
            { -180.00f, 20.50f, -14.76f },
            { -180.00f, 20.50f, -11.77f },
            { -180.00f, 20.50f, -8.77f },
            { -180.00f, 20.50f, -5.77f },
            { -180.00f, 20.50f, -2.77f },
            { -180.00f, 20.50f, 0.23f },
            { -180.00f, 20.50f, 3.22f },
            { -180.00f, 20.50f, 6.22f },
            { -180.00f, 20.50f, 9.22f },
            { -180.00f, 20.50f, 12.22f },
            { -180.00f, 20.50f, 15.22f },
            { -180.00f, 20.50f, 18.21f },
            { -180.00f, 20.50f, 21.21f },
            { -180.00f, 20.50f, 24.21f },
            { -180.00f, 20.50f, 27.21f },
            { 178.22f, 20.50f, 30.21f },
            { 174.65f, 20.47f, 33.20f },
            { 172.87f, 20.10f, 36.18f },
            { 172.87f, 19.73f, 39.15f },
            { 172.87f, 19.36f, 42.13f },
            { 172.87f, 18.99f, 45.10f },
            { 172.87f, 18.62f, 48.08f },
            { 172.87f, 18.24f, 51.05f },
            { 172.87f, 17.87f, 54.03f },
            { 175.16f, 17.50f, 57.00f }
    };

    private static final float START_Y = 17.50f;
    private static final float START_Z = 57.00f;

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
            if (diff > 180f)
                p2 -= 360f;
            else if (diff < -180f)
                p2 += 360f;
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

}
