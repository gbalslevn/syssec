package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\bH\u0097@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\r\u001a\u00060\u000bj\u0002`\fH\u0017¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0014\u001a\u00020\u00132\u0018\u0010\u0012\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\b0\u000fj\u0002`\u0011H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J9\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0018\u0010\u0012\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\b0\u000fj\u0002`\u0011H\u0017¢\u0006\u0004\b\u0014\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\b2\u000e\u0010\u0019\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0017¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010)\u001a\u0004\u0018\u00010\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0004\u001a\u0004\b&\u0010'R\u001a\u0010*\u001a\u00020\u00058VX\u0097\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0004\u001a\u0004\b*\u0010\u0007R\u001a\u0010,\u001a\u00020\u00058VX\u0097\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0004\u001a\u0004\b,\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lkotlinx/coroutines/NonCancellable;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/Job;", "<init>", "()V", BuildConfig.FLAVOR, "start", "()Z", BuildConfig.FLAVOR, "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "Lkotlin/Function1;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "cause", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "message", "Ljava/lang/String;", "getParent", "()Lkotlinx/coroutines/Job;", "getParent$annotations", "parent", "isActive", "isActive$annotations", "isCancelled", "isCancelled$annotations", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NonCancellable extends AbstractCoroutineContextElement implements Job {
    public static final NonCancellable INSTANCE = new NonCancellable();
    private static final String message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited";

    private NonCancellable() {
        super(Job.INSTANCE);
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated
    public ChildHandle attachChild(ChildJob child) {
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated
    public void cancel(CancellationException cause) {
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated
    public CancellationException getCancellationException() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    public Job getParent() {
        return null;
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated
    public DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> handler) {
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isCancelled() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated
    public Object join(Continuation<? super Unit> continuation) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated
    public boolean start() {
        return false;
    }

    public String toString() {
        return "NonCancellable";
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated
    public DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, Function1<? super Throwable, Unit> handler) {
        return NonDisposableHandle.INSTANCE;
    }
}
