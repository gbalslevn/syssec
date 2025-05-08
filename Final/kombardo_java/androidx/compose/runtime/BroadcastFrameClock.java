package androidx.compose.runtime;

import androidx.compose.runtime.MonotonicFrameClock;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001&B\u0019\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ*\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\u0010H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R \u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0011\u0010%\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Landroidx/compose/runtime/BroadcastFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onNewAwaiters", "<init>", "(Lkotlin/jvm/functions/Function0;)V", BuildConfig.FLAVOR, "cause", "fail", "(Ljava/lang/Throwable;)V", BuildConfig.FLAVOR, "timeNanos", "sendFrame", "(J)V", "R", "Lkotlin/Function1;", "onFrame", "withFrameNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/jvm/functions/Function0;", BuildConfig.FLAVOR, "lock", "Ljava/lang/Object;", "failureCause", "Ljava/lang/Throwable;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter;", "awaiters", "Ljava/util/List;", "spareList", "Landroidx/compose/runtime/AtomicInt;", "hasAwaitersUnlocked", "Landroidx/compose/runtime/AtomicInt;", BuildConfig.FLAVOR, "getHasAwaiters", "()Z", "hasAwaiters", "FrameAwaiter", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BroadcastFrameClock implements MonotonicFrameClock {
    private Throwable failureCause;
    private final Function0<Unit> onNewAwaiters;
    private final Object lock = new Object();
    private List<FrameAwaiter<?>> awaiters = new ArrayList();
    private List<FrameAwaiter<?>> spareList = new ArrayList();
    private final AtomicInt hasAwaitersUnlocked = new AtomicInt(0);

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter;", "R", BuildConfig.FLAVOR, "Lkotlin/Function1;", BuildConfig.FLAVOR, "onFrame", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "timeNanos", BuildConfig.FLAVOR, "resume", "(J)V", "Lkotlin/jvm/functions/Function1;", "getOnFrame", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/coroutines/Continuation;", "getContinuation", "()Lkotlin/coroutines/Continuation;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class FrameAwaiter<R> {
        private final Continuation<R> continuation;
        private final Function1<Long, R> onFrame;

        /* JADX WARN: Multi-variable type inference failed */
        public FrameAwaiter(Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
            this.onFrame = function1;
            this.continuation = continuation;
        }

        public final Continuation<R> getContinuation() {
            return this.continuation;
        }

        public final void resume(long timeNanos) {
            Object m3567constructorimpl;
            Continuation<R> continuation = this.continuation;
            try {
                Result.Companion companion = Result.INSTANCE;
                m3567constructorimpl = Result.m3567constructorimpl(this.onFrame.invoke(Long.valueOf(timeNanos)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m3567constructorimpl = Result.m3567constructorimpl(ResultKt.createFailure(th));
            }
            continuation.resumeWith(m3567constructorimpl);
        }
    }

    public BroadcastFrameClock(Function0<Unit> function0) {
        this.onNewAwaiters = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fail(Throwable cause) {
        synchronized (this.lock) {
            try {
                if (this.failureCause != null) {
                    return;
                }
                this.failureCause = cause;
                List<FrameAwaiter<?>> list = this.awaiters;
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    Continuation<?> continuation = list.get(i5).getContinuation();
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m3567constructorimpl(ResultKt.createFailure(cause)));
                }
                this.awaiters.clear();
                this.hasAwaitersUnlocked.set(0);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r5, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) MonotonicFrameClock.DefaultImpls.fold(this, r5, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) MonotonicFrameClock.DefaultImpls.get(this, key);
    }

    public final boolean getHasAwaiters() {
        return this.hasAwaitersUnlocked.get() != 0;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return MonotonicFrameClock.DefaultImpls.plus(this, coroutineContext);
    }

    public final void sendFrame(long timeNanos) {
        synchronized (this.lock) {
            try {
                List<FrameAwaiter<?>> list = this.awaiters;
                this.awaiters = this.spareList;
                this.spareList = list;
                this.hasAwaitersUnlocked.set(0);
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    list.get(i5).resume(timeNanos);
                }
                list.clear();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public <R> Object withFrameNanos(Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final FrameAwaiter frameAwaiter = new FrameAwaiter(function1, cancellableContinuationImpl);
        synchronized (this.lock) {
            Throwable th = this.failureCause;
            if (th != null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m3567constructorimpl(ResultKt.createFailure(th)));
            } else {
                boolean isEmpty = this.awaiters.isEmpty();
                this.awaiters.add(frameAwaiter);
                if (isEmpty) {
                    this.hasAwaitersUnlocked.set(1);
                }
                cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.BroadcastFrameClock$withFrameNanos$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                        invoke2(th2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th2) {
                        Object obj = BroadcastFrameClock.this.lock;
                        BroadcastFrameClock broadcastFrameClock = BroadcastFrameClock.this;
                        Object obj2 = frameAwaiter;
                        synchronized (obj) {
                            try {
                                broadcastFrameClock.awaiters.remove(obj2);
                                if (broadcastFrameClock.awaiters.isEmpty()) {
                                    broadcastFrameClock.hasAwaitersUnlocked.set(0);
                                }
                                Unit unit = Unit.INSTANCE;
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                    }
                });
                if (isEmpty && this.onNewAwaiters != null) {
                    try {
                        this.onNewAwaiters.invoke();
                    } catch (Throwable th2) {
                        fail(th2);
                    }
                }
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
