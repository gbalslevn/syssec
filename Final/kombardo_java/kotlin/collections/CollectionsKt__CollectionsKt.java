package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\t\u0010\n\u001a-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\f\u0010\n\u001a7\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\rj\b\u0012\u0004\u0012\u00028\u0000`\u000e\"\u0004\b\u0000\u0010\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0000*\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a5\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0000*\u00020\u00112\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0001\"\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0013\u0010\n\u001a%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001aG\u0010\u001b\u001a\u00020\u0018\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0017*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00052\b\u0010\u0012\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001c\u001aE\u0010\u001b\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00180\u001d¢\u0006\u0004\b\u001b\u0010\u001f\u001a'\u0010$\u001a\u00020!2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\"\u0010#\u001a\u000f\u0010%\u001a\u00020!H\u0001¢\u0006\u0004\b%\u0010&\u001a\u000f\u0010'\u001a\u00020!H\u0001¢\u0006\u0004\b'\u0010&\"\u0019\u0010+\u001a\u00020(*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b)\u0010*\"!\u0010.\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00058F¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"T", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "asCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", BuildConfig.FLAVOR, "emptyList", "()Ljava/util/List;", "elements", "listOf", "([Ljava/lang/Object;)Ljava/util/List;", BuildConfig.FLAVOR, "mutableListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "arrayListOf", "([Ljava/lang/Object;)Ljava/util/ArrayList;", BuildConfig.FLAVOR, "element", "listOfNotNull", "(Ljava/lang/Object;)Ljava/util/List;", "optimizeReadOnlyList", "(Ljava/util/List;)Ljava/util/List;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "fromIndex", "toIndex", "binarySearch", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "Lkotlin/Function1;", "comparison", "(Ljava/util/List;IILkotlin/jvm/functions/Function1;)I", "size", BuildConfig.FLAVOR, "rangeCheck$CollectionsKt__CollectionsKt", "(III)V", "rangeCheck", "throwIndexOverflow", "()V", "throwCountOverflow", "Lkotlin/ranges/IntRange;", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "indices", "getLastIndex", "(Ljava/util/List;)I", "lastIndex", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes2.dex */
public abstract class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {
    public static <T> ArrayList<T> arrayListOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(new ArrayAsCollection(elements, true));
    }

    public static final <T> Collection<T> asCollection(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new ArrayAsCollection(tArr, false);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, T t5, int i5, int i6) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), i5, i6);
        int i7 = i6 - 1;
        while (i5 <= i7) {
            int i8 = (i5 + i7) >>> 1;
            int compareValues = ComparisonsKt.compareValues(list.get(i8), t5);
            if (compareValues < 0) {
                i5 = i8 + 1;
            } else {
                if (compareValues <= 0) {
                    return i8;
                }
                i7 = i8 - 1;
            }
        }
        return -(i5 + 1);
    }

    public static /* synthetic */ int binarySearch$default(List list, Comparable comparable, int i5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            i6 = list.size();
        }
        return binarySearch((List<? extends Comparable>) list, comparable, i5, i6);
    }

    public static <T> List<T> emptyList() {
        return EmptyList.INSTANCE;
    }

    public static IntRange getIndices(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new IntRange(0, collection.size() - 1);
    }

    public static <T> int getLastIndex(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.size() - 1;
    }

    public static <T> List<T> listOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length > 0 ? ArraysKt.asList(elements) : CollectionsKt.emptyList();
    }

    public static <T> List<T> listOfNotNull(T t5) {
        return t5 != null ? CollectionsKt.listOf(t5) : CollectionsKt.emptyList();
    }

    public static <T> List<T> mutableListOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new ArrayAsCollection(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : CollectionsKt.listOf(list.get(0)) : CollectionsKt.emptyList();
    }

    private static final void rangeCheck$CollectionsKt__CollectionsKt(int i5, int i6, int i7) {
        if (i6 > i7) {
            throw new IllegalArgumentException("fromIndex (" + i6 + ") is greater than toIndex (" + i7 + ").");
        }
        if (i6 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i6 + ") is less than zero.");
        }
        if (i7 <= i5) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i7 + ") is greater than size (" + i5 + ").");
    }

    public static void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static /* synthetic */ int binarySearch$default(List list, int i5, int i6, Function1 function1, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i5 = 0;
        }
        if ((i7 & 2) != 0) {
            i6 = list.size();
        }
        return binarySearch(list, i5, i6, function1);
    }

    public static <T> List<T> listOfNotNull(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt.filterNotNull(elements);
    }

    public static final <T> int binarySearch(List<? extends T> list, int i5, int i6, Function1<? super T, Integer> comparison) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(comparison, "comparison");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), i5, i6);
        int i7 = i6 - 1;
        while (i5 <= i7) {
            int i8 = (i5 + i7) >>> 1;
            int intValue = comparison.invoke(list.get(i8)).intValue();
            if (intValue < 0) {
                i5 = i8 + 1;
            } else {
                if (intValue <= 0) {
                    return i8;
                }
                i7 = i8 - 1;
            }
        }
        return -(i5 + 1);
    }
}
