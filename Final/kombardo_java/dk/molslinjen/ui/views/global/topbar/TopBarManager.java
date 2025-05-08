package dk.molslinjen.ui.views.global.topbar;

import kotlin.Metadata;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/ui/views/global/topbar/TopBarManager;", "Ldk/molslinjen/ui/views/global/topbar/ITopBarManager;", "<init>", "()V", "_configuration", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/global/topbar/TopBarConfiguration;", "configuration", "Lkotlinx/coroutines/flow/StateFlow;", "getConfiguration", "()Lkotlinx/coroutines/flow/StateFlow;", "apply", BuildConfig.FLAVOR, "topBarConfiguration", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TopBarManager implements ITopBarManager {
    private final MutableStateFlow<TopBarConfiguration> _configuration = StateFlowKt.MutableStateFlow(new TopBarConfiguration(false, null, null, null, 14, null));

    @Override // dk.molslinjen.ui.views.global.topbar.ITopBarManager
    public void apply(TopBarConfiguration topBarConfiguration) {
        if (topBarConfiguration != null) {
            this._configuration.setValue(topBarConfiguration);
        }
    }

    @Override // dk.molslinjen.ui.views.global.topbar.ITopBarManager
    public StateFlow<TopBarConfiguration> getConfiguration() {
        return this._configuration;
    }
}
