package androidx.compose.ui.graphics;

import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a&\u0010\u000b\u001a\u00060\u0001j\u0002`\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n*\f\b\u0000\u0010\f\"\u00020\u00012\u00020\u0001\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"Landroidx/compose/ui/graphics/ColorFilter;", "Landroid/graphics/ColorFilter;", "asAndroidColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/Color;", "color", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "Landroidx/compose/ui/graphics/NativeColorFilter;", "actualTintColorFilter-xETnrds", "(JI)Landroid/graphics/ColorFilter;", "actualTintColorFilter", "NativeColorFilter", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidColorFilter_androidKt {
    /* renamed from: actualTintColorFilter-xETnrds, reason: not valid java name */
    public static final android.graphics.ColorFilter m1397actualTintColorFilterxETnrds(long j5, int i5) {
        return Build.VERSION.SDK_INT >= 29 ? BlendModeColorFilterHelper.INSTANCE.m1462BlendModeColorFilterxETnrds(j5, i5) : new PorterDuffColorFilter(ColorKt.m1508toArgb8_81llA(j5), AndroidBlendMode_androidKt.m1388toPorterDuffModes9anfk8(i5));
    }

    public static final android.graphics.ColorFilter asAndroidColorFilter(ColorFilter colorFilter) {
        return colorFilter.getNativeColorFilter();
    }
}
