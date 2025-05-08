package com.ionspin.kotlin.bignum.integer;

import com.adjust.sdk.Constants;
import com.ionspin.kotlin.bignum.BigNumber;
import com.ionspin.kotlin.bignum.CommonBigNumberOperations;
import com.ionspin.kotlin.bignum.decimal.BigDecimal;
import com.ionspin.kotlin.bignum.integer.base63.array.BigInteger63Arithmetic;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001c\u0018\u0000 o2\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\b\u0012\u0004\u0012\u00020\u00000\u00032\b\u0012\u0004\u0012\u00020\u00030\u00042\u00020\u0003:\u0002opB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0007\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0007\u0010\u0011B \b\u0000\u0012\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0017J!\u0010\u001c\u001a\u00020\u00192\n\u0010\u0018\u001a\u00060\u0012j\u0002`\u0013H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00000!H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0000H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0000H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0000H\u0016¢\u0006\u0004\b)\u0010(J\u0017\u0010*\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0000H\u0016¢\u0006\u0004\b*\u0010(J\u0017\u0010+\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0000H\u0016¢\u0006\u0004\b+\u0010(J\u0017\u0010,\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0000H\u0016¢\u0006\u0004\b,\u0010(J#\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000-2\u0006\u0010&\u001a\u00020\u0000H\u0016¢\u0006\u0004\b.\u0010/J\u0018\u00101\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\b1\u0010(J\u0015\u00102\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u0000¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0019H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0000H\u0016¢\u0006\u0004\b6\u0010%J\u000f\u00107\u001a\u00020\u0000H\u0016¢\u0006\u0004\b7\u0010%J\u0017\u00109\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u0005H\u0016¢\u0006\u0004\b9\u0010:J\u0017\u00109\u001a\u00020\u00002\u0006\u00108\u001a\u00020\tH\u0016¢\u0006\u0004\b9\u0010;J\u000f\u0010<\u001a\u00020\tH\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0005H\u0016¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b@\u0010%J\u0010\u0010A\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\bA\u0010%J\u0018\u0010C\u001a\u00020B2\u0006\u0010&\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\bC\u0010DJ\u0018\u0010E\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0000H\u0096\u0004¢\u0006\u0004\bE\u0010(J\u0018\u0010F\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\bF\u0010GJ)\u0010L\u001a\u00020\t2\u0006\u0010I\u001a\u00020H2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0J¢\u0006\u0004\bL\u0010MJ)\u0010P\u001a\u00020\t2\u0006\u0010O\u001a\u00020N2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0J¢\u0006\u0004\bP\u0010QJ\u001a\u0010R\u001a\u00020\u00192\b\u0010&\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\tH\u0016¢\u0006\u0004\bT\u0010=J\u000f\u0010V\u001a\u00020UH\u0016¢\u0006\u0004\bV\u0010WJ\u0017\u0010V\u001a\u00020U2\u0006\u0010X\u001a\u00020\tH\u0016¢\u0006\u0004\bV\u0010YJ\u0017\u0010[\u001a\u00020U2\u0006\u0010X\u001a\u00020\tH\u0000¢\u0006\u0004\bZ\u0010YJ\u0017\u0010]\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\u0019H\u0016¢\u0006\u0004\b]\u0010^R'\u0010_\u001a\u00060\u0012j\u0002`\u00138\u0000X\u0080\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR\u001a\u0010c\u001a\u00020\u00158\u0000X\u0080\u0004¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u0017\u0010g\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010=R$\u0010j\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010W\"\u0004\bm\u0010n\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006q"}, d2 = {"Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "Lcom/ionspin/kotlin/bignum/BigNumber;", "Lcom/ionspin/kotlin/bignum/CommonBigNumberOperations;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, Constants.LONG, "<init>", "(J)V", BuildConfig.FLAVOR, "int", "(I)V", BuildConfig.FLAVOR, "short", "(S)V", BuildConfig.FLAVOR, "byte", "(B)V", "Lkotlin/ULongArray;", "Lcom/ionspin/kotlin/bignum/integer/WordArray;", "wordArray", "Lcom/ionspin/kotlin/bignum/integer/Sign;", "requestedSign", "([JLcom/ionspin/kotlin/bignum/integer/Sign;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "resultMagnitude", BuildConfig.FLAVOR, "isResultZero-QwZRm1k", "([J)Z", "isResultZero", BuildConfig.FLAVOR, "number", "javascriptNumberComparison", "(Ljava/lang/Number;)I", "Lcom/ionspin/kotlin/bignum/BigNumber$Creator;", "getCreator", "()Lcom/ionspin/kotlin/bignum/BigNumber$Creator;", "getInstance", "()Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "other", "add", "(Lcom/ionspin/kotlin/bignum/integer/BigInteger;)Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "subtract", "multiply", "divide", "remainder", "Lkotlin/Pair;", "divideAndRemainder", "(Lcom/ionspin/kotlin/bignum/integer/BigInteger;)Lkotlin/Pair;", "modulo", "mod", "compare", "(Lcom/ionspin/kotlin/bignum/integer/BigInteger;)I", "isZero", "()Z", "negate", "abs", "exponent", "pow", "(J)Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "(I)Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "signum", "()I", "numberOfDecimalDigits", "()J", "dec", "inc", "Lcom/ionspin/kotlin/bignum/integer/BigInteger$QuotientAndRemainder;", "divrem", "(Lcom/ionspin/kotlin/bignum/integer/BigInteger;)Lcom/ionspin/kotlin/bignum/integer/BigInteger$QuotientAndRemainder;", "xor", "compareTo", "(Ljava/lang/Object;)I", BuildConfig.FLAVOR, "float", "Lkotlin/Function1;", "comparisonBlock", "compareFloatAndBigInt", "(FLkotlin/jvm/functions/Function1;)I", BuildConfig.FLAVOR, "double", "compareDoubleAndBigInt", "(DLkotlin/jvm/functions/Function1;)I", "equals", "(Ljava/lang/Object;)Z", "hashCode", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "base", "(I)Ljava/lang/String;", "toStringWithoutSign$bignum", "toStringWithoutSign", "exactRequired", "intValue", "(Z)I", "magnitude", "[J", "getMagnitude-Y2RjT0g$bignum", "()[J", "sign", "Lcom/ionspin/kotlin/bignum/integer/Sign;", "getSign$bignum", "()Lcom/ionspin/kotlin/bignum/integer/Sign;", "numberOfWords", "I", "getNumberOfWords", "stringRepresentation", "Ljava/lang/String;", "getStringRepresentation", "setStringRepresentation", "(Ljava/lang/String;)V", "Companion", "QuotientAndRemainder", "bignum"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class BigInteger implements BigNumber<BigInteger>, CommonBigNumberOperations<BigInteger>, Comparable<Object> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final double LOG_10_OF_2;
    private static final BigInteger ONE;
    private static final BigInteger TEN;
    private static final BigInteger TWO;
    private static final BigInteger ZERO;
    private static final BigIntegerArithmetic arithmetic;
    private final long[] magnitude;
    private final int numberOfWords;
    private final Sign sign;
    private String stringRepresentation;

    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u00032\b\u0012\u0004\u0012\u00020\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010\u000fJ\u0017\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\bH\u0016¢\u0006\u0004\b$\u0010\u0014J\u0017\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010\u0019J\u0017\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010\u001eJ\u001f\u0010/\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100J\u001f\u00103\u001a\u00020\u00022\u0006\u00102\u001a\u0002012\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001a\u00109\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b9\u00106\u001a\u0004\b:\u00108R\u001a\u0010;\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b;\u00106\u001a\u0004\b<\u00108R\u001a\u0010=\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b=\u00106\u001a\u0004\b>\u00108R\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010A\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006B"}, d2 = {"Lcom/ionspin/kotlin/bignum/integer/BigInteger$Companion;", "Lcom/ionspin/kotlin/bignum/BigNumber$Creator;", "Lcom/ionspin/kotlin/bignum/integer/BigInteger;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "string", BuildConfig.FLAVOR, "base", "parseString", "(Ljava/lang/String;I)Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "Lkotlin/ULong;", "uLong", "fromULong-VKZWuLQ", "(J)Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "fromULong", "Lkotlin/UInt;", "uInt", "fromUInt-WZ4Q5Ns", "(I)Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "fromUInt", "Lkotlin/UShort;", "uShort", "fromUShort-xj2QHRw", "(S)Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "fromUShort", "Lkotlin/UByte;", "uByte", "fromUByte-7apg3OU", "(B)Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "fromUByte", BuildConfig.FLAVOR, Constants.LONG, "fromLong", "int", "fromInt", BuildConfig.FLAVOR, "short", "fromShort", BuildConfig.FLAVOR, "byte", "fromByte", BuildConfig.FLAVOR, "float", BuildConfig.FLAVOR, "exactRequired", "tryFromFloat", "(FZ)Lcom/ionspin/kotlin/bignum/integer/BigInteger;", BuildConfig.FLAVOR, "double", "tryFromDouble", "(DZ)Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "ZERO", "Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "getZERO", "()Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "ONE", "getONE", "TWO", "getTWO", "TEN", "getTEN", "Lcom/ionspin/kotlin/bignum/integer/BigIntegerArithmetic;", "arithmetic", "Lcom/ionspin/kotlin/bignum/integer/BigIntegerArithmetic;", "bignum"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion implements BigNumber.Creator<BigInteger> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public BigInteger fromByte(byte r22) {
            return new BigInteger(r22);
        }

        public BigInteger fromLong(long r22) {
            return new BigInteger(r22);
        }

        public BigInteger fromShort(short r22) {
            return new BigInteger(r22);
        }

        /* renamed from: fromUByte-7apg3OU, reason: not valid java name */
        public BigInteger m2931fromUByte7apg3OU(byte uByte) {
            return new BigInteger(BigInteger.arithmetic.mo2943fromUByteab45Ak8(uByte), Sign.POSITIVE, null);
        }

        /* renamed from: fromUInt-WZ4Q5Ns, reason: not valid java name */
        public BigInteger m2932fromUIntWZ4Q5Ns(int uInt) {
            return new BigInteger(BigInteger.arithmetic.mo2944fromUIntkOc6_GI(uInt), Sign.POSITIVE, null);
        }

        /* renamed from: fromULong-VKZWuLQ, reason: not valid java name */
        public BigInteger m2933fromULongVKZWuLQ(long uLong) {
            return new BigInteger(BigInteger.arithmetic.mo2945fromULongGCcj4Q(uLong), Sign.POSITIVE, null);
        }

        /* renamed from: fromUShort-xj2QHRw, reason: not valid java name */
        public BigInteger m2934fromUShortxj2QHRw(short uShort) {
            return new BigInteger(BigInteger.arithmetic.mo2946fromUShortjOPi9CM(uShort), Sign.POSITIVE, null);
        }

        public BigInteger getONE() {
            return BigInteger.ONE;
        }

        public BigInteger getTEN() {
            return BigInteger.TEN;
        }

        public BigInteger getTWO() {
            return BigInteger.TWO;
        }

        public BigInteger getZERO() {
            return BigInteger.ZERO;
        }

        public BigInteger parseString(String string, int base) {
            Intrinsics.checkNotNullParameter(string, "string");
            if (base < 2 || base > 36) {
                throw new NumberFormatException("Unsupported base: " + base + ". Supported base range is from 2 to 36");
            }
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (StringsKt.contains$default((CharSequence) string, '.', false, 2, (Object) null)) {
                BigDecimal parseString = BigDecimal.INSTANCE.parseString(string);
                if (parseString.minus(parseString.floor()).compareTo(0) <= 0) {
                    return parseString.toBigInteger();
                }
                throw new NumberFormatException("Supplied string is decimal, which cannot be converted to BigInteger without precision loss.");
            }
            if (string.charAt(0) != '-' && string.charAt(0) != '+') {
                return (string.length() == 1 && string.charAt(0) == '0') ? getZERO() : new BigInteger(BigInteger.arithmetic.mo2952parseForBase_llDaS8(string, base), Sign.POSITIVE, defaultConstructorMarker);
            }
            if (string.length() == 1) {
                throw new NumberFormatException(Intrinsics.stringPlus("Invalid big integer: ", string));
            }
            Sign sign = string.charAt(0) == '-' ? Sign.NEGATIVE : Sign.POSITIVE;
            if (string.length() == 2 && string.charAt(1) == '0') {
                return getZERO();
            }
            BigIntegerArithmetic bigIntegerArithmetic = BigInteger.arithmetic;
            String substring = string.substring(1, string.length());
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return new BigInteger(bigIntegerArithmetic.mo2952parseForBase_llDaS8(substring, base), sign, defaultConstructorMarker);
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.ionspin.kotlin.bignum.BigNumber.Creator
        public BigInteger fromInt(int r22) {
            return new BigInteger(r22);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.ionspin.kotlin.bignum.BigNumber.Creator
        public BigInteger tryFromDouble(double r5, boolean exactRequired) {
            double floor = r5 - Math.floor(r5);
            BigDecimal fromDouble = BigDecimal.INSTANCE.fromDouble(Math.floor(r5), null);
            if (exactRequired && floor > 0.0d) {
                throw new ArithmeticException("Cant create BigInteger without precision loss, and exact  value was required");
            }
            return fromDouble.toBigInteger();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.ionspin.kotlin.bignum.BigNumber.Creator
        public BigInteger tryFromFloat(float r5, boolean exactRequired) {
            double d5 = r5;
            float floor = r5 - ((float) Math.floor(d5));
            BigDecimal fromFloat = BigDecimal.INSTANCE.fromFloat((float) Math.floor(d5), null);
            if (exactRequired && floor > 0.0f) {
                throw new ArithmeticException("Cant create BigInteger without precision loss, and exact  value was required");
            }
            return fromFloat.toBigInteger();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/ionspin/kotlin/bignum/integer/BigInteger$QuotientAndRemainder;", BuildConfig.FLAVOR, "Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "quotient", "remainder", "<init>", "(Lcom/ionspin/kotlin/bignum/integer/BigInteger;Lcom/ionspin/kotlin/bignum/integer/BigInteger;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "getQuotient", "()Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "getRemainder", "bignum"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class QuotientAndRemainder {
        private final BigInteger quotient;
        private final BigInteger remainder;

        public QuotientAndRemainder(BigInteger quotient, BigInteger remainder) {
            Intrinsics.checkNotNullParameter(quotient, "quotient");
            Intrinsics.checkNotNullParameter(remainder, "remainder");
            this.quotient = quotient;
            this.remainder = remainder;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QuotientAndRemainder)) {
                return false;
            }
            QuotientAndRemainder quotientAndRemainder = (QuotientAndRemainder) other;
            return Intrinsics.areEqual(this.quotient, quotientAndRemainder.quotient) && Intrinsics.areEqual(this.remainder, quotientAndRemainder.remainder);
        }

        public final BigInteger getQuotient() {
            return this.quotient;
        }

        public final BigInteger getRemainder() {
            return this.remainder;
        }

        public int hashCode() {
            return (this.quotient.hashCode() * 31) + this.remainder.hashCode();
        }

        public String toString() {
            return "QuotientAndRemainder(quotient=" + this.quotient + ", remainder=" + this.remainder + ')';
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Sign.values().length];
            iArr[Sign.POSITIVE.ordinal()] = 1;
            iArr[Sign.NEGATIVE.ordinal()] = 2;
            iArr[Sign.ZERO.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        INSTANCE = new Companion(defaultConstructorMarker);
        BigIntegerArithmetic chosenArithmetic = ConfigurationKt.getChosenArithmetic();
        arithmetic = chosenArithmetic;
        ZERO = new BigInteger(chosenArithmetic.mo2950getZEROY2RjT0g(), Sign.ZERO, defaultConstructorMarker);
        long[] mo2947getONEY2RjT0g = chosenArithmetic.mo2947getONEY2RjT0g();
        Sign sign = Sign.POSITIVE;
        ONE = new BigInteger(mo2947getONEY2RjT0g, sign, defaultConstructorMarker);
        TWO = new BigInteger(chosenArithmetic.mo2949getTWOY2RjT0g(), sign, defaultConstructorMarker);
        TEN = new BigInteger(chosenArithmetic.mo2948getTENY2RjT0g(), sign, defaultConstructorMarker);
        LOG_10_OF_2 = Math.log10(2.0d);
    }

    public /* synthetic */ BigInteger(long[] jArr, Sign sign, DefaultConstructorMarker defaultConstructorMarker) {
        this(jArr, sign);
    }

    /* renamed from: isResultZero-QwZRm1k, reason: not valid java name */
    private final boolean m2927isResultZeroQwZRm1k(long[] resultMagnitude) {
        BigIntegerArithmetic bigIntegerArithmetic = arithmetic;
        return bigIntegerArithmetic.mo2937compareGR1PJdc(resultMagnitude, bigIntegerArithmetic.mo2950getZEROY2RjT0g()) == 0;
    }

    private final int javascriptNumberComparison(Number number) {
        return number.floatValue() % ((float) 1) == 0.0f ? compare(INSTANCE.fromLong(number.longValue())) : compareFloatAndBigInt(number.floatValue(), new Function1<BigInteger, Integer>() { // from class: com.ionspin.kotlin.bignum.integer.BigInteger$javascriptNumberComparison$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(BigInteger it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(BigInteger.this.compare(it));
            }
        });
    }

    public BigInteger abs() {
        return new BigInteger(getMagnitude(), Sign.POSITIVE, null);
    }

    public final int compare(BigInteger other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (isZero() && other.isZero()) {
            return 0;
        }
        if (other.isZero() && this.sign == Sign.POSITIVE) {
            return 1;
        }
        if (other.isZero() && this.sign == Sign.NEGATIVE) {
            return -1;
        }
        if (isZero() && other.sign == Sign.POSITIVE) {
            return -1;
        }
        if (isZero() && other.sign == Sign.NEGATIVE) {
            return 1;
        }
        Sign sign = this.sign;
        if (sign != other.sign) {
            return sign == Sign.POSITIVE ? 1 : -1;
        }
        int mo2937compareGR1PJdc = arithmetic.mo2937compareGR1PJdc(getMagnitude(), other.getMagnitude());
        Sign sign2 = this.sign;
        Sign sign3 = Sign.NEGATIVE;
        return (sign2 == sign3 && other.sign == sign3) ? mo2937compareGR1PJdc * (-1) : mo2937compareGR1PJdc;
    }

    public final int compareDoubleAndBigInt(double r13, Function1<? super BigInteger, Integer> comparisonBlock) {
        Intrinsics.checkNotNullParameter(comparisonBlock, "comparisonBlock");
        double floor = Math.floor(r13);
        double d5 = 1;
        if (r13 % d5 == 0.0d) {
            return comparisonBlock.invoke(BigNumber.Creator.DefaultImpls.tryFromDouble$default(INSTANCE, floor, false, 2, null)).intValue();
        }
        int intValue = comparisonBlock.invoke(BigNumber.Creator.DefaultImpls.tryFromDouble$default(INSTANCE, floor + d5, false, 2, null)).intValue();
        if (intValue == 0) {
            return 1;
        }
        return intValue;
    }

    public final int compareFloatAndBigInt(float r7, Function1<? super BigInteger, Integer> comparisonBlock) {
        Intrinsics.checkNotNullParameter(comparisonBlock, "comparisonBlock");
        float floor = (float) Math.floor(r7);
        float f5 = 1;
        if (r7 % f5 == 0.0f) {
            return comparisonBlock.invoke(BigNumber.Creator.DefaultImpls.tryFromFloat$default(INSTANCE, floor, false, 2, null)).intValue();
        }
        int intValue = comparisonBlock.invoke(BigNumber.Creator.DefaultImpls.tryFromFloat$default(INSTANCE, floor + f5, false, 2, null)).intValue();
        if (intValue == 0) {
            return 1;
        }
        return intValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (other instanceof Number) {
            Number number = (Number) other;
            if (ComparisonWorkaround.INSTANCE.isSpecialHandlingForFloatNeeded(number)) {
                return javascriptNumberComparison(number);
            }
        }
        if (other instanceof BigInteger) {
            return compare((BigInteger) other);
        }
        if (other instanceof Long) {
            return compare(INSTANCE.fromLong(((Number) other).longValue()));
        }
        if (other instanceof Integer) {
            return compare(INSTANCE.fromInt(((Number) other).intValue()));
        }
        if (other instanceof Short) {
            return compare(INSTANCE.fromShort(((Number) other).shortValue()));
        }
        if (other instanceof Byte) {
            return compare(INSTANCE.fromByte(((Number) other).byteValue()));
        }
        if (other instanceof ULong) {
            return compare(INSTANCE.m2933fromULongVKZWuLQ(((ULong) other).getData()));
        }
        if (other instanceof UInt) {
            return compare(INSTANCE.m2932fromUIntWZ4Q5Ns(((UInt) other).getData()));
        }
        if (other instanceof UShort) {
            return compare(INSTANCE.m2934fromUShortxj2QHRw(((UShort) other).getData()));
        }
        if (other instanceof UByte) {
            return compare(INSTANCE.m2931fromUByte7apg3OU(((UByte) other).getData()));
        }
        if (other instanceof Float) {
            return compareFloatAndBigInt(((Number) other).floatValue(), new Function1<BigInteger, Integer>() { // from class: com.ionspin.kotlin.bignum.integer.BigInteger$compareTo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Integer invoke(BigInteger it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Integer.valueOf(BigInteger.this.compare(it));
                }
            });
        }
        if (other instanceof Double) {
            return compareDoubleAndBigInt(((Number) other).doubleValue(), new Function1<BigInteger, Integer>() { // from class: com.ionspin.kotlin.bignum.integer.BigInteger$compareTo$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Integer invoke(BigInteger it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Integer.valueOf(BigInteger.this.compare(it));
                }
            });
        }
        throw new RuntimeException(Intrinsics.stringPlus("Invalid comparison type for BigInteger: ", Reflection.getOrCreateKotlinClass(other.getClass())));
    }

    public final BigInteger dec() {
        return (BigInteger) minus((BigNumber) ONE);
    }

    public Pair<BigInteger, BigInteger> divideAndRemainder(BigInteger other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (!other.isZero()) {
            Sign sign = this.sign != other.sign ? Sign.NEGATIVE : Sign.POSITIVE;
            BigIntegerArithmetic bigIntegerArithmetic = arithmetic;
            Pair<ULongArray, ULongArray> mo2938divideGR1PJdc = bigIntegerArithmetic.mo2938divideGR1PJdc(getMagnitude(), other.getMagnitude());
            DefaultConstructorMarker defaultConstructorMarker = null;
            return new Pair<>(ULongArray.m3634equalsimpl0(mo2938divideGR1PJdc.getFirst().getStorage(), bigIntegerArithmetic.mo2950getZEROY2RjT0g()) ? ZERO : new BigInteger(mo2938divideGR1PJdc.getFirst().getStorage(), sign, defaultConstructorMarker), ULongArray.m3634equalsimpl0(mo2938divideGR1PJdc.getSecond().getStorage(), bigIntegerArithmetic.mo2950getZEROY2RjT0g()) ? ZERO : new BigInteger(mo2938divideGR1PJdc.getSecond().getStorage(), this.sign, defaultConstructorMarker));
        }
        throw new ArithmeticException("Division by zero! " + this + " / " + other);
    }

    public final QuotientAndRemainder divrem(BigInteger other) {
        Intrinsics.checkNotNullParameter(other, "other");
        Pair<BigInteger, BigInteger> divideAndRemainder = divideAndRemainder(other);
        return new QuotientAndRemainder(divideAndRemainder.getFirst(), divideAndRemainder.getSecond());
    }

    public boolean equals(Object other) {
        return (other instanceof BigInteger ? compare((BigInteger) other) : other instanceof Long ? compare(INSTANCE.fromLong(((Number) other).longValue())) : other instanceof Integer ? compare(INSTANCE.fromInt(((Number) other).intValue())) : other instanceof Short ? compare(INSTANCE.fromShort(((Number) other).shortValue())) : other instanceof Byte ? compare(INSTANCE.fromByte(((Number) other).byteValue())) : other instanceof ULong ? compare(INSTANCE.m2933fromULongVKZWuLQ(((ULong) other).getData())) : other instanceof UInt ? compare(INSTANCE.m2932fromUIntWZ4Q5Ns(((UInt) other).getData())) : other instanceof UShort ? compare(INSTANCE.m2934fromUShortxj2QHRw(((UShort) other).getData())) : other instanceof UByte ? compare(INSTANCE.m2931fromUByte7apg3OU(((UByte) other).getData())) : -1) == 0;
    }

    @Override // com.ionspin.kotlin.bignum.CommonBigNumberOperations
    public BigNumber.Creator<BigInteger> getCreator() {
        return INSTANCE;
    }

    @Override // com.ionspin.kotlin.bignum.CommonBigNumberOperations
    public BigInteger getInstance() {
        return this;
    }

    /* renamed from: getMagnitude-Y2RjT0g$bignum, reason: not valid java name and from getter */
    public final long[] getMagnitude() {
        return this.magnitude;
    }

    /* renamed from: getSign$bignum, reason: from getter */
    public final Sign getSign() {
        return this.sign;
    }

    public int hashCode() {
        int i5 = 0;
        for (long j5 : getMagnitude()) {
            i5 += ULong.m3625hashCodeimpl(j5);
        }
        return i5 + this.sign.hashCode();
    }

    public final BigInteger inc() {
        return (BigInteger) plus((BigNumber) ONE);
    }

    public int intValue(boolean exactRequired) {
        if (!exactRequired || (compareTo(Integer.MAX_VALUE) <= 0 && compareTo(Integer.MIN_VALUE) >= 0)) {
            return ((int) ULongArray.m3635getsVKNKU(getMagnitude(), 0)) * signum();
        }
        throw new ArithmeticException("Cannot convert to int and provide exact value");
    }

    public boolean isNegative() {
        return BigNumber.DefaultImpls.isNegative(this);
    }

    public boolean isZero() {
        return this.sign == Sign.ZERO || ConfigurationKt.getChosenArithmetic().mo2937compareGR1PJdc(getMagnitude(), ConfigurationKt.getChosenArithmetic().mo2950getZEROY2RjT0g()) == 0;
    }

    public final BigInteger mod(BigInteger modulo) {
        Intrinsics.checkNotNullParameter(modulo, "modulo");
        BigInteger bigInteger = (BigInteger) rem((BigNumber) modulo);
        return bigInteger.compareTo(0) < 0 ? (BigInteger) bigInteger.plus((BigNumber) modulo) : bigInteger;
    }

    public BigInteger negate() {
        return new BigInteger(getMagnitude(), this.sign.not(), null);
    }

    public long numberOfDecimalDigits() {
        if (isZero()) {
            return 1L;
        }
        int ceil = (int) Math.ceil((arithmetic.mo2936bitLengthQwZRm1k(getMagnitude()) - 1) * LOG_10_OF_2);
        BigInteger bigInteger = (BigInteger) div((BigNumber) BigIntegerExtensionsKt.toBigInteger(10).pow(ceil));
        long j5 = 0;
        while (bigInteger.compareTo(0) != 0) {
            bigInteger = (BigInteger) bigInteger.div(10);
            j5++;
        }
        return j5 + ceil;
    }

    public BigInteger pow(long exponent) {
        if (exponent >= 0) {
            BigInteger bigInteger = ZERO;
            if (Intrinsics.areEqual(this, bigInteger)) {
                return bigInteger;
            }
            BigInteger bigInteger2 = ONE;
            if (Intrinsics.areEqual(this, bigInteger2)) {
                return bigInteger2;
            }
            Sign sign = this.sign;
            Sign sign2 = Sign.NEGATIVE;
            if (sign != sign2) {
                sign2 = Sign.POSITIVE;
            } else if (exponent % 2 == 0) {
                sign2 = Sign.POSITIVE;
            }
            return new BigInteger(arithmetic.mo2953powGERUpyg(getMagnitude(), exponent), sign2, null);
        }
        throw new ArithmeticException("Negative exponent not supported with BigInteger");
    }

    @Override // com.ionspin.kotlin.bignum.BigNumber
    public int signum() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[this.sign.ordinal()];
        if (i5 == 1) {
            return 1;
        }
        if (i5 == 2) {
            return -1;
        }
        if (i5 == 3) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    public String toString() {
        return toString(10);
    }

    public final String toStringWithoutSign$bignum(int base) {
        return arithmetic.mo2955toStringtBf0fek(getMagnitude(), base);
    }

    public BigInteger xor(BigInteger other) {
        Intrinsics.checkNotNullParameter(other, "other");
        long[] mo2956xorj68ebKY = arithmetic.mo2956xorj68ebKY(getMagnitude(), other.getMagnitude());
        return new BigInteger(mo2956xorj68ebKY, other.isNegative() ^ isNegative() ? Sign.NEGATIVE : m2927isResultZeroQwZRm1k(mo2956xorj68ebKY) ? Sign.ZERO : Sign.POSITIVE, null);
    }

    private BigInteger(long[] jArr, Sign sign) {
        Sign sign2 = Sign.ZERO;
        if (sign == sign2 && !m2927isResultZeroQwZRm1k(jArr)) {
            throw new IllegalArgumentException("sign should be Sign.ZERO iff magnitude has a value of 0");
        }
        this.magnitude = BigInteger63Arithmetic.INSTANCE.m3017removeLeadingZerosJIhQxVY(jArr);
        this.sign = m2927isResultZeroQwZRm1k(getMagnitude()) ? sign2 : sign;
        this.numberOfWords = ULongArray.m3636getSizeimpl(getMagnitude());
    }

    @Override // com.ionspin.kotlin.bignum.BigNumber
    public BigInteger add(BigInteger other) {
        Intrinsics.checkNotNullParameter(other, "other");
        BigIntegerArithmetic bigIntegerArithmetic = arithmetic;
        int mo2937compareGR1PJdc = bigIntegerArithmetic.mo2937compareGR1PJdc(getMagnitude(), other.getMagnitude());
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (other.sign == this.sign) {
            return new BigInteger(bigIntegerArithmetic.mo2935addj68ebKY(getMagnitude(), other.getMagnitude()), this.sign, defaultConstructorMarker);
        }
        if (mo2937compareGR1PJdc > 0) {
            return new BigInteger(bigIntegerArithmetic.mo2954subtractj68ebKY(getMagnitude(), other.getMagnitude()), this.sign, defaultConstructorMarker);
        }
        if (mo2937compareGR1PJdc < 0) {
            return new BigInteger(bigIntegerArithmetic.mo2954subtractj68ebKY(other.getMagnitude(), getMagnitude()), other.sign, defaultConstructorMarker);
        }
        return ZERO;
    }

    @Override // com.ionspin.kotlin.bignum.BigNumber
    public BigInteger divide(BigInteger other) {
        Sign sign;
        Intrinsics.checkNotNullParameter(other, "other");
        if (!other.isZero()) {
            BigIntegerArithmetic bigIntegerArithmetic = arithmetic;
            long[] storage = bigIntegerArithmetic.mo2938divideGR1PJdc(getMagnitude(), other.getMagnitude()).getFirst().getStorage();
            if (ULongArray.m3634equalsimpl0(storage, bigIntegerArithmetic.mo2950getZEROY2RjT0g())) {
                return ZERO;
            }
            if (this.sign != other.sign) {
                sign = Sign.NEGATIVE;
            } else {
                sign = Sign.POSITIVE;
            }
            return new BigInteger(storage, sign, null);
        }
        throw new ArithmeticException("Division by zero! " + this + " / " + other);
    }

    public BigInteger minus(BigInteger bigInteger) {
        return (BigInteger) CommonBigNumberOperations.DefaultImpls.minus(this, bigInteger);
    }

    @Override // com.ionspin.kotlin.bignum.BigNumber
    public BigInteger multiply(BigInteger other) {
        Sign sign;
        Intrinsics.checkNotNullParameter(other, "other");
        if (!isZero() && !other.isZero()) {
            if (Intrinsics.areEqual(other, ONE)) {
                return this;
            }
            if (this.sign != other.sign) {
                sign = Sign.NEGATIVE;
            } else {
                sign = Sign.POSITIVE;
            }
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (sign == Sign.POSITIVE) {
                return new BigInteger(arithmetic.mo2951multiplyj68ebKY(getMagnitude(), other.getMagnitude()), sign, defaultConstructorMarker);
            }
            return new BigInteger(arithmetic.mo2951multiplyj68ebKY(getMagnitude(), other.getMagnitude()), sign, defaultConstructorMarker);
        }
        return ZERO;
    }

    public BigInteger plus(BigInteger bigInteger) {
        return (BigInteger) CommonBigNumberOperations.DefaultImpls.plus(this, bigInteger);
    }

    @Override // com.ionspin.kotlin.bignum.BigNumber
    public BigInteger remainder(BigInteger other) {
        Sign sign;
        Intrinsics.checkNotNullParameter(other, "other");
        if (!other.isZero()) {
            if (this.sign != other.sign) {
                sign = Sign.NEGATIVE;
            } else {
                sign = Sign.POSITIVE;
            }
            BigIntegerArithmetic bigIntegerArithmetic = arithmetic;
            long[] storage = bigIntegerArithmetic.mo2938divideGR1PJdc(getMagnitude(), other.getMagnitude()).getSecond().getStorage();
            if (ULongArray.m3634equalsimpl0(storage, bigIntegerArithmetic.mo2950getZEROY2RjT0g())) {
                sign = Sign.ZERO;
            }
            return new BigInteger(storage, sign, null);
        }
        throw new ArithmeticException("Division by zero! " + this + " / " + other);
    }

    @Override // com.ionspin.kotlin.bignum.BigNumber
    public BigInteger subtract(BigInteger other) {
        Intrinsics.checkNotNullParameter(other, "other");
        BigIntegerArithmetic bigIntegerArithmetic = arithmetic;
        int mo2937compareGR1PJdc = bigIntegerArithmetic.mo2937compareGR1PJdc(getMagnitude(), other.getMagnitude());
        BigInteger bigInteger = ZERO;
        if (Intrinsics.areEqual(this, bigInteger)) {
            return other.negate();
        }
        if (Intrinsics.areEqual(other, bigInteger)) {
            return this;
        }
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (other.sign != this.sign) {
            return new BigInteger(bigIntegerArithmetic.mo2935addj68ebKY(getMagnitude(), other.getMagnitude()), this.sign, defaultConstructorMarker);
        }
        if (mo2937compareGR1PJdc > 0) {
            return new BigInteger(bigIntegerArithmetic.mo2954subtractj68ebKY(getMagnitude(), other.getMagnitude()), this.sign, defaultConstructorMarker);
        }
        return mo2937compareGR1PJdc < 0 ? new BigInteger(bigIntegerArithmetic.mo2954subtractj68ebKY(other.getMagnitude(), getMagnitude()), this.sign.not(), defaultConstructorMarker) : bigInteger;
    }

    public BigInteger times(BigInteger bigInteger) {
        return (BigInteger) CommonBigNumberOperations.DefaultImpls.times(this, bigInteger);
    }

    public String toString(int base) {
        String str;
        if (this.sign == Sign.NEGATIVE) {
            str = "-";
        } else {
            str = BuildConfig.FLAVOR;
        }
        return Intrinsics.stringPlus(str, toStringWithoutSign$bignum(base));
    }

    public BigInteger div(int i5) {
        return (BigInteger) CommonBigNumberOperations.DefaultImpls.div(this, i5);
    }

    public BigInteger rem(int i5) {
        return (BigInteger) CommonBigNumberOperations.DefaultImpls.rem(this, i5);
    }

    public BigInteger div(BigInteger bigInteger) {
        return (BigInteger) CommonBigNumberOperations.DefaultImpls.div(this, bigInteger);
    }

    public BigInteger rem(BigInteger bigInteger) {
        return (BigInteger) CommonBigNumberOperations.DefaultImpls.rem(this, bigInteger);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BigInteger(long j5) {
        this(r0, r6, null);
        Sign sign;
        long[] mo2941fromLongDHQ6RzY = arithmetic.mo2941fromLongDHQ6RzY(j5);
        Number valueOf = Long.valueOf(j5);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            if (valueOf.longValue() < 0) {
                sign = Sign.NEGATIVE;
            } else {
                sign = valueOf.longValue() > 0 ? Sign.POSITIVE : Sign.ZERO;
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            if (valueOf.intValue() < 0) {
                sign = Sign.NEGATIVE;
            } else {
                sign = valueOf.intValue() > 0 ? Sign.POSITIVE : Sign.ZERO;
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
            if (valueOf.shortValue() < 0) {
                sign = Sign.NEGATIVE;
            } else {
                sign = valueOf.shortValue() > 0 ? Sign.POSITIVE : Sign.ZERO;
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
            if (valueOf.byteValue() < 0) {
                sign = Sign.NEGATIVE;
            } else {
                sign = valueOf.byteValue() > 0 ? Sign.POSITIVE : Sign.ZERO;
            }
        } else {
            throw new RuntimeException(Intrinsics.stringPlus("Unsupported type ", Reflection.getOrCreateKotlinClass(Long.class)));
        }
    }

    public BigInteger pow(int exponent) {
        return pow(exponent);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BigInteger(int i5) {
        this(r0, r6, null);
        Sign sign;
        long[] mo2940fromIntDHQ6RzY = arithmetic.mo2940fromIntDHQ6RzY(i5);
        Number valueOf = Integer.valueOf(i5);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            if (valueOf.longValue() < 0) {
                sign = Sign.NEGATIVE;
            } else {
                sign = valueOf.longValue() > 0 ? Sign.POSITIVE : Sign.ZERO;
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            if (valueOf.intValue() < 0) {
                sign = Sign.NEGATIVE;
            } else {
                sign = valueOf.intValue() > 0 ? Sign.POSITIVE : Sign.ZERO;
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
            if (valueOf.shortValue() < 0) {
                sign = Sign.NEGATIVE;
            } else {
                sign = valueOf.shortValue() > 0 ? Sign.POSITIVE : Sign.ZERO;
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
            if (valueOf.byteValue() < 0) {
                sign = Sign.NEGATIVE;
            } else {
                sign = valueOf.byteValue() > 0 ? Sign.POSITIVE : Sign.ZERO;
            }
        } else {
            throw new RuntimeException(Intrinsics.stringPlus("Unsupported type ", Reflection.getOrCreateKotlinClass(Integer.class)));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BigInteger(short s5) {
        this(r0, r6, null);
        Sign sign;
        long[] mo2942fromShortDHQ6RzY = arithmetic.mo2942fromShortDHQ6RzY(s5);
        Number valueOf = Short.valueOf(s5);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Short.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            if (valueOf.longValue() < 0) {
                sign = Sign.NEGATIVE;
            } else {
                sign = valueOf.longValue() > 0 ? Sign.POSITIVE : Sign.ZERO;
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            if (valueOf.intValue() < 0) {
                sign = Sign.NEGATIVE;
            } else {
                sign = valueOf.intValue() > 0 ? Sign.POSITIVE : Sign.ZERO;
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
            if (valueOf.shortValue() < 0) {
                sign = Sign.NEGATIVE;
            } else {
                sign = valueOf.shortValue() > 0 ? Sign.POSITIVE : Sign.ZERO;
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
            if (valueOf.byteValue() < 0) {
                sign = Sign.NEGATIVE;
            } else {
                sign = valueOf.byteValue() > 0 ? Sign.POSITIVE : Sign.ZERO;
            }
        } else {
            throw new RuntimeException(Intrinsics.stringPlus("Unsupported type ", Reflection.getOrCreateKotlinClass(Short.class)));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BigInteger(byte b5) {
        this(r0, r6, null);
        Sign sign;
        long[] mo2939fromByteDHQ6RzY = arithmetic.mo2939fromByteDHQ6RzY(b5);
        Number valueOf = Byte.valueOf(b5);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Byte.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            if (valueOf.longValue() < 0) {
                sign = Sign.NEGATIVE;
            } else {
                sign = valueOf.longValue() > 0 ? Sign.POSITIVE : Sign.ZERO;
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            if (valueOf.intValue() < 0) {
                sign = Sign.NEGATIVE;
            } else {
                sign = valueOf.intValue() > 0 ? Sign.POSITIVE : Sign.ZERO;
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
            if (valueOf.shortValue() < 0) {
                sign = Sign.NEGATIVE;
            } else {
                sign = valueOf.shortValue() > 0 ? Sign.POSITIVE : Sign.ZERO;
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
            if (valueOf.byteValue() < 0) {
                sign = Sign.NEGATIVE;
            } else {
                sign = valueOf.byteValue() > 0 ? Sign.POSITIVE : Sign.ZERO;
            }
        } else {
            throw new RuntimeException(Intrinsics.stringPlus("Unsupported type ", Reflection.getOrCreateKotlinClass(Byte.class)));
        }
    }
}
