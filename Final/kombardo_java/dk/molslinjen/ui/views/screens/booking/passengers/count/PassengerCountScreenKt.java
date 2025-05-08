package dk.molslinjen.ui.views.screens.booking.passengers.count;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.generated.destinations.CheckoutDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PassengerHelpScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.EditManager;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.TicketSection;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.screens.booking.passengers.PassengerHeaderSectionKt;
import dk.molslinjen.ui.views.screens.booking.passengers.count.PassengerCountScreenKt;
import dk.molslinjen.ui.views.screens.booking.passengers.count.PassengerCountViewModel;
import dk.molslinjen.ui.views.screens.booking.shared.CheckoutButtonSheetBottomBarKt;
import dk.molslinjen.ui.views.screens.config.regular.checkout.helpers.ICheckoutExpirationDialogHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u007f\u0010\u001a\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00060\u00132\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00060\u0017H\u0003¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0017\u0010\u001c\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/passengers/count/PassengerCountViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;", "checkoutExpirationDialogHandler", BuildConfig.FLAVOR, "PassengerCountScreen", "(Ldk/molslinjen/ui/views/screens/booking/passengers/count/PassengerCountViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/booking/passengers/count/PassengerCountViewModel$ViewState;", "state", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "checkoutState", "Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;", "editState", "Lkotlin/Function0;", "proceed", "showTicketDetails", "showHelp", "Lkotlin/Function2;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "passengerCountChanged", "Lkotlin/Function1;", BuildConfig.FLAVOR, "changeSameReturnPassengersAsOutbound", "PassengerCountContent", "(Ldk/molslinjen/ui/views/screens/booking/passengers/count/PassengerCountViewModel$ViewState;Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "isValidToProceed", "(Ldk/molslinjen/ui/views/screens/booking/passengers/count/PassengerCountViewModel$ViewState;)Z", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PassengerCountScreenKt {
    private static final void PassengerCountContent(final PassengerCountViewModel.ViewState viewState, final CheckoutManager.CheckoutState checkoutState, final EditManager.EditState editState, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function2<? super Integer, ? super DepartureDirection, Unit> function2, final Function1<? super Boolean, Unit> function1, Composer composer, final int i5) {
        int i6;
        String stringResource;
        Composer startRestartGroup = composer.startRestartGroup(-840388970);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(checkoutState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(editState) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function03) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 8388608 : 4194304;
        }
        if ((4793491 & i6) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-840388970, i6, -1, "dk.molslinjen.ui.views.screens.booking.passengers.count.PassengerCountContent (PassengerCountScreen.kt:82)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier closeKeyboardOnClickOutside = ModifierExtensionsKt.closeKeyboardOnClickOutside(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null), (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager()));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, closeKeyboardOnClickOutside);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            PassengerHeaderSectionKt.PassengerHeaderSection(function03, null, CollectionsKt.emptyList(), checkoutState.getTransportation(), false, checkoutState.getBookingType(), false, DepartureDirection.Outbound, 0, 0, 0, false, false, startRestartGroup, ((i6 >> 15) & 14) | 920150448, 438);
            int i7 = i6 << 6;
            PassengerCountSelectorViewKt.PassengerCountSelectorView(columnScopeInstance, viewState.getOutboundPassengerCount(), viewState.getReturnPassengerCount(), checkoutState.getTransportation().getMaxPassengers(), viewState.getBookingType(), viewState.getSameReturnPassengersAsOutbound(), viewState.getLockOutbound(), function1, function2, startRestartGroup, (29360128 & i6) | 6 | (i7 & 234881024));
            boolean isValidToProceed = isValidToProceed(viewState);
            if (isValidToProceed && !viewState.getSameReturnPassengersAsOutbound() && viewState.getOutboundPassengerCount() != viewState.getReturnPassengerCount()) {
                startRestartGroup.startReplaceGroup(-1219660452);
                stringResource = StringResources_androidKt.stringResource(R.string.checkout_buttonBar_proceed, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            } else if (isValidToProceed) {
                startRestartGroup.startReplaceGroup(-1219657626);
                stringResource = StringResources_androidKt.pluralStringResource(R.plurals.passengers_proceedButton_validCount, viewState.getOutboundPassengerCount(), new Object[]{Integer.valueOf(viewState.getOutboundPassengerCount())}, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1219651033);
                stringResource = StringResources_androidKt.stringResource(R.string.passengers_proceedButton_invalidCount, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            }
            CheckoutButtonSheetBottomBarKt.CheckoutButtonSheetBottomBar(ModifierExtensionsKt.topShadow(companion), stringResource, checkoutState.getPriceDetails().getTotalPrice(), editState.getIsEditing(), null, isValidToProceed, function02, null, function0, startRestartGroup, (i7 & 3670016) | ((i6 << 15) & 234881024), 144);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: V2.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PassengerCountContent$lambda$11;
                    PassengerCountContent$lambda$11 = PassengerCountScreenKt.PassengerCountContent$lambda$11(PassengerCountViewModel.ViewState.this, checkoutState, editState, function0, function02, function03, function2, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PassengerCountContent$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCountContent$lambda$11(PassengerCountViewModel.ViewState viewState, CheckoutManager.CheckoutState checkoutState, EditManager.EditState editState, Function0 function0, Function0 function02, Function0 function03, Function2 function2, Function1 function1, int i5, Composer composer, int i6) {
        PassengerCountContent(viewState, checkoutState, editState, function0, function02, function03, function2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void PassengerCountScreen(final PassengerCountViewModel viewModel, final DestinationsNavigator navigator, final ICheckoutExpirationDialogHandler checkoutExpirationDialogHandler, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(checkoutExpirationDialogHandler, "checkoutExpirationDialogHandler");
        Composer startRestartGroup = composer.startRestartGroup(-683941161);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= (i5 & 512) == 0 ? startRestartGroup.changed(checkoutExpirationDialogHandler) : startRestartGroup.changedInstance(checkoutExpirationDialogHandler) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-683941161, i6, -1, "dk.molslinjen.ui.views.screens.booking.passengers.count.PassengerCountScreen (PassengerCountScreen.kt:49)");
            }
            int i7 = i6 & 112;
            checkoutExpirationDialogHandler.HandleDepartureExpiration(viewModel, navigator, startRestartGroup, i6 & 1022);
            PassengerCountViewModel.ViewState viewState = (PassengerCountViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            CheckoutManager.CheckoutState checkoutState = (CheckoutManager.CheckoutState) SnapshotStateKt.collectAsState(viewModel.getCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            if (checkoutState == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: V2.a
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit PassengerCountScreen$lambda$0;
                            PassengerCountScreen$lambda$0 = PassengerCountScreenKt.PassengerCountScreen$lambda$0(PassengerCountViewModel.this, navigator, checkoutExpirationDialogHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return PassengerCountScreen$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            EditManager.EditState editState = (EditManager.EditState) SnapshotStateKt.collectAsState(viewModel.getEditState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(-742215611);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel) | (i7 == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: V2.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PassengerCountScreen$lambda$2$lambda$1;
                        PassengerCountScreen$lambda$2$lambda$1 = PassengerCountScreenKt.PassengerCountScreen$lambda$2$lambda$1(PassengerCountViewModel.this, navigator);
                        return PassengerCountScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-742213248);
            boolean z5 = i7 == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: V2.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PassengerCountScreen$lambda$4$lambda$3;
                        PassengerCountScreen$lambda$4$lambda$3 = PassengerCountScreenKt.PassengerCountScreen$lambda$4$lambda$3(DestinationsNavigator.this);
                        return PassengerCountScreen$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function0 function02 = (Function0) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-742209371);
            boolean z6 = i7 == 32;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: V2.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PassengerCountScreen$lambda$6$lambda$5;
                        PassengerCountScreen$lambda$6$lambda$5 = PassengerCountScreenKt.PassengerCountScreen$lambda$6$lambda$5(DestinationsNavigator.this);
                        return PassengerCountScreen$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            Function0 function03 = (Function0) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-742205957);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new PassengerCountScreenKt$PassengerCountScreen$4$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            Function2 function2 = (Function2) ((KFunction) rememberedValue4);
            startRestartGroup.startReplaceGroup(-742203350);
            boolean changedInstance3 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new PassengerCountScreenKt$PassengerCountScreen$5$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            PassengerCountContent(viewState, checkoutState, editState, function0, function02, function03, function2, (Function1) ((KFunction) rememberedValue5), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: V2.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PassengerCountScreen$lambda$9;
                    PassengerCountScreen$lambda$9 = PassengerCountScreenKt.PassengerCountScreen$lambda$9(PassengerCountViewModel.this, navigator, checkoutExpirationDialogHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PassengerCountScreen$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCountScreen$lambda$0(PassengerCountViewModel passengerCountViewModel, DestinationsNavigator destinationsNavigator, ICheckoutExpirationDialogHandler iCheckoutExpirationDialogHandler, int i5, Composer composer, int i6) {
        PassengerCountScreen(passengerCountViewModel, destinationsNavigator, iCheckoutExpirationDialogHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCountScreen$lambda$2$lambda$1(PassengerCountViewModel passengerCountViewModel, DestinationsNavigator destinationsNavigator) {
        passengerCountViewModel.proceed(new PassengerCountScreenKt$PassengerCountScreen$1$1$1(destinationsNavigator));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCountScreen$lambda$4$lambda$3(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, CheckoutDetailsScreenDestination.INSTANCE.invoke(TicketSection.Passenger), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCountScreen$lambda$6$lambda$5(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, PassengerHelpScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCountScreen$lambda$9(PassengerCountViewModel passengerCountViewModel, DestinationsNavigator destinationsNavigator, ICheckoutExpirationDialogHandler iCheckoutExpirationDialogHandler, int i5, Composer composer, int i6) {
        PassengerCountScreen(passengerCountViewModel, destinationsNavigator, iCheckoutExpirationDialogHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final boolean isValidToProceed(PassengerCountViewModel.ViewState viewState) {
        return viewState.getOutboundPassengerCount() > 0;
    }
}
