package dk.molslinjen.ui.views.reusable.ticket;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.extensions.ColorExtensionsKt;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aI\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "disabled", "asDisabledOverlay", "topRightCornerRounded", "selected", "showLeftCutout", BuildConfig.FLAVOR, "TicketBackgroundView", "(Landroidx/compose/ui/Modifier;ZZZZZLandroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TicketBackgroundViewKt {
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r5v22 ??, still in use, count: 1, list:
          (r5v22 ?? I:java.lang.Object) from 0x01bb: INVOKE (r1v1 ?? I:androidx.compose.runtime.Composer), (r5v22 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:34)
        */
    public static final void TicketBackgroundView(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r5v22 ??, still in use, count: 1, list:
          (r5v22 ?? I:java.lang.Object) from 0x01bb: INVOKE (r1v1 ?? I:androidx.compose.runtime.Composer), (r5v22 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r23v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:237)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier TicketBackgroundView$lambda$1$lambda$0(long j5, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return ModifierExtensionsKt.defaultShadow(applyIf, CornerBasedShape.copy$default(ThemeShapesKt.getThemeShapes().getMedium(), null, CornerSizeKt.CornerSize(CornerRadius.m1323getXimpl(j5)), null, null, 13, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketBackgroundView$lambda$10(Modifier modifier, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, int i5, int i6, Composer composer, int i7) {
        TicketBackgroundView(modifier, z5, z6, z7, z8, z9, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketBackgroundView$lambda$9$lambda$8(boolean z5, boolean z6, float f5, boolean z7, boolean z8, long j5, long j6, DrawScope Canvas) {
        long j7;
        DrawContext drawContext;
        DrawScope drawScope;
        int i5;
        float f6;
        Path.Direction direction;
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        long mo1703getSizeNHjbRc = Canvas.mo1703getSizeNHjbRc();
        Path Path = AndroidPath_androidKt.Path();
        if (z7) {
            Path.addOval$default(Path, RectKt.m1361Rect3MmeM6k(OffsetKt.Offset(0.0f, Size.m1375getHeightimpl(mo1703getSizeNHjbRc) / 2.0f), Canvas.mo212toPx0680j_4(Dp.m2599constructorimpl(6))), null, 2, null);
        }
        float f7 = 6;
        Path.addOval$default(Path, RectKt.m1361Rect3MmeM6k(OffsetKt.Offset(Size.m1377getWidthimpl(mo1703getSizeNHjbRc), Size.m1375getHeightimpl(mo1703getSizeNHjbRc) / 2.0f), Canvas.mo212toPx0680j_4(Dp.m2599constructorimpl(f7))), null, 2, null);
        ClipOp.Companion companion = ClipOp.INSTANCE;
        int m1479getDifferencertfAjoo = companion.m1479getDifferencertfAjoo();
        DrawContext drawContext2 = Canvas.getDrawContext();
        long mo1682getSizeNHjbRc = drawContext2.mo1682getSizeNHjbRc();
        drawContext2.getCanvas().save();
        try {
            drawContext2.getTransform().mo1684clipPathmtrdDE(Path, m1479getDifferencertfAjoo);
            Path Path2 = AndroidPath_androidKt.Path();
            Path.addRoundRect$default(Path2, RoundRectKt.m1367RoundRectZAM2FJo(RectKt.m1362Recttz77jQw(OffsetKt.Offset(0.0f, 0.0f), mo1703getSizeNHjbRc), j5, j6, j5, j5), null, 2, null);
            j7 = mo1682getSizeNHjbRc;
            try {
                DrawScope.m1696drawPathLG529CI$default(Canvas, Path2, z8 ? ColorExtensionsKt.m3249withAlphaDxMtmZc(AppColor.INSTANCE.m3268getGrey50d7_KjU(), 0.5f) : z6 ? AppColor.INSTANCE.m3269getGrey60d7_KjU() : z5 ? AppColor.INSTANCE.m3255getBrandBlue10d7_KjU() : AppColor.INSTANCE.m3281getWhite0d7_KjU(), 0.0f, null, null, 0, 60, null);
                drawContext2.getCanvas().restore();
                drawContext2.mo1683setSizeuvyYCjk(j7);
                if (z5 && !z6) {
                    float f8 = 2 * f5;
                    long m1372copyxjbvk4A = Size.m1372copyxjbvk4A(mo1703getSizeNHjbRc, Size.m1377getWidthimpl(mo1703getSizeNHjbRc) - f8, Size.m1375getHeightimpl(mo1703getSizeNHjbRc) - f8);
                    Path Path3 = AndroidPath_androidKt.Path();
                    if (z7) {
                        f6 = 2.0f;
                        long Offset = OffsetKt.Offset(0.0f, Size.m1375getHeightimpl(mo1703getSizeNHjbRc) / 2.0f);
                        float m2599constructorimpl = Dp.m2599constructorimpl(f7);
                        drawScope = Canvas;
                        i5 = 2;
                        Rect m1361Rect3MmeM6k = RectKt.m1361Rect3MmeM6k(Offset, drawScope.mo212toPx0680j_4(m2599constructorimpl) + f5);
                        direction = null;
                        Path.addOval$default(Path3, m1361Rect3MmeM6k, null, 2, null);
                    } else {
                        drawScope = Canvas;
                        i5 = 2;
                        f6 = 2.0f;
                        direction = null;
                    }
                    Path.addOval$default(Path3, RectKt.m1361Rect3MmeM6k(OffsetKt.Offset(Size.m1377getWidthimpl(mo1703getSizeNHjbRc), Size.m1375getHeightimpl(mo1703getSizeNHjbRc) / f6), drawScope.mo212toPx0680j_4(Dp.m2599constructorimpl(f7)) + f5), direction, i5, direction);
                    int m1479getDifferencertfAjoo2 = companion.m1479getDifferencertfAjoo();
                    DrawContext drawContext3 = Canvas.getDrawContext();
                    long mo1682getSizeNHjbRc2 = drawContext3.mo1682getSizeNHjbRc();
                    drawContext3.getCanvas().save();
                    try {
                        drawContext3.getTransform().mo1684clipPathmtrdDE(Path3, m1479getDifferencertfAjoo2);
                        Path Path4 = AndroidPath_androidKt.Path();
                        Path.addRoundRect$default(Path4, RoundRectKt.m1367RoundRectZAM2FJo(RectKt.m1362Recttz77jQw(OffsetKt.Offset(f5, f5), m1372copyxjbvk4A), j5, j6, j5, j5), direction, i5, direction);
                        DrawScope.m1696drawPathLG529CI$default(Canvas, Path4, AppColor.INSTANCE.m3281getWhite0d7_KjU(), 0.0f, null, null, 0, 60, null);
                    } finally {
                        drawContext3.getCanvas().restore();
                        drawContext3.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc2);
                    }
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                th = th;
                drawContext = drawContext2;
                drawContext.getCanvas().restore();
                drawContext.mo1683setSizeuvyYCjk(j7);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            j7 = mo1682getSizeNHjbRc;
            drawContext = drawContext2;
        }
    }
}
