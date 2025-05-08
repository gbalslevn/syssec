package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class ComplexColorCompat {
    private static final String LOG_TAG = "ComplexColorCompat";
    private int mColor;
    private final ColorStateList mColorStateList;
    private final Shader mShader;

    private ComplexColorCompat(Shader shader, ColorStateList colorStateList, int i5) {
        this.mShader = shader;
        this.mColorStateList = colorStateList;
        this.mColor = i5;
    }

    private static ComplexColorCompat createFromXml(Resources resources, int i5, Resources.Theme theme) {
        int next;
        XmlResourceParser xml = resources.getXml(i5);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.hashCode();
        if (name.equals("gradient")) {
            return from(GradientColorInflaterCompat.createFromXmlInner(resources, xml, asAttributeSet, theme));
        }
        if (name.equals("selector")) {
            return from(ColorStateListInflaterCompat.createFromXmlInner(resources, xml, asAttributeSet, theme));
        }
        throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
    }

    static ComplexColorCompat from(Shader shader) {
        return new ComplexColorCompat(shader, null, 0);
    }

    public static ComplexColorCompat inflate(Resources resources, int i5, Resources.Theme theme) {
        try {
            return createFromXml(resources, i5, theme);
        } catch (Exception e5) {
            Log.e(LOG_TAG, "Failed to inflate ComplexColor.", e5);
            return null;
        }
    }

    public int getColor() {
        return this.mColor;
    }

    public Shader getShader() {
        return this.mShader;
    }

    public boolean isGradient() {
        return this.mShader != null;
    }

    public boolean willDraw() {
        return isGradient() || this.mColor != 0;
    }

    static ComplexColorCompat from(ColorStateList colorStateList) {
        return new ComplexColorCompat(null, colorStateList, colorStateList.getDefaultColor());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ComplexColorCompat from(int i5) {
        return new ComplexColorCompat(null, null, i5);
    }
}
