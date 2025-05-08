package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public abstract class TypedArrayUtils {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    public static boolean getNamedBoolean(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i5, boolean z5) {
        return !hasAttribute(xmlPullParser, str) ? z5 : typedArray.getBoolean(i5, z5);
    }

    public static int getNamedColor(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i5, int i6) {
        return !hasAttribute(xmlPullParser, str) ? i6 : typedArray.getColor(i5, i6);
    }

    public static ColorStateList getNamedColorStateList(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i5) {
        if (!hasAttribute(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i5, typedValue);
        int i6 = typedValue.type;
        if (i6 != 2) {
            return (i6 < 28 || i6 > 31) ? ColorStateListInflaterCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i5, 0), theme) : getNamedColorStateListFromInt(typedValue);
        }
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + i5 + ": " + typedValue);
    }

    private static ColorStateList getNamedColorStateListFromInt(TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static ComplexColorCompat getNamedComplexColor(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i5, int i6) {
        if (hasAttribute(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i5, typedValue);
            int i7 = typedValue.type;
            if (i7 >= 28 && i7 <= 31) {
                return ComplexColorCompat.from(typedValue.data);
            }
            ComplexColorCompat inflate = ComplexColorCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i5, 0), theme);
            if (inflate != null) {
                return inflate;
            }
        }
        return ComplexColorCompat.from(i6);
    }

    public static float getNamedFloat(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i5, float f5) {
        return !hasAttribute(xmlPullParser, str) ? f5 : typedArray.getFloat(i5, f5);
    }

    public static int getNamedInt(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i5, int i6) {
        return !hasAttribute(xmlPullParser, str) ? i6 : typedArray.getInt(i5, i6);
    }

    public static boolean hasAttribute(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue(NAMESPACE, str) != null;
    }

    public static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
