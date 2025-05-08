package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aF\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/Dp;", "elevation", "Landroidx/compose/ui/graphics/Shape;", "shape", BuildConfig.FLAVOR, "clip", "Landroidx/compose/ui/graphics/Color;", "ambientColor", "spotColor", "shadow-s4CzXII", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;ZJJ)Landroidx/compose/ui/Modifier;", "shadow", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ShadowKt {
    /* renamed from: shadow-s4CzXII, reason: not valid java name */
    public static final Modifier m1269shadows4CzXII(Modifier modifier, float f5, Shape shape, boolean z5, long j5, long j6) {
        return (Dp.m2598compareTo0680j_4(f5, Dp.m2599constructorimpl((float) 0)) > 0 || z5) ? modifier.then(new ShadowGraphicsLayerElement(f5, shape, z5, j5, j6, null)) : modifier;
    }

    /* renamed from: shadow-s4CzXII$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1270shadows4CzXII$default(Modifier modifier, float f5, Shape shape, boolean z5, long j5, long j6, int i5, Object obj) {
        boolean z6;
        Shape rectangleShape = (i5 & 2) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        if ((i5 & 4) != 0) {
            z6 = false;
            if (Dp.m2598compareTo0680j_4(f5, Dp.m2599constructorimpl(0)) > 0) {
                z6 = true;
            }
        } else {
            z6 = z5;
        }
        return m1269shadows4CzXII(modifier, f5, rectangleShape, z6, (i5 & 8) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j5, (i5 & 16) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j6);
    }
}
