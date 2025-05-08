package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0004\b\b\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0000H\u0086\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0086\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/PriceTotal;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "price", "Ldk/molslinjen/domain/model/shared/Price$Charge;", "charges", BuildConfig.FLAVOR, "preferChargesIfZero", "<init>", "(Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ldk/molslinjen/domain/model/shared/Price$Charge;Z)V", "Ldk/molslinjen/domain/model/shared/Price;", "(Ldk/molslinjen/domain/model/shared/Price;)V", "increment", "plus", "(Ldk/molslinjen/domain/managers/checkout/PriceTotal;)Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "i", "compareTo", "(I)I", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "Ldk/molslinjen/domain/model/shared/Price$Charge;", "getCharges", "()Ldk/molslinjen/domain/model/shared/Price$Charge;", "Z", "getPreferChargesIfZero", "()Z", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PriceTotal {
    private final Price.Charge charges;
    private final boolean preferChargesIfZero;
    private final PriceWithCurrency price;

    public PriceTotal(PriceWithCurrency price, Price.Charge charges, boolean z5) {
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(charges, "charges");
        this.price = price;
        this.charges = charges;
        this.preferChargesIfZero = z5;
    }

    public final int compareTo(int i5) {
        return (this.price.getValue() + this.charges.getNumberOfCharges()) - i5;
    }

    public boolean equals(Object other) {
        if (other instanceof PriceTotal) {
            PriceTotal priceTotal = (PriceTotal) other;
            if (Intrinsics.areEqual(this.price, priceTotal.price) && Intrinsics.areEqual(this.charges, priceTotal.charges)) {
                return true;
            }
        } else {
            if (other instanceof Price) {
                return Intrinsics.areEqual(this, new PriceTotal((Price) other));
            }
            if (other instanceof Integer) {
                int value = this.price.getValue() + this.charges.getNumberOfCharges();
                if ((other instanceof Integer) && value == ((Number) other).intValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final Price.Charge getCharges() {
        return this.charges;
    }

    public final boolean getPreferChargesIfZero() {
        return this.preferChargesIfZero;
    }

    public final PriceWithCurrency getPrice() {
        return this.price;
    }

    public int hashCode() {
        return (this.price.hashCode() * 31) + this.charges.hashCode();
    }

    public final PriceTotal plus(PriceTotal increment) {
        if (increment == null) {
            return this;
        }
        return new PriceTotal(new PriceWithCurrency(this.price.getValue() + increment.price.getValue(), this.price.getCurrencyType()), new Price.Charge(this.charges.getNumberOfCharges() + increment.charges.getNumberOfCharges()), false, 4, null);
    }

    public String toString() {
        return "PriceTotal(price=" + this.price + ", charges=" + this.charges + ", preferChargesIfZero=" + this.preferChargesIfZero + ")";
    }

    public /* synthetic */ PriceTotal(PriceWithCurrency priceWithCurrency, Price.Charge charge, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(priceWithCurrency, charge, (i5 & 4) != 0 ? false : z5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PriceTotal(Price price) {
        this(price instanceof PriceWithCurrency ? (PriceWithCurrency) price : PriceWithCurrency.INSTANCE.m3248default(), r1 ? (Price.Charge) price : new Price.Charge(0), r1);
        Intrinsics.checkNotNullParameter(price, "price");
        boolean z5 = price instanceof Price.Charge;
    }
}
