package dk.molslinjen.domain.model.booking.product.presentation;

import dk.molslinjen.api.services.booking.response.product.presentation.ImageNumericProductPresentationResponseDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Ldk/molslinjen/domain/model/booking/product/presentation/ImageNumericProductPresentation;", "Ldk/molslinjen/domain/model/booking/product/presentation/ProductPresentation;", "imageUrl", BuildConfig.FLAVOR, "singularLabel", "pluralLabel", "inputType", "Ldk/molslinjen/domain/model/booking/product/presentation/ProductInputType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/product/presentation/ProductInputType;)V", "dto", "Ldk/molslinjen/api/services/booking/response/product/presentation/ImageNumericProductPresentationResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/product/presentation/ImageNumericProductPresentationResponseDTO;)V", "getImageUrl", "()Ljava/lang/String;", "getSingularLabel", "getPluralLabel", "getInputType", "()Ldk/molslinjen/domain/model/booking/product/presentation/ProductInputType;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ImageNumericProductPresentation extends ProductPresentation {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ImageNumericProductPresentation mock = new ImageNumericProductPresentation("/media/504998/morgenbuffet-inkl-valgfri-baristas-kaffe-400x400px.jpg", "Kahyt", "Kahytter", ProductInputType.Numeric);
    private final String imageUrl;
    private final ProductInputType inputType;
    private final String pluralLabel;
    private final String singularLabel;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/presentation/ImageNumericProductPresentation$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/product/presentation/ImageNumericProductPresentation;", "getMock", "()Ldk/molslinjen/domain/model/booking/product/presentation/ImageNumericProductPresentation;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ImageNumericProductPresentation getMock() {
            return ImageNumericProductPresentation.mock;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageNumericProductPresentation(String imageUrl, String singularLabel, String pluralLabel, ProductInputType inputType) {
        super(null);
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(singularLabel, "singularLabel");
        Intrinsics.checkNotNullParameter(pluralLabel, "pluralLabel");
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        this.imageUrl = imageUrl;
        this.singularLabel = singularLabel;
        this.pluralLabel = pluralLabel;
        this.inputType = inputType;
    }

    public static /* synthetic */ ImageNumericProductPresentation copy$default(ImageNumericProductPresentation imageNumericProductPresentation, String str, String str2, String str3, ProductInputType productInputType, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = imageNumericProductPresentation.imageUrl;
        }
        if ((i5 & 2) != 0) {
            str2 = imageNumericProductPresentation.singularLabel;
        }
        if ((i5 & 4) != 0) {
            str3 = imageNumericProductPresentation.pluralLabel;
        }
        if ((i5 & 8) != 0) {
            productInputType = imageNumericProductPresentation.inputType;
        }
        return imageNumericProductPresentation.copy(str, str2, str3, productInputType);
    }

    /* renamed from: component1, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSingularLabel() {
        return this.singularLabel;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPluralLabel() {
        return this.pluralLabel;
    }

    /* renamed from: component4, reason: from getter */
    public final ProductInputType getInputType() {
        return this.inputType;
    }

    public final ImageNumericProductPresentation copy(String imageUrl, String singularLabel, String pluralLabel, ProductInputType inputType) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(singularLabel, "singularLabel");
        Intrinsics.checkNotNullParameter(pluralLabel, "pluralLabel");
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        return new ImageNumericProductPresentation(imageUrl, singularLabel, pluralLabel, inputType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageNumericProductPresentation)) {
            return false;
        }
        ImageNumericProductPresentation imageNumericProductPresentation = (ImageNumericProductPresentation) other;
        return Intrinsics.areEqual(this.imageUrl, imageNumericProductPresentation.imageUrl) && Intrinsics.areEqual(this.singularLabel, imageNumericProductPresentation.singularLabel) && Intrinsics.areEqual(this.pluralLabel, imageNumericProductPresentation.pluralLabel) && this.inputType == imageNumericProductPresentation.inputType;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Override // dk.molslinjen.domain.model.booking.product.presentation.ProductPresentation
    public ProductInputType getInputType() {
        return this.inputType;
    }

    public final String getPluralLabel() {
        return this.pluralLabel;
    }

    public final String getSingularLabel() {
        return this.singularLabel;
    }

    public int hashCode() {
        return (((((this.imageUrl.hashCode() * 31) + this.singularLabel.hashCode()) * 31) + this.pluralLabel.hashCode()) * 31) + this.inputType.hashCode();
    }

    public String toString() {
        return "ImageNumericProductPresentation(imageUrl=" + this.imageUrl + ", singularLabel=" + this.singularLabel + ", pluralLabel=" + this.pluralLabel + ", inputType=" + this.inputType + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageNumericProductPresentation(ImageNumericProductPresentationResponseDTO dto) {
        this(dto.getImageUrl(), dto.getSingularLabel(), dto.getPluralLabel(), ProductInputType.INSTANCE.invoke(dto.getInputType()));
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
