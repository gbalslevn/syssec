package coil.size;

import coil.size.Dimension;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\b¨\u0006\u0018"}, d2 = {"Lcoil/size/Size;", BuildConfig.FLAVOR, "Lcoil/size/Dimension;", "width", "height", "<init>", "(Lcoil/size/Dimension;Lcoil/size/Dimension;)V", "component1", "()Lcoil/size/Dimension;", "component2", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Lcoil/size/Dimension;", "getWidth", "getHeight", "Companion", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class Size {
    public static final Size ORIGINAL;
    private final Dimension height;
    private final Dimension width;

    static {
        Dimension.Undefined undefined = Dimension.Undefined.INSTANCE;
        ORIGINAL = new Size(undefined, undefined);
    }

    public Size(Dimension dimension, Dimension dimension2) {
        this.width = dimension;
        this.height = dimension2;
    }

    /* renamed from: component1, reason: from getter */
    public final Dimension getWidth() {
        return this.width;
    }

    /* renamed from: component2, reason: from getter */
    public final Dimension getHeight() {
        return this.height;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Size)) {
            return false;
        }
        Size size = (Size) other;
        return Intrinsics.areEqual(this.width, size.width) && Intrinsics.areEqual(this.height, size.height);
    }

    public final Dimension getHeight() {
        return this.height;
    }

    public final Dimension getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (this.width.hashCode() * 31) + this.height.hashCode();
    }

    public String toString() {
        return "Size(width=" + this.width + ", height=" + this.height + ')';
    }
}
