package androidx.compose.ui.graphics;

import com.sun.jna.Function;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0004\b\u0081@\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\b\u0088\u0001\u0007\u0092\u0001\u00020\u0006¨\u0006\n"}, d2 = {"Landroidx/compose/ui/graphics/Float16;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "constructor-impl", "(F)S", BuildConfig.FLAVOR, "halfValue", "(S)S", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Float16 implements Comparable<Float16> {
    private static final short Epsilon = m1523constructorimpl((short) 5120);
    private static final short LowestValue = m1523constructorimpl((short) -1025);
    private static final short MaxValue = m1523constructorimpl((short) 31743);
    private static final short MinNormal = m1523constructorimpl((short) 1024);
    private static final short MinValue = m1523constructorimpl((short) 1);
    private static final short NaN = m1523constructorimpl((short) 32256);
    private static final short NegativeInfinity = m1523constructorimpl((short) -1024);
    private static final short NegativeZero = m1523constructorimpl(Short.MIN_VALUE);
    private static final short PositiveInfinity = m1523constructorimpl((short) 31744);
    private static final short PositiveZero = m1523constructorimpl((short) 0);

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m1523constructorimpl(short s5) {
        return s5;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m1522constructorimpl(float f5) {
        int i5;
        int floatToRawIntBits = Float.floatToRawIntBits(f5);
        int i6 = floatToRawIntBits >>> 31;
        int i7 = (floatToRawIntBits >>> 23) & Function.USE_VARARGS;
        int i8 = 8388607 & floatToRawIntBits;
        int i9 = 31;
        int i10 = 0;
        if (i7 != 255) {
            int i11 = i7 - 112;
            if (i11 >= 31) {
                i9 = 49;
            } else if (i11 > 0) {
                i10 = i8 >> 13;
                if ((floatToRawIntBits & 4096) != 0) {
                    i5 = (((i11 << 10) | i10) + 1) | (i6 << 15);
                    return m1523constructorimpl((short) i5);
                }
                i9 = i11;
            } else if (i11 >= -10) {
                int i12 = (8388608 | i8) >> (1 - i11);
                if ((i12 & 4096) != 0) {
                    i12 += 8192;
                }
                i9 = 0;
                i10 = i12 >> 13;
            } else {
                i9 = 0;
            }
        } else if (i8 != 0) {
            i10 = 512;
        }
        i5 = (i6 << 15) | (i9 << 10) | i10;
        return m1523constructorimpl((short) i5);
    }
}
