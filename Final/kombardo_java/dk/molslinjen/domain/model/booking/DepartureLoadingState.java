package dk.molslinjen.domain.model.booking;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/model/booking/DepartureLoadingState;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Loading", "Loaded", "Error", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DepartureLoadingState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DepartureLoadingState[] $VALUES;
    public static final DepartureLoadingState Loading = new DepartureLoadingState("Loading", 0);
    public static final DepartureLoadingState Loaded = new DepartureLoadingState("Loaded", 1);
    public static final DepartureLoadingState Error = new DepartureLoadingState("Error", 2);

    private static final /* synthetic */ DepartureLoadingState[] $values() {
        return new DepartureLoadingState[]{Loading, Loaded, Error};
    }

    static {
        DepartureLoadingState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private DepartureLoadingState(String str, int i5) {
    }

    public static EnumEntries<DepartureLoadingState> getEntries() {
        return $ENTRIES;
    }

    public static DepartureLoadingState valueOf(String str) {
        return (DepartureLoadingState) Enum.valueOf(DepartureLoadingState.class, str);
    }

    public static DepartureLoadingState[] values() {
        return (DepartureLoadingState[]) $VALUES.clone();
    }
}
