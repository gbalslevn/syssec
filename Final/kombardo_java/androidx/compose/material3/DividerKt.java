package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a0\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/unit/Dp;", "thickness", "Landroidx/compose/ui/graphics/Color;", "color", BuildConfig.FLAVOR, "Divider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "Divider", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DividerKt {
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0071, code lost:
    
        if ((r14 & 4) != 0) goto L46;
     */
    @Deprecated
    /* renamed from: Divider-9IZ8Weo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m843Divider9IZ8Weo(Modifier modifier, float f5, long j5, Composer composer, final int i5, final int i6) {
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(1562471785);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i9 = i6 & 2;
        if (i9 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(f5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= ((i6 & 4) == 0 && startRestartGroup.changed(j5)) ? 256 : 128;
        }
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            startRestartGroup.startDefaults();
            if ((i5 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if (i8 != 0) {
                    modifier = Modifier.INSTANCE;
                }
                if (i9 != 0) {
                    f5 = DividerDefaults.INSTANCE.m842getThicknessD9Ej5fM();
                }
                if ((i6 & 4) != 0) {
                    j5 = DividerDefaults.INSTANCE.getColor(startRestartGroup, 6);
                    i7 &= -897;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1562471785, i7, -1, "androidx.compose.material3.Divider (Divider.kt:101)");
                }
                startRestartGroup.startReplaceGroup(-433645095);
                float m2599constructorimpl = Dp.m2601equalsimpl0(f5, Dp.INSTANCE.m2606getHairlineD9Ej5fM()) ? Dp.m2599constructorimpl(1.0f / ((Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).getDensity()) : f5;
                startRestartGroup.endReplaceGroup();
                BoxKt.Box(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.m325height3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), m2599constructorimpl), j5, null, 2, null), startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
            }
        }
        final Modifier modifier2 = modifier;
        final float f6 = f5;
        final long j6 = j5;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DividerKt$Divider$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i10) {
                    DividerKt.m843Divider9IZ8Weo(Modifier.this, f6, j6, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                }
            });
        }
    }
}
