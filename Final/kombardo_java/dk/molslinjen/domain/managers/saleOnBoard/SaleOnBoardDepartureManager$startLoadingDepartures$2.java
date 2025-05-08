package dk.molslinjen.domain.managers.saleOnBoard;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardDepartureManager$startLoadingDepartures$2", f = "SaleOnBoardDepartureManager.kt", l = {60}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SaleOnBoardDepartureManager$startLoadingDepartures$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LocalDate $date;
    final /* synthetic */ String $departuresRequestId;
    final /* synthetic */ int $i;
    final /* synthetic */ SaleOnBoardRouteState $routeState;
    int label;
    final /* synthetic */ SaleOnBoardDepartureManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardDepartureManager$startLoadingDepartures$2(SaleOnBoardDepartureManager saleOnBoardDepartureManager, String str, SaleOnBoardRouteState saleOnBoardRouteState, LocalDate localDate, int i5, Continuation<? super SaleOnBoardDepartureManager$startLoadingDepartures$2> continuation) {
        super(2, continuation);
        this.this$0 = saleOnBoardDepartureManager;
        this.$departuresRequestId = str;
        this.$routeState = saleOnBoardRouteState;
        this.$date = localDate;
        this.$i = i5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SaleOnBoardDepartureManager$startLoadingDepartures$2(this.this$0, this.$departuresRequestId, this.$routeState, this.$date, this.$i, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object departures;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            SaleOnBoardDepartureManager saleOnBoardDepartureManager = this.this$0;
            String str = this.$departuresRequestId;
            SaleOnBoardRouteState saleOnBoardRouteState = this.$routeState;
            LocalDate plusDays = this.$date.plusDays(this.$i);
            Intrinsics.checkNotNullExpressionValue(plusDays, "plusDays(...)");
            this.label = 1;
            departures = saleOnBoardDepartureManager.getDepartures(str, saleOnBoardRouteState, plusDays, this);
            if (departures == coroutine_suspended) {
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
        return ((SaleOnBoardDepartureManager$startLoadingDepartures$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
