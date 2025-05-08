package uniffi.molslinjen_shared;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Luniffi/molslinjen_shared/Size;", BuildConfig.FLAVOR, "width", BuildConfig.FLAVOR, "height", "(DD)V", "getHeight", "()D", "setHeight", "(D)V", "getWidth", "setWidth", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Size {
    private double height;
    private double width;

    public Size(double d5, double d6) {
        this.width = d5;
        this.height = d6;
    }

    public static /* synthetic */ Size copy$default(Size size, double d5, double d6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            d5 = size.width;
        }
        if ((i5 & 2) != 0) {
            d6 = size.height;
        }
        return size.copy(d5, d6);
    }

    /* renamed from: component1, reason: from getter */
    public final double getWidth() {
        return this.width;
    }

    /* renamed from: component2, reason: from getter */
    public final double getHeight() {
        return this.height;
    }

    public final Size copy(double width, double height) {
        return new Size(width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Size)) {
            return false;
        }
        Size size = (Size) other;
        return Double.compare(this.width, size.width) == 0 && Double.compare(this.height, size.height) == 0;
    }

    public final double getHeight() {
        return this.height;
    }

    public final double getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (Double.hashCode(this.width) * 31) + Double.hashCode(this.height);
    }

    public final void setHeight(double d5) {
        this.height = d5;
    }

    public final void setWidth(double d5) {
        this.width = d5;
    }

    public String toString() {
        return "Size(width=" + this.width + ", height=" + this.height + ")";
    }
}
