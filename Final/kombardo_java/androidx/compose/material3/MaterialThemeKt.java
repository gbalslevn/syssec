package androidx.compose.material3;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material.ripple.RippleThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a;\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\f\u0010\r\" \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/ColorScheme;", "colorScheme", "Landroidx/compose/material3/Shapes;", "shapes", "Landroidx/compose/material3/Typography;", "typography", "Lkotlin/Function0;", BuildConfig.FLAVOR, "content", "MaterialTheme", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "rememberTextSelectionColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "Landroidx/compose/runtime/ProvidableCompositionLocal;", BuildConfig.FLAVOR, "LocalUsingExpressiveTheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalUsingExpressiveTheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class MaterialThemeKt {
    private static final ProvidableCompositionLocal<Boolean> LocalUsingExpressiveTheme = CompositionLocalKt.staticCompositionLocalOf(new Function0<Boolean>() { // from class: androidx.compose.material3.MaterialThemeKt$LocalUsingExpressiveTheme$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    });

    /* JADX WARN: Code restructure failed: missing block: B:53:0x008e, code lost:
    
        if ((r15 & 4) != 0) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MaterialTheme(ColorScheme colorScheme, Shapes shapes, final Typography typography, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5, final int i6) {
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-2127166334);
        if ((i5 & 6) == 0) {
            i7 = (((i6 & 1) == 0 && startRestartGroup.changed(colorScheme)) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= ((i6 & 2) == 0 && startRestartGroup.changed(shapes)) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= ((i6 & 4) == 0 && startRestartGroup.changed(typography)) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i7 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            startRestartGroup.startDefaults();
            if ((i5 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if ((i6 & 1) != 0) {
                    colorScheme = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6);
                    i7 &= -15;
                }
                if ((i6 & 2) != 0) {
                    shapes = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6);
                    i7 &= -113;
                }
                if ((i6 & 4) != 0) {
                    typography = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
                    i7 &= -897;
                }
                int i8 = i7;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2127166334, i8, -1, "androidx.compose.material3.MaterialTheme (MaterialTheme.kt:55)");
                }
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ColorSchemeKt.getLocalColorScheme().provides(colorScheme), IndicationKt.getLocalIndication().provides(RippleKt.m885rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, startRestartGroup, 0, 7)), RippleThemeKt.getLocalRippleTheme().provides(CompatRippleTheme.INSTANCE), ShapesKt.getLocalShapes().provides(shapes), TextSelectionColorsKt.getLocalTextSelectionColors().provides(rememberTextSelectionColors(colorScheme, startRestartGroup, i8 & 14)), TypographyKt.getLocalTypography().provides(typography)}, ComposableLambdaKt.rememberComposableLambda(-1066563262, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MaterialThemeKt$MaterialTheme$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        if ((i9 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1066563262, i9, -1, "androidx.compose.material3.MaterialTheme.<anonymous> (MaterialTheme.kt:68)");
                        }
                        TextKt.ProvideTextStyle(Typography.this.getBodyLarge(), function2, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i6 & 1) != 0) {
                    i7 &= -15;
                }
                if ((i6 & 2) != 0) {
                    i7 &= -113;
                }
            }
        }
        final ColorScheme colorScheme2 = colorScheme;
        final Shapes shapes2 = shapes;
        final Typography typography2 = typography;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MaterialThemeKt$MaterialTheme$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i9) {
                    MaterialThemeKt.MaterialTheme(ColorScheme.this, shapes2, typography2, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                }
            });
        }
    }

    public static final SelectionColors rememberTextSelectionColors(ColorScheme colorScheme, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1866455512, i5, -1, "androidx.compose.material3.rememberTextSelectionColors (MaterialTheme.kt:159)");
        }
        long primary = colorScheme.getPrimary();
        boolean changed = composer.changed(primary);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new SelectionColors(primary, Color.m1485copywmQWz5c$default(primary, 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null);
            composer.updateRememberedValue(rememberedValue);
        }
        SelectionColors selectionColors = (SelectionColors) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return selectionColors;
    }
}
