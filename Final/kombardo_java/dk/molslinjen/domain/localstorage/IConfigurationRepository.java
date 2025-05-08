package dk.molslinjen.domain.localstorage;

import dk.molslinjen.domain.model.config.Configuration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/domain/localstorage/IConfigurationRepository;", BuildConfig.FLAVOR, "getConfiguration", "Ldk/molslinjen/domain/model/config/Configuration;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", BuildConfig.FLAVOR, "configuration", "(Ldk/molslinjen/domain/model/config/Configuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IConfigurationRepository {
    Object getConfiguration(Continuation<? super Configuration> continuation);

    Object save(Configuration configuration, Continuation<? super Unit> continuation);
}
