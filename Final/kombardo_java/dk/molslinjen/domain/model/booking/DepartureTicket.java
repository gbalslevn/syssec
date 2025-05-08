package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.response.DeparturesResponseDTO;
import dk.molslinjen.api.shared.response.TicketSurchargeDTO;
import dk.molslinjen.domain.model.booking.Fee;
import dk.molslinjen.domain.model.booking.ProductPrice;
import dk.molslinjen.domain.model.booking.TicketCategory;
import dk.molslinjen.domain.model.booking.TicketSurcharge;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 :2\u00020\u0001:\u0001:B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e¢\u0006\u0004\b\u0014\u0010\u0015B!\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u001aJ\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\t\u00100\u001a\u00020\fHÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\t\u00102\u001a\u00020\u0011HÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eHÆ\u0003Jq\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eHÆ\u0001J\u0013\u00105\u001a\u00020\u00112\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'¨\u0006;"}, d2 = {"Ldk/molslinjen/domain/model/booking/DepartureTicket;", BuildConfig.FLAVOR, "carId", BuildConfig.FLAVOR, "category", "Ldk/molslinjen/domain/model/booking/TicketCategory;", "changeFee", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "fees", "Ldk/molslinjen/domain/model/booking/Fee;", "goodsFee", "price", "Ldk/molslinjen/domain/model/shared/Price;", "productPrices", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/ProductPrice;", "soldOut", BuildConfig.FLAVOR, "surcharges", "Ldk/molslinjen/domain/model/booking/TicketSurcharge;", "<init>", "(Ljava/lang/String;Ldk/molslinjen/domain/model/booking/TicketCategory;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ldk/molslinjen/domain/model/booking/Fee;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ldk/molslinjen/domain/model/shared/Price;Ljava/util/List;ZLjava/util/List;)V", "dto", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$TicketResponseDTO;", "isMultiRide", "isEdit", "(Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$TicketResponseDTO;ZZ)V", "getCarId", "()Ljava/lang/String;", "getCategory", "()Ldk/molslinjen/domain/model/booking/TicketCategory;", "getChangeFee", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getFees", "()Ldk/molslinjen/domain/model/booking/Fee;", "getGoodsFee", "getPrice", "()Ldk/molslinjen/domain/model/shared/Price;", "getProductPrices", "()Ljava/util/List;", "getSoldOut", "()Z", "getSurcharges", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DepartureTicket {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DepartureTicket mockBlueClass;
    private static final DepartureTicket mockLowPrice;
    private static final DepartureTicket mockStandard;
    private final String carId;
    private final TicketCategory category;
    private final PriceWithCurrency changeFee;
    private final Fee fees;
    private final PriceWithCurrency goodsFee;
    private final Price price;
    private final List<ProductPrice> productPrices;
    private final boolean soldOut;
    private final List<TicketSurcharge> surcharges;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/booking/DepartureTicket$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mockLowPrice", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "getMockLowPrice", "()Ldk/molslinjen/domain/model/booking/DepartureTicket;", "mockStandard", "getMockStandard", "mockBlueClass", "getMockBlueClass", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DepartureTicket getMockBlueClass() {
            return DepartureTicket.mockBlueClass;
        }

        public final DepartureTicket getMockLowPrice() {
            return DepartureTicket.mockLowPrice;
        }

        public final DepartureTicket getMockStandard() {
            return DepartureTicket.mockStandard;
        }

        private Companion() {
        }
    }

    static {
        TicketCategory.Companion companion = TicketCategory.INSTANCE;
        TicketCategory mockLowPrice2 = companion.getMockLowPrice();
        PriceWithCurrency.Companion companion2 = PriceWithCurrency.INSTANCE;
        PriceWithCurrency mock = companion2.mock(100);
        Fee.Companion companion3 = Fee.INSTANCE;
        Fee mock2 = companion3.getMock();
        PriceWithCurrency mock3 = companion2.mock(50);
        PriceWithCurrency mock4 = companion2.mock(549);
        ProductPrice.Companion companion4 = ProductPrice.INSTANCE;
        List listOf = CollectionsKt.listOf(companion4.getMock());
        TicketSurcharge.Companion companion5 = TicketSurcharge.INSTANCE;
        mockLowPrice = new DepartureTicket("8304K", mockLowPrice2, mock, mock2, mock3, mock4, listOf, false, CollectionsKt.listOf(companion5.getMock()));
        mockStandard = new DepartureTicket("8304K", companion.getMockStandard(), companion2.mock(100), companion3.getMock(), companion2.mock(50), companion2.mock(749), CollectionsKt.listOf(companion4.getMock()), false, CollectionsKt.listOf(companion5.getMock()));
        mockBlueClass = new DepartureTicket("8304K", companion.getMockBlueClass(), companion2.mock(100), companion3.getMock(), companion2.mock(50), companion2.mock(749), CollectionsKt.listOf(companion4.getMock()), false, CollectionsKt.listOf(companion5.getMock()));
    }

    public DepartureTicket(String carId, TicketCategory category, PriceWithCurrency changeFee, Fee fee, PriceWithCurrency goodsFee, Price price, List<ProductPrice> productPrices, boolean z5, List<TicketSurcharge> surcharges) {
        Intrinsics.checkNotNullParameter(carId, "carId");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(changeFee, "changeFee");
        Intrinsics.checkNotNullParameter(goodsFee, "goodsFee");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(productPrices, "productPrices");
        Intrinsics.checkNotNullParameter(surcharges, "surcharges");
        this.carId = carId;
        this.category = category;
        this.changeFee = changeFee;
        this.fees = fee;
        this.goodsFee = goodsFee;
        this.price = price;
        this.productPrices = productPrices;
        this.soldOut = z5;
        this.surcharges = surcharges;
    }

    /* renamed from: component1, reason: from getter */
    public final String getCarId() {
        return this.carId;
    }

    /* renamed from: component2, reason: from getter */
    public final TicketCategory getCategory() {
        return this.category;
    }

    /* renamed from: component3, reason: from getter */
    public final PriceWithCurrency getChangeFee() {
        return this.changeFee;
    }

    /* renamed from: component4, reason: from getter */
    public final Fee getFees() {
        return this.fees;
    }

    /* renamed from: component5, reason: from getter */
    public final PriceWithCurrency getGoodsFee() {
        return this.goodsFee;
    }

    /* renamed from: component6, reason: from getter */
    public final Price getPrice() {
        return this.price;
    }

    public final List<ProductPrice> component7() {
        return this.productPrices;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getSoldOut() {
        return this.soldOut;
    }

    public final List<TicketSurcharge> component9() {
        return this.surcharges;
    }

    public final DepartureTicket copy(String carId, TicketCategory category, PriceWithCurrency changeFee, Fee fees, PriceWithCurrency goodsFee, Price price, List<ProductPrice> productPrices, boolean soldOut, List<TicketSurcharge> surcharges) {
        Intrinsics.checkNotNullParameter(carId, "carId");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(changeFee, "changeFee");
        Intrinsics.checkNotNullParameter(goodsFee, "goodsFee");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(productPrices, "productPrices");
        Intrinsics.checkNotNullParameter(surcharges, "surcharges");
        return new DepartureTicket(carId, category, changeFee, fees, goodsFee, price, productPrices, soldOut, surcharges);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DepartureTicket)) {
            return false;
        }
        DepartureTicket departureTicket = (DepartureTicket) other;
        return Intrinsics.areEqual(this.carId, departureTicket.carId) && Intrinsics.areEqual(this.category, departureTicket.category) && Intrinsics.areEqual(this.changeFee, departureTicket.changeFee) && Intrinsics.areEqual(this.fees, departureTicket.fees) && Intrinsics.areEqual(this.goodsFee, departureTicket.goodsFee) && Intrinsics.areEqual(this.price, departureTicket.price) && Intrinsics.areEqual(this.productPrices, departureTicket.productPrices) && this.soldOut == departureTicket.soldOut && Intrinsics.areEqual(this.surcharges, departureTicket.surcharges);
    }

    public final String getCarId() {
        return this.carId;
    }

    public final TicketCategory getCategory() {
        return this.category;
    }

    public final PriceWithCurrency getChangeFee() {
        return this.changeFee;
    }

    public final Fee getFees() {
        return this.fees;
    }

    public final PriceWithCurrency getGoodsFee() {
        return this.goodsFee;
    }

    public final Price getPrice() {
        return this.price;
    }

    public final List<ProductPrice> getProductPrices() {
        return this.productPrices;
    }

    public final boolean getSoldOut() {
        return this.soldOut;
    }

    public final List<TicketSurcharge> getSurcharges() {
        return this.surcharges;
    }

    public int hashCode() {
        int hashCode = ((((this.carId.hashCode() * 31) + this.category.hashCode()) * 31) + this.changeFee.hashCode()) * 31;
        Fee fee = this.fees;
        return ((((((((((hashCode + (fee == null ? 0 : fee.hashCode())) * 31) + this.goodsFee.hashCode()) * 31) + this.price.hashCode()) * 31) + this.productPrices.hashCode()) * 31) + Boolean.hashCode(this.soldOut)) * 31) + this.surcharges.hashCode();
    }

    public String toString() {
        return "DepartureTicket(carId=" + this.carId + ", category=" + this.category + ", changeFee=" + this.changeFee + ", fees=" + this.fees + ", goodsFee=" + this.goodsFee + ", price=" + this.price + ", productPrices=" + this.productPrices + ", soldOut=" + this.soldOut + ", surcharges=" + this.surcharges + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DepartureTicket(DeparturesResponseDTO.TicketResponseDTO dto, boolean z5, boolean z6) {
        this(r2, r3, r4, r5, r6, r7, r8, r9, r10);
        Price priceWithCurrency;
        List emptyList;
        Intrinsics.checkNotNullParameter(dto, "dto");
        String carId = dto.getCarId();
        TicketCategory ticketCategory = new TicketCategory(dto.getCategory());
        PriceWithCurrency priceWithCurrency2 = new PriceWithCurrency(dto.getChangeFee());
        DeparturesResponseDTO.FeeResponseDTO fees = dto.getFees();
        Fee fee = fees != null ? new Fee(fees) : null;
        PriceWithCurrency priceWithCurrency3 = new PriceWithCurrency(dto.getGoodsFee());
        if (z5) {
            priceWithCurrency = new Price.Charge(!z6 ? 1 : 0);
        } else {
            priceWithCurrency = new PriceWithCurrency(dto.getTotalPrice());
        }
        Price price = priceWithCurrency;
        List<DeparturesResponseDTO.ProductPriceResponseDTO> productPrices = dto.getProductPrices();
        if (productPrices != null) {
            List<DeparturesResponseDTO.ProductPriceResponseDTO> list = productPrices;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new ProductPrice((DeparturesResponseDTO.ProductPriceResponseDTO) it.next()));
            }
            emptyList = arrayList;
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        boolean soldOut = dto.getSoldOut();
        List<TicketSurchargeDTO> surcharges = dto.getSurcharges();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(surcharges, 10));
        Iterator<T> it2 = surcharges.iterator();
        while (it2.hasNext()) {
            arrayList2.add(new TicketSurcharge((TicketSurchargeDTO) it2.next()));
        }
    }
}
