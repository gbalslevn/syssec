package dk.molslinjen.ui.views.screens.agreements.multiride.purchase;

import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/multiride/purchase/MultiRidePurchaseScreenNavArgs;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "paymentOrigin", "Ldk/molslinjen/domain/model/config/Site;", "site", "<init>", "(Ldk/molslinjen/domain/model/payment/PaymentOrigin;Ldk/molslinjen/domain/model/config/Site;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "getPaymentOrigin", "()Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MultiRidePurchaseScreenNavArgs {
    private final PaymentOrigin paymentOrigin;
    private final Site site;

    public MultiRidePurchaseScreenNavArgs(PaymentOrigin paymentOrigin, Site site) {
        Intrinsics.checkNotNullParameter(paymentOrigin, "paymentOrigin");
        Intrinsics.checkNotNullParameter(site, "site");
        this.paymentOrigin = paymentOrigin;
        this.site = site;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiRidePurchaseScreenNavArgs)) {
            return false;
        }
        MultiRidePurchaseScreenNavArgs multiRidePurchaseScreenNavArgs = (MultiRidePurchaseScreenNavArgs) other;
        return this.paymentOrigin == multiRidePurchaseScreenNavArgs.paymentOrigin && this.site == multiRidePurchaseScreenNavArgs.site;
    }

    public final PaymentOrigin getPaymentOrigin() {
        return this.paymentOrigin;
    }

    public final Site getSite() {
        return this.site;
    }

    public int hashCode() {
        return (this.paymentOrigin.hashCode() * 31) + this.site.hashCode();
    }

    public String toString() {
        return "MultiRidePurchaseScreenNavArgs(paymentOrigin=" + this.paymentOrigin + ", site=" + this.site + ")";
    }
}
