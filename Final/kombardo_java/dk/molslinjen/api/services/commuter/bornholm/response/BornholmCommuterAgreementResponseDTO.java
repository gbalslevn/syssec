package dk.molslinjen.api.services.commuter.bornholm.response;

import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import dk.molslinjen.domain.model.constants.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 J2\u00020\u0001:\u0002IJBu\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016B\u0099\u0001\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u000e\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0015\u0010\u001aJ\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\t\u00105\u001a\u00020\nHÆ\u0003J\t\u00106\u001a\u00020\u000eHÆ\u0003J\t\u00107\u001a\u00020\bHÆ\u0003J\t\u00108\u001a\u00020\bHÆ\u0003J\t\u00109\u001a\u00020\bHÆ\u0003J\t\u0010:\u001a\u00020\u0013HÆ\u0003J\t\u0010;\u001a\u00020\bHÆ\u0003J\u008f\u0001\u0010<\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\bHÆ\u0001J\u0013\u0010=\u001a\u00020\n2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\u000eHÖ\u0001J\t\u0010@\u001a\u00020\bHÖ\u0001J%\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0001¢\u0006\u0002\bHR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010$R\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001e\u001a\u0004\b'\u0010(R\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0011\u0010\u0010\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u001c\u0010\u0011\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u001e\u001a\u0004\b,\u0010\"R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0014\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\"¨\u0006K"}, d2 = {"Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterAgreementResponseDTO;", BuildConfig.FLAVOR, "activeTickets", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterBookingResponseDTO;", "validToDate", "Lorg/threeten/bp/LocalDate;", "commuteAgreementId", BuildConfig.FLAVOR, "deleteTicketsAllowed", BuildConfig.FLAVOR, "allowedRoundtripRouteIds", "isApproved", "numberOfPersons", BuildConfig.FLAVOR, "text", Constants.IntentExtra.PushTitle, "transportId", "currency", "Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "lineName", "<init>", "(Ljava/util/List;Lorg/threeten/bp/LocalDate;Ljava/lang/String;ZLjava/util/List;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lorg/threeten/bp/LocalDate;Ljava/lang/String;ZLjava/util/List;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActiveTickets", "()Ljava/util/List;", "getValidToDate$annotations", "()V", "getValidToDate", "()Lorg/threeten/bp/LocalDate;", "getCommuteAgreementId", "()Ljava/lang/String;", "getDeleteTicketsAllowed", "()Z", "getAllowedRoundtripRouteIds", "getNumberOfPersons$annotations", "getNumberOfPersons", "()I", "getText", "getTitle", "getTransportId$annotations", "getTransportId", "getCurrency", "()Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "getLineName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class BornholmCommuterAgreementResponseDTO {
    private final List<BornholmCommuterBookingResponseDTO> activeTickets;
    private final List<String> allowedRoundtripRouteIds;
    private final String commuteAgreementId;
    private final CurrencyTypeDTO currency;
    private final boolean deleteTicketsAllowed;
    private final boolean isApproved;
    private final String lineName;
    private final int numberOfPersons;
    private final String text;
    private final String title;
    private final String transportId;
    private final LocalDate validToDate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(BornholmCommuterBookingResponseDTO$$serializer.INSTANCE), null, null, null, new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null, null, null, null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterAgreementResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterAgreementResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<BornholmCommuterAgreementResponseDTO> serializer() {
            return BornholmCommuterAgreementResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ BornholmCommuterAgreementResponseDTO(int i5, List list, LocalDate localDate, String str, boolean z5, List list2, boolean z6, int i6, String str2, String str3, String str4, CurrencyTypeDTO currencyTypeDTO, String str5, SerializationConstructorMarker serializationConstructorMarker) {
        if (4095 != (i5 & 4095)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 4095, BornholmCommuterAgreementResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.activeTickets = list;
        this.validToDate = localDate;
        this.commuteAgreementId = str;
        this.deleteTicketsAllowed = z5;
        this.allowedRoundtripRouteIds = list2;
        this.isApproved = z6;
        this.numberOfPersons = i6;
        this.text = str2;
        this.title = str3;
        this.transportId = str4;
        this.currency = currencyTypeDTO;
        this.lineName = str5;
    }

    public static /* synthetic */ void getNumberOfPersons$annotations() {
    }

    public static /* synthetic */ void getTransportId$annotations() {
    }

    @Serializable(with = LocalDateWithTimeSerializer.class)
    public static /* synthetic */ void getValidToDate$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(BornholmCommuterAgreementResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.activeTickets);
        output.encodeNullableSerializableElement(serialDesc, 1, LocalDateWithTimeSerializer.INSTANCE, self.validToDate);
        output.encodeStringElement(serialDesc, 2, self.commuteAgreementId);
        output.encodeBooleanElement(serialDesc, 3, self.deleteTicketsAllowed);
        output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.allowedRoundtripRouteIds);
        output.encodeBooleanElement(serialDesc, 5, self.isApproved);
        output.encodeIntElement(serialDesc, 6, self.numberOfPersons);
        output.encodeStringElement(serialDesc, 7, self.text);
        output.encodeStringElement(serialDesc, 8, self.title);
        output.encodeStringElement(serialDesc, 9, self.transportId);
        output.encodeSerializableElement(serialDesc, 10, CurrencyTypeDTO.Serializer.INSTANCE, self.currency);
        output.encodeStringElement(serialDesc, 11, self.lineName);
    }

    public final List<BornholmCommuterBookingResponseDTO> component1() {
        return this.activeTickets;
    }

    /* renamed from: component10, reason: from getter */
    public final String getTransportId() {
        return this.transportId;
    }

    /* renamed from: component11, reason: from getter */
    public final CurrencyTypeDTO getCurrency() {
        return this.currency;
    }

    /* renamed from: component12, reason: from getter */
    public final String getLineName() {
        return this.lineName;
    }

    /* renamed from: component2, reason: from getter */
    public final LocalDate getValidToDate() {
        return this.validToDate;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCommuteAgreementId() {
        return this.commuteAgreementId;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getDeleteTicketsAllowed() {
        return this.deleteTicketsAllowed;
    }

    public final List<String> component5() {
        return this.allowedRoundtripRouteIds;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsApproved() {
        return this.isApproved;
    }

    /* renamed from: component7, reason: from getter */
    public final int getNumberOfPersons() {
        return this.numberOfPersons;
    }

    /* renamed from: component8, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component9, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final BornholmCommuterAgreementResponseDTO copy(List<BornholmCommuterBookingResponseDTO> activeTickets, LocalDate validToDate, String commuteAgreementId, boolean deleteTicketsAllowed, List<String> allowedRoundtripRouteIds, boolean isApproved, int numberOfPersons, String text, String title, String transportId, CurrencyTypeDTO currency, String lineName) {
        Intrinsics.checkNotNullParameter(activeTickets, "activeTickets");
        Intrinsics.checkNotNullParameter(commuteAgreementId, "commuteAgreementId");
        Intrinsics.checkNotNullParameter(allowedRoundtripRouteIds, "allowedRoundtripRouteIds");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(transportId, "transportId");
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(lineName, "lineName");
        return new BornholmCommuterAgreementResponseDTO(activeTickets, validToDate, commuteAgreementId, deleteTicketsAllowed, allowedRoundtripRouteIds, isApproved, numberOfPersons, text, title, transportId, currency, lineName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BornholmCommuterAgreementResponseDTO)) {
            return false;
        }
        BornholmCommuterAgreementResponseDTO bornholmCommuterAgreementResponseDTO = (BornholmCommuterAgreementResponseDTO) other;
        return Intrinsics.areEqual(this.activeTickets, bornholmCommuterAgreementResponseDTO.activeTickets) && Intrinsics.areEqual(this.validToDate, bornholmCommuterAgreementResponseDTO.validToDate) && Intrinsics.areEqual(this.commuteAgreementId, bornholmCommuterAgreementResponseDTO.commuteAgreementId) && this.deleteTicketsAllowed == bornholmCommuterAgreementResponseDTO.deleteTicketsAllowed && Intrinsics.areEqual(this.allowedRoundtripRouteIds, bornholmCommuterAgreementResponseDTO.allowedRoundtripRouteIds) && this.isApproved == bornholmCommuterAgreementResponseDTO.isApproved && this.numberOfPersons == bornholmCommuterAgreementResponseDTO.numberOfPersons && Intrinsics.areEqual(this.text, bornholmCommuterAgreementResponseDTO.text) && Intrinsics.areEqual(this.title, bornholmCommuterAgreementResponseDTO.title) && Intrinsics.areEqual(this.transportId, bornholmCommuterAgreementResponseDTO.transportId) && this.currency == bornholmCommuterAgreementResponseDTO.currency && Intrinsics.areEqual(this.lineName, bornholmCommuterAgreementResponseDTO.lineName);
    }

    public final List<BornholmCommuterBookingResponseDTO> getActiveTickets() {
        return this.activeTickets;
    }

    public final List<String> getAllowedRoundtripRouteIds() {
        return this.allowedRoundtripRouteIds;
    }

    public final String getCommuteAgreementId() {
        return this.commuteAgreementId;
    }

    public final CurrencyTypeDTO getCurrency() {
        return this.currency;
    }

    public final boolean getDeleteTicketsAllowed() {
        return this.deleteTicketsAllowed;
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

    public final LocalDate getValidToDate() {
        return this.validToDate;
    }

    public int hashCode() {
        int hashCode = this.activeTickets.hashCode() * 31;
        LocalDate localDate = this.validToDate;
        return ((((((((((((((((((((hashCode + (localDate == null ? 0 : localDate.hashCode())) * 31) + this.commuteAgreementId.hashCode()) * 31) + Boolean.hashCode(this.deleteTicketsAllowed)) * 31) + this.allowedRoundtripRouteIds.hashCode()) * 31) + Boolean.hashCode(this.isApproved)) * 31) + Integer.hashCode(this.numberOfPersons)) * 31) + this.text.hashCode()) * 31) + this.title.hashCode()) * 31) + this.transportId.hashCode()) * 31) + this.currency.hashCode()) * 31) + this.lineName.hashCode();
    }

    public final boolean isApproved() {
        return this.isApproved;
    }

    public String toString() {
        return "BornholmCommuterAgreementResponseDTO(activeTickets=" + this.activeTickets + ", validToDate=" + this.validToDate + ", commuteAgreementId=" + this.commuteAgreementId + ", deleteTicketsAllowed=" + this.deleteTicketsAllowed + ", allowedRoundtripRouteIds=" + this.allowedRoundtripRouteIds + ", isApproved=" + this.isApproved + ", numberOfPersons=" + this.numberOfPersons + ", text=" + this.text + ", title=" + this.title + ", transportId=" + this.transportId + ", currency=" + this.currency + ", lineName=" + this.lineName + ")";
    }

    public BornholmCommuterAgreementResponseDTO(List<BornholmCommuterBookingResponseDTO> activeTickets, LocalDate localDate, String commuteAgreementId, boolean z5, List<String> allowedRoundtripRouteIds, boolean z6, int i5, String text, String title, String transportId, CurrencyTypeDTO currency, String lineName) {
        Intrinsics.checkNotNullParameter(activeTickets, "activeTickets");
        Intrinsics.checkNotNullParameter(commuteAgreementId, "commuteAgreementId");
        Intrinsics.checkNotNullParameter(allowedRoundtripRouteIds, "allowedRoundtripRouteIds");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(transportId, "transportId");
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(lineName, "lineName");
        this.activeTickets = activeTickets;
        this.validToDate = localDate;
        this.commuteAgreementId = commuteAgreementId;
        this.deleteTicketsAllowed = z5;
        this.allowedRoundtripRouteIds = allowedRoundtripRouteIds;
        this.isApproved = z6;
        this.numberOfPersons = i5;
        this.text = text;
        this.title = title;
        this.transportId = transportId;
        this.currency = currency;
        this.lineName = lineName;
    }
}
