package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0007\" \u0010\u0001\u001a\u00020\u00008\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0001\u0010\u0002\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/graphics/Shape;", "RectangleShape", "Landroidx/compose/ui/graphics/Shape;", "getRectangleShape", "()Landroidx/compose/ui/graphics/Shape;", "getRectangleShape$annotations", "()V", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class RectangleShapeKt {
    private static final Shape RectangleShape = new Shape() { // from class: androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1
        public String toString() {
            return "RectangleShape";
        }

        @Override // androidx.compose.ui.graphics.Shape
        /* renamed from: createOutline-Pq9zytI */
        public Outline.Rectangle mo131createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
            return new Outline.Rectangle(SizeKt.m1386toRectuvyYCjk(size));
        }
    };

    public static final Shape getRectangleShape() {
        return RectangleShape;
    }
}
