package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0082\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\u00072\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011JX\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u001eR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001fR\"\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010 R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001eR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010!R\u0011\u0010$\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lkotlinx/coroutines/CompletedContinuation;", BuildConfig.FLAVOR, "result", "Lkotlinx/coroutines/CancelHandler;", "cancelHandler", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "onCancellation", "idempotentResume", "cancelCause", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/CancelHandler;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuationImpl;", "cont", "cause", "invokeHandlers", "(Lkotlinx/coroutines/CancellableContinuationImpl;Ljava/lang/Throwable;)V", "copy", "(Ljava/lang/Object;Lkotlinx/coroutines/CancelHandler;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Throwable;)Lkotlinx/coroutines/CompletedContinuation;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "Lkotlinx/coroutines/CancelHandler;", "Lkotlin/jvm/functions/Function1;", "Ljava/lang/Throwable;", "getCancelled", "()Z", "cancelled", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* data */ class CompletedContinuation {
    public final Throwable cancelCause;
    public final CancelHandler cancelHandler;
    public final Object idempotentResume;
    public final Function1<Throwable, Unit> onCancellation;
    public final Object result;

    /* JADX WARN: Multi-variable type inference failed */
    public CompletedContinuation(Object obj, CancelHandler cancelHandler, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th) {
        this.result = obj;
        this.cancelHandler = cancelHandler;
        this.onCancellation = function1;
        this.idempotentResume = obj2;
        this.cancelCause = th;
    }

    public static /* synthetic */ CompletedContinuation copy$default(CompletedContinuation completedContinuation, Object obj, CancelHandler cancelHandler, Function1 function1, Object obj2, Throwable th, int i5, Object obj3) {
        if ((i5 & 1) != 0) {
            obj = completedContinuation.result;
        }
        if ((i5 & 2) != 0) {
            cancelHandler = completedContinuation.cancelHandler;
        }
        CancelHandler cancelHandler2 = cancelHandler;
        if ((i5 & 4) != 0) {
            function1 = completedContinuation.onCancellation;
        }
        Function1 function12 = function1;
        if ((i5 & 8) != 0) {
            obj2 = completedContinuation.idempotentResume;
        }
        Object obj4 = obj2;
        if ((i5 & 16) != 0) {
            th = completedContinuation.cancelCause;
        }
        return completedContinuation.copy(obj, cancelHandler2, function12, obj4, th);
    }

    public final CompletedContinuation copy(Object result, CancelHandler cancelHandler, Function1<? super Throwable, Unit> onCancellation, Object idempotentResume, Throwable cancelCause) {
        return new CompletedContinuation(result, cancelHandler, onCancellation, idempotentResume, cancelCause);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompletedContinuation)) {
            return false;
        }
        CompletedContinuation completedContinuation = (CompletedContinuation) other;
        return Intrinsics.areEqual(this.result, completedContinuation.result) && Intrinsics.areEqual(this.cancelHandler, completedContinuation.cancelHandler) && Intrinsics.areEqual(this.onCancellation, completedContinuation.onCancellation) && Intrinsics.areEqual(this.idempotentResume, completedContinuation.idempotentResume) && Intrinsics.areEqual(this.cancelCause, completedContinuation.cancelCause);
    }

    public final boolean getCancelled() {
        return this.cancelCause != null;
    }

    public int hashCode() {
        Object obj = this.result;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        CancelHandler cancelHandler = this.cancelHandler;
        int hashCode2 = (hashCode + (cancelHandler == null ? 0 : cancelHandler.hashCode())) * 31;
        Function1<Throwable, Unit> function1 = this.onCancellation;
        int hashCode3 = (hashCode2 + (function1 == null ? 0 : function1.hashCode())) * 31;
        Object obj2 = this.idempotentResume;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.cancelCause;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final void invokeHandlers(CancellableContinuationImpl<?> cont, Throwable cause) {
        CancelHandler cancelHandler = this.cancelHandler;
        if (cancelHandler != null) {
            cont.callCancelHandler(cancelHandler, cause);
        }
        Function1<Throwable, Unit> function1 = this.onCancellation;
        if (function1 != null) {
            cont.callOnCancellation(function1, cause);
        }
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.result + ", cancelHandler=" + this.cancelHandler + ", onCancellation=" + this.onCancellation + ", idempotentResume=" + this.idempotentResume + ", cancelCause=" + this.cancelCause + ')';
    }

    public /* synthetic */ CompletedContinuation(Object obj, CancelHandler cancelHandler, Function1 function1, Object obj2, Throwable th, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i5 & 2) != 0 ? null : cancelHandler, (i5 & 4) != 0 ? null : function1, (i5 & 8) != 0 ? null : obj2, (i5 & 16) != 0 ? null : th);
    }
}
