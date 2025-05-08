package androidx.collection;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u001c\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"K", "Landroidx/collection/MutableObjectLongMap;", "mutableObjectLongMapOf", "()Landroidx/collection/MutableObjectLongMap;", BuildConfig.FLAVOR, "EmptyObjectLongMap", "Landroidx/collection/MutableObjectLongMap;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ObjectLongMapKt {
    private static final MutableObjectLongMap<Object> EmptyObjectLongMap = new MutableObjectLongMap<>(0);

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf() {
        return new MutableObjectLongMap<>(0, 1, null);
    }
}
