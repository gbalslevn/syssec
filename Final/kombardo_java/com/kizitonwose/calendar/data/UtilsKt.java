package com.kizitonwose.calendar.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\b\u0004\u001a+\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u0006\u0010\u0005\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"checkRange", BuildConfig.FLAVOR, "T", BuildConfig.FLAVOR, "start", "end", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "data"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class UtilsKt {
    public static final <T extends Comparable<? super T>> void checkRange(T start, T end) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        if (end.compareTo(start) >= 0) {
            return;
        }
        throw new IllegalStateException(("start: " + start + " is greater than end: " + end).toString());
    }
}
