package com.ionspin.kotlin.bignum;

import com.ionspin.kotlin.bignum.BigNumber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ionspin/kotlin/bignum/CommonBigNumberOperations;", "Lcom/ionspin/kotlin/bignum/BigNumber;", "BigType", BuildConfig.FLAVOR, "Lcom/ionspin/kotlin/bignum/BigNumber$Creator;", "getCreator", "()Lcom/ionspin/kotlin/bignum/BigNumber$Creator;", "getInstance", "()Lcom/ionspin/kotlin/bignum/BigNumber;", "bignum"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public interface CommonBigNumberOperations<BigType extends BigNumber<BigType>> {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static <BigType extends BigNumber<BigType>> BigType div(CommonBigNumberOperations<BigType> commonBigNumberOperations, BigType other) {
            Intrinsics.checkNotNullParameter(commonBigNumberOperations, "this");
            Intrinsics.checkNotNullParameter(other, "other");
            return (BigType) commonBigNumberOperations.getInstance().divide(other);
        }

        public static <BigType extends BigNumber<BigType>> BigType minus(CommonBigNumberOperations<BigType> commonBigNumberOperations, BigType other) {
            Intrinsics.checkNotNullParameter(commonBigNumberOperations, "this");
            Intrinsics.checkNotNullParameter(other, "other");
            return (BigType) commonBigNumberOperations.getInstance().subtract(other);
        }

        public static <BigType extends BigNumber<BigType>> BigType plus(CommonBigNumberOperations<BigType> commonBigNumberOperations, BigType other) {
            Intrinsics.checkNotNullParameter(commonBigNumberOperations, "this");
            Intrinsics.checkNotNullParameter(other, "other");
            return (BigType) commonBigNumberOperations.getInstance().add(other);
        }

        public static <BigType extends BigNumber<BigType>> BigType rem(CommonBigNumberOperations<BigType> commonBigNumberOperations, BigType other) {
            Intrinsics.checkNotNullParameter(commonBigNumberOperations, "this");
            Intrinsics.checkNotNullParameter(other, "other");
            return (BigType) commonBigNumberOperations.getInstance().remainder(other);
        }

        public static <BigType extends BigNumber<BigType>> BigType times(CommonBigNumberOperations<BigType> commonBigNumberOperations, BigType other) {
            Intrinsics.checkNotNullParameter(commonBigNumberOperations, "this");
            Intrinsics.checkNotNullParameter(other, "other");
            return (BigType) commonBigNumberOperations.getInstance().multiply(other);
        }

        public static <BigType extends BigNumber<BigType>> BigType div(CommonBigNumberOperations<BigType> commonBigNumberOperations, int i5) {
            Intrinsics.checkNotNullParameter(commonBigNumberOperations, "this");
            return (BigType) commonBigNumberOperations.getInstance().divide(commonBigNumberOperations.getCreator().fromInt(i5));
        }

        public static <BigType extends BigNumber<BigType>> BigType minus(CommonBigNumberOperations<BigType> commonBigNumberOperations, int i5) {
            Intrinsics.checkNotNullParameter(commonBigNumberOperations, "this");
            return (BigType) commonBigNumberOperations.getInstance().subtract(commonBigNumberOperations.getCreator().fromInt(i5));
        }

        public static <BigType extends BigNumber<BigType>> BigType plus(CommonBigNumberOperations<BigType> commonBigNumberOperations, int i5) {
            Intrinsics.checkNotNullParameter(commonBigNumberOperations, "this");
            return (BigType) commonBigNumberOperations.getInstance().add(commonBigNumberOperations.getCreator().fromInt(i5));
        }

        public static <BigType extends BigNumber<BigType>> BigType rem(CommonBigNumberOperations<BigType> commonBigNumberOperations, int i5) {
            Intrinsics.checkNotNullParameter(commonBigNumberOperations, "this");
            return (BigType) commonBigNumberOperations.getInstance().remainder(commonBigNumberOperations.getCreator().fromInt(i5));
        }
    }

    BigNumber.Creator<BigType> getCreator();

    BigType getInstance();
}
