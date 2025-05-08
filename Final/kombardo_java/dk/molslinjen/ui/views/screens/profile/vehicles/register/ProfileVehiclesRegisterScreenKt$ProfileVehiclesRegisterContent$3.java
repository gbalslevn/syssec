package dk.molslinjen.ui.views.screens.profile.vehicles.register;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.res.StringResources_androidKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileVehiclesRegisterScreenKt$ProfileVehiclesRegisterContent$3 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function0<Unit> $dismiss;
    final /* synthetic */ MutableState<Boolean> $isFormValid$delegate;
    final /* synthetic */ boolean $isLoading;
    final /* synthetic */ MutableState<Boolean> $submitFieldsTrigger$delegate;
    final /* synthetic */ Function1<Function0<Unit>, Unit> $validateLicencePlate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public ProfileVehiclesRegisterScreenKt$ProfileVehiclesRegisterContent$3(boolean z5, Function1<? super Function0<Unit>, Unit> function1, Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
        this.$isLoading = z5;
        this.$validateLicencePlate = function1;
        this.$dismiss = function0;
        this.$isFormValid$delegate = mutableState;
        this.$submitFieldsTrigger$delegate = mutableState2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState mutableState) {
        ProfileVehiclesRegisterScreenKt.ProfileVehiclesRegisterContent$lambda$14(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(Function1 function1, Function0 function0) {
        function1.invoke(function0);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        boolean ProfileVehiclesRegisterContent$lambda$10;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2113198450, i5, -1, "dk.molslinjen.ui.views.screens.profile.vehicles.register.ProfileVehiclesRegisterContent.<anonymous> (ProfileVehiclesRegisterScreen.kt:80)");
        }
        String stringResource = StringResources_androidKt.stringResource(R.string.profile_vehicles_registerVehicle, composer, 6);
        ProfileVehiclesRegisterContent$lambda$10 = ProfileVehiclesRegisterScreenKt.ProfileVehiclesRegisterContent$lambda$10(this.$isFormValid$delegate);
        boolean z5 = ProfileVehiclesRegisterContent$lambda$10 && !this.$isLoading;
        boolean z6 = this.$isLoading;
        composer.startReplaceGroup(-1891415599);
        final MutableState<Boolean> mutableState = this.$submitFieldsTrigger$delegate;
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.vehicles.register.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = ProfileVehiclesRegisterScreenKt$ProfileVehiclesRegisterContent$3.invoke$lambda$1$lambda$0(MutableState.this);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function0 function0 = (Function0) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-1891417804);
        boolean changed = composer.changed(this.$validateLicencePlate) | composer.changed(this.$dismiss);
        final Function1<Function0<Unit>, Unit> function1 = this.$validateLicencePlate;
        final Function0<Unit> function02 = this.$dismiss;
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.vehicles.register.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = ProfileVehiclesRegisterScreenKt$ProfileVehiclesRegisterContent$3.invoke$lambda$3$lambda$2(Function1.this, function02);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(stringResource, null, z5, z6, false, 0L, function0, (Function0) rememberedValue2, composer, 1572864, 50);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
