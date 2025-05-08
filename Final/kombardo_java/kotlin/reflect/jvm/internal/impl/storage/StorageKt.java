package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* loaded from: classes3.dex */
public abstract class StorageKt {
    public static final <T> T getValue(NotNullLazyValue<? extends T> notNullLazyValue, Object obj, KProperty<?> p5) {
        Intrinsics.checkNotNullParameter(notNullLazyValue, "<this>");
        Intrinsics.checkNotNullParameter(p5, "p");
        return notNullLazyValue.invoke();
    }

    public static final <T> T getValue(NullableLazyValue<? extends T> nullableLazyValue, Object obj, KProperty<?> p5) {
        Intrinsics.checkNotNullParameter(nullableLazyValue, "<this>");
        Intrinsics.checkNotNullParameter(p5, "p");
        return nullableLazyValue.invoke();
    }
}
