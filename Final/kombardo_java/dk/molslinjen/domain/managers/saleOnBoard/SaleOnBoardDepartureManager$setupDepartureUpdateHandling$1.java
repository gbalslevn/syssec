package dk.molslinjen.domain.managers.saleOnBoard;

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
import kotlinx.coroutines.flow.FlowKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardDepartureManager$setupDepartureUpdateHandling$1", f = "SaleOnBoardDepartureManager.kt", l = {37}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SaleOnBoardDepartureManager$setupDepartureUpdateHandling$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SaleOnBoardDepartureManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardRouteState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardDepartureManager$setupDepartureUpdateHandling$1$1", f = "SaleOnBoardDepartureManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardDepartureManager$setupDepartureUpdateHandling$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<SaleOnBoardRouteState, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$launch;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SaleOnBoardDepartureManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SaleOnBoardDepartureManager saleOnBoardDepartureManager, CoroutineScope coroutineScope, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = saleOnBoardDepartureManager;
            this.$$this$launch = coroutineScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$$this$launch, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaleOnBoardRouteState saleOnBoardRouteState, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(saleOnBoardRouteState, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SaleOnBoardRouteState saleOnBoardRouteState = (SaleOnBoardRouteState) this.L$0;
            SaleOnBoardDepartureManager saleOnBoardDepartureManager = this.this$0;
            CoroutineScope coroutineScope = this.$$this$launch;
            if (saleOnBoardRouteState == null) {
                return Unit.INSTANCE;
            }
            saleOnBoardDepartureManager.startLoadingDepartures(coroutineScope, saleOnBoardRouteState);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardDepartureManager$setupDepartureUpdateHandling$1(SaleOnBoardDepartureManager saleOnBoardDepartureManager, Continuation<? super SaleOnBoardDepartureManager$setupDepartureUpdateHandling$1> continuation) {
        super(2, continuation);
        this.this$0 = saleOnBoardDepartureManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SaleOnBoardDepartureManager$setupDepartureUpdateHandling$1 saleOnBoardDepartureManager$setupDepartureUpdateHandling$1 = new SaleOnBoardDepartureManager$setupDepartureUpdateHandling$1(this.this$0, continuation);
        saleOnBoardDepartureManager$setupDepartureUpdateHandling$1.L$0 = obj;
        return saleOnBoardDepartureManager$setupDepartureUpdateHandling$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ISaleOnBoardRouteManager iSaleOnBoardRouteManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            iSaleOnBoardRouteManager = this.this$0.saleOnBoardRouteManager;
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(FlowKt.debounce(iSaleOnBoardRouteManager.getRouteState(), 500L));
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, coroutineScope, null);
            this.label = 1;
            if (FlowKt.collectLatest(distinctUntilChanged, anonymousClass1, this) == coroutine_suspended) {
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
        return ((SaleOnBoardDepartureManager$setupDepartureUpdateHandling$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
