package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.helpers.serializers.DurationSerializer;
import dk.molslinjen.api.helpers.serializers.LocalDateSerializer;
import dk.molslinjen.api.helpers.serializers.LocalTimeSerializer;
import dk.molslinjen.api.services.booking.response.booking.BookingHeaderResponseDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.shared.response.SublineDTO;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.config.Harbor;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Subline;
import dk.molslinjen.domain.model.config.Subline$$serializer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 y2\u00020\u0001:\u0002yzB»\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b!\u0010\"B%\b\u0016\u0012\u0006\u0010#\u001a\u00020$\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b!\u0010%Bç\u0001\b\u0010\u0012\u0006\u0010&\u001a\u00020'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010(\u001a\u0004\u0018\u00010)¢\u0006\u0004\b!\u0010*J\u0006\u0010M\u001a\u00020\u000eJ\u0006\u0010N\u001a\u00020OJ\u0016\u0010P\u001a\u0004\u0018\u00010Q2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020Q0SJ\"\u0010T\u001a\u0004\u0018\u00010Q2\b\u0010U\u001a\u0004\u0018\u00010\u00032\f\u0010R\u001a\b\u0012\u0004\u0012\u00020Q0SH\u0002J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u0007HÆ\u0003J\t\u0010Y\u001a\u00020\u0007HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u000eHÆ\u0003J\t\u0010^\u001a\u00020\u000eHÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\t\u0010b\u001a\u00020\u0014HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u000eHÆ\u0003J\t\u0010g\u001a\u00020\u001bHÆ\u0003J\t\u0010h\u001a\u00020\u001dHÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jã\u0001\u0010k\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010l\u001a\u00020\u000e2\b\u0010m\u001a\u0004\u0018\u00010nHÖ\u0003J\t\u0010o\u001a\u00020'HÖ\u0001J\t\u0010p\u001a\u00020\u0003HÖ\u0001J%\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020\u00002\u0006\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020wH\u0001¢\u0006\u0002\bxR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001c\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001c\u0010\u0006\u001a\u00020\u00078\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010.\u001a\u0004\b2\u00103R\u001c\u0010\b\u001a\u00020\u00078\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010.\u001a\u0004\b5\u00103R\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010,R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0014\u0010\f\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010,R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010:R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010:R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010,R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010,R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010,R\u001c\u0010\u0013\u001a\u00020\u00148\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010.\u001a\u0004\b?\u0010@R\u0014\u0010\u0015\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010,R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010,R\u0011\u0010\u0019\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010:R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u0010,¨\u0006{"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingHeader;", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "arrivalHarborName", BuildConfig.FLAVOR, "date", "Lorg/threeten/bp/LocalDate;", "arrivalTime", "Lorg/threeten/bp/LocalTime;", "departureTime", "departureHarborName", "ferry", "Ldk/molslinjen/domain/model/booking/Ferry;", "timeTableId", "isCheckedIn", BuildConfig.FLAVOR, "isEarlyCheckInAllowed", "phone", "reservationId", "departureId", "travelTime", "Lorg/threeten/bp/Duration;", "routeId", "routeType", "Ldk/molslinjen/domain/model/booking/RouteType;", "transportationId", "refunded", "site", "Ldk/molslinjen/domain/model/config/Site;", "ticketCategory", "Ldk/molslinjen/domain/model/booking/TicketCategory;", "subline", "Ldk/molslinjen/domain/model/config/Subline;", "lineLogoUrl", "<init>", "(Ljava/lang/String;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalTime;Lorg/threeten/bp/LocalTime;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/Ferry;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/Duration;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/RouteType;Ljava/lang/String;ZLdk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/booking/TicketCategory;Ldk/molslinjen/domain/model/config/Subline;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/booking/response/booking/BookingHeaderResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/booking/BookingHeaderResponseDTO;Ldk/molslinjen/domain/model/booking/RouteType;Ldk/molslinjen/domain/model/booking/Ferry;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalTime;Lorg/threeten/bp/LocalTime;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/Ferry;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/Duration;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/RouteType;Ljava/lang/String;ZLdk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/booking/TicketCategory;Ldk/molslinjen/domain/model/config/Subline;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getArrivalHarborName", "()Ljava/lang/String;", "getDate$annotations", "()V", "getDate", "()Lorg/threeten/bp/LocalDate;", "getArrivalTime$annotations", "getArrivalTime", "()Lorg/threeten/bp/LocalTime;", "getDepartureTime$annotations", "getDepartureTime", "getDepartureHarborName", "getFerry", "()Ldk/molslinjen/domain/model/booking/Ferry;", "getTimeTableId", "()Z", "getPhone", "getReservationId", "getDepartureId", "getTravelTime$annotations", "getTravelTime", "()Lorg/threeten/bp/Duration;", "getRouteId", "getRouteType", "()Ldk/molslinjen/domain/model/booking/RouteType;", "getTransportationId", "getRefunded", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "getTicketCategory", "()Ldk/molslinjen/domain/model/booking/TicketCategory;", "getSubline", "()Ldk/molslinjen/domain/model/config/Subline;", "getLineLogoUrl", "isActive", "departureDateTime", "Lorg/threeten/bp/LocalDateTime;", "getDepartureHarbor", "Ldk/molslinjen/domain/model/config/Harbor;", "harbors", BuildConfig.FLAVOR, "getHarbor", "harborName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class BookingHeader implements IDepartureInfo {
    private static final BookingHeader mock;
    private final String arrivalHarborName;
    private final LocalTime arrivalTime;
    private final LocalDate date;
    private final String departureHarborName;
    private final String departureId;
    private final LocalTime departureTime;
    private final Ferry ferry;
    private final boolean isCheckedIn;
    private final boolean isEarlyCheckInAllowed;
    private final String lineLogoUrl;
    private final String phone;
    private final boolean refunded;
    private final String reservationId;
    private final String routeId;
    private final RouteType routeType;
    private final Site site;
    private final Subline subline;
    private final TicketCategory ticketCategory;
    private final String timeTableId;
    private final String transportationId;
    private final Duration travelTime;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, EnumsKt.createSimpleEnumSerializer("dk.molslinjen.domain.model.booking.RouteType", RouteType.values()), null, null, Site.INSTANCE.serializer(), null, null, null};

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingHeader$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/BookingHeader;", "getMock", "()Ldk/molslinjen/domain/model/booking/BookingHeader;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BookingHeader getMock() {
            return BookingHeader.mock;
        }

        public final KSerializer<BookingHeader> serializer() {
            return BookingHeader$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        LocalDate of = LocalDate.of(2023, 1, 1);
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
        LocalTime of2 = LocalTime.of(10, 0);
        Intrinsics.checkNotNullExpressionValue(of2, "of(...)");
        LocalTime of3 = LocalTime.of(11, 15);
        Intrinsics.checkNotNullExpressionValue(of3, "of(...)");
        Ferry mock2 = Ferry.INSTANCE.getMock();
        Duration ofMinutes = Duration.ofMinutes(90L);
        Intrinsics.checkNotNullExpressionValue(ofMinutes, "ofMinutes(...)");
        mock = new BookingHeader("København", of, of2, of3, "Helsingør", mock2, "12323123", false, true, "12345678", "12345678", "JYL_3_20230421_1015", ofMinutes, "123", RouteType.Ferry, "123", false, Site.Mols, TicketCategory.INSTANCE.getMockLowPrice(), Subline.INSTANCE.getMock(), null);
    }

    public /* synthetic */ BookingHeader(int i5, String str, LocalDate localDate, LocalTime localTime, LocalTime localTime2, String str2, Ferry ferry, String str3, boolean z5, boolean z6, String str4, String str5, String str6, Duration duration, String str7, RouteType routeType, String str8, boolean z7, Site site, TicketCategory ticketCategory, Subline subline, String str9, SerializationConstructorMarker serializationConstructorMarker) {
        if (524287 != (i5 & 524287)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 524287, BookingHeader$$serializer.INSTANCE.getDescriptor());
        }
        this.arrivalHarborName = str;
        this.date = localDate;
        this.arrivalTime = localTime;
        this.departureTime = localTime2;
        this.departureHarborName = str2;
        this.ferry = ferry;
        this.timeTableId = str3;
        this.isCheckedIn = z5;
        this.isEarlyCheckInAllowed = z6;
        this.phone = str4;
        this.reservationId = str5;
        this.departureId = str6;
        this.travelTime = duration;
        this.routeId = str7;
        this.routeType = routeType;
        this.transportationId = str8;
        this.refunded = z7;
        this.site = site;
        this.ticketCategory = ticketCategory;
        if ((524288 & i5) == 0) {
            this.subline = null;
        } else {
            this.subline = subline;
        }
        if ((i5 & 1048576) == 0) {
            this.lineLogoUrl = null;
        } else {
            this.lineLogoUrl = str9;
        }
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

    private final Harbor getHarbor(String harborName, List<Harbor> harbors) {
        Object obj;
        List<Harbor> list = harbors;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Harbor) obj).getName(), harborName)) {
                break;
            }
        }
        Harbor harbor = (Harbor) obj;
        if (harbor != null) {
            return harbor;
        }
        Logger logger = Logger.INSTANCE;
        int size = harbors.size();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(((Harbor) it2.next()).getName());
        }
        logger.logCritical(new CriticalLog("Harbor name \"" + harborName + "\" was not found in harbors list with " + size + " harbors. Names: " + CollectionsKt.distinct(arrayList)));
        return null;
    }

    @Serializable(with = DurationSerializer.class)
    public static /* synthetic */ void getTravelTime$annotations() {
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(BookingHeader self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.getArrivalHarborName());
        output.encodeSerializableElement(serialDesc, 1, LocalDateSerializer.INSTANCE, self.getDate());
        LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 2, localTimeSerializer, self.getArrivalTime());
        output.encodeSerializableElement(serialDesc, 3, localTimeSerializer, self.getDepartureTime());
        output.encodeStringElement(serialDesc, 4, self.getDepartureHarborName());
        output.encodeNullableSerializableElement(serialDesc, 5, Ferry$$serializer.INSTANCE, self.getFerry());
        output.encodeStringElement(serialDesc, 6, self.getTimeTableId());
        output.encodeBooleanElement(serialDesc, 7, self.isCheckedIn);
        output.encodeBooleanElement(serialDesc, 8, self.isEarlyCheckInAllowed);
        output.encodeStringElement(serialDesc, 9, self.phone);
        output.encodeStringElement(serialDesc, 10, self.reservationId);
        output.encodeStringElement(serialDesc, 11, self.departureId);
        output.encodeSerializableElement(serialDesc, 12, DurationSerializer.INSTANCE, self.getTravelTime());
        output.encodeStringElement(serialDesc, 13, self.getRouteId());
        output.encodeNullableSerializableElement(serialDesc, 14, kSerializerArr[14], self.getRouteType());
        output.encodeStringElement(serialDesc, 15, self.transportationId);
        output.encodeBooleanElement(serialDesc, 16, self.refunded);
        output.encodeSerializableElement(serialDesc, 17, kSerializerArr[17], self.site);
        output.encodeSerializableElement(serialDesc, 18, TicketCategory$$serializer.INSTANCE, self.ticketCategory);
        if (output.shouldEncodeElementDefault(serialDesc, 19) || self.subline != null) {
            output.encodeNullableSerializableElement(serialDesc, 19, Subline$$serializer.INSTANCE, self.subline);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 20) && self.lineLogoUrl == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 20, StringSerializer.INSTANCE, self.lineLogoUrl);
    }

    /* renamed from: component1, reason: from getter */
    public final String getArrivalHarborName() {
        return this.arrivalHarborName;
    }

    /* renamed from: component10, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component11, reason: from getter */
    public final String getReservationId() {
        return this.reservationId;
    }

    /* renamed from: component12, reason: from getter */
    public final String getDepartureId() {
        return this.departureId;
    }

    /* renamed from: component13, reason: from getter */
    public final Duration getTravelTime() {
        return this.travelTime;
    }

    /* renamed from: component14, reason: from getter */
    public final String getRouteId() {
        return this.routeId;
    }

    /* renamed from: component15, reason: from getter */
    public final RouteType getRouteType() {
        return this.routeType;
    }

    /* renamed from: component16, reason: from getter */
    public final String getTransportationId() {
        return this.transportationId;
    }

    /* renamed from: component17, reason: from getter */
    public final boolean getRefunded() {
        return this.refunded;
    }

    /* renamed from: component18, reason: from getter */
    public final Site getSite() {
        return this.site;
    }

    /* renamed from: component19, reason: from getter */
    public final TicketCategory getTicketCategory() {
        return this.ticketCategory;
    }

    /* renamed from: component2, reason: from getter */
    public final LocalDate getDate() {
        return this.date;
    }

    /* renamed from: component20, reason: from getter */
    public final Subline getSubline() {
        return this.subline;
    }

    /* renamed from: component21, reason: from getter */
    public final String getLineLogoUrl() {
        return this.lineLogoUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    /* renamed from: component4, reason: from getter */
    public final LocalTime getDepartureTime() {
        return this.departureTime;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDepartureHarborName() {
        return this.departureHarborName;
    }

    /* renamed from: component6, reason: from getter */
    public final Ferry getFerry() {
        return this.ferry;
    }

    /* renamed from: component7, reason: from getter */
    public final String getTimeTableId() {
        return this.timeTableId;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsCheckedIn() {
        return this.isCheckedIn;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsEarlyCheckInAllowed() {
        return this.isEarlyCheckInAllowed;
    }

    public final BookingHeader copy(String arrivalHarborName, LocalDate date, LocalTime arrivalTime, LocalTime departureTime, String departureHarborName, Ferry ferry, String timeTableId, boolean isCheckedIn, boolean isEarlyCheckInAllowed, String phone, String reservationId, String departureId, Duration travelTime, String routeId, RouteType routeType, String transportationId, boolean refunded, Site site, TicketCategory ticketCategory, Subline subline, String lineLogoUrl) {
        Intrinsics.checkNotNullParameter(arrivalHarborName, "arrivalHarborName");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
        Intrinsics.checkNotNullParameter(departureTime, "departureTime");
        Intrinsics.checkNotNullParameter(departureHarborName, "departureHarborName");
        Intrinsics.checkNotNullParameter(timeTableId, "timeTableId");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(reservationId, "reservationId");
        Intrinsics.checkNotNullParameter(departureId, "departureId");
        Intrinsics.checkNotNullParameter(travelTime, "travelTime");
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        Intrinsics.checkNotNullParameter(transportationId, "transportationId");
        Intrinsics.checkNotNullParameter(site, "site");
        Intrinsics.checkNotNullParameter(ticketCategory, "ticketCategory");
        return new BookingHeader(arrivalHarborName, date, arrivalTime, departureTime, departureHarborName, ferry, timeTableId, isCheckedIn, isEarlyCheckInAllowed, phone, reservationId, departureId, travelTime, routeId, routeType, transportationId, refunded, site, ticketCategory, subline, lineLogoUrl);
    }

    public final LocalDateTime departureDateTime() {
        LocalDateTime of = LocalDateTime.of(getDate(), getDepartureTime());
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
        return of;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BookingHeader)) {
            return false;
        }
        BookingHeader bookingHeader = (BookingHeader) other;
        return Intrinsics.areEqual(this.arrivalHarborName, bookingHeader.arrivalHarborName) && Intrinsics.areEqual(this.date, bookingHeader.date) && Intrinsics.areEqual(this.arrivalTime, bookingHeader.arrivalTime) && Intrinsics.areEqual(this.departureTime, bookingHeader.departureTime) && Intrinsics.areEqual(this.departureHarborName, bookingHeader.departureHarborName) && Intrinsics.areEqual(this.ferry, bookingHeader.ferry) && Intrinsics.areEqual(this.timeTableId, bookingHeader.timeTableId) && this.isCheckedIn == bookingHeader.isCheckedIn && this.isEarlyCheckInAllowed == bookingHeader.isEarlyCheckInAllowed && Intrinsics.areEqual(this.phone, bookingHeader.phone) && Intrinsics.areEqual(this.reservationId, bookingHeader.reservationId) && Intrinsics.areEqual(this.departureId, bookingHeader.departureId) && Intrinsics.areEqual(this.travelTime, bookingHeader.travelTime) && Intrinsics.areEqual(this.routeId, bookingHeader.routeId) && this.routeType == bookingHeader.routeType && Intrinsics.areEqual(this.transportationId, bookingHeader.transportationId) && this.refunded == bookingHeader.refunded && this.site == bookingHeader.site && Intrinsics.areEqual(this.ticketCategory, bookingHeader.ticketCategory) && Intrinsics.areEqual(this.subline, bookingHeader.subline) && Intrinsics.areEqual(this.lineLogoUrl, bookingHeader.lineLogoUrl);
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

    public final Harbor getDepartureHarbor(List<Harbor> harbors) {
        Intrinsics.checkNotNullParameter(harbors, "harbors");
        return getHarbor(getDepartureHarborName(), harbors);
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getDepartureHarborName() {
        return this.departureHarborName;
    }

    public final String getDepartureId() {
        return this.departureId;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public LocalTime getDepartureTime() {
        return this.departureTime;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public Ferry getFerry() {
        return this.ferry;
    }

    public final String getLineLogoUrl() {
        return this.lineLogoUrl;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final boolean getRefunded() {
        return this.refunded;
    }

    public final String getReservationId() {
        return this.reservationId;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getRouteId() {
        return this.routeId;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public RouteType getRouteType() {
        return this.routeType;
    }

    public final Site getSite() {
        return this.site;
    }

    public final Subline getSubline() {
        return this.subline;
    }

    public final TicketCategory getTicketCategory() {
        return this.ticketCategory;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getTimeTableId() {
        return this.timeTableId;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public String getTransportSwitchDescription() {
        return IDepartureInfo.DefaultImpls.getTransportSwitchDescription(this);
    }

    public final String getTransportationId() {
        return this.transportationId;
    }

    @Override // dk.molslinjen.domain.model.booking.IDepartureInfo
    public Duration getTravelTime() {
        return this.travelTime;
    }

    public int hashCode() {
        int hashCode = ((((((((this.arrivalHarborName.hashCode() * 31) + this.date.hashCode()) * 31) + this.arrivalTime.hashCode()) * 31) + this.departureTime.hashCode()) * 31) + this.departureHarborName.hashCode()) * 31;
        Ferry ferry = this.ferry;
        int hashCode2 = (((((((((((((((((hashCode + (ferry == null ? 0 : ferry.hashCode())) * 31) + this.timeTableId.hashCode()) * 31) + Boolean.hashCode(this.isCheckedIn)) * 31) + Boolean.hashCode(this.isEarlyCheckInAllowed)) * 31) + this.phone.hashCode()) * 31) + this.reservationId.hashCode()) * 31) + this.departureId.hashCode()) * 31) + this.travelTime.hashCode()) * 31) + this.routeId.hashCode()) * 31;
        RouteType routeType = this.routeType;
        int hashCode3 = (((((((((hashCode2 + (routeType == null ? 0 : routeType.hashCode())) * 31) + this.transportationId.hashCode()) * 31) + Boolean.hashCode(this.refunded)) * 31) + this.site.hashCode()) * 31) + this.ticketCategory.hashCode()) * 31;
        Subline subline = this.subline;
        int hashCode4 = (hashCode3 + (subline == null ? 0 : subline.hashCode())) * 31;
        String str = this.lineLogoUrl;
        return hashCode4 + (str != null ? str.hashCode() : 0);
    }

    public final boolean isActive() {
        return LocalDateTime.of(getDate(), getArrivalTime()).isAfter(LocalDateTime.now()) && !this.refunded;
    }

    public final boolean isCheckedIn() {
        return this.isCheckedIn;
    }

    public final boolean isEarlyCheckInAllowed() {
        return this.isEarlyCheckInAllowed;
    }

    public String toString() {
        return "BookingHeader(arrivalHarborName=" + this.arrivalHarborName + ", date=" + this.date + ", arrivalTime=" + this.arrivalTime + ", departureTime=" + this.departureTime + ", departureHarborName=" + this.departureHarborName + ", ferry=" + this.ferry + ", timeTableId=" + this.timeTableId + ", isCheckedIn=" + this.isCheckedIn + ", isEarlyCheckInAllowed=" + this.isEarlyCheckInAllowed + ", phone=" + this.phone + ", reservationId=" + this.reservationId + ", departureId=" + this.departureId + ", travelTime=" + this.travelTime + ", routeId=" + this.routeId + ", routeType=" + this.routeType + ", transportationId=" + this.transportationId + ", refunded=" + this.refunded + ", site=" + this.site + ", ticketCategory=" + this.ticketCategory + ", subline=" + this.subline + ", lineLogoUrl=" + this.lineLogoUrl + ")";
    }

    public BookingHeader(String arrivalHarborName, LocalDate date, LocalTime arrivalTime, LocalTime departureTime, String departureHarborName, Ferry ferry, String timeTableId, boolean z5, boolean z6, String phone, String reservationId, String departureId, Duration travelTime, String routeId, RouteType routeType, String transportationId, boolean z7, Site site, TicketCategory ticketCategory, Subline subline, String str) {
        Intrinsics.checkNotNullParameter(arrivalHarborName, "arrivalHarborName");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
        Intrinsics.checkNotNullParameter(departureTime, "departureTime");
        Intrinsics.checkNotNullParameter(departureHarborName, "departureHarborName");
        Intrinsics.checkNotNullParameter(timeTableId, "timeTableId");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(reservationId, "reservationId");
        Intrinsics.checkNotNullParameter(departureId, "departureId");
        Intrinsics.checkNotNullParameter(travelTime, "travelTime");
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        Intrinsics.checkNotNullParameter(transportationId, "transportationId");
        Intrinsics.checkNotNullParameter(site, "site");
        Intrinsics.checkNotNullParameter(ticketCategory, "ticketCategory");
        this.arrivalHarborName = arrivalHarborName;
        this.date = date;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.departureHarborName = departureHarborName;
        this.ferry = ferry;
        this.timeTableId = timeTableId;
        this.isCheckedIn = z5;
        this.isEarlyCheckInAllowed = z6;
        this.phone = phone;
        this.reservationId = reservationId;
        this.departureId = departureId;
        this.travelTime = travelTime;
        this.routeId = routeId;
        this.routeType = routeType;
        this.transportationId = transportationId;
        this.refunded = z7;
        this.site = site;
        this.ticketCategory = ticketCategory;
        this.subline = subline;
        this.lineLogoUrl = str;
    }

    public /* synthetic */ BookingHeader(String str, LocalDate localDate, LocalTime localTime, LocalTime localTime2, String str2, Ferry ferry, String str3, boolean z5, boolean z6, String str4, String str5, String str6, Duration duration, String str7, RouteType routeType, String str8, boolean z7, Site site, TicketCategory ticketCategory, Subline subline, String str9, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, localDate, localTime, localTime2, str2, ferry, str3, z5, z6, str4, str5, str6, duration, str7, routeType, str8, z7, site, ticketCategory, (i5 & 524288) != 0 ? null : subline, (i5 & 1048576) != 0 ? null : str9);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BookingHeader(BookingHeaderResponseDTO dto, RouteType routeType, Ferry ferry) {
        this(r4, r5, r6, r7, r8, ferry, r10, r11, r12, r13, r14, r15, r16, r17, routeType, r19, r20, r21, r0, r2 != null ? new Subline(r2) : null, dto.getSite() == SiteDTO.Kombardo ? null : dto.getLineLogoUrl());
        Intrinsics.checkNotNullParameter(dto, "dto");
        String arrivalHarborName = dto.getArrivalHarborName();
        String str = arrivalHarborName == null ? "-" : arrivalHarborName;
        LocalDate localDate = dto.getDepartureDateTime().toLocalDate();
        Intrinsics.checkNotNullExpressionValue(localDate, "toLocalDate(...)");
        LocalTime arrivalTime = dto.getArrivalTime();
        LocalTime localTime = dto.getDepartureDateTime().toLocalTime();
        Intrinsics.checkNotNullExpressionValue(localTime, "toLocalTime(...)");
        String departureHarborName = dto.getDepartureHarborName();
        String str2 = departureHarborName == null ? "-" : departureHarborName;
        boolean isCheckedIn = dto.isCheckedIn();
        String phone = dto.getPhone();
        String reservationId = dto.getReservationId();
        String departureId = dto.getDepartureId();
        Duration travelTime = dto.getTravelTime();
        String routeId = dto.getRouteId();
        boolean isEarlyCheckInPossible = dto.isEarlyCheckInPossible();
        boolean isRefunded = dto.getRefundInfo().isRefunded();
        String transportId = dto.getTransportId();
        Site invoke = Site.INSTANCE.invoke(dto.getSite());
        TicketCategory ticketCategory = new TicketCategory(dto.getTicketTypeId());
        String timeTableId = dto.getTimeTableId();
        SublineDTO subline = dto.getSubline();
    }
}
