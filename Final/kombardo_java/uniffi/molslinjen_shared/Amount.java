package uniffi.molslinjen_shared;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Luniffi/molslinjen_shared/Amount;", BuildConfig.FLAVOR, "()V", "Charge", "Companion", "Mixed", "Monetary", "Luniffi/molslinjen_shared/Amount$Charge;", "Luniffi/molslinjen_shared/Amount$Mixed;", "Luniffi/molslinjen_shared/Amount$Monetary;", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class Amount {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Luniffi/molslinjen_shared/Amount$Charge;", "Luniffi/molslinjen_shared/Amount;", "count", BuildConfig.FLAVOR, "(J)V", "getCount", "()J", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* data */ class Charge extends Amount {
        private final long count;

        public Charge(long j5) {
            super(null);
            this.count = j5;
        }

        public static /* synthetic */ Charge copy$default(Charge charge, long j5, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                j5 = charge.count;
            }
            return charge.copy(j5);
        }

        /* renamed from: component1, reason: from getter */
        public final long getCount() {
            return this.count;
        }

        public final Charge copy(long count) {
            return new Charge(count);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Charge) && this.count == ((Charge) other).count;
        }

        public final long getCount() {
            return this.count;
        }

        public int hashCode() {
            return Long.hashCode(this.count);
        }

        public String toString() {
            return "Charge(count=" + this.count + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Luniffi/molslinjen_shared/Amount$Companion;", BuildConfig.FLAVOR, "()V", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Luniffi/molslinjen_shared/Amount$Mixed;", "Luniffi/molslinjen_shared/Amount;", "chargeCount", BuildConfig.FLAVOR, "monetaryAmount", "currency", "Luniffi/molslinjen_shared/Currency;", "(JJLuniffi/molslinjen_shared/Currency;)V", "getChargeCount", "()J", "getCurrency", "()Luniffi/molslinjen_shared/Currency;", "getMonetaryAmount", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* data */ class Mixed extends Amount {
        private final long chargeCount;
        private final Currency currency;
        private final long monetaryAmount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Mixed(long j5, long j6, Currency currency) {
            super(null);
            Intrinsics.checkNotNullParameter(currency, "currency");
            this.chargeCount = j5;
            this.monetaryAmount = j6;
            this.currency = currency;
        }

        public static /* synthetic */ Mixed copy$default(Mixed mixed, long j5, long j6, Currency currency, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                j5 = mixed.chargeCount;
            }
            long j7 = j5;
            if ((i5 & 2) != 0) {
                j6 = mixed.monetaryAmount;
            }
            long j8 = j6;
            if ((i5 & 4) != 0) {
                currency = mixed.currency;
            }
            return mixed.copy(j7, j8, currency);
        }

        /* renamed from: component1, reason: from getter */
        public final long getChargeCount() {
            return this.chargeCount;
        }

        /* renamed from: component2, reason: from getter */
        public final long getMonetaryAmount() {
            return this.monetaryAmount;
        }

        /* renamed from: component3, reason: from getter */
        public final Currency getCurrency() {
            return this.currency;
        }

        public final Mixed copy(long chargeCount, long monetaryAmount, Currency currency) {
            Intrinsics.checkNotNullParameter(currency, "currency");
            return new Mixed(chargeCount, monetaryAmount, currency);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Mixed)) {
                return false;
            }
            Mixed mixed = (Mixed) other;
            return this.chargeCount == mixed.chargeCount && this.monetaryAmount == mixed.monetaryAmount && this.currency == mixed.currency;
        }

        public final long getChargeCount() {
            return this.chargeCount;
        }

        public final Currency getCurrency() {
            return this.currency;
        }

        public final long getMonetaryAmount() {
            return this.monetaryAmount;
        }

        public int hashCode() {
            return (((Long.hashCode(this.chargeCount) * 31) + Long.hashCode(this.monetaryAmount)) * 31) + this.currency.hashCode();
        }

        public String toString() {
            return "Mixed(chargeCount=" + this.chargeCount + ", monetaryAmount=" + this.monetaryAmount + ", currency=" + this.currency + ")";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Luniffi/molslinjen_shared/Amount$Monetary;", "Luniffi/molslinjen_shared/Amount;", "amount", BuildConfig.FLAVOR, "currency", "Luniffi/molslinjen_shared/Currency;", "(JLuniffi/molslinjen_shared/Currency;)V", "getAmount", "()J", "getCurrency", "()Luniffi/molslinjen_shared/Currency;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* data */ class Monetary extends Amount {
        private final long amount;
        private final Currency currency;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Monetary(long j5, Currency currency) {
            super(null);
            Intrinsics.checkNotNullParameter(currency, "currency");
            this.amount = j5;
            this.currency = currency;
        }

        public static /* synthetic */ Monetary copy$default(Monetary monetary, long j5, Currency currency, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                j5 = monetary.amount;
            }
            if ((i5 & 2) != 0) {
                currency = monetary.currency;
            }
            return monetary.copy(j5, currency);
        }

        /* renamed from: component1, reason: from getter */
        public final long getAmount() {
            return this.amount;
        }

        /* renamed from: component2, reason: from getter */
        public final Currency getCurrency() {
            return this.currency;
        }

        public final Monetary copy(long amount, Currency currency) {
            Intrinsics.checkNotNullParameter(currency, "currency");
            return new Monetary(amount, currency);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Monetary)) {
                return false;
            }
            Monetary monetary = (Monetary) other;
            return this.amount == monetary.amount && this.currency == monetary.currency;
        }

        public final long getAmount() {
            return this.amount;
        }

        public final Currency getCurrency() {
            return this.currency;
        }

        public int hashCode() {
            return (Long.hashCode(this.amount) * 31) + this.currency.hashCode();
        }

        public String toString() {
            return "Monetary(amount=" + this.amount + ", currency=" + this.currency + ")";
        }
    }

    public /* synthetic */ Amount(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Amount() {
    }
}
