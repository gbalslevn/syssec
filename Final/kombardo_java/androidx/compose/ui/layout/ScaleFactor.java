package androidx.compose.ui.layout;

import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\b\u0087@\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u000b\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000e\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\b\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/layout/ScaleFactor;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "packedValue", "constructor-impl", "(J)J", BuildConfig.FLAVOR, "getScaleX-impl", "(J)F", "getScaleX$annotations", "()V", "scaleX", "getScaleY-impl", "getScaleY$annotations", "scaleY", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ScaleFactor {
    private static final long Unspecified = ScaleFactorKt.ScaleFactor(Float.NaN, Float.NaN);

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1980constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: getScaleX-impl, reason: not valid java name */
    public static final float m1981getScaleXimpl(long j5) {
        if (!(j5 != Unspecified)) {
            InlineClassHelperKt.throwIllegalStateException("ScaleFactor is unspecified");
        }
        return Float.intBitsToFloat((int) (j5 >> 32));
    }

    /* renamed from: getScaleY-impl, reason: not valid java name */
    public static final float m1982getScaleYimpl(long j5) {
        if (!(j5 != Unspecified)) {
            InlineClassHelperKt.throwIllegalStateException("ScaleFactor is unspecified");
        }
        return Float.intBitsToFloat((int) (j5 & 4294967295L));
    }
}
