package dk.molslinjen.api.services.booking.response.product;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.helpers.serializers.SafeListSerializer;
import dk.molslinjen.api.services.booking.response.ProductTypeResponseDTO;
import dk.molslinjen.api.services.booking.response.product.presentation.ProductPresentationResponseDTO;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 &2\u00020\u0001:\u0002%&B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$\u0082\u0001\u0004'()*¨\u0006+"}, d2 = {"Ldk/molslinjen/api/services/booking/response/product/ProductResponseDTO;", BuildConfig.FLAVOR, "<init>", "()V", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "getId", "()Ljava/lang/String;", "name", "getName", "price", "Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "getPrice", "()Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "originalPrice", "getOriginalPrice", "quantity", BuildConfig.FLAVOR, "getQuantity", "()I", "disabled", BuildConfig.FLAVOR, "getDisabled", "()Z", "presentation", "Ldk/molslinjen/api/services/booking/response/product/presentation/ProductPresentationResponseDTO;", "getPresentation", "()Ldk/molslinjen/api/services/booking/response/product/presentation/ProductPresentationResponseDTO;", "productType", "Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "getProductType", "()Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "tags", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/booking/response/product/ProductTagDTO;", "getTags", "()Ljava/util/List;", "ProductResponseDTOSafeListSerializer", "Companion", "Ldk/molslinjen/api/services/booking/response/product/ProductBikeResponseDTO;", "Ldk/molslinjen/api/services/booking/response/product/ProductExtraResponseDTO;", "Ldk/molslinjen/api/services/booking/response/product/ProductQuantityResponseDTO;", "Ldk/molslinjen/api/services/booking/response/product/ProductTrailerResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = ProductResponseDTOSerializer.class)
/* loaded from: classes2.dex */
public abstract class ProductResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/product/ProductResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/product/ProductResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ProductResponseDTO> serializer() {
            return ProductResponseDTOSerializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/api/services/booking/response/product/ProductResponseDTO$ProductResponseDTOSafeListSerializer;", "Ldk/molslinjen/api/helpers/serializers/SafeListSerializer;", "Ldk/molslinjen/api/services/booking/response/product/ProductResponseDTO;", "<init>", "()V", "itemSerializer", "Lkotlinx/serialization/KSerializer;", "getItemSerializer", "()Lkotlinx/serialization/KSerializer;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class ProductResponseDTOSafeListSerializer extends SafeListSerializer<ProductResponseDTO> {
        public static final ProductResponseDTOSafeListSerializer INSTANCE = new ProductResponseDTOSafeListSerializer();
        private static final KSerializer<ProductResponseDTO> itemSerializer = ProductResponseDTO.INSTANCE.serializer();

        private ProductResponseDTOSafeListSerializer() {
        }

        @Override // dk.molslinjen.api.helpers.serializers.SafeListSerializer
        protected KSerializer<ProductResponseDTO> getItemSerializer() {
            return itemSerializer;
        }
    }

    public /* synthetic */ ProductResponseDTO(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract boolean getDisabled();

    public abstract String getId();

    public abstract String getName();

    public abstract PriceWithCurrencyDTO getOriginalPrice();

    public abstract ProductPresentationResponseDTO getPresentation();

    public abstract PriceWithCurrencyDTO getPrice();

    public abstract ProductTypeResponseDTO getProductType();

    public abstract int getQuantity();

    public abstract List<ProductTagDTO> getTags();

    private ProductResponseDTO() {
    }
}
