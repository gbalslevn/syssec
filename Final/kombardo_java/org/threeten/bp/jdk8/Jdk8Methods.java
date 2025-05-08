package org.threeten.bp.jdk8;

/* loaded from: classes3.dex */
public abstract class Jdk8Methods {
    public static int compareInts(int i5, int i6) {
        if (i5 < i6) {
            return -1;
        }
        return i5 > i6 ? 1 : 0;
    }

    public static int compareLongs(long j5, long j6) {
        if (j5 < j6) {
            return -1;
        }
        return j5 > j6 ? 1 : 0;
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static long floorDiv(long j5, long j6) {
        return j5 >= 0 ? j5 / j6 : ((j5 + 1) / j6) - 1;
    }

    public static long floorMod(long j5, long j6) {
        return ((j5 % j6) + j6) % j6;
    }

    public static <T> T requireNonNull(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str + " must not be null");
    }

    public static long safeAdd(long j5, long j6) {
        long j7 = j5 + j6;
        if ((j5 ^ j7) >= 0 || (j5 ^ j6) < 0) {
            return j7;
        }
        throw new ArithmeticException("Addition overflows a long: " + j5 + " + " + j6);
    }

    public static long safeMultiply(long j5, int i5) {
        if (i5 == -1) {
            if (j5 != Long.MIN_VALUE) {
                return -j5;
            }
            throw new ArithmeticException("Multiplication overflows a long: " + j5 + " * " + i5);
        }
        if (i5 == 0) {
            return 0L;
        }
        if (i5 == 1) {
            return j5;
        }
        long j6 = i5;
        long j7 = j5 * j6;
        if (j7 / j6 == j5) {
            return j7;
        }
        throw new ArithmeticException("Multiplication overflows a long: " + j5 + " * " + i5);
    }

    public static int safeSubtract(int i5, int i6) {
        int i7 = i5 - i6;
        if ((i5 ^ i7) >= 0 || (i5 ^ i6) >= 0) {
            return i7;
        }
        throw new ArithmeticException("Subtraction overflows an int: " + i5 + " - " + i6);
    }

    public static int safeToInt(long j5) {
        if (j5 <= 2147483647L && j5 >= -2147483648L) {
            return (int) j5;
        }
        throw new ArithmeticException("Calculation overflows an int: " + j5);
    }

    public static int floorDiv(int i5, int i6) {
        return i5 >= 0 ? i5 / i6 : ((i5 + 1) / i6) - 1;
    }

    public static int floorMod(long j5, int i5) {
        long j6 = i5;
        return (int) (((j5 % j6) + j6) % j6);
    }

    public static long safeSubtract(long j5, long j6) {
        long j7 = j5 - j6;
        if ((j5 ^ j7) >= 0 || (j5 ^ j6) >= 0) {
            return j7;
        }
        throw new ArithmeticException("Subtraction overflows a long: " + j5 + " - " + j6);
    }

    public static int floorMod(int i5, int i6) {
        return ((i5 % i6) + i6) % i6;
    }

    public static long safeMultiply(long j5, long j6) {
        if (j6 == 1) {
            return j5;
        }
        if (j5 == 1) {
            return j6;
        }
        if (j5 == 0 || j6 == 0) {
            return 0L;
        }
        long j7 = j5 * j6;
        if (j7 / j6 == j5 && ((j5 != Long.MIN_VALUE || j6 != -1) && (j6 != Long.MIN_VALUE || j5 != -1))) {
            return j7;
        }
        throw new ArithmeticException("Multiplication overflows a long: " + j5 + " * " + j6);
    }
}
