package dk.molslinjen.ui.views.screens.developer.inputs;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.buttons.ButtonConfig;
import dk.molslinjen.ui.views.reusable.buttons.SecondaryButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* renamed from: dk.molslinjen.ui.views.screens.developer.inputs.ComposableSingletons$DeveloperInputButtonsKt$lambda-2$1, reason: invalid class name */
/* loaded from: classes2.dex */
final class ComposableSingletons$DeveloperInputButtonsKt$lambda2$1 implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$DeveloperInputButtonsKt$lambda2$1 INSTANCE = new ComposableSingletons$DeveloperInputButtonsKt$lambda2$1();

    ComposableSingletons$DeveloperInputButtonsKt$lambda2$1() {
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(356715320, i5, -1, "dk.molslinjen.ui.views.screens.developer.inputs.ComposableSingletons$DeveloperInputButtonsKt.lambda-2.<anonymous> (DeveloperInputButtons.kt:102)");
        }
        composer.startReplaceGroup(1839305988);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        ButtonConfig buttonConfig = ButtonConfig.Small;
        SecondaryButtonKt.m3406SecondaryButtonbZJ32A(null, "Button title", (Function0) rememberedValue, null, false, buttonConfig, false, null, null, 0L, false, composer, 197040, 0, 2009);
        composer.startReplaceGroup(1839311172);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        SecondaryButtonKt.m3406SecondaryButtonbZJ32A(null, "Button title", (Function0) rememberedValue2, null, false, buttonConfig, false, Integer.valueOf(R.drawable.icon_profile), null, 0L, false, composer, 12779952, 0, 1881);
        composer.startReplaceGroup(1839318020);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        SecondaryButtonKt.m3406SecondaryButtonbZJ32A(null, "Button title", (Function0) rememberedValue3, null, false, buttonConfig, false, null, Integer.valueOf(R.drawable.icon_profile), 0L, false, composer, 100860336, 0, 1753);
        composer.startReplaceGroup(1839324900);
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
            rememberedValue4 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.g
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceGroup();
        SecondaryButtonKt.m3406SecondaryButtonbZJ32A(null, "Button title", (Function0) rememberedValue4, null, false, buttonConfig, false, Integer.valueOf(R.drawable.icon_profile), Integer.valueOf(R.drawable.icon_profile), 0L, false, composer, 113443248, 0, 1625);
        composer.startReplaceGroup(1839333444);
        Object rememberedValue5 = composer.rememberedValue();
        if (rememberedValue5 == companion.getEmpty()) {
            rememberedValue5 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
            composer.updateRememberedValue(rememberedValue5);
        }
        composer.endReplaceGroup();
        SecondaryButtonKt.m3406SecondaryButtonbZJ32A(null, "Button title", (Function0) rememberedValue5, null, false, ButtonConfig.Regular, true, null, null, 0L, false, composer, 1769904, 0, 1945);
        composer.startReplaceGroup(1839339780);
        Object rememberedValue6 = composer.rememberedValue();
        if (rememberedValue6 == companion.getEmpty()) {
            rememberedValue6 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
            composer.updateRememberedValue(rememberedValue6);
        }
        composer.endReplaceGroup();
        SecondaryButtonKt.m3406SecondaryButtonbZJ32A(null, "Button title", (Function0) rememberedValue6, null, false, ButtonConfig.Large, false, null, null, 0L, false, composer, 197040, 0, 2009);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
