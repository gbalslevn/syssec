package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u001a'\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a5\u0010\u000b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\r\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0001H\u0002¢\u0006\u0004\b\r\u0010\u000e\"\u0018\u0010\u000f\u001a\u00020\t*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0018\u0010\u0011\u001a\u00020\t*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"T", "Lkotlinx/coroutines/DispatchedTask;", BuildConfig.FLAVOR, "mode", BuildConfig.FLAVOR, "dispatch", "(Lkotlinx/coroutines/DispatchedTask;I)V", "Lkotlin/coroutines/Continuation;", "delegate", BuildConfig.FLAVOR, "undispatched", "resume", "(Lkotlinx/coroutines/DispatchedTask;Lkotlin/coroutines/Continuation;Z)V", "resumeUnconfined", "(Lkotlinx/coroutines/DispatchedTask;)V", "isCancellableMode", "(I)Z", "isReusableMode", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class DispatchedTaskKt {
    public static final <T> void dispatch(DispatchedTask<? super T> dispatchedTask, int i5) {
        Continuation<? super T> delegate$kotlinx_coroutines_core = dispatchedTask.getDelegate$kotlinx_coroutines_core();
        boolean z5 = i5 == 4;
        if (z5 || !(delegate$kotlinx_coroutines_core instanceof DispatchedContinuation) || isCancellableMode(i5) != isCancellableMode(dispatchedTask.resumeMode)) {
            resume(dispatchedTask, delegate$kotlinx_coroutines_core, z5);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) delegate$kotlinx_coroutines_core).dispatcher;
        CoroutineContext context = delegate$kotlinx_coroutines_core.getContext();
        if (coroutineDispatcher.isDispatchNeeded(context)) {
            coroutineDispatcher.dispatch(context, dispatchedTask);
        } else {
            resumeUnconfined(dispatchedTask);
        }
    }

    public static final boolean isCancellableMode(int i5) {
        return i5 == 1 || i5 == 2;
    }

    public static final boolean isReusableMode(int i5) {
        return i5 == 2;
    }

    public static final <T> void resume(DispatchedTask<? super T> dispatchedTask, Continuation<? super T> continuation, boolean z5) {
        Object successfulResult$kotlinx_coroutines_core;
        Object takeState$kotlinx_coroutines_core = dispatchedTask.takeState$kotlinx_coroutines_core();
        Throwable exceptionalResult$kotlinx_coroutines_core = dispatchedTask.getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            Result.Companion companion = Result.INSTANCE;
            successfulResult$kotlinx_coroutines_core = ResultKt.createFailure(exceptionalResult$kotlinx_coroutines_core);
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            successfulResult$kotlinx_coroutines_core = dispatchedTask.getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        }
        Object m3567constructorimpl = Result.m3567constructorimpl(successfulResult$kotlinx_coroutines_core);
        if (!z5) {
            continuation.resumeWith(m3567constructorimpl);
            return;
        }
        Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        Continuation<T> continuation2 = dispatchedContinuation.continuation;
        Object obj = dispatchedContinuation.countOrElement;
        CoroutineContext context = continuation2.getContext();
        Object updateThreadContext = ThreadContextKt.updateThreadContext(context, obj);
        UndispatchedCoroutine<?> updateUndispatchedCompletion = updateThreadContext != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(continuation2, context, updateThreadContext) : null;
        try {
            dispatchedContinuation.continuation.resumeWith(m3567constructorimpl);
            Unit unit = Unit.INSTANCE;
        } finally {
            if (updateUndispatchedCompletion == null || updateUndispatchedCompletion.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        }
    }

    private static final void resumeUnconfined(DispatchedTask<?> dispatchedTask) {
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedTask);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            resume(dispatchedTask, dispatchedTask.getDelegate$kotlinx_coroutines_core(), true);
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
        } finally {
            try {
            } finally {
            }
        }
    }
}
