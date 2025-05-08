package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\u001a#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\b\"\u001c\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\"\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {BuildConfig.FLAVOR, "collection", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "collectionToArray", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "EMPTY", "[Ljava/lang/Object;", BuildConfig.FLAVOR, "MAX_SIZE", "I", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CollectionToArray {
    private static final Object[] EMPTY = new Object[0];
    private static final int MAX_SIZE = 2147483645;

    @Deprecated
    public static final Object[] toArray(Collection<?> collection, Object[] objArr) {
        Object[] objArr2;
        Intrinsics.checkNotNullParameter(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int i5 = 0;
        if (size == 0) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        if (size <= objArr.length) {
            objArr2 = objArr;
        } else {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr2 = (Object[]) newInstance;
        }
        while (true) {
            int i6 = i5 + 1;
            objArr2[i5] = it.next();
            if (i6 >= objArr2.length) {
                if (!it.hasNext()) {
                    return objArr2;
                }
                int i7 = ((i6 * 3) + 1) >>> 1;
                if (i7 <= i6) {
                    i7 = MAX_SIZE;
                    if (i6 >= MAX_SIZE) {
                        throw new OutOfMemoryError();
                    }
                }
                objArr2 = Arrays.copyOf(objArr2, i7);
            } else if (!it.hasNext()) {
                if (objArr2 == objArr) {
                    objArr[i6] = null;
                    return objArr;
                }
                Object[] copyOf = Arrays.copyOf(objArr2, i6);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                return copyOf;
            }
            i5 = i6;
        }
    }

    @Deprecated
    public static final Object[] toArray(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        int size = collection.size();
        if (size != 0) {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArr = new Object[size];
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    objArr[i5] = it.next();
                    if (i6 >= objArr.length) {
                        if (!it.hasNext()) {
                            return objArr;
                        }
                        int i7 = ((i6 * 3) + 1) >>> 1;
                        if (i7 <= i6) {
                            i7 = MAX_SIZE;
                            if (i6 >= MAX_SIZE) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArr = Arrays.copyOf(objArr, i7);
                    } else if (!it.hasNext()) {
                        Object[] copyOf = Arrays.copyOf(objArr, i6);
                        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                        return copyOf;
                    }
                    i5 = i6;
                }
            }
        }
        return EMPTY;
    }
}
