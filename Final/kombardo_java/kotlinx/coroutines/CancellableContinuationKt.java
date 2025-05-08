package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a)\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\n\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"T", "Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/CancellableContinuationImpl;", "getOrCreateCancellableContinuation", "(Lkotlin/coroutines/Continuation;)Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/DisposableHandle;", "handle", BuildConfig.FLAVOR, "disposeOnCancellation", "(Lkotlinx/coroutines/CancellableContinuation;Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class CancellableContinuationKt {
    public static final void disposeOnCancellation(CancellableContinuation<?> cancellableContinuation, DisposableHandle disposableHandle) {
        cancellableContinuation.invokeOnCancellation(new DisposeOnCancel(disposableHandle));
    }

    public static final <T> CancellableContinuationImpl<T> getOrCreateCancellableContinuation(Continuation<? super T> continuation) {
        if (!(continuation instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl<>(continuation, 1);
        }
        CancellableContinuationImpl<T> claimReusableCancellableContinuation$kotlinx_coroutines_core = ((DispatchedContinuation) continuation).claimReusableCancellableContinuation$kotlinx_coroutines_core();
        if (claimReusableCancellableContinuation$kotlinx_coroutines_core != null) {
            if (!claimReusableCancellableContinuation$kotlinx_coroutines_core.resetStateReusable()) {
                claimReusableCancellableContinuation$kotlinx_coroutines_core = null;
            }
            if (claimReusableCancellableContinuation$kotlinx_coroutines_core != null) {
                return claimReusableCancellableContinuation$kotlinx_coroutines_core;
            }
        }
        return new CancellableContinuationImpl<>(continuation, 2);
    }
}
