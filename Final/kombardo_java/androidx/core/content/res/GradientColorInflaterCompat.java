package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.core.R$styleable;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class GradientColorInflaterCompat {
    private static final int TILE_MODE_CLAMP = 0;
    private static final int TILE_MODE_MIRROR = 2;
    private static final int TILE_MODE_REPEAT = 1;

    private static ColorStops checkColors(ColorStops colorStops, int i5, int i6, boolean z5, int i7) {
        return colorStops != null ? colorStops : z5 ? new ColorStops(i5, i7, i6) : new ColorStops(i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Shader createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R$styleable.GradientColor);
        float namedFloat = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "startX", R$styleable.GradientColor_android_startX, 0.0f);
        float namedFloat2 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "startY", R$styleable.GradientColor_android_startY, 0.0f);
        float namedFloat3 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "endX", R$styleable.GradientColor_android_endX, 0.0f);
        float namedFloat4 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "endY", R$styleable.GradientColor_android_endY, 0.0f);
        float namedFloat5 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "centerX", R$styleable.GradientColor_android_centerX, 0.0f);
        float namedFloat6 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "centerY", R$styleable.GradientColor_android_centerY, 0.0f);
        int namedInt = TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "type", R$styleable.GradientColor_android_type, 0);
        int namedColor = TypedArrayUtils.getNamedColor(obtainAttributes, xmlPullParser, "startColor", R$styleable.GradientColor_android_startColor, 0);
        boolean hasAttribute = TypedArrayUtils.hasAttribute(xmlPullParser, "centerColor");
        int namedColor2 = TypedArrayUtils.getNamedColor(obtainAttributes, xmlPullParser, "centerColor", R$styleable.GradientColor_android_centerColor, 0);
        int namedColor3 = TypedArrayUtils.getNamedColor(obtainAttributes, xmlPullParser, "endColor", R$styleable.GradientColor_android_endColor, 0);
        int namedInt2 = TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "tileMode", R$styleable.GradientColor_android_tileMode, 0);
        float namedFloat7 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "gradientRadius", R$styleable.GradientColor_android_gradientRadius, 0.0f);
        obtainAttributes.recycle();
        ColorStops checkColors = checkColors(inflateChildElements(resources, xmlPullParser, attributeSet, theme), namedColor, namedColor3, hasAttribute, namedColor2);
        if (namedInt != 1) {
            return namedInt != 2 ? new LinearGradient(namedFloat, namedFloat2, namedFloat3, namedFloat4, checkColors.mColors, checkColors.mOffsets, parseTileMode(namedInt2)) : new SweepGradient(namedFloat5, namedFloat6, checkColors.mColors, checkColors.mOffsets);
        }
        if (namedFloat7 > 0.0f) {
            return new RadialGradient(namedFloat5, namedFloat6, namedFloat7, checkColors.mColors, checkColors.mOffsets, parseTileMode(namedInt2));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0080, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ColorStops inflateChildElements(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R$styleable.GradientColorItem);
                int i5 = R$styleable.GradientColorItem_android_color;
                boolean hasValue = obtainAttributes.hasValue(i5);
                int i6 = R$styleable.GradientColorItem_android_offset;
                boolean hasValue2 = obtainAttributes.hasValue(i6);
                if (!hasValue || !hasValue2) {
                    break;
                }
                int color = obtainAttributes.getColor(i5, 0);
                float f5 = obtainAttributes.getFloat(i6, 0.0f);
                obtainAttributes.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f5));
            }
        }
        if (arrayList2.size() > 0) {
            return new ColorStops(arrayList2, arrayList);
        }
        return null;
    }

    private static Shader.TileMode parseTileMode(int i5) {
        return i5 != 1 ? i5 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ColorStops {
        final int[] mColors;
        final float[] mOffsets;

        ColorStops(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.mColors = new int[size];
            this.mOffsets = new float[size];
            for (int i5 = 0; i5 < size; i5++) {
                this.mColors[i5] = list.get(i5).intValue();
                this.mOffsets[i5] = list2.get(i5).floatValue();
            }
        }

        ColorStops(int i5, int i6) {
            this.mColors = new int[]{i5, i6};
            this.mOffsets = new float[]{0.0f, 1.0f};
        }

        ColorStops(int i5, int i6, int i7) {
            this.mColors = new int[]{i5, i6, i7};
            this.mOffsets = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
