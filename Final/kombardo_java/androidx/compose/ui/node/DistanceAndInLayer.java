package androidx.compose.ui.node;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0083@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/DistanceAndInLayer;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "packedValue", "constructor-impl", "(J)J", "other", BuildConfig.FLAVOR, "compareTo-S_HNhKs", "(JJ)I", "compareTo", BuildConfig.FLAVOR, "getDistance-impl", "(J)F", "distance", BuildConfig.FLAVOR, "isInLayer-impl", "(J)Z", "isInLayer", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
abstract class DistanceAndInLayer {
    /* renamed from: compareTo-S_HNhKs, reason: not valid java name */
    public static final int m1991compareToS_HNhKs(long j5, long j6) {
        boolean m1994isInLayerimpl = m1994isInLayerimpl(j5);
        return m1994isInLayerimpl != m1994isInLayerimpl(j6) ? m1994isInLayerimpl ? -1 : 1 : (int) Math.signum(m1993getDistanceimpl(j5) - m1993getDistanceimpl(j6));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1992constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: getDistance-impl, reason: not valid java name */
    public static final float m1993getDistanceimpl(long j5) {
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    /* renamed from: isInLayer-impl, reason: not valid java name */
    public static final boolean m1994isInLayerimpl(long j5) {
        return ((int) (j5 & 4294967295L)) != 0;
    }
}
