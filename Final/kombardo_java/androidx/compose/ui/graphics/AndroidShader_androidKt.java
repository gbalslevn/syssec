package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001aL\u0010\u000e\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001d\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a%\u0010\u0014\u001a\u00020\u00132\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a7\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a-\u0010\u001b\u001a\u00020\u001a2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u001b\u0010\u001c*\n\u0010\u001d\"\u00020\n2\u00020\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/geometry/Offset;", "from", "to", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/Color;", "colors", BuildConfig.FLAVOR, "colorStops", "Landroidx/compose/ui/graphics/TileMode;", "tileMode", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "ActualLinearGradientShader-VjE6UOU", "(JJLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "ActualLinearGradientShader", BuildConfig.FLAVOR, "countTransparentColors", "(Ljava/util/List;)I", "numTransparentColors", BuildConfig.FLAVOR, "makeTransparentColors", "(Ljava/util/List;I)[I", "stops", BuildConfig.FLAVOR, "makeTransparentStops", "(Ljava/util/List;Ljava/util/List;I)[F", BuildConfig.FLAVOR, "validateColorStops", "(Ljava/util/List;Ljava/util/List;)V", "Shader", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidShader_androidKt {
    /* renamed from: ActualLinearGradientShader-VjE6UOU, reason: not valid java name */
    public static final Shader m1425ActualLinearGradientShaderVjE6UOU(long j5, long j6, List<Color> list, List<Float> list2, int i5) {
        validateColorStops(list, list2);
        int countTransparentColors = countTransparentColors(list);
        return new android.graphics.LinearGradient(Offset.m1337getXimpl(j5), Offset.m1338getYimpl(j5), Offset.m1337getXimpl(j6), Offset.m1338getYimpl(j6), makeTransparentColors(list, countTransparentColors), makeTransparentStops(list2, list, countTransparentColors), AndroidTileMode_androidKt.m1426toAndroidTileMode0vamqd0(i5));
    }

    public static final int countTransparentColors(List<Color> list) {
        return 0;
    }

    public static final int[] makeTransparentColors(List<Color> list, int i5) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i6 = 0; i6 < size; i6++) {
            iArr[i6] = ColorKt.m1508toArgb8_81llA(list.get(i6).getValue());
        }
        return iArr;
    }

    public static final float[] makeTransparentStops(List<Float> list, List<Color> list2, int i5) {
        if (i5 == 0) {
            if (list != null) {
                return CollectionsKt.toFloatArray(list);
            }
            return null;
        }
        float[] fArr = new float[list2.size() + i5];
        fArr[0] = list != null ? list.get(0).floatValue() : 0.0f;
        int lastIndex = CollectionsKt.getLastIndex(list2);
        int i6 = 1;
        for (int i7 = 1; i7 < lastIndex; i7++) {
            long value = list2.get(i7).getValue();
            float floatValue = list != null ? list.get(i7).floatValue() : i7 / CollectionsKt.getLastIndex(list2);
            int i8 = i6 + 1;
            fArr[i6] = floatValue;
            if (Color.m1488getAlphaimpl(value) == 0.0f) {
                i6 += 2;
                fArr[i8] = floatValue;
            } else {
                i6 = i8;
            }
        }
        fArr[i6] = list != null ? list.get(CollectionsKt.getLastIndex(list2)).floatValue() : 1.0f;
        return fArr;
    }

    private static final void validateColorStops(List<Color> list, List<Float> list2) {
        if (list2 == null) {
            if (list.size() < 2) {
                throw new IllegalArgumentException("colors must have length of at least 2 if colorStops is omitted.");
            }
        } else if (list.size() != list2.size()) {
            throw new IllegalArgumentException("colors and colorStops arguments must have equal length.");
        }
    }
}
