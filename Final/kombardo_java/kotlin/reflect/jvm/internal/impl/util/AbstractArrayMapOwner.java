package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KClass;

/* loaded from: classes3.dex */
public abstract class AbstractArrayMapOwner<K, V> implements Iterable<V>, KMappedMarker {

    /* loaded from: classes3.dex */
    public static abstract class AbstractArrayMapAccessor<K, V, T extends V> {
        private final int id;

        public AbstractArrayMapAccessor(int i5) {
            this.id = i5;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final T extractValue(AbstractArrayMapOwner<K, V> thisRef) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            return thisRef.getArrayMap().get(this.id);
        }
    }

    protected abstract ArrayMap<V> getArrayMap();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract TypeRegistry<K, V> getTypeRegistry();

    public final boolean isEmpty() {
        return getArrayMap().getSize() == 0;
    }

    @Override // java.lang.Iterable
    public final Iterator<V> iterator() {
        return getArrayMap().iterator();
    }

    protected abstract void registerComponent(String str, V v5);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void registerComponent(KClass<? extends K> tClass, V value) {
        Intrinsics.checkNotNullParameter(tClass, "tClass");
        Intrinsics.checkNotNullParameter(value, "value");
        String qualifiedName = tClass.getQualifiedName();
        Intrinsics.checkNotNull(qualifiedName);
        registerComponent(qualifiedName, (String) value);
    }
}
