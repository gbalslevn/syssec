package uniffi.molslinjen_shared;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, d2 = {"Luniffi/molslinjen_shared/FerrySeatType;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "AVAILABLE", "NOT_AVAILABLE", "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FerrySeatType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FerrySeatType[] $VALUES;
    public static final FerrySeatType AVAILABLE = new FerrySeatType("AVAILABLE", 0);
    public static final FerrySeatType NOT_AVAILABLE = new FerrySeatType("NOT_AVAILABLE", 1);

    private static final /* synthetic */ FerrySeatType[] $values() {
        return new FerrySeatType[]{AVAILABLE, NOT_AVAILABLE};
    }

    static {
        FerrySeatType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private FerrySeatType(String str, int i5) {
    }

    public static EnumEntries<FerrySeatType> getEntries() {
        return $ENTRIES;
    }

    public static FerrySeatType valueOf(String str) {
        return (FerrySeatType) Enum.valueOf(FerrySeatType.class, str);
    }

    public static FerrySeatType[] values() {
        return (FerrySeatType[]) $VALUES.clone();
    }
}
