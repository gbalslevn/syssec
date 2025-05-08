package dk.molslinjen.domain.managers.saleOnBoard;

import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardStore;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "result", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStore;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager$loadShopsAndProducts$3", f = "SaleOnBoardCheckoutManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SaleOnBoardCheckoutManager$loadShopsAndProducts$3 extends SuspendLambda implements Function2<List<? extends SaleOnBoardStore>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SaleOnBoardCheckoutManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardCheckoutManager$loadShopsAndProducts$3(SaleOnBoardCheckoutManager saleOnBoardCheckoutManager, Continuation<? super SaleOnBoardCheckoutManager$loadShopsAndProducts$3> continuation) {
        super(2, continuation);
        this.this$0 = saleOnBoardCheckoutManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SaleOnBoardCheckoutManager$loadShopsAndProducts$3 saleOnBoardCheckoutManager$loadShopsAndProducts$3 = new SaleOnBoardCheckoutManager$loadShopsAndProducts$3(this.this$0, continuation);
        saleOnBoardCheckoutManager$loadShopsAndProducts$3.L$0 = obj;
        return saleOnBoardCheckoutManager$loadShopsAndProducts$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends SaleOnBoardStore> list, Continuation<? super Unit> continuation) {
        return invoke2((List<SaleOnBoardStore>) list, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List list = (List) this.L$0;
        MutableStateFlow<SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState> saleOnBoardCheckoutState = this.this$0.getSaleOnBoardCheckoutState();
        while (true) {
            SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState value = saleOnBoardCheckoutState.getValue();
            MutableStateFlow<SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState> mutableStateFlow = saleOnBoardCheckoutState;
            if (mutableStateFlow.compareAndSet(value, SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState.copy$default(value, null, null, (SaleOnBoardStore) CollectionsKt.firstOrNull(list), list, null, null, null, null, null, null, null, null, null, null, null, 32755, null))) {
                return Unit.INSTANCE;
            }
            saleOnBoardCheckoutState = mutableStateFlow;
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<SaleOnBoardStore> list, Continuation<? super Unit> continuation) {
        return ((SaleOnBoardCheckoutManager$loadShopsAndProducts$3) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
