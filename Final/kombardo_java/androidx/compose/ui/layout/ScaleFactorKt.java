package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\n\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {BuildConfig.FLAVOR, "scaleX", "scaleY", "Landroidx/compose/ui/layout/ScaleFactor;", "ScaleFactor", "(FF)J", "Landroidx/compose/ui/geometry/Size;", "scaleFactor", "times-UQTWf7w", "(JJ)J", "times", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ScaleFactorKt {
    public static final long ScaleFactor(float f5, float f6) {
        return ScaleFactor.m1980constructorimpl((Float.floatToRawIntBits(f6) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
    }

    /* renamed from: times-UQTWf7w, reason: not valid java name */
    public static final long m1983timesUQTWf7w(long j5, long j6) {
        return SizeKt.Size(Size.m1377getWidthimpl(j5) * ScaleFactor.m1981getScaleXimpl(j6), Size.m1375getHeightimpl(j5) * ScaleFactor.m1982getScaleYimpl(j6));
    }
}
