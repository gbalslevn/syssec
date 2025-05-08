package dk.molslinjen.domain.managers.api;

import dk.molslinjen.core.ApiEnvironment;
import dk.molslinjen.core.Environment;
import dk.molslinjen.domain.managers.api.IApiProviderManager;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0096@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/domain/managers/api/ApiProviderManager;", "Ldk/molslinjen/domain/managers/api/IApiProviderManager;", "settings", "Ldk/molslinjen/domain/model/settings/ISettings;", "<init>", "(Ldk/molslinjen/domain/model/settings/ISettings;)V", "localScope", "Lkotlinx/coroutines/CoroutineScope;", "settingsKey", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Dev$ApiEnvironmentOverride;", "originalApi", "Ldk/molslinjen/core/ApiEnvironment;", "getOriginalApi", "()Ldk/molslinjen/core/ApiEnvironment;", "overrideApiState", "Lkotlinx/coroutines/flow/StateFlow;", "getOverrideApiState", "()Lkotlinx/coroutines/flow/StateFlow;", "setApiEnvironment", BuildConfig.FLAVOR, "apiEnvironment", "(Ldk/molslinjen/core/ApiEnvironment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAvailableApis", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ApiProviderManager implements IApiProviderManager {
    private final CoroutineScope localScope;
    private final ApiEnvironment originalApi;
    private final StateFlow<ApiEnvironment> overrideApiState;
    private final ISettings settings;
    private final SettingsProperty.Dev.ApiEnvironmentOverride settingsKey;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Environment.values().length];
            try {
                iArr[Environment.Dev.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Environment.Test.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Environment.ProdTest.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Environment.Prod.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ApiProviderManager(ISettings settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.settings = settings;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.localScope = CoroutineScope;
        SettingsProperty.Dev.ApiEnvironmentOverride apiEnvironmentOverride = SettingsProperty.Dev.ApiEnvironmentOverride.INSTANCE;
        this.settingsKey = apiEnvironmentOverride;
        this.originalApi = ApiEnvironment.INSTANCE.from(Environment.INSTANCE.current());
        this.overrideApiState = settings.get(CoroutineScope, apiEnvironmentOverride);
    }

    @Override // dk.molslinjen.domain.managers.api.IApiProviderManager
    public ApiEnvironment getActiveApi() {
        return IApiProviderManager.DefaultImpls.getActiveApi(this);
    }

    @Override // dk.molslinjen.domain.managers.api.IApiProviderManager
    public List<ApiEnvironment> getAvailableApis() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[Environment.INSTANCE.current().ordinal()];
        if (i5 == 1 || i5 == 2) {
            return CollectionsKt.listOf((Object[]) new ApiEnvironment[]{ApiEnvironment.QA, ApiEnvironment.Stage});
        }
        if (i5 == 3 || i5 == 4) {
            return CollectionsKt.emptyList();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // dk.molslinjen.domain.managers.api.IApiProviderManager, dk.molslinjen.core.providers.IApiInfoProvider
    public ApiEnvironment getOriginalApi() {
        return this.originalApi;
    }

    @Override // dk.molslinjen.domain.managers.api.IApiProviderManager, dk.molslinjen.core.providers.IApiInfoProvider
    public ApiEnvironment getOverrideApi() {
        return IApiProviderManager.DefaultImpls.getOverrideApi(this);
    }

    @Override // dk.molslinjen.domain.managers.api.IApiProviderManager
    public StateFlow<ApiEnvironment> getOverrideApiState() {
        return this.overrideApiState;
    }

    @Override // dk.molslinjen.domain.managers.api.IApiProviderManager
    public Object setApiEnvironment(ApiEnvironment apiEnvironment, Continuation<? super Unit> continuation) {
        if (apiEnvironment == getOriginalApi()) {
            apiEnvironment = null;
        }
        Object update = this.settings.update(this.settingsKey, apiEnvironment, continuation);
        return update == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? update : Unit.INSTANCE;
    }
}
