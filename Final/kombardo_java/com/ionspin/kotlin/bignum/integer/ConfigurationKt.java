package com.ionspin.kotlin.bignum.integer;

import com.ionspin.kotlin.bignum.integer.base63.array.BigInteger63Arithmetic;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\" \u0010\u0001\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0001\u0010\u0002\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004*\n\u0010\b\"\u00020\u00072\u00020\u0007*\n\u0010\n\"\u00020\t2\u00020\t¨\u0006\u000b"}, d2 = {"Lcom/ionspin/kotlin/bignum/integer/BigIntegerArithmetic;", "chosenArithmetic", "Lcom/ionspin/kotlin/bignum/integer/BigIntegerArithmetic;", "getChosenArithmetic", "()Lcom/ionspin/kotlin/bignum/integer/BigIntegerArithmetic;", "getChosenArithmetic$annotations", "()V", "Lkotlin/ULong;", "Word", "Lkotlin/ULongArray;", "WordArray", "bignum"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ConfigurationKt {
    private static final BigIntegerArithmetic chosenArithmetic = BigInteger63Arithmetic.INSTANCE;

    public static final BigIntegerArithmetic getChosenArithmetic() {
        return chosenArithmetic;
    }
}
