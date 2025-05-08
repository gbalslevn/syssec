package dk.molslinjen.domain.managers.user.creditcards;

import dk.molslinjen.api.services.account.creditcard.response.CreditCardDTO;
import dk.molslinjen.domain.model.account.CreditCard;
import java.util.ArrayList;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "cards", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/account/creditcard/response/CreditCardDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.creditcards.UserCreditCardsManager$loadCreditCards$2", f = "UserCreditCardsManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class UserCreditCardsManager$loadCreditCards$2 extends SuspendLambda implements Function2<List<? extends CreditCardDTO>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UserCreditCardsManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserCreditCardsManager$loadCreditCards$2(UserCreditCardsManager userCreditCardsManager, Continuation<? super UserCreditCardsManager$loadCreditCards$2> continuation) {
        super(2, continuation);
        this.this$0 = userCreditCardsManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UserCreditCardsManager$loadCreditCards$2 userCreditCardsManager$loadCreditCards$2 = new UserCreditCardsManager$loadCreditCards$2(this.this$0, continuation);
        userCreditCardsManager$loadCreditCards$2.L$0 = obj;
        return userCreditCardsManager$loadCreditCards$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends CreditCardDTO> list, Continuation<? super Unit> continuation) {
        return invoke2((List<CreditCardDTO>) list, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UserCreditCardsState value;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List list = (List) this.L$0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new CreditCard((CreditCardDTO) it.next()));
        }
        MutableStateFlow<UserCreditCardsState> creditCardsState = this.this$0.getCreditCardsState();
        do {
            value = creditCardsState.getValue();
        } while (!creditCardsState.compareAndSet(value, value.copy(arrayList)));
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<CreditCardDTO> list, Continuation<? super Unit> continuation) {
        return ((UserCreditCardsManager$loadCreditCards$2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
