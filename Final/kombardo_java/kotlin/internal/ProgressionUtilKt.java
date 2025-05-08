package kotlin.internal;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\f\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {BuildConfig.FLAVOR, "a", "b", "mod", "(II)I", "c", "differenceModulo", "(III)I", "start", "end", "step", "getProgressionLastElement", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProgressionUtilKt {
    private static final int differenceModulo(int i5, int i6, int i7) {
        return mod(mod(i5, i7) - mod(i6, i7), i7);
    }

    public static final int getProgressionLastElement(int i5, int i6, int i7) {
        if (i7 > 0) {
            return i5 >= i6 ? i6 : i6 - differenceModulo(i6, i5, i7);
        }
        if (i7 < 0) {
            return i5 <= i6 ? i6 : i6 + differenceModulo(i5, i6, -i7);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    private static final int mod(int i5, int i6) {
        int i7 = i5 % i6;
        return i7 >= 0 ? i7 : i7 + i6;
    }
}
