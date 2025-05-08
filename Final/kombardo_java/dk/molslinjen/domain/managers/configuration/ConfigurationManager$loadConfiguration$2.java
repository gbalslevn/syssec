package dk.molslinjen.domain.managers.configuration;

import dk.molslinjen.domain.localstorage.IConfigurationRepository;
import dk.molslinjen.domain.model.config.Configuration;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "data", "Ldk/molslinjen/domain/model/config/Configuration;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.configuration.ConfigurationManager$loadConfiguration$2", f = "ConfigurationManager.kt", l = {45}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ConfigurationManager$loadConfiguration$2 extends SuspendLambda implements Function2<Configuration, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ConfigurationManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfigurationManager$loadConfiguration$2(ConfigurationManager configurationManager, Continuation<? super ConfigurationManager$loadConfiguration$2> continuation) {
        super(2, continuation);
        this.this$0 = configurationManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ConfigurationManager$loadConfiguration$2 configurationManager$loadConfiguration$2 = new ConfigurationManager$loadConfiguration$2(this.this$0, continuation);
        configurationManager$loadConfiguration$2.L$0 = obj;
        return configurationManager$loadConfiguration$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Configuration configuration, Continuation<? super Unit> continuation) {
        return ((ConfigurationManager$loadConfiguration$2) create(configuration, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IConfigurationRepository iConfigurationRepository;
        Configuration configuration;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            Configuration configuration2 = (Configuration) this.L$0;
            iConfigurationRepository = this.this$0.configurationRepository;
            this.L$0 = configuration2;
            this.label = 1;
            if (iConfigurationRepository.save(configuration2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            configuration = configuration2;
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            configuration = (Configuration) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.updateActiveConfigurations(configuration);
        return Unit.INSTANCE;
    }
}
