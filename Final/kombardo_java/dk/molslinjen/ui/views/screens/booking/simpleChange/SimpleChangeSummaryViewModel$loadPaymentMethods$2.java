package dk.molslinjen.ui.views.screens.booking.simpleChange;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.creditcards.IUserCreditCardsManager;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.simpleChange.SimpleChangeSummaryViewModel$loadPaymentMethods$2", f = "SimpleChangeSummaryViewModel.kt", l = {57, 58}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SimpleChangeSummaryViewModel$loadPaymentMethods$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SimpleChangeSummaryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleChangeSummaryViewModel$loadPaymentMethods$2(SimpleChangeSummaryViewModel simpleChangeSummaryViewModel, Continuation<? super SimpleChangeSummaryViewModel$loadPaymentMethods$2> continuation) {
        super(2, continuation);
        this.this$0 = simpleChangeSummaryViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SimpleChangeSummaryViewModel$loadPaymentMethods$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IUserCreditCardsManager iUserCreditCardsManager;
        ISnackbarService iSnackbarService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iUserCreditCardsManager = this.this$0.creditCardsManager;
            this.label = 1;
            obj = iUserCreditCardsManager.loadCreditCards(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        iSnackbarService = this.this$0.snackbarService;
        this.label = 2;
        if (ManagerResultExtensionsKt.handlePotentialError((ManagerResult) obj, iSnackbarService, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SimpleChangeSummaryViewModel$loadPaymentMethods$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
