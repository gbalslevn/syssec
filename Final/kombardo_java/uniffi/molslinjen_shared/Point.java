package uniffi.molslinjen_shared;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Luniffi/molslinjen_shared/Point;", BuildConfig.FLAVOR, "x", BuildConfig.FLAVOR, "y", "(DD)V", "getX", "()D", "setX", "(D)V", "getY", "setY", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Point {
    private double x;
    private double y;

    public Point(double d5, double d6) {
        this.x = d5;
        this.y = d6;
    }

    public static /* synthetic */ Point copy$default(Point point, double d5, double d6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            d5 = point.x;
        }
        if ((i5 & 2) != 0) {
            d6 = point.y;
        }
        return point.copy(d5, d6);
    }

    /* renamed from: component1, reason: from getter */
    public final double getX() {
        return this.x;
    }

    /* renamed from: component2, reason: from getter */
    public final double getY() {
        return this.y;
    }

    public final Point copy(double x5, double y5) {
        return new Point(x5, y5);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Point)) {
            return false;
        }
        Point point = (Point) other;
        return Double.compare(this.x, point.x) == 0 && Double.compare(this.y, point.y) == 0;
    }

    public final double getX() {
        return this.x;
    }

    public final double getY() {
        return this.y;
    }

    public int hashCode() {
        return (Double.hashCode(this.x) * 31) + Double.hashCode(this.y);
    }

    public final void setX(double d5) {
        this.x = d5;
    }

    public final void setY(double d5) {
        this.y = d5;
    }

    public String toString() {
        return "Point(x=" + this.x + ", y=" + this.y + ")";
    }
}
