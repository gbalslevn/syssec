package dk.molslinjen.ui.views.reusable.input;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.PainterResources_androidKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.threeten.bp.LocalDate;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BirthdateInputKt$BirthdateInput$4$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function1<LocalDate, Unit> $onBirthdateChange;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public BirthdateInputKt$BirthdateInput$4$1(Function1<? super LocalDate, Unit> function1) {
        this.$onBirthdateChange = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function1 function1) {
        function1.invoke(null);
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
            ComposerKt.traceEventStart(-166218797, i5, -1, "dk.molslinjen.ui.views.reusable.input.BirthdateInput.<anonymous>.<anonymous> (BirthdateInput.kt:90)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        composer.startReplaceGroup(-2064456097);
        boolean changed = composer.changed(this.$onBirthdateChange);
        final Function1<LocalDate, Unit> function1 = this.$onBirthdateChange;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.reusable.input.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = BirthdateInputKt$BirthdateInput$4$1.invoke$lambda$1$lambda$0(Function1.this);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_close, composer, 6), Accessibility.INSTANCE.getSkip(), ClickableKt.m122clickableXHw0xAI$default(companion, false, null, null, (Function0) rememberedValue, 7, null), null, null, 0.0f, null, composer, 0, 120);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
