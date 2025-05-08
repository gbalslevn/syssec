package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\tJ)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/grid/GridCells;", BuildConfig.FLAVOR, "Landroidx/compose/ui/unit/Density;", BuildConfig.FLAVOR, "availableSize", "spacing", BuildConfig.FLAVOR, "calculateCrossAxisCellSizes", "(Landroidx/compose/ui/unit/Density;II)Ljava/util/List;", "Adaptive", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface GridCells {

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/lazy/grid/GridCells$Adaptive;", "Landroidx/compose/foundation/lazy/grid/GridCells;", "minSize", "Landroidx/compose/ui/unit/Dp;", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "calculateCrossAxisCellSizes", BuildConfig.FLAVOR, "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Adaptive implements GridCells {
        private final float minSize;

        public /* synthetic */ Adaptive(float f5, DefaultConstructorMarker defaultConstructorMarker) {
            this(f5);
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        public List<Integer> calculateCrossAxisCellSizes(Density density, int i5, int i6) {
            List<Integer> calculateCellsCrossAxisSizeImpl;
            calculateCellsCrossAxisSizeImpl = LazyGridDslKt.calculateCellsCrossAxisSizeImpl(i5, Math.max((i5 + i6) / (density.mo206roundToPx0680j_4(this.minSize) + i6), 1), i6);
            return calculateCellsCrossAxisSizeImpl;
        }

        public boolean equals(Object other) {
            return (other instanceof Adaptive) && Dp.m2601equalsimpl0(this.minSize, ((Adaptive) other).minSize);
        }

        public int hashCode() {
            return Dp.m2602hashCodeimpl(this.minSize);
        }

        private Adaptive(float f5) {
            this.minSize = f5;
            if (Dp.m2598compareTo0680j_4(f5, Dp.m2599constructorimpl(0)) > 0) {
                return;
            }
            throw new IllegalArgumentException(("Provided min size " + ((Object) Dp.m2603toStringimpl(f5)) + " should be larger than zero.").toString());
        }
    }

    List<Integer> calculateCrossAxisCellSizes(Density density, int i5, int i6);
}
