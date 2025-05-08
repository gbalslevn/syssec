package dk.molslinjen.domain.model.saleOnBoard;

import dk.molslinjen.api.helpers.serializers.DurationSerializer;
import dk.molslinjen.api.helpers.serializers.LocalDateSerializer;
import dk.molslinjen.api.helpers.serializers.LocalTimeSerializer;
import dk.molslinjen.domain.model.booking.Ferry;
import dk.molslinjen.domain.model.booking.Ferry$$serializer;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.booking.RouteType;
import dk.molslinjen.domain.model.config.Harbor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 L2\u00020\u0001:\u0002LMBe\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0001¢\u0006\u0004\b\u0013\u0010\u0016B\u0089\u0001\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0013\u0010\u001bJ\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u00107\u001a\u00020\bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u00109\u001a\u00020\u000fHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010;\u001a\u00020\bHÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003J}\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\bHÆ\u0001J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020\u0018HÖ\u0001J\t\u0010C\u001a\u00020\bHÖ\u0001J%\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0001¢\u0006\u0002\bKR\u001c\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\"R\u001c\u0010\u0006\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001fR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010\u000b\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001c\u0010\u000e\u001a\u00020\u000f8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010.R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u0014\u0010\u0011\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u0014\u0010\u0012\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010&¨\u0006N"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardDeparture;", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "arrivalTime", "Lorg/threeten/bp/LocalTime;", "date", "Lorg/threeten/bp/LocalDate;", "departureTime", "routeId", BuildConfig.FLAVOR, "routeType", "Ldk/molslinjen/domain/model/booking/RouteType;", "timeTableId", "ferry", "Ldk/molslinjen/domain/model/booking/Ferry;", "travelTime", "Lorg/threeten/bp/Duration;", "transportSwitchDescription", "arrivalHarborName", "departureHarborName", "<init>", "(Lorg/threeten/bp/LocalTime;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalTime;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/RouteType;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/Ferry;Lorg/threeten/bp/Duration;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "dto", "(Ldk/molslinjen/domain/model/booking/IDepartureInfo;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILorg/threeten/bp/LocalTime;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalTime;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/RouteType;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/Ferry;Lorg/threeten/bp/Duration;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getArrivalTime$annotations", "()V", "getArrivalTime", "()Lorg/threeten/bp/LocalTime;", "getDate$annotations", "getDate", "()Lorg/threeten/bp/LocalDate;", "getDepartureTime$annotations", "getDepartureTime", "getRouteId", "()Ljava/lang/String;", "getRouteType", "()Ldk/molslinjen/domain/model/booking/RouteType;", "getTimeTableId", "getFerry", "()Ldk/molslinjen/domain/model/booking/Ferry;", "getTravelTime$annotations", "getTravelTime", "()Lorg/threeten/bp/Duration;", "getTransportSwitchDescription", "getArrivalHarborName", "getDepartureHarborName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class SaleOnBoardDeparture implements IDepartureInfo {
    private static final SaleOnBoardDeparture mock;
    private final String arrivalHarborName;
    private final LocalTime arrivalTime;
    private final LocalDate date;
    private final String departureHarborName;
    private final LocalTime departureTime;
    private final Ferry ferry;
    private final String routeId;
    private final RouteType routeType;
    private final String timeTableId;
    private final String transportSwitchDescription;
    private final Duration travelTime;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, EnumsKt.createSimpleEnumSerializer("dk.molslinjen.domain.model.booking.RouteType", RouteType.values()), null, null, null, null, null, null};

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardDeparture$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardDeparture;", "getMock", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardDeparture;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaleOnBoardDeparture getMock() {
            return SaleOnBoardDeparture.mock;
        }

        public final KSerializer<SaleOnBoardDeparture> serializer() {
            return SaleOnBoardDeparture$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        LocalTime of = LocalTime.of(12, 0);
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
        LocalDate of2 = LocalDate.of(2022, 1, 1);
        Intrinsics.checkNotNullExpressionValue(of2, "of(...)");
        LocalTime of3 = LocalTime.of(10, 0);
        Intrinsics.checkNotNullExpressionValue(of3, "of(...)");
        RouteType routeType = RouteType.Ferry;
        Ferry mock2 = Ferry.INSTANCE.getMock();
        Harbor.Companion companion = Harbor.INSTANCE;
        String name = companion.getMockOdden().getName();
        String name2 = companion.getMockAarhus().getName();
        Duration ofMinutes = Duration.ofMinutes(120L);
        Intrinsics.checkNotNullExpressionValue(ofMinutes, "ofMinutes(...)");
        mock = new SaleOnBoardDeparture(of, of2, of3, "JYL3", routeType, "564621", mock2, ofMinutes, null, name, name2);
    }

    public /* synthetic */ SaleOnBoardDeparture(int i5, LocalTime localTime, LocalDate localDate, LocalTime localTime2, String str, RouteType routeType, String str2, Ferry ferry, Duration duration, String str3, String str4, String str5, SerializationConstructorMarker serializationConstructorMarker) {
        if (2047 != (i5 & 2047)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 2047, SaleOnBoardDeparture$$serializer.INSTANCE.getDescriptor());
        }
        this.arrivalTime = localTime;
        this.date = localDate;
        this.departureTime = localTime2;
        this.routeId = str;
        this.routeType = routeType;
        this.timeTableId = str2;
        this.ferry = ferry;
        this.travelTime = duration;
        this.transportSwitchDescription = str3;
        this.arrivalHarborName = str4;
        this.departureHarborName = str5;
    }

    @Serializable(with = LocalTimeSerializer.class)
    public static /* synthetic */ void getArrivalTime$annotations() {
    }

    @Serializable(with = LocalDateSerializer.class)
    public static /* synthetic */ void getDate$annotations() {
    }

    @Serializable(with = LocalTimeSerializer.class)
    public static /* synthetic */ void getDepartureTime$annotations() {
    }

    @Serializable(with = DurationSerializer.class)
    public static /* synthetic */ void getTravelTime$annotations() {
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(SaleOnBoardDeparture self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 0, localTimeSerializer, self.getArrivalTime());
        output.encodeSerializableElement(serialDesc, 1, LocalDateSerializer.INSTANCE, self.getDate());
        output.encodeSerializableElement(serialDesc, 2, localTimeSerializer, self.getDepartureTime());
        output.encodeStringElement(serialDesc, 3, self.getRouteId());
        output.encodeNullableSerializableElement(serialDesc, 4, kSerializerArr[4], self.getRouteType());
        output.encodeStringElement(serialDesc, 5, self.getTimeTableId());
        output.encodeNullableSerializableElement(serialDesc, 6, Ferry$$serializer.INSTANCE, self.getFerry());
        output.encodeSerializableElement(serialDesc, 7, DurationSerializer.INSTANCE, self.getTravelTime());
        output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.getTransportSwitchDescription());
        output.encodeStringElement(serialDesc, 9, self.getArrivalHarborName());
        output.encodeStringElement(serialDesc, 10, self.getDepartureHarborName());
    }

    /* renamed from: component1, reason: from getter */
    public final LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    /* renamed from: component10, reason: from getter */
    public final String getArrivalHarborName() {
        return this.arrivalHarborName;
    }

    /* renamed from: component11, reason: from getter */
    public final String getDepartureHarborName() {
        return this.departureHarborName;
    }

    /* renamed from: component2, reason: from getter */
    public final LocalDate getDate() {
        return this.date;
    }

    /* renamed from: component3, reason: from getter */
    public final LocalTime getDepartureTime() {
        return this.departureTime;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRouteId() {
        return this.routeId;
    }

    /* renamed from: component5, reason: from getter */
    public final RouteType getRouteType() {
        return this.routeType;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTimeTableId() {
        return this.timeTableId;
    }

    /* renamed from: component7, reason: from getter */
    public final Ferry getFerry() {
        return this.ferry;
    }

    /* renamed from: component8, reason: from getter */
    public final Duration getTravelTime() {
        return this.travelTime;
    }

    /* renamed from: component9, reason: from getter */
    public final String getTransportSwitchDescription() {
        return this.transportSwitchDescription;
    }

    public final SaleOnBoardDeparture copy(LocalTime arrivalTime, LocalDate date, LocalTime departureTime, String routeId, RouteType routeType, String timeTableId, Ferry ferry, Duration travelTime, String transportSwitchDescription, String arrivalHarborName, String departureHarborName) {
        Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(departureTime, "departureTime");
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        Intrinsics.checkNotNullParameter(timeTableId, "timeTableId");
        Intrinsics.checkNotNullParameter(travelTime, "travelTime");
        Intrinsics.checkNotNullParameter(arrivalHarborName, "arrivalHarborName");
        Intrinsics.checkNotNullParameter(departureHarborName, "departureHarborName");
        return new SaleOnBoardDeparture(arrivalTime, date, departureTime, routeId, routeType, timeTableId, ferry, travelTime, transportSwitchDescription, arrivalHarborName, departureHarborName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleOnBoardDeparture)) {
            return false;
        }
        SaleOnBoardDeparture saleOnBoardDeparture = (SaleOnBoardDeparture) other;
        return Intrinsics.areEqual(this.arrivalTime, saleOnBoardDeparture.arrivalTime) && Intrinsics.areEqual(this.date, saleOnBoardDeparture.date) && Intrinsics.areEqual(this.departureTime, saleOnBoardDeparture.departureTime) && Intrinsics.areEqual(this.routeId, saleOnBoardDeparture.routeId) && this.routeType == saleOnBoardDeparture.routeType && Intrinsics.areEqual(this.timeTableId, saleOnBoardDeparture.timeTableId) && Intrinsics.areEqual(this.ferry, saleOnBoardDeparture.ferry) && Intrinsics.areEqual(this.travelTime, saleOnBoardDeparture.travelTime) && Intrinsics.areEqual(this.transportSwitchDescription, saleOnBoardDeparture.transportSwitchDescription) && Intrinsics.areEqual(this.arrivalHarborName, saleOnBoardDeparture.arrivalHarborName) && Intrinsics.areEqual(this.departureHarborName, saleOnBoardDeparture.departureHarborName);
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getArrivalHarborName() {
        return this.arrivalHarborName;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public LocalDate getDate() {
        return this.date;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getDepartureHarborName() {
        return this.departureHarborName;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public LocalTime getDepartureTime() {
        return this.departureTime;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public Ferry getFerry() {
        return this.ferry;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getRouteId() {
        return this.routeId;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public RouteType getRouteType() {
        return this.routeType;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getTimeTableId() {
        return this.timeTableId;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getTransportSwitchDescription() {
        return this.transportSwitchDescription;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public Duration getTravelTime() {
        return this.travelTime;
    }

    public int hashCode() {
        int hashCode = ((((((this.arrivalTime.hashCode() * 31) + this.date.hashCode()) * 31) + this.departureTime.hashCode()) * 31) + this.routeId.hashCode()) * 31;
        RouteType routeType = this.routeType;
        int hashCode2 = (((hashCode + (routeType == null ? 0 : routeType.hashCode())) * 31) + this.timeTableId.hashCode()) * 31;
        Ferry ferry = this.ferry;
        int hashCode3 = (((hashCode2 + (ferry == null ? 0 : ferry.hashCode())) * 31) + this.travelTime.hashCode()) * 31;
        String str = this.transportSwitchDescription;
        return ((((hashCode3 + (str != null ? str.hashCode() : 0)) * 31) + this.arrivalHarborName.hashCode()) * 31) + this.departureHarborName.hashCode();
    }

    public String toString() {
        return "SaleOnBoardDeparture(arrivalTime=" + this.arrivalTime + ", date=" + this.date + ", departureTime=" + this.departureTime + ", routeId=" + this.routeId + ", routeType=" + this.routeType + ", timeTableId=" + this.timeTableId + ", ferry=" + this.ferry + ", travelTime=" + this.travelTime + ", transportSwitchDescription=" + this.transportSwitchDescription + ", arrivalHarborName=" + this.arrivalHarborName + ", departureHarborName=" + this.departureHarborName + ")";
    }

    public SaleOnBoardDeparture(LocalTime arrivalTime, LocalDate date, LocalTime departureTime, String routeId, RouteType routeType, String timeTableId, Ferry ferry, Duration travelTime, String str, String arrivalHarborName, String departureHarborName) {
        Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(departureTime, "departureTime");
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        Intrinsics.checkNotNullParameter(timeTableId, "timeTableId");
        Intrinsics.checkNotNullParameter(travelTime, "travelTime");
        Intrinsics.checkNotNullParameter(arrivalHarborName, "arrivalHarborName");
        Intrinsics.checkNotNullParameter(departureHarborName, "departureHarborName");
        this.arrivalTime = arrivalTime;
        this.date = date;
        this.departureTime = departureTime;
        this.routeId = routeId;
        this.routeType = routeType;
        this.timeTableId = timeTableId;
        this.ferry = ferry;
        this.travelTime = travelTime;
        this.transportSwitchDescription = str;
        this.arrivalHarborName = arrivalHarborName;
        this.departureHarborName = departureHarborName;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardDeparture(IDepartureInfo dto) {
        this(dto.getArrivalTime(), dto.getDate(), dto.getDepartureTime(), dto.getRouteId(), dto.getRouteType(), dto.getTimeTableId(), dto.getFerry(), dto.getTravelTime(), dto.getTransportSwitchDescription(), dto.getArrivalHarborName(), dto.getDepartureHarborName());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
