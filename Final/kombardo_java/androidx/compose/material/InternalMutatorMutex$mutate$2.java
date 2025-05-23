package androidx.compose.material;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.material.InternalMutatorMutex;
import e.AbstractC0321h;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.InternalMutatorMutex$mutate$2", f = "InternalMutatorMutex.kt", l = {177, 99}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class InternalMutatorMutex$mutate$2<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
    final /* synthetic */ MutatePriority $priority;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ InternalMutatorMutex this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InternalMutatorMutex$mutate$2(MutatePriority mutatePriority, InternalMutatorMutex internalMutatorMutex, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super InternalMutatorMutex$mutate$2> continuation) {
        super(2, continuation);
        this.$priority = mutatePriority;
        this.this$0 = internalMutatorMutex;
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InternalMutatorMutex$mutate$2 internalMutatorMutex$mutate$2 = new InternalMutatorMutex$mutate$2(this.$priority, this.this$0, this.$block, continuation);
        internalMutatorMutex$mutate$2.L$0 = obj;
        return internalMutatorMutex$mutate$2;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [int, kotlinx.coroutines.sync.Mutex] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        Function1<Continuation<? super R>, Object> function1;
        InternalMutatorMutex.Mutator mutator;
        InternalMutatorMutex internalMutatorMutex;
        InternalMutatorMutex.Mutator mutator2;
        Throwable th;
        InternalMutatorMutex internalMutatorMutex2;
        Mutex mutex2;
        AtomicReference atomicReference;
        AtomicReference atomicReference2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r12 = this.label;
        try {
            try {
                if (r12 == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    MutatePriority mutatePriority = this.$priority;
                    CoroutineContext.Element element = coroutineScope.getCoroutineContext().get(Job.INSTANCE);
                    Intrinsics.checkNotNull(element);
                    InternalMutatorMutex.Mutator mutator3 = new InternalMutatorMutex.Mutator(mutatePriority, (Job) element);
                    this.this$0.tryMutateOrCancel(mutator3);
                    mutex = this.this$0.mutex;
                    Function1<Continuation<? super R>, Object> function12 = this.$block;
                    InternalMutatorMutex internalMutatorMutex3 = this.this$0;
                    this.L$0 = mutator3;
                    this.L$1 = mutex;
                    this.L$2 = function12;
                    this.L$3 = internalMutatorMutex3;
                    this.label = 1;
                    if (mutex.lock(null, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function1 = function12;
                    mutator = mutator3;
                    internalMutatorMutex = internalMutatorMutex3;
                } else {
                    if (r12 != 1) {
                        if (r12 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        internalMutatorMutex2 = (InternalMutatorMutex) this.L$2;
                        mutex2 = (Mutex) this.L$1;
                        mutator2 = (InternalMutatorMutex.Mutator) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            atomicReference2 = internalMutatorMutex2.currentMutator;
                            AbstractC0321h.a(atomicReference2, mutator2, null);
                            mutex2.unlock(null);
                            return obj;
                        } catch (Throwable th2) {
                            th = th2;
                            atomicReference = internalMutatorMutex2.currentMutator;
                            AbstractC0321h.a(atomicReference, mutator2, null);
                            throw th;
                        }
                    }
                    internalMutatorMutex = (InternalMutatorMutex) this.L$3;
                    function1 = (Function1) this.L$2;
                    Mutex mutex3 = (Mutex) this.L$1;
                    mutator = (InternalMutatorMutex.Mutator) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    mutex = mutex3;
                }
                this.L$0 = mutator;
                this.L$1 = mutex;
                this.L$2 = internalMutatorMutex;
                this.L$3 = null;
                this.label = 2;
                Object invoke = function1.invoke(this);
                if (invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                internalMutatorMutex2 = internalMutatorMutex;
                mutex2 = mutex;
                obj = invoke;
                mutator2 = mutator;
                atomicReference2 = internalMutatorMutex2.currentMutator;
                AbstractC0321h.a(atomicReference2, mutator2, null);
                mutex2.unlock(null);
                return obj;
            } catch (Throwable th3) {
                mutator2 = mutator;
                th = th3;
                internalMutatorMutex2 = internalMutatorMutex;
                atomicReference = internalMutatorMutex2.currentMutator;
                AbstractC0321h.a(atomicReference, mutator2, null);
                throw th;
            }
        } catch (Throwable th4) {
            r12.unlock(null);
            throw th4;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return ((InternalMutatorMutex$mutate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
