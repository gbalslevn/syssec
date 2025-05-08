package dk.molslinjen.extensions;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class ModifierExtensionsKt$noRippleClickable$1 implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Function0<Unit> $onClick;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModifierExtensionsKt$noRippleClickable$1(Function0<Unit> function0) {
        this.$onClick = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    public final Modifier invoke(Modifier composed, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.startReplaceGroup(-561333878);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-561333878, i5, -1, "dk.molslinjen.extensions.noRippleClickable.<anonymous> (ModifierExtensions.kt:25)");
        }
        composer.startReplaceGroup(-1507792231);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(rememberedValue);
        }
        MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-1507790773);
        boolean changed = composer.changed(this.$onClick);
        final Function0<Unit> function0 = this.$onClick;
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.extensions.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = ModifierExtensionsKt$noRippleClickable$1.invoke$lambda$2$lambda$1(Function0.this);
                    return invoke$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        Modifier m120clickableO2vRcR0$default = ClickableKt.m120clickableO2vRcR0$default(composed, mutableInteractionSource, null, false, null, null, (Function0) rememberedValue2, 28, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return m120clickableO2vRcR0$default;
    }
}
