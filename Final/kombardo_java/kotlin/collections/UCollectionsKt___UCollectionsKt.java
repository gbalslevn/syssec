package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\b\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {BuildConfig.FLAVOR, "Lkotlin/ULong;", "Lkotlin/ULongArray;", "toULongArray", "(Ljava/util/Collection;)[J", BuildConfig.FLAVOR, "sumOfULong", "(Ljava/lang/Iterable;)J", "sum", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/UCollectionsKt")
/* loaded from: classes2.dex */
public abstract class UCollectionsKt___UCollectionsKt {
    public static long sumOfULong(Iterable<ULong> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<ULong> it = iterable.iterator();
        long j5 = 0;
        while (it.hasNext()) {
            j5 = ULong.m3622constructorimpl(j5 + it.next().getData());
        }
        return j5;
    }

    public static long[] toULongArray(Collection<ULong> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] m3629constructorimpl = ULongArray.m3629constructorimpl(collection.size());
        Iterator<ULong> it = collection.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            ULongArray.m3640setk8EXiF4(m3629constructorimpl, i5, it.next().getData());
            i5++;
        }
        return m3629constructorimpl;
    }
}
