package dk.molslinjen.extensions;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001f\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u0012\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0011\u0010\u0014\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001aM\u0010!\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u001a¢\u0006\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/compose/ui/Modifier;", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", "noRippleClickable", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/focus/FocusManager;", "focusManager", "closeKeyboardOnClickOutside", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/focus/FocusManager;)Landroidx/compose/ui/Modifier;", BuildConfig.FLAVOR, "shouldApply", "Lkotlin/Function1;", "block", "applyIf", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/graphics/Shape;", "shape", "defaultShadow", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "topShadow", "(Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/graphics/Color;", "color", BuildConfig.FLAVOR, "alpha", "Landroidx/compose/ui/unit/Dp;", "cornersRadius", "shadowBlurRadius", "offsetY", "offsetX", "advancedShadow-PRYyx80", "(Landroidx/compose/ui/Modifier;JFFFFF)Landroidx/compose/ui/Modifier;", "advancedShadow", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ModifierExtensionsKt {
    /* renamed from: advancedShadow-PRYyx80 */
    public static final Modifier m3251advancedShadowPRYyx80(Modifier advancedShadow, final long j5, final float f5, final float f6, final float f7, final float f8, final float f9) {
        Intrinsics.checkNotNullParameter(advancedShadow, "$this$advancedShadow");
        return DrawModifierKt.drawBehind(advancedShadow, new Function1() { // from class: O1.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit advancedShadow_PRYyx80$lambda$1;
                advancedShadow_PRYyx80$lambda$1 = ModifierExtensionsKt.advancedShadow_PRYyx80$lambda$1(j5, f5, f7, f9, f8, f6, (DrawScope) obj);
                return advancedShadow_PRYyx80$lambda$1;
            }
        });
    }

    /* renamed from: advancedShadow-PRYyx80$default */
    public static /* synthetic */ Modifier m3252advancedShadowPRYyx80$default(Modifier modifier, long j5, float f5, float f6, float f7, float f8, float f9, int i5, Object obj) {
        return m3251advancedShadowPRYyx80(modifier, (i5 & 1) != 0 ? Color.INSTANCE.m1496getBlack0d7_KjU() : j5, (i5 & 2) != 0 ? 1.0f : f5, (i5 & 4) != 0 ? Dp.m2599constructorimpl(0) : f6, (i5 & 8) != 0 ? Dp.m2599constructorimpl(0) : f7, (i5 & 16) != 0 ? Dp.m2599constructorimpl(0) : f8, (i5 & 32) != 0 ? Dp.m2599constructorimpl(0) : f9);
    }

    public static final Unit advancedShadow_PRYyx80$lambda$1(long j5, float f5, float f6, float f7, float f8, float f9, DrawScope drawBehind) {
        Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
        int m1508toArgb8_81llA = ColorKt.m1508toArgb8_81llA(Color.m1485copywmQWz5c$default(j5, f5, 0.0f, 0.0f, 0.0f, 14, null));
        int m1508toArgb8_81llA2 = ColorKt.m1508toArgb8_81llA(Color.m1485copywmQWz5c$default(j5, 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
        Canvas canvas = drawBehind.getDrawContext().getCanvas();
        Paint Paint = AndroidPaint_androidKt.Paint();
        android.graphics.Paint internalPaint = Paint.getInternalPaint();
        internalPaint.setColor(m1508toArgb8_81llA2);
        internalPaint.setShadowLayer(drawBehind.mo212toPx0680j_4(f6), drawBehind.mo212toPx0680j_4(f7), drawBehind.mo212toPx0680j_4(f8), m1508toArgb8_81llA);
        canvas.drawRoundRect(0.0f, 0.0f, Size.m1377getWidthimpl(drawBehind.mo1703getSizeNHjbRc()), Size.m1375getHeightimpl(drawBehind.mo1703getSizeNHjbRc()), drawBehind.mo212toPx0680j_4(f9), drawBehind.mo212toPx0680j_4(f9), Paint);
        return Unit.INSTANCE;
    }

    public static final Modifier applyIf(Modifier modifier, boolean z5, Function1<? super Modifier, ? extends Modifier> block) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return z5 ? block.invoke(modifier) : modifier;
    }

    public static final Modifier closeKeyboardOnClickOutside(Modifier modifier, FocusManager focusManager) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(focusManager, "focusManager");
        return SuspendingPointerInputFilterKt.pointerInput(modifier, Unit.INSTANCE, new ModifierExtensionsKt$closeKeyboardOnClickOutside$1(focusManager, null));
    }

    public static final Modifier defaultShadow(Modifier modifier, Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(shape, "shape");
        float m2599constructorimpl = Dp.m2599constructorimpl(6);
        AppColor appColor = AppColor.INSTANCE;
        return ShadowKt.m1270shadows4CzXII$default(modifier, m2599constructorimpl, shape, false, appColor.m3270getShadowColor0d7_KjU(), appColor.m3270getShadowColor0d7_KjU(), 4, null);
    }

    public static /* synthetic */ Modifier defaultShadow$default(Modifier modifier, Shape shape, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            shape = ThemeShapesKt.getThemeShapes().getMedium();
        }
        return defaultShadow(modifier, shape);
    }

    public static final Modifier noRippleClickable(Modifier modifier, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ComposedModifierKt.composed$default(modifier, null, new ModifierExtensionsKt$noRippleClickable$1(onClick), 1, null);
    }

    public static final Modifier topShadow(Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return m3252advancedShadowPRYyx80$default(modifier, ColorExtensionsKt.m3249withAlphaDxMtmZc(AppColor.INSTANCE.m3270getShadowColor0d7_KjU(), 0.1f), 0.0f, 0.0f, Dp.m2599constructorimpl(30), Dp.m2599constructorimpl(25), 0.0f, 38, null);
    }
}
