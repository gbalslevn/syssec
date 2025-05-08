package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u0003*\u00020\u0002H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\n\u001a\u00020\u0007*\u00020\u0002H\u0017ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0006\u001a\u00020\u0003*\u00020\u000bH\u0017ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u0002*\u00020\u0007H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u0002*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0005J\u0019\u0010\u0013\u001a\u00020\u000b*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0018\u001a\u00020\u0015*\u00020\u0014H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u001a\u001a\u00020\u0014*\u00020\u0015H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001f\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006 À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/FontScaling;", "Landroidx/compose/ui/unit/Dp;", BuildConfig.FLAVOR, "toPx-0680j_4", "(F)F", "toPx", BuildConfig.FLAVOR, "roundToPx-0680j_4", "(F)I", "roundToPx", "Landroidx/compose/ui/unit/TextUnit;", "toPx--R2X_6o", "(J)F", "toDp-u2uoSUM", "(I)F", "toDp", "toSp-kPz2Gy4", "(F)J", "toSp", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toSize-XkaWNTQ", "(J)J", "toSize", "toDpSize-k-rfVVM", "toDpSize", "getDensity", "()F", "getDensity$annotations", "()V", "density", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Density extends FontScaling {
    float getDensity();

    /* renamed from: roundToPx-0680j_4 */
    default int mo206roundToPx0680j_4(float f5) {
        float mo212toPx0680j_4 = mo212toPx0680j_4(f5);
        if (Float.isInfinite(mo212toPx0680j_4)) {
            return Integer.MAX_VALUE;
        }
        return Math.round(mo212toPx0680j_4);
    }

    /* renamed from: toDp-u2uoSUM */
    default float mo209toDpu2uoSUM(int i5) {
        return Dp.m2599constructorimpl(i5 / getDensity());
    }

    /* renamed from: toDpSize-k-rfVVM */
    default long mo210toDpSizekrfVVM(long j5) {
        return j5 != 9205357640488583168L ? DpKt.m2610DpSizeYgX7TsA(mo208toDpu2uoSUM(Size.m1377getWidthimpl(j5)), mo208toDpu2uoSUM(Size.m1375getHeightimpl(j5))) : DpSize.INSTANCE.m2630getUnspecifiedMYxV2XQ();
    }

    /* renamed from: toPx--R2X_6o */
    default float mo211toPxR2X_6o(long j5) {
        if (TextUnitType.m2688equalsimpl0(TextUnit.m2674getTypeUIouoOA(j5), TextUnitType.INSTANCE.m2693getSpUIouoOA())) {
            return mo212toPx0680j_4(mo207toDpGaN1DYA(j5));
        }
        throw new IllegalStateException("Only Sp can convert to Px");
    }

    /* renamed from: toPx-0680j_4 */
    default float mo212toPx0680j_4(float f5) {
        return f5 * getDensity();
    }

    /* renamed from: toSize-XkaWNTQ */
    default long mo213toSizeXkaWNTQ(long j5) {
        return j5 != 9205357640488583168L ? SizeKt.Size(mo212toPx0680j_4(DpSize.m2626getWidthD9Ej5fM(j5)), mo212toPx0680j_4(DpSize.m2625getHeightD9Ej5fM(j5))) : Size.INSTANCE.m1383getUnspecifiedNHjbRc();
    }

    /* renamed from: toSp-kPz2Gy4 */
    default long mo215toSpkPz2Gy4(float f5) {
        return mo214toSp0xMU5do(mo208toDpu2uoSUM(f5));
    }

    /* renamed from: toDp-u2uoSUM */
    default float mo208toDpu2uoSUM(float f5) {
        return Dp.m2599constructorimpl(f5 / getDensity());
    }
}
