package dk.molslinjen.api.services.booking.response.booking;

import dk.molslinjen.api.helpers.serializers.DurationSerializer;
import dk.molslinjen.api.helpers.serializers.LocalDateTimeSerializer;
import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.helpers.serializers.LocalTimeSerializer;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.shared.response.SublineDTO;
import dk.molslinjen.api.shared.response.SublineDTO$$serializer;
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
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 e2\u00020\u0001:\u0003cdeB©\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001e\u0010\u001fBÕ\u0001\b\u0010\u0012\u0006\u0010 \u001a\u00020!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\u0004\b\u001e\u0010$J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0007HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010H\u001a\u00020\fHÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0011HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0015HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\fHÆ\u0003J\t\u0010S\u001a\u00020\u001aHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÑ\u0001\u0010V\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010W\u001a\u00020\f2\b\u0010X\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Y\u001a\u00020!HÖ\u0001J\t\u0010Z\u001a\u00020\u0003HÖ\u0001J%\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00002\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH\u0001¢\u0006\u0002\bbR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010(\u001a\u0004\b,\u0010-R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010&R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u00101R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010&R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010&R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010&R\u001c\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010(\u001a\u0004\b6\u00107R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010&R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010&R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010&R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010&R\u0011\u0010\u0018\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u00101R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010&¨\u0006f"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingHeaderResponseDTO;", BuildConfig.FLAVOR, "arrivalHarborName", BuildConfig.FLAVOR, "arrivalTime", "Lorg/threeten/bp/LocalTime;", "departureDateTime", "Lorg/threeten/bp/LocalDateTime;", "departureHarborName", "ferry", "Ldk/molslinjen/api/services/booking/response/booking/FerryResponseDTO;", "isCheckedIn", BuildConfig.FLAVOR, "phone", "reservationId", "departureId", "travelTime", "Lorg/threeten/bp/Duration;", "routeId", "transportId", "refundInfo", "Ldk/molslinjen/api/services/booking/response/booking/BookingHeaderResponseDTO$RefundInfo;", "ticketTypeId", "timeTableId", "isEarlyCheckInPossible", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "subline", "Ldk/molslinjen/api/shared/response/SublineDTO;", "lineLogoUrl", "<init>", "(Ljava/lang/String;Lorg/threeten/bp/LocalTime;Lorg/threeten/bp/LocalDateTime;Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/booking/FerryResponseDTO;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/Duration;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/booking/BookingHeaderResponseDTO$RefundInfo;Ljava/lang/String;Ljava/lang/String;ZLdk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/shared/response/SublineDTO;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lorg/threeten/bp/LocalTime;Lorg/threeten/bp/LocalDateTime;Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/booking/FerryResponseDTO;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/Duration;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/booking/BookingHeaderResponseDTO$RefundInfo;Ljava/lang/String;Ljava/lang/String;ZLdk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/shared/response/SublineDTO;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getArrivalHarborName", "()Ljava/lang/String;", "getArrivalTime$annotations", "()V", "getArrivalTime", "()Lorg/threeten/bp/LocalTime;", "getDepartureDateTime$annotations", "getDepartureDateTime", "()Lorg/threeten/bp/LocalDateTime;", "getDepartureHarborName", "getFerry", "()Ldk/molslinjen/api/services/booking/response/booking/FerryResponseDTO;", "()Z", "getPhone", "getReservationId", "getDepartureId", "getTravelTime$annotations", "getTravelTime", "()Lorg/threeten/bp/Duration;", "getRouteId", "getTransportId", "getRefundInfo", "()Ldk/molslinjen/api/services/booking/response/booking/BookingHeaderResponseDTO$RefundInfo;", "getTicketTypeId", "getTimeTableId", "getSite", "()Ldk/molslinjen/api/services/config/response/SiteDTO;", "getSubline", "()Ldk/molslinjen/api/shared/response/SublineDTO;", "getLineLogoUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "RefundInfo", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class BookingHeaderResponseDTO {
    private final String arrivalHarborName;
    private final LocalTime arrivalTime;
    private final LocalDateTime departureDateTime;
    private final String departureHarborName;
    private final String departureId;
    private final FerryResponseDTO ferry;
    private final boolean isCheckedIn;
    private final boolean isEarlyCheckInPossible;
    private final String lineLogoUrl;
    private final String phone;
    private final RefundInfo refundInfo;
    private final String reservationId;
    private final String routeId;
    private final SiteDTO site;
    private final SublineDTO subline;
    private final String ticketTypeId;
    private final String timeTableId;
    private final String transportId;
    private final Duration travelTime;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, EnumsKt.createSimpleEnumSerializer("dk.molslinjen.api.services.config.response.SiteDTO", SiteDTO.values()), null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingHeaderResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingHeaderResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<BookingHeaderResponseDTO> serializer() {
            return BookingHeaderResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\rR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingHeaderResponseDTO$RefundInfo;", BuildConfig.FLAVOR, "isRefunded", BuildConfig.FLAVOR, "refundDate", "Lorg/threeten/bp/LocalDate;", "<init>", "(ZLorg/threeten/bp/LocalDate;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLorg/threeten/bp/LocalDate;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "()Z", "getRefundDate$annotations", "()V", "getRefundDate", "()Lorg/threeten/bp/LocalDate;", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class RefundInfo {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean isRefunded;
        private final LocalDate refundDate;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingHeaderResponseDTO$RefundInfo$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingHeaderResponseDTO$RefundInfo;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<RefundInfo> serializer() {
                return BookingHeaderResponseDTO$RefundInfo$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ RefundInfo(int i5, boolean z5, LocalDate localDate, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i5 & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 3, BookingHeaderResponseDTO$RefundInfo$$serializer.INSTANCE.getDescriptor());
            }
            this.isRefunded = z5;
            this.refundDate = localDate;
        }

        public static /* synthetic */ RefundInfo copy$default(RefundInfo refundInfo, boolean z5, LocalDate localDate, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = refundInfo.isRefunded;
            }
            if ((i5 & 2) != 0) {
                localDate = refundInfo.refundDate;
            }
            return refundInfo.copy(z5, localDate);
        }

        @Serializable(with = LocalDateWithTimeSerializer.class)
        public static /* synthetic */ void getRefundDate$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(RefundInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeBooleanElement(serialDesc, 0, self.isRefunded);
            output.encodeNullableSerializableElement(serialDesc, 1, LocalDateWithTimeSerializer.INSTANCE, self.refundDate);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsRefunded() {
            return this.isRefunded;
        }

        /* renamed from: component2, reason: from getter */
        public final LocalDate getRefundDate() {
            return this.refundDate;
        }

        public final RefundInfo copy(boolean isRefunded, LocalDate refundDate) {
            return new RefundInfo(isRefunded, refundDate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RefundInfo)) {
                return false;
            }
            RefundInfo refundInfo = (RefundInfo) other;
            return this.isRefunded == refundInfo.isRefunded && Intrinsics.areEqual(this.refundDate, refundInfo.refundDate);
        }

        public final LocalDate getRefundDate() {
            return this.refundDate;
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.isRefunded) * 31;
            LocalDate localDate = this.refundDate;
            return hashCode + (localDate == null ? 0 : localDate.hashCode());
        }

        public final boolean isRefunded() {
            return this.isRefunded;
        }

        public String toString() {
            return "RefundInfo(isRefunded=" + this.isRefunded + ", refundDate=" + this.refundDate + ")";
        }

        public RefundInfo(boolean z5, LocalDate localDate) {
            this.isRefunded = z5;
            this.refundDate = localDate;
        }
    }

    public /* synthetic */ BookingHeaderResponseDTO(int i5, String str, LocalTime localTime, LocalDateTime localDateTime, String str2, FerryResponseDTO ferryResponseDTO, boolean z5, String str3, String str4, String str5, Duration duration, String str6, String str7, RefundInfo refundInfo, String str8, String str9, boolean z6, SiteDTO siteDTO, SublineDTO sublineDTO, String str10, SerializationConstructorMarker serializationConstructorMarker) {
        if (524287 != (i5 & 524287)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 524287, BookingHeaderResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.arrivalHarborName = str;
        this.arrivalTime = localTime;
        this.departureDateTime = localDateTime;
        this.departureHarborName = str2;
        this.ferry = ferryResponseDTO;
        this.isCheckedIn = z5;
        this.phone = str3;
        this.reservationId = str4;
        this.departureId = str5;
        this.travelTime = duration;
        this.routeId = str6;
        this.transportId = str7;
        this.refundInfo = refundInfo;
        this.ticketTypeId = str8;
        this.timeTableId = str9;
        this.isEarlyCheckInPossible = z6;
        this.site = siteDTO;
        this.subline = sublineDTO;
        this.lineLogoUrl = str10;
    }

    @Serializable(with = LocalTimeSerializer.class)
    public static /* synthetic */ void getArrivalTime$annotations() {
    }

    @Serializable(with = LocalDateTimeSerializer.class)
    public static /* synthetic */ void getDepartureDateTime$annotations() {
    }

    @Serializable(with = DurationSerializer.class)
    public static /* synthetic */ void getTravelTime$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(BookingHeaderResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.arrivalHarborName);
        output.encodeSerializableElement(serialDesc, 1, LocalTimeSerializer.INSTANCE, self.arrivalTime);
        output.encodeSerializableElement(serialDesc, 2, LocalDateTimeSerializer.INSTANCE, self.departureDateTime);
        output.encodeNullableSerializableElement(serialDesc, 3, stringSerializer, self.departureHarborName);
        output.encodeNullableSerializableElement(serialDesc, 4, FerryResponseDTO$$serializer.INSTANCE, self.ferry);
        output.encodeBooleanElement(serialDesc, 5, self.isCheckedIn);
        output.encodeStringElement(serialDesc, 6, self.phone);
        output.encodeStringElement(serialDesc, 7, self.reservationId);
        output.encodeStringElement(serialDesc, 8, self.departureId);
        output.encodeSerializableElement(serialDesc, 9, DurationSerializer.INSTANCE, self.travelTime);
        output.encodeStringElement(serialDesc, 10, self.routeId);
        output.encodeStringElement(serialDesc, 11, self.transportId);
        output.encodeSerializableElement(serialDesc, 12, BookingHeaderResponseDTO$RefundInfo$$serializer.INSTANCE, self.refundInfo);
        output.encodeStringElement(serialDesc, 13, self.ticketTypeId);
        output.encodeStringElement(serialDesc, 14, self.timeTableId);
        output.encodeBooleanElement(serialDesc, 15, self.isEarlyCheckInPossible);
        output.encodeSerializableElement(serialDesc, 16, kSerializerArr[16], self.site);
        output.encodeNullableSerializableElement(serialDesc, 17, SublineDTO$$serializer.INSTANCE, self.subline);
        output.encodeNullableSerializableElement(serialDesc, 18, stringSerializer, self.lineLogoUrl);
    }

    /* renamed from: component1, reason: from getter */
    public final String getArrivalHarborName() {
        return this.arrivalHarborName;
    }

    /* renamed from: component10, reason: from getter */
    public final Duration getTravelTime() {
        return this.travelTime;
    }

    /* renamed from: component11, reason: from getter */
    public final String getRouteId() {
        return this.routeId;
    }

    /* renamed from: component12, reason: from getter */
    public final String getTransportId() {
        return this.transportId;
    }

    /* renamed from: component13, reason: from getter */
    public final RefundInfo getRefundInfo() {
        return this.refundInfo;
    }

    /* renamed from: component14, reason: from getter */
    public final String getTicketTypeId() {
        return this.ticketTypeId;
    }

    /* renamed from: component15, reason: from getter */
    public final String getTimeTableId() {
        return this.timeTableId;
    }

    /* renamed from: component16, reason: from getter */
    public final boolean getIsEarlyCheckInPossible() {
        return this.isEarlyCheckInPossible;
    }

    /* renamed from: component17, reason: from getter */
    public final SiteDTO getSite() {
        return this.site;
    }

    /* renamed from: component18, reason: from getter */
    public final SublineDTO getSubline() {
        return this.subline;
    }

    /* renamed from: component19, reason: from getter */
    public final String getLineLogoUrl() {
        return this.lineLogoUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    /* renamed from: component3, reason: from getter */
    public final LocalDateTime getDepartureDateTime() {
        return this.departureDateTime;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDepartureHarborName() {
        return this.departureHarborName;
    }

    /* renamed from: component5, reason: from getter */
    public final FerryResponseDTO getFerry() {
        return this.ferry;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsCheckedIn() {
        return this.isCheckedIn;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component8, reason: from getter */
    public final String getReservationId() {
        return this.reservationId;
    }

    /* renamed from: component9, reason: from getter */
    public final String getDepartureId() {
        return this.departureId;
    }

    public final BookingHeaderResponseDTO copy(String arrivalHarborName, LocalTime arrivalTime, LocalDateTime departureDateTime, String departureHarborName, FerryResponseDTO ferry, boolean isCheckedIn, String phone, String reservationId, String departureId, Duration travelTime, String routeId, String transportId, RefundInfo refundInfo, String ticketTypeId, String timeTableId, boolean isEarlyCheckInPossible, SiteDTO site, SublineDTO subline, String lineLogoUrl) {
        Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
        Intrinsics.checkNotNullParameter(departureDateTime, "departureDateTime");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(reservationId, "reservationId");
        Intrinsics.checkNotNullParameter(departureId, "departureId");
        Intrinsics.checkNotNullParameter(travelTime, "travelTime");
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        Intrinsics.checkNotNullParameter(transportId, "transportId");
        Intrinsics.checkNotNullParameter(refundInfo, "refundInfo");
        Intrinsics.checkNotNullParameter(ticketTypeId, "ticketTypeId");
        Intrinsics.checkNotNullParameter(timeTableId, "timeTableId");
        Intrinsics.checkNotNullParameter(site, "site");
        return new BookingHeaderResponseDTO(arrivalHarborName, arrivalTime, departureDateTime, departureHarborName, ferry, isCheckedIn, phone, reservationId, departureId, travelTime, routeId, transportId, refundInfo, ticketTypeId, timeTableId, isEarlyCheckInPossible, site, subline, lineLogoUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BookingHeaderResponseDTO)) {
            return false;
        }
        BookingHeaderResponseDTO bookingHeaderResponseDTO = (BookingHeaderResponseDTO) other;
        return Intrinsics.areEqual(this.arrivalHarborName, bookingHeaderResponseDTO.arrivalHarborName) && Intrinsics.areEqual(this.arrivalTime, bookingHeaderResponseDTO.arrivalTime) && Intrinsics.areEqual(this.departureDateTime, bookingHeaderResponseDTO.departureDateTime) && Intrinsics.areEqual(this.departureHarborName, bookingHeaderResponseDTO.departureHarborName) && Intrinsics.areEqual(this.ferry, bookingHeaderResponseDTO.ferry) && this.isCheckedIn == bookingHeaderResponseDTO.isCheckedIn && Intrinsics.areEqual(this.phone, bookingHeaderResponseDTO.phone) && Intrinsics.areEqual(this.reservationId, bookingHeaderResponseDTO.reservationId) && Intrinsics.areEqual(this.departureId, bookingHeaderResponseDTO.departureId) && Intrinsics.areEqual(this.travelTime, bookingHeaderResponseDTO.travelTime) && Intrinsics.areEqual(this.routeId, bookingHeaderResponseDTO.routeId) && Intrinsics.areEqual(this.transportId, bookingHeaderResponseDTO.transportId) && Intrinsics.areEqual(this.refundInfo, bookingHeaderResponseDTO.refundInfo) && Intrinsics.areEqual(this.ticketTypeId, bookingHeaderResponseDTO.ticketTypeId) && Intrinsics.areEqual(this.timeTableId, bookingHeaderResponseDTO.timeTableId) && this.isEarlyCheckInPossible == bookingHeaderResponseDTO.isEarlyCheckInPossible && this.site == bookingHeaderResponseDTO.site && Intrinsics.areEqual(this.subline, bookingHeaderResponseDTO.subline) && Intrinsics.areEqual(this.lineLogoUrl, bookingHeaderResponseDTO.lineLogoUrl);
    }

    public final String getArrivalHarborName() {
        return this.arrivalHarborName;
    }

    public final LocalTime getArrivalTime() {
        return this.arrivalTime;
    }

    public final LocalDateTime getDepartureDateTime() {
        return this.departureDateTime;
    }

    public final String getDepartureHarborName() {
        return this.departureHarborName;
    }

    public final String getDepartureId() {
        return this.departureId;
    }

    public final FerryResponseDTO getFerry() {
        return this.ferry;
    }

    public final String getLineLogoUrl() {
        return this.lineLogoUrl;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final RefundInfo getRefundInfo() {
        return this.refundInfo;
    }

    public final String getReservationId() {
        return this.reservationId;
    }

    public final String getRouteId() {
        return this.routeId;
    }

    public final SiteDTO getSite() {
        return this.site;
    }

    public final SublineDTO getSubline() {
        return this.subline;
    }

    public final String getTicketTypeId() {
        return this.ticketTypeId;
    }

    public final String getTimeTableId() {
        return this.timeTableId;
    }

    public final String getTransportId() {
        return this.transportId;
    }

    public final Duration getTravelTime() {
        return this.travelTime;
    }

    public int hashCode() {
        String str = this.arrivalHarborName;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.arrivalTime.hashCode()) * 31) + this.departureDateTime.hashCode()) * 31;
        String str2 = this.departureHarborName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        FerryResponseDTO ferryResponseDTO = this.ferry;
        int hashCode3 = (((((((((((((((((((((((((hashCode2 + (ferryResponseDTO == null ? 0 : ferryResponseDTO.hashCode())) * 31) + Boolean.hashCode(this.isCheckedIn)) * 31) + this.phone.hashCode()) * 31) + this.reservationId.hashCode()) * 31) + this.departureId.hashCode()) * 31) + this.travelTime.hashCode()) * 31) + this.routeId.hashCode()) * 31) + this.transportId.hashCode()) * 31) + this.refundInfo.hashCode()) * 31) + this.ticketTypeId.hashCode()) * 31) + this.timeTableId.hashCode()) * 31) + Boolean.hashCode(this.isEarlyCheckInPossible)) * 31) + this.site.hashCode()) * 31;
        SublineDTO sublineDTO = this.subline;
        int hashCode4 = (hashCode3 + (sublineDTO == null ? 0 : sublineDTO.hashCode())) * 31;
        String str3 = this.lineLogoUrl;
        return hashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean isCheckedIn() {
        return this.isCheckedIn;
    }

    public final boolean isEarlyCheckInPossible() {
        return this.isEarlyCheckInPossible;
    }

    public String toString() {
        return "BookingHeaderResponseDTO(arrivalHarborName=" + this.arrivalHarborName + ", arrivalTime=" + this.arrivalTime + ", departureDateTime=" + this.departureDateTime + ", departureHarborName=" + this.departureHarborName + ", ferry=" + this.ferry + ", isCheckedIn=" + this.isCheckedIn + ", phone=" + this.phone + ", reservationId=" + this.reservationId + ", departureId=" + this.departureId + ", travelTime=" + this.travelTime + ", routeId=" + this.routeId + ", transportId=" + this.transportId + ", refundInfo=" + this.refundInfo + ", ticketTypeId=" + this.ticketTypeId + ", timeTableId=" + this.timeTableId + ", isEarlyCheckInPossible=" + this.isEarlyCheckInPossible + ", site=" + this.site + ", subline=" + this.subline + ", lineLogoUrl=" + this.lineLogoUrl + ")";
    }

    public BookingHeaderResponseDTO(String str, LocalTime arrivalTime, LocalDateTime departureDateTime, String str2, FerryResponseDTO ferryResponseDTO, boolean z5, String phone, String reservationId, String departureId, Duration travelTime, String routeId, String transportId, RefundInfo refundInfo, String ticketTypeId, String timeTableId, boolean z6, SiteDTO site, SublineDTO sublineDTO, String str3) {
        Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
        Intrinsics.checkNotNullParameter(departureDateTime, "departureDateTime");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(reservationId, "reservationId");
        Intrinsics.checkNotNullParameter(departureId, "departureId");
        Intrinsics.checkNotNullParameter(travelTime, "travelTime");
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        Intrinsics.checkNotNullParameter(transportId, "transportId");
        Intrinsics.checkNotNullParameter(refundInfo, "refundInfo");
        Intrinsics.checkNotNullParameter(ticketTypeId, "ticketTypeId");
        Intrinsics.checkNotNullParameter(timeTableId, "timeTableId");
        Intrinsics.checkNotNullParameter(site, "site");
        this.arrivalHarborName = str;
        this.arrivalTime = arrivalTime;
        this.departureDateTime = departureDateTime;
        this.departureHarborName = str2;
        this.ferry = ferryResponseDTO;
        this.isCheckedIn = z5;
        this.phone = phone;
        this.reservationId = reservationId;
        this.departureId = departureId;
        this.travelTime = travelTime;
        this.routeId = routeId;
        this.transportId = transportId;
        this.refundInfo = refundInfo;
        this.ticketTypeId = ticketTypeId;
        this.timeTableId = timeTableId;
        this.isEarlyCheckInPossible = z6;
        this.site = site;
        this.subline = sublineDTO;
        this.lineLogoUrl = str3;
    }
}
