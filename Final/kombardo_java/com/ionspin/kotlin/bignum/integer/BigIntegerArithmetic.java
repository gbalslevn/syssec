package com.ionspin.kotlin.bignum.integer;

import com.adjust.sdk.Constants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ULongArray;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0010\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0011\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u000eJ%\u0010\u0013\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u000eJ1\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00142\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ(\u0010\"\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0004H&ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b \u0010!J%\u0010&\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0004H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%J\u001d\u0010+\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*J\u001d\u00100\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/J\u001d\u00105\u001a\u00020\u00022\u0006\u00102\u001a\u000201H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104J\u001d\u0010:\u001a\u00020\u00022\u0006\u00107\u001a\u000206H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00109J \u0010=\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u0019H&ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b<\u0010*J \u0010@\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u0004H&ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b?\u0010/J \u0010D\u001a\u00020\u00022\u0006\u0010B\u001a\u00020AH&ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bC\u00104J \u0010H\u001a\u00020\u00022\u0006\u0010F\u001a\u00020EH&ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bG\u00109J%\u0010K\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00022\u0006\u0010I\u001a\u00020\u0002H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bJ\u0010\u000eR\u001d\u0010N\u001a\u00020\u00028&X¦\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bL\u0010MR\u001d\u0010P\u001a\u00020\u00028&X¦\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bO\u0010MR\u001d\u0010R\u001a\u00020\u00028&X¦\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bQ\u0010MR\u001d\u0010T\u001a\u00020\u00028&X¦\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bS\u0010M\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006U"}, d2 = {"Lcom/ionspin/kotlin/bignum/integer/BigIntegerArithmetic;", BuildConfig.FLAVOR, "Lkotlin/ULongArray;", "value", BuildConfig.FLAVOR, "bitLength-QwZRm1k", "([J)I", "bitLength", "first", "second", "compare-GR1PJdc", "([J[J)I", "compare", "add-j68ebKY", "([J[J)[J", "add", "subtract-j68ebKY", "subtract", "multiply-j68ebKY", "multiply", "Lkotlin/Pair;", "divide-GR1PJdc", "([J[J)Lkotlin/Pair;", "divide", "base", BuildConfig.FLAVOR, "exponent", "pow-GERUpyg", "([JJ)[J", "pow", BuildConfig.FLAVOR, "number", "parseForBase-_llDaS8", "(Ljava/lang/String;I)[J", "parseForBase", "operand", "toString-tBf0fek", "([JI)Ljava/lang/String;", "toString", "Lkotlin/ULong;", "uLong", "fromULong--GCcj4Q", "(J)[J", "fromULong", "Lkotlin/UInt;", "uInt", "fromUInt-kOc6_GI", "(I)[J", "fromUInt", "Lkotlin/UShort;", "uShort", "fromUShort-jOPi9CM", "(S)[J", "fromUShort", "Lkotlin/UByte;", "uByte", "fromUByte-ab45Ak8", "(B)[J", "fromUByte", Constants.LONG, "fromLong-DHQ6RzY", "fromLong", "int", "fromInt-DHQ6RzY", "fromInt", BuildConfig.FLAVOR, "short", "fromShort-DHQ6RzY", "fromShort", BuildConfig.FLAVOR, "byte", "fromByte-DHQ6RzY", "fromByte", "mask", "xor-j68ebKY", "xor", "getZERO-Y2RjT0g", "()[J", "ZERO", "getONE-Y2RjT0g", "ONE", "getTWO-Y2RjT0g", "TWO", "getTEN-Y2RjT0g", "TEN", "bignum"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public interface BigIntegerArithmetic {
    /* renamed from: add-j68ebKY, reason: not valid java name */
    long[] mo2935addj68ebKY(long[] first, long[] second);

    /* renamed from: bitLength-QwZRm1k, reason: not valid java name */
    int mo2936bitLengthQwZRm1k(long[] value);

    /* renamed from: compare-GR1PJdc, reason: not valid java name */
    int mo2937compareGR1PJdc(long[] first, long[] second);

    /* renamed from: divide-GR1PJdc, reason: not valid java name */
    Pair<ULongArray, ULongArray> mo2938divideGR1PJdc(long[] first, long[] second);

    /* renamed from: fromByte-DHQ6RzY, reason: not valid java name */
    long[] mo2939fromByteDHQ6RzY(byte r12);

    /* renamed from: fromInt-DHQ6RzY, reason: not valid java name */
    long[] mo2940fromIntDHQ6RzY(int r12);

    /* renamed from: fromLong-DHQ6RzY, reason: not valid java name */
    long[] mo2941fromLongDHQ6RzY(long r12);

    /* renamed from: fromShort-DHQ6RzY, reason: not valid java name */
    long[] mo2942fromShortDHQ6RzY(short r12);

    /* renamed from: fromUByte-ab45Ak8, reason: not valid java name */
    long[] mo2943fromUByteab45Ak8(byte uByte);

    /* renamed from: fromUInt-kOc6_GI, reason: not valid java name */
    long[] mo2944fromUIntkOc6_GI(int uInt);

    /* renamed from: fromULong--GCcj4Q, reason: not valid java name */
    long[] mo2945fromULongGCcj4Q(long uLong);

    /* renamed from: fromUShort-jOPi9CM, reason: not valid java name */
    long[] mo2946fromUShortjOPi9CM(short uShort);

    /* renamed from: getONE-Y2RjT0g, reason: not valid java name */
    long[] mo2947getONEY2RjT0g();

    /* renamed from: getTEN-Y2RjT0g, reason: not valid java name */
    long[] mo2948getTENY2RjT0g();

    /* renamed from: getTWO-Y2RjT0g, reason: not valid java name */
    long[] mo2949getTWOY2RjT0g();

    /* renamed from: getZERO-Y2RjT0g, reason: not valid java name */
    long[] mo2950getZEROY2RjT0g();

    /* renamed from: multiply-j68ebKY, reason: not valid java name */
    long[] mo2951multiplyj68ebKY(long[] first, long[] second);

    /* renamed from: parseForBase-_llDaS8, reason: not valid java name */
    long[] mo2952parseForBase_llDaS8(String number, int base);

    /* renamed from: pow-GERUpyg, reason: not valid java name */
    long[] mo2953powGERUpyg(long[] base, long exponent);

    /* renamed from: subtract-j68ebKY, reason: not valid java name */
    long[] mo2954subtractj68ebKY(long[] first, long[] second);

    /* renamed from: toString-tBf0fek, reason: not valid java name */
    String mo2955toStringtBf0fek(long[] operand, int base);

    /* renamed from: xor-j68ebKY, reason: not valid java name */
    long[] mo2956xorj68ebKY(long[] operand, long[] mask);
}
