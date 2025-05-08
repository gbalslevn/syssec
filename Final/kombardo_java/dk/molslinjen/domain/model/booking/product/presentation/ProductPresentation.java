package dk.molslinjen.domain.model.booking.product.presentation;

import dk.molslinjen.api.services.booking.response.product.presentation.ImageNumericProductPresentationResponseDTO;
import dk.molslinjen.api.services.booking.response.product.presentation.ImageProductPresentationResponseDTO;
import dk.molslinjen.api.services.booking.response.product.presentation.ProductPresentationResponseDTO;
import dk.molslinjen.api.services.booking.response.product.presentation.TextProductPresentationResponseDTO;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b2\u00020\u0001:\u0001\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/presentation/ProductPresentation;", BuildConfig.FLAVOR, "<init>", "()V", "inputType", "Ldk/molslinjen/domain/model/booking/product/presentation/ProductInputType;", "getInputType", "()Ldk/molslinjen/domain/model/booking/product/presentation/ProductInputType;", "Companion", "Ldk/molslinjen/domain/model/booking/product/presentation/ImageNumericProductPresentation;", "Ldk/molslinjen/domain/model/booking/product/presentation/ImageProductPresentation;", "Ldk/molslinjen/domain/model/booking/product/presentation/TextProductPresentation;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProductPresentation {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/presentation/ProductPresentation$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/booking/product/presentation/ProductPresentation;", "dto", "Ldk/molslinjen/api/services/booking/response/product/presentation/ProductPresentationResponseDTO;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProductPresentation invoke(ProductPresentationResponseDTO dto) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            if (dto instanceof TextProductPresentationResponseDTO) {
                return new TextProductPresentation((TextProductPresentationResponseDTO) dto);
            }
            if (dto instanceof ImageProductPresentationResponseDTO) {
                return new ImageProductPresentation((ImageProductPresentationResponseDTO) dto);
            }
            if (dto instanceof ImageNumericProductPresentationResponseDTO) {
                return new ImageNumericProductPresentation((ImageNumericProductPresentationResponseDTO) dto);
            }
            throw new NoWhenBranchMatchedException();
        }

        private Companion() {
        }
    }

    public /* synthetic */ ProductPresentation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract ProductInputType getInputType();

    private ProductPresentation() {
    }
}
