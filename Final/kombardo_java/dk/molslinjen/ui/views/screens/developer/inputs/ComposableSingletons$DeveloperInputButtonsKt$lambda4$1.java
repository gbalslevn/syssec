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
/* renamed from: dk.molslinjen.ui.views.screens.developer.inputs.ComposableSingletons$DeveloperInputButtonsKt$lambda-4$1, reason: invalid class name */
/* loaded from: classes2.dex */
final class ComposableSingletons$DeveloperInputButtonsKt$lambda4$1 implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$DeveloperInputButtonsKt$lambda4$1 INSTANCE = new ComposableSingletons$DeveloperInputButtonsKt$lambda4$1();

    ComposableSingletons$DeveloperInputButtonsKt$lambda4$1() {
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
            ComposerKt.traceEventStart(962490102, i5, -1, "dk.molslinjen.ui.views.screens.developer.inputs.ComposableSingletons$DeveloperInputButtonsKt.lambda-4.<anonymous> (DeveloperInputButtons.kt:184)");
        }
        composer.startReplaceGroup(559526534);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.n
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
        DestructiveButtonKt.DestructiveButton(null, "Button title", (Function0) rememberedValue, null, ButtonConfig.Small, false, false, composer, 25008, 105);
        composer.startReplaceGroup(559531782);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.o
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
        DestructiveButtonKt.DestructiveButton(null, "Button title", (Function0) rememberedValue2, null, ButtonConfig.Regular, false, false, composer, 25008, 105);
        composer.startReplaceGroup(559537094);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.p
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
        DestructiveButtonKt.DestructiveButton(null, "Button title", (Function0) rememberedValue3, null, ButtonConfig.Large, false, true, composer, 1597872, 41);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
