package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0004\u001a\u00020\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a9\u0010\t\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u001a\u0010\b\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0006j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {BuildConfig.FLAVOR, "T", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "sort", "(Ljava/util/List;)V", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "sortWith", "(Ljava/util/List;Ljava/util/Comparator;)V", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes2.dex */
public abstract class CollectionsKt__MutableCollectionsJVMKt extends CollectionsKt__IteratorsKt {
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static <T> void sortWith(List<T> list, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
