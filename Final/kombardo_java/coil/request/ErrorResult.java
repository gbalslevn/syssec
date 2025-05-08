package coil.request;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcoil/request/ErrorResult;", "Lcoil/request/ImageResult;", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcoil/request/ImageRequest;", "request", BuildConfig.FLAVOR, "throwable", "<init>", "(Landroid/graphics/drawable/Drawable;Lcoil/request/ImageRequest;Ljava/lang/Throwable;)V", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "Lcoil/request/ImageRequest;", "getRequest", "()Lcoil/request/ImageRequest;", "Ljava/lang/Throwable;", "getThrowable", "()Ljava/lang/Throwable;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ErrorResult extends ImageResult {
    private final Drawable drawable;
    private final ImageRequest request;
    private final Throwable throwable;

    public ErrorResult(Drawable drawable, ImageRequest imageRequest, Throwable th) {
        super(null);
        this.drawable = drawable;
        this.request = imageRequest;
        this.throwable = th;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ErrorResult) {
            ErrorResult errorResult = (ErrorResult) other;
            if (Intrinsics.areEqual(getDrawable(), errorResult.getDrawable()) && Intrinsics.areEqual(getRequest(), errorResult.getRequest()) && Intrinsics.areEqual(this.throwable, errorResult.throwable)) {
                return true;
            }
        }
        return false;
    }

    @Override // coil.request.ImageResult
    public Drawable getDrawable() {
        return this.drawable;
    }

    @Override // coil.request.ImageResult
    public ImageRequest getRequest() {
        return this.request;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public int hashCode() {
        Drawable drawable = getDrawable();
        return ((((drawable != null ? drawable.hashCode() : 0) * 31) + getRequest().hashCode()) * 31) + this.throwable.hashCode();
    }
}
