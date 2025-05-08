package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.shared.CurrencyType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH¦@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H¦@¢\u0006\u0002\u0010\u0011R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/ICurrencyManager;", BuildConfig.FLAVOR, "selectedCurrencyState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "getSelectedCurrencyState", "()Lkotlinx/coroutines/flow/StateFlow;", "getCurrencies", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectCurrency", BuildConfig.FLAVOR, "currencyType", "(Ldk/molslinjen/domain/model/shared/CurrencyType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSelectedCurrency", "site", "Ldk/molslinjen/domain/model/config/Site;", "(Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ICurrencyManager {
    Object getCurrencies(Continuation<? super List<? extends CurrencyType>> continuation);

    Object getSelectedCurrency(Site site, Continuation<? super CurrencyType> continuation);

    StateFlow<CurrencyType> getSelectedCurrencyState();

    Object selectCurrency(CurrencyType currencyType, Continuation<? super Unit> continuation);
}
