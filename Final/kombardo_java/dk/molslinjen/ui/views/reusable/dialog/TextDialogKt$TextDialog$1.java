package dk.molslinjen.ui.views.reusable.dialog;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.ui.theme.TypographyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class TextDialogKt$TextDialog$1 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ String $description;
    final /* synthetic */ String $title;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextDialogKt$TextDialog$1(String str, String str2) {
        this.$title = str;
        this.$description = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.m2183setLiveRegionhR3wRGc(semantics, LiveRegionMode.INSTANCE.m2161getAssertive0phEisY());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope CustomDialog, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(CustomDialog, "$this$CustomDialog");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1043973530, i5, -1, "dk.molslinjen.ui.views.reusable.dialog.TextDialog.<anonymous> (TextDialog.kt:33)");
        }
        TextStyle paragraphBold = TypographyKt.getParagraphBold();
        TextAlign.Companion companion = TextAlign.INSTANCE;
        int m2528getCentere0LSkKk = companion.m2528getCentere0LSkKk();
        Modifier.Companion companion2 = Modifier.INSTANCE;
        composer.startReplaceGroup(1129103770);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.reusable.dialog.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = TextDialogKt$TextDialog$1.invoke$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        TextKt.m940Text4IGK_g(this.$title, SemanticsModifierKt.semantics$default(companion2, false, (Function1) rememberedValue, 1, null), 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(m2528getCentere0LSkKk), 0L, 0, false, 0, 0, null, paragraphBold, composer, 0, 1572864, 65020);
        String str = this.$description;
        if (str != null) {
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(16)), composer, 6);
            TextKt.m940Text4IGK_g(str, null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer, 0, 1572864, 65022);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
