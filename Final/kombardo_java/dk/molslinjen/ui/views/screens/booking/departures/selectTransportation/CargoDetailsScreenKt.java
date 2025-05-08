package dk.molslinjen.ui.views.screens.booking.departures.selectTransportation;

import android.content.Context;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.ResultBackNavigator;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BlockedDismissType;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetDismissHandler;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.NoteInputValidator;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsScreenKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsViewModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aE\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u008b\u0001\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\r0\u00122\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0\u00122\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0\u00122\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0\u00122\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0\u00122\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0003¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportation/CargoDetailsViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Landroidx/navigation/NavController;", "navController", "Landroidx/navigation/NavBackStackEntry;", "navBackStackEntry", "Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetDismissHandler;", "bottomSheetDismissHandler", "Lcom/ramcosta/composedestinations/result/ResultBackNavigator;", BuildConfig.FLAVOR, "resultNavigator", BuildConfig.FLAVOR, "CargoDetailsScreen", "(Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportation/CargoDetailsViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/navigation/NavController;Landroidx/navigation/NavBackStackEntry;Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetDismissHandler;Lcom/ramcosta/composedestinations/result/ResultBackNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportation/CargoDetailsViewModel$ViewState;", "viewState", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "changeSection", BuildConfig.FLAVOR, "onTotalWeightChange", "onNote1Change", "onNote2Change", "onNote3Change", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "outboundValidator", "returnValidator", "CargoDetailsContent", "(Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportation/CargoDetailsViewModel$ViewState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "maxWeightAllowed", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator;", "validatorsMap", "(D)Ljava/util/Map;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CargoDetailsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void CargoDetailsContent(final CargoDetailsViewModel.ViewState viewState, final Function1<? super DepartureDirection, Unit> function1, final Function1<? super String, Unit> function12, final Function1<? super String, Unit> function13, final Function1<? super String, Unit> function14, final Function1<? super String, Unit> function15, final IFormValidator iFormValidator, final IFormValidator iFormValidator2, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1777222375);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function13) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function14) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function15) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= (2097152 & i5) == 0 ? startRestartGroup.changed(iFormValidator) : startRestartGroup.changedInstance(iFormValidator) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= (16777216 & i5) == 0 ? startRestartGroup.changed(iFormValidator2) : startRestartGroup.changedInstance(iFormValidator2) ? 8388608 : 4194304;
        }
        if ((4793491 & i6) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1777222375, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsContent (CargoDetailsScreen.kt:165)");
            }
            composer2 = startRestartGroup;
            LoadingComponentKt.m3392LoadingComponentjfnsLPA(SizeKt.m324defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(100), 1, null), 0.0f, viewState.getIsLoading(), 0, false, null, ComposableLambdaKt.rememberComposableLambda(1793655653, true, new CargoDetailsScreenKt$CargoDetailsContent$1(viewState, function1, function12, function13, function14, function15, iFormValidator, iFormValidator2), startRestartGroup, 54), composer2, 1572870, 58);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: R2.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CargoDetailsContent$lambda$9;
                    CargoDetailsContent$lambda$9 = CargoDetailsScreenKt.CargoDetailsContent$lambda$9(CargoDetailsViewModel.ViewState.this, function1, function12, function13, function14, function15, iFormValidator, iFormValidator2, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CargoDetailsContent$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CargoDetailsContent$lambda$9(CargoDetailsViewModel.ViewState viewState, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, IFormValidator iFormValidator, IFormValidator iFormValidator2, int i5, Composer composer, int i6) {
        CargoDetailsContent(viewState, function1, function12, function13, function14, function15, iFormValidator, iFormValidator2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void CargoDetailsScreen(final CargoDetailsViewModel viewModel, final DestinationsNavigator navigator, final NavController navController, final NavBackStackEntry navBackStackEntry, final BottomSheetDismissHandler bottomSheetDismissHandler, final ResultBackNavigator<Boolean> resultNavigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Intrinsics.checkNotNullParameter(bottomSheetDismissHandler, "bottomSheetDismissHandler");
        Intrinsics.checkNotNullParameter(resultNavigator, "resultNavigator");
        Composer startRestartGroup = composer.startRestartGroup(1656445085);
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
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(resultNavigator) ? 131072 : 65536;
        }
        int i7 = i6;
        if ((74899 & i7) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1656445085, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsScreen (CargoDetailsScreen.kt:63)");
            }
            bottomSheetDismissHandler.SetupHandling(navBackStackEntry, navController, navigator, BlockedDismissType.DragToDismissAndBackAction, startRestartGroup, ((i7 >> 9) & 14) | 3072 | ((i7 >> 3) & 112) | ((i7 << 3) & 896) | (57344 & i7));
            startRestartGroup.startReplaceGroup(-1814006183);
            boolean changedInstance = startRestartGroup.changedInstance(bottomSheetDismissHandler) | ((i7 & 458752) == 131072);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: R2.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit CargoDetailsScreen$lambda$2$lambda$1;
                        CargoDetailsScreen$lambda$2$lambda$1 = CargoDetailsScreenKt.CargoDetailsScreen$lambda$2$lambda$1(BottomSheetDismissHandler.this, resultNavigator, ((Boolean) obj).booleanValue());
                        return CargoDetailsScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final Function1 function1 = (Function1) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Boolean bool = Boolean.TRUE;
            startRestartGroup.startReplaceGroup(-1813991702);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel) | startRestartGroup.changed(function1);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new CargoDetailsScreenKt$CargoDetailsScreen$1$1(viewModel, function1, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(bool, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, 6);
            Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final CargoDetailsViewModel.ViewState viewState = (CargoDetailsViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue3 == companion.getEmpty()) {
                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue3 = compositionScopedCoroutineScopeCanceller;
            }
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue3).getCoroutineScope();
            double maxWeightAllowed = viewState.getMaxWeightAllowed();
            startRestartGroup.startReplaceGroup(-1813984768);
            boolean changed = startRestartGroup.changed(maxWeightAllowed);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new FormValidator(validatorsMap(viewState.getMaxWeightAllowed()), coroutineScope);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final FormValidator formValidator = (FormValidator) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            double maxWeightAllowed2 = viewState.getMaxWeightAllowed();
            startRestartGroup.startReplaceGroup(-1813978880);
            boolean changed2 = startRestartGroup.changed(maxWeightAllowed2);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new FormValidator(validatorsMap(viewState.getMaxWeightAllowed()), coroutineScope);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final FormValidator formValidator2 = (FormValidator) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1813973081);
            startRestartGroup.startReplaceGroup(-1813973169);
            boolean z5 = !viewState.getIsLoading() && ((Boolean) SnapshotStateKt.collectAsState(formValidator.isFormValid(), null, startRestartGroup, 0, 1).getValue()).booleanValue();
            startRestartGroup.endReplaceGroup();
            boolean z6 = z5 && (((Boolean) SnapshotStateKt.collectAsState(formValidator2.isFormValid(), null, startRestartGroup, 0, 1).getValue()).booleanValue() || !viewState.getHasReturn());
            startRestartGroup.endReplaceGroup();
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, null, false, 14, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.cargoDetails_title, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-1813960524);
            boolean changed3 = startRestartGroup.changed(function1);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new Function0() { // from class: R2.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CargoDetailsScreen$lambda$7$lambda$6;
                        CargoDetailsScreen$lambda$7$lambda$6 = CargoDetailsScreenKt.CargoDetailsScreen$lambda$7$lambda$6(Function1.this);
                        return CargoDetailsScreen$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1783625185, true, new CargoDetailsScreenKt$CargoDetailsScreen$3(z6, formValidator, formValidator2, context, viewState, viewModel, function1), startRestartGroup, 54);
            ComposableLambda rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-724642064, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsScreenKt$CargoDetailsScreen$4
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
                        ComposerKt.traceEventStart(-724642064, i8, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsScreen.<anonymous> (CargoDetailsScreen.kt:142)");
                    }
                    CargoDetailsViewModel cargoDetailsViewModel = CargoDetailsViewModel.this;
                    composer3.startReplaceGroup(-923492518);
                    boolean changedInstance3 = composer3.changedInstance(cargoDetailsViewModel);
                    Object rememberedValue7 = composer3.rememberedValue();
                    if (changedInstance3 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue7 = new CargoDetailsScreenKt$CargoDetailsScreen$4$1$1(cargoDetailsViewModel);
                        composer3.updateRememberedValue(rememberedValue7);
                    }
                    KFunction kFunction = (KFunction) rememberedValue7;
                    composer3.endReplaceGroup();
                    CargoDetailsViewModel cargoDetailsViewModel2 = CargoDetailsViewModel.this;
                    composer3.startReplaceGroup(-923487456);
                    boolean changedInstance4 = composer3.changedInstance(cargoDetailsViewModel2);
                    Object rememberedValue8 = composer3.rememberedValue();
                    if (changedInstance4 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue8 = new CargoDetailsScreenKt$CargoDetailsScreen$4$2$1(cargoDetailsViewModel2);
                        composer3.updateRememberedValue(rememberedValue8);
                    }
                    KFunction kFunction2 = (KFunction) rememberedValue8;
                    composer3.endReplaceGroup();
                    CargoDetailsViewModel cargoDetailsViewModel3 = CargoDetailsViewModel.this;
                    composer3.startReplaceGroup(-923485542);
                    boolean changedInstance5 = composer3.changedInstance(cargoDetailsViewModel3);
                    Object rememberedValue9 = composer3.rememberedValue();
                    if (changedInstance5 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue9 = new CargoDetailsScreenKt$CargoDetailsScreen$4$3$1(cargoDetailsViewModel3);
                        composer3.updateRememberedValue(rememberedValue9);
                    }
                    KFunction kFunction3 = (KFunction) rememberedValue9;
                    composer3.endReplaceGroup();
                    CargoDetailsViewModel cargoDetailsViewModel4 = CargoDetailsViewModel.this;
                    composer3.startReplaceGroup(-923483814);
                    boolean changedInstance6 = composer3.changedInstance(cargoDetailsViewModel4);
                    Object rememberedValue10 = composer3.rememberedValue();
                    if (changedInstance6 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue10 = new CargoDetailsScreenKt$CargoDetailsScreen$4$4$1(cargoDetailsViewModel4);
                        composer3.updateRememberedValue(rememberedValue10);
                    }
                    KFunction kFunction4 = (KFunction) rememberedValue10;
                    composer3.endReplaceGroup();
                    CargoDetailsViewModel cargoDetailsViewModel5 = CargoDetailsViewModel.this;
                    composer3.startReplaceGroup(-923482086);
                    boolean changedInstance7 = composer3.changedInstance(cargoDetailsViewModel5);
                    Object rememberedValue11 = composer3.rememberedValue();
                    if (changedInstance7 || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue11 = new CargoDetailsScreenKt$CargoDetailsScreen$4$5$1(cargoDetailsViewModel5);
                        composer3.updateRememberedValue(rememberedValue11);
                    }
                    composer3.endReplaceGroup();
                    CargoDetailsScreenKt.CargoDetailsContent(viewState, (Function1) kFunction, (Function1) kFunction2, (Function1) kFunction3, (Function1) kFunction4, (Function1) ((KFunction) rememberedValue11), formValidator, formValidator2, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(verticalScroll$default, 0.0f, stringResource, null, 0L, null, (Function0) rememberedValue6, null, rememberComposableLambda, rememberComposableLambda2, composer2, 905969664, 186);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: R2.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CargoDetailsScreen$lambda$8;
                    CargoDetailsScreen$lambda$8 = CargoDetailsScreenKt.CargoDetailsScreen$lambda$8(CargoDetailsViewModel.this, navigator, navController, navBackStackEntry, bottomSheetDismissHandler, resultNavigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CargoDetailsScreen$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CargoDetailsScreen$lambda$2$lambda$1(BottomSheetDismissHandler bottomSheetDismissHandler, final ResultBackNavigator resultBackNavigator, final boolean z5) {
        bottomSheetDismissHandler.dismissPopBlockingSheets(new Function0() { // from class: R2.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit CargoDetailsScreen$lambda$2$lambda$1$lambda$0;
                CargoDetailsScreen$lambda$2$lambda$1$lambda$0 = CargoDetailsScreenKt.CargoDetailsScreen$lambda$2$lambda$1$lambda$0(ResultBackNavigator.this, z5);
                return CargoDetailsScreen$lambda$2$lambda$1$lambda$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CargoDetailsScreen$lambda$2$lambda$1$lambda$0(ResultBackNavigator resultBackNavigator, boolean z5) {
        resultBackNavigator.navigateBack(Boolean.valueOf(z5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CargoDetailsScreen$lambda$7$lambda$6(Function1 function1) {
        function1.invoke(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CargoDetailsScreen$lambda$8(CargoDetailsViewModel cargoDetailsViewModel, DestinationsNavigator destinationsNavigator, NavController navController, NavBackStackEntry navBackStackEntry, BottomSheetDismissHandler bottomSheetDismissHandler, ResultBackNavigator resultBackNavigator, int i5, Composer composer, int i6) {
        CargoDetailsScreen(cargoDetailsViewModel, destinationsNavigator, navController, navBackStackEntry, bottomSheetDismissHandler, resultBackNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final Map<IFormValidator.ValidationKey, IInputValidator> validatorsMap(double d5) {
        Pair pair = TuplesKt.to(CargoFormField.Weight, new CargoInputValidator(d5));
        CargoFormField cargoFormField = CargoFormField.Note1;
        NoteInputValidator noteInputValidator = NoteInputValidator.INSTANCE;
        return MapsKt.mapOf(pair, TuplesKt.to(cargoFormField, noteInputValidator), TuplesKt.to(CargoFormField.Note2, noteInputValidator), TuplesKt.to(CargoFormField.Note3, noteInputValidator));
    }
}
