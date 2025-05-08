package dk.molslinjen.ui.views.screens.developer.inputs;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import dk.molslinjen.ui.views.reusable.buttons.ButtonConfig;
import dk.molslinjen.ui.views.reusable.buttons.DestructiveButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* renamed from: dk.molslinjen.ui.views.screens.developer.inputs.ComposableSingletons$DeveloperInputButtonsKt$lambda-5$1, reason: invalid class name */
/* loaded from: classes2.dex */
final class ComposableSingletons$DeveloperInputButtonsKt$lambda5$1 implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$DeveloperInputButtonsKt$lambda5$1 INSTANCE = new ComposableSingletons$DeveloperInputButtonsKt$lambda5$1();

    ComposableSingletons$DeveloperInputButtonsKt$lambda5$1() {
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
            ComposerKt.traceEventStart(1265377493, i5, -1, "dk.molslinjen.ui.views.screens.developer.inputs.ComposableSingletons$DeveloperInputButtonsKt.lambda-5.<anonymous> (DeveloperInputButtons.kt:209)");
        }
        ButtonConfig buttonConfig = ButtonConfig.Small;
        composer.startReplaceGroup(2067101831);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.q
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
        DestructiveButtonKt.DestructiveButton(null, "Button title", (Function0) rememberedValue, null, buttonConfig, false, false, composer, 221616, 73);
        ButtonConfig buttonConfig2 = ButtonConfig.Regular;
        composer.startReplaceGroup(2067108135);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.r
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
        DestructiveButtonKt.DestructiveButton(null, "Button title", (Function0) rememberedValue2, null, buttonConfig2, false, false, composer, 221616, 73);
        ButtonConfig buttonConfig3 = ButtonConfig.Large;
        composer.startReplaceGroup(2067114503);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.s
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
        DestructiveButtonKt.DestructiveButton(null, "Button title", (Function0) rememberedValue3, null, buttonConfig3, false, true, composer, 1794480, 9);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
