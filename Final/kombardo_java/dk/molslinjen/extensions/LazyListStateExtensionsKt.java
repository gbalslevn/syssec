package dk.molslinjen.extensions;

import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListState;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"isScrolledToTheEnd", BuildConfig.FLAVOR, "Landroidx/compose/foundation/lazy/LazyListState;", "bottomContentPaddingPixels", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class LazyListStateExtensionsKt {
    public static final boolean isScrolledToTheEnd(LazyListState lazyListState, float f5) {
        Intrinsics.checkNotNullParameter(lazyListState, "<this>");
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.lastOrNull((List) lazyListState.getLayoutInfo().getVisibleItemsInfo());
        return lazyListItemInfo == null || (f5 + ((float) lazyListItemInfo.getSize())) + ((float) lazyListItemInfo.getOffset()) <= ((float) lazyListState.getLayoutInfo().getViewportEndOffset());
    }
}
