package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¨\u0006\u0006"}, d2 = {"binarySearch", BuildConfig.FLAVOR, "T", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "itemIndex", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class IntervalListKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> int binarySearch(MutableVector<IntervalList.Interval<T>> mutableVector, int i5) {
        int size = mutableVector.getSize() - 1;
        int i6 = 0;
        while (i6 < size) {
            int i7 = ((size - i6) / 2) + i6;
            int startIndex = mutableVector.getContent()[i7].getStartIndex();
            if (startIndex == i5) {
                return i7;
            }
            if (startIndex < i5) {
                i6 = i7 + 1;
                if (i5 < mutableVector.getContent()[i6].getStartIndex()) {
                    return i7;
                }
            } else {
                size = i7 - 1;
            }
        }
        return i6;
    }
}
