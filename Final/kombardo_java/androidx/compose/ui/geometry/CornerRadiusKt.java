package androidx.compose.ui.geometry;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {BuildConfig.FLAVOR, "x", "y", "Landroidx/compose/ui/geometry/CornerRadius;", "CornerRadius", "(FF)J", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class CornerRadiusKt {
    public static final long CornerRadius(float f5, float f6) {
        return CornerRadius.m1321constructorimpl((Float.floatToRawIntBits(f6) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
    }

    public static /* synthetic */ long CornerRadius$default(float f5, float f6, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            f6 = f5;
        }
        return CornerRadius(f5, f6);
    }
}
