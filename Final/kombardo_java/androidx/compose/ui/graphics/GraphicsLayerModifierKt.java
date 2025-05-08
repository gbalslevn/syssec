package androidx.compose.ui.graphics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001aÂ\u0001\u0010\u001b\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cH\u0007¢\u0006\u0004\b\u001b\u0010 \u001a\u0013\u0010!\u001a\u00020\u0000*\u00020\u0000H\u0007¢\u0006\u0004\b!\u0010\"\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"Landroidx/compose/ui/Modifier;", BuildConfig.FLAVOR, "scaleX", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "Landroidx/compose/ui/graphics/TransformOrigin;", "transformOrigin", "Landroidx/compose/ui/graphics/Shape;", "shape", BuildConfig.FLAVOR, "clip", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "spotShadowColor", "Landroidx/compose/ui/graphics/CompositingStrategy;", "compositingStrategy", "graphicsLayer-Ap8cVGQ", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJI)Landroidx/compose/ui/Modifier;", "graphicsLayer", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", BuildConfig.FLAVOR, "block", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "toolingGraphicsLayer", "(Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class GraphicsLayerModifierKt {
    public static final Modifier graphicsLayer(Modifier modifier, Function1<? super GraphicsLayerScope, Unit> function1) {
        return modifier.then(new BlockGraphicsLayerElement(function1));
    }

    /* renamed from: graphicsLayer-Ap8cVGQ, reason: not valid java name */
    public static final Modifier m1524graphicsLayerAp8cVGQ(Modifier modifier, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, long j5, Shape shape, boolean z5, RenderEffect renderEffect, long j6, long j7, int i5) {
        return modifier.then(new GraphicsLayerElement(f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, j5, shape, z5, renderEffect, j6, j7, i5, null));
    }

    /* renamed from: graphicsLayer-Ap8cVGQ$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1525graphicsLayerAp8cVGQ$default(Modifier modifier, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, long j5, Shape shape, boolean z5, RenderEffect renderEffect, long j6, long j7, int i5, int i6, Object obj) {
        return m1524graphicsLayerAp8cVGQ(modifier, (i6 & 1) != 0 ? 1.0f : f5, (i6 & 2) != 0 ? 1.0f : f6, (i6 & 4) == 0 ? f7 : 1.0f, (i6 & 8) != 0 ? 0.0f : f8, (i6 & 16) != 0 ? 0.0f : f9, (i6 & 32) != 0 ? 0.0f : f10, (i6 & 64) != 0 ? 0.0f : f11, (i6 & 128) != 0 ? 0.0f : f12, (i6 & 256) == 0 ? f13 : 0.0f, (i6 & 512) != 0 ? 8.0f : f14, (i6 & 1024) != 0 ? TransformOrigin.INSTANCE.m1635getCenterSzJe1aQ() : j5, (i6 & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : shape, (i6 & 4096) != 0 ? false : z5, (i6 & 8192) != 0 ? null : renderEffect, (i6 & 16384) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j6, (i6 & 32768) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j7, (i6 & 65536) != 0 ? CompositingStrategy.INSTANCE.m1513getAutoNrFUSI() : i5);
    }

    public static final Modifier toolingGraphicsLayer(Modifier modifier) {
        return InspectableValueKt.isDebugInspectorInfoEnabled() ? modifier.then(m1525graphicsLayerAp8cVGQ$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null)) : modifier;
    }
}
