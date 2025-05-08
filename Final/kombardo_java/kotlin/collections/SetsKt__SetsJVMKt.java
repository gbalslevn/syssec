package kotlin.collections;

import java.util.Collections;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.builders.SetBuilder;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0005H\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00052\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0007\u0010\u000b\u001a)\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0001¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"T", "element", BuildConfig.FLAVOR, "setOf", "(Ljava/lang/Object;)Ljava/util/Set;", "E", BuildConfig.FLAVOR, "createSetBuilder", "()Ljava/util/Set;", BuildConfig.FLAVOR, "capacity", "(I)Ljava/util/Set;", "builder", "build", "(Ljava/util/Set;)Ljava/util/Set;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/SetsKt")
/* loaded from: classes2.dex */
public abstract class SetsKt__SetsJVMKt {
    public static <E> Set<E> build(Set<E> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return ((SetBuilder) builder).build();
    }

    public static <E> Set<E> createSetBuilder() {
        return new SetBuilder();
    }

    public static <T> Set<T> setOf(T t5) {
        Set<T> singleton = Collections.singleton(t5);
        Intrinsics.checkNotNullExpressionValue(singleton, "singleton(...)");
        return singleton;
    }

    public static <E> Set<E> createSetBuilder(int i5) {
        return new SetBuilder(i5);
    }
}
