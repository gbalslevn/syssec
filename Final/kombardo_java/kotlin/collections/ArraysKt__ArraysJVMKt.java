package kotlin.collections;

import java.lang.reflect.Array;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a1\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\t\u0010\n\u001a#\u0010\r\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0001H\u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"T", BuildConfig.FLAVOR, "reference", BuildConfig.FLAVOR, "size", "arrayOfNulls", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "toIndex", BuildConfig.FLAVOR, "copyOfRangeToIndexCheck", "(II)V", "contentDeepHashCode", "([Ljava/lang/Object;)I", "contentDeepHashCodeImpl", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes2.dex */
public abstract class ArraysKt__ArraysJVMKt {
    public static final <T> T[] arrayOfNulls(T[] reference, int i5) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        Object newInstance = Array.newInstance(reference.getClass().getComponentType(), i5);
        Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[]) ((Object[]) newInstance);
    }

    public static <T> int contentDeepHashCode(T[] tArr) {
        return Arrays.deepHashCode(tArr);
    }

    public static final void copyOfRangeToIndexCheck(int i5, int i6) {
        if (i5 <= i6) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i5 + ") is greater than size (" + i6 + ").");
    }
}
