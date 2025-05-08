package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"LazyGridPrefetchStrategy", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "nestedPrefetchItemCount", BuildConfig.FLAVOR, "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LazyGridPrefetchStrategyKt {
    public static final LazyGridPrefetchStrategy LazyGridPrefetchStrategy(int i5) {
        return new DefaultLazyGridPrefetchStrategy(i5);
    }

    public static /* synthetic */ LazyGridPrefetchStrategy LazyGridPrefetchStrategy$default(int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = 2;
        }
        return LazyGridPrefetchStrategy(i5);
    }
}
