package com.kizitonwose.calendar.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/kizitonwose/calendar/core/DayPosition;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "InDate", "MonthDate", "OutDate", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DayPosition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DayPosition[] $VALUES;
    public static final DayPosition InDate = new DayPosition("InDate", 0);
    public static final DayPosition MonthDate = new DayPosition("MonthDate", 1);
    public static final DayPosition OutDate = new DayPosition("OutDate", 2);

    private static final /* synthetic */ DayPosition[] $values() {
        return new DayPosition[]{InDate, MonthDate, OutDate};
    }

    static {
        DayPosition[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private DayPosition(String str, int i5) {
    }

    public static DayPosition valueOf(String str) {
        return (DayPosition) Enum.valueOf(DayPosition.class, str);
    }

    public static DayPosition[] values() {
        return (DayPosition[]) $VALUES.clone();
    }
}
