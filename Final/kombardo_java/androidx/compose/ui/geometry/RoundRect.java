package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0001*BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001b\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u001d\u0010\b\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010\t\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b!\u0010 R\u001d\u0010\n\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\"\u0010 R\u001d\u0010\u000b\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b#\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0011\u0010'\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b&\u0010\u001aR\u0011\u0010)\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b(\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/ui/geometry/RoundRect;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "left", "top", "right", "bottom", "Landroidx/compose/ui/geometry/CornerRadius;", "topLeftCornerRadius", "topRightCornerRadius", "bottomRightCornerRadius", "bottomLeftCornerRadius", "<init>", "(FFFFJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "F", "getLeft", "()F", "getTop", "getRight", "getBottom", "J", "getTopLeftCornerRadius-kKHJgLs", "()J", "getTopRightCornerRadius-kKHJgLs", "getBottomRightCornerRadius-kKHJgLs", "getBottomLeftCornerRadius-kKHJgLs", "_scaledRadiiRect", "Landroidx/compose/ui/geometry/RoundRect;", "getWidth", "width", "getHeight", "height", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class RoundRect {
    private static final RoundRect Zero = RoundRectKt.m1368RoundRectgG7oq9Y(0.0f, 0.0f, 0.0f, 0.0f, CornerRadius.INSTANCE.m1327getZerokKHJgLs());
    private RoundRect _scaledRadiiRect;
    private final float bottom;
    private final long bottomLeftCornerRadius;
    private final long bottomRightCornerRadius;
    private final float left;
    private final float right;
    private final float top;
    private final long topLeftCornerRadius;
    private final long topRightCornerRadius;

    public /* synthetic */ RoundRect(float f5, float f6, float f7, float f8, long j5, long j6, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(f5, f6, f7, f8, j5, j6, j7, j8);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoundRect)) {
            return false;
        }
        RoundRect roundRect = (RoundRect) other;
        return Float.compare(this.left, roundRect.left) == 0 && Float.compare(this.top, roundRect.top) == 0 && Float.compare(this.right, roundRect.right) == 0 && Float.compare(this.bottom, roundRect.bottom) == 0 && CornerRadius.m1322equalsimpl0(this.topLeftCornerRadius, roundRect.topLeftCornerRadius) && CornerRadius.m1322equalsimpl0(this.topRightCornerRadius, roundRect.topRightCornerRadius) && CornerRadius.m1322equalsimpl0(this.bottomRightCornerRadius, roundRect.bottomRightCornerRadius) && CornerRadius.m1322equalsimpl0(this.bottomLeftCornerRadius, roundRect.bottomLeftCornerRadius);
    }

    public final float getBottom() {
        return this.bottom;
    }

    /* renamed from: getBottomLeftCornerRadius-kKHJgLs, reason: not valid java name and from getter */
    public final long getBottomLeftCornerRadius() {
        return this.bottomLeftCornerRadius;
    }

    /* renamed from: getBottomRightCornerRadius-kKHJgLs, reason: not valid java name and from getter */
    public final long getBottomRightCornerRadius() {
        return this.bottomRightCornerRadius;
    }

    public final float getHeight() {
        return this.bottom - this.top;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    /* renamed from: getTopLeftCornerRadius-kKHJgLs, reason: not valid java name and from getter */
    public final long getTopLeftCornerRadius() {
        return this.topLeftCornerRadius;
    }

    /* renamed from: getTopRightCornerRadius-kKHJgLs, reason: not valid java name and from getter */
    public final long getTopRightCornerRadius() {
        return this.topRightCornerRadius;
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return (((((((((((((Float.hashCode(this.left) * 31) + Float.hashCode(this.top)) * 31) + Float.hashCode(this.right)) * 31) + Float.hashCode(this.bottom)) * 31) + CornerRadius.m1325hashCodeimpl(this.topLeftCornerRadius)) * 31) + CornerRadius.m1325hashCodeimpl(this.topRightCornerRadius)) * 31) + CornerRadius.m1325hashCodeimpl(this.bottomRightCornerRadius)) * 31) + CornerRadius.m1325hashCodeimpl(this.bottomLeftCornerRadius);
    }

    public String toString() {
        long j5 = this.topLeftCornerRadius;
        long j6 = this.topRightCornerRadius;
        long j7 = this.bottomRightCornerRadius;
        long j8 = this.bottomLeftCornerRadius;
        String str = GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1);
        if (!CornerRadius.m1322equalsimpl0(j5, j6) || !CornerRadius.m1322equalsimpl0(j6, j7) || !CornerRadius.m1322equalsimpl0(j7, j8)) {
            return "RoundRect(rect=" + str + ", topLeft=" + ((Object) CornerRadius.m1326toStringimpl(j5)) + ", topRight=" + ((Object) CornerRadius.m1326toStringimpl(j6)) + ", bottomRight=" + ((Object) CornerRadius.m1326toStringimpl(j7)) + ", bottomLeft=" + ((Object) CornerRadius.m1326toStringimpl(j8)) + ')';
        }
        if (CornerRadius.m1323getXimpl(j5) == CornerRadius.m1324getYimpl(j5)) {
            return "RoundRect(rect=" + str + ", radius=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m1323getXimpl(j5), 1) + ')';
        }
        return "RoundRect(rect=" + str + ", x=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m1323getXimpl(j5), 1) + ", y=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m1324getYimpl(j5), 1) + ')';
    }

    private RoundRect(float f5, float f6, float f7, float f8, long j5, long j6, long j7, long j8) {
        this.left = f5;
        this.top = f6;
        this.right = f7;
        this.bottom = f8;
        this.topLeftCornerRadius = j5;
        this.topRightCornerRadius = j6;
        this.bottomRightCornerRadius = j7;
        this.bottomLeftCornerRadius = j8;
    }
}
