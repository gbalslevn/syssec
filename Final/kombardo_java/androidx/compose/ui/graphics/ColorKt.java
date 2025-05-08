package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\u001a;\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a;\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\n\u0010\t\u001a\u0019\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\b\u0010\r\u001a\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\b\u0010\u000f\u001a7\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0001\u001a\u00020\u000b2\b\b\u0001\u0010\u0002\u001a\u00020\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u000b2\b\b\u0003\u0010\u0004\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\b\u0010\u0010\u001a,\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0001\u0010\u0013\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001e\u0010\u001a\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0016\u0010\u001d\u001a\u00020\u0000*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0016\u0010 \u001a\u00020\u000b*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {BuildConfig.FLAVOR, "red", "green", "blue", "alpha", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "colorSpace", "Landroidx/compose/ui/graphics/Color;", "Color", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "UncheckedColor", BuildConfig.FLAVOR, "color", "(I)J", BuildConfig.FLAVOR, "(J)J", "(IIII)J", "start", "stop", "fraction", "lerp-jxsXWHM", "(JJF)J", "lerp", "background", "compositeOver--OWjLjI", "(JJ)J", "compositeOver", "luminance-8_81llA", "(J)F", "luminance", "toArgb-8_81llA", "(J)I", "toArgb", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ColorKt {
    /* JADX WARN: Removed duplicated region for block: B:106:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long Color(float f5, float f6, float f7, float f8, ColorSpace colorSpace) {
        int i5;
        int i6;
        int i7;
        float minValue;
        float maxValue;
        int i8;
        int i9;
        int i10;
        int i11;
        float minValue2;
        float maxValue2;
        int i12;
        int i13;
        int i14;
        if (colorSpace.getIsSrgb()) {
            float f9 = f8 < 0.0f ? 0.0f : f8;
            if (f9 > 1.0f) {
                f9 = 1.0f;
            }
            int i15 = ((int) ((f9 * 255.0f) + 0.5f)) << 24;
            float f10 = f5 < 0.0f ? 0.0f : f5;
            if (f10 > 1.0f) {
                f10 = 1.0f;
            }
            int i16 = i15 | (((int) ((f10 * 255.0f) + 0.5f)) << 16);
            float f11 = f6 < 0.0f ? 0.0f : f6;
            if (f11 > 1.0f) {
                f11 = 1.0f;
            }
            int i17 = i16 | (((int) ((f11 * 255.0f) + 0.5f)) << 8);
            return Color.m1482constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(i17 | ((int) ((((f7 >= 0.0f ? f7 : 0.0f) <= 1.0f ? r5 : 1.0f) * 255.0f) + 0.5f))) << 32));
        }
        if (!(colorSpace.getComponentCount() == 3)) {
            InlineClassHelperKt.throwIllegalArgumentException("Color only works with ColorSpaces with 3 components");
        }
        int id = colorSpace.getId();
        if (!(id != -1)) {
            InlineClassHelperKt.throwIllegalArgumentException("Unknown color space, please use a color space in ColorSpaces");
        }
        float minValue3 = colorSpace.getMinValue(0);
        float maxValue3 = colorSpace.getMaxValue(0);
        if (f5 >= minValue3) {
            minValue3 = f5;
        }
        if (minValue3 <= maxValue3) {
            maxValue3 = minValue3;
        }
        int floatToRawIntBits = Float.floatToRawIntBits(maxValue3);
        int i18 = floatToRawIntBits >>> 31;
        int i19 = (floatToRawIntBits >>> 23) & Function.USE_VARARGS;
        int i20 = floatToRawIntBits & 8388607;
        int i21 = 31;
        if (i19 == 255) {
            i6 = i20 != 0 ? 512 : 0;
            i5 = 31;
        } else {
            i5 = i19 - 112;
            if (i5 >= 31) {
                i5 = 49;
                i6 = 0;
            } else if (i5 <= 0) {
                if (i5 >= -10) {
                    int i22 = (i20 | 8388608) >> (1 - i5);
                    if ((i22 & 4096) != 0) {
                        i22 += 8192;
                    }
                    i6 = i22 >> 13;
                } else {
                    i6 = 0;
                }
                i5 = 0;
            } else {
                int i23 = i20 >> 13;
                if ((floatToRawIntBits & 4096) != 0) {
                    i7 = (((i5 << 10) | i23) + 1) | (i18 << 15);
                    short s5 = (short) i7;
                    minValue = colorSpace.getMinValue(1);
                    maxValue = colorSpace.getMaxValue(1);
                    if (f6 >= minValue) {
                        minValue = f6;
                    }
                    if (minValue <= maxValue) {
                        maxValue = minValue;
                    }
                    int floatToRawIntBits2 = Float.floatToRawIntBits(maxValue);
                    int i24 = floatToRawIntBits2 >>> 31;
                    i8 = (floatToRawIntBits2 >>> 23) & Function.USE_VARARGS;
                    int i25 = floatToRawIntBits2 & 8388607;
                    if (i8 != 255) {
                        i10 = i25 != 0 ? 512 : 0;
                        i9 = 31;
                    } else {
                        i9 = i8 - 112;
                        if (i9 >= 31) {
                            i9 = 49;
                            i10 = 0;
                        } else if (i9 <= 0) {
                            if (i9 >= -10) {
                                int i26 = (i25 | 8388608) >> (1 - i9);
                                if ((i26 & 4096) != 0) {
                                    i26 += 8192;
                                }
                                i10 = i26 >> 13;
                            } else {
                                i10 = 0;
                            }
                            i9 = 0;
                        } else {
                            int i27 = i25 >> 13;
                            if ((floatToRawIntBits2 & 4096) != 0) {
                                i11 = (((i9 << 10) | i27) + 1) | (i24 << 15);
                                short s6 = (short) i11;
                                minValue2 = colorSpace.getMinValue(2);
                                maxValue2 = colorSpace.getMaxValue(2);
                                if (f7 >= minValue2) {
                                    minValue2 = f7;
                                }
                                if (minValue2 <= maxValue2) {
                                    maxValue2 = minValue2;
                                }
                                int floatToRawIntBits3 = Float.floatToRawIntBits(maxValue2);
                                int i28 = floatToRawIntBits3 >>> 31;
                                i12 = (floatToRawIntBits3 >>> 23) & Function.USE_VARARGS;
                                int i29 = 8388607 & floatToRawIntBits3;
                                if (i12 == 255) {
                                    i13 = i29 == 0 ? 0 : 512;
                                } else {
                                    int i30 = i12 - 112;
                                    if (i30 >= 31) {
                                        i21 = 49;
                                    } else if (i30 > 0) {
                                        int i31 = i29 >> 13;
                                        if ((floatToRawIntBits3 & 4096) != 0) {
                                            i14 = (((i30 << 10) | i31) + 1) | (i28 << 15);
                                            short s7 = (short) i14;
                                            return Color.m1482constructorimpl(ULong.m3622constructorimpl((id & 63) | ((((int) ((((f8 >= 0.0f ? f8 : 0.0f) <= 1.0f ? r5 : 1.0f) * 1023.0f) + 0.5f)) & 1023) << 6) | ((s5 & 65535) << 48) | ((s6 & 65535) << 32) | ((65535 & s7) << 16)));
                                        }
                                        i13 = i31;
                                        i21 = i30;
                                    } else if (i30 >= -10) {
                                        int i32 = (i29 | 8388608) >> (1 - i30);
                                        if ((i32 & 4096) != 0) {
                                            i32 += 8192;
                                        }
                                        i13 = i32 >> 13;
                                        i21 = 0;
                                    } else {
                                        i21 = 0;
                                    }
                                    i13 = 0;
                                }
                                i14 = (i28 << 15) | (i21 << 10) | i13;
                                short s72 = (short) i14;
                                if (f8 >= 0.0f) {
                                }
                                return Color.m1482constructorimpl(ULong.m3622constructorimpl((id & 63) | ((((int) ((((f8 >= 0.0f ? f8 : 0.0f) <= 1.0f ? r5 : 1.0f) * 1023.0f) + 0.5f)) & 1023) << 6) | ((s5 & 65535) << 48) | ((s6 & 65535) << 32) | ((65535 & s72) << 16)));
                            }
                            i10 = i27;
                        }
                    }
                    i11 = i10 | (i24 << 15) | (i9 << 10);
                    short s62 = (short) i11;
                    minValue2 = colorSpace.getMinValue(2);
                    maxValue2 = colorSpace.getMaxValue(2);
                    if (f7 >= minValue2) {
                    }
                    if (minValue2 <= maxValue2) {
                    }
                    int floatToRawIntBits32 = Float.floatToRawIntBits(maxValue2);
                    int i282 = floatToRawIntBits32 >>> 31;
                    i12 = (floatToRawIntBits32 >>> 23) & Function.USE_VARARGS;
                    int i292 = 8388607 & floatToRawIntBits32;
                    if (i12 == 255) {
                    }
                    i14 = (i282 << 15) | (i21 << 10) | i13;
                    short s722 = (short) i14;
                    if (f8 >= 0.0f) {
                    }
                    return Color.m1482constructorimpl(ULong.m3622constructorimpl((id & 63) | ((((int) ((((f8 >= 0.0f ? f8 : 0.0f) <= 1.0f ? r5 : 1.0f) * 1023.0f) + 0.5f)) & 1023) << 6) | ((s5 & 65535) << 48) | ((s62 & 65535) << 32) | ((65535 & s722) << 16)));
                }
                i6 = i23;
            }
        }
        i7 = i6 | (i18 << 15) | (i5 << 10);
        short s52 = (short) i7;
        minValue = colorSpace.getMinValue(1);
        maxValue = colorSpace.getMaxValue(1);
        if (f6 >= minValue) {
        }
        if (minValue <= maxValue) {
        }
        int floatToRawIntBits22 = Float.floatToRawIntBits(maxValue);
        int i242 = floatToRawIntBits22 >>> 31;
        i8 = (floatToRawIntBits22 >>> 23) & Function.USE_VARARGS;
        int i252 = floatToRawIntBits22 & 8388607;
        if (i8 != 255) {
        }
        i11 = i10 | (i242 << 15) | (i9 << 10);
        short s622 = (short) i11;
        minValue2 = colorSpace.getMinValue(2);
        maxValue2 = colorSpace.getMaxValue(2);
        if (f7 >= minValue2) {
        }
        if (minValue2 <= maxValue2) {
        }
        int floatToRawIntBits322 = Float.floatToRawIntBits(maxValue2);
        int i2822 = floatToRawIntBits322 >>> 31;
        i12 = (floatToRawIntBits322 >>> 23) & Function.USE_VARARGS;
        int i2922 = 8388607 & floatToRawIntBits322;
        if (i12 == 255) {
        }
        i14 = (i2822 << 15) | (i21 << 10) | i13;
        short s7222 = (short) i14;
        if (f8 >= 0.0f) {
        }
        return Color.m1482constructorimpl(ULong.m3622constructorimpl((id & 63) | ((((int) ((((f8 >= 0.0f ? f8 : 0.0f) <= 1.0f ? r5 : 1.0f) * 1023.0f) + 0.5f)) & 1023) << 6) | ((s52 & 65535) << 48) | ((s622 & 65535) << 32) | ((65535 & s7222) << 16)));
    }

    public static /* synthetic */ long Color$default(float f5, float f6, float f7, float f8, ColorSpace colorSpace, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            f8 = 1.0f;
        }
        if ((i5 & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f5, f6, f7, f8, colorSpace);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long UncheckedColor(float f5, float f6, float f7, float f8, ColorSpace colorSpace) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        if (colorSpace.getIsSrgb()) {
            return Color.m1482constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl((((((int) ((f8 * 255.0f) + 0.5f)) << 24) | (((int) ((f5 * 255.0f) + 0.5f)) << 16)) | (((int) ((f6 * 255.0f) + 0.5f)) << 8)) | ((int) ((255.0f * f7) + 0.5f))) << 32));
        }
        int floatToRawIntBits = Float.floatToRawIntBits(f5);
        int i15 = floatToRawIntBits >>> 31;
        int i16 = (floatToRawIntBits >>> 23) & Function.USE_VARARGS;
        int i17 = floatToRawIntBits & 8388607;
        int i18 = 0;
        if (i16 == 255) {
            i6 = i17 != 0 ? 512 : 0;
            i5 = 31;
        } else {
            i5 = i16 - 112;
            if (i5 >= 31) {
                i6 = 0;
                i5 = 49;
            } else if (i5 > 0) {
                int i19 = i17 >> 13;
                if ((floatToRawIntBits & 4096) != 0) {
                    i7 = (((i5 << 10) | i19) + 1) | (i15 << 15);
                    short s5 = (short) i7;
                    int floatToRawIntBits2 = Float.floatToRawIntBits(f6);
                    int i20 = floatToRawIntBits2 >>> 31;
                    i8 = (floatToRawIntBits2 >>> 23) & Function.USE_VARARGS;
                    int i21 = floatToRawIntBits2 & 8388607;
                    if (i8 != 255) {
                        i10 = i21 != 0 ? 512 : 0;
                        i9 = 31;
                    } else {
                        i9 = i8 - 112;
                        if (i9 >= 31) {
                            i10 = 0;
                            i9 = 49;
                        } else if (i9 > 0) {
                            int i22 = i21 >> 13;
                            if ((floatToRawIntBits2 & 4096) != 0) {
                                i11 = (((i9 << 10) | i22) + 1) | (i20 << 15);
                                short s6 = (short) i11;
                                int floatToRawIntBits3 = Float.floatToRawIntBits(f7);
                                int i23 = floatToRawIntBits3 >>> 31;
                                i12 = (floatToRawIntBits3 >>> 23) & Function.USE_VARARGS;
                                int i24 = 8388607 & floatToRawIntBits3;
                                if (i12 == 255) {
                                    i18 = i24 == 0 ? 0 : 512;
                                    i13 = 31;
                                } else {
                                    i13 = i12 - 112;
                                    if (i13 >= 31) {
                                        i13 = 49;
                                    } else if (i13 > 0) {
                                        i18 = i24 >> 13;
                                        if ((floatToRawIntBits3 & 4096) != 0) {
                                            i14 = (((i13 << 10) | i18) + 1) | (i23 << 15);
                                            return Color.m1482constructorimpl(ULong.m3622constructorimpl(((s6 & 65535) << 32) | ((s5 & 65535) << 48) | ((((short) i14) & 65535) << 16) | ((((int) ((Math.max(0.0f, Math.min(f8, 1.0f)) * 1023.0f) + 0.5f)) & 1023) << 6) | (colorSpace.getId() & 63)));
                                        }
                                    } else if (i13 >= -10) {
                                        int i25 = (i24 | 8388608) >> (1 - i13);
                                        if ((i25 & 4096) != 0) {
                                            i25 += 8192;
                                        }
                                        i13 = 0;
                                        i18 = i25 >> 13;
                                    } else {
                                        i13 = 0;
                                    }
                                }
                                i14 = (i23 << 15) | (i13 << 10) | i18;
                                return Color.m1482constructorimpl(ULong.m3622constructorimpl(((s6 & 65535) << 32) | ((s5 & 65535) << 48) | ((((short) i14) & 65535) << 16) | ((((int) ((Math.max(0.0f, Math.min(f8, 1.0f)) * 1023.0f) + 0.5f)) & 1023) << 6) | (colorSpace.getId() & 63)));
                            }
                            i10 = i22;
                        } else if (i9 >= -10) {
                            int i26 = (i21 | 8388608) >> (1 - i9);
                            if ((i26 & 4096) != 0) {
                                i26 += 8192;
                            }
                            i10 = i26 >> 13;
                            i9 = 0;
                        } else {
                            i10 = 0;
                            i9 = 0;
                        }
                    }
                    i11 = i10 | (i20 << 15) | (i9 << 10);
                    short s62 = (short) i11;
                    int floatToRawIntBits32 = Float.floatToRawIntBits(f7);
                    int i232 = floatToRawIntBits32 >>> 31;
                    i12 = (floatToRawIntBits32 >>> 23) & Function.USE_VARARGS;
                    int i242 = 8388607 & floatToRawIntBits32;
                    if (i12 == 255) {
                    }
                    i14 = (i232 << 15) | (i13 << 10) | i18;
                    return Color.m1482constructorimpl(ULong.m3622constructorimpl(((s62 & 65535) << 32) | ((s5 & 65535) << 48) | ((((short) i14) & 65535) << 16) | ((((int) ((Math.max(0.0f, Math.min(f8, 1.0f)) * 1023.0f) + 0.5f)) & 1023) << 6) | (colorSpace.getId() & 63)));
                }
                i6 = i19;
            } else if (i5 >= -10) {
                int i27 = (i17 | 8388608) >> (1 - i5);
                if ((i27 & 4096) != 0) {
                    i27 += 8192;
                }
                i6 = i27 >> 13;
                i5 = 0;
            } else {
                i6 = 0;
                i5 = 0;
            }
        }
        i7 = i6 | (i15 << 15) | (i5 << 10);
        short s52 = (short) i7;
        int floatToRawIntBits22 = Float.floatToRawIntBits(f6);
        int i202 = floatToRawIntBits22 >>> 31;
        i8 = (floatToRawIntBits22 >>> 23) & Function.USE_VARARGS;
        int i212 = floatToRawIntBits22 & 8388607;
        if (i8 != 255) {
        }
        i11 = i10 | (i202 << 15) | (i9 << 10);
        short s622 = (short) i11;
        int floatToRawIntBits322 = Float.floatToRawIntBits(f7);
        int i2322 = floatToRawIntBits322 >>> 31;
        i12 = (floatToRawIntBits322 >>> 23) & Function.USE_VARARGS;
        int i2422 = 8388607 & floatToRawIntBits322;
        if (i12 == 255) {
        }
        i14 = (i2322 << 15) | (i13 << 10) | i18;
        return Color.m1482constructorimpl(ULong.m3622constructorimpl(((s622 & 65535) << 32) | ((s52 & 65535) << 48) | ((((short) i14) & 65535) << 16) | ((((int) ((Math.max(0.0f, Math.min(f8, 1.0f)) * 1023.0f) + 0.5f)) & 1023) << 6) | (colorSpace.getId() & 63)));
    }

    /* renamed from: compositeOver--OWjLjI, reason: not valid java name */
    public static final long m1505compositeOverOWjLjI(long j5, long j6) {
        long m1483convertvNxB06k = Color.m1483convertvNxB06k(j5, Color.m1490getColorSpaceimpl(j6));
        float m1488getAlphaimpl = Color.m1488getAlphaimpl(j6);
        float m1488getAlphaimpl2 = Color.m1488getAlphaimpl(m1483convertvNxB06k);
        float f5 = 1.0f - m1488getAlphaimpl2;
        float f6 = (m1488getAlphaimpl * f5) + m1488getAlphaimpl2;
        return UncheckedColor(f6 == 0.0f ? 0.0f : ((Color.m1492getRedimpl(m1483convertvNxB06k) * m1488getAlphaimpl2) + ((Color.m1492getRedimpl(j6) * m1488getAlphaimpl) * f5)) / f6, f6 == 0.0f ? 0.0f : ((Color.m1491getGreenimpl(m1483convertvNxB06k) * m1488getAlphaimpl2) + ((Color.m1491getGreenimpl(j6) * m1488getAlphaimpl) * f5)) / f6, f6 != 0.0f ? ((Color.m1489getBlueimpl(m1483convertvNxB06k) * m1488getAlphaimpl2) + ((Color.m1489getBlueimpl(j6) * m1488getAlphaimpl) * f5)) / f6 : 0.0f, f6, Color.m1490getColorSpaceimpl(j6));
    }

    /* renamed from: lerp-jxsXWHM, reason: not valid java name */
    public static final long m1506lerpjxsXWHM(long j5, long j6, float f5) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long m1483convertvNxB06k = Color.m1483convertvNxB06k(j5, oklab);
        long m1483convertvNxB06k2 = Color.m1483convertvNxB06k(j6, oklab);
        float m1488getAlphaimpl = Color.m1488getAlphaimpl(m1483convertvNxB06k);
        float m1492getRedimpl = Color.m1492getRedimpl(m1483convertvNxB06k);
        float m1491getGreenimpl = Color.m1491getGreenimpl(m1483convertvNxB06k);
        float m1489getBlueimpl = Color.m1489getBlueimpl(m1483convertvNxB06k);
        float m1488getAlphaimpl2 = Color.m1488getAlphaimpl(m1483convertvNxB06k2);
        float m1492getRedimpl2 = Color.m1492getRedimpl(m1483convertvNxB06k2);
        float m1491getGreenimpl2 = Color.m1491getGreenimpl(m1483convertvNxB06k2);
        float m1489getBlueimpl2 = Color.m1489getBlueimpl(m1483convertvNxB06k2);
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        return Color.m1483convertvNxB06k(UncheckedColor(MathHelpersKt.lerp(m1492getRedimpl, m1492getRedimpl2, f5), MathHelpersKt.lerp(m1491getGreenimpl, m1491getGreenimpl2, f5), MathHelpersKt.lerp(m1489getBlueimpl, m1489getBlueimpl2, f5), MathHelpersKt.lerp(m1488getAlphaimpl, m1488getAlphaimpl2, f5), oklab), Color.m1490getColorSpaceimpl(j6));
    }

    /* renamed from: luminance-8_81llA, reason: not valid java name */
    public static final float m1507luminance8_81llA(long j5) {
        ColorSpace m1490getColorSpaceimpl = Color.m1490getColorSpaceimpl(j5);
        if (!ColorModel.m1638equalsimpl0(m1490getColorSpaceimpl.getModel(), ColorModel.INSTANCE.m1643getRgbxdoWZVw())) {
            InlineClassHelperKt.throwIllegalArgumentException("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.m1641toStringimpl(m1490getColorSpaceimpl.getModel())));
        }
        Intrinsics.checkNotNull(m1490getColorSpaceimpl, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction eotfFunc = ((Rgb) m1490getColorSpaceimpl).getEotfFunc();
        float invoke = (float) ((eotfFunc.invoke(Color.m1492getRedimpl(j5)) * 0.2126d) + (eotfFunc.invoke(Color.m1491getGreenimpl(j5)) * 0.7152d) + (eotfFunc.invoke(Color.m1489getBlueimpl(j5)) * 0.0722d));
        if (invoke < 0.0f) {
            invoke = 0.0f;
        }
        if (invoke > 1.0f) {
            return 1.0f;
        }
        return invoke;
    }

    /* renamed from: toArgb-8_81llA, reason: not valid java name */
    public static final int m1508toArgb8_81llA(long j5) {
        return (int) ULong.m3622constructorimpl(Color.m1483convertvNxB06k(j5, ColorSpaces.INSTANCE.getSrgb()) >>> 32);
    }

    public static /* synthetic */ long Color$default(int i5, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 8) != 0) {
            i8 = Function.USE_VARARGS;
        }
        return Color(i5, i6, i7, i8);
    }

    public static final long Color(int i5) {
        return Color.m1482constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(i5) << 32));
    }

    public static final long Color(long j5) {
        return Color.m1482constructorimpl(ULong.m3622constructorimpl(j5 << 32));
    }

    public static final long Color(int i5, int i6, int i7, int i8) {
        return Color(((i5 & Function.USE_VARARGS) << 16) | ((i8 & Function.USE_VARARGS) << 24) | ((i6 & Function.USE_VARARGS) << 8) | (i7 & Function.USE_VARARGS));
    }
}
