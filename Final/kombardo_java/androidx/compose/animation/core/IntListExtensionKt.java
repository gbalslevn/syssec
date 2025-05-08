package androidx.compose.animation.core;

import androidx.collection.IntList;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0001¨\u0006\u0006"}, d2 = {"binarySearch", BuildConfig.FLAVOR, "Landroidx/collection/IntList;", "element", "fromIndex", "toIndex", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class IntListExtensionKt {
    public static final int binarySearch(IntList intList, int i5, int i6, int i7) {
        if (!(i6 <= i7)) {
            PreconditionsKt.throwIllegalArgumentException("fromIndex(" + i6 + ") > toIndex(" + i7 + ')');
        }
        if (i6 < 0) {
            throw new IndexOutOfBoundsException("Index out of range: " + i6);
        }
        if (i7 > intList.get_size()) {
            throw new IndexOutOfBoundsException("Index out of range: " + i7);
        }
        int i8 = i7 - 1;
        while (i6 <= i8) {
            int i9 = (i6 + i8) >>> 1;
            int i10 = intList.get(i9);
            if (i10 < i5) {
                i6 = i9 + 1;
            } else {
                if (i10 <= i5) {
                    return i9;
                }
                i8 = i9 - 1;
            }
        }
        return -(i6 + 1);
    }

    public static /* synthetic */ int binarySearch$default(IntList intList, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = intList.get_size();
        }
        return binarySearch(intList, i5, i6, i7);
    }
}
