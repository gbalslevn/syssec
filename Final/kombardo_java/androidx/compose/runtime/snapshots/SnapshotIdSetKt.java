package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"binarySearch", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SnapshotIdSetKt {
    public static final int binarySearch(int[] iArr, int i5) {
        int length = iArr.length - 1;
        int i6 = 0;
        while (i6 <= length) {
            int i7 = (i6 + length) >>> 1;
            int i8 = iArr[i7];
            if (i5 > i8) {
                i6 = i7 + 1;
            } else {
                if (i5 >= i8) {
                    return i7;
                }
                length = i7 - 1;
            }
        }
        return -(i6 + 1);
    }
}
