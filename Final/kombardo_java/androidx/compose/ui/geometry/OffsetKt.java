package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a*\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\"\u001e\u0010\u0011\u001a\u00020\f*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\"\u001e\u0010\u0014\u001a\u00020\f*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\u000e\"\u001e\u0010\u0017\u001a\u00020\f*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0015\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {BuildConfig.FLAVOR, "x", "y", "Landroidx/compose/ui/geometry/Offset;", "Offset", "(FF)J", "start", "stop", "fraction", "lerp-Wko1d7g", "(JJF)J", "lerp", BuildConfig.FLAVOR, "isFinite-k-4lQ0M", "(J)Z", "isFinite-k-4lQ0M$annotations", "(J)V", "isFinite", "isSpecified-k-4lQ0M", "isSpecified-k-4lQ0M$annotations", "isSpecified", "isUnspecified-k-4lQ0M", "isUnspecified-k-4lQ0M$annotations", "isUnspecified", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class OffsetKt {
    public static final long Offset(float f5, float f6) {
        return Offset.m1329constructorimpl((Float.floatToRawIntBits(f6) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
    }

    /* renamed from: isFinite-k-4lQ0M, reason: not valid java name */
    public static final boolean m1350isFinitek4lQ0M(long j5) {
        long j6 = (j5 & 9187343241974906880L) ^ 9187343241974906880L;
        return (((~j6) & (j6 - 4294967297L)) & (-9223372034707292160L)) == 0;
    }

    /* renamed from: isSpecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m1351isSpecifiedk4lQ0M(long j5) {
        return (j5 & 9223372034707292159L) != 9205357640488583168L;
    }

    /* renamed from: isUnspecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m1352isUnspecifiedk4lQ0M(long j5) {
        return (j5 & 9223372034707292159L) == 9205357640488583168L;
    }

    /* renamed from: lerp-Wko1d7g, reason: not valid java name */
    public static final long m1353lerpWko1d7g(long j5, long j6, float f5) {
        float lerp = MathHelpersKt.lerp(Float.intBitsToFloat((int) (j5 >> 32)), Float.intBitsToFloat((int) (j6 >> 32)), f5);
        float lerp2 = MathHelpersKt.lerp(Float.intBitsToFloat((int) (j5 & 4294967295L)), Float.intBitsToFloat((int) (j6 & 4294967295L)), f5);
        return Offset.m1329constructorimpl((Float.floatToRawIntBits(lerp) << 32) | (Float.floatToRawIntBits(lerp2) & 4294967295L));
    }
}
