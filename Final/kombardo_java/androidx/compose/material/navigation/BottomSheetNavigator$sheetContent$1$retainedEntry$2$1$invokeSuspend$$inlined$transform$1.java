package androidx.compose.material.navigation;

import androidx.compose.material.ModalBottomSheetState;
import androidx.navigation.NavBackStackEntry;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.compose.material.navigation.BottomSheetNavigator$sheetContent$1$retainedEntry$2$1$invokeSuspend$$inlined$transform$1", f = "BottomSheetNavigator.kt", l = {40}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class BottomSheetNavigator$sheetContent$1$retainedEntry$2$1$invokeSuspend$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super NavBackStackEntry>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BottomSheetNavigator this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", BuildConfig.FLAVOR, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material.navigation.BottomSheetNavigator$sheetContent$1$retainedEntry$2$1$invokeSuspend$$inlined$transform$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<NavBackStackEntry> $$this$flow;
        final /* synthetic */ BottomSheetNavigator this$0;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material.navigation.BottomSheetNavigator$sheetContent$1$retainedEntry$2$1$invokeSuspend$$inlined$transform$1$1", f = "BottomSheetNavigator.kt", l = {224, 229, 229, 229}, m = "emit")
        /* renamed from: androidx.compose.material.navigation.BottomSheetNavigator$sheetContent$1$retainedEntry$2$1$invokeSuspend$$inlined$transform$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C00221 extends ContinuationImpl {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;

            public C00221(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass1.this.emit(null, this);
            }
        }

        public AnonymousClass1(FlowCollector flowCollector, BottomSheetNavigator bottomSheetNavigator) {
            this.this$0 = bottomSheetNavigator;
            this.$$this$flow = flowCollector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0080 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a7 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0095 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t5, Continuation<? super Unit> continuation) {
            C00221 c00221;
            Object coroutine_suspended;
            int i5;
            FlowCollector flowCollector;
            List list;
            FlowCollector flowCollector2;
            FlowCollector flowCollector3;
            Object lastOrNull;
            Object lastOrNull2;
            Object lastOrNull3;
            if (continuation instanceof C00221) {
                c00221 = (C00221) continuation;
                int i6 = c00221.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    c00221.label = i6 - Integer.MIN_VALUE;
                    Object obj = c00221.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = c00221.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        flowCollector = this.$$this$flow;
                        list = (List) t5;
                        try {
                            ModalBottomSheetState sheetState = this.this$0.getSheetState();
                            c00221.L$0 = list;
                            c00221.L$1 = flowCollector;
                            c00221.label = 1;
                            if (sheetState.hide(c00221) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            flowCollector3 = flowCollector;
                        } catch (CancellationException unused) {
                            flowCollector2 = flowCollector;
                            lastOrNull2 = CollectionsKt.lastOrNull((List<? extends Object>) list);
                            c00221.L$0 = null;
                            c00221.L$1 = null;
                            c00221.label = 3;
                            if (flowCollector2.emit(lastOrNull2, c00221) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th) {
                            th = th;
                            lastOrNull = CollectionsKt.lastOrNull((List<? extends Object>) list);
                            c00221.L$0 = th;
                            c00221.L$1 = null;
                            c00221.label = 4;
                            if (flowCollector.emit(lastOrNull, c00221) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            throw th;
                        }
                    } else {
                        if (i5 != 1) {
                            if (i5 == 2 || i5 == 3) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            if (i5 != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            Throwable th2 = (Throwable) c00221.L$0;
                            ResultKt.throwOnFailure(obj);
                            throw th2;
                        }
                        flowCollector2 = (FlowCollector) c00221.L$1;
                        list = (List) c00221.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            flowCollector3 = flowCollector2;
                        } catch (CancellationException unused2) {
                            lastOrNull2 = CollectionsKt.lastOrNull((List<? extends Object>) list);
                            c00221.L$0 = null;
                            c00221.L$1 = null;
                            c00221.label = 3;
                            if (flowCollector2.emit(lastOrNull2, c00221) == coroutine_suspended) {
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th3) {
                            flowCollector = flowCollector2;
                            th = th3;
                            lastOrNull = CollectionsKt.lastOrNull((List<? extends Object>) list);
                            c00221.L$0 = th;
                            c00221.L$1 = null;
                            c00221.label = 4;
                            if (flowCollector.emit(lastOrNull, c00221) != coroutine_suspended) {
                            }
                        }
                    }
                    lastOrNull3 = CollectionsKt.lastOrNull((List<? extends Object>) list);
                    c00221.L$0 = null;
                    c00221.L$1 = null;
                    c00221.label = 2;
                    if (flowCollector3.emit(lastOrNull3, c00221) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
            }
            c00221 = new C00221(continuation);
            Object obj2 = c00221.result;
            coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i5 = c00221.label;
            if (i5 != 0) {
            }
            lastOrNull3 = CollectionsKt.lastOrNull((List<? extends Object>) list);
            c00221.L$0 = null;
            c00221.L$1 = null;
            c00221.label = 2;
            if (flowCollector3.emit(lastOrNull3, c00221) == coroutine_suspended) {
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetNavigator$sheetContent$1$retainedEntry$2$1$invokeSuspend$$inlined$transform$1(Flow flow, Continuation continuation, BottomSheetNavigator bottomSheetNavigator) {
        super(2, continuation);
        this.$this_transform = flow;
        this.this$0 = bottomSheetNavigator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BottomSheetNavigator$sheetContent$1$retainedEntry$2$1$invokeSuspend$$inlined$transform$1 bottomSheetNavigator$sheetContent$1$retainedEntry$2$1$invokeSuspend$$inlined$transform$1 = new BottomSheetNavigator$sheetContent$1$retainedEntry$2$1$invokeSuspend$$inlined$transform$1(this.$this_transform, continuation, this.this$0);
        bottomSheetNavigator$sheetContent$1$retainedEntry$2$1$invokeSuspend$$inlined$transform$1.L$0 = obj;
        return bottomSheetNavigator$sheetContent$1$retainedEntry$2$1$invokeSuspend$$inlined$transform$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Flow flow = this.$this_transform;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(flowCollector, this.this$0);
            this.label = 1;
            if (flow.collect(anonymousClass1, this) == coroutine_suspended) {
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
    public final Object invoke(FlowCollector<? super NavBackStackEntry> flowCollector, Continuation<? super Unit> continuation) {
        return ((BottomSheetNavigator$sheetContent$1$retainedEntry$2$1$invokeSuspend$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
