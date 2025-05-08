package dk.molslinjen.ui.views.screens.profile.vehicles.edit;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import dk.molslinjen.ui.views.screens.profile.vehicles.shared.InputState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$6 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ InputState $inputState;
    final /* synthetic */ MutableState<Boolean> $isFormValid$delegate;
    final /* synthetic */ boolean $isLoading;
    final /* synthetic */ Function0<Unit> $onSubmit;
    final /* synthetic */ MutableState<Boolean> $submitFieldsTrigger$delegate;
    final /* synthetic */ ProfileVehiclesEditViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$6(boolean z5, InputState inputState, ProfileVehiclesEditViewModel profileVehiclesEditViewModel, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Function0<Unit> function0) {
        this.$isLoading = z5;
        this.$inputState = inputState;
        this.$viewModel = profileVehiclesEditViewModel;
        this.$submitFieldsTrigger$delegate = mutableState;
        this.$isFormValid$delegate = mutableState2;
        this.$onSubmit = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3(MutableState mutableState, boolean z5) {
        ProfileVehicleEditScreenKt.ProfileVehicleEditScreen$lambda$13(mutableState, z5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$6$lambda$5(Function0 function0, MutableState mutableState, MutableState mutableState2) {
        boolean ProfileVehicleEditScreen$lambda$12;
        ProfileVehicleEditScreenKt.ProfileVehicleEditScreen$lambda$16(mutableState, true);
        ProfileVehicleEditScreen$lambda$12 = ProfileVehicleEditScreenKt.ProfileVehicleEditScreen$lambda$12(mutableState2);
        if (ProfileVehicleEditScreen$lambda$12) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope BottomSheetContainer, Composer composer, int i5) {
        int i6;
        boolean ProfileVehicleEditScreen$lambda$15;
        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
        if ((i5 & 6) == 0) {
            i6 = i5 | (composer.changed(BottomSheetContainer) ? 4 : 2);
        } else {
            i6 = i5;
        }
        if ((i6 & 19) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(557954190, i6, -1, "dk.molslinjen.ui.views.screens.profile.vehicles.edit.ProfileVehicleEditScreen.<anonymous> (ProfileVehicleEditScreen.kt:100)");
        }
        boolean z5 = this.$isLoading;
        InputState inputState = this.$inputState;
        ProfileVehiclesEditViewModel profileVehiclesEditViewModel = this.$viewModel;
        composer.startReplaceGroup(-505477893);
        boolean changedInstance = composer.changedInstance(profileVehiclesEditViewModel);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$6$1$1(profileVehiclesEditViewModel);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        Function0 function0 = (Function0) ((KFunction) rememberedValue);
        ProfileVehiclesEditViewModel profileVehiclesEditViewModel2 = this.$viewModel;
        composer.startReplaceGroup(-505475876);
        boolean changedInstance2 = composer.changedInstance(profileVehiclesEditViewModel2);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$6$2$1(profileVehiclesEditViewModel2);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        Function1 function1 = (Function1) ((KFunction) rememberedValue2);
        ProfileVehiclesEditViewModel profileVehiclesEditViewModel3 = this.$viewModel;
        composer.startReplaceGroup(-505474092);
        boolean changedInstance3 = composer.changedInstance(profileVehiclesEditViewModel3);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = new ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$6$3$1(profileVehiclesEditViewModel3);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        Function1 function12 = (Function1) ((KFunction) rememberedValue3);
        ProfileVehicleEditScreen$lambda$15 = ProfileVehicleEditScreenKt.ProfileVehicleEditScreen$lambda$15(this.$submitFieldsTrigger$delegate);
        composer.startReplaceGroup(-505470413);
        final MutableState<Boolean> mutableState = this.$isFormValid$delegate;
        Object rememberedValue4 = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue4 == companion.getEmpty()) {
            rememberedValue4 = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.vehicles.edit.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$4$lambda$3;
                    invoke$lambda$4$lambda$3 = ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$6.invoke$lambda$4$lambda$3(MutableState.this, ((Boolean) obj).booleanValue());
                    return invoke$lambda$4$lambda$3;
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        Function1 function13 = (Function1) rememberedValue4;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-505468595);
        final Function0<Unit> function02 = this.$onSubmit;
        final MutableState<Boolean> mutableState2 = this.$submitFieldsTrigger$delegate;
        final MutableState<Boolean> mutableState3 = this.$isFormValid$delegate;
        Object rememberedValue5 = composer.rememberedValue();
        if (rememberedValue5 == companion.getEmpty()) {
            rememberedValue5 = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.vehicles.edit.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$6$lambda$5;
                    invoke$lambda$6$lambda$5 = ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$6.invoke$lambda$6$lambda$5(Function0.this, mutableState2, mutableState3);
                    return invoke$lambda$6$lambda$5;
                }
            };
            composer.updateRememberedValue(rememberedValue5);
        }
        composer.endReplaceGroup();
        ProfileVehicleEditScreenKt.ProfileVehicleEditScreenContent(BottomSheetContainer, z5, inputState, function0, function1, function12, ProfileVehicleEditScreen$lambda$15, function13, (Function0) rememberedValue5, composer, 113246208 | (i6 & 14));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
