package com.google.firebase.perf.util;

/* loaded from: classes2.dex */
public enum StorageUnit {
    TERABYTES(1099511627776L) { // from class: com.google.firebase.perf.util.StorageUnit.1
    },
    GIGABYTES(1073741824) { // from class: com.google.firebase.perf.util.StorageUnit.2
    },
    MEGABYTES(1048576) { // from class: com.google.firebase.perf.util.StorageUnit.3
    },
    KILOBYTES(1024) { // from class: com.google.firebase.perf.util.StorageUnit.4
    },
    BYTES(1) { // from class: com.google.firebase.perf.util.StorageUnit.5
    };

    long numBytes;

    public long toKilobytes(long j5) {
        return (j5 * this.numBytes) / KILOBYTES.numBytes;
    }

    StorageUnit(long j5) {
        this.numBytes = j5;
    }
}
