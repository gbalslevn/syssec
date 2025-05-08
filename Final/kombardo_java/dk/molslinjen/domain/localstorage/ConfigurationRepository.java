package dk.molslinjen.domain.localstorage;

import android.content.Context;
import dk.molslinjen.domain.localstorage.base.FileObjectRepository;
import dk.molslinjen.domain.model.config.Configuration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0096@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/domain/localstorage/ConfigurationRepository;", "Ldk/molslinjen/domain/localstorage/IConfigurationRepository;", "Ldk/molslinjen/domain/localstorage/base/FileObjectRepository;", "Ldk/molslinjen/domain/model/config/Configuration;", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getConfiguration", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", BuildConfig.FLAVOR, "configuration", "(Ldk/molslinjen/domain/model/config/Configuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConfigurationRepository extends FileObjectRepository<Configuration> implements IConfigurationRepository {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfigurationRepository(Context appContext) {
        super(appContext, "configuration_v3.json", Configuration.INSTANCE.serializer());
        Intrinsics.checkNotNullParameter(appContext, "appContext");
    }

    @Override // dk.molslinjen.domain.localstorage.IConfigurationRepository
    public Object getConfiguration(Continuation<? super Configuration> continuation) {
        return getItem(continuation);
    }

    @Override // dk.molslinjen.domain.localstorage.IConfigurationRepository
    public Object save(Configuration configuration, Continuation<? super Unit> continuation) {
        Object saveItem = super.saveItem(configuration, continuation);
        return saveItem == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? saveItem : Unit.INSTANCE;
    }
}
