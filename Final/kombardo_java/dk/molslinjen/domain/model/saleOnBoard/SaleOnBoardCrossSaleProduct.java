package dk.molslinjen.domain.model.saleOnBoard;

import dk.molslinjen.api.services.saleOnBoard.response.ShopAndProductsResponseDTO;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.domain.model.shared.PriceWithCurrency$$serializer;
import java.util.List;
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

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002,-B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J?\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\rHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006."}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCrossSaleProduct;", BuildConfig.FLAVOR, "productId", BuildConfig.FLAVOR, "product", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;", "name", "description", "price", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "<init>", "(Ljava/lang/String;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getProductId", "()Ljava/lang/String;", "getProduct", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;", "getName", "getDescription", "getPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class SaleOnBoardCrossSaleProduct {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SaleOnBoardCrossSaleProduct mock1;
    private static final SaleOnBoardCrossSaleProduct mock2;
    private static final SaleOnBoardCrossSaleProduct mock3;
    private final String description;
    private final String name;
    private final PriceWithCurrency price;
    private final SaleOnBoardProduct product;
    private final String productId;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086\u0002J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCrossSaleProduct$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCrossSaleProduct;", "dto", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardCrossSaleProductResponseDTO;", "currencyType", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "mock1", "getMock1", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCrossSaleProduct;", "mock2", "getMock2", "mock3", "getMock3", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaleOnBoardCrossSaleProduct getMock1() {
            return SaleOnBoardCrossSaleProduct.mock1;
        }

        public final SaleOnBoardCrossSaleProduct getMock2() {
            return SaleOnBoardCrossSaleProduct.mock2;
        }

        public final SaleOnBoardCrossSaleProduct getMock3() {
            return SaleOnBoardCrossSaleProduct.mock3;
        }

        public final SaleOnBoardCrossSaleProduct invoke(ShopAndProductsResponseDTO.SaleOnBoardCrossSaleProductResponseDTO dto, CurrencyType currencyType) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            Intrinsics.checkNotNullParameter(currencyType, "currencyType");
            List<String> extendedTexts = dto.getExtendedTexts();
            String str = BuildConfig.FLAVOR;
            if (extendedTexts != null) {
                for (String str2 : extendedTexts) {
                    if (str.length() > 0) {
                        str = ((Object) str) + "\n";
                    }
                    str = ((Object) str) + str2;
                }
            }
            return new SaleOnBoardCrossSaleProduct(dto.getId(), (SaleOnBoardProduct) null, dto.getName(), StringExtensionsKt.nullIfEmpty(str), new PriceWithCurrency((int) dto.getPrice(), currencyType), 2, (DefaultConstructorMarker) null);
        }

        public final KSerializer<SaleOnBoardCrossSaleProduct> serializer() {
            return SaleOnBoardCrossSaleProduct$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        PriceWithCurrency.Companion companion = PriceWithCurrency.INSTANCE;
        mock1 = new SaleOnBoardCrossSaleProduct("{6D79005A-EBEA-4B51-AD3E-BDAEA1BEC1C4}", (SaleOnBoardProduct) null, "Sæsonkage", (String) null, companion.mock(36), 2, (DefaultConstructorMarker) null);
        mock2 = new SaleOnBoardCrossSaleProduct("{1D6D8EC3-8182-4863-8F83-0CAF91CB1898}", (SaleOnBoardProduct) null, "Crossaint", "Den franske klassisker, smørstegt og sprød. ", companion.mock(20), 2, (DefaultConstructorMarker) null);
        mock3 = new SaleOnBoardCrossSaleProduct("{F4A38774-F9A0-46B0-8EFB-EAD56774586A}", (SaleOnBoardProduct) null, "Hindbærsnitte", "En sprød dej med hindbærkompot imellem lagene og citronglasur på toppen. ", companion.mock(20), 2, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ SaleOnBoardCrossSaleProduct(int i5, String str, SaleOnBoardProduct saleOnBoardProduct, String str2, String str3, PriceWithCurrency priceWithCurrency, SerializationConstructorMarker serializationConstructorMarker) {
        if (29 != (i5 & 29)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 29, SaleOnBoardCrossSaleProduct$$serializer.INSTANCE.getDescriptor());
        }
        this.productId = str;
        if ((i5 & 2) == 0) {
            this.product = null;
        } else {
            this.product = saleOnBoardProduct;
        }
        this.name = str2;
        this.description = str3;
        this.price = priceWithCurrency;
    }

    public static /* synthetic */ SaleOnBoardCrossSaleProduct copy$default(SaleOnBoardCrossSaleProduct saleOnBoardCrossSaleProduct, String str, SaleOnBoardProduct saleOnBoardProduct, String str2, String str3, PriceWithCurrency priceWithCurrency, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = saleOnBoardCrossSaleProduct.productId;
        }
        if ((i5 & 2) != 0) {
            saleOnBoardProduct = saleOnBoardCrossSaleProduct.product;
        }
        SaleOnBoardProduct saleOnBoardProduct2 = saleOnBoardProduct;
        if ((i5 & 4) != 0) {
            str2 = saleOnBoardCrossSaleProduct.name;
        }
        String str4 = str2;
        if ((i5 & 8) != 0) {
            str3 = saleOnBoardCrossSaleProduct.description;
        }
        String str5 = str3;
        if ((i5 & 16) != 0) {
            priceWithCurrency = saleOnBoardCrossSaleProduct.price;
        }
        return saleOnBoardCrossSaleProduct.copy(str, saleOnBoardProduct2, str4, str5, priceWithCurrency);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(SaleOnBoardCrossSaleProduct self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.productId);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.product != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, SaleOnBoardProduct$$serializer.INSTANCE, self.product);
        }
        output.encodeStringElement(serialDesc, 2, self.name);
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.description);
        output.encodeSerializableElement(serialDesc, 4, PriceWithCurrency$$serializer.INSTANCE, self.price);
    }

    /* renamed from: component1, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* renamed from: component2, reason: from getter */
    public final SaleOnBoardProduct getProduct() {
        return this.product;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component5, reason: from getter */
    public final PriceWithCurrency getPrice() {
        return this.price;
    }

    public final SaleOnBoardCrossSaleProduct copy(String productId, SaleOnBoardProduct product, String name, String description, PriceWithCurrency price) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(price, "price");
        return new SaleOnBoardCrossSaleProduct(productId, product, name, description, price);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleOnBoardCrossSaleProduct)) {
            return false;
        }
        SaleOnBoardCrossSaleProduct saleOnBoardCrossSaleProduct = (SaleOnBoardCrossSaleProduct) other;
        return Intrinsics.areEqual(this.productId, saleOnBoardCrossSaleProduct.productId) && Intrinsics.areEqual(this.product, saleOnBoardCrossSaleProduct.product) && Intrinsics.areEqual(this.name, saleOnBoardCrossSaleProduct.name) && Intrinsics.areEqual(this.description, saleOnBoardCrossSaleProduct.description) && Intrinsics.areEqual(this.price, saleOnBoardCrossSaleProduct.price);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public final PriceWithCurrency getPrice() {
        return this.price;
    }

    public final SaleOnBoardProduct getProduct() {
        return this.product;
    }

    public final String getProductId() {
        return this.productId;
    }

    public int hashCode() {
        int hashCode = this.productId.hashCode() * 31;
        SaleOnBoardProduct saleOnBoardProduct = this.product;
        int hashCode2 = (((hashCode + (saleOnBoardProduct == null ? 0 : saleOnBoardProduct.hashCode())) * 31) + this.name.hashCode()) * 31;
        String str = this.description;
        return ((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.price.hashCode();
    }

    public String toString() {
        return "SaleOnBoardCrossSaleProduct(productId=" + this.productId + ", product=" + this.product + ", name=" + this.name + ", description=" + this.description + ", price=" + this.price + ")";
    }

    public SaleOnBoardCrossSaleProduct(String productId, SaleOnBoardProduct saleOnBoardProduct, String name, String str, PriceWithCurrency price) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(price, "price");
        this.productId = productId;
        this.product = saleOnBoardProduct;
        this.name = name;
        this.description = str;
        this.price = price;
    }

    public /* synthetic */ SaleOnBoardCrossSaleProduct(String str, SaleOnBoardProduct saleOnBoardProduct, String str2, String str3, PriceWithCurrency priceWithCurrency, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i5 & 2) != 0 ? null : saleOnBoardProduct, str2, str3, priceWithCurrency);
    }
}
