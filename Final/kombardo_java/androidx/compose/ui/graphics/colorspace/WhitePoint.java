package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\bB)\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\nJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001c\u0010\u001b¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/WhitePoint;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "x", "y", "<init>", "(FF)V", "z", "(FFF)V", "sum", "(FFFF)V", BuildConfig.FLAVOR, "toXyz$ui_graphics_release", "()[F", "toXyz", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "F", "getX", "()F", "getY", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class WhitePoint {
    private final float x;
    private final float y;

    public WhitePoint(float f5, float f6) {
        this.x = f5;
        this.y = f6;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WhitePoint)) {
            return false;
        }
        WhitePoint whitePoint = (WhitePoint) other;
        return Float.compare(this.x, whitePoint.x) == 0 && Float.compare(this.y, whitePoint.y) == 0;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        return (Float.hashCode(this.x) * 31) + Float.hashCode(this.y);
    }

    public String toString() {
        return "WhitePoint(x=" + this.x + ", y=" + this.y + ')';
    }

    public final float[] toXyz$ui_graphics_release() {
        float f5 = this.x;
        float f6 = this.y;
        return new float[]{f5 / f6, 1.0f, ((1.0f - f5) - f6) / f6};
    }

    public WhitePoint(float f5, float f6, float f7) {
        this(f5, f6, f7, f5 + f6 + f7);
    }

    private WhitePoint(float f5, float f6, float f7, float f8) {
        this(f5 / f8, f6 / f8);
    }
}
