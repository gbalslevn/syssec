package dk.molslinjen.ui.views.screens.booking.addons.seating.select;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import androidx.view.OnBackPressedDispatcherKt;
import androidx.view.OnBackPressedDispatcherOwner;
import androidx.view.compose.LocalOnBackPressedDispatcherOwner;
import com.ramcosta.composedestinations.generated.destinations.AddonsScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BlockedDismissType;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetDismissHandler;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.dialog.DeleteDialogKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsScreenKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeat;
import uniffi.molslinjen_shared.FerrySeatingSectionDetails;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a7\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001aG\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0003¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Landroidx/navigation/NavController;", "navController", "Landroidx/navigation/NavBackStackEntry;", "navBackStackEntry", "Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetDismissHandler;", "bottomSheetDismissHandler", BuildConfig.FLAVOR, "FerrySectionSeatsScreen", "(Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/navigation/NavController;Landroidx/navigation/NavBackStackEntry;Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetDismissHandler;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel$ViewState;", "state", "Lkotlin/Function1;", "Luniffi/molslinjen_shared/FerrySeat;", "onToggleSeat", "Lkotlin/Function0;", "onConfirmPressed", "onDeleteReservationPressed", "Content", "(Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel$ViewState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FerrySectionSeatsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void Content(final FerrySectionSeatsViewModel.ViewState viewState, final Function1<? super FerrySeat, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(749434287);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(749434287, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.select.Content (FerrySectionSeatsScreen.kt:153)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.INSTANCE.getStart(), startRestartGroup, 6);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            SeatTypesViewKt.SeatTypesView(viewState.getSeatTypes(), startRestartGroup, 0);
            FerrySeatingSectionDetails sectionDetails = viewState.getSectionDetails();
            startRestartGroup.startReplaceGroup(1625444961);
            if (sectionDetails != null) {
                FerrySectionSeatsContainerKt.m3444FerrySectionSeatsContainercliRtBg(columnScopeInstance, sectionDetails, viewState.getInitialFocusPoint(), viewState.getSelectedSeats(), function1, startRestartGroup, 6 | ((i6 << 9) & 57344));
            }
            startRestartGroup.endReplaceGroup();
            SeatsActionSheetKt.SeatsActionSheet(viewState.getMaxNumberOfPassengers(), viewState.getSelectedSeats(), function1, function0, viewState.getHasExistingReservation() ? function02 : null, startRestartGroup, (i6 << 3) & 8064, 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: I2.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$17;
                    Content$lambda$17 = FerrySectionSeatsScreenKt.Content$lambda$17(FerrySectionSeatsViewModel.ViewState.this, function1, function0, function02, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$17;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$17(FerrySectionSeatsViewModel.ViewState viewState, Function1 function1, Function0 function0, Function0 function02, int i5, Composer composer, int i6) {
        Content(viewState, function1, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void FerrySectionSeatsScreen(final FerrySectionSeatsViewModel viewModel, final DestinationsNavigator navigator, final NavController navController, final NavBackStackEntry navBackStackEntry, final BottomSheetDismissHandler bottomSheetDismissHandler, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Intrinsics.checkNotNullParameter(bottomSheetDismissHandler, "bottomSheetDismissHandler");
        Composer startRestartGroup = composer.startRestartGroup(1765692172);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(navController) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(navBackStackEntry) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(bottomSheetDismissHandler) ? 16384 : 8192;
        }
        int i7 = i6;
        if ((i7 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1765692172, i7, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsScreen (FerrySectionSeatsScreen.kt:53)");
            }
            bottomSheetDismissHandler.SetupHandling(navBackStackEntry, navController, navigator, BlockedDismissType.DragToDismiss, startRestartGroup, ((i7 >> 9) & 14) | 3072 | ((i7 >> 3) & 112) | ((i7 << 3) & 896) | (57344 & i7));
            final FerrySectionSeatsViewModel.ViewState viewState = (FerrySectionSeatsViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(-1254368005);
            boolean changedInstance = ((i7 & 112) == 32) | startRestartGroup.changedInstance(bottomSheetDismissHandler);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: I2.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit FerrySectionSeatsScreen$lambda$1$lambda$0;
                        FerrySectionSeatsScreen$lambda$1$lambda$0 = FerrySectionSeatsScreenKt.FerrySectionSeatsScreen$lambda$1$lambda$0(BottomSheetDismissHandler.this, navigator, ((Boolean) obj).booleanValue());
                        return FerrySectionSeatsScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final Function1 function1 = (Function1) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1254355997);
            if (viewState.getCloseWarningState() instanceof FerrySectionSeatsViewModel.ViewState.CloseWarning.Show) {
                String stringResource = StringResources_androidKt.stringResource(R.string.selectSeat_dialog_leaveSectionTitle, startRestartGroup, 6);
                String stringResource2 = StringResources_androidKt.stringResource(R.string.button_leaveSection, startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(-1254340854);
                boolean changedInstance2 = startRestartGroup.changedInstance(viewModel);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new FerrySectionSeatsScreenKt$FerrySectionSeatsScreen$1$1(viewModel);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                KFunction kFunction = (KFunction) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1254346493);
                boolean changedInstance3 = startRestartGroup.changedInstance(viewModel) | startRestartGroup.changed(function1) | startRestartGroup.changedInstance(viewState);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: I2.g
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit FerrySectionSeatsScreen$lambda$4$lambda$3;
                            FerrySectionSeatsScreen$lambda$4$lambda$3 = FerrySectionSeatsScreenKt.FerrySectionSeatsScreen$lambda$4$lambda$3(FerrySectionSeatsViewModel.this, function1, viewState);
                            return FerrySectionSeatsScreen$lambda$4$lambda$3;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                Function0 function0 = (Function0) kFunction;
                composer2 = startRestartGroup;
                DeleteDialogKt.DeleteDialog(stringResource, null, stringResource2, null, false, (Function0) rememberedValue3, function0, composer2, 24576, 10);
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1254338856);
            if (viewState.getShowDeletePrompt()) {
                String stringResource3 = StringResources_androidKt.stringResource(R.string.selectSeat_dialog_deleteReservationTitle, composer2, 6);
                String stringResource4 = StringResources_androidKt.stringResource(R.string.button_deleteSeatReservation, composer2, 6);
                boolean isDeleteLoading = viewState.getIsDeleteLoading();
                composer2.startReplaceGroup(-1254329259);
                boolean changedInstance4 = composer2.changedInstance(viewModel) | composer2.changed(function1);
                Object rememberedValue4 = composer2.rememberedValue();
                if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: I2.h
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit FerrySectionSeatsScreen$lambda$6$lambda$5;
                            FerrySectionSeatsScreen$lambda$6$lambda$5 = FerrySectionSeatsScreenKt.FerrySectionSeatsScreen$lambda$6$lambda$5(FerrySectionSeatsViewModel.this, function1);
                            return FerrySectionSeatsScreen$lambda$6$lambda$5;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue4);
                }
                Function0 function02 = (Function0) rememberedValue4;
                composer2.endReplaceGroup();
                composer2.startReplaceGroup(-1254326038);
                boolean changedInstance5 = composer2.changedInstance(viewModel);
                Object rememberedValue5 = composer2.rememberedValue();
                if (changedInstance5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue5 = new FerrySectionSeatsScreenKt$FerrySectionSeatsScreen$4$1(viewModel);
                    composer2.updateRememberedValue(rememberedValue5);
                }
                composer2.endReplaceGroup();
                DeleteDialogKt.DeleteDialog(stringResource3, null, stringResource4, null, isDeleteLoading, function02, (Function0) ((KFunction) rememberedValue5), composer2, 0, 10);
            }
            composer2.endReplaceGroup();
            boolean hasExistingReservation = viewState.getHasExistingReservation();
            composer2.startReplaceGroup(-1254321837);
            boolean changed = composer2.changed(!hasExistingReservation);
            Object rememberedValue6 = composer2.rememberedValue();
            if (changed || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = !hasExistingReservation ? new Function0() { // from class: I2.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit FerrySectionSeatsScreen$lambda$9$lambda$8;
                        FerrySectionSeatsScreen$lambda$9$lambda$8 = FerrySectionSeatsScreenKt.FerrySectionSeatsScreen$lambda$9$lambda$8(FerrySectionSeatsViewModel.this, function1);
                        return FerrySectionSeatsScreen$lambda$9$lambda$8;
                    }
                } : null;
                composer2.updateRememberedValue(rememberedValue6);
            }
            final Function0 function03 = (Function0) rememberedValue6;
            composer2.endReplaceGroup();
            OnBackPressedDispatcherOwner current = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(composer2, LocalOnBackPressedDispatcherOwner.$stable);
            OnBackPressedDispatcher onBackPressedDispatcher = current != null ? current.getOnBackPressedDispatcher() : null;
            composer2.startReplaceGroup(-1254309359);
            if (onBackPressedDispatcher != null) {
                composer2.startReplaceGroup(-1254308987);
                boolean changed2 = composer2.changed(function03) | composer2.changed(function1);
                Object rememberedValue7 = composer2.rememberedValue();
                if (changed2 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue7 = new Function1() { // from class: I2.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit FerrySectionSeatsScreen$lambda$11$lambda$10;
                            FerrySectionSeatsScreen$lambda$11$lambda$10 = FerrySectionSeatsScreenKt.FerrySectionSeatsScreen$lambda$11$lambda$10(Function0.this, function1, (OnBackPressedCallback) obj);
                            return FerrySectionSeatsScreen$lambda$11$lambda$10;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue7);
                }
                composer2.endReplaceGroup();
                OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, null, false, (Function1) rememberedValue7, 3, null);
            }
            composer2.endReplaceGroup();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            String stringResource5 = StringResources_androidKt.stringResource(R.string.selectSeat_chooseSeats, composer2, 6);
            composer2.startReplaceGroup(-1254300734);
            boolean changedInstance6 = composer2.changedInstance(viewModel) | composer2.changed(function1);
            Object rememberedValue8 = composer2.rememberedValue();
            if (changedInstance6 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = new Function0() { // from class: I2.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit FerrySectionSeatsScreen$lambda$13$lambda$12;
                        FerrySectionSeatsScreen$lambda$13$lambda$12 = FerrySectionSeatsScreenKt.FerrySectionSeatsScreen$lambda$13$lambda$12(FerrySectionSeatsViewModel.this, function1);
                        return FerrySectionSeatsScreen$lambda$13$lambda$12;
                    }
                };
                composer2.updateRememberedValue(rememberedValue8);
            }
            composer2.endReplaceGroup();
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(fillMaxSize$default, 0.0f, stringResource5, null, 0L, function03, (Function0) rememberedValue8, null, null, ComposableLambdaKt.rememberComposableLambda(902191385, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsScreenKt$FerrySectionSeatsScreen$7

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsScreenKt$FerrySectionSeatsScreen$7$1, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
                    final /* synthetic */ Function1<Boolean, Unit> $dismiss;
                    final /* synthetic */ FerrySectionSeatsViewModel.ViewState $state;
                    final /* synthetic */ FerrySectionSeatsViewModel $viewModel;

                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass1(FerrySectionSeatsViewModel.ViewState viewState, FerrySectionSeatsViewModel ferrySectionSeatsViewModel, Function1<? super Boolean, Unit> function1) {
                        this.$state = viewState;
                        this.$viewModel = ferrySectionSeatsViewModel;
                        this.$dismiss = function1;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$2$lambda$1(FerrySectionSeatsViewModel ferrySectionSeatsViewModel, Function1 function1) {
                        ferrySectionSeatsViewModel.onConfirm(function1);
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i5) {
                        if ((i5 & 3) == 2 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2127772571, i5, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsScreen.<anonymous>.<anonymous> (FerrySectionSeatsScreen.kt:135)");
                        }
                        FerrySectionSeatsViewModel.ViewState viewState = this.$state;
                        FerrySectionSeatsViewModel ferrySectionSeatsViewModel = this.$viewModel;
                        composer.startReplaceGroup(24892706);
                        boolean changedInstance = composer.changedInstance(ferrySectionSeatsViewModel);
                        Object rememberedValue = composer.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new FerrySectionSeatsScreenKt$FerrySectionSeatsScreen$7$1$1$1(ferrySectionSeatsViewModel);
                            composer.updateRememberedValue(rememberedValue);
                        }
                        composer.endReplaceGroup();
                        Function1 function1 = (Function1) ((KFunction) rememberedValue);
                        composer.startReplaceGroup(24894609);
                        boolean changedInstance2 = composer.changedInstance(this.$viewModel) | composer.changed(this.$dismiss);
                        final FerrySectionSeatsViewModel ferrySectionSeatsViewModel2 = this.$viewModel;
                        final Function1<Boolean, Unit> function12 = this.$dismiss;
                        Object rememberedValue2 = composer.rememberedValue();
                        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0073: CONSTRUCTOR (r2v1 'rememberedValue2' java.lang.Object) = 
                                  (r0v6 'ferrySectionSeatsViewModel2' dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel A[DONT_INLINE])
                                  (r1v5 'function12' kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> A[DONT_INLINE])
                                 A[MD:(dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel, kotlin.jvm.functions.Function1):void (m)] (LINE:15) call: dk.molslinjen.ui.views.screens.booking.addons.seating.select.a.<init>(dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel, kotlin.jvm.functions.Function1):void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsScreenKt$FerrySectionSeatsScreen$7.1.invoke(androidx.compose.runtime.Composer, int):void, file: classes2.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.booking.addons.seating.select.a, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 25 more
                                */
                            /*
                                this = this;
                                r0 = r11 & 3
                                r1 = 2
                                if (r0 != r1) goto L11
                                boolean r0 = r10.getSkipping()
                                if (r0 != 0) goto Lc
                                goto L11
                            Lc:
                                r10.skipToGroupEnd()
                                goto Lb7
                            L11:
                                boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                if (r0 == 0) goto L20
                                r0 = -1
                                java.lang.String r1 = "dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsScreen.<anonymous>.<anonymous> (FerrySectionSeatsScreen.kt:135)"
                                r2 = -2127772571(0xffffffff812cc465, float:-3.1732317E-38)
                                androidx.compose.runtime.ComposerKt.traceEventStart(r2, r11, r0, r1)
                            L20:
                                dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$ViewState r3 = r9.$state
                                dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel r11 = r9.$viewModel
                                r0 = 24892706(0x17bd522, float:4.6254334E-38)
                                r10.startReplaceGroup(r0)
                                boolean r0 = r10.changedInstance(r11)
                                java.lang.Object r1 = r10.rememberedValue()
                                if (r0 != 0) goto L3c
                                androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.INSTANCE
                                java.lang.Object r0 = r0.getEmpty()
                                if (r1 != r0) goto L44
                            L3c:
                                dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsScreenKt$FerrySectionSeatsScreen$7$1$1$1 r1 = new dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsScreenKt$FerrySectionSeatsScreen$7$1$1$1
                                r1.<init>(r11)
                                r10.updateRememberedValue(r1)
                            L44:
                                kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
                                r10.endReplaceGroup()
                                r4 = r1
                                kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
                                r11 = 24894609(0x17bdc91, float:4.6259668E-38)
                                r10.startReplaceGroup(r11)
                                dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel r11 = r9.$viewModel
                                boolean r11 = r10.changedInstance(r11)
                                kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r0 = r9.$dismiss
                                boolean r0 = r10.changed(r0)
                                r11 = r11 | r0
                                dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel r0 = r9.$viewModel
                                kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r1 = r9.$dismiss
                                java.lang.Object r2 = r10.rememberedValue()
                                if (r11 != 0) goto L71
                                androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.INSTANCE
                                java.lang.Object r11 = r11.getEmpty()
                                if (r2 != r11) goto L79
                            L71:
                                dk.molslinjen.ui.views.screens.booking.addons.seating.select.a r2 = new dk.molslinjen.ui.views.screens.booking.addons.seating.select.a
                                r2.<init>(r0, r1)
                                r10.updateRememberedValue(r2)
                            L79:
                                r5 = r2
                                kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
                                r10.endReplaceGroup()
                                dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel r11 = r9.$viewModel
                                r0 = 24898248(0x17beac8, float:4.6269866E-38)
                                r10.startReplaceGroup(r0)
                                boolean r0 = r10.changedInstance(r11)
                                java.lang.Object r1 = r10.rememberedValue()
                                if (r0 != 0) goto L99
                                androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.INSTANCE
                                java.lang.Object r0 = r0.getEmpty()
                                if (r1 != r0) goto La1
                            L99:
                                dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsScreenKt$FerrySectionSeatsScreen$7$1$3$1 r1 = new dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsScreenKt$FerrySectionSeatsScreen$7$1$3$1
                                r1.<init>(r11)
                                r10.updateRememberedValue(r1)
                            La1:
                                kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
                                r10.endReplaceGroup()
                                r6 = r1
                                kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
                                r8 = 0
                                r7 = r10
                                dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsScreenKt.access$Content(r3, r4, r5, r6, r7, r8)
                                boolean r10 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                if (r10 == 0) goto Lb7
                                androidx.compose.runtime.ComposerKt.traceEventEnd()
                            Lb7:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsScreenKt$FerrySectionSeatsScreen$7.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                        }
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                        invoke(columnScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i8) {
                        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                        if ((i8 & 17) == 16 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(902191385, i8, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsScreen.<anonymous> (FerrySectionSeatsScreen.kt:131)");
                        }
                        LoadingComponentKt.m3392LoadingComponentjfnsLPA(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, FerrySectionSeatsViewModel.ViewState.this.getIsLoading(), 0, false, null, ComposableLambdaKt.rememberComposableLambda(-2127772571, true, new AnonymousClass1(FerrySectionSeatsViewModel.ViewState.this, viewModel, function1), composer3, 54), composer3, 1572870, 58);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, 805306374, 410);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new Function2() { // from class: I2.l
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit FerrySectionSeatsScreen$lambda$14;
                        FerrySectionSeatsScreen$lambda$14 = FerrySectionSeatsScreenKt.FerrySectionSeatsScreen$lambda$14(FerrySectionSeatsViewModel.this, navigator, navController, navBackStackEntry, bottomSheetDismissHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                        return FerrySectionSeatsScreen$lambda$14;
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit FerrySectionSeatsScreen$lambda$1$lambda$0(BottomSheetDismissHandler bottomSheetDismissHandler, DestinationsNavigator destinationsNavigator, boolean z5) {
            if (z5) {
                bottomSheetDismissHandler.dismissPopBlockingSheets(destinationsNavigator, AddonsScreenDestination.INSTANCE, false);
            } else {
                BottomSheetDismissHandler.dismissPopBlockingSheets$default(bottomSheetDismissHandler, destinationsNavigator, null, false, 6, null);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit FerrySectionSeatsScreen$lambda$11$lambda$10(Function0 function0, Function1 function1, OnBackPressedCallback addCallback) {
            Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
            if (function0 != null) {
                function0.invoke();
            } else {
                function1.invoke(Boolean.FALSE);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit FerrySectionSeatsScreen$lambda$13$lambda$12(FerrySectionSeatsViewModel ferrySectionSeatsViewModel, Function1 function1) {
            if (ferrySectionSeatsViewModel.hasChanges()) {
                ferrySectionSeatsViewModel.showCloseWarning(true);
            } else {
                function1.invoke(Boolean.TRUE);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit FerrySectionSeatsScreen$lambda$14(FerrySectionSeatsViewModel ferrySectionSeatsViewModel, DestinationsNavigator destinationsNavigator, NavController navController, NavBackStackEntry navBackStackEntry, BottomSheetDismissHandler bottomSheetDismissHandler, int i5, Composer composer, int i6) {
            FerrySectionSeatsScreen(ferrySectionSeatsViewModel, destinationsNavigator, navController, navBackStackEntry, bottomSheetDismissHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit FerrySectionSeatsScreen$lambda$4$lambda$3(FerrySectionSeatsViewModel ferrySectionSeatsViewModel, Function1 function1, FerrySectionSeatsViewModel.ViewState viewState) {
            ferrySectionSeatsViewModel.cancelChanges();
            function1.invoke(Boolean.valueOf(((FerrySectionSeatsViewModel.ViewState.CloseWarning.Show) viewState.getCloseWarningState()).getPopToRoot()));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit FerrySectionSeatsScreen$lambda$6$lambda$5(FerrySectionSeatsViewModel ferrySectionSeatsViewModel, Function1 function1) {
            ferrySectionSeatsViewModel.onDeleteReservation(function1);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit FerrySectionSeatsScreen$lambda$9$lambda$8(FerrySectionSeatsViewModel ferrySectionSeatsViewModel, Function1 function1) {
            if (ferrySectionSeatsViewModel.hasChanges()) {
                ferrySectionSeatsViewModel.showCloseWarning(false);
            } else {
                function1.invoke(Boolean.FALSE);
            }
            return Unit.INSTANCE;
        }
    }
