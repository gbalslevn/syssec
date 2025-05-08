package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R$attr;
import androidx.core.R$styleable;
import androidx.core.math.MathUtils;
import com.sun.jna.Function;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public abstract class ColorStateListInflaterCompat {
    private static final ThreadLocal<TypedValue> sTempTypedValue = new ThreadLocal<>();

    public static ColorStateList createFromXml(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return createFromXmlInner(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return inflate(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> threadLocal = sTempTypedValue;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList inflate(Resources resources, int i5, Resources.Theme theme) {
        try {
            return createFromXml(resources, resources.getXml(i5), theme);
        } catch (Exception e5) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e5);
            return null;
        }
    }

    private static boolean isColorInt(Resources resources, int i5) {
        TypedValue typedValue = getTypedValue();
        resources.getValue(i5, typedValue, true);
        int i6 = typedValue.type;
        return i6 >= 28 && i6 <= 31;
    }

    private static int modulateColorAlpha(int i5, float f5, float f6) {
        boolean z5 = f6 >= 0.0f && f6 <= 100.0f;
        if (f5 == 1.0f && !z5) {
            return i5;
        }
        int clamp = MathUtils.clamp((int) ((Color.alpha(i5) * f5) + 0.5f), 0, Function.USE_VARARGS);
        if (z5) {
            CamColor fromColor = CamColor.fromColor(i5);
            i5 = CamColor.toColor(fromColor.getHue(), fromColor.getChroma(), f6);
        }
        return (i5 & 16777215) | (clamp << 24);
    }

    private static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ColorStateList inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int color;
        float f5;
        int attributeCount;
        int i5;
        Resources resources2 = resources;
        int i6 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20];
        int[] iArr2 = new int[20];
        int i7 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i6 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray obtainAttributes = obtainAttributes(resources2, theme, attributeSet, R$styleable.ColorStateListItem);
                int i8 = R$styleable.ColorStateListItem_android_color;
                int resourceId = obtainAttributes.getResourceId(i8, -1);
                if (resourceId != -1 && !isColorInt(resources2, resourceId)) {
                    try {
                        color = createFromXml(resources2, resources2.getXml(resourceId), theme).getDefaultColor();
                    } catch (Exception unused) {
                        color = obtainAttributes.getColor(R$styleable.ColorStateListItem_android_color, -65281);
                    }
                } else {
                    color = obtainAttributes.getColor(i8, -65281);
                }
                int i9 = R$styleable.ColorStateListItem_android_alpha;
                float f6 = 1.0f;
                if (obtainAttributes.hasValue(i9)) {
                    f6 = obtainAttributes.getFloat(i9, 1.0f);
                } else {
                    int i10 = R$styleable.ColorStateListItem_alpha;
                    if (obtainAttributes.hasValue(i10)) {
                        f6 = obtainAttributes.getFloat(i10, 1.0f);
                    }
                }
                if (Build.VERSION.SDK_INT >= 31) {
                    int i11 = R$styleable.ColorStateListItem_android_lStar;
                    if (obtainAttributes.hasValue(i11)) {
                        f5 = obtainAttributes.getFloat(i11, -1.0f);
                        obtainAttributes.recycle();
                        attributeCount = attributeSet.getAttributeCount();
                        int[] iArr3 = new int[attributeCount];
                        int i12 = 0;
                        for (i5 = 0; i5 < attributeCount; i5++) {
                            int attributeNameResource = attributeSet.getAttributeNameResource(i5);
                            if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R$attr.alpha && attributeNameResource != R$attr.lStar) {
                                int i13 = i12 + 1;
                                if (!attributeSet.getAttributeBooleanValue(i5, false)) {
                                    attributeNameResource = -attributeNameResource;
                                }
                                iArr3[i12] = attributeNameResource;
                                i12 = i13;
                            }
                        }
                        int[] trimStateSet = StateSet.trimStateSet(iArr3, i12);
                        iArr2 = GrowingArrayUtils.append(iArr2, i7, modulateColorAlpha(color, f6, f5));
                        iArr = (int[][]) GrowingArrayUtils.append(iArr, i7, trimStateSet);
                        i7++;
                    }
                }
                f5 = obtainAttributes.getFloat(R$styleable.ColorStateListItem_lStar, -1.0f);
                obtainAttributes.recycle();
                attributeCount = attributeSet.getAttributeCount();
                int[] iArr32 = new int[attributeCount];
                int i122 = 0;
                while (i5 < attributeCount) {
                }
                int[] trimStateSet2 = StateSet.trimStateSet(iArr32, i122);
                iArr2 = GrowingArrayUtils.append(iArr2, i7, modulateColorAlpha(color, f6, f5));
                iArr = (int[][]) GrowingArrayUtils.append(iArr, i7, trimStateSet2);
                i7++;
            }
            i6 = 1;
            resources2 = resources;
        }
        int[] iArr4 = new int[i7];
        int[][] iArr5 = new int[i7];
        System.arraycopy(iArr2, 0, iArr4, 0, i7);
        System.arraycopy(iArr, 0, iArr5, 0, i7);
        return new ColorStateList(iArr5, iArr4);
    }
}
