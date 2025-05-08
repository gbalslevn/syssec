package androidx.compose.ui.util;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u001a%\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0007\u001a\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {BuildConfig.FLAVOR, "start", "stop", "fraction", "lerp", "(FFF)F", BuildConfig.FLAVOR, "(IIF)I", "x", "fastCbrt", "(F)F", "ui-util_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class MathHelpersKt {
    public static final float fastCbrt(float f5) {
        float intBitsToFloat = Float.intBitsToFloat(((int) ((Float.floatToRawIntBits(f5) & 8589934591L) / 3)) + 709952852);
        float f6 = intBitsToFloat - ((intBitsToFloat - (f5 / (intBitsToFloat * intBitsToFloat))) * 0.33333334f);
        return f6 - ((f6 - (f5 / (f6 * f6))) * 0.33333334f);
    }

    public static final float lerp(float f5, float f6, float f7) {
        return ((1 - f7) * f5) + (f7 * f6);
    }

    public static final int lerp(int i5, int i6, float f5) {
        return i5 + ((int) Math.round((i6 - i5) * f5));
    }
}
