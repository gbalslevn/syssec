package coil.size;

import coil.size.Dimension;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {BuildConfig.FLAVOR, "px", "Lcoil/size/Dimension$Pixels;", "Dimension", "(I)Lcoil/size/Dimension$Pixels;", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* renamed from: coil.size.-Dimensions, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class Dimensions {
    public static final Dimension.Pixels Dimension(int i5) {
        return new Dimension.Pixels(i5);
    }
}
