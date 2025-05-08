package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0015\u001a\u00020\t*\u00020\u0014H$¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00172\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ2\u0010#\u001a\u00020\t*\u00020\u00142\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010(R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010)R\u0016\u0010\u001c\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010*R \u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u00100\u001a\u00020\u001f8&X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b.\u0010/\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00061"}, d2 = {"Landroidx/compose/ui/graphics/painter/Painter;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/graphics/Paint;", "obtainPaint", "()Landroidx/compose/ui/graphics/Paint;", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", BuildConfig.FLAVOR, "configureColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", BuildConfig.FLAVOR, "alpha", "configureAlpha", "(F)V", "Landroidx/compose/ui/unit/LayoutDirection;", "rtl", "configureLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "onDraw", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;)V", BuildConfig.FLAVOR, "applyAlpha", "(F)Z", "applyColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)Z", "layoutDirection", "applyLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)Z", "Landroidx/compose/ui/geometry/Size;", "size", "draw-x_KDEd0", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/ui/graphics/ColorFilter;)V", "draw", "layerPaint", "Landroidx/compose/ui/graphics/Paint;", "useLayer", "Z", "Landroidx/compose/ui/graphics/ColorFilter;", "F", "Landroidx/compose/ui/unit/LayoutDirection;", "Lkotlin/Function1;", "drawLambda", "Lkotlin/jvm/functions/Function1;", "getIntrinsicSize-NH-jbRc", "()J", "intrinsicSize", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Painter {
    private ColorFilter colorFilter;
    private Paint layerPaint;
    private boolean useLayer;
    private float alpha = 1.0f;
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private final Function1<DrawScope, Unit> drawLambda = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.painter.Painter$drawLambda$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
            invoke2(drawScope);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DrawScope drawScope) {
            Painter.this.onDraw(drawScope);
        }
    };

    private final void configureAlpha(float alpha) {
        if (this.alpha == alpha) {
            return;
        }
        if (!applyAlpha(alpha)) {
            if (alpha == 1.0f) {
                Paint paint = this.layerPaint;
                if (paint != null) {
                    paint.setAlpha(alpha);
                }
                this.useLayer = false;
            } else {
                obtainPaint().setAlpha(alpha);
                this.useLayer = true;
            }
        }
        this.alpha = alpha;
    }

    private final void configureColorFilter(ColorFilter colorFilter) {
        if (Intrinsics.areEqual(this.colorFilter, colorFilter)) {
            return;
        }
        if (!applyColorFilter(colorFilter)) {
            if (colorFilter == null) {
                Paint paint = this.layerPaint;
                if (paint != null) {
                    paint.setColorFilter(null);
                }
                this.useLayer = false;
            } else {
                obtainPaint().setColorFilter(colorFilter);
                this.useLayer = true;
            }
        }
        this.colorFilter = colorFilter;
    }

    private final void configureLayoutDirection(LayoutDirection rtl) {
        if (this.layoutDirection != rtl) {
            applyLayoutDirection(rtl);
            this.layoutDirection = rtl;
        }
    }

    /* renamed from: draw-x_KDEd0$default, reason: not valid java name */
    public static /* synthetic */ void m1748drawx_KDEd0$default(Painter painter, DrawScope drawScope, long j5, float f5, ColorFilter colorFilter, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: draw-x_KDEd0");
        }
        if ((i5 & 2) != 0) {
            f5 = 1.0f;
        }
        float f6 = f5;
        if ((i5 & 4) != 0) {
            colorFilter = null;
        }
        painter.m1749drawx_KDEd0(drawScope, j5, f6, colorFilter);
    }

    private final Paint obtainPaint() {
        Paint paint = this.layerPaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        this.layerPaint = Paint;
        return Paint;
    }

    protected abstract boolean applyAlpha(float alpha);

    protected abstract boolean applyColorFilter(ColorFilter colorFilter);

    protected boolean applyLayoutDirection(LayoutDirection layoutDirection) {
        return false;
    }

    /* renamed from: draw-x_KDEd0, reason: not valid java name */
    public final void m1749drawx_KDEd0(DrawScope drawScope, long j5, float f5, ColorFilter colorFilter) {
        configureAlpha(f5);
        configureColorFilter(colorFilter);
        configureLayoutDirection(drawScope.getLayoutDirection());
        float m1377getWidthimpl = Size.m1377getWidthimpl(drawScope.mo1703getSizeNHjbRc()) - Size.m1377getWidthimpl(j5);
        float m1375getHeightimpl = Size.m1375getHeightimpl(drawScope.mo1703getSizeNHjbRc()) - Size.m1375getHeightimpl(j5);
        drawScope.getDrawContext().getTransform().inset(0.0f, 0.0f, m1377getWidthimpl, m1375getHeightimpl);
        if (f5 > 0.0f) {
            try {
                if (Size.m1377getWidthimpl(j5) > 0.0f && Size.m1375getHeightimpl(j5) > 0.0f) {
                    if (this.useLayer) {
                        Rect m1362Recttz77jQw = RectKt.m1362Recttz77jQw(Offset.INSTANCE.m1349getZeroF1C5BW0(), SizeKt.Size(Size.m1377getWidthimpl(j5), Size.m1375getHeightimpl(j5)));
                        Canvas canvas = drawScope.getDrawContext().getCanvas();
                        try {
                            canvas.saveLayer(m1362Recttz77jQw, obtainPaint());
                            onDraw(drawScope);
                            canvas.restore();
                        } catch (Throwable th) {
                            canvas.restore();
                            throw th;
                        }
                    } else {
                        onDraw(drawScope);
                    }
                }
            } catch (Throwable th2) {
                drawScope.getDrawContext().getTransform().inset(-0.0f, -0.0f, -m1377getWidthimpl, -m1375getHeightimpl);
                throw th2;
            }
        }
        drawScope.getDrawContext().getTransform().inset(-0.0f, -0.0f, -m1377getWidthimpl, -m1375getHeightimpl);
    }

    /* renamed from: getIntrinsicSize-NH-jbRc */
    public abstract long mo1744getIntrinsicSizeNHjbRc();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onDraw(DrawScope drawScope);
}
