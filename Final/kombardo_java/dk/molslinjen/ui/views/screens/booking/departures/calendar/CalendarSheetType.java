package dk.molslinjen.ui.views.screens.booking.departures.calendar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/calendar/CalendarSheetType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Regular", "LowPrice", "Companion", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CalendarSheetType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CalendarSheetType[] $VALUES;
    public static final CalendarSheetType Regular = new CalendarSheetType("Regular", 0);
    public static final CalendarSheetType LowPrice = new CalendarSheetType("LowPrice", 1);

    private static final /* synthetic */ CalendarSheetType[] $values() {
        return new CalendarSheetType[]{Regular, LowPrice};
    }

    static {
        CalendarSheetType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private CalendarSheetType(String str, int i5) {
    }

    public static CalendarSheetType valueOf(String str) {
        return (CalendarSheetType) Enum.valueOf(CalendarSheetType.class, str);
    }

    public static CalendarSheetType[] values() {
        return (CalendarSheetType[]) $VALUES.clone();
    }
}
