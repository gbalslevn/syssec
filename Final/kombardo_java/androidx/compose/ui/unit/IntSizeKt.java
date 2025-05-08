package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0016\u0010\t\u001a\u00020\u0006*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0016\u0010\u000b\u001a\u00020\u0003*\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\b\"\u001e\u0010\u0010\u001a\u00020\f*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\r\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {BuildConfig.FLAVOR, "width", "height", "Landroidx/compose/ui/unit/IntSize;", "IntSize", "(II)J", "Landroidx/compose/ui/geometry/Size;", "toSize-ozmzZPI", "(J)J", "toSize", "roundToIntSize-uvyYCjk", "roundToIntSize", "Landroidx/compose/ui/unit/IntOffset;", "getCenter-ozmzZPI", "getCenter-ozmzZPI$annotations", "(J)V", "center", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class IntSizeKt {
    public static final long IntSize(int i5, int i6) {
        return IntSize.m2657constructorimpl((i6 & 4294967295L) | (i5 << 32));
    }

    /* renamed from: getCenter-ozmzZPI, reason: not valid java name */
    public static final long m2666getCenterozmzZPI(long j5) {
        return IntOffset.m2635constructorimpl((((j5 << 32) >> 33) & 4294967295L) | ((j5 >> 33) << 32));
    }

    /* renamed from: roundToIntSize-uvyYCjk, reason: not valid java name */
    public static final long m2667roundToIntSizeuvyYCjk(long j5) {
        return IntSize.m2657constructorimpl((Math.round(Size.m1375getHeightimpl(j5)) & 4294967295L) | (Math.round(Size.m1377getWidthimpl(j5)) << 32));
    }

    /* renamed from: toSize-ozmzZPI, reason: not valid java name */
    public static final long m2668toSizeozmzZPI(long j5) {
        return SizeKt.Size(IntSize.m2661getWidthimpl(j5), IntSize.m2660getHeightimpl(j5));
    }
}
