package androidx.compose.ui.graphics.vector.compat;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.compose.ui.graphics.vector.PathParser;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0018\u00010\u000eR\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0001\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0001\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J/\u0010\"\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0001\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020!¢\u0006\u0004\b\"\u0010#J%\u0010%\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001e¢\u0006\u0004\b%\u0010&J%\u0010'\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b'\u0010(J\u001f\u0010)\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0004¢\u0006\u0004\b)\u0010*J%\u0010,\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u001e¢\u0006\u0004\b,\u0010&J?\u0010.\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u00142\f\u0010\u000f\u001a\b\u0018\u00010\u000eR\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0001\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b.\u0010/J7\u00101\u001a\u0004\u0018\u0001002\u0006\u0010\u0017\u001a\u00020\u00142\f\u0010\u000f\u001a\b\u0018\u00010\u000eR\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0001\u0010\u001a\u001a\u00020\u0004¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b5\u00106J\u001a\u00108\u001a\u00020!2\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b8\u00109R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010:\u001a\u0004\b;\u0010<R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010=\u001a\u0004\b>\u00106\"\u0004\b?\u0010\u000bR\u0014\u0010A\u001a\u00020@8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006C"}, d2 = {"Landroidx/compose/ui/graphics/vector/compat/AndroidVectorParser;", BuildConfig.FLAVOR, "Lorg/xmlpull/v1/XmlPullParser;", "xmlParser", BuildConfig.FLAVOR, "config", "<init>", "(Lorg/xmlpull/v1/XmlPullParser;I)V", "resConfig", BuildConfig.FLAVOR, "updateConfig", "(I)V", "Landroid/content/res/Resources;", "res", "Landroid/content/res/Resources$Theme;", "theme", "Landroid/util/AttributeSet;", "set", BuildConfig.FLAVOR, "attrs", "Landroid/content/res/TypedArray;", "obtainAttributes", "(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;", "typedArray", BuildConfig.FLAVOR, "attrName", "resId", "defaultValue", "getNamedInt", "(Landroid/content/res/TypedArray;Ljava/lang/String;II)I", BuildConfig.FLAVOR, "getNamedFloat", "(Landroid/content/res/TypedArray;Ljava/lang/String;IF)F", BuildConfig.FLAVOR, "getNamedBoolean", "(Landroid/content/res/TypedArray;Ljava/lang/String;IZ)Z", "index", "getFloat", "(Landroid/content/res/TypedArray;IF)F", "getInt", "(Landroid/content/res/TypedArray;II)I", "getString", "(Landroid/content/res/TypedArray;I)Ljava/lang/String;", "defValue", "getDimension", "Landroidx/core/content/res/ComplexColorCompat;", "getNamedComplexColor", "(Landroid/content/res/TypedArray;Landroid/content/res/Resources$Theme;Ljava/lang/String;II)Landroidx/core/content/res/ComplexColorCompat;", "Landroid/content/res/ColorStateList;", "getNamedColorStateList", "(Landroid/content/res/TypedArray;Landroid/content/res/Resources$Theme;Ljava/lang/String;I)Landroid/content/res/ColorStateList;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lorg/xmlpull/v1/XmlPullParser;", "getXmlParser", "()Lorg/xmlpull/v1/XmlPullParser;", "I", "getConfig", "setConfig", "Landroidx/compose/ui/graphics/vector/PathParser;", "pathParser", "Landroidx/compose/ui/graphics/vector/PathParser;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AndroidVectorParser {
    private int config;
    public final PathParser pathParser;
    private final XmlPullParser xmlParser;

    public AndroidVectorParser(XmlPullParser xmlPullParser, int i5) {
        this.xmlParser = xmlPullParser;
        this.config = i5;
        this.pathParser = new PathParser();
    }

    private final void updateConfig(int resConfig) {
        this.config = resConfig | this.config;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AndroidVectorParser)) {
            return false;
        }
        AndroidVectorParser androidVectorParser = (AndroidVectorParser) other;
        return Intrinsics.areEqual(this.xmlParser, androidVectorParser.xmlParser) && this.config == androidVectorParser.config;
    }

    public final float getDimension(TypedArray typedArray, int index, float defValue) {
        float dimension = typedArray.getDimension(index, defValue);
        updateConfig(typedArray.getChangingConfigurations());
        return dimension;
    }

    public final float getFloat(TypedArray typedArray, int index, float defaultValue) {
        float f5 = typedArray.getFloat(index, defaultValue);
        updateConfig(typedArray.getChangingConfigurations());
        return f5;
    }

    public final int getInt(TypedArray typedArray, int index, int defaultValue) {
        int i5 = typedArray.getInt(index, defaultValue);
        updateConfig(typedArray.getChangingConfigurations());
        return i5;
    }

    public final boolean getNamedBoolean(TypedArray typedArray, String attrName, int resId, boolean defaultValue) {
        boolean namedBoolean = TypedArrayUtils.getNamedBoolean(typedArray, this.xmlParser, attrName, resId, defaultValue);
        updateConfig(typedArray.getChangingConfigurations());
        return namedBoolean;
    }

    public final ColorStateList getNamedColorStateList(TypedArray typedArray, Resources.Theme theme, String attrName, int resId) {
        ColorStateList namedColorStateList = TypedArrayUtils.getNamedColorStateList(typedArray, this.xmlParser, theme, attrName, resId);
        updateConfig(typedArray.getChangingConfigurations());
        return namedColorStateList;
    }

    public final ComplexColorCompat getNamedComplexColor(TypedArray typedArray, Resources.Theme theme, String attrName, int resId, int defaultValue) {
        ComplexColorCompat namedComplexColor = TypedArrayUtils.getNamedComplexColor(typedArray, this.xmlParser, theme, attrName, resId, defaultValue);
        updateConfig(typedArray.getChangingConfigurations());
        return namedComplexColor;
    }

    public final float getNamedFloat(TypedArray typedArray, String attrName, int resId, float defaultValue) {
        float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, this.xmlParser, attrName, resId, defaultValue);
        updateConfig(typedArray.getChangingConfigurations());
        return namedFloat;
    }

    public final int getNamedInt(TypedArray typedArray, String attrName, int resId, int defaultValue) {
        int namedInt = TypedArrayUtils.getNamedInt(typedArray, this.xmlParser, attrName, resId, defaultValue);
        updateConfig(typedArray.getChangingConfigurations());
        return namedInt;
    }

    public final String getString(TypedArray typedArray, int index) {
        String string = typedArray.getString(index);
        updateConfig(typedArray.getChangingConfigurations());
        return string;
    }

    public final XmlPullParser getXmlParser() {
        return this.xmlParser;
    }

    public int hashCode() {
        return (this.xmlParser.hashCode() * 31) + Integer.hashCode(this.config);
    }

    public final TypedArray obtainAttributes(Resources res, Resources.Theme theme, AttributeSet set, int[] attrs) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(res, theme, set, attrs);
        updateConfig(obtainAttributes.getChangingConfigurations());
        return obtainAttributes;
    }

    public String toString() {
        return "AndroidVectorParser(xmlParser=" + this.xmlParser + ", config=" + this.config + ')';
    }

    public /* synthetic */ AndroidVectorParser(XmlPullParser xmlPullParser, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(xmlPullParser, (i6 & 2) != 0 ? 0 : i5);
    }
}
