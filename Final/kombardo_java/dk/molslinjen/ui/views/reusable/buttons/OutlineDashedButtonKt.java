package dk.molslinjen.ui.views.reusable.buttons;

import androidx.compose.material3.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.Stroke;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.buttons.ButtonStyle;
import dk.molslinjen.ui.views.reusable.buttons.OutlineDashedButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001aW\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, BuildConfig.FLAVOR, "icon", "Landroidx/compose/ui/graphics/Color;", "containerColor", "borderColor", "contentColor", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", "OutlineDashedButton-EMNEwkI", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;IJJJLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "OutlineDashedButton", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class OutlineDashedButtonKt {
    /* renamed from: OutlineDashedButton-EMNEwkI, reason: not valid java name */
    public static final void m3405OutlineDashedButtonEMNEwkI(Modifier modifier, final String title, final int i5, long j5, long j6, long j7, final Function0<Unit> onClick, Composer composer, final int i6, final int i7) {
        int i8;
        long j8;
        long j9;
        Composer composer2;
        final Modifier modifier2;
        final long j10;
        final long j11;
        final long j12;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-235124252);
        int i9 = i7 & 1;
        if (i9 != 0) {
            i8 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i8 = (startRestartGroup.changed(modifier) ? 4 : 2) | i6;
        } else {
            i8 = i6;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changed(title) ? 32 : 16;
        }
        if ((i7 & 4) != 0) {
            i8 |= 384;
        } else if ((i6 & 384) == 0) {
            i8 |= startRestartGroup.changed(i5) ? 256 : 128;
        }
        int i10 = i7 & 8;
        if (i10 != 0) {
            i8 |= 3072;
        } else if ((i6 & 3072) == 0) {
            i8 |= startRestartGroup.changed(j5) ? 2048 : 1024;
        }
        int i11 = i7 & 16;
        if (i11 != 0) {
            i8 |= 24576;
            j8 = j6;
        } else {
            j8 = j6;
            if ((i6 & 24576) == 0) {
                i8 |= startRestartGroup.changed(j8) ? 16384 : 8192;
            }
        }
        int i12 = i7 & 32;
        if (i12 != 0) {
            i8 |= 196608;
            j9 = j7;
        } else {
            j9 = j7;
            if ((196608 & i6) == 0) {
                i8 |= startRestartGroup.changed(j9) ? 131072 : 65536;
            }
        }
        if ((i7 & 64) != 0) {
            i8 |= 1572864;
        } else if ((i6 & 1572864) == 0) {
            i8 |= startRestartGroup.changedInstance(onClick) ? 1048576 : 524288;
        }
        if ((i8 & 599187) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            j11 = j8;
            j12 = j9;
            composer2 = startRestartGroup;
            j10 = j5;
        } else {
            Modifier modifier3 = i9 != 0 ? Modifier.INSTANCE : modifier;
            long m3281getWhite0d7_KjU = i10 != 0 ? AppColor.INSTANCE.m3281getWhite0d7_KjU() : j5;
            long m3267getGrey40d7_KjU = i11 != 0 ? AppColor.INSTANCE.m3267getGrey40d7_KjU() : j8;
            long m3255getBrandBlue10d7_KjU = i12 != 0 ? AppColor.INSTANCE.m3255getBrandBlue10d7_KjU() : j9;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-235124252, i8, -1, "dk.molslinjen.ui.views.reusable.buttons.OutlineDashedButton (OutlineDashedButton.kt:49)");
            }
            float dpToPx = ComposeExtensionsKt.dpToPx(6, startRestartGroup, 6);
            composer2 = startRestartGroup;
            CompositionLocalKt.CompositionLocalProvider(RippleKt.getLocalRippleConfiguration().provides(ButtonStyle.Tertiary.INSTANCE.getRipple()), ComposableLambdaKt.rememberComposableLambda(-292004572, true, new OutlineDashedButtonKt$OutlineDashedButton$1(modifier3, ComposeExtensionsKt.dpToPx(4, startRestartGroup, 6), onClick, m3281getWhite0d7_KjU, m3267getGrey40d7_KjU, new Stroke(ComposeExtensionsKt.dpToPx(2, startRestartGroup, 6), 0.0f, StrokeCap.INSTANCE.m1608getRoundKaPHkGw(), 0, PathEffect.Companion.dashPathEffect$default(PathEffect.INSTANCE, new float[]{dpToPx, dpToPx}, 0.0f, 2, null), 10, null), i5, m3255getBrandBlue10d7_KjU, title), composer2, 54), composer2, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            j10 = m3281getWhite0d7_KjU;
            j11 = m3267getGrey40d7_KjU;
            j12 = m3255getBrandBlue10d7_KjU;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: Z1.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OutlineDashedButton_EMNEwkI$lambda$0;
                    OutlineDashedButton_EMNEwkI$lambda$0 = OutlineDashedButtonKt.OutlineDashedButton_EMNEwkI$lambda$0(Modifier.this, title, i5, j10, j11, j12, onClick, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                    return OutlineDashedButton_EMNEwkI$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OutlineDashedButton_EMNEwkI$lambda$0(Modifier modifier, String str, int i5, long j5, long j6, long j7, Function0 function0, int i6, int i7, Composer composer, int i8) {
        m3405OutlineDashedButtonEMNEwkI(modifier, str, i5, j5, j6, j7, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }
}
