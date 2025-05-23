package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/foundation/layout/PaddingValues;)V", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "getBottom", BuildConfig.FLAVOR, "density", "Landroidx/compose/ui/unit/Density;", "getLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getRight", "getTop", "hashCode", "toString", BuildConfig.FLAVOR, "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.foundation.layout.PaddingValuesInsets, reason: from toString */
/* loaded from: classes.dex */
final class PaddingValues implements WindowInsets {
    private final androidx.compose.foundation.layout.PaddingValues paddingValues;

    public PaddingValues(androidx.compose.foundation.layout.PaddingValues paddingValues) {
        this.paddingValues = paddingValues;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PaddingValues) {
            return Intrinsics.areEqual(((PaddingValues) other).paddingValues, this.paddingValues);
        }
        return false;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(Density density) {
        return density.mo206roundToPx0680j_4(this.paddingValues.getBottom());
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(Density density, LayoutDirection layoutDirection) {
        return density.mo206roundToPx0680j_4(this.paddingValues.mo290calculateLeftPaddingu2uoSUM(layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(Density density, LayoutDirection layoutDirection) {
        return density.mo206roundToPx0680j_4(this.paddingValues.mo291calculateRightPaddingu2uoSUM(layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(Density density) {
        return density.mo206roundToPx0680j_4(this.paddingValues.getTop());
    }

    public int hashCode() {
        return this.paddingValues.hashCode();
    }

    public String toString() {
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        return "PaddingValues(" + ((Object) Dp.m2603toStringimpl(this.paddingValues.mo290calculateLeftPaddingu2uoSUM(layoutDirection))) + ", " + ((Object) Dp.m2603toStringimpl(this.paddingValues.getTop())) + ", " + ((Object) Dp.m2603toStringimpl(this.paddingValues.mo291calculateRightPaddingu2uoSUM(layoutDirection))) + ", " + ((Object) Dp.m2603toStringimpl(this.paddingValues.getBottom())) + ')';
    }
}
