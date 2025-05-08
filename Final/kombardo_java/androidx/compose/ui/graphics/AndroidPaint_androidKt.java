package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u000f\u0010\u0006\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\"\u0010\u000e\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\u0006\u0010\n\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a!\u0010\u0011\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0014\u001a\u00020\u0013*\u00060\u0003j\u0002`\bH\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u0016\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\u0006\u0010\u0010\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0017\u0010\u0019\u001a\u00020\u0018*\u00060\u0003j\u0002`\bH\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\"\u0010\u001d\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\u0006\u0010\u0010\u001a\u00020\u0018H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\"\u0010 \u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\u0006\u0010\u0010\u001a\u00020\u001eH\u0000ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\r\u001a\u0017\u0010!\u001a\u00020\u0013*\u00060\u0003j\u0002`\bH\u0000¢\u0006\u0004\b!\u0010\u0015\u001a\u001f\u0010\"\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\u0006\u0010\u0010\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\"\u0010\u0017\u001a\u0017\u0010$\u001a\u00020#*\u00060\u0003j\u0002`\bH\u0000¢\u0006\u0004\b$\u0010%\u001a\"\u0010'\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\u0006\u0010\u0010\u001a\u00020#H\u0000ø\u0001\u0000¢\u0006\u0004\b&\u0010\r\u001a\u0017\u0010)\u001a\u00020(*\u00060\u0003j\u0002`\bH\u0000¢\u0006\u0004\b)\u0010%\u001a\"\u0010+\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\u0006\u0010\u0010\u001a\u00020(H\u0000ø\u0001\u0000¢\u0006\u0004\b*\u0010\r\u001a\u0017\u0010,\u001a\u00020\u0013*\u00060\u0003j\u0002`\bH\u0000¢\u0006\u0004\b,\u0010\u0015\u001a\u001f\u0010-\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\u0006\u0010\u0010\u001a\u00020\u0013H\u0000¢\u0006\u0004\b-\u0010\u0017\u001a\u0017\u0010/\u001a\u00020.*\u00060\u0003j\u0002`\bH\u0000¢\u0006\u0004\b/\u0010%\u001a\"\u00101\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\u0006\u0010\u0010\u001a\u00020.H\u0000ø\u0001\u0000¢\u0006\u0004\b0\u0010\r\u001a'\u00104\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\u000e\u0010\u0010\u001a\n\u0018\u000102j\u0004\u0018\u0001`3H\u0000¢\u0006\u0004\b4\u00105\u001a!\u00107\u001a\u00020\u000b*\u00060\u0003j\u0002`\b2\b\u0010\u0010\u001a\u0004\u0018\u000106H\u0000¢\u0006\u0004\b7\u00108*\n\u00109\"\u00020\u00032\u00020\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006:"}, d2 = {"Landroidx/compose/ui/graphics/Paint;", "Paint", "()Landroidx/compose/ui/graphics/Paint;", "Landroid/graphics/Paint;", "asComposePaint", "(Landroid/graphics/Paint;)Landroidx/compose/ui/graphics/Paint;", "makeNativePaint", "()Landroid/graphics/Paint;", "Landroidx/compose/ui/graphics/NativePaint;", "Landroidx/compose/ui/graphics/BlendMode;", "mode", BuildConfig.FLAVOR, "setNativeBlendMode-GB0RdKg", "(Landroid/graphics/Paint;I)V", "setNativeBlendMode", "Landroidx/compose/ui/graphics/ColorFilter;", "value", "setNativeColorFilter", "(Landroid/graphics/Paint;Landroidx/compose/ui/graphics/ColorFilter;)V", BuildConfig.FLAVOR, "getNativeAlpha", "(Landroid/graphics/Paint;)F", "setNativeAlpha", "(Landroid/graphics/Paint;F)V", "Landroidx/compose/ui/graphics/Color;", "getNativeColor", "(Landroid/graphics/Paint;)J", "setNativeColor-4WTKRHQ", "(Landroid/graphics/Paint;J)V", "setNativeColor", "Landroidx/compose/ui/graphics/PaintingStyle;", "setNativeStyle--5YerkU", "setNativeStyle", "getNativeStrokeWidth", "setNativeStrokeWidth", "Landroidx/compose/ui/graphics/StrokeCap;", "getNativeStrokeCap", "(Landroid/graphics/Paint;)I", "setNativeStrokeCap-CSYIeUk", "setNativeStrokeCap", "Landroidx/compose/ui/graphics/StrokeJoin;", "getNativeStrokeJoin", "setNativeStrokeJoin-kLtJ_vA", "setNativeStrokeJoin", "getNativeStrokeMiterLimit", "setNativeStrokeMiterLimit", "Landroidx/compose/ui/graphics/FilterQuality;", "getNativeFilterQuality", "setNativeFilterQuality-50PEsBU", "setNativeFilterQuality", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "setNativeShader", "(Landroid/graphics/Paint;Landroid/graphics/Shader;)V", "Landroidx/compose/ui/graphics/PathEffect;", "setNativePathEffect", "(Landroid/graphics/Paint;Landroidx/compose/ui/graphics/PathEffect;)V", "NativePaint", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidPaint_androidKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[Paint.Style.values().length];
            try {
                iArr[Paint.Style.STROKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Paint.Cap.values().length];
            try {
                iArr2[Paint.Cap.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[Paint.Cap.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Paint.Cap.SQUARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[Paint.Join.values().length];
            try {
                iArr3[Paint.Join.MITER.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[Paint.Join.BEVEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[Paint.Join.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final Paint Paint() {
        return new AndroidPaint();
    }

    public static final Paint asComposePaint(android.graphics.Paint paint) {
        return new AndroidPaint(paint);
    }

    public static final float getNativeAlpha(android.graphics.Paint paint) {
        return paint.getAlpha() / 255.0f;
    }

    public static final long getNativeColor(android.graphics.Paint paint) {
        return ColorKt.Color(paint.getColor());
    }

    public static final int getNativeFilterQuality(android.graphics.Paint paint) {
        return !paint.isFilterBitmap() ? FilterQuality.INSTANCE.m1521getNonefv9h1I() : FilterQuality.INSTANCE.m1520getLowfv9h1I();
    }

    public static final int getNativeStrokeCap(android.graphics.Paint paint) {
        Paint.Cap strokeCap = paint.getStrokeCap();
        int i5 = strokeCap == null ? -1 : WhenMappings.$EnumSwitchMapping$1[strokeCap.ordinal()];
        return i5 != 1 ? i5 != 2 ? i5 != 3 ? StrokeCap.INSTANCE.m1607getButtKaPHkGw() : StrokeCap.INSTANCE.m1609getSquareKaPHkGw() : StrokeCap.INSTANCE.m1608getRoundKaPHkGw() : StrokeCap.INSTANCE.m1607getButtKaPHkGw();
    }

    public static final int getNativeStrokeJoin(android.graphics.Paint paint) {
        Paint.Join strokeJoin = paint.getStrokeJoin();
        int i5 = strokeJoin == null ? -1 : WhenMappings.$EnumSwitchMapping$2[strokeJoin.ordinal()];
        return i5 != 1 ? i5 != 2 ? i5 != 3 ? StrokeJoin.INSTANCE.m1615getMiterLxFBmk8() : StrokeJoin.INSTANCE.m1616getRoundLxFBmk8() : StrokeJoin.INSTANCE.m1614getBevelLxFBmk8() : StrokeJoin.INSTANCE.m1615getMiterLxFBmk8();
    }

    public static final float getNativeStrokeMiterLimit(android.graphics.Paint paint) {
        return paint.getStrokeMiter();
    }

    public static final float getNativeStrokeWidth(android.graphics.Paint paint) {
        return paint.getStrokeWidth();
    }

    public static final android.graphics.Paint makeNativePaint() {
        return new android.graphics.Paint(7);
    }

    public static final void setNativeAlpha(android.graphics.Paint paint, float f5) {
        paint.setAlpha((int) Math.rint(f5 * 255.0f));
    }

    /* renamed from: setNativeBlendMode-GB0RdKg, reason: not valid java name */
    public static final void m1414setNativeBlendModeGB0RdKg(android.graphics.Paint paint, int i5) {
        if (Build.VERSION.SDK_INT >= 29) {
            WrapperVerificationHelperMethods.INSTANCE.m1636setBlendModeGB0RdKg(paint, i5);
        } else {
            paint.setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m1388toPorterDuffModes9anfk8(i5)));
        }
    }

    /* renamed from: setNativeColor-4WTKRHQ, reason: not valid java name */
    public static final void m1415setNativeColor4WTKRHQ(android.graphics.Paint paint, long j5) {
        paint.setColor(ColorKt.m1508toArgb8_81llA(j5));
    }

    public static final void setNativeColorFilter(android.graphics.Paint paint, ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter != null ? AndroidColorFilter_androidKt.asAndroidColorFilter(colorFilter) : null);
    }

    /* renamed from: setNativeFilterQuality-50PEsBU, reason: not valid java name */
    public static final void m1416setNativeFilterQuality50PEsBU(android.graphics.Paint paint, int i5) {
        paint.setFilterBitmap(!FilterQuality.m1517equalsimpl0(i5, FilterQuality.INSTANCE.m1521getNonefv9h1I()));
    }

    public static final void setNativePathEffect(android.graphics.Paint paint, PathEffect pathEffect) {
        AndroidPathEffect androidPathEffect = (AndroidPathEffect) pathEffect;
        paint.setPathEffect(androidPathEffect != null ? androidPathEffect.getNativePathEffect() : null);
    }

    public static final void setNativeShader(android.graphics.Paint paint, Shader shader) {
        paint.setShader(shader);
    }

    /* renamed from: setNativeStrokeCap-CSYIeUk, reason: not valid java name */
    public static final void m1417setNativeStrokeCapCSYIeUk(android.graphics.Paint paint, int i5) {
        StrokeCap.Companion companion = StrokeCap.INSTANCE;
        paint.setStrokeCap(StrokeCap.m1604equalsimpl0(i5, companion.m1609getSquareKaPHkGw()) ? Paint.Cap.SQUARE : StrokeCap.m1604equalsimpl0(i5, companion.m1608getRoundKaPHkGw()) ? Paint.Cap.ROUND : StrokeCap.m1604equalsimpl0(i5, companion.m1607getButtKaPHkGw()) ? Paint.Cap.BUTT : Paint.Cap.BUTT);
    }

    /* renamed from: setNativeStrokeJoin-kLtJ_vA, reason: not valid java name */
    public static final void m1418setNativeStrokeJoinkLtJ_vA(android.graphics.Paint paint, int i5) {
        StrokeJoin.Companion companion = StrokeJoin.INSTANCE;
        paint.setStrokeJoin(StrokeJoin.m1611equalsimpl0(i5, companion.m1615getMiterLxFBmk8()) ? Paint.Join.MITER : StrokeJoin.m1611equalsimpl0(i5, companion.m1614getBevelLxFBmk8()) ? Paint.Join.BEVEL : StrokeJoin.m1611equalsimpl0(i5, companion.m1616getRoundLxFBmk8()) ? Paint.Join.ROUND : Paint.Join.MITER);
    }

    public static final void setNativeStrokeMiterLimit(android.graphics.Paint paint, float f5) {
        paint.setStrokeMiter(f5);
    }

    public static final void setNativeStrokeWidth(android.graphics.Paint paint, float f5) {
        paint.setStrokeWidth(f5);
    }

    /* renamed from: setNativeStyle--5YerkU, reason: not valid java name */
    public static final void m1419setNativeStyle5YerkU(android.graphics.Paint paint, int i5) {
        paint.setStyle(PaintingStyle.m1571equalsimpl0(i5, PaintingStyle.INSTANCE.m1573getStrokeTiuSbCo()) ? Paint.Style.STROKE : Paint.Style.FILL);
    }
}
