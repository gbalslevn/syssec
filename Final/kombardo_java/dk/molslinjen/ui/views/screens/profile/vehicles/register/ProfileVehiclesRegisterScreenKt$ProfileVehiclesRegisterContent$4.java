package dk.molslinjen.ui.views.screens.profile.vehicles.register;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import dk.molslinjen.ui.views.screens.profile.vehicles.shared.InputState;
import dk.molslinjen.ui.views.screens.profile.vehicles.shared.ProfileVehicleInputContentKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileVehiclesRegisterScreenKt$ProfileVehiclesRegisterContent$4 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ Function0<Unit> $dismiss;
    final /* synthetic */ InputState $inputState;
    final /* synthetic */ MutableState<Boolean> $isFormValid$delegate;
    final /* synthetic */ boolean $isLoading;
    final /* synthetic */ MutableState<Boolean> $submitFieldsTrigger$delegate;
    final /* synthetic */ Function1<String, Unit> $updateLicensePlate;
    final /* synthetic */ Function1<String, Unit> $updateName;
    final /* synthetic */ Function1<Function0<Unit>, Unit> $validateLicencePlate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public ProfileVehiclesRegisterScreenKt$ProfileVehiclesRegisterContent$4(InputState inputState, boolean z5, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, Function1<? super Function0<Unit>, Unit> function13, Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
        this.$inputState = inputState;
        this.$isLoading = z5;
        this.$updateLicensePlate = function1;
        this.$updateName = function12;
        this.$validateLicencePlate = function13;
        this.$dismiss = function0;
        this.$submitFieldsTrigger$delegate = mutableState;
        this.$isFormValid$delegate = mutableState2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState mutableState, boolean z5) {
        ProfileVehiclesRegisterScreenKt.ProfileVehiclesRegisterContent$lambda$11(mutableState, z5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(Function1 function1, Function0 function0, MutableState mutableState, MutableState mutableState2) {
        boolean ProfileVehiclesRegisterContent$lambda$10;
        ProfileVehiclesRegisterScreenKt.ProfileVehiclesRegisterContent$lambda$14(mutableState, true);
        ProfileVehiclesRegisterContent$lambda$10 = ProfileVehiclesRegisterScreenKt.ProfileVehiclesRegisterContent$lambda$10(mutableState2);
        if (ProfileVehiclesRegisterContent$lambda$10) {
            function1.invoke(function0);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope BottomSheetContainer, Composer composer, int i5) {
        boolean ProfileVehiclesRegisterContent$lambda$13;
        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1324590653, i5, -1, "dk.molslinjen.ui.views.screens.profile.vehicles.register.ProfileVehiclesRegisterContent.<anonymous> (ProfileVehiclesRegisterScreen.kt:89)");
        }
        String licensePlate = this.$inputState.getLicensePlate();
        String name = this.$inputState.getName();
        boolean z5 = this.$isLoading;
        Function1<String, Unit> function1 = this.$updateLicensePlate;
        Function1<String, Unit> function12 = this.$updateName;
        ProfileVehiclesRegisterContent$lambda$13 = ProfileVehiclesRegisterScreenKt.ProfileVehiclesRegisterContent$lambda$13(this.$submitFieldsTrigger$delegate);
        composer.startReplaceGroup(-1891399289);
        final MutableState<Boolean> mutableState = this.$isFormValid$delegate;
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.vehicles.register.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = ProfileVehiclesRegisterScreenKt$ProfileVehiclesRegisterContent$4.invoke$lambda$1$lambda$0(MutableState.this, ((Boolean) obj).booleanValue());
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function1 function13 = (Function1) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-1891397452);
        boolean changed = composer.changed(this.$validateLicencePlate) | composer.changed(this.$dismiss);
        final Function1<Function0<Unit>, Unit> function14 = this.$validateLicencePlate;
        final Function0<Unit> function0 = this.$dismiss;
        final MutableState<Boolean> mutableState2 = this.$submitFieldsTrigger$delegate;
        final MutableState<Boolean> mutableState3 = this.$isFormValid$delegate;
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.vehicles.register.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = ProfileVehiclesRegisterScreenKt$ProfileVehiclesRegisterContent$4.invoke$lambda$3$lambda$2(Function1.this, function0, mutableState2, mutableState3);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        ProfileVehicleInputContentKt.ProfileVehicleInputContent(licensePlate, name, z5, function1, function12, ProfileVehiclesRegisterContent$lambda$13, function13, (Function0) rememberedValue2, composer, 1572864);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
