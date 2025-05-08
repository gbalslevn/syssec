package dk.molslinjen.domain.model.booking.product.presentation;

import dk.molslinjen.api.services.booking.response.product.presentation.ImageProductPresentationResponseDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/presentation/ImageProductPresentation;", "Ldk/molslinjen/domain/model/booking/product/presentation/ProductPresentation;", "imageUrl", BuildConfig.FLAVOR, "inputType", "Ldk/molslinjen/domain/model/booking/product/presentation/ProductInputType;", "<init>", "(Ljava/lang/String;Ldk/molslinjen/domain/model/booking/product/presentation/ProductInputType;)V", "dto", "Ldk/molslinjen/api/services/booking/response/product/presentation/ImageProductPresentationResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/product/presentation/ImageProductPresentationResponseDTO;)V", "getImageUrl", "()Ljava/lang/String;", "getInputType", "()Ldk/molslinjen/domain/model/booking/product/presentation/ProductInputType;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ImageProductPresentation extends ProductPresentation {
    private final String imageUrl;
    private final ProductInputType inputType;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ImageProductPresentation mockNumeric = new ImageProductPresentation("https://qa.molslinjen.dk/media/504885/dagens-kage-caffé-latte-400x400px.jpg", ProductInputType.Numeric);
    private static final ImageProductPresentation mockCheckbox = new ImageProductPresentation("https://qa.molslinjen.dk/media/504885/dagens-kage-caffé-latte-400x400px.jpg", ProductInputType.Checkbox);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/presentation/ImageProductPresentation$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mockNumeric", "Ldk/molslinjen/domain/model/booking/product/presentation/ImageProductPresentation;", "getMockNumeric", "()Ldk/molslinjen/domain/model/booking/product/presentation/ImageProductPresentation;", "mockCheckbox", "getMockCheckbox", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ImageProductPresentation getMockCheckbox() {
            return ImageProductPresentation.mockCheckbox;
        }

        public final ImageProductPresentation getMockNumeric() {
            return ImageProductPresentation.mockNumeric;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageProductPresentation(String str, ProductInputType inputType) {
        super(null);
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        this.imageUrl = str;
        this.inputType = inputType;
    }

    public static /* synthetic */ ImageProductPresentation copy$default(ImageProductPresentation imageProductPresentation, String str, ProductInputType productInputType, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = imageProductPresentation.imageUrl;
        }
        if ((i5 & 2) != 0) {
            productInputType = imageProductPresentation.inputType;
        }
        return imageProductPresentation.copy(str, productInputType);
    }

    /* renamed from: component1, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final ProductInputType getInputType() {
        return this.inputType;
    }

    public final ImageProductPresentation copy(String imageUrl, ProductInputType inputType) {
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        return new ImageProductPresentation(imageUrl, inputType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageProductPresentation)) {
            return false;
        }
        ImageProductPresentation imageProductPresentation = (ImageProductPresentation) other;
        return Intrinsics.areEqual(this.imageUrl, imageProductPresentation.imageUrl) && this.inputType == imageProductPresentation.inputType;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Override // dk.molslinjen.domain.model.booking.product.presentation.ProductPresentation
    public ProductInputType getInputType() {
        return this.inputType;
    }

    public int hashCode() {
        String str = this.imageUrl;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.inputType.hashCode();
    }

    public String toString() {
        return "ImageProductPresentation(imageUrl=" + this.imageUrl + ", inputType=" + this.inputType + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageProductPresentation(ImageProductPresentationResponseDTO dto) {
        this(dto.getImageUrl(), ProductInputType.INSTANCE.invoke(dto.getInputType()));
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
