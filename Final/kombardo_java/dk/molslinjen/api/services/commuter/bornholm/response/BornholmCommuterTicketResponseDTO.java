package dk.molslinjen.api.services.commuter.bornholm.response;

import dk.molslinjen.api.helpers.serializers.DurationSerializer;
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
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 72\u00020\u0001:\u000267B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rBW\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003JE\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u000fHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u001bR\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014¨\u00068"}, d2 = {"Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterTicketResponseDTO;", BuildConfig.FLAVOR, "route", BuildConfig.FLAVOR, "date", "Lorg/threeten/bp/LocalDate;", "time", "Lorg/threeten/bp/LocalTime;", "arrivalTime", "crossingTime", "Lorg/threeten/bp/Duration;", "ferryName", "<init>", "(Ljava/lang/String;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalTime;Lorg/threeten/bp/LocalTime;Lorg/threeten/bp/Duration;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalTime;Lorg/threeten/bp/LocalTime;Lorg/threeten/bp/Duration;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRoute", "()Ljava/lang/String;", "getDate$annotations", "()V", "getDate", "()Lorg/threeten/bp/LocalDate;", "getTime$annotations", "getTime", "()Lorg/threeten/bp/LocalTime;", "getArrivalTime$annotations", "getArrivalTime", "getCrossingTime$annotations", "getCrossingTime", "()Lorg/threeten/bp/Duration;", "getFerryName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class BornholmCommuterTicketResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final LocalTime arrivalTime;
    private final Duration crossingTime;
    private final LocalDate date;
    private final String ferryName;
    private final String route;
    private final LocalTime time;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterTicketResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterTicketResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<BornholmCommuterTicketResponseDTO> serializer() {
            return BornholmCommuterTicketResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ BornholmCommuterTicketResponseDTO(int i5, String str, LocalDate localDate, LocalTime localTime, LocalTime localTime2, Duration duration, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i5 & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 63, BornholmCommuterTicketResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.route = str;
        this.date = localDate;
        this.time = localTime;
        this.arrivalTime = localTime2;
        this.crossingTime = duration;
        this.ferryName = str2;
    }

    public static /* synthetic */ BornholmCommuterTicketResponseDTO copy$default(BornholmCommuterTicketResponseDTO bornholmCommuterTicketResponseDTO, String str, LocalDate localDate, LocalTime localTime, LocalTime localTime2, Duration duration, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = bornholmCommuterTicketResponseDTO.route;
        }
        if ((i5 & 2) != 0) {
            localDate = bornholmCommuterTicketResponseDTO.date;
        }
        LocalDate localDate2 = localDate;
        if ((i5 & 4) != 0) {
            localTime = bornholmCommuterTicketResponseDTO.time;
        }
        LocalTime localTime3 = localTime;
        if ((i5 & 8) != 0) {
            localTime2 = bornholmCommuterTicketResponseDTO.arrivalTime;
        }
        LocalTime localTime4 = localTime2;
        if ((i5 & 16) != 0) {
            duration = bornholmCommuterTicketResponseDTO.crossingTime;
        }
        Duration duration2 = duration;
        if ((i5 & 32) != 0) {
            str2 = bornholmCommuterTicketResponseDTO.ferryName;
        }
        return bornholmCommuterTicketResponseDTO.copy(str, localDate2, localTime3, localTime4, duration2, str2);
    }

    @Serializable(with = LocalTimeSerializer.class)
    public static /* synthetic */ void getArrivalTime$annotations() {
    }

    @Serializable(with = DurationSerializer.class)
    public static /* synthetic */ void getCrossingTime$annotations() {
    }

    @Serializable(with = LocalDateWithTimeSerializer.class)
    public static /* synthetic */ void getDate$annotations() {
    }

    @Serializable(with = LocalTimeSerializer.class)
    public static /* synthetic */ void getTime$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(BornholmCommuterTicketResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.route);
        output.encodeSerializableElement(serialDesc, 1, LocalDateWithTimeSerializer.INSTANCE, self.date);
        LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 2, localTimeSerializer, self.time);
        output.encodeSerializableElement(serialDesc, 3, localTimeSerializer, self.arrivalTime);
        output.encodeSerializableElement(serialDesc, 4, DurationSerializer.INSTANCE, self.crossingTime);
        output.encodeStringElement(serialDesc, 5, self.ferryName);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRoute() {
        return this.route;
    }

    /* renamed from: component2, reason: from getter */
    public final LocalDate getDate() {
        return this.date;
    }

    /* renamed from: component3, reason: from getter */
    public final LocalTime getTime() {
        return this.time;
    }

    /* renamed from: component4, reason: from getter */
    public final LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    /* renamed from: component5, reason: from getter */
    public final Duration getCrossingTime() {
        return this.crossingTime;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFerryName() {
        return this.ferryName;
    }

    public final BornholmCommuterTicketResponseDTO copy(String route, LocalDate date, LocalTime time, LocalTime arrivalTime, Duration crossingTime, String ferryName) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
        Intrinsics.checkNotNullParameter(crossingTime, "crossingTime");
        Intrinsics.checkNotNullParameter(ferryName, "ferryName");
        return new BornholmCommuterTicketResponseDTO(route, date, time, arrivalTime, crossingTime, ferryName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BornholmCommuterTicketResponseDTO)) {
            return false;
        }
        BornholmCommuterTicketResponseDTO bornholmCommuterTicketResponseDTO = (BornholmCommuterTicketResponseDTO) other;
        return Intrinsics.areEqual(this.route, bornholmCommuterTicketResponseDTO.route) && Intrinsics.areEqual(this.date, bornholmCommuterTicketResponseDTO.date) && Intrinsics.areEqual(this.time, bornholmCommuterTicketResponseDTO.time) && Intrinsics.areEqual(this.arrivalTime, bornholmCommuterTicketResponseDTO.arrivalTime) && Intrinsics.areEqual(this.crossingTime, bornholmCommuterTicketResponseDTO.crossingTime) && Intrinsics.areEqual(this.ferryName, bornholmCommuterTicketResponseDTO.ferryName);
    }

    public final LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    public final Duration getCrossingTime() {
        return this.crossingTime;
    }

    public final LocalDate getDate() {
        return this.date;
    }

    public final String getFerryName() {
        return this.ferryName;
    }

    public final String getRoute() {
        return this.route;
    }

    public final LocalTime getTime() {
        return this.time;
    }

    public int hashCode() {
        return (((((((((this.route.hashCode() * 31) + this.date.hashCode()) * 31) + this.time.hashCode()) * 31) + this.arrivalTime.hashCode()) * 31) + this.crossingTime.hashCode()) * 31) + this.ferryName.hashCode();
    }

    public String toString() {
        return "BornholmCommuterTicketResponseDTO(route=" + this.route + ", date=" + this.date + ", time=" + this.time + ", arrivalTime=" + this.arrivalTime + ", crossingTime=" + this.crossingTime + ", ferryName=" + this.ferryName + ")";
    }

    public BornholmCommuterTicketResponseDTO(String route, LocalDate date, LocalTime time, LocalTime arrivalTime, Duration crossingTime, String ferryName) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
        Intrinsics.checkNotNullParameter(crossingTime, "crossingTime");
        Intrinsics.checkNotNullParameter(ferryName, "ferryName");
        this.route = route;
        this.date = date;
        this.time = time;
        this.arrivalTime = arrivalTime;
        this.crossingTime = crossingTime;
        this.ferryName = ferryName;
    }
}
