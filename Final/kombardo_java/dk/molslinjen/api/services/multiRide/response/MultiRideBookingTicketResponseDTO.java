package dk.molslinjen.api.services.multiRide.response;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.helpers.serializers.LocalTimeSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 H2\u00020\u0001:\u0002GHBg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014B\u008f\u0001\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0018J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u000eHÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0011HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\u0081\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001J\u0013\u0010;\u001a\u00020\u000e2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0011HÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001J%\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0001¢\u0006\u0002\bFR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\"R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u001c\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001a¨\u0006I"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/MultiRideBookingTicketResponseDTO;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "arrivalHarbor", "arrivalTime", "Lorg/threeten/bp/LocalTime;", "date", "Lorg/threeten/bp/LocalDate;", "departureHarbor", "departureRegionId", "departureTime", "ferry", "noShow", BuildConfig.FLAVOR, "numberPlate", "passengers", BuildConfig.FLAVOR, "phone", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalTime;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalTime;Ljava/lang/String;ZLjava/lang/String;ILjava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalTime;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalTime;Ljava/lang/String;ZLjava/lang/String;ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getArrivalHarbor", "getArrivalTime$annotations", "()V", "getArrivalTime", "()Lorg/threeten/bp/LocalTime;", "getDate$annotations", "getDate", "()Lorg/threeten/bp/LocalDate;", "getDepartureHarbor", "getDepartureRegionId", "getDepartureTime$annotations", "getDepartureTime", "getFerry", "getNoShow", "()Z", "getNumberPlate", "getPassengers", "()I", "getPhone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class MultiRideBookingTicketResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String arrivalHarbor;
    private final LocalTime arrivalTime;
    private final LocalDate date;
    private final String departureHarbor;
    private final String departureRegionId;
    private final LocalTime departureTime;
    private final String ferry;
    private final String id;
    private final boolean noShow;
    private final String numberPlate;
    private final int passengers;
    private final String phone;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/MultiRideBookingTicketResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/multiRide/response/MultiRideBookingTicketResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<MultiRideBookingTicketResponseDTO> serializer() {
            return MultiRideBookingTicketResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ MultiRideBookingTicketResponseDTO(int i5, String str, String str2, LocalTime localTime, LocalDate localDate, String str3, String str4, LocalTime localTime2, String str5, boolean z5, String str6, int i6, String str7, SerializationConstructorMarker serializationConstructorMarker) {
        if (4095 != (i5 & 4095)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 4095, MultiRideBookingTicketResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.arrivalHarbor = str2;
        this.arrivalTime = localTime;
        this.date = localDate;
        this.departureHarbor = str3;
        this.departureRegionId = str4;
        this.departureTime = localTime2;
        this.ferry = str5;
        this.noShow = z5;
        this.numberPlate = str6;
        this.passengers = i6;
        this.phone = str7;
    }

    @Serializable(with = LocalTimeSerializer.class)
    public static /* synthetic */ void getArrivalTime$annotations() {
    }

    @Serializable(with = LocalDateWithTimeSerializer.class)
    public static /* synthetic */ void getDate$annotations() {
    }

    @Serializable(with = LocalTimeSerializer.class)
    public static /* synthetic */ void getDepartureTime$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(MultiRideBookingTicketResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.arrivalHarbor);
        LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 2, localTimeSerializer, self.arrivalTime);
        output.encodeSerializableElement(serialDesc, 3, LocalDateWithTimeSerializer.INSTANCE, self.date);
        output.encodeStringElement(serialDesc, 4, self.departureHarbor);
        output.encodeStringElement(serialDesc, 5, self.departureRegionId);
        output.encodeSerializableElement(serialDesc, 6, localTimeSerializer, self.departureTime);
        output.encodeStringElement(serialDesc, 7, self.ferry);
        output.encodeBooleanElement(serialDesc, 8, self.noShow);
        output.encodeStringElement(serialDesc, 9, self.numberPlate);
        output.encodeIntElement(serialDesc, 10, self.passengers);
        output.encodeStringElement(serialDesc, 11, self.phone);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getNumberPlate() {
        return this.numberPlate;
    }

    /* renamed from: component11, reason: from getter */
    public final int getPassengers() {
        return this.passengers;
    }

    /* renamed from: component12, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component2, reason: from getter */
    public final String getArrivalHarbor() {
        return this.arrivalHarbor;
    }

    /* renamed from: component3, reason: from getter */
    public final LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    /* renamed from: component4, reason: from getter */
    public final LocalDate getDate() {
        return this.date;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDepartureHarbor() {
        return this.departureHarbor;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDepartureRegionId() {
        return this.departureRegionId;
    }

    /* renamed from: component7, reason: from getter */
    public final LocalTime getDepartureTime() {
        return this.departureTime;
    }

    /* renamed from: component8, reason: from getter */
    public final String getFerry() {
        return this.ferry;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getNoShow() {
        return this.noShow;
    }

    public final MultiRideBookingTicketResponseDTO copy(String id, String arrivalHarbor, LocalTime arrivalTime, LocalDate date, String departureHarbor, String departureRegionId, LocalTime departureTime, String ferry, boolean noShow, String numberPlate, int passengers, String phone) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(arrivalHarbor, "arrivalHarbor");
        Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(departureHarbor, "departureHarbor");
        Intrinsics.checkNotNullParameter(departureRegionId, "departureRegionId");
        Intrinsics.checkNotNullParameter(departureTime, "departureTime");
        Intrinsics.checkNotNullParameter(ferry, "ferry");
        Intrinsics.checkNotNullParameter(numberPlate, "numberPlate");
        Intrinsics.checkNotNullParameter(phone, "phone");
        return new MultiRideBookingTicketResponseDTO(id, arrivalHarbor, arrivalTime, date, departureHarbor, departureRegionId, departureTime, ferry, noShow, numberPlate, passengers, phone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiRideBookingTicketResponseDTO)) {
            return false;
        }
        MultiRideBookingTicketResponseDTO multiRideBookingTicketResponseDTO = (MultiRideBookingTicketResponseDTO) other;
        return Intrinsics.areEqual(this.id, multiRideBookingTicketResponseDTO.id) && Intrinsics.areEqual(this.arrivalHarbor, multiRideBookingTicketResponseDTO.arrivalHarbor) && Intrinsics.areEqual(this.arrivalTime, multiRideBookingTicketResponseDTO.arrivalTime) && Intrinsics.areEqual(this.date, multiRideBookingTicketResponseDTO.date) && Intrinsics.areEqual(this.departureHarbor, multiRideBookingTicketResponseDTO.departureHarbor) && Intrinsics.areEqual(this.departureRegionId, multiRideBookingTicketResponseDTO.departureRegionId) && Intrinsics.areEqual(this.departureTime, multiRideBookingTicketResponseDTO.departureTime) && Intrinsics.areEqual(this.ferry, multiRideBookingTicketResponseDTO.ferry) && this.noShow == multiRideBookingTicketResponseDTO.noShow && Intrinsics.areEqual(this.numberPlate, multiRideBookingTicketResponseDTO.numberPlate) && this.passengers == multiRideBookingTicketResponseDTO.passengers && Intrinsics.areEqual(this.phone, multiRideBookingTicketResponseDTO.phone);
    }

    public final String getArrivalHarbor() {
        return this.arrivalHarbor;
    }

    public final LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    public final LocalDate getDate() {
        return this.date;
    }

    public final String getDepartureHarbor() {
        return this.departureHarbor;
    }

    public final String getDepartureRegionId() {
        return this.departureRegionId;
    }

    public final LocalTime getDepartureTime() {
        return this.departureTime;
    }

    public final String getFerry() {
        return this.ferry;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getNoShow() {
        return this.noShow;
    }

    public final String getNumberPlate() {
        return this.numberPlate;
    }

    public final int getPassengers() {
        return this.passengers;
    }

    public final String getPhone() {
        return this.phone;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.id.hashCode() * 31) + this.arrivalHarbor.hashCode()) * 31) + this.arrivalTime.hashCode()) * 31) + this.date.hashCode()) * 31) + this.departureHarbor.hashCode()) * 31) + this.departureRegionId.hashCode()) * 31) + this.departureTime.hashCode()) * 31) + this.ferry.hashCode()) * 31) + Boolean.hashCode(this.noShow)) * 31) + this.numberPlate.hashCode()) * 31) + Integer.hashCode(this.passengers)) * 31) + this.phone.hashCode();
    }

    public String toString() {
        return "MultiRideBookingTicketResponseDTO(id=" + this.id + ", arrivalHarbor=" + this.arrivalHarbor + ", arrivalTime=" + this.arrivalTime + ", date=" + this.date + ", departureHarbor=" + this.departureHarbor + ", departureRegionId=" + this.departureRegionId + ", departureTime=" + this.departureTime + ", ferry=" + this.ferry + ", noShow=" + this.noShow + ", numberPlate=" + this.numberPlate + ", passengers=" + this.passengers + ", phone=" + this.phone + ")";
    }

    public MultiRideBookingTicketResponseDTO(String id, String arrivalHarbor, LocalTime arrivalTime, LocalDate date, String departureHarbor, String departureRegionId, LocalTime departureTime, String ferry, boolean z5, String numberPlate, int i5, String phone) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(arrivalHarbor, "arrivalHarbor");
        Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(departureHarbor, "departureHarbor");
        Intrinsics.checkNotNullParameter(departureRegionId, "departureRegionId");
        Intrinsics.checkNotNullParameter(departureTime, "departureTime");
        Intrinsics.checkNotNullParameter(ferry, "ferry");
        Intrinsics.checkNotNullParameter(numberPlate, "numberPlate");
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.id = id;
        this.arrivalHarbor = arrivalHarbor;
        this.arrivalTime = arrivalTime;
        this.date = date;
        this.departureHarbor = departureHarbor;
        this.departureRegionId = departureRegionId;
        this.departureTime = departureTime;
        this.ferry = ferry;
        this.noShow = z5;
        this.numberPlate = numberPlate;
        this.passengers = i5;
        this.phone = phone;
    }
}
