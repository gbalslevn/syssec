package dk.molslinjen.domain.managers.user.creditcards;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.merge.IAssetsMerger;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.account.CreditCardType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH¦@¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000eJ<\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u0016J(\u0010\u0017\u001a\u00020\t2\u0018\u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020\t0\u0019H¦@¢\u0006\u0002\u0010\u001cR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001d"}, d2 = {"Ldk/molslinjen/domain/managers/user/creditcards/IUserCreditCardsManager;", "Ldk/molslinjen/domain/managers/user/merge/IAssetsMerger;", "creditCardsState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/user/creditcards/UserCreditCardsState;", "getCreditCardsState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadCreditCards", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCreditCard", "cardId", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addCreditCard", "maskedNumber", "cardType", "Ldk/molslinjen/domain/model/account/CreditCardType;", "expirationMonth", "expirationYear", "creditCardToken", "(Ljava/lang/String;Ldk/molslinjen/domain/model/account/CreditCardType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectLatestValidCards", "observer", "Lkotlin/Function1;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/CreditCard;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IUserCreditCardsManager extends IAssetsMerger {
    Object addCreditCard(String str, CreditCardType creditCardType, String str2, String str3, String str4, Continuation<? super ManagerResult<Unit>> continuation);

    Object collectLatestValidCards(Function1<? super List<CreditCard>, Unit> function1, Continuation<? super Unit> continuation);

    Object deleteCreditCard(String str, Continuation<? super ManagerResult<Unit>> continuation);

    StateFlow<UserCreditCardsState> getCreditCardsState();

    Object loadCreditCards(Continuation<? super ManagerResult<Unit>> continuation);
}
