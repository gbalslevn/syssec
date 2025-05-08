package uniffi.molslinjen_shared;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Luniffi/molslinjen_shared/RustLoggerLevel;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "ERROR", "WARN", "INFO", "DEBUG", "TRACE", "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RustLoggerLevel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RustLoggerLevel[] $VALUES;
    public static final RustLoggerLevel ERROR = new RustLoggerLevel("ERROR", 0);
    public static final RustLoggerLevel WARN = new RustLoggerLevel("WARN", 1);
    public static final RustLoggerLevel INFO = new RustLoggerLevel("INFO", 2);
    public static final RustLoggerLevel DEBUG = new RustLoggerLevel("DEBUG", 3);
    public static final RustLoggerLevel TRACE = new RustLoggerLevel("TRACE", 4);

    private static final /* synthetic */ RustLoggerLevel[] $values() {
        return new RustLoggerLevel[]{ERROR, WARN, INFO, DEBUG, TRACE};
    }

    static {
        RustLoggerLevel[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private RustLoggerLevel(String str, int i5) {
    }

    public static EnumEntries<RustLoggerLevel> getEntries() {
        return $ENTRIES;
    }

    public static RustLoggerLevel valueOf(String str) {
        return (RustLoggerLevel) Enum.valueOf(RustLoggerLevel.class, str);
    }

    public static RustLoggerLevel[] values() {
        return (RustLoggerLevel[]) $VALUES.clone();
    }
}
