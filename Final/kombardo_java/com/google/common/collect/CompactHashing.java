package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class CompactHashing {
    private static final int BYTE_MASK = 255;
    private static final int BYTE_MAX_SIZE = 256;
    private static final int HASH_TABLE_BITS_MAX_BITS = 5;
    private static final int MIN_HASH_TABLE_SIZE = 4;
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_MAX_SIZE = 65536;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object createTable(int i5) {
        if (i5 >= 2 && i5 <= 1073741824 && Integer.highestOneBit(i5) == i5) {
            return i5 <= 256 ? new byte[i5] : i5 <= SHORT_MAX_SIZE ? new short[i5] : new int[i5];
        }
        StringBuilder sb = new StringBuilder(52);
        sb.append("must be power of 2 between 2^1 and 2^30: ");
        sb.append(i5);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getHashPrefix(int i5, int i6) {
        return i5 & (~i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getNext(int i5, int i6) {
        return i5 & i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int maskCombine(int i5, int i6, int i7) {
        return (i5 & (~i7)) | (i6 & i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int newCapacity(int i5) {
        return (i5 < 32 ? 4 : 2) * (i5 + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int remove(Object obj, Object obj2, int i5, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i6;
        int i7;
        int smearedHash = Hashing.smearedHash(obj);
        int i8 = smearedHash & i5;
        int tableGet = tableGet(obj3, i8);
        if (tableGet == 0) {
            return -1;
        }
        int hashPrefix = getHashPrefix(smearedHash, i5);
        int i9 = -1;
        while (true) {
            i6 = tableGet - 1;
            i7 = iArr[i6];
            if (getHashPrefix(i7, i5) != hashPrefix || !Objects.equal(obj, objArr[i6]) || (objArr2 != null && !Objects.equal(obj2, objArr2[i6]))) {
                int next = getNext(i7, i5);
                if (next == 0) {
                    return -1;
                }
                i9 = i6;
                tableGet = next;
            }
        }
        int next2 = getNext(i7, i5);
        if (i9 == -1) {
            tableSet(obj3, i8, next2);
        } else {
            iArr[i9] = maskCombine(iArr[i9], next2, i5);
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void tableClear(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int tableGet(Object obj, int i5) {
        return obj instanceof byte[] ? ((byte[]) obj)[i5] & 255 : obj instanceof short[] ? ((short[]) obj)[i5] & SHORT_MASK : ((int[]) obj)[i5];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void tableSet(Object obj, int i5, int i6) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i5] = (byte) i6;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i5] = (short) i6;
        } else {
            ((int[]) obj)[i5] = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int tableSize(int i5) {
        return Math.max(4, Hashing.closedTableSize(i5 + 1, 1.0d));
    }
}
