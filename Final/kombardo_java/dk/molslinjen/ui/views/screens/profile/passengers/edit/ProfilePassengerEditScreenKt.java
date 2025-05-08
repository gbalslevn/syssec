package dk.molslinjen.ui.views.screens.profile.passengers.edit;

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
import com.ramcosta.composedestinations.generated.destinations.NationalitySelectionScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.OpenResultRecipientKt;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.domain.model.account.UserPassenger;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.profile.passengers.edit.ProfilePassengerEditScreenKt;
import dk.molslinjen.ui.views.screens.profile.passengers.edit.ProfilePassengerEditViewModel;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.ProfilePassengerDeleteDialogKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a3\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e²\u0006\u000e\u0010\f\u001a\u00020\u000b8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\r\u001a\u00020\u000b8\n@\nX\u008a\u008e\u0002"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/passengers/edit/ProfilePassengerEditViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/NationalitySelectionScreenDestination;", "Ljava/util/Locale;", "nationalityResultRecipient", BuildConfig.FLAVOR, "ProfilePassengerEditScreen", "(Ldk/molslinjen/ui/views/screens/profile/passengers/edit/ProfilePassengerEditViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultRecipient;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "isFormValid", "submitFieldsTrigger", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfilePassengerEditScreenKt {
    public static final void ProfilePassengerEditScreen(final ProfilePassengerEditViewModel viewModel, final DestinationsNavigator navigator, final ResultRecipient<NationalitySelectionScreenDestination, Locale> nationalityResultRecipient, Composer composer, final int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        Composer composer2;
        Composer composer3;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(nationalityResultRecipient, "nationalityResultRecipient");
        Composer startRestartGroup = composer.startRestartGroup(966904458);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(nationalityResultRecipient) ? 256 : 128;
        }
        int i10 = i6;
        if ((i10 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer3 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(966904458, i10, -1, "dk.molslinjen.ui.views.screens.profile.passengers.edit.ProfilePassengerEditScreen (ProfilePassengerEditScreen.kt:42)");
            }
            startRestartGroup.startReplaceGroup(1776372271);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: R3.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ProfilePassengerEditScreen$lambda$1$lambda$0;
                        ProfilePassengerEditScreen$lambda$1$lambda$0 = ProfilePassengerEditScreenKt.ProfilePassengerEditScreen$lambda$1$lambda$0(ProfilePassengerEditViewModel.this, (Locale) obj);
                        return ProfilePassengerEditScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(nationalityResultRecipient, null, (Function1) rememberedValue, startRestartGroup, (i10 >> 6) & 14, 1);
            ProfilePassengerEditViewModel.ViewState viewState = (ProfilePassengerEditViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            boolean showDeleteDialog = viewState.getShowDeleteDialog();
            UserPassenger originalPassenger = viewState.getOriginalPassenger();
            startRestartGroup.startReplaceGroup(1776379851);
            if (!showDeleteDialog || originalPassenger == null) {
                i7 = i10;
                i8 = 32;
                i9 = 2;
                composer2 = startRestartGroup;
            } else {
                boolean isDeleteLoading = viewState.getIsDeleteLoading();
                startRestartGroup.startReplaceGroup(1776386230);
                boolean changedInstance2 = startRestartGroup.changedInstance(viewModel) | ((i10 & 112) == 32);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: R3.c
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProfilePassengerEditScreen$lambda$3$lambda$2;
                            ProfilePassengerEditScreen$lambda$3$lambda$2 = ProfilePassengerEditScreenKt.ProfilePassengerEditScreen$lambda$3$lambda$2(ProfilePassengerEditViewModel.this, navigator);
                            return ProfilePassengerEditScreen$lambda$3$lambda$2;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                Function0 function0 = (Function0) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1776388763);
                boolean changedInstance3 = startRestartGroup.changedInstance(viewModel);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new ProfilePassengerEditScreenKt$ProfilePassengerEditScreen$3$1(viewModel);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                Function0 function02 = (Function0) ((KFunction) rememberedValue3);
                i7 = i10;
                i8 = 32;
                i9 = 2;
                composer2 = startRestartGroup;
                ProfilePassengerDeleteDialogKt.ProfilePassengerDeleteDialog(originalPassenger, isDeleteLoading, function0, function02, startRestartGroup, 0);
            }
            composer2.endReplaceGroup();
            boolean isLoading = viewState.getIsLoading();
            Composer composer4 = composer2;
            composer4.startReplaceGroup(1776392226);
            Object rememberedValue4 = composer4.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, i9, null);
                composer4.updateRememberedValue(rememberedValue4);
            }
            MutableState mutableState = (MutableState) rememberedValue4;
            composer4.endReplaceGroup();
            composer4.startReplaceGroup(1776394338);
            Object rememberedValue5 = composer4.rememberedValue();
            if (rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, i9, null);
                composer4.updateRememberedValue(rememberedValue5);
            }
            MutableState mutableState2 = (MutableState) rememberedValue5;
            composer4.endReplaceGroup();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.profile_passenger_edit, composer4, 6);
            composer4.startReplaceGroup(1776400695);
            boolean z5 = (i7 & 112) == i8;
            Object rememberedValue6 = composer4.rememberedValue();
            if (z5 || rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new ProfilePassengerEditScreenKt$ProfilePassengerEditScreen$4$1(navigator);
                composer4.updateRememberedValue(rememberedValue6);
            }
            composer4.endReplaceGroup();
            composer3 = composer4;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(fillMaxSize$default, 0.0f, stringResource, null, 0L, null, (Function0) rememberedValue6, null, ComposableLambdaKt.rememberComposableLambda(159977868, true, new ProfilePassengerEditScreenKt$ProfilePassengerEditScreen$5(viewState, viewModel, navigator, mutableState, mutableState2), composer4, 54), ComposableLambdaKt.rememberComposableLambda(-1233922787, true, new ProfilePassengerEditScreenKt$ProfilePassengerEditScreen$6(viewModel, isLoading, navigator, mutableState2, mutableState), composer4, 54), composer3, 905969670, 186);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: R3.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfilePassengerEditScreen$lambda$13;
                    ProfilePassengerEditScreen$lambda$13 = ProfilePassengerEditScreenKt.ProfilePassengerEditScreen$lambda$13(ProfilePassengerEditViewModel.this, navigator, nationalityResultRecipient, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfilePassengerEditScreen$lambda$13;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfilePassengerEditScreen$lambda$1$lambda$0(ProfilePassengerEditViewModel profilePassengerEditViewModel, Locale it) {
        Intrinsics.checkNotNullParameter(it, "it");
        profilePassengerEditViewModel.updateNationality(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfilePassengerEditScreen$lambda$10(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfilePassengerEditScreen$lambda$13(ProfilePassengerEditViewModel profilePassengerEditViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, int i5, Composer composer, int i6) {
        ProfilePassengerEditScreen(profilePassengerEditViewModel, destinationsNavigator, resultRecipient, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfilePassengerEditScreen$lambda$3$lambda$2(ProfilePassengerEditViewModel profilePassengerEditViewModel, DestinationsNavigator destinationsNavigator) {
        profilePassengerEditViewModel.deletePassenger(new ProfilePassengerEditScreenKt$ProfilePassengerEditScreen$2$1$1(destinationsNavigator));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ProfilePassengerEditScreen$lambda$6(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfilePassengerEditScreen$lambda$7(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ProfilePassengerEditScreen$lambda$9(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }
}
