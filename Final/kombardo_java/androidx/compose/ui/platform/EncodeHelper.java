package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!ø\u0001\u0000¢\u0006\u0004\b\"\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,ø\u0001\u0000¢\u0006\u0004\b-\u0010\nJ\u0006\u0010.\u001a\u00020*J\u0006\u0010/\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Landroidx/compose/ui/platform/EncodeHelper;", BuildConfig.FLAVOR, "()V", "parcel", "Landroid/os/Parcel;", "encode", BuildConfig.FLAVOR, "color", "Landroidx/compose/ui/graphics/Color;", "encode-8_81llA", "(J)V", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "encode-nzbMABs", "(I)V", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "encode-6p3vJLY", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "encode-4Dl_Bck", "(F)V", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textUnit", "Landroidx/compose/ui/unit/TextUnit;", "encode--R2X_6o", "byte", BuildConfig.FLAVOR, "float", BuildConfig.FLAVOR, "int", BuildConfig.FLAVOR, "string", BuildConfig.FLAVOR, "uLong", "Lkotlin/ULong;", "encode-VKZWuLQ", "encodedString", "reset", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EncodeHelper {
    private Parcel parcel = Parcel.obtain();

    public final void encode(SpanStyle spanStyle) {
        long m2255getColor0d7_KjU = spanStyle.m2255getColor0d7_KjU();
        Color.Companion companion = Color.INSTANCE;
        if (!Color.m1487equalsimpl0(m2255getColor0d7_KjU, companion.m1501getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m2133encode8_81llA(spanStyle.m2255getColor0d7_KjU());
        }
        long fontSize = spanStyle.getFontSize();
        TextUnit.Companion companion2 = TextUnit.INSTANCE;
        if (!TextUnit.m2672equalsimpl0(fontSize, companion2.m2679getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m2130encodeR2X_6o(spanStyle.getFontSize());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            encode((byte) 3);
            encode(fontWeight);
        }
        FontStyle fontStyle = spanStyle.getFontStyle();
        if (fontStyle != null) {
            int value = fontStyle.getValue();
            encode((byte) 4);
            m2135encodenzbMABs(value);
        }
        FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
        if (fontSynthesis != null) {
            int value2 = fontSynthesis.getValue();
            encode((byte) 5);
            m2132encode6p3vJLY(value2);
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            encode((byte) 6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.m2672equalsimpl0(spanStyle.getLetterSpacing(), companion2.m2679getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m2130encodeR2X_6o(spanStyle.getLetterSpacing());
        }
        BaselineShift baselineShift = spanStyle.getBaselineShift();
        if (baselineShift != null) {
            float multiplier = baselineShift.getMultiplier();
            encode((byte) 8);
            m2131encode4Dl_Bck(multiplier);
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            encode((byte) 9);
            encode(textGeometricTransform);
        }
        if (!Color.m1487equalsimpl0(spanStyle.getBackground(), companion.m1501getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m2133encode8_81llA(spanStyle.getBackground());
        }
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration != null) {
            encode((byte) 11);
            encode(textDecoration);
        }
        Shadow shadow = spanStyle.getShadow();
        if (shadow != null) {
            encode((byte) 12);
            encode(shadow);
        }
    }

    /* renamed from: encode--R2X_6o, reason: not valid java name */
    public final void m2130encodeR2X_6o(long textUnit) {
        long m2674getTypeUIouoOA = TextUnit.m2674getTypeUIouoOA(textUnit);
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        byte b5 = 0;
        if (!TextUnitType.m2688equalsimpl0(m2674getTypeUIouoOA, companion.m2694getUnspecifiedUIouoOA())) {
            if (TextUnitType.m2688equalsimpl0(m2674getTypeUIouoOA, companion.m2693getSpUIouoOA())) {
                b5 = 1;
            } else if (TextUnitType.m2688equalsimpl0(m2674getTypeUIouoOA, companion.m2692getEmUIouoOA())) {
                b5 = 2;
            }
        }
        encode(b5);
        if (TextUnitType.m2688equalsimpl0(TextUnit.m2674getTypeUIouoOA(textUnit), companion.m2694getUnspecifiedUIouoOA())) {
            return;
        }
        encode(TextUnit.m2675getValueimpl(textUnit));
    }

    /* renamed from: encode-4Dl_Bck, reason: not valid java name */
    public final void m2131encode4Dl_Bck(float baselineShift) {
        encode(baselineShift);
    }

    /* renamed from: encode-6p3vJLY, reason: not valid java name */
    public final void m2132encode6p3vJLY(int fontSynthesis) {
        FontSynthesis.Companion companion = FontSynthesis.INSTANCE;
        byte b5 = 0;
        if (!FontSynthesis.m2348equalsimpl0(fontSynthesis, companion.m2355getNoneGVVA2EU())) {
            if (FontSynthesis.m2348equalsimpl0(fontSynthesis, companion.m2354getAllGVVA2EU())) {
                b5 = 1;
            } else if (FontSynthesis.m2348equalsimpl0(fontSynthesis, companion.m2357getWeightGVVA2EU())) {
                b5 = 2;
            } else if (FontSynthesis.m2348equalsimpl0(fontSynthesis, companion.m2356getStyleGVVA2EU())) {
                b5 = 3;
            }
        }
        encode(b5);
    }

    /* renamed from: encode-8_81llA, reason: not valid java name */
    public final void m2133encode8_81llA(long color) {
        m2134encodeVKZWuLQ(color);
    }

    /* renamed from: encode-VKZWuLQ, reason: not valid java name */
    public final void m2134encodeVKZWuLQ(long uLong) {
        this.parcel.writeLong(uLong);
    }

    /* renamed from: encode-nzbMABs, reason: not valid java name */
    public final void m2135encodenzbMABs(int fontStyle) {
        FontStyle.Companion companion = FontStyle.INSTANCE;
        byte b5 = 0;
        if (!FontStyle.m2339equalsimpl0(fontStyle, companion.m2344getNormal_LCdwA()) && FontStyle.m2339equalsimpl0(fontStyle, companion.m2343getItalic_LCdwA())) {
            b5 = 1;
        }
        encode(b5);
    }

    public final String encodedString() {
        return Base64.encodeToString(this.parcel.marshall(), 0);
    }

    public final void reset() {
        this.parcel.recycle();
        this.parcel = Parcel.obtain();
    }

    public final void encode(FontWeight fontWeight) {
        encode(fontWeight.getWeight());
    }

    public final void encode(TextGeometricTransform textGeometricTransform) {
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(TextDecoration textDecoration) {
        encode(textDecoration.getMask());
    }

    public final void encode(Shadow shadow) {
        m2133encode8_81llA(shadow.getColor());
        encode(Offset.m1337getXimpl(shadow.getOffset()));
        encode(Offset.m1338getYimpl(shadow.getOffset()));
        encode(shadow.getBlurRadius());
    }

    public final void encode(byte r22) {
        this.parcel.writeByte(r22);
    }

    public final void encode(int r22) {
        this.parcel.writeInt(r22);
    }

    public final void encode(float r22) {
        this.parcel.writeFloat(r22);
    }

    public final void encode(String string) {
        this.parcel.writeString(string);
    }
}
