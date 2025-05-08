package dk.molslinjen.api.services.booking.response.product;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.booking.response.ProductTypeResponseDTO;
import dk.molslinjen.api.services.booking.response.product.presentation.ProductPresentationResponseDTO;
import dk.molslinjen.api.services.booking.response.product.presentation.ProductPresentationResponseDTOSerializer;
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
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 82\u00020\u0001:\u000278Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017B\u008f\u0001\b\u0010\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0016\u0010\u001bJ%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001c\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0013\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010#R\u0011\u0010\u0014\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u0011\u0010\u0015\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%¨\u00069"}, d2 = {"Ldk/molslinjen/api/services/booking/response/product/ProductBikeResponseDTO;", "Ldk/molslinjen/api/services/booking/response/product/ProductResponseDTO;", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "price", "Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "originalPrice", "quantity", BuildConfig.FLAVOR, "disabled", BuildConfig.FLAVOR, "presentation", "Ldk/molslinjen/api/services/booking/response/product/presentation/ProductPresentationResponseDTO;", "productType", "Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "tags", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/booking/response/product/ProductTagDTO;", "maxQuantity", "minFirstStep", "hasTrailer", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;IZLdk/molslinjen/api/services/booking/response/product/presentation/ProductPresentationResponseDTO;Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;Ljava/util/List;IIZ)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;IZLdk/molslinjen/api/services/booking/response/product/presentation/ProductPresentationResponseDTO;Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;Ljava/util/List;IIZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "getPrice", "()Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "getOriginalPrice", "getQuantity", "()I", "getDisabled", "()Z", "getPresentation", "()Ldk/molslinjen/api/services/booking/response/product/presentation/ProductPresentationResponseDTO;", "getProductType", "()Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "getTags", "()Ljava/util/List;", "getMaxQuantity", "getMinFirstStep", "getHasTrailer", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class ProductBikeResponseDTO extends ProductResponseDTO {
    private final boolean disabled;
    private final boolean hasTrailer;
    private final String id;
    private final int maxQuantity;
    private final int minFirstStep;
    private final String name;
    private final PriceWithCurrencyDTO originalPrice;
    private final ProductPresentationResponseDTO presentation;
    private final PriceWithCurrencyDTO price;
    private final ProductTypeResponseDTO productType;
    private final int quantity;
    private final List<ProductTagDTO> tags;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, new ArrayListSerializer(ProductTagDTO$$serializer.INSTANCE), null, null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/product/ProductBikeResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/product/ProductBikeResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ProductBikeResponseDTO> serializer() {
            return ProductBikeResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProductBikeResponseDTO(int i5, String str, String str2, PriceWithCurrencyDTO priceWithCurrencyDTO, PriceWithCurrencyDTO priceWithCurrencyDTO2, int i6, boolean z5, ProductPresentationResponseDTO productPresentationResponseDTO, ProductTypeResponseDTO productTypeResponseDTO, List list, int i7, int i8, boolean z6, SerializationConstructorMarker serializationConstructorMarker) {
        super(null);
        if (4087 != (i5 & 4087)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 4087, ProductBikeResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.name = str2;
        this.price = priceWithCurrencyDTO;
        if ((i5 & 8) == 0) {
            this.originalPrice = null;
        } else {
            this.originalPrice = priceWithCurrencyDTO2;
        }
        this.quantity = i6;
        this.disabled = z5;
        this.presentation = productPresentationResponseDTO;
        this.productType = productTypeResponseDTO;
        this.tags = list;
        this.maxQuantity = i7;
        this.minFirstStep = i8;
        this.hasTrailer = z6;
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(ProductBikeResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.getId());
        output.encodeStringElement(serialDesc, 1, self.getName());
        PriceWithCurrencyDTO$$serializer priceWithCurrencyDTO$$serializer = PriceWithCurrencyDTO$$serializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 2, priceWithCurrencyDTO$$serializer, self.getPrice());
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.getOriginalPrice() != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, priceWithCurrencyDTO$$serializer, self.getOriginalPrice());
        }
        output.encodeIntElement(serialDesc, 4, self.getQuantity());
        output.encodeBooleanElement(serialDesc, 5, self.getDisabled());
        output.encodeSerializableElement(serialDesc, 6, ProductPresentationResponseDTOSerializer.INSTANCE, self.getPresentation());
        output.encodeSerializableElement(serialDesc, 7, ProductTypeResponseDTO.Serializer.INSTANCE, self.getProductType());
        output.encodeNullableSerializableElement(serialDesc, 8, kSerializerArr[8], self.getTags());
        output.encodeIntElement(serialDesc, 9, self.maxQuantity);
        output.encodeIntElement(serialDesc, 10, self.minFirstStep);
        output.encodeBooleanElement(serialDesc, 11, self.hasTrailer);
    }

    @Override // dk.molslinjen.api.services.booking.response.product.ProductResponseDTO
    public boolean getDisabled() {
        return this.disabled;
    }

    public final boolean getHasTrailer() {
        return this.hasTrailer;
    }

    @Override // dk.molslinjen.api.services.booking.response.product.ProductResponseDTO
    public String getId() {
        return this.id;
    }

    public final int getMaxQuantity() {
        return this.maxQuantity;
    }

    public final int getMinFirstStep() {
        return this.minFirstStep;
    }

    @Override // dk.molslinjen.api.services.booking.response.product.ProductResponseDTO
    public String getName() {
        return this.name;
    }

    @Override // dk.molslinjen.api.services.booking.response.product.ProductResponseDTO
    public PriceWithCurrencyDTO getOriginalPrice() {
        return this.originalPrice;
    }

    @Override // dk.molslinjen.api.services.booking.response.product.ProductResponseDTO
    public ProductPresentationResponseDTO getPresentation() {
        return this.presentation;
    }

    @Override // dk.molslinjen.api.services.booking.response.product.ProductResponseDTO
    public PriceWithCurrencyDTO getPrice() {
        return this.price;
    }

    @Override // dk.molslinjen.api.services.booking.response.product.ProductResponseDTO
    public ProductTypeResponseDTO getProductType() {
        return this.productType;
    }

    @Override // dk.molslinjen.api.services.booking.response.product.ProductResponseDTO
    public int getQuantity() {
        return this.quantity;
    }

    @Override // dk.molslinjen.api.services.booking.response.product.ProductResponseDTO
    public List<ProductTagDTO> getTags() {
        return this.tags;
    }

    public /* synthetic */ ProductBikeResponseDTO(String str, String str2, PriceWithCurrencyDTO priceWithCurrencyDTO, PriceWithCurrencyDTO priceWithCurrencyDTO2, int i5, boolean z5, ProductPresentationResponseDTO productPresentationResponseDTO, ProductTypeResponseDTO productTypeResponseDTO, List list, int i6, int i7, boolean z6, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, priceWithCurrencyDTO, (i8 & 8) != 0 ? null : priceWithCurrencyDTO2, i5, z5, productPresentationResponseDTO, productTypeResponseDTO, list, i6, i7, z6);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductBikeResponseDTO(String id, String name, PriceWithCurrencyDTO price, PriceWithCurrencyDTO priceWithCurrencyDTO, int i5, boolean z5, ProductPresentationResponseDTO presentation, ProductTypeResponseDTO productType, List<ProductTagDTO> list, int i6, int i7, boolean z6) {
        super(null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(presentation, "presentation");
        Intrinsics.checkNotNullParameter(productType, "productType");
        this.id = id;
        this.name = name;
        this.price = price;
        this.originalPrice = priceWithCurrencyDTO;
        this.quantity = i5;
        this.disabled = z5;
        this.presentation = presentation;
        this.productType = productType;
        this.tags = list;
        this.maxQuantity = i6;
        this.minFirstStep = i7;
        this.hasTrailer = z6;
    }
}
