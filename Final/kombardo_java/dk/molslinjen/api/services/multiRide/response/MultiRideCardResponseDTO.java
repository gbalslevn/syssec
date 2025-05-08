package dk.molslinjen.api.services.multiRide.response;

import dk.molslinjen.api.helpers.serializers.DurationSerializer;
import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
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
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 M2\u00020\u0001:\u0002LMBu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0017B\u0099\u0001\b\u0010\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0016\u0010\u001bJ\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\t\u00108\u001a\u00020\fHÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u000fHÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\t\u0010<\u001a\u00020\u0012HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u0010>\u001a\u00020\fHÆ\u0003J\u008f\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\fHÆ\u0001J\u0013\u0010@\u001a\u00020\u00122\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020\fHÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001J%\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0001¢\u0006\u0002\bKR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u001c\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010)\u001a\u0004\b0\u00101R\u0011\u0010\u0015\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b2\u0010&¨\u0006N"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/MultiRideCardResponseDTO;", BuildConfig.FLAVOR, "cardNumber", BuildConfig.FLAVOR, "cardType", "category", "Ldk/molslinjen/api/services/multiRide/response/MultiRideTicketCategoryResponseDTO;", "enabledTransports", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/multiRide/response/MultiRideTransportDTO;", "defaultTransport", "numberOfTickets", BuildConfig.FLAVOR, "customerId", "validUntil", "Lorg/threeten/bp/LocalDate;", "allowedRoundtripRouteIds", "canRefill", BuildConfig.FLAVOR, "ticketExpiration", "Lorg/threeten/bp/Duration;", "ticketExpiringCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/multiRide/response/MultiRideTicketCategoryResponseDTO;Ljava/util/List;Ldk/molslinjen/api/services/multiRide/response/MultiRideTransportDTO;ILjava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/util/List;ZLorg/threeten/bp/Duration;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/multiRide/response/MultiRideTicketCategoryResponseDTO;Ljava/util/List;Ldk/molslinjen/api/services/multiRide/response/MultiRideTransportDTO;ILjava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/util/List;ZLorg/threeten/bp/Duration;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCardNumber", "()Ljava/lang/String;", "getCardType", "getCategory", "()Ldk/molslinjen/api/services/multiRide/response/MultiRideTicketCategoryResponseDTO;", "getEnabledTransports", "()Ljava/util/List;", "getDefaultTransport", "()Ldk/molslinjen/api/services/multiRide/response/MultiRideTransportDTO;", "getNumberOfTickets", "()I", "getCustomerId", "getValidUntil$annotations", "()V", "getValidUntil", "()Lorg/threeten/bp/LocalDate;", "getAllowedRoundtripRouteIds", "getCanRefill", "()Z", "getTicketExpiration$annotations", "getTicketExpiration", "()Lorg/threeten/bp/Duration;", "getTicketExpiringCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class MultiRideCardResponseDTO {
    private final List<String> allowedRoundtripRouteIds;
    private final boolean canRefill;
    private final String cardNumber;
    private final String cardType;
    private final MultiRideTicketCategoryResponseDTO category;
    private final String customerId;
    private final MultiRideTransportDTO defaultTransport;
    private final List<MultiRideTransportDTO> enabledTransports;
    private final int numberOfTickets;
    private final Duration ticketExpiration;
    private final int ticketExpiringCount;
    private final LocalDate validUntil;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, new ArrayListSerializer(MultiRideTransportDTO$$serializer.INSTANCE), null, null, null, null, new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/MultiRideCardResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/multiRide/response/MultiRideCardResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<MultiRideCardResponseDTO> serializer() {
            return MultiRideCardResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ MultiRideCardResponseDTO(int i5, String str, String str2, MultiRideTicketCategoryResponseDTO multiRideTicketCategoryResponseDTO, List list, MultiRideTransportDTO multiRideTransportDTO, int i6, String str3, LocalDate localDate, List list2, boolean z5, Duration duration, int i7, SerializationConstructorMarker serializationConstructorMarker) {
        if (4095 != (i5 & 4095)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 4095, MultiRideCardResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.cardNumber = str;
        this.cardType = str2;
        this.category = multiRideTicketCategoryResponseDTO;
        this.enabledTransports = list;
        this.defaultTransport = multiRideTransportDTO;
        this.numberOfTickets = i6;
        this.customerId = str3;
        this.validUntil = localDate;
        this.allowedRoundtripRouteIds = list2;
        this.canRefill = z5;
        this.ticketExpiration = duration;
        this.ticketExpiringCount = i7;
    }

    @Serializable(with = DurationSerializer.class)
    public static /* synthetic */ void getTicketExpiration$annotations() {
    }

    @Serializable(with = LocalDateWithTimeSerializer.class)
    public static /* synthetic */ void getValidUntil$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(MultiRideCardResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.cardNumber);
        output.encodeStringElement(serialDesc, 1, self.cardType);
        output.encodeSerializableElement(serialDesc, 2, MultiRideTicketCategoryResponseDTO$$serializer.INSTANCE, self.category);
        output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.enabledTransports);
        output.encodeSerializableElement(serialDesc, 4, MultiRideTransportDTO$$serializer.INSTANCE, self.defaultTransport);
        output.encodeIntElement(serialDesc, 5, self.numberOfTickets);
        output.encodeStringElement(serialDesc, 6, self.customerId);
        output.encodeSerializableElement(serialDesc, 7, LocalDateWithTimeSerializer.INSTANCE, self.validUntil);
        output.encodeSerializableElement(serialDesc, 8, kSerializerArr[8], self.allowedRoundtripRouteIds);
        output.encodeBooleanElement(serialDesc, 9, self.canRefill);
        output.encodeNullableSerializableElement(serialDesc, 10, DurationSerializer.INSTANCE, self.ticketExpiration);
        output.encodeIntElement(serialDesc, 11, self.ticketExpiringCount);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCardNumber() {
        return this.cardNumber;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getCanRefill() {
        return this.canRefill;
    }

    /* renamed from: component11, reason: from getter */
    public final Duration getTicketExpiration() {
        return this.ticketExpiration;
    }

    /* renamed from: component12, reason: from getter */
    public final int getTicketExpiringCount() {
        return this.ticketExpiringCount;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCardType() {
        return this.cardType;
    }

    /* renamed from: component3, reason: from getter */
    public final MultiRideTicketCategoryResponseDTO getCategory() {
        return this.category;
    }

    public final List<MultiRideTransportDTO> component4() {
        return this.enabledTransports;
    }

    /* renamed from: component5, reason: from getter */
    public final MultiRideTransportDTO getDefaultTransport() {
        return this.defaultTransport;
    }

    /* renamed from: component6, reason: from getter */
    public final int getNumberOfTickets() {
        return this.numberOfTickets;
    }

    /* renamed from: component7, reason: from getter */
    public final String getCustomerId() {
        return this.customerId;
    }

    /* renamed from: component8, reason: from getter */
    public final LocalDate getValidUntil() {
        return this.validUntil;
    }

    public final List<String> component9() {
        return this.allowedRoundtripRouteIds;
    }

    public final MultiRideCardResponseDTO copy(String cardNumber, String cardType, MultiRideTicketCategoryResponseDTO category, List<MultiRideTransportDTO> enabledTransports, MultiRideTransportDTO defaultTransport, int numberOfTickets, String customerId, LocalDate validUntil, List<String> allowedRoundtripRouteIds, boolean canRefill, Duration ticketExpiration, int ticketExpiringCount) {
        Intrinsics.checkNotNullParameter(cardNumber, "cardNumber");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(enabledTransports, "enabledTransports");
        Intrinsics.checkNotNullParameter(defaultTransport, "defaultTransport");
        Intrinsics.checkNotNullParameter(customerId, "customerId");
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        Intrinsics.checkNotNullParameter(allowedRoundtripRouteIds, "allowedRoundtripRouteIds");
        return new MultiRideCardResponseDTO(cardNumber, cardType, category, enabledTransports, defaultTransport, numberOfTickets, customerId, validUntil, allowedRoundtripRouteIds, canRefill, ticketExpiration, ticketExpiringCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiRideCardResponseDTO)) {
            return false;
        }
        MultiRideCardResponseDTO multiRideCardResponseDTO = (MultiRideCardResponseDTO) other;
        return Intrinsics.areEqual(this.cardNumber, multiRideCardResponseDTO.cardNumber) && Intrinsics.areEqual(this.cardType, multiRideCardResponseDTO.cardType) && Intrinsics.areEqual(this.category, multiRideCardResponseDTO.category) && Intrinsics.areEqual(this.enabledTransports, multiRideCardResponseDTO.enabledTransports) && Intrinsics.areEqual(this.defaultTransport, multiRideCardResponseDTO.defaultTransport) && this.numberOfTickets == multiRideCardResponseDTO.numberOfTickets && Intrinsics.areEqual(this.customerId, multiRideCardResponseDTO.customerId) && Intrinsics.areEqual(this.validUntil, multiRideCardResponseDTO.validUntil) && Intrinsics.areEqual(this.allowedRoundtripRouteIds, multiRideCardResponseDTO.allowedRoundtripRouteIds) && this.canRefill == multiRideCardResponseDTO.canRefill && Intrinsics.areEqual(this.ticketExpiration, multiRideCardResponseDTO.ticketExpiration) && this.ticketExpiringCount == multiRideCardResponseDTO.ticketExpiringCount;
    }

    public final List<String> getAllowedRoundtripRouteIds() {
        return this.allowedRoundtripRouteIds;
    }

    public final boolean getCanRefill() {
        return this.canRefill;
    }

    public final String getCardNumber() {
        return this.cardNumber;
    }

    public final String getCardType() {
        return this.cardType;
    }

    public final MultiRideTicketCategoryResponseDTO getCategory() {
        return this.category;
    }

    public final String getCustomerId() {
        return this.customerId;
    }

    public final MultiRideTransportDTO getDefaultTransport() {
        return this.defaultTransport;
    }

    public final List<MultiRideTransportDTO> getEnabledTransports() {
        return this.enabledTransports;
    }

    public final int getNumberOfTickets() {
        return this.numberOfTickets;
    }

    public final Duration getTicketExpiration() {
        return this.ticketExpiration;
    }

    public final int getTicketExpiringCount() {
        return this.ticketExpiringCount;
    }

    public final LocalDate getValidUntil() {
        return this.validUntil;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((this.cardNumber.hashCode() * 31) + this.cardType.hashCode()) * 31) + this.category.hashCode()) * 31) + this.enabledTransports.hashCode()) * 31) + this.defaultTransport.hashCode()) * 31) + Integer.hashCode(this.numberOfTickets)) * 31) + this.customerId.hashCode()) * 31) + this.validUntil.hashCode()) * 31) + this.allowedRoundtripRouteIds.hashCode()) * 31) + Boolean.hashCode(this.canRefill)) * 31;
        Duration duration = this.ticketExpiration;
        return ((hashCode + (duration == null ? 0 : duration.hashCode())) * 31) + Integer.hashCode(this.ticketExpiringCount);
    }

    public String toString() {
        return "MultiRideCardResponseDTO(cardNumber=" + this.cardNumber + ", cardType=" + this.cardType + ", category=" + this.category + ", enabledTransports=" + this.enabledTransports + ", defaultTransport=" + this.defaultTransport + ", numberOfTickets=" + this.numberOfTickets + ", customerId=" + this.customerId + ", validUntil=" + this.validUntil + ", allowedRoundtripRouteIds=" + this.allowedRoundtripRouteIds + ", canRefill=" + this.canRefill + ", ticketExpiration=" + this.ticketExpiration + ", ticketExpiringCount=" + this.ticketExpiringCount + ")";
    }

    public MultiRideCardResponseDTO(String cardNumber, String cardType, MultiRideTicketCategoryResponseDTO category, List<MultiRideTransportDTO> enabledTransports, MultiRideTransportDTO defaultTransport, int i5, String customerId, LocalDate validUntil, List<String> allowedRoundtripRouteIds, boolean z5, Duration duration, int i6) {
        Intrinsics.checkNotNullParameter(cardNumber, "cardNumber");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(enabledTransports, "enabledTransports");
        Intrinsics.checkNotNullParameter(defaultTransport, "defaultTransport");
        Intrinsics.checkNotNullParameter(customerId, "customerId");
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        Intrinsics.checkNotNullParameter(allowedRoundtripRouteIds, "allowedRoundtripRouteIds");
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.category = category;
        this.enabledTransports = enabledTransports;
        this.defaultTransport = defaultTransport;
        this.numberOfTickets = i5;
        this.customerId = customerId;
        this.validUntil = validUntil;
        this.allowedRoundtripRouteIds = allowedRoundtripRouteIds;
        this.canRefill = z5;
        this.ticketExpiration = duration;
        this.ticketExpiringCount = i6;
    }
}
