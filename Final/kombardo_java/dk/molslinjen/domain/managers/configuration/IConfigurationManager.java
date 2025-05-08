package dk.molslinjen.domain.managers.configuration;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.model.config.Configuration;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Site;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004H¦@¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\r2\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000b¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", BuildConfig.FLAVOR, "loadConfiguration", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/model/config/Configuration;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConfiguration", "getActiveConfiguration", "Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;", "site", "Ldk/molslinjen/domain/model/config/Site;", "(Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveConfigurationFlow", "Lkotlinx/coroutines/flow/StateFlow;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IConfigurationManager {
    Object getActiveConfiguration(Site site, Continuation<? super LocalizedSiteConfiguration> continuation);

    Object getActiveConfigurationFlow(Site site, Continuation<? super StateFlow<LocalizedSiteConfiguration>> continuation);

    Object getConfiguration(Continuation<? super Configuration> continuation);

    Object loadConfiguration(Continuation<? super ManagerResult<Configuration>> continuation);
}
