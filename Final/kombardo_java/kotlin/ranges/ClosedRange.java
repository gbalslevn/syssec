package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\bf\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003R\u0014\u0010\u0006\u001a\u00028\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u00028\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\t"}, d2 = {"Lkotlin/ranges/ClosedRange;", BuildConfig.FLAVOR, "T", BuildConfig.FLAVOR, "getStart", "()Ljava/lang/Comparable;", "start", "getEndInclusive", "endInclusive", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ClosedRange<T extends Comparable<? super T>> {
    T getEndInclusive();

    T getStart();
}
