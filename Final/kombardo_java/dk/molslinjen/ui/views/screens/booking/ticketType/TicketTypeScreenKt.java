package dk.molslinjen.ui.views.screens.booking.ticketType;

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
import androidx.navigation.NavOptions;
import com.ramcosta.composedestinations.generated.destinations.TicketTypeScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.ResultBackNavigator;
import com.ramcosta.composedestinations.spec.Direction;
import dk.molslinjen.core.Environment;
import dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeScreenKt;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"TicketTypeScreen", BuildConfig.FLAVOR, "navigator", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "resultNavigatorOnOutboundDepartureSelected", "Lcom/ramcosta/composedestinations/result/ResultBackNavigator;", "Ljava/util/UUID;", "(Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultBackNavigator;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TicketTypeScreenKt {
    public static final void TicketTypeScreen(final DestinationsNavigator navigator, final ResultBackNavigator<UUID> resultNavigatorOnOutboundDepartureSelected, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(resultNavigatorOnOutboundDepartureSelected, "resultNavigatorOnOutboundDepartureSelected");
        Composer startRestartGroup = composer.startRestartGroup(347986167);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(navigator) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(resultNavigatorOnOutboundDepartureSelected) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(347986167, i6, -1, "dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeScreen (TicketTypeScreen.kt:31)");
            }
            startRestartGroup.startReplaceGroup(1879143015);
            int i7 = i6 & 14;
            boolean z5 = ((i6 & 112) == 32) | (i7 == 4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function2() { // from class: i3.B
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit TicketTypeScreen$lambda$1$lambda$0;
                        TicketTypeScreen$lambda$1$lambda$0 = TicketTypeScreenKt.TicketTypeScreen$lambda$1$lambda$0(ResultBackNavigator.this, navigator, (Direction) obj, ((Boolean) obj2).booleanValue());
                        return TicketTypeScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function2 function2 = (Function2) rememberedValue;
            startRestartGroup.endReplaceGroup();
            if (Environment.INSTANCE.isMolslinjen()) {
                startRestartGroup.startReplaceGroup(-1875722665);
                startRestartGroup.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(1729797275);
                ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) TicketTypeMolslinjenViewModel.class, current, (String) null, createHiltViewModelFactory, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, startRestartGroup, 36936, 0);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                TicketTypeMolslinjenViewModel ticketTypeMolslinjenViewModel = (TicketTypeMolslinjenViewModel) viewModel;
                startRestartGroup.startReplaceGroup(1879158551);
                boolean z6 = i7 == 4;
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new TicketTypeScreenKt$TicketTypeScreen$1$1(navigator);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                TicketTypeMolslinjenScreenKt.TicketTypeMolslinjenScreen(ticketTypeMolslinjenViewModel, (Function0) rememberedValue2, function2, startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1875547143);
                startRestartGroup.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current2 = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
                if (current2 == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                ViewModelProvider.Factory createHiltViewModelFactory2 = HiltViewModelKt.createHiltViewModelFactory(current2, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(1729797275);
                ViewModel viewModel2 = ViewModelKt.viewModel((Class<ViewModel>) TicketTypeKombardoViewModel.class, current2, (String) null, createHiltViewModelFactory2, current2 instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current2).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, startRestartGroup, 36936, 0);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                TicketTypeKombardoViewModel ticketTypeKombardoViewModel = (TicketTypeKombardoViewModel) viewModel2;
                startRestartGroup.startReplaceGroup(1879164151);
                boolean z7 = i7 == 4;
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (z7 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new TicketTypeScreenKt$TicketTypeScreen$2$1(navigator);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                TicketTypeKombardoScreenKt.TicketTypeKombardoScreen(ticketTypeKombardoViewModel, (Function0) rememberedValue3, function2, startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: i3.C
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TicketTypeScreen$lambda$5;
                    TicketTypeScreen$lambda$5 = TicketTypeScreenKt.TicketTypeScreen$lambda$5(DestinationsNavigator.this, resultNavigatorOnOutboundDepartureSelected, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TicketTypeScreen$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketTypeScreen$lambda$1$lambda$0(ResultBackNavigator resultBackNavigator, DestinationsNavigator destinationsNavigator, Direction direction, boolean z5) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        if (z5) {
            UUID randomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(randomUUID, "randomUUID(...)");
            resultBackNavigator.navigateBack(randomUUID);
        } else {
            DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, direction, NavOptions.Builder.setPopUpTo$default(new NavOptions.Builder(), TicketTypeScreenDestination.INSTANCE.getRoute(), true, false, 4, (Object) null).build(), null, 4, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketTypeScreen$lambda$5(DestinationsNavigator destinationsNavigator, ResultBackNavigator resultBackNavigator, int i5, Composer composer, int i6) {
        TicketTypeScreen(destinationsNavigator, resultBackNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
