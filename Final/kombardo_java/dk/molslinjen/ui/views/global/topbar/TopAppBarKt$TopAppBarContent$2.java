package dk.molslinjen.ui.views.global.topbar;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.TextUnitKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class TopAppBarKt$TopAppBarContent$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ TopBarConfiguration $topBarConfig;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TopAppBarKt$TopAppBarContent$2(TopBarConfiguration topBarConfiguration, FocusRequester focusRequester) {
        this.$topBarConfig = topBarConfiguration;
        this.$focusRequester = focusRequester;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1$lambda$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.heading(semantics);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        TextStyle m2295copyp1EtxEg;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1130212514, i5, -1, "dk.molslinjen.ui.views.global.topbar.TopAppBarContent.<anonymous> (TopAppBar.kt:63)");
        }
        Integer title = this.$topBarConfig.getTitle();
        if (title != null) {
            FocusRequester focusRequester = this.$focusRequester;
            int intValue = title.intValue();
            Modifier.Companion companion = Modifier.INSTANCE;
            composer.startReplaceGroup(-960986272);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.global.topbar.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$2$lambda$1$lambda$0;
                        invoke$lambda$2$lambda$1$lambda$0 = TopAppBarKt$TopAppBarContent$2.invoke$lambda$2$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                        return invoke$lambda$2$lambda$1$lambda$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            Modifier focusable$default = FocusableKt.focusable$default(FocusRequesterModifierKt.focusRequester(SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null), focusRequester), false, null, 3, null);
            String stringResource = StringResources_androidKt.stringResource(intValue, composer, 0);
            m2295copyp1EtxEg = r15.m2295copyp1EtxEg((r48 & 1) != 0 ? r15.spanStyle.m2255getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r15.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r15.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r15.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r15.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r15.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r15.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r15.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r15.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r15.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r15.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r15.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r15.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r15.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r15.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r15.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r15.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r15.paragraphStyle.getLineHeight() : TextUnitKt.getSp(18), (r48 & 262144) != 0 ? r15.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r15.platformStyle : null, (r48 & 1048576) != 0 ? r15.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r15.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r15.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? TypographyKt.getH3Bold().paragraphStyle.getTextMotion() : null);
            TextKt.m940Text4IGK_g(stringResource, focusable$default, AppColor.INSTANCE.m3281getWhite0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, m2295copyp1EtxEg, composer, 384, 0, 65528);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
