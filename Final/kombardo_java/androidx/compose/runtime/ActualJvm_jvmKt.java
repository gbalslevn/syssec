package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a%\u0010\n\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u000f\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u000f\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011*\u001e\b\u0000\u0010\u0014\u001a\u0004\b\u0000\u0010\u0012\"\b\u0012\u0004\u0012\u00028\u00000\u00132\b\u0012\u0004\u0012\u00028\u00000\u0013*\f\b\u0000\u0010\u0015\"\u00020\u00002\u00020\u0000¨\u0006\u0016"}, d2 = {BuildConfig.FLAVOR, "instance", BuildConfig.FLAVOR, "identityHashCode", "(Ljava/lang/Object;)I", "Landroidx/compose/runtime/Composer;", "composer", "Lkotlin/Function0;", BuildConfig.FLAVOR, "composable", "invokeComposable", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function2;)V", BuildConfig.FLAVOR, "currentThreadId", "()J", BuildConfig.FLAVOR, "currentThreadName", "()Ljava/lang/String;", "V", "Ljava/util/concurrent/atomic/AtomicReference;", "AtomicReference", "TestOnly", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ActualJvm_jvmKt {
    public static final long currentThreadId() {
        return Thread.currentThread().getId();
    }

    public static final String currentThreadName() {
        return Thread.currentThread().getName();
    }

    public static final int identityHashCode(Object obj) {
        return System.identityHashCode(obj);
    }

    public static final void invokeComposable(Composer composer, Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNull(function2, "null cannot be cast to non-null type kotlin.Function2<androidx.compose.runtime.Composer, kotlin.Int, kotlin.Unit>");
        ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(composer, 1);
    }
}
