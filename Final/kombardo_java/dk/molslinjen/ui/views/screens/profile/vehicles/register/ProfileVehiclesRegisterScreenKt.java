package dk.molslinjen.ui.views.screens.profile.vehicles.register;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.model.account.LicensePlateValidation;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.profile.vehicles.register.ProfileVehiclesRegisterScreenKt;
import dk.molslinjen.ui.views.screens.profile.vehicles.register.ProfileVehiclesRegisterViewModel;
import dk.molslinjen.ui.views.screens.profile.vehicles.shared.InputState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a¡\u0001\u0010\u0016\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0018\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000e\u0012\u0004\u0012\u00020\u00040\r2\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000e\u0012\u0004\u0012\u00020\u00040\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\r2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\rH\u0003¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001a²\u0006\u000e\u0010\u0018\u001a\u00020\u000b8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0019\u001a\u00020\u000b8\n@\nX\u008a\u008e\u0002"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/vehicles/register/ProfileVehiclesRegisterViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "ProfileVehiclesRegisterScreen", "(Ldk/molslinjen/ui/views/screens/profile/vehicles/register/ProfileVehiclesRegisterViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/profile/vehicles/shared/IProfileVehicleInputHandler$InputState;", "inputState", "Ldk/molslinjen/domain/model/account/LicensePlateValidation$Valid;", "licensePlateValidation", BuildConfig.FLAVOR, "isLoading", "Lkotlin/Function1;", "Lkotlin/Function0;", "validateLicencePlate", "registerVehicle", "cancelRegister", "dismiss", BuildConfig.FLAVOR, "updateName", "updateLicensePlate", "ProfileVehiclesRegisterContent", "(Ldk/molslinjen/ui/views/screens/profile/vehicles/shared/IProfileVehicleInputHandler$InputState;Ldk/molslinjen/domain/model/account/LicensePlateValidation$Valid;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "isFormValid", "submitFieldsTrigger", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfileVehiclesRegisterScreenKt {
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r7v6 */
    private static final void ProfileVehiclesRegisterContent(final InputState inputState, final LicensePlateValidation.Valid valid, final boolean z5, final Function1<? super Function0<Unit>, Unit> function1, final Function1<? super Function0<Unit>, Unit> function12, final Function0<Unit> function0, final Function0<Unit> function02, final Function1<? super String, Unit> function13, final Function1<? super String, Unit> function14, Composer composer, final int i5) {
        int i6;
        int i7;
        boolean z6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1652961520);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(inputState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(valid) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function13) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i6 |= startRestartGroup.changedInstance(function14) ? 67108864 : 33554432;
        }
        if ((i6 & 38347923) == 38347922 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1652961520, i6, -1, "dk.molslinjen.ui.views.screens.profile.vehicles.register.ProfileVehiclesRegisterContent (ProfileVehiclesRegisterScreen.kt:58)");
            }
            startRestartGroup.startReplaceGroup(-1038973086);
            if (valid != null) {
                startRestartGroup.startReplaceGroup(-1038967568);
                boolean z7 = ((57344 & i6) == 16384) | ((i6 & 3670016) == 1048576);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z7 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: b4.e
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProfileVehiclesRegisterContent$lambda$8$lambda$7;
                            ProfileVehiclesRegisterContent$lambda$8$lambda$7 = ProfileVehiclesRegisterScreenKt.ProfileVehiclesRegisterContent$lambda$8$lambda$7(Function1.this, function02);
                            return ProfileVehiclesRegisterContent$lambda$8$lambda$7;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                i7 = i6;
                z6 = 1;
                ProfileVehicleValidationDialogKt.ProfileVehicleValidationDialog(valid, z5, (Function0) rememberedValue, function0, startRestartGroup, ((i6 >> 3) & 126) | ((i6 >> 6) & 7168));
            } else {
                i7 = i6;
                z6 = 1;
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1038963882);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1038961770);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            MutableState mutableState2 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, z6, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.profile_vehicles_registerVehicle, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-1038955035);
            int i8 = i7;
            boolean z8 = ((i8 & 896) == 256 ? z6 : false) | ((i8 & 3670016) == 1048576 ? z6 : false);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: b4.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileVehiclesRegisterContent$lambda$16$lambda$15;
                        ProfileVehiclesRegisterContent$lambda$16$lambda$15 = ProfileVehiclesRegisterScreenKt.ProfileVehiclesRegisterContent$lambda$16$lambda$15(z5, function02);
                        return ProfileVehiclesRegisterContent$lambda$16$lambda$15;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(fillMaxSize$default, 0.0f, stringResource, null, 0L, null, (Function0) rememberedValue4, null, ComposableLambdaKt.rememberComposableLambda(2113198450, z6, new ProfileVehiclesRegisterScreenKt$ProfileVehiclesRegisterContent$3(z5, function1, function02, mutableState, mutableState2), startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1324590653, z6, new ProfileVehiclesRegisterScreenKt$ProfileVehiclesRegisterContent$4(inputState, z5, function14, function13, function1, function02, mutableState2, mutableState), composer2, 54), composer2, 905969670, 186);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: b4.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileVehiclesRegisterContent$lambda$17;
                    ProfileVehiclesRegisterContent$lambda$17 = ProfileVehiclesRegisterScreenKt.ProfileVehiclesRegisterContent$lambda$17(InputState.this, valid, z5, function1, function12, function0, function02, function13, function14, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileVehiclesRegisterContent$lambda$17;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ProfileVehiclesRegisterContent$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileVehiclesRegisterContent$lambda$11(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ProfileVehiclesRegisterContent$lambda$13(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileVehiclesRegisterContent$lambda$14(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehiclesRegisterContent$lambda$16$lambda$15(boolean z5, Function0 function0) {
        if (!z5) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehiclesRegisterContent$lambda$17(InputState inputState, LicensePlateValidation.Valid valid, boolean z5, Function1 function1, Function1 function12, Function0 function0, Function0 function02, Function1 function13, Function1 function14, int i5, Composer composer, int i6) {
        ProfileVehiclesRegisterContent(inputState, valid, z5, function1, function12, function0, function02, function13, function14, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehiclesRegisterContent$lambda$8$lambda$7(Function1 function1, Function0 function0) {
        function1.invoke(function0);
        return Unit.INSTANCE;
    }

    public static final void ProfileVehiclesRegisterScreen(final ProfileVehiclesRegisterViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-164150901);
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
                ComposerKt.traceEventStart(-164150901, i6, -1, "dk.molslinjen.ui.views.screens.profile.vehicles.register.ProfileVehiclesRegisterScreen (ProfileVehiclesRegisterScreen.kt:27)");
            }
            ProfileVehiclesRegisterViewModel.ViewState viewState = (ProfileVehiclesRegisterViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            InputState inputState = (InputState) SnapshotStateKt.collectAsState(viewModel.getVehicleInput(), null, startRestartGroup, 0, 1).getValue();
            LicensePlateValidation.Valid licensePlaceValidation = viewState.getLicensePlaceValidation();
            boolean isLoading = viewState.getIsLoading();
            startRestartGroup.startReplaceGroup(-1678861360);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new ProfileVehiclesRegisterScreenKt$ProfileVehiclesRegisterScreen$1$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function1 function1 = (Function1) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1678859477);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new ProfileVehiclesRegisterScreenKt$ProfileVehiclesRegisterScreen$2$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function1 function12 = (Function1) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1678857772);
            boolean changedInstance3 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new ProfileVehiclesRegisterScreenKt$ProfileVehiclesRegisterScreen$3$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            KFunction kFunction = (KFunction) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1678855930);
            boolean changedInstance4 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new ProfileVehiclesRegisterScreenKt$ProfileVehiclesRegisterScreen$4$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            KFunction kFunction2 = (KFunction) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1678854258);
            boolean changedInstance5 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new ProfileVehiclesRegisterScreenKt$ProfileVehiclesRegisterScreen$5$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            KFunction kFunction3 = (KFunction) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1678852696);
            boolean z5 = (i6 & 112) == 32;
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = new ProfileVehiclesRegisterScreenKt$ProfileVehiclesRegisterScreen$6$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            ProfileVehiclesRegisterContent(inputState, licensePlaceValidation, isLoading, function1, function12, (Function0) kFunction, (Function0) rememberedValue6, (Function1) kFunction2, (Function1) kFunction3, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: b4.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileVehiclesRegisterScreen$lambda$6;
                    ProfileVehiclesRegisterScreen$lambda$6 = ProfileVehiclesRegisterScreenKt.ProfileVehiclesRegisterScreen$lambda$6(ProfileVehiclesRegisterViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileVehiclesRegisterScreen$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehiclesRegisterScreen$lambda$6(ProfileVehiclesRegisterViewModel profileVehiclesRegisterViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        ProfileVehiclesRegisterScreen(profileVehiclesRegisterViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
