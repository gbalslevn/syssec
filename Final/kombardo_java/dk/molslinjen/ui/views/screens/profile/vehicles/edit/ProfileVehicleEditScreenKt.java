package dk.molslinjen.ui.views.screens.profile.vehicles.edit;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.buttons.IconTextButtonKt;
import dk.molslinjen.ui.views.screens.profile.vehicles.edit.ProfileVehicleEditScreenKt;
import dk.molslinjen.ui.views.screens.profile.vehicles.edit.ProfileVehiclesEditViewModel;
import dk.molslinjen.ui.views.screens.profile.vehicles.shared.InputState;
import dk.molslinjen.ui.views.screens.profile.vehicles.shared.ProfileVehicleInputContentKt;
import dk.molslinjen.ui.views.screens.profile.vehicles.shared.VehicleDeleteDialogKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0083\u0001\u0010\u0015\u001a\u00020\u0004*\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u0012\u001a\u00020\b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0003¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0019²\u0006\u000e\u0010\u0017\u001a\u00020\b8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0018\u001a\u00020\b8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0012\u001a\u00020\b8\n@\nX\u008a\u008e\u0002"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/vehicles/edit/ProfileVehiclesEditViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "ProfileVehicleEditScreen", "(Ldk/molslinjen/ui/views/screens/profile/vehicles/edit/ProfileVehiclesEditViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/layout/ColumnScope;", BuildConfig.FLAVOR, "isLoading", "Ldk/molslinjen/ui/views/screens/profile/vehicles/shared/IProfileVehicleInputHandler$InputState;", "inputState", "Lkotlin/Function0;", "startDeleteFlow", "Lkotlin/Function1;", BuildConfig.FLAVOR, "updateLicensePlate", "updateName", "submitFieldsTrigger", "onFormValidationChange", "onKeyboardSubmit", "ProfileVehicleEditScreenContent", "(Landroidx/compose/foundation/layout/ColumnScope;ZLdk/molslinjen/ui/views/screens/profile/vehicles/shared/IProfileVehicleInputHandler$InputState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "shouldDismiss", "isFormValid", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfileVehicleEditScreenKt {
    public static final void ProfileVehicleEditScreen(final ProfileVehiclesEditViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        boolean z5;
        boolean z6;
        int i7;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(1829115329);
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
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1829115329, i6, -1, "dk.molslinjen.ui.views.screens.profile.vehicles.edit.ProfileVehicleEditScreen (ProfileVehicleEditScreen.kt:45)");
            }
            startRestartGroup.startReplaceGroup(1982443682);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            boolean isImeVisible = WindowInsets_androidKt.isImeVisible(WindowInsets.INSTANCE, startRestartGroup, 6);
            Boolean valueOf = Boolean.valueOf(ProfileVehicleEditScreen$lambda$1(mutableState));
            Boolean valueOf2 = Boolean.valueOf(isImeVisible);
            startRestartGroup.startReplaceGroup(1982448777);
            int i8 = i6 & 112;
            boolean changed = startRestartGroup.changed(isImeVisible) | (i8 == 32);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$1$1(isImeVisible, navigator, mutableState, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(valueOf, valueOf2, (Function2) rememberedValue2, startRestartGroup, 0);
            startRestartGroup.startReplaceGroup(1982453213);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: a4.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileVehicleEditScreen$lambda$6$lambda$5;
                        ProfileVehicleEditScreen$lambda$6$lambda$5 = ProfileVehicleEditScreenKt.ProfileVehicleEditScreen$lambda$6$lambda$5(ProfileVehiclesEditViewModel.this, mutableState);
                        return ProfileVehicleEditScreen$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            Function0 function0 = (Function0) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            ProfileVehiclesEditViewModel.ViewState viewState = (ProfileVehiclesEditViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            InputState inputState = (InputState) SnapshotStateKt.collectAsState(viewModel.getVehicleInput(), null, startRestartGroup, 0, 1).getValue();
            final boolean isLoading = viewState.getIsLoading();
            boolean showDeleteDialog = viewState.getShowDeleteDialog();
            UserVehicle originalVehicle = viewState.getOriginalVehicle();
            startRestartGroup.startReplaceGroup(1982466575);
            if (!showDeleteDialog || originalVehicle == null) {
                z5 = false;
                z6 = isLoading;
                i7 = i8;
            } else {
                startRestartGroup.startReplaceGroup(1982472084);
                boolean changedInstance = startRestartGroup.changedInstance(viewModel) | (i8 == 32);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: a4.b
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProfileVehicleEditScreen$lambda$8$lambda$7;
                            ProfileVehicleEditScreen$lambda$8$lambda$7 = ProfileVehicleEditScreenKt.ProfileVehicleEditScreen$lambda$8$lambda$7(ProfileVehiclesEditViewModel.this, navigator);
                            return ProfileVehicleEditScreen$lambda$8$lambda$7;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                Function0 function02 = (Function0) rememberedValue4;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1982474836);
                boolean changed2 = startRestartGroup.changed(isLoading) | startRestartGroup.changedInstance(viewModel);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new Function0() { // from class: a4.c
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProfileVehicleEditScreen$lambda$10$lambda$9;
                            ProfileVehicleEditScreen$lambda$10$lambda$9 = ProfileVehicleEditScreenKt.ProfileVehicleEditScreen$lambda$10$lambda$9(isLoading, viewModel);
                            return ProfileVehicleEditScreen$lambda$10$lambda$9;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceGroup();
                z5 = false;
                z6 = isLoading;
                i7 = i8;
                VehicleDeleteDialogKt.VehicleDeleteDialog(originalVehicle, isLoading, function02, (Function0) rememberedValue5, startRestartGroup, 0);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1982479778);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            MutableState mutableState2 = (MutableState) rememberedValue6;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1982481890);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            MutableState mutableState3 = (MutableState) rememberedValue7;
            startRestartGroup.endReplaceGroup();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.profile_vehicle_edit_title, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(1982488375);
            boolean z7 = i7 == 32 ? true : z5;
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue8 == companion.getEmpty()) {
                rememberedValue8 = new ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$4$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(fillMaxSize$default, 0.0f, stringResource, null, 0L, null, (Function0) rememberedValue8, null, ComposableLambdaKt.rememberComposableLambda(842926335, true, new ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$5(viewState, function0, mutableState2, mutableState3), startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(557954190, true, new ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$6(z6, inputState, viewModel, mutableState3, mutableState2, function0), startRestartGroup, 54), composer2, 905969670, 186);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: a4.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileVehicleEditScreen$lambda$19;
                    ProfileVehicleEditScreen$lambda$19 = ProfileVehicleEditScreenKt.ProfileVehicleEditScreen$lambda$19(ProfileVehiclesEditViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileVehicleEditScreen$lambda$19;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ProfileVehicleEditScreen$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleEditScreen$lambda$10$lambda$9(boolean z5, ProfileVehiclesEditViewModel profileVehiclesEditViewModel) {
        if (!z5) {
            profileVehiclesEditViewModel.cancelDeleteFlow();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ProfileVehicleEditScreen$lambda$12(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileVehicleEditScreen$lambda$13(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ProfileVehicleEditScreen$lambda$15(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileVehicleEditScreen$lambda$16(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleEditScreen$lambda$19(ProfileVehiclesEditViewModel profileVehiclesEditViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        ProfileVehicleEditScreen(profileVehiclesEditViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void ProfileVehicleEditScreen$lambda$2(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleEditScreen$lambda$6$lambda$5(ProfileVehiclesEditViewModel profileVehiclesEditViewModel, final MutableState mutableState) {
        profileVehiclesEditViewModel.updateVehicle(new Function0() { // from class: a4.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit ProfileVehicleEditScreen$lambda$6$lambda$5$lambda$4;
                ProfileVehicleEditScreen$lambda$6$lambda$5$lambda$4 = ProfileVehicleEditScreenKt.ProfileVehicleEditScreen$lambda$6$lambda$5$lambda$4(MutableState.this);
                return ProfileVehicleEditScreen$lambda$6$lambda$5$lambda$4;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleEditScreen$lambda$6$lambda$5$lambda$4(MutableState mutableState) {
        ProfileVehicleEditScreen$lambda$2(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleEditScreen$lambda$8$lambda$7(ProfileVehiclesEditViewModel profileVehiclesEditViewModel, DestinationsNavigator destinationsNavigator) {
        profileVehiclesEditViewModel.deleteVehicle(new ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$2$1$1(destinationsNavigator));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileVehicleEditScreenContent(final ColumnScope columnScope, final boolean z5, final InputState inputState, final Function0<Unit> function0, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final boolean z6, final Function1<? super Boolean, Unit> function13, final Function0<Unit> function02, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(632398438);
        if ((i5 & 48) == 0) {
            i6 = (startRestartGroup.changed(z5) ? 32 : 16) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(inputState) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function13) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 67108864 : 33554432;
        }
        if ((38347921 & i6) == 38347920 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(632398438, i6, -1, "dk.molslinjen.ui.views.screens.profile.vehicles.edit.ProfileVehicleEditScreenContent (ProfileVehicleEditScreen.kt:128)");
            }
            float f5 = 24;
            IconTextButtonKt.m3404IconTextButtonV9fs2A(PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), 2, null), function0, R.drawable.icon_delete, R.string.profile_vehicle_delete, !z5, AppColor.INSTANCE.m3272getSignalRed0d7_KjU(), startRestartGroup, ((i6 >> 6) & 112) | 200070, 0);
            int i7 = (i6 << 3) & 896;
            int i8 = i6 >> 3;
            composer2 = startRestartGroup;
            ProfileVehicleInputContentKt.ProfileVehicleInputContent(inputState.getLicensePlate(), inputState.getName(), z5, function1, function12, z6, function13, function02, startRestartGroup, i7 | (i8 & 7168) | (57344 & i8) | (458752 & i8) | (3670016 & i8) | (i8 & 29360128));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: a4.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileVehicleEditScreenContent$lambda$20;
                    ProfileVehicleEditScreenContent$lambda$20 = ProfileVehicleEditScreenKt.ProfileVehicleEditScreenContent$lambda$20(ColumnScope.this, z5, inputState, function0, function1, function12, z6, function13, function02, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileVehicleEditScreenContent$lambda$20;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleEditScreenContent$lambda$20(ColumnScope columnScope, boolean z5, InputState inputState, Function0 function0, Function1 function1, Function1 function12, boolean z6, Function1 function13, Function0 function02, int i5, Composer composer, int i6) {
        ProfileVehicleEditScreenContent(columnScope, z5, inputState, function0, function1, function12, z6, function13, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
