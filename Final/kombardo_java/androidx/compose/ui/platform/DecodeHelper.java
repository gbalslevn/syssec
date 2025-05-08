package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.OffsetKt;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0015\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0002J\u0013\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0013\u0010\u0015\u001a\u00020\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001aø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0018J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\bH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010!\u001a\u00020\"J\n\u0010#\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020'H\u0002J\u0013\u0010(\u001a\u00020)ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010\u0012J\u0015\u0010+\u001a\u00020,H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"Landroidx/compose/ui/platform/DecodeHelper;", BuildConfig.FLAVOR, "string", BuildConfig.FLAVOR, "(Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "dataAvailable", BuildConfig.FLAVOR, "decodeBaselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "decodeBaselineShift-y9eOQZs", "()F", "decodeByte", BuildConfig.FLAVOR, "decodeColor", "Landroidx/compose/ui/graphics/Color;", "decodeColor-0d7_KjU", "()J", "decodeFloat", BuildConfig.FLAVOR, "decodeFontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "decodeFontStyle-_-LCdwA", "()I", "decodeFontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "decodeFontSynthesis-GVVA2EU", "decodeFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "decodeInt", "decodeShadow", "Landroidx/compose/ui/graphics/Shadow;", "decodeSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "decodeString", "decodeTextDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "decodeTextGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "decodeTextUnit", "Landroidx/compose/ui/unit/TextUnit;", "decodeTextUnit-XSAIIZE", "decodeULong", "Lkotlin/ULong;", "decodeULong-s-VKNKU", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DecodeHelper {
    private final Parcel parcel;

    public DecodeHelper(String str) {
        Parcel obtain = Parcel.obtain();
        this.parcel = obtain;
        byte[] decode = Base64.decode(str, 0);
        obtain.unmarshall(decode, 0, decode.length);
        obtain.setDataPosition(0);
    }

    private final int dataAvailable() {
        return this.parcel.dataAvail();
    }

    /* renamed from: decodeBaselineShift-y9eOQZs, reason: not valid java name */
    private final float m2123decodeBaselineShifty9eOQZs() {
        return BaselineShift.m2456constructorimpl(decodeFloat());
    }

    private final byte decodeByte() {
        return this.parcel.readByte();
    }

    private final float decodeFloat() {
        return this.parcel.readFloat();
    }

    private final int decodeInt() {
        return this.parcel.readInt();
    }

    private final Shadow decodeShadow() {
        return new Shadow(m2125decodeColor0d7_KjU(), OffsetKt.Offset(decodeFloat(), decodeFloat()), decodeFloat(), null);
    }

    private final String decodeString() {
        return this.parcel.readString();
    }

    private final TextDecoration decodeTextDecoration() {
        int decodeInt = decodeInt();
        TextDecoration.Companion companion = TextDecoration.INSTANCE;
        boolean z5 = (companion.getLineThrough().getMask() & decodeInt) != 0;
        boolean z6 = (decodeInt & companion.getUnderline().getMask()) != 0;
        return (z5 && z6) ? companion.combine(CollectionsKt.listOf((Object[]) new TextDecoration[]{companion.getLineThrough(), companion.getUnderline()})) : z5 ? companion.getLineThrough() : z6 ? companion.getUnderline() : companion.getNone();
    }

    private final TextGeometricTransform decodeTextGeometricTransform() {
        return new TextGeometricTransform(decodeFloat(), decodeFloat());
    }

    /* renamed from: decodeULong-s-VKNKU, reason: not valid java name */
    private final long m2124decodeULongsVKNKU() {
        return ULong.m3622constructorimpl(this.parcel.readLong());
    }

    /* renamed from: decodeColor-0d7_KjU, reason: not valid java name */
    public final long m2125decodeColor0d7_KjU() {
        return Color.m1482constructorimpl(m2124decodeULongsVKNKU());
    }

    /* renamed from: decodeFontStyle-_-LCdwA, reason: not valid java name */
    public final int m2126decodeFontStyle_LCdwA() {
        byte decodeByte = decodeByte();
        if (decodeByte != 0 && decodeByte == 1) {
            return FontStyle.INSTANCE.m2343getItalic_LCdwA();
        }
        return FontStyle.INSTANCE.m2344getNormal_LCdwA();
    }

    /* renamed from: decodeFontSynthesis-GVVA2EU, reason: not valid java name */
    public final int m2127decodeFontSynthesisGVVA2EU() {
        byte decodeByte = decodeByte();
        return decodeByte == 0 ? FontSynthesis.INSTANCE.m2355getNoneGVVA2EU() : decodeByte == 1 ? FontSynthesis.INSTANCE.m2354getAllGVVA2EU() : decodeByte == 3 ? FontSynthesis.INSTANCE.m2356getStyleGVVA2EU() : decodeByte == 2 ? FontSynthesis.INSTANCE.m2357getWeightGVVA2EU() : FontSynthesis.INSTANCE.m2355getNoneGVVA2EU();
    }

    public final FontWeight decodeFontWeight() {
        return new FontWeight(decodeInt());
    }

    public final SpanStyle decodeSpanStyle() {
        MutableSpanStyle mutableSpanStyle;
        MutableSpanStyle mutableSpanStyle2 = r15;
        MutableSpanStyle mutableSpanStyle3 = new MutableSpanStyle(0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 16383, null);
        while (this.parcel.dataAvail() > 1) {
            byte decodeByte = decodeByte();
            if (decodeByte != 1) {
                mutableSpanStyle = mutableSpanStyle2;
                if (decodeByte == 2) {
                    if (dataAvailable() < 5) {
                        break;
                    }
                    mutableSpanStyle.m2144setFontSizeR2X_6o(m2128decodeTextUnitXSAIIZE());
                    mutableSpanStyle2 = mutableSpanStyle;
                } else if (decodeByte == 3) {
                    if (dataAvailable() < 4) {
                        break;
                    }
                    mutableSpanStyle.setFontWeight(decodeFontWeight());
                    mutableSpanStyle2 = mutableSpanStyle;
                } else if (decodeByte == 4) {
                    if (dataAvailable() < 1) {
                        break;
                    }
                    mutableSpanStyle.m2145setFontStylemLjRB2g(FontStyle.m2336boximpl(m2126decodeFontStyle_LCdwA()));
                    mutableSpanStyle2 = mutableSpanStyle;
                } else if (decodeByte != 5) {
                    if (decodeByte != 6) {
                        if (decodeByte != 7) {
                            if (decodeByte != 8) {
                                if (decodeByte != 9) {
                                    if (decodeByte != 10) {
                                        if (decodeByte != 11) {
                                            if (decodeByte == 12) {
                                                if (dataAvailable() < 20) {
                                                    break;
                                                }
                                                mutableSpanStyle.setShadow(decodeShadow());
                                            }
                                        } else {
                                            if (dataAvailable() < 4) {
                                                break;
                                            }
                                            mutableSpanStyle.setTextDecoration(decodeTextDecoration());
                                        }
                                    } else {
                                        if (dataAvailable() < 8) {
                                            break;
                                        }
                                        mutableSpanStyle.m2141setBackground8_81llA(m2125decodeColor0d7_KjU());
                                    }
                                } else {
                                    if (dataAvailable() < 8) {
                                        break;
                                    }
                                    mutableSpanStyle.setTextGeometricTransform(decodeTextGeometricTransform());
                                }
                            } else {
                                if (dataAvailable() < 4) {
                                    break;
                                }
                                mutableSpanStyle.m2142setBaselineShift_isdbwI(BaselineShift.m2455boximpl(m2123decodeBaselineShifty9eOQZs()));
                            }
                        } else {
                            if (dataAvailable() < 5) {
                                break;
                            }
                            mutableSpanStyle.m2147setLetterSpacingR2X_6o(m2128decodeTextUnitXSAIIZE());
                        }
                    } else {
                        mutableSpanStyle.setFontFeatureSettings(decodeString());
                    }
                    mutableSpanStyle2 = mutableSpanStyle;
                } else {
                    if (dataAvailable() < 1) {
                        break;
                    }
                    mutableSpanStyle.m2146setFontSynthesistDdu0R4(FontSynthesis.m2345boximpl(m2127decodeFontSynthesisGVVA2EU()));
                    mutableSpanStyle2 = mutableSpanStyle;
                }
            } else {
                if (dataAvailable() < 8) {
                    break;
                }
                mutableSpanStyle2.m2143setColor8_81llA(m2125decodeColor0d7_KjU());
            }
        }
        mutableSpanStyle = mutableSpanStyle2;
        return mutableSpanStyle.toSpanStyle();
    }

    /* renamed from: decodeTextUnit-XSAIIZE, reason: not valid java name */
    public final long m2128decodeTextUnitXSAIIZE() {
        byte decodeByte = decodeByte();
        long m2693getSpUIouoOA = decodeByte == 1 ? TextUnitType.INSTANCE.m2693getSpUIouoOA() : decodeByte == 2 ? TextUnitType.INSTANCE.m2692getEmUIouoOA() : TextUnitType.INSTANCE.m2694getUnspecifiedUIouoOA();
        return TextUnitType.m2688equalsimpl0(m2693getSpUIouoOA, TextUnitType.INSTANCE.m2694getUnspecifiedUIouoOA()) ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : TextUnitKt.m2680TextUnitanM5pPY(decodeFloat(), m2693getSpUIouoOA);
    }
}
