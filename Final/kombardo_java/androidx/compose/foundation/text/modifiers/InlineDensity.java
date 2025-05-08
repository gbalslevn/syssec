package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0081@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\bB\u0011\b\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011\u0088\u0001\n\u0092\u0001\u00020\t¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/text/modifiers/InlineDensity;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "density", "fontScale", "constructor-impl", "(FF)J", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)J", BuildConfig.FLAVOR, "packedValue", "(J)J", BuildConfig.FLAVOR, "toString-impl", "(J)Ljava/lang/String;", "toString", "getDensity-impl", "(J)F", "getFontScale-impl", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class InlineDensity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Unspecified = m595constructorimpl(Float.NaN, Float.NaN);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/modifiers/InlineDensity$Companion;", BuildConfig.FLAVOR, "()V", "Unspecified", "Landroidx/compose/foundation/text/modifiers/InlineDensity;", "getUnspecified-L26CHvs", "()J", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getUnspecified-L26CHvs, reason: not valid java name */
        public final long m602getUnspecifiedL26CHvs() {
            return InlineDensity.Unspecified;
        }

        private Companion() {
        }
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static long m596constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m598equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getDensity-impl, reason: not valid java name */
    public static final float m599getDensityimpl(long j5) {
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    /* renamed from: getFontScale-impl, reason: not valid java name */
    public static final float m600getFontScaleimpl(long j5) {
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m601toStringimpl(long j5) {
        return "InlineDensity(density=" + m599getDensityimpl(j5) + ", fontScale=" + m600getFontScaleimpl(j5) + ')';
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m597constructorimpl(Density density) {
        return m595constructorimpl(density.getDensity(), density.getFontScale());
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m595constructorimpl(float f5, float f6) {
        return m596constructorimpl((Float.floatToRawIntBits(f6) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
    }
}
