package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u0000 G2\u00020\u0001:\u0001GB'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\r\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0012\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001e\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\tH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J8\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\"\u0010\u0018J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010&\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010(\u0012\u0004\b+\u0010,\u001a\u0004\b)\u0010*R \u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0004\u0010(\u0012\u0004\b.\u0010,\u001a\u0004\b-\u0010*R \u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010(\u0012\u0004\b0\u0010,\u001a\u0004\b/\u0010*R \u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0006\u0010(\u0012\u0004\b2\u0010,\u001a\u0004\b1\u0010*R\u001a\u00105\u001a\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b4\u0010,\u001a\u0004\b3\u0010*R\u001a\u00108\u001a\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b7\u0010,\u001a\u0004\b6\u0010*R \u0010=\u001a\u0002098FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b<\u0010,\u001a\u0004\b:\u0010;R\u001a\u0010>\u001a\u00020\u00198FX\u0087\u0004¢\u0006\f\u0012\u0004\b@\u0010,\u001a\u0004\b>\u0010?R\u0017\u0010B\u001a\u00020\t8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bA\u0010;R\u0017\u0010D\u001a\u00020\t8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bC\u0010;R\u0017\u0010F\u001a\u00020\t8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bE\u0010;\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006H"}, d2 = {"Landroidx/compose/ui/geometry/Rect;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "left", "top", "right", "bottom", "<init>", "(FFFF)V", "Landroidx/compose/ui/geometry/Offset;", "offset", "translate-k-4lQ0M", "(J)Landroidx/compose/ui/geometry/Rect;", "translate", "translateX", "translateY", "(FF)Landroidx/compose/ui/geometry/Rect;", "other", "intersect", "(Landroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/geometry/Rect;", "otherLeft", "otherTop", "otherRight", "otherBottom", "(FFFF)Landroidx/compose/ui/geometry/Rect;", BuildConfig.FLAVOR, "overlaps", "(Landroidx/compose/ui/geometry/Rect;)Z", "contains-k-4lQ0M", "(J)Z", "contains", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "copy", BuildConfig.FLAVOR, "hashCode", "()I", "equals", "(Ljava/lang/Object;)Z", "F", "getLeft", "()F", "getLeft$annotations", "()V", "getTop", "getTop$annotations", "getRight", "getRight$annotations", "getBottom", "getBottom$annotations", "getWidth", "getWidth$annotations", "width", "getHeight", "getHeight$annotations", "height", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "getSize-NH-jbRc$annotations", "size", "isEmpty", "()Z", "isEmpty$annotations", "getTopLeft-F1C5BW0", "topLeft", "getCenter-F1C5BW0", "center", "getBottomRight-F1C5BW0", "bottomRight", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class Rect {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Rect Zero = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/compose/ui/geometry/Rect$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/geometry/Rect;", "Zero", "Landroidx/compose/ui/geometry/Rect;", "getZero", "()Landroidx/compose/ui/geometry/Rect;", "getZero$annotations", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Rect getZero() {
            return Rect.Zero;
        }

        private Companion() {
        }
    }

    public Rect(float f5, float f6, float f7, float f8) {
        this.left = f5;
        this.top = f6;
        this.right = f7;
        this.bottom = f8;
    }

    public static /* synthetic */ Rect copy$default(Rect rect, float f5, float f6, float f7, float f8, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = rect.left;
        }
        if ((i5 & 2) != 0) {
            f6 = rect.top;
        }
        if ((i5 & 4) != 0) {
            f7 = rect.right;
        }
        if ((i5 & 8) != 0) {
            f8 = rect.bottom;
        }
        return rect.copy(f5, f6, f7, f8);
    }

    /* renamed from: contains-k-4lQ0M, reason: not valid java name */
    public final boolean m1354containsk4lQ0M(long offset) {
        return Offset.m1337getXimpl(offset) >= this.left && Offset.m1337getXimpl(offset) < this.right && Offset.m1338getYimpl(offset) >= this.top && Offset.m1338getYimpl(offset) < this.bottom;
    }

    public final Rect copy(float left, float top, float right, float bottom) {
        return new Rect(left, top, right, bottom);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Rect)) {
            return false;
        }
        Rect rect = (Rect) other;
        return Float.compare(this.left, rect.left) == 0 && Float.compare(this.top, rect.top) == 0 && Float.compare(this.right, rect.right) == 0 && Float.compare(this.bottom, rect.bottom) == 0;
    }

    public final float getBottom() {
        return this.bottom;
    }

    /* renamed from: getBottomRight-F1C5BW0, reason: not valid java name */
    public final long m1355getBottomRightF1C5BW0() {
        return OffsetKt.Offset(this.right, this.bottom);
    }

    /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
    public final long m1356getCenterF1C5BW0() {
        return OffsetKt.Offset(this.left + (getWidth() / 2.0f), this.top + (getHeight() / 2.0f));
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

    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long m1357getSizeNHjbRc() {
        return SizeKt.Size(getWidth(), getHeight());
    }

    public final float getTop() {
        return this.top;
    }

    /* renamed from: getTopLeft-F1C5BW0, reason: not valid java name */
    public final long m1358getTopLeftF1C5BW0() {
        return OffsetKt.Offset(this.left, this.top);
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.left) * 31) + Float.hashCode(this.top)) * 31) + Float.hashCode(this.right)) * 31) + Float.hashCode(this.bottom);
    }

    public final Rect intersect(Rect other) {
        return new Rect(Math.max(this.left, other.left), Math.max(this.top, other.top), Math.min(this.right, other.right), Math.min(this.bottom, other.bottom));
    }

    public final boolean isEmpty() {
        return this.left >= this.right || this.top >= this.bottom;
    }

    public final boolean overlaps(Rect other) {
        return this.right > other.left && other.right > this.left && this.bottom > other.top && other.bottom > this.top;
    }

    public String toString() {
        return "Rect.fromLTRB(" + GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1) + ')';
    }

    public final Rect translate(float translateX, float translateY) {
        return new Rect(this.left + translateX, this.top + translateY, this.right + translateX, this.bottom + translateY);
    }

    /* renamed from: translate-k-4lQ0M, reason: not valid java name */
    public final Rect m1359translatek4lQ0M(long offset) {
        return new Rect(this.left + Offset.m1337getXimpl(offset), this.top + Offset.m1338getYimpl(offset), this.right + Offset.m1337getXimpl(offset), this.bottom + Offset.m1338getYimpl(offset));
    }

    public final Rect intersect(float otherLeft, float otherTop, float otherRight, float otherBottom) {
        return new Rect(Math.max(this.left, otherLeft), Math.max(this.top, otherTop), Math.min(this.right, otherRight), Math.min(this.bottom, otherBottom));
    }
}
