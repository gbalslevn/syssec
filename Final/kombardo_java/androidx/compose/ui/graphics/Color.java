package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0087@\u0018\u0000 02\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ=\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u001a\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001f\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010\u0007\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u001a\u0010\r\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010&\u001a\u0004\b'\u0010(R\u001a\u0010\u000e\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010&\u001a\u0004\b*\u0010(R\u001a\u0010\u000f\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u0010&\u001a\u0004\b,\u0010(R\u001a\u0010\f\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010&\u001a\u0004\b.\u0010(\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"Landroidx/compose/ui/graphics/Color;", BuildConfig.FLAVOR, "Lkotlin/ULong;", "value", "constructor-impl", "(J)J", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "colorSpace", "convert-vNxB06k", "(JLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "convert", BuildConfig.FLAVOR, "alpha", "red", "green", "blue", "copy-wmQWz5c", "(JFFFF)J", "copy", BuildConfig.FLAVOR, "toString-impl", "(J)Ljava/lang/String;", "toString", BuildConfig.FLAVOR, "hashCode-impl", "(J)I", "hashCode", "other", BuildConfig.FLAVOR, "equals-impl", "(JLjava/lang/Object;)Z", "equals", "J", "getValue-s-VKNKU", "()J", "getColorSpace-impl", "(J)Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpace$annotations", "()V", "getRed-impl", "(J)F", "getRed$annotations", "getGreen-impl", "getGreen$annotations", "getBlue-impl", "getBlue$annotations", "getAlpha-impl", "getAlpha$annotations", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Color {
    private final long value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Black = ColorKt.Color(4278190080L);
    private static final long DarkGray = ColorKt.Color(4282664004L);
    private static final long Gray = ColorKt.Color(4287137928L);
    private static final long LightGray = ColorKt.Color(4291611852L);
    private static final long White = ColorKt.Color(4294967295L);
    private static final long Red = ColorKt.Color(4294901760L);
    private static final long Green = ColorKt.Color(4278255360L);
    private static final long Blue = ColorKt.Color(4278190335L);
    private static final long Yellow = ColorKt.Color(4294967040L);
    private static final long Cyan = ColorKt.Color(4278255615L);
    private static final long Magenta = ColorKt.Color(4294902015L);
    private static final long Transparent = ColorKt.Color(0);
    private static final long Unspecified = ColorKt.Color(0.0f, 0.0f, 0.0f, 0.0f, ColorSpaces.INSTANCE.getUnspecified$ui_graphics_release());

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR&\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\n\u0010\u0006\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\u000b\u0010\bR&\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u000e\u0010\bR&\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0011\u0010\bR&\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0014\u0010\bR&\u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0016\u0010\u0006\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0017\u0010\bR&\u0010\u0019\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0019\u0010\u0006\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001a\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/graphics/Color$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/graphics/Color;", "Black", "J", "getBlack-0d7_KjU", "()J", "getBlack-0d7_KjU$annotations", "DarkGray", "getDarkGray-0d7_KjU", "getDarkGray-0d7_KjU$annotations", "White", "getWhite-0d7_KjU", "getWhite-0d7_KjU$annotations", "Red", "getRed-0d7_KjU", "getRed-0d7_KjU$annotations", "Blue", "getBlue-0d7_KjU", "getBlue-0d7_KjU$annotations", "Transparent", "getTransparent-0d7_KjU", "getTransparent-0d7_KjU$annotations", "Unspecified", "getUnspecified-0d7_KjU", "getUnspecified-0d7_KjU$annotations", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getBlack-0d7_KjU, reason: not valid java name */
        public final long m1496getBlack0d7_KjU() {
            return Color.Black;
        }

        /* renamed from: getBlue-0d7_KjU, reason: not valid java name */
        public final long m1497getBlue0d7_KjU() {
            return Color.Blue;
        }

        /* renamed from: getDarkGray-0d7_KjU, reason: not valid java name */
        public final long m1498getDarkGray0d7_KjU() {
            return Color.DarkGray;
        }

        /* renamed from: getRed-0d7_KjU, reason: not valid java name */
        public final long m1499getRed0d7_KjU() {
            return Color.Red;
        }

        /* renamed from: getTransparent-0d7_KjU, reason: not valid java name */
        public final long m1500getTransparent0d7_KjU() {
            return Color.Transparent;
        }

        /* renamed from: getUnspecified-0d7_KjU, reason: not valid java name */
        public final long m1501getUnspecified0d7_KjU() {
            return Color.Unspecified;
        }

        /* renamed from: getWhite-0d7_KjU, reason: not valid java name */
        public final long m1502getWhite0d7_KjU() {
            return Color.White;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Color(long j5) {
        this.value = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Color m1481boximpl(long j5) {
        return new Color(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1482constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: convert-vNxB06k, reason: not valid java name */
    public static final long m1483convertvNxB06k(long j5, ColorSpace colorSpace) {
        return ColorSpaceKt.m1648connectYBCOT_4$default(m1490getColorSpaceimpl(j5), colorSpace, 0, 2, null).mo1650transformToColorl2rxGTc$ui_graphics_release(j5);
    }

    /* renamed from: copy-wmQWz5c, reason: not valid java name */
    public static final long m1484copywmQWz5c(long j5, float f5, float f6, float f7, float f8) {
        return ColorKt.Color(f6, f7, f8, f5, m1490getColorSpaceimpl(j5));
    }

    /* renamed from: copy-wmQWz5c$default, reason: not valid java name */
    public static /* synthetic */ long m1485copywmQWz5c$default(long j5, float f5, float f6, float f7, float f8, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = m1488getAlphaimpl(j5);
        }
        float f9 = f5;
        if ((i5 & 2) != 0) {
            f6 = m1492getRedimpl(j5);
        }
        float f10 = f6;
        if ((i5 & 4) != 0) {
            f7 = m1491getGreenimpl(j5);
        }
        float f11 = f7;
        if ((i5 & 8) != 0) {
            f8 = m1489getBlueimpl(j5);
        }
        return m1484copywmQWz5c(j5, f9, f10, f11, f8);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1486equalsimpl(long j5, Object obj) {
        return (obj instanceof Color) && j5 == ((Color) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1487equalsimpl0(long j5, long j6) {
        return ULong.m3624equalsimpl0(j5, j6);
    }

    /* renamed from: getAlpha-impl, reason: not valid java name */
    public static final float m1488getAlphaimpl(long j5) {
        float ulongToDouble;
        float f5;
        if (ULong.m3622constructorimpl(63 & j5) == 0) {
            ulongToDouble = (float) UnsignedKt.ulongToDouble(ULong.m3622constructorimpl(ULong.m3622constructorimpl(j5 >>> 56) & 255));
            f5 = 255.0f;
        } else {
            ulongToDouble = (float) UnsignedKt.ulongToDouble(ULong.m3622constructorimpl(ULong.m3622constructorimpl(j5 >>> 6) & 1023));
            f5 = 1023.0f;
        }
        return ulongToDouble / f5;
    }

    /* renamed from: getBlue-impl, reason: not valid java name */
    public static final float m1489getBlueimpl(long j5) {
        int i5;
        int i6;
        int i7;
        float f5;
        if (ULong.m3622constructorimpl(63 & j5) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m3622constructorimpl(ULong.m3622constructorimpl(j5 >>> 32) & 255))) / 255.0f;
        }
        short m3622constructorimpl = (short) ULong.m3622constructorimpl(ULong.m3622constructorimpl(j5 >>> 16) & 65535);
        int i8 = 32768 & m3622constructorimpl;
        int i9 = ((65535 & m3622constructorimpl) >>> 10) & 31;
        int i10 = m3622constructorimpl & 1023;
        if (i9 != 0) {
            int i11 = i10 << 13;
            if (i9 == 31) {
                i5 = Function.USE_VARARGS;
                if (i11 != 0) {
                    i11 |= 4194304;
                }
            } else {
                i5 = i9 + 112;
            }
            int i12 = i5;
            i6 = i11;
            i7 = i12;
        } else {
            if (i10 != 0) {
                float intBitsToFloat = Float.intBitsToFloat(i10 + 1056964608);
                f5 = Float16Kt.Fp32DenormalFloat;
                float f6 = intBitsToFloat - f5;
                return i8 == 0 ? f6 : -f6;
            }
            i7 = 0;
            i6 = 0;
        }
        return Float.intBitsToFloat((i7 << 23) | (i8 << 16) | i6);
    }

    /* renamed from: getColorSpace-impl, reason: not valid java name */
    public static final ColorSpace m1490getColorSpaceimpl(long j5) {
        ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
        return colorSpaces.getColorSpacesArray$ui_graphics_release()[(int) ULong.m3622constructorimpl(j5 & 63)];
    }

    /* renamed from: getGreen-impl, reason: not valid java name */
    public static final float m1491getGreenimpl(long j5) {
        int i5;
        int i6;
        int i7;
        float f5;
        if (ULong.m3622constructorimpl(63 & j5) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m3622constructorimpl(ULong.m3622constructorimpl(j5 >>> 40) & 255))) / 255.0f;
        }
        short m3622constructorimpl = (short) ULong.m3622constructorimpl(ULong.m3622constructorimpl(j5 >>> 32) & 65535);
        int i8 = 32768 & m3622constructorimpl;
        int i9 = ((65535 & m3622constructorimpl) >>> 10) & 31;
        int i10 = m3622constructorimpl & 1023;
        if (i9 != 0) {
            int i11 = i10 << 13;
            if (i9 == 31) {
                i5 = Function.USE_VARARGS;
                if (i11 != 0) {
                    i11 |= 4194304;
                }
            } else {
                i5 = i9 + 112;
            }
            int i12 = i5;
            i6 = i11;
            i7 = i12;
        } else {
            if (i10 != 0) {
                float intBitsToFloat = Float.intBitsToFloat(i10 + 1056964608);
                f5 = Float16Kt.Fp32DenormalFloat;
                float f6 = intBitsToFloat - f5;
                return i8 == 0 ? f6 : -f6;
            }
            i7 = 0;
            i6 = 0;
        }
        return Float.intBitsToFloat((i7 << 23) | (i8 << 16) | i6);
    }

    /* renamed from: getRed-impl, reason: not valid java name */
    public static final float m1492getRedimpl(long j5) {
        int i5;
        int i6;
        int i7;
        float f5;
        if (ULong.m3622constructorimpl(63 & j5) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m3622constructorimpl(ULong.m3622constructorimpl(j5 >>> 48) & 255))) / 255.0f;
        }
        short m3622constructorimpl = (short) ULong.m3622constructorimpl(ULong.m3622constructorimpl(j5 >>> 48) & 65535);
        int i8 = 32768 & m3622constructorimpl;
        int i9 = ((65535 & m3622constructorimpl) >>> 10) & 31;
        int i10 = m3622constructorimpl & 1023;
        if (i9 != 0) {
            int i11 = i10 << 13;
            if (i9 == 31) {
                i5 = Function.USE_VARARGS;
                if (i11 != 0) {
                    i11 |= 4194304;
                }
            } else {
                i5 = i9 + 112;
            }
            int i12 = i5;
            i6 = i11;
            i7 = i12;
        } else {
            if (i10 != 0) {
                float intBitsToFloat = Float.intBitsToFloat(i10 + 1056964608);
                f5 = Float16Kt.Fp32DenormalFloat;
                float f6 = intBitsToFloat - f5;
                return i8 == 0 ? f6 : -f6;
            }
            i7 = 0;
            i6 = 0;
        }
        return Float.intBitsToFloat((i7 << 23) | (i8 << 16) | i6);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1493hashCodeimpl(long j5) {
        return ULong.m3625hashCodeimpl(j5);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1494toStringimpl(long j5) {
        return "Color(" + m1492getRedimpl(j5) + ", " + m1491getGreenimpl(j5) + ", " + m1489getBlueimpl(j5) + ", " + m1488getAlphaimpl(j5) + ", " + m1490getColorSpaceimpl(j5).getName() + ')';
    }

    public boolean equals(Object obj) {
        return m1486equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1493hashCodeimpl(this.value);
    }

    public String toString() {
        return m1494toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getValue() {
        return this.value;
    }
}
