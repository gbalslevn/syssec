package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.FlowCollector;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1", f = "SnapshotFlow.kt", l = {148, 152, 174}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T> $block;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(Function0<? extends T> function0, Continuation<? super SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1> continuation) {
        super(2, continuation);
        this.$block = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1 snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = new SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(this.$block, continuation);
        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = obj;
        return snapshotStateKt__SnapshotFlowKt$snapshotFlow$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00e1 A[Catch: all -> 0x0055, TryCatch #1 {all -> 0x0055, blocks: (B:14:0x00dd, B:16:0x00e1, B:20:0x00eb, B:24:0x00f9, B:30:0x010f, B:32:0x0118, B:42:0x0134, B:43:0x0137, B:56:0x0050, B:26:0x0104, B:29:0x010c, B:38:0x0130, B:39:0x0133), top: B:55:0x0050, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f9 A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #1 {all -> 0x0055, blocks: (B:14:0x00dd, B:16:0x00e1, B:20:0x00eb, B:24:0x00f9, B:30:0x010f, B:32:0x0118, B:42:0x0134, B:43:0x0137, B:56:0x0050, B:26:0x0104, B:29:0x010c, B:38:0x0130, B:39:0x0133), top: B:55:0x0050, inners: #2 }] */
    /* JADX WARN: Type inference failed for: r10v1, types: [kotlinx.coroutines.flow.FlowCollector, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v1, types: [kotlinx.coroutines.flow.FlowCollector, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v5 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ObserverHandle observerHandle;
        ?? r10;
        final MutableScatterSet mutableScatterSet;
        Function1<Object, Unit> function1;
        final Channel Channel$default;
        Object invoke;
        ObserverHandle observerHandle2;
        ?? r11;
        MutableScatterSet mutableScatterSet2;
        Function1<Object, Unit> function12;
        Channel channel;
        Object obj2;
        int i5;
        Set set;
        Snapshot takeSnapshot;
        boolean intersects$SnapshotStateKt__SnapshotFlowKt;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = this.label;
        try {
            if (i6 != 0) {
                if (i6 == 1) {
                    invoke = this.L$5;
                    observerHandle = (ObserverHandle) this.L$4;
                    Channel$default = (Channel) this.L$3;
                    function1 = (Function1) this.L$2;
                    mutableScatterSet = (MutableScatterSet) this.L$1;
                    r10 = (FlowCollector) this.L$0;
                } else if (i6 == 2) {
                    i5 = this.I$0;
                    obj2 = this.L$5;
                    observerHandle2 = (ObserverHandle) this.L$4;
                    channel = (Channel) this.L$3;
                    function12 = (Function1) this.L$2;
                    mutableScatterSet2 = (MutableScatterSet) this.L$1;
                    FlowCollector flowCollector = (FlowCollector) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        r11 = flowCollector;
                        set = (Set) obj;
                        do {
                            if (i5 == 0) {
                                intersects$SnapshotStateKt__SnapshotFlowKt = SnapshotStateKt__SnapshotFlowKt.intersects$SnapshotStateKt__SnapshotFlowKt(mutableScatterSet2, set);
                                if (!intersects$SnapshotStateKt__SnapshotFlowKt) {
                                    i5 = 0;
                                    set = (Set) ChannelResult.m3772getOrNullimpl(channel.mo3766tryReceivePtdJZtk());
                                }
                            }
                            i5 = 1;
                            set = (Set) ChannelResult.m3772getOrNullimpl(channel.mo3766tryReceivePtdJZtk());
                        } while (set != null);
                        if (i5 != 0) {
                            try {
                                mutableScatterSet2.clear();
                                takeSnapshot = Snapshot.INSTANCE.takeSnapshot(function12);
                                Function0<T> function0 = this.$block;
                                try {
                                    invoke = function0.invoke();
                                    takeSnapshot.dispose();
                                    if (!Intrinsics.areEqual(invoke, obj2)) {
                                        this.L$0 = r11;
                                        this.L$1 = mutableScatterSet2;
                                        this.L$2 = function12;
                                        this.L$3 = channel;
                                        this.L$4 = observerHandle2;
                                        this.L$5 = invoke;
                                        this.label = 3;
                                        if (r11.emit(invoke, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        observerHandle = observerHandle2;
                                        Channel$default = channel;
                                        function1 = function12;
                                        mutableScatterSet = mutableScatterSet2;
                                        r10 = r11;
                                    }
                                } finally {
                                }
                            } finally {
                            }
                            Snapshot makeCurrent = takeSnapshot.makeCurrent();
                        }
                        invoke = obj2;
                        observerHandle = observerHandle2;
                        Channel$default = channel;
                        function1 = function12;
                        mutableScatterSet = mutableScatterSet2;
                        r10 = r11;
                    } catch (Throwable th) {
                        th = th;
                        observerHandle = observerHandle2;
                        observerHandle.dispose();
                        throw th;
                    }
                } else {
                    if (i6 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    invoke = this.L$5;
                    observerHandle = (ObserverHandle) this.L$4;
                    Channel$default = (Channel) this.L$3;
                    function1 = (Function1) this.L$2;
                    mutableScatterSet = (MutableScatterSet) this.L$1;
                    r10 = (FlowCollector) this.L$0;
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                r10 = (FlowCollector) this.L$0;
                mutableScatterSet = new MutableScatterSet(0, 1, null);
                function1 = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj3) {
                        invoke2(obj3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object obj3) {
                        if (obj3 instanceof StateObjectImpl) {
                            ((StateObjectImpl) obj3).m1250recordReadInh_f27i8$runtime_release(ReaderKind.m1248constructorimpl(4));
                        }
                        mutableScatterSet.add(obj3);
                    }
                };
                Channel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
                Snapshot.Companion companion = Snapshot.INSTANCE;
                observerHandle = companion.registerApplyObserver(new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set2, Snapshot snapshot) {
                        invoke2(set2, snapshot);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Set<? extends Object> set2, Snapshot snapshot) {
                        if (set2 instanceof ScatterSetWrapper) {
                            ScatterSet set$runtime_release = ((ScatterSetWrapper) set2).getSet$runtime_release();
                            Object[] objArr = set$runtime_release.elements;
                            long[] jArr = set$runtime_release.metadata;
                            int length = jArr.length - 2;
                            if (length >= 0) {
                                int i7 = 0;
                                loop0: while (true) {
                                    long j5 = jArr[i7];
                                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i8 = 8 - ((~(i7 - length)) >>> 31);
                                        for (int i9 = 0; i9 < i8; i9++) {
                                            if ((255 & j5) < 128) {
                                                Object obj3 = objArr[(i7 << 3) + i9];
                                                if (!(obj3 instanceof StateObjectImpl) || ((StateObjectImpl) obj3).m1249isReadInh_f27i8$runtime_release(ReaderKind.m1248constructorimpl(4))) {
                                                    break loop0;
                                                }
                                            }
                                            j5 >>= 8;
                                        }
                                        if (i8 != 8) {
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
                        }
                        Set<? extends Object> set3 = set2;
                        if (!(set3 instanceof Collection) || !set3.isEmpty()) {
                            for (Object obj4 : set3) {
                                if ((obj4 instanceof StateObjectImpl) && !((StateObjectImpl) obj4).m1249isReadInh_f27i8$runtime_release(ReaderKind.m1248constructorimpl(4))) {
                                }
                                Channel$default.mo3767trySendJP2dKIU(set2);
                                return;
                            }
                        }
                    }
                });
                Snapshot takeSnapshot2 = companion.takeSnapshot(function1);
                Function0<T> function02 = this.$block;
                try {
                    Snapshot makeCurrent2 = takeSnapshot2.makeCurrent();
                    try {
                        invoke = function02.invoke();
                        takeSnapshot2.dispose();
                        this.L$0 = r10;
                        this.L$1 = mutableScatterSet;
                        this.L$2 = function1;
                        this.L$3 = Channel$default;
                        this.L$4 = observerHandle;
                        this.L$5 = invoke;
                        this.label = 1;
                        if (r10.emit(invoke, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } finally {
                    }
                } finally {
                }
            }
            this.L$0 = r10;
            this.L$1 = mutableScatterSet;
            this.L$2 = function1;
            this.L$3 = Channel$default;
            this.L$4 = observerHandle;
            this.L$5 = invoke;
            this.I$0 = 0;
            this.label = 2;
            obj = Channel$default.receive(this);
            if (obj != coroutine_suspended) {
                return coroutine_suspended;
            }
            r11 = r10;
            mutableScatterSet2 = mutableScatterSet;
            function12 = function1;
            channel = Channel$default;
            observerHandle2 = observerHandle;
            obj2 = invoke;
            i5 = 0;
            set = (Set) obj;
            do {
                if (i5 == 0) {
                }
                i5 = 1;
                set = (Set) ChannelResult.m3772getOrNullimpl(channel.mo3766tryReceivePtdJZtk());
            } while (set != null);
            if (i5 != 0) {
            }
            invoke = obj2;
            observerHandle = observerHandle2;
            Channel$default = channel;
            function1 = function12;
            mutableScatterSet = mutableScatterSet2;
            r10 = r11;
            this.L$0 = r10;
            this.L$1 = mutableScatterSet;
            this.L$2 = function1;
            this.L$3 = Channel$default;
            this.L$4 = observerHandle;
            this.L$5 = invoke;
            this.I$0 = 0;
            this.label = 2;
            obj = Channel$default.receive(this);
            if (obj != coroutine_suspended) {
            }
        } catch (Throwable th2) {
            th = th2;
            observerHandle.dispose();
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return ((SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
