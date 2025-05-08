package dk.molslinjen.ui.views.shared.routeSelector;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import dk.molslinjen.core.Environment;
import dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"RouteSelectorView", BuildConfig.FLAVOR, "onRouteSelected", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class RouteSelectorViewKt {
    public static final void RouteSelectorView(final Function0<Unit> onRouteSelected, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(onRouteSelected, "onRouteSelected");
        Composer startRestartGroup = composer.startRestartGroup(2022304023);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(onRouteSelected) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2022304023, i6, -1, "dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorView (RouteSelectorView.kt:7)");
            }
            if (Environment.INSTANCE.isMolslinjen()) {
                startRestartGroup.startReplaceGroup(-724422695);
                startRestartGroup.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(1729797275);
                ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) RouteSelectorMolslinjenViewModel.class, current, (String) null, createHiltViewModelFactory, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, startRestartGroup, 36936, 0);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                RouteSelectorMolslinjenViewKt.RouteSelectorMolslinjenView((RouteSelectorMolslinjenViewModel) viewModel, onRouteSelected, startRestartGroup, (i6 << 3) & 112);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-724340421);
                startRestartGroup.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current2 = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
                if (current2 == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                ViewModelProvider.Factory createHiltViewModelFactory2 = HiltViewModelKt.createHiltViewModelFactory(current2, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(1729797275);
                ViewModel viewModel2 = ViewModelKt.viewModel((Class<ViewModel>) RouteSelectorKombardoViewModel.class, current2, (String) null, createHiltViewModelFactory2, current2 instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current2).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, startRestartGroup, 36936, 0);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                RouteSelectorKombardoViewKt.RouteSelectorKombardoView((RouteSelectorKombardoViewModel) viewModel2, onRouteSelected, startRestartGroup, (i6 << 3) & 112);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: A4.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RouteSelectorView$lambda$0;
                    RouteSelectorView$lambda$0 = RouteSelectorViewKt.RouteSelectorView$lambda$0(Function0.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return RouteSelectorView$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteSelectorView$lambda$0(Function0 function0, int i5, Composer composer, int i6) {
        RouteSelectorView(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
