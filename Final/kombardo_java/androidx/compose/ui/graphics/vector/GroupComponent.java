package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u001f\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u001d\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u001a\u001a\u00020\u0006*\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u001e\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R$\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020%8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b'\u0010)R*\u0010*\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t8\u0006@BX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R6\u00101\u001a\b\u0012\u0004\u0012\u00020/0.2\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0.8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010$\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u00106\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010(R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R0\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010:8\u0010@\u0010X\u0090\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R \u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010<R*\u0010B\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u001c8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010\u001e\"\u0004\bE\u0010FR*\u0010H\u001a\u00020G2\u0006\u00100\u001a\u00020G8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR*\u0010N\u001a\u00020G2\u0006\u00100\u001a\u00020G8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010I\u001a\u0004\bO\u0010K\"\u0004\bP\u0010MR*\u0010Q\u001a\u00020G2\u0006\u00100\u001a\u00020G8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010I\u001a\u0004\bR\u0010K\"\u0004\bS\u0010MR*\u0010T\u001a\u00020G2\u0006\u00100\u001a\u00020G8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010I\u001a\u0004\bU\u0010K\"\u0004\bV\u0010MR*\u0010W\u001a\u00020G2\u0006\u00100\u001a\u00020G8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010I\u001a\u0004\bX\u0010K\"\u0004\bY\u0010MR*\u0010Z\u001a\u00020G2\u0006\u00100\u001a\u00020G8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010I\u001a\u0004\b[\u0010K\"\u0004\b\\\u0010MR*\u0010]\u001a\u00020G2\u0006\u00100\u001a\u00020G8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010I\u001a\u0004\b^\u0010K\"\u0004\b_\u0010MR\u0016\u0010`\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010(R\u0014\u0010b\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\ba\u0010)R\u0011\u0010e\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\bc\u0010d\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006f"}, d2 = {"Landroidx/compose/ui/graphics/vector/GroupComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "<init>", "()V", "Landroidx/compose/ui/graphics/Brush;", "brush", BuildConfig.FLAVOR, "markTintForBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "Landroidx/compose/ui/graphics/Color;", "color", "markTintForColor-8_81llA", "(J)V", "markTintForColor", "node", "markTintForVNode", "(Landroidx/compose/ui/graphics/vector/VNode;)V", "markNotTintable", "updateClipPath", "updateMatrix", BuildConfig.FLAVOR, "index", "instance", "insertAt", "(ILandroidx/compose/ui/graphics/vector/VNode;)V", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "draw", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "Landroidx/compose/ui/graphics/Matrix;", "groupMatrix", "[F", BuildConfig.FLAVOR, "children", "Ljava/util/List;", BuildConfig.FLAVOR, "<set-?>", "isTintable", "Z", "()Z", "tintColor", "J", "getTintColor-0d7_KjU", "()J", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/vector/PathNode;", "value", "clipPathData", "getClipPathData", "()Ljava/util/List;", "setClipPathData", "(Ljava/util/List;)V", "isClipPathDirty", "Landroidx/compose/ui/graphics/Path;", "clipPath", "Landroidx/compose/ui/graphics/Path;", "Lkotlin/Function1;", "invalidateListener", "Lkotlin/jvm/functions/Function1;", "getInvalidateListener$ui_release", "()Lkotlin/jvm/functions/Function1;", "setInvalidateListener$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "wrappedListener", "name", "Ljava/lang/String;", "getName", "setName", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "rotation", "F", "getRotation", "()F", "setRotation", "(F)V", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "isMatrixDirty", "getWillClipPath", "willClipPath", "getNumChildren", "()I", "numChildren", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GroupComponent extends VNode {
    private final List<VNode> children;
    private Path clipPath;
    private List<? extends PathNode> clipPathData;
    private float[] groupMatrix;
    private Function1<? super VNode, Unit> invalidateListener;
    private boolean isClipPathDirty;
    private boolean isMatrixDirty;
    private boolean isTintable;
    private String name;
    private float pivotX;
    private float pivotY;
    private float rotation;
    private float scaleX;
    private float scaleY;
    private long tintColor;
    private float translationX;
    private float translationY;
    private final Function1<VNode, Unit> wrappedListener;

    public GroupComponent() {
        super(null);
        this.children = new ArrayList();
        this.isTintable = true;
        this.tintColor = Color.INSTANCE.m1501getUnspecified0d7_KjU();
        this.clipPathData = VectorKt.getEmptyPath();
        this.isClipPathDirty = true;
        this.wrappedListener = new Function1<VNode, Unit>() { // from class: androidx.compose.ui.graphics.vector.GroupComponent$wrappedListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VNode vNode) {
                invoke2(vNode);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(VNode vNode) {
                GroupComponent.this.markTintForVNode(vNode);
                Function1<VNode, Unit> invalidateListener$ui_release = GroupComponent.this.getInvalidateListener$ui_release();
                if (invalidateListener$ui_release != null) {
                    invalidateListener$ui_release.invoke(vNode);
                }
            }
        };
        this.name = BuildConfig.FLAVOR;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.isMatrixDirty = true;
    }

    private final boolean getWillClipPath() {
        return !this.clipPathData.isEmpty();
    }

    private final void markNotTintable() {
        this.isTintable = false;
        this.tintColor = Color.INSTANCE.m1501getUnspecified0d7_KjU();
    }

    private final void markTintForBrush(Brush brush) {
        if (this.isTintable && brush != null) {
            if (brush instanceof SolidColor) {
                m1751markTintForColor8_81llA(((SolidColor) brush).getValue());
            } else {
                markNotTintable();
            }
        }
    }

    /* renamed from: markTintForColor-8_81llA, reason: not valid java name */
    private final void m1751markTintForColor8_81llA(long color) {
        if (this.isTintable && color != 16) {
            long j5 = this.tintColor;
            if (j5 == 16) {
                this.tintColor = color;
            } else {
                if (VectorKt.m1765rgbEqualOWjLjI(j5, color)) {
                    return;
                }
                markNotTintable();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markTintForVNode(VNode node) {
        if (node instanceof PathComponent) {
            PathComponent pathComponent = (PathComponent) node;
            markTintForBrush(pathComponent.getFill());
            markTintForBrush(pathComponent.getStroke());
        } else if (node instanceof GroupComponent) {
            GroupComponent groupComponent = (GroupComponent) node;
            if (groupComponent.isTintable && this.isTintable) {
                m1751markTintForColor8_81llA(groupComponent.tintColor);
            } else {
                markNotTintable();
            }
        }
    }

    private final void updateClipPath() {
        if (getWillClipPath()) {
            Path path = this.clipPath;
            if (path == null) {
                path = AndroidPath_androidKt.Path();
                this.clipPath = path;
            }
            PathParserKt.toPath(this.clipPathData, path);
        }
    }

    private final void updateMatrix() {
        float[] fArr = this.groupMatrix;
        if (fArr == null) {
            fArr = Matrix.m1547constructorimpl$default(null, 1, null);
            this.groupMatrix = fArr;
        } else {
            Matrix.m1552resetimpl(fArr);
        }
        Matrix.m1561translateimpl$default(fArr, this.pivotX + this.translationX, this.pivotY + this.translationY, 0.0f, 4, null);
        Matrix.m1555rotateZimpl(fArr, this.rotation);
        Matrix.m1556scaleimpl(fArr, this.scaleX, this.scaleY, 1.0f);
        Matrix.m1561translateimpl$default(fArr, -this.pivotX, -this.pivotY, 0.0f, 4, null);
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void draw(DrawScope drawScope) {
        if (this.isMatrixDirty) {
            updateMatrix();
            this.isMatrixDirty = false;
        }
        if (this.isClipPathDirty) {
            updateClipPath();
            this.isClipPathDirty = false;
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long mo1682getSizeNHjbRc = drawContext.mo1682getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            DrawTransform transform = drawContext.getTransform();
            float[] fArr = this.groupMatrix;
            if (fArr != null) {
                transform.mo1689transform58bKbWc(Matrix.m1545boximpl(fArr).getValues());
            }
            Path path = this.clipPath;
            if (getWillClipPath() && path != null) {
                DrawTransform.m1706clipPathmtrdDE$default(transform, path, 0, 2, null);
            }
            List<VNode> list = this.children;
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                list.get(i5).draw(drawScope);
            }
            drawContext.getCanvas().restore();
            drawContext.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
        } catch (Throwable th) {
            drawContext.getCanvas().restore();
            drawContext.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
            throw th;
        }
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public Function1<VNode, Unit> getInvalidateListener$ui_release() {
        return this.invalidateListener;
    }

    public final int getNumChildren() {
        return this.children.size();
    }

    /* renamed from: getTintColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTintColor() {
        return this.tintColor;
    }

    public final void insertAt(int index, VNode instance) {
        if (index < getNumChildren()) {
            this.children.set(index, instance);
        } else {
            this.children.add(instance);
        }
        markTintForVNode(instance);
        instance.setInvalidateListener$ui_release(this.wrappedListener);
        invalidate();
    }

    /* renamed from: isTintable, reason: from getter */
    public final boolean getIsTintable() {
        return this.isTintable;
    }

    public final void setClipPathData(List<? extends PathNode> list) {
        this.clipPathData = list;
        this.isClipPathDirty = true;
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void setInvalidateListener$ui_release(Function1<? super VNode, Unit> function1) {
        this.invalidateListener = function1;
    }

    public final void setName(String str) {
        this.name = str;
        invalidate();
    }

    public final void setPivotX(float f5) {
        this.pivotX = f5;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setPivotY(float f5) {
        this.pivotY = f5;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setRotation(float f5) {
        this.rotation = f5;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setScaleX(float f5) {
        this.scaleX = f5;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setScaleY(float f5) {
        this.scaleY = f5;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setTranslationX(float f5) {
        this.translationX = f5;
        this.isMatrixDirty = true;
        invalidate();
    }

    public final void setTranslationY(float f5) {
        this.translationY = f5;
        this.isMatrixDirty = true;
        invalidate();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VGroup: ");
        sb.append(this.name);
        List<VNode> list = this.children;
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            VNode vNode = list.get(i5);
            sb.append("\t");
            sb.append(vNode.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
