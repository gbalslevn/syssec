package androidx.compose.material3.internal;

import androidx.compose.material3.internal.MenuPosition;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"androidx/compose/material3/internal/WindowAlignmentMarginPosition$Vertical", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "Landroidx/compose/ui/Alignment$Vertical;", "alignment", BuildConfig.FLAVOR, "margin", "<init>", "(Landroidx/compose/ui/Alignment$Vertical;I)V", "Landroidx/compose/ui/unit/IntRect;", "anchorBounds", "Landroidx/compose/ui/unit/IntSize;", "windowSize", "menuHeight", "position-JVtK1S4", "(Landroidx/compose/ui/unit/IntRect;JI)I", "position", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/Alignment$Vertical;", "I", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.material3.internal.WindowAlignmentMarginPosition$Vertical, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class Vertical implements MenuPosition.Vertical {
    private final Alignment.Vertical alignment;
    private final int margin;

    public Vertical(Alignment.Vertical vertical, int i5) {
        this.alignment = vertical;
        this.margin = i5;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Vertical)) {
            return false;
        }
        Vertical vertical = (Vertical) other;
        return Intrinsics.areEqual(this.alignment, vertical.alignment) && this.margin == vertical.margin;
    }

    public int hashCode() {
        return (this.alignment.hashCode() * 31) + Integer.hashCode(this.margin);
    }

    @Override // androidx.compose.material3.internal.MenuPosition.Vertical
    /* renamed from: position-JVtK1S4 */
    public int mo992positionJVtK1S4(IntRect anchorBounds, long windowSize, int menuHeight) {
        return menuHeight >= IntSize.m2660getHeightimpl(windowSize) - (this.margin * 2) ? Alignment.INSTANCE.getCenterVertically().align(menuHeight, IntSize.m2660getHeightimpl(windowSize)) : RangesKt.coerceIn(this.alignment.align(menuHeight, IntSize.m2660getHeightimpl(windowSize)), this.margin, (IntSize.m2660getHeightimpl(windowSize) - this.margin) - menuHeight);
    }

    public String toString() {
        return "Vertical(alignment=" + this.alignment + ", margin=" + this.margin + ')';
    }
}
