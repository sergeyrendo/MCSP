package tech.mcsp.mcsp.client.model;

import com.atsuishio.superbwarfare.client.model.entity.VehicleModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import tech.mcsp.mcsp.entity.Ztz99aSandEntity;

import java.util.regex.Pattern;

public class Ztz99aSandModel extends VehicleModel<Ztz99aSandEntity> {

    public static final int TRACK_COUNT = 68;
    private static final int MAX_IDX = 68;
    private static final float[][] KEYFRAMES = {
        {178.07f, 22.00f, 56.50f}, {147.52f, 20.89f, 60.27f}, {112.55f, 17.92f, 62.86f},
        {82.57f, 14.03f, 63.43f}, {47.60f, 10.45f, 61.81f}, {25.11f, 8.23f, 58.55f},
        {25.11f, 6.54f, 54.93f}, {25.11f, 4.84f, 51.32f}, {25.11f, 3.15f, 47.71f},
        {25.11f, 1.46f, 44.10f}, {0.52f, 0.50f, 40.28f}, {0.00f, 0.50f, 36.29f},
        {0.00f, 0.50f, 32.30f}, {0.00f, 0.50f, 28.31f}, {0.00f, 0.50f, 24.32f},
        {0.00f, 0.50f, 20.34f}, {0.00f, 0.50f, 16.35f}, {0.00f, 0.50f, 12.36f},
        {0.00f, 0.50f, 8.37f}, {0.00f, 0.50f, 4.39f}, {0.00f, 0.50f, 0.40f},
        {0.00f, 0.50f, -3.59f}, {0.00f, 0.50f, -7.58f}, {0.00f, 0.50f, -11.57f},
        {0.00f, 0.50f, -15.55f}, {0.00f, 0.50f, -19.54f}, {0.00f, 0.50f, -23.53f},
        {0.00f, 0.50f, -27.52f}, {0.00f, 0.50f, -31.51f}, {0.00f, 0.50f, -35.49f},
        {0.00f, 0.50f, -39.48f}, {0.00f, 0.50f, -43.47f}, {-15.00f, 0.78f, -47.43f},
        {-41.36f, 3.05f, -50.64f}, {-41.36f, 5.68f, -53.63f}, {-41.36f, 8.32f, -56.63f},
        {-38.09f, 10.95f, -59.62f}, {-73.00f, 13.85f, -62.22f}, {-117.79f, 17.72f, -61.98f},
        {-162.58f, 20.25f, -59.03f}, {-178.77f, 20.45f, -55.07f}, {178.81f, 20.37f, -51.09f},
        {178.81f, 20.28f, -47.10f}, {178.81f, 20.20f, -43.11f}, {178.81f, 20.12f, -39.12f},
        {179.10f, 20.03f, -35.14f}, {179.70f, 20.00f, -31.15f}, {-180.00f, 20.00f, -27.16f},
        {-180.00f, 20.00f, -23.17f}, {-180.00f, 20.00f, -19.19f}, {-180.00f, 20.00f, -15.20f},
        {-180.00f, 20.00f, -11.21f}, {-180.00f, 20.00f, -7.22f}, {-180.00f, 20.00f, -3.24f},
        {-180.00f, 20.00f, 0.75f}, {-180.00f, 20.00f, 4.74f}, {-180.00f, 20.00f, 8.73f},
        {-180.00f, 20.00f, 12.72f}, {-180.00f, 20.00f, 16.70f}, {-180.00f, 20.00f, 20.69f},
        {-180.00f, 20.00f, 24.68f}, {-180.00f, 20.00f, 28.67f}, {-176.43f, 20.01f, 32.66f},
        {-175.24f, 20.34f, 36.63f}, {-175.24f, 20.68f, 40.60f}, {-175.24f, 21.01f, 44.58f},
        {-175.24f, 21.34f, 48.55f}, {-175.24f, 21.67f, 52.53f}, {178.07f, 22.00f, 56.50f}
    };
    private static final float START_Y = 22.00f;
    private static final float START_Z = 56.50f;

    @Override
    public boolean hideForTurretControllerWhileZooming() {
        return true;
    }

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

}
