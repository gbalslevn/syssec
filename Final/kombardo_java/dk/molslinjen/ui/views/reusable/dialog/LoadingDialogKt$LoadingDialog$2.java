package dk.molslinjen.ui.views.reusable.dialog;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
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
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class LoadingDialogKt$LoadingDialog$2 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ String $title;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoadingDialogKt$LoadingDialog$2(String str) {
        this.$title = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1$lambda$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.m2183setLiveRegionhR3wRGc(semantics, LiveRegionMode.INSTANCE.m2162getPolite0phEisY());
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
            ComposerKt.traceEventStart(60315533, i5, -1, "dk.molslinjen.ui.views.reusable.dialog.LoadingDialog.<anonymous> (LoadingDialog.kt:24)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        LoadingComponentKt.m3392LoadingComponentjfnsLPA(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(200)), 0.0f, true, 0, false, null, ComposableSingletons$LoadingDialogKt.INSTANCE.m3409getLambda1$app_kombardoProd(), composer, 1573254, 58);
        String str = this.$title;
        if (str != null) {
            TextStyle paragraphSmall = TypographyKt.getParagraphSmall();
            int m2528getCentere0LSkKk = TextAlign.INSTANCE.m2528getCentere0LSkKk();
            composer.startReplaceGroup(501281323);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.reusable.dialog.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$2$lambda$1$lambda$0;
                        invoke$lambda$2$lambda$1$lambda$0 = LoadingDialogKt$LoadingDialog$2.invoke$lambda$2$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                        return invoke$lambda$2$lambda$1$lambda$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            TextKt.m940Text4IGK_g(str, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null), 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(m2528getCentere0LSkKk), 0L, 0, false, 0, 0, null, paragraphSmall, composer, 0, 1572864, 65020);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
