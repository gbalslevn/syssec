package com.sdk.growthbook.features;

import com.sdk.growthbook.model.GBFeature;
import com.sdk.growthbook.utils.Resource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.sdk.growthbook.features.FeaturesDataSource$autoRefresh$$inlined$transform$1", f = "FeaturesDataSource.kt", l = {40}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class FeaturesDataSource$autoRefresh$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super Resource<? extends Map<String, ? extends GBFeature>>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $failure$inlined;
    final /* synthetic */ Function1 $success$inlined;
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeaturesDataSource this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", BuildConfig.FLAVOR, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    /* renamed from: com.sdk.growthbook.features.FeaturesDataSource$autoRefresh$$inlined$transform$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<Resource<? extends Map<String, ? extends GBFeature>>> $$this$flow;
        final /* synthetic */ Function1 $failure$inlined;
        final /* synthetic */ Function1 $success$inlined;
        final /* synthetic */ FeaturesDataSource this$0;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.sdk.growthbook.features.FeaturesDataSource$autoRefresh$$inlined$transform$1$1", f = "FeaturesDataSource.kt", l = {230, 233}, m = "emit")
        /* renamed from: com.sdk.growthbook.features.FeaturesDataSource$autoRefresh$$inlined$transform$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00311 extends ContinuationImpl {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;

            public C00311(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass1.this.emit(null, this);
            }
        }

        public AnonymousClass1(FlowCollector flowCollector, FeaturesDataSource featuresDataSource, Function1 function1, Function1 function12) {
            this.this$0 = featuresDataSource;
            this.$success$inlined = function1;
            this.$failure$inlined = function12;
            this.$$this$flow = flowCollector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t5, Continuation<? super Unit> continuation) {
            C00311 c00311;
            int i5;
            Resource<? extends Map<String, ? extends GBFeature>> resource;
            AnonymousClass1<T> anonymousClass1;
            Json jsonParser;
            FeaturesDataModel featuresDataModel;
            AnonymousClass1<T> anonymousClass12;
            if (continuation instanceof C00311) {
                c00311 = (C00311) continuation;
                int i6 = c00311.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    c00311.label = i6 - Integer.MIN_VALUE;
                    Object obj = c00311.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = c00311.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        FlowCollector<Resource<? extends Map<String, ? extends GBFeature>>> flowCollector = this.$$this$flow;
                        resource = (Resource) t5;
                        if (resource instanceof Resource.Success) {
                            jsonParser = this.this$0.getJsonParser();
                            featuresDataModel = (FeaturesDataModel) jsonParser.decodeFromString(SerializersKt.serializer(jsonParser.getSerializersModule(), Reflection.typeOf(FeaturesDataModel.class)), (String) ((Resource.Success) resource).getData());
                            Resource.Success success = new Resource.Success(featuresDataModel.getFeatures());
                            c00311.L$0 = this;
                            c00311.L$1 = featuresDataModel;
                            c00311.label = 1;
                            if (flowCollector.emit(success, c00311) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            anonymousClass12 = this;
                            anonymousClass12.$success$inlined.invoke(featuresDataModel);
                        } else if (resource instanceof Resource.Error) {
                            c00311.L$0 = this;
                            c00311.L$1 = resource;
                            c00311.label = 2;
                            if (flowCollector.emit(resource, c00311) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            anonymousClass1 = this;
                            anonymousClass1.$failure$inlined.invoke(((Resource.Error) resource).getException());
                        }
                    } else if (i5 == 1) {
                        featuresDataModel = (FeaturesDataModel) c00311.L$1;
                        anonymousClass12 = (AnonymousClass1) c00311.L$0;
                        ResultKt.throwOnFailure(obj);
                        anonymousClass12.$success$inlined.invoke(featuresDataModel);
                    } else {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        resource = (Resource) c00311.L$1;
                        anonymousClass1 = (AnonymousClass1) c00311.L$0;
                        ResultKt.throwOnFailure(obj);
                        anonymousClass1.$failure$inlined.invoke(((Resource.Error) resource).getException());
                    }
                    return Unit.INSTANCE;
                }
            }
            c00311 = new C00311(continuation);
            Object obj2 = c00311.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i5 = c00311.label;
            if (i5 != 0) {
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeaturesDataSource$autoRefresh$$inlined$transform$1(Flow flow, Continuation continuation, FeaturesDataSource featuresDataSource, Function1 function1, Function1 function12) {
        super(2, continuation);
        this.$this_transform = flow;
        this.this$0 = featuresDataSource;
        this.$success$inlined = function1;
        this.$failure$inlined = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FeaturesDataSource$autoRefresh$$inlined$transform$1 featuresDataSource$autoRefresh$$inlined$transform$1 = new FeaturesDataSource$autoRefresh$$inlined$transform$1(this.$this_transform, continuation, this.this$0, this.$success$inlined, this.$failure$inlined);
        featuresDataSource$autoRefresh$$inlined$transform$1.L$0 = obj;
        return featuresDataSource$autoRefresh$$inlined$transform$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Flow flow = this.$this_transform;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(flowCollector, this.this$0, this.$success$inlined, this.$failure$inlined);
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
    public final Object invoke(FlowCollector<? super Resource<? extends Map<String, ? extends GBFeature>>> flowCollector, Continuation<? super Unit> continuation) {
        return ((FeaturesDataSource$autoRefresh$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
