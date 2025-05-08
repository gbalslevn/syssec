package dk.molslinjen.ui.views.reusable.buttons;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.AutoShrinkTextKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BaseButtonKt$BaseButton$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ boolean $autoShrinkText;
    final /* synthetic */ BorderStroke $border;
    final /* synthetic */ ButtonConfig $buttonConfig;
    final /* synthetic */ boolean $clearFocusOnClick;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ FocusManager $focusManager;
    final /* synthetic */ boolean $isLoading;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $leftContent;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ Function0<Unit> $onClickDisabled;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $rightContent;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ ButtonStyle $style;
    final /* synthetic */ String $text;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseButtonKt$BaseButton$1(Modifier modifier, ButtonConfig buttonConfig, boolean z5, Function0<Unit> function0, ButtonStyle buttonStyle, boolean z6, FocusManager focusManager, boolean z7, Function0<Unit> function02, Shape shape, BorderStroke borderStroke, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, String str, boolean z8, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32) {
        this.$modifier = modifier;
        this.$buttonConfig = buttonConfig;
        this.$enabled = z5;
        this.$onClickDisabled = function0;
        this.$style = buttonStyle;
        this.$clearFocusOnClick = z6;
        this.$focusManager = focusManager;
        this.$isLoading = z7;
        this.$onClick = function02;
        this.$shape = shape;
        this.$border = borderStroke;
        this.$leftContent = function3;
        this.$text = str;
        this.$autoShrinkText = z8;
        this.$rightContent = function32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(boolean z5, FocusManager focusManager, boolean z6, boolean z7, Function0 function0, Function0 function02) {
        if (z5) {
            FocusManager.clearFocus$default(focusManager, false, 1, null);
        }
        if (z6 && !z7) {
            function0.invoke();
        } else if (function02 != null) {
            function02.invoke();
        }
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
            ComposerKt.traceEventStart(-1556362792, i5, -1, "dk.molslinjen.ui.views.reusable.buttons.BaseButton.<anonymous> (BaseButton.kt:59)");
        }
        Modifier m324defaultMinSizeVpY3zN4$default = SizeKt.m324defaultMinSizeVpY3zN4$default(this.$modifier, 0.0f, this.$buttonConfig.getHeight(), 1, null);
        boolean z5 = this.$enabled || this.$onClickDisabled != null;
        ButtonColors m779buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m779buttonColorsro_MJ88(this.$style.getColors().containerColor(this.$enabled, composer, 0).getValue().getValue(), this.$style.getColors().contentColor(this.$enabled, composer, 0).getValue().getValue(), this.$style.getColors().containerColor(false, composer, 6).getValue().getValue(), this.$style.getColors().contentColor(false, composer, 6).getValue().getValue(), composer, ButtonDefaults.$stable << 12, 0);
        composer.startReplaceGroup(188789488);
        boolean changed = composer.changed(this.$clearFocusOnClick) | composer.changedInstance(this.$focusManager) | composer.changed(this.$enabled) | composer.changed(this.$isLoading) | composer.changed(this.$onClick) | composer.changed(this.$onClickDisabled);
        final boolean z6 = this.$clearFocusOnClick;
        final FocusManager focusManager = this.$focusManager;
        final boolean z7 = this.$enabled;
        final boolean z8 = this.$isLoading;
        final Function0<Unit> function0 = this.$onClick;
        final Function0<Unit> function02 = this.$onClickDisabled;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.reusable.buttons.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = BaseButtonKt$BaseButton$1.invoke$lambda$1$lambda$0(z6, focusManager, z7, z8, function0, function02);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        Shape shape = this.$shape;
        BorderStroke borderStroke = this.$border;
        final Function3<RowScope, Composer, Integer, Unit> function3 = this.$leftContent;
        final ButtonStyle buttonStyle = this.$style;
        final boolean z9 = this.$enabled;
        final ButtonConfig buttonConfig = this.$buttonConfig;
        final String str = this.$text;
        final boolean z10 = this.$autoShrinkText;
        final Function3<RowScope, Composer, Integer, Unit> function32 = this.$rightContent;
        final boolean z11 = this.$isLoading;
        ButtonKt.Button((Function0) rememberedValue, m324defaultMinSizeVpY3zN4$default, z5, shape, m779buttonColorsro_MJ88, null, borderStroke, null, null, ComposableLambdaKt.rememberComposableLambda(-119116824, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.buttons.BaseButtonKt$BaseButton$1.2
            private static final LottieComposition invoke$lambda$0(LottieCompositionResult lottieCompositionResult) {
                return lottieCompositionResult.getValue();
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                invoke(rowScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RowScope Button, Composer composer2, int i6) {
                int i7;
                Intrinsics.checkNotNullParameter(Button, "$this$Button");
                if ((i6 & 6) == 0) {
                    i7 = i6 | (composer2.changed(Button) ? 4 : 2);
                } else {
                    i7 = i6;
                }
                if ((i7 & 19) == 18 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-119116824, i7, -1, "dk.molslinjen.ui.views.reusable.buttons.BaseButton.<anonymous>.<anonymous> (BaseButton.kt:84)");
                }
                Function3<RowScope, Composer, Integer, Unit> function33 = function3;
                composer2.startReplaceGroup(-244889633);
                if (function33 != null) {
                    function33.invoke(Button, composer2, Integer.valueOf(i7 & 14));
                    Unit unit = Unit.INSTANCE;
                }
                composer2.endReplaceGroup();
                Modifier.Companion companion = Modifier.INSTANCE;
                int i8 = i7;
                AutoShrinkTextKt.m3384AutoShrinkTextwoKQQc(str, PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(8), 0.0f, 2, null), z10, buttonStyle.getColors().contentColor(z9, composer2, 0).getValue().getValue(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, buttonConfig.getTextStyle(), composer2, 48, 0, 32752);
                Function3<RowScope, Composer, Integer, Unit> function34 = function32;
                composer2.startReplaceGroup(-244878625);
                if (function34 != null) {
                    function34.invoke(Button, composer2, Integer.valueOf(i8 & 14));
                    Unit unit2 = Unit.INSTANCE;
                }
                composer2.endReplaceGroup();
                if (z11) {
                    LottieAnimationKt.LottieAnimation(invoke$lambda$0(RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.RawRes.m2761boximpl(LottieCompositionSpec.RawRes.m2762constructorimpl(R.raw.animation_lottie_loadspinner)), null, null, null, null, null, composer2, 6, 62)), SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(16)), false, false, null, 0.0f, Integer.MAX_VALUE, false, false, false, null, false, false, null, null, null, false, null, composer2, 1572912, 0, 262076);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, 805306368, 416);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
