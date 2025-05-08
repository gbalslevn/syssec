package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001vB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJJ\u0010\u0019\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018JH\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJj\u0010(\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\b&\u0010'Jl\u0010(\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u001e\u0010-\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,J`\u00104\u001a\u0002012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010$2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\b2\u00103J`\u00104\u001a\u0002012\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010$2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\b5\u00106JN\u0010<\u001a\u0002012\u0006\u0010\r\u001a\u00020\f2\u0006\u00107\u001a\u00020.2\u0006\u00109\u001a\u0002082\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\b:\u0010;JN\u0010<\u001a\u0002012\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u00107\u001a\u00020.2\u0006\u00109\u001a\u0002082\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\b=\u0010>JF\u0010C\u001a\u0002012\u0006\u0010@\u001a\u00020?2\u0006\u00107\u001a\u00020.2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\bA\u0010BJf\u0010C\u001a\u0002012\u0006\u0010@\u001a\u00020?2\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020D2\u0006\u0010I\u001a\u00020F2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJV\u0010P\u001a\u0002012\u0006\u0010\r\u001a\u00020\f2\u0006\u00107\u001a\u00020.2\u0006\u00109\u001a\u0002082\u0006\u0010M\u001a\u00020L2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\bN\u0010OJV\u0010P\u001a\u0002012\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u00107\u001a\u00020.2\u0006\u00109\u001a\u0002082\u0006\u0010M\u001a\u00020L2\u0006\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\bQ\u0010RJN\u0010W\u001a\u0002012\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010S\u001a\u00020\u000f2\u0006\u0010T\u001a\u00020.2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\bU\u0010VJF\u0010\\\u001a\u0002012\u0006\u0010Y\u001a\u00020X2\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\bZ\u0010[JF\u0010\\\u001a\u0002012\u0006\u0010Y\u001a\u00020X2\u0006\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\b]\u0010^R \u0010`\u001a\u00020_8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b`\u0010a\u0012\u0004\bd\u0010\u0003\u001a\u0004\bb\u0010cR\u001a\u0010f\u001a\u00020e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR\u0018\u0010j\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010l\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010kR\u0014\u0010p\u001a\u00020m8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bn\u0010oR\u0014\u0010s\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bq\u0010rR\u0014\u0010u\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bt\u0010r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006w"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "<init>", "()V", "Landroidx/compose/ui/graphics/Paint;", "obtainFillPaint", "()Landroidx/compose/ui/graphics/Paint;", "obtainStrokePaint", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "drawStyle", "selectPaint", "(Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/graphics/Paint;", "Landroidx/compose/ui/graphics/Brush;", "brush", "style", BuildConfig.FLAVOR, "alpha", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "configurePaint-swdJneE", "(Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "configurePaint", "Landroidx/compose/ui/graphics/Color;", "color", "configurePaint-2qPWKa0", "(JLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "strokeWidth", "miter", "Landroidx/compose/ui/graphics/StrokeCap;", "cap", "Landroidx/compose/ui/graphics/StrokeJoin;", "join", "Landroidx/compose/ui/graphics/PathEffect;", "pathEffect", "configureStrokePaint-Q_0CZUI", "(JFFIILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "configureStrokePaint", "configureStrokePaint-ho4zsrM", "(Landroidx/compose/ui/graphics/Brush;FFIILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "modulate-5vOe2sY", "(JF)J", "modulate", "Landroidx/compose/ui/geometry/Offset;", "start", "end", BuildConfig.FLAVOR, "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "topLeft", "Landroidx/compose/ui/geometry/Size;", "size", "drawRect-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "Landroidx/compose/ui/graphics/ImageBitmap;", "image", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "Landroidx/compose/ui/unit/IntOffset;", "srcOffset", "Landroidx/compose/ui/unit/IntSize;", "srcSize", "dstOffset", "dstSize", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "Landroidx/compose/ui/geometry/CornerRadius;", "cornerRadius", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "radius", "center", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "Landroidx/compose/ui/graphics/Path;", "path", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "drawParams", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "getDrawParams", "()Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "getDrawParams$annotations", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "fillPaint", "Landroidx/compose/ui/graphics/Paint;", "strokePaint", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getDensity", "()F", "density", "getFontScale", "fontScale", "DrawParams", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CanvasDrawScope implements DrawScope {
    private Paint fillPaint;
    private Paint strokePaint;
    private final DrawParams drawParams = new DrawParams(null, null, null, 0, 15, null);
    private final DrawContext drawContext = new DrawContext() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScope$drawContext$1
        private GraphicsLayer graphicsLayer;
        private final DrawTransform transform;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            DrawTransform asDrawTransform;
            asDrawTransform = CanvasDrawScopeKt.asDrawTransform(this);
            this.transform = asDrawTransform;
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public Canvas getCanvas() {
            return CanvasDrawScope.this.getDrawParams().getCanvas();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public Density getDensity() {
            return CanvasDrawScope.this.getDrawParams().getDensity();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public GraphicsLayer getGraphicsLayer() {
            return this.graphicsLayer;
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public LayoutDirection getLayoutDirection() {
            return CanvasDrawScope.this.getDrawParams().getLayoutDirection();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        /* renamed from: getSize-NH-jbRc, reason: not valid java name */
        public long mo1682getSizeNHjbRc() {
            return CanvasDrawScope.this.getDrawParams().m1680getSizeNHjbRc();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public DrawTransform getTransform() {
            return this.transform;
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public void setCanvas(Canvas canvas) {
            CanvasDrawScope.this.getDrawParams().setCanvas(canvas);
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public void setDensity(Density density) {
            CanvasDrawScope.this.getDrawParams().setDensity(density);
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public void setGraphicsLayer(GraphicsLayer graphicsLayer) {
            this.graphicsLayer = graphicsLayer;
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        public void setLayoutDirection(LayoutDirection layoutDirection) {
            CanvasDrawScope.this.getDrawParams().setLayoutDirection(layoutDirection);
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        /* renamed from: setSize-uvyYCjk, reason: not valid java name */
        public void mo1683setSizeuvyYCjk(long j5) {
            CanvasDrawScope.this.getDrawParams().m1681setSizeuvyYCjk(j5);
        }
    };

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0014\u001a\u00020\bHÆ\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\"R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010\u000f\"\u0004\b%\u0010&R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010'\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010*R(\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0012\n\u0004\b\t\u0010+\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010.\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006/"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", BuildConfig.FLAVOR, "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "Landroidx/compose/ui/geometry/Size;", "size", "<init>", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "component1", "()Landroidx/compose/ui/unit/Density;", "component2", "()Landroidx/compose/ui/unit/LayoutDirection;", "component3", "()Landroidx/compose/ui/graphics/Canvas;", "component4-NH-jbRc", "()J", "component4", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/unit/Density;", "getDensity", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "Landroidx/compose/ui/graphics/Canvas;", "getCanvas", "setCanvas", "(Landroidx/compose/ui/graphics/Canvas;)V", "J", "getSize-NH-jbRc", "setSize-uvyYCjk", "(J)V", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* data */ class DrawParams {
        private Canvas canvas;
        private Density density;
        private LayoutDirection layoutDirection;
        private long size;

        public /* synthetic */ DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j5, DefaultConstructorMarker defaultConstructorMarker) {
            this(density, layoutDirection, canvas, j5);
        }

        /* renamed from: component1, reason: from getter */
        public final Density getDensity() {
            return this.density;
        }

        /* renamed from: component2, reason: from getter */
        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        /* renamed from: component3, reason: from getter */
        public final Canvas getCanvas() {
            return this.canvas;
        }

        /* renamed from: component4-NH-jbRc, reason: not valid java name and from getter */
        public final long getSize() {
            return this.size;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DrawParams)) {
                return false;
            }
            DrawParams drawParams = (DrawParams) other;
            return Intrinsics.areEqual(this.density, drawParams.density) && this.layoutDirection == drawParams.layoutDirection && Intrinsics.areEqual(this.canvas, drawParams.canvas) && Size.m1374equalsimpl0(this.size, drawParams.size);
        }

        public final Canvas getCanvas() {
            return this.canvas;
        }

        public final Density getDensity() {
            return this.density;
        }

        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        /* renamed from: getSize-NH-jbRc, reason: not valid java name */
        public final long m1680getSizeNHjbRc() {
            return this.size;
        }

        public int hashCode() {
            return (((((this.density.hashCode() * 31) + this.layoutDirection.hashCode()) * 31) + this.canvas.hashCode()) * 31) + Size.m1378hashCodeimpl(this.size);
        }

        public final void setCanvas(Canvas canvas) {
            this.canvas = canvas;
        }

        public final void setDensity(Density density) {
            this.density = density;
        }

        public final void setLayoutDirection(LayoutDirection layoutDirection) {
            this.layoutDirection = layoutDirection;
        }

        /* renamed from: setSize-uvyYCjk, reason: not valid java name */
        public final void m1681setSizeuvyYCjk(long j5) {
            this.size = j5;
        }

        public String toString() {
            return "DrawParams(density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", canvas=" + this.canvas + ", size=" + ((Object) Size.m1381toStringimpl(this.size)) + ')';
        }

        private DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j5) {
            this.density = density;
            this.layoutDirection = layoutDirection;
            this.canvas = canvas;
            this.size = j5;
        }

        public /* synthetic */ DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? DrawContextKt.getDefaultDensity() : density, (i5 & 2) != 0 ? LayoutDirection.Ltr : layoutDirection, (i5 & 4) != 0 ? new EmptyCanvas() : canvas, (i5 & 8) != 0 ? Size.INSTANCE.m1384getZeroNHjbRc() : j5, null);
        }
    }

    /* renamed from: configurePaint-2qPWKa0, reason: not valid java name */
    private final Paint m1659configurePaint2qPWKa0(long color, DrawStyle style, float alpha, ColorFilter colorFilter, int blendMode, int filterQuality) {
        Paint selectPaint = selectPaint(style);
        long m1667modulate5vOe2sY = m1667modulate5vOe2sY(color, alpha);
        if (!Color.m1487equalsimpl0(selectPaint.mo1404getColor0d7_KjU(), m1667modulate5vOe2sY)) {
            selectPaint.mo1409setColor8_81llA(m1667modulate5vOe2sY);
        }
        if (selectPaint.getInternalShader() != null) {
            selectPaint.setShader(null);
        }
        if (!Intrinsics.areEqual(selectPaint.getInternalColorFilter(), colorFilter)) {
            selectPaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m1429equalsimpl0(selectPaint.get_blendMode(), blendMode)) {
            selectPaint.mo1408setBlendModes9anfk8(blendMode);
        }
        if (!FilterQuality.m1517equalsimpl0(selectPaint.mo1405getFilterQualityfv9h1I(), filterQuality)) {
            selectPaint.mo1410setFilterQualityvDHp3xo(filterQuality);
        }
        return selectPaint;
    }

    /* renamed from: configurePaint-2qPWKa0$default, reason: not valid java name */
    static /* synthetic */ Paint m1660configurePaint2qPWKa0$default(CanvasDrawScope canvasDrawScope, long j5, DrawStyle drawStyle, float f5, ColorFilter colorFilter, int i5, int i6, int i7, Object obj) {
        return canvasDrawScope.m1659configurePaint2qPWKa0(j5, drawStyle, f5, colorFilter, i5, (i7 & 32) != 0 ? DrawScope.INSTANCE.m1705getDefaultFilterQualityfv9h1I() : i6);
    }

    /* renamed from: configurePaint-swdJneE, reason: not valid java name */
    private final Paint m1661configurePaintswdJneE(Brush brush, DrawStyle style, float alpha, ColorFilter colorFilter, int blendMode, int filterQuality) {
        Paint selectPaint = selectPaint(style);
        if (brush != null) {
            brush.mo1463applyToPq9zytI(mo1703getSizeNHjbRc(), selectPaint, alpha);
        } else {
            if (selectPaint.getInternalShader() != null) {
                selectPaint.setShader(null);
            }
            long mo1404getColor0d7_KjU = selectPaint.mo1404getColor0d7_KjU();
            Color.Companion companion = Color.INSTANCE;
            if (!Color.m1487equalsimpl0(mo1404getColor0d7_KjU, companion.m1496getBlack0d7_KjU())) {
                selectPaint.mo1409setColor8_81llA(companion.m1496getBlack0d7_KjU());
            }
            if (selectPaint.getAlpha() != alpha) {
                selectPaint.setAlpha(alpha);
            }
        }
        if (!Intrinsics.areEqual(selectPaint.getInternalColorFilter(), colorFilter)) {
            selectPaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m1429equalsimpl0(selectPaint.get_blendMode(), blendMode)) {
            selectPaint.mo1408setBlendModes9anfk8(blendMode);
        }
        if (!FilterQuality.m1517equalsimpl0(selectPaint.mo1405getFilterQualityfv9h1I(), filterQuality)) {
            selectPaint.mo1410setFilterQualityvDHp3xo(filterQuality);
        }
        return selectPaint;
    }

    /* renamed from: configurePaint-swdJneE$default, reason: not valid java name */
    static /* synthetic */ Paint m1662configurePaintswdJneE$default(CanvasDrawScope canvasDrawScope, Brush brush, DrawStyle drawStyle, float f5, ColorFilter colorFilter, int i5, int i6, int i7, Object obj) {
        if ((i7 & 32) != 0) {
            i6 = DrawScope.INSTANCE.m1705getDefaultFilterQualityfv9h1I();
        }
        return canvasDrawScope.m1661configurePaintswdJneE(brush, drawStyle, f5, colorFilter, i5, i6);
    }

    /* renamed from: configureStrokePaint-Q_0CZUI, reason: not valid java name */
    private final Paint m1663configureStrokePaintQ_0CZUI(long color, float strokeWidth, float miter, int cap, int join, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode, int filterQuality) {
        Paint obtainStrokePaint = obtainStrokePaint();
        long m1667modulate5vOe2sY = m1667modulate5vOe2sY(color, alpha);
        if (!Color.m1487equalsimpl0(obtainStrokePaint.mo1404getColor0d7_KjU(), m1667modulate5vOe2sY)) {
            obtainStrokePaint.mo1409setColor8_81llA(m1667modulate5vOe2sY);
        }
        if (obtainStrokePaint.getInternalShader() != null) {
            obtainStrokePaint.setShader(null);
        }
        if (!Intrinsics.areEqual(obtainStrokePaint.getInternalColorFilter(), colorFilter)) {
            obtainStrokePaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m1429equalsimpl0(obtainStrokePaint.get_blendMode(), blendMode)) {
            obtainStrokePaint.mo1408setBlendModes9anfk8(blendMode);
        }
        if (obtainStrokePaint.getStrokeWidth() != strokeWidth) {
            obtainStrokePaint.setStrokeWidth(strokeWidth);
        }
        if (obtainStrokePaint.getStrokeMiterLimit() != miter) {
            obtainStrokePaint.setStrokeMiterLimit(miter);
        }
        if (!StrokeCap.m1604equalsimpl0(obtainStrokePaint.mo1406getStrokeCapKaPHkGw(), cap)) {
            obtainStrokePaint.mo1411setStrokeCapBeK7IIE(cap);
        }
        if (!StrokeJoin.m1611equalsimpl0(obtainStrokePaint.mo1407getStrokeJoinLxFBmk8(), join)) {
            obtainStrokePaint.mo1412setStrokeJoinWw9F2mQ(join);
        }
        if (!Intrinsics.areEqual(obtainStrokePaint.getPathEffect(), pathEffect)) {
            obtainStrokePaint.setPathEffect(pathEffect);
        }
        if (!FilterQuality.m1517equalsimpl0(obtainStrokePaint.mo1405getFilterQualityfv9h1I(), filterQuality)) {
            obtainStrokePaint.mo1410setFilterQualityvDHp3xo(filterQuality);
        }
        return obtainStrokePaint;
    }

    /* renamed from: configureStrokePaint-Q_0CZUI$default, reason: not valid java name */
    static /* synthetic */ Paint m1664configureStrokePaintQ_0CZUI$default(CanvasDrawScope canvasDrawScope, long j5, float f5, float f6, int i5, int i6, PathEffect pathEffect, float f7, ColorFilter colorFilter, int i7, int i8, int i9, Object obj) {
        return canvasDrawScope.m1663configureStrokePaintQ_0CZUI(j5, f5, f6, i5, i6, pathEffect, f7, colorFilter, i7, (i9 & 512) != 0 ? DrawScope.INSTANCE.m1705getDefaultFilterQualityfv9h1I() : i8);
    }

    /* renamed from: configureStrokePaint-ho4zsrM, reason: not valid java name */
    private final Paint m1665configureStrokePaintho4zsrM(Brush brush, float strokeWidth, float miter, int cap, int join, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode, int filterQuality) {
        Paint obtainStrokePaint = obtainStrokePaint();
        if (brush != null) {
            brush.mo1463applyToPq9zytI(mo1703getSizeNHjbRc(), obtainStrokePaint, alpha);
        } else if (obtainStrokePaint.getAlpha() != alpha) {
            obtainStrokePaint.setAlpha(alpha);
        }
        if (!Intrinsics.areEqual(obtainStrokePaint.getInternalColorFilter(), colorFilter)) {
            obtainStrokePaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m1429equalsimpl0(obtainStrokePaint.get_blendMode(), blendMode)) {
            obtainStrokePaint.mo1408setBlendModes9anfk8(blendMode);
        }
        if (obtainStrokePaint.getStrokeWidth() != strokeWidth) {
            obtainStrokePaint.setStrokeWidth(strokeWidth);
        }
        if (obtainStrokePaint.getStrokeMiterLimit() != miter) {
            obtainStrokePaint.setStrokeMiterLimit(miter);
        }
        if (!StrokeCap.m1604equalsimpl0(obtainStrokePaint.mo1406getStrokeCapKaPHkGw(), cap)) {
            obtainStrokePaint.mo1411setStrokeCapBeK7IIE(cap);
        }
        if (!StrokeJoin.m1611equalsimpl0(obtainStrokePaint.mo1407getStrokeJoinLxFBmk8(), join)) {
            obtainStrokePaint.mo1412setStrokeJoinWw9F2mQ(join);
        }
        if (!Intrinsics.areEqual(obtainStrokePaint.getPathEffect(), pathEffect)) {
            obtainStrokePaint.setPathEffect(pathEffect);
        }
        if (!FilterQuality.m1517equalsimpl0(obtainStrokePaint.mo1405getFilterQualityfv9h1I(), filterQuality)) {
            obtainStrokePaint.mo1410setFilterQualityvDHp3xo(filterQuality);
        }
        return obtainStrokePaint;
    }

    /* renamed from: configureStrokePaint-ho4zsrM$default, reason: not valid java name */
    static /* synthetic */ Paint m1666configureStrokePaintho4zsrM$default(CanvasDrawScope canvasDrawScope, Brush brush, float f5, float f6, int i5, int i6, PathEffect pathEffect, float f7, ColorFilter colorFilter, int i7, int i8, int i9, Object obj) {
        return canvasDrawScope.m1665configureStrokePaintho4zsrM(brush, f5, f6, i5, i6, pathEffect, f7, colorFilter, i7, (i9 & 512) != 0 ? DrawScope.INSTANCE.m1705getDefaultFilterQualityfv9h1I() : i8);
    }

    /* renamed from: modulate-5vOe2sY, reason: not valid java name */
    private final long m1667modulate5vOe2sY(long j5, float f5) {
        return f5 == 1.0f ? j5 : Color.m1485copywmQWz5c$default(j5, Color.m1488getAlphaimpl(j5) * f5, 0.0f, 0.0f, 0.0f, 14, null);
    }

    private final Paint obtainFillPaint() {
        Paint paint = this.fillPaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo1413setStylek9PVt8s(PaintingStyle.INSTANCE.m1572getFillTiuSbCo());
        this.fillPaint = Paint;
        return Paint;
    }

    private final Paint obtainStrokePaint() {
        Paint paint = this.strokePaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo1413setStylek9PVt8s(PaintingStyle.INSTANCE.m1573getStrokeTiuSbCo());
        this.strokePaint = Paint;
        return Paint;
    }

    private final Paint selectPaint(DrawStyle drawStyle) {
        if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
            return obtainFillPaint();
        }
        if (!(drawStyle instanceof Stroke)) {
            throw new NoWhenBranchMatchedException();
        }
        Paint obtainStrokePaint = obtainStrokePaint();
        Stroke stroke = (Stroke) drawStyle;
        if (obtainStrokePaint.getStrokeWidth() != stroke.getWidth()) {
            obtainStrokePaint.setStrokeWidth(stroke.getWidth());
        }
        if (!StrokeCap.m1604equalsimpl0(obtainStrokePaint.mo1406getStrokeCapKaPHkGw(), stroke.getCap())) {
            obtainStrokePaint.mo1411setStrokeCapBeK7IIE(stroke.getCap());
        }
        if (obtainStrokePaint.getStrokeMiterLimit() != stroke.getMiter()) {
            obtainStrokePaint.setStrokeMiterLimit(stroke.getMiter());
        }
        if (!StrokeJoin.m1611equalsimpl0(obtainStrokePaint.mo1407getStrokeJoinLxFBmk8(), stroke.getJoin())) {
            obtainStrokePaint.mo1412setStrokeJoinWw9F2mQ(stroke.getJoin());
        }
        if (!Intrinsics.areEqual(obtainStrokePaint.getPathEffect(), stroke.getPathEffect())) {
            obtainStrokePaint.setPathEffect(stroke.getPathEffect());
        }
        return obtainStrokePaint;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawCircle-VaOC9Bg, reason: not valid java name */
    public void mo1668drawCircleVaOC9Bg(long color, float radius, long center, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().mo1392drawCircle9KIMszo(center, radius, m1660configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawImage-AZ2fEMs, reason: not valid java name */
    public void mo1669drawImageAZ2fEMs(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
        this.drawParams.getCanvas().mo1394drawImageRectHPBpro0(image, srcOffset, srcSize, dstOffset, dstSize, m1661configurePaintswdJneE(null, style, alpha, colorFilter, blendMode, filterQuality));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawImage-gbVJVH8, reason: not valid java name */
    public void mo1670drawImagegbVJVH8(ImageBitmap image, long topLeft, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().mo1393drawImaged4ec7I(image, topLeft, m1662configurePaintswdJneE$default(this, null, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawLine-1RTmtNc, reason: not valid java name */
    public void mo1671drawLine1RTmtNc(Brush brush, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().mo1395drawLineWko1d7g(start, end, m1666configureStrokePaintho4zsrM$default(this, brush, strokeWidth, 4.0f, cap, StrokeJoin.INSTANCE.m1615getMiterLxFBmk8(), pathEffect, alpha, colorFilter, blendMode, 0, 512, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawLine-NGM6Ib0, reason: not valid java name */
    public void mo1672drawLineNGM6Ib0(long color, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().mo1395drawLineWko1d7g(start, end, m1664configureStrokePaintQ_0CZUI$default(this, color, strokeWidth, 4.0f, cap, StrokeJoin.INSTANCE.m1615getMiterLxFBmk8(), pathEffect, alpha, colorFilter, blendMode, 0, 512, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawPath-GBMwjPU, reason: not valid java name */
    public void mo1673drawPathGBMwjPU(Path path, Brush brush, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawPath(path, m1662configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawPath-LG529CI, reason: not valid java name */
    public void mo1674drawPathLG529CI(Path path, long color, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawPath(path, m1660configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRect-AsUm42w, reason: not valid java name */
    public void mo1675drawRectAsUm42w(Brush brush, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawRect(Offset.m1337getXimpl(topLeft), Offset.m1338getYimpl(topLeft), Offset.m1337getXimpl(topLeft) + Size.m1377getWidthimpl(size), Offset.m1338getYimpl(topLeft) + Size.m1375getHeightimpl(size), m1662configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRect-n-J9OG0, reason: not valid java name */
    public void mo1676drawRectnJ9OG0(long color, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawRect(Offset.m1337getXimpl(topLeft), Offset.m1338getYimpl(topLeft), Offset.m1337getXimpl(topLeft) + Size.m1377getWidthimpl(size), Offset.m1338getYimpl(topLeft) + Size.m1375getHeightimpl(size), m1660configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRoundRect-ZuiqVtQ, reason: not valid java name */
    public void mo1677drawRoundRectZuiqVtQ(Brush brush, long topLeft, long size, long cornerRadius, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawRoundRect(Offset.m1337getXimpl(topLeft), Offset.m1338getYimpl(topLeft), Offset.m1337getXimpl(topLeft) + Size.m1377getWidthimpl(size), Offset.m1338getYimpl(topLeft) + Size.m1375getHeightimpl(size), CornerRadius.m1323getXimpl(cornerRadius), CornerRadius.m1324getYimpl(cornerRadius), m1662configurePaintswdJneE$default(this, brush, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRoundRect-u-Aw5IA, reason: not valid java name */
    public void mo1678drawRoundRectuAw5IA(long color, long topLeft, long size, long cornerRadius, DrawStyle style, float alpha, ColorFilter colorFilter, int blendMode) {
        this.drawParams.getCanvas().drawRoundRect(Offset.m1337getXimpl(topLeft), Offset.m1338getYimpl(topLeft), Offset.m1337getXimpl(topLeft) + Size.m1377getWidthimpl(size), Offset.m1338getYimpl(topLeft) + Size.m1375getHeightimpl(size), CornerRadius.m1323getXimpl(cornerRadius), CornerRadius.m1324getYimpl(cornerRadius), m1660configurePaint2qPWKa0$default(this, color, style, alpha, colorFilter, blendMode, 0, 32, null));
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.drawParams.getDensity().getDensity();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public DrawContext getDrawContext() {
        return this.drawContext;
    }

    public final DrawParams getDrawParams() {
        return this.drawParams;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this.drawParams.getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public LayoutDirection getLayoutDirection() {
        return this.drawParams.getLayoutDirection();
    }
}
