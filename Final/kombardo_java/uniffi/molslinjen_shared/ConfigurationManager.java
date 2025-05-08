package uniffi.molslinjen_shared;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Luniffi/molslinjen_shared/ConfigurationManager;", BuildConfig.FLAVOR, "config", "Luniffi/molslinjen_shared/BuildConfiguration;", "(Luniffi/molslinjen_shared/BuildConfiguration;)V", "getConfig", "()Luniffi/molslinjen_shared/BuildConfiguration;", "setConfig", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ConfigurationManager {
    private BuildConfiguration config;

    public ConfigurationManager(BuildConfiguration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    public static /* synthetic */ ConfigurationManager copy$default(ConfigurationManager configurationManager, BuildConfiguration buildConfiguration, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            buildConfiguration = configurationManager.config;
        }
        return configurationManager.copy(buildConfiguration);
    }

    /* renamed from: component1, reason: from getter */
    public final BuildConfiguration getConfig() {
        return this.config;
    }

    public final ConfigurationManager copy(BuildConfiguration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return new ConfigurationManager(config);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ConfigurationManager) && this.config == ((ConfigurationManager) other).config;
    }

    public final BuildConfiguration getConfig() {
        return this.config;
    }

    public int hashCode() {
        return this.config.hashCode();
    }

    public final void setConfig(BuildConfiguration buildConfiguration) {
        Intrinsics.checkNotNullParameter(buildConfiguration, "<set-?>");
        this.config = buildConfiguration;
    }

    public String toString() {
        return "ConfigurationManager(config=" + this.config + ")";
    }
}
