package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u000eJ\u001d\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R+\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00028F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\u001dR+\u0010\u0005\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00048F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010\u001aR\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0017\u00102\u001a\u0002018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00066"}, d2 = {"Landroidx/compose/foundation/pager/PagerScrollPosition;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "currentPage", BuildConfig.FLAVOR, "currentPageOffsetFraction", "Landroidx/compose/foundation/pager/PagerState;", "state", "<init>", "(IFLandroidx/compose/foundation/pager/PagerState;)V", "page", "offsetFraction", BuildConfig.FLAVOR, "update", "(IF)V", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "measureResult", "updateFromMeasureResult", "(Landroidx/compose/foundation/pager/PagerMeasureResult;)V", "index", "requestPositionAndForgetLastKnownKey", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "itemProvider", "matchPageWithKey", "(Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;I)I", "updateCurrentPageOffsetFraction", "(F)V", "delta", "applyScrollDelta", "(I)V", "Landroidx/compose/foundation/pager/PagerState;", "getState", "()Landroidx/compose/foundation/pager/PagerState;", "<set-?>", "currentPage$delegate", "Landroidx/compose/runtime/MutableIntState;", "getCurrentPage", "()I", "setCurrentPage", "currentPageOffsetFraction$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getCurrentPageOffsetFraction", "()F", "setCurrentPageOffsetFraction", BuildConfig.FLAVOR, "hadFirstNotEmptyLayout", "Z", "lastKnownCurrentPageKey", "Ljava/lang/Object;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagerScrollPosition {

    /* renamed from: currentPage$delegate, reason: from kotlin metadata */
    private final MutableIntState currentPage;

    /* renamed from: currentPageOffsetFraction$delegate, reason: from kotlin metadata */
    private final MutableFloatState currentPageOffsetFraction;
    private boolean hadFirstNotEmptyLayout;
    private Object lastKnownCurrentPageKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final PagerState state;

    public PagerScrollPosition(int i5, float f5, PagerState pagerState) {
        this.state = pagerState;
        this.currentPage = SnapshotIntStateKt.mutableIntStateOf(i5);
        this.currentPageOffsetFraction = PrimitiveSnapshotStateKt.mutableFloatStateOf(f5);
        this.nearestRangeState = new LazyLayoutNearestRangeState(i5, 30, 100);
    }

    private final void setCurrentPage(int i5) {
        this.currentPage.setIntValue(i5);
    }

    private final void setCurrentPageOffsetFraction(float f5) {
        this.currentPageOffsetFraction.setFloatValue(f5);
    }

    private final void update(int page, float offsetFraction) {
        setCurrentPage(page);
        this.nearestRangeState.update(page);
        setCurrentPageOffsetFraction(offsetFraction);
    }

    public final void applyScrollDelta(int delta) {
        setCurrentPageOffsetFraction(getCurrentPageOffsetFraction() + (this.state.getPageSizeWithSpacing$foundation_release() == 0 ? 0.0f : delta / this.state.getPageSizeWithSpacing$foundation_release()));
    }

    public final int getCurrentPage() {
        return this.currentPage.getIntValue();
    }

    public final float getCurrentPageOffsetFraction() {
        return this.currentPageOffsetFraction.getFloatValue();
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    public final int matchPageWithKey(PagerLazyLayoutItemProvider itemProvider, int index) {
        int findIndexByKey = LazyLayoutItemProviderKt.findIndexByKey(itemProvider, this.lastKnownCurrentPageKey, index);
        if (index != findIndexByKey) {
            setCurrentPage(findIndexByKey);
            this.nearestRangeState.update(index);
        }
        return findIndexByKey;
    }

    public final void requestPositionAndForgetLastKnownKey(int index, float offsetFraction) {
        update(index, offsetFraction);
        this.lastKnownCurrentPageKey = null;
    }

    public final void updateCurrentPageOffsetFraction(float offsetFraction) {
        setCurrentPageOffsetFraction(offsetFraction);
    }

    public final void updateFromMeasureResult(PagerMeasureResult measureResult) {
        MeasuredPage currentPage = measureResult.getCurrentPage();
        this.lastKnownCurrentPageKey = currentPage != null ? currentPage.getKey() : null;
        if (this.hadFirstNotEmptyLayout || !measureResult.getVisiblePagesInfo().isEmpty()) {
            this.hadFirstNotEmptyLayout = true;
            MeasuredPage currentPage2 = measureResult.getCurrentPage();
            update(currentPage2 != null ? currentPage2.getIndex() : 0, measureResult.getCurrentPageOffsetFraction());
        }
    }
}
