package kotlin.collections.builders;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0005\u001a=\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b*\n\u0012\u0006\b\u0001\u0012\u0002H\b0\u00012\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\fH\u0002¢\u0006\u0002\u0010\r\u001a-\u0010\u000e\u001a\u00020\u0004\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00012\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u000f\u001a9\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00012\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0002¢\u0006\u0002\u0010\u0014\u001a+\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00012\u0006\u0010\u0016\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0017\u001a%\u0010\u0018\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u001b\u001a-\u0010\u001c\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u001f¨\u0006 "}, d2 = {"arrayOfUninitializedElements", BuildConfig.FLAVOR, "E", "size", BuildConfig.FLAVOR, "(I)[Ljava/lang/Object;", "subarrayContentToString", BuildConfig.FLAVOR, "T", "offset", "length", "thisCollection", BuildConfig.FLAVOR, "([Ljava/lang/Object;IILjava/util/Collection;)Ljava/lang/String;", "subarrayContentHashCode", "([Ljava/lang/Object;II)I", "subarrayContentEquals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "([Ljava/lang/Object;IILjava/util/List;)Z", "copyOfUninitializedElements", "newSize", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "resetAt", BuildConfig.FLAVOR, "index", "([Ljava/lang/Object;I)V", "resetRange", "fromIndex", "toIndex", "([Ljava/lang/Object;II)V", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ListBuilderKt {
    public static final <E> E[] arrayOfUninitializedElements(int i5) {
        if (i5 >= 0) {
            return (E[]) new Object[i5];
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }

    public static final <T> T[] copyOfUninitializedElements(T[] tArr, int i5) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i5);
        Intrinsics.checkNotNullExpressionValue(tArr2, "copyOf(...)");
        return tArr2;
    }

    public static final <E> void resetAt(E[] eArr, int i5) {
        Intrinsics.checkNotNullParameter(eArr, "<this>");
        eArr[i5] = null;
    }

    public static final <E> void resetRange(E[] eArr, int i5, int i6) {
        Intrinsics.checkNotNullParameter(eArr, "<this>");
        while (i5 < i6) {
            resetAt(eArr, i5);
            i5++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> boolean subarrayContentEquals(T[] tArr, int i5, int i6, List<?> list) {
        if (i6 != list.size()) {
            return false;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            if (!Intrinsics.areEqual(tArr[i5 + i7], list.get(i7))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> int subarrayContentHashCode(T[] tArr, int i5, int i6) {
        int i7 = 1;
        for (int i8 = 0; i8 < i6; i8++) {
            T t5 = tArr[i5 + i8];
            i7 = (i7 * 31) + (t5 != null ? t5.hashCode() : 0);
        }
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> String subarrayContentToString(T[] tArr, int i5, int i6, Collection<? extends T> collection) {
        StringBuilder sb = new StringBuilder((i6 * 3) + 2);
        sb.append("[");
        for (int i7 = 0; i7 < i6; i7++) {
            if (i7 > 0) {
                sb.append(", ");
            }
            T t5 = tArr[i5 + i7];
            if (t5 == collection) {
                sb.append("(this Collection)");
            } else {
                sb.append(t5);
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
