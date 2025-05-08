package dk.molslinjen.domain.managers.user.creditcards;

import dk.molslinjen.domain.model.account.CreditCard;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "state", "Ldk/molslinjen/domain/managers/user/creditcards/UserCreditCardsState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.creditcards.UserCreditCardsManager$collectLatestValidCards$2", f = "UserCreditCardsManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class UserCreditCardsManager$collectLatestValidCards$2 extends SuspendLambda implements Function2<UserCreditCardsState, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<List<CreditCard>, Unit> $observer;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UserCreditCardsManager$collectLatestValidCards$2(Function1<? super List<CreditCard>, Unit> function1, Continuation<? super UserCreditCardsManager$collectLatestValidCards$2> continuation) {
        super(2, continuation);
        this.$observer = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UserCreditCardsManager$collectLatestValidCards$2 userCreditCardsManager$collectLatestValidCards$2 = new UserCreditCardsManager$collectLatestValidCards$2(this.$observer, continuation);
        userCreditCardsManager$collectLatestValidCards$2.L$0 = obj;
        return userCreditCardsManager$collectLatestValidCards$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(UserCreditCardsState userCreditCardsState, Continuation<? super Unit> continuation) {
        return ((UserCreditCardsManager$collectLatestValidCards$2) create(userCreditCardsState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<CreditCard> creditCards = ((UserCreditCardsState) this.L$0).getCreditCards();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : creditCards) {
            if (!((CreditCard) obj2).isExpired()) {
                arrayList.add(obj2);
            }
        }
        this.$observer.invoke(arrayList);
        return Unit.INSTANCE;
    }
}
