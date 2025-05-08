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
/* renamed from: dk.molslinjen.ui.views.screens.developer.inputs.ComposableSingletons$DeveloperInputButtonsKt$lambda-3$1, reason: invalid class name */
/* loaded from: classes2.dex */
final class ComposableSingletons$DeveloperInputButtonsKt$lambda3$1 implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$DeveloperInputButtonsKt$lambda3$1 INSTANCE = new ComposableSingletons$DeveloperInputButtonsKt$lambda3$1();

    ComposableSingletons$DeveloperInputButtonsKt$lambda3$1() {
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
            ComposerKt.traceEventStart(659602711, i5, -1, "dk.molslinjen.ui.views.screens.developer.inputs.ComposableSingletons$DeveloperInputButtonsKt.lambda-3.<anonymous> (DeveloperInputButtons.kt:146)");
        }
        composer.startReplaceGroup(-948063995);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.j
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
        SecondaryButtonKt.m3406SecondaryButtonbZJ32A(null, "Button title", (Function0) rememberedValue, null, false, buttonConfig, false, null, null, 0L, false, composer, 221616, 0, 1993);
        composer.startReplaceGroup(-948057755);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.k
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
        SecondaryButtonKt.m3406SecondaryButtonbZJ32A(null, "Button title", (Function0) rememberedValue2, null, false, buttonConfig, false, Integer.valueOf(R.drawable.icon_profile), Integer.valueOf(R.drawable.icon_profile), 0L, false, composer, 113467824, 0, 1609);
        composer.startReplaceGroup(-948048155);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.l
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
        SecondaryButtonKt.m3406SecondaryButtonbZJ32A(null, "Button title", (Function0) rememberedValue3, null, false, ButtonConfig.Regular, true, null, null, 0L, false, composer, 1794480, 0, 1929);
        composer.startReplaceGroup(-948040763);
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
            rememberedValue4 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.m
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
        SecondaryButtonKt.m3406SecondaryButtonbZJ32A(null, "Button title", (Function0) rememberedValue4, null, false, ButtonConfig.Large, false, null, null, 0L, false, composer, 221616, 0, 1993);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
