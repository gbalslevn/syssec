package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2", f = "Recomposer.kt", l = {1054}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class Recomposer$recompositionRunner$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ MonotonicFrameClock $parentFrameClock;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2$3", f = "Recomposer.kt", l = {1055}, m = "invokeSuspend")
    /* renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2$3, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ MonotonicFrameClock $parentFrameClock;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, MonotonicFrameClock monotonicFrameClock, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$block = function3;
            this.$parentFrameClock = monotonicFrameClock;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$block, this.$parentFrameClock, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> function3 = this.$block;
                MonotonicFrameClock monotonicFrameClock = this.$parentFrameClock;
                this.label = 1;
                if (function3.invoke(coroutineScope, monotonicFrameClock, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Recomposer$recompositionRunner$2(Recomposer recomposer, Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, MonotonicFrameClock monotonicFrameClock, Continuation<? super Recomposer$recompositionRunner$2> continuation) {
        super(2, continuation);
        this.this$0 = recomposer;
        this.$block = function3;
        this.$parentFrameClock = monotonicFrameClock;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Recomposer$recompositionRunner$2 recomposer$recompositionRunner$2 = new Recomposer$recompositionRunner$2(this.this$0, this.$block, this.$parentFrameClock, continuation);
        recomposer$recompositionRunner$2.L$0 = obj;
        return recomposer$recompositionRunner$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Job job;
        Recomposer.RecomposerInfoImpl recomposerInfoImpl;
        ObserverHandle observerHandle;
        Throwable th;
        List knownCompositions;
        Object obj2;
        Job job2;
        Recomposer.RecomposerInfoImpl recomposerInfoImpl2;
        Job job3;
        Recomposer.RecomposerInfoImpl recomposerInfoImpl3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            job = JobKt.getJob(((CoroutineScope) this.L$0).getCoroutineContext());
            this.this$0.registerRunnerJob(job);
            Snapshot.Companion companion = Snapshot.INSTANCE;
            final Recomposer recomposer = this.this$0;
            ObserverHandle registerApplyObserver = companion.registerApplyObserver(new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.Recomposer$recompositionRunner$2$unregisterApplyObserver$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set, Snapshot snapshot) {
                    invoke2(set, snapshot);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Set<? extends Object> set, Snapshot snapshot) {
                    MutableStateFlow mutableStateFlow;
                    CancellableContinuation cancellableContinuation;
                    MutableScatterSet mutableScatterSet;
                    int i6;
                    Object obj3 = Recomposer.this.stateLock;
                    Recomposer recomposer2 = Recomposer.this;
                    synchronized (obj3) {
                        try {
                            mutableStateFlow = recomposer2._state;
                            if (((Recomposer.State) mutableStateFlow.getValue()).compareTo(Recomposer.State.Idle) >= 0) {
                                mutableScatterSet = recomposer2.snapshotInvalidations;
                                if (set instanceof ScatterSetWrapper) {
                                    ScatterSet set$runtime_release = ((ScatterSetWrapper) set).getSet$runtime_release();
                                    Object[] objArr = set$runtime_release.elements;
                                    long[] jArr = set$runtime_release.metadata;
                                    int length = jArr.length - 2;
                                    if (length >= 0) {
                                        int i7 = 0;
                                        while (true) {
                                            long j5 = jArr[i7];
                                            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                int i8 = 8;
                                                int i9 = 8 - ((~(i7 - length)) >>> 31);
                                                int i10 = 0;
                                                while (i10 < i9) {
                                                    if ((255 & j5) < 128) {
                                                        Object obj4 = objArr[(i7 << 3) + i10];
                                                        if (!(obj4 instanceof StateObjectImpl) || ((StateObjectImpl) obj4).m1249isReadInh_f27i8$runtime_release(ReaderKind.m1248constructorimpl(1))) {
                                                            mutableScatterSet.add(obj4);
                                                        }
                                                        i6 = 8;
                                                    } else {
                                                        i6 = i8;
                                                    }
                                                    j5 >>= i6;
                                                    i10++;
                                                    i8 = i6;
                                                }
                                                if (i9 != i8) {
                                                    break;
                                                }
                                            }
                                            if (i7 == length) {
                                                break;
                                            } else {
                                                i7++;
                                            }
                                        }
                                    }
                                } else {
                                    for (Object obj5 : set) {
                                        if (!(obj5 instanceof StateObjectImpl) || ((StateObjectImpl) obj5).m1249isReadInh_f27i8$runtime_release(ReaderKind.m1248constructorimpl(1))) {
                                            mutableScatterSet.add(obj5);
                                        }
                                    }
                                }
                                cancellableContinuation = recomposer2.deriveStateLocked();
                            } else {
                                cancellableContinuation = null;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    if (cancellableContinuation != null) {
                        Result.Companion companion2 = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m3567constructorimpl(Unit.INSTANCE));
                    }
                }
            });
            Recomposer.Companion companion2 = Recomposer.INSTANCE;
            recomposerInfoImpl = this.this$0.recomposerInfo;
            companion2.addRunning(recomposerInfoImpl);
            try {
                Object obj3 = this.this$0.stateLock;
                Recomposer recomposer2 = this.this$0;
                synchronized (obj3) {
                    knownCompositions = recomposer2.getKnownCompositions();
                }
                int size = knownCompositions.size();
                for (int i6 = 0; i6 < size; i6++) {
                    ((ControlledComposition) knownCompositions.get(i6)).invalidateAll();
                }
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$block, this.$parentFrameClock, null);
                this.L$0 = job;
                this.L$1 = registerApplyObserver;
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(anonymousClass3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                observerHandle = registerApplyObserver;
            } catch (Throwable th2) {
                observerHandle = registerApplyObserver;
                th = th2;
                observerHandle.dispose();
                obj2 = this.this$0.stateLock;
                Recomposer recomposer3 = this.this$0;
                synchronized (obj2) {
                    try {
                        job2 = recomposer3.runnerJob;
                        if (job2 == job) {
                            recomposer3.runnerJob = null;
                        }
                        recomposer3.deriveStateLocked();
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                Recomposer.Companion companion3 = Recomposer.INSTANCE;
                recomposerInfoImpl2 = this.this$0.recomposerInfo;
                companion3.removeRunning(recomposerInfoImpl2);
                throw th;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            observerHandle = (ObserverHandle) this.L$1;
            job = (Job) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th4) {
                th = th4;
                observerHandle.dispose();
                obj2 = this.this$0.stateLock;
                Recomposer recomposer32 = this.this$0;
                synchronized (obj2) {
                }
            }
        }
        observerHandle.dispose();
        Object obj4 = this.this$0.stateLock;
        Recomposer recomposer4 = this.this$0;
        synchronized (obj4) {
            try {
                job3 = recomposer4.runnerJob;
                if (job3 == job) {
                    recomposer4.runnerJob = null;
                }
                recomposer4.deriveStateLocked();
            } catch (Throwable th5) {
                throw th5;
            }
        }
        Recomposer.Companion companion4 = Recomposer.INSTANCE;
        recomposerInfoImpl3 = this.this$0.recomposerInfo;
        companion4.removeRunning(recomposerInfoImpl3);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Recomposer$recompositionRunner$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
