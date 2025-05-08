package dk.molslinjen.ui.views.global.navigation.wrappers;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.generated.destinations.AgreementsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeparturesMultiRideScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.MultiRideDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketDetailsScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.scope.DestinationScope;
import com.ramcosta.composedestinations.wrapper.DestinationWrapper;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.model.booking.MultiRideBookingData;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.ui.views.global.navigation.wrappers.MultiRideFlowStickyTopBarWrapper;
import dk.molslinjen.ui.views.screens.booking.departures.DeparturesViewModel;
import dk.molslinjen.ui.views.screens.booking.shared.CheckoutMultiRideFlowTopBarKt;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\t\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0017¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/ui/views/global/navigation/wrappers/MultiRideFlowStickyTopBarWrapper;", "Lcom/ramcosta/composedestinations/wrapper/DestinationWrapper;", "<init>", "()V", "T", "Lcom/ramcosta/composedestinations/scope/DestinationScope;", "Lkotlin/Function0;", BuildConfig.FLAVOR, "screenContent", "Wrap", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/booking/departures/DeparturesViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "abortMultiRideFlow", "(Ldk/molslinjen/ui/views/screens/booking/departures/DeparturesViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;)V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiRideFlowStickyTopBarWrapper implements DestinationWrapper {
    public static final MultiRideFlowStickyTopBarWrapper INSTANCE = new MultiRideFlowStickyTopBarWrapper();

    private MultiRideFlowStickyTopBarWrapper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Wrap$lambda$2$lambda$1$lambda$0(DeparturesViewModel departuresViewModel, DestinationScope destinationScope) {
        INSTANCE.abortMultiRideFlow(departuresViewModel, destinationScope.getDestinationsNavigator());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0087  */
    @Override // com.ramcosta.composedestinations.wrapper.DestinationWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> void Wrap(final DestinationScope<T> destinationScope, Function2<? super Composer, ? super Integer, Unit> screenContent, Composer composer, int i5) {
        Object obj;
        ViewModel viewModel;
        RouteSharedSelectedState routeSharedSelectedState;
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        Intrinsics.checkNotNullParameter(screenContent, "screenContent");
        composer.startReplaceGroup(1481741952);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1481741952, i5, -1, "dk.molslinjen.ui.views.global.navigation.wrappers.MultiRideFlowStickyTopBarWrapper.Wrap (MultiRideFlowStickyTopBarWrapper.kt:19)");
        }
        NavController navController = destinationScope.getNavController();
        DeparturesMultiRideScreenDestination departuresMultiRideScreenDestination = DeparturesMultiRideScreenDestination.INSTANCE;
        composer.startReplaceGroup(351911413);
        boolean z5 = true;
        List list = (List) SnapshotStateKt.collectAsState(navController.getCurrentBackStack(), null, composer, 0, 1).getValue();
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            } else {
                obj = listIterator.previous();
                if (Intrinsics.areEqual(((NavBackStackEntry) obj).getDestination().getRoute(), departuresMultiRideScreenDestination.getRoute())) {
                    break;
                }
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        try {
        } catch (Exception unused) {
            composer.endReplaceGroup();
        }
        if (navBackStackEntry != null) {
            viewModel = new ViewModelProvider(navBackStackEntry).get((Class<ViewModel>) DeparturesViewModel.class);
            composer.endReplaceGroup();
            final DeparturesViewModel departuresViewModel = (DeparturesViewModel) viewModel;
            StateFlow<RouteSharedSelectedState> sharedSelectedState = departuresViewModel == null ? departuresViewModel.getSharedSelectedState() : null;
            composer.startReplaceGroup(-1843438662);
            State collectAsState = sharedSelectedState != null ? null : SnapshotStateKt.collectAsState(sharedSelectedState, null, composer, 0, 1);
            composer.endReplaceGroup();
            routeSharedSelectedState = collectAsState == null ? (RouteSharedSelectedState) collectAsState.getValue() : null;
            composer.startReplaceGroup(-1843437536);
            if ((routeSharedSelectedState != null ? routeSharedSelectedState.getMultiRideBookingData() : null) != null) {
                screenContent.invoke(composer, Integer.valueOf((i5 >> 3) & 14));
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return;
            }
            composer.endReplaceGroup();
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            if (composer.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(composer);
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composer.startReplaceGroup(242744253);
            boolean changedInstance = composer.changedInstance(departuresViewModel);
            if ((((i5 & 14) ^ 6) <= 4 || !composer.changed(destinationScope)) && (i5 & 6) != 4) {
                z5 = false;
            }
            boolean z6 = changedInstance | z5;
            Object rememberedValue = composer.rememberedValue();
            if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: U1.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit Wrap$lambda$2$lambda$1$lambda$0;
                        Wrap$lambda$2$lambda$1$lambda$0 = MultiRideFlowStickyTopBarWrapper.Wrap$lambda$2$lambda$1$lambda$0(DeparturesViewModel.this, destinationScope);
                        return Wrap$lambda$2$lambda$1$lambda$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            CheckoutMultiRideFlowTopBarKt.CheckoutMultiRideFlowTopBar((Function0) rememberedValue, composer, 0);
            screenContent.invoke(composer, Integer.valueOf((i5 >> 3) & 14));
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return;
        }
        composer.endReplaceGroup();
        viewModel = null;
        final DeparturesViewModel departuresViewModel2 = (DeparturesViewModel) viewModel;
        if (departuresViewModel2 == null) {
        }
        composer.startReplaceGroup(-1843438662);
        if (sharedSelectedState != null) {
        }
        composer.endReplaceGroup();
        if (collectAsState == null) {
        }
        composer.startReplaceGroup(-1843437536);
        if ((routeSharedSelectedState != null ? routeSharedSelectedState.getMultiRideBookingData() : null) != null) {
        }
    }

    public final void abortMultiRideFlow(DeparturesViewModel viewModel, DestinationsNavigator navigator) {
        MultiRideBookingData multiRideBookingData;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        viewModel.stopEdit();
        DestinationsNavigator.DefaultImpls.popBackStack$default(navigator, TicketDetailsScreenDestination.INSTANCE, false, false, 4, null);
        viewModel.stopAddingReturnFromBookingSummary();
        viewModel.stopEdit();
        RouteSharedSelectedState value = viewModel.getSharedSelectedState().getValue();
        DestinationsNavigator.DefaultImpls.popBackStack$default(navigator, ((value == null || (multiRideBookingData = value.getMultiRideBookingData()) == null) ? null : multiRideBookingData.getFlowOrigin()) == PaymentOrigin.MultiRideTicketFromDetails ? MultiRideDetailsScreenDestination.INSTANCE : AgreementsScreenDestination.INSTANCE, false, false, 4, null);
    }
}
