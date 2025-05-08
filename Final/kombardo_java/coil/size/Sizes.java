package coil.size;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcoil/size/Size;", BuildConfig.FLAVOR, "isOriginal", "(Lcoil/size/Size;)Z", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* renamed from: coil.size.-Sizes, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class Sizes {
    public static final boolean isOriginal(Size size) {
        return Intrinsics.areEqual(size, Size.ORIGINAL);
    }
}
