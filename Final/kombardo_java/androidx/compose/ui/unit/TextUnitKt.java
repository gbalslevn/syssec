package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\u001a\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0004H\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\"\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\"\u0014\u0010\u001b\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c\"\u0014\u0010\u001d\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001c\"\u0014\u0010\u001e\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001c\"\u0014\u0010\u001f\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001c\"\u001e\u0010$\u001a\u00020 *\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0010\u001a\u0004\b!\u0010\"\"\u001e\u0010)\u001a\u00020\u0004*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010(\u001a\u0004\b%\u0010&\"\u001e\u0010)\u001a\u00020\u0004*\u00020*8FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010,\u001a\u0004\b%\u0010+\"\u001e\u0010)\u001a\u00020\u0004*\u00020-8FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010/\u001a\u0004\b%\u0010.\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {BuildConfig.FLAVOR, "value", "Landroidx/compose/ui/unit/TextUnitType;", "type", "Landroidx/compose/ui/unit/TextUnit;", "TextUnit-anM5pPY", "(FJ)J", "TextUnit", BuildConfig.FLAVOR, "unitType", "v", "pack", "(JF)J", "a", BuildConfig.FLAVOR, "checkArithmetic--R2X_6o", "(J)V", "checkArithmetic", "b", "checkArithmetic-NB67dxo", "(JJ)V", "start", "stop", "fraction", "lerp-C3pnCVY", "(JJF)J", "lerp", "UNIT_MASK", "J", "UNIT_TYPE_UNSPECIFIED", "UNIT_TYPE_SP", "UNIT_TYPE_EM", BuildConfig.FLAVOR, "isUnspecified--R2X_6o", "(J)Z", "isUnspecified--R2X_6o$annotations", "isUnspecified", "getSp", "(F)J", "getSp$annotations", "(F)V", "sp", BuildConfig.FLAVOR, "(D)J", "(D)V", BuildConfig.FLAVOR, "(I)J", "(I)V", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TextUnitKt {
    private static final long UNIT_MASK = 1095216660480L;
    private static final long UNIT_TYPE_EM = 8589934592L;
    private static final long UNIT_TYPE_SP = 4294967296L;
    private static final long UNIT_TYPE_UNSPECIFIED = 0;

    /* renamed from: TextUnit-anM5pPY, reason: not valid java name */
    public static final long m2680TextUnitanM5pPY(float f5, long j5) {
        return pack(j5, f5);
    }

    /* renamed from: checkArithmetic--R2X_6o, reason: not valid java name */
    public static final void m2681checkArithmeticR2X_6o(long j5) {
        if (m2683isUnspecifiedR2X_6o(j5)) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
    }

    /* renamed from: checkArithmetic-NB67dxo, reason: not valid java name */
    public static final void m2682checkArithmeticNB67dxo(long j5, long j6) {
        if (m2683isUnspecifiedR2X_6o(j5) || m2683isUnspecifiedR2X_6o(j6)) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
        if (TextUnitType.m2688equalsimpl0(TextUnit.m2674getTypeUIouoOA(j5), TextUnit.m2674getTypeUIouoOA(j6))) {
            return;
        }
        throw new IllegalArgumentException(("Cannot perform operation for " + ((Object) TextUnitType.m2690toStringimpl(TextUnit.m2674getTypeUIouoOA(j5))) + " and " + ((Object) TextUnitType.m2690toStringimpl(TextUnit.m2674getTypeUIouoOA(j6)))).toString());
    }

    public static final long getSp(float f5) {
        return pack(UNIT_TYPE_SP, f5);
    }

    /* renamed from: isUnspecified--R2X_6o, reason: not valid java name */
    public static final boolean m2683isUnspecifiedR2X_6o(long j5) {
        return TextUnit.m2673getRawTypeimpl(j5) == 0;
    }

    /* renamed from: lerp-C3pnCVY, reason: not valid java name */
    public static final long m2684lerpC3pnCVY(long j5, long j6, float f5) {
        m2682checkArithmeticNB67dxo(j5, j6);
        return pack(TextUnit.m2673getRawTypeimpl(j5), MathHelpersKt.lerp(TextUnit.m2675getValueimpl(j5), TextUnit.m2675getValueimpl(j6), f5));
    }

    public static final long pack(long j5, float f5) {
        return TextUnit.m2670constructorimpl(j5 | (Float.floatToIntBits(f5) & 4294967295L));
    }

    public static final long getSp(double d5) {
        return pack(UNIT_TYPE_SP, (float) d5);
    }

    public static final long getSp(int i5) {
        return pack(UNIT_TYPE_SP, i5);
    }
}
