package dk.molslinjen.ui.views.reusable;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.InputErrorTextKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a%\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/layout/ColumnScope;", BuildConfig.FLAVOR, "visible", BuildConfig.FLAVOR, "errorMessage", BuildConfig.FLAVOR, "InputErrorText", "(Landroidx/compose/foundation/layout/ColumnScope;ZLjava/lang/String;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class InputErrorTextKt {
    public static final void InputErrorText(final ColumnScope columnScope, final boolean z5, final String str, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(columnScope, "<this>");
        Composer startRestartGroup = composer.startRestartGroup(-1071651528);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(columnScope) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1071651528, i6, -1, "dk.molslinjen.ui.views.reusable.InputErrorText (InputErrorText.kt:18)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            startRestartGroup.startReplaceGroup(-795626483);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: W1.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit InputErrorText$lambda$1$lambda$0;
                        InputErrorText$lambda$1$lambda$0 = InputErrorTextKt.InputErrorText$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                        return InputErrorText$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            AnimatedVisibilityKt.AnimatedVisibility(columnScope, z5 && str != null, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1854793232, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.InputErrorTextKt$InputErrorText$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                    invoke(animatedVisibilityScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i7) {
                    TextStyle m2295copyp1EtxEg;
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1854793232, i7, -1, "dk.molslinjen.ui.views.reusable.InputErrorText.<anonymous> (InputErrorText.kt:25)");
                    }
                    String str2 = str;
                    if (str2 == null) {
                        str2 = BuildConfig.FLAVOR;
                    }
                    m2295copyp1EtxEg = r3.m2295copyp1EtxEg((r48 & 1) != 0 ? r3.spanStyle.m2255getColor0d7_KjU() : AppColor.INSTANCE.m3272getSignalRed0d7_KjU(), (r48 & 2) != 0 ? r3.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r3.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r3.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r3.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r3.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r3.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r3.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r3.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r3.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r3.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r3.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r3.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r3.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r3.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r3.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r3.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r3.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r3.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r3.platformStyle : null, (r48 & 1048576) != 0 ? r3.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r3.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r3.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? TypographyKt.getSub().paragraphStyle.getTextMotion() : null);
                    TextKt.m940Text4IGK_g(str2, PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, m2295copyp1EtxEg, composer2, 48, 0, 65532);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i6 & 14) | 1572864, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: W1.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit InputErrorText$lambda$2;
                    InputErrorText$lambda$2 = InputErrorTextKt.InputErrorText$lambda$2(ColumnScope.this, z5, str, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return InputErrorText$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputErrorText$lambda$1$lambda$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.m2183setLiveRegionhR3wRGc(semantics, LiveRegionMode.INSTANCE.m2161getAssertive0phEisY());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputErrorText$lambda$2(ColumnScope columnScope, boolean z5, String str, int i5, Composer composer, int i6) {
        InputErrorText(columnScope, z5, str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
