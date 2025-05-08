package dk.molslinjen.api.shared.response;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
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

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b(\b\u0087\b\u0018\u0000 K2\u00020\u0001:\u0002LKBÃ\u0001\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010(\u001a\u00020%2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010)\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010.\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b.\u0010/R&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0006\u00100\u0012\u0004\b3\u00104\u001a\u0004\b1\u00102R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u00105\u001a\u0004\b6\u00107R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u00105\u001a\u0004\b8\u00107R\u0017\u0010\n\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\n\u00105\u001a\u0004\b9\u00107R\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000b\u00105\u001a\u0004\b:\u00107R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010;\u001a\u0004\b<\u0010*R\u0017\u0010\r\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010;\u001a\u0004\b=\u0010*R\u0017\u0010\u000e\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u00105\u001a\u0004\b\u000e\u00107R\u0017\u0010\u000f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000f\u00105\u001a\u0004\b\u000f\u00107R\u0017\u0010\u0010\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0010\u00105\u001a\u0004\b\u0010\u00107R\u0017\u0010\u0011\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0011\u00105\u001a\u0004\b\u0011\u00107R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010>\u001a\u0004\b?\u0010@R\u0017\u0010\u0014\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0014\u0010>\u001a\u0004\bA\u0010@R\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010B\u001a\u0004\bC\u0010,R\u0017\u0010\u0016\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0016\u0010>\u001a\u0004\bD\u0010@R\u0017\u0010\u0017\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0017\u0010;\u001a\u0004\bE\u0010*R\u0017\u0010\u0019\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010F\u001a\u0004\bG\u0010HR\u0017\u0010\u001a\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001a\u00105\u001a\u0004\bI\u00107R\u0017\u0010\u001b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001b\u00105\u001a\u0004\bJ\u00107¨\u0006M"}, d2 = {"Ldk/molslinjen/api/shared/response/TransportResponseDTO;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "seen0", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "allowedRouteIds", BuildConfig.FLAVOR, "adultRequired", "adultRequiredForInfants", "allowLicensePlate", "licensePlateRequired", "imageUrl", Constants.ID_ATTRIBUTE_KEY, "isEarlyCheckInAllowed", "isFreightPossible", "isWalking", "isOnlyAvailableWithReturnTicket", BuildConfig.FLAVOR, "maxHeight", "maxLength", "maxPassengers", "maxWeight", "name", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$PassengerEntryTypeDTO;", "passengerEntryType", "personDataOnlyForChauffeur", "trailerAllowed", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILjava/util/List;ZZZZLjava/lang/String;Ljava/lang/String;ZZZZDDIDLjava/lang/String;Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$PassengerEntryTypeDTO;ZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", BuildConfig.FLAVOR, "write$Self$api_kombardoProd", "(Ldk/molslinjen/api/shared/response/TransportResponseDTO;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getAllowedRouteIds", "()Ljava/util/List;", "getAllowedRouteIds$annotations", "()V", "Z", "getAdultRequired", "()Z", "getAdultRequiredForInfants", "getAllowLicensePlate", "getLicensePlateRequired", "Ljava/lang/String;", "getImageUrl", "getId", "D", "getMaxHeight", "()D", "getMaxLength", "I", "getMaxPassengers", "getMaxWeight", "getName", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$PassengerEntryTypeDTO;", "getPassengerEntryType", "()Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$PassengerEntryTypeDTO;", "getPersonDataOnlyForChauffeur", "getTrailerAllowed", "Companion", "$serializer", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class TransportResponseDTO {
    private final boolean adultRequired;
    private final boolean adultRequiredForInfants;
    private final boolean allowLicensePlate;
    private final List<String> allowedRouteIds;
    private final String id;
    private final String imageUrl;
    private final boolean isEarlyCheckInAllowed;
    private final boolean isFreightPossible;
    private final boolean isOnlyAvailableWithReturnTicket;
    private final boolean isWalking;
    private final boolean licensePlateRequired;
    private final double maxHeight;
    private final double maxLength;
    private final int maxPassengers;
    private final double maxWeight;
    private final String name;
    private final ConfigurationResponseDTO.PassengerEntryTypeDTO passengerEntryType;
    private final boolean personDataOnlyForChauffeur;
    private final boolean trailerAllowed;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/shared/response/TransportResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/shared/response/TransportResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<TransportResponseDTO> serializer() {
            return TransportResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ TransportResponseDTO(int i5, List list, boolean z5, boolean z6, boolean z7, boolean z8, String str, String str2, boolean z9, boolean z10, boolean z11, boolean z12, double d5, double d6, int i6, double d7, String str3, ConfigurationResponseDTO.PassengerEntryTypeDTO passengerEntryTypeDTO, boolean z13, boolean z14, SerializationConstructorMarker serializationConstructorMarker) {
        if (524287 != (i5 & 524287)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 524287, TransportResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.allowedRouteIds = list;
        this.adultRequired = z5;
        this.adultRequiredForInfants = z6;
        this.allowLicensePlate = z7;
        this.licensePlateRequired = z8;
        this.imageUrl = str;
        this.id = str2;
        this.isEarlyCheckInAllowed = z9;
        this.isFreightPossible = z10;
        this.isWalking = z11;
        this.isOnlyAvailableWithReturnTicket = z12;
        this.maxHeight = d5;
        this.maxLength = d6;
        this.maxPassengers = i6;
        this.maxWeight = d7;
        this.name = str3;
        this.passengerEntryType = passengerEntryTypeDTO;
        this.personDataOnlyForChauffeur = z13;
        this.trailerAllowed = z14;
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(TransportResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.allowedRouteIds);
        output.encodeBooleanElement(serialDesc, 1, self.adultRequired);
        output.encodeBooleanElement(serialDesc, 2, self.adultRequiredForInfants);
        output.encodeBooleanElement(serialDesc, 3, self.allowLicensePlate);
        output.encodeBooleanElement(serialDesc, 4, self.licensePlateRequired);
        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.imageUrl);
        output.encodeStringElement(serialDesc, 6, self.id);
        output.encodeBooleanElement(serialDesc, 7, self.isEarlyCheckInAllowed);
        output.encodeBooleanElement(serialDesc, 8, self.isFreightPossible);
        output.encodeBooleanElement(serialDesc, 9, self.isWalking);
        output.encodeBooleanElement(serialDesc, 10, self.isOnlyAvailableWithReturnTicket);
        output.encodeDoubleElement(serialDesc, 11, self.maxHeight);
        output.encodeDoubleElement(serialDesc, 12, self.maxLength);
        output.encodeIntElement(serialDesc, 13, self.maxPassengers);
        output.encodeDoubleElement(serialDesc, 14, self.maxWeight);
        output.encodeStringElement(serialDesc, 15, self.name);
        output.encodeSerializableElement(serialDesc, 16, ConfigurationResponseDTO.PassengerEntryTypeDTO.Serializer.INSTANCE, self.passengerEntryType);
        output.encodeBooleanElement(serialDesc, 17, self.personDataOnlyForChauffeur);
        output.encodeBooleanElement(serialDesc, 18, self.trailerAllowed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransportResponseDTO)) {
            return false;
        }
        TransportResponseDTO transportResponseDTO = (TransportResponseDTO) other;
        return Intrinsics.areEqual(this.allowedRouteIds, transportResponseDTO.allowedRouteIds) && this.adultRequired == transportResponseDTO.adultRequired && this.adultRequiredForInfants == transportResponseDTO.adultRequiredForInfants && this.allowLicensePlate == transportResponseDTO.allowLicensePlate && this.licensePlateRequired == transportResponseDTO.licensePlateRequired && Intrinsics.areEqual(this.imageUrl, transportResponseDTO.imageUrl) && Intrinsics.areEqual(this.id, transportResponseDTO.id) && this.isEarlyCheckInAllowed == transportResponseDTO.isEarlyCheckInAllowed && this.isFreightPossible == transportResponseDTO.isFreightPossible && this.isWalking == transportResponseDTO.isWalking && this.isOnlyAvailableWithReturnTicket == transportResponseDTO.isOnlyAvailableWithReturnTicket && Double.compare(this.maxHeight, transportResponseDTO.maxHeight) == 0 && Double.compare(this.maxLength, transportResponseDTO.maxLength) == 0 && this.maxPassengers == transportResponseDTO.maxPassengers && Double.compare(this.maxWeight, transportResponseDTO.maxWeight) == 0 && Intrinsics.areEqual(this.name, transportResponseDTO.name) && this.passengerEntryType == transportResponseDTO.passengerEntryType && this.personDataOnlyForChauffeur == transportResponseDTO.personDataOnlyForChauffeur && this.trailerAllowed == transportResponseDTO.trailerAllowed;
    }

    public final boolean getAdultRequired() {
        return this.adultRequired;
    }

    public final boolean getAdultRequiredForInfants() {
        return this.adultRequiredForInfants;
    }

    public final boolean getAllowLicensePlate() {
        return this.allowLicensePlate;
    }

    public final List<String> getAllowedRouteIds() {
        return this.allowedRouteIds;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final boolean getLicensePlateRequired() {
        return this.licensePlateRequired;
    }

    public final double getMaxHeight() {
        return this.maxHeight;
    }

    public final double getMaxLength() {
        return this.maxLength;
    }

    public final int getMaxPassengers() {
        return this.maxPassengers;
    }

    public final double getMaxWeight() {
        return this.maxWeight;
    }

    public final String getName() {
        return this.name;
    }

    public final ConfigurationResponseDTO.PassengerEntryTypeDTO getPassengerEntryType() {
        return this.passengerEntryType;
    }

    public final boolean getPersonDataOnlyForChauffeur() {
        return this.personDataOnlyForChauffeur;
    }

    public final boolean getTrailerAllowed() {
        return this.trailerAllowed;
    }

    public int hashCode() {
        int hashCode = ((((((((this.allowedRouteIds.hashCode() * 31) + Boolean.hashCode(this.adultRequired)) * 31) + Boolean.hashCode(this.adultRequiredForInfants)) * 31) + Boolean.hashCode(this.allowLicensePlate)) * 31) + Boolean.hashCode(this.licensePlateRequired)) * 31;
        String str = this.imageUrl;
        return ((((((((((((((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.id.hashCode()) * 31) + Boolean.hashCode(this.isEarlyCheckInAllowed)) * 31) + Boolean.hashCode(this.isFreightPossible)) * 31) + Boolean.hashCode(this.isWalking)) * 31) + Boolean.hashCode(this.isOnlyAvailableWithReturnTicket)) * 31) + Double.hashCode(this.maxHeight)) * 31) + Double.hashCode(this.maxLength)) * 31) + Integer.hashCode(this.maxPassengers)) * 31) + Double.hashCode(this.maxWeight)) * 31) + this.name.hashCode()) * 31) + this.passengerEntryType.hashCode()) * 31) + Boolean.hashCode(this.personDataOnlyForChauffeur)) * 31) + Boolean.hashCode(this.trailerAllowed);
    }

    /* renamed from: isEarlyCheckInAllowed, reason: from getter */
    public final boolean getIsEarlyCheckInAllowed() {
        return this.isEarlyCheckInAllowed;
    }

    /* renamed from: isFreightPossible, reason: from getter */
    public final boolean getIsFreightPossible() {
        return this.isFreightPossible;
    }

    /* renamed from: isOnlyAvailableWithReturnTicket, reason: from getter */
    public final boolean getIsOnlyAvailableWithReturnTicket() {
        return this.isOnlyAvailableWithReturnTicket;
    }

    /* renamed from: isWalking, reason: from getter */
    public final boolean getIsWalking() {
        return this.isWalking;
    }

    public String toString() {
        return "TransportResponseDTO(allowedRouteIds=" + this.allowedRouteIds + ", adultRequired=" + this.adultRequired + ", adultRequiredForInfants=" + this.adultRequiredForInfants + ", allowLicensePlate=" + this.allowLicensePlate + ", licensePlateRequired=" + this.licensePlateRequired + ", imageUrl=" + this.imageUrl + ", id=" + this.id + ", isEarlyCheckInAllowed=" + this.isEarlyCheckInAllowed + ", isFreightPossible=" + this.isFreightPossible + ", isWalking=" + this.isWalking + ", isOnlyAvailableWithReturnTicket=" + this.isOnlyAvailableWithReturnTicket + ", maxHeight=" + this.maxHeight + ", maxLength=" + this.maxLength + ", maxPassengers=" + this.maxPassengers + ", maxWeight=" + this.maxWeight + ", name=" + this.name + ", passengerEntryType=" + this.passengerEntryType + ", personDataOnlyForChauffeur=" + this.personDataOnlyForChauffeur + ", trailerAllowed=" + this.trailerAllowed + ")";
    }
}
