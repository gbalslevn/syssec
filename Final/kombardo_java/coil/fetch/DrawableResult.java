package coil.fetch;

import android.graphics.drawable.Drawable;
import coil.decode.DataSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0005\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcoil/fetch/DrawableResult;", "Lcoil/fetch/FetchResult;", "Landroid/graphics/drawable/Drawable;", "drawable", BuildConfig.FLAVOR, "isSampled", "Lcoil/decode/DataSource;", "dataSource", "<init>", "(Landroid/graphics/drawable/Drawable;ZLcoil/decode/DataSource;)V", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "Z", "()Z", "Lcoil/decode/DataSource;", "getDataSource", "()Lcoil/decode/DataSource;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DrawableResult extends FetchResult {
    private final DataSource dataSource;
    private final Drawable drawable;
    private final boolean isSampled;

    public DrawableResult(Drawable drawable, boolean z5, DataSource dataSource) {
        super(null);
        this.drawable = drawable;
        this.isSampled = z5;
        this.dataSource = dataSource;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DrawableResult) {
            DrawableResult drawableResult = (DrawableResult) other;
            if (Intrinsics.areEqual(this.drawable, drawableResult.drawable) && this.isSampled == drawableResult.isSampled && this.dataSource == drawableResult.dataSource) {
                return true;
            }
        }
        return false;
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    public int hashCode() {
        return (((this.drawable.hashCode() * 31) + Boolean.hashCode(this.isSampled)) * 31) + this.dataSource.hashCode();
    }

    /* renamed from: isSampled, reason: from getter */
    public final boolean getIsSampled() {
        return this.isSampled;
    }
}
