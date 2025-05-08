package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.C0683SegmentedByteString;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\t\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "fromIndex", "toIndex", "binarySearch", "([IIII)I", "Lokio/SegmentedByteString;", "pos", "segment", "(Lokio/SegmentedByteString;I)I", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* renamed from: okio.internal.-SegmentedByteString, reason: invalid class name */
/* loaded from: classes3.dex */
public abstract class SegmentedByteString {
    public static final int binarySearch(int[] iArr, int i5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i8 = i7 - 1;
        while (i6 <= i8) {
            int i9 = (i6 + i8) >>> 1;
            int i10 = iArr[i9];
            if (i10 < i5) {
                i6 = i9 + 1;
            } else {
                if (i10 <= i5) {
                    return i9;
                }
                i8 = i9 - 1;
            }
        }
        return (-i6) - 1;
    }

    public static final int segment(C0683SegmentedByteString c0683SegmentedByteString, int i5) {
        Intrinsics.checkNotNullParameter(c0683SegmentedByteString, "<this>");
        int binarySearch = binarySearch(c0683SegmentedByteString.getDirectory(), i5 + 1, 0, c0683SegmentedByteString.getSegments().length);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }
}
