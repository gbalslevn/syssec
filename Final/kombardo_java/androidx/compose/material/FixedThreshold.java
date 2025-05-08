package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Deprecated
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u00020\u0007*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Landroidx/compose/material/FixedThreshold;", "Landroidx/compose/material/ThresholdConfig;", "Landroidx/compose/ui/unit/Dp;", "offset", "<init>", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/unit/Density;", BuildConfig.FLAVOR, "fromValue", "toValue", "computeThreshold", "(Landroidx/compose/ui/unit/Density;FF)F", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "F", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class FixedThreshold implements ThresholdConfig {
    private final float offset;

    public /* synthetic */ FixedThreshold(float f5, DefaultConstructorMarker defaultConstructorMarker) {
        this(f5);
    }

    @Override // androidx.compose.material.ThresholdConfig
    public float computeThreshold(Density density, float f5, float f6) {
        return f5 + (density.mo212toPx0680j_4(this.offset) * Math.signum(f6 - f5));
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FixedThreshold) && Dp.m2601equalsimpl0(this.offset, ((FixedThreshold) other).offset);
    }

    public int hashCode() {
        return Dp.m2602hashCodeimpl(this.offset);
    }

    public String toString() {
        return "FixedThreshold(offset=" + ((Object) Dp.m2603toStringimpl(this.offset)) + ')';
    }

    private FixedThreshold(float f5) {
        this.offset = f5;
    }
}
