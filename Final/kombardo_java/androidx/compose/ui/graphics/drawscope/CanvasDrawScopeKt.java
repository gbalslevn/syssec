package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.InlineClassHelperKt;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"asDrawTransform", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class CanvasDrawScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawTransform asDrawTransform(final DrawContext drawContext) {
        return new DrawTransform() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt$asDrawTransform$1
            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: clipPath-mtrdD-E, reason: not valid java name */
            public void mo1684clipPathmtrdDE(Path path, int clipOp) {
                DrawContext.this.getCanvas().mo1389clipPathmtrdDE(path, clipOp);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: clipRect-N_I0leg, reason: not valid java name */
            public void mo1685clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp) {
                DrawContext.this.getCanvas().mo1390clipRectN_I0leg(left, top, right, bottom, clipOp);
            }

            /* renamed from: getSize-NH-jbRc, reason: not valid java name */
            public long m1686getSizeNHjbRc() {
                return DrawContext.this.mo1682getSizeNHjbRc();
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void inset(float left, float top, float right, float bottom) {
                Canvas canvas = DrawContext.this.getCanvas();
                DrawContext drawContext2 = DrawContext.this;
                long Size = SizeKt.Size(Size.m1377getWidthimpl(m1686getSizeNHjbRc()) - (right + left), Size.m1375getHeightimpl(m1686getSizeNHjbRc()) - (bottom + top));
                if (!(Size.m1377getWidthimpl(Size) >= 0.0f && Size.m1375getHeightimpl(Size) >= 0.0f)) {
                    InlineClassHelperKt.throwIllegalArgumentException("Width and height must be greater than or equal to zero");
                }
                drawContext2.mo1683setSizeuvyYCjk(Size);
                canvas.translate(left, top);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: rotate-Uv8p0NA, reason: not valid java name */
            public void mo1687rotateUv8p0NA(float degrees, long pivot) {
                Canvas canvas = DrawContext.this.getCanvas();
                canvas.translate(Offset.m1337getXimpl(pivot), Offset.m1338getYimpl(pivot));
                canvas.rotate(degrees);
                canvas.translate(-Offset.m1337getXimpl(pivot), -Offset.m1338getYimpl(pivot));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: scale-0AR0LA0, reason: not valid java name */
            public void mo1688scale0AR0LA0(float scaleX, float scaleY, long pivot) {
                Canvas canvas = DrawContext.this.getCanvas();
                canvas.translate(Offset.m1337getXimpl(pivot), Offset.m1338getYimpl(pivot));
                canvas.scale(scaleX, scaleY);
                canvas.translate(-Offset.m1337getXimpl(pivot), -Offset.m1338getYimpl(pivot));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: transform-58bKbWc, reason: not valid java name */
            public void mo1689transform58bKbWc(float[] matrix) {
                DrawContext.this.getCanvas().mo1391concat58bKbWc(matrix);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void translate(float left, float top) {
                DrawContext.this.getCanvas().translate(left, top);
            }
        };
    }
}
