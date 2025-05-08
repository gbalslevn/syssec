package androidx.compose.ui.unit;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0005"}, d2 = {"Density", "Landroidx/compose/ui/unit/Density;", "density", BuildConfig.FLAVOR, "fontScale", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DensityKt {
    public static final Density Density(float f5, float f6) {
        return new DensityImpl(f5, f6);
    }

    public static /* synthetic */ Density Density$default(float f5, float f6, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            f6 = 1.0f;
        }
        return Density(f5, f6);
    }
}
