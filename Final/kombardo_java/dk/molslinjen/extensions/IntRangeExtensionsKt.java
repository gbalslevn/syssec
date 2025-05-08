package dk.molslinjen.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"format", BuildConfig.FLAVOR, "Lkotlin/ranges/IntRange;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class IntRangeExtensionsKt {
    public static final String format(IntRange intRange) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        return intRange.getFirst() + " - " + intRange.getLast();
    }
}
