package dk.molslinjen.domain.model.shared;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/shared/Price;", BuildConfig.FLAVOR, "<init>", "()V", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "Charge", "Ldk/molslinjen/domain/model/shared/Price$Charge;", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class Price {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/domain/model/shared/Price$Charge;", "Ldk/molslinjen/domain/model/shared/Price;", "numberOfCharges", BuildConfig.FLAVOR, "<init>", "(I)V", "getNumberOfCharges", "()I", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Charge extends Price {
        private final int numberOfCharges;

        public Charge(int i5) {
            super(null);
            this.numberOfCharges = i5;
        }

        public static /* synthetic */ Charge copy$default(Charge charge, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i5 = charge.numberOfCharges;
            }
            return charge.copy(i5);
        }

        /* renamed from: component1, reason: from getter */
        public final int getNumberOfCharges() {
            return this.numberOfCharges;
        }

        public final Charge copy(int numberOfCharges) {
            return new Charge(numberOfCharges);
        }

        @Override // dk.molslinjen.domain.model.shared.Price
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Charge) && this.numberOfCharges == ((Charge) other).numberOfCharges;
        }

        public final int getNumberOfCharges() {
            return this.numberOfCharges;
        }

        @Override // dk.molslinjen.domain.model.shared.Price
        public int hashCode() {
            return Integer.hashCode(this.numberOfCharges);
        }

        public String toString() {
            return "Charge(numberOfCharges=" + this.numberOfCharges + ")";
        }
    }

    public /* synthetic */ Price(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public boolean equals(Object other) {
        if (!(other instanceof Price)) {
            return false;
        }
        if (this instanceof Charge) {
            if (!(other instanceof Charge) || ((Charge) this).getNumberOfCharges() != ((Charge) other).getNumberOfCharges()) {
                return false;
            }
        } else {
            if (!(this instanceof PriceWithCurrency)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!(other instanceof PriceWithCurrency)) {
                return false;
            }
            PriceWithCurrency priceWithCurrency = (PriceWithCurrency) this;
            PriceWithCurrency priceWithCurrency2 = (PriceWithCurrency) other;
            if (priceWithCurrency.getValue() != priceWithCurrency2.getValue() || priceWithCurrency.getCurrencyType() != priceWithCurrency2.getCurrencyType()) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    private Price() {
    }
}
