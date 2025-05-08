package androidx.compose.foundation.shape;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\r\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\t¢\u0006\u0004\b\u0003\u0010\b\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0003\u0010\f\u001a8\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u0017\u0010\u0013\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/shape/CornerSize;", "corner", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "RoundedCornerShape", "(Landroidx/compose/foundation/shape/CornerSize;)Landroidx/compose/foundation/shape/RoundedCornerShape;", "Landroidx/compose/ui/unit/Dp;", "size", "RoundedCornerShape-0680j_4", "(F)Landroidx/compose/foundation/shape/RoundedCornerShape;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "percent", "(I)Landroidx/compose/foundation/shape/RoundedCornerShape;", "topStart", "topEnd", "bottomEnd", "bottomStart", "RoundedCornerShape-a9UjIt4", "(FFFF)Landroidx/compose/foundation/shape/RoundedCornerShape;", "CircleShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "getCircleShape", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class RoundedCornerShapeKt {
    private static final RoundedCornerShape CircleShape = RoundedCornerShape(50);

    public static final RoundedCornerShape RoundedCornerShape(CornerSize cornerSize) {
        return new RoundedCornerShape(cornerSize, cornerSize, cornerSize, cornerSize);
    }

    /* renamed from: RoundedCornerShape-0680j_4, reason: not valid java name */
    public static final RoundedCornerShape m460RoundedCornerShape0680j_4(float f5) {
        return RoundedCornerShape(CornerSizeKt.m459CornerSize0680j_4(f5));
    }

    /* renamed from: RoundedCornerShape-a9UjIt4, reason: not valid java name */
    public static final RoundedCornerShape m461RoundedCornerShapea9UjIt4(float f5, float f6, float f7, float f8) {
        return new RoundedCornerShape(CornerSizeKt.m459CornerSize0680j_4(f5), CornerSizeKt.m459CornerSize0680j_4(f6), CornerSizeKt.m459CornerSize0680j_4(f7), CornerSizeKt.m459CornerSize0680j_4(f8));
    }

    /* renamed from: RoundedCornerShape-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ RoundedCornerShape m462RoundedCornerShapea9UjIt4$default(float f5, float f6, float f7, float f8, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = Dp.m2599constructorimpl(0);
        }
        if ((i5 & 2) != 0) {
            f6 = Dp.m2599constructorimpl(0);
        }
        if ((i5 & 4) != 0) {
            f7 = Dp.m2599constructorimpl(0);
        }
        if ((i5 & 8) != 0) {
            f8 = Dp.m2599constructorimpl(0);
        }
        return m461RoundedCornerShapea9UjIt4(f5, f6, f7, f8);
    }

    public static final RoundedCornerShape getCircleShape() {
        return CircleShape;
    }

    public static final RoundedCornerShape RoundedCornerShape(float f5) {
        return RoundedCornerShape(CornerSizeKt.CornerSize(f5));
    }

    public static final RoundedCornerShape RoundedCornerShape(int i5) {
        return RoundedCornerShape(CornerSizeKt.CornerSize(i5));
    }
}
