package dk.molslinjen.domain.model.booking;

import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideTransport;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fB\u0019\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u000e\u0010\u0014J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\rHÆ\u0003Je\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010*\u001a\u00020\u00132\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u000bHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006."}, d2 = {"Ldk/molslinjen/domain/model/booking/MultiRideBookingData;", BuildConfig.FLAVOR, "customer", BuildConfig.FLAVOR, "agreementNumber", "typeId", "routeIds", BuildConfig.FLAVOR, "defaultTransportId", "transportationIds", "remainingCharges", BuildConfig.FLAVOR, "flowOrigin", "Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;ILdk/molslinjen/domain/model/payment/PaymentOrigin;)V", "multiRideCard", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "isFromDetails", BuildConfig.FLAVOR, "(Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;Z)V", "getCustomer", "()Ljava/lang/String;", "getAgreementNumber", "getTypeId", "getRouteIds", "()Ljava/util/List;", "getDefaultTransportId", "getTransportationIds", "getRemainingCharges", "()I", "getFlowOrigin", "()Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MultiRideBookingData {
    private final String agreementNumber;
    private final String customer;
    private final String defaultTransportId;
    private final PaymentOrigin flowOrigin;
    private final int remainingCharges;
    private final List<String> routeIds;
    private final List<String> transportationIds;
    private final String typeId;

    public MultiRideBookingData(String customer, String agreementNumber, String typeId, List<String> routeIds, String defaultTransportId, List<String> transportationIds, int i5, PaymentOrigin flowOrigin) {
        Intrinsics.checkNotNullParameter(customer, "customer");
        Intrinsics.checkNotNullParameter(agreementNumber, "agreementNumber");
        Intrinsics.checkNotNullParameter(typeId, "typeId");
        Intrinsics.checkNotNullParameter(routeIds, "routeIds");
        Intrinsics.checkNotNullParameter(defaultTransportId, "defaultTransportId");
        Intrinsics.checkNotNullParameter(transportationIds, "transportationIds");
        Intrinsics.checkNotNullParameter(flowOrigin, "flowOrigin");
        this.customer = customer;
        this.agreementNumber = agreementNumber;
        this.typeId = typeId;
        this.routeIds = routeIds;
        this.defaultTransportId = defaultTransportId;
        this.transportationIds = transportationIds;
        this.remainingCharges = i5;
        this.flowOrigin = flowOrigin;
    }

    /* renamed from: component1, reason: from getter */
    public final String getCustomer() {
        return this.customer;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAgreementNumber() {
        return this.agreementNumber;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTypeId() {
        return this.typeId;
    }

    public final List<String> component4() {
        return this.routeIds;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDefaultTransportId() {
        return this.defaultTransportId;
    }

    public final List<String> component6() {
        return this.transportationIds;
    }

    /* renamed from: component7, reason: from getter */
    public final int getRemainingCharges() {
        return this.remainingCharges;
    }

    /* renamed from: component8, reason: from getter */
    public final PaymentOrigin getFlowOrigin() {
        return this.flowOrigin;
    }

    public final MultiRideBookingData copy(String customer, String agreementNumber, String typeId, List<String> routeIds, String defaultTransportId, List<String> transportationIds, int remainingCharges, PaymentOrigin flowOrigin) {
        Intrinsics.checkNotNullParameter(customer, "customer");
        Intrinsics.checkNotNullParameter(agreementNumber, "agreementNumber");
        Intrinsics.checkNotNullParameter(typeId, "typeId");
        Intrinsics.checkNotNullParameter(routeIds, "routeIds");
        Intrinsics.checkNotNullParameter(defaultTransportId, "defaultTransportId");
        Intrinsics.checkNotNullParameter(transportationIds, "transportationIds");
        Intrinsics.checkNotNullParameter(flowOrigin, "flowOrigin");
        return new MultiRideBookingData(customer, agreementNumber, typeId, routeIds, defaultTransportId, transportationIds, remainingCharges, flowOrigin);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiRideBookingData)) {
            return false;
        }
        MultiRideBookingData multiRideBookingData = (MultiRideBookingData) other;
        return Intrinsics.areEqual(this.customer, multiRideBookingData.customer) && Intrinsics.areEqual(this.agreementNumber, multiRideBookingData.agreementNumber) && Intrinsics.areEqual(this.typeId, multiRideBookingData.typeId) && Intrinsics.areEqual(this.routeIds, multiRideBookingData.routeIds) && Intrinsics.areEqual(this.defaultTransportId, multiRideBookingData.defaultTransportId) && Intrinsics.areEqual(this.transportationIds, multiRideBookingData.transportationIds) && this.remainingCharges == multiRideBookingData.remainingCharges && this.flowOrigin == multiRideBookingData.flowOrigin;
    }

    public final String getAgreementNumber() {
        return this.agreementNumber;
    }

    public final String getCustomer() {
        return this.customer;
    }

    public final String getDefaultTransportId() {
        return this.defaultTransportId;
    }

    public final PaymentOrigin getFlowOrigin() {
        return this.flowOrigin;
    }

    public final int getRemainingCharges() {
        return this.remainingCharges;
    }

    public final List<String> getRouteIds() {
        return this.routeIds;
    }

    public final List<String> getTransportationIds() {
        return this.transportationIds;
    }

    public final String getTypeId() {
        return this.typeId;
    }

    public int hashCode() {
        return (((((((((((((this.customer.hashCode() * 31) + this.agreementNumber.hashCode()) * 31) + this.typeId.hashCode()) * 31) + this.routeIds.hashCode()) * 31) + this.defaultTransportId.hashCode()) * 31) + this.transportationIds.hashCode()) * 31) + Integer.hashCode(this.remainingCharges)) * 31) + this.flowOrigin.hashCode();
    }

    public String toString() {
        return "MultiRideBookingData(customer=" + this.customer + ", agreementNumber=" + this.agreementNumber + ", typeId=" + this.typeId + ", routeIds=" + this.routeIds + ", defaultTransportId=" + this.defaultTransportId + ", transportationIds=" + this.transportationIds + ", remainingCharges=" + this.remainingCharges + ", flowOrigin=" + this.flowOrigin + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MultiRideBookingData(MultiRideCard multiRideCard, boolean z5) {
        this(r2, r3, r4, r5, r6, r7, multiRideCard.getRemainingCharges(), z5 ? PaymentOrigin.MultiRideTicketFromDetails : PaymentOrigin.MultiRideTicketFromAgreements);
        Intrinsics.checkNotNullParameter(multiRideCard, "multiRideCard");
        String customer = multiRideCard.getCustomer();
        String id = multiRideCard.getId();
        String multiRideTypeId = multiRideCard.getMultiRideTypeId();
        List<String> allowedRouteIds = multiRideCard.getAllowedRouteIds();
        String transportId = multiRideCard.getDefaultTransportation().getTransportId();
        List<MultiRideTransport> enabledTransportations = multiRideCard.getEnabledTransportations();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(enabledTransportations, 10));
        Iterator<T> it = enabledTransportations.iterator();
        while (it.hasNext()) {
            arrayList.add(((MultiRideTransport) it.next()).getTransportId());
        }
    }
}
