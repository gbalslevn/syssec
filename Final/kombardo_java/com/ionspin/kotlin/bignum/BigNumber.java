package com.ionspin.kotlin.bignum;

import com.ionspin.kotlin.bignum.BigNumber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002:\u0001\rJ\u0017\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\b\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\t\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/ionspin/kotlin/bignum/BigNumber;", "BigType", BuildConfig.FLAVOR, "other", "add", "(Lcom/ionspin/kotlin/bignum/BigNumber;)Lcom/ionspin/kotlin/bignum/BigNumber;", "subtract", "multiply", "divide", "remainder", BuildConfig.FLAVOR, "signum", "()I", "Creator", "bignum"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public interface BigNumber<BigType extends BigNumber<BigType>> {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00028\u00012\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/ionspin/kotlin/bignum/BigNumber$Creator;", "BigType", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "int", "fromInt", "(I)Ljava/lang/Object;", BuildConfig.FLAVOR, "float", BuildConfig.FLAVOR, "exactRequired", "tryFromFloat", "(FZ)Ljava/lang/Object;", BuildConfig.FLAVOR, "double", "tryFromDouble", "(DZ)Ljava/lang/Object;", "bignum"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public interface Creator<BigType> {

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class DefaultImpls {
            public static /* synthetic */ Object tryFromDouble$default(Creator creator, double d5, boolean z5, int i5, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryFromDouble");
                }
                if ((i5 & 2) != 0) {
                    z5 = false;
                }
                return creator.tryFromDouble(d5, z5);
            }

            public static /* synthetic */ Object tryFromFloat$default(Creator creator, float f5, boolean z5, int i5, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryFromFloat");
                }
                if ((i5 & 2) != 0) {
                    z5 = false;
                }
                return creator.tryFromFloat(f5, z5);
            }
        }

        BigType fromInt(int r12);

        BigType tryFromDouble(double r12, boolean exactRequired);

        BigType tryFromFloat(float r12, boolean exactRequired);
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static <BigType extends BigNumber<BigType>> boolean isNegative(BigNumber<BigType> bigNumber) {
            Intrinsics.checkNotNullParameter(bigNumber, "this");
            return bigNumber.signum() < 0;
        }
    }

    BigType add(BigType other);

    BigType divide(BigType other);

    BigType multiply(BigType other);

    BigType remainder(BigType other);

    int signum();

    BigType subtract(BigType other);
}
