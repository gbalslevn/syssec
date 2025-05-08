package dk.molslinjen.api.services.booking.response;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.helpers.serializers.IntToEnumSerializer;
import dk.molslinjen.api.helpers.serializers.SafeListSerializer;
import dk.molslinjen.api.helpers.serializers.SerializableEnum;
import dk.molslinjen.api.services.booking.response.ProductTypeResponseDTO;
import dk.molslinjen.api.services.booking.response.product.ProductResponseDTO;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO$$serializer;
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
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0005()*+,B1\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tBE\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006-"}, d2 = {"Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO;", BuildConfig.FLAVOR, "groups", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$ProductGroupResponseDTO;", "unavailableProducts", "Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$UnavailableProductResponseDTO;", "recommendedProductsGroup", "<init>", "(Ljava/util/List;Ljava/util/List;Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$ProductGroupResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$ProductGroupResponseDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGroups", "()Ljava/util/List;", "getUnavailableProducts$annotations", "()V", "getUnavailableProducts", "getRecommendedProductsGroup", "()Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$ProductGroupResponseDTO;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "ProductGroupResponseDTO", "ProductSizeResponseDTO", "UnavailableProductResponseDTO", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class ProductsResponseDTO {
    private final List<ProductGroupResponseDTO> groups;
    private final ProductGroupResponseDTO recommendedProductsGroup;
    private final List<UnavailableProductResponseDTO> unavailableProducts;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(ProductsResponseDTO$ProductGroupResponseDTO$$serializer.INSTANCE), null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ProductsResponseDTO> serializer() {
            return ProductsResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bBI\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J7\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\rHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006."}, d2 = {"Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$ProductGroupResponseDTO;", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "description", "products", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/booking/response/product/ProductResponseDTO;", "size", "Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$ProductSizeResponseDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$ProductSizeResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$ProductSizeResponseDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getDescription", "getProducts$annotations", "()V", "getProducts", "()Ljava/util/List;", "getSize", "()Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$ProductSizeResponseDTO;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class ProductGroupResponseDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String description;
        private final String name;
        private final List<ProductResponseDTO> products;
        private final ProductSizeResponseDTO size;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$ProductGroupResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$ProductGroupResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<ProductGroupResponseDTO> serializer() {
                return ProductsResponseDTO$ProductGroupResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ ProductGroupResponseDTO(int i5, String str, String str2, List list, ProductSizeResponseDTO productSizeResponseDTO, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i5 & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 15, ProductsResponseDTO$ProductGroupResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.name = str;
            this.description = str2;
            this.products = list;
            this.size = productSizeResponseDTO;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ProductGroupResponseDTO copy$default(ProductGroupResponseDTO productGroupResponseDTO, String str, String str2, List list, ProductSizeResponseDTO productSizeResponseDTO, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = productGroupResponseDTO.name;
            }
            if ((i5 & 2) != 0) {
                str2 = productGroupResponseDTO.description;
            }
            if ((i5 & 4) != 0) {
                list = productGroupResponseDTO.products;
            }
            if ((i5 & 8) != 0) {
                productSizeResponseDTO = productGroupResponseDTO.size;
            }
            return productGroupResponseDTO.copy(str, str2, list, productSizeResponseDTO);
        }

        @Serializable(with = ProductResponseDTO.ProductResponseDTOSafeListSerializer.class)
        public static /* synthetic */ void getProducts$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(ProductGroupResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.name);
            output.encodeStringElement(serialDesc, 1, self.description);
            output.encodeSerializableElement(serialDesc, 2, ProductResponseDTO.ProductResponseDTOSafeListSerializer.INSTANCE, self.products);
            output.encodeSerializableElement(serialDesc, 3, ProductSizeResponseDTO.Serializer.INSTANCE, self.size);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        public final List<ProductResponseDTO> component3() {
            return this.products;
        }

        /* renamed from: component4, reason: from getter */
        public final ProductSizeResponseDTO getSize() {
            return this.size;
        }

        public final ProductGroupResponseDTO copy(String name, String description, List<? extends ProductResponseDTO> products, ProductSizeResponseDTO size) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(products, "products");
            Intrinsics.checkNotNullParameter(size, "size");
            return new ProductGroupResponseDTO(name, description, products, size);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ProductGroupResponseDTO)) {
                return false;
            }
            ProductGroupResponseDTO productGroupResponseDTO = (ProductGroupResponseDTO) other;
            return Intrinsics.areEqual(this.name, productGroupResponseDTO.name) && Intrinsics.areEqual(this.description, productGroupResponseDTO.description) && Intrinsics.areEqual(this.products, productGroupResponseDTO.products) && this.size == productGroupResponseDTO.size;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getName() {
            return this.name;
        }

        public final List<ProductResponseDTO> getProducts() {
            return this.products;
        }

        public final ProductSizeResponseDTO getSize() {
            return this.size;
        }

        public int hashCode() {
            return (((((this.name.hashCode() * 31) + this.description.hashCode()) * 31) + this.products.hashCode()) * 31) + this.size.hashCode();
        }

        public String toString() {
            return "ProductGroupResponseDTO(name=" + this.name + ", description=" + this.description + ", products=" + this.products + ", size=" + this.size + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ProductGroupResponseDTO(String name, String description, List<? extends ProductResponseDTO> products, ProductSizeResponseDTO size) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(products, "products");
            Intrinsics.checkNotNullParameter(size, "size");
            this.name = name;
            this.description = description;
            this.products = products;
            this.size = size;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002\u000b\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, d2 = {"Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$ProductSizeResponseDTO;", "Ldk/molslinjen/api/helpers/serializers/SerializableEnum;", BuildConfig.FLAVOR, "rawValue", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getRawValue", "()I", "Small", "Large", "Serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable(with = Serializer.class)
    /* loaded from: classes2.dex */
    public static final class ProductSizeResponseDTO implements SerializableEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ProductSizeResponseDTO[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final int rawValue;
        public static final ProductSizeResponseDTO Small = new ProductSizeResponseDTO("Small", 0, 0);
        public static final ProductSizeResponseDTO Large = new ProductSizeResponseDTO("Large", 1, 2);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$ProductSizeResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$ProductSizeResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<ProductSizeResponseDTO> serializer() {
                return Serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$ProductSizeResponseDTO$Serializer;", "Ldk/molslinjen/api/helpers/serializers/IntToEnumSerializer;", "Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$ProductSizeResponseDTO;", "<init>", "()V", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Serializer extends IntToEnumSerializer<ProductSizeResponseDTO> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(ProductSizeResponseDTO.class);
            }
        }

        private static final /* synthetic */ ProductSizeResponseDTO[] $values() {
            return new ProductSizeResponseDTO[]{Small, Large};
        }

        static {
            ProductSizeResponseDTO[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
        }

        private ProductSizeResponseDTO(String str, int i5, int i6) {
            this.rawValue = i6;
        }

        public static EnumEntries<ProductSizeResponseDTO> getEntries() {
            return $ENTRIES;
        }

        public static ProductSizeResponseDTO valueOf(String str) {
            return (ProductSizeResponseDTO) Enum.valueOf(ProductSizeResponseDTO.class, str);
        }

        public static ProductSizeResponseDTO[] values() {
            return (ProductSizeResponseDTO[]) $VALUES.clone();
        }

        @Override // dk.molslinjen.api.helpers.serializers.SerializableEnum
        public int getRawValue() {
            return this.rawValue;
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0003)*+B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$UnavailableProductResponseDTO;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "price", "Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "productType", "Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "getPrice", "()Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "getProductType", "()Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "UnavailableProductResponseDTOSafeListSerializer", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class UnavailableProductResponseDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String id;
        private final String name;
        private final PriceWithCurrencyDTO price;
        private final ProductTypeResponseDTO productType;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$UnavailableProductResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$UnavailableProductResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<UnavailableProductResponseDTO> serializer() {
                return ProductsResponseDTO$UnavailableProductResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$UnavailableProductResponseDTO$UnavailableProductResponseDTOSafeListSerializer;", "Ldk/molslinjen/api/helpers/serializers/SafeListSerializer;", "Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$UnavailableProductResponseDTO;", "<init>", "()V", "itemSerializer", "Lkotlinx/serialization/KSerializer;", "getItemSerializer", "()Lkotlinx/serialization/KSerializer;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class UnavailableProductResponseDTOSafeListSerializer extends SafeListSerializer<UnavailableProductResponseDTO> {
            public static final UnavailableProductResponseDTOSafeListSerializer INSTANCE = new UnavailableProductResponseDTOSafeListSerializer();
            private static final KSerializer<UnavailableProductResponseDTO> itemSerializer = UnavailableProductResponseDTO.INSTANCE.serializer();

            private UnavailableProductResponseDTOSafeListSerializer() {
            }

            @Override // dk.molslinjen.api.helpers.serializers.SafeListSerializer
            protected KSerializer<UnavailableProductResponseDTO> getItemSerializer() {
                return itemSerializer;
            }
        }

        public /* synthetic */ UnavailableProductResponseDTO(int i5, String str, String str2, PriceWithCurrencyDTO priceWithCurrencyDTO, ProductTypeResponseDTO productTypeResponseDTO, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i5 & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 15, ProductsResponseDTO$UnavailableProductResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.name = str2;
            this.price = priceWithCurrencyDTO;
            this.productType = productTypeResponseDTO;
        }

        public static /* synthetic */ UnavailableProductResponseDTO copy$default(UnavailableProductResponseDTO unavailableProductResponseDTO, String str, String str2, PriceWithCurrencyDTO priceWithCurrencyDTO, ProductTypeResponseDTO productTypeResponseDTO, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = unavailableProductResponseDTO.id;
            }
            if ((i5 & 2) != 0) {
                str2 = unavailableProductResponseDTO.name;
            }
            if ((i5 & 4) != 0) {
                priceWithCurrencyDTO = unavailableProductResponseDTO.price;
            }
            if ((i5 & 8) != 0) {
                productTypeResponseDTO = unavailableProductResponseDTO.productType;
            }
            return unavailableProductResponseDTO.copy(str, str2, priceWithCurrencyDTO, productTypeResponseDTO);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(UnavailableProductResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeStringElement(serialDesc, 1, self.name);
            output.encodeSerializableElement(serialDesc, 2, PriceWithCurrencyDTO$$serializer.INSTANCE, self.price);
            output.encodeSerializableElement(serialDesc, 3, ProductTypeResponseDTO.Serializer.INSTANCE, self.productType);
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
        public final ProductTypeResponseDTO getProductType() {
            return this.productType;
        }

        public final UnavailableProductResponseDTO copy(String id, String name, PriceWithCurrencyDTO price, ProductTypeResponseDTO productType) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(price, "price");
            Intrinsics.checkNotNullParameter(productType, "productType");
            return new UnavailableProductResponseDTO(id, name, price, productType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnavailableProductResponseDTO)) {
                return false;
            }
            UnavailableProductResponseDTO unavailableProductResponseDTO = (UnavailableProductResponseDTO) other;
            return Intrinsics.areEqual(this.id, unavailableProductResponseDTO.id) && Intrinsics.areEqual(this.name, unavailableProductResponseDTO.name) && Intrinsics.areEqual(this.price, unavailableProductResponseDTO.price) && this.productType == unavailableProductResponseDTO.productType;
        }

        public final String getId() {
            return this.id;
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

        public int hashCode() {
            return (((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.price.hashCode()) * 31) + this.productType.hashCode();
        }

        public String toString() {
            return "UnavailableProductResponseDTO(id=" + this.id + ", name=" + this.name + ", price=" + this.price + ", productType=" + this.productType + ")";
        }

        public UnavailableProductResponseDTO(String id, String name, PriceWithCurrencyDTO price, ProductTypeResponseDTO productType) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(price, "price");
            Intrinsics.checkNotNullParameter(productType, "productType");
            this.id = id;
            this.name = name;
            this.price = price;
            this.productType = productType;
        }
    }

    public /* synthetic */ ProductsResponseDTO(int i5, List list, List list2, ProductGroupResponseDTO productGroupResponseDTO, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, ProductsResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.groups = list;
        this.unavailableProducts = list2;
        this.recommendedProductsGroup = productGroupResponseDTO;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductsResponseDTO copy$default(ProductsResponseDTO productsResponseDTO, List list, List list2, ProductGroupResponseDTO productGroupResponseDTO, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            list = productsResponseDTO.groups;
        }
        if ((i5 & 2) != 0) {
            list2 = productsResponseDTO.unavailableProducts;
        }
        if ((i5 & 4) != 0) {
            productGroupResponseDTO = productsResponseDTO.recommendedProductsGroup;
        }
        return productsResponseDTO.copy(list, list2, productGroupResponseDTO);
    }

    @Serializable(with = UnavailableProductResponseDTO.UnavailableProductResponseDTOSafeListSerializer.class)
    public static /* synthetic */ void getUnavailableProducts$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(ProductsResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, $childSerializers[0], self.groups);
        output.encodeNullableSerializableElement(serialDesc, 1, UnavailableProductResponseDTO.UnavailableProductResponseDTOSafeListSerializer.INSTANCE, self.unavailableProducts);
        output.encodeNullableSerializableElement(serialDesc, 2, ProductsResponseDTO$ProductGroupResponseDTO$$serializer.INSTANCE, self.recommendedProductsGroup);
    }

    public final List<ProductGroupResponseDTO> component1() {
        return this.groups;
    }

    public final List<UnavailableProductResponseDTO> component2() {
        return this.unavailableProducts;
    }

    /* renamed from: component3, reason: from getter */
    public final ProductGroupResponseDTO getRecommendedProductsGroup() {
        return this.recommendedProductsGroup;
    }

    public final ProductsResponseDTO copy(List<ProductGroupResponseDTO> groups, List<UnavailableProductResponseDTO> unavailableProducts, ProductGroupResponseDTO recommendedProductsGroup) {
        return new ProductsResponseDTO(groups, unavailableProducts, recommendedProductsGroup);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProductsResponseDTO)) {
            return false;
        }
        ProductsResponseDTO productsResponseDTO = (ProductsResponseDTO) other;
        return Intrinsics.areEqual(this.groups, productsResponseDTO.groups) && Intrinsics.areEqual(this.unavailableProducts, productsResponseDTO.unavailableProducts) && Intrinsics.areEqual(this.recommendedProductsGroup, productsResponseDTO.recommendedProductsGroup);
    }

    public final List<ProductGroupResponseDTO> getGroups() {
        return this.groups;
    }

    public final ProductGroupResponseDTO getRecommendedProductsGroup() {
        return this.recommendedProductsGroup;
    }

    public final List<UnavailableProductResponseDTO> getUnavailableProducts() {
        return this.unavailableProducts;
    }

    public int hashCode() {
        List<ProductGroupResponseDTO> list = this.groups;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<UnavailableProductResponseDTO> list2 = this.unavailableProducts;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        ProductGroupResponseDTO productGroupResponseDTO = this.recommendedProductsGroup;
        return hashCode2 + (productGroupResponseDTO != null ? productGroupResponseDTO.hashCode() : 0);
    }

    public String toString() {
        return "ProductsResponseDTO(groups=" + this.groups + ", unavailableProducts=" + this.unavailableProducts + ", recommendedProductsGroup=" + this.recommendedProductsGroup + ")";
    }

    public ProductsResponseDTO(List<ProductGroupResponseDTO> list, List<UnavailableProductResponseDTO> list2, ProductGroupResponseDTO productGroupResponseDTO) {
        this.groups = list;
        this.unavailableProducts = list2;
        this.recommendedProductsGroup = productGroupResponseDTO;
    }
}
