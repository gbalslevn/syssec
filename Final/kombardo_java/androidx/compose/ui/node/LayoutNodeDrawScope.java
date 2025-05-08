package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006JY\u0010\u0017\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0003\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016JO\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0003\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJw\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020\u001e2\b\b\u0002\u0010#\u001a\u00020 2\b\b\u0003\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020$H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'Jk\u00103\u001a\u00020\u00142\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000b2\b\b\u0002\u0010,\u001a\u00020\t2\b\b\u0002\u0010.\u001a\u00020-2\n\b\u0002\u00100\u001a\u0004\u0018\u00010/2\b\b\u0003\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102Jk\u00103\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000b2\b\b\u0002\u0010,\u001a\u00020\t2\b\b\u0002\u0010.\u001a\u00020-2\n\b\u0002\u00100\u001a\u0004\u0018\u00010/2\b\b\u0003\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105JM\u0010:\u001a\u00020\u00142\u0006\u00107\u001a\u0002062\u0006\u0010)\u001a\u00020(2\b\b\u0003\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109JM\u0010:\u001a\u00020\u00142\u0006\u00107\u001a\u0002062\u0006\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010<JY\u0010A\u001a\u00020\u00142\u0006\u0010)\u001a\u00020(2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0003\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@JY\u0010A\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0003\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010CJc\u0010H\u001a\u00020\u00142\u0006\u0010)\u001a\u00020(2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010E\u001a\u00020D2\b\b\u0003\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010GJc\u0010H\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010E\u001a\u00020D2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0003\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\u0017\u0010O\u001a\u00020L*\u00020KH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ\u0017\u0010S\u001a\u00020K*\u00020PH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bQ\u0010RJ\u001a\u0010S\u001a\u00020K*\u00020\tH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ\u001a\u0010S\u001a\u00020K*\u00020LH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010VJ\u0017\u0010Z\u001a\u00020W*\u00020=H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010YJ\u0017\u0010\\\u001a\u00020\t*\u00020KH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b[\u0010UJ\u0017\u0010\\\u001a\u00020\t*\u00020PH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b]\u0010RJ\u0017\u0010_\u001a\u00020=*\u00020WH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010YJ\u0017\u0010b\u001a\u00020P*\u00020KH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010aJ\u001a\u0010b\u001a\u00020P*\u00020\tH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bc\u0010aJ\u000f\u0010d\u001a\u00020\u0014H\u0016¢\u0006\u0004\bd\u0010eJ#\u0010k\u001a\u00020\u0014*\u00020f2\u0006\u0010h\u001a\u00020g2\b\u0010j\u001a\u0004\u0018\u00010i¢\u0006\u0004\bk\u0010lJ<\u0010s\u001a\u00020\u00142\u0006\u0010h\u001a\u00020g2\u0006\u0010>\u001a\u00020=2\u0006\u0010n\u001a\u00020m2\u0006\u0010p\u001a\u00020o2\b\u0010j\u001a\u0004\u0018\u00010iH\u0000ø\u0001\u0000¢\u0006\u0004\bq\u0010rJ<\u0010v\u001a\u00020\u00142\u0006\u0010h\u001a\u00020g2\u0006\u0010>\u001a\u00020=2\u0006\u0010n\u001a\u00020m2\u0006\u0010p\u001a\u00020f2\b\u0010j\u001a\u0004\u0018\u00010iH\u0000ø\u0001\u0000¢\u0006\u0004\bt\u0010uR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010w\u001a\u0004\bx\u0010yR\u0018\u0010p\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010zR\u001a\u0010\f\u001a\u00020\u000b8VX\u0096\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b{\u0010|R\u0014\u0010\u007f\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b}\u0010~R\u0018\u0010\u0083\u0001\u001a\u00030\u0080\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0016\u0010\u0085\u0001\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010~R\u0018\u0010\u0089\u0001\u001a\u00030\u0086\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001b\u0010>\u001a\u00020=8VX\u0096\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010|\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u008b\u0001"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "canvasDrawScope", "<init>", "(Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "Landroidx/compose/ui/graphics/Color;", "color", BuildConfig.FLAVOR, "radius", "Landroidx/compose/ui/geometry/Offset;", "center", "alpha", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "style", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", BuildConfig.FLAVOR, "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "Landroidx/compose/ui/graphics/ImageBitmap;", "image", "topLeft", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "Landroidx/compose/ui/unit/IntOffset;", "srcOffset", "Landroidx/compose/ui/unit/IntSize;", "srcSize", "dstOffset", "dstSize", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "Landroidx/compose/ui/graphics/Brush;", "brush", "start", "end", "strokeWidth", "Landroidx/compose/ui/graphics/StrokeCap;", "cap", "Landroidx/compose/ui/graphics/PathEffect;", "pathEffect", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "Landroidx/compose/ui/graphics/Path;", "path", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "Landroidx/compose/ui/geometry/Size;", "size", "drawRect-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "Landroidx/compose/ui/geometry/CornerRadius;", "cornerRadius", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "Landroidx/compose/ui/unit/Dp;", BuildConfig.FLAVOR, "roundToPx-0680j_4", "(F)I", "roundToPx", "Landroidx/compose/ui/unit/TextUnit;", "toDp-GaN1DYA", "(J)F", "toDp", "toDp-u2uoSUM", "(F)F", "(I)F", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toDpSize", "toPx-0680j_4", "toPx", "toPx--R2X_6o", "toSize-XkaWNTQ", "toSize", "toSp-0xMU5do", "(F)J", "toSp", "toSp-kPz2Gy4", "drawContent", "()V", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "performDraw", "(Landroidx/compose/ui/node/DrawModifierNode;Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "Landroidx/compose/ui/node/NodeCoordinator;", "coordinator", "Landroidx/compose/ui/Modifier$Node;", "drawNode", "draw-eZhPAX0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "draw", "drawDirect-eZhPAX0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/node/DrawModifierNode;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "drawDirect", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "getCanvasDrawScope", "()Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "Landroidx/compose/ui/node/DrawModifierNode;", "getCenter-F1C5BW0", "()J", "getDensity", "()F", "density", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawContext", "getFontScale", "fontScale", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getSize-NH-jbRc", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutNodeDrawScope implements DrawScope, ContentDrawScope {
    private final CanvasDrawScope canvasDrawScope;
    private DrawModifierNode drawNode;

    public LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope) {
        this.canvasDrawScope = canvasDrawScope;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* renamed from: draw-eZhPAX0$ui_release, reason: not valid java name */
    public final void m2013draweZhPAX0$ui_release(Canvas canvas, long size, NodeCoordinator coordinator, Modifier.Node drawNode, GraphicsLayer layer) {
        int m2074constructorimpl = NodeKind.m2074constructorimpl(4);
        DelegatingNode delegatingNode = drawNode;
        MutableVector mutableVector = null;
        while (delegatingNode != 0) {
            if (delegatingNode instanceof DrawModifierNode) {
                m2014drawDirecteZhPAX0$ui_release(canvas, size, coordinator, delegatingNode, layer);
            } else if ((delegatingNode.getKindSet() & m2074constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                Modifier.Node delegate = delegatingNode.getDelegate();
                int i5 = 0;
                delegatingNode = delegatingNode;
                while (delegate != null) {
                    if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                        i5++;
                        if (i5 == 1) {
                            delegatingNode = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (delegatingNode != 0) {
                                mutableVector.add(delegatingNode);
                                delegatingNode = 0;
                            }
                            mutableVector.add(delegate);
                        }
                    }
                    delegate = delegate.getChild();
                    delegatingNode = delegatingNode;
                }
                if (i5 == 1) {
                }
            }
            delegatingNode = DelegatableNodeKt.pop(mutableVector);
        }
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawCircle-VaOC9Bg */
    public void mo1668drawCircleVaOC9Bg(long color, float radius, long center, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo1668drawCircleVaOC9Bg(color, radius, center, alpha, style, colorFilter, blendMode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object] */
    @Override // androidx.compose.ui.graphics.drawscope.ContentDrawScope
    public void drawContent() {
        DelegatingNode nextDrawNode;
        Canvas canvas = getDrawContext().getCanvas();
        DrawModifierNode drawModifierNode = this.drawNode;
        Intrinsics.checkNotNull(drawModifierNode);
        nextDrawNode = LayoutNodeDrawScopeKt.nextDrawNode(drawModifierNode);
        if (nextDrawNode == 0) {
            NodeCoordinator m1990requireCoordinator64DMado = DelegatableNodeKt.m1990requireCoordinator64DMado(drawModifierNode, NodeKind.m2074constructorimpl(4));
            if (m1990requireCoordinator64DMado.getTail() == drawModifierNode.getNode()) {
                m1990requireCoordinator64DMado = m1990requireCoordinator64DMado.getWrapped();
                Intrinsics.checkNotNull(m1990requireCoordinator64DMado);
            }
            m1990requireCoordinator64DMado.performDraw(canvas, getDrawContext().getGraphicsLayer());
            return;
        }
        int m2074constructorimpl = NodeKind.m2074constructorimpl(4);
        MutableVector mutableVector = null;
        while (nextDrawNode != 0) {
            if (nextDrawNode instanceof DrawModifierNode) {
                performDraw((DrawModifierNode) nextDrawNode, canvas, getDrawContext().getGraphicsLayer());
            } else if ((nextDrawNode.getKindSet() & m2074constructorimpl) != 0 && (nextDrawNode instanceof DelegatingNode)) {
                Modifier.Node delegate = nextDrawNode.getDelegate();
                int i5 = 0;
                nextDrawNode = nextDrawNode;
                while (delegate != null) {
                    if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                        i5++;
                        if (i5 == 1) {
                            nextDrawNode = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (nextDrawNode != 0) {
                                mutableVector.add(nextDrawNode);
                                nextDrawNode = 0;
                            }
                            mutableVector.add(delegate);
                        }
                    }
                    delegate = delegate.getChild();
                    nextDrawNode = nextDrawNode;
                }
                if (i5 == 1) {
                }
            }
            nextDrawNode = DelegatableNodeKt.pop(mutableVector);
        }
    }

    /* renamed from: drawDirect-eZhPAX0$ui_release, reason: not valid java name */
    public final void m2014drawDirecteZhPAX0$ui_release(Canvas canvas, long size, NodeCoordinator coordinator, DrawModifierNode drawNode, GraphicsLayer layer) {
        DrawModifierNode drawModifierNode = this.drawNode;
        this.drawNode = drawNode;
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        LayoutDirection layoutDirection = coordinator.getLayoutDirection();
        Density density = canvasDrawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = canvasDrawScope.getDrawContext().getLayoutDirection();
        Canvas canvas2 = canvasDrawScope.getDrawContext().getCanvas();
        long mo1682getSizeNHjbRc = canvasDrawScope.getDrawContext().mo1682getSizeNHjbRc();
        GraphicsLayer graphicsLayer = canvasDrawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = canvasDrawScope.getDrawContext();
        drawContext.setDensity(coordinator);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.mo1683setSizeuvyYCjk(size);
        drawContext.setGraphicsLayer(layer);
        canvas.save();
        try {
            drawNode.draw(this);
            canvas.restore();
            DrawContext drawContext2 = canvasDrawScope.getDrawContext();
            drawContext2.setDensity(density);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
            drawContext2.setGraphicsLayer(graphicsLayer);
            this.drawNode = drawModifierNode;
        } catch (Throwable th) {
            canvas.restore();
            DrawContext drawContext3 = canvasDrawScope.getDrawContext();
            drawContext3.setDensity(density);
            drawContext3.setLayoutDirection(layoutDirection2);
            drawContext3.setCanvas(canvas2);
            drawContext3.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
            drawContext3.setGraphicsLayer(graphicsLayer);
            throw th;
        }
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawImage-AZ2fEMs */
    public void mo1669drawImageAZ2fEMs(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
        this.canvasDrawScope.mo1669drawImageAZ2fEMs(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, filterQuality);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawImage-gbVJVH8 */
    public void mo1670drawImagegbVJVH8(ImageBitmap image, long topLeft, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo1670drawImagegbVJVH8(image, topLeft, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawLine-1RTmtNc */
    public void mo1671drawLine1RTmtNc(Brush brush, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo1671drawLine1RTmtNc(brush, start, end, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawLine-NGM6Ib0 */
    public void mo1672drawLineNGM6Ib0(long color, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo1672drawLineNGM6Ib0(color, start, end, strokeWidth, cap, pathEffect, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawPath-GBMwjPU */
    public void mo1673drawPathGBMwjPU(Path path, Brush brush, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo1673drawPathGBMwjPU(path, brush, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawPath-LG529CI */
    public void mo1674drawPathLG529CI(Path path, long color, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo1674drawPathLG529CI(path, color, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRect-AsUm42w */
    public void mo1675drawRectAsUm42w(Brush brush, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo1675drawRectAsUm42w(brush, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRect-n-J9OG0 */
    public void mo1676drawRectnJ9OG0(long color, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo1676drawRectnJ9OG0(color, topLeft, size, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRoundRect-ZuiqVtQ */
    public void mo1677drawRoundRectZuiqVtQ(Brush brush, long topLeft, long size, long cornerRadius, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo1677drawRoundRectZuiqVtQ(brush, topLeft, size, cornerRadius, alpha, style, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRoundRect-u-Aw5IA */
    public void mo1678drawRoundRectuAw5IA(long color, long topLeft, long size, long cornerRadius, DrawStyle style, float alpha, ColorFilter colorFilter, int blendMode) {
        this.canvasDrawScope.mo1678drawRoundRectuAw5IA(color, topLeft, size, cornerRadius, style, alpha, colorFilter, blendMode);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: getCenter-F1C5BW0 */
    public long mo1702getCenterF1C5BW0() {
        return this.canvasDrawScope.mo1702getCenterF1C5BW0();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.canvasDrawScope.getDensity();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public DrawContext getDrawContext() {
        return this.canvasDrawScope.getDrawContext();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this.canvasDrawScope.getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public LayoutDirection getLayoutDirection() {
        return this.canvasDrawScope.getLayoutDirection();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: getSize-NH-jbRc */
    public long mo1703getSizeNHjbRc() {
        return this.canvasDrawScope.mo1703getSizeNHjbRc();
    }

    public final void performDraw(DrawModifierNode drawModifierNode, Canvas canvas, GraphicsLayer graphicsLayer) {
        NodeCoordinator m1990requireCoordinator64DMado = DelegatableNodeKt.m1990requireCoordinator64DMado(drawModifierNode, NodeKind.m2074constructorimpl(4));
        m1990requireCoordinator64DMado.getLayoutNode().getMDrawScope$ui_release().m2014drawDirecteZhPAX0$ui_release(canvas, IntSizeKt.m2668toSizeozmzZPI(m1990requireCoordinator64DMado.mo1948getSizeYbymL2g()), m1990requireCoordinator64DMado, drawModifierNode, graphicsLayer);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: roundToPx-0680j_4 */
    public int mo206roundToPx0680j_4(float f5) {
        return this.canvasDrawScope.mo206roundToPx0680j_4(f5);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* renamed from: toDp-GaN1DYA */
    public float mo207toDpGaN1DYA(long j5) {
        return this.canvasDrawScope.mo207toDpGaN1DYA(j5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo208toDpu2uoSUM(float f5) {
        return this.canvasDrawScope.mo208toDpu2uoSUM(f5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    public long mo210toDpSizekrfVVM(long j5) {
        return this.canvasDrawScope.mo210toDpSizekrfVVM(j5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx--R2X_6o */
    public float mo211toPxR2X_6o(long j5) {
        return this.canvasDrawScope.mo211toPxR2X_6o(j5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx-0680j_4 */
    public float mo212toPx0680j_4(float f5) {
        return this.canvasDrawScope.mo212toPx0680j_4(f5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    public long mo213toSizeXkaWNTQ(long j5) {
        return this.canvasDrawScope.mo213toSizeXkaWNTQ(j5);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* renamed from: toSp-0xMU5do */
    public long mo214toSp0xMU5do(float f5) {
        return this.canvasDrawScope.mo214toSp0xMU5do(f5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public long mo215toSpkPz2Gy4(float f5) {
        return this.canvasDrawScope.mo215toSpkPz2Gy4(f5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo209toDpu2uoSUM(int i5) {
        return this.canvasDrawScope.mo209toDpu2uoSUM(i5);
    }

    public /* synthetic */ LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }
}
