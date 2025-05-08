package dk.molslinjen.api.services.booking.response.booking;

import dk.molslinjen.api.helpers.serializers.LocalTimeSerializer;
import dk.molslinjen.api.services.booking.response.booking.FerryTypeDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\u00020\u0001:\u000256BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rBa\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003J]\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u000fHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001J%\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\b4R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00067"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/FerryResponseDTO;", BuildConfig.FLAVOR, "ferryId", BuildConfig.FLAVOR, "arrivalTime", "Lorg/threeten/bp/LocalTime;", "departureTime", "departureHarbor", "arrivalHarbor", "ferryName", "ferryType", "Ldk/molslinjen/api/services/booking/response/booking/FerryTypeDTO;", "<init>", "(Ljava/lang/String;Lorg/threeten/bp/LocalTime;Lorg/threeten/bp/LocalTime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/booking/FerryTypeDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lorg/threeten/bp/LocalTime;Lorg/threeten/bp/LocalTime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/booking/FerryTypeDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFerryId", "()Ljava/lang/String;", "getArrivalTime$annotations", "()V", "getArrivalTime", "()Lorg/threeten/bp/LocalTime;", "getDepartureTime$annotations", "getDepartureTime", "getDepartureHarbor", "getArrivalHarbor", "getFerryName", "getFerryType", "()Ldk/molslinjen/api/services/booking/response/booking/FerryTypeDTO;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class FerryResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String arrivalHarbor;
    private final LocalTime arrivalTime;
    private final String departureHarbor;
    private final LocalTime departureTime;
    private final String ferryId;
    private final String ferryName;
    private final FerryTypeDTO ferryType;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/FerryResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/FerryResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<FerryResponseDTO> serializer() {
            return FerryResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ FerryResponseDTO(int i5, String str, LocalTime localTime, LocalTime localTime2, String str2, String str3, String str4, FerryTypeDTO ferryTypeDTO, SerializationConstructorMarker serializationConstructorMarker) {
        if (127 != (i5 & 127)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 127, FerryResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.ferryId = str;
        this.arrivalTime = localTime;
        this.departureTime = localTime2;
        this.departureHarbor = str2;
        this.arrivalHarbor = str3;
        this.ferryName = str4;
        this.ferryType = ferryTypeDTO;
    }

    public static /* synthetic */ FerryResponseDTO copy$default(FerryResponseDTO ferryResponseDTO, String str, LocalTime localTime, LocalTime localTime2, String str2, String str3, String str4, FerryTypeDTO ferryTypeDTO, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = ferryResponseDTO.ferryId;
        }
        if ((i5 & 2) != 0) {
            localTime = ferryResponseDTO.arrivalTime;
        }
        LocalTime localTime3 = localTime;
        if ((i5 & 4) != 0) {
            localTime2 = ferryResponseDTO.departureTime;
        }
        LocalTime localTime4 = localTime2;
        if ((i5 & 8) != 0) {
            str2 = ferryResponseDTO.departureHarbor;
        }
        String str5 = str2;
        if ((i5 & 16) != 0) {
            str3 = ferryResponseDTO.arrivalHarbor;
        }
        String str6 = str3;
        if ((i5 & 32) != 0) {
            str4 = ferryResponseDTO.ferryName;
        }
        String str7 = str4;
        if ((i5 & 64) != 0) {
            ferryTypeDTO = ferryResponseDTO.ferryType;
        }
        return ferryResponseDTO.copy(str, localTime3, localTime4, str5, str6, str7, ferryTypeDTO);
    }

    @Serializable(with = LocalTimeSerializer.class)
    public static /* synthetic */ void getArrivalTime$annotations() {
    }

    @Serializable(with = LocalTimeSerializer.class)
    public static /* synthetic */ void getDepartureTime$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(FerryResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.ferryId);
        LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 1, localTimeSerializer, self.arrivalTime);
        output.encodeNullableSerializableElement(serialDesc, 2, localTimeSerializer, self.departureTime);
        output.encodeNullableSerializableElement(serialDesc, 3, stringSerializer, self.departureHarbor);
        output.encodeNullableSerializableElement(serialDesc, 4, stringSerializer, self.arrivalHarbor);
        output.encodeNullableSerializableElement(serialDesc, 5, stringSerializer, self.ferryName);
        output.encodeNullableSerializableElement(serialDesc, 6, FerryTypeDTO.Serializer.INSTANCE, self.ferryType);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFerryId() {
        return this.ferryId;
    }

    /* renamed from: component2, reason: from getter */
    public final LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    /* renamed from: component3, reason: from getter */
    public final LocalTime getDepartureTime() {
        return this.departureTime;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDepartureHarbor() {
        return this.departureHarbor;
    }

    /* renamed from: component5, reason: from getter */
    public final String getArrivalHarbor() {
        return this.arrivalHarbor;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFerryName() {
        return this.ferryName;
    }

    /* renamed from: component7, reason: from getter */
    public final FerryTypeDTO getFerryType() {
        return this.ferryType;
    }

    public final FerryResponseDTO copy(String ferryId, LocalTime arrivalTime, LocalTime departureTime, String departureHarbor, String arrivalHarbor, String ferryName, FerryTypeDTO ferryType) {
        return new FerryResponseDTO(ferryId, arrivalTime, departureTime, departureHarbor, arrivalHarbor, ferryName, ferryType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FerryResponseDTO)) {
            return false;
        }
        FerryResponseDTO ferryResponseDTO = (FerryResponseDTO) other;
        return Intrinsics.areEqual(this.ferryId, ferryResponseDTO.ferryId) && Intrinsics.areEqual(this.arrivalTime, ferryResponseDTO.arrivalTime) && Intrinsics.areEqual(this.departureTime, ferryResponseDTO.departureTime) && Intrinsics.areEqual(this.departureHarbor, ferryResponseDTO.departureHarbor) && Intrinsics.areEqual(this.arrivalHarbor, ferryResponseDTO.arrivalHarbor) && Intrinsics.areEqual(this.ferryName, ferryResponseDTO.ferryName) && this.ferryType == ferryResponseDTO.ferryType;
    }

    public final String getArrivalHarbor() {
        return this.arrivalHarbor;
    }

    public final LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    public final String getDepartureHarbor() {
        return this.departureHarbor;
    }

    public final LocalTime getDepartureTime() {
        return this.departureTime;
    }

    public final String getFerryId() {
        return this.ferryId;
    }

    public final String getFerryName() {
        return this.ferryName;
    }

    public final FerryTypeDTO getFerryType() {
        return this.ferryType;
    }

    public int hashCode() {
        String str = this.ferryId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        LocalTime localTime = this.arrivalTime;
        int hashCode2 = (hashCode + (localTime == null ? 0 : localTime.hashCode())) * 31;
        LocalTime localTime2 = this.departureTime;
        int hashCode3 = (hashCode2 + (localTime2 == null ? 0 : localTime2.hashCode())) * 31;
        String str2 = this.departureHarbor;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.arrivalHarbor;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.ferryName;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        FerryTypeDTO ferryTypeDTO = this.ferryType;
        return hashCode6 + (ferryTypeDTO != null ? ferryTypeDTO.hashCode() : 0);
    }

    public String toString() {
        return "FerryResponseDTO(ferryId=" + this.ferryId + ", arrivalTime=" + this.arrivalTime + ", departureTime=" + this.departureTime + ", departureHarbor=" + this.departureHarbor + ", arrivalHarbor=" + this.arrivalHarbor + ", ferryName=" + this.ferryName + ", ferryType=" + this.ferryType + ")";
    }

    public FerryResponseDTO(String str, LocalTime localTime, LocalTime localTime2, String str2, String str3, String str4, FerryTypeDTO ferryTypeDTO) {
        this.ferryId = str;
        this.arrivalTime = localTime;
        this.departureTime = localTime2;
        this.departureHarbor = str2;
        this.arrivalHarbor = str3;
        this.ferryName = str4;
        this.ferryType = ferryTypeDTO;
    }
}
