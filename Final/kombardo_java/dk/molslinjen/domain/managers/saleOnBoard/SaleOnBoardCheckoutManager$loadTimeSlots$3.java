package dk.molslinjen.domain.managers.saleOnBoard;

import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardStoreTimeSlots;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardTimeSlot;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "result", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStoreTimeSlots;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager$loadTimeSlots$3", f = "SaleOnBoardCheckoutManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SaleOnBoardCheckoutManager$loadTimeSlots$3 extends SuspendLambda implements Function2<List<? extends SaleOnBoardStoreTimeSlots>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SaleOnBoardCheckoutManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardCheckoutManager$loadTimeSlots$3(SaleOnBoardCheckoutManager saleOnBoardCheckoutManager, Continuation<? super SaleOnBoardCheckoutManager$loadTimeSlots$3> continuation) {
        super(2, continuation);
        this.this$0 = saleOnBoardCheckoutManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SaleOnBoardCheckoutManager$loadTimeSlots$3 saleOnBoardCheckoutManager$loadTimeSlots$3 = new SaleOnBoardCheckoutManager$loadTimeSlots$3(this.this$0, continuation);
        saleOnBoardCheckoutManager$loadTimeSlots$3.L$0 = obj;
        return saleOnBoardCheckoutManager$loadTimeSlots$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends SaleOnBoardStoreTimeSlots> list, Continuation<? super Unit> continuation) {
        return invoke2((List<SaleOnBoardStoreTimeSlots>) list, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List<SaleOnBoardTimeSlot> timeSlots;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List list = (List) this.L$0;
        MutableStateFlow<SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState> saleOnBoardCheckoutState = this.this$0.getSaleOnBoardCheckoutState();
        while (true) {
            SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState value = saleOnBoardCheckoutState.getValue();
            SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState2 = value;
            SaleOnBoardStoreTimeSlots saleOnBoardStoreTimeSlots = (SaleOnBoardStoreTimeSlots) CollectionsKt.firstOrNull(list);
            SaleOnBoardTimeSlot saleOnBoardTimeSlot = null;
            if (saleOnBoardStoreTimeSlots != null && (timeSlots = saleOnBoardStoreTimeSlots.getTimeSlots()) != null) {
                Iterator<T> it = timeSlots.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (!((SaleOnBoardTimeSlot) next).getFullyBooked()) {
                        saleOnBoardTimeSlot = next;
                        break;
                    }
                }
                saleOnBoardTimeSlot = saleOnBoardTimeSlot;
            }
            MutableStateFlow<SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState> mutableStateFlow = saleOnBoardCheckoutState;
            if (mutableStateFlow.compareAndSet(value, SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState.copy$default(saleOnBoardCheckoutState2, null, null, null, null, list, null, null, null, null, null, saleOnBoardTimeSlot, null, null, null, null, 31727, null))) {
                return Unit.INSTANCE;
            }
            saleOnBoardCheckoutState = mutableStateFlow;
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<SaleOnBoardStoreTimeSlots> list, Continuation<? super Unit> continuation) {
        return ((SaleOnBoardCheckoutManager$loadTimeSlots$3) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
