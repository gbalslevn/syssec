package com.ramcosta.composedestinations.utils;

import androidx.navigation.NavBackStackEntry;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import com.ramcosta.composedestinations.spec.TypedNavGraphSpec;
import com.ramcosta.composedestinations.spec.TypedRoute;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.ramcosta.composedestinations.utils.NavControllerExtKt$special$$inlined$transform$1", f = "NavControllerExt.kt", l = {40}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class NavControllerExtKt$special$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super TypedDestinationSpec<?>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", BuildConfig.FLAVOR, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.ramcosta.composedestinations.utils.NavControllerExtKt$special$$inlined$transform$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<TypedDestinationSpec<?>> $$this$flow;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.ramcosta.composedestinations.utils.NavControllerExtKt$special$$inlined$transform$1$1", f = "NavControllerExt.kt", l = {224}, m = "emit")
        /* renamed from: com.ramcosta.composedestinations.utils.NavControllerExtKt$special$$inlined$transform$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00301 extends ContinuationImpl {
            int label;
            /* synthetic */ Object result;

            public C00301(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass1.this.emit(null, this);
            }
        }

        public AnonymousClass1(FlowCollector flowCollector) {
            this.$$this$flow = flowCollector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t5, Continuation<? super Unit> continuation) {
            C00301 c00301;
            int i5;
            if (continuation instanceof C00301) {
                c00301 = (C00301) continuation;
                int i6 = c00301.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    c00301.label = i6 - Integer.MIN_VALUE;
                    Object obj = c00301.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = c00301.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        FlowCollector<TypedDestinationSpec<?>> flowCollector = this.$$this$flow;
                        TypedRoute<?> route = NavControllerExtKt.route((NavBackStackEntry) t5);
                        if (route instanceof TypedDestinationSpec) {
                            c00301.label = 1;
                            if (flowCollector.emit(route, c00301) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (!(route instanceof TypedNavGraphSpec)) {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        if (i5 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
            c00301 = new C00301(continuation);
            Object obj2 = c00301.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i5 = c00301.label;
            if (i5 != 0) {
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavControllerExtKt$special$$inlined$transform$1(Flow flow, Continuation continuation) {
        super(2, continuation);
        this.$this_transform = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NavControllerExtKt$special$$inlined$transform$1 navControllerExtKt$special$$inlined$transform$1 = new NavControllerExtKt$special$$inlined$transform$1(this.$this_transform, continuation);
        navControllerExtKt$special$$inlined$transform$1.L$0 = obj;
        return navControllerExtKt$special$$inlined$transform$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Flow flow = this.$this_transform;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(flowCollector);
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
    public final Object invoke(FlowCollector<? super TypedDestinationSpec<?>> flowCollector, Continuation<? super Unit> continuation) {
        return ((NavControllerExtKt$special$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
