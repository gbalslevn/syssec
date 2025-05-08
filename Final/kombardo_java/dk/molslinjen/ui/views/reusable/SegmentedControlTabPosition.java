package dk.molslinjen.ui.views.reusable;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/ui/views/reusable/SegmentedControlTabPosition;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Start", "Middle", "End", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SegmentedControlTabPosition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SegmentedControlTabPosition[] $VALUES;
    public static final SegmentedControlTabPosition Start = new SegmentedControlTabPosition("Start", 0);
    public static final SegmentedControlTabPosition Middle = new SegmentedControlTabPosition("Middle", 1);
    public static final SegmentedControlTabPosition End = new SegmentedControlTabPosition("End", 2);

    private static final /* synthetic */ SegmentedControlTabPosition[] $values() {
        return new SegmentedControlTabPosition[]{Start, Middle, End};
    }

    static {
        SegmentedControlTabPosition[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private SegmentedControlTabPosition(String str, int i5) {
    }

    public static SegmentedControlTabPosition valueOf(String str) {
        return (SegmentedControlTabPosition) Enum.valueOf(SegmentedControlTabPosition.class, str);
    }

    public static SegmentedControlTabPosition[] values() {
        return (SegmentedControlTabPosition[]) $VALUES.clone();
    }
}
