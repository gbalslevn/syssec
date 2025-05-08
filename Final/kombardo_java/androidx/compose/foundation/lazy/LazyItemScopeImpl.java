package androidx.compose.foundation.lazy;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\n*\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\n*\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "<init>", "()V", BuildConfig.FLAVOR, "width", "height", BuildConfig.FLAVOR, "setMaxSize", "(II)V", "Landroidx/compose/ui/Modifier;", BuildConfig.FLAVOR, "fraction", "fillParentMaxWidth", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "fillParentMaxHeight", "Landroidx/compose/runtime/MutableIntState;", "maxWidthState", "Landroidx/compose/runtime/MutableIntState;", "maxHeightState", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyItemScopeImpl implements LazyItemScope {
    private MutableIntState maxWidthState = SnapshotIntStateKt.mutableIntStateOf(Integer.MAX_VALUE);
    private MutableIntState maxHeightState = SnapshotIntStateKt.mutableIntStateOf(Integer.MAX_VALUE);

    @Override // androidx.compose.foundation.lazy.LazyItemScope
    public Modifier fillParentMaxHeight(Modifier modifier, float f5) {
        return modifier.then(new ParentSizeElement(f5, null, this.maxHeightState, "fillParentMaxHeight", 2, null));
    }

    @Override // androidx.compose.foundation.lazy.LazyItemScope
    public Modifier fillParentMaxWidth(Modifier modifier, float f5) {
        return modifier.then(new ParentSizeElement(f5, this.maxWidthState, null, "fillParentMaxWidth", 4, null));
    }

    public final void setMaxSize(int width, int height) {
        this.maxWidthState.setIntValue(width);
        this.maxHeightState.setIntValue(height);
    }
}
