package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes3.dex */
public abstract class ArrayMap<T> implements Iterable<T>, KMappedMarker {
    public /* synthetic */ ArrayMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract T get(int i5);

    public abstract int getSize();

    @Override // java.lang.Iterable
    public abstract Iterator<T> iterator();

    public abstract void set(int i5, T t5);

    private ArrayMap() {
    }
}
