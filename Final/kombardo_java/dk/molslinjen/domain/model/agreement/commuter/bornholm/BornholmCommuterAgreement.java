package dk.molslinjen.domain.model.agreement.commuter.bornholm;

import dk.molslinjen.api.services.commuter.bornholm.response.BornholmCommuterAgreementResponseDTO;
import dk.molslinjen.api.services.commuter.bornholm.response.BornholmCommuterBookingResponseDTO;
import dk.molslinjen.domain.extensions.domain.CommuterBookingExtensionsKt;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.shared.CurrencyType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b-\b\u0086\b\u0018\u0000 G2\u00020\u0001:\u0001GB\u0087\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u0019B#\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0018\u0010\u001cJ\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00106\u001a\u00020\bHÆ\u0003J\t\u00107\u001a\u00020\bHÆ\u0003J\t\u00108\u001a\u00020\u000bHÆ\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u000bHÆ\u0003J\t\u0010;\u001a\u00020\u000fHÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003J\t\u0010=\u001a\u00020\bHÆ\u0003J\t\u0010>\u001a\u00020\bHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u0010@\u001a\u00020\u0016HÆ\u0003J\t\u0010A\u001a\u00020\bHÆ\u0003J¥\u0001\u0010B\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\bHÆ\u0001J\u0013\u0010C\u001a\u00020\u000b2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\u000fHÖ\u0001J\t\u0010F\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010%R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0010\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0011\u0010\u0012\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0017\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0011\u00101\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b1\u0010%R\u0013\u00102\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b3\u0010\"¨\u0006H"}, d2 = {"Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterAgreement;", BuildConfig.FLAVOR, "activeTickets", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterBooking;", "validUntil", "Lorg/threeten/bp/LocalDate;", "commuterId", BuildConfig.FLAVOR, "commuterAgreementId", "deleteTicketsAllowed", BuildConfig.FLAVOR, "allowedRouteIds", "isApproved", "numberOfPersons", BuildConfig.FLAVOR, "text", Constants.IntentExtra.PushTitle, "transportId", "transportation", "Ldk/molslinjen/domain/model/config/Transportation;", "currency", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "lineName", "<init>", "(Ljava/util/List;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Transportation;Ldk/molslinjen/domain/model/shared/CurrencyType;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterAgreementResponseDTO;", "(Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterAgreementResponseDTO;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Transportation;)V", "getActiveTickets", "()Ljava/util/List;", "getValidUntil", "()Lorg/threeten/bp/LocalDate;", "getCommuterId", "()Ljava/lang/String;", "getCommuterAgreementId", "getDeleteTicketsAllowed", "()Z", "getAllowedRouteIds", "getNumberOfPersons", "()I", "getText", "getTitle", "getTransportId", "getTransportation", "()Ldk/molslinjen/domain/model/config/Transportation;", "getCurrency", "()Ldk/molslinjen/domain/model/shared/CurrencyType;", "getLineName", "isExpired", "licensePlate", "getLicensePlate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BornholmCommuterAgreement {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final BornholmCommuterAgreement mock = new BornholmCommuterAgreement(CollectionsKt.listOf(BornholmCommuterBooking.INSTANCE.getMock()), LocalDate.now().plusMonths(1), "123456", "101247", false, CollectionsKt.listOf((Object[]) new String[]{"1", "2", "3"}), true, 5, "QWEWQEQ", "Lav bil", "B810000", Transportation.INSTANCE.getMockCar(), CurrencyType.DKK, "Bornholmslinjen");
    private final List<BornholmCommuterBooking> activeTickets;
    private final List<String> allowedRouteIds;
    private final String commuterAgreementId;
    private final String commuterId;
    private final CurrencyType currency;
    private final boolean deleteTicketsAllowed;
    private final boolean isApproved;
    private final String lineName;
    private final int numberOfPersons;
    private final String text;
    private final String title;
    private final String transportId;
    private final Transportation transportation;
    private final LocalDate validUntil;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterAgreement$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterAgreement;", "getMock", "()Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterAgreement;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BornholmCommuterAgreement getMock() {
            return BornholmCommuterAgreement.mock;
        }

        private Companion() {
        }
    }

    public BornholmCommuterAgreement(List<BornholmCommuterBooking> activeTickets, LocalDate localDate, String commuterId, String commuterAgreementId, boolean z5, List<String> allowedRouteIds, boolean z6, int i5, String text, String title, String transportId, Transportation transportation, CurrencyType currency, String lineName) {
        Intrinsics.checkNotNullParameter(activeTickets, "activeTickets");
        Intrinsics.checkNotNullParameter(commuterId, "commuterId");
        Intrinsics.checkNotNullParameter(commuterAgreementId, "commuterAgreementId");
        Intrinsics.checkNotNullParameter(allowedRouteIds, "allowedRouteIds");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(transportId, "transportId");
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(lineName, "lineName");
        this.activeTickets = activeTickets;
        this.validUntil = localDate;
        this.commuterId = commuterId;
        this.commuterAgreementId = commuterAgreementId;
        this.deleteTicketsAllowed = z5;
        this.allowedRouteIds = allowedRouteIds;
        this.isApproved = z6;
        this.numberOfPersons = i5;
        this.text = text;
        this.title = title;
        this.transportId = transportId;
        this.transportation = transportation;
        this.currency = currency;
        this.lineName = lineName;
    }

    public final List<BornholmCommuterBooking> component1() {
        return this.activeTickets;
    }

    /* renamed from: component10, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component11, reason: from getter */
    public final String getTransportId() {
        return this.transportId;
    }

    /* renamed from: component12, reason: from getter */
    public final Transportation getTransportation() {
        return this.transportation;
    }

    /* renamed from: component13, reason: from getter */
    public final CurrencyType getCurrency() {
        return this.currency;
    }

    /* renamed from: component14, reason: from getter */
    public final String getLineName() {
        return this.lineName;
    }

    /* renamed from: component2, reason: from getter */
    public final LocalDate getValidUntil() {
        return this.validUntil;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCommuterId() {
        return this.commuterId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCommuterAgreementId() {
        return this.commuterAgreementId;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getDeleteTicketsAllowed() {
        return this.deleteTicketsAllowed;
    }

    public final List<String> component6() {
        return this.allowedRouteIds;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsApproved() {
        return this.isApproved;
    }

    /* renamed from: component8, reason: from getter */
    public final int getNumberOfPersons() {
        return this.numberOfPersons;
    }

    /* renamed from: component9, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final BornholmCommuterAgreement copy(List<BornholmCommuterBooking> activeTickets, LocalDate validUntil, String commuterId, String commuterAgreementId, boolean deleteTicketsAllowed, List<String> allowedRouteIds, boolean isApproved, int numberOfPersons, String text, String title, String transportId, Transportation transportation, CurrencyType currency, String lineName) {
        Intrinsics.checkNotNullParameter(activeTickets, "activeTickets");
        Intrinsics.checkNotNullParameter(commuterId, "commuterId");
        Intrinsics.checkNotNullParameter(commuterAgreementId, "commuterAgreementId");
        Intrinsics.checkNotNullParameter(allowedRouteIds, "allowedRouteIds");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(transportId, "transportId");
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(lineName, "lineName");
        return new BornholmCommuterAgreement(activeTickets, validUntil, commuterId, commuterAgreementId, deleteTicketsAllowed, allowedRouteIds, isApproved, numberOfPersons, text, title, transportId, transportation, currency, lineName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BornholmCommuterAgreement)) {
            return false;
        }
        BornholmCommuterAgreement bornholmCommuterAgreement = (BornholmCommuterAgreement) other;
        return Intrinsics.areEqual(this.activeTickets, bornholmCommuterAgreement.activeTickets) && Intrinsics.areEqual(this.validUntil, bornholmCommuterAgreement.validUntil) && Intrinsics.areEqual(this.commuterId, bornholmCommuterAgreement.commuterId) && Intrinsics.areEqual(this.commuterAgreementId, bornholmCommuterAgreement.commuterAgreementId) && this.deleteTicketsAllowed == bornholmCommuterAgreement.deleteTicketsAllowed && Intrinsics.areEqual(this.allowedRouteIds, bornholmCommuterAgreement.allowedRouteIds) && this.isApproved == bornholmCommuterAgreement.isApproved && this.numberOfPersons == bornholmCommuterAgreement.numberOfPersons && Intrinsics.areEqual(this.text, bornholmCommuterAgreement.text) && Intrinsics.areEqual(this.title, bornholmCommuterAgreement.title) && Intrinsics.areEqual(this.transportId, bornholmCommuterAgreement.transportId) && Intrinsics.areEqual(this.transportation, bornholmCommuterAgreement.transportation) && this.currency == bornholmCommuterAgreement.currency && Intrinsics.areEqual(this.lineName, bornholmCommuterAgreement.lineName);
    }

    public final List<BornholmCommuterBooking> getActiveTickets() {
        return this.activeTickets;
    }

    public final List<String> getAllowedRouteIds() {
        return this.allowedRouteIds;
    }

    public final String getCommuterAgreementId() {
        return this.commuterAgreementId;
    }

    public final String getCommuterId() {
        return this.commuterId;
    }

    public final CurrencyType getCurrency() {
        return this.currency;
    }

    public final boolean getDeleteTicketsAllowed() {
        return this.deleteTicketsAllowed;
    }

    public final String getLicensePlate() {
        Transportation transportation = this.transportation;
        if (transportation == null || transportation.isWalking()) {
            return null;
        }
        return this.text;
    }

    public final String getLineName() {
        return this.lineName;
    }

    public final int getNumberOfPersons() {
        return this.numberOfPersons;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTransportId() {
        return this.transportId;
    }

    public final Transportation getTransportation() {
        return this.transportation;
    }

    public final LocalDate getValidUntil() {
        return this.validUntil;
    }

    public int hashCode() {
        int hashCode = this.activeTickets.hashCode() * 31;
        LocalDate localDate = this.validUntil;
        int hashCode2 = (((((((((((((((((((hashCode + (localDate == null ? 0 : localDate.hashCode())) * 31) + this.commuterId.hashCode()) * 31) + this.commuterAgreementId.hashCode()) * 31) + Boolean.hashCode(this.deleteTicketsAllowed)) * 31) + this.allowedRouteIds.hashCode()) * 31) + Boolean.hashCode(this.isApproved)) * 31) + Integer.hashCode(this.numberOfPersons)) * 31) + this.text.hashCode()) * 31) + this.title.hashCode()) * 31) + this.transportId.hashCode()) * 31;
        Transportation transportation = this.transportation;
        return ((((hashCode2 + (transportation != null ? transportation.hashCode() : 0)) * 31) + this.currency.hashCode()) * 31) + this.lineName.hashCode();
    }

    public final boolean isApproved() {
        return this.isApproved;
    }

    public final boolean isExpired() {
        LocalDate localDate = this.validUntil;
        return localDate != null && localDate.isBefore(LocalDate.now());
    }

    public String toString() {
        return "BornholmCommuterAgreement(activeTickets=" + this.activeTickets + ", validUntil=" + this.validUntil + ", commuterId=" + this.commuterId + ", commuterAgreementId=" + this.commuterAgreementId + ", deleteTicketsAllowed=" + this.deleteTicketsAllowed + ", allowedRouteIds=" + this.allowedRouteIds + ", isApproved=" + this.isApproved + ", numberOfPersons=" + this.numberOfPersons + ", text=" + this.text + ", title=" + this.title + ", transportId=" + this.transportId + ", transportation=" + this.transportation + ", currency=" + this.currency + ", lineName=" + this.lineName + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BornholmCommuterAgreement(BornholmCommuterAgreementResponseDTO dto, String commuterId, Transportation transportation) {
        this(CommuterBookingExtensionsKt.sortedForDisplay(r2), dto.getValidToDate(), commuterId, dto.getCommuteAgreementId(), dto.getDeleteTicketsAllowed(), dto.getAllowedRoundtripRouteIds(), dto.isApproved(), dto.getNumberOfPersons(), dto.getText(), dto.getTitle(), dto.getTransportId(), transportation, CurrencyType.INSTANCE.invoke(dto.getCurrency()), dto.getLineName());
        Intrinsics.checkNotNullParameter(dto, "dto");
        Intrinsics.checkNotNullParameter(commuterId, "commuterId");
        List<BornholmCommuterBookingResponseDTO> activeTickets = dto.getActiveTickets();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(activeTickets, 10));
        Iterator<T> it = activeTickets.iterator();
        while (it.hasNext()) {
            arrayList.add(new BornholmCommuterBooking((BornholmCommuterBookingResponseDTO) it.next()));
        }
    }
}
