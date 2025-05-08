package dk.molslinjen.api.services.booking.response.booking;

import com.sdk.growthbook.utils.Constants;
import com.sun.jna.Function;
import dk.molslinjen.api.helpers.serializers.DurationSerializer;
import dk.molslinjen.api.helpers.serializers.IntToEnumSerializer;
import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.helpers.serializers.LocalTimeSerializer;
import dk.molslinjen.api.helpers.serializers.SerializableEnum;
import dk.molslinjen.api.services.account.passenger.response.GenderDTO;
import dk.molslinjen.api.services.booking.request.DirectionDTO;
import dk.molslinjen.api.services.booking.response.ProductTypeResponseDTO;
import dk.molslinjen.api.services.booking.response.booking.AgeGroupResponseDTO;
import dk.molslinjen.api.shared.response.HarborDTO;
import dk.molslinjen.api.shared.response.HarborDTO$$serializer;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO$$serializer;
import dk.molslinjen.api.shared.response.RouteTypeResponseDTO;
import dk.molslinjen.api.shared.response.SublineDTO;
import dk.molslinjen.api.shared.response.SublineDTO$$serializer;
import dk.molslinjen.api.shared.response.TicketSurchargeDTO;
import dk.molslinjen.api.shared.response.TicketSurchargeDTO$$serializer;
import dk.molslinjen.api.shared.response.TransportResponseDTO;
import dk.molslinjen.api.shared.response.TransportResponseDTO$$serializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0087\b\u0018\u0000 d2\u00020\u0001:\u0014QRSTUVWXYZ[\\]^_`abcdB\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aB¥\u0001\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u0019\u0010\u001fJ\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0013HÆ\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0018HÆ\u0003J¥\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÆ\u0001J\u0013\u0010E\u001a\u00020\u00052\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\u001cHÖ\u0001J\t\u0010H\u001a\u00020\u0013HÖ\u0001J%\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0001¢\u0006\u0002\bPR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010#R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0013\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010#R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010#R\u001c\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010,\u001a\u0004\b0\u00101R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b4\u00105¨\u0006e"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO;", BuildConfig.FLAVOR, "authenticationInfo", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$AuthenticationInfoResponseDTO;", "canChange", BuildConfig.FLAVOR, "customerInfo", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$CustomerInfoResponseDTO;", "orderTotal", "Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "isRefundAvailable", "changeFee", "refundAmount", "refundFee", "refundDate", "Lorg/threeten/bp/LocalDate;", "isRefunded", "isUsed", "reservationNumber", BuildConfig.FLAVOR, "tickets", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$TicketResponseDTO;", "multiRideInfo", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$MultiRideInfoResponseDTO;", "<init>", "(Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$AuthenticationInfoResponseDTO;ZLdk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$CustomerInfoResponseDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;ZLdk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Lorg/threeten/bp/LocalDate;ZZLjava/lang/String;Ljava/util/List;Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$MultiRideInfoResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$AuthenticationInfoResponseDTO;ZLdk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$CustomerInfoResponseDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;ZLdk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Lorg/threeten/bp/LocalDate;ZZLjava/lang/String;Ljava/util/List;Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$MultiRideInfoResponseDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAuthenticationInfo", "()Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$AuthenticationInfoResponseDTO;", "getCanChange", "()Z", "getCustomerInfo", "()Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$CustomerInfoResponseDTO;", "getOrderTotal", "()Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "getChangeFee", "getRefundAmount", "getRefundFee", "getRefundDate$annotations", "()V", "getRefundDate", "()Lorg/threeten/bp/LocalDate;", "getReservationNumber$annotations", "getReservationNumber", "()Ljava/lang/String;", "getTickets", "()Ljava/util/List;", "getMultiRideInfo", "()Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$MultiRideInfoResponseDTO;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "AuthenticationInfoResponseDTO", "CustomerInfoResponseDTO", "TicketResponseDTO", "TransportInfoDTO", "BookingSeatReservationDTO", "BookingSeatDTO", "SeatTypeDTO", "BarcodeResponseDTO", "CommuteAgreementResponseDTO", "DepartureResponseDTO", "EditInfoResponseDTO", "GoodsResponseDTO", "LineItemResponseDTO", "PassengerInfoResponseDTO", "MultiRideInfoResponseDTO", "BookingPassengerResponseDTO", "BarcodeTypeResponseDTO", "AvailabilityResponseDTO", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class BookingResponseDTO {
    private final AuthenticationInfoResponseDTO authenticationInfo;
    private final boolean canChange;
    private final PriceWithCurrencyDTO changeFee;
    private final CustomerInfoResponseDTO customerInfo;
    private final boolean isRefundAvailable;
    private final boolean isRefunded;
    private final boolean isUsed;
    private final MultiRideInfoResponseDTO multiRideInfo;
    private final PriceWithCurrencyDTO orderTotal;
    private final PriceWithCurrencyDTO refundAmount;
    private final LocalDate refundDate;
    private final PriceWithCurrencyDTO refundFee;
    private final String reservationNumber;
    private final List<TicketResponseDTO> tickets;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, new ArrayListSerializer(BookingResponseDTO$TicketResponseDTO$$serializer.INSTANCE), null};

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$AuthenticationInfoResponseDTO;", BuildConfig.FLAVOR, "commuteAgreement", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$CommuteAgreementResponseDTO;", "multiRideId", BuildConfig.FLAVOR, "<init>", "(Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$CommuteAgreementResponseDTO;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$CommuteAgreementResponseDTO;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCommuteAgreement", "()Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$CommuteAgreementResponseDTO;", "getMultiRideId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class AuthenticationInfoResponseDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final CommuteAgreementResponseDTO commuteAgreement;
        private final String multiRideId;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$AuthenticationInfoResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$AuthenticationInfoResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<AuthenticationInfoResponseDTO> serializer() {
                return BookingResponseDTO$AuthenticationInfoResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ AuthenticationInfoResponseDTO(int i5, CommuteAgreementResponseDTO commuteAgreementResponseDTO, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i5 & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 3, BookingResponseDTO$AuthenticationInfoResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.commuteAgreement = commuteAgreementResponseDTO;
            this.multiRideId = str;
        }

        public static /* synthetic */ AuthenticationInfoResponseDTO copy$default(AuthenticationInfoResponseDTO authenticationInfoResponseDTO, CommuteAgreementResponseDTO commuteAgreementResponseDTO, String str, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                commuteAgreementResponseDTO = authenticationInfoResponseDTO.commuteAgreement;
            }
            if ((i5 & 2) != 0) {
                str = authenticationInfoResponseDTO.multiRideId;
            }
            return authenticationInfoResponseDTO.copy(commuteAgreementResponseDTO, str);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(AuthenticationInfoResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, BookingResponseDTO$CommuteAgreementResponseDTO$$serializer.INSTANCE, self.commuteAgreement);
            output.encodeStringElement(serialDesc, 1, self.multiRideId);
        }

        /* renamed from: component1, reason: from getter */
        public final CommuteAgreementResponseDTO getCommuteAgreement() {
            return this.commuteAgreement;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMultiRideId() {
            return this.multiRideId;
        }

        public final AuthenticationInfoResponseDTO copy(CommuteAgreementResponseDTO commuteAgreement, String multiRideId) {
            Intrinsics.checkNotNullParameter(commuteAgreement, "commuteAgreement");
            Intrinsics.checkNotNullParameter(multiRideId, "multiRideId");
            return new AuthenticationInfoResponseDTO(commuteAgreement, multiRideId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AuthenticationInfoResponseDTO)) {
                return false;
            }
            AuthenticationInfoResponseDTO authenticationInfoResponseDTO = (AuthenticationInfoResponseDTO) other;
            return Intrinsics.areEqual(this.commuteAgreement, authenticationInfoResponseDTO.commuteAgreement) && Intrinsics.areEqual(this.multiRideId, authenticationInfoResponseDTO.multiRideId);
        }

        public final CommuteAgreementResponseDTO getCommuteAgreement() {
            return this.commuteAgreement;
        }

        public final String getMultiRideId() {
            return this.multiRideId;
        }

        public int hashCode() {
            return (this.commuteAgreement.hashCode() * 31) + this.multiRideId.hashCode();
        }

        public String toString() {
            return "AuthenticationInfoResponseDTO(commuteAgreement=" + this.commuteAgreement + ", multiRideId=" + this.multiRideId + ")";
        }

        public AuthenticationInfoResponseDTO(CommuteAgreementResponseDTO commuteAgreement, String multiRideId) {
            Intrinsics.checkNotNullParameter(commuteAgreement, "commuteAgreement");
            Intrinsics.checkNotNullParameter(multiRideId, "multiRideId");
            this.commuteAgreement = commuteAgreement;
            this.multiRideId = multiRideId;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0087\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002\f\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$AvailabilityResponseDTO;", "Ldk/molslinjen/api/helpers/serializers/SerializableEnum;", BuildConfig.FLAVOR, "rawValue", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getRawValue", "()I", "None", "Route", "Departure", "Serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable(with = Serializer.class)
    /* loaded from: classes2.dex */
    public static final class AvailabilityResponseDTO implements SerializableEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AvailabilityResponseDTO[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final int rawValue;
        public static final AvailabilityResponseDTO None = new AvailabilityResponseDTO("None", 0, 0);
        public static final AvailabilityResponseDTO Route = new AvailabilityResponseDTO("Route", 1, 1);
        public static final AvailabilityResponseDTO Departure = new AvailabilityResponseDTO("Departure", 2, 2);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$AvailabilityResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$AvailabilityResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<AvailabilityResponseDTO> serializer() {
                return Serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$AvailabilityResponseDTO$Serializer;", "Ldk/molslinjen/api/helpers/serializers/IntToEnumSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$AvailabilityResponseDTO;", "<init>", "()V", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Serializer extends IntToEnumSerializer<AvailabilityResponseDTO> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(AvailabilityResponseDTO.class);
            }
        }

        private static final /* synthetic */ AvailabilityResponseDTO[] $values() {
            return new AvailabilityResponseDTO[]{None, Route, Departure};
        }

        static {
            AvailabilityResponseDTO[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
        }

        private AvailabilityResponseDTO(String str, int i5, int i6) {
            this.rawValue = i6;
        }

        public static EnumEntries<AvailabilityResponseDTO> getEntries() {
            return $ENTRIES;
        }

        public static AvailabilityResponseDTO valueOf(String str) {
            return (AvailabilityResponseDTO) Enum.valueOf(AvailabilityResponseDTO.class, str);
        }

        public static AvailabilityResponseDTO[] values() {
            return (AvailabilityResponseDTO[]) $VALUES.clone();
        }

        @Override // dk.molslinjen.api.helpers.serializers.SerializableEnum
        public int getRawValue() {
            return this.rawValue;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BarcodeResponseDTO;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "type", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BarcodeTypeResponseDTO;", "<init>", "(Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BarcodeTypeResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BarcodeTypeResponseDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getType", "()Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BarcodeTypeResponseDTO;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class BarcodeResponseDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String id;
        private final BarcodeTypeResponseDTO type;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BarcodeResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BarcodeResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<BarcodeResponseDTO> serializer() {
                return BookingResponseDTO$BarcodeResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ BarcodeResponseDTO(int i5, String str, BarcodeTypeResponseDTO barcodeTypeResponseDTO, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i5 & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 3, BookingResponseDTO$BarcodeResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.type = barcodeTypeResponseDTO;
        }

        public static /* synthetic */ BarcodeResponseDTO copy$default(BarcodeResponseDTO barcodeResponseDTO, String str, BarcodeTypeResponseDTO barcodeTypeResponseDTO, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = barcodeResponseDTO.id;
            }
            if ((i5 & 2) != 0) {
                barcodeTypeResponseDTO = barcodeResponseDTO.type;
            }
            return barcodeResponseDTO.copy(str, barcodeTypeResponseDTO);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(BarcodeResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeSerializableElement(serialDesc, 1, BarcodeTypeResponseDTO.Serializer.INSTANCE, self.type);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final BarcodeTypeResponseDTO getType() {
            return this.type;
        }

        public final BarcodeResponseDTO copy(String id, BarcodeTypeResponseDTO type) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            return new BarcodeResponseDTO(id, type);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BarcodeResponseDTO)) {
                return false;
            }
            BarcodeResponseDTO barcodeResponseDTO = (BarcodeResponseDTO) other;
            return Intrinsics.areEqual(this.id, barcodeResponseDTO.id) && this.type == barcodeResponseDTO.type;
        }

        public final String getId() {
            return this.id;
        }

        public final BarcodeTypeResponseDTO getType() {
            return this.type;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.type.hashCode();
        }

        public String toString() {
            return "BarcodeResponseDTO(id=" + this.id + ", type=" + this.type + ")";
        }

        public BarcodeResponseDTO(String id, BarcodeTypeResponseDTO type) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.type = type;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002\u000b\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BarcodeTypeResponseDTO;", "Ldk/molslinjen/api/helpers/serializers/SerializableEnum;", BuildConfig.FLAVOR, "rawValue", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getRawValue", "()I", "Catering", "Lounge", "Serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable(with = Serializer.class)
    /* loaded from: classes2.dex */
    public static final class BarcodeTypeResponseDTO implements SerializableEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ BarcodeTypeResponseDTO[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final int rawValue;
        public static final BarcodeTypeResponseDTO Catering = new BarcodeTypeResponseDTO("Catering", 0, 0);
        public static final BarcodeTypeResponseDTO Lounge = new BarcodeTypeResponseDTO("Lounge", 1, 1);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BarcodeTypeResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BarcodeTypeResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<BarcodeTypeResponseDTO> serializer() {
                return Serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BarcodeTypeResponseDTO$Serializer;", "Ldk/molslinjen/api/helpers/serializers/IntToEnumSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BarcodeTypeResponseDTO;", "<init>", "()V", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Serializer extends IntToEnumSerializer<BarcodeTypeResponseDTO> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(BarcodeTypeResponseDTO.class);
            }
        }

        private static final /* synthetic */ BarcodeTypeResponseDTO[] $values() {
            return new BarcodeTypeResponseDTO[]{Catering, Lounge};
        }

        static {
            BarcodeTypeResponseDTO[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
        }

        private BarcodeTypeResponseDTO(String str, int i5, int i6) {
            this.rawValue = i6;
        }

        public static EnumEntries<BarcodeTypeResponseDTO> getEntries() {
            return $ENTRIES;
        }

        public static BarcodeTypeResponseDTO valueOf(String str) {
            return (BarcodeTypeResponseDTO) Enum.valueOf(BarcodeTypeResponseDTO.class, str);
        }

        public static BarcodeTypeResponseDTO[] values() {
            return (BarcodeTypeResponseDTO[]) $VALUES.clone();
        }

        @Override // dk.molslinjen.api.helpers.serializers.SerializableEnum
        public int getRawValue() {
            return this.rawValue;
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000234B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rBW\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003JE\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u000fHÖ\u0001J\t\u0010*\u001a\u00020\u0007HÖ\u0001J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00065"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingPassengerResponseDTO;", BuildConfig.FLAVOR, "ageGroup", "Ldk/molslinjen/api/services/booking/response/booking/AgeGroupResponseDTO;", "birthDate", "Lorg/threeten/bp/LocalDate;", "firstName", BuildConfig.FLAVOR, "lastName", "nationality", "sex", "Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;", "<init>", "(Ldk/molslinjen/api/services/booking/response/booking/AgeGroupResponseDTO;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/api/services/booking/response/booking/AgeGroupResponseDTO;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAgeGroup", "()Ldk/molslinjen/api/services/booking/response/booking/AgeGroupResponseDTO;", "getBirthDate$annotations", "()V", "getBirthDate", "()Lorg/threeten/bp/LocalDate;", "getFirstName", "()Ljava/lang/String;", "getLastName", "getNationality", "getSex", "()Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class BookingPassengerResponseDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final AgeGroupResponseDTO ageGroup;
        private final LocalDate birthDate;
        private final String firstName;
        private final String lastName;
        private final String nationality;
        private final GenderDTO sex;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingPassengerResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingPassengerResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<BookingPassengerResponseDTO> serializer() {
                return BookingResponseDTO$BookingPassengerResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ BookingPassengerResponseDTO(int i5, AgeGroupResponseDTO ageGroupResponseDTO, LocalDate localDate, String str, String str2, String str3, GenderDTO genderDTO, SerializationConstructorMarker serializationConstructorMarker) {
            if (63 != (i5 & 63)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 63, BookingResponseDTO$BookingPassengerResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.ageGroup = ageGroupResponseDTO;
            this.birthDate = localDate;
            this.firstName = str;
            this.lastName = str2;
            this.nationality = str3;
            this.sex = genderDTO;
        }

        public static /* synthetic */ BookingPassengerResponseDTO copy$default(BookingPassengerResponseDTO bookingPassengerResponseDTO, AgeGroupResponseDTO ageGroupResponseDTO, LocalDate localDate, String str, String str2, String str3, GenderDTO genderDTO, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                ageGroupResponseDTO = bookingPassengerResponseDTO.ageGroup;
            }
            if ((i5 & 2) != 0) {
                localDate = bookingPassengerResponseDTO.birthDate;
            }
            LocalDate localDate2 = localDate;
            if ((i5 & 4) != 0) {
                str = bookingPassengerResponseDTO.firstName;
            }
            String str4 = str;
            if ((i5 & 8) != 0) {
                str2 = bookingPassengerResponseDTO.lastName;
            }
            String str5 = str2;
            if ((i5 & 16) != 0) {
                str3 = bookingPassengerResponseDTO.nationality;
            }
            String str6 = str3;
            if ((i5 & 32) != 0) {
                genderDTO = bookingPassengerResponseDTO.sex;
            }
            return bookingPassengerResponseDTO.copy(ageGroupResponseDTO, localDate2, str4, str5, str6, genderDTO);
        }

        @Serializable(with = LocalDateWithTimeSerializer.class)
        public static /* synthetic */ void getBirthDate$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(BookingPassengerResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, AgeGroupResponseDTO.Serializer.INSTANCE, self.ageGroup);
            output.encodeSerializableElement(serialDesc, 1, LocalDateWithTimeSerializer.INSTANCE, self.birthDate);
            output.encodeStringElement(serialDesc, 2, self.firstName);
            output.encodeStringElement(serialDesc, 3, self.lastName);
            output.encodeStringElement(serialDesc, 4, self.nationality);
            output.encodeSerializableElement(serialDesc, 5, GenderDTO.Serializer.INSTANCE, self.sex);
        }

        /* renamed from: component1, reason: from getter */
        public final AgeGroupResponseDTO getAgeGroup() {
            return this.ageGroup;
        }

        /* renamed from: component2, reason: from getter */
        public final LocalDate getBirthDate() {
            return this.birthDate;
        }

        /* renamed from: component3, reason: from getter */
        public final String getFirstName() {
            return this.firstName;
        }

        /* renamed from: component4, reason: from getter */
        public final String getLastName() {
            return this.lastName;
        }

        /* renamed from: component5, reason: from getter */
        public final String getNationality() {
            return this.nationality;
        }

        /* renamed from: component6, reason: from getter */
        public final GenderDTO getSex() {
            return this.sex;
        }

        public final BookingPassengerResponseDTO copy(AgeGroupResponseDTO ageGroup, LocalDate birthDate, String firstName, String lastName, String nationality, GenderDTO sex) {
            Intrinsics.checkNotNullParameter(ageGroup, "ageGroup");
            Intrinsics.checkNotNullParameter(birthDate, "birthDate");
            Intrinsics.checkNotNullParameter(firstName, "firstName");
            Intrinsics.checkNotNullParameter(lastName, "lastName");
            Intrinsics.checkNotNullParameter(nationality, "nationality");
            Intrinsics.checkNotNullParameter(sex, "sex");
            return new BookingPassengerResponseDTO(ageGroup, birthDate, firstName, lastName, nationality, sex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BookingPassengerResponseDTO)) {
                return false;
            }
            BookingPassengerResponseDTO bookingPassengerResponseDTO = (BookingPassengerResponseDTO) other;
            return this.ageGroup == bookingPassengerResponseDTO.ageGroup && Intrinsics.areEqual(this.birthDate, bookingPassengerResponseDTO.birthDate) && Intrinsics.areEqual(this.firstName, bookingPassengerResponseDTO.firstName) && Intrinsics.areEqual(this.lastName, bookingPassengerResponseDTO.lastName) && Intrinsics.areEqual(this.nationality, bookingPassengerResponseDTO.nationality) && this.sex == bookingPassengerResponseDTO.sex;
        }

        public final AgeGroupResponseDTO getAgeGroup() {
            return this.ageGroup;
        }

        public final LocalDate getBirthDate() {
            return this.birthDate;
        }

        public final String getFirstName() {
            return this.firstName;
        }

        public final String getLastName() {
            return this.lastName;
        }

        public final String getNationality() {
            return this.nationality;
        }

        public final GenderDTO getSex() {
            return this.sex;
        }

        public int hashCode() {
            return (((((((((this.ageGroup.hashCode() * 31) + this.birthDate.hashCode()) * 31) + this.firstName.hashCode()) * 31) + this.lastName.hashCode()) * 31) + this.nationality.hashCode()) * 31) + this.sex.hashCode();
        }

        public String toString() {
            return "BookingPassengerResponseDTO(ageGroup=" + this.ageGroup + ", birthDate=" + this.birthDate + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", nationality=" + this.nationality + ", sex=" + this.sex + ")";
        }

        public BookingPassengerResponseDTO(AgeGroupResponseDTO ageGroup, LocalDate birthDate, String firstName, String lastName, String nationality, GenderDTO sex) {
            Intrinsics.checkNotNullParameter(ageGroup, "ageGroup");
            Intrinsics.checkNotNullParameter(birthDate, "birthDate");
            Intrinsics.checkNotNullParameter(firstName, "firstName");
            Intrinsics.checkNotNullParameter(lastName, "lastName");
            Intrinsics.checkNotNullParameter(nationality, "nationality");
            Intrinsics.checkNotNullParameter(sex, "sex");
            this.ageGroup = ageGroup;
            this.birthDate = birthDate;
            this.firstName = firstName;
            this.lastName = lastName;
            this.nationality = nationality;
            this.sex = sex;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nBA\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006*"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingSeatDTO;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "seatPrice", "Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "text", BuildConfig.FLAVOR, "sectionName", "<init>", "(ILdk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILdk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()I", "getSeatPrice", "()Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "getText", "()Ljava/lang/String;", "getSectionName", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class BookingSeatDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int id;
        private final PriceWithCurrencyDTO seatPrice;
        private final String sectionName;
        private final String text;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingSeatDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingSeatDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<BookingSeatDTO> serializer() {
                return BookingResponseDTO$BookingSeatDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ BookingSeatDTO(int i5, int i6, PriceWithCurrencyDTO priceWithCurrencyDTO, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i5 & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 15, BookingResponseDTO$BookingSeatDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.id = i6;
            this.seatPrice = priceWithCurrencyDTO;
            this.text = str;
            this.sectionName = str2;
        }

        public static /* synthetic */ BookingSeatDTO copy$default(BookingSeatDTO bookingSeatDTO, int i5, PriceWithCurrencyDTO priceWithCurrencyDTO, String str, String str2, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i5 = bookingSeatDTO.id;
            }
            if ((i6 & 2) != 0) {
                priceWithCurrencyDTO = bookingSeatDTO.seatPrice;
            }
            if ((i6 & 4) != 0) {
                str = bookingSeatDTO.text;
            }
            if ((i6 & 8) != 0) {
                str2 = bookingSeatDTO.sectionName;
            }
            return bookingSeatDTO.copy(i5, priceWithCurrencyDTO, str, str2);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(BookingSeatDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeIntElement(serialDesc, 0, self.id);
            output.encodeSerializableElement(serialDesc, 1, PriceWithCurrencyDTO$$serializer.INSTANCE, self.seatPrice);
            output.encodeStringElement(serialDesc, 2, self.text);
            output.encodeStringElement(serialDesc, 3, self.sectionName);
        }

        /* renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final PriceWithCurrencyDTO getSeatPrice() {
            return this.seatPrice;
        }

        /* renamed from: component3, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component4, reason: from getter */
        public final String getSectionName() {
            return this.sectionName;
        }

        public final BookingSeatDTO copy(int id, PriceWithCurrencyDTO seatPrice, String text, String sectionName) {
            Intrinsics.checkNotNullParameter(seatPrice, "seatPrice");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(sectionName, "sectionName");
            return new BookingSeatDTO(id, seatPrice, text, sectionName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BookingSeatDTO)) {
                return false;
            }
            BookingSeatDTO bookingSeatDTO = (BookingSeatDTO) other;
            return this.id == bookingSeatDTO.id && Intrinsics.areEqual(this.seatPrice, bookingSeatDTO.seatPrice) && Intrinsics.areEqual(this.text, bookingSeatDTO.text) && Intrinsics.areEqual(this.sectionName, bookingSeatDTO.sectionName);
        }

        public final int getId() {
            return this.id;
        }

        public final PriceWithCurrencyDTO getSeatPrice() {
            return this.seatPrice;
        }

        public final String getSectionName() {
            return this.sectionName;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.id) * 31) + this.seatPrice.hashCode()) * 31) + this.text.hashCode()) * 31) + this.sectionName.hashCode();
        }

        public String toString() {
            return "BookingSeatDTO(id=" + this.id + ", seatPrice=" + this.seatPrice + ", text=" + this.text + ", sectionName=" + this.sectionName + ")";
        }

        public BookingSeatDTO(int i5, PriceWithCurrencyDTO seatPrice, String text, String sectionName) {
            Intrinsics.checkNotNullParameter(seatPrice, "seatPrice");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(sectionName, "sectionName");
            this.id = i5;
            this.seatPrice = seatPrice;
            this.text = text;
            this.sectionName = sectionName;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB3\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingSeatReservationDTO;", BuildConfig.FLAVOR, "seatReservationId", BuildConfig.FLAVOR, "seats", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingSeatDTO;", "<init>", "(ILjava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSeatReservationId", "()I", "getSeats", "()Ljava/util/List;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class BookingSeatReservationDTO {
        private final int seatReservationId;
        private final List<BookingSeatDTO> seats;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(BookingResponseDTO$BookingSeatDTO$$serializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingSeatReservationDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingSeatReservationDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<BookingSeatReservationDTO> serializer() {
                return BookingResponseDTO$BookingSeatReservationDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ BookingSeatReservationDTO(int i5, int i6, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i5 & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 3, BookingResponseDTO$BookingSeatReservationDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.seatReservationId = i6;
            this.seats = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BookingSeatReservationDTO copy$default(BookingSeatReservationDTO bookingSeatReservationDTO, int i5, List list, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i5 = bookingSeatReservationDTO.seatReservationId;
            }
            if ((i6 & 2) != 0) {
                list = bookingSeatReservationDTO.seats;
            }
            return bookingSeatReservationDTO.copy(i5, list);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(BookingSeatReservationDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeIntElement(serialDesc, 0, self.seatReservationId);
            output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.seats);
        }

        /* renamed from: component1, reason: from getter */
        public final int getSeatReservationId() {
            return this.seatReservationId;
        }

        public final List<BookingSeatDTO> component2() {
            return this.seats;
        }

        public final BookingSeatReservationDTO copy(int seatReservationId, List<BookingSeatDTO> seats) {
            Intrinsics.checkNotNullParameter(seats, "seats");
            return new BookingSeatReservationDTO(seatReservationId, seats);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BookingSeatReservationDTO)) {
                return false;
            }
            BookingSeatReservationDTO bookingSeatReservationDTO = (BookingSeatReservationDTO) other;
            return this.seatReservationId == bookingSeatReservationDTO.seatReservationId && Intrinsics.areEqual(this.seats, bookingSeatReservationDTO.seats);
        }

        public final int getSeatReservationId() {
            return this.seatReservationId;
        }

        public final List<BookingSeatDTO> getSeats() {
            return this.seats;
        }

        public int hashCode() {
            return (Integer.hashCode(this.seatReservationId) * 31) + this.seats.hashCode();
        }

        public String toString() {
            return "BookingSeatReservationDTO(seatReservationId=" + this.seatReservationId + ", seats=" + this.seats + ")";
        }

        public BookingSeatReservationDTO(int i5, List<BookingSeatDTO> seats) {
            Intrinsics.checkNotNullParameter(seats, "seats");
            this.seatReservationId = i5;
            this.seats = seats;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J%\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0001¢\u0006\u0002\b\u001bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$CommuteAgreementResponseDTO;", BuildConfig.FLAVOR, "agreementId", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAgreementId", "()Ljava/lang/String;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class CommuteAgreementResponseDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String agreementId;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$CommuteAgreementResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$CommuteAgreementResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<CommuteAgreementResponseDTO> serializer() {
                return BookingResponseDTO$CommuteAgreementResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ CommuteAgreementResponseDTO(int i5, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i5 & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 1, BookingResponseDTO$CommuteAgreementResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.agreementId = str;
        }

        public static /* synthetic */ CommuteAgreementResponseDTO copy$default(CommuteAgreementResponseDTO commuteAgreementResponseDTO, String str, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = commuteAgreementResponseDTO.agreementId;
            }
            return commuteAgreementResponseDTO.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAgreementId() {
            return this.agreementId;
        }

        public final CommuteAgreementResponseDTO copy(String agreementId) {
            return new CommuteAgreementResponseDTO(agreementId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CommuteAgreementResponseDTO) && Intrinsics.areEqual(this.agreementId, ((CommuteAgreementResponseDTO) other).agreementId);
        }

        public final String getAgreementId() {
            return this.agreementId;
        }

        public int hashCode() {
            String str = this.agreementId;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "CommuteAgreementResponseDTO(agreementId=" + this.agreementId + ")";
        }

        public CommuteAgreementResponseDTO(String str) {
            this.agreementId = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<BookingResponseDTO> serializer() {
            return BookingResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tBM\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u000bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0010¨\u0006,"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$CustomerInfoResponseDTO;", BuildConfig.FLAVOR, "email", BuildConfig.FLAVOR, "phone", "postalCode", "prefix", "licensePlate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEmail", "()Ljava/lang/String;", "getPhone", "getPostalCode", "getPrefix", "getLicensePlate$annotations", "()V", "getLicensePlate", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class CustomerInfoResponseDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String email;
        private final String licensePlate;
        private final String phone;
        private final String postalCode;
        private final String prefix;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$CustomerInfoResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$CustomerInfoResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<CustomerInfoResponseDTO> serializer() {
                return BookingResponseDTO$CustomerInfoResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ CustomerInfoResponseDTO(int i5, String str, String str2, String str3, String str4, String str5, SerializationConstructorMarker serializationConstructorMarker) {
            if (31 != (i5 & 31)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 31, BookingResponseDTO$CustomerInfoResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.email = str;
            this.phone = str2;
            this.postalCode = str3;
            this.prefix = str4;
            this.licensePlate = str5;
        }

        public static /* synthetic */ CustomerInfoResponseDTO copy$default(CustomerInfoResponseDTO customerInfoResponseDTO, String str, String str2, String str3, String str4, String str5, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = customerInfoResponseDTO.email;
            }
            if ((i5 & 2) != 0) {
                str2 = customerInfoResponseDTO.phone;
            }
            String str6 = str2;
            if ((i5 & 4) != 0) {
                str3 = customerInfoResponseDTO.postalCode;
            }
            String str7 = str3;
            if ((i5 & 8) != 0) {
                str4 = customerInfoResponseDTO.prefix;
            }
            String str8 = str4;
            if ((i5 & 16) != 0) {
                str5 = customerInfoResponseDTO.licensePlate;
            }
            return customerInfoResponseDTO.copy(str, str6, str7, str8, str5);
        }

        public static /* synthetic */ void getLicensePlate$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(CustomerInfoResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.email);
            output.encodeStringElement(serialDesc, 1, self.phone);
            output.encodeStringElement(serialDesc, 2, self.postalCode);
            output.encodeStringElement(serialDesc, 3, self.prefix);
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.licensePlate);
        }

        /* renamed from: component1, reason: from getter */
        public final String getEmail() {
            return this.email;
        }

        /* renamed from: component2, reason: from getter */
        public final String getPhone() {
            return this.phone;
        }

        /* renamed from: component3, reason: from getter */
        public final String getPostalCode() {
            return this.postalCode;
        }

        /* renamed from: component4, reason: from getter */
        public final String getPrefix() {
            return this.prefix;
        }

        /* renamed from: component5, reason: from getter */
        public final String getLicensePlate() {
            return this.licensePlate;
        }

        public final CustomerInfoResponseDTO copy(String email, String phone, String postalCode, String prefix, String licensePlate) {
            Intrinsics.checkNotNullParameter(email, "email");
            Intrinsics.checkNotNullParameter(phone, "phone");
            Intrinsics.checkNotNullParameter(postalCode, "postalCode");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            return new CustomerInfoResponseDTO(email, phone, postalCode, prefix, licensePlate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CustomerInfoResponseDTO)) {
                return false;
            }
            CustomerInfoResponseDTO customerInfoResponseDTO = (CustomerInfoResponseDTO) other;
            return Intrinsics.areEqual(this.email, customerInfoResponseDTO.email) && Intrinsics.areEqual(this.phone, customerInfoResponseDTO.phone) && Intrinsics.areEqual(this.postalCode, customerInfoResponseDTO.postalCode) && Intrinsics.areEqual(this.prefix, customerInfoResponseDTO.prefix) && Intrinsics.areEqual(this.licensePlate, customerInfoResponseDTO.licensePlate);
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getLicensePlate() {
            return this.licensePlate;
        }

        public final String getPhone() {
            return this.phone;
        }

        public final String getPostalCode() {
            return this.postalCode;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public int hashCode() {
            int hashCode = ((((((this.email.hashCode() * 31) + this.phone.hashCode()) * 31) + this.postalCode.hashCode()) * 31) + this.prefix.hashCode()) * 31;
            String str = this.licensePlate;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "CustomerInfoResponseDTO(email=" + this.email + ", phone=" + this.phone + ", postalCode=" + this.postalCode + ", prefix=" + this.prefix + ", licensePlate=" + this.licensePlate + ")";
        }

        public CustomerInfoResponseDTO(String email, String phone, String postalCode, String prefix, String str) {
            Intrinsics.checkNotNullParameter(email, "email");
            Intrinsics.checkNotNullParameter(phone, "phone");
            Intrinsics.checkNotNullParameter(postalCode, "postalCode");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            this.email = email;
            this.phone = phone;
            this.postalCode = postalCode;
            this.prefix = prefix;
            this.licensePlate = str;
        }
    }

    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ^2\u00020\u0001:\u0002]^B\u0093\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001c\u0010\u001dB¿\u0001\b\u0010\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0004\b\u001c\u0010\"J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0007HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0007HÆ\u0003J\t\u0010E\u001a\u00020\u0007HÆ\u0003J\t\u0010F\u001a\u00020\u0007HÆ\u0003J\u000f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\t\u0010H\u001a\u00020\u0007HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u0010J\u001a\u00020\u0013HÆ\u0003J\t\u0010K\u001a\u00020\u0015HÆ\u0003J\t\u0010L\u001a\u00020\u0015HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010N\u001a\u00020\u0019HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u001bHÆ\u0003Jµ\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÆ\u0001J\u0013\u0010Q\u001a\u00020\u00192\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020\u001fHÖ\u0001J\t\u0010T\u001a\u00020\u0007HÖ\u0001J%\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u00002\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H\u0001¢\u0006\u0002\b\\R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010$\u001a\u0004\b(\u0010)R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010$\u001a\u0004\b-\u0010&R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010+R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010+R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u0010+R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001c\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010$\u001a\u0004\b7\u00108R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010\u0016\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b;\u0010:R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b<\u0010+R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010=R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?¨\u0006_"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$DepartureResponseDTO;", BuildConfig.FLAVOR, "arrivalTime", "Lorg/threeten/bp/LocalTime;", "date", "Lorg/threeten/bp/LocalDate;", "departureId", BuildConfig.FLAVOR, "departureTime", "regionId", "routeId", "mainRouteId", "routeTypes", BuildConfig.FLAVOR, "Ldk/molslinjen/api/shared/response/RouteTypeResponseDTO;", "timeTableId", "ferry", "Ldk/molslinjen/api/services/booking/response/booking/FerryResponseDTO;", "travelTime", "Lorg/threeten/bp/Duration;", "departureHarbor", "Ldk/molslinjen/api/shared/response/HarborDTO;", "arrivalHarbor", "transportSwitchDescription", "isEarlyCheckInPossible", BuildConfig.FLAVOR, "subline", "Ldk/molslinjen/api/shared/response/SublineDTO;", "<init>", "(Lorg/threeten/bp/LocalTime;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Lorg/threeten/bp/LocalTime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/booking/FerryResponseDTO;Lorg/threeten/bp/Duration;Ldk/molslinjen/api/shared/response/HarborDTO;Ldk/molslinjen/api/shared/response/HarborDTO;Ljava/lang/String;ZLdk/molslinjen/api/shared/response/SublineDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILorg/threeten/bp/LocalTime;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Lorg/threeten/bp/LocalTime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/booking/FerryResponseDTO;Lorg/threeten/bp/Duration;Ldk/molslinjen/api/shared/response/HarborDTO;Ldk/molslinjen/api/shared/response/HarborDTO;Ljava/lang/String;ZLdk/molslinjen/api/shared/response/SublineDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getArrivalTime$annotations", "()V", "getArrivalTime", "()Lorg/threeten/bp/LocalTime;", "getDate$annotations", "getDate", "()Lorg/threeten/bp/LocalDate;", "getDepartureId", "()Ljava/lang/String;", "getDepartureTime$annotations", "getDepartureTime", "getRegionId", "getRouteId", "getMainRouteId", "getRouteTypes", "()Ljava/util/List;", "getTimeTableId", "getFerry", "()Ldk/molslinjen/api/services/booking/response/booking/FerryResponseDTO;", "getTravelTime$annotations", "getTravelTime", "()Lorg/threeten/bp/Duration;", "getDepartureHarbor", "()Ldk/molslinjen/api/shared/response/HarborDTO;", "getArrivalHarbor", "getTransportSwitchDescription", "()Z", "getSubline", "()Ldk/molslinjen/api/shared/response/SublineDTO;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class DepartureResponseDTO {
        private final HarborDTO arrivalHarbor;
        private final LocalTime arrivalTime;
        private final LocalDate date;
        private final HarborDTO departureHarbor;
        private final String departureId;
        private final LocalTime departureTime;
        private final FerryResponseDTO ferry;
        private final boolean isEarlyCheckInPossible;
        private final String mainRouteId;
        private final String regionId;
        private final String routeId;
        private final List<RouteTypeResponseDTO> routeTypes;
        private final SublineDTO subline;
        private final String timeTableId;
        private final String transportSwitchDescription;
        private final Duration travelTime;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, new ArrayListSerializer(RouteTypeResponseDTO.Serializer.INSTANCE), null, null, null, null, null, null, null, null};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$DepartureResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$DepartureResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<DepartureResponseDTO> serializer() {
                return BookingResponseDTO$DepartureResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ DepartureResponseDTO(int i5, LocalTime localTime, LocalDate localDate, String str, LocalTime localTime2, String str2, String str3, String str4, List list, String str5, FerryResponseDTO ferryResponseDTO, Duration duration, HarborDTO harborDTO, HarborDTO harborDTO2, String str6, boolean z5, SublineDTO sublineDTO, SerializationConstructorMarker serializationConstructorMarker) {
            if (65535 != (i5 & 65535)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 65535, BookingResponseDTO$DepartureResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.arrivalTime = localTime;
            this.date = localDate;
            this.departureId = str;
            this.departureTime = localTime2;
            this.regionId = str2;
            this.routeId = str3;
            this.mainRouteId = str4;
            this.routeTypes = list;
            this.timeTableId = str5;
            this.ferry = ferryResponseDTO;
            this.travelTime = duration;
            this.departureHarbor = harborDTO;
            this.arrivalHarbor = harborDTO2;
            this.transportSwitchDescription = str6;
            this.isEarlyCheckInPossible = z5;
            this.subline = sublineDTO;
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

        @Serializable(with = DurationSerializer.class)
        public static /* synthetic */ void getTravelTime$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(DepartureResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
            output.encodeSerializableElement(serialDesc, 0, localTimeSerializer, self.arrivalTime);
            output.encodeSerializableElement(serialDesc, 1, LocalDateWithTimeSerializer.INSTANCE, self.date);
            output.encodeStringElement(serialDesc, 2, self.departureId);
            output.encodeSerializableElement(serialDesc, 3, localTimeSerializer, self.departureTime);
            output.encodeStringElement(serialDesc, 4, self.regionId);
            output.encodeStringElement(serialDesc, 5, self.routeId);
            output.encodeStringElement(serialDesc, 6, self.mainRouteId);
            output.encodeSerializableElement(serialDesc, 7, kSerializerArr[7], self.routeTypes);
            output.encodeStringElement(serialDesc, 8, self.timeTableId);
            output.encodeNullableSerializableElement(serialDesc, 9, FerryResponseDTO$$serializer.INSTANCE, self.ferry);
            output.encodeSerializableElement(serialDesc, 10, DurationSerializer.INSTANCE, self.travelTime);
            HarborDTO$$serializer harborDTO$$serializer = HarborDTO$$serializer.INSTANCE;
            output.encodeSerializableElement(serialDesc, 11, harborDTO$$serializer, self.departureHarbor);
            output.encodeSerializableElement(serialDesc, 12, harborDTO$$serializer, self.arrivalHarbor);
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.transportSwitchDescription);
            output.encodeBooleanElement(serialDesc, 14, self.isEarlyCheckInPossible);
            output.encodeNullableSerializableElement(serialDesc, 15, SublineDTO$$serializer.INSTANCE, self.subline);
        }

        /* renamed from: component1, reason: from getter */
        public final LocalTime getArrivalTime() {
            return this.arrivalTime;
        }

        /* renamed from: component10, reason: from getter */
        public final FerryResponseDTO getFerry() {
            return this.ferry;
        }

        /* renamed from: component11, reason: from getter */
        public final Duration getTravelTime() {
            return this.travelTime;
        }

        /* renamed from: component12, reason: from getter */
        public final HarborDTO getDepartureHarbor() {
            return this.departureHarbor;
        }

        /* renamed from: component13, reason: from getter */
        public final HarborDTO getArrivalHarbor() {
            return this.arrivalHarbor;
        }

        /* renamed from: component14, reason: from getter */
        public final String getTransportSwitchDescription() {
            return this.transportSwitchDescription;
        }

        /* renamed from: component15, reason: from getter */
        public final boolean getIsEarlyCheckInPossible() {
            return this.isEarlyCheckInPossible;
        }

        /* renamed from: component16, reason: from getter */
        public final SublineDTO getSubline() {
            return this.subline;
        }

        /* renamed from: component2, reason: from getter */
        public final LocalDate getDate() {
            return this.date;
        }

        /* renamed from: component3, reason: from getter */
        public final String getDepartureId() {
            return this.departureId;
        }

        /* renamed from: component4, reason: from getter */
        public final LocalTime getDepartureTime() {
            return this.departureTime;
        }

        /* renamed from: component5, reason: from getter */
        public final String getRegionId() {
            return this.regionId;
        }

        /* renamed from: component6, reason: from getter */
        public final String getRouteId() {
            return this.routeId;
        }

        /* renamed from: component7, reason: from getter */
        public final String getMainRouteId() {
            return this.mainRouteId;
        }

        public final List<RouteTypeResponseDTO> component8() {
            return this.routeTypes;
        }

        /* renamed from: component9, reason: from getter */
        public final String getTimeTableId() {
            return this.timeTableId;
        }

        public final DepartureResponseDTO copy(LocalTime arrivalTime, LocalDate date, String departureId, LocalTime departureTime, String regionId, String routeId, String mainRouteId, List<? extends RouteTypeResponseDTO> routeTypes, String timeTableId, FerryResponseDTO ferry, Duration travelTime, HarborDTO departureHarbor, HarborDTO arrivalHarbor, String transportSwitchDescription, boolean isEarlyCheckInPossible, SublineDTO subline) {
            Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(departureId, "departureId");
            Intrinsics.checkNotNullParameter(departureTime, "departureTime");
            Intrinsics.checkNotNullParameter(regionId, "regionId");
            Intrinsics.checkNotNullParameter(routeId, "routeId");
            Intrinsics.checkNotNullParameter(mainRouteId, "mainRouteId");
            Intrinsics.checkNotNullParameter(routeTypes, "routeTypes");
            Intrinsics.checkNotNullParameter(timeTableId, "timeTableId");
            Intrinsics.checkNotNullParameter(travelTime, "travelTime");
            Intrinsics.checkNotNullParameter(departureHarbor, "departureHarbor");
            Intrinsics.checkNotNullParameter(arrivalHarbor, "arrivalHarbor");
            return new DepartureResponseDTO(arrivalTime, date, departureId, departureTime, regionId, routeId, mainRouteId, routeTypes, timeTableId, ferry, travelTime, departureHarbor, arrivalHarbor, transportSwitchDescription, isEarlyCheckInPossible, subline);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DepartureResponseDTO)) {
                return false;
            }
            DepartureResponseDTO departureResponseDTO = (DepartureResponseDTO) other;
            return Intrinsics.areEqual(this.arrivalTime, departureResponseDTO.arrivalTime) && Intrinsics.areEqual(this.date, departureResponseDTO.date) && Intrinsics.areEqual(this.departureId, departureResponseDTO.departureId) && Intrinsics.areEqual(this.departureTime, departureResponseDTO.departureTime) && Intrinsics.areEqual(this.regionId, departureResponseDTO.regionId) && Intrinsics.areEqual(this.routeId, departureResponseDTO.routeId) && Intrinsics.areEqual(this.mainRouteId, departureResponseDTO.mainRouteId) && Intrinsics.areEqual(this.routeTypes, departureResponseDTO.routeTypes) && Intrinsics.areEqual(this.timeTableId, departureResponseDTO.timeTableId) && Intrinsics.areEqual(this.ferry, departureResponseDTO.ferry) && Intrinsics.areEqual(this.travelTime, departureResponseDTO.travelTime) && Intrinsics.areEqual(this.departureHarbor, departureResponseDTO.departureHarbor) && Intrinsics.areEqual(this.arrivalHarbor, departureResponseDTO.arrivalHarbor) && Intrinsics.areEqual(this.transportSwitchDescription, departureResponseDTO.transportSwitchDescription) && this.isEarlyCheckInPossible == departureResponseDTO.isEarlyCheckInPossible && Intrinsics.areEqual(this.subline, departureResponseDTO.subline);
        }

        public final HarborDTO getArrivalHarbor() {
            return this.arrivalHarbor;
        }

        public final LocalTime getArrivalTime() {
            return this.arrivalTime;
        }

        public final LocalDate getDate() {
            return this.date;
        }

        public final HarborDTO getDepartureHarbor() {
            return this.departureHarbor;
        }

        public final String getDepartureId() {
            return this.departureId;
        }

        public final LocalTime getDepartureTime() {
            return this.departureTime;
        }

        public final FerryResponseDTO getFerry() {
            return this.ferry;
        }

        public final String getMainRouteId() {
            return this.mainRouteId;
        }

        public final String getRegionId() {
            return this.regionId;
        }

        public final String getRouteId() {
            return this.routeId;
        }

        public final List<RouteTypeResponseDTO> getRouteTypes() {
            return this.routeTypes;
        }

        public final SublineDTO getSubline() {
            return this.subline;
        }

        public final String getTimeTableId() {
            return this.timeTableId;
        }

        public final String getTransportSwitchDescription() {
            return this.transportSwitchDescription;
        }

        public final Duration getTravelTime() {
            return this.travelTime;
        }

        public int hashCode() {
            int hashCode = ((((((((((((((((this.arrivalTime.hashCode() * 31) + this.date.hashCode()) * 31) + this.departureId.hashCode()) * 31) + this.departureTime.hashCode()) * 31) + this.regionId.hashCode()) * 31) + this.routeId.hashCode()) * 31) + this.mainRouteId.hashCode()) * 31) + this.routeTypes.hashCode()) * 31) + this.timeTableId.hashCode()) * 31;
            FerryResponseDTO ferryResponseDTO = this.ferry;
            int hashCode2 = (((((((hashCode + (ferryResponseDTO == null ? 0 : ferryResponseDTO.hashCode())) * 31) + this.travelTime.hashCode()) * 31) + this.departureHarbor.hashCode()) * 31) + this.arrivalHarbor.hashCode()) * 31;
            String str = this.transportSwitchDescription;
            int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isEarlyCheckInPossible)) * 31;
            SublineDTO sublineDTO = this.subline;
            return hashCode3 + (sublineDTO != null ? sublineDTO.hashCode() : 0);
        }

        public final boolean isEarlyCheckInPossible() {
            return this.isEarlyCheckInPossible;
        }

        public String toString() {
            return "DepartureResponseDTO(arrivalTime=" + this.arrivalTime + ", date=" + this.date + ", departureId=" + this.departureId + ", departureTime=" + this.departureTime + ", regionId=" + this.regionId + ", routeId=" + this.routeId + ", mainRouteId=" + this.mainRouteId + ", routeTypes=" + this.routeTypes + ", timeTableId=" + this.timeTableId + ", ferry=" + this.ferry + ", travelTime=" + this.travelTime + ", departureHarbor=" + this.departureHarbor + ", arrivalHarbor=" + this.arrivalHarbor + ", transportSwitchDescription=" + this.transportSwitchDescription + ", isEarlyCheckInPossible=" + this.isEarlyCheckInPossible + ", subline=" + this.subline + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public DepartureResponseDTO(LocalTime arrivalTime, LocalDate date, String departureId, LocalTime departureTime, String regionId, String routeId, String mainRouteId, List<? extends RouteTypeResponseDTO> routeTypes, String timeTableId, FerryResponseDTO ferryResponseDTO, Duration travelTime, HarborDTO departureHarbor, HarborDTO arrivalHarbor, String str, boolean z5, SublineDTO sublineDTO) {
            Intrinsics.checkNotNullParameter(arrivalTime, "arrivalTime");
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(departureId, "departureId");
            Intrinsics.checkNotNullParameter(departureTime, "departureTime");
            Intrinsics.checkNotNullParameter(regionId, "regionId");
            Intrinsics.checkNotNullParameter(routeId, "routeId");
            Intrinsics.checkNotNullParameter(mainRouteId, "mainRouteId");
            Intrinsics.checkNotNullParameter(routeTypes, "routeTypes");
            Intrinsics.checkNotNullParameter(timeTableId, "timeTableId");
            Intrinsics.checkNotNullParameter(travelTime, "travelTime");
            Intrinsics.checkNotNullParameter(departureHarbor, "departureHarbor");
            Intrinsics.checkNotNullParameter(arrivalHarbor, "arrivalHarbor");
            this.arrivalTime = arrivalTime;
            this.date = date;
            this.departureId = departureId;
            this.departureTime = departureTime;
            this.regionId = regionId;
            this.routeId = routeId;
            this.mainRouteId = mainRouteId;
            this.routeTypes = routeTypes;
            this.timeTableId = timeTableId;
            this.ferry = ferryResponseDTO;
            this.travelTime = travelTime;
            this.departureHarbor = departureHarbor;
            this.arrivalHarbor = arrivalHarbor;
            this.transportSwitchDescription = str;
            this.isEarlyCheckInPossible = z5;
            this.subline = sublineDTO;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB7\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013¨\u0006)"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$EditInfoResponseDTO;", BuildConfig.FLAVOR, "canChange", BuildConfig.FLAVOR, "canChangeFrom", "Lorg/threeten/bp/LocalDate;", "canChangeUntil", "<init>", "(ZLorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCanChange", "()Z", "getCanChangeFrom$annotations", "()V", "getCanChangeFrom", "()Lorg/threeten/bp/LocalDate;", "getCanChangeUntil$annotations", "getCanChangeUntil", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class EditInfoResponseDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canChange;
        private final LocalDate canChangeFrom;
        private final LocalDate canChangeUntil;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$EditInfoResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$EditInfoResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<EditInfoResponseDTO> serializer() {
                return BookingResponseDTO$EditInfoResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ EditInfoResponseDTO(int i5, boolean z5, LocalDate localDate, LocalDate localDate2, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, BookingResponseDTO$EditInfoResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.canChange = z5;
            this.canChangeFrom = localDate;
            this.canChangeUntil = localDate2;
        }

        public static /* synthetic */ EditInfoResponseDTO copy$default(EditInfoResponseDTO editInfoResponseDTO, boolean z5, LocalDate localDate, LocalDate localDate2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = editInfoResponseDTO.canChange;
            }
            if ((i5 & 2) != 0) {
                localDate = editInfoResponseDTO.canChangeFrom;
            }
            if ((i5 & 4) != 0) {
                localDate2 = editInfoResponseDTO.canChangeUntil;
            }
            return editInfoResponseDTO.copy(z5, localDate, localDate2);
        }

        @Serializable(with = LocalDateWithTimeSerializer.class)
        public static /* synthetic */ void getCanChangeFrom$annotations() {
        }

        @Serializable(with = LocalDateWithTimeSerializer.class)
        public static /* synthetic */ void getCanChangeUntil$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(EditInfoResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeBooleanElement(serialDesc, 0, self.canChange);
            LocalDateWithTimeSerializer localDateWithTimeSerializer = LocalDateWithTimeSerializer.INSTANCE;
            output.encodeSerializableElement(serialDesc, 1, localDateWithTimeSerializer, self.canChangeFrom);
            output.encodeSerializableElement(serialDesc, 2, localDateWithTimeSerializer, self.canChangeUntil);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getCanChange() {
            return this.canChange;
        }

        /* renamed from: component2, reason: from getter */
        public final LocalDate getCanChangeFrom() {
            return this.canChangeFrom;
        }

        /* renamed from: component3, reason: from getter */
        public final LocalDate getCanChangeUntil() {
            return this.canChangeUntil;
        }

        public final EditInfoResponseDTO copy(boolean canChange, LocalDate canChangeFrom, LocalDate canChangeUntil) {
            Intrinsics.checkNotNullParameter(canChangeFrom, "canChangeFrom");
            Intrinsics.checkNotNullParameter(canChangeUntil, "canChangeUntil");
            return new EditInfoResponseDTO(canChange, canChangeFrom, canChangeUntil);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EditInfoResponseDTO)) {
                return false;
            }
            EditInfoResponseDTO editInfoResponseDTO = (EditInfoResponseDTO) other;
            return this.canChange == editInfoResponseDTO.canChange && Intrinsics.areEqual(this.canChangeFrom, editInfoResponseDTO.canChangeFrom) && Intrinsics.areEqual(this.canChangeUntil, editInfoResponseDTO.canChangeUntil);
        }

        public final boolean getCanChange() {
            return this.canChange;
        }

        public final LocalDate getCanChangeFrom() {
            return this.canChangeFrom;
        }

        public final LocalDate getCanChangeUntil() {
            return this.canChangeUntil;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.canChange) * 31) + this.canChangeFrom.hashCode()) * 31) + this.canChangeUntil.hashCode();
        }

        public String toString() {
            return "EditInfoResponseDTO(canChange=" + this.canChange + ", canChangeFrom=" + this.canChangeFrom + ", canChangeUntil=" + this.canChangeUntil + ")";
        }

        public EditInfoResponseDTO(boolean z5, LocalDate canChangeFrom, LocalDate canChangeUntil) {
            Intrinsics.checkNotNullParameter(canChangeFrom, "canChangeFrom");
            Intrinsics.checkNotNullParameter(canChangeUntil, "canChangeUntil");
            this.canChange = z5;
            this.canChangeFrom = canChangeFrom;
            this.canChangeUntil = canChangeUntil;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\""}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$GoodsResponseDTO;", BuildConfig.FLAVOR, "weight", BuildConfig.FLAVOR, "weightFee", "<init>", "(DD)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IDDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getWeight", "()D", "getWeightFee", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class GoodsResponseDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final double weight;
        private final double weightFee;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$GoodsResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$GoodsResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<GoodsResponseDTO> serializer() {
                return BookingResponseDTO$GoodsResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ GoodsResponseDTO(int i5, double d5, double d6, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i5 & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 3, BookingResponseDTO$GoodsResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.weight = d5;
            this.weightFee = d6;
        }

        public static /* synthetic */ GoodsResponseDTO copy$default(GoodsResponseDTO goodsResponseDTO, double d5, double d6, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                d5 = goodsResponseDTO.weight;
            }
            if ((i5 & 2) != 0) {
                d6 = goodsResponseDTO.weightFee;
            }
            return goodsResponseDTO.copy(d5, d6);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(GoodsResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeDoubleElement(serialDesc, 0, self.weight);
            output.encodeDoubleElement(serialDesc, 1, self.weightFee);
        }

        /* renamed from: component1, reason: from getter */
        public final double getWeight() {
            return this.weight;
        }

        /* renamed from: component2, reason: from getter */
        public final double getWeightFee() {
            return this.weightFee;
        }

        public final GoodsResponseDTO copy(double weight, double weightFee) {
            return new GoodsResponseDTO(weight, weightFee);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GoodsResponseDTO)) {
                return false;
            }
            GoodsResponseDTO goodsResponseDTO = (GoodsResponseDTO) other;
            return Double.compare(this.weight, goodsResponseDTO.weight) == 0 && Double.compare(this.weightFee, goodsResponseDTO.weightFee) == 0;
        }

        public final double getWeight() {
            return this.weight;
        }

        public final double getWeightFee() {
            return this.weightFee;
        }

        public int hashCode() {
            return (Double.hashCode(this.weight) * 31) + Double.hashCode(this.weightFee);
        }

        public String toString() {
            return "GoodsResponseDTO(weight=" + this.weight + ", weightFee=" + this.weightFee + ")";
        }

        public GoodsResponseDTO(double d5, double d6) {
            this.weight = d5;
            this.weightFee = d6;
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 <2\u00020\u0001:\u0002;<BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011Bs\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u000eHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jg\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u000bHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001J%\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\b:R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017¨\u0006="}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$LineItemResponseDTO;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "price", "Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "unitPrice", "productType", "Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "quantity", BuildConfig.FLAVOR, "imageUrl", "availability", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$AvailabilityResponseDTO;", "cateringLocationText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;ILjava/lang/String;Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$AvailabilityResponseDTO;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;ILjava/lang/String;Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$AvailabilityResponseDTO;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "getPrice", "()Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "getUnitPrice", "getProductType", "()Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "getQuantity", "()I", "getImageUrl", "getAvailability", "()Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$AvailabilityResponseDTO;", "getCateringLocationText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class LineItemResponseDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final AvailabilityResponseDTO availability;
        private final String cateringLocationText;
        private final String id;
        private final String imageUrl;
        private final String name;
        private final PriceWithCurrencyDTO price;
        private final ProductTypeResponseDTO productType;
        private final int quantity;
        private final PriceWithCurrencyDTO unitPrice;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$LineItemResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$LineItemResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<LineItemResponseDTO> serializer() {
                return BookingResponseDTO$LineItemResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ LineItemResponseDTO(int i5, String str, String str2, PriceWithCurrencyDTO priceWithCurrencyDTO, PriceWithCurrencyDTO priceWithCurrencyDTO2, ProductTypeResponseDTO productTypeResponseDTO, int i6, String str3, AvailabilityResponseDTO availabilityResponseDTO, String str4, SerializationConstructorMarker serializationConstructorMarker) {
            if (255 != (i5 & Function.USE_VARARGS)) {
                PluginExceptionsKt.throwMissingFieldException(i5, Function.USE_VARARGS, BookingResponseDTO$LineItemResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.name = str2;
            this.price = priceWithCurrencyDTO;
            this.unitPrice = priceWithCurrencyDTO2;
            this.productType = productTypeResponseDTO;
            this.quantity = i6;
            this.imageUrl = str3;
            this.availability = availabilityResponseDTO;
            if ((i5 & 256) == 0) {
                this.cateringLocationText = null;
            } else {
                this.cateringLocationText = str4;
            }
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(LineItemResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeStringElement(serialDesc, 1, self.name);
            PriceWithCurrencyDTO$$serializer priceWithCurrencyDTO$$serializer = PriceWithCurrencyDTO$$serializer.INSTANCE;
            output.encodeSerializableElement(serialDesc, 2, priceWithCurrencyDTO$$serializer, self.price);
            output.encodeSerializableElement(serialDesc, 3, priceWithCurrencyDTO$$serializer, self.unitPrice);
            output.encodeSerializableElement(serialDesc, 4, ProductTypeResponseDTO.Serializer.INSTANCE, self.productType);
            output.encodeIntElement(serialDesc, 5, self.quantity);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 6, stringSerializer, self.imageUrl);
            output.encodeSerializableElement(serialDesc, 7, AvailabilityResponseDTO.Serializer.INSTANCE, self.availability);
            if (!output.shouldEncodeElementDefault(serialDesc, 8) && self.cateringLocationText == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 8, stringSerializer, self.cateringLocationText);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component3, reason: from getter */
        public final PriceWithCurrencyDTO getPrice() {
            return this.price;
        }

        /* renamed from: component4, reason: from getter */
        public final PriceWithCurrencyDTO getUnitPrice() {
            return this.unitPrice;
        }

        /* renamed from: component5, reason: from getter */
        public final ProductTypeResponseDTO getProductType() {
            return this.productType;
        }

        /* renamed from: component6, reason: from getter */
        public final int getQuantity() {
            return this.quantity;
        }

        /* renamed from: component7, reason: from getter */
        public final String getImageUrl() {
            return this.imageUrl;
        }

        /* renamed from: component8, reason: from getter */
        public final AvailabilityResponseDTO getAvailability() {
            return this.availability;
        }

        /* renamed from: component9, reason: from getter */
        public final String getCateringLocationText() {
            return this.cateringLocationText;
        }

        public final LineItemResponseDTO copy(String id, String name, PriceWithCurrencyDTO price, PriceWithCurrencyDTO unitPrice, ProductTypeResponseDTO productType, int quantity, String imageUrl, AvailabilityResponseDTO availability, String cateringLocationText) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(price, "price");
            Intrinsics.checkNotNullParameter(unitPrice, "unitPrice");
            Intrinsics.checkNotNullParameter(productType, "productType");
            Intrinsics.checkNotNullParameter(availability, "availability");
            return new LineItemResponseDTO(id, name, price, unitPrice, productType, quantity, imageUrl, availability, cateringLocationText);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LineItemResponseDTO)) {
                return false;
            }
            LineItemResponseDTO lineItemResponseDTO = (LineItemResponseDTO) other;
            return Intrinsics.areEqual(this.id, lineItemResponseDTO.id) && Intrinsics.areEqual(this.name, lineItemResponseDTO.name) && Intrinsics.areEqual(this.price, lineItemResponseDTO.price) && Intrinsics.areEqual(this.unitPrice, lineItemResponseDTO.unitPrice) && this.productType == lineItemResponseDTO.productType && this.quantity == lineItemResponseDTO.quantity && Intrinsics.areEqual(this.imageUrl, lineItemResponseDTO.imageUrl) && this.availability == lineItemResponseDTO.availability && Intrinsics.areEqual(this.cateringLocationText, lineItemResponseDTO.cateringLocationText);
        }

        public final AvailabilityResponseDTO getAvailability() {
            return this.availability;
        }

        public final String getCateringLocationText() {
            return this.cateringLocationText;
        }

        public final String getId() {
            return this.id;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final String getName() {
            return this.name;
        }

        public final PriceWithCurrencyDTO getPrice() {
            return this.price;
        }

        public final ProductTypeResponseDTO getProductType() {
            return this.productType;
        }

        public final int getQuantity() {
            return this.quantity;
        }

        public final PriceWithCurrencyDTO getUnitPrice() {
            return this.unitPrice;
        }

        public int hashCode() {
            int hashCode = ((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.price.hashCode()) * 31) + this.unitPrice.hashCode()) * 31) + this.productType.hashCode()) * 31) + Integer.hashCode(this.quantity)) * 31;
            String str = this.imageUrl;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.availability.hashCode()) * 31;
            String str2 = this.cateringLocationText;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "LineItemResponseDTO(id=" + this.id + ", name=" + this.name + ", price=" + this.price + ", unitPrice=" + this.unitPrice + ", productType=" + this.productType + ", quantity=" + this.quantity + ", imageUrl=" + this.imageUrl + ", availability=" + this.availability + ", cateringLocationText=" + this.cateringLocationText + ")";
        }

        public LineItemResponseDTO(String id, String name, PriceWithCurrencyDTO price, PriceWithCurrencyDTO unitPrice, ProductTypeResponseDTO productType, int i5, String str, AvailabilityResponseDTO availability, String str2) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(price, "price");
            Intrinsics.checkNotNullParameter(unitPrice, "unitPrice");
            Intrinsics.checkNotNullParameter(productType, "productType");
            Intrinsics.checkNotNullParameter(availability, "availability");
            this.id = id;
            this.name = name;
            this.price = price;
            this.unitPrice = unitPrice;
            this.productType = productType;
            this.quantity = i5;
            this.imageUrl = str;
            this.availability = availability;
            this.cateringLocationText = str2;
        }

        public /* synthetic */ LineItemResponseDTO(String str, String str2, PriceWithCurrencyDTO priceWithCurrencyDTO, PriceWithCurrencyDTO priceWithCurrencyDTO2, ProductTypeResponseDTO productTypeResponseDTO, int i5, String str3, AvailabilityResponseDTO availabilityResponseDTO, String str4, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, priceWithCurrencyDTO, priceWithCurrencyDTO2, productTypeResponseDTO, i5, str3, availabilityResponseDTO, (i6 & 256) != 0 ? null : str4);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$MultiRideInfoResponseDTO;", BuildConfig.FLAVOR, "cardType", BuildConfig.FLAVOR, "cardNumber", "customerId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCardType", "()Ljava/lang/String;", "getCardNumber", "getCustomerId", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class MultiRideInfoResponseDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String cardNumber;
        private final String cardType;
        private final String customerId;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$MultiRideInfoResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$MultiRideInfoResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<MultiRideInfoResponseDTO> serializer() {
                return BookingResponseDTO$MultiRideInfoResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ MultiRideInfoResponseDTO(int i5, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, BookingResponseDTO$MultiRideInfoResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.cardType = str;
            this.cardNumber = str2;
            this.customerId = str3;
        }

        public static /* synthetic */ MultiRideInfoResponseDTO copy$default(MultiRideInfoResponseDTO multiRideInfoResponseDTO, String str, String str2, String str3, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = multiRideInfoResponseDTO.cardType;
            }
            if ((i5 & 2) != 0) {
                str2 = multiRideInfoResponseDTO.cardNumber;
            }
            if ((i5 & 4) != 0) {
                str3 = multiRideInfoResponseDTO.customerId;
            }
            return multiRideInfoResponseDTO.copy(str, str2, str3);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(MultiRideInfoResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.cardType);
            output.encodeStringElement(serialDesc, 1, self.cardNumber);
            output.encodeStringElement(serialDesc, 2, self.customerId);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCardType() {
            return this.cardType;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCardNumber() {
            return this.cardNumber;
        }

        /* renamed from: component3, reason: from getter */
        public final String getCustomerId() {
            return this.customerId;
        }

        public final MultiRideInfoResponseDTO copy(String cardType, String cardNumber, String customerId) {
            Intrinsics.checkNotNullParameter(cardType, "cardType");
            Intrinsics.checkNotNullParameter(cardNumber, "cardNumber");
            Intrinsics.checkNotNullParameter(customerId, "customerId");
            return new MultiRideInfoResponseDTO(cardType, cardNumber, customerId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MultiRideInfoResponseDTO)) {
                return false;
            }
            MultiRideInfoResponseDTO multiRideInfoResponseDTO = (MultiRideInfoResponseDTO) other;
            return Intrinsics.areEqual(this.cardType, multiRideInfoResponseDTO.cardType) && Intrinsics.areEqual(this.cardNumber, multiRideInfoResponseDTO.cardNumber) && Intrinsics.areEqual(this.customerId, multiRideInfoResponseDTO.customerId);
        }

        public final String getCardNumber() {
            return this.cardNumber;
        }

        public final String getCardType() {
            return this.cardType;
        }

        public final String getCustomerId() {
            return this.customerId;
        }

        public int hashCode() {
            return (((this.cardType.hashCode() * 31) + this.cardNumber.hashCode()) * 31) + this.customerId.hashCode();
        }

        public String toString() {
            return "MultiRideInfoResponseDTO(cardType=" + this.cardType + ", cardNumber=" + this.cardNumber + ", customerId=" + this.customerId + ")";
        }

        public MultiRideInfoResponseDTO(String cardType, String cardNumber, String customerId) {
            Intrinsics.checkNotNullParameter(cardType, "cardType");
            Intrinsics.checkNotNullParameter(cardNumber, "cardNumber");
            Intrinsics.checkNotNullParameter(customerId, "customerId");
            this.cardType = cardType;
            this.cardNumber = cardNumber;
            this.customerId = customerId;
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006*"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$PassengerInfoResponseDTO;", BuildConfig.FLAVOR, "adultCount", BuildConfig.FLAVOR, "childCount", "infantCount", "passengerData", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingPassengerResponseDTO;", "<init>", "(IIILjava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAdultCount", "()I", "getChildCount", "getInfantCount", "getPassengerData", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class PassengerInfoResponseDTO {
        private final int adultCount;
        private final int childCount;
        private final int infantCount;
        private final List<BookingPassengerResponseDTO> passengerData;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, new ArrayListSerializer(BookingResponseDTO$BookingPassengerResponseDTO$$serializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$PassengerInfoResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$PassengerInfoResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<PassengerInfoResponseDTO> serializer() {
                return BookingResponseDTO$PassengerInfoResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ PassengerInfoResponseDTO(int i5, int i6, int i7, int i8, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i5 & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 15, BookingResponseDTO$PassengerInfoResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.adultCount = i6;
            this.childCount = i7;
            this.infantCount = i8;
            this.passengerData = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PassengerInfoResponseDTO copy$default(PassengerInfoResponseDTO passengerInfoResponseDTO, int i5, int i6, int i7, List list, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                i5 = passengerInfoResponseDTO.adultCount;
            }
            if ((i8 & 2) != 0) {
                i6 = passengerInfoResponseDTO.childCount;
            }
            if ((i8 & 4) != 0) {
                i7 = passengerInfoResponseDTO.infantCount;
            }
            if ((i8 & 8) != 0) {
                list = passengerInfoResponseDTO.passengerData;
            }
            return passengerInfoResponseDTO.copy(i5, i6, i7, list);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(PassengerInfoResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeIntElement(serialDesc, 0, self.adultCount);
            output.encodeIntElement(serialDesc, 1, self.childCount);
            output.encodeIntElement(serialDesc, 2, self.infantCount);
            output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.passengerData);
        }

        /* renamed from: component1, reason: from getter */
        public final int getAdultCount() {
            return this.adultCount;
        }

        /* renamed from: component2, reason: from getter */
        public final int getChildCount() {
            return this.childCount;
        }

        /* renamed from: component3, reason: from getter */
        public final int getInfantCount() {
            return this.infantCount;
        }

        public final List<BookingPassengerResponseDTO> component4() {
            return this.passengerData;
        }

        public final PassengerInfoResponseDTO copy(int adultCount, int childCount, int infantCount, List<BookingPassengerResponseDTO> passengerData) {
            Intrinsics.checkNotNullParameter(passengerData, "passengerData");
            return new PassengerInfoResponseDTO(adultCount, childCount, infantCount, passengerData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PassengerInfoResponseDTO)) {
                return false;
            }
            PassengerInfoResponseDTO passengerInfoResponseDTO = (PassengerInfoResponseDTO) other;
            return this.adultCount == passengerInfoResponseDTO.adultCount && this.childCount == passengerInfoResponseDTO.childCount && this.infantCount == passengerInfoResponseDTO.infantCount && Intrinsics.areEqual(this.passengerData, passengerInfoResponseDTO.passengerData);
        }

        public final int getAdultCount() {
            return this.adultCount;
        }

        public final int getChildCount() {
            return this.childCount;
        }

        public final int getInfantCount() {
            return this.infantCount;
        }

        public final List<BookingPassengerResponseDTO> getPassengerData() {
            return this.passengerData;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.adultCount) * 31) + Integer.hashCode(this.childCount)) * 31) + Integer.hashCode(this.infantCount)) * 31) + this.passengerData.hashCode();
        }

        public String toString() {
            return "PassengerInfoResponseDTO(adultCount=" + this.adultCount + ", childCount=" + this.childCount + ", infantCount=" + this.infantCount + ", passengerData=" + this.passengerData + ")";
        }

        public PassengerInfoResponseDTO(int i5, int i6, int i7, List<BookingPassengerResponseDTO> passengerData) {
            Intrinsics.checkNotNullParameter(passengerData, "passengerData");
            this.adultCount = i5;
            this.childCount = i6;
            this.infantCount = i7;
            this.passengerData = passengerData;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0087\u0081\u0002\u0018\u0000 \u00102\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002\u000f\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$SeatTypeDTO;", "Ldk/molslinjen/api/helpers/serializers/SerializableEnum;", BuildConfig.FLAVOR, "rawValue", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getRawValue", "()I", "Available", "Occupied", "NotAvailable", "Window", "Chosen", "Undefined", "Serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable(with = Serializer.class)
    /* loaded from: classes2.dex */
    public static final class SeatTypeDTO implements SerializableEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SeatTypeDTO[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final int rawValue;
        public static final SeatTypeDTO Available = new SeatTypeDTO("Available", 0, 0);
        public static final SeatTypeDTO Occupied = new SeatTypeDTO("Occupied", 1, 1);
        public static final SeatTypeDTO NotAvailable = new SeatTypeDTO("NotAvailable", 2, 2);
        public static final SeatTypeDTO Window = new SeatTypeDTO("Window", 3, 3);
        public static final SeatTypeDTO Chosen = new SeatTypeDTO("Chosen", 4, 4);
        public static final SeatTypeDTO Undefined = new SeatTypeDTO("Undefined", 5, 5);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$SeatTypeDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$SeatTypeDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<SeatTypeDTO> serializer() {
                return Serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$SeatTypeDTO$Serializer;", "Ldk/molslinjen/api/helpers/serializers/IntToEnumSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$SeatTypeDTO;", "<init>", "()V", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Serializer extends IntToEnumSerializer<SeatTypeDTO> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(SeatTypeDTO.class);
            }
        }

        private static final /* synthetic */ SeatTypeDTO[] $values() {
            return new SeatTypeDTO[]{Available, Occupied, NotAvailable, Window, Chosen, Undefined};
        }

        static {
            SeatTypeDTO[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
        }

        private SeatTypeDTO(String str, int i5, int i6) {
            this.rawValue = i6;
        }

        public static EnumEntries<SeatTypeDTO> getEntries() {
            return $ENTRIES;
        }

        public static SeatTypeDTO valueOf(String str) {
            return (SeatTypeDTO) Enum.valueOf(SeatTypeDTO.class, str);
        }

        public static SeatTypeDTO[] values() {
            return (SeatTypeDTO[]) $VALUES.clone();
        }

        @Override // dk.molslinjen.api.helpers.serializers.SerializableEnum
        public int getRawValue() {
            return this.rawValue;
        }
    }

    @Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 c2\u00020\u0001:\u0002bcBµ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\r\u0012\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\r\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\r¢\u0006\u0004\b\"\u0010#Bá\u0001\b\u0010\u0012\u0006\u0010$\u001a\u00020%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\r\u0012\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\r\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\r\u0012\b\u0010&\u001a\u0004\u0018\u00010'¢\u0006\u0004\b\"\u0010(J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0007HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010H\u001a\u00020\u000bHÆ\u0003J\u000f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\u000f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00100\rHÆ\u0003J\t\u0010K\u001a\u00020\u0012HÆ\u0003J\t\u0010L\u001a\u00020\u0014HÆ\u0003J\t\u0010M\u001a\u00020\u0014HÆ\u0003J\t\u0010N\u001a\u00020\u0010HÆ\u0003J\t\u0010O\u001a\u00020\u0010HÆ\u0003J\t\u0010P\u001a\u00020\u0019HÆ\u0003J\u0011\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\rHÆ\u0003J\u0011\u0010R\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\rHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u000f\u0010T\u001a\b\u0012\u0004\u0012\u00020!0\rHÆ\u0003JÙ\u0001\u0010U\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\r2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\r2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\rHÆ\u0001J\u0013\u0010V\u001a\u00020\u000b2\b\u0010W\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010X\u001a\u00020%HÖ\u0001J\t\u0010Y\u001a\u00020\u0010HÖ\u0001J%\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u00002\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020`H\u0001¢\u0006\u0002\baR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u00101R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r¢\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u0015\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b9\u00108R\u0011\u0010\u0016\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u0017\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b<\u0010;R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0019\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b?\u00103R\u0019\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b@\u00103R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\r¢\u0006\b\n\u0000\u001a\u0004\bC\u00103¨\u0006d"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$TicketResponseDTO;", BuildConfig.FLAVOR, "departure", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$DepartureResponseDTO;", "directionType", "Ldk/molslinjen/api/services/booking/request/DirectionDTO;", "editInfo", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$EditInfoResponseDTO;", "goods", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$GoodsResponseDTO;", "isCheckedIn", BuildConfig.FLAVOR, "products", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$LineItemResponseDTO;", "notes", BuildConfig.FLAVOR, "passengerInfo", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$PassengerInfoResponseDTO;", "ticketPrice", "Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "totalPrice", "ticketCategoryName", "ticketTypeId", "transportInfo", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$TransportInfoDTO;", "barcodes", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BarcodeResponseDTO;", "availableProductTypes", "Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "seatReservation", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingSeatReservationDTO;", "surcharges", "Ldk/molslinjen/api/shared/response/TicketSurchargeDTO;", "<init>", "(Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$DepartureResponseDTO;Ldk/molslinjen/api/services/booking/request/DirectionDTO;Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$EditInfoResponseDTO;Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$GoodsResponseDTO;ZLjava/util/List;Ljava/util/List;Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$PassengerInfoResponseDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$TransportInfoDTO;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingSeatReservationDTO;Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$DepartureResponseDTO;Ldk/molslinjen/api/services/booking/request/DirectionDTO;Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$EditInfoResponseDTO;Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$GoodsResponseDTO;ZLjava/util/List;Ljava/util/List;Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$PassengerInfoResponseDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$TransportInfoDTO;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingSeatReservationDTO;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDeparture", "()Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$DepartureResponseDTO;", "getDirectionType", "()Ldk/molslinjen/api/services/booking/request/DirectionDTO;", "getEditInfo", "()Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$EditInfoResponseDTO;", "getGoods", "()Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$GoodsResponseDTO;", "()Z", "getProducts", "()Ljava/util/List;", "getNotes", "getPassengerInfo", "()Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$PassengerInfoResponseDTO;", "getTicketPrice", "()Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "getTotalPrice", "getTicketCategoryName", "()Ljava/lang/String;", "getTicketTypeId", "getTransportInfo", "()Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$TransportInfoDTO;", "getBarcodes", "getAvailableProductTypes", "getSeatReservation", "()Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$BookingSeatReservationDTO;", "getSurcharges", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class TicketResponseDTO {
        private final List<ProductTypeResponseDTO> availableProductTypes;
        private final List<BarcodeResponseDTO> barcodes;
        private final DepartureResponseDTO departure;
        private final DirectionDTO directionType;
        private final EditInfoResponseDTO editInfo;
        private final GoodsResponseDTO goods;
        private final boolean isCheckedIn;
        private final List<String> notes;
        private final PassengerInfoResponseDTO passengerInfo;
        private final List<LineItemResponseDTO> products;
        private final BookingSeatReservationDTO seatReservation;
        private final List<TicketSurchargeDTO> surcharges;
        private final String ticketCategoryName;
        private final PriceWithCurrencyDTO ticketPrice;
        private final String ticketTypeId;
        private final PriceWithCurrencyDTO totalPrice;
        private final TransportInfoDTO transportInfo;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, new ArrayListSerializer(BookingResponseDTO$LineItemResponseDTO$$serializer.INSTANCE), new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null, null, null, null, new ArrayListSerializer(BookingResponseDTO$BarcodeResponseDTO$$serializer.INSTANCE), new ArrayListSerializer(ProductTypeResponseDTO.Serializer.INSTANCE), null, new ArrayListSerializer(TicketSurchargeDTO$$serializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$TicketResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$TicketResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<TicketResponseDTO> serializer() {
                return BookingResponseDTO$TicketResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ TicketResponseDTO(int i5, DepartureResponseDTO departureResponseDTO, DirectionDTO directionDTO, EditInfoResponseDTO editInfoResponseDTO, GoodsResponseDTO goodsResponseDTO, boolean z5, List list, List list2, PassengerInfoResponseDTO passengerInfoResponseDTO, PriceWithCurrencyDTO priceWithCurrencyDTO, PriceWithCurrencyDTO priceWithCurrencyDTO2, String str, String str2, TransportInfoDTO transportInfoDTO, List list3, List list4, BookingSeatReservationDTO bookingSeatReservationDTO, List list5, SerializationConstructorMarker serializationConstructorMarker) {
            if (131071 != (i5 & 131071)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 131071, BookingResponseDTO$TicketResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.departure = departureResponseDTO;
            this.directionType = directionDTO;
            this.editInfo = editInfoResponseDTO;
            this.goods = goodsResponseDTO;
            this.isCheckedIn = z5;
            this.products = list;
            this.notes = list2;
            this.passengerInfo = passengerInfoResponseDTO;
            this.ticketPrice = priceWithCurrencyDTO;
            this.totalPrice = priceWithCurrencyDTO2;
            this.ticketCategoryName = str;
            this.ticketTypeId = str2;
            this.transportInfo = transportInfoDTO;
            this.barcodes = list3;
            this.availableProductTypes = list4;
            this.seatReservation = bookingSeatReservationDTO;
            this.surcharges = list5;
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(TicketResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeSerializableElement(serialDesc, 0, BookingResponseDTO$DepartureResponseDTO$$serializer.INSTANCE, self.departure);
            output.encodeSerializableElement(serialDesc, 1, DirectionDTO.Serializer.INSTANCE, self.directionType);
            output.encodeSerializableElement(serialDesc, 2, BookingResponseDTO$EditInfoResponseDTO$$serializer.INSTANCE, self.editInfo);
            output.encodeNullableSerializableElement(serialDesc, 3, BookingResponseDTO$GoodsResponseDTO$$serializer.INSTANCE, self.goods);
            output.encodeBooleanElement(serialDesc, 4, self.isCheckedIn);
            output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.products);
            output.encodeSerializableElement(serialDesc, 6, kSerializerArr[6], self.notes);
            output.encodeSerializableElement(serialDesc, 7, BookingResponseDTO$PassengerInfoResponseDTO$$serializer.INSTANCE, self.passengerInfo);
            PriceWithCurrencyDTO$$serializer priceWithCurrencyDTO$$serializer = PriceWithCurrencyDTO$$serializer.INSTANCE;
            output.encodeSerializableElement(serialDesc, 8, priceWithCurrencyDTO$$serializer, self.ticketPrice);
            output.encodeSerializableElement(serialDesc, 9, priceWithCurrencyDTO$$serializer, self.totalPrice);
            output.encodeStringElement(serialDesc, 10, self.ticketCategoryName);
            output.encodeStringElement(serialDesc, 11, self.ticketTypeId);
            output.encodeSerializableElement(serialDesc, 12, BookingResponseDTO$TransportInfoDTO$$serializer.INSTANCE, self.transportInfo);
            output.encodeNullableSerializableElement(serialDesc, 13, kSerializerArr[13], self.barcodes);
            output.encodeNullableSerializableElement(serialDesc, 14, kSerializerArr[14], self.availableProductTypes);
            output.encodeNullableSerializableElement(serialDesc, 15, BookingResponseDTO$BookingSeatReservationDTO$$serializer.INSTANCE, self.seatReservation);
            output.encodeSerializableElement(serialDesc, 16, kSerializerArr[16], self.surcharges);
        }

        /* renamed from: component1, reason: from getter */
        public final DepartureResponseDTO getDeparture() {
            return this.departure;
        }

        /* renamed from: component10, reason: from getter */
        public final PriceWithCurrencyDTO getTotalPrice() {
            return this.totalPrice;
        }

        /* renamed from: component11, reason: from getter */
        public final String getTicketCategoryName() {
            return this.ticketCategoryName;
        }

        /* renamed from: component12, reason: from getter */
        public final String getTicketTypeId() {
            return this.ticketTypeId;
        }

        /* renamed from: component13, reason: from getter */
        public final TransportInfoDTO getTransportInfo() {
            return this.transportInfo;
        }

        public final List<BarcodeResponseDTO> component14() {
            return this.barcodes;
        }

        public final List<ProductTypeResponseDTO> component15() {
            return this.availableProductTypes;
        }

        /* renamed from: component16, reason: from getter */
        public final BookingSeatReservationDTO getSeatReservation() {
            return this.seatReservation;
        }

        public final List<TicketSurchargeDTO> component17() {
            return this.surcharges;
        }

        /* renamed from: component2, reason: from getter */
        public final DirectionDTO getDirectionType() {
            return this.directionType;
        }

        /* renamed from: component3, reason: from getter */
        public final EditInfoResponseDTO getEditInfo() {
            return this.editInfo;
        }

        /* renamed from: component4, reason: from getter */
        public final GoodsResponseDTO getGoods() {
            return this.goods;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsCheckedIn() {
            return this.isCheckedIn;
        }

        public final List<LineItemResponseDTO> component6() {
            return this.products;
        }

        public final List<String> component7() {
            return this.notes;
        }

        /* renamed from: component8, reason: from getter */
        public final PassengerInfoResponseDTO getPassengerInfo() {
            return this.passengerInfo;
        }

        /* renamed from: component9, reason: from getter */
        public final PriceWithCurrencyDTO getTicketPrice() {
            return this.ticketPrice;
        }

        public final TicketResponseDTO copy(DepartureResponseDTO departure, DirectionDTO directionType, EditInfoResponseDTO editInfo, GoodsResponseDTO goods, boolean isCheckedIn, List<LineItemResponseDTO> products, List<String> notes, PassengerInfoResponseDTO passengerInfo, PriceWithCurrencyDTO ticketPrice, PriceWithCurrencyDTO totalPrice, String ticketCategoryName, String ticketTypeId, TransportInfoDTO transportInfo, List<BarcodeResponseDTO> barcodes, List<? extends ProductTypeResponseDTO> availableProductTypes, BookingSeatReservationDTO seatReservation, List<TicketSurchargeDTO> surcharges) {
            Intrinsics.checkNotNullParameter(departure, "departure");
            Intrinsics.checkNotNullParameter(directionType, "directionType");
            Intrinsics.checkNotNullParameter(editInfo, "editInfo");
            Intrinsics.checkNotNullParameter(products, "products");
            Intrinsics.checkNotNullParameter(notes, "notes");
            Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
            Intrinsics.checkNotNullParameter(ticketPrice, "ticketPrice");
            Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
            Intrinsics.checkNotNullParameter(ticketCategoryName, "ticketCategoryName");
            Intrinsics.checkNotNullParameter(ticketTypeId, "ticketTypeId");
            Intrinsics.checkNotNullParameter(transportInfo, "transportInfo");
            Intrinsics.checkNotNullParameter(surcharges, "surcharges");
            return new TicketResponseDTO(departure, directionType, editInfo, goods, isCheckedIn, products, notes, passengerInfo, ticketPrice, totalPrice, ticketCategoryName, ticketTypeId, transportInfo, barcodes, availableProductTypes, seatReservation, surcharges);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TicketResponseDTO)) {
                return false;
            }
            TicketResponseDTO ticketResponseDTO = (TicketResponseDTO) other;
            return Intrinsics.areEqual(this.departure, ticketResponseDTO.departure) && this.directionType == ticketResponseDTO.directionType && Intrinsics.areEqual(this.editInfo, ticketResponseDTO.editInfo) && Intrinsics.areEqual(this.goods, ticketResponseDTO.goods) && this.isCheckedIn == ticketResponseDTO.isCheckedIn && Intrinsics.areEqual(this.products, ticketResponseDTO.products) && Intrinsics.areEqual(this.notes, ticketResponseDTO.notes) && Intrinsics.areEqual(this.passengerInfo, ticketResponseDTO.passengerInfo) && Intrinsics.areEqual(this.ticketPrice, ticketResponseDTO.ticketPrice) && Intrinsics.areEqual(this.totalPrice, ticketResponseDTO.totalPrice) && Intrinsics.areEqual(this.ticketCategoryName, ticketResponseDTO.ticketCategoryName) && Intrinsics.areEqual(this.ticketTypeId, ticketResponseDTO.ticketTypeId) && Intrinsics.areEqual(this.transportInfo, ticketResponseDTO.transportInfo) && Intrinsics.areEqual(this.barcodes, ticketResponseDTO.barcodes) && Intrinsics.areEqual(this.availableProductTypes, ticketResponseDTO.availableProductTypes) && Intrinsics.areEqual(this.seatReservation, ticketResponseDTO.seatReservation) && Intrinsics.areEqual(this.surcharges, ticketResponseDTO.surcharges);
        }

        public final List<ProductTypeResponseDTO> getAvailableProductTypes() {
            return this.availableProductTypes;
        }

        public final List<BarcodeResponseDTO> getBarcodes() {
            return this.barcodes;
        }

        public final DepartureResponseDTO getDeparture() {
            return this.departure;
        }

        public final DirectionDTO getDirectionType() {
            return this.directionType;
        }

        public final EditInfoResponseDTO getEditInfo() {
            return this.editInfo;
        }

        public final GoodsResponseDTO getGoods() {
            return this.goods;
        }

        public final List<String> getNotes() {
            return this.notes;
        }

        public final PassengerInfoResponseDTO getPassengerInfo() {
            return this.passengerInfo;
        }

        public final List<LineItemResponseDTO> getProducts() {
            return this.products;
        }

        public final BookingSeatReservationDTO getSeatReservation() {
            return this.seatReservation;
        }

        public final List<TicketSurchargeDTO> getSurcharges() {
            return this.surcharges;
        }

        public final String getTicketCategoryName() {
            return this.ticketCategoryName;
        }

        public final PriceWithCurrencyDTO getTicketPrice() {
            return this.ticketPrice;
        }

        public final String getTicketTypeId() {
            return this.ticketTypeId;
        }

        public final PriceWithCurrencyDTO getTotalPrice() {
            return this.totalPrice;
        }

        public final TransportInfoDTO getTransportInfo() {
            return this.transportInfo;
        }

        public int hashCode() {
            int hashCode = ((((this.departure.hashCode() * 31) + this.directionType.hashCode()) * 31) + this.editInfo.hashCode()) * 31;
            GoodsResponseDTO goodsResponseDTO = this.goods;
            int hashCode2 = (((((((((((((((((((hashCode + (goodsResponseDTO == null ? 0 : goodsResponseDTO.hashCode())) * 31) + Boolean.hashCode(this.isCheckedIn)) * 31) + this.products.hashCode()) * 31) + this.notes.hashCode()) * 31) + this.passengerInfo.hashCode()) * 31) + this.ticketPrice.hashCode()) * 31) + this.totalPrice.hashCode()) * 31) + this.ticketCategoryName.hashCode()) * 31) + this.ticketTypeId.hashCode()) * 31) + this.transportInfo.hashCode()) * 31;
            List<BarcodeResponseDTO> list = this.barcodes;
            int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
            List<ProductTypeResponseDTO> list2 = this.availableProductTypes;
            int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
            BookingSeatReservationDTO bookingSeatReservationDTO = this.seatReservation;
            return ((hashCode4 + (bookingSeatReservationDTO != null ? bookingSeatReservationDTO.hashCode() : 0)) * 31) + this.surcharges.hashCode();
        }

        public final boolean isCheckedIn() {
            return this.isCheckedIn;
        }

        public String toString() {
            return "TicketResponseDTO(departure=" + this.departure + ", directionType=" + this.directionType + ", editInfo=" + this.editInfo + ", goods=" + this.goods + ", isCheckedIn=" + this.isCheckedIn + ", products=" + this.products + ", notes=" + this.notes + ", passengerInfo=" + this.passengerInfo + ", ticketPrice=" + this.ticketPrice + ", totalPrice=" + this.totalPrice + ", ticketCategoryName=" + this.ticketCategoryName + ", ticketTypeId=" + this.ticketTypeId + ", transportInfo=" + this.transportInfo + ", barcodes=" + this.barcodes + ", availableProductTypes=" + this.availableProductTypes + ", seatReservation=" + this.seatReservation + ", surcharges=" + this.surcharges + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public TicketResponseDTO(DepartureResponseDTO departure, DirectionDTO directionType, EditInfoResponseDTO editInfo, GoodsResponseDTO goodsResponseDTO, boolean z5, List<LineItemResponseDTO> products, List<String> notes, PassengerInfoResponseDTO passengerInfo, PriceWithCurrencyDTO ticketPrice, PriceWithCurrencyDTO totalPrice, String ticketCategoryName, String ticketTypeId, TransportInfoDTO transportInfo, List<BarcodeResponseDTO> list, List<? extends ProductTypeResponseDTO> list2, BookingSeatReservationDTO bookingSeatReservationDTO, List<TicketSurchargeDTO> surcharges) {
            Intrinsics.checkNotNullParameter(departure, "departure");
            Intrinsics.checkNotNullParameter(directionType, "directionType");
            Intrinsics.checkNotNullParameter(editInfo, "editInfo");
            Intrinsics.checkNotNullParameter(products, "products");
            Intrinsics.checkNotNullParameter(notes, "notes");
            Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
            Intrinsics.checkNotNullParameter(ticketPrice, "ticketPrice");
            Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
            Intrinsics.checkNotNullParameter(ticketCategoryName, "ticketCategoryName");
            Intrinsics.checkNotNullParameter(ticketTypeId, "ticketTypeId");
            Intrinsics.checkNotNullParameter(transportInfo, "transportInfo");
            Intrinsics.checkNotNullParameter(surcharges, "surcharges");
            this.departure = departure;
            this.directionType = directionType;
            this.editInfo = editInfo;
            this.goods = goodsResponseDTO;
            this.isCheckedIn = z5;
            this.products = products;
            this.notes = notes;
            this.passengerInfo = passengerInfo;
            this.ticketPrice = ticketPrice;
            this.totalPrice = totalPrice;
            this.ticketCategoryName = ticketCategoryName;
            this.ticketTypeId = ticketTypeId;
            this.transportInfo = transportInfo;
            this.barcodes = list;
            this.availableProductTypes = list2;
            this.seatReservation = bookingSeatReservationDTO;
            this.surcharges = surcharges;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$TransportInfoDTO;", BuildConfig.FLAVOR, "transport", "Ldk/molslinjen/api/shared/response/TransportResponseDTO;", "carId", BuildConfig.FLAVOR, "<init>", "(Ldk/molslinjen/api/shared/response/TransportResponseDTO;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/api/shared/response/TransportResponseDTO;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTransport", "()Ldk/molslinjen/api/shared/response/TransportResponseDTO;", "getCarId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class TransportInfoDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String carId;
        private final TransportResponseDTO transport;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$TransportInfoDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$TransportInfoDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<TransportInfoDTO> serializer() {
                return BookingResponseDTO$TransportInfoDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ TransportInfoDTO(int i5, TransportResponseDTO transportResponseDTO, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i5 & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 3, BookingResponseDTO$TransportInfoDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.transport = transportResponseDTO;
            this.carId = str;
        }

        public static /* synthetic */ TransportInfoDTO copy$default(TransportInfoDTO transportInfoDTO, TransportResponseDTO transportResponseDTO, String str, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                transportResponseDTO = transportInfoDTO.transport;
            }
            if ((i5 & 2) != 0) {
                str = transportInfoDTO.carId;
            }
            return transportInfoDTO.copy(transportResponseDTO, str);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(TransportInfoDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, TransportResponseDTO$$serializer.INSTANCE, self.transport);
            output.encodeStringElement(serialDesc, 1, self.carId);
        }

        /* renamed from: component1, reason: from getter */
        public final TransportResponseDTO getTransport() {
            return this.transport;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCarId() {
            return this.carId;
        }

        public final TransportInfoDTO copy(TransportResponseDTO transport, String carId) {
            Intrinsics.checkNotNullParameter(transport, "transport");
            Intrinsics.checkNotNullParameter(carId, "carId");
            return new TransportInfoDTO(transport, carId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TransportInfoDTO)) {
                return false;
            }
            TransportInfoDTO transportInfoDTO = (TransportInfoDTO) other;
            return Intrinsics.areEqual(this.transport, transportInfoDTO.transport) && Intrinsics.areEqual(this.carId, transportInfoDTO.carId);
        }

        public final String getCarId() {
            return this.carId;
        }

        public final TransportResponseDTO getTransport() {
            return this.transport;
        }

        public int hashCode() {
            return (this.transport.hashCode() * 31) + this.carId.hashCode();
        }

        public String toString() {
            return "TransportInfoDTO(transport=" + this.transport + ", carId=" + this.carId + ")";
        }

        public TransportInfoDTO(TransportResponseDTO transport, String carId) {
            Intrinsics.checkNotNullParameter(transport, "transport");
            Intrinsics.checkNotNullParameter(carId, "carId");
            this.transport = transport;
            this.carId = carId;
        }
    }

    public /* synthetic */ BookingResponseDTO(int i5, AuthenticationInfoResponseDTO authenticationInfoResponseDTO, boolean z5, CustomerInfoResponseDTO customerInfoResponseDTO, PriceWithCurrencyDTO priceWithCurrencyDTO, boolean z6, PriceWithCurrencyDTO priceWithCurrencyDTO2, PriceWithCurrencyDTO priceWithCurrencyDTO3, PriceWithCurrencyDTO priceWithCurrencyDTO4, LocalDate localDate, boolean z7, boolean z8, String str, List list, MultiRideInfoResponseDTO multiRideInfoResponseDTO, SerializationConstructorMarker serializationConstructorMarker) {
        if (16383 != (i5 & 16383)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 16383, BookingResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.authenticationInfo = authenticationInfoResponseDTO;
        this.canChange = z5;
        this.customerInfo = customerInfoResponseDTO;
        this.orderTotal = priceWithCurrencyDTO;
        this.isRefundAvailable = z6;
        this.changeFee = priceWithCurrencyDTO2;
        this.refundAmount = priceWithCurrencyDTO3;
        this.refundFee = priceWithCurrencyDTO4;
        this.refundDate = localDate;
        this.isRefunded = z7;
        this.isUsed = z8;
        this.reservationNumber = str;
        this.tickets = list;
        this.multiRideInfo = multiRideInfoResponseDTO;
    }

    @Serializable(with = LocalDateWithTimeSerializer.class)
    public static /* synthetic */ void getRefundDate$annotations() {
    }

    public static /* synthetic */ void getReservationNumber$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(BookingResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, BookingResponseDTO$AuthenticationInfoResponseDTO$$serializer.INSTANCE, self.authenticationInfo);
        output.encodeBooleanElement(serialDesc, 1, self.canChange);
        output.encodeSerializableElement(serialDesc, 2, BookingResponseDTO$CustomerInfoResponseDTO$$serializer.INSTANCE, self.customerInfo);
        PriceWithCurrencyDTO$$serializer priceWithCurrencyDTO$$serializer = PriceWithCurrencyDTO$$serializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 3, priceWithCurrencyDTO$$serializer, self.orderTotal);
        output.encodeBooleanElement(serialDesc, 4, self.isRefundAvailable);
        output.encodeNullableSerializableElement(serialDesc, 5, priceWithCurrencyDTO$$serializer, self.changeFee);
        output.encodeNullableSerializableElement(serialDesc, 6, priceWithCurrencyDTO$$serializer, self.refundAmount);
        output.encodeNullableSerializableElement(serialDesc, 7, priceWithCurrencyDTO$$serializer, self.refundFee);
        output.encodeNullableSerializableElement(serialDesc, 8, LocalDateWithTimeSerializer.INSTANCE, self.refundDate);
        output.encodeBooleanElement(serialDesc, 9, self.isRefunded);
        output.encodeBooleanElement(serialDesc, 10, self.isUsed);
        output.encodeStringElement(serialDesc, 11, self.reservationNumber);
        output.encodeSerializableElement(serialDesc, 12, kSerializerArr[12], self.tickets);
        output.encodeNullableSerializableElement(serialDesc, 13, BookingResponseDTO$MultiRideInfoResponseDTO$$serializer.INSTANCE, self.multiRideInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final AuthenticationInfoResponseDTO getAuthenticationInfo() {
        return this.authenticationInfo;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsRefunded() {
        return this.isRefunded;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsUsed() {
        return this.isUsed;
    }

    /* renamed from: component12, reason: from getter */
    public final String getReservationNumber() {
        return this.reservationNumber;
    }

    public final List<TicketResponseDTO> component13() {
        return this.tickets;
    }

    /* renamed from: component14, reason: from getter */
    public final MultiRideInfoResponseDTO getMultiRideInfo() {
        return this.multiRideInfo;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getCanChange() {
        return this.canChange;
    }

    /* renamed from: component3, reason: from getter */
    public final CustomerInfoResponseDTO getCustomerInfo() {
        return this.customerInfo;
    }

    /* renamed from: component4, reason: from getter */
    public final PriceWithCurrencyDTO getOrderTotal() {
        return this.orderTotal;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsRefundAvailable() {
        return this.isRefundAvailable;
    }

    /* renamed from: component6, reason: from getter */
    public final PriceWithCurrencyDTO getChangeFee() {
        return this.changeFee;
    }

    /* renamed from: component7, reason: from getter */
    public final PriceWithCurrencyDTO getRefundAmount() {
        return this.refundAmount;
    }

    /* renamed from: component8, reason: from getter */
    public final PriceWithCurrencyDTO getRefundFee() {
        return this.refundFee;
    }

    /* renamed from: component9, reason: from getter */
    public final LocalDate getRefundDate() {
        return this.refundDate;
    }

    public final BookingResponseDTO copy(AuthenticationInfoResponseDTO authenticationInfo, boolean canChange, CustomerInfoResponseDTO customerInfo, PriceWithCurrencyDTO orderTotal, boolean isRefundAvailable, PriceWithCurrencyDTO changeFee, PriceWithCurrencyDTO refundAmount, PriceWithCurrencyDTO refundFee, LocalDate refundDate, boolean isRefunded, boolean isUsed, String reservationNumber, List<TicketResponseDTO> tickets, MultiRideInfoResponseDTO multiRideInfo) {
        Intrinsics.checkNotNullParameter(authenticationInfo, "authenticationInfo");
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Intrinsics.checkNotNullParameter(orderTotal, "orderTotal");
        Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
        Intrinsics.checkNotNullParameter(tickets, "tickets");
        return new BookingResponseDTO(authenticationInfo, canChange, customerInfo, orderTotal, isRefundAvailable, changeFee, refundAmount, refundFee, refundDate, isRefunded, isUsed, reservationNumber, tickets, multiRideInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BookingResponseDTO)) {
            return false;
        }
        BookingResponseDTO bookingResponseDTO = (BookingResponseDTO) other;
        return Intrinsics.areEqual(this.authenticationInfo, bookingResponseDTO.authenticationInfo) && this.canChange == bookingResponseDTO.canChange && Intrinsics.areEqual(this.customerInfo, bookingResponseDTO.customerInfo) && Intrinsics.areEqual(this.orderTotal, bookingResponseDTO.orderTotal) && this.isRefundAvailable == bookingResponseDTO.isRefundAvailable && Intrinsics.areEqual(this.changeFee, bookingResponseDTO.changeFee) && Intrinsics.areEqual(this.refundAmount, bookingResponseDTO.refundAmount) && Intrinsics.areEqual(this.refundFee, bookingResponseDTO.refundFee) && Intrinsics.areEqual(this.refundDate, bookingResponseDTO.refundDate) && this.isRefunded == bookingResponseDTO.isRefunded && this.isUsed == bookingResponseDTO.isUsed && Intrinsics.areEqual(this.reservationNumber, bookingResponseDTO.reservationNumber) && Intrinsics.areEqual(this.tickets, bookingResponseDTO.tickets) && Intrinsics.areEqual(this.multiRideInfo, bookingResponseDTO.multiRideInfo);
    }

    public final AuthenticationInfoResponseDTO getAuthenticationInfo() {
        return this.authenticationInfo;
    }

    public final boolean getCanChange() {
        return this.canChange;
    }

    public final PriceWithCurrencyDTO getChangeFee() {
        return this.changeFee;
    }

    public final CustomerInfoResponseDTO getCustomerInfo() {
        return this.customerInfo;
    }

    public final MultiRideInfoResponseDTO getMultiRideInfo() {
        return this.multiRideInfo;
    }

    public final PriceWithCurrencyDTO getOrderTotal() {
        return this.orderTotal;
    }

    public final PriceWithCurrencyDTO getRefundAmount() {
        return this.refundAmount;
    }

    public final LocalDate getRefundDate() {
        return this.refundDate;
    }

    public final PriceWithCurrencyDTO getRefundFee() {
        return this.refundFee;
    }

    public final String getReservationNumber() {
        return this.reservationNumber;
    }

    public final List<TicketResponseDTO> getTickets() {
        return this.tickets;
    }

    public int hashCode() {
        int hashCode = ((((((((this.authenticationInfo.hashCode() * 31) + Boolean.hashCode(this.canChange)) * 31) + this.customerInfo.hashCode()) * 31) + this.orderTotal.hashCode()) * 31) + Boolean.hashCode(this.isRefundAvailable)) * 31;
        PriceWithCurrencyDTO priceWithCurrencyDTO = this.changeFee;
        int hashCode2 = (hashCode + (priceWithCurrencyDTO == null ? 0 : priceWithCurrencyDTO.hashCode())) * 31;
        PriceWithCurrencyDTO priceWithCurrencyDTO2 = this.refundAmount;
        int hashCode3 = (hashCode2 + (priceWithCurrencyDTO2 == null ? 0 : priceWithCurrencyDTO2.hashCode())) * 31;
        PriceWithCurrencyDTO priceWithCurrencyDTO3 = this.refundFee;
        int hashCode4 = (hashCode3 + (priceWithCurrencyDTO3 == null ? 0 : priceWithCurrencyDTO3.hashCode())) * 31;
        LocalDate localDate = this.refundDate;
        int hashCode5 = (((((((((hashCode4 + (localDate == null ? 0 : localDate.hashCode())) * 31) + Boolean.hashCode(this.isRefunded)) * 31) + Boolean.hashCode(this.isUsed)) * 31) + this.reservationNumber.hashCode()) * 31) + this.tickets.hashCode()) * 31;
        MultiRideInfoResponseDTO multiRideInfoResponseDTO = this.multiRideInfo;
        return hashCode5 + (multiRideInfoResponseDTO != null ? multiRideInfoResponseDTO.hashCode() : 0);
    }

    public final boolean isRefundAvailable() {
        return this.isRefundAvailable;
    }

    public final boolean isRefunded() {
        return this.isRefunded;
    }

    public final boolean isUsed() {
        return this.isUsed;
    }

    public String toString() {
        return "BookingResponseDTO(authenticationInfo=" + this.authenticationInfo + ", canChange=" + this.canChange + ", customerInfo=" + this.customerInfo + ", orderTotal=" + this.orderTotal + ", isRefundAvailable=" + this.isRefundAvailable + ", changeFee=" + this.changeFee + ", refundAmount=" + this.refundAmount + ", refundFee=" + this.refundFee + ", refundDate=" + this.refundDate + ", isRefunded=" + this.isRefunded + ", isUsed=" + this.isUsed + ", reservationNumber=" + this.reservationNumber + ", tickets=" + this.tickets + ", multiRideInfo=" + this.multiRideInfo + ")";
    }

    public BookingResponseDTO(AuthenticationInfoResponseDTO authenticationInfo, boolean z5, CustomerInfoResponseDTO customerInfo, PriceWithCurrencyDTO orderTotal, boolean z6, PriceWithCurrencyDTO priceWithCurrencyDTO, PriceWithCurrencyDTO priceWithCurrencyDTO2, PriceWithCurrencyDTO priceWithCurrencyDTO3, LocalDate localDate, boolean z7, boolean z8, String reservationNumber, List<TicketResponseDTO> tickets, MultiRideInfoResponseDTO multiRideInfoResponseDTO) {
        Intrinsics.checkNotNullParameter(authenticationInfo, "authenticationInfo");
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Intrinsics.checkNotNullParameter(orderTotal, "orderTotal");
        Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
        Intrinsics.checkNotNullParameter(tickets, "tickets");
        this.authenticationInfo = authenticationInfo;
        this.canChange = z5;
        this.customerInfo = customerInfo;
        this.orderTotal = orderTotal;
        this.isRefundAvailable = z6;
        this.changeFee = priceWithCurrencyDTO;
        this.refundAmount = priceWithCurrencyDTO2;
        this.refundFee = priceWithCurrencyDTO3;
        this.refundDate = localDate;
        this.isRefunded = z7;
        this.isUsed = z8;
        this.reservationNumber = reservationNumber;
        this.tickets = tickets;
        this.multiRideInfo = multiRideInfoResponseDTO;
    }
}
