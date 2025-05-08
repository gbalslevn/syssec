package dk.molslinjen.ui.views.screens.developer.inputs;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import dk.molslinjen.core.snackbar.SnackbarEvent;
import dk.molslinjen.core.snackbar.SnackbarText;
import dk.molslinjen.ui.views.reusable.buttons.ButtonConfig;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class DeveloperInputButtonsKt$DeveloperInputButtons$1$4 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function1<SnackbarEvent, Unit> $showSnackbar;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public DeveloperInputButtonsKt$DeveloperInputButtons$1$4(Function1<? super SnackbarEvent, Unit> function1) {
        this.$showSnackbar = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$11$lambda$10(Function1 function1) {
        function1.invoke(new SnackbarEvent.Information(new SnackbarText.StringText("Clicked disabled button"), null, false, 6, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(Function1 function1) {
        function1.invoke(new SnackbarEvent.Information(new SnackbarText.StringText("Clicked disabled button"), null, false, 6, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$6(Function1 function1) {
        function1.invoke(new SnackbarEvent.Information(new SnackbarText.StringText("Clicked disabled button"), null, false, 6, null));
        return Unit.INSTANCE;
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
            ComposerKt.traceEventStart(53827929, i5, -1, "dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputButtons.<anonymous>.<anonymous> (DeveloperInputButtons.kt:68)");
        }
        ButtonConfig buttonConfig = ButtonConfig.Small;
        composer.startReplaceGroup(2013875845);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.t
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function0 function0 = (Function0) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(2013877154);
        boolean changed = composer.changed(this.$showSnackbar);
        final Function1<SnackbarEvent, Unit> function1 = this.$showSnackbar;
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.u
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = DeveloperInputButtonsKt$DeveloperInputButtons$1$4.invoke$lambda$3$lambda$2(Function1.this);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        PrimaryButtonKt.PrimaryButton(null, "Button title", function0, (Function0) rememberedValue2, buttonConfig, false, true, false, composer, 1794480, 129);
        ButtonConfig buttonConfig2 = ButtonConfig.Regular;
        composer.startReplaceGroup(2013887301);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.v
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        Function0 function02 = (Function0) rememberedValue3;
        composer.endReplaceGroup();
        composer.startReplaceGroup(2013888610);
        boolean changed2 = composer.changed(this.$showSnackbar);
        final Function1<SnackbarEvent, Unit> function12 = this.$showSnackbar;
        Object rememberedValue4 = composer.rememberedValue();
        if (changed2 || rememberedValue4 == companion.getEmpty()) {
            rememberedValue4 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.w
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$7$lambda$6;
                    invoke$lambda$7$lambda$6 = DeveloperInputButtonsKt$DeveloperInputButtons$1$4.invoke$lambda$7$lambda$6(Function1.this);
                    return invoke$lambda$7$lambda$6;
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceGroup();
        PrimaryButtonKt.PrimaryButton(null, "Button title", function02, (Function0) rememberedValue4, buttonConfig2, false, false, false, composer, 221616, 193);
        ButtonConfig buttonConfig3 = ButtonConfig.Large;
        composer.startReplaceGroup(2013897733);
        Object rememberedValue5 = composer.rememberedValue();
        if (rememberedValue5 == companion.getEmpty()) {
            rememberedValue5 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.x
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
            composer.updateRememberedValue(rememberedValue5);
        }
        Function0 function03 = (Function0) rememberedValue5;
        composer.endReplaceGroup();
        composer.startReplaceGroup(2013899042);
        boolean changed3 = composer.changed(this.$showSnackbar);
        final Function1<SnackbarEvent, Unit> function13 = this.$showSnackbar;
        Object rememberedValue6 = composer.rememberedValue();
        if (changed3 || rememberedValue6 == companion.getEmpty()) {
            rememberedValue6 = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.y
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$11$lambda$10;
                    invoke$lambda$11$lambda$10 = DeveloperInputButtonsKt$DeveloperInputButtons$1$4.invoke$lambda$11$lambda$10(Function1.this);
                    return invoke$lambda$11$lambda$10;
                }
            };
            composer.updateRememberedValue(rememberedValue6);
        }
        composer.endReplaceGroup();
        PrimaryButtonKt.PrimaryButton(null, "Button title", function03, (Function0) rememberedValue6, buttonConfig3, false, false, false, composer, 221616, 193);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
