package dk.molslinjen.api.services.booking.request;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.helpers.serializers.LocalTimeSerializer;
import dk.molslinjen.api.services.booking.response.ProductTypeResponseDTO;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087\b\u0018\u0000 \\2\u00020\u0001:\u0007VWXYZ[\\B\u008f\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bB«\u0001\b\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001a\u0010 J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010@\u001a\u00020\rHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0017HÆ\u0003J\t\u0010H\u001a\u00020\u0019HÆ\u0003J©\u0001\u0010I\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019HÆ\u0001J\u0013\u0010J\u001a\u00020\u00192\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020\u001dHÖ\u0001J\t\u0010M\u001a\u00020\u0003HÖ\u0001J%\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0001¢\u0006\u0002\bUR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010$\u001a\u0004\b4\u0010\"R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\"R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:¨\u0006]"}, d2 = {"Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters;", BuildConfig.FLAVOR, "commuteAgreementId", BuildConfig.FLAVOR, "date", "Lorg/threeten/bp/LocalDate;", "goods", "Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$GoodsRequestParameters;", "multiRide", "Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$MultiRideRequestParameters;", "outboundTrip", "Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$OutboundTripRequestParameters;", "passengerInfo", "Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$DeparturePassengerInfoRequestParameters;", "phone", "products", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$ProductRequestParameters;", "regionId", "reservationNumber", "routeId", "transportId", "currency", "Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "includeEnRouteDepartures", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$GoodsRequestParameters;Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$MultiRideRequestParameters;Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$OutboundTripRequestParameters;Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$DeparturePassengerInfoRequestParameters;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;Z)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lorg/threeten/bp/LocalDate;Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$GoodsRequestParameters;Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$MultiRideRequestParameters;Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$OutboundTripRequestParameters;Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$DeparturePassengerInfoRequestParameters;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCommuteAgreementId", "()Ljava/lang/String;", "getDate$annotations", "()V", "getDate", "()Lorg/threeten/bp/LocalDate;", "getGoods", "()Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$GoodsRequestParameters;", "getMultiRide", "()Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$MultiRideRequestParameters;", "getOutboundTrip", "()Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$OutboundTripRequestParameters;", "getPassengerInfo", "()Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$DeparturePassengerInfoRequestParameters;", "getPhone", "getProducts", "()Ljava/util/List;", "getRegionId", "getReservationNumber$annotations", "getReservationNumber", "getRouteId", "getTransportId", "getCurrency", "()Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "getIncludeEnRouteDepartures", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "GoodsRequestParameters", "MultiRideRequestParameters", "OutboundTripRequestParameters", "DeparturePassengerInfoRequestParameters", "ProductRequestParameters", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class DepartureRequestParameters {
    private final String commuteAgreementId;
    private final CurrencyTypeDTO currency;
    private final LocalDate date;
    private final GoodsRequestParameters goods;
    private final boolean includeEnRouteDepartures;
    private final MultiRideRequestParameters multiRide;
    private final OutboundTripRequestParameters outboundTrip;
    private final DeparturePassengerInfoRequestParameters passengerInfo;
    private final String phone;
    private final List<ProductRequestParameters> products;
    private final String regionId;
    private final String reservationNumber;
    private final String routeId;
    private final String transportId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, new ArrayListSerializer(DepartureRequestParameters$ProductRequestParameters$$serializer.INSTANCE), null, null, null, null, null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<DepartureRequestParameters> serializer() {
            return DepartureRequestParameters$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B3\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006$"}, d2 = {"Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$DeparturePassengerInfoRequestParameters;", BuildConfig.FLAVOR, "adultCount", BuildConfig.FLAVOR, "childCount", "infantCount", "<init>", "(III)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAdultCount", "()I", "getChildCount", "getInfantCount", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class DeparturePassengerInfoRequestParameters {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int adultCount;
        private final int childCount;
        private final int infantCount;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$DeparturePassengerInfoRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$DeparturePassengerInfoRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<DeparturePassengerInfoRequestParameters> serializer() {
                return DepartureRequestParameters$DeparturePassengerInfoRequestParameters$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ DeparturePassengerInfoRequestParameters(int i5, int i6, int i7, int i8, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, DepartureRequestParameters$DeparturePassengerInfoRequestParameters$$serializer.INSTANCE.getDescriptor());
            }
            this.adultCount = i6;
            this.childCount = i7;
            this.infantCount = i8;
        }

        public static /* synthetic */ DeparturePassengerInfoRequestParameters copy$default(DeparturePassengerInfoRequestParameters departurePassengerInfoRequestParameters, int i5, int i6, int i7, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                i5 = departurePassengerInfoRequestParameters.adultCount;
            }
            if ((i8 & 2) != 0) {
                i6 = departurePassengerInfoRequestParameters.childCount;
            }
            if ((i8 & 4) != 0) {
                i7 = departurePassengerInfoRequestParameters.infantCount;
            }
            return departurePassengerInfoRequestParameters.copy(i5, i6, i7);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(DeparturePassengerInfoRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeIntElement(serialDesc, 0, self.adultCount);
            output.encodeIntElement(serialDesc, 1, self.childCount);
            output.encodeIntElement(serialDesc, 2, self.infantCount);
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

        public final DeparturePassengerInfoRequestParameters copy(int adultCount, int childCount, int infantCount) {
            return new DeparturePassengerInfoRequestParameters(adultCount, childCount, infantCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DeparturePassengerInfoRequestParameters)) {
                return false;
            }
            DeparturePassengerInfoRequestParameters departurePassengerInfoRequestParameters = (DeparturePassengerInfoRequestParameters) other;
            return this.adultCount == departurePassengerInfoRequestParameters.adultCount && this.childCount == departurePassengerInfoRequestParameters.childCount && this.infantCount == departurePassengerInfoRequestParameters.infantCount;
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

        public int hashCode() {
            return (((Integer.hashCode(this.adultCount) * 31) + Integer.hashCode(this.childCount)) * 31) + Integer.hashCode(this.infantCount);
        }

        public String toString() {
            return "DeparturePassengerInfoRequestParameters(adultCount=" + this.adultCount + ", childCount=" + this.childCount + ", infantCount=" + this.infantCount + ")";
        }

        public DeparturePassengerInfoRequestParameters(int i5, int i6, int i7) {
            this.adultCount = i5;
            this.childCount = i6;
            this.infantCount = i7;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J.\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006("}, d2 = {"Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$GoodsRequestParameters;", BuildConfig.FLAVOR, "hasDangerousGoods", BuildConfig.FLAVOR, "hasLimitedQuantity", "weight", BuildConfig.FLAVOR, "<init>", "(ZZLjava/lang/Double;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZZLjava/lang/Double;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getHasDangerousGoods", "()Z", "getHasLimitedQuantity", "getWeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "copy", "(ZZLjava/lang/Double;)Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$GoodsRequestParameters;", "equals", "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class GoodsRequestParameters {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean hasDangerousGoods;
        private final boolean hasLimitedQuantity;
        private final Double weight;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$GoodsRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$GoodsRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<GoodsRequestParameters> serializer() {
                return DepartureRequestParameters$GoodsRequestParameters$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ GoodsRequestParameters(int i5, boolean z5, boolean z6, Double d5, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, DepartureRequestParameters$GoodsRequestParameters$$serializer.INSTANCE.getDescriptor());
            }
            this.hasDangerousGoods = z5;
            this.hasLimitedQuantity = z6;
            this.weight = d5;
        }

        public static /* synthetic */ GoodsRequestParameters copy$default(GoodsRequestParameters goodsRequestParameters, boolean z5, boolean z6, Double d5, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = goodsRequestParameters.hasDangerousGoods;
            }
            if ((i5 & 2) != 0) {
                z6 = goodsRequestParameters.hasLimitedQuantity;
            }
            if ((i5 & 4) != 0) {
                d5 = goodsRequestParameters.weight;
            }
            return goodsRequestParameters.copy(z5, z6, d5);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(GoodsRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeBooleanElement(serialDesc, 0, self.hasDangerousGoods);
            output.encodeBooleanElement(serialDesc, 1, self.hasLimitedQuantity);
            output.encodeNullableSerializableElement(serialDesc, 2, DoubleSerializer.INSTANCE, self.weight);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getHasDangerousGoods() {
            return this.hasDangerousGoods;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getHasLimitedQuantity() {
            return this.hasLimitedQuantity;
        }

        /* renamed from: component3, reason: from getter */
        public final Double getWeight() {
            return this.weight;
        }

        public final GoodsRequestParameters copy(boolean hasDangerousGoods, boolean hasLimitedQuantity, Double weight) {
            return new GoodsRequestParameters(hasDangerousGoods, hasLimitedQuantity, weight);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GoodsRequestParameters)) {
                return false;
            }
            GoodsRequestParameters goodsRequestParameters = (GoodsRequestParameters) other;
            return this.hasDangerousGoods == goodsRequestParameters.hasDangerousGoods && this.hasLimitedQuantity == goodsRequestParameters.hasLimitedQuantity && Intrinsics.areEqual(this.weight, goodsRequestParameters.weight);
        }

        public final boolean getHasDangerousGoods() {
            return this.hasDangerousGoods;
        }

        public final boolean getHasLimitedQuantity() {
            return this.hasLimitedQuantity;
        }

        public final Double getWeight() {
            return this.weight;
        }

        public int hashCode() {
            int hashCode = ((Boolean.hashCode(this.hasDangerousGoods) * 31) + Boolean.hashCode(this.hasLimitedQuantity)) * 31;
            Double d5 = this.weight;
            return hashCode + (d5 == null ? 0 : d5.hashCode());
        }

        public String toString() {
            return "GoodsRequestParameters(hasDangerousGoods=" + this.hasDangerousGoods + ", hasLimitedQuantity=" + this.hasLimitedQuantity + ", weight=" + this.weight + ")";
        }

        public GoodsRequestParameters(boolean z5, boolean z6, Double d5) {
            this.hasDangerousGoods = z5;
            this.hasLimitedQuantity = z6;
            this.weight = d5;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$MultiRideRequestParameters;", BuildConfig.FLAVOR, "cardType", BuildConfig.FLAVOR, "customerId", Constants.ID_ATTRIBUTE_KEY, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCardType", "()Ljava/lang/String;", "getCustomerId", "getId", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class MultiRideRequestParameters {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String cardType;
        private final String customerId;
        private final String id;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$MultiRideRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$MultiRideRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<MultiRideRequestParameters> serializer() {
                return DepartureRequestParameters$MultiRideRequestParameters$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ MultiRideRequestParameters(int i5, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, DepartureRequestParameters$MultiRideRequestParameters$$serializer.INSTANCE.getDescriptor());
            }
            this.cardType = str;
            this.customerId = str2;
            this.id = str3;
        }

        public static /* synthetic */ MultiRideRequestParameters copy$default(MultiRideRequestParameters multiRideRequestParameters, String str, String str2, String str3, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = multiRideRequestParameters.cardType;
            }
            if ((i5 & 2) != 0) {
                str2 = multiRideRequestParameters.customerId;
            }
            if ((i5 & 4) != 0) {
                str3 = multiRideRequestParameters.id;
            }
            return multiRideRequestParameters.copy(str, str2, str3);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(MultiRideRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.cardType);
            output.encodeStringElement(serialDesc, 1, self.customerId);
            output.encodeStringElement(serialDesc, 2, self.id);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCardType() {
            return this.cardType;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCustomerId() {
            return this.customerId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final MultiRideRequestParameters copy(String cardType, String customerId, String id) {
            Intrinsics.checkNotNullParameter(cardType, "cardType");
            Intrinsics.checkNotNullParameter(customerId, "customerId");
            Intrinsics.checkNotNullParameter(id, "id");
            return new MultiRideRequestParameters(cardType, customerId, id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MultiRideRequestParameters)) {
                return false;
            }
            MultiRideRequestParameters multiRideRequestParameters = (MultiRideRequestParameters) other;
            return Intrinsics.areEqual(this.cardType, multiRideRequestParameters.cardType) && Intrinsics.areEqual(this.customerId, multiRideRequestParameters.customerId) && Intrinsics.areEqual(this.id, multiRideRequestParameters.id);
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
            return (((this.cardType.hashCode() * 31) + this.customerId.hashCode()) * 31) + this.id.hashCode();
        }

        public String toString() {
            return "MultiRideRequestParameters(cardType=" + this.cardType + ", customerId=" + this.customerId + ", id=" + this.id + ")";
        }

        public MultiRideRequestParameters(String cardType, String customerId, String id) {
            Intrinsics.checkNotNullParameter(cardType, "cardType");
            Intrinsics.checkNotNullParameter(customerId, "customerId");
            Intrinsics.checkNotNullParameter(id, "id");
            this.cardType = cardType;
            this.customerId = customerId;
            this.id = id;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fBM\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J;\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u000eHÖ\u0001J\t\u0010(\u001a\u00020\tHÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001c¨\u00063"}, d2 = {"Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$OutboundTripRequestParameters;", BuildConfig.FLAVOR, "date", "Lorg/threeten/bp/LocalDate;", "departureTime", "Lorg/threeten/bp/LocalTime;", "passengerInfo", "Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$DeparturePassengerInfoRequestParameters;", "regionId", BuildConfig.FLAVOR, "transportId", "<init>", "(Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalTime;Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$DeparturePassengerInfoRequestParameters;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalTime;Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$DeparturePassengerInfoRequestParameters;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDate$annotations", "()V", "getDate", "()Lorg/threeten/bp/LocalDate;", "getDepartureTime$annotations", "getDepartureTime", "()Lorg/threeten/bp/LocalTime;", "getPassengerInfo", "()Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$DeparturePassengerInfoRequestParameters;", "getRegionId", "()Ljava/lang/String;", "getTransportId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class OutboundTripRequestParameters {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final LocalDate date;
        private final LocalTime departureTime;
        private final DeparturePassengerInfoRequestParameters passengerInfo;
        private final String regionId;
        private final String transportId;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$OutboundTripRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$OutboundTripRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<OutboundTripRequestParameters> serializer() {
                return DepartureRequestParameters$OutboundTripRequestParameters$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ OutboundTripRequestParameters(int i5, LocalDate localDate, LocalTime localTime, DeparturePassengerInfoRequestParameters departurePassengerInfoRequestParameters, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (31 != (i5 & 31)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 31, DepartureRequestParameters$OutboundTripRequestParameters$$serializer.INSTANCE.getDescriptor());
            }
            this.date = localDate;
            this.departureTime = localTime;
            this.passengerInfo = departurePassengerInfoRequestParameters;
            this.regionId = str;
            this.transportId = str2;
        }

        public static /* synthetic */ OutboundTripRequestParameters copy$default(OutboundTripRequestParameters outboundTripRequestParameters, LocalDate localDate, LocalTime localTime, DeparturePassengerInfoRequestParameters departurePassengerInfoRequestParameters, String str, String str2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                localDate = outboundTripRequestParameters.date;
            }
            if ((i5 & 2) != 0) {
                localTime = outboundTripRequestParameters.departureTime;
            }
            LocalTime localTime2 = localTime;
            if ((i5 & 4) != 0) {
                departurePassengerInfoRequestParameters = outboundTripRequestParameters.passengerInfo;
            }
            DeparturePassengerInfoRequestParameters departurePassengerInfoRequestParameters2 = departurePassengerInfoRequestParameters;
            if ((i5 & 8) != 0) {
                str = outboundTripRequestParameters.regionId;
            }
            String str3 = str;
            if ((i5 & 16) != 0) {
                str2 = outboundTripRequestParameters.transportId;
            }
            return outboundTripRequestParameters.copy(localDate, localTime2, departurePassengerInfoRequestParameters2, str3, str2);
        }

        @Serializable(with = LocalDateWithTimeSerializer.class)
        public static /* synthetic */ void getDate$annotations() {
        }

        @Serializable(with = LocalTimeSerializer.class)
        public static /* synthetic */ void getDepartureTime$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(OutboundTripRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, LocalDateWithTimeSerializer.INSTANCE, self.date);
            output.encodeSerializableElement(serialDesc, 1, LocalTimeSerializer.INSTANCE, self.departureTime);
            output.encodeSerializableElement(serialDesc, 2, DepartureRequestParameters$DeparturePassengerInfoRequestParameters$$serializer.INSTANCE, self.passengerInfo);
            output.encodeStringElement(serialDesc, 3, self.regionId);
            output.encodeStringElement(serialDesc, 4, self.transportId);
        }

        /* renamed from: component1, reason: from getter */
        public final LocalDate getDate() {
            return this.date;
        }

        /* renamed from: component2, reason: from getter */
        public final LocalTime getDepartureTime() {
            return this.departureTime;
        }

        /* renamed from: component3, reason: from getter */
        public final DeparturePassengerInfoRequestParameters getPassengerInfo() {
            return this.passengerInfo;
        }

        /* renamed from: component4, reason: from getter */
        public final String getRegionId() {
            return this.regionId;
        }

        /* renamed from: component5, reason: from getter */
        public final String getTransportId() {
            return this.transportId;
        }

        public final OutboundTripRequestParameters copy(LocalDate date, LocalTime departureTime, DeparturePassengerInfoRequestParameters passengerInfo, String regionId, String transportId) {
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(departureTime, "departureTime");
            Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
            Intrinsics.checkNotNullParameter(regionId, "regionId");
            Intrinsics.checkNotNullParameter(transportId, "transportId");
            return new OutboundTripRequestParameters(date, departureTime, passengerInfo, regionId, transportId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OutboundTripRequestParameters)) {
                return false;
            }
            OutboundTripRequestParameters outboundTripRequestParameters = (OutboundTripRequestParameters) other;
            return Intrinsics.areEqual(this.date, outboundTripRequestParameters.date) && Intrinsics.areEqual(this.departureTime, outboundTripRequestParameters.departureTime) && Intrinsics.areEqual(this.passengerInfo, outboundTripRequestParameters.passengerInfo) && Intrinsics.areEqual(this.regionId, outboundTripRequestParameters.regionId) && Intrinsics.areEqual(this.transportId, outboundTripRequestParameters.transportId);
        }

        public final LocalDate getDate() {
            return this.date;
        }

        public final LocalTime getDepartureTime() {
            return this.departureTime;
        }

        public final DeparturePassengerInfoRequestParameters getPassengerInfo() {
            return this.passengerInfo;
        }

        public final String getRegionId() {
            return this.regionId;
        }

        public final String getTransportId() {
            return this.transportId;
        }

        public int hashCode() {
            return (((((((this.date.hashCode() * 31) + this.departureTime.hashCode()) * 31) + this.passengerInfo.hashCode()) * 31) + this.regionId.hashCode()) * 31) + this.transportId.hashCode();
        }

        public String toString() {
            return "OutboundTripRequestParameters(date=" + this.date + ", departureTime=" + this.departureTime + ", passengerInfo=" + this.passengerInfo + ", regionId=" + this.regionId + ", transportId=" + this.transportId + ")";
        }

        public OutboundTripRequestParameters(LocalDate date, LocalTime departureTime, DeparturePassengerInfoRequestParameters passengerInfo, String regionId, String transportId) {
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(departureTime, "departureTime");
            Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
            Intrinsics.checkNotNullParameter(regionId, "regionId");
            Intrinsics.checkNotNullParameter(transportId, "transportId");
            this.date = date;
            this.departureTime = departureTime;
            this.passengerInfo = passengerInfo;
            this.regionId = regionId;
            this.transportId = transportId;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\rJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$ProductRequestParameters;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "productType", "Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "quantity", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getProductType", "()Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "getQuantity", "()I", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class ProductRequestParameters {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String id;
        private final ProductTypeResponseDTO productType;
        private final int quantity;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$ProductRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters$ProductRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<ProductRequestParameters> serializer() {
                return DepartureRequestParameters$ProductRequestParameters$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ ProductRequestParameters(int i5, String str, ProductTypeResponseDTO productTypeResponseDTO, int i6, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, DepartureRequestParameters$ProductRequestParameters$$serializer.INSTANCE.getDescriptor());
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

    public /* synthetic */ DepartureRequestParameters(int i5, String str, LocalDate localDate, GoodsRequestParameters goodsRequestParameters, MultiRideRequestParameters multiRideRequestParameters, OutboundTripRequestParameters outboundTripRequestParameters, DeparturePassengerInfoRequestParameters departurePassengerInfoRequestParameters, String str2, List list, String str3, String str4, String str5, String str6, CurrencyTypeDTO currencyTypeDTO, boolean z5, SerializationConstructorMarker serializationConstructorMarker) {
        if (8063 != (i5 & 8063)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 8063, DepartureRequestParameters$$serializer.INSTANCE.getDescriptor());
        }
        this.commuteAgreementId = str;
        this.date = localDate;
        this.goods = goodsRequestParameters;
        this.multiRide = multiRideRequestParameters;
        this.outboundTrip = outboundTripRequestParameters;
        this.passengerInfo = departurePassengerInfoRequestParameters;
        this.phone = str2;
        this.products = (i5 & 128) == 0 ? CollectionsKt.emptyList() : list;
        this.regionId = str3;
        this.reservationNumber = str4;
        this.routeId = str5;
        this.transportId = str6;
        this.currency = currencyTypeDTO;
        this.includeEnRouteDepartures = (i5 & 8192) == 0 ? false : z5;
    }

    @Serializable(with = LocalDateWithTimeSerializer.class)
    public static /* synthetic */ void getDate$annotations() {
    }

    public static /* synthetic */ void getReservationNumber$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(DepartureRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.commuteAgreementId);
        output.encodeSerializableElement(serialDesc, 1, LocalDateWithTimeSerializer.INSTANCE, self.date);
        output.encodeNullableSerializableElement(serialDesc, 2, DepartureRequestParameters$GoodsRequestParameters$$serializer.INSTANCE, self.goods);
        output.encodeNullableSerializableElement(serialDesc, 3, DepartureRequestParameters$MultiRideRequestParameters$$serializer.INSTANCE, self.multiRide);
        output.encodeNullableSerializableElement(serialDesc, 4, DepartureRequestParameters$OutboundTripRequestParameters$$serializer.INSTANCE, self.outboundTrip);
        output.encodeSerializableElement(serialDesc, 5, DepartureRequestParameters$DeparturePassengerInfoRequestParameters$$serializer.INSTANCE, self.passengerInfo);
        output.encodeNullableSerializableElement(serialDesc, 6, stringSerializer, self.phone);
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.products, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 7, kSerializerArr[7], self.products);
        }
        output.encodeNullableSerializableElement(serialDesc, 8, stringSerializer, self.regionId);
        output.encodeNullableSerializableElement(serialDesc, 9, stringSerializer, self.reservationNumber);
        output.encodeStringElement(serialDesc, 10, self.routeId);
        output.encodeStringElement(serialDesc, 11, self.transportId);
        output.encodeSerializableElement(serialDesc, 12, CurrencyTypeDTO.Serializer.INSTANCE, self.currency);
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.includeEnRouteDepartures) {
            output.encodeBooleanElement(serialDesc, 13, self.includeEnRouteDepartures);
        }
    }

    /* renamed from: component1, reason: from getter */
    public final String getCommuteAgreementId() {
        return this.commuteAgreementId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getReservationNumber() {
        return this.reservationNumber;
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
    public final CurrencyTypeDTO getCurrency() {
        return this.currency;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getIncludeEnRouteDepartures() {
        return this.includeEnRouteDepartures;
    }

    /* renamed from: component2, reason: from getter */
    public final LocalDate getDate() {
        return this.date;
    }

    /* renamed from: component3, reason: from getter */
    public final GoodsRequestParameters getGoods() {
        return this.goods;
    }

    /* renamed from: component4, reason: from getter */
    public final MultiRideRequestParameters getMultiRide() {
        return this.multiRide;
    }

    /* renamed from: component5, reason: from getter */
    public final OutboundTripRequestParameters getOutboundTrip() {
        return this.outboundTrip;
    }

    /* renamed from: component6, reason: from getter */
    public final DeparturePassengerInfoRequestParameters getPassengerInfo() {
        return this.passengerInfo;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    public final List<ProductRequestParameters> component8() {
        return this.products;
    }

    /* renamed from: component9, reason: from getter */
    public final String getRegionId() {
        return this.regionId;
    }

    public final DepartureRequestParameters copy(String commuteAgreementId, LocalDate date, GoodsRequestParameters goods, MultiRideRequestParameters multiRide, OutboundTripRequestParameters outboundTrip, DeparturePassengerInfoRequestParameters passengerInfo, String phone, List<ProductRequestParameters> products, String regionId, String reservationNumber, String routeId, String transportId, CurrencyTypeDTO currency, boolean includeEnRouteDepartures) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        Intrinsics.checkNotNullParameter(transportId, "transportId");
        Intrinsics.checkNotNullParameter(currency, "currency");
        return new DepartureRequestParameters(commuteAgreementId, date, goods, multiRide, outboundTrip, passengerInfo, phone, products, regionId, reservationNumber, routeId, transportId, currency, includeEnRouteDepartures);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DepartureRequestParameters)) {
            return false;
        }
        DepartureRequestParameters departureRequestParameters = (DepartureRequestParameters) other;
        return Intrinsics.areEqual(this.commuteAgreementId, departureRequestParameters.commuteAgreementId) && Intrinsics.areEqual(this.date, departureRequestParameters.date) && Intrinsics.areEqual(this.goods, departureRequestParameters.goods) && Intrinsics.areEqual(this.multiRide, departureRequestParameters.multiRide) && Intrinsics.areEqual(this.outboundTrip, departureRequestParameters.outboundTrip) && Intrinsics.areEqual(this.passengerInfo, departureRequestParameters.passengerInfo) && Intrinsics.areEqual(this.phone, departureRequestParameters.phone) && Intrinsics.areEqual(this.products, departureRequestParameters.products) && Intrinsics.areEqual(this.regionId, departureRequestParameters.regionId) && Intrinsics.areEqual(this.reservationNumber, departureRequestParameters.reservationNumber) && Intrinsics.areEqual(this.routeId, departureRequestParameters.routeId) && Intrinsics.areEqual(this.transportId, departureRequestParameters.transportId) && this.currency == departureRequestParameters.currency && this.includeEnRouteDepartures == departureRequestParameters.includeEnRouteDepartures;
    }

    public final String getCommuteAgreementId() {
        return this.commuteAgreementId;
    }

    public final CurrencyTypeDTO getCurrency() {
        return this.currency;
    }

    public final LocalDate getDate() {
        return this.date;
    }

    public final GoodsRequestParameters getGoods() {
        return this.goods;
    }

    public final boolean getIncludeEnRouteDepartures() {
        return this.includeEnRouteDepartures;
    }

    public final MultiRideRequestParameters getMultiRide() {
        return this.multiRide;
    }

    public final OutboundTripRequestParameters getOutboundTrip() {
        return this.outboundTrip;
    }

    public final DeparturePassengerInfoRequestParameters getPassengerInfo() {
        return this.passengerInfo;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final List<ProductRequestParameters> getProducts() {
        return this.products;
    }

    public final String getRegionId() {
        return this.regionId;
    }

    public final String getReservationNumber() {
        return this.reservationNumber;
    }

    public final String getRouteId() {
        return this.routeId;
    }

    public final String getTransportId() {
        return this.transportId;
    }

    public int hashCode() {
        String str = this.commuteAgreementId;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.date.hashCode()) * 31;
        GoodsRequestParameters goodsRequestParameters = this.goods;
        int hashCode2 = (hashCode + (goodsRequestParameters == null ? 0 : goodsRequestParameters.hashCode())) * 31;
        MultiRideRequestParameters multiRideRequestParameters = this.multiRide;
        int hashCode3 = (hashCode2 + (multiRideRequestParameters == null ? 0 : multiRideRequestParameters.hashCode())) * 31;
        OutboundTripRequestParameters outboundTripRequestParameters = this.outboundTrip;
        int hashCode4 = (((hashCode3 + (outboundTripRequestParameters == null ? 0 : outboundTripRequestParameters.hashCode())) * 31) + this.passengerInfo.hashCode()) * 31;
        String str2 = this.phone;
        int hashCode5 = (((hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.products.hashCode()) * 31;
        String str3 = this.regionId;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.reservationNumber;
        return ((((((((hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.routeId.hashCode()) * 31) + this.transportId.hashCode()) * 31) + this.currency.hashCode()) * 31) + Boolean.hashCode(this.includeEnRouteDepartures);
    }

    public String toString() {
        return "DepartureRequestParameters(commuteAgreementId=" + this.commuteAgreementId + ", date=" + this.date + ", goods=" + this.goods + ", multiRide=" + this.multiRide + ", outboundTrip=" + this.outboundTrip + ", passengerInfo=" + this.passengerInfo + ", phone=" + this.phone + ", products=" + this.products + ", regionId=" + this.regionId + ", reservationNumber=" + this.reservationNumber + ", routeId=" + this.routeId + ", transportId=" + this.transportId + ", currency=" + this.currency + ", includeEnRouteDepartures=" + this.includeEnRouteDepartures + ")";
    }

    public DepartureRequestParameters(String str, LocalDate date, GoodsRequestParameters goodsRequestParameters, MultiRideRequestParameters multiRideRequestParameters, OutboundTripRequestParameters outboundTripRequestParameters, DeparturePassengerInfoRequestParameters passengerInfo, String str2, List<ProductRequestParameters> products, String str3, String str4, String routeId, String transportId, CurrencyTypeDTO currency, boolean z5) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        Intrinsics.checkNotNullParameter(transportId, "transportId");
        Intrinsics.checkNotNullParameter(currency, "currency");
        this.commuteAgreementId = str;
        this.date = date;
        this.goods = goodsRequestParameters;
        this.multiRide = multiRideRequestParameters;
        this.outboundTrip = outboundTripRequestParameters;
        this.passengerInfo = passengerInfo;
        this.phone = str2;
        this.products = products;
        this.regionId = str3;
        this.reservationNumber = str4;
        this.routeId = routeId;
        this.transportId = transportId;
        this.currency = currency;
        this.includeEnRouteDepartures = z5;
    }

    public /* synthetic */ DepartureRequestParameters(String str, LocalDate localDate, GoodsRequestParameters goodsRequestParameters, MultiRideRequestParameters multiRideRequestParameters, OutboundTripRequestParameters outboundTripRequestParameters, DeparturePassengerInfoRequestParameters departurePassengerInfoRequestParameters, String str2, List list, String str3, String str4, String str5, String str6, CurrencyTypeDTO currencyTypeDTO, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, localDate, goodsRequestParameters, multiRideRequestParameters, outboundTripRequestParameters, departurePassengerInfoRequestParameters, str2, (i5 & 128) != 0 ? CollectionsKt.emptyList() : list, str3, str4, str5, str6, currencyTypeDTO, (i5 & 8192) != 0 ? false : z5);
    }
}
