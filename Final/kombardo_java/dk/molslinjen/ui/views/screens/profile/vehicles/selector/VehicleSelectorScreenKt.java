package dk.molslinjen.ui.views.screens.profile.vehicles.selector;

import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.generated.destinations.ProfileVehiclesRegisterScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.ResultBackNavigator;
import defpackage.ProfileVehiclesListKt;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.dialog.SimpleButtonData;
import dk.molslinjen.ui.views.reusable.dialog.TextDialogKt;
import dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt;
import dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorScreenKt;
import dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorViewModel;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"VehicleSelectorScreen", BuildConfig.FLAVOR, "viewModel", "Ldk/molslinjen/ui/views/screens/profile/vehicles/selector/VehicleSelectorViewModel;", "navigator", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "resultNavigator", "Lcom/ramcosta/composedestinations/result/ResultBackNavigator;", "Ldk/molslinjen/domain/model/account/UserVehicle;", "(Ldk/molslinjen/ui/views/screens/profile/vehicles/selector/VehicleSelectorViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultBackNavigator;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class VehicleSelectorScreenKt {
    public static final void VehicleSelectorScreen(final VehicleSelectorViewModel viewModel, final DestinationsNavigator navigator, final ResultBackNavigator<UserVehicle> resultNavigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(resultNavigator, "resultNavigator");
        Composer startRestartGroup = composer.startRestartGroup(-1346748538);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(resultNavigator) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1346748538, i6, -1, "dk.molslinjen.ui.views.screens.profile.vehicles.selector.VehicleSelectorScreen (VehicleSelectorScreen.kt:48)");
            }
            final VehicleSelectorViewModel.ViewState viewState = (VehicleSelectorViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            List plus = CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) viewState.getAvailableVehicles(), (Iterable) viewState.getUnavailableVehicles()), (Iterable) viewState.getUnvalidatedVehicles());
            startRestartGroup.startReplaceGroup(-1797676123);
            boolean z5 = (i6 & 896) == 256;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: c4.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit VehicleSelectorScreen$lambda$1$lambda$0;
                        VehicleSelectorScreen$lambda$1$lambda$0 = VehicleSelectorScreenKt.VehicleSelectorScreen$lambda$1$lambda$0(ResultBackNavigator.this, (UserVehicle) obj);
                        return VehicleSelectorScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final Function1 function1 = (Function1) rememberedValue;
            startRestartGroup.endReplaceGroup();
            String stringResource = StringResources_androidKt.stringResource(R.string.vehicleSelector_title, startRestartGroup, 6);
            boolean isLoading = viewState.getIsLoading();
            boolean isEmpty = plus.isEmpty();
            startRestartGroup.startReplaceGroup(-1797667236);
            int i7 = i6 & 112;
            boolean z6 = i7 == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new VehicleSelectorScreenKt$VehicleSelectorScreen$1$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function0 function0 = (Function0) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            String stringResource2 = StringResources_androidKt.stringResource(R.string.profile_vehicles_emptyDescription, startRestartGroup, 6);
            String stringResource3 = StringResources_androidKt.stringResource(R.string.profile_vehicles_registerVehicle, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-1797657723);
            boolean z7 = i7 == 32;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: c4.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit VehicleSelectorScreen$lambda$4$lambda$3;
                        VehicleSelectorScreen$lambda$4$lambda$3 = VehicleSelectorScreenKt.VehicleSelectorScreen$lambda$4$lambda$3(DestinationsNavigator.this);
                        return VehicleSelectorScreen$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            Function0 function02 = (Function0) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1797653124);
            boolean changedInstance = startRestartGroup.changedInstance(viewState) | startRestartGroup.changedInstance(viewModel) | startRestartGroup.changed(function1);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: c4.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit VehicleSelectorScreen$lambda$7$lambda$6;
                        VehicleSelectorScreen$lambda$7$lambda$6 = VehicleSelectorScreenKt.VehicleSelectorScreen$lambda$7$lambda$6(VehicleSelectorViewModel.ViewState.this, viewModel, function1, (LazyListScope) obj);
                        return VehicleSelectorScreen$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            ProfileAssetsContainerKt.ProfileAssetsListContainer(stringResource, null, isLoading, isEmpty, function0, null, R.drawable.icon_profile_vehicles, stringResource2, null, stringResource3, function02, null, (Function1) rememberedValue4, startRestartGroup, 1572864, 0, 2338);
            if (viewState.getShowValidationErrorDialog()) {
                startRestartGroup = startRestartGroup;
                String stringResource4 = StringResources_androidKt.stringResource(R.string.vehicleSelector_validationError_title, startRestartGroup, 6);
                String stringResource5 = StringResources_androidKt.stringResource(R.string.vehicleSelector_validationError_description, startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(-1797568668);
                boolean changedInstance2 = startRestartGroup.changedInstance(viewModel);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue5 = new VehicleSelectorScreenKt$VehicleSelectorScreen$4$1(viewModel);
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                KFunction kFunction = (KFunction) rememberedValue5;
                startRestartGroup.endReplaceGroup();
                String stringResource6 = StringResources_androidKt.stringResource(R.string.vehicleSelector_validationError_button_continue, startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(-1797561982);
                boolean changedInstance3 = startRestartGroup.changedInstance(viewState) | startRestartGroup.changed(function1);
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue6 = new Function0() { // from class: c4.d
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit VehicleSelectorScreen$lambda$10$lambda$9;
                            VehicleSelectorScreen$lambda$10$lambda$9 = VehicleSelectorScreenKt.VehicleSelectorScreen$lambda$10$lambda$9(VehicleSelectorViewModel.ViewState.this, function1);
                            return VehicleSelectorScreen$lambda$10$lambda$9;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                startRestartGroup.endReplaceGroup();
                SimpleButtonData simpleButtonData = new SimpleButtonData(stringResource6, false, false, (Function0) rememberedValue6, 6, null);
                String stringResource7 = StringResources_androidKt.stringResource(R.string.vehicleSelector_validationError_button_back, startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(-1797553052);
                boolean changedInstance4 = startRestartGroup.changedInstance(viewModel);
                Object rememberedValue7 = startRestartGroup.rememberedValue();
                if (changedInstance4 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue7 = new VehicleSelectorScreenKt$VehicleSelectorScreen$6$1(viewModel);
                    startRestartGroup.updateRememberedValue(rememberedValue7);
                }
                startRestartGroup.endReplaceGroup();
                TextDialogKt.TextDialog(stringResource4, stringResource5, simpleButtonData, null, new SimpleButtonData(stringResource7, false, false, (Function0) ((KFunction) rememberedValue7), 6, null), true, (Function0) kFunction, startRestartGroup, 196608, 8);
            } else {
                startRestartGroup = startRestartGroup;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: c4.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit VehicleSelectorScreen$lambda$12;
                    VehicleSelectorScreen$lambda$12 = VehicleSelectorScreenKt.VehicleSelectorScreen$lambda$12(VehicleSelectorViewModel.this, navigator, resultNavigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return VehicleSelectorScreen$lambda$12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VehicleSelectorScreen$lambda$1$lambda$0(ResultBackNavigator resultBackNavigator, UserVehicle vehicle) {
        Intrinsics.checkNotNullParameter(vehicle, "vehicle");
        resultBackNavigator.navigateBack(vehicle);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VehicleSelectorScreen$lambda$10$lambda$9(VehicleSelectorViewModel.ViewState viewState, Function1 function1) {
        UserVehicle vehicleWithValidationError = viewState.getVehicleWithValidationError();
        if (vehicleWithValidationError != null) {
            function1.invoke(vehicleWithValidationError);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VehicleSelectorScreen$lambda$12(VehicleSelectorViewModel vehicleSelectorViewModel, DestinationsNavigator destinationsNavigator, ResultBackNavigator resultBackNavigator, int i5, Composer composer, int i6) {
        VehicleSelectorScreen(vehicleSelectorViewModel, destinationsNavigator, resultBackNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VehicleSelectorScreen$lambda$4$lambda$3(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, ProfileVehiclesRegisterScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VehicleSelectorScreen$lambda$7$lambda$6(VehicleSelectorViewModel.ViewState viewState, final VehicleSelectorViewModel vehicleSelectorViewModel, final Function1 function1, LazyListScope ProfileAssetsListContainer) {
        Intrinsics.checkNotNullParameter(ProfileAssetsListContainer, "$this$ProfileAssetsListContainer");
        List<Transportation> transportations = viewState.getTransportations();
        if (transportations != null && !transportations.isEmpty()) {
            LazyListScope.item$default(ProfileAssetsListContainer, null, null, ComposableLambdaKt.composableLambdaInstance(-9201639, true, new VehicleSelectorScreenKt$VehicleSelectorScreen$3$1$1(viewState)), 3, null);
        }
        List plus = CollectionsKt.plus((Collection) viewState.getAvailableVehicles(), (Iterable) viewState.getUnvalidatedVehicles());
        if (!plus.isEmpty()) {
            LazyListScope.item$default(ProfileAssetsListContainer, null, null, ComposableSingletons$VehicleSelectorScreenKt.INSTANCE.m3518getLambda1$app_kombardoProd(), 3, null);
            ProfileVehiclesListKt.profileVehiclesList(ProfileAssetsListContainer, plus, (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : new Function1() { // from class: c4.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit VehicleSelectorScreen$lambda$7$lambda$6$lambda$5;
                    VehicleSelectorScreen$lambda$7$lambda$6$lambda$5 = VehicleSelectorScreenKt.VehicleSelectorScreen$lambda$7$lambda$6$lambda$5(VehicleSelectorViewModel.this, function1, (UserVehicle) obj);
                    return VehicleSelectorScreen$lambda$7$lambda$6$lambda$5;
                }
            }, (r13 & 16) != 0 ? null : null);
        }
        if (!viewState.getUnavailableVehicles().isEmpty()) {
            LazyListScope.item$default(ProfileAssetsListContainer, null, null, ComposableSingletons$VehicleSelectorScreenKt.INSTANCE.m3519getLambda2$app_kombardoProd(), 3, null);
            ProfileVehiclesListKt.profileVehiclesList(ProfileAssetsListContainer, viewState.getUnavailableVehicles(), (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : new VehicleSelectorScreenKt$VehicleSelectorScreen$3$1$3(vehicleSelectorViewModel));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VehicleSelectorScreen$lambda$7$lambda$6$lambda$5(VehicleSelectorViewModel vehicleSelectorViewModel, Function1 function1, UserVehicle it) {
        Intrinsics.checkNotNullParameter(it, "it");
        vehicleSelectorViewModel.vehicleSelected(it, function1);
        return Unit.INSTANCE;
    }
}
