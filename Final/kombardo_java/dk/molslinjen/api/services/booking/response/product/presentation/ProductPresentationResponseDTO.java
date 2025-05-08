package dk.molslinjen.api.services.booking.response.product.presentation;

import dk.molslinjen.api.services.booking.response.ProductInputTypeResponseDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \b2\u00020\u0001:\u0001\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/api/services/booking/response/product/presentation/ProductPresentationResponseDTO;", BuildConfig.FLAVOR, "<init>", "()V", "inputType", "Ldk/molslinjen/api/services/booking/response/ProductInputTypeResponseDTO;", "getInputType", "()Ldk/molslinjen/api/services/booking/response/ProductInputTypeResponseDTO;", "Companion", "Ldk/molslinjen/api/services/booking/response/product/presentation/ImageNumericProductPresentationResponseDTO;", "Ldk/molslinjen/api/services/booking/response/product/presentation/ImageProductPresentationResponseDTO;", "Ldk/molslinjen/api/services/booking/response/product/presentation/TextProductPresentationResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = ProductPresentationResponseDTOSerializer.class)
/* loaded from: classes2.dex */
public abstract class ProductPresentationResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/product/presentation/ProductPresentationResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/product/presentation/ProductPresentationResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ProductPresentationResponseDTO> serializer() {
            return ProductPresentationResponseDTOSerializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ ProductPresentationResponseDTO(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract ProductInputTypeResponseDTO getInputType();

    private ProductPresentationResponseDTO() {
    }
}
