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

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Q2\u00020\u0001:\u0002PQB\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018B\u00ad\u0001\b\u0010\u0012\u0006\u0010\u0019\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0017\u0010\u001cJ\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010;\u001a\u00020\nHÆ\u0003J\t\u0010<\u001a\u00020\rHÆ\u0003J\t\u0010=\u001a\u00020\u000fHÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u0010@\u001a\u00020\u0013HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010B\u001a\u00020\rHÆ\u0003J£\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\rHÆ\u0001J\u0013\u0010D\u001a\u00020\u000f2\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010F\u001a\u00020\rHÖ\u0001J\t\u0010G\u001a\u00020\u0003HÖ\u0001J%\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0001¢\u0006\u0002\bOR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u001c\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010.\u001a\u0004\b2\u00103R\u0011\u0010\u0016\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b4\u0010(¨\u0006R"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/AccountMultiRideResponseDTO;", BuildConfig.FLAVOR, "agreementNumber", BuildConfig.FLAVOR, "agreementType", "multiRideTypeId", "ticketTypeName", "ticketTypeId", "enabledTransports", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/multiRide/response/MultiRideTransportDTO;", "defaultTransport", "remainingTrips", BuildConfig.FLAVOR, "canRefill", BuildConfig.FLAVOR, "customer", "allowedRoundtripRouteIds", "validUntil", "Lorg/threeten/bp/LocalDate;", "ticketExpiration", "Lorg/threeten/bp/Duration;", "ticketExpiringCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ldk/molslinjen/api/services/multiRide/response/MultiRideTransportDTO;IZLjava/lang/String;Ljava/util/List;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/Duration;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ldk/molslinjen/api/services/multiRide/response/MultiRideTransportDTO;IZLjava/lang/String;Ljava/util/List;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/Duration;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAgreementNumber", "()Ljava/lang/String;", "getAgreementType", "getMultiRideTypeId", "getTicketTypeName", "getTicketTypeId", "getEnabledTransports", "()Ljava/util/List;", "getDefaultTransport", "()Ldk/molslinjen/api/services/multiRide/response/MultiRideTransportDTO;", "getRemainingTrips", "()I", "getCanRefill", "()Z", "getCustomer", "getAllowedRoundtripRouteIds", "getValidUntil$annotations", "()V", "getValidUntil", "()Lorg/threeten/bp/LocalDate;", "getTicketExpiration$annotations", "getTicketExpiration", "()Lorg/threeten/bp/Duration;", "getTicketExpiringCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class AccountMultiRideResponseDTO {
    private final String agreementNumber;
    private final String agreementType;
    private final List<String> allowedRoundtripRouteIds;
    private final boolean canRefill;
    private final String customer;
    private final MultiRideTransportDTO defaultTransport;
    private final List<MultiRideTransportDTO> enabledTransports;
    private final String multiRideTypeId;
    private final int remainingTrips;
    private final Duration ticketExpiration;
    private final int ticketExpiringCount;
    private final String ticketTypeId;
    private final String ticketTypeName;
    private final LocalDate validUntil;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, new ArrayListSerializer(MultiRideTransportDTO$$serializer.INSTANCE), null, null, null, null, new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/AccountMultiRideResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/multiRide/response/AccountMultiRideResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<AccountMultiRideResponseDTO> serializer() {
            return AccountMultiRideResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ AccountMultiRideResponseDTO(int i5, String str, String str2, String str3, String str4, String str5, List list, MultiRideTransportDTO multiRideTransportDTO, int i6, boolean z5, String str6, List list2, LocalDate localDate, Duration duration, int i7, SerializationConstructorMarker serializationConstructorMarker) {
        if (16383 != (i5 & 16383)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 16383, AccountMultiRideResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.agreementNumber = str;
        this.agreementType = str2;
        this.multiRideTypeId = str3;
        this.ticketTypeName = str4;
        this.ticketTypeId = str5;
        this.enabledTransports = list;
        this.defaultTransport = multiRideTransportDTO;
        this.remainingTrips = i6;
        this.canRefill = z5;
        this.customer = str6;
        this.allowedRoundtripRouteIds = list2;
        this.validUntil = localDate;
        this.ticketExpiration = duration;
        this.ticketExpiringCount = i7;
    }

    @Serializable(with = DurationSerializer.class)
    public static /* synthetic */ void getTicketExpiration$annotations() {
    }

    @Serializable(with = LocalDateWithTimeSerializer.class)
    public static /* synthetic */ void getValidUntil$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(AccountMultiRideResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.agreementNumber);
        output.encodeStringElement(serialDesc, 1, self.agreementType);
        output.encodeStringElement(serialDesc, 2, self.multiRideTypeId);
        output.encodeStringElement(serialDesc, 3, self.ticketTypeName);
        output.encodeStringElement(serialDesc, 4, self.ticketTypeId);
        output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.enabledTransports);
        output.encodeSerializableElement(serialDesc, 6, MultiRideTransportDTO$$serializer.INSTANCE, self.defaultTransport);
        output.encodeIntElement(serialDesc, 7, self.remainingTrips);
        output.encodeBooleanElement(serialDesc, 8, self.canRefill);
        output.encodeStringElement(serialDesc, 9, self.customer);
        output.encodeSerializableElement(serialDesc, 10, kSerializerArr[10], self.allowedRoundtripRouteIds);
        output.encodeSerializableElement(serialDesc, 11, LocalDateWithTimeSerializer.INSTANCE, self.validUntil);
        output.encodeNullableSerializableElement(serialDesc, 12, DurationSerializer.INSTANCE, self.ticketExpiration);
        output.encodeIntElement(serialDesc, 13, self.ticketExpiringCount);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAgreementNumber() {
        return this.agreementNumber;
    }

    /* renamed from: component10, reason: from getter */
    public final String getCustomer() {
        return this.customer;
    }

    public final List<String> component11() {
        return this.allowedRoundtripRouteIds;
    }

    /* renamed from: component12, reason: from getter */
    public final LocalDate getValidUntil() {
        return this.validUntil;
    }

    /* renamed from: component13, reason: from getter */
    public final Duration getTicketExpiration() {
        return this.ticketExpiration;
    }

    /* renamed from: component14, reason: from getter */
    public final int getTicketExpiringCount() {
        return this.ticketExpiringCount;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAgreementType() {
        return this.agreementType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMultiRideTypeId() {
        return this.multiRideTypeId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTicketTypeName() {
        return this.ticketTypeName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTicketTypeId() {
        return this.ticketTypeId;
    }

    public final List<MultiRideTransportDTO> component6() {
        return this.enabledTransports;
    }

    /* renamed from: component7, reason: from getter */
    public final MultiRideTransportDTO getDefaultTransport() {
        return this.defaultTransport;
    }

    /* renamed from: component8, reason: from getter */
    public final int getRemainingTrips() {
        return this.remainingTrips;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getCanRefill() {
        return this.canRefill;
    }

    public final AccountMultiRideResponseDTO copy(String agreementNumber, String agreementType, String multiRideTypeId, String ticketTypeName, String ticketTypeId, List<MultiRideTransportDTO> enabledTransports, MultiRideTransportDTO defaultTransport, int remainingTrips, boolean canRefill, String customer, List<String> allowedRoundtripRouteIds, LocalDate validUntil, Duration ticketExpiration, int ticketExpiringCount) {
        Intrinsics.checkNotNullParameter(agreementNumber, "agreementNumber");
        Intrinsics.checkNotNullParameter(agreementType, "agreementType");
        Intrinsics.checkNotNullParameter(multiRideTypeId, "multiRideTypeId");
        Intrinsics.checkNotNullParameter(ticketTypeName, "ticketTypeName");
        Intrinsics.checkNotNullParameter(ticketTypeId, "ticketTypeId");
        Intrinsics.checkNotNullParameter(enabledTransports, "enabledTransports");
        Intrinsics.checkNotNullParameter(defaultTransport, "defaultTransport");
        Intrinsics.checkNotNullParameter(customer, "customer");
        Intrinsics.checkNotNullParameter(allowedRoundtripRouteIds, "allowedRoundtripRouteIds");
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        return new AccountMultiRideResponseDTO(agreementNumber, agreementType, multiRideTypeId, ticketTypeName, ticketTypeId, enabledTransports, defaultTransport, remainingTrips, canRefill, customer, allowedRoundtripRouteIds, validUntil, ticketExpiration, ticketExpiringCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccountMultiRideResponseDTO)) {
            return false;
        }
        AccountMultiRideResponseDTO accountMultiRideResponseDTO = (AccountMultiRideResponseDTO) other;
        return Intrinsics.areEqual(this.agreementNumber, accountMultiRideResponseDTO.agreementNumber) && Intrinsics.areEqual(this.agreementType, accountMultiRideResponseDTO.agreementType) && Intrinsics.areEqual(this.multiRideTypeId, accountMultiRideResponseDTO.multiRideTypeId) && Intrinsics.areEqual(this.ticketTypeName, accountMultiRideResponseDTO.ticketTypeName) && Intrinsics.areEqual(this.ticketTypeId, accountMultiRideResponseDTO.ticketTypeId) && Intrinsics.areEqual(this.enabledTransports, accountMultiRideResponseDTO.enabledTransports) && Intrinsics.areEqual(this.defaultTransport, accountMultiRideResponseDTO.defaultTransport) && this.remainingTrips == accountMultiRideResponseDTO.remainingTrips && this.canRefill == accountMultiRideResponseDTO.canRefill && Intrinsics.areEqual(this.customer, accountMultiRideResponseDTO.customer) && Intrinsics.areEqual(this.allowedRoundtripRouteIds, accountMultiRideResponseDTO.allowedRoundtripRouteIds) && Intrinsics.areEqual(this.validUntil, accountMultiRideResponseDTO.validUntil) && Intrinsics.areEqual(this.ticketExpiration, accountMultiRideResponseDTO.ticketExpiration) && this.ticketExpiringCount == accountMultiRideResponseDTO.ticketExpiringCount;
    }

    public final String getAgreementNumber() {
        return this.agreementNumber;
    }

    public final String getAgreementType() {
        return this.agreementType;
    }

    public final List<String> getAllowedRoundtripRouteIds() {
        return this.allowedRoundtripRouteIds;
    }

    public final boolean getCanRefill() {
        return this.canRefill;
    }

    public final String getCustomer() {
        return this.customer;
    }

    public final MultiRideTransportDTO getDefaultTransport() {
        return this.defaultTransport;
    }

    public final List<MultiRideTransportDTO> getEnabledTransports() {
        return this.enabledTransports;
    }

    public final String getMultiRideTypeId() {
        return this.multiRideTypeId;
    }

    public final int getRemainingTrips() {
        return this.remainingTrips;
    }

    public final Duration getTicketExpiration() {
        return this.ticketExpiration;
    }

    public final int getTicketExpiringCount() {
        return this.ticketExpiringCount;
    }

    public final String getTicketTypeId() {
        return this.ticketTypeId;
    }

    public final String getTicketTypeName() {
        return this.ticketTypeName;
    }

    public final LocalDate getValidUntil() {
        return this.validUntil;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((this.agreementNumber.hashCode() * 31) + this.agreementType.hashCode()) * 31) + this.multiRideTypeId.hashCode()) * 31) + this.ticketTypeName.hashCode()) * 31) + this.ticketTypeId.hashCode()) * 31) + this.enabledTransports.hashCode()) * 31) + this.defaultTransport.hashCode()) * 31) + Integer.hashCode(this.remainingTrips)) * 31) + Boolean.hashCode(this.canRefill)) * 31) + this.customer.hashCode()) * 31) + this.allowedRoundtripRouteIds.hashCode()) * 31) + this.validUntil.hashCode()) * 31;
        Duration duration = this.ticketExpiration;
        return ((hashCode + (duration == null ? 0 : duration.hashCode())) * 31) + Integer.hashCode(this.ticketExpiringCount);
    }

    public String toString() {
        return "AccountMultiRideResponseDTO(agreementNumber=" + this.agreementNumber + ", agreementType=" + this.agreementType + ", multiRideTypeId=" + this.multiRideTypeId + ", ticketTypeName=" + this.ticketTypeName + ", ticketTypeId=" + this.ticketTypeId + ", enabledTransports=" + this.enabledTransports + ", defaultTransport=" + this.defaultTransport + ", remainingTrips=" + this.remainingTrips + ", canRefill=" + this.canRefill + ", customer=" + this.customer + ", allowedRoundtripRouteIds=" + this.allowedRoundtripRouteIds + ", validUntil=" + this.validUntil + ", ticketExpiration=" + this.ticketExpiration + ", ticketExpiringCount=" + this.ticketExpiringCount + ")";
    }

    public AccountMultiRideResponseDTO(String agreementNumber, String agreementType, String multiRideTypeId, String ticketTypeName, String ticketTypeId, List<MultiRideTransportDTO> enabledTransports, MultiRideTransportDTO defaultTransport, int i5, boolean z5, String customer, List<String> allowedRoundtripRouteIds, LocalDate validUntil, Duration duration, int i6) {
        Intrinsics.checkNotNullParameter(agreementNumber, "agreementNumber");
        Intrinsics.checkNotNullParameter(agreementType, "agreementType");
        Intrinsics.checkNotNullParameter(multiRideTypeId, "multiRideTypeId");
        Intrinsics.checkNotNullParameter(ticketTypeName, "ticketTypeName");
        Intrinsics.checkNotNullParameter(ticketTypeId, "ticketTypeId");
        Intrinsics.checkNotNullParameter(enabledTransports, "enabledTransports");
        Intrinsics.checkNotNullParameter(defaultTransport, "defaultTransport");
        Intrinsics.checkNotNullParameter(customer, "customer");
        Intrinsics.checkNotNullParameter(allowedRoundtripRouteIds, "allowedRoundtripRouteIds");
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        this.agreementNumber = agreementNumber;
        this.agreementType = agreementType;
        this.multiRideTypeId = multiRideTypeId;
        this.ticketTypeName = ticketTypeName;
        this.ticketTypeId = ticketTypeId;
        this.enabledTransports = enabledTransports;
        this.defaultTransport = defaultTransport;
        this.remainingTrips = i5;
        this.canRefill = z5;
        this.customer = customer;
        this.allowedRoundtripRouteIds = allowedRoundtripRouteIds;
        this.validUntil = validUntil;
        this.ticketExpiration = duration;
        this.ticketExpiringCount = i6;
    }
}
