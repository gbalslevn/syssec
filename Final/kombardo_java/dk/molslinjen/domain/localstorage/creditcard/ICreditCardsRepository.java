package dk.molslinjen.domain.localstorage.creditcard;

import dk.molslinjen.domain.model.account.CreditCard;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/domain/localstorage/creditcard/ICreditCardsRepository;", BuildConfig.FLAVOR, "getCards", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/CreditCard;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCard", "cardId", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", BuildConfig.FLAVOR, "card", "(Ldk/molslinjen/domain/model/account/CreditCard;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ICreditCardsRepository {
    Object clear(Continuation<? super Boolean> continuation);

    Object deleteCard(String str, Continuation<? super List<CreditCard>> continuation);

    Object getCards(Continuation<? super List<CreditCard>> continuation);

    Object save(CreditCard creditCard, Continuation<? super Boolean> continuation);
}
