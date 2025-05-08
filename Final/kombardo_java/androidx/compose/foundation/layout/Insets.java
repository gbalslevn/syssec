package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/layout/FixedDpInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "leftDp", "Landroidx/compose/ui/unit/Dp;", "topDp", "rightDp", "bottomDp", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "getBottom", BuildConfig.FLAVOR, "density", "Landroidx/compose/ui/unit/Density;", "getLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getRight", "getTop", "hashCode", "toString", BuildConfig.FLAVOR, "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.foundation.layout.FixedDpInsets, reason: from toString */
/* loaded from: classes.dex */
final class Insets implements WindowInsets {

    /* renamed from: bottomDp, reason: from kotlin metadata and from toString */
    private final float bottom;

    /* renamed from: leftDp, reason: from kotlin metadata and from toString */
    private final float left;

    /* renamed from: rightDp, reason: from kotlin metadata and from toString */
    private final float right;

    /* renamed from: topDp, reason: from kotlin metadata and from toString */
    private final float top;

    public /* synthetic */ Insets(float f5, float f6, float f7, float f8, DefaultConstructorMarker defaultConstructorMarker) {
        this(f5, f6, f7, f8);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Insets)) {
            return false;
        }
        Insets insets = (Insets) other;
        return Dp.m2601equalsimpl0(this.left, insets.left) && Dp.m2601equalsimpl0(this.top, insets.top) && Dp.m2601equalsimpl0(this.right, insets.right) && Dp.m2601equalsimpl0(this.bottom, insets.bottom);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(Density density) {
        return density.mo206roundToPx0680j_4(this.bottom);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(Density density, LayoutDirection layoutDirection) {
        return density.mo206roundToPx0680j_4(this.left);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(Density density, LayoutDirection layoutDirection) {
        return density.mo206roundToPx0680j_4(this.right);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(Density density) {
        return density.mo206roundToPx0680j_4(this.top);
    }

    public int hashCode() {
        return (((((Dp.m2602hashCodeimpl(this.left) * 31) + Dp.m2602hashCodeimpl(this.top)) * 31) + Dp.m2602hashCodeimpl(this.right)) * 31) + Dp.m2602hashCodeimpl(this.bottom);
    }

    public String toString() {
        return "Insets(left=" + ((Object) Dp.m2603toStringimpl(this.left)) + ", top=" + ((Object) Dp.m2603toStringimpl(this.top)) + ", right=" + ((Object) Dp.m2603toStringimpl(this.right)) + ", bottom=" + ((Object) Dp.m2603toStringimpl(this.bottom)) + ')';
    }

    private Insets(float f5, float f6, float f7, float f8) {
        this.left = f5;
        this.top = f6;
        this.right = f7;
        this.bottom = f8;
    }
}
