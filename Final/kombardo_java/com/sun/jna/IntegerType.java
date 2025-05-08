package com.sun.jna;

/* loaded from: classes2.dex */
public abstract class IntegerType extends Number implements NativeMapped {
    private static final long serialVersionUID = 1;
    private Number number;
    private int size;
    private boolean unsigned;
    private long value;

    public IntegerType(int i5) {
        this(i5, 0L, false);
    }

    public static final int compare(long j5, long j6) {
        if (j5 == j6) {
            return 0;
        }
        return j5 < j6 ? -1 : 1;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.number.doubleValue();
    }

    public boolean equals(Object obj) {
        return (obj instanceof IntegerType) && this.number.equals(((IntegerType) obj).number);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.number.floatValue();
    }

    @Override // com.sun.jna.NativeMapped
    public Object fromNative(Object obj, FromNativeContext fromNativeContext) {
        long longValue = obj == null ? 0L : ((Number) obj).longValue();
        IntegerType integerType = (IntegerType) Klass.newInstance(getClass());
        integerType.setValue(longValue);
        return integerType;
    }

    public int hashCode() {
        return this.number.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    @Override // com.sun.jna.NativeMapped
    public Class<?> nativeType() {
        return this.number.getClass();
    }

    public void setValue(long j5) {
        long j6;
        this.value = j5;
        int i5 = this.size;
        if (i5 == 1) {
            if (this.unsigned) {
                this.value = 255 & j5;
            }
            byte b5 = (byte) j5;
            j6 = b5;
            this.number = Byte.valueOf(b5);
        } else if (i5 == 2) {
            if (this.unsigned) {
                this.value = 65535 & j5;
            }
            short s5 = (short) j5;
            j6 = s5;
            this.number = Short.valueOf(s5);
        } else if (i5 == 4) {
            if (this.unsigned) {
                this.value = 4294967295L & j5;
            }
            int i6 = (int) j5;
            j6 = i6;
            this.number = Integer.valueOf(i6);
        } else {
            if (i5 != 8) {
                throw new IllegalArgumentException("Unsupported size: " + this.size);
            }
            this.number = Long.valueOf(j5);
            j6 = j5;
        }
        int i7 = this.size;
        if (i7 < 8) {
            long j7 = ~((1 << (i7 * 8)) - 1);
            if ((j5 >= 0 || j6 == j5) && (j5 < 0 || (j7 & j5) == 0)) {
                return;
            }
            throw new IllegalArgumentException("Argument value 0x" + Long.toHexString(j5) + " exceeds native capacity (" + this.size + " bytes) mask=0x" + Long.toHexString(j7));
        }
    }

    @Override // com.sun.jna.NativeMapped
    public Object toNative() {
        return this.number;
    }

    public String toString() {
        return this.number.toString();
    }

    public IntegerType(int i5, boolean z5) {
        this(i5, 0L, z5);
    }

    public static <T extends IntegerType> int compare(T t5, T t6) {
        if (t5 == t6) {
            return 0;
        }
        if (t5 == null) {
            return 1;
        }
        if (t6 == null) {
            return -1;
        }
        return compare(t5.longValue(), t6.longValue());
    }

    public IntegerType(int i5, long j5) {
        this(i5, j5, false);
    }

    public static int compare(IntegerType integerType, long j5) {
        if (integerType == null) {
            return 1;
        }
        return compare(integerType.longValue(), j5);
    }

    public IntegerType(int i5, long j5, boolean z5) {
        this.size = i5;
        this.unsigned = z5;
        setValue(j5);
    }
}
