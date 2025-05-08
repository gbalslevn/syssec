package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fR&\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/lazy/grid/GridSlotCache;", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "calculation", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "density", "constraints", "invoke-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "invoke", "Lkotlin/jvm/functions/Function2;", "cachedConstraints", "J", BuildConfig.FLAVOR, "cachedDensity", "F", "cachedSizes", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class GridSlotCache implements LazyGridSlotsProvider {
    private long cachedConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
    private float cachedDensity;
    private LazyGridSlots cachedSizes;
    private final Function2<Density, Constraints, LazyGridSlots> calculation;

    /* JADX WARN: Multi-variable type inference failed */
    public GridSlotCache(Function2<? super Density, ? super Constraints, LazyGridSlots> function2) {
        this.calculation = function2;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider
    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
    public LazyGridSlots mo387invoke0kLqBqw(Density density, long constraints) {
        if (this.cachedSizes != null && Constraints.m2572equalsimpl0(this.cachedConstraints, constraints) && this.cachedDensity == density.getDensity()) {
            LazyGridSlots lazyGridSlots = this.cachedSizes;
            Intrinsics.checkNotNull(lazyGridSlots);
            return lazyGridSlots;
        }
        this.cachedConstraints = constraints;
        this.cachedDensity = density.getDensity();
        LazyGridSlots invoke = this.calculation.invoke(density, Constraints.m2567boximpl(constraints));
        this.cachedSizes = invoke;
        return invoke;
    }
}
