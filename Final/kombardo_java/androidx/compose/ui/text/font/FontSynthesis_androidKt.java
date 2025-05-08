package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.text.font.FontWeight;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"synthesizeTypeface", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/font/FontSynthesis;", "typeface", "font", "Landroidx/compose/ui/text/font/Font;", "requestedWeight", "Landroidx/compose/ui/text/font/FontWeight;", "requestedStyle", "Landroidx/compose/ui/text/font/FontStyle;", "synthesizeTypeface-FxwP2eA", "(ILjava/lang/Object;Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/lang/Object;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class FontSynthesis_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006c  */
    /* renamed from: synthesizeTypeface-FxwP2eA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m2358synthesizeTypefaceFxwP2eA(int i5, Object obj, Font font, FontWeight fontWeight, int i6) {
        boolean z5;
        boolean z6;
        if (!(obj instanceof Typeface)) {
            return obj;
        }
        boolean z7 = false;
        if (FontSynthesis.m2351isWeightOnimpl$ui_text_release(i5) && !Intrinsics.areEqual(font.getWeight(), fontWeight)) {
            FontWeight.Companion companion = FontWeight.INSTANCE;
            if (fontWeight.compareTo(AndroidFontUtils_androidKt.getAndroidBold(companion)) >= 0 && font.getWeight().compareTo(AndroidFontUtils_androidKt.getAndroidBold(companion)) < 0) {
                z5 = true;
                z6 = (FontSynthesis.m2350isStyleOnimpl$ui_text_release(i5) || FontStyle.m2339equalsimpl0(i6, font.mo2323getStyle_LCdwA())) ? false : true;
                if (z6 && !z5) {
                    return obj;
                }
                if (Build.VERSION.SDK_INT < 28) {
                    return TypefaceHelperMethodsApi28.INSTANCE.create((Typeface) obj, z5 ? fontWeight.getWeight() : font.getWeight().getWeight(), z6 ? FontStyle.m2339equalsimpl0(i6, FontStyle.INSTANCE.m2343getItalic_LCdwA()) : FontStyle.m2339equalsimpl0(font.mo2323getStyle_LCdwA(), FontStyle.INSTANCE.m2343getItalic_LCdwA()));
                }
                if (z6 && FontStyle.m2339equalsimpl0(i6, FontStyle.INSTANCE.m2343getItalic_LCdwA())) {
                    z7 = true;
                }
                return Typeface.create((Typeface) obj, AndroidFontUtils_androidKt.getAndroidTypefaceStyle(z5, z7));
            }
        }
        z5 = false;
        if (FontSynthesis.m2350isStyleOnimpl$ui_text_release(i5)) {
        }
        if (z6) {
        }
        if (Build.VERSION.SDK_INT < 28) {
        }
    }
}
