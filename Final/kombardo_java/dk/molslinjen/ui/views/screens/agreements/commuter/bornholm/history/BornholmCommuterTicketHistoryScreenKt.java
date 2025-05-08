package dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.history;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import com.ramcosta.composedestinations.generated.destinations.TicketDetailsScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.screens.agreements.common.AgreementTicketHistoryContentKt;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.history.BornholmCommuterTicketHistoryScreenKt;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.history.BornholmCommuterTicketHistoryViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a1\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tH\u0003¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/history/BornholmCommuterTicketHistoryViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "CommuterTicketHistoryScreen", "(Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/history/BornholmCommuterTicketHistoryViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/history/BornholmCommuterTicketHistoryViewModel$ViewState;", "viewState", "Lkotlin/Function2;", BuildConfig.FLAVOR, "showTicketDetails", "Content", "(Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/history/BornholmCommuterTicketHistoryViewModel$ViewState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BornholmCommuterTicketHistoryScreenKt {
    public static final void CommuterTicketHistoryScreen(final BornholmCommuterTicketHistoryViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(1509529139);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1509529139, i6, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.history.CommuterTicketHistoryScreen (BornholmCommuterTicketHistoryScreen.kt:33)");
            }
            BornholmCommuterTicketHistoryViewModel.ViewState viewState = (BornholmCommuterTicketHistoryViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(BackgroundKt.m104backgroundbw27NRU$default(Modifier.INSTANCE, AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null), 0.0f, 1, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-589972612);
            boolean z5 = (i6 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function2() { // from class: t2.a
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit CommuterTicketHistoryScreen$lambda$2$lambda$1$lambda$0;
                        CommuterTicketHistoryScreen$lambda$2$lambda$1$lambda$0 = BornholmCommuterTicketHistoryScreenKt.CommuterTicketHistoryScreen$lambda$2$lambda$1$lambda$0(DestinationsNavigator.this, (String) obj, (String) obj2);
                        return CommuterTicketHistoryScreen$lambda$2$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Content(viewState, (Function2) rememberedValue, startRestartGroup, 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: t2.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CommuterTicketHistoryScreen$lambda$3;
                    CommuterTicketHistoryScreen$lambda$3 = BornholmCommuterTicketHistoryScreenKt.CommuterTicketHistoryScreen$lambda$3(BornholmCommuterTicketHistoryViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CommuterTicketHistoryScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommuterTicketHistoryScreen$lambda$2$lambda$1$lambda$0(DestinationsNavigator destinationsNavigator, String reservationId, String phone) {
        Intrinsics.checkNotNullParameter(reservationId, "reservationId");
        Intrinsics.checkNotNullParameter(phone, "phone");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, TicketDetailsScreenDestination.INSTANCE.invoke(reservationId, phone, MultiRideManager.INSTANCE.getForceMolsSite(), true), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommuterTicketHistoryScreen$lambda$3(BornholmCommuterTicketHistoryViewModel bornholmCommuterTicketHistoryViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        CommuterTicketHistoryScreen(bornholmCommuterTicketHistoryViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void Content(final BornholmCommuterTicketHistoryViewModel.ViewState viewState, final Function2<? super String, ? super String, Unit> function2, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(1106385787);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1106385787, i6, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.history.Content (BornholmCommuterTicketHistoryScreen.kt:60)");
            }
            AgreementTicketHistoryContentKt.AgreementTicketHistoryContent(R.string.commuter_ticketHistory_header, viewState.getIsLoading(), viewState.getCommuterAgreementId(), viewState.getTickets(), viewState.getTicketCategoryType(), function2, startRestartGroup, ((i6 << 12) & 458752) | 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: t2.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$4;
                    Content$lambda$4 = BornholmCommuterTicketHistoryScreenKt.Content$lambda$4(BornholmCommuterTicketHistoryViewModel.ViewState.this, function2, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$4(BornholmCommuterTicketHistoryViewModel.ViewState viewState, Function2 function2, int i5, Composer composer, int i6) {
        Content(viewState, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
