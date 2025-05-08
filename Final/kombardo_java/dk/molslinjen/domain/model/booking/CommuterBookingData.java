package dk.molslinjen.domain.model.booking;

import dk.molslinjen.domain.model.agreement.commuter.bornholm.BornholmCommuterAgreement;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.domain.model.shared.CurrencyType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\f\u0010\u0012J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003JM\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010$\u001a\u00020\u00112\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Ldk/molslinjen/domain/model/booking/CommuterBookingData;", BuildConfig.FLAVOR, "agreementId", BuildConfig.FLAVOR, "routeIds", BuildConfig.FLAVOR, "licensePlate", "transportationId", "currency", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "flowOrigin", "Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/CurrencyType;Ldk/molslinjen/domain/model/payment/PaymentOrigin;)V", "bornholmCommuterAgreement", "Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterAgreement;", "isFromDetails", BuildConfig.FLAVOR, "(Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterAgreement;Z)V", "getAgreementId", "()Ljava/lang/String;", "getRouteIds", "()Ljava/util/List;", "getLicensePlate", "getTransportationId", "getCurrency", "()Ldk/molslinjen/domain/model/shared/CurrencyType;", "getFlowOrigin", "()Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CommuterBookingData {
    private final String agreementId;
    private final CurrencyType currency;
    private final PaymentOrigin flowOrigin;
    private final String licensePlate;
    private final List<String> routeIds;
    private final String transportationId;

    public CommuterBookingData(String agreementId, List<String> routeIds, String str, String transportationId, CurrencyType currency, PaymentOrigin flowOrigin) {
        Intrinsics.checkNotNullParameter(agreementId, "agreementId");
        Intrinsics.checkNotNullParameter(routeIds, "routeIds");
        Intrinsics.checkNotNullParameter(transportationId, "transportationId");
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(flowOrigin, "flowOrigin");
        this.agreementId = agreementId;
        this.routeIds = routeIds;
        this.licensePlate = str;
        this.transportationId = transportationId;
        this.currency = currency;
        this.flowOrigin = flowOrigin;
    }

    public static /* synthetic */ CommuterBookingData copy$default(CommuterBookingData commuterBookingData, String str, List list, String str2, String str3, CurrencyType currencyType, PaymentOrigin paymentOrigin, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = commuterBookingData.agreementId;
        }
        if ((i5 & 2) != 0) {
            list = commuterBookingData.routeIds;
        }
        List list2 = list;
        if ((i5 & 4) != 0) {
            str2 = commuterBookingData.licensePlate;
        }
        String str4 = str2;
        if ((i5 & 8) != 0) {
            str3 = commuterBookingData.transportationId;
        }
        String str5 = str3;
        if ((i5 & 16) != 0) {
            currencyType = commuterBookingData.currency;
        }
        CurrencyType currencyType2 = currencyType;
        if ((i5 & 32) != 0) {
            paymentOrigin = commuterBookingData.flowOrigin;
        }
        return commuterBookingData.copy(str, list2, str4, str5, currencyType2, paymentOrigin);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAgreementId() {
        return this.agreementId;
    }

    public final List<String> component2() {
        return this.routeIds;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLicensePlate() {
        return this.licensePlate;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTransportationId() {
        return this.transportationId;
    }

    /* renamed from: component5, reason: from getter */
    public final CurrencyType getCurrency() {
        return this.currency;
    }

    /* renamed from: component6, reason: from getter */
    public final PaymentOrigin getFlowOrigin() {
        return this.flowOrigin;
    }

    public final CommuterBookingData copy(String agreementId, List<String> routeIds, String licensePlate, String transportationId, CurrencyType currency, PaymentOrigin flowOrigin) {
        Intrinsics.checkNotNullParameter(agreementId, "agreementId");
        Intrinsics.checkNotNullParameter(routeIds, "routeIds");
        Intrinsics.checkNotNullParameter(transportationId, "transportationId");
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(flowOrigin, "flowOrigin");
        return new CommuterBookingData(agreementId, routeIds, licensePlate, transportationId, currency, flowOrigin);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommuterBookingData)) {
            return false;
        }
        CommuterBookingData commuterBookingData = (CommuterBookingData) other;
        return Intrinsics.areEqual(this.agreementId, commuterBookingData.agreementId) && Intrinsics.areEqual(this.routeIds, commuterBookingData.routeIds) && Intrinsics.areEqual(this.licensePlate, commuterBookingData.licensePlate) && Intrinsics.areEqual(this.transportationId, commuterBookingData.transportationId) && this.currency == commuterBookingData.currency && this.flowOrigin == commuterBookingData.flowOrigin;
    }

    public final String getAgreementId() {
        return this.agreementId;
    }

    public final CurrencyType getCurrency() {
        return this.currency;
    }

    public final PaymentOrigin getFlowOrigin() {
        return this.flowOrigin;
    }

    public final String getLicensePlate() {
        return this.licensePlate;
    }

    public final List<String> getRouteIds() {
        return this.routeIds;
    }

    public final String getTransportationId() {
        return this.transportationId;
    }

    public int hashCode() {
        int hashCode = ((this.agreementId.hashCode() * 31) + this.routeIds.hashCode()) * 31;
        String str = this.licensePlate;
        return ((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.transportationId.hashCode()) * 31) + this.currency.hashCode()) * 31) + this.flowOrigin.hashCode();
    }

    public String toString() {
        return "CommuterBookingData(agreementId=" + this.agreementId + ", routeIds=" + this.routeIds + ", licensePlate=" + this.licensePlate + ", transportationId=" + this.transportationId + ", currency=" + this.currency + ", flowOrigin=" + this.flowOrigin + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommuterBookingData(BornholmCommuterAgreement bornholmCommuterAgreement, boolean z5) {
        this(bornholmCommuterAgreement.getCommuterAgreementId(), bornholmCommuterAgreement.getAllowedRouteIds(), bornholmCommuterAgreement.getLicensePlate(), bornholmCommuterAgreement.getTransportId(), bornholmCommuterAgreement.getCurrency(), z5 ? PaymentOrigin.CommuterTicketFromDetails : PaymentOrigin.CommuterTicketFromAgreements);
        Intrinsics.checkNotNullParameter(bornholmCommuterAgreement, "bornholmCommuterAgreement");
    }
}
