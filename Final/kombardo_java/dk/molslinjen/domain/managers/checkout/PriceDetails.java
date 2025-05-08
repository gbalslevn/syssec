package dk.molslinjen.domain.managers.checkout;

import com.adjust.sdk.Constants;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB=\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0005\u0010\u0019R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u001d\u0010\u0019R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001e\u0010\u001c¨\u0006 "}, d2 = {"Ldk/molslinjen/domain/managers/checkout/PriceDetails;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "totalPrice", BuildConfig.FLAVOR, "isEditing", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "changeFee", "nonRefundableAddons", "unavailableFood", "<init>", "(Ldk/molslinjen/domain/managers/checkout/PriceTotal;ZLdk/molslinjen/domain/model/shared/PriceWithCurrency;ZLdk/molslinjen/domain/model/shared/PriceWithCurrency;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "getTotalPrice", "()Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "Z", "()Z", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getChangeFee", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getNonRefundableAddons", "getUnavailableFood", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PriceDetails {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PriceDetails mock;
    private final PriceWithCurrency changeFee;
    private final boolean isEditing;
    private final boolean nonRefundableAddons;
    private final PriceTotal totalPrice;
    private final PriceWithCurrency unavailableFood;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/PriceDetails$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/managers/checkout/PriceDetails;", "getMock", "()Ldk/molslinjen/domain/managers/checkout/PriceDetails;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PriceDetails getMock() {
            return PriceDetails.mock;
        }

        private Companion() {
        }
    }

    static {
        PriceWithCurrency.Companion companion = PriceWithCurrency.INSTANCE;
        mock = new PriceDetails(new PriceTotal(companion.mock(Constants.ONE_SECOND), new Price.Charge(0), false, 4, null), true, companion.mock(100), true, companion.mock(50));
    }

    public PriceDetails(PriceTotal totalPrice, boolean z5, PriceWithCurrency priceWithCurrency, boolean z6, PriceWithCurrency priceWithCurrency2) {
        Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
        this.totalPrice = totalPrice;
        this.isEditing = z5;
        this.changeFee = priceWithCurrency;
        this.nonRefundableAddons = z6;
        this.unavailableFood = priceWithCurrency2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PriceDetails)) {
            return false;
        }
        PriceDetails priceDetails = (PriceDetails) other;
        return Intrinsics.areEqual(this.totalPrice, priceDetails.totalPrice) && this.isEditing == priceDetails.isEditing && Intrinsics.areEqual(this.changeFee, priceDetails.changeFee) && this.nonRefundableAddons == priceDetails.nonRefundableAddons && Intrinsics.areEqual(this.unavailableFood, priceDetails.unavailableFood);
    }

    public final PriceWithCurrency getChangeFee() {
        return this.changeFee;
    }

    public final boolean getNonRefundableAddons() {
        return this.nonRefundableAddons;
    }

    public final PriceTotal getTotalPrice() {
        return this.totalPrice;
    }

    public final PriceWithCurrency getUnavailableFood() {
        return this.unavailableFood;
    }

    public int hashCode() {
        int hashCode = ((this.totalPrice.hashCode() * 31) + Boolean.hashCode(this.isEditing)) * 31;
        PriceWithCurrency priceWithCurrency = this.changeFee;
        int hashCode2 = (((hashCode + (priceWithCurrency == null ? 0 : priceWithCurrency.hashCode())) * 31) + Boolean.hashCode(this.nonRefundableAddons)) * 31;
        PriceWithCurrency priceWithCurrency2 = this.unavailableFood;
        return hashCode2 + (priceWithCurrency2 != null ? priceWithCurrency2.hashCode() : 0);
    }

    /* renamed from: isEditing, reason: from getter */
    public final boolean getIsEditing() {
        return this.isEditing;
    }

    public String toString() {
        return "PriceDetails(totalPrice=" + this.totalPrice + ", isEditing=" + this.isEditing + ", changeFee=" + this.changeFee + ", nonRefundableAddons=" + this.nonRefundableAddons + ", unavailableFood=" + this.unavailableFood + ")";
    }

    public /* synthetic */ PriceDetails(PriceTotal priceTotal, boolean z5, PriceWithCurrency priceWithCurrency, boolean z6, PriceWithCurrency priceWithCurrency2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? new PriceTotal(PriceWithCurrency.INSTANCE.m3248default(), new Price.Charge(0), false, 4, null) : priceTotal, (i5 & 2) != 0 ? false : z5, (i5 & 4) != 0 ? null : priceWithCurrency, (i5 & 8) == 0 ? z6 : false, (i5 & 16) == 0 ? priceWithCurrency2 : null);
    }
}
