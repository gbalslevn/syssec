package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00028V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "Landroidx/compose/runtime/State;", "Lkotlin/ranges/IntRange;", "firstVisibleItem", BuildConfig.FLAVOR, "slidingWindowSize", "extraItemCount", "(III)V", "lastFirstVisibleItem", "<set-?>", "value", "getValue", "()Lkotlin/ranges/IntRange;", "setValue", "(Lkotlin/ranges/IntRange;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "update", BuildConfig.FLAVOR, "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyLayoutNearestRangeState implements State<IntRange> {
    private static final Companion Companion = new Companion(null);
    private final int extraItemCount;
    private int lastFirstVisibleItem;
    private final int slidingWindowSize;

    /* renamed from: value$delegate, reason: from kotlin metadata */
    private final MutableState value;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState$Companion;", BuildConfig.FLAVOR, "()V", "calculateNearestItemsRange", "Lkotlin/ranges/IntRange;", "firstVisibleItem", BuildConfig.FLAVOR, "slidingWindowSize", "extraItemCount", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final IntRange calculateNearestItemsRange(int firstVisibleItem, int slidingWindowSize, int extraItemCount) {
            int i5 = (firstVisibleItem / slidingWindowSize) * slidingWindowSize;
            return RangesKt.until(Math.max(i5 - extraItemCount, 0), i5 + slidingWindowSize + extraItemCount);
        }

        private Companion() {
        }
    }

    public LazyLayoutNearestRangeState(int i5, int i6, int i7) {
        this.slidingWindowSize = i6;
        this.extraItemCount = i7;
        this.value = SnapshotStateKt.mutableStateOf(Companion.calculateNearestItemsRange(i5, i6, i7), SnapshotStateKt.structuralEqualityPolicy());
        this.lastFirstVisibleItem = i5;
    }

    private void setValue(IntRange intRange) {
        this.value.setValue(intRange);
    }

    public final void update(int firstVisibleItem) {
        if (firstVisibleItem != this.lastFirstVisibleItem) {
            this.lastFirstVisibleItem = firstVisibleItem;
            setValue(Companion.calculateNearestItemsRange(firstVisibleItem, this.slidingWindowSize, this.extraItemCount));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.State
    public IntRange getValue() {
        return (IntRange) this.value.getValue();
    }
}
