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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.creditcards.UserCreditCardsManager$deleteCreditCard$result$1", f = "UserCreditCardsManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class UserCreditCardsManager$deleteCreditCard$result$1 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cardId;
    int label;
    final /* synthetic */ UserCreditCardsManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserCreditCardsManager$deleteCreditCard$result$1(UserCreditCardsManager userCreditCardsManager, String str, Continuation<? super UserCreditCardsManager$deleteCreditCard$result$1> continuation) {
        super(2, continuation);
        this.this$0 = userCreditCardsManager;
        this.$cardId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserCreditCardsManager$deleteCreditCard$result$1(this.this$0, this.$cardId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UserCreditCardsState value;
        UserCreditCardsState userCreditCardsState;
        ArrayList arrayList;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        MutableStateFlow<UserCreditCardsState> creditCardsState = this.this$0.getCreditCardsState();
        String str = this.$cardId;
        do {
            value = creditCardsState.getValue();
            userCreditCardsState = value;
            List<CreditCard> creditCards = userCreditCardsState.getCreditCards();
            arrayList = new ArrayList();
            for (Object obj2 : creditCards) {
                if (!Intrinsics.areEqual(((CreditCard) obj2).getCardId(), str)) {
                    arrayList.add(obj2);
                }
            }
        } while (!creditCardsState.compareAndSet(value, userCreditCardsState.copy(arrayList)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
        return ((UserCreditCardsManager$deleteCreditCard$result$1) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
