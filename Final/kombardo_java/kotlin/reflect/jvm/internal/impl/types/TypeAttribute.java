package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.types.TypeAttribute;

/* loaded from: classes3.dex */
public abstract class TypeAttribute<T extends TypeAttribute<? extends T>> {
    public abstract T add(T t5);

    public abstract KClass<? extends T> getKey();

    public abstract T intersect(T t5);
}
