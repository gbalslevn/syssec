package dk.molslinjen.domain.managers.user.creditcards;

import dk.molslinjen.domain.analytics.IFacebookTracker;
import dk.molslinjen.domain.managers.ManagerResult;
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
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.creditcards.UserCreditCardsManager$addCreditCard$2", f = "UserCreditCardsManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class UserCreditCardsManager$addCreditCard$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ManagerResult<Unit> $result;
    int label;
    final /* synthetic */ UserCreditCardsManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserCreditCardsManager$addCreditCard$2(UserCreditCardsManager userCreditCardsManager, ManagerResult<Unit> managerResult, Continuation<? super UserCreditCardsManager$addCreditCard$2> continuation) {
        super(2, continuation);
        this.this$0 = userCreditCardsManager;
        this.$result = managerResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserCreditCardsManager$addCreditCard$2(this.this$0, this.$result, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IFacebookTracker iFacebookTracker;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        iFacebookTracker = this.this$0.facebookTracker;
        iFacebookTracker.trackAddCreditCard(this.$result instanceof ManagerResult.Success);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UserCreditCardsManager$addCreditCard$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
