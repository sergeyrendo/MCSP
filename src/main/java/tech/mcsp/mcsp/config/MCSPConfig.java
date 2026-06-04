package tech.mcsp.mcsp.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class MCSPConfig {
    public static final ModConfigSpec COMMON_CONFIG;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        COMMON_CONFIG = builder.build();
    }

    private MCSPConfig() {
    }
}
