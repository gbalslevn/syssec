package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ,\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002JF\u0010'\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010.R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R,\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006/"}, d2 = {"Landroidx/compose/foundation/BorderModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "widthParameter", "Landroidx/compose/ui/unit/Dp;", "brushParameter", "Landroidx/compose/ui/graphics/Brush;", "shapeParameter", "Landroidx/compose/ui/graphics/Shape;", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "borderCache", "Landroidx/compose/foundation/BorderCache;", "value", "brush", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "width", "getWidth-D9Ej5fM", "()F", "setWidth-0680j_4", "(F)V", "F", "drawGenericBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "fillArea", BuildConfig.FLAVOR, "strokeWidth", BuildConfig.FLAVOR, "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "drawRoundRectBorder-JqoCqck", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BorderModifierNode extends DelegatingNode {
    private BorderCache borderCache;
    private Brush brush;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private Shape shape;
    private float width;

    public /* synthetic */ BorderModifierNode(float f5, Brush brush, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
        this(f5, brush, shape);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00d9, code lost:
    
        if (androidx.compose.ui.graphics.ImageBitmapConfig.m1533equalsimpl(r14, r6 != null ? androidx.compose.ui.graphics.ImageBitmapConfig.m1531boximpl(r6.mo1398getConfig_sVssgQ()) : null) != false) goto L26;
     */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [T, androidx.compose.ui.graphics.ImageBitmap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final DrawResult drawGenericBorder(CacheDrawScope cacheDrawScope, final Brush brush, final Outline.Generic generic, boolean z5, float f5) {
        int m1539getArgb8888_sVssgQ;
        ColorFilter colorFilter;
        ImageBitmap imageBitmap;
        Canvas canvas;
        Canvas canvas2;
        ?? r12;
        CanvasDrawScope canvasDrawScope;
        float f6;
        long j5;
        DrawContext drawContext;
        if (z5) {
            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawGenericBorder$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                    invoke2(contentDrawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ContentDrawScope contentDrawScope) {
                    contentDrawScope.drawContent();
                    DrawScope.m1695drawPathGBMwjPU$default(contentDrawScope, Outline.Generic.this.getPath(), brush, 0.0f, null, null, 0, 60, null);
                }
            });
        }
        if (brush instanceof SolidColor) {
            m1539getArgb8888_sVssgQ = ImageBitmapConfig.INSTANCE.m1538getAlpha8_sVssgQ();
            colorFilter = ColorFilter.Companion.m1503tintxETnrds$default(ColorFilter.INSTANCE, ((SolidColor) brush).getValue(), 0, 2, null);
        } else {
            m1539getArgb8888_sVssgQ = ImageBitmapConfig.INSTANCE.m1539getArgb8888_sVssgQ();
            colorFilter = null;
        }
        final Rect bounds = generic.getPath().getBounds();
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache = this.borderCache;
        Intrinsics.checkNotNull(borderCache);
        Path obtainPath = borderCache.obtainPath();
        obtainPath.reset();
        Path.addRect$default(obtainPath, bounds, null, 2, null);
        obtainPath.mo1422opN5in7k0(obtainPath, generic.getPath(), PathOperation.INSTANCE.m1582getDifferenceb3I0S0c());
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final long IntSize = IntSizeKt.IntSize((int) Math.ceil(bounds.getWidth()), (int) Math.ceil(bounds.getHeight()));
        BorderCache borderCache2 = this.borderCache;
        Intrinsics.checkNotNull(borderCache2);
        imageBitmap = borderCache2.imageBitmap;
        canvas = borderCache2.canvas;
        ImageBitmapConfig m1531boximpl = imageBitmap != null ? ImageBitmapConfig.m1531boximpl(imageBitmap.mo1398getConfig_sVssgQ()) : null;
        boolean z6 = false;
        if (!(m1531boximpl == null ? false : ImageBitmapConfig.m1534equalsimpl0(m1531boximpl.getValue(), ImageBitmapConfig.INSTANCE.m1539getArgb8888_sVssgQ()))) {
        }
        z6 = true;
        if (imageBitmap == null || canvas == null || Size.m1377getWidthimpl(cacheDrawScope.m1261getSizeNHjbRc()) > imageBitmap.getWidth() || Size.m1375getHeightimpl(cacheDrawScope.m1261getSizeNHjbRc()) > imageBitmap.getHeight() || !z6) {
            ImageBitmap m1544ImageBitmapx__hDU$default = ImageBitmapKt.m1544ImageBitmapx__hDU$default(IntSize.m2661getWidthimpl(IntSize), IntSize.m2660getHeightimpl(IntSize), m1539getArgb8888_sVssgQ, false, null, 24, null);
            borderCache2.imageBitmap = m1544ImageBitmapx__hDU$default;
            Canvas Canvas = androidx.compose.ui.graphics.CanvasKt.Canvas(m1544ImageBitmapx__hDU$default);
            borderCache2.canvas = Canvas;
            canvas2 = Canvas;
            r12 = m1544ImageBitmapx__hDU$default;
        } else {
            r12 = imageBitmap;
            canvas2 = canvas;
        }
        canvasDrawScope = borderCache2.canvasDrawScope;
        if (canvasDrawScope == null) {
            canvasDrawScope = new CanvasDrawScope();
            borderCache2.canvasDrawScope = canvasDrawScope;
        }
        CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
        long m2668toSizeozmzZPI = IntSizeKt.m2668toSizeozmzZPI(IntSize);
        LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope2.getDrawParams();
        Density density = drawParams.getDensity();
        LayoutDirection layoutDirection2 = drawParams.getLayoutDirection();
        Canvas canvas3 = drawParams.getCanvas();
        long size = drawParams.getSize();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope2.getDrawParams();
        drawParams2.setDensity(cacheDrawScope);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas2);
        drawParams2.m1681setSizeuvyYCjk(m2668toSizeozmzZPI);
        canvas2.save();
        long m1496getBlack0d7_KjU = Color.INSTANCE.m1496getBlack0d7_KjU();
        BlendMode.Companion companion = BlendMode.INSTANCE;
        DrawScope.m1698drawRectnJ9OG0$default(canvasDrawScope2, m1496getBlack0d7_KjU, 0L, m2668toSizeozmzZPI, 0.0f, null, null, companion.m1432getClear0nO6VwU(), 58, null);
        float f7 = -bounds.getLeft();
        float f8 = -bounds.getTop();
        canvasDrawScope2.getDrawContext().getTransform().translate(f7, f8);
        try {
            try {
                DrawScope.m1695drawPathGBMwjPU$default(canvasDrawScope2, generic.getPath(), brush, 0.0f, new Stroke(f5 * 2, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
                float f9 = 1;
                float m1377getWidthimpl = (Size.m1377getWidthimpl(canvasDrawScope2.mo1703getSizeNHjbRc()) + f9) / Size.m1377getWidthimpl(canvasDrawScope2.mo1703getSizeNHjbRc());
                float m1375getHeightimpl = (Size.m1375getHeightimpl(canvasDrawScope2.mo1703getSizeNHjbRc()) + f9) / Size.m1375getHeightimpl(canvasDrawScope2.mo1703getSizeNHjbRc());
                long mo1702getCenterF1C5BW0 = canvasDrawScope2.mo1702getCenterF1C5BW0();
                DrawContext drawContext2 = canvasDrawScope2.getDrawContext();
                long mo1682getSizeNHjbRc = drawContext2.mo1682getSizeNHjbRc();
                drawContext2.getCanvas().save();
                try {
                    drawContext2.getTransform().mo1688scale0AR0LA0(m1377getWidthimpl, m1375getHeightimpl, mo1702getCenterF1C5BW0);
                    drawContext = drawContext2;
                    try {
                        DrawScope.m1695drawPathGBMwjPU$default(canvasDrawScope2, obtainPath, brush, 0.0f, null, null, companion.m1432getClear0nO6VwU(), 28, null);
                        drawContext.getCanvas().restore();
                        drawContext.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
                        canvasDrawScope2.getDrawContext().getTransform().translate(-f7, -f8);
                        canvas2.restore();
                        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope2.getDrawParams();
                        drawParams3.setDensity(density);
                        drawParams3.setLayoutDirection(layoutDirection2);
                        drawParams3.setCanvas(canvas3);
                        drawParams3.m1681setSizeuvyYCjk(size);
                        r12.prepareToDraw();
                        ref$ObjectRef.element = r12;
                        final ColorFilter colorFilter2 = colorFilter;
                        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawGenericBorder$3
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                                invoke2(contentDrawScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ContentDrawScope contentDrawScope) {
                                contentDrawScope.drawContent();
                                float left = Rect.this.getLeft();
                                float top = Rect.this.getTop();
                                Ref$ObjectRef<ImageBitmap> ref$ObjectRef2 = ref$ObjectRef;
                                long j6 = IntSize;
                                ColorFilter colorFilter3 = colorFilter2;
                                contentDrawScope.getDrawContext().getTransform().translate(left, top);
                                try {
                                    DrawScope.m1691drawImageAZ2fEMs$default(contentDrawScope, ref$ObjectRef2.element, 0L, j6, 0L, 0L, 0.0f, null, colorFilter3, 0, 0, 890, null);
                                } finally {
                                    contentDrawScope.getDrawContext().getTransform().translate(-left, -top);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        th = th;
                        f8 = f8;
                        f6 = f7;
                        j5 = mo1682getSizeNHjbRc;
                        try {
                            drawContext.getCanvas().restore();
                            drawContext.mo1683setSizeuvyYCjk(j5);
                            throw th;
                        } catch (Throwable th2) {
                            th = th2;
                            canvasDrawScope2.getDrawContext().getTransform().translate(-f6, -f8);
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    j5 = mo1682getSizeNHjbRc;
                    drawContext = drawContext2;
                    f8 = f8;
                    f6 = f7;
                }
            } catch (Throwable th4) {
                th = th4;
                f8 = f8;
                f6 = f7;
            }
        } catch (Throwable th5) {
            th = th5;
            f6 = f7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawRoundRectBorder-JqoCqck, reason: not valid java name */
    public final DrawResult m113drawRoundRectBorderJqoCqck(CacheDrawScope cacheDrawScope, final Brush brush, Outline.Rounded rounded, final long j5, final long j6, final boolean z5, final float f5) {
        final Path createRoundRectPath;
        if (RoundRectKt.isSimple(rounded.getRoundRect())) {
            final long topLeftCornerRadius = rounded.getRoundRect().getTopLeftCornerRadius();
            final float f6 = f5 / 2;
            final Stroke stroke = new Stroke(f5, 0.0f, 0, 0, null, 30, null);
            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                    invoke2(contentDrawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ContentDrawScope contentDrawScope) {
                    long m111shrinkKibmq7A;
                    long j7;
                    contentDrawScope.drawContent();
                    if (z5) {
                        DrawScope.m1699drawRoundRectZuiqVtQ$default(contentDrawScope, brush, 0L, 0L, topLeftCornerRadius, 0.0f, null, null, 0, 246, null);
                        return;
                    }
                    float m1323getXimpl = CornerRadius.m1323getXimpl(topLeftCornerRadius);
                    float f7 = f6;
                    if (m1323getXimpl < f7) {
                        float f8 = f5;
                        float m1377getWidthimpl = Size.m1377getWidthimpl(contentDrawScope.mo1703getSizeNHjbRc()) - f5;
                        float m1375getHeightimpl = Size.m1375getHeightimpl(contentDrawScope.mo1703getSizeNHjbRc()) - f5;
                        int m1479getDifferencertfAjoo = ClipOp.INSTANCE.m1479getDifferencertfAjoo();
                        Brush brush2 = brush;
                        long j8 = topLeftCornerRadius;
                        DrawContext drawContext = contentDrawScope.getDrawContext();
                        long mo1682getSizeNHjbRc = drawContext.mo1682getSizeNHjbRc();
                        drawContext.getCanvas().save();
                        try {
                            drawContext.getTransform().mo1685clipRectN_I0leg(f8, f8, m1377getWidthimpl, m1375getHeightimpl, m1479getDifferencertfAjoo);
                            j7 = mo1682getSizeNHjbRc;
                            try {
                                DrawScope.m1699drawRoundRectZuiqVtQ$default(contentDrawScope, brush2, 0L, 0L, j8, 0.0f, null, null, 0, 246, null);
                                drawContext.getCanvas().restore();
                                drawContext.mo1683setSizeuvyYCjk(j7);
                            } catch (Throwable th) {
                                th = th;
                                drawContext.getCanvas().restore();
                                drawContext.mo1683setSizeuvyYCjk(j7);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            j7 = mo1682getSizeNHjbRc;
                        }
                    } else {
                        Brush brush3 = brush;
                        long j9 = j5;
                        long j10 = j6;
                        m111shrinkKibmq7A = BorderKt.m111shrinkKibmq7A(topLeftCornerRadius, f7);
                        DrawScope.m1699drawRoundRectZuiqVtQ$default(contentDrawScope, brush3, j9, j10, m111shrinkKibmq7A, 0.0f, stroke, null, 0, 208, null);
                    }
                }
            });
        }
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache = this.borderCache;
        Intrinsics.checkNotNull(borderCache);
        createRoundRectPath = BorderKt.createRoundRectPath(borderCache.obtainPath(), rounded.getRoundRect(), f5, z5);
        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope contentDrawScope) {
                contentDrawScope.drawContent();
                DrawScope.m1695drawPathGBMwjPU$default(contentDrawScope, Path.this, brush, 0.0f, null, null, 0, 60, null);
            }
        });
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final Shape getShape() {
        return this.shape;
    }

    /* renamed from: getWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getWidth() {
        return this.width;
    }

    public final void setBrush(Brush brush) {
        if (Intrinsics.areEqual(this.brush, brush)) {
            return;
        }
        this.brush = brush;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    public final void setShape(Shape shape) {
        if (Intrinsics.areEqual(this.shape, shape)) {
            return;
        }
        this.shape = shape;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    /* renamed from: setWidth-0680j_4, reason: not valid java name */
    public final void m115setWidth0680j_4(float f5) {
        if (Dp.m2601equalsimpl0(this.width, f5)) {
            return;
        }
        this.width = f5;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    private BorderModifierNode(float f5, Brush brush, Shape shape) {
        this.width = f5;
        this.brush = brush;
        this.shape = shape;
        this.drawWithCacheModifierNode = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.BorderModifierNode$drawWithCacheModifierNode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                DrawResult drawContentWithoutBorder;
                DrawResult m110drawRectBorderNsqcLGU;
                DrawResult m113drawRoundRectBorderJqoCqck;
                DrawResult drawGenericBorder;
                if (cacheDrawScope.mo212toPx0680j_4(BorderModifierNode.this.getWidth()) >= 0.0f && Size.m1376getMinDimensionimpl(cacheDrawScope.m1261getSizeNHjbRc()) > 0.0f) {
                    float f6 = 2;
                    float min = Math.min(Dp.m2601equalsimpl0(BorderModifierNode.this.getWidth(), Dp.INSTANCE.m2606getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil(cacheDrawScope.mo212toPx0680j_4(BorderModifierNode.this.getWidth())), (float) Math.ceil(Size.m1376getMinDimensionimpl(cacheDrawScope.m1261getSizeNHjbRc()) / f6));
                    float f7 = min / f6;
                    long Offset = OffsetKt.Offset(f7, f7);
                    long Size = SizeKt.Size(Size.m1377getWidthimpl(cacheDrawScope.m1261getSizeNHjbRc()) - min, Size.m1375getHeightimpl(cacheDrawScope.m1261getSizeNHjbRc()) - min);
                    boolean z5 = f6 * min > Size.m1376getMinDimensionimpl(cacheDrawScope.m1261getSizeNHjbRc());
                    Outline mo131createOutlinePq9zytI = BorderModifierNode.this.getShape().mo131createOutlinePq9zytI(cacheDrawScope.m1261getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
                    if (mo131createOutlinePq9zytI instanceof Outline.Generic) {
                        BorderModifierNode borderModifierNode = BorderModifierNode.this;
                        drawGenericBorder = borderModifierNode.drawGenericBorder(cacheDrawScope, borderModifierNode.getBrush(), (Outline.Generic) mo131createOutlinePq9zytI, z5, min);
                        return drawGenericBorder;
                    }
                    if (mo131createOutlinePq9zytI instanceof Outline.Rounded) {
                        BorderModifierNode borderModifierNode2 = BorderModifierNode.this;
                        m113drawRoundRectBorderJqoCqck = borderModifierNode2.m113drawRoundRectBorderJqoCqck(cacheDrawScope, borderModifierNode2.getBrush(), (Outline.Rounded) mo131createOutlinePq9zytI, Offset, Size, z5, min);
                        return m113drawRoundRectBorderJqoCqck;
                    }
                    if (!(mo131createOutlinePq9zytI instanceof Outline.Rectangle)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    m110drawRectBorderNsqcLGU = BorderKt.m110drawRectBorderNsqcLGU(cacheDrawScope, BorderModifierNode.this.getBrush(), Offset, Size, z5, min);
                    return m110drawRectBorderNsqcLGU;
                }
                drawContentWithoutBorder = BorderKt.drawContentWithoutBorder(cacheDrawScope);
                return drawContentWithoutBorder;
            }
        }));
    }
}
