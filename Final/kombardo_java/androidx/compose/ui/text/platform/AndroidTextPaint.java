package androidx.compose.ui.text.platform;

import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextPaint;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J,\u0010\u001f\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010'R\u001c\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b)\u0010*R(\u0010\u0010\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b\u0010\u0010+\u0012\u0004\b/\u0010\n\u001a\u0004\b,\u0010-\"\u0004\b.\u0010\u0012R*\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b\u0019\u00100\u0012\u0004\b5\u0010\n\u001a\u0004\b1\u00102\"\u0004\b3\u00104R2\u00109\u001a\u0012\u0012\f\u0012\n\u0018\u000107j\u0004\u0018\u0001`8\u0018\u0001068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R0\u0010?\u001a\u0004\u0018\u00010\u001a8\u0000@\u0000X\u0081\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0018\n\u0004\b?\u0010@\u0012\u0004\bE\u0010\n\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010FR\u0014\u0010I\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR*\u0010O\u001a\u00020(2\u0006\u0010J\u001a\u00020(8F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006P"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidTextPaint;", "Landroid/text/TextPaint;", BuildConfig.FLAVOR, "flags", BuildConfig.FLAVOR, "density", "<init>", "(IF)V", BuildConfig.FLAVOR, "clearShader", "()V", "Landroidx/compose/ui/text/style/TextDecoration;", "textDecoration", "setTextDecoration", "(Landroidx/compose/ui/text/style/TextDecoration;)V", "Landroidx/compose/ui/graphics/Shadow;", "shadow", "setShadow", "(Landroidx/compose/ui/graphics/Shadow;)V", "Landroidx/compose/ui/graphics/Color;", "color", "setColor-8_81llA", "(J)V", "setColor", "Landroidx/compose/ui/graphics/Brush;", "brush", "Landroidx/compose/ui/geometry/Size;", "size", "alpha", "setBrush-12SF9DM", "(Landroidx/compose/ui/graphics/Brush;JF)V", "setBrush", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "drawStyle", "setDrawStyle", "(Landroidx/compose/ui/graphics/drawscope/DrawStyle;)V", "Landroidx/compose/ui/graphics/Paint;", "backingComposePaint", "Landroidx/compose/ui/graphics/Paint;", "Landroidx/compose/ui/text/style/TextDecoration;", "Landroidx/compose/ui/graphics/BlendMode;", "backingBlendMode", "I", "Landroidx/compose/ui/graphics/Shadow;", "getShadow$ui_text_release", "()Landroidx/compose/ui/graphics/Shadow;", "setShadow$ui_text_release", "getShadow$ui_text_release$annotations", "Landroidx/compose/ui/graphics/Brush;", "getBrush$ui_text_release", "()Landroidx/compose/ui/graphics/Brush;", "setBrush$ui_text_release", "(Landroidx/compose/ui/graphics/Brush;)V", "getBrush$ui_text_release$annotations", "Landroidx/compose/runtime/State;", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "shaderState", "Landroidx/compose/runtime/State;", "getShaderState$ui_text_release", "()Landroidx/compose/runtime/State;", "setShaderState$ui_text_release", "(Landroidx/compose/runtime/State;)V", "brushSize", "Landroidx/compose/ui/geometry/Size;", "getBrushSize-VsRJwc0$ui_text_release", "()Landroidx/compose/ui/geometry/Size;", "setBrushSize-iaC8Vc4$ui_text_release", "(Landroidx/compose/ui/geometry/Size;)V", "getBrushSize-VsRJwc0$ui_text_release$annotations", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "getComposePaint", "()Landroidx/compose/ui/graphics/Paint;", "composePaint", "value", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "blendMode", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidTextPaint extends TextPaint {
    private int backingBlendMode;
    private Paint backingComposePaint;
    private Brush brush;
    private Size brushSize;
    private DrawStyle drawStyle;
    private State<? extends Shader> shaderState;
    private Shadow shadow;
    private TextDecoration textDecoration;

    public AndroidTextPaint(int i5, float f5) {
        super(i5);
        ((TextPaint) this).density = f5;
        this.textDecoration = TextDecoration.INSTANCE.getNone();
        this.backingBlendMode = DrawScope.INSTANCE.m1704getDefaultBlendMode0nO6VwU();
        this.shadow = Shadow.INSTANCE.getNone();
    }

    private final void clearShader() {
        this.shaderState = null;
        this.brush = null;
        this.brushSize = null;
        setShader(null);
    }

    private final Paint getComposePaint() {
        Paint paint = this.backingComposePaint;
        if (paint != null) {
            return paint;
        }
        Paint asComposePaint = AndroidPaint_androidKt.asComposePaint(this);
        this.backingComposePaint = asComposePaint;
        return asComposePaint;
    }

    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name and from getter */
    public final int getBackingBlendMode() {
        return this.backingBlendMode;
    }

    /* renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public final void m2439setBlendModes9anfk8(int i5) {
        if (BlendMode.m1429equalsimpl0(i5, this.backingBlendMode)) {
            return;
        }
        getComposePaint().mo1408setBlendModes9anfk8(i5);
        this.backingBlendMode = i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        if ((r0 == null ? false : androidx.compose.ui.geometry.Size.m1374equalsimpl0(r0.getPackedValue(), r6)) == false) goto L16;
     */
    /* renamed from: setBrush-12SF9DM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2440setBrush12SF9DM(final Brush brush, final long size, float alpha) {
        if (brush == null) {
            clearShader();
            return;
        }
        if (brush instanceof SolidColor) {
            m2441setColor8_81llA(TextDrawStyleKt.m2548modulateDxMtmZc(((SolidColor) brush).getValue(), alpha));
            return;
        }
        if (brush instanceof ShaderBrush) {
            if (Intrinsics.areEqual(this.brush, brush)) {
                Size size2 = this.brushSize;
            }
            if (size != 9205357640488583168L) {
                this.brush = brush;
                this.brushSize = Size.m1370boximpl(size);
                this.shaderState = SnapshotStateKt.derivedStateOf(new Function0<Shader>() { // from class: androidx.compose.ui.text.platform.AndroidTextPaint$setBrush$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Shader invoke() {
                        return ((ShaderBrush) Brush.this).mo1472createShaderuvyYCjk(size);
                    }
                });
            }
            Paint composePaint = getComposePaint();
            State<? extends Shader> state = this.shaderState;
            composePaint.setShader(state != null ? state.getValue() : null);
            AndroidTextPaint_androidKt.setAlpha(this, alpha);
        }
    }

    /* renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m2441setColor8_81llA(long color) {
        if (color != 16) {
            setColor(ColorKt.m1508toArgb8_81llA(color));
            clearShader();
        }
    }

    public final void setDrawStyle(DrawStyle drawStyle) {
        if (drawStyle == null || Intrinsics.areEqual(this.drawStyle, drawStyle)) {
            return;
        }
        this.drawStyle = drawStyle;
        if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
            setStyle(Paint.Style.FILL);
            return;
        }
        if (drawStyle instanceof Stroke) {
            getComposePaint().mo1413setStylek9PVt8s(PaintingStyle.INSTANCE.m1573getStrokeTiuSbCo());
            Stroke stroke = (Stroke) drawStyle;
            getComposePaint().setStrokeWidth(stroke.getWidth());
            getComposePaint().setStrokeMiterLimit(stroke.getMiter());
            getComposePaint().mo1412setStrokeJoinWw9F2mQ(stroke.getJoin());
            getComposePaint().mo1411setStrokeCapBeK7IIE(stroke.getCap());
            getComposePaint().setPathEffect(stroke.getPathEffect());
        }
    }

    public final void setShadow(Shadow shadow) {
        if (shadow == null || Intrinsics.areEqual(this.shadow, shadow)) {
            return;
        }
        this.shadow = shadow;
        if (Intrinsics.areEqual(shadow, Shadow.INSTANCE.getNone())) {
            clearShadowLayer();
        } else {
            setShadowLayer(TextPaintExtensions_androidKt.correctBlurRadius(this.shadow.getBlurRadius()), Offset.m1337getXimpl(this.shadow.getOffset()), Offset.m1338getYimpl(this.shadow.getOffset()), ColorKt.m1508toArgb8_81llA(this.shadow.getColor()));
        }
    }

    public final void setTextDecoration(TextDecoration textDecoration) {
        if (textDecoration == null || Intrinsics.areEqual(this.textDecoration, textDecoration)) {
            return;
        }
        this.textDecoration = textDecoration;
        TextDecoration.Companion companion = TextDecoration.INSTANCE;
        setUnderlineText(textDecoration.contains(companion.getUnderline()));
        setStrikeThruText(this.textDecoration.contains(companion.getLineThrough()));
    }
}
