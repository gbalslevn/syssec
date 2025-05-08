package com.kizitonwose.calendar.compose;

import com.kizitonwose.calendar.core.OutDateStyle;
import java.time.DayOfWeek;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/kizitonwose/calendar/compose/CalendarInfo;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "indexCount", "Ljava/time/DayOfWeek;", "firstDayOfWeek", "Lcom/kizitonwose/calendar/core/OutDateStyle;", "outDateStyle", "<init>", "(ILjava/time/DayOfWeek;Lcom/kizitonwose/calendar/core/OutDateStyle;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "I", "getIndexCount", "Ljava/time/DayOfWeek;", "Lcom/kizitonwose/calendar/core/OutDateStyle;", "compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CalendarInfo {
    private final DayOfWeek firstDayOfWeek;
    private final int indexCount;
    private final OutDateStyle outDateStyle;

    public CalendarInfo(int i5, DayOfWeek dayOfWeek, OutDateStyle outDateStyle) {
        this.indexCount = i5;
        this.firstDayOfWeek = dayOfWeek;
        this.outDateStyle = outDateStyle;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CalendarInfo)) {
            return false;
        }
        CalendarInfo calendarInfo = (CalendarInfo) other;
        return this.indexCount == calendarInfo.indexCount && this.firstDayOfWeek == calendarInfo.firstDayOfWeek && this.outDateStyle == calendarInfo.outDateStyle;
    }

    public final int getIndexCount() {
        return this.indexCount;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.indexCount) * 31;
        DayOfWeek dayOfWeek = this.firstDayOfWeek;
        int hashCode2 = (hashCode + (dayOfWeek == null ? 0 : dayOfWeek.hashCode())) * 31;
        OutDateStyle outDateStyle = this.outDateStyle;
        return hashCode2 + (outDateStyle != null ? outDateStyle.hashCode() : 0);
    }

    public String toString() {
        return "CalendarInfo(indexCount=" + this.indexCount + ", firstDayOfWeek=" + this.firstDayOfWeek + ", outDateStyle=" + this.outDateStyle + ")";
    }

    public /* synthetic */ CalendarInfo(int i5, DayOfWeek dayOfWeek, OutDateStyle outDateStyle, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5, (i6 & 2) != 0 ? null : dayOfWeek, (i6 & 4) != 0 ? null : outDateStyle);
    }
}
