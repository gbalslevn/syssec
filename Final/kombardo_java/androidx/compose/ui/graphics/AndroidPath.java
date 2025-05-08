package androidx.compose.ui.graphics;

import android.graphics.Path;
import android.graphics.RectF;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u000fJ/\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001f\u0010\u001aJ?\u0010\"\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\"\u0010#J?\u0010&\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000bH\u0016¢\u0006\u0004\b&\u0010#J\u001f\u0010)\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b,\u0010*J\u001f\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020-2\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b/\u00100J\"\u00106\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00012\u0006\u00103\u001a\u000202H\u0016ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u000f\u00107\u001a\u00020\bH\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\bH\u0016¢\u0006\u0004\b9\u00108J\u000f\u0010:\u001a\u00020\bH\u0016¢\u0006\u0004\b:\u00108J\u001a\u0010=\u001a\u00020\b2\u0006\u00103\u001a\u000202H\u0016ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u000f\u0010>\u001a\u00020\u0006H\u0016¢\u0006\u0004\b>\u0010?J*\u0010G\u001a\u00020D2\u0006\u0010@\u001a\u00020\u00012\u0006\u0010A\u001a\u00020\u00012\u0006\u0010C\u001a\u00020BH\u0016ø\u0001\u0000¢\u0006\u0004\bE\u0010FR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010H\u001a\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010R\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR*\u0010Z\u001a\u00020T2\u0006\u0010U\u001a\u00020T8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001a\u0010[\u001a\u00020D8VX\u0096\u0004¢\u0006\f\u0012\u0004\b]\u00108\u001a\u0004\b[\u0010\\R\u0014\u0010^\u001a\u00020D8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u0010\\\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006_"}, d2 = {"Landroidx/compose/ui/graphics/AndroidPath;", "Landroidx/compose/ui/graphics/Path;", "Landroid/graphics/Path;", "internalPath", "<init>", "(Landroid/graphics/Path;)V", "Landroidx/compose/ui/geometry/Rect;", "rect", BuildConfig.FLAVOR, "validateRectangle", "(Landroidx/compose/ui/geometry/Rect;)V", BuildConfig.FLAVOR, "x", "y", "moveTo", "(FF)V", "dx", "dy", "relativeMoveTo", "lineTo", "relativeLineTo", "x1", "y1", "x2", "y2", "quadraticTo", "(FFFF)V", "dx1", "dy1", "dx2", "dy2", "relativeQuadraticTo", "x3", "y3", "cubicTo", "(FFFFFF)V", "dx3", "dy3", "relativeCubicTo", "Landroidx/compose/ui/graphics/Path$Direction;", "direction", "addRect", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/graphics/Path$Direction;)V", "oval", "addOval", "Landroidx/compose/ui/geometry/RoundRect;", "roundRect", "addRoundRect", "(Landroidx/compose/ui/geometry/RoundRect;Landroidx/compose/ui/graphics/Path$Direction;)V", "path", "Landroidx/compose/ui/geometry/Offset;", "offset", "addPath-Uv8p0NA", "(Landroidx/compose/ui/graphics/Path;J)V", "addPath", "close", "()V", "reset", "rewind", "translate-k-4lQ0M", "(J)V", "translate", "getBounds", "()Landroidx/compose/ui/geometry/Rect;", "path1", "path2", "Landroidx/compose/ui/graphics/PathOperation;", "operation", BuildConfig.FLAVOR, "op-N5in7k0", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Path;I)Z", "op", "Landroid/graphics/Path;", "getInternalPath", "()Landroid/graphics/Path;", "Landroid/graphics/RectF;", "rectF", "Landroid/graphics/RectF;", BuildConfig.FLAVOR, "radii", "[F", "Landroid/graphics/Matrix;", "mMatrix", "Landroid/graphics/Matrix;", "Landroidx/compose/ui/graphics/PathFillType;", "value", "getFillType-Rg-k1Os", "()I", "setFillType-oQ8Xj4U", "(I)V", "fillType", "isConvex", "()Z", "isConvex$annotations", "isEmpty", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidPath implements Path {
    private final android.graphics.Path internalPath;
    private android.graphics.Matrix mMatrix;
    private float[] radii;
    private RectF rectF;

    public AndroidPath(android.graphics.Path path) {
        this.internalPath = path;
    }

    private final void validateRectangle(Rect rect) {
        if (Float.isNaN(rect.getLeft()) || Float.isNaN(rect.getTop()) || Float.isNaN(rect.getRight()) || Float.isNaN(rect.getBottom())) {
            AndroidPath_androidKt.throwIllegalStateException("Invalid rectangle, make sure no value is NaN");
        }
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addOval(Rect oval, Path.Direction direction) {
        if (this.rectF == null) {
            this.rectF = new RectF();
        }
        RectF rectF = this.rectF;
        Intrinsics.checkNotNull(rectF);
        rectF.set(oval.getLeft(), oval.getTop(), oval.getRight(), oval.getBottom());
        android.graphics.Path path = this.internalPath;
        RectF rectF2 = this.rectF;
        Intrinsics.checkNotNull(rectF2);
        path.addOval(rectF2, AndroidPath_androidKt.access$toPlatformPathDirection(direction));
    }

    @Override // androidx.compose.ui.graphics.Path
    /* renamed from: addPath-Uv8p0NA, reason: not valid java name */
    public void mo1420addPathUv8p0NA(Path path, long offset) {
        android.graphics.Path path2 = this.internalPath;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        path2.addPath(((AndroidPath) path).getInternalPath(), Offset.m1337getXimpl(offset), Offset.m1338getYimpl(offset));
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addRect(Rect rect, Path.Direction direction) {
        validateRectangle(rect);
        if (this.rectF == null) {
            this.rectF = new RectF();
        }
        RectF rectF = this.rectF;
        Intrinsics.checkNotNull(rectF);
        rectF.set(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
        android.graphics.Path path = this.internalPath;
        RectF rectF2 = this.rectF;
        Intrinsics.checkNotNull(rectF2);
        path.addRect(rectF2, AndroidPath_androidKt.access$toPlatformPathDirection(direction));
    }

    @Override // androidx.compose.ui.graphics.Path
    public void addRoundRect(RoundRect roundRect, Path.Direction direction) {
        if (this.rectF == null) {
            this.rectF = new RectF();
        }
        RectF rectF = this.rectF;
        Intrinsics.checkNotNull(rectF);
        rectF.set(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
        if (this.radii == null) {
            this.radii = new float[8];
        }
        float[] fArr = this.radii;
        Intrinsics.checkNotNull(fArr);
        fArr[0] = CornerRadius.m1323getXimpl(roundRect.getTopLeftCornerRadius());
        fArr[1] = CornerRadius.m1324getYimpl(roundRect.getTopLeftCornerRadius());
        fArr[2] = CornerRadius.m1323getXimpl(roundRect.getTopRightCornerRadius());
        fArr[3] = CornerRadius.m1324getYimpl(roundRect.getTopRightCornerRadius());
        fArr[4] = CornerRadius.m1323getXimpl(roundRect.getBottomRightCornerRadius());
        fArr[5] = CornerRadius.m1324getYimpl(roundRect.getBottomRightCornerRadius());
        fArr[6] = CornerRadius.m1323getXimpl(roundRect.getBottomLeftCornerRadius());
        fArr[7] = CornerRadius.m1324getYimpl(roundRect.getBottomLeftCornerRadius());
        android.graphics.Path path = this.internalPath;
        RectF rectF2 = this.rectF;
        Intrinsics.checkNotNull(rectF2);
        float[] fArr2 = this.radii;
        Intrinsics.checkNotNull(fArr2);
        path.addRoundRect(rectF2, fArr2, AndroidPath_androidKt.access$toPlatformPathDirection(direction));
    }

    @Override // androidx.compose.ui.graphics.Path
    public void close() {
        this.internalPath.close();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void cubicTo(float x12, float y12, float x22, float y22, float x32, float y32) {
        this.internalPath.cubicTo(x12, y12, x22, y22, x32, y32);
    }

    @Override // androidx.compose.ui.graphics.Path
    public Rect getBounds() {
        if (this.rectF == null) {
            this.rectF = new RectF();
        }
        RectF rectF = this.rectF;
        Intrinsics.checkNotNull(rectF);
        this.internalPath.computeBounds(rectF, true);
        return new Rect(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // androidx.compose.ui.graphics.Path
    /* renamed from: getFillType-Rg-k1Os, reason: not valid java name */
    public int mo1421getFillTypeRgk1Os() {
        return this.internalPath.getFillType() == Path.FillType.EVEN_ODD ? PathFillType.INSTANCE.m1578getEvenOddRgk1Os() : PathFillType.INSTANCE.m1579getNonZeroRgk1Os();
    }

    public final android.graphics.Path getInternalPath() {
        return this.internalPath;
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean isConvex() {
        return this.internalPath.isConvex();
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean isEmpty() {
        return this.internalPath.isEmpty();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void lineTo(float x5, float y5) {
        this.internalPath.lineTo(x5, y5);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void moveTo(float x5, float y5) {
        this.internalPath.moveTo(x5, y5);
    }

    @Override // androidx.compose.ui.graphics.Path
    /* renamed from: op-N5in7k0, reason: not valid java name */
    public boolean mo1422opN5in7k0(Path path1, Path path2, int operation) {
        PathOperation.Companion companion = PathOperation.INSTANCE;
        Path.Op op = PathOperation.m1581equalsimpl0(operation, companion.m1582getDifferenceb3I0S0c()) ? Path.Op.DIFFERENCE : PathOperation.m1581equalsimpl0(operation, companion.m1583getIntersectb3I0S0c()) ? Path.Op.INTERSECT : PathOperation.m1581equalsimpl0(operation, companion.m1584getReverseDifferenceb3I0S0c()) ? Path.Op.REVERSE_DIFFERENCE : PathOperation.m1581equalsimpl0(operation, companion.m1585getUnionb3I0S0c()) ? Path.Op.UNION : Path.Op.XOR;
        android.graphics.Path path = this.internalPath;
        if (!(path1 instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        android.graphics.Path internalPath = ((AndroidPath) path1).getInternalPath();
        if (path2 instanceof AndroidPath) {
            return path.op(internalPath, ((AndroidPath) path2).getInternalPath(), op);
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.Path
    public void quadraticTo(float x12, float y12, float x22, float y22) {
        this.internalPath.quadTo(x12, y12, x22, y22);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeCubicTo(float dx1, float dy1, float dx2, float dy2, float dx3, float dy3) {
        this.internalPath.rCubicTo(dx1, dy1, dx2, dy2, dx3, dy3);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeLineTo(float dx, float dy) {
        this.internalPath.rLineTo(dx, dy);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeMoveTo(float dx, float dy) {
        this.internalPath.rMoveTo(dx, dy);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void relativeQuadraticTo(float dx1, float dy1, float dx2, float dy2) {
        this.internalPath.rQuadTo(dx1, dy1, dx2, dy2);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void reset() {
        this.internalPath.reset();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void rewind() {
        this.internalPath.rewind();
    }

    @Override // androidx.compose.ui.graphics.Path
    /* renamed from: setFillType-oQ8Xj4U, reason: not valid java name */
    public void mo1423setFillTypeoQ8Xj4U(int i5) {
        this.internalPath.setFillType(PathFillType.m1576equalsimpl0(i5, PathFillType.INSTANCE.m1578getEvenOddRgk1Os()) ? Path.FillType.EVEN_ODD : Path.FillType.WINDING);
    }

    @Override // androidx.compose.ui.graphics.Path
    /* renamed from: translate-k-4lQ0M, reason: not valid java name */
    public void mo1424translatek4lQ0M(long offset) {
        android.graphics.Matrix matrix = this.mMatrix;
        if (matrix == null) {
            this.mMatrix = new android.graphics.Matrix();
        } else {
            Intrinsics.checkNotNull(matrix);
            matrix.reset();
        }
        android.graphics.Matrix matrix2 = this.mMatrix;
        Intrinsics.checkNotNull(matrix2);
        matrix2.setTranslate(Offset.m1337getXimpl(offset), Offset.m1338getYimpl(offset));
        android.graphics.Path path = this.internalPath;
        android.graphics.Matrix matrix3 = this.mMatrix;
        Intrinsics.checkNotNull(matrix3);
        path.transform(matrix3);
    }

    public /* synthetic */ AndroidPath(android.graphics.Path path, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? new android.graphics.Path() : path);
    }
}
