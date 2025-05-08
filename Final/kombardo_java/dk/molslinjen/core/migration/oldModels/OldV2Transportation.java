package dk.molslinjen.core.migration.oldModels;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.domain.model.config.PassengerEntryType;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Deprecated
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b&\b\u0087\b\u0018\u0000 J2\u00020\u0001:\u0002KJBË\u0001\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J'\u0010)\u001a\u00020&2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010*\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b,\u0010-J\u001a\u0010/\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b/\u00100R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u00101\u001a\u0004\b2\u00103R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u00104\u001a\u0004\b5\u00106R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u00104\u001a\u0004\b7\u00106R\u0017\u0010\n\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\n\u00104\u001a\u0004\b8\u00106R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u00109\u001a\u0004\b:\u0010+R\u0017\u0010\f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u00109\u001a\u0004\b;\u0010+R\u0017\u0010\r\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\r\u00104\u001a\u0004\b\r\u00106R\u0017\u0010\u000e\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u00104\u001a\u0004\b\u000e\u00106R\u0017\u0010\u000f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000f\u00104\u001a\u0004\b\u000f\u00106R\u0017\u0010\u0010\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0010\u00104\u001a\u0004\b\u0010\u00106R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010<\u001a\u0004\b=\u0010>R\u0017\u0010\u0013\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010<\u001a\u0004\b?\u0010>R\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010@\u001a\u0004\bA\u0010-R\u0017\u0010\u0015\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0015\u0010<\u001a\u0004\bB\u0010>R\u0017\u0010\u0016\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0016\u00109\u001a\u0004\bC\u0010+R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010\u0019\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0019\u00104\u001a\u0004\bG\u00106R\u0017\u0010\u001a\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001a\u00104\u001a\u0004\bH\u00106R\u0017\u0010\u001b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001b\u00104\u001a\u0004\bI\u00106R\u0017\u0010\u001c\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001c\u00104\u001a\u0004\b\u001c\u00106¨\u0006L"}, d2 = {"Ldk/molslinjen/core/migration/oldModels/OldV2Transportation;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "seen0", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "allowedRouteIds", BuildConfig.FLAVOR, "adultRequired", "adultRequiredForInfants", "allowLicensePlate", "imageUrl", Constants.ID_ATTRIBUTE_KEY, "isEarlyCheckInAllowed", "isFreightPossible", "isWalking", "isOnlyAvailableWithReturnTicket", BuildConfig.FLAVOR, "maxHeight", "maxLength", "maxPassengers", "maxWeight", "name", "Ldk/molslinjen/domain/model/config/PassengerEntryType;", "passengerEntryType", "personDataOnlyForChauffeur", "licensePlateRequired", "trailerAllowed", "isTura", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILjava/util/List;ZZZLjava/lang/String;Ljava/lang/String;ZZZZDDIDLjava/lang/String;Ldk/molslinjen/domain/model/config/PassengerEntryType;ZZZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", BuildConfig.FLAVOR, "write$Self$app_kombardoProd", "(Ldk/molslinjen/core/migration/oldModels/OldV2Transportation;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getAllowedRouteIds", "()Ljava/util/List;", "Z", "getAdultRequired", "()Z", "getAdultRequiredForInfants", "getAllowLicensePlate", "Ljava/lang/String;", "getImageUrl", "getId", "D", "getMaxHeight", "()D", "getMaxLength", "I", "getMaxPassengers", "getMaxWeight", "getName", "Ldk/molslinjen/domain/model/config/PassengerEntryType;", "getPassengerEntryType", "()Ldk/molslinjen/domain/model/config/PassengerEntryType;", "getPersonDataOnlyForChauffeur", "getLicensePlateRequired", "getTrailerAllowed", "Companion", "$serializer", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class OldV2Transportation {
    private final boolean adultRequired;
    private final boolean adultRequiredForInfants;
    private final boolean allowLicensePlate;
    private final List<String> allowedRouteIds;
    private final String id;
    private final String imageUrl;
    private final boolean isEarlyCheckInAllowed;
    private final boolean isFreightPossible;
    private final boolean isOnlyAvailableWithReturnTicket;
    private final boolean isTura;
    private final boolean isWalking;
    private final boolean licensePlateRequired;
    private final double maxHeight;
    private final double maxLength;
    private final int maxPassengers;
    private final double maxWeight;
    private final String name;
    private final PassengerEntryType passengerEntryType;
    private final boolean personDataOnlyForChauffeur;
    private final boolean trailerAllowed;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null, null, null, null, null, null, null, null, null, null, null, null, EnumsKt.createSimpleEnumSerializer("dk.molslinjen.domain.model.config.PassengerEntryType", PassengerEntryType.values()), null, null, null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/core/migration/oldModels/OldV2Transportation$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/core/migration/oldModels/OldV2Transportation;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<OldV2Transportation> serializer() {
            return OldV2Transportation$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ OldV2Transportation(int i5, List list, boolean z5, boolean z6, boolean z7, String str, String str2, boolean z8, boolean z9, boolean z10, boolean z11, double d5, double d6, int i6, double d7, String str3, PassengerEntryType passengerEntryType, boolean z12, boolean z13, boolean z14, boolean z15, SerializationConstructorMarker serializationConstructorMarker) {
        if (1048575 != (i5 & 1048575)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 1048575, OldV2Transportation$$serializer.INSTANCE.getDescriptor());
        }
        this.allowedRouteIds = list;
        this.adultRequired = z5;
        this.adultRequiredForInfants = z6;
        this.allowLicensePlate = z7;
        this.imageUrl = str;
        this.id = str2;
        this.isEarlyCheckInAllowed = z8;
        this.isFreightPossible = z9;
        this.isWalking = z10;
        this.isOnlyAvailableWithReturnTicket = z11;
        this.maxHeight = d5;
        this.maxLength = d6;
        this.maxPassengers = i6;
        this.maxWeight = d7;
        this.name = str3;
        this.passengerEntryType = passengerEntryType;
        this.personDataOnlyForChauffeur = z12;
        this.licensePlateRequired = z13;
        this.trailerAllowed = z14;
        this.isTura = z15;
    }

    public static final /* synthetic */ void write$Self$app_kombardoProd(OldV2Transportation self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.allowedRouteIds);
        output.encodeBooleanElement(serialDesc, 1, self.adultRequired);
        output.encodeBooleanElement(serialDesc, 2, self.adultRequiredForInfants);
        output.encodeBooleanElement(serialDesc, 3, self.allowLicensePlate);
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.imageUrl);
        output.encodeStringElement(serialDesc, 5, self.id);
        output.encodeBooleanElement(serialDesc, 6, self.isEarlyCheckInAllowed);
        output.encodeBooleanElement(serialDesc, 7, self.isFreightPossible);
        output.encodeBooleanElement(serialDesc, 8, self.isWalking);
        output.encodeBooleanElement(serialDesc, 9, self.isOnlyAvailableWithReturnTicket);
        output.encodeDoubleElement(serialDesc, 10, self.maxHeight);
        output.encodeDoubleElement(serialDesc, 11, self.maxLength);
        output.encodeIntElement(serialDesc, 12, self.maxPassengers);
        output.encodeDoubleElement(serialDesc, 13, self.maxWeight);
        output.encodeStringElement(serialDesc, 14, self.name);
        output.encodeSerializableElement(serialDesc, 15, kSerializerArr[15], self.passengerEntryType);
        output.encodeBooleanElement(serialDesc, 16, self.personDataOnlyForChauffeur);
        output.encodeBooleanElement(serialDesc, 17, self.licensePlateRequired);
        output.encodeBooleanElement(serialDesc, 18, self.trailerAllowed);
        output.encodeBooleanElement(serialDesc, 19, self.isTura);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OldV2Transportation)) {
            return false;
        }
        OldV2Transportation oldV2Transportation = (OldV2Transportation) other;
        return Intrinsics.areEqual(this.allowedRouteIds, oldV2Transportation.allowedRouteIds) && this.adultRequired == oldV2Transportation.adultRequired && this.adultRequiredForInfants == oldV2Transportation.adultRequiredForInfants && this.allowLicensePlate == oldV2Transportation.allowLicensePlate && Intrinsics.areEqual(this.imageUrl, oldV2Transportation.imageUrl) && Intrinsics.areEqual(this.id, oldV2Transportation.id) && this.isEarlyCheckInAllowed == oldV2Transportation.isEarlyCheckInAllowed && this.isFreightPossible == oldV2Transportation.isFreightPossible && this.isWalking == oldV2Transportation.isWalking && this.isOnlyAvailableWithReturnTicket == oldV2Transportation.isOnlyAvailableWithReturnTicket && Double.compare(this.maxHeight, oldV2Transportation.maxHeight) == 0 && Double.compare(this.maxLength, oldV2Transportation.maxLength) == 0 && this.maxPassengers == oldV2Transportation.maxPassengers && Double.compare(this.maxWeight, oldV2Transportation.maxWeight) == 0 && Intrinsics.areEqual(this.name, oldV2Transportation.name) && this.passengerEntryType == oldV2Transportation.passengerEntryType && this.personDataOnlyForChauffeur == oldV2Transportation.personDataOnlyForChauffeur && this.licensePlateRequired == oldV2Transportation.licensePlateRequired && this.trailerAllowed == oldV2Transportation.trailerAllowed && this.isTura == oldV2Transportation.isTura;
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

    public final PassengerEntryType getPassengerEntryType() {
        return this.passengerEntryType;
    }

    public final boolean getPersonDataOnlyForChauffeur() {
        return this.personDataOnlyForChauffeur;
    }

    public final boolean getTrailerAllowed() {
        return this.trailerAllowed;
    }

    public int hashCode() {
        int hashCode = ((((((this.allowedRouteIds.hashCode() * 31) + Boolean.hashCode(this.adultRequired)) * 31) + Boolean.hashCode(this.adultRequiredForInfants)) * 31) + Boolean.hashCode(this.allowLicensePlate)) * 31;
        String str = this.imageUrl;
        return ((((((((((((((((((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.id.hashCode()) * 31) + Boolean.hashCode(this.isEarlyCheckInAllowed)) * 31) + Boolean.hashCode(this.isFreightPossible)) * 31) + Boolean.hashCode(this.isWalking)) * 31) + Boolean.hashCode(this.isOnlyAvailableWithReturnTicket)) * 31) + Double.hashCode(this.maxHeight)) * 31) + Double.hashCode(this.maxLength)) * 31) + Integer.hashCode(this.maxPassengers)) * 31) + Double.hashCode(this.maxWeight)) * 31) + this.name.hashCode()) * 31) + this.passengerEntryType.hashCode()) * 31) + Boolean.hashCode(this.personDataOnlyForChauffeur)) * 31) + Boolean.hashCode(this.licensePlateRequired)) * 31) + Boolean.hashCode(this.trailerAllowed)) * 31) + Boolean.hashCode(this.isTura);
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

    /* renamed from: isTura, reason: from getter */
    public final boolean getIsTura() {
        return this.isTura;
    }

    /* renamed from: isWalking, reason: from getter */
    public final boolean getIsWalking() {
        return this.isWalking;
    }

    public String toString() {
        return "OldV2Transportation(allowedRouteIds=" + this.allowedRouteIds + ", adultRequired=" + this.adultRequired + ", adultRequiredForInfants=" + this.adultRequiredForInfants + ", allowLicensePlate=" + this.allowLicensePlate + ", imageUrl=" + this.imageUrl + ", id=" + this.id + ", isEarlyCheckInAllowed=" + this.isEarlyCheckInAllowed + ", isFreightPossible=" + this.isFreightPossible + ", isWalking=" + this.isWalking + ", isOnlyAvailableWithReturnTicket=" + this.isOnlyAvailableWithReturnTicket + ", maxHeight=" + this.maxHeight + ", maxLength=" + this.maxLength + ", maxPassengers=" + this.maxPassengers + ", maxWeight=" + this.maxWeight + ", name=" + this.name + ", passengerEntryType=" + this.passengerEntryType + ", personDataOnlyForChauffeur=" + this.personDataOnlyForChauffeur + ", licensePlateRequired=" + this.licensePlateRequired + ", trailerAllowed=" + this.trailerAllowed + ", isTura=" + this.isTura + ")";
    }
}
