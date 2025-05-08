package dk.molslinjen.api.services.booking.request;

import com.sun.jna.Function;
import dk.molslinjen.api.services.booking.request.DirectionDTO;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
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

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u00029:BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010Bg\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0014J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\fHÆ\u0003J\t\u0010+\u001a\u00020\u000eHÆ\u0003J]\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010-\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\bHÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001J%\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006;"}, d2 = {"Ldk/molslinjen/api/services/booking/request/ProductsRequestParameters;", BuildConfig.FLAVOR, "carId", BuildConfig.FLAVOR, "departureId", "direction", "Ldk/molslinjen/api/services/booking/request/DirectionDTO;", "passengerCount", BuildConfig.FLAVOR, "reservationNumber", "phone", "includeSummaryProducts", BuildConfig.FLAVOR, "currency", "Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/booking/request/DirectionDTO;ILjava/lang/String;Ljava/lang/String;ZLdk/molslinjen/api/shared/response/CurrencyTypeDTO;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/booking/request/DirectionDTO;ILjava/lang/String;Ljava/lang/String;ZLdk/molslinjen/api/shared/response/CurrencyTypeDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCarId", "()Ljava/lang/String;", "getDepartureId", "getDirection", "()Ldk/molslinjen/api/services/booking/request/DirectionDTO;", "getPassengerCount", "()I", "getReservationNumber$annotations", "()V", "getReservationNumber", "getPhone", "getIncludeSummaryProducts", "()Z", "getCurrency", "()Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class ProductsRequestParameters {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String carId;
    private final CurrencyTypeDTO currency;
    private final String departureId;
    private final DirectionDTO direction;
    private final boolean includeSummaryProducts;
    private final int passengerCount;
    private final String phone;
    private final String reservationNumber;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/request/ProductsRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/request/ProductsRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ProductsRequestParameters> serializer() {
            return ProductsRequestParameters$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ ProductsRequestParameters(int i5, String str, String str2, DirectionDTO directionDTO, int i6, String str3, String str4, boolean z5, CurrencyTypeDTO currencyTypeDTO, SerializationConstructorMarker serializationConstructorMarker) {
        if (255 != (i5 & Function.USE_VARARGS)) {
            PluginExceptionsKt.throwMissingFieldException(i5, Function.USE_VARARGS, ProductsRequestParameters$$serializer.INSTANCE.getDescriptor());
        }
        this.carId = str;
        this.departureId = str2;
        this.direction = directionDTO;
        this.passengerCount = i6;
        this.reservationNumber = str3;
        this.phone = str4;
        this.includeSummaryProducts = z5;
        this.currency = currencyTypeDTO;
    }

    public static /* synthetic */ void getReservationNumber$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(ProductsRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.carId);
        output.encodeStringElement(serialDesc, 1, self.departureId);
        output.encodeSerializableElement(serialDesc, 2, DirectionDTO.Serializer.INSTANCE, self.direction);
        output.encodeIntElement(serialDesc, 3, self.passengerCount);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 4, stringSerializer, self.reservationNumber);
        output.encodeNullableSerializableElement(serialDesc, 5, stringSerializer, self.phone);
        output.encodeBooleanElement(serialDesc, 6, self.includeSummaryProducts);
        output.encodeSerializableElement(serialDesc, 7, CurrencyTypeDTO.Serializer.INSTANCE, self.currency);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCarId() {
        return this.carId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDepartureId() {
        return this.departureId;
    }

    /* renamed from: component3, reason: from getter */
    public final DirectionDTO getDirection() {
        return this.direction;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPassengerCount() {
        return this.passengerCount;
    }

    /* renamed from: component5, reason: from getter */
    public final String getReservationNumber() {
        return this.reservationNumber;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIncludeSummaryProducts() {
        return this.includeSummaryProducts;
    }

    /* renamed from: component8, reason: from getter */
    public final CurrencyTypeDTO getCurrency() {
        return this.currency;
    }

    public final ProductsRequestParameters copy(String carId, String departureId, DirectionDTO direction, int passengerCount, String reservationNumber, String phone, boolean includeSummaryProducts, CurrencyTypeDTO currency) {
        Intrinsics.checkNotNullParameter(carId, "carId");
        Intrinsics.checkNotNullParameter(departureId, "departureId");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(currency, "currency");
        return new ProductsRequestParameters(carId, departureId, direction, passengerCount, reservationNumber, phone, includeSummaryProducts, currency);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProductsRequestParameters)) {
            return false;
        }
        ProductsRequestParameters productsRequestParameters = (ProductsRequestParameters) other;
        return Intrinsics.areEqual(this.carId, productsRequestParameters.carId) && Intrinsics.areEqual(this.departureId, productsRequestParameters.departureId) && this.direction == productsRequestParameters.direction && this.passengerCount == productsRequestParameters.passengerCount && Intrinsics.areEqual(this.reservationNumber, productsRequestParameters.reservationNumber) && Intrinsics.areEqual(this.phone, productsRequestParameters.phone) && this.includeSummaryProducts == productsRequestParameters.includeSummaryProducts && this.currency == productsRequestParameters.currency;
    }

    public final String getCarId() {
        return this.carId;
    }

    public final CurrencyTypeDTO getCurrency() {
        return this.currency;
    }

    public final String getDepartureId() {
        return this.departureId;
    }

    public final DirectionDTO getDirection() {
        return this.direction;
    }

    public final boolean getIncludeSummaryProducts() {
        return this.includeSummaryProducts;
    }

    public final int getPassengerCount() {
        return this.passengerCount;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getReservationNumber() {
        return this.reservationNumber;
    }

    public int hashCode() {
        int hashCode = ((((((this.carId.hashCode() * 31) + this.departureId.hashCode()) * 31) + this.direction.hashCode()) * 31) + Integer.hashCode(this.passengerCount)) * 31;
        String str = this.reservationNumber;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.phone;
        return ((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Boolean.hashCode(this.includeSummaryProducts)) * 31) + this.currency.hashCode();
    }

    public String toString() {
        return "ProductsRequestParameters(carId=" + this.carId + ", departureId=" + this.departureId + ", direction=" + this.direction + ", passengerCount=" + this.passengerCount + ", reservationNumber=" + this.reservationNumber + ", phone=" + this.phone + ", includeSummaryProducts=" + this.includeSummaryProducts + ", currency=" + this.currency + ")";
    }

    public ProductsRequestParameters(String carId, String departureId, DirectionDTO direction, int i5, String str, String str2, boolean z5, CurrencyTypeDTO currency) {
        Intrinsics.checkNotNullParameter(carId, "carId");
        Intrinsics.checkNotNullParameter(departureId, "departureId");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(currency, "currency");
        this.carId = carId;
        this.departureId = departureId;
        this.direction = direction;
        this.passengerCount = i5;
        this.reservationNumber = str;
        this.phone = str2;
        this.includeSummaryProducts = z5;
        this.currency = currency;
    }
}
