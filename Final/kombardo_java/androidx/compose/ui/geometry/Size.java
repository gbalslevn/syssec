package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\b\u0087@\u0018\u0000 +2\u00020\u0001:\u0001+B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000f\u001a\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0006H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u001b\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001f\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u0012\u0004\b!\u0010\"R\u001a\u0010\u0007\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010\b\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010\"\u001a\u0004\b&\u0010$R\u001a\u0010*\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010\"\u001a\u0004\b(\u0010$\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006,"}, d2 = {"Landroidx/compose/ui/geometry/Size;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "packedValue", "constructor-impl", "(J)J", BuildConfig.FLAVOR, "width", "height", "copy-xjbvk4A", "(JFF)J", "copy", BuildConfig.FLAVOR, "isEmpty-impl", "(J)Z", "isEmpty", "operand", "times-7Ah8Wj8", "(JF)J", "times", BuildConfig.FLAVOR, "toString-impl", "(J)Ljava/lang/String;", "toString", BuildConfig.FLAVOR, "hashCode-impl", "(J)I", "hashCode", "other", "equals-impl", "(JLjava/lang/Object;)Z", "equals", "J", "getPackedValue$annotations", "()V", "getWidth-impl", "(J)F", "getWidth$annotations", "getHeight-impl", "getHeight$annotations", "getMinDimension-impl", "getMinDimension$annotations", "minDimension", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Size {
    private final long packedValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m1371constructorimpl(0);
    private static final long Unspecified = m1371constructorimpl(9205357640488583168L);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR&\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\n\u0010\u0006\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\u000b\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\r"}, d2 = {"Landroidx/compose/ui/geometry/Size$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/geometry/Size;", "Zero", "J", "getZero-NH-jbRc", "()J", "getZero-NH-jbRc$annotations", "Unspecified", "getUnspecified-NH-jbRc", "getUnspecified-NH-jbRc$annotations", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getUnspecified-NH-jbRc, reason: not valid java name */
        public final long m1383getUnspecifiedNHjbRc() {
            return Size.Unspecified;
        }

        /* renamed from: getZero-NH-jbRc, reason: not valid java name */
        public final long m1384getZeroNHjbRc() {
            return Size.Zero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Size(long j5) {
        this.packedValue = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Size m1370boximpl(long j5) {
        return new Size(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1371constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: copy-xjbvk4A, reason: not valid java name */
    public static final long m1372copyxjbvk4A(long j5, float f5, float f6) {
        return m1371constructorimpl((Float.floatToRawIntBits(f5) << 32) | (Float.floatToRawIntBits(f6) & 4294967295L));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1373equalsimpl(long j5, Object obj) {
        return (obj instanceof Size) && j5 == ((Size) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1374equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getHeight-impl, reason: not valid java name */
    public static final float m1375getHeightimpl(long j5) {
        if (j5 == 9205357640488583168L) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }

    /* renamed from: getMinDimension-impl, reason: not valid java name */
    public static final float m1376getMinDimensionimpl(long j5) {
        if (j5 == 9205357640488583168L) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        return Math.min(Float.intBitsToFloat((int) ((j5 >> 32) & 2147483647L)), Float.intBitsToFloat((int) (j5 & 2147483647L)));
    }

    /* renamed from: getWidth-impl, reason: not valid java name */
    public static final float m1377getWidthimpl(long j5) {
        if (j5 == 9205357640488583168L) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1378hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m1379isEmptyimpl(long j5) {
        if (j5 == 9205357640488583168L) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        long j6 = j5 & (~((((-9223372034707292160L) & j5) >>> 31) * (-1)));
        return ((j6 & 4294967295L) & (j6 >>> 32)) == 0;
    }

    /* renamed from: times-7Ah8Wj8, reason: not valid java name */
    public static final long m1380times7Ah8Wj8(long j5, float f5) {
        if (j5 == 9205357640488583168L) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        float intBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32)) * f5;
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L)) * f5;
        return m1371constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1381toStringimpl(long j5) {
        if (j5 == 9205357640488583168L) {
            return "Size.Unspecified";
        }
        return "Size(" + GeometryUtilsKt.toStringAsFixed(m1377getWidthimpl(j5), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m1375getHeightimpl(j5), 1) + ')';
    }

    public boolean equals(Object obj) {
        return m1373equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1378hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m1381toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }
}
