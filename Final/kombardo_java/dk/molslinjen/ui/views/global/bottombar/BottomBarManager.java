package dk.molslinjen.ui.views.global.bottombar;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/ui/views/global/bottombar/BottomBarManager;", "Ldk/molslinjen/ui/views/global/bottombar/IBottomBarManager;", "<init>", "()V", "_configuration", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/global/bottombar/BottomBarConfiguration;", "configuration", "Lkotlinx/coroutines/flow/StateFlow;", "getConfiguration", "()Lkotlinx/coroutines/flow/StateFlow;", "apply", BuildConfig.FLAVOR, "bottomBarConfiguration", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BottomBarManager implements IBottomBarManager {
    private final MutableStateFlow<BottomBarConfiguration> _configuration;
    private final StateFlow<BottomBarConfiguration> configuration;

    public BottomBarManager() {
        MutableStateFlow<BottomBarConfiguration> MutableStateFlow = StateFlowKt.MutableStateFlow(BottomBarConfiguration.INSTANCE.getHidden());
        this._configuration = MutableStateFlow;
        this.configuration = MutableStateFlow;
    }

    @Override // dk.molslinjen.ui.views.global.bottombar.IBottomBarManager
    public void apply(BottomBarConfiguration bottomBarConfiguration) {
        Intrinsics.checkNotNullParameter(bottomBarConfiguration, "bottomBarConfiguration");
        this._configuration.setValue(bottomBarConfiguration);
    }

    @Override // dk.molslinjen.ui.views.global.bottombar.IBottomBarManager
    public StateFlow<BottomBarConfiguration> getConfiguration() {
        return this.configuration;
    }
}
