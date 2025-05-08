package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u001c\u0010\u0017\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u000b\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/ThreadState;", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lkotlinx/coroutines/CompletionHandler;", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Lkotlinx/coroutines/Job;)V", BuildConfig.FLAVOR, "state", BuildConfig.FLAVOR, "invalidState", "(I)Ljava/lang/Void;", "setup", "()V", "clearInterrupt", "cause", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/Job;", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "targetThread", "Ljava/lang/Thread;", "Lkotlinx/coroutines/DisposableHandle;", "cancelHandle", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/atomicfu/AtomicInt;", "_state", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
final class ThreadState implements Function1<Throwable, Unit> {
    private static final AtomicIntegerFieldUpdater _state$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadState.class, "_state");
    private volatile int _state;
    private DisposableHandle cancelHandle;
    private final Job job;
    private final Thread targetThread = Thread.currentThread();

    public ThreadState(Job job) {
        this.job = job;
    }

    private final Void invalidState(int state) {
        throw new IllegalStateException(("Illegal state " + state).toString());
    }

    public final void clearInterrupt() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _state$FU;
        while (true) {
            int i5 = atomicIntegerFieldUpdater.get(this);
            if (i5 != 0) {
                if (i5 != 2) {
                    if (i5 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        invalidState(i5);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (_state$FU.compareAndSet(this, i5, 1)) {
                DisposableHandle disposableHandle = this.cancelHandle;
                if (disposableHandle != null) {
                    disposableHandle.dispose();
                    return;
                }
                return;
            }
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    public final void setup() {
        int i5;
        this.cancelHandle = this.job.invokeOnCompletion(true, true, this);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _state$FU;
        do {
            i5 = atomicIntegerFieldUpdater.get(this);
            if (i5 != 0) {
                if (i5 == 2 || i5 == 3) {
                    return;
                }
                invalidState(i5);
                throw new KotlinNothingValueException();
            }
        } while (!_state$FU.compareAndSet(this, i5, 0));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(Throwable cause) {
        int i5;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = _state$FU;
        do {
            i5 = atomicIntegerFieldUpdater2.get(this);
            if (i5 != 0) {
                if (i5 == 1 || i5 == 2 || i5 == 3) {
                    return;
                }
                invalidState(i5);
                throw new KotlinNothingValueException();
            }
            atomicIntegerFieldUpdater = _state$FU;
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i5, 2));
        this.targetThread.interrupt();
        atomicIntegerFieldUpdater.set(this, 3);
    }
}
