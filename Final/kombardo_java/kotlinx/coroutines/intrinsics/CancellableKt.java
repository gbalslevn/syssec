package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u001al\u0010\u000b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\u0005\u001a\u00028\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a%\u0010\u000b\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\t0\u00032\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0000¢\u0006\u0004\b\u000b\u0010\u000e\u001a#\u0010\u0010\u001a\u00020\t2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"R", "T", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "receiver", "completion", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "onCancellation", "startCoroutineCancellable", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function1;)V", "fatalCompletion", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/Continuation;)V", "e", "dispatcherFailure", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class CancellableKt {
    private static final void dispatcherFailure(Continuation<?> continuation, Throwable th) {
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m3567constructorimpl(ResultKt.createFailure(th)));
        throw th;
    }

    public static final <R, T> void startCoroutineCancellable(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r5, Continuation<? super T> continuation, Function1<? super Throwable, Unit> function1) {
        try {
            Continuation intercepted = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function2, r5, continuation));
            Result.Companion companion = Result.INSTANCE;
            DispatchedContinuationKt.resumeCancellableWith(intercepted, Result.m3567constructorimpl(Unit.INSTANCE), function1);
        } catch (Throwable th) {
            dispatcherFailure(continuation, th);
        }
    }

    public static /* synthetic */ void startCoroutineCancellable$default(Function2 function2, Object obj, Continuation continuation, Function1 function1, int i5, Object obj2) {
        if ((i5 & 4) != 0) {
            function1 = null;
        }
        startCoroutineCancellable(function2, obj, continuation, function1);
    }

    public static final void startCoroutineCancellable(Continuation<? super Unit> continuation, Continuation<?> continuation2) {
        try {
            Continuation intercepted = IntrinsicsKt.intercepted(continuation);
            Result.Companion companion = Result.INSTANCE;
            DispatchedContinuationKt.resumeCancellableWith$default(intercepted, Result.m3567constructorimpl(Unit.INSTANCE), null, 2, null);
        } catch (Throwable th) {
            dispatcherFailure(continuation2, th);
        }
    }
}
