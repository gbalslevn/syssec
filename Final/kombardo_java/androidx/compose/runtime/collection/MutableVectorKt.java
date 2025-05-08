package androidx.compose.runtime.collection;

import java.util.List;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a'\u0010\b\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {BuildConfig.FLAVOR, BuildConfig.FLAVOR, "index", BuildConfig.FLAVOR, "checkIndex", "(Ljava/util/List;I)V", "fromIndex", "toIndex", "checkSubIndex", "(Ljava/util/List;II)V", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class MutableVectorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkIndex(List<?> list, int i5) {
        int size = list.size();
        if (i5 < 0 || i5 >= size) {
            throw new IndexOutOfBoundsException("Index " + i5 + " is out of bounds. The list has " + size + " elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkSubIndex(List<?> list, int i5, int i6) {
        int size = list.size();
        if (i5 > i6) {
            throw new IllegalArgumentException("Indices are out of order. fromIndex (" + i5 + ") is greater than toIndex (" + i6 + ").");
        }
        if (i5 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i5 + ") is less than 0.");
        }
        if (i6 <= size) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i6 + ") is more than than the list size (" + size + ')');
    }
}
