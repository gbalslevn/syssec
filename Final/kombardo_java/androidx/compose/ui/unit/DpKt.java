package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\r\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/unit/Dp;", "start", "stop", BuildConfig.FLAVOR, "fraction", "lerp-Md-fbLM", "(FFF)F", "lerp", "x", "y", "Landroidx/compose/ui/unit/DpOffset;", "DpOffset-YgX7TsA", "(FF)J", "DpOffset", "width", "height", "Landroidx/compose/ui/unit/DpSize;", "DpSize-YgX7TsA", "DpSize", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DpKt {
    /* renamed from: DpOffset-YgX7TsA, reason: not valid java name */
    public static final long m2609DpOffsetYgX7TsA(float f5, float f6) {
        return DpOffset.m2613constructorimpl((Float.floatToRawIntBits(f6) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
    }

    /* renamed from: DpSize-YgX7TsA, reason: not valid java name */
    public static final long m2610DpSizeYgX7TsA(float f5, float f6) {
        return DpSize.m2622constructorimpl((Float.floatToRawIntBits(f6) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
    }

    /* renamed from: lerp-Md-fbLM, reason: not valid java name */
    public static final float m2611lerpMdfbLM(float f5, float f6, float f7) {
        return Dp.m2599constructorimpl(MathHelpersKt.lerp(f5, f6, f7));
    }
}
