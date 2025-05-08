package dk.molslinjen.domain.model.booking.product.presentation;

import dk.molslinjen.api.services.booking.response.product.presentation.TextProductPresentationResponseDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/presentation/TextProductPresentation;", "Ldk/molslinjen/domain/model/booking/product/presentation/ProductPresentation;", "inputType", "Ldk/molslinjen/domain/model/booking/product/presentation/ProductInputType;", "<init>", "(Ldk/molslinjen/domain/model/booking/product/presentation/ProductInputType;)V", "dto", "Ldk/molslinjen/api/services/booking/response/product/presentation/TextProductPresentationResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/product/presentation/TextProductPresentationResponseDTO;)V", "getInputType", "()Ldk/molslinjen/domain/model/booking/product/presentation/ProductInputType;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TextProductPresentation extends ProductPresentation {
    private final ProductInputType inputType;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TextProductPresentation mockNumeric = new TextProductPresentation(ProductInputType.Numeric);
    private static final TextProductPresentation mockCheckbox = new TextProductPresentation(ProductInputType.Checkbox);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/presentation/TextProductPresentation$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mockNumeric", "Ldk/molslinjen/domain/model/booking/product/presentation/TextProductPresentation;", "getMockNumeric", "()Ldk/molslinjen/domain/model/booking/product/presentation/TextProductPresentation;", "mockCheckbox", "getMockCheckbox", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TextProductPresentation getMockCheckbox() {
            return TextProductPresentation.mockCheckbox;
        }

        public final TextProductPresentation getMockNumeric() {
            return TextProductPresentation.mockNumeric;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextProductPresentation(ProductInputType inputType) {
        super(null);
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        this.inputType = inputType;
    }

    public static /* synthetic */ TextProductPresentation copy$default(TextProductPresentation textProductPresentation, ProductInputType productInputType, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            productInputType = textProductPresentation.inputType;
        }
        return textProductPresentation.copy(productInputType);
    }

    /* renamed from: component1, reason: from getter */
    public final ProductInputType getInputType() {
        return this.inputType;
    }

    public final TextProductPresentation copy(ProductInputType inputType) {
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        return new TextProductPresentation(inputType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TextProductPresentation) && this.inputType == ((TextProductPresentation) other).inputType;
    }

    @Override // dk.molslinjen.domain.model.booking.product.presentation.ProductPresentation
    public ProductInputType getInputType() {
        return this.inputType;
    }

    public int hashCode() {
        return this.inputType.hashCode();
    }

    public String toString() {
        return "TextProductPresentation(inputType=" + this.inputType + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextProductPresentation(TextProductPresentationResponseDTO dto) {
        this(ProductInputType.INSTANCE.invoke(dto.getInputType()));
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
