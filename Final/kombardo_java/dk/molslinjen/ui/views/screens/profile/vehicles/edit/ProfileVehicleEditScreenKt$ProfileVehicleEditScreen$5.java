package dk.molslinjen.ui.views.screens.profile.vehicles.edit;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.res.StringResources_androidKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import dk.molslinjen.ui.views.screens.profile.vehicles.edit.ProfileVehiclesEditViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$5 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Boolean> $isFormValid$delegate;
    final /* synthetic */ Function0<Unit> $onSubmit;
    final /* synthetic */ MutableState<Boolean> $submitFieldsTrigger$delegate;
    final /* synthetic */ ProfileVehiclesEditViewModel.ViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$5(ProfileVehiclesEditViewModel.ViewState viewState, Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
        this.$viewState = viewState;
        this.$onSubmit = function0;
        this.$isFormValid$delegate = mutableState;
        this.$submitFieldsTrigger$delegate = mutableState2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState mutableState) {
        ProfileVehicleEditScreenKt.ProfileVehicleEditScreen$lambda$16(mutableState, true);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        boolean ProfileVehicleEditScreen$lambda$12;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(842926335, i5, -1, "dk.molslinjen.ui.views.screens.profile.vehicles.edit.ProfileVehicleEditScreen.<anonymous> (ProfileVehicleEditScreen.kt:91)");
        }
        String stringResource = StringResources_androidKt.stringResource(R.string.button_saveChanges, composer, 6);
        ProfileVehicleEditScreen$lambda$12 = ProfileVehicleEditScreenKt.ProfileVehicleEditScreen$lambda$12(this.$isFormValid$delegate);
        boolean z5 = ProfileVehicleEditScreen$lambda$12 && !this.$viewState.getIsLoading();
        boolean isLoading = this.$viewState.getIsLoading();
        composer.startReplaceGroup(-505488067);
        final MutableState<Boolean> mutableState = this.$submitFieldsTrigger$delegate;
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.vehicles.edit.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$5.invoke$lambda$1$lambda$0(MutableState.this);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(stringResource, null, z5, isLoading, false, 0L, (Function0) rememberedValue, this.$onSubmit, composer, 14155776, 50);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
