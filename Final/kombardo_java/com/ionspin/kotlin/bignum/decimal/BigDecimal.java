package com.ionspin.kotlin.bignum.decimal;

import com.adjust.sdk.Constants;
import com.ionspin.kotlin.bignum.BigNumber;
import com.ionspin.kotlin.bignum.CommonBigNumberOperations;
import com.ionspin.kotlin.bignum.integer.BigInteger;
import com.ionspin.kotlin.bignum.integer.BigIntegerExtensionsKt;
import com.ionspin.kotlin.bignum.integer.ComparisonWorkaround;
import com.ionspin.kotlin.bignum.integer.Sign;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\f\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 k2\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0002klB'\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u000fJ1\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010#\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001dH\u0002¢\u0006\u0004\b#\u0010$J\u001f\u0010%\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001dH\u0002¢\u0006\u0004\b%\u0010$J\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00000&H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0000H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0016¢\u0006\u0004\b+\u0010\u000fJ!\u0010+\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b+\u0010-J\u0017\u0010.\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0016¢\u0006\u0004\b.\u0010\u000fJ!\u0010.\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b.\u0010-J\u0017\u0010/\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0016¢\u0006\u0004\b/\u0010\u000fJ!\u0010/\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b/\u0010-J\u0017\u00100\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0016¢\u0006\u0004\b0\u0010\u000fJ!\u00100\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b0\u0010-J\u0017\u00101\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0016¢\u0006\u0004\b1\u0010\u000fJ#\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000022\u0006\u0010\u0010\u001a\u00020\u0000H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107J-\u0010:\u001a\u00020\u00002\b\b\u0002\u00108\u001a\u00020\u00052\b\b\u0002\u00109\u001a\u00020\u00072\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b:\u0010;J\u0015\u0010=\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0007¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\u0000¢\u0006\u0004\b?\u0010*J\r\u0010@\u001a\u00020\u0005¢\u0006\u0004\b@\u0010AJ\u0018\u0010B\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\bB\u0010\u000fJ\u0018\u0010C\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\bC\u0010\u000fJ\u000f\u0010D\u001a\u00020\u001dH\u0016¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bF\u0010GJ\u0015\u0010H\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u0000¢\u0006\u0004\bH\u0010IJ\u0018\u0010J\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\bJ\u0010KJ\u001a\u0010L\u001a\u0002052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020\u001dH\u0016¢\u0006\u0004\bN\u0010EJ\u000f\u0010O\u001a\u00020 H\u0016¢\u0006\u0004\bO\u0010PJ\r\u0010Q\u001a\u00020 ¢\u0006\u0004\bQ\u0010PJ\u001c\u0010C\u001a\u00020 *\u00020\u00072\u0006\u0010S\u001a\u00020RH\u0086\u0002¢\u0006\u0004\bC\u0010TR\u0017\u0010U\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u0017\u00108\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b8\u0010Y\u001a\u0004\bZ\u0010AR\u0017\u00109\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b9\u0010V\u001a\u0004\b[\u0010XR\u0019\u0010,\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b,\u0010\\\u001a\u0004\b]\u0010^R\u0017\u0010_\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b_\u0010V\u001a\u0004\b`\u0010XR\u0017\u0010b\u001a\u00020a8\u0006¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u0017\u0010f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\bf\u0010V\u001a\u0004\bg\u0010XR\u0017\u0010h\u001a\u0002058\u0006¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u00107¨\u0006m"}, d2 = {"Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", "Lcom/ionspin/kotlin/bignum/BigNumber;", "Lcom/ionspin/kotlin/bignum/CommonBigNumberOperations;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "_significand", BuildConfig.FLAVOR, "_exponent", "Lcom/ionspin/kotlin/bignum/decimal/DecimalMode;", "_decimalMode", "<init>", "(Lcom/ionspin/kotlin/bignum/integer/BigInteger;JLcom/ionspin/kotlin/bignum/decimal/DecimalMode;)V", "bigDecimal", "removeTrailingZeroes", "(Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", "other", "Lcom/ionspin/kotlin/bignum/decimal/BigDecimal$ScaleOps;", "op", "computeMode", "(Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;Lcom/ionspin/kotlin/bignum/decimal/BigDecimal$ScaleOps;)Lcom/ionspin/kotlin/bignum/decimal/DecimalMode;", "getRidOfRadix", "first", "second", "Lkotlin/Triple;", "bringSignificandToSameExponent", "(Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;)Lkotlin/Triple;", BuildConfig.FLAVOR, "number", BuildConfig.FLAVOR, "javascriptNumberComparison", "(Ljava/lang/Number;)I", BuildConfig.FLAVOR, "input", "position", "placeADotInStringExpanded", "(Ljava/lang/String;I)Ljava/lang/String;", "placeADotInString", "Lcom/ionspin/kotlin/bignum/BigNumber$Creator;", "getCreator", "()Lcom/ionspin/kotlin/bignum/BigNumber$Creator;", "getInstance", "()Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", "add", "decimalMode", "(Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;Lcom/ionspin/kotlin/bignum/decimal/DecimalMode;)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", "subtract", "multiply", "divide", "remainder", "Lkotlin/Pair;", "divideAndRemainder", "(Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;)Lkotlin/Pair;", BuildConfig.FLAVOR, "isZero", "()Z", "significand", "exponent", "copy", "(Lcom/ionspin/kotlin/bignum/integer/BigInteger;JLcom/ionspin/kotlin/bignum/decimal/DecimalMode;)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", "places", "moveDecimalPoint", "(J)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", "floor", "toBigInteger", "()Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "minus", "times", "signum", "()I", "roundSignificand", "(Lcom/ionspin/kotlin/bignum/decimal/DecimalMode;)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", "compare", "(Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;)I", "compareTo", "(Ljava/lang/Object;)I", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "()Ljava/lang/String;", "toStringExpanded", BuildConfig.FLAVOR, "char", "(JC)Ljava/lang/String;", "precision", "J", "getPrecision", "()J", "Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "getSignificand", "getExponent", "Lcom/ionspin/kotlin/bignum/decimal/DecimalMode;", "getDecimalMode", "()Lcom/ionspin/kotlin/bignum/decimal/DecimalMode;", "precisionLimit", "getPrecisionLimit", "Lcom/ionspin/kotlin/bignum/decimal/RoundingMode;", "roundingMode", "Lcom/ionspin/kotlin/bignum/decimal/RoundingMode;", "getRoundingMode", "()Lcom/ionspin/kotlin/bignum/decimal/RoundingMode;", "scale", "getScale", "usingScale", "Z", "getUsingScale", "Companion", "ScaleOps", "bignum"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class BigDecimal implements BigNumber<BigDecimal>, CommonBigNumberOperations<BigDecimal>, Comparable<Object> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final BigDecimal ONE;
    private static final BigDecimal TEN;
    private static final BigDecimal TWO;
    private static final BigDecimal ZERO;
    private static final double[] double10pow;
    private static final float[] float10pow;
    private static final BigDecimal leastSignificantDouble;
    private static final BigDecimal leastSignificantFloat;
    private static final BigDecimal maximumDouble;
    private static final BigDecimal maximumFloat;
    private static boolean useToStringExpanded;
    private final DecimalMode decimalMode;
    private final long exponent;
    private final long precision;
    private final long precisionLimit;
    private final RoundingMode roundingMode;
    private final long scale;
    private final BigInteger significand;
    private final boolean usingScale;

    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\b\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001QB\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\fJ'\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\fJ-\u0010\u0018\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\fJ!\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b \u0010!J!\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b$\u0010%J!\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b(\u0010)J!\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b,\u0010-J!\u00100\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b0\u00101J\u0017\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u00102J\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u00103J\u0017\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u00104J\u0017\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u00105J\u001f\u00108\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*2\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109J\u001f\u0010:\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.2\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b:\u0010;J\u0015\u0010>\u001a\u00020\u00022\u0006\u0010=\u001a\u00020<¢\u0006\u0004\b>\u0010?J!\u0010A\u001a\u00020\u00022\u0006\u0010@\u001a\u00020<2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010DR\u0014\u0010N\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010DR\u0014\u0010O\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010DR\u0014\u0010P\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010D¨\u0006R"}, d2 = {"Lcom/ionspin/kotlin/bignum/decimal/BigDecimal$Companion;", "Lcom/ionspin/kotlin/bignum/BigNumber$Creator;", "Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", "<init>", "()V", "Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "significand", BuildConfig.FLAVOR, "exponent", "Lcom/ionspin/kotlin/bignum/decimal/DecimalMode;", "decimalMode", "roundOrDont", "(Lcom/ionspin/kotlin/bignum/integer/BigInteger;JLcom/ionspin/kotlin/bignum/decimal/DecimalMode;)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", "discarded", "Lcom/ionspin/kotlin/bignum/decimal/BigDecimal$Companion$SignificantDecider;", "determineDecider", "(Lcom/ionspin/kotlin/bignum/integer/BigInteger;)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal$Companion$SignificantDecider;", "roundDiscarded", "(Lcom/ionspin/kotlin/bignum/integer/BigInteger;Lcom/ionspin/kotlin/bignum/integer/BigInteger;Lcom/ionspin/kotlin/bignum/decimal/DecimalMode;)Lcom/ionspin/kotlin/bignum/integer/BigInteger;", "roundSignificand", "applyScale", "firstDecimalMode", "secondDecimalMode", "suppliedDecimalMode", "resolveDecimalMode", "(Lcom/ionspin/kotlin/bignum/decimal/DecimalMode;Lcom/ionspin/kotlin/bignum/decimal/DecimalMode;Lcom/ionspin/kotlin/bignum/decimal/DecimalMode;)Lcom/ionspin/kotlin/bignum/decimal/DecimalMode;", "handleZeroRounding", Constants.LONG, "fromLong", "(JLcom/ionspin/kotlin/bignum/decimal/DecimalMode;)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", BuildConfig.FLAVOR, "int", "fromInt", "(ILcom/ionspin/kotlin/bignum/decimal/DecimalMode;)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", BuildConfig.FLAVOR, "short", "fromShort", "(SLcom/ionspin/kotlin/bignum/decimal/DecimalMode;)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", BuildConfig.FLAVOR, "byte", "fromByte", "(BLcom/ionspin/kotlin/bignum/decimal/DecimalMode;)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", BuildConfig.FLAVOR, "float", "fromFloat", "(FLcom/ionspin/kotlin/bignum/decimal/DecimalMode;)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", BuildConfig.FLAVOR, "double", "fromDouble", "(DLcom/ionspin/kotlin/bignum/decimal/DecimalMode;)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", "(J)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", "(I)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", "(S)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", "(B)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", BuildConfig.FLAVOR, "exactRequired", "tryFromFloat", "(FZ)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", "tryFromDouble", "(DZ)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", BuildConfig.FLAVOR, "string", "parseString", "(Ljava/lang/String;)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", "floatingPointString", "parseStringWithMode", "(Ljava/lang/String;Lcom/ionspin/kotlin/bignum/decimal/DecimalMode;)Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", "ZERO", "Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", "getZERO", "()Lcom/ionspin/kotlin/bignum/decimal/BigDecimal;", BuildConfig.FLAVOR, "double10pow", "[D", BuildConfig.FLAVOR, "float10pow", "[F", "leastSignificantDouble", "leastSignificantFloat", "maximumDouble", "maximumFloat", "SignificantDecider", "bignum"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion implements BigNumber.Creator<BigDecimal> {

        /* JADX INFO: Access modifiers changed from: private */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ionspin/kotlin/bignum/decimal/BigDecimal$Companion$SignificantDecider;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "FIVE", "LESS_THAN_FIVE", "MORE_THAN_FIVE", "bignum"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes2.dex */
        public enum SignificantDecider {
            FIVE,
            LESS_THAN_FIVE,
            MORE_THAN_FIVE
        }

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[RoundingMode.values().length];
                iArr[RoundingMode.AWAY_FROM_ZERO.ordinal()] = 1;
                iArr[RoundingMode.TOWARDS_ZERO.ordinal()] = 2;
                iArr[RoundingMode.CEILING.ordinal()] = 3;
                iArr[RoundingMode.FLOOR.ordinal()] = 4;
                iArr[RoundingMode.ROUND_HALF_AWAY_FROM_ZERO.ordinal()] = 5;
                iArr[RoundingMode.ROUND_HALF_TOWARDS_ZERO.ordinal()] = 6;
                iArr[RoundingMode.ROUND_HALF_CEILING.ordinal()] = 7;
                iArr[RoundingMode.ROUND_HALF_FLOOR.ordinal()] = 8;
                iArr[RoundingMode.ROUND_HALF_TO_EVEN.ordinal()] = 9;
                iArr[RoundingMode.ROUND_HALF_TO_ODD.ordinal()] = 10;
                iArr[RoundingMode.NONE.ordinal()] = 11;
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[Sign.values().length];
                iArr2[Sign.POSITIVE.ordinal()] = 1;
                iArr2[Sign.NEGATIVE.ordinal()] = 2;
                iArr2[Sign.ZERO.ordinal()] = 3;
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BigDecimal applyScale(BigInteger significand, long exponent, DecimalMode decimalMode) {
            DecimalMode decimalMode2;
            if (!decimalMode.getUsingScale()) {
                return new BigDecimal(significand, exponent, decimalMode, null);
            }
            if (exponent >= 0) {
                decimalMode2 = new DecimalMode(decimalMode.getScale() + exponent + 1, decimalMode.getRoundingMode(), 0L, 4, null);
            } else {
                if (exponent >= 0) {
                    throw new RuntimeException("Unexpected state");
                }
                decimalMode2 = new DecimalMode(decimalMode.getScale() + 1, decimalMode.getRoundingMode(), 0L, 4, null);
            }
            DecimalMode decimalMode3 = decimalMode2;
            if (exponent >= 0) {
                return roundSignificand(significand, exponent, decimalMode3);
            }
            BigDecimal bigDecimal = (BigDecimal) new BigDecimal(significand, exponent, null, 4, null).plus(significand.signum());
            return (BigDecimal) roundSignificand(bigDecimal.getSignificand(), bigDecimal.getExponent(), decimalMode3).minus(significand.signum());
        }

        private final SignificantDecider determineDecider(BigInteger discarded) {
            BigInteger.Companion companion = BigInteger.INSTANCE;
            BigInteger.QuotientAndRemainder divrem = discarded.divrem(companion.getTEN().pow(discarded.numberOfDecimalDigits() - 1));
            int intValue = divrem.getQuotient().abs().intValue(true);
            BigInteger abs = divrem.getRemainder().abs();
            if (intValue == 5) {
                return Intrinsics.areEqual(abs, companion.getZERO()) ? SignificantDecider.FIVE : SignificantDecider.MORE_THAN_FIVE;
            }
            if (intValue > 5) {
                return SignificantDecider.MORE_THAN_FIVE;
            }
            if (intValue < 5) {
                return SignificantDecider.LESS_THAN_FIVE;
            }
            throw new RuntimeException("Couldn't determine decider");
        }

        public static /* synthetic */ BigDecimal fromDouble$default(Companion companion, double d5, DecimalMode decimalMode, int i5, Object obj) {
            if ((i5 & 2) != 0) {
                decimalMode = null;
            }
            return companion.fromDouble(d5, decimalMode);
        }

        public static /* synthetic */ BigDecimal fromFloat$default(Companion companion, float f5, DecimalMode decimalMode, int i5, Object obj) {
            if ((i5 & 2) != 0) {
                decimalMode = null;
            }
            return companion.fromFloat(f5, decimalMode);
        }

        public static /* synthetic */ BigDecimal parseStringWithMode$default(Companion companion, String str, DecimalMode decimalMode, int i5, Object obj) {
            if ((i5 & 2) != 0) {
                decimalMode = null;
            }
            return companion.parseStringWithMode(str, decimalMode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DecimalMode resolveDecimalMode(DecimalMode firstDecimalMode, DecimalMode secondDecimalMode, DecimalMode suppliedDecimalMode) {
            if (suppliedDecimalMode != null) {
                return suppliedDecimalMode;
            }
            if (firstDecimalMode == null && secondDecimalMode == null) {
                return new DecimalMode(0L, null, 0L, 7, null);
            }
            if (firstDecimalMode == null && secondDecimalMode != null) {
                return secondDecimalMode;
            }
            if (secondDecimalMode == null && firstDecimalMode != null) {
                return firstDecimalMode;
            }
            Intrinsics.checkNotNull(firstDecimalMode);
            RoundingMode roundingMode = firstDecimalMode.getRoundingMode();
            Intrinsics.checkNotNull(secondDecimalMode);
            if (roundingMode == secondDecimalMode.getRoundingMode()) {
                if (firstDecimalMode.getDecimalPrecision() < secondDecimalMode.getDecimalPrecision()) {
                    firstDecimalMode = secondDecimalMode;
                }
                return firstDecimalMode;
            }
            throw new ArithmeticException("Different rounding modes! This: " + firstDecimalMode.getRoundingMode() + " Other: " + secondDecimalMode.getRoundingMode());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BigInteger roundDiscarded(BigInteger significand, BigInteger discarded, DecimalMode decimalMode) {
            Pair pair;
            long numberOfDecimalDigits = significand.numberOfDecimalDigits() - decimalMode.getDecimalPrecision();
            if (numberOfDecimalDigits > 0) {
                BigInteger.QuotientAndRemainder divrem = significand.divrem(BigInteger.INSTANCE.getTEN().pow(numberOfDecimalDigits));
                pair = new Pair(divrem.getQuotient(), divrem.getRemainder());
            } else {
                pair = new Pair(significand, discarded);
            }
            BigInteger bigInteger = (BigInteger) pair.component1();
            BigInteger bigInteger2 = (BigInteger) pair.component2();
            BigInteger.Companion companion = BigInteger.INSTANCE;
            Sign sign = Intrinsics.areEqual(significand, companion.getZERO()) ? discarded.getSign() : significand.getSign();
            if (bigInteger2.isZero()) {
                return bigInteger;
            }
            SignificantDecider determineDecider = determineDecider(bigInteger2);
            switch (WhenMappings.$EnumSwitchMapping$0[decimalMode.getRoundingMode().ordinal()]) {
                case 1:
                    return sign == Sign.POSITIVE ? bigInteger.inc() : bigInteger.dec();
                case 2:
                default:
                    return bigInteger;
                case 3:
                    return sign == Sign.POSITIVE ? bigInteger.inc() : bigInteger;
                case 4:
                    return sign == Sign.POSITIVE ? bigInteger : bigInteger.dec();
                case 5:
                    int i5 = WhenMappings.$EnumSwitchMapping$1[sign.ordinal()];
                    return i5 != 1 ? (i5 == 2 && determineDecider != SignificantDecider.LESS_THAN_FIVE) ? bigInteger.dec() : bigInteger : determineDecider != SignificantDecider.LESS_THAN_FIVE ? bigInteger.inc() : bigInteger;
                case 6:
                    int i6 = WhenMappings.$EnumSwitchMapping$1[sign.ordinal()];
                    return i6 != 1 ? (i6 == 2 && determineDecider == SignificantDecider.MORE_THAN_FIVE) ? bigInteger.dec() : bigInteger : determineDecider == SignificantDecider.MORE_THAN_FIVE ? bigInteger.inc() : bigInteger;
                case 7:
                    int i7 = WhenMappings.$EnumSwitchMapping$1[sign.ordinal()];
                    return i7 != 1 ? (i7 == 2 && determineDecider == SignificantDecider.MORE_THAN_FIVE) ? bigInteger.dec() : bigInteger : determineDecider != SignificantDecider.LESS_THAN_FIVE ? bigInteger.inc() : bigInteger;
                case 8:
                    int i8 = WhenMappings.$EnumSwitchMapping$1[sign.ordinal()];
                    return i8 != 1 ? (i8 == 2 && determineDecider != SignificantDecider.LESS_THAN_FIVE) ? bigInteger.dec() : bigInteger : determineDecider == SignificantDecider.MORE_THAN_FIVE ? bigInteger.inc() : bigInteger;
                case 9:
                    if (determineDecider == SignificantDecider.FIVE) {
                        if (Intrinsics.areEqual(significand.rem(2), companion.getONE())) {
                            int i9 = WhenMappings.$EnumSwitchMapping$1[sign.ordinal()];
                            return i9 != 1 ? (i9 == 2 && determineDecider != SignificantDecider.LESS_THAN_FIVE) ? bigInteger.dec() : bigInteger : determineDecider != SignificantDecider.LESS_THAN_FIVE ? bigInteger.inc() : bigInteger;
                        }
                        int i10 = WhenMappings.$EnumSwitchMapping$1[sign.ordinal()];
                        return i10 != 1 ? (i10 == 2 && determineDecider != SignificantDecider.LESS_THAN_FIVE) ? bigInteger.dec() : bigInteger : determineDecider == SignificantDecider.MORE_THAN_FIVE ? bigInteger.inc() : bigInteger;
                    }
                    if (determineDecider != SignificantDecider.MORE_THAN_FIVE) {
                        return bigInteger;
                    }
                    if (sign == Sign.POSITIVE) {
                        bigInteger = bigInteger.inc();
                    }
                    return sign == Sign.NEGATIVE ? bigInteger.dec() : bigInteger;
                case 10:
                    if (determineDecider == SignificantDecider.FIVE) {
                        if (Intrinsics.areEqual(significand.rem(2), companion.getZERO())) {
                            int i11 = WhenMappings.$EnumSwitchMapping$1[sign.ordinal()];
                            return i11 != 1 ? (i11 == 2 && determineDecider != SignificantDecider.LESS_THAN_FIVE) ? bigInteger.dec() : bigInteger : determineDecider != SignificantDecider.LESS_THAN_FIVE ? bigInteger.inc() : bigInteger;
                        }
                        int i12 = WhenMappings.$EnumSwitchMapping$1[sign.ordinal()];
                        return i12 != 1 ? (i12 == 2 && determineDecider != SignificantDecider.LESS_THAN_FIVE) ? bigInteger.dec() : bigInteger : determineDecider == SignificantDecider.MORE_THAN_FIVE ? bigInteger.inc() : bigInteger;
                    }
                    if (determineDecider != SignificantDecider.MORE_THAN_FIVE) {
                        return bigInteger;
                    }
                    if (sign == Sign.POSITIVE) {
                        bigInteger = bigInteger.inc();
                    }
                    return sign == Sign.NEGATIVE ? bigInteger.dec() : bigInteger;
                case 11:
                    throw new ArithmeticException("Non-terminating result of division operation. Specify decimalPrecision");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BigDecimal roundOrDont(BigInteger significand, long exponent, DecimalMode decimalMode) {
            if (!decimalMode.getIsPrecisionUnlimited()) {
                return roundSignificand(significand, exponent, decimalMode);
            }
            return new BigDecimal(significand, exponent, null, 4, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BigDecimal roundSignificand(BigInteger significand, long exponent, DecimalMode decimalMode) {
            BigInteger.Companion companion = BigInteger.INSTANCE;
            if (Intrinsics.areEqual(significand, companion.getZERO())) {
                return new BigDecimal(companion.getZERO(), exponent, decimalMode, null);
            }
            long numberOfDecimalDigits = significand.numberOfDecimalDigits();
            long decimalPrecision = decimalMode.getUsingScale() ? decimalMode.getDecimalPrecision() + decimalMode.getScale() : decimalMode.getDecimalPrecision();
            if (decimalPrecision > numberOfDecimalDigits) {
                return new BigDecimal((BigInteger) significand.times((BigNumber) companion.getTEN().pow(decimalPrecision - numberOfDecimalDigits)), exponent, decimalMode, null);
            }
            if (decimalPrecision >= numberOfDecimalDigits) {
                return new BigDecimal(significand, exponent, decimalMode, null);
            }
            BigInteger.QuotientAndRemainder divrem = significand.divrem(companion.getTEN().pow(numberOfDecimalDigits - decimalPrecision));
            BigInteger remainder = divrem.getRemainder();
            if (Intrinsics.areEqual(divrem.getRemainder(), companion.getZERO())) {
                return new BigDecimal(divrem.getQuotient(), exponent, decimalMode, null);
            }
            if (significand.numberOfDecimalDigits() != divrem.getQuotient().numberOfDecimalDigits() + divrem.getRemainder().numberOfDecimalDigits()) {
                return handleZeroRounding(divrem.getQuotient(), exponent, decimalMode);
            }
            BigInteger roundDiscarded = roundDiscarded(divrem.getQuotient(), remainder, decimalMode);
            return new BigDecimal(roundDiscarded, exponent + (roundDiscarded.numberOfDecimalDigits() - divrem.getQuotient().numberOfDecimalDigits()), decimalMode, null);
        }

        public final BigDecimal fromByte(byte r8, DecimalMode decimalMode) {
            BigInteger fromByte = BigInteger.INSTANCE.fromByte(r8);
            return new BigDecimal(fromByte, fromByte.numberOfDecimalDigits() - 1, decimalMode, null).roundSignificand(decimalMode);
        }

        public final BigDecimal fromDouble(double r5, DecimalMode decimalMode) {
            String str;
            String valueOf = String.valueOf(r5);
            if (!StringsKt.contains$default((CharSequence) valueOf, '.', false, 2, (Object) null) || StringsKt.contains((CharSequence) valueOf, 'E', true)) {
                return parseStringWithMode(valueOf, decimalMode).roundSignificand(decimalMode).roundSignificand(decimalMode);
            }
            int lastIndex = StringsKt.getLastIndex(valueOf);
            while (true) {
                if (lastIndex < 0) {
                    str = BuildConfig.FLAVOR;
                    break;
                }
                if (valueOf.charAt(lastIndex) != '0') {
                    str = valueOf.substring(0, lastIndex + 1);
                    Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    break;
                }
                lastIndex--;
            }
            return parseStringWithMode(str, decimalMode).roundSignificand(decimalMode);
        }

        public final BigDecimal fromFloat(float r6, DecimalMode decimalMode) {
            String str;
            String valueOf = String.valueOf(r6);
            if (!StringsKt.contains$default((CharSequence) valueOf, '.', false, 2, (Object) null) || StringsKt.contains((CharSequence) valueOf, 'E', true)) {
                return parseStringWithMode(valueOf, decimalMode).roundSignificand(decimalMode);
            }
            int lastIndex = StringsKt.getLastIndex(valueOf);
            while (true) {
                if (lastIndex < 0) {
                    str = BuildConfig.FLAVOR;
                    break;
                }
                if (valueOf.charAt(lastIndex) != '0') {
                    str = valueOf.substring(0, lastIndex + 1);
                    Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    break;
                }
                lastIndex--;
            }
            return parseStringWithMode(str, decimalMode).roundSignificand(decimalMode);
        }

        public final BigDecimal fromLong(long r8, DecimalMode decimalMode) {
            BigInteger fromLong = BigInteger.INSTANCE.fromLong(r8);
            return new BigDecimal(fromLong, fromLong.numberOfDecimalDigits() - 1, decimalMode, null).roundSignificand(decimalMode);
        }

        public final BigDecimal fromShort(short r8, DecimalMode decimalMode) {
            BigInteger fromShort = BigInteger.INSTANCE.fromShort(r8);
            return new BigDecimal(fromShort, fromShort.numberOfDecimalDigits() - 1, decimalMode, null).roundSignificand(decimalMode);
        }

        public BigDecimal getZERO() {
            return BigDecimal.ZERO;
        }

        public final BigDecimal handleZeroRounding(BigInteger significand, long exponent, DecimalMode decimalMode) {
            BigDecimal bigDecimal;
            Intrinsics.checkNotNullParameter(significand, "significand");
            Intrinsics.checkNotNullParameter(decimalMode, "decimalMode");
            if (significand.getSign() == Sign.POSITIVE) {
                int i5 = WhenMappings.$EnumSwitchMapping$0[decimalMode.getRoundingMode().ordinal()];
                if (i5 != 1 && i5 != 3) {
                    return new BigDecimal(significand, exponent, decimalMode, null);
                }
                BigInteger inc = significand.inc();
                bigDecimal = new BigDecimal(inc, (inc.numberOfDecimalDigits() - significand.numberOfDecimalDigits()) + exponent, decimalMode, null);
            } else {
                if (significand.getSign() != Sign.NEGATIVE) {
                    return new BigDecimal(significand, exponent, decimalMode, null);
                }
                int i6 = WhenMappings.$EnumSwitchMapping$0[decimalMode.getRoundingMode().ordinal()];
                if (i6 != 1 && i6 != 4) {
                    return new BigDecimal(significand, exponent, decimalMode, null);
                }
                BigInteger dec = significand.dec();
                bigDecimal = new BigDecimal(dec, (dec.numberOfDecimalDigits() - significand.numberOfDecimalDigits()) + exponent, decimalMode, null);
            }
            return bigDecimal;
        }

        public final BigDecimal parseString(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return parseStringWithMode$default(this, string, null, 2, null);
        }

        public final BigDecimal parseStringWithMode(String floatingPointString, DecimalMode decimalMode) {
            int i5;
            int i6;
            String str;
            String str2;
            List split$default;
            long j5;
            long length;
            int i7 = 0;
            Intrinsics.checkNotNullParameter(floatingPointString, "floatingPointString");
            if (floatingPointString.length() == 0) {
                return getZERO();
            }
            if (!StringsKt.contains((CharSequence) floatingPointString, 'E', true)) {
                if (!StringsKt.contains$default((CharSequence) floatingPointString, '.', false, 2, (Object) null)) {
                    BigInteger parseString = BigInteger.INSTANCE.parseString(floatingPointString, 10);
                    return new BigDecimal(parseString, parseString.numberOfDecimalDigits() - 1, decimalMode, null);
                }
                List split$default2 = StringsKt.split$default((CharSequence) floatingPointString, new char[]{'.'}, false, 0, 6, (Object) null);
                if (split$default2.size() != 2) {
                    throw new ArithmeticException(Intrinsics.stringPlus("Invalid (or unsupported) floating point number format: ", floatingPointString));
                }
                int i8 = (floatingPointString.charAt(0) == '-' || floatingPointString.charAt(0) == '+') ? 1 : 0;
                Sign sign = i8 != 0 ? floatingPointString.charAt(0) == '-' ? Sign.NEGATIVE : Sign.POSITIVE : Sign.POSITIVE;
                String str3 = (String) split$default2.get(0);
                if (str3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String substring = str3.substring(i8);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                String str4 = (String) split$default2.get(1);
                int length2 = substring.length();
                int i9 = 0;
                while (true) {
                    if (i9 >= length2) {
                        i9 = -1;
                        break;
                    }
                    if (substring.charAt(i9) != '0') {
                        break;
                    }
                    i9++;
                }
                if (i9 == -1) {
                    i9 = 0;
                }
                int length3 = str4.length();
                while (true) {
                    length3--;
                    if (length3 < 0) {
                        length3 = -1;
                        break;
                    }
                    if (str4.charAt(length3) != '0') {
                        break;
                    }
                }
                if (length3 == -1) {
                    length3 = str4.length() - 1;
                }
                String substring2 = substring.substring(i9, substring.length());
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                int i10 = length3 + 1;
                if (str4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String substring3 = str4.substring(0, i10);
                Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                BigInteger parseString2 = BigInteger.INSTANCE.parseString(Intrinsics.stringPlus(substring2, substring3), 10);
                if (substring2.length() <= 0 || substring2.charAt(0) == '0') {
                    int length4 = substring3.length();
                    while (true) {
                        if (i7 >= length4) {
                            i7 = -1;
                            break;
                        }
                        if (substring3.charAt(i7) != '0') {
                            break;
                        }
                        i7++;
                    }
                    i5 = (i7 + 1) * (-1);
                } else {
                    i5 = substring2.length() - 1;
                }
                if (Intrinsics.areEqual(parseString2, BigInteger.INSTANCE.getZERO())) {
                    sign = Sign.ZERO;
                }
                if (sign == Sign.NEGATIVE) {
                    parseString2 = parseString2.negate();
                }
                return new BigDecimal(parseString2, i5, decimalMode, null);
            }
            if (StringsKt.contains$default((CharSequence) floatingPointString, '.', false, 2, (Object) null)) {
                i6 = 10;
                str = "null cannot be cast to non-null type java.lang.String";
                str2 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
                split$default = StringsKt.split$default((CharSequence) floatingPointString, new char[]{'.'}, false, 0, 6, (Object) null);
            } else {
                i6 = 10;
                str = "null cannot be cast to non-null type java.lang.String";
                str2 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
                List split$default3 = StringsKt.split$default((CharSequence) floatingPointString, new char[]{'E', 'e'}, false, 0, 6, (Object) null);
                split$default = CollectionsKt.listOf((Object[]) new String[]{(String) split$default3.get(0), Intrinsics.stringPlus("0E", split$default3.get(1))});
            }
            if (split$default.size() != 2) {
                throw new ArithmeticException(Intrinsics.stringPlus("Invalid (or unsupported) floating point number format: ", floatingPointString));
            }
            int i11 = (floatingPointString.charAt(0) == '-' || floatingPointString.charAt(0) == '+') ? 1 : 0;
            Sign sign2 = i11 != 0 ? floatingPointString.charAt(0) == '-' ? Sign.NEGATIVE : Sign.POSITIVE : Sign.POSITIVE;
            String str5 = (String) split$default.get(0);
            if (str5 == null) {
                throw new NullPointerException(str);
            }
            String substring4 = str5.substring(i11);
            Intrinsics.checkNotNullExpressionValue(substring4, "(this as java.lang.String).substring(startIndex)");
            List split$default4 = StringsKt.split$default((CharSequence) split$default.get(1), new char[]{'E', 'e'}, false, 0, 6, (Object) null);
            String str6 = (String) split$default4.get(0);
            String str7 = (String) split$default4.get(1);
            int i12 = (str7.charAt(0) == '-' || str7.charAt(0) == '+') ? 1 : 0;
            Sign sign3 = str7.charAt(0) == '-' ? Sign.NEGATIVE : Sign.POSITIVE;
            String substring5 = str7.substring(i12);
            Intrinsics.checkNotNullExpressionValue(substring5, "(this as java.lang.String).substring(startIndex)");
            long parseLong = sign3 == Sign.POSITIVE ? Long.parseLong(substring5, CharsKt.checkRadix(i6)) : Long.parseLong(substring5, CharsKt.checkRadix(i6)) * (-1);
            int length5 = substring4.length();
            int i13 = 0;
            while (true) {
                if (i13 >= length5) {
                    i13 = -1;
                    break;
                }
                if (substring4.charAt(i13) != '0') {
                    break;
                }
                i13++;
            }
            if (i13 == -1) {
                i13 = 0;
            }
            int length6 = str6.length();
            while (true) {
                length6--;
                if (length6 < 0) {
                    length6 = -1;
                    break;
                }
                if (str6.charAt(length6) != '0') {
                    break;
                }
            }
            if (length6 == -1) {
                length6 = str6.length() - 1;
            }
            String substring6 = substring4.substring(i13, substring4.length());
            String str8 = str2;
            Intrinsics.checkNotNullExpressionValue(substring6, str8);
            int i14 = length6 + 1;
            if (str6 == null) {
                throw new NullPointerException(str);
            }
            String substring7 = str6.substring(0, i14);
            Intrinsics.checkNotNullExpressionValue(substring7, str8);
            BigInteger.Companion companion = BigInteger.INSTANCE;
            BigInteger parseString3 = companion.parseString(Intrinsics.stringPlus(substring6, substring7), i6);
            if (Intrinsics.areEqual(parseString3, companion.getZERO())) {
                sign2 = Sign.ZERO;
            }
            if (sign2 == Sign.NEGATIVE) {
                parseString3 = parseString3.negate();
            }
            BigInteger bigInteger = parseString3;
            if (Intrinsics.areEqual(substring6, "0")) {
                j5 = 1;
                length = parseLong - (substring7.length() - bigInteger.numberOfDecimalDigits());
            } else {
                length = parseLong + substring6.length();
                j5 = 1;
            }
            return new BigDecimal(bigInteger, length - j5, decimalMode, null);
        }

        private Companion() {
        }

        public final BigDecimal fromInt(int r8, DecimalMode decimalMode) {
            BigInteger fromInt = BigInteger.INSTANCE.fromInt(r8);
            return new BigDecimal(fromInt, fromInt.numberOfDecimalDigits() - 1, decimalMode, null).roundSignificand(decimalMode);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.ionspin.kotlin.bignum.BigNumber.Creator
        public BigDecimal tryFromDouble(double r12, boolean exactRequired) {
            return fromDouble(r12, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.ionspin.kotlin.bignum.BigNumber.Creator
        public BigDecimal tryFromFloat(float r12, boolean exactRequired) {
            return fromFloat(r12, null);
        }

        public BigDecimal fromByte(byte r22) {
            return fromByte(r22, null);
        }

        public BigDecimal fromLong(long r22) {
            return fromLong(r22, null);
        }

        public BigDecimal fromShort(short r22) {
            return fromShort(r22, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.ionspin.kotlin.bignum.BigNumber.Creator
        public BigDecimal fromInt(int r22) {
            return fromInt(r22, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ionspin/kotlin/bignum/decimal/BigDecimal$ScaleOps;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "Max", "Min", "Add", "bignum"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public enum ScaleOps {
        Max,
        Min,
        Add
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScaleOps.values().length];
            iArr[ScaleOps.Max.ordinal()] = 1;
            iArr[ScaleOps.Min.ordinal()] = 2;
            iArr[ScaleOps.Add.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        BigInteger.Companion companion2 = BigInteger.INSTANCE;
        int i5 = 6;
        DefaultConstructorMarker defaultConstructorMarker = null;
        long j5 = 0;
        DecimalMode decimalMode = null;
        ZERO = new BigDecimal(companion2.getZERO(), j5, decimalMode, i5, defaultConstructorMarker);
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        DecimalMode decimalMode2 = null;
        ONE = new BigDecimal(companion2.getONE(), 0L, decimalMode2, 6, defaultConstructorMarker2);
        TWO = new BigDecimal(companion2.getTWO(), j5, decimalMode, i5, defaultConstructorMarker);
        TEN = new BigDecimal(companion2.getTEN(), 1L, decimalMode2, 4, defaultConstructorMarker2);
        double10pow = new double[]{1.0d, 10.0d, 100.0d, 1000.0d, 10000.0d, 100000.0d, 1000000.0d, 1.0E7d, 1.0E8d, 1.0E9d, 1.0E10d, 1.0E11d, 1.0E12d, 1.0E13d, 1.0E14d, 1.0E15d, 1.0E16d, 1.0E17d, 1.0E18d, 1.0E19d, 1.0E20d, 1.0E21d, 1.0E22d};
        maximumDouble = Companion.fromDouble$default(companion, Double.MAX_VALUE, null, 2, null);
        leastSignificantDouble = Companion.fromDouble$default(companion, Double.MIN_VALUE, null, 2, null);
        float10pow = new float[]{1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f};
        maximumFloat = Companion.fromFloat$default(companion, Float.MAX_VALUE, null, 2, null);
        leastSignificantFloat = Companion.fromFloat$default(companion, Float.MIN_VALUE, null, 2, null);
    }

    public /* synthetic */ BigDecimal(BigInteger bigInteger, long j5, DecimalMode decimalMode, DefaultConstructorMarker defaultConstructorMarker) {
        this(bigInteger, j5, decimalMode);
    }

    private final Triple<BigInteger, BigInteger, Long> bringSignificandToSameExponent(BigDecimal first, BigDecimal second) {
        BigDecimal ridOfRadix = getRidOfRadix(first);
        BigDecimal ridOfRadix2 = getRidOfRadix(second);
        long j5 = ridOfRadix.exponent;
        long j6 = ridOfRadix2.exponent;
        long j7 = first.exponent;
        long j8 = second.exponent;
        if (j7 > j8) {
            long j9 = j5 - j6;
            if (j9 >= 0) {
                return new Triple<>((BigInteger) ridOfRadix.significand.times((BigNumber) BigIntegerExtensionsKt.toBigInteger(10).pow(j9)), second.significand, Long.valueOf(j6));
            }
            return new Triple<>(first.significand, (BigInteger) ridOfRadix2.significand.times((BigNumber) BigIntegerExtensionsKt.toBigInteger(10).pow(j9 * (-1))), Long.valueOf(j5));
        }
        if (j7 < j8) {
            long j10 = j6 - j5;
            if (j10 < 0) {
                return new Triple<>((BigInteger) ridOfRadix.significand.times((BigNumber) BigIntegerExtensionsKt.toBigInteger(10).pow(j10 * (-1))), second.significand, Long.valueOf(j5));
            }
            return new Triple<>(first.significand, (BigInteger) ridOfRadix2.significand.times((BigNumber) BigIntegerExtensionsKt.toBigInteger(10).pow(j10)), Long.valueOf(j5));
        }
        if (j7 != j8) {
            throw new RuntimeException("Invalid comparison state BigInteger: " + first.exponent + ", " + second.exponent);
        }
        long j11 = j5 - j6;
        if (j11 > 0) {
            return new Triple<>((BigInteger) first.significand.times((BigNumber) BigIntegerExtensionsKt.toBigInteger(10).pow(j11)), second.significand, Long.valueOf(j5));
        }
        if (j11 < 0) {
            return new Triple<>(first.significand, (BigInteger) second.significand.times((BigNumber) BigIntegerExtensionsKt.toBigInteger(10).pow(j11 * (-1))), Long.valueOf(j5));
        }
        if (Intrinsics.compare(j11, 0L) == 0) {
            return new Triple<>(first.significand, second.significand, Long.valueOf(j5));
        }
        throw new RuntimeException(Intrinsics.stringPlus("Invalid delta: ", Long.valueOf(j11)));
    }

    private final DecimalMode computeMode(BigDecimal other, ScaleOps op) {
        DecimalMode decimalMode;
        long j5;
        long j6;
        DecimalMode decimalMode2 = this.decimalMode;
        if (decimalMode2 == null || decimalMode2.getIsPrecisionUnlimited() || (decimalMode = other.decimalMode) == null || decimalMode.getIsPrecisionUnlimited()) {
            return DecimalMode.INSTANCE.getDEFAULT();
        }
        long max = Math.max(this.decimalMode.getDecimalPrecision(), other.decimalMode.getDecimalPrecision());
        RoundingMode roundingMode = this.decimalMode.getRoundingMode();
        if (this.decimalMode.getUsingScale() && other.decimalMode.getUsingScale()) {
            int i5 = WhenMappings.$EnumSwitchMapping$0[op.ordinal()];
            if (i5 == 1) {
                j5 = Math.max(this.decimalMode.getScale(), other.decimalMode.getScale());
            } else {
                if (i5 != 2) {
                    if (i5 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    j6 = this.decimalMode.getScale() + other.decimalMode.getScale();
                    return new DecimalMode(max, roundingMode, j6);
                }
                j5 = Math.min(this.decimalMode.getScale(), other.decimalMode.getScale());
            }
        } else {
            j5 = -1;
        }
        j6 = j5;
        return new DecimalMode(max, roundingMode, j6);
    }

    public static /* synthetic */ BigDecimal copy$default(BigDecimal bigDecimal, BigInteger bigInteger, long j5, DecimalMode decimalMode, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            bigInteger = bigDecimal.significand;
        }
        if ((i5 & 2) != 0) {
            j5 = bigDecimal.exponent;
        }
        if ((i5 & 4) != 0) {
            decimalMode = bigDecimal.decimalMode;
        }
        return bigDecimal.copy(bigInteger, j5, decimalMode);
    }

    private final BigDecimal getRidOfRadix(BigDecimal bigDecimal) {
        return new BigDecimal(bigDecimal.significand, (bigDecimal.exponent - bigDecimal.significand.numberOfDecimalDigits()) + 1, null, 4, null);
    }

    private final int javascriptNumberComparison(Number number) {
        return number.floatValue() % ((float) 1) == 0.0f ? compare(INSTANCE.fromLong(number.longValue())) : compare(BigDecimalExtensionsKt.toBigDecimal$default(number.floatValue(), null, null, 3, null));
    }

    private final String placeADotInString(String input, int position) {
        String str = StringsKt.substring(input, RangesKt.until(0, input.length() - position)) + '.' + StringsKt.substring(input, RangesKt.until(input.length() - position, input.length()));
        for (int lastIndex = StringsKt.getLastIndex(str); lastIndex >= 0; lastIndex--) {
            if (str.charAt(lastIndex) != '0') {
                String substring = str.substring(0, lastIndex + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return BuildConfig.FLAVOR;
    }

    private final String placeADotInStringExpanded(String input, int position) {
        String str;
        String substring = StringsKt.substring(input, RangesKt.until(0, input.length() - position));
        String substring2 = StringsKt.substring(input, RangesKt.until(input.length() - position, input.length()));
        int lastIndex = StringsKt.getLastIndex(substring2);
        while (true) {
            if (lastIndex < 0) {
                str = BuildConfig.FLAVOR;
                break;
            }
            if (substring2.charAt(lastIndex) != '0') {
                str = substring2.substring(0, lastIndex + 1);
                Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                break;
            }
            lastIndex--;
        }
        if (str.length() <= 0) {
            return substring;
        }
        return substring + '.' + str;
    }

    private final BigDecimal removeTrailingZeroes(BigDecimal bigDecimal) {
        if (Intrinsics.areEqual(bigDecimal, ZERO)) {
            return this;
        }
        BigInteger bigInteger = bigDecimal.significand;
        BigInteger.QuotientAndRemainder quotientAndRemainder = new BigInteger.QuotientAndRemainder(bigInteger, BigInteger.INSTANCE.getZERO());
        while (true) {
            BigInteger quotient = quotientAndRemainder.getQuotient();
            BigInteger.Companion companion = BigInteger.INSTANCE;
            quotientAndRemainder = quotient.divrem(companion.getTEN());
            if (Intrinsics.areEqual(quotientAndRemainder.getRemainder(), companion.getZERO())) {
                bigInteger = quotientAndRemainder.getQuotient();
            }
            BigInteger bigInteger2 = bigInteger;
            if (!Intrinsics.areEqual(quotientAndRemainder.getRemainder(), companion.getZERO())) {
                return new BigDecimal(bigInteger2, bigDecimal.exponent, null, 4, null);
            }
            bigInteger = bigInteger2;
        }
    }

    public final int compare(BigDecimal other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.exponent == other.exponent && this.precision == other.precision) {
            return this.significand.compare(other.significand);
        }
        Triple<BigInteger, BigInteger, Long> bringSignificandToSameExponent = bringSignificandToSameExponent(this, other);
        return bringSignificandToSameExponent.component1().compare(bringSignificandToSameExponent.component2());
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
        if (other instanceof BigDecimal) {
            return compare((BigDecimal) other);
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
        if (other instanceof Double) {
            return compare(Companion.fromDouble$default(INSTANCE, ((Number) other).doubleValue(), null, 2, null));
        }
        if (other instanceof Float) {
            return compare(Companion.fromFloat$default(INSTANCE, ((Number) other).floatValue(), null, 2, null));
        }
        throw new RuntimeException(Intrinsics.stringPlus("Invalid comparison type for BigDecimal: ", Reflection.getOrCreateKotlinClass(other.getClass()).getSimpleName()));
    }

    public final BigDecimal copy(BigInteger significand, long exponent, DecimalMode decimalMode) {
        Intrinsics.checkNotNullParameter(significand, "significand");
        return new BigDecimal(significand, exponent, decimalMode);
    }

    public Pair<BigDecimal, BigDecimal> divideAndRemainder(BigDecimal other) {
        Intrinsics.checkNotNullParameter(other, "other");
        DecimalMode decimalMode = this.decimalMode;
        if (decimalMode == null) {
            decimalMode = new DecimalMode(this.exponent + 1, RoundingMode.FLOOR, 0L, 4, null);
        }
        BigDecimal divide = divide(other, decimalMode);
        return new Pair<>(divide, minus(copy$default(divide, null, 0L, DecimalMode.INSTANCE.getDEFAULT(), 3, null).times(other)));
    }

    public boolean equals(Object other) {
        return (other instanceof BigDecimal ? compare((BigDecimal) other) : other instanceof Long ? compare(INSTANCE.fromLong(((Number) other).longValue())) : other instanceof Integer ? compare(INSTANCE.fromInt(((Number) other).intValue())) : other instanceof Short ? compare(INSTANCE.fromShort(((Number) other).shortValue())) : other instanceof Byte ? compare(INSTANCE.fromByte(((Number) other).byteValue())) : other instanceof Double ? compare(Companion.fromDouble$default(INSTANCE, ((Number) other).doubleValue(), null, 2, null)) : other instanceof Float ? compare(Companion.fromFloat$default(INSTANCE, ((Number) other).floatValue(), null, 2, null)) : -1) == 0;
    }

    public final BigDecimal floor() {
        return roundSignificand(new DecimalMode(this.exponent + 1, RoundingMode.FLOOR, 0L, 4, null));
    }

    @Override // com.ionspin.kotlin.bignum.CommonBigNumberOperations
    public BigNumber.Creator<BigDecimal> getCreator() {
        return INSTANCE;
    }

    public final long getExponent() {
        return this.exponent;
    }

    @Override // com.ionspin.kotlin.bignum.CommonBigNumberOperations
    public BigDecimal getInstance() {
        return this;
    }

    public final BigInteger getSignificand() {
        return this.significand;
    }

    public int hashCode() {
        if (Intrinsics.areEqual(this, ZERO)) {
            return 0;
        }
        return removeTrailingZeroes(this).significand.hashCode() + Long.hashCode(this.exponent);
    }

    public boolean isZero() {
        return this.significand.isZero();
    }

    public final BigDecimal moveDecimalPoint(long places) {
        return places == 0 ? this : copy$default(this, null, this.exponent + places, null, 5, null);
    }

    public final BigDecimal roundSignificand(DecimalMode decimalMode) {
        return decimalMode == null ? this : INSTANCE.roundSignificand(this.significand, this.exponent, decimalMode);
    }

    @Override // com.ionspin.kotlin.bignum.BigNumber
    public int signum() {
        return this.significand.signum();
    }

    public BigDecimal times(BigDecimal other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return multiply(other, computeMode(other, ScaleOps.Max));
    }

    public final BigInteger toBigInteger() {
        long j5 = this.exponent;
        if (j5 < 0) {
            return BigInteger.INSTANCE.getZERO();
        }
        long j6 = j5 - this.precision;
        return j6 > 0 ? (BigInteger) this.significand.times((BigNumber) BigIntegerExtensionsKt.toBigInteger(10).pow(j6 + 1)) : j6 < 0 ? (BigInteger) this.significand.div((BigNumber) BigIntegerExtensionsKt.toBigInteger(10).pow(Math.abs(j6) - 1)) : this.significand;
    }

    public String toString() {
        String str;
        String str2;
        if (useToStringExpanded) {
            return toStringExpanded();
        }
        String bigInteger = this.significand.toString(10);
        int i5 = this.significand.compareTo(0) < 0 ? 2 : 1;
        String bigInteger2 = this.significand.toString();
        int lastIndex = StringsKt.getLastIndex(bigInteger2);
        while (true) {
            str = BuildConfig.FLAVOR;
            if (lastIndex < 0) {
                str2 = BuildConfig.FLAVOR;
                break;
            }
            if (bigInteger2.charAt(lastIndex) != '0') {
                str2 = bigInteger2.substring(0, lastIndex + 1);
                Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                break;
            }
            lastIndex--;
        }
        if (str2.length() <= 1) {
            str = "0";
        }
        long j5 = this.exponent;
        if (j5 > 0) {
            return placeADotInString(bigInteger, bigInteger.length() - i5) + str + "E+" + this.exponent;
        }
        if (j5 >= 0) {
            if (j5 == 0) {
                return Intrinsics.stringPlus(placeADotInString(bigInteger, bigInteger.length() - i5), str);
            }
            throw new RuntimeException("Invalid state, please report a bug (Integer compareTo invalid)");
        }
        return placeADotInString(bigInteger, bigInteger.length() - i5) + str + 'E' + this.exponent;
    }

    public final String toStringExpanded() {
        String placeADotInStringExpanded;
        if (Intrinsics.areEqual(this, ZERO)) {
            return "0";
        }
        long numberOfDecimalDigits = this.significand.numberOfDecimalDigits();
        if (this.exponent > 2147483647L) {
            throw new RuntimeException("Invalid toStringExpanded request (exponent > Int.MAX_VALUE)");
        }
        String stringWithoutSign$bignum = this.significand.toStringWithoutSign$bignum(10);
        String str = this.significand.getSign() == Sign.NEGATIVE ? "-" : BuildConfig.FLAVOR;
        long j5 = this.exponent;
        if (j5 > 0) {
            long j6 = (j5 - numberOfDecimalDigits) + 1;
            placeADotInStringExpanded = j6 > 0 ? Intrinsics.stringPlus(stringWithoutSign$bignum, times(j6, '0')) : placeADotInStringExpanded(stringWithoutSign$bignum, (stringWithoutSign$bignum.length() - ((int) this.exponent)) - 1);
        } else if (j5 < 0) {
            placeADotInStringExpanded = Math.abs((int) j5) > 0 ? placeADotInStringExpanded(Intrinsics.stringPlus(times(Math.abs(this.exponent), '0'), stringWithoutSign$bignum), (r0 + stringWithoutSign$bignum.length()) - 1) : placeADotInStringExpanded(stringWithoutSign$bignum, stringWithoutSign$bignum.length() - 1);
        } else {
            if (j5 != 0) {
                throw new RuntimeException("Invalid state, please report a bug (Integer compareTo invalid)");
            }
            if (numberOfDecimalDigits == 1) {
                return Intrinsics.stringPlus(str, stringWithoutSign$bignum);
            }
            placeADotInStringExpanded = placeADotInStringExpanded(stringWithoutSign$bignum, stringWithoutSign$bignum.length() - 1);
        }
        return Intrinsics.stringPlus(str, placeADotInStringExpanded);
    }

    private BigDecimal(BigInteger bigInteger, long j5, DecimalMode decimalMode) {
        if (decimalMode != null && decimalMode.getUsingScale()) {
            BigDecimal applyScale = INSTANCE.applyScale(bigInteger, j5, decimalMode);
            if (!applyScale.isZero()) {
                BigInteger bigInteger2 = applyScale.significand;
                this.significand = bigInteger2;
                this.exponent = applyScale.exponent;
                long numberOfDecimalDigits = bigInteger2.numberOfDecimalDigits();
                this.precision = numberOfDecimalDigits;
                this.decimalMode = DecimalMode.copy$default(decimalMode, numberOfDecimalDigits, null, 0L, 6, null);
            } else {
                this.significand = applyScale.significand;
                this.exponent = applyScale.exponent * (decimalMode.getDecimalPrecision() + decimalMode.getScale());
                long decimalPrecision = decimalMode.getDecimalPrecision() + decimalMode.getScale();
                this.precision = decimalPrecision;
                this.decimalMode = DecimalMode.copy$default(decimalMode, decimalPrecision, null, 0L, 6, null);
            }
        } else {
            this.significand = bigInteger;
            this.precision = bigInteger.numberOfDecimalDigits();
            this.exponent = j5;
            this.decimalMode = decimalMode;
        }
        DecimalMode decimalMode2 = this.decimalMode;
        this.precisionLimit = decimalMode2 == null ? 0L : decimalMode2.getDecimalPrecision();
        DecimalMode decimalMode3 = this.decimalMode;
        RoundingMode roundingMode = decimalMode3 == null ? null : decimalMode3.getRoundingMode();
        this.roundingMode = roundingMode == null ? RoundingMode.NONE : roundingMode;
        DecimalMode decimalMode4 = this.decimalMode;
        long scale = decimalMode4 == null ? -1L : decimalMode4.getScale();
        this.scale = scale;
        this.usingScale = scale >= 0;
    }

    @Override // com.ionspin.kotlin.bignum.BigNumber
    public BigDecimal add(BigDecimal other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return add(other, computeMode(other, ScaleOps.Max));
    }

    @Override // com.ionspin.kotlin.bignum.BigNumber
    public BigDecimal divide(BigDecimal other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return divide(other, computeMode(other, ScaleOps.Max));
    }

    public BigDecimal minus(int i5) {
        return (BigDecimal) CommonBigNumberOperations.DefaultImpls.minus(this, i5);
    }

    @Override // com.ionspin.kotlin.bignum.BigNumber
    public BigDecimal multiply(BigDecimal other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return multiply(other, computeMode(other, ScaleOps.Max));
    }

    public BigDecimal plus(int i5) {
        return (BigDecimal) CommonBigNumberOperations.DefaultImpls.plus(this, i5);
    }

    @Override // com.ionspin.kotlin.bignum.BigNumber
    public BigDecimal remainder(BigDecimal other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return divideAndRemainder(other).getSecond();
    }

    @Override // com.ionspin.kotlin.bignum.BigNumber
    public BigDecimal subtract(BigDecimal other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return subtract(other, computeMode(other, ScaleOps.Max));
    }

    public final String times(long j5, char c5) {
        if (j5 >= 0) {
            StringBuilder sb = new StringBuilder();
            while (j5 > 0) {
                sb.append(c5);
                j5--;
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
            return sb2;
        }
        throw new RuntimeException("Char cannot be multiplied with negative number");
    }

    public final BigDecimal add(BigDecimal other, DecimalMode decimalMode) {
        Intrinsics.checkNotNullParameter(other, "other");
        Companion companion = INSTANCE;
        DecimalMode resolveDecimalMode = companion.resolveDecimalMode(this.decimalMode, other.decimalMode, decimalMode);
        BigDecimal bigDecimal = ZERO;
        if (Intrinsics.areEqual(this, bigDecimal)) {
            return companion.roundOrDont(other.significand, other.exponent, resolveDecimalMode);
        }
        if (Intrinsics.areEqual(other, bigDecimal)) {
            return companion.roundOrDont(this.significand, this.exponent, resolveDecimalMode);
        }
        Triple<BigInteger, BigInteger, Long> bringSignificandToSameExponent = bringSignificandToSameExponent(this, other);
        BigInteger component1 = bringSignificandToSameExponent.component1();
        BigInteger component2 = bringSignificandToSameExponent.component2();
        long numberOfDecimalDigits = component1.numberOfDecimalDigits();
        long numberOfDecimalDigits2 = component2.numberOfDecimalDigits();
        BigInteger bigInteger = (BigInteger) component1.plus((BigNumber) component2);
        long numberOfDecimalDigits3 = bigInteger.numberOfDecimalDigits();
        if (numberOfDecimalDigits <= numberOfDecimalDigits2) {
            numberOfDecimalDigits = numberOfDecimalDigits2;
        }
        long max = Math.max(this.exponent, other.exponent) + (numberOfDecimalDigits3 - numberOfDecimalDigits);
        if (resolveDecimalMode.getUsingScale()) {
            return companion.roundOrDont(bigInteger, max, DecimalMode.copy$default(resolveDecimalMode, numberOfDecimalDigits3, null, 0L, 6, null));
        }
        return companion.roundOrDont(bigInteger, max, resolveDecimalMode);
    }

    public final BigDecimal divide(BigDecimal other, DecimalMode decimalMode) {
        BigInteger bigInteger;
        Intrinsics.checkNotNullParameter(other, "other");
        Companion companion = INSTANCE;
        DecimalMode resolveDecimalMode = companion.resolveDecimalMode(this.decimalMode, other.decimalMode, decimalMode);
        if (resolveDecimalMode.getIsPrecisionUnlimited()) {
            long j5 = this.exponent - other.exponent;
            long j6 = (other.precision * 2) + 6;
            BigInteger bigInteger2 = this.significand;
            BigInteger.Companion companion2 = BigInteger.INSTANCE;
            BigInteger bigInteger3 = (BigInteger) bigInteger2.times((BigNumber) companion2.getTEN().pow(j6));
            BigInteger.QuotientAndRemainder divrem = bigInteger3.divrem(other.significand);
            BigInteger quotient = divrem.getQuotient();
            long numberOfDecimalDigits = (other.precision - 1) + (quotient.numberOfDecimalDigits() - bigInteger3.numberOfDecimalDigits());
            if (Intrinsics.areEqual(divrem.getRemainder(), companion2.getZERO())) {
                return new BigDecimal(quotient, j5 + numberOfDecimalDigits, resolveDecimalMode);
            }
            throw new ArithmeticException("Non-terminating result of division operation (i.e. 1/3 = 0.3333... library needs to know when to stop and how to round up at that point). Specify decimalPrecision inside your decimal mode.");
        }
        long j7 = this.exponent - other.exponent;
        long j8 = j7 - 1;
        long decimalPrecision = (resolveDecimalMode.getDecimalPrecision() - this.precision) + other.precision;
        if (decimalPrecision > 0) {
            bigInteger = (BigInteger) this.significand.times((BigNumber) BigIntegerExtensionsKt.toBigInteger(10).pow(decimalPrecision));
        } else if (decimalPrecision < 0) {
            bigInteger = (BigInteger) this.significand.div((BigNumber) BigIntegerExtensionsKt.toBigInteger(10).pow(Math.abs(decimalPrecision)));
        } else {
            bigInteger = this.significand;
        }
        BigInteger.QuotientAndRemainder divrem2 = bigInteger.divrem(other.significand);
        BigInteger quotient2 = divrem2.getQuotient();
        if (Intrinsics.areEqual(quotient2, BigInteger.INSTANCE.getZERO())) {
            j8 = j7 - 2;
        }
        long numberOfDecimalDigits2 = quotient2.numberOfDecimalDigits() - resolveDecimalMode.getDecimalPrecision();
        if (this.usingScale) {
            return new BigDecimal(companion.roundDiscarded(quotient2, divrem2.getRemainder(), resolveDecimalMode), j8 + numberOfDecimalDigits2, DecimalMode.copy$default(resolveDecimalMode, quotient2.numberOfDecimalDigits(), null, 0L, 6, null));
        }
        return new BigDecimal(companion.roundDiscarded(quotient2, divrem2.getRemainder(), resolveDecimalMode), j8 + numberOfDecimalDigits2, resolveDecimalMode);
    }

    public BigDecimal minus(BigDecimal other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return subtract(other, computeMode(other, ScaleOps.Max));
    }

    public final BigDecimal multiply(BigDecimal other, DecimalMode decimalMode) {
        Intrinsics.checkNotNullParameter(other, "other");
        Companion companion = INSTANCE;
        DecimalMode resolveDecimalMode = companion.resolveDecimalMode(this.decimalMode, other.decimalMode, decimalMode);
        long numberOfDecimalDigits = this.significand.numberOfDecimalDigits();
        long numberOfDecimalDigits2 = other.significand.numberOfDecimalDigits();
        BigInteger bigInteger = (BigInteger) this.significand.times((BigNumber) other.significand);
        long numberOfDecimalDigits3 = bigInteger.numberOfDecimalDigits();
        long j5 = 1 + this.exponent + other.exponent + (numberOfDecimalDigits3 - (numberOfDecimalDigits + numberOfDecimalDigits2));
        if (resolveDecimalMode.getUsingScale()) {
            return companion.roundOrDont(bigInteger, j5, DecimalMode.copy$default(resolveDecimalMode, numberOfDecimalDigits3, null, 0L, 6, null));
        }
        return companion.roundOrDont(bigInteger, j5, resolveDecimalMode);
    }

    public final BigDecimal subtract(BigDecimal other, DecimalMode decimalMode) {
        Intrinsics.checkNotNullParameter(other, "other");
        Companion companion = INSTANCE;
        DecimalMode resolveDecimalMode = companion.resolveDecimalMode(this.decimalMode, other.decimalMode, decimalMode);
        BigDecimal bigDecimal = ZERO;
        if (Intrinsics.areEqual(this, bigDecimal)) {
            return companion.roundOrDont(other.significand.negate(), other.exponent, resolveDecimalMode);
        }
        if (Intrinsics.areEqual(other, bigDecimal)) {
            return companion.roundOrDont(this.significand, this.exponent, resolveDecimalMode);
        }
        Triple<BigInteger, BigInteger, Long> bringSignificandToSameExponent = bringSignificandToSameExponent(this, other);
        BigInteger component1 = bringSignificandToSameExponent.component1();
        BigInteger component2 = bringSignificandToSameExponent.component2();
        long numberOfDecimalDigits = component1.numberOfDecimalDigits();
        long numberOfDecimalDigits2 = component2.numberOfDecimalDigits();
        BigInteger bigInteger = (BigInteger) component1.minus((BigNumber) component2);
        long numberOfDecimalDigits3 = bigInteger.numberOfDecimalDigits();
        if (numberOfDecimalDigits <= numberOfDecimalDigits2) {
            numberOfDecimalDigits = numberOfDecimalDigits2;
        }
        long max = Math.max(this.exponent, other.exponent) + (numberOfDecimalDigits3 - numberOfDecimalDigits);
        if (this.usingScale) {
            return companion.roundOrDont(bigInteger, max, DecimalMode.copy$default(resolveDecimalMode, numberOfDecimalDigits3, null, 0L, 6, null));
        }
        return companion.roundOrDont(bigInteger, max, resolveDecimalMode);
    }

    /* synthetic */ BigDecimal(BigInteger bigInteger, long j5, DecimalMode decimalMode, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(bigInteger, (i5 & 2) != 0 ? 0L : j5, (i5 & 4) != 0 ? null : decimalMode);
    }
}
