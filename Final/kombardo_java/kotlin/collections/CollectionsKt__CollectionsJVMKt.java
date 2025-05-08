package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0005H\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00052\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0007\u0010\u000b\u001a)\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a1\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u000f\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a3\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00160\u0010\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"T", "element", BuildConfig.FLAVOR, "listOf", "(Ljava/lang/Object;)Ljava/util/List;", "E", BuildConfig.FLAVOR, "createListBuilder", "()Ljava/util/List;", BuildConfig.FLAVOR, "capacity", "(I)Ljava/util/List;", "builder", "build", "(Ljava/util/List;)Ljava/util/List;", "collectionSize", BuildConfig.FLAVOR, "array", "terminateCollectionToArray", "(I[Ljava/lang/Object;)[Ljava/lang/Object;", BuildConfig.FLAVOR, "isVarargs", BuildConfig.FLAVOR, "copyToArrayOfAny", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes2.dex */
public abstract class CollectionsKt__CollectionsJVMKt {
    public static <E> List<E> build(List<E> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return ((ListBuilder) builder).build();
    }

    public static final <T> Object[] copyToArrayOfAny(T[] tArr, boolean z5) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (z5 && Intrinsics.areEqual(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static <E> List<E> createListBuilder() {
        return new ListBuilder(0, 1, null);
    }

    public static <T> List<T> listOf(T t5) {
        List<T> singletonList = Collections.singletonList(t5);
        Intrinsics.checkNotNullExpressionValue(singletonList, "singletonList(...)");
        return singletonList;
    }

    public static <T> T[] terminateCollectionToArray(int i5, T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (i5 < array.length) {
            array[i5] = null;
        }
        return array;
    }

    public static <E> List<E> createListBuilder(int i5) {
        return new ListBuilder(i5);
    }
}
