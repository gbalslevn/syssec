package androidx.collection;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u001c\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"E", "element1", "Landroidx/collection/MutableObjectList;", "mutableObjectListOf", "(Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "EmptyArray", "[Ljava/lang/Object;", "Landroidx/collection/ObjectList;", "EmptyObjectList", "Landroidx/collection/ObjectList;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ObjectListKt {
    private static final Object[] EmptyArray = new Object[0];
    private static final ObjectList<Object> EmptyObjectList = new MutableObjectList(0);

    public static final /* synthetic */ Object[] access$getEmptyArray$p() {
        return EmptyArray;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E e5) {
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(1);
        mutableObjectList.add(e5);
        return mutableObjectList;
    }
}
