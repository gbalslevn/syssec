package dk.molslinjen.ui.views.screens.tickets.barcodeDetails;

import androidx.compose.runtime.MutableState;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.SensorDataManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeValidityViewKt$BarcodeValidityView$1$1$job$1", f = "BarcodeValidityView.kt", l = {52}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class BarcodeValidityViewKt$BarcodeValidityView$1$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<SensorDataManager.SensorData> $data$delegate;
    final /* synthetic */ SensorDataManager $dataManager;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BarcodeValidityViewKt$BarcodeValidityView$1$1$job$1(SensorDataManager sensorDataManager, MutableState<SensorDataManager.SensorData> mutableState, Continuation<? super BarcodeValidityViewKt$BarcodeValidityView$1$1$job$1> continuation) {
        super(2, continuation);
        this.$dataManager = sensorDataManager;
        this.$data$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BarcodeValidityViewKt$BarcodeValidityView$1$1$job$1(this.$dataManager, this.$data$delegate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow receiveAsFlow = FlowKt.receiveAsFlow(this.$dataManager.getData());
            final MutableState<SensorDataManager.SensorData> mutableState = this.$data$delegate;
            FlowCollector flowCollector = new FlowCollector() { // from class: dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeValidityViewKt$BarcodeValidityView$1$1$job$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((SensorDataManager.SensorData) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(SensorDataManager.SensorData sensorData, Continuation<? super Unit> continuation) {
                    mutableState.setValue(sensorData);
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (receiveAsFlow.collect(flowCollector, this) == coroutine_suspended) {
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
        return ((BarcodeValidityViewKt$BarcodeValidityView$1$1$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
