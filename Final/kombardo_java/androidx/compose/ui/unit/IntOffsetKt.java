package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\n\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\f\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\t\u001a\u0016\u0010\u000f\u001a\u00020\u0003*\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {BuildConfig.FLAVOR, "x", "y", "Landroidx/compose/ui/unit/IntOffset;", "IntOffset", "(II)J", "Landroidx/compose/ui/geometry/Offset;", "offset", "plus-Nv-tHpc", "(JJ)J", "plus", "minus-Nv-tHpc", "minus", "round-k-4lQ0M", "(J)J", "round", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class IntOffsetKt {
    public static final long IntOffset(int i5, int i6) {
        return IntOffset.m2635constructorimpl((i6 & 4294967295L) | (i5 << 32));
    }

    /* renamed from: minus-Nv-tHpc, reason: not valid java name */
    public static final long m2649minusNvtHpc(long j5, long j6) {
        return OffsetKt.Offset(Offset.m1337getXimpl(j5) - IntOffset.m2640getXimpl(j6), Offset.m1338getYimpl(j5) - IntOffset.m2641getYimpl(j6));
    }

    /* renamed from: plus-Nv-tHpc, reason: not valid java name */
    public static final long m2650plusNvtHpc(long j5, long j6) {
        return OffsetKt.Offset(Offset.m1337getXimpl(j5) + IntOffset.m2640getXimpl(j6), Offset.m1338getYimpl(j5) + IntOffset.m2641getYimpl(j6));
    }

    /* renamed from: round-k-4lQ0M, reason: not valid java name */
    public static final long m2651roundk4lQ0M(long j5) {
        return IntOffset.m2635constructorimpl((Math.round(Offset.m1338getYimpl(j5)) & 4294967295L) | (Math.round(Offset.m1337getXimpl(j5)) << 32));
    }
}
