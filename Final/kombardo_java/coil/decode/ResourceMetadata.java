package coil.decode;

import coil.decode.ImageSource;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcoil/decode/ResourceMetadata;", "Lcoil/decode/ImageSource$Metadata;", BuildConfig.FLAVOR, "packageName", BuildConfig.FLAVOR, "resId", "density", "<init>", "(Ljava/lang/String;II)V", "Ljava/lang/String;", "getPackageName", "()Ljava/lang/String;", "I", "getResId", "()I", "getDensity", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ResourceMetadata extends ImageSource.Metadata {
    private final int density;
    private final String packageName;
    private final int resId;

    public ResourceMetadata(String str, int i5, int i6) {
        this.packageName = str;
        this.resId = i5;
        this.density = i6;
    }

    public final int getDensity() {
        return this.density;
    }
}
