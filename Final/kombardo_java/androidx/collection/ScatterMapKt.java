package androidx.collection;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u001a%\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0013\u0010\u0011\u001a\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0014\u0010\u0011\u001a\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0015\u0010\u0011\"\u0014\u0010\u0016\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\"\"\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u00190\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b*\f\b\u0000\u0010\u001d\"\u00020\u001c2\u00020\u001c*\f\b\u0000\u0010\u001e\"\u00020\u001c2\u00020\u001c*\f\b\u0000\u0010\u001f\"\u00020\u001c2\u00020\u001c¨\u0006 "}, d2 = {"K", "V", "Landroidx/collection/MutableScatterMap;", "mutableScatterMapOf", "()Landroidx/collection/MutableScatterMap;", BuildConfig.FLAVOR, "metadata", BuildConfig.FLAVOR, "capacity", BuildConfig.FLAVOR, "convertMetadataForCleanup", "([JI)V", "start", "end", "findEmptySlot", "([JII)I", "nextCapacity", "(I)I", "n", "normalizeCapacity", "loadedCapacity", "unloadedCapacity", "EmptyGroup", "[J", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "EmptyScatterMap", "Landroidx/collection/MutableScatterMap;", BuildConfig.FLAVOR, "Bitmask", "Group", "StaticBitmask", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ScatterMapKt {
    public static final long[] EmptyGroup = {-9187201950435737345L, -1};
    private static final MutableScatterMap EmptyScatterMap = new MutableScatterMap(0);

    public static final void convertMetadataForCleanup(long[] metadata, int i5) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        int i6 = (i5 + 7) >> 3;
        for (int i7 = 0; i7 < i6; i7++) {
            long j5 = metadata[i7] & (-9187201950435737472L);
            metadata[i7] = (-72340172838076674L) & ((~j5) + (j5 >>> 7));
        }
        int lastIndex = ArraysKt.getLastIndex(metadata);
        int i8 = lastIndex - 1;
        metadata[i8] = (metadata[i8] & 72057594037927935L) | (-72057594037927936L);
        metadata[lastIndex] = metadata[0];
    }

    public static final int findEmptySlot(long[] metadata, int i5, int i6) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        while (i5 < i6) {
            if (((metadata[i5 >> 3] >> ((i5 & 7) << 3)) & 255) == 128) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static final int loadedCapacity(int i5) {
        if (i5 == 7) {
            return 6;
        }
        return i5 - (i5 / 8);
    }

    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf() {
        return new MutableScatterMap<>(0, 1, null);
    }

    public static final int nextCapacity(int i5) {
        if (i5 == 0) {
            return 6;
        }
        return (i5 * 2) + 1;
    }

    public static final int normalizeCapacity(int i5) {
        if (i5 > 0) {
            return (-1) >>> Integer.numberOfLeadingZeros(i5);
        }
        return 0;
    }

    public static final int unloadedCapacity(int i5) {
        if (i5 == 7) {
            return 8;
        }
        return i5 + ((i5 - 1) / 7);
    }
}
