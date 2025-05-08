package com.kizitonwose.calendar.data;

import java.time.DayOfWeek;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ljava/time/DayOfWeek;", "other", BuildConfig.FLAVOR, "daysUntil", "(Ljava/time/DayOfWeek;Ljava/time/DayOfWeek;)I", "data"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ExtensionsKt {
    public static final int daysUntil(DayOfWeek dayOfWeek, DayOfWeek other) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return ((other.ordinal() - dayOfWeek.ordinal()) + 7) % 7;
    }
}
