package com.ionspin.kotlin.bignum.integer.base32;

import com.ionspin.kotlin.bignum.integer.Quadruple;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001lB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\bJ\u001b\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\fJ%\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0018J5\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u001e2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J#\u0010%\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\u0018J%\u0010*\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J%\u0010-\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,J%\u0010/\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010,J#\u00101\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u0010\u0018J1\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n022\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104J/\u00109\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n022\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00104J\"\u0010;\u001a\u00020\n*\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0006H\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u0010\u0018J\"\u0010=\u001a\u00020\n*\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0006H\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010\u0018J\"\u0010@\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\nH\u0080\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010,J\"\u0010B\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\u0004H\u0080\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bA\u0010\u0018J\"\u0010D\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\u0004H\u0080\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010\u0018J\"\u0010F\u001a\u00020\u0006*\u00020\n2\u0006\u0010>\u001a\u00020\nH\u0080\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bE\u0010)R\u001a\u0010H\u001a\u00020G8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR#\u0010M\u001a\u00020L8\u0006X\u0086Dø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR#\u0010Q\u001a\u00020\u00048\u0006X\u0086Dø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR#\u0010U\u001a\u00020L8\u0006X\u0086Dø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\bU\u0010N\u001a\u0004\bV\u0010PR#\u0010W\u001a\u00020L8\u0006X\u0086Dø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\bW\u0010N\u001a\u0004\bX\u0010PR#\u0010Y\u001a\u00020\u00048\u0006X\u0086Dø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\bY\u0010R\u001a\u0004\bZ\u0010TR\u001a\u0010[\u001a\u00020\u00068\u0016X\u0096D¢\u0006\f\n\u0004\b[\u0010R\u001a\u0004\b\\\u0010TR\u001a\u0010]\u001a\u00020\u00068\u0006X\u0086D¢\u0006\f\n\u0004\b]\u0010R\u001a\u0004\b^\u0010TR#\u0010_\u001a\u00020\n8\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b_\u0010I\u001a\u0004\b`\u0010KR#\u0010a\u001a\u00020\n8\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\ba\u0010I\u001a\u0004\bb\u0010KR#\u0010c\u001a\u00020\n8\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\bc\u0010I\u001a\u0004\bd\u0010KR#\u0010e\u001a\u00020\n8\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\be\u0010I\u001a\u0004\bf\u0010KR\u0017\u0010h\u001a\u00020g8\u0006¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006m"}, d2 = {"Lcom/ionspin/kotlin/bignum/integer/base32/BigInteger32Arithmetic;", BuildConfig.FLAVOR, "<init>", "()V", "Lkotlin/UInt;", "value", BuildConfig.FLAVOR, "numberOfLeadingZerosInAWord-WZ4Q5Ns", "(I)I", "numberOfLeadingZerosInAWord", "Lkotlin/UIntArray;", "bitLength--ajY-9A", "([I)I", "bitLength", "bitLength-WZ4Q5Ns", "bigInteger", "removeLeadingZeros-hkIa6DI", "([I)[I", "removeLeadingZeros", "countLeadingZeroWords--ajY-9A", "countLeadingZeroWords", "operand", "places", "shiftLeft-Wj2uyrI", "([II)[I", "shiftLeft", "shiftRight-Wj2uyrI", "shiftRight", "dividend", "divisor", "Lkotlin/Triple;", "normalize-Ynv0uTE", "([I[I)Lkotlin/Triple;", "normalize", "remainderNormalized", "normalizationShift", "denormalize-Wj2uyrI", "denormalize", "first", "second", "compare-Ynv0uTE", "([I[I)I", "compare", "add-0-0sMy4", "([I[I)[I", "add", "subtract-0-0sMy4", "subtract", "multiply-FE_7wA8", "multiply", "Lkotlin/Pair;", "divide-Ynv0uTE", "([I[I)Lkotlin/Pair;", "divide", "unnormalizedDividend", "unnormalizedDivisor", "basicDivide-Ynv0uTE", "basicDivide", "shl-Wj2uyrI$bignum", "shl", "shr-Wj2uyrI$bignum", "shr", "other", "minus-0-0sMy4$bignum", "minus", "plus-FE_7wA8$bignum", "plus", "times-FE_7wA8$bignum", "times", "compareTo-Ynv0uTE$bignum", "compareTo", BuildConfig.FLAVOR, "_emitIntArray", "[I", "get_emitIntArray", "()[I", "Lkotlin/ULong;", "baseMask", "J", "getBaseMask-s-VKNKU", "()J", "baseMaskInt", "I", "getBaseMaskInt-pVg5ArA", "()I", "overflowMask", "getOverflowMask-s-VKNKU", "lowerMask", "getLowerMask-s-VKNKU", "base", "getBase-pVg5ArA", "basePowerOfTwo", "getBasePowerOfTwo", "wordSizeInBits", "getWordSizeInBits", "ZERO", "getZERO--hP7Qyg", "ONE", "getONE--hP7Qyg", "TWO", "getTWO--hP7Qyg", "TEN", "getTEN--hP7Qyg", "Lcom/ionspin/kotlin/bignum/integer/base32/BigInteger32Arithmetic$SignedUIntArray;", "SIGNED_POSITIVE_TWO", "Lcom/ionspin/kotlin/bignum/integer/base32/BigInteger32Arithmetic$SignedUIntArray;", "getSIGNED_POSITIVE_TWO", "()Lcom/ionspin/kotlin/bignum/integer/base32/BigInteger32Arithmetic$SignedUIntArray;", "SignedUIntArray", "bignum"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class BigInteger32Arithmetic {
    public static final BigInteger32Arithmetic INSTANCE;
    private static final int[] ONE;
    private static final SignedUIntArray SIGNED_POSITIVE_TWO;
    private static final int[] TEN;
    private static final int[] TWO;
    private static final int[] ZERO;
    private static final int[] _emitIntArray;
    private static final int base;
    private static final long baseMask;
    private static final int baseMaskInt;
    private static final int basePowerOfTwo;
    private static final long lowerMask;
    private static final long overflowMask;
    private static final int wordSizeInBits;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001a\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Lcom/ionspin/kotlin/bignum/integer/base32/BigInteger32Arithmetic$SignedUIntArray;", BuildConfig.FLAVOR, "Lkotlin/UIntArray;", "unsignedValue", BuildConfig.FLAVOR, "sign", "<init>", "([IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "[I", "getUnsignedValue--hP7Qyg", "()[I", "Z", "getSign", "()Z", "bignum"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class SignedUIntArray {
        private final boolean sign;
        private final int[] unsignedValue;

        public /* synthetic */ SignedUIntArray(int[] iArr, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
            this(iArr, z5);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SignedUIntArray)) {
                return false;
            }
            SignedUIntArray signedUIntArray = (SignedUIntArray) other;
            return UIntArray.m3610equalsimpl0(this.unsignedValue, signedUIntArray.unsignedValue) && this.sign == signedUIntArray.sign;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int m3613hashCodeimpl = UIntArray.m3613hashCodeimpl(this.unsignedValue) * 31;
            boolean z5 = this.sign;
            int i5 = z5;
            if (z5 != 0) {
                i5 = 1;
            }
            return m3613hashCodeimpl + i5;
        }

        public String toString() {
            return "SignedUIntArray(unsignedValue=" + ((Object) UIntArray.m3617toStringimpl(this.unsignedValue)) + ", sign=" + this.sign + ')';
        }

        private SignedUIntArray(int[] iArr, boolean z5) {
            this.unsignedValue = iArr;
            this.sign = z5;
        }
    }

    static {
        BigInteger32Arithmetic bigInteger32Arithmetic = new BigInteger32Arithmetic();
        INSTANCE = bigInteger32Arithmetic;
        _emitIntArray = new int[0];
        baseMask = 4294967295L;
        baseMaskInt = -1;
        overflowMask = 4294967296L;
        lowerMask = 65535L;
        base = -1;
        basePowerOfTwo = 32;
        wordSizeInBits = 32;
        ZERO = UIntArray.m3605constructorimpl(0);
        ONE = UIntArray.m3606constructorimpl(new int[]{1});
        TWO = UIntArray.m3606constructorimpl(new int[]{2});
        TEN = UIntArray.m3606constructorimpl(new int[]{10});
        SIGNED_POSITIVE_TWO = new SignedUIntArray(bigInteger32Arithmetic.m2970getTWOhP7Qyg(), true, null);
    }

    private BigInteger32Arithmetic() {
    }

    /* renamed from: add-0-0sMy4, reason: not valid java name */
    public int[] m2957add00sMy4(int[] first, int[] second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        if (UIntArray.m3612getSizeimpl(first) == 1 && UIntArray.m3611getpVg5ArA(first, 0) == 0) {
            return second;
        }
        if (UIntArray.m3612getSizeimpl(second) == 1 && UIntArray.m3611getpVg5ArA(second, 0) == 0) {
            return first;
        }
        Quadruple quadruple = UIntArray.m3612getSizeimpl(first) > UIntArray.m3612getSizeimpl(second) ? new Quadruple(Integer.valueOf(UIntArray.m3612getSizeimpl(first)), Integer.valueOf(UIntArray.m3612getSizeimpl(second)), UIntArray.m3604boximpl(first), UIntArray.m3604boximpl(second)) : new Quadruple(Integer.valueOf(UIntArray.m3612getSizeimpl(second)), Integer.valueOf(UIntArray.m3612getSizeimpl(first)), UIntArray.m3604boximpl(second), UIntArray.m3604boximpl(first));
        int intValue = ((Number) quadruple.component1()).intValue();
        int intValue2 = ((Number) quadruple.component2()).intValue();
        int[] storage = ((UIntArray) quadruple.component3()).getStorage();
        int[] storage2 = ((UIntArray) quadruple.component4()).getStorage();
        int i5 = intValue + 1;
        int[] iArr = new int[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            iArr[i6] = 0;
        }
        int[] m3606constructorimpl = UIntArray.m3606constructorimpl(iArr);
        int i7 = 0;
        long j5 = 0;
        while (i7 < intValue2) {
            long m3622constructorimpl = ULong.m3622constructorimpl(ULong.m3622constructorimpl(j5 + ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(storage, i7) & 4294967295L)) + ULong.m3622constructorimpl(4294967295L & UIntArray.m3611getpVg5ArA(storage2, i7)));
            UIntArray.m3616setVXSXFK8(m3606constructorimpl, i7, UInt.m3599constructorimpl((int) ULong.m3622constructorimpl(m2967getBaseMasksVKNKU() & m3622constructorimpl)));
            j5 = ULong.m3622constructorimpl(m3622constructorimpl >>> getBasePowerOfTwo());
            i7++;
        }
        while (j5 != 0) {
            if (i7 == intValue) {
                UIntArray.m3616setVXSXFK8(m3606constructorimpl, intValue, UInt.m3599constructorimpl((int) j5));
                return m3606constructorimpl;
            }
            long m3622constructorimpl2 = ULong.m3622constructorimpl(j5 + ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(storage, i7) & 4294967295L));
            UIntArray.m3616setVXSXFK8(m3606constructorimpl, i7, UInt.m3599constructorimpl((int) ULong.m3622constructorimpl(m2967getBaseMasksVKNKU() & m3622constructorimpl2)));
            j5 = ULong.m3622constructorimpl(m3622constructorimpl2 >>> getBasePowerOfTwo());
            i7++;
        }
        while (i7 < intValue) {
            UIntArray.m3616setVXSXFK8(m3606constructorimpl, i7, UIntArray.m3611getpVg5ArA(storage, i7));
            i7++;
        }
        return UIntArray.m3611getpVg5ArA(m3606constructorimpl, UIntArray.m3612getSizeimpl(m3606constructorimpl) - 1) == 0 ? UIntArray.m3606constructorimpl(ArraysKt.copyOfRange(m3606constructorimpl, 0, UIntArray.m3612getSizeimpl(m3606constructorimpl) - 1)) : m3606constructorimpl;
    }

    /* renamed from: basicDivide-Ynv0uTE, reason: not valid java name */
    public final Pair<UIntArray, UIntArray> m2958basicDivideYnv0uTE(int[] unnormalizedDividend, int[] unnormalizedDivisor) {
        Intrinsics.checkNotNullParameter(unnormalizedDividend, "unnormalizedDividend");
        Intrinsics.checkNotNullParameter(unnormalizedDivisor, "unnormalizedDivisor");
        if (m2962compareToYnv0uTE$bignum(unnormalizedDivisor, unnormalizedDividend) > 0) {
            return new Pair<>(UIntArray.m3604boximpl(m2971getZEROhP7Qyg()), UIntArray.m3604boximpl(unnormalizedDividend));
        }
        if (UIntArray.m3612getSizeimpl(unnormalizedDivisor) == 1 && UIntArray.m3612getSizeimpl(unnormalizedDividend) == 1) {
            return new Pair<>(UIntArray.m3604boximpl(m2977removeLeadingZeroshkIa6DI(new int[]{Integer.divideUnsigned(UIntArray.m3611getpVg5ArA(unnormalizedDividend, 0), UIntArray.m3611getpVg5ArA(unnormalizedDivisor, 0))})), UIntArray.m3604boximpl(m2977removeLeadingZeroshkIa6DI(new int[]{Integer.remainderUnsigned(UIntArray.m3611getpVg5ArA(unnormalizedDividend, 0), UIntArray.m3611getpVg5ArA(unnormalizedDivisor, 0))})));
        }
        if (m2959bitLengthajY9A(unnormalizedDividend) - m2959bitLengthajY9A(unnormalizedDivisor) == 0) {
            return new Pair<>(UIntArray.m3604boximpl(new int[]{1}), UIntArray.m3604boximpl(m2972minus00sMy4$bignum(unnormalizedDividend, unnormalizedDivisor)));
        }
        Triple<UIntArray, UIntArray, Integer> m2974normalizeYnv0uTE = m2974normalizeYnv0uTE(unnormalizedDividend, unnormalizedDivisor);
        int[] storage = m2974normalizeYnv0uTE.component1().getStorage();
        int[] storage2 = m2974normalizeYnv0uTE.component2().getStorage();
        int intValue = m2974normalizeYnv0uTE.component3().intValue();
        int m3612getSizeimpl = UIntArray.m3612getSizeimpl(storage);
        int m3612getSizeimpl2 = UIntArray.m3612getSizeimpl(storage2);
        int i5 = m3612getSizeimpl - m3612getSizeimpl2;
        int[] m3605constructorimpl = UIntArray.m3605constructorimpl(i5);
        int[] m2980shlWj2uyrI$bignum = m2980shlWj2uyrI$bignum(storage2, getBasePowerOfTwo() * i5);
        if (m2962compareToYnv0uTE$bignum(storage, m2980shlWj2uyrI$bignum) >= 0) {
            m3605constructorimpl = UIntArray.m3605constructorimpl(i5 + 1);
            UIntArray.m3616setVXSXFK8(m3605constructorimpl, i5, 1);
            storage = m2972minus00sMy4$bignum(storage, m2980shlWj2uyrI$bignum);
        }
        int i6 = i5 - 1;
        if (i6 >= 0) {
            while (true) {
                int i7 = i6 - 1;
                int i8 = m3612getSizeimpl2 + i6;
                long m3667ulongDivideeb3DHEI = i8 < UIntArray.m3612getSizeimpl(storage) ? UnsignedKt.m3667ulongDivideeb3DHEI(ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(storage, i8) & 4294967295L) << getBasePowerOfTwo()) + ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(storage, i8 - 1) & 4294967295L)), ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(storage2, m3612getSizeimpl2 - 1) & 4294967295L)) : i8 == UIntArray.m3612getSizeimpl(storage) ? ULong.m3622constructorimpl(Integer.divideUnsigned(UIntArray.m3611getpVg5ArA(storage, i8 - 1), UIntArray.m3611getpVg5ArA(storage2, m3612getSizeimpl2 - 1)) & 4294967295L) : 0L;
                UIntArray.m3616setVXSXFK8(m3605constructorimpl, i6, Long.compareUnsigned(m3667ulongDivideeb3DHEI, ULong.m3622constructorimpl(ULong.m3622constructorimpl(4294967295L & ((long) m2966getBasepVg5ArA())) - 1)) < 0 ? UInt.m3599constructorimpl((int) m3667ulongDivideeb3DHEI) : UInt.m3599constructorimpl(m2966getBasepVg5ArA() - 1));
                int[] m2980shlWj2uyrI$bignum2 = m2980shlWj2uyrI$bignum(m2983timesFE_7wA8$bignum(storage2, UIntArray.m3611getpVg5ArA(m3605constructorimpl, i6)), getBasePowerOfTwo() * i6);
                while (m2962compareToYnv0uTE$bignum(m2980shlWj2uyrI$bignum2, storage) > 0) {
                    UIntArray.m3616setVXSXFK8(m3605constructorimpl, i6, UInt.m3599constructorimpl(UIntArray.m3611getpVg5ArA(m3605constructorimpl, i6) - 1));
                    m2980shlWj2uyrI$bignum2 = m2980shlWj2uyrI$bignum(m2983timesFE_7wA8$bignum(storage2, UIntArray.m3611getpVg5ArA(m3605constructorimpl, i6)), getBasePowerOfTwo() * i6);
                }
                storage = m2972minus00sMy4$bignum(storage, m2980shlWj2uyrI$bignum2);
                if (i7 < 0) {
                    break;
                }
                i6 = i7;
            }
        }
        while (m2962compareToYnv0uTE$bignum(storage, storage2) >= 0) {
            m3605constructorimpl = m2976plusFE_7wA8$bignum(m3605constructorimpl, 1);
            storage = m2972minus00sMy4$bignum(storage, storage2);
        }
        return new Pair<>(UIntArray.m3604boximpl(m2977removeLeadingZeroshkIa6DI(m3605constructorimpl)), UIntArray.m3604boximpl(m2964denormalizeWj2uyrI(storage, intValue)));
    }

    /* renamed from: bitLength--ajY-9A, reason: not valid java name */
    public int m2959bitLengthajY9A(int[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (UIntArray.m3614isEmptyimpl(value)) {
            return 0;
        }
        return m2960bitLengthWZ4Q5Ns(UIntArray.m3611getpVg5ArA(value, UIntArray.m3612getSizeimpl(value) - 1)) + ((UIntArray.m3612getSizeimpl(value) - 1) * getBasePowerOfTwo());
    }

    /* renamed from: bitLength-WZ4Q5Ns, reason: not valid java name */
    public final int m2960bitLengthWZ4Q5Ns(int value) {
        return getBasePowerOfTwo() - m2975numberOfLeadingZerosInAWordWZ4Q5Ns(value);
    }

    /* renamed from: compare-Ynv0uTE, reason: not valid java name */
    public int m2961compareYnv0uTE(int[] first, int[] second) {
        boolean z5;
        boolean z6;
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        int m3612getSizeimpl = UIntArray.m3612getSizeimpl(first) - m2963countLeadingZeroWordsajY9A(first);
        int m3612getSizeimpl2 = UIntArray.m3612getSizeimpl(second) - m2963countLeadingZeroWordsajY9A(second);
        if (m3612getSizeimpl > m3612getSizeimpl2) {
            return 1;
        }
        if (m3612getSizeimpl2 > m3612getSizeimpl) {
            return -1;
        }
        int i5 = m3612getSizeimpl - 1;
        while (true) {
            if (i5 < 0) {
                z5 = false;
                z6 = true;
                break;
            }
            if (Integer.compareUnsigned(UIntArray.m3611getpVg5ArA(first, i5), UIntArray.m3611getpVg5ArA(second, i5)) > 0) {
                z6 = false;
                z5 = true;
                break;
            }
            if (Integer.compareUnsigned(UIntArray.m3611getpVg5ArA(first, i5), UIntArray.m3611getpVg5ArA(second, i5)) < 0) {
                z6 = false;
                z5 = false;
                break;
            }
            i5--;
        }
        if (z6) {
            return 0;
        }
        return z5 ? 1 : -1;
    }

    /* renamed from: compareTo-Ynv0uTE$bignum, reason: not valid java name */
    public final int m2962compareToYnv0uTE$bignum(int[] receiver, int[] other) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        Intrinsics.checkNotNullParameter(other, "other");
        return m2961compareYnv0uTE(receiver, other);
    }

    /* renamed from: countLeadingZeroWords--ajY-9A, reason: not valid java name */
    public final int m2963countLeadingZeroWordsajY9A(int[] bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "bigInteger");
        int m3612getSizeimpl = UIntArray.m3612getSizeimpl(bigInteger) - 1;
        if (m3612getSizeimpl <= 0) {
            return 0;
        }
        int m3611getpVg5ArA = UIntArray.m3611getpVg5ArA(bigInteger, m3612getSizeimpl);
        while (m3611getpVg5ArA == 0 && m3612getSizeimpl > 0) {
            m3612getSizeimpl--;
            m3611getpVg5ArA = UIntArray.m3611getpVg5ArA(bigInteger, m3612getSizeimpl);
        }
        if (UIntArray.m3611getpVg5ArA(bigInteger, m3612getSizeimpl) == 0) {
            m3612getSizeimpl--;
        }
        return (UIntArray.m3612getSizeimpl(bigInteger) - m3612getSizeimpl) - 1;
    }

    /* renamed from: denormalize-Wj2uyrI, reason: not valid java name */
    public final int[] m2964denormalizeWj2uyrI(int[] remainderNormalized, int normalizationShift) {
        Intrinsics.checkNotNullParameter(remainderNormalized, "remainderNormalized");
        return m2981shrWj2uyrI$bignum(remainderNormalized, normalizationShift);
    }

    /* renamed from: divide-Ynv0uTE, reason: not valid java name */
    public Pair<UIntArray, UIntArray> m2965divideYnv0uTE(int[] first, int[] second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        return m2958basicDivideYnv0uTE(first, second);
    }

    /* renamed from: getBase-pVg5ArA, reason: not valid java name */
    public final int m2966getBasepVg5ArA() {
        return base;
    }

    /* renamed from: getBaseMask-s-VKNKU, reason: not valid java name */
    public final long m2967getBaseMasksVKNKU() {
        return baseMask;
    }

    /* renamed from: getBaseMaskInt-pVg5ArA, reason: not valid java name */
    public final int m2968getBaseMaskIntpVg5ArA() {
        return baseMaskInt;
    }

    public int getBasePowerOfTwo() {
        return basePowerOfTwo;
    }

    /* renamed from: getOverflowMask-s-VKNKU, reason: not valid java name */
    public final long m2969getOverflowMasksVKNKU() {
        return overflowMask;
    }

    /* renamed from: getTWO--hP7Qyg, reason: not valid java name */
    public int[] m2970getTWOhP7Qyg() {
        return TWO;
    }

    /* renamed from: getZERO--hP7Qyg, reason: not valid java name */
    public int[] m2971getZEROhP7Qyg() {
        return ZERO;
    }

    /* renamed from: minus-0-0sMy4$bignum, reason: not valid java name */
    public final int[] m2972minus00sMy4$bignum(int[] receiver, int[] other) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        Intrinsics.checkNotNullParameter(other, "other");
        return m2982subtract00sMy4(receiver, other);
    }

    /* renamed from: multiply-FE_7wA8, reason: not valid java name */
    public final int[] m2973multiplyFE_7wA8(int[] first, int second) {
        Intrinsics.checkNotNullParameter(first, "first");
        int[] m3605constructorimpl = UIntArray.m3605constructorimpl(UIntArray.m3612getSizeimpl(first) + 1);
        int m3612getSizeimpl = UIntArray.m3612getSizeimpl(first);
        if (m3612getSizeimpl > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                long m3622constructorimpl = ULong.m3622constructorimpl(ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(first, i5) & 4294967295L) * ULong.m3622constructorimpl(second & 4294967295L));
                long m3622constructorimpl2 = ULong.m3622constructorimpl(ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(m3605constructorimpl, i5) & 4294967295L) + ULong.m3622constructorimpl(4294967295L & UInt.m3599constructorimpl((int) ULong.m3622constructorimpl(m2967getBaseMasksVKNKU() & m3622constructorimpl))));
                UIntArray.m3616setVXSXFK8(m3605constructorimpl, i5, UInt.m3599constructorimpl((int) ULong.m3622constructorimpl(m2967getBaseMasksVKNKU() & m3622constructorimpl2)));
                UIntArray.m3616setVXSXFK8(m3605constructorimpl, i6, UInt.m3599constructorimpl(UInt.m3599constructorimpl((int) ULong.m3622constructorimpl(m3622constructorimpl >>> getBasePowerOfTwo())) + UInt.m3599constructorimpl((int) ULong.m3622constructorimpl(m3622constructorimpl2 >>> getBasePowerOfTwo()))));
                if (i6 >= m3612getSizeimpl) {
                    break;
                }
                i5 = i6;
            }
        }
        return m2977removeLeadingZeroshkIa6DI(m3605constructorimpl);
    }

    /* renamed from: normalize-Ynv0uTE, reason: not valid java name */
    public final Triple<UIntArray, UIntArray, Integer> m2974normalizeYnv0uTE(int[] dividend, int[] divisor) {
        Intrinsics.checkNotNullParameter(dividend, "dividend");
        Intrinsics.checkNotNullParameter(divisor, "divisor");
        int m2975numberOfLeadingZerosInAWordWZ4Q5Ns = m2975numberOfLeadingZerosInAWordWZ4Q5Ns(UIntArray.m3611getpVg5ArA(divisor, UIntArray.m3612getSizeimpl(divisor) - 1));
        return new Triple<>(UIntArray.m3604boximpl(m2980shlWj2uyrI$bignum(dividend, m2975numberOfLeadingZerosInAWordWZ4Q5Ns)), UIntArray.m3604boximpl(m2980shlWj2uyrI$bignum(divisor, m2975numberOfLeadingZerosInAWordWZ4Q5Ns)), Integer.valueOf(m2975numberOfLeadingZerosInAWordWZ4Q5Ns));
    }

    /* renamed from: numberOfLeadingZerosInAWord-WZ4Q5Ns, reason: not valid java name */
    public int m2975numberOfLeadingZerosInAWordWZ4Q5Ns(int value) {
        int basePowerOfTwo2 = getBasePowerOfTwo();
        int m3599constructorimpl = UInt.m3599constructorimpl(value >>> 16);
        if (m3599constructorimpl != 0) {
            basePowerOfTwo2 -= 16;
            value = m3599constructorimpl;
        }
        int m3599constructorimpl2 = UInt.m3599constructorimpl(value >>> 8);
        if (m3599constructorimpl2 != 0) {
            basePowerOfTwo2 -= 8;
            value = m3599constructorimpl2;
        }
        int m3599constructorimpl3 = UInt.m3599constructorimpl(value >>> 4);
        if (m3599constructorimpl3 != 0) {
            basePowerOfTwo2 -= 4;
            value = m3599constructorimpl3;
        }
        int m3599constructorimpl4 = UInt.m3599constructorimpl(value >>> 2);
        if (m3599constructorimpl4 != 0) {
            basePowerOfTwo2 -= 2;
            value = m3599constructorimpl4;
        }
        return UInt.m3599constructorimpl(value >>> 1) != 0 ? basePowerOfTwo2 - 2 : basePowerOfTwo2 - value;
    }

    /* renamed from: plus-FE_7wA8$bignum, reason: not valid java name */
    public final int[] m2976plusFE_7wA8$bignum(int[] receiver, int i5) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        return m2957add00sMy4(receiver, new int[]{i5});
    }

    /* renamed from: removeLeadingZeros-hkIa6DI, reason: not valid java name */
    public final int[] m2977removeLeadingZeroshkIa6DI(int[] bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "bigInteger");
        int length = bigInteger.length - 1;
        while (true) {
            if (length < 0) {
                length = -1;
                break;
            }
            if (UInt.m3599constructorimpl(bigInteger[length]) != 0) {
                break;
            }
            length--;
        }
        int i5 = length + 1;
        return (i5 == -1 || i5 == 0) ? m2971getZEROhP7Qyg() : UIntArray.m3606constructorimpl(ArraysKt.copyOfRange(bigInteger, 0, i5));
    }

    /* renamed from: shiftLeft-Wj2uyrI, reason: not valid java name */
    public int[] m2978shiftLeftWj2uyrI(int[] operand, int places) {
        int m3599constructorimpl;
        Intrinsics.checkNotNullParameter(operand, "operand");
        if (UIntArray.m3614isEmptyimpl(operand) || places == 0) {
            return operand;
        }
        int m3612getSizeimpl = UIntArray.m3612getSizeimpl(operand);
        int m2975numberOfLeadingZerosInAWordWZ4Q5Ns = m2975numberOfLeadingZerosInAWordWZ4Q5Ns(UIntArray.m3611getpVg5ArA(operand, UIntArray.m3612getSizeimpl(operand) - 1));
        int basePowerOfTwo2 = places / getBasePowerOfTwo();
        int basePowerOfTwo3 = places % getBasePowerOfTwo();
        int i5 = basePowerOfTwo3 > m2975numberOfLeadingZerosInAWordWZ4Q5Ns ? basePowerOfTwo2 + 1 : basePowerOfTwo2;
        if (basePowerOfTwo3 == 0) {
            int m3612getSizeimpl2 = UIntArray.m3612getSizeimpl(operand) + i5;
            int[] iArr = new int[m3612getSizeimpl2];
            int i6 = 0;
            while (i6 < m3612getSizeimpl2) {
                iArr[i6] = (i6 < 0 || i6 >= basePowerOfTwo2) ? UIntArray.m3611getpVg5ArA(operand, i6 - basePowerOfTwo2) : 0;
                i6++;
            }
            return UIntArray.m3606constructorimpl(iArr);
        }
        int m3612getSizeimpl3 = UIntArray.m3612getSizeimpl(operand) + i5;
        int[] iArr2 = new int[m3612getSizeimpl3];
        for (int i7 = 0; i7 < m3612getSizeimpl3; i7++) {
            if (i7 >= 0 && i7 < basePowerOfTwo2) {
                m3599constructorimpl = 0;
            } else if (i7 == basePowerOfTwo2) {
                m3599constructorimpl = UInt.m3599constructorimpl(UIntArray.m3611getpVg5ArA(operand, i7 - basePowerOfTwo2) << basePowerOfTwo3);
            } else {
                int i8 = basePowerOfTwo2 + 1;
                if (i7 < m3612getSizeimpl + basePowerOfTwo2 && i8 <= i7) {
                    int i9 = i7 - basePowerOfTwo2;
                    m3599constructorimpl = UInt.m3599constructorimpl(UInt.m3599constructorimpl(UIntArray.m3611getpVg5ArA(operand, i9 - 1) >>> (INSTANCE.getBasePowerOfTwo() - basePowerOfTwo3)) | UInt.m3599constructorimpl(UIntArray.m3611getpVg5ArA(operand, i9) << basePowerOfTwo3));
                } else {
                    if (i7 != (m3612getSizeimpl + i5) - 1) {
                        throw new RuntimeException(Intrinsics.stringPlus("Invalid case ", Integer.valueOf(i7)));
                    }
                    m3599constructorimpl = UInt.m3599constructorimpl(UIntArray.m3611getpVg5ArA(operand, i7 - i5) >>> (INSTANCE.getBasePowerOfTwo() - basePowerOfTwo3));
                }
            }
            iArr2[i7] = m3599constructorimpl;
        }
        return UIntArray.m3606constructorimpl(iArr2);
    }

    /* renamed from: shiftRight-Wj2uyrI, reason: not valid java name */
    public int[] m2979shiftRightWj2uyrI(int[] operand, int places) {
        int m3599constructorimpl;
        Intrinsics.checkNotNullParameter(operand, "operand");
        if (UIntArray.m3614isEmptyimpl(operand) || places == 0) {
            return operand;
        }
        int basePowerOfTwo2 = places % getBasePowerOfTwo();
        int basePowerOfTwo3 = places / getBasePowerOfTwo();
        if (basePowerOfTwo3 >= UIntArray.m3612getSizeimpl(operand)) {
            return m2971getZEROhP7Qyg();
        }
        if (basePowerOfTwo2 == 0) {
            return UIntArray.m3606constructorimpl(ArraysKt.copyOfRange(operand, basePowerOfTwo3, UIntArray.m3612getSizeimpl(operand)));
        }
        if (UIntArray.m3612getSizeimpl(operand) > 1 && UIntArray.m3612getSizeimpl(operand) - basePowerOfTwo3 == 1) {
            return new int[]{UInt.m3599constructorimpl(UIntArray.m3611getpVg5ArA(operand, UIntArray.m3612getSizeimpl(operand) - 1) >>> basePowerOfTwo2)};
        }
        int m3612getSizeimpl = UIntArray.m3612getSizeimpl(operand) - basePowerOfTwo3;
        int[] iArr = new int[m3612getSizeimpl];
        for (int i5 = 0; i5 < m3612getSizeimpl; i5++) {
            if (i5 >= 0 && i5 < (UIntArray.m3612getSizeimpl(operand) - 1) - basePowerOfTwo3) {
                int i6 = i5 + basePowerOfTwo3;
                m3599constructorimpl = UInt.m3599constructorimpl(UInt.m3599constructorimpl(UIntArray.m3611getpVg5ArA(operand, i6 + 1) << (INSTANCE.getBasePowerOfTwo() - basePowerOfTwo2)) | UInt.m3599constructorimpl(UIntArray.m3611getpVg5ArA(operand, i6) >>> basePowerOfTwo2));
            } else {
                if (i5 != (UIntArray.m3612getSizeimpl(operand) - 1) - basePowerOfTwo3) {
                    throw new RuntimeException(Intrinsics.stringPlus("Invalid case ", Integer.valueOf(i5)));
                }
                m3599constructorimpl = UInt.m3599constructorimpl(UIntArray.m3611getpVg5ArA(operand, i5 + basePowerOfTwo3) >>> basePowerOfTwo2);
            }
            iArr[i5] = m3599constructorimpl;
        }
        return m2977removeLeadingZeroshkIa6DI(UIntArray.m3606constructorimpl(iArr));
    }

    /* renamed from: shl-Wj2uyrI$bignum, reason: not valid java name */
    public final int[] m2980shlWj2uyrI$bignum(int[] receiver, int i5) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        return m2978shiftLeftWj2uyrI(receiver, i5);
    }

    /* renamed from: shr-Wj2uyrI$bignum, reason: not valid java name */
    public final int[] m2981shrWj2uyrI$bignum(int[] receiver, int i5) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        return m2979shiftRightWj2uyrI(receiver, i5);
    }

    /* renamed from: subtract-0-0sMy4, reason: not valid java name */
    public int[] m2982subtract00sMy4(int[] first, int[] second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        int[] m2977removeLeadingZeroshkIa6DI = m2977removeLeadingZeroshkIa6DI(first);
        int[] m2977removeLeadingZeroshkIa6DI2 = m2977removeLeadingZeroshkIa6DI(second);
        Quadruple quadruple = m2961compareYnv0uTE(m2977removeLeadingZeroshkIa6DI, m2977removeLeadingZeroshkIa6DI2) == 1 ? new Quadruple(Integer.valueOf(UIntArray.m3612getSizeimpl(m2977removeLeadingZeroshkIa6DI)), Integer.valueOf(UIntArray.m3612getSizeimpl(m2977removeLeadingZeroshkIa6DI2)), UIntArray.m3604boximpl(m2977removeLeadingZeroshkIa6DI), UIntArray.m3604boximpl(m2977removeLeadingZeroshkIa6DI2)) : new Quadruple(Integer.valueOf(UIntArray.m3612getSizeimpl(m2977removeLeadingZeroshkIa6DI2)), Integer.valueOf(UIntArray.m3612getSizeimpl(m2977removeLeadingZeroshkIa6DI)), UIntArray.m3604boximpl(m2977removeLeadingZeroshkIa6DI2), UIntArray.m3604boximpl(m2977removeLeadingZeroshkIa6DI));
        int intValue = ((Number) quadruple.component1()).intValue();
        int intValue2 = ((Number) quadruple.component2()).intValue();
        int[] storage = ((UIntArray) quadruple.component3()).getStorage();
        int[] storage2 = ((UIntArray) quadruple.component4()).getStorage();
        int i5 = intValue + 1;
        int[] iArr = new int[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            iArr[i6] = 0;
        }
        int[] m3606constructorimpl = UIntArray.m3606constructorimpl(iArr);
        int i7 = 0;
        long j5 = 0;
        while (i7 < intValue2) {
            if (i7 >= UIntArray.m3612getSizeimpl(storage)) {
                System.out.println((Object) "Breakpoint");
            }
            if (i7 >= UIntArray.m3612getSizeimpl(storage2)) {
                System.out.println((Object) "Breakpoint");
            }
            long m3622constructorimpl = ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(storage, i7) & 4294967295L) - ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(storage2, i7) & 4294967295L)) - j5);
            UIntArray.m3616setVXSXFK8(m3606constructorimpl, i7, UInt.m3599constructorimpl((int) m3622constructorimpl));
            j5 = ULong.m3622constructorimpl(ULong.m3622constructorimpl(m3622constructorimpl & m2969getOverflowMasksVKNKU()) >>> wordSizeInBits);
            i7++;
            storage = storage;
        }
        int[] iArr2 = storage;
        while (j5 != 0) {
            long m3622constructorimpl2 = ULong.m3622constructorimpl(ULong.m3622constructorimpl(UIntArray.m3611getpVg5ArA(iArr2, i7) & 4294967295L) - j5);
            UIntArray.m3616setVXSXFK8(m3606constructorimpl, i7, UInt.m3599constructorimpl(UInt.m3599constructorimpl((int) m3622constructorimpl2) & m2968getBaseMaskIntpVg5ArA()));
            j5 = ULong.m3622constructorimpl(ULong.m3622constructorimpl(m3622constructorimpl2 & m2969getOverflowMasksVKNKU()) >>> wordSizeInBits);
            i7++;
        }
        while (i7 < intValue) {
            UIntArray.m3616setVXSXFK8(m3606constructorimpl, i7, UIntArray.m3611getpVg5ArA(iArr2, i7));
            i7++;
        }
        ArrayList arrayList = new ArrayList();
        for (int i8 : m3606constructorimpl) {
            if (i8 == 0) {
                arrayList.add(UInt.m3598boximpl(i8));
            }
        }
        if (arrayList.isEmpty()) {
            return m2971getZEROhP7Qyg();
        }
        int i9 = -1;
        int length = m3606constructorimpl.length - 1;
        while (true) {
            if (length < 0) {
                break;
            }
            if (UInt.m3599constructorimpl(m3606constructorimpl[length]) != 0) {
                i9 = length;
                break;
            }
            length--;
        }
        return UIntArray.m3606constructorimpl(ArraysKt.copyOfRange(m3606constructorimpl, 0, i9 + 1));
    }

    /* renamed from: times-FE_7wA8$bignum, reason: not valid java name */
    public final int[] m2983timesFE_7wA8$bignum(int[] receiver, int i5) {
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        return m2973multiplyFE_7wA8(receiver, i5);
    }
}
