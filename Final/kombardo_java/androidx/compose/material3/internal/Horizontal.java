package androidx.compose.material3.internal;

import androidx.compose.material3.internal.MenuPosition;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J2\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001d\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"androidx/compose/material3/internal/WindowAlignmentMarginPosition$Horizontal", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "Landroidx/compose/ui/Alignment$Horizontal;", "alignment", BuildConfig.FLAVOR, "margin", "<init>", "(Landroidx/compose/ui/Alignment$Horizontal;I)V", "Landroidx/compose/ui/unit/IntRect;", "anchorBounds", "Landroidx/compose/ui/unit/IntSize;", "windowSize", "menuWidth", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "position-95KtPRI", "(Landroidx/compose/ui/unit/IntRect;JILandroidx/compose/ui/unit/LayoutDirection;)I", "position", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/Alignment$Horizontal;", "I", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.material3.internal.WindowAlignmentMarginPosition$Horizontal, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class Horizontal implements MenuPosition.Horizontal {
    private final Alignment.Horizontal alignment;
    private final int margin;

    public Horizontal(Alignment.Horizontal horizontal, int i5) {
        this.alignment = horizontal;
        this.margin = i5;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Horizontal)) {
            return false;
        }
        Horizontal horizontal = (Horizontal) other;
        return Intrinsics.areEqual(this.alignment, horizontal.alignment) && this.margin == horizontal.margin;
    }

    public int hashCode() {
        return (this.alignment.hashCode() * 31) + Integer.hashCode(this.margin);
    }

    @Override // androidx.compose.material3.internal.MenuPosition.Horizontal
    /* renamed from: position-95KtPRI */
    public int mo991position95KtPRI(IntRect anchorBounds, long windowSize, int menuWidth, LayoutDirection layoutDirection) {
        return menuWidth >= IntSize.m2661getWidthimpl(windowSize) - (this.margin * 2) ? Alignment.INSTANCE.getCenterHorizontally().align(menuWidth, IntSize.m2661getWidthimpl(windowSize), layoutDirection) : RangesKt.coerceIn(this.alignment.align(menuWidth, IntSize.m2661getWidthimpl(windowSize), layoutDirection), this.margin, (IntSize.m2661getWidthimpl(windowSize) - this.margin) - menuWidth);
    }

    public String toString() {
        return "Horizontal(alignment=" + this.alignment + ", margin=" + this.margin + ')';
    }
}
