package com.sun.jna;

/* loaded from: classes2.dex */
public class NativeLong extends IntegerType {
    public static final int SIZE = Native.LONG_SIZE;
    private static final long serialVersionUID = 1;

    public NativeLong() {
        this(0L);
    }

    public NativeLong(long j5) {
        this(j5, false);
    }

    public NativeLong(long j5, boolean z5) {
        super(SIZE, j5, z5);
    }
}
