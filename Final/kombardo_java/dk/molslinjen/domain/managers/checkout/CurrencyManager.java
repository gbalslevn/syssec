package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.core.Feature;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.model.config.Configuration;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.SiteConfiguration;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import dk.molslinjen.domain.model.shared.CurrencyType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/CurrencyManager;", "Ldk/molslinjen/domain/managers/checkout/ICurrencyManager;", "configurationManager", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "settings", "Ldk/molslinjen/domain/model/settings/ISettings;", "<init>", "(Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;Ldk/molslinjen/domain/model/settings/ISettings;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "selectedCurrencyState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "getSelectedCurrencyState", "()Lkotlinx/coroutines/flow/StateFlow;", "getCurrencies", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectCurrency", BuildConfig.FLAVOR, "currencyType", "(Ldk/molslinjen/domain/model/shared/CurrencyType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSelectedCurrency", "site", "Ldk/molslinjen/domain/model/config/Site;", "(Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CurrencyManager implements ICurrencyManager {
    private final IConfigurationManager configurationManager;
    private final CoroutineScope coroutineScope;
    private final StateFlow<CurrencyType> selectedCurrencyState;
    private final ISettings settings;

    public CurrencyManager(IConfigurationManager configurationManager, ISettings settings) {
        Intrinsics.checkNotNullParameter(configurationManager, "configurationManager");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.configurationManager = configurationManager;
        this.settings = settings;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.coroutineScope = CoroutineScope;
        this.selectedCurrencyState = settings.get(CoroutineScope, SettingsProperty.Checkout.SelectedCurrency.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // dk.molslinjen.domain.managers.checkout.ICurrencyManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getCurrencies(Continuation<? super List<? extends CurrencyType>> continuation) {
        CurrencyManager$getCurrencies$1 currencyManager$getCurrencies$1;
        int i5;
        Configuration configuration;
        if (continuation instanceof CurrencyManager$getCurrencies$1) {
            currencyManager$getCurrencies$1 = (CurrencyManager$getCurrencies$1) continuation;
            int i6 = currencyManager$getCurrencies$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                currencyManager$getCurrencies$1.label = i6 - Integer.MIN_VALUE;
                Object obj = currencyManager$getCurrencies$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = currencyManager$getCurrencies$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IConfigurationManager iConfigurationManager = this.configurationManager;
                    currencyManager$getCurrencies$1.label = 1;
                    obj = iConfigurationManager.getConfiguration(currencyManager$getCurrencies$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                configuration = (Configuration) obj;
                if (configuration != null) {
                    return CollectionsKt.emptyList();
                }
                Collection<SiteConfiguration> values = configuration.getSiteConfigurations().values();
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = values.iterator();
                while (it.hasNext()) {
                    CollectionsKt.addAll(arrayList, ((SiteConfiguration) it.next()).getActiveConfiguration().getEnabledCurrencies());
                }
                return CollectionsKt.distinct(arrayList);
            }
        }
        currencyManager$getCurrencies$1 = new CurrencyManager$getCurrencies$1(this, continuation);
        Object obj2 = currencyManager$getCurrencies$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = currencyManager$getCurrencies$1.label;
        if (i5 != 0) {
        }
        configuration = (Configuration) obj2;
        if (configuration != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // dk.molslinjen.domain.managers.checkout.ICurrencyManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getSelectedCurrency(Site site, Continuation<? super CurrencyType> continuation) {
        CurrencyManager$getSelectedCurrency$1 currencyManager$getSelectedCurrency$1;
        int i5;
        CurrencyManager currencyManager;
        CurrencyType currencyType;
        LocalizedSiteConfiguration localizedSiteConfiguration;
        List<CurrencyType> enabledCurrencies;
        Object obj;
        if (continuation instanceof CurrencyManager$getSelectedCurrency$1) {
            currencyManager$getSelectedCurrency$1 = (CurrencyManager$getSelectedCurrency$1) continuation;
            int i6 = currencyManager$getSelectedCurrency$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                currencyManager$getSelectedCurrency$1.label = i6 - Integer.MIN_VALUE;
                Object obj2 = currencyManager$getSelectedCurrency$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = currencyManager$getSelectedCurrency$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    CurrencyType currencyType2 = CurrencyType.DKK;
                    if (Feature.HardcodedSekCurrency.isEnabled()) {
                        return CurrencyType.SEK;
                    }
                    IConfigurationManager iConfigurationManager = this.configurationManager;
                    currencyManager$getSelectedCurrency$1.L$0 = this;
                    currencyManager$getSelectedCurrency$1.L$1 = currencyType2;
                    currencyManager$getSelectedCurrency$1.label = 1;
                    Object activeConfiguration = iConfigurationManager.getActiveConfiguration(site, currencyManager$getSelectedCurrency$1);
                    if (activeConfiguration == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    currencyManager = this;
                    obj2 = activeConfiguration;
                    currencyType = currencyType2;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    currencyType = (CurrencyType) currencyManager$getSelectedCurrency$1.L$1;
                    currencyManager = (CurrencyManager) currencyManager$getSelectedCurrency$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                }
                localizedSiteConfiguration = (LocalizedSiteConfiguration) obj2;
                if (localizedSiteConfiguration == null && (enabledCurrencies = localizedSiteConfiguration.getEnabledCurrencies()) != null) {
                    CurrencyType currencyType3 = (CurrencyType) currencyManager.settings.latestValueFor(SettingsProperty.Checkout.SelectedCurrency.INSTANCE);
                    Iterator<T> it = enabledCurrencies.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (((CurrencyType) obj) == currencyType3) {
                            break;
                        }
                    }
                    CurrencyType currencyType4 = (CurrencyType) obj;
                    return currencyType4 == null ? currencyType : currencyType4;
                }
            }
        }
        currencyManager$getSelectedCurrency$1 = new CurrencyManager$getSelectedCurrency$1(this, continuation);
        Object obj22 = currencyManager$getSelectedCurrency$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = currencyManager$getSelectedCurrency$1.label;
        if (i5 != 0) {
        }
        localizedSiteConfiguration = (LocalizedSiteConfiguration) obj22;
        return localizedSiteConfiguration == null ? currencyType : currencyType;
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICurrencyManager
    public StateFlow<CurrencyType> getSelectedCurrencyState() {
        return this.selectedCurrencyState;
    }

    @Override // dk.molslinjen.domain.managers.checkout.ICurrencyManager
    public Object selectCurrency(CurrencyType currencyType, Continuation<? super Unit> continuation) {
        Object update = this.settings.update(SettingsProperty.Checkout.SelectedCurrency.INSTANCE, currencyType, continuation);
        return update == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? update : Unit.INSTANCE;
    }
}
