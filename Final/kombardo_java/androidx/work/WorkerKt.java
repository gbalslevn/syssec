package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.work.WorkerKt;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"future", "Lcom/google/common/util/concurrent/ListenableFuture;", "T", "Ljava/util/concurrent/Executor;", "block", "Lkotlin/Function0;", "work-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class WorkerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> ListenableFuture<T> future(final Executor executor, final Function0<? extends T> function0) {
        ListenableFuture<T> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: P.h
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                Unit future$lambda$2;
                future$lambda$2 = WorkerKt.future$lambda$2(executor, function0, completer);
                return future$lambda$2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(future, "getFuture {\n        val …        }\n        }\n    }");
        return future;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit future$lambda$2(Executor executor, final Function0 function0, final CallbackToFutureAdapter.Completer it) {
        Intrinsics.checkNotNullParameter(it, "it");
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        it.addCancellationListener(new Runnable() { // from class: P.i
            @Override // java.lang.Runnable
            public final void run() {
                atomicBoolean.set(true);
            }
        }, DirectExecutor.INSTANCE);
        executor.execute(new Runnable() { // from class: P.j
            @Override // java.lang.Runnable
            public final void run() {
                WorkerKt.future$lambda$2$lambda$1(atomicBoolean, it, function0);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void future$lambda$2$lambda$1(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, Function0 function0) {
        if (atomicBoolean.get()) {
            return;
        }
        try {
            completer.set(function0.invoke());
        } catch (Throwable th) {
            completer.setException(th);
        }
    }
}
