package kotlin.text;

import com.sun.jna.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a\u001b\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0003H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\u0003H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000e\u001a\u00020\r*\u00020\u0003H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0013\u0010\u0010\u001a\u00020\u0000*\u00020\u0003H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0007*\u00020\u0003H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u0007*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0012\u0010\u0014\u001a\u0015\u0010\u0015\u001a\u0004\u0018\u00010\n*\u00020\u0003H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001d\u0010\u0015\u001a\u0004\u0018\u00010\n*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0015\u0010\u0017\u001a\u0015\u0010\u0018\u001a\u0004\u0018\u00010\r*\u00020\u0003H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001d\u0010\u0018\u001a\u0004\u0018\u00010\r*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0018\u0010\u001a\u001a\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0000*\u00020\u0003H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u0000*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u001b\u0010\u001d¨\u0006\u001e"}, d2 = {"Lkotlin/ULong;", BuildConfig.FLAVOR, "radix", BuildConfig.FLAVOR, "toString-JSWoG40", "(JI)Ljava/lang/String;", "toString", "Lkotlin/UByte;", "toUByte", "(Ljava/lang/String;)B", "Lkotlin/UShort;", "toUShort", "(Ljava/lang/String;)S", "Lkotlin/UInt;", "toUInt", "(Ljava/lang/String;)I", "toULong", "(Ljava/lang/String;)J", "toUByteOrNull", "(Ljava/lang/String;)Lkotlin/UByte;", "(Ljava/lang/String;I)Lkotlin/UByte;", "toUShortOrNull", "(Ljava/lang/String;)Lkotlin/UShort;", "(Ljava/lang/String;I)Lkotlin/UShort;", "toUIntOrNull", "(Ljava/lang/String;)Lkotlin/UInt;", "(Ljava/lang/String;I)Lkotlin/UInt;", "toULongOrNull", "(Ljava/lang/String;)Lkotlin/ULong;", "(Ljava/lang/String;I)Lkotlin/ULong;", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class UStringsKt {
    /* renamed from: toString-JSWoG40, reason: not valid java name */
    public static final String m3724toStringJSWoG40(long j5, int i5) {
        return UnsignedKt.ulongToString(j5, CharsKt.checkRadix(i5));
    }

    public static final byte toUByte(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UByte uByteOrNull = toUByteOrNull(str);
        if (uByteOrNull != null) {
            return uByteOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final UByte toUByteOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toUByteOrNull(str, 10);
    }

    public static final int toUInt(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntOrNull = toUIntOrNull(str);
        if (uIntOrNull != null) {
            return uIntOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final UInt toUIntOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toUIntOrNull(str, 10);
    }

    public static final long toULong(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ULong uLongOrNull = toULongOrNull(str);
        if (uLongOrNull != null) {
            return uLongOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final ULong toULongOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toULongOrNull(str, 10);
    }

    public static final short toUShort(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UShort uShortOrNull = toUShortOrNull(str);
        if (uShortOrNull != null) {
            return uShortOrNull.getData();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final UShort toUShortOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toUShortOrNull(str, 10);
    }

    public static final UByte toUByteOrNull(String str, int i5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntOrNull = toUIntOrNull(str, i5);
        if (uIntOrNull == null) {
            return null;
        }
        int data = uIntOrNull.getData();
        if (Integer.compareUnsigned(data, UInt.m3599constructorimpl(Function.USE_VARARGS)) > 0) {
            return null;
        }
        return UByte.m3576boximpl(UByte.m3577constructorimpl((byte) data));
    }

    public static final UInt toUIntOrNull(String str, int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt.checkRadix(i5);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i7 = 0;
        char charAt = str.charAt(0);
        if (Intrinsics.compare((int) charAt, 48) < 0) {
            i6 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        } else {
            i6 = 0;
        }
        int m3599constructorimpl = UInt.m3599constructorimpl(i5);
        int i8 = 119304647;
        while (i6 < length) {
            int digitOf = CharsKt__CharJVMKt.digitOf(str.charAt(i6), i5);
            if (digitOf < 0) {
                return null;
            }
            if (Integer.compareUnsigned(i7, i8) > 0) {
                if (i8 == 119304647) {
                    i8 = Integer.divideUnsigned(-1, m3599constructorimpl);
                    if (Integer.compareUnsigned(i7, i8) > 0) {
                    }
                }
                return null;
            }
            int m3599constructorimpl2 = UInt.m3599constructorimpl(i7 * m3599constructorimpl);
            int m3599constructorimpl3 = UInt.m3599constructorimpl(UInt.m3599constructorimpl(digitOf) + m3599constructorimpl2);
            if (Integer.compareUnsigned(m3599constructorimpl3, m3599constructorimpl2) < 0) {
                return null;
            }
            i6++;
            i7 = m3599constructorimpl3;
        }
        return UInt.m3598boximpl(i7);
    }

    public static final ULong toULongOrNull(String str, int i5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt.checkRadix(i5);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i6 = 0;
        char charAt = str.charAt(0);
        if (Intrinsics.compare((int) charAt, 48) < 0) {
            i6 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        }
        long m3622constructorimpl = ULong.m3622constructorimpl(i5);
        long j5 = 0;
        long j6 = 512409557603043100L;
        while (i6 < length) {
            if (CharsKt__CharJVMKt.digitOf(str.charAt(i6), i5) < 0) {
                return null;
            }
            if (Long.compareUnsigned(j5, j6) > 0) {
                if (j6 == 512409557603043100L) {
                    j6 = Long.divideUnsigned(-1L, m3622constructorimpl);
                    if (Long.compareUnsigned(j5, j6) > 0) {
                    }
                }
                return null;
            }
            long m3622constructorimpl2 = ULong.m3622constructorimpl(j5 * m3622constructorimpl);
            long m3622constructorimpl3 = ULong.m3622constructorimpl(ULong.m3622constructorimpl(UInt.m3599constructorimpl(r13) & 4294967295L) + m3622constructorimpl2);
            if (Long.compareUnsigned(m3622constructorimpl3, m3622constructorimpl2) < 0) {
                return null;
            }
            i6++;
            j5 = m3622constructorimpl3;
        }
        return ULong.m3621boximpl(j5);
    }

    public static final UShort toUShortOrNull(String str, int i5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntOrNull = toUIntOrNull(str, i5);
        if (uIntOrNull == null) {
            return null;
        }
        int data = uIntOrNull.getData();
        if (Integer.compareUnsigned(data, UInt.m3599constructorimpl(65535)) > 0) {
            return null;
        }
        return UShort.m3645boximpl(UShort.m3646constructorimpl((short) data));
    }
}
