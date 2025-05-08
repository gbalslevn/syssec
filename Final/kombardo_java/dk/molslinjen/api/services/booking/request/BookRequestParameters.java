package dk.molslinjen.api.services.booking.request;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.services.account.passenger.response.GenderDTO;
import dk.molslinjen.api.services.booking.request.DirectionDTO;
import dk.molslinjen.api.services.booking.request.PaymentTypeRequestParameters;
import dk.molslinjen.api.services.booking.response.ProductTypeResponseDTO;
import dk.molslinjen.api.services.booking.response.booking.ApiAppPaymentRedirectDetailsDTO;
import dk.molslinjen.api.services.booking.response.booking.ApiAppPaymentRedirectDetailsDTO$$serializer;
import dk.molslinjen.api.shared.request.PaymentDataRequestParameters;
import dk.molslinjen.api.shared.request.PaymentDataRequestParameters$$serializer;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO$$serializer;
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
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\b\u0018\u0000 A2\u00020\u0001:\u000b789:;<=>?@AB?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010B]\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\fHÆ\u0003J\t\u0010)\u001a\u00020\u000eHÆ\u0003JO\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0012HÖ\u0001J\t\u0010.\u001a\u00020\u000eHÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006B"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters;", BuildConfig.FLAVOR, "booking", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$BookingRequestParameters;", "paymentType", "Ldk/molslinjen/api/services/booking/request/PaymentTypeRequestParameters;", "subscribeToNewsletter", BuildConfig.FLAVOR, "subscribeToPromotions", "paymentRedirectDetails", "Ldk/molslinjen/api/services/booking/response/booking/ApiAppPaymentRedirectDetailsDTO;", "paymentData", "Ldk/molslinjen/api/shared/request/PaymentDataRequestParameters;", "version", BuildConfig.FLAVOR, "<init>", "(Ldk/molslinjen/api/services/booking/request/BookRequestParameters$BookingRequestParameters;Ldk/molslinjen/api/services/booking/request/PaymentTypeRequestParameters;ZZLdk/molslinjen/api/services/booking/response/booking/ApiAppPaymentRedirectDetailsDTO;Ldk/molslinjen/api/shared/request/PaymentDataRequestParameters;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/api/services/booking/request/BookRequestParameters$BookingRequestParameters;Ldk/molslinjen/api/services/booking/request/PaymentTypeRequestParameters;ZZLdk/molslinjen/api/services/booking/response/booking/ApiAppPaymentRedirectDetailsDTO;Ldk/molslinjen/api/shared/request/PaymentDataRequestParameters;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBooking", "()Ldk/molslinjen/api/services/booking/request/BookRequestParameters$BookingRequestParameters;", "getPaymentType", "()Ldk/molslinjen/api/services/booking/request/PaymentTypeRequestParameters;", "getSubscribeToNewsletter", "()Z", "getSubscribeToPromotions", "getPaymentRedirectDetails", "()Ldk/molslinjen/api/services/booking/response/booking/ApiAppPaymentRedirectDetailsDTO;", "getPaymentData", "()Ldk/molslinjen/api/shared/request/PaymentDataRequestParameters;", "getVersion", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "BookingRequestParameters", "CustomerInfoRequestParameters", "MultiRideRequestParameters", "TicketRequestParameters", "BookSeatReservationRequestParameter", "GoodsRequestParameters", "PassengerInfoRequestParameters", "ProductRequestParameters", "PassengerDataRequestParameters", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class BookRequestParameters {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final BookingRequestParameters booking;
    private final PaymentDataRequestParameters paymentData;
    private final ApiAppPaymentRedirectDetailsDTO paymentRedirectDetails;
    private final PaymentTypeRequestParameters paymentType;
    private final boolean subscribeToNewsletter;
    private final boolean subscribeToPromotions;
    private final String version;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0003\"#$B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB3\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$BookSeatReservationRequestParameter;", BuildConfig.FLAVOR, "seatReservationId", BuildConfig.FLAVOR, "seats", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$BookSeatReservationRequestParameter$SeatRequestParameters;", "<init>", "(ILjava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSeatReservationId", "()I", "getSeats", "()Ljava/util/List;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "SeatRequestParameters", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class BookSeatReservationRequestParameter {
        private final int seatReservationId;
        private final List<SeatRequestParameters> seats;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(BookRequestParameters$BookSeatReservationRequestParameter$SeatRequestParameters$$serializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$BookSeatReservationRequestParameter$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$BookSeatReservationRequestParameter;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<BookSeatReservationRequestParameter> serializer() {
                return BookRequestParameters$BookSeatReservationRequestParameter$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bBI\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006-"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$BookSeatReservationRequestParameter$SeatRequestParameters;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "seatPrice", "Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "text", BuildConfig.FLAVOR, "sectionName", "type", "<init>", "(ILdk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ljava/lang/String;Ljava/lang/String;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILdk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ljava/lang/String;Ljava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()I", "getSeatPrice", "()Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "getText", "()Ljava/lang/String;", "getSectionName", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @Serializable
        /* loaded from: classes2.dex */
        public static final /* data */ class SeatRequestParameters {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final int id;
            private final PriceWithCurrencyDTO seatPrice;
            private final String sectionName;
            private final String text;
            private final int type;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$BookSeatReservationRequestParameter$SeatRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$BookSeatReservationRequestParameter$SeatRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes2.dex */
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<SeatRequestParameters> serializer() {
                    return BookRequestParameters$BookSeatReservationRequestParameter$SeatRequestParameters$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public /* synthetic */ SeatRequestParameters(int i5, int i6, PriceWithCurrencyDTO priceWithCurrencyDTO, String str, String str2, int i7, SerializationConstructorMarker serializationConstructorMarker) {
                if (15 != (i5 & 15)) {
                    PluginExceptionsKt.throwMissingFieldException(i5, 15, BookRequestParameters$BookSeatReservationRequestParameter$SeatRequestParameters$$serializer.INSTANCE.getDescriptor());
                }
                this.id = i6;
                this.seatPrice = priceWithCurrencyDTO;
                this.text = str;
                this.sectionName = str2;
                if ((i5 & 16) == 0) {
                    this.type = 0;
                } else {
                    this.type = i7;
                }
            }

            public static /* synthetic */ SeatRequestParameters copy$default(SeatRequestParameters seatRequestParameters, int i5, PriceWithCurrencyDTO priceWithCurrencyDTO, String str, String str2, int i6, int i7, Object obj) {
                if ((i7 & 1) != 0) {
                    i5 = seatRequestParameters.id;
                }
                if ((i7 & 2) != 0) {
                    priceWithCurrencyDTO = seatRequestParameters.seatPrice;
                }
                PriceWithCurrencyDTO priceWithCurrencyDTO2 = priceWithCurrencyDTO;
                if ((i7 & 4) != 0) {
                    str = seatRequestParameters.text;
                }
                String str3 = str;
                if ((i7 & 8) != 0) {
                    str2 = seatRequestParameters.sectionName;
                }
                String str4 = str2;
                if ((i7 & 16) != 0) {
                    i6 = seatRequestParameters.type;
                }
                return seatRequestParameters.copy(i5, priceWithCurrencyDTO2, str3, str4, i6);
            }

            public static final /* synthetic */ void write$Self$api_kombardoProd(SeatRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeIntElement(serialDesc, 0, self.id);
                output.encodeSerializableElement(serialDesc, 1, PriceWithCurrencyDTO$$serializer.INSTANCE, self.seatPrice);
                output.encodeStringElement(serialDesc, 2, self.text);
                output.encodeStringElement(serialDesc, 3, self.sectionName);
                if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.type == 0) {
                    return;
                }
                output.encodeIntElement(serialDesc, 4, self.type);
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

            /* renamed from: component5, reason: from getter */
            public final int getType() {
                return this.type;
            }

            public final SeatRequestParameters copy(int id, PriceWithCurrencyDTO seatPrice, String text, String sectionName, int type) {
                Intrinsics.checkNotNullParameter(seatPrice, "seatPrice");
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(sectionName, "sectionName");
                return new SeatRequestParameters(id, seatPrice, text, sectionName, type);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SeatRequestParameters)) {
                    return false;
                }
                SeatRequestParameters seatRequestParameters = (SeatRequestParameters) other;
                return this.id == seatRequestParameters.id && Intrinsics.areEqual(this.seatPrice, seatRequestParameters.seatPrice) && Intrinsics.areEqual(this.text, seatRequestParameters.text) && Intrinsics.areEqual(this.sectionName, seatRequestParameters.sectionName) && this.type == seatRequestParameters.type;
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

            public final int getType() {
                return this.type;
            }

            public int hashCode() {
                return (((((((Integer.hashCode(this.id) * 31) + this.seatPrice.hashCode()) * 31) + this.text.hashCode()) * 31) + this.sectionName.hashCode()) * 31) + Integer.hashCode(this.type);
            }

            public String toString() {
                return "SeatRequestParameters(id=" + this.id + ", seatPrice=" + this.seatPrice + ", text=" + this.text + ", sectionName=" + this.sectionName + ", type=" + this.type + ")";
            }

            public SeatRequestParameters(int i5, PriceWithCurrencyDTO seatPrice, String text, String sectionName, int i6) {
                Intrinsics.checkNotNullParameter(seatPrice, "seatPrice");
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(sectionName, "sectionName");
                this.id = i5;
                this.seatPrice = seatPrice;
                this.text = text;
                this.sectionName = sectionName;
                this.type = i6;
            }

            public /* synthetic */ SeatRequestParameters(int i5, PriceWithCurrencyDTO priceWithCurrencyDTO, String str, String str2, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
                this(i5, priceWithCurrencyDTO, str, str2, (i7 & 16) != 0 ? 0 : i6);
            }
        }

        public /* synthetic */ BookSeatReservationRequestParameter(int i5, int i6, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i5 & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 3, BookRequestParameters$BookSeatReservationRequestParameter$$serializer.INSTANCE.getDescriptor());
            }
            this.seatReservationId = i6;
            this.seats = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BookSeatReservationRequestParameter copy$default(BookSeatReservationRequestParameter bookSeatReservationRequestParameter, int i5, List list, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i5 = bookSeatReservationRequestParameter.seatReservationId;
            }
            if ((i6 & 2) != 0) {
                list = bookSeatReservationRequestParameter.seats;
            }
            return bookSeatReservationRequestParameter.copy(i5, list);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(BookSeatReservationRequestParameter self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeIntElement(serialDesc, 0, self.seatReservationId);
            output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.seats);
        }

        /* renamed from: component1, reason: from getter */
        public final int getSeatReservationId() {
            return this.seatReservationId;
        }

        public final List<SeatRequestParameters> component2() {
            return this.seats;
        }

        public final BookSeatReservationRequestParameter copy(int seatReservationId, List<SeatRequestParameters> seats) {
            Intrinsics.checkNotNullParameter(seats, "seats");
            return new BookSeatReservationRequestParameter(seatReservationId, seats);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BookSeatReservationRequestParameter)) {
                return false;
            }
            BookSeatReservationRequestParameter bookSeatReservationRequestParameter = (BookSeatReservationRequestParameter) other;
            return this.seatReservationId == bookSeatReservationRequestParameter.seatReservationId && Intrinsics.areEqual(this.seats, bookSeatReservationRequestParameter.seats);
        }

        public final int getSeatReservationId() {
            return this.seatReservationId;
        }

        public final List<SeatRequestParameters> getSeats() {
            return this.seats;
        }

        public int hashCode() {
            return (Integer.hashCode(this.seatReservationId) * 31) + this.seats.hashCode();
        }

        public String toString() {
            return "BookSeatReservationRequestParameter(seatReservationId=" + this.seatReservationId + ", seats=" + this.seats + ")";
        }

        public BookSeatReservationRequestParameter(int i5, List<SeatRequestParameters> seats) {
            Intrinsics.checkNotNullParameter(seats, "seats");
            this.seatReservationId = i5;
            this.seats = seats;
        }
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u00029:BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000f\u0010\u0010Bg\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003J]\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0012HÖ\u0001J\t\u00100\u001a\u00020\bHÖ\u0001J%\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u001bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001b¨\u0006;"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$BookingRequestParameters;", BuildConfig.FLAVOR, "customerInfo", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$CustomerInfoRequestParameters;", "tickets", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$TicketRequestParameters;", "commuteAgreementId", BuildConfig.FLAVOR, "multiRide", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$MultiRideRequestParameters;", "reservationNumber", "currency", "Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "originalPhoneNumber", "<init>", "(Ldk/molslinjen/api/services/booking/request/BookRequestParameters$CustomerInfoRequestParameters;Ljava/util/List;Ljava/lang/String;Ldk/molslinjen/api/services/booking/request/BookRequestParameters$MultiRideRequestParameters;Ljava/lang/String;Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/api/services/booking/request/BookRequestParameters$CustomerInfoRequestParameters;Ljava/util/List;Ljava/lang/String;Ldk/molslinjen/api/services/booking/request/BookRequestParameters$MultiRideRequestParameters;Ljava/lang/String;Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCustomerInfo", "()Ldk/molslinjen/api/services/booking/request/BookRequestParameters$CustomerInfoRequestParameters;", "getTickets", "()Ljava/util/List;", "getCommuteAgreementId", "()Ljava/lang/String;", "getMultiRide", "()Ldk/molslinjen/api/services/booking/request/BookRequestParameters$MultiRideRequestParameters;", "getReservationNumber$annotations", "()V", "getReservationNumber", "getCurrency", "()Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "getOriginalPhoneNumber", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class BookingRequestParameters {
        private final String commuteAgreementId;
        private final CurrencyTypeDTO currency;
        private final CustomerInfoRequestParameters customerInfo;
        private final MultiRideRequestParameters multiRide;
        private final String originalPhoneNumber;
        private final String reservationNumber;
        private final List<TicketRequestParameters> tickets;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(BookRequestParameters$TicketRequestParameters$$serializer.INSTANCE), null, null, null, null, null};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$BookingRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$BookingRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<BookingRequestParameters> serializer() {
                return BookRequestParameters$BookingRequestParameters$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ BookingRequestParameters(int i5, CustomerInfoRequestParameters customerInfoRequestParameters, List list, String str, MultiRideRequestParameters multiRideRequestParameters, String str2, CurrencyTypeDTO currencyTypeDTO, String str3, SerializationConstructorMarker serializationConstructorMarker) {
            if (127 != (i5 & 127)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 127, BookRequestParameters$BookingRequestParameters$$serializer.INSTANCE.getDescriptor());
            }
            this.customerInfo = customerInfoRequestParameters;
            this.tickets = list;
            this.commuteAgreementId = str;
            this.multiRide = multiRideRequestParameters;
            this.reservationNumber = str2;
            this.currency = currencyTypeDTO;
            this.originalPhoneNumber = str3;
        }

        public static /* synthetic */ BookingRequestParameters copy$default(BookingRequestParameters bookingRequestParameters, CustomerInfoRequestParameters customerInfoRequestParameters, List list, String str, MultiRideRequestParameters multiRideRequestParameters, String str2, CurrencyTypeDTO currencyTypeDTO, String str3, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                customerInfoRequestParameters = bookingRequestParameters.customerInfo;
            }
            if ((i5 & 2) != 0) {
                list = bookingRequestParameters.tickets;
            }
            List list2 = list;
            if ((i5 & 4) != 0) {
                str = bookingRequestParameters.commuteAgreementId;
            }
            String str4 = str;
            if ((i5 & 8) != 0) {
                multiRideRequestParameters = bookingRequestParameters.multiRide;
            }
            MultiRideRequestParameters multiRideRequestParameters2 = multiRideRequestParameters;
            if ((i5 & 16) != 0) {
                str2 = bookingRequestParameters.reservationNumber;
            }
            String str5 = str2;
            if ((i5 & 32) != 0) {
                currencyTypeDTO = bookingRequestParameters.currency;
            }
            CurrencyTypeDTO currencyTypeDTO2 = currencyTypeDTO;
            if ((i5 & 64) != 0) {
                str3 = bookingRequestParameters.originalPhoneNumber;
            }
            return bookingRequestParameters.copy(customerInfoRequestParameters, list2, str4, multiRideRequestParameters2, str5, currencyTypeDTO2, str3);
        }

        public static /* synthetic */ void getReservationNumber$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(BookingRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeSerializableElement(serialDesc, 0, BookRequestParameters$CustomerInfoRequestParameters$$serializer.INSTANCE, self.customerInfo);
            output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.tickets);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 2, stringSerializer, self.commuteAgreementId);
            output.encodeNullableSerializableElement(serialDesc, 3, BookRequestParameters$MultiRideRequestParameters$$serializer.INSTANCE, self.multiRide);
            output.encodeNullableSerializableElement(serialDesc, 4, stringSerializer, self.reservationNumber);
            output.encodeSerializableElement(serialDesc, 5, CurrencyTypeDTO.Serializer.INSTANCE, self.currency);
            output.encodeNullableSerializableElement(serialDesc, 6, stringSerializer, self.originalPhoneNumber);
        }

        /* renamed from: component1, reason: from getter */
        public final CustomerInfoRequestParameters getCustomerInfo() {
            return this.customerInfo;
        }

        public final List<TicketRequestParameters> component2() {
            return this.tickets;
        }

        /* renamed from: component3, reason: from getter */
        public final String getCommuteAgreementId() {
            return this.commuteAgreementId;
        }

        /* renamed from: component4, reason: from getter */
        public final MultiRideRequestParameters getMultiRide() {
            return this.multiRide;
        }

        /* renamed from: component5, reason: from getter */
        public final String getReservationNumber() {
            return this.reservationNumber;
        }

        /* renamed from: component6, reason: from getter */
        public final CurrencyTypeDTO getCurrency() {
            return this.currency;
        }

        /* renamed from: component7, reason: from getter */
        public final String getOriginalPhoneNumber() {
            return this.originalPhoneNumber;
        }

        public final BookingRequestParameters copy(CustomerInfoRequestParameters customerInfo, List<TicketRequestParameters> tickets, String commuteAgreementId, MultiRideRequestParameters multiRide, String reservationNumber, CurrencyTypeDTO currency, String originalPhoneNumber) {
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
            Intrinsics.checkNotNullParameter(tickets, "tickets");
            Intrinsics.checkNotNullParameter(currency, "currency");
            return new BookingRequestParameters(customerInfo, tickets, commuteAgreementId, multiRide, reservationNumber, currency, originalPhoneNumber);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BookingRequestParameters)) {
                return false;
            }
            BookingRequestParameters bookingRequestParameters = (BookingRequestParameters) other;
            return Intrinsics.areEqual(this.customerInfo, bookingRequestParameters.customerInfo) && Intrinsics.areEqual(this.tickets, bookingRequestParameters.tickets) && Intrinsics.areEqual(this.commuteAgreementId, bookingRequestParameters.commuteAgreementId) && Intrinsics.areEqual(this.multiRide, bookingRequestParameters.multiRide) && Intrinsics.areEqual(this.reservationNumber, bookingRequestParameters.reservationNumber) && this.currency == bookingRequestParameters.currency && Intrinsics.areEqual(this.originalPhoneNumber, bookingRequestParameters.originalPhoneNumber);
        }

        public final String getCommuteAgreementId() {
            return this.commuteAgreementId;
        }

        public final CurrencyTypeDTO getCurrency() {
            return this.currency;
        }

        public final CustomerInfoRequestParameters getCustomerInfo() {
            return this.customerInfo;
        }

        public final MultiRideRequestParameters getMultiRide() {
            return this.multiRide;
        }

        public final String getOriginalPhoneNumber() {
            return this.originalPhoneNumber;
        }

        public final String getReservationNumber() {
            return this.reservationNumber;
        }

        public final List<TicketRequestParameters> getTickets() {
            return this.tickets;
        }

        public int hashCode() {
            int hashCode = ((this.customerInfo.hashCode() * 31) + this.tickets.hashCode()) * 31;
            String str = this.commuteAgreementId;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            MultiRideRequestParameters multiRideRequestParameters = this.multiRide;
            int hashCode3 = (hashCode2 + (multiRideRequestParameters == null ? 0 : multiRideRequestParameters.hashCode())) * 31;
            String str2 = this.reservationNumber;
            int hashCode4 = (((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.currency.hashCode()) * 31;
            String str3 = this.originalPhoneNumber;
            return hashCode4 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "BookingRequestParameters(customerInfo=" + this.customerInfo + ", tickets=" + this.tickets + ", commuteAgreementId=" + this.commuteAgreementId + ", multiRide=" + this.multiRide + ", reservationNumber=" + this.reservationNumber + ", currency=" + this.currency + ", originalPhoneNumber=" + this.originalPhoneNumber + ")";
        }

        public BookingRequestParameters(CustomerInfoRequestParameters customerInfo, List<TicketRequestParameters> tickets, String str, MultiRideRequestParameters multiRideRequestParameters, String str2, CurrencyTypeDTO currency, String str3) {
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
            Intrinsics.checkNotNullParameter(tickets, "tickets");
            Intrinsics.checkNotNullParameter(currency, "currency");
            this.customerInfo = customerInfo;
            this.tickets = tickets;
            this.commuteAgreementId = str;
            this.multiRide = multiRideRequestParameters;
            this.reservationNumber = str2;
            this.currency = currency;
            this.originalPhoneNumber = str3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<BookRequestParameters> serializer() {
            return BookRequestParameters$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tBM\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u000bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0010¨\u0006,"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$CustomerInfoRequestParameters;", BuildConfig.FLAVOR, "email", BuildConfig.FLAVOR, "phone", "postalCode", "prefix", "licensePlate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEmail", "()Ljava/lang/String;", "getPhone", "getPostalCode", "getPrefix", "getLicensePlate$annotations", "()V", "getLicensePlate", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class CustomerInfoRequestParameters {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String email;
        private final String licensePlate;
        private final String phone;
        private final String postalCode;
        private final String prefix;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$CustomerInfoRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$CustomerInfoRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<CustomerInfoRequestParameters> serializer() {
                return BookRequestParameters$CustomerInfoRequestParameters$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ CustomerInfoRequestParameters(int i5, String str, String str2, String str3, String str4, String str5, SerializationConstructorMarker serializationConstructorMarker) {
            if (31 != (i5 & 31)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 31, BookRequestParameters$CustomerInfoRequestParameters$$serializer.INSTANCE.getDescriptor());
            }
            this.email = str;
            this.phone = str2;
            this.postalCode = str3;
            this.prefix = str4;
            this.licensePlate = str5;
        }

        public static /* synthetic */ CustomerInfoRequestParameters copy$default(CustomerInfoRequestParameters customerInfoRequestParameters, String str, String str2, String str3, String str4, String str5, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = customerInfoRequestParameters.email;
            }
            if ((i5 & 2) != 0) {
                str2 = customerInfoRequestParameters.phone;
            }
            String str6 = str2;
            if ((i5 & 4) != 0) {
                str3 = customerInfoRequestParameters.postalCode;
            }
            String str7 = str3;
            if ((i5 & 8) != 0) {
                str4 = customerInfoRequestParameters.prefix;
            }
            String str8 = str4;
            if ((i5 & 16) != 0) {
                str5 = customerInfoRequestParameters.licensePlate;
            }
            return customerInfoRequestParameters.copy(str, str6, str7, str8, str5);
        }

        public static /* synthetic */ void getLicensePlate$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(CustomerInfoRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
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

        public final CustomerInfoRequestParameters copy(String email, String phone, String postalCode, String prefix, String licensePlate) {
            Intrinsics.checkNotNullParameter(email, "email");
            Intrinsics.checkNotNullParameter(phone, "phone");
            Intrinsics.checkNotNullParameter(postalCode, "postalCode");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            return new CustomerInfoRequestParameters(email, phone, postalCode, prefix, licensePlate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CustomerInfoRequestParameters)) {
                return false;
            }
            CustomerInfoRequestParameters customerInfoRequestParameters = (CustomerInfoRequestParameters) other;
            return Intrinsics.areEqual(this.email, customerInfoRequestParameters.email) && Intrinsics.areEqual(this.phone, customerInfoRequestParameters.phone) && Intrinsics.areEqual(this.postalCode, customerInfoRequestParameters.postalCode) && Intrinsics.areEqual(this.prefix, customerInfoRequestParameters.prefix) && Intrinsics.areEqual(this.licensePlate, customerInfoRequestParameters.licensePlate);
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
            return "CustomerInfoRequestParameters(email=" + this.email + ", phone=" + this.phone + ", postalCode=" + this.postalCode + ", prefix=" + this.prefix + ", licensePlate=" + this.licensePlate + ")";
        }

        public CustomerInfoRequestParameters(String email, String phone, String postalCode, String prefix, String str) {
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

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\tJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J%\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0001¢\u0006\u0002\b\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$GoodsRequestParameters;", BuildConfig.FLAVOR, "weight", BuildConfig.FLAVOR, "<init>", "(I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getWeight", "()I", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class GoodsRequestParameters {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int weight;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$GoodsRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$GoodsRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<GoodsRequestParameters> serializer() {
                return BookRequestParameters$GoodsRequestParameters$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ GoodsRequestParameters(int i5, int i6, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i5 & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 1, BookRequestParameters$GoodsRequestParameters$$serializer.INSTANCE.getDescriptor());
            }
            this.weight = i6;
        }

        public static /* synthetic */ GoodsRequestParameters copy$default(GoodsRequestParameters goodsRequestParameters, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i5 = goodsRequestParameters.weight;
            }
            return goodsRequestParameters.copy(i5);
        }

        /* renamed from: component1, reason: from getter */
        public final int getWeight() {
            return this.weight;
        }

        public final GoodsRequestParameters copy(int weight) {
            return new GoodsRequestParameters(weight);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GoodsRequestParameters) && this.weight == ((GoodsRequestParameters) other).weight;
        }

        public final int getWeight() {
            return this.weight;
        }

        public int hashCode() {
            return Integer.hashCode(this.weight);
        }

        public String toString() {
            return "GoodsRequestParameters(weight=" + this.weight + ")";
        }

        public GoodsRequestParameters(int i5) {
            this.weight = i5;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$MultiRideRequestParameters;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "cardType", "customerId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getCardType", "getCustomerId", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class MultiRideRequestParameters {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String cardType;
        private final String customerId;
        private final String id;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$MultiRideRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$MultiRideRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<MultiRideRequestParameters> serializer() {
                return BookRequestParameters$MultiRideRequestParameters$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ MultiRideRequestParameters(int i5, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, BookRequestParameters$MultiRideRequestParameters$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.cardType = str2;
            this.customerId = str3;
        }

        public static /* synthetic */ MultiRideRequestParameters copy$default(MultiRideRequestParameters multiRideRequestParameters, String str, String str2, String str3, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = multiRideRequestParameters.id;
            }
            if ((i5 & 2) != 0) {
                str2 = multiRideRequestParameters.cardType;
            }
            if ((i5 & 4) != 0) {
                str3 = multiRideRequestParameters.customerId;
            }
            return multiRideRequestParameters.copy(str, str2, str3);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(MultiRideRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeStringElement(serialDesc, 1, self.cardType);
            output.encodeStringElement(serialDesc, 2, self.customerId);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCardType() {
            return this.cardType;
        }

        /* renamed from: component3, reason: from getter */
        public final String getCustomerId() {
            return this.customerId;
        }

        public final MultiRideRequestParameters copy(String id, String cardType, String customerId) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(cardType, "cardType");
            Intrinsics.checkNotNullParameter(customerId, "customerId");
            return new MultiRideRequestParameters(id, cardType, customerId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MultiRideRequestParameters)) {
                return false;
            }
            MultiRideRequestParameters multiRideRequestParameters = (MultiRideRequestParameters) other;
            return Intrinsics.areEqual(this.id, multiRideRequestParameters.id) && Intrinsics.areEqual(this.cardType, multiRideRequestParameters.cardType) && Intrinsics.areEqual(this.customerId, multiRideRequestParameters.customerId);
        }

        public final String getCardType() {
            return this.cardType;
        }

        public final String getCustomerId() {
            return this.customerId;
        }

        public final String getId() {
            return this.id;
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + this.cardType.hashCode()) * 31) + this.customerId.hashCode();
        }

        public String toString() {
            return "MultiRideRequestParameters(id=" + this.id + ", cardType=" + this.cardType + ", customerId=" + this.customerId + ")";
        }

        public MultiRideRequestParameters(String id, String cardType, String customerId) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(cardType, "cardType");
            Intrinsics.checkNotNullParameter(customerId, "customerId");
            this.id = id;
            this.cardType = cardType;
            this.customerId = customerId;
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002./B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\rHÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016¨\u00060"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$PassengerDataRequestParameters;", BuildConfig.FLAVOR, "birthDate", "Lorg/threeten/bp/LocalDate;", "firstName", BuildConfig.FLAVOR, "gender", "Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;", "lastName", "nationality", "<init>", "(Lorg/threeten/bp/LocalDate;Ljava/lang/String;Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILorg/threeten/bp/LocalDate;Ljava/lang/String;Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBirthDate$annotations", "()V", "getBirthDate", "()Lorg/threeten/bp/LocalDate;", "getFirstName", "()Ljava/lang/String;", "getGender", "()Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;", "getLastName", "getNationality", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class PassengerDataRequestParameters {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final LocalDate birthDate;
        private final String firstName;
        private final GenderDTO gender;
        private final String lastName;
        private final String nationality;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$PassengerDataRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$PassengerDataRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<PassengerDataRequestParameters> serializer() {
                return BookRequestParameters$PassengerDataRequestParameters$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ PassengerDataRequestParameters(int i5, LocalDate localDate, String str, GenderDTO genderDTO, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
            if (31 != (i5 & 31)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 31, BookRequestParameters$PassengerDataRequestParameters$$serializer.INSTANCE.getDescriptor());
            }
            this.birthDate = localDate;
            this.firstName = str;
            this.gender = genderDTO;
            this.lastName = str2;
            this.nationality = str3;
        }

        public static /* synthetic */ PassengerDataRequestParameters copy$default(PassengerDataRequestParameters passengerDataRequestParameters, LocalDate localDate, String str, GenderDTO genderDTO, String str2, String str3, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                localDate = passengerDataRequestParameters.birthDate;
            }
            if ((i5 & 2) != 0) {
                str = passengerDataRequestParameters.firstName;
            }
            String str4 = str;
            if ((i5 & 4) != 0) {
                genderDTO = passengerDataRequestParameters.gender;
            }
            GenderDTO genderDTO2 = genderDTO;
            if ((i5 & 8) != 0) {
                str2 = passengerDataRequestParameters.lastName;
            }
            String str5 = str2;
            if ((i5 & 16) != 0) {
                str3 = passengerDataRequestParameters.nationality;
            }
            return passengerDataRequestParameters.copy(localDate, str4, genderDTO2, str5, str3);
        }

        @Serializable(with = LocalDateWithTimeSerializer.class)
        public static /* synthetic */ void getBirthDate$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(PassengerDataRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, LocalDateWithTimeSerializer.INSTANCE, self.birthDate);
            output.encodeStringElement(serialDesc, 1, self.firstName);
            output.encodeSerializableElement(serialDesc, 2, GenderDTO.Serializer.INSTANCE, self.gender);
            output.encodeStringElement(serialDesc, 3, self.lastName);
            output.encodeStringElement(serialDesc, 4, self.nationality);
        }

        /* renamed from: component1, reason: from getter */
        public final LocalDate getBirthDate() {
            return this.birthDate;
        }

        /* renamed from: component2, reason: from getter */
        public final String getFirstName() {
            return this.firstName;
        }

        /* renamed from: component3, reason: from getter */
        public final GenderDTO getGender() {
            return this.gender;
        }

        /* renamed from: component4, reason: from getter */
        public final String getLastName() {
            return this.lastName;
        }

        /* renamed from: component5, reason: from getter */
        public final String getNationality() {
            return this.nationality;
        }

        public final PassengerDataRequestParameters copy(LocalDate birthDate, String firstName, GenderDTO gender, String lastName, String nationality) {
            Intrinsics.checkNotNullParameter(birthDate, "birthDate");
            Intrinsics.checkNotNullParameter(firstName, "firstName");
            Intrinsics.checkNotNullParameter(gender, "gender");
            Intrinsics.checkNotNullParameter(lastName, "lastName");
            Intrinsics.checkNotNullParameter(nationality, "nationality");
            return new PassengerDataRequestParameters(birthDate, firstName, gender, lastName, nationality);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PassengerDataRequestParameters)) {
                return false;
            }
            PassengerDataRequestParameters passengerDataRequestParameters = (PassengerDataRequestParameters) other;
            return Intrinsics.areEqual(this.birthDate, passengerDataRequestParameters.birthDate) && Intrinsics.areEqual(this.firstName, passengerDataRequestParameters.firstName) && this.gender == passengerDataRequestParameters.gender && Intrinsics.areEqual(this.lastName, passengerDataRequestParameters.lastName) && Intrinsics.areEqual(this.nationality, passengerDataRequestParameters.nationality);
        }

        public final LocalDate getBirthDate() {
            return this.birthDate;
        }

        public final String getFirstName() {
            return this.firstName;
        }

        public final GenderDTO getGender() {
            return this.gender;
        }

        public final String getLastName() {
            return this.lastName;
        }

        public final String getNationality() {
            return this.nationality;
        }

        public int hashCode() {
            return (((((((this.birthDate.hashCode() * 31) + this.firstName.hashCode()) * 31) + this.gender.hashCode()) * 31) + this.lastName.hashCode()) * 31) + this.nationality.hashCode();
        }

        public String toString() {
            return "PassengerDataRequestParameters(birthDate=" + this.birthDate + ", firstName=" + this.firstName + ", gender=" + this.gender + ", lastName=" + this.lastName + ", nationality=" + this.nationality + ")";
        }

        public PassengerDataRequestParameters(LocalDate birthDate, String firstName, GenderDTO gender, String lastName, String nationality) {
            Intrinsics.checkNotNullParameter(birthDate, "birthDate");
            Intrinsics.checkNotNullParameter(firstName, "firstName");
            Intrinsics.checkNotNullParameter(gender, "gender");
            Intrinsics.checkNotNullParameter(lastName, "lastName");
            Intrinsics.checkNotNullParameter(nationality, "nationality");
            this.birthDate = birthDate;
            this.firstName = firstName;
            this.gender = gender;
            this.lastName = lastName;
            this.nationality = nationality;
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006*"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$PassengerInfoRequestParameters;", BuildConfig.FLAVOR, "adultCount", BuildConfig.FLAVOR, "childCount", "infantCount", "passengerData", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$PassengerDataRequestParameters;", "<init>", "(IIILjava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAdultCount", "()I", "getChildCount", "getInfantCount", "getPassengerData", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class PassengerInfoRequestParameters {
        private final int adultCount;
        private final int childCount;
        private final int infantCount;
        private final List<PassengerDataRequestParameters> passengerData;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, new ArrayListSerializer(BookRequestParameters$PassengerDataRequestParameters$$serializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$PassengerInfoRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$PassengerInfoRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<PassengerInfoRequestParameters> serializer() {
                return BookRequestParameters$PassengerInfoRequestParameters$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ PassengerInfoRequestParameters(int i5, int i6, int i7, int i8, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i5 & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 15, BookRequestParameters$PassengerInfoRequestParameters$$serializer.INSTANCE.getDescriptor());
            }
            this.adultCount = i6;
            this.childCount = i7;
            this.infantCount = i8;
            this.passengerData = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PassengerInfoRequestParameters copy$default(PassengerInfoRequestParameters passengerInfoRequestParameters, int i5, int i6, int i7, List list, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                i5 = passengerInfoRequestParameters.adultCount;
            }
            if ((i8 & 2) != 0) {
                i6 = passengerInfoRequestParameters.childCount;
            }
            if ((i8 & 4) != 0) {
                i7 = passengerInfoRequestParameters.infantCount;
            }
            if ((i8 & 8) != 0) {
                list = passengerInfoRequestParameters.passengerData;
            }
            return passengerInfoRequestParameters.copy(i5, i6, i7, list);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(PassengerInfoRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
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

        public final List<PassengerDataRequestParameters> component4() {
            return this.passengerData;
        }

        public final PassengerInfoRequestParameters copy(int adultCount, int childCount, int infantCount, List<PassengerDataRequestParameters> passengerData) {
            Intrinsics.checkNotNullParameter(passengerData, "passengerData");
            return new PassengerInfoRequestParameters(adultCount, childCount, infantCount, passengerData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PassengerInfoRequestParameters)) {
                return false;
            }
            PassengerInfoRequestParameters passengerInfoRequestParameters = (PassengerInfoRequestParameters) other;
            return this.adultCount == passengerInfoRequestParameters.adultCount && this.childCount == passengerInfoRequestParameters.childCount && this.infantCount == passengerInfoRequestParameters.infantCount && Intrinsics.areEqual(this.passengerData, passengerInfoRequestParameters.passengerData);
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

        public final List<PassengerDataRequestParameters> getPassengerData() {
            return this.passengerData;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.adultCount) * 31) + Integer.hashCode(this.childCount)) * 31) + Integer.hashCode(this.infantCount)) * 31) + this.passengerData.hashCode();
        }

        public String toString() {
            return "PassengerInfoRequestParameters(adultCount=" + this.adultCount + ", childCount=" + this.childCount + ", infantCount=" + this.infantCount + ", passengerData=" + this.passengerData + ")";
        }

        public PassengerInfoRequestParameters(int i5, int i6, int i7, List<PassengerDataRequestParameters> passengerData) {
            Intrinsics.checkNotNullParameter(passengerData, "passengerData");
            this.adultCount = i5;
            this.childCount = i6;
            this.infantCount = i7;
            this.passengerData = passengerData;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\rJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$ProductRequestParameters;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "productType", "Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "quantity", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getProductType", "()Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "getQuantity", "()I", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class ProductRequestParameters {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String id;
        private final ProductTypeResponseDTO productType;
        private final int quantity;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$ProductRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$ProductRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<ProductRequestParameters> serializer() {
                return BookRequestParameters$ProductRequestParameters$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ ProductRequestParameters(int i5, String str, ProductTypeResponseDTO productTypeResponseDTO, int i6, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, BookRequestParameters$ProductRequestParameters$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.productType = productTypeResponseDTO;
            this.quantity = i6;
        }

        public static /* synthetic */ ProductRequestParameters copy$default(ProductRequestParameters productRequestParameters, String str, ProductTypeResponseDTO productTypeResponseDTO, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                str = productRequestParameters.id;
            }
            if ((i6 & 2) != 0) {
                productTypeResponseDTO = productRequestParameters.productType;
            }
            if ((i6 & 4) != 0) {
                i5 = productRequestParameters.quantity;
            }
            return productRequestParameters.copy(str, productTypeResponseDTO, i5);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(ProductRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeSerializableElement(serialDesc, 1, ProductTypeResponseDTO.Serializer.INSTANCE, self.productType);
            output.encodeIntElement(serialDesc, 2, self.quantity);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final ProductTypeResponseDTO getProductType() {
            return this.productType;
        }

        /* renamed from: component3, reason: from getter */
        public final int getQuantity() {
            return this.quantity;
        }

        public final ProductRequestParameters copy(String id, ProductTypeResponseDTO productType, int quantity) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(productType, "productType");
            return new ProductRequestParameters(id, productType, quantity);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ProductRequestParameters)) {
                return false;
            }
            ProductRequestParameters productRequestParameters = (ProductRequestParameters) other;
            return Intrinsics.areEqual(this.id, productRequestParameters.id) && this.productType == productRequestParameters.productType && this.quantity == productRequestParameters.quantity;
        }

        public final String getId() {
            return this.id;
        }

        public final ProductTypeResponseDTO getProductType() {
            return this.productType;
        }

        public final int getQuantity() {
            return this.quantity;
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + this.productType.hashCode()) * 31) + Integer.hashCode(this.quantity);
        }

        public String toString() {
            return "ProductRequestParameters(id=" + this.id + ", productType=" + this.productType + ", quantity=" + this.quantity + ")";
        }

        public ProductRequestParameters(String id, ProductTypeResponseDTO productType, int i5) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(productType, "productType");
            this.id = id;
            this.productType = productType;
            this.quantity = i5;
        }
    }

    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 S2\u00020\u0001:\u0002RSB\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aB±\u0001\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u0019\u0010\u001fJ\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\bHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010<\u001a\u00020\fHÆ\u0003J\u000f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eHÆ\u0003J\t\u0010>\u001a\u00020\u0010HÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eHÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0018HÆ\u0003J¥\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÆ\u0001J\u0013\u0010F\u001a\u00020\f2\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020\u001cHÖ\u0001J\t\u0010I\u001a\u00020\u0003HÖ\u0001J%\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020PH\u0001¢\u0006\u0002\bQR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010+R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u0010-R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010!R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010!R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010!R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006T"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$TicketRequestParameters;", BuildConfig.FLAVOR, "carId", BuildConfig.FLAVOR, "date", "Lorg/threeten/bp/LocalDate;", "departureId", "direction", "Ldk/molslinjen/api/services/booking/request/DirectionDTO;", "goods", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$GoodsRequestParameters;", "isCheckedIn", BuildConfig.FLAVOR, "notes", BuildConfig.FLAVOR, "passengerInfo", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$PassengerInfoRequestParameters;", "products", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$ProductRequestParameters;", "regionId", "routeId", "ticketTypeId", "transportId", "seatReservation", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$BookSeatReservationRequestParameter;", "<init>", "(Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Ldk/molslinjen/api/services/booking/request/DirectionDTO;Ldk/molslinjen/api/services/booking/request/BookRequestParameters$GoodsRequestParameters;ZLjava/util/List;Ldk/molslinjen/api/services/booking/request/BookRequestParameters$PassengerInfoRequestParameters;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/booking/request/BookRequestParameters$BookSeatReservationRequestParameter;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Ldk/molslinjen/api/services/booking/request/DirectionDTO;Ldk/molslinjen/api/services/booking/request/BookRequestParameters$GoodsRequestParameters;ZLjava/util/List;Ldk/molslinjen/api/services/booking/request/BookRequestParameters$PassengerInfoRequestParameters;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/booking/request/BookRequestParameters$BookSeatReservationRequestParameter;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCarId", "()Ljava/lang/String;", "getDate$annotations", "()V", "getDate", "()Lorg/threeten/bp/LocalDate;", "getDepartureId", "getDirection", "()Ldk/molslinjen/api/services/booking/request/DirectionDTO;", "getGoods", "()Ldk/molslinjen/api/services/booking/request/BookRequestParameters$GoodsRequestParameters;", "()Z", "getNotes", "()Ljava/util/List;", "getPassengerInfo", "()Ldk/molslinjen/api/services/booking/request/BookRequestParameters$PassengerInfoRequestParameters;", "getProducts", "getRegionId", "getRouteId", "getTicketTypeId", "getTransportId", "getSeatReservation", "()Ldk/molslinjen/api/services/booking/request/BookRequestParameters$BookSeatReservationRequestParameter;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class TicketRequestParameters {
        private final String carId;
        private final LocalDate date;
        private final String departureId;
        private final DirectionDTO direction;
        private final GoodsRequestParameters goods;
        private final boolean isCheckedIn;
        private final List<String> notes;
        private final PassengerInfoRequestParameters passengerInfo;
        private final List<ProductRequestParameters> products;
        private final String regionId;
        private final String routeId;
        private final BookSeatReservationRequestParameter seatReservation;
        private final String ticketTypeId;
        private final String transportId;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, new ArrayListSerializer(StringSerializer.INSTANCE), null, new ArrayListSerializer(BookRequestParameters$ProductRequestParameters$$serializer.INSTANCE), null, null, null, null, null};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/request/BookRequestParameters$TicketRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$TicketRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<TicketRequestParameters> serializer() {
                return BookRequestParameters$TicketRequestParameters$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ TicketRequestParameters(int i5, String str, LocalDate localDate, String str2, DirectionDTO directionDTO, GoodsRequestParameters goodsRequestParameters, boolean z5, List list, PassengerInfoRequestParameters passengerInfoRequestParameters, List list2, String str3, String str4, String str5, String str6, BookSeatReservationRequestParameter bookSeatReservationRequestParameter, SerializationConstructorMarker serializationConstructorMarker) {
            if (16383 != (i5 & 16383)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 16383, BookRequestParameters$TicketRequestParameters$$serializer.INSTANCE.getDescriptor());
            }
            this.carId = str;
            this.date = localDate;
            this.departureId = str2;
            this.direction = directionDTO;
            this.goods = goodsRequestParameters;
            this.isCheckedIn = z5;
            this.notes = list;
            this.passengerInfo = passengerInfoRequestParameters;
            this.products = list2;
            this.regionId = str3;
            this.routeId = str4;
            this.ticketTypeId = str5;
            this.transportId = str6;
            this.seatReservation = bookSeatReservationRequestParameter;
        }

        @Serializable(with = LocalDateWithTimeSerializer.class)
        public static /* synthetic */ void getDate$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(TicketRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.carId);
            output.encodeSerializableElement(serialDesc, 1, LocalDateWithTimeSerializer.INSTANCE, self.date);
            output.encodeStringElement(serialDesc, 2, self.departureId);
            output.encodeSerializableElement(serialDesc, 3, DirectionDTO.Serializer.INSTANCE, self.direction);
            output.encodeNullableSerializableElement(serialDesc, 4, BookRequestParameters$GoodsRequestParameters$$serializer.INSTANCE, self.goods);
            output.encodeBooleanElement(serialDesc, 5, self.isCheckedIn);
            output.encodeSerializableElement(serialDesc, 6, kSerializerArr[6], self.notes);
            output.encodeSerializableElement(serialDesc, 7, BookRequestParameters$PassengerInfoRequestParameters$$serializer.INSTANCE, self.passengerInfo);
            output.encodeSerializableElement(serialDesc, 8, kSerializerArr[8], self.products);
            output.encodeStringElement(serialDesc, 9, self.regionId);
            output.encodeStringElement(serialDesc, 10, self.routeId);
            output.encodeStringElement(serialDesc, 11, self.ticketTypeId);
            output.encodeStringElement(serialDesc, 12, self.transportId);
            output.encodeNullableSerializableElement(serialDesc, 13, BookRequestParameters$BookSeatReservationRequestParameter$$serializer.INSTANCE, self.seatReservation);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCarId() {
            return this.carId;
        }

        /* renamed from: component10, reason: from getter */
        public final String getRegionId() {
            return this.regionId;
        }

        /* renamed from: component11, reason: from getter */
        public final String getRouteId() {
            return this.routeId;
        }

        /* renamed from: component12, reason: from getter */
        public final String getTicketTypeId() {
            return this.ticketTypeId;
        }

        /* renamed from: component13, reason: from getter */
        public final String getTransportId() {
            return this.transportId;
        }

        /* renamed from: component14, reason: from getter */
        public final BookSeatReservationRequestParameter getSeatReservation() {
            return this.seatReservation;
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
        public final DirectionDTO getDirection() {
            return this.direction;
        }

        /* renamed from: component5, reason: from getter */
        public final GoodsRequestParameters getGoods() {
            return this.goods;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsCheckedIn() {
            return this.isCheckedIn;
        }

        public final List<String> component7() {
            return this.notes;
        }

        /* renamed from: component8, reason: from getter */
        public final PassengerInfoRequestParameters getPassengerInfo() {
            return this.passengerInfo;
        }

        public final List<ProductRequestParameters> component9() {
            return this.products;
        }

        public final TicketRequestParameters copy(String carId, LocalDate date, String departureId, DirectionDTO direction, GoodsRequestParameters goods, boolean isCheckedIn, List<String> notes, PassengerInfoRequestParameters passengerInfo, List<ProductRequestParameters> products, String regionId, String routeId, String ticketTypeId, String transportId, BookSeatReservationRequestParameter seatReservation) {
            Intrinsics.checkNotNullParameter(carId, "carId");
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(departureId, "departureId");
            Intrinsics.checkNotNullParameter(direction, "direction");
            Intrinsics.checkNotNullParameter(notes, "notes");
            Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
            Intrinsics.checkNotNullParameter(products, "products");
            Intrinsics.checkNotNullParameter(regionId, "regionId");
            Intrinsics.checkNotNullParameter(routeId, "routeId");
            Intrinsics.checkNotNullParameter(ticketTypeId, "ticketTypeId");
            Intrinsics.checkNotNullParameter(transportId, "transportId");
            return new TicketRequestParameters(carId, date, departureId, direction, goods, isCheckedIn, notes, passengerInfo, products, regionId, routeId, ticketTypeId, transportId, seatReservation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TicketRequestParameters)) {
                return false;
            }
            TicketRequestParameters ticketRequestParameters = (TicketRequestParameters) other;
            return Intrinsics.areEqual(this.carId, ticketRequestParameters.carId) && Intrinsics.areEqual(this.date, ticketRequestParameters.date) && Intrinsics.areEqual(this.departureId, ticketRequestParameters.departureId) && this.direction == ticketRequestParameters.direction && Intrinsics.areEqual(this.goods, ticketRequestParameters.goods) && this.isCheckedIn == ticketRequestParameters.isCheckedIn && Intrinsics.areEqual(this.notes, ticketRequestParameters.notes) && Intrinsics.areEqual(this.passengerInfo, ticketRequestParameters.passengerInfo) && Intrinsics.areEqual(this.products, ticketRequestParameters.products) && Intrinsics.areEqual(this.regionId, ticketRequestParameters.regionId) && Intrinsics.areEqual(this.routeId, ticketRequestParameters.routeId) && Intrinsics.areEqual(this.ticketTypeId, ticketRequestParameters.ticketTypeId) && Intrinsics.areEqual(this.transportId, ticketRequestParameters.transportId) && Intrinsics.areEqual(this.seatReservation, ticketRequestParameters.seatReservation);
        }

        public final String getCarId() {
            return this.carId;
        }

        public final LocalDate getDate() {
            return this.date;
        }

        public final String getDepartureId() {
            return this.departureId;
        }

        public final DirectionDTO getDirection() {
            return this.direction;
        }

        public final GoodsRequestParameters getGoods() {
            return this.goods;
        }

        public final List<String> getNotes() {
            return this.notes;
        }

        public final PassengerInfoRequestParameters getPassengerInfo() {
            return this.passengerInfo;
        }

        public final List<ProductRequestParameters> getProducts() {
            return this.products;
        }

        public final String getRegionId() {
            return this.regionId;
        }

        public final String getRouteId() {
            return this.routeId;
        }

        public final BookSeatReservationRequestParameter getSeatReservation() {
            return this.seatReservation;
        }

        public final String getTicketTypeId() {
            return this.ticketTypeId;
        }

        public final String getTransportId() {
            return this.transportId;
        }

        public int hashCode() {
            int hashCode = ((((((this.carId.hashCode() * 31) + this.date.hashCode()) * 31) + this.departureId.hashCode()) * 31) + this.direction.hashCode()) * 31;
            GoodsRequestParameters goodsRequestParameters = this.goods;
            int hashCode2 = (((((((((((((((((hashCode + (goodsRequestParameters == null ? 0 : goodsRequestParameters.hashCode())) * 31) + Boolean.hashCode(this.isCheckedIn)) * 31) + this.notes.hashCode()) * 31) + this.passengerInfo.hashCode()) * 31) + this.products.hashCode()) * 31) + this.regionId.hashCode()) * 31) + this.routeId.hashCode()) * 31) + this.ticketTypeId.hashCode()) * 31) + this.transportId.hashCode()) * 31;
            BookSeatReservationRequestParameter bookSeatReservationRequestParameter = this.seatReservation;
            return hashCode2 + (bookSeatReservationRequestParameter != null ? bookSeatReservationRequestParameter.hashCode() : 0);
        }

        public final boolean isCheckedIn() {
            return this.isCheckedIn;
        }

        public String toString() {
            return "TicketRequestParameters(carId=" + this.carId + ", date=" + this.date + ", departureId=" + this.departureId + ", direction=" + this.direction + ", goods=" + this.goods + ", isCheckedIn=" + this.isCheckedIn + ", notes=" + this.notes + ", passengerInfo=" + this.passengerInfo + ", products=" + this.products + ", regionId=" + this.regionId + ", routeId=" + this.routeId + ", ticketTypeId=" + this.ticketTypeId + ", transportId=" + this.transportId + ", seatReservation=" + this.seatReservation + ")";
        }

        public TicketRequestParameters(String carId, LocalDate date, String departureId, DirectionDTO direction, GoodsRequestParameters goodsRequestParameters, boolean z5, List<String> notes, PassengerInfoRequestParameters passengerInfo, List<ProductRequestParameters> products, String regionId, String routeId, String ticketTypeId, String transportId, BookSeatReservationRequestParameter bookSeatReservationRequestParameter) {
            Intrinsics.checkNotNullParameter(carId, "carId");
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(departureId, "departureId");
            Intrinsics.checkNotNullParameter(direction, "direction");
            Intrinsics.checkNotNullParameter(notes, "notes");
            Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
            Intrinsics.checkNotNullParameter(products, "products");
            Intrinsics.checkNotNullParameter(regionId, "regionId");
            Intrinsics.checkNotNullParameter(routeId, "routeId");
            Intrinsics.checkNotNullParameter(ticketTypeId, "ticketTypeId");
            Intrinsics.checkNotNullParameter(transportId, "transportId");
            this.carId = carId;
            this.date = date;
            this.departureId = departureId;
            this.direction = direction;
            this.goods = goodsRequestParameters;
            this.isCheckedIn = z5;
            this.notes = notes;
            this.passengerInfo = passengerInfo;
            this.products = products;
            this.regionId = regionId;
            this.routeId = routeId;
            this.ticketTypeId = ticketTypeId;
            this.transportId = transportId;
            this.seatReservation = bookSeatReservationRequestParameter;
        }
    }

    public /* synthetic */ BookRequestParameters(int i5, BookingRequestParameters bookingRequestParameters, PaymentTypeRequestParameters paymentTypeRequestParameters, boolean z5, boolean z6, ApiAppPaymentRedirectDetailsDTO apiAppPaymentRedirectDetailsDTO, PaymentDataRequestParameters paymentDataRequestParameters, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (127 != (i5 & 127)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 127, BookRequestParameters$$serializer.INSTANCE.getDescriptor());
        }
        this.booking = bookingRequestParameters;
        this.paymentType = paymentTypeRequestParameters;
        this.subscribeToNewsletter = z5;
        this.subscribeToPromotions = z6;
        this.paymentRedirectDetails = apiAppPaymentRedirectDetailsDTO;
        this.paymentData = paymentDataRequestParameters;
        this.version = str;
    }

    public static /* synthetic */ BookRequestParameters copy$default(BookRequestParameters bookRequestParameters, BookingRequestParameters bookingRequestParameters, PaymentTypeRequestParameters paymentTypeRequestParameters, boolean z5, boolean z6, ApiAppPaymentRedirectDetailsDTO apiAppPaymentRedirectDetailsDTO, PaymentDataRequestParameters paymentDataRequestParameters, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            bookingRequestParameters = bookRequestParameters.booking;
        }
        if ((i5 & 2) != 0) {
            paymentTypeRequestParameters = bookRequestParameters.paymentType;
        }
        PaymentTypeRequestParameters paymentTypeRequestParameters2 = paymentTypeRequestParameters;
        if ((i5 & 4) != 0) {
            z5 = bookRequestParameters.subscribeToNewsletter;
        }
        boolean z7 = z5;
        if ((i5 & 8) != 0) {
            z6 = bookRequestParameters.subscribeToPromotions;
        }
        boolean z8 = z6;
        if ((i5 & 16) != 0) {
            apiAppPaymentRedirectDetailsDTO = bookRequestParameters.paymentRedirectDetails;
        }
        ApiAppPaymentRedirectDetailsDTO apiAppPaymentRedirectDetailsDTO2 = apiAppPaymentRedirectDetailsDTO;
        if ((i5 & 32) != 0) {
            paymentDataRequestParameters = bookRequestParameters.paymentData;
        }
        PaymentDataRequestParameters paymentDataRequestParameters2 = paymentDataRequestParameters;
        if ((i5 & 64) != 0) {
            str = bookRequestParameters.version;
        }
        return bookRequestParameters.copy(bookingRequestParameters, paymentTypeRequestParameters2, z7, z8, apiAppPaymentRedirectDetailsDTO2, paymentDataRequestParameters2, str);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(BookRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, BookRequestParameters$BookingRequestParameters$$serializer.INSTANCE, self.booking);
        output.encodeSerializableElement(serialDesc, 1, PaymentTypeRequestParameters.Serializer.INSTANCE, self.paymentType);
        output.encodeBooleanElement(serialDesc, 2, self.subscribeToNewsletter);
        output.encodeBooleanElement(serialDesc, 3, self.subscribeToPromotions);
        output.encodeSerializableElement(serialDesc, 4, ApiAppPaymentRedirectDetailsDTO$$serializer.INSTANCE, self.paymentRedirectDetails);
        output.encodeSerializableElement(serialDesc, 5, PaymentDataRequestParameters$$serializer.INSTANCE, self.paymentData);
        output.encodeStringElement(serialDesc, 6, self.version);
    }

    /* renamed from: component1, reason: from getter */
    public final BookingRequestParameters getBooking() {
        return this.booking;
    }

    /* renamed from: component2, reason: from getter */
    public final PaymentTypeRequestParameters getPaymentType() {
        return this.paymentType;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSubscribeToNewsletter() {
        return this.subscribeToNewsletter;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getSubscribeToPromotions() {
        return this.subscribeToPromotions;
    }

    /* renamed from: component5, reason: from getter */
    public final ApiAppPaymentRedirectDetailsDTO getPaymentRedirectDetails() {
        return this.paymentRedirectDetails;
    }

    /* renamed from: component6, reason: from getter */
    public final PaymentDataRequestParameters getPaymentData() {
        return this.paymentData;
    }

    /* renamed from: component7, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final BookRequestParameters copy(BookingRequestParameters booking, PaymentTypeRequestParameters paymentType, boolean subscribeToNewsletter, boolean subscribeToPromotions, ApiAppPaymentRedirectDetailsDTO paymentRedirectDetails, PaymentDataRequestParameters paymentData, String version) {
        Intrinsics.checkNotNullParameter(booking, "booking");
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        Intrinsics.checkNotNullParameter(paymentRedirectDetails, "paymentRedirectDetails");
        Intrinsics.checkNotNullParameter(paymentData, "paymentData");
        Intrinsics.checkNotNullParameter(version, "version");
        return new BookRequestParameters(booking, paymentType, subscribeToNewsletter, subscribeToPromotions, paymentRedirectDetails, paymentData, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BookRequestParameters)) {
            return false;
        }
        BookRequestParameters bookRequestParameters = (BookRequestParameters) other;
        return Intrinsics.areEqual(this.booking, bookRequestParameters.booking) && this.paymentType == bookRequestParameters.paymentType && this.subscribeToNewsletter == bookRequestParameters.subscribeToNewsletter && this.subscribeToPromotions == bookRequestParameters.subscribeToPromotions && Intrinsics.areEqual(this.paymentRedirectDetails, bookRequestParameters.paymentRedirectDetails) && Intrinsics.areEqual(this.paymentData, bookRequestParameters.paymentData) && Intrinsics.areEqual(this.version, bookRequestParameters.version);
    }

    public final BookingRequestParameters getBooking() {
        return this.booking;
    }

    public final PaymentDataRequestParameters getPaymentData() {
        return this.paymentData;
    }

    public final ApiAppPaymentRedirectDetailsDTO getPaymentRedirectDetails() {
        return this.paymentRedirectDetails;
    }

    public final PaymentTypeRequestParameters getPaymentType() {
        return this.paymentType;
    }

    public final boolean getSubscribeToNewsletter() {
        return this.subscribeToNewsletter;
    }

    public final boolean getSubscribeToPromotions() {
        return this.subscribeToPromotions;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((this.booking.hashCode() * 31) + this.paymentType.hashCode()) * 31) + Boolean.hashCode(this.subscribeToNewsletter)) * 31) + Boolean.hashCode(this.subscribeToPromotions)) * 31) + this.paymentRedirectDetails.hashCode()) * 31) + this.paymentData.hashCode()) * 31) + this.version.hashCode();
    }

    public String toString() {
        return "BookRequestParameters(booking=" + this.booking + ", paymentType=" + this.paymentType + ", subscribeToNewsletter=" + this.subscribeToNewsletter + ", subscribeToPromotions=" + this.subscribeToPromotions + ", paymentRedirectDetails=" + this.paymentRedirectDetails + ", paymentData=" + this.paymentData + ", version=" + this.version + ")";
    }

    public BookRequestParameters(BookingRequestParameters booking, PaymentTypeRequestParameters paymentType, boolean z5, boolean z6, ApiAppPaymentRedirectDetailsDTO paymentRedirectDetails, PaymentDataRequestParameters paymentData, String version) {
        Intrinsics.checkNotNullParameter(booking, "booking");
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        Intrinsics.checkNotNullParameter(paymentRedirectDetails, "paymentRedirectDetails");
        Intrinsics.checkNotNullParameter(paymentData, "paymentData");
        Intrinsics.checkNotNullParameter(version, "version");
        this.booking = booking;
        this.paymentType = paymentType;
        this.subscribeToNewsletter = z5;
        this.subscribeToPromotions = z6;
        this.paymentRedirectDetails = paymentRedirectDetails;
        this.paymentData = paymentData;
        this.version = version;
    }
}
