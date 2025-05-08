package dk.molslinjen.domain.model.booking;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO;
import dk.molslinjen.domain.model.booking.product.ISummaryProduct;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 42\u00020\u0001:\u00014BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0010\u0010\u0014J\b\u0010#\u001a\u00020$H\u0016J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\t\u0010*\u001a\u00020\fHÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jg\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010/\u001a\u00020$2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\nHÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\r\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016¨\u00065"}, d2 = {"Ldk/molslinjen/domain/model/booking/LineItem;", "Ldk/molslinjen/domain/model/booking/product/ISummaryProduct;", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "price", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "productType", "Ldk/molslinjen/domain/model/booking/ProductType;", "originalQuantity", BuildConfig.FLAVOR, "availability", "Ldk/molslinjen/domain/model/booking/Availability;", "quantity", "imageUrl", "cateringLocationText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ldk/molslinjen/domain/model/booking/ProductType;ILdk/molslinjen/domain/model/booking/Availability;ILjava/lang/String;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$LineItemResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$LineItemResponseDTO;)V", "getId", "()Ljava/lang/String;", "getName", "getPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getProductType", "()Ldk/molslinjen/domain/model/booking/ProductType;", "getOriginalQuantity", "()I", "getAvailability", "()Ldk/molslinjen/domain/model/booking/Availability;", "getQuantity", "getImageUrl", "getCateringLocationText", "showQuantity", BuildConfig.FLAVOR, "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class LineItem implements ISummaryProduct {
    public static final String loungeAccessId = "68";
    private final Availability availability;
    private final String cateringLocationText;
    private final String id;
    private final String imageUrl;
    private final String name;
    private final int originalQuantity;
    private final PriceWithCurrency price;
    private final ProductType productType;
    private final int quantity;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final LineItem mock = new LineItem("CMOR", "Buffet & valgfri BARISTA's kaffe", PriceWithCurrency.INSTANCE.mock(100), ProductType.Catering, 0, Availability.Route, 1, null, "Afhentes hos: Molslinjen Express Shop 233", 16, null);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/booking/LineItem$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "loungeAccessId", BuildConfig.FLAVOR, "mock", "Ldk/molslinjen/domain/model/booking/LineItem;", "getMock", "()Ldk/molslinjen/domain/model/booking/LineItem;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LineItem getMock() {
            return LineItem.mock;
        }

        private Companion() {
        }
    }

    public LineItem(String id, String name, PriceWithCurrency price, ProductType productType, int i5, Availability availability, int i6, String str, String str2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(availability, "availability");
        this.id = id;
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.originalQuantity = i5;
        this.availability = availability;
        this.quantity = i6;
        this.imageUrl = str;
        this.cateringLocationText = str2;
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
    public final PriceWithCurrency getPrice() {
        return this.price;
    }

    /* renamed from: component4, reason: from getter */
    public final ProductType getProductType() {
        return this.productType;
    }

    /* renamed from: component5, reason: from getter */
    public final int getOriginalQuantity() {
        return this.originalQuantity;
    }

    /* renamed from: component6, reason: from getter */
    public final Availability getAvailability() {
        return this.availability;
    }

    /* renamed from: component7, reason: from getter */
    public final int getQuantity() {
        return this.quantity;
    }

    /* renamed from: component8, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: component9, reason: from getter */
    public final String getCateringLocationText() {
        return this.cateringLocationText;
    }

    public final LineItem copy(String id, String name, PriceWithCurrency price, ProductType productType, int originalQuantity, Availability availability, int quantity, String imageUrl, String cateringLocationText) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(availability, "availability");
        return new LineItem(id, name, price, productType, originalQuantity, availability, quantity, imageUrl, cateringLocationText);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LineItem)) {
            return false;
        }
        LineItem lineItem = (LineItem) other;
        return Intrinsics.areEqual(this.id, lineItem.id) && Intrinsics.areEqual(this.name, lineItem.name) && Intrinsics.areEqual(this.price, lineItem.price) && this.productType == lineItem.productType && this.originalQuantity == lineItem.originalQuantity && this.availability == lineItem.availability && this.quantity == lineItem.quantity && Intrinsics.areEqual(this.imageUrl, lineItem.imageUrl) && Intrinsics.areEqual(this.cateringLocationText, lineItem.cateringLocationText);
    }

    public final Availability getAvailability() {
        return this.availability;
    }

    public final String getCateringLocationText() {
        return this.cateringLocationText;
    }

    @Override // dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public String getId() {
        return this.id;
    }

    @Override // dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public String getImageUrl() {
        return this.imageUrl;
    }

    @Override // dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public String getName() {
        return this.name;
    }

    @Override // dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public int getOriginalQuantity() {
        return this.originalQuantity;
    }

    @Override // dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public PriceWithCurrency getPrice() {
        return this.price;
    }

    @Override // dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public ProductType getProductType() {
        return this.productType;
    }

    @Override // dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public int getQuantity() {
        return this.quantity;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.price.hashCode()) * 31) + this.productType.hashCode()) * 31) + Integer.hashCode(this.originalQuantity)) * 31) + this.availability.hashCode()) * 31) + Integer.hashCode(this.quantity)) * 31;
        String str = this.imageUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.cateringLocationText;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public boolean showQuantity() {
        return getQuantity() > 1;
    }

    @Override // dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public PriceWithCurrency sum() {
        return ISummaryProduct.DefaultImpls.sum(this);
    }

    public String toString() {
        return "LineItem(id=" + this.id + ", name=" + this.name + ", price=" + this.price + ", productType=" + this.productType + ", originalQuantity=" + this.originalQuantity + ", availability=" + this.availability + ", quantity=" + this.quantity + ", imageUrl=" + this.imageUrl + ", cateringLocationText=" + this.cateringLocationText + ")";
    }

    public /* synthetic */ LineItem(String str, String str2, PriceWithCurrency priceWithCurrency, ProductType productType, int i5, Availability availability, int i6, String str3, String str4, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, priceWithCurrency, productType, (i7 & 16) != 0 ? 0 : i5, availability, i6, str3, str4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LineItem(BookingResponseDTO.LineItemResponseDTO dto) {
        this(dto.getId(), dto.getName(), new PriceWithCurrency(dto.getUnitPrice()), ProductType.INSTANCE.invoke(dto.getProductType()), r6, Availability.INSTANCE.invoke(dto.getAvailability()), dto.getQuantity(), dto.getImageUrl(), dto.getCateringLocationText(), 16, null);
        Intrinsics.checkNotNullParameter(dto, "dto");
        int i5 = 0;
    }
}
