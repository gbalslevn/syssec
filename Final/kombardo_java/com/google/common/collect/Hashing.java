package com.google.common.collect;

/* loaded from: classes2.dex */
abstract class Hashing {

    /* renamed from: C1, reason: collision with root package name */
    private static final long f4350C1 = -862048943;

    /* renamed from: C2, reason: collision with root package name */
    private static final long f4351C2 = 461845907;
    private static final int MAX_TABLE_SIZE = 1073741824;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int closedTableSize(int i5, double d5) {
        int max = Math.max(i5, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (d5 * highestOneBit))) {
            return highestOneBit;
        }
        int i6 = highestOneBit << 1;
        return i6 > 0 ? i6 : MAX_TABLE_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int smear(int i5) {
        return (int) (Integer.rotateLeft((int) (i5 * f4350C1), 15) * f4351C2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int smearedHash(Object obj) {
        return smear(obj == null ? 0 : obj.hashCode());
    }
}
