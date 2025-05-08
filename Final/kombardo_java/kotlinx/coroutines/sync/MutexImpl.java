package kotlinx.coroutines.sync;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\"B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0082@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017RD\u0010\u001d\u001a2\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\f0\u001a0\u0018j\u0002`\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0013\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070!8\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Mutex;", BuildConfig.FLAVOR, "locked", "<init>", "(Z)V", BuildConfig.FLAVOR, "owner", BuildConfig.FLAVOR, "holdsLockImpl", "(Ljava/lang/Object;)I", BuildConfig.FLAVOR, "lockSuspend", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryLockImpl", "lock", "tryLock", "(Ljava/lang/Object;)Z", "unlock", "(Ljava/lang/Object;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/Function1;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "onSelectCancellationUnlockConstructor", "Lkotlin/jvm/functions/Function3;", "isLocked", "()Z", "Lkotlinx/atomicfu/AtomicRef;", "CancellableContinuationWithOwner", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public class MutexImpl extends SemaphoreImpl implements Mutex {
    private static final AtomicReferenceFieldUpdater owner$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner");
    private final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onSelectCancellationUnlockConstructor;
    private volatile Object owner;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0097\u0001¢\u0006\u0004\b\u0010\u0010\u0011J*\u0010\u0015\u001a\u00020\u00022\u0018\u0010\u0014\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00020\u0012j\u0002`\u0013H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0019\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0011J\u001c\u0010\u001c\u001a\u00020\u0002*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0002H\u0097\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ$\u0010\u0015\u001a\u00020\u00022\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010!\u001a\u00020 H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\"J9\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\u00062\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012H\u0016¢\u0006\u0004\b%\u0010&J-\u0010'\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012H\u0016¢\u0006\u0004\b'\u0010(R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010)R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010*R\u0014\u0010.\u001a\u00020+8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020\f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u00020\f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u00100\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner;", "Lkotlinx/coroutines/CancellableContinuation;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/Waiter;", "Lkotlinx/coroutines/CancellableContinuationImpl;", "cont", BuildConfig.FLAVOR, "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Lkotlinx/coroutines/CancellableContinuationImpl;Ljava/lang/Object;)V", BuildConfig.FLAVOR, "cause", BuildConfig.FLAVOR, "cancel", "(Ljava/lang/Throwable;)Z", "token", "completeResume", "(Ljava/lang/Object;)V", "Lkotlin/Function1;", "Lkotlinx/coroutines/CompletionHandler;", "handler", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Result;", "result", "resumeWith", "Lkotlinx/coroutines/CoroutineDispatcher;", "value", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/Unit;)V", "Lkotlinx/coroutines/internal/Segment;", "segment", BuildConfig.FLAVOR, "index", "(Lkotlinx/coroutines/internal/Segment;I)V", "idempotent", "onCancellation", "tryResume", "(Lkotlin/Unit;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "resume", "(Lkotlin/Unit;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CancellableContinuationImpl;", "Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "isActive", "()Z", "isCompleted", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class CancellableContinuationWithOwner implements CancellableContinuation<Unit>, Waiter {
        public final CancellableContinuationImpl<Unit> cont;
        public final Object owner;

        /* JADX WARN: Multi-variable type inference failed */
        public CancellableContinuationWithOwner(CancellableContinuationImpl<? super Unit> cancellableContinuationImpl, Object obj) {
            this.cont = cancellableContinuationImpl;
            this.owner = obj;
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean cancel(Throwable cause) {
            return this.cont.cancel(cause);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void completeResume(Object token) {
            this.cont.completeResume(token);
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.cont.getContext();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void invokeOnCancellation(Function1<? super Throwable, Unit> handler) {
            this.cont.invokeOnCancellation(handler);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean isActive() {
            return this.cont.isActive();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public boolean isCompleted() {
            return this.cont.isCompleted();
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public /* bridge */ /* synthetic */ void resume(Unit unit, Function1 function1) {
            resume2(unit, (Function1<? super Throwable, Unit>) function1);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, Unit unit) {
            this.cont.resumeUndispatched(coroutineDispatcher, unit);
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object result) {
            this.cont.resumeWith(result);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public /* bridge */ /* synthetic */ Object tryResume(Unit unit, Object obj, Function1 function1) {
            return tryResume2(unit, obj, (Function1<? super Throwable, Unit>) function1);
        }

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(Segment<?> segment, int index) {
            this.cont.invokeOnCancellation(segment, index);
        }

        /* renamed from: resume, reason: avoid collision after fix types in other method */
        public void resume2(Unit value, Function1<? super Throwable, Unit> onCancellation) {
            MutexImpl.owner$FU.set(MutexImpl.this, this.owner);
            CancellableContinuationImpl<Unit> cancellableContinuationImpl = this.cont;
            final MutexImpl mutexImpl = MutexImpl.this;
            cancellableContinuationImpl.resume(value, new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$CancellableContinuationWithOwner$resume$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    MutexImpl.this.unlock(this.owner);
                }
            });
        }

        /* renamed from: tryResume, reason: avoid collision after fix types in other method */
        public Object tryResume2(Unit value, Object idempotent, Function1<? super Throwable, Unit> onCancellation) {
            final MutexImpl mutexImpl = MutexImpl.this;
            Object tryResume = this.cont.tryResume(value, idempotent, new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$CancellableContinuationWithOwner$tryResume$token$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    MutexImpl.owner$FU.set(MutexImpl.this, this.owner);
                    MutexImpl.this.unlock(this.owner);
                }
            });
            if (tryResume != null) {
                MutexImpl.owner$FU.set(MutexImpl.this, this.owner);
            }
            return tryResume;
        }
    }

    public MutexImpl(boolean z5) {
        super(1, z5 ? 1 : 0);
        this.owner = z5 ? null : MutexKt.NO_OWNER;
        this.onSelectCancellationUnlockConstructor = new Function3<SelectInstance<?>, Object, Object, Function1<? super Throwable, ? extends Unit>>() { // from class: kotlinx.coroutines.sync.MutexImpl$onSelectCancellationUnlockConstructor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Function1<Throwable, Unit> invoke(SelectInstance<?> selectInstance, final Object obj, Object obj2) {
                final MutexImpl mutexImpl = MutexImpl.this;
                return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$onSelectCancellationUnlockConstructor$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        MutexImpl.this.unlock(obj);
                    }
                };
            }
        };
    }

    private final int holdsLockImpl(Object owner) {
        Symbol symbol;
        while (isLocked()) {
            Object obj = owner$FU.get(this);
            symbol = MutexKt.NO_OWNER;
            if (obj != symbol) {
                return obj == owner ? 1 : 2;
            }
        }
        return 0;
    }

    static /* synthetic */ Object lock$suspendImpl(MutexImpl mutexImpl, Object obj, Continuation<? super Unit> continuation) {
        Object lockSuspend;
        return (!mutexImpl.tryLock(obj) && (lockSuspend = mutexImpl.lockSuspend(obj, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? lockSuspend : Unit.INSTANCE;
    }

    private final Object lockSuspend(Object obj, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            acquire((CancellableContinuation<? super Unit>) new CancellableContinuationWithOwner(orCreateCancellableContinuation, obj));
            Object result = orCreateCancellableContinuation.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    private final int tryLockImpl(Object owner) {
        while (!tryAcquire()) {
            if (owner == null) {
                return 1;
            }
            int holdsLockImpl = holdsLockImpl(owner);
            if (holdsLockImpl == 1) {
                return 2;
            }
            if (holdsLockImpl == 2) {
                return 1;
            }
        }
        owner$FU.set(this, owner);
        return 0;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean isLocked() {
        return getAvailablePermits() == 0;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public Object lock(Object obj, Continuation<? super Unit> continuation) {
        return lock$suspendImpl(this, obj, continuation);
    }

    public String toString() {
        return "Mutex@" + DebugStringsKt.getHexAddress(this) + "[isLocked=" + isLocked() + ",owner=" + owner$FU.get(this) + ']';
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean tryLock(Object owner) {
        int tryLockImpl = tryLockImpl(owner);
        if (tryLockImpl == 0) {
            return true;
        }
        if (tryLockImpl == 1) {
            return false;
        }
        if (tryLockImpl != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + owner).toString());
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public void unlock(Object owner) {
        Symbol symbol;
        Symbol symbol2;
        while (isLocked()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = owner$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            symbol = MutexKt.NO_OWNER;
            if (obj != symbol) {
                if (obj != owner && owner != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj + ", but " + owner + " is expected").toString());
                }
                symbol2 = MutexKt.NO_OWNER;
                if (a.a(atomicReferenceFieldUpdater, this, obj, symbol2)) {
                    release();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }
}
