package androidx.compose.foundation.lazy;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\b\b\u0003\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\b\b\u0003\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/lazy/LazyItemScope;", BuildConfig.FLAVOR, "Landroidx/compose/ui/Modifier;", BuildConfig.FLAVOR, "fraction", "fillParentMaxWidth", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "fillParentMaxHeight", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface LazyItemScope {
    static /* synthetic */ Modifier fillParentMaxHeight$default(LazyItemScope lazyItemScope, Modifier modifier, float f5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillParentMaxHeight");
        }
        if ((i5 & 1) != 0) {
            f5 = 1.0f;
        }
        return lazyItemScope.fillParentMaxHeight(modifier, f5);
    }

    static /* synthetic */ Modifier fillParentMaxWidth$default(LazyItemScope lazyItemScope, Modifier modifier, float f5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillParentMaxWidth");
        }
        if ((i5 & 1) != 0) {
            f5 = 1.0f;
        }
        return lazyItemScope.fillParentMaxWidth(modifier, f5);
    }

    Modifier fillParentMaxHeight(Modifier modifier, float f5);

    Modifier fillParentMaxWidth(Modifier modifier, float f5);
}
