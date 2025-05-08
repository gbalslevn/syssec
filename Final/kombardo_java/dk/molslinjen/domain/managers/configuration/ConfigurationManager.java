package dk.molslinjen.domain.managers.configuration;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.config.IConfigService;
import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.localstorage.IConfigurationRepository;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.configuration.ConfigurationManager;
import dk.molslinjen.domain.model.config.AgeClassifications;
import dk.molslinjen.domain.model.config.Configuration;
import dk.molslinjen.domain.model.config.Harbor;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.MultiRideType;
import dk.molslinjen.domain.model.config.Region;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.config.SimpleFerry;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.SiteConfiguration;
import dk.molslinjen.domain.model.shared.CurrencyType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\bH\u0096@¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0096@¢\u0006\u0004\b\u0010\u0010\u000eJ\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00162\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R(\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/domain/managers/configuration/ConfigurationManager;", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "Ldk/molslinjen/domain/localstorage/IConfigurationRepository;", "configurationRepository", "Ldk/molslinjen/api/services/config/IConfigService;", "configService", "<init>", "(Ldk/molslinjen/domain/localstorage/IConfigurationRepository;Ldk/molslinjen/api/services/config/IConfigService;)V", "Ldk/molslinjen/domain/model/config/Configuration;", "configuration", BuildConfig.FLAVOR, "updateActiveConfigurations", "(Ldk/molslinjen/domain/model/config/Configuration;)V", "getConfiguration", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ldk/molslinjen/domain/managers/ManagerResult;", "loadConfiguration", "Ldk/molslinjen/domain/model/config/Site;", "site", "Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;", "getActiveConfiguration", "(Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/StateFlow;", "getActiveConfigurationFlow", "Ldk/molslinjen/domain/localstorage/IConfigurationRepository;", "Ldk/molslinjen/api/services/config/IConfigService;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/flow/MutableStateFlow;", "activeState", "Ljava/util/Map;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConfigurationManager implements IConfigurationManager {
    private final Map<Site, MutableStateFlow<LocalizedSiteConfiguration>> activeState;
    private final IConfigService configService;
    private final IConfigurationRepository configurationRepository;

    public ConfigurationManager(IConfigurationRepository configurationRepository, IConfigService configService) {
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(configService, "configService");
        this.configurationRepository = configurationRepository;
        this.configService = configService;
        this.activeState = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Configuration loadConfiguration$lambda$1(ConfigurationResponseDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new Configuration(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateActiveConfigurations(Configuration configuration) {
        LocalizedSiteConfiguration value;
        LocalizedSiteConfiguration localizedSiteConfiguration;
        for (Map.Entry<Site, SiteConfiguration> entry : configuration.getSiteConfigurations().entrySet()) {
            Site key = entry.getKey();
            LocalizedSiteConfiguration activeConfiguration = entry.getValue().getActiveConfiguration();
            Map<Site, MutableStateFlow<LocalizedSiteConfiguration>> map = this.activeState;
            MutableStateFlow<LocalizedSiteConfiguration> mutableStateFlow = map.get(key);
            if (mutableStateFlow == null) {
                mutableStateFlow = StateFlowKt.MutableStateFlow(activeConfiguration);
                map.put(key, mutableStateFlow);
            }
            MutableStateFlow<LocalizedSiteConfiguration> mutableStateFlow2 = mutableStateFlow;
            do {
                value = mutableStateFlow2.getValue();
                LocalizedSiteConfiguration localizedSiteConfiguration2 = value;
                if (localizedSiteConfiguration2 != null) {
                    List<Route> routes = activeConfiguration.getRoutes();
                    List<Harbor> harbors = activeConfiguration.getHarbors();
                    AgeClassifications ageClassifications = activeConfiguration.getAgeClassifications();
                    List<CurrencyType> enabledCurrencies = activeConfiguration.getEnabledCurrencies();
                    List<SimpleFerry> ferries = activeConfiguration.getFerries();
                    List<MultiRideType> multiRideTypes = activeConfiguration.getMultiRideTypes();
                    List<Region> regions = activeConfiguration.getRegions();
                    Site site = activeConfiguration.getSite();
                    localizedSiteConfiguration = localizedSiteConfiguration2.copy((r28 & 1) != 0 ? localizedSiteConfiguration2.routes : routes, (r28 & 2) != 0 ? localizedSiteConfiguration2.transportationCategories : activeConfiguration.getTransportationCategories(), (r28 & 4) != 0 ? localizedSiteConfiguration2.extraTransportations : null, (r28 & 8) != 0 ? localizedSiteConfiguration2.harbors : harbors, (r28 & 16) != 0 ? localizedSiteConfiguration2.regions : regions, (r28 & 32) != 0 ? localizedSiteConfiguration2.multiRideTypes : multiRideTypes, (r28 & 64) != 0 ? localizedSiteConfiguration2.ferries : ferries, (r28 & 128) != 0 ? localizedSiteConfiguration2.ageClassifications : ageClassifications, (r28 & 256) != 0 ? localizedSiteConfiguration2.siteName : activeConfiguration.getSiteName(), (r28 & 512) != 0 ? localizedSiteConfiguration2.lineLogoUrl : null, (r28 & 1024) != 0 ? localizedSiteConfiguration2.site : site, (r28 & 2048) != 0 ? localizedSiteConfiguration2.supportInfo : activeConfiguration.getSupportInfo(), (r28 & 4096) != 0 ? localizedSiteConfiguration2.enabledCurrencies : enabledCurrencies);
                } else {
                    localizedSiteConfiguration = null;
                }
            } while (!mutableStateFlow2.compareAndSet(value, localizedSiteConfiguration));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // dk.molslinjen.domain.managers.configuration.IConfigurationManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getActiveConfiguration(Site site, Continuation<? super LocalizedSiteConfiguration> continuation) {
        ConfigurationManager$getActiveConfiguration$1 configurationManager$getActiveConfiguration$1;
        int i5;
        if (continuation instanceof ConfigurationManager$getActiveConfiguration$1) {
            configurationManager$getActiveConfiguration$1 = (ConfigurationManager$getActiveConfiguration$1) continuation;
            int i6 = configurationManager$getActiveConfiguration$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                configurationManager$getActiveConfiguration$1.label = i6 - Integer.MIN_VALUE;
                Object obj = configurationManager$getActiveConfiguration$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = configurationManager$getActiveConfiguration$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    configurationManager$getActiveConfiguration$1.label = 1;
                    obj = getActiveConfigurationFlow(site, configurationManager$getActiveConfiguration$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((StateFlow) obj).getValue();
            }
        }
        configurationManager$getActiveConfiguration$1 = new ConfigurationManager$getActiveConfiguration$1(this, continuation);
        Object obj2 = configurationManager$getActiveConfiguration$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = configurationManager$getActiveConfiguration$1.label;
        if (i5 != 0) {
        }
        return ((StateFlow) obj2).getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // dk.molslinjen.domain.managers.configuration.IConfigurationManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getActiveConfigurationFlow(Site site, Continuation<? super StateFlow<LocalizedSiteConfiguration>> continuation) {
        ConfigurationManager$getActiveConfigurationFlow$1 configurationManager$getActiveConfigurationFlow$1;
        int i5;
        ConfigurationManager configurationManager;
        MutableStateFlow<LocalizedSiteConfiguration> mutableStateFlow;
        if (continuation instanceof ConfigurationManager$getActiveConfigurationFlow$1) {
            configurationManager$getActiveConfigurationFlow$1 = (ConfigurationManager$getActiveConfigurationFlow$1) continuation;
            int i6 = configurationManager$getActiveConfigurationFlow$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                configurationManager$getActiveConfigurationFlow$1.label = i6 - Integer.MIN_VALUE;
                Object obj = configurationManager$getActiveConfigurationFlow$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = configurationManager$getActiveConfigurationFlow$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    MutableStateFlow<LocalizedSiteConfiguration> mutableStateFlow2 = this.activeState.get(site);
                    if (mutableStateFlow2 != null) {
                        return mutableStateFlow2;
                    }
                    configurationManager$getActiveConfigurationFlow$1.L$0 = this;
                    configurationManager$getActiveConfigurationFlow$1.L$1 = site;
                    configurationManager$getActiveConfigurationFlow$1.label = 1;
                    obj = getConfiguration(configurationManager$getActiveConfigurationFlow$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    configurationManager = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    site = (Site) configurationManager$getActiveConfigurationFlow$1.L$1;
                    configurationManager = (ConfigurationManager) configurationManager$getActiveConfigurationFlow$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Map<Site, MutableStateFlow<LocalizedSiteConfiguration>> map = configurationManager.activeState;
                mutableStateFlow = map.get(site);
                if (mutableStateFlow == null) {
                    return mutableStateFlow;
                }
                MutableStateFlow<LocalizedSiteConfiguration> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
                map.put(site, MutableStateFlow);
                return MutableStateFlow;
            }
        }
        configurationManager$getActiveConfigurationFlow$1 = new ConfigurationManager$getActiveConfigurationFlow$1(this, continuation);
        Object obj2 = configurationManager$getActiveConfigurationFlow$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = configurationManager$getActiveConfigurationFlow$1.label;
        if (i5 != 0) {
        }
        Map<Site, MutableStateFlow<LocalizedSiteConfiguration>> map2 = configurationManager.activeState;
        mutableStateFlow = map2.get(site);
        if (mutableStateFlow == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // dk.molslinjen.domain.managers.configuration.IConfigurationManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getConfiguration(Continuation<? super Configuration> continuation) {
        ConfigurationManager$getConfiguration$1 configurationManager$getConfiguration$1;
        int i5;
        ConfigurationManager configurationManager;
        Configuration configuration;
        Configuration configuration2;
        if (continuation instanceof ConfigurationManager$getConfiguration$1) {
            configurationManager$getConfiguration$1 = (ConfigurationManager$getConfiguration$1) continuation;
            int i6 = configurationManager$getConfiguration$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                configurationManager$getConfiguration$1.label = i6 - Integer.MIN_VALUE;
                Object obj = configurationManager$getConfiguration$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = configurationManager$getConfiguration$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IConfigurationRepository iConfigurationRepository = this.configurationRepository;
                    configurationManager$getConfiguration$1.L$0 = this;
                    configurationManager$getConfiguration$1.label = 1;
                    obj = iConfigurationRepository.getConfiguration(configurationManager$getConfiguration$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    configurationManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        configuration2 = (Configuration) ManagerResultExtensionsKt.toData((ManagerResult) obj);
                        if (configuration2 == null) {
                            return configuration2;
                        }
                        Logger.INSTANCE.logCritical(new CriticalLog("Failed to load configuration from local storage and external source."));
                        return null;
                    }
                    configurationManager = (ConfigurationManager) configurationManager$getConfiguration$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                configuration = (Configuration) obj;
                if (configuration == null) {
                    configurationManager.updateActiveConfigurations(configuration);
                    return configuration;
                }
                configurationManager$getConfiguration$1.L$0 = null;
                configurationManager$getConfiguration$1.label = 2;
                obj = configurationManager.loadConfiguration(configurationManager$getConfiguration$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                configuration2 = (Configuration) ManagerResultExtensionsKt.toData((ManagerResult) obj);
                if (configuration2 == null) {
                }
            }
        }
        configurationManager$getConfiguration$1 = new ConfigurationManager$getConfiguration$1(this, continuation);
        Object obj2 = configurationManager$getConfiguration$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = configurationManager$getConfiguration$1.label;
        if (i5 != 0) {
        }
        configuration = (Configuration) obj2;
        if (configuration == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // dk.molslinjen.domain.managers.configuration.IConfigurationManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadConfiguration(Continuation<? super ManagerResult<Configuration>> continuation) {
        ConfigurationManager$loadConfiguration$1 configurationManager$loadConfiguration$1;
        int i5;
        ConfigurationManager configurationManager;
        if (continuation instanceof ConfigurationManager$loadConfiguration$1) {
            configurationManager$loadConfiguration$1 = (ConfigurationManager$loadConfiguration$1) continuation;
            int i6 = configurationManager$loadConfiguration$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                configurationManager$loadConfiguration$1.label = i6 - Integer.MIN_VALUE;
                Object obj = configurationManager$loadConfiguration$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = configurationManager$loadConfiguration$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IConfigService iConfigService = this.configService;
                    configurationManager$loadConfiguration$1.L$0 = this;
                    configurationManager$loadConfiguration$1.label = 1;
                    obj = iConfigService.getConfiguration(configurationManager$loadConfiguration$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    configurationManager = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ManagerResult managerResult = (ManagerResult) configurationManager$loadConfiguration$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return managerResult;
                    }
                    configurationManager = (ConfigurationManager) configurationManager$loadConfiguration$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ManagerResult managerResult2 = ManagerResultExtensionsKt.toManagerResult((ApiResult) obj, new Function1() { // from class: C1.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Configuration loadConfiguration$lambda$1;
                        loadConfiguration$lambda$1 = ConfigurationManager.loadConfiguration$lambda$1((ConfigurationResponseDTO) obj2);
                        return loadConfiguration$lambda$1;
                    }
                });
                ConfigurationManager$loadConfiguration$2 configurationManager$loadConfiguration$2 = new ConfigurationManager$loadConfiguration$2(configurationManager, null);
                configurationManager$loadConfiguration$1.L$0 = managerResult2;
                configurationManager$loadConfiguration$1.label = 2;
                return ManagerResultExtensionsKt.onSuccess(managerResult2, configurationManager$loadConfiguration$2, configurationManager$loadConfiguration$1) != coroutine_suspended ? coroutine_suspended : managerResult2;
            }
        }
        configurationManager$loadConfiguration$1 = new ConfigurationManager$loadConfiguration$1(this, continuation);
        Object obj2 = configurationManager$loadConfiguration$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = configurationManager$loadConfiguration$1.label;
        if (i5 != 0) {
        }
        ManagerResult managerResult22 = ManagerResultExtensionsKt.toManagerResult((ApiResult) obj2, new Function1() { // from class: C1.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj22) {
                Configuration loadConfiguration$lambda$1;
                loadConfiguration$lambda$1 = ConfigurationManager.loadConfiguration$lambda$1((ConfigurationResponseDTO) obj22);
                return loadConfiguration$lambda$1;
            }
        });
        ConfigurationManager$loadConfiguration$2 configurationManager$loadConfiguration$22 = new ConfigurationManager$loadConfiguration$2(configurationManager, null);
        configurationManager$loadConfiguration$1.L$0 = managerResult22;
        configurationManager$loadConfiguration$1.label = 2;
        if (ManagerResultExtensionsKt.onSuccess(managerResult22, configurationManager$loadConfiguration$22, configurationManager$loadConfiguration$1) != coroutine_suspended2) {
        }
    }
}
