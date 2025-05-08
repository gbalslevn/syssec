package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000f\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\b\u0003\u001a/\u0010\u0004\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a#\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010\b\u001a\u00020\u0007\"\u00020\u0006H\u0007¢\u0006\u0004\b\u0004\u0010\t¨\u0006\n"}, d2 = {BuildConfig.FLAVOR, "T", "a", "b", "maxOf", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "other", "(I[I)I", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
/* loaded from: classes2.dex */
public abstract class ComparisonsKt___ComparisonsJvmKt extends ComparisonsKt__ComparisonsKt {
    public static <T extends Comparable<? super T>> T maxOf(T a5, T b5) {
        Intrinsics.checkNotNullParameter(a5, "a");
        Intrinsics.checkNotNullParameter(b5, "b");
        return a5.compareTo(b5) >= 0 ? a5 : b5;
    }

    public static int maxOf(int i5, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i6 : other) {
            i5 = Math.max(i5, i6);
        }
        return i5;
    }
}
