package dk.molslinjen.ui.views.screens.profile.vehicles;

import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.generated.destinations.ProfileVehicleEditScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ProfileVehiclesRegisterScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SignupScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import defpackage.ProfileVehiclesListKt;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData;
import dk.molslinjen.ui.views.screens.profile.vehicles.ProfileVehiclesScreenKt;
import dk.molslinjen.ui.views.screens.profile.vehicles.ProfileVehiclesViewModel;
import dk.molslinjen.ui.views.screens.profile.vehicles.shared.VehicleDeleteDialogKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"ProfileVehiclesScreen", BuildConfig.FLAVOR, "viewModel", "Ldk/molslinjen/ui/views/screens/profile/vehicles/ProfileVehiclesViewModel;", "navigator", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "(Ldk/molslinjen/ui/views/screens/profile/vehicles/ProfileVehiclesViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfileVehiclesScreenKt {
    public static final void ProfileVehiclesScreen(final ProfileVehiclesViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(970750807);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        int i7 = i6;
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(970750807, i7, -1, "dk.molslinjen.ui.views.screens.profile.vehicles.ProfileVehiclesScreen (ProfileVehiclesScreen.kt:21)");
            }
            final ProfileVehiclesViewModel.ViewState viewState = (ProfileVehiclesViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            UserVehicle vehicleToDelete = viewState.getVehicleToDelete();
            final boolean isDeleteLoading = viewState.getIsDeleteLoading();
            startRestartGroup.startReplaceGroup(1457254126);
            if (vehicleToDelete != null) {
                startRestartGroup.startReplaceGroup(1457259192);
                boolean changedInstance = startRestartGroup.changedInstance(viewModel) | startRestartGroup.changedInstance(viewState);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: Z3.a
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProfileVehiclesScreen$lambda$1$lambda$0;
                            ProfileVehiclesScreen$lambda$1$lambda$0 = ProfileVehiclesScreenKt.ProfileVehiclesScreen$lambda$1$lambda$0(ProfileVehiclesViewModel.this, viewState);
                            return ProfileVehiclesScreen$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                Function0 function0 = (Function0) rememberedValue;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1457262108);
                boolean changed = startRestartGroup.changed(isDeleteLoading) | startRestartGroup.changedInstance(viewModel);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: Z3.b
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProfileVehiclesScreen$lambda$3$lambda$2;
                            ProfileVehiclesScreen$lambda$3$lambda$2 = ProfileVehiclesScreenKt.ProfileVehiclesScreen$lambda$3$lambda$2(isDeleteLoading, viewModel);
                            return ProfileVehiclesScreen$lambda$3$lambda$2;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                VehicleDeleteDialogKt.VehicleDeleteDialog(vehicleToDelete, isDeleteLoading, function0, (Function0) rememberedValue2, startRestartGroup, 0);
            }
            startRestartGroup.endReplaceGroup();
            boolean isLoading = viewState.getIsLoading();
            final List<UserVehicle> vehicles = viewState.getUserVehiclesState().getVehicles();
            String stringResource = StringResources_androidKt.stringResource(R.string.profile_vehiclesTitle, startRestartGroup, 6);
            AccountCardData accountCardData = viewState.getAccountCardData();
            boolean isEmpty = vehicles.isEmpty();
            startRestartGroup.startReplaceGroup(1457279958);
            int i8 = i7 & 112;
            boolean z5 = i8 == 32;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new ProfileVehiclesScreenKt$ProfileVehiclesScreen$3$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            Function0 function02 = (Function0) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1457281430);
            boolean z6 = i8 == 32;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new ProfileVehiclesScreenKt$ProfileVehiclesScreen$4$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            Function0 function03 = (Function0) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            String stringResource2 = StringResources_androidKt.stringResource(R.string.profile_vehicles_emptyDescription, startRestartGroup, 6);
            String stringResource3 = StringResources_androidKt.stringResource(R.string.profile_vehicles_registerVehicle, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(1457290943);
            boolean z7 = i8 == 32;
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: Z3.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileVehiclesScreen$lambda$8$lambda$7;
                        ProfileVehiclesScreen$lambda$8$lambda$7 = ProfileVehiclesScreenKt.ProfileVehiclesScreen$lambda$8$lambda$7(DestinationsNavigator.this);
                        return ProfileVehiclesScreen$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            Function0 function04 = (Function0) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1457275438);
            boolean z8 = i8 == 32;
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = new Function0() { // from class: Z3.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileVehiclesScreen$lambda$10$lambda$9;
                        ProfileVehiclesScreen$lambda$10$lambda$9 = ProfileVehiclesScreenKt.ProfileVehiclesScreen$lambda$10$lambda$9(DestinationsNavigator.this);
                        return ProfileVehiclesScreen$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            Function0 function05 = (Function0) rememberedValue6;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1457293417);
            boolean changedInstance2 = startRestartGroup.changedInstance(vehicles) | (i8 == 32) | startRestartGroup.changedInstance(viewModel);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = new Function1() { // from class: Z3.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ProfileVehiclesScreen$lambda$13$lambda$12;
                        ProfileVehiclesScreen$lambda$13$lambda$12 = ProfileVehiclesScreenKt.ProfileVehiclesScreen$lambda$13$lambda$12(vehicles, viewModel, navigator, (LazyListScope) obj);
                        return ProfileVehiclesScreen$lambda$13$lambda$12;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            ProfileAssetsContainerKt.ProfileAssetsListContainer(stringResource, accountCardData, isLoading, isEmpty, function02, function03, R.drawable.icon_profile_vehicles, stringResource2, null, stringResource3, function04, function05, (Function1) rememberedValue7, composer2, 1572864, 0, 256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: Z3.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileVehiclesScreen$lambda$14;
                    ProfileVehiclesScreen$lambda$14 = ProfileVehiclesScreenKt.ProfileVehiclesScreen$lambda$14(ProfileVehiclesViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileVehiclesScreen$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehiclesScreen$lambda$1$lambda$0(ProfileVehiclesViewModel profileVehiclesViewModel, ProfileVehiclesViewModel.ViewState viewState) {
        profileVehiclesViewModel.deleteVehicle(viewState.getVehicleToDelete().getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehiclesScreen$lambda$10$lambda$9(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SignupScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehiclesScreen$lambda$13$lambda$12(List list, ProfileVehiclesViewModel profileVehiclesViewModel, final DestinationsNavigator destinationsNavigator, LazyListScope ProfileAssetsListContainer) {
        Intrinsics.checkNotNullParameter(ProfileAssetsListContainer, "$this$ProfileAssetsListContainer");
        ProfileVehiclesListKt.profileVehiclesList(ProfileAssetsListContainer, list, (r13 & 2) != 0 ? null : new Function1() { // from class: Z3.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ProfileVehiclesScreen$lambda$13$lambda$12$lambda$11;
                ProfileVehiclesScreen$lambda$13$lambda$12$lambda$11 = ProfileVehiclesScreenKt.ProfileVehiclesScreen$lambda$13$lambda$12$lambda$11(DestinationsNavigator.this, (String) obj);
                return ProfileVehiclesScreen$lambda$13$lambda$12$lambda$11;
            }
        }, (r13 & 4) != 0 ? null : new ProfileVehiclesScreenKt$ProfileVehiclesScreen$7$1$2(profileVehiclesViewModel), (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehiclesScreen$lambda$13$lambda$12$lambda$11(DestinationsNavigator destinationsNavigator, String vehicleId) {
        Intrinsics.checkNotNullParameter(vehicleId, "vehicleId");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, ProfileVehicleEditScreenDestination.INSTANCE.invoke(vehicleId), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehiclesScreen$lambda$14(ProfileVehiclesViewModel profileVehiclesViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        ProfileVehiclesScreen(profileVehiclesViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehiclesScreen$lambda$3$lambda$2(boolean z5, ProfileVehiclesViewModel profileVehiclesViewModel) {
        if (!z5) {
            profileVehiclesViewModel.cancelDeleteVehicle();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehiclesScreen$lambda$8$lambda$7(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, ProfileVehiclesRegisterScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }
}
