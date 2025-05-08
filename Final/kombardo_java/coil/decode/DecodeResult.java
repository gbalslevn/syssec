package coil.decode;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0005\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcoil/decode/DecodeResult;", BuildConfig.FLAVOR, "Landroid/graphics/drawable/Drawable;", "drawable", BuildConfig.FLAVOR, "isSampled", "<init>", "(Landroid/graphics/drawable/Drawable;Z)V", "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "Z", "()Z", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DecodeResult {
    private final Drawable drawable;
    private final boolean isSampled;

    public DecodeResult(Drawable drawable, boolean z5) {
        this.drawable = drawable;
        this.isSampled = z5;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DecodeResult) {
            DecodeResult decodeResult = (DecodeResult) other;
            if (Intrinsics.areEqual(this.drawable, decodeResult.drawable) && this.isSampled == decodeResult.isSampled) {
                return true;
            }
        }
        return false;
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    public int hashCode() {
        return (this.drawable.hashCode() * 31) + Boolean.hashCode(this.isSampled);
    }

    /* renamed from: isSampled, reason: from getter */
    public final boolean getIsSampled() {
        return this.isSampled;
    }
}
