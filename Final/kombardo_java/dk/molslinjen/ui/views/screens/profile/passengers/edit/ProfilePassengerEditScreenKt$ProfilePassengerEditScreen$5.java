package dk.molslinjen.ui.views.screens.profile.passengers.edit;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import dk.molslinjen.ui.views.screens.profile.passengers.edit.ProfilePassengerEditViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfilePassengerEditScreenKt$ProfilePassengerEditScreen$5 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Boolean> $isFormValid$delegate;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ MutableState<Boolean> $submitFieldsTrigger$delegate;
    final /* synthetic */ ProfilePassengerEditViewModel $viewModel;
    final /* synthetic */ ProfilePassengerEditViewModel.ViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfilePassengerEditScreenKt$ProfilePassengerEditScreen$5(ProfilePassengerEditViewModel.ViewState viewState, ProfilePassengerEditViewModel profilePassengerEditViewModel, DestinationsNavigator destinationsNavigator, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
        this.$viewState = viewState;
        this.$viewModel = profilePassengerEditViewModel;
        this.$navigator = destinationsNavigator;
        this.$isFormValid$delegate = mutableState;
        this.$submitFieldsTrigger$delegate = mutableState2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState mutableState) {
        ProfilePassengerEditScreenKt.ProfilePassengerEditScreen$lambda$10(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(ProfilePassengerEditViewModel profilePassengerEditViewModel, DestinationsNavigator destinationsNavigator) {
        profilePassengerEditViewModel.updatePassenger(new ProfilePassengerEditScreenKt$ProfilePassengerEditScreen$5$2$1$1(destinationsNavigator));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        boolean ProfilePassengerEditScreen$lambda$6;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(159977868, i5, -1, "dk.molslinjen.ui.views.screens.profile.passengers.edit.ProfilePassengerEditScreen.<anonymous> (ProfilePassengerEditScreen.kt:70)");
        }
        String stringResource = StringResources_androidKt.stringResource(R.string.button_saveChanges, composer, 6);
        ProfilePassengerEditScreen$lambda$6 = ProfilePassengerEditScreenKt.ProfilePassengerEditScreen$lambda$6(this.$isFormValid$delegate);
        boolean z5 = ProfilePassengerEditScreen$lambda$6 && !this.$viewState.getIsLoading();
        boolean isLoading = this.$viewState.getIsLoading();
        composer.startReplaceGroup(-1235428099);
        final MutableState<Boolean> mutableState = this.$submitFieldsTrigger$delegate;
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.passengers.edit.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = ProfilePassengerEditScreenKt$ProfilePassengerEditScreen$5.invoke$lambda$1$lambda$0(MutableState.this);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function0 function0 = (Function0) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-1235430955);
        boolean changedInstance = composer.changedInstance(this.$viewModel) | composer.changed(this.$navigator);
        final ProfilePassengerEditViewModel profilePassengerEditViewModel = this.$viewModel;
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.passengers.edit.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = ProfilePassengerEditScreenKt$ProfilePassengerEditScreen$5.invoke$lambda$3$lambda$2(ProfilePassengerEditViewModel.this, destinationsNavigator);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(stringResource, null, z5, isLoading, false, 0L, function0, (Function0) rememberedValue2, composer, 1572864, 50);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
