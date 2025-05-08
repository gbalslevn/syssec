package dk.molslinjen.ui.views.screens.profile.faq.subject;

import android.util.Patterns;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import dev.jeziellago.compose.markdowntext.MarkdownTextKt;
import dk.molslinjen.domain.model.faq.FaqQuestionAndAnswer;
import dk.molslinjen.ui.theme.TypographyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class FaqSubjectScreenKt$QAView$2$2 implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
    final /* synthetic */ FaqQuestionAndAnswer $questionAndAnswer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FaqSubjectScreenKt$QAView$2$2(FaqQuestionAndAnswer faqQuestionAndAnswer) {
        this.$questionAndAnswer = faqQuestionAndAnswer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(UriHandler uriHandler, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (Patterns.WEB_URL.matcher(it).matches()) {
            uriHandler.openUri(it);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
        invoke(animatedVisibilityScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(941004433, i5, -1, "dk.molslinjen.ui.views.screens.profile.faq.subject.QAView.<anonymous>.<anonymous> (FaqSubjectScreen.kt:176)");
        }
        final UriHandler uriHandler = (UriHandler) composer.consume(CompositionLocalsKt.getLocalUriHandler());
        Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(24), 0.0f, Dp.m2599constructorimpl(8), 5, null);
        String answer = this.$questionAndAnswer.getAnswer();
        TextStyle paragraphSmall = TypographyKt.getParagraphSmall();
        composer.startReplaceGroup(-1852903311);
        boolean changedInstance = composer.changedInstance(uriHandler);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.faq.subject.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = FaqSubjectScreenKt$QAView$2$2.invoke$lambda$1$lambda$0(UriHandler.this, (String) obj);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        MarkdownTextKt.m3186MarkdownTextnAGSkkc(answer, m315paddingqDBjuR0$default, 0L, 0L, null, 0, null, paragraphSmall, null, null, false, null, (Function1) rememberedValue, null, composer, 12582960, 0, 12156);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
