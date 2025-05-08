package uniffi.molslinjen_shared;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Luniffi/molslinjen_shared/BuildConfiguration;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "DEVELOPMENT", "TEST", "PROD_TEST", "PRODUCTION", "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BuildConfiguration {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BuildConfiguration[] $VALUES;
    public static final BuildConfiguration DEVELOPMENT = new BuildConfiguration("DEVELOPMENT", 0);
    public static final BuildConfiguration TEST = new BuildConfiguration("TEST", 1);
    public static final BuildConfiguration PROD_TEST = new BuildConfiguration("PROD_TEST", 2);
    public static final BuildConfiguration PRODUCTION = new BuildConfiguration("PRODUCTION", 3);

    private static final /* synthetic */ BuildConfiguration[] $values() {
        return new BuildConfiguration[]{DEVELOPMENT, TEST, PROD_TEST, PRODUCTION};
    }

    static {
        BuildConfiguration[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private BuildConfiguration(String str, int i5) {
    }

    public static EnumEntries<BuildConfiguration> getEntries() {
        return $ENTRIES;
    }

    public static BuildConfiguration valueOf(String str) {
        return (BuildConfiguration) Enum.valueOf(BuildConfiguration.class, str);
    }

    public static BuildConfiguration[] values() {
        return (BuildConfiguration[]) $VALUES.clone();
    }
}
