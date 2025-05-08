package dk.molslinjen.api.services.booking.response.product.presentation;

import dk.molslinjen.api.services.booking.response.ProductInputTypeResponseDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006*"}, d2 = {"Ldk/molslinjen/api/services/booking/response/product/presentation/ImageNumericProductPresentationResponseDTO;", "Ldk/molslinjen/api/services/booking/response/product/presentation/ProductPresentationResponseDTO;", "imageUrl", BuildConfig.FLAVOR, "singularLabel", "pluralLabel", "inputType", "Ldk/molslinjen/api/services/booking/response/ProductInputTypeResponseDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/ProductInputTypeResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/ProductInputTypeResponseDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImageUrl", "()Ljava/lang/String;", "getSingularLabel", "getPluralLabel", "getInputType", "()Ldk/molslinjen/api/services/booking/response/ProductInputTypeResponseDTO;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class ImageNumericProductPresentationResponseDTO extends ProductPresentationResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String imageUrl;
    private final ProductInputTypeResponseDTO inputType;
    private final String pluralLabel;
    private final String singularLabel;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/product/presentation/ImageNumericProductPresentationResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/product/presentation/ImageNumericProductPresentationResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ImageNumericProductPresentationResponseDTO> serializer() {
            return ImageNumericProductPresentationResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageNumericProductPresentationResponseDTO(int i5, String str, String str2, String str3, ProductInputTypeResponseDTO productInputTypeResponseDTO, SerializationConstructorMarker serializationConstructorMarker) {
        super(null);
        if (15 != (i5 & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 15, ImageNumericProductPresentationResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.imageUrl = str;
        this.singularLabel = str2;
        this.pluralLabel = str3;
        this.inputType = productInputTypeResponseDTO;
    }

    public static /* synthetic */ ImageNumericProductPresentationResponseDTO copy$default(ImageNumericProductPresentationResponseDTO imageNumericProductPresentationResponseDTO, String str, String str2, String str3, ProductInputTypeResponseDTO productInputTypeResponseDTO, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = imageNumericProductPresentationResponseDTO.imageUrl;
        }
        if ((i5 & 2) != 0) {
            str2 = imageNumericProductPresentationResponseDTO.singularLabel;
        }
        if ((i5 & 4) != 0) {
            str3 = imageNumericProductPresentationResponseDTO.pluralLabel;
        }
        if ((i5 & 8) != 0) {
            productInputTypeResponseDTO = imageNumericProductPresentationResponseDTO.inputType;
        }
        return imageNumericProductPresentationResponseDTO.copy(str, str2, str3, productInputTypeResponseDTO);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(ImageNumericProductPresentationResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.imageUrl);
        output.encodeStringElement(serialDesc, 1, self.singularLabel);
        output.encodeStringElement(serialDesc, 2, self.pluralLabel);
        output.encodeSerializableElement(serialDesc, 3, ProductInputTypeResponseDTO.Serializer.INSTANCE, self.getInputType());
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
    public final ProductInputTypeResponseDTO getInputType() {
        return this.inputType;
    }

    public final ImageNumericProductPresentationResponseDTO copy(String imageUrl, String singularLabel, String pluralLabel, ProductInputTypeResponseDTO inputType) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(singularLabel, "singularLabel");
        Intrinsics.checkNotNullParameter(pluralLabel, "pluralLabel");
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        return new ImageNumericProductPresentationResponseDTO(imageUrl, singularLabel, pluralLabel, inputType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageNumericProductPresentationResponseDTO)) {
            return false;
        }
        ImageNumericProductPresentationResponseDTO imageNumericProductPresentationResponseDTO = (ImageNumericProductPresentationResponseDTO) other;
        return Intrinsics.areEqual(this.imageUrl, imageNumericProductPresentationResponseDTO.imageUrl) && Intrinsics.areEqual(this.singularLabel, imageNumericProductPresentationResponseDTO.singularLabel) && Intrinsics.areEqual(this.pluralLabel, imageNumericProductPresentationResponseDTO.pluralLabel) && this.inputType == imageNumericProductPresentationResponseDTO.inputType;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Override // dk.molslinjen.api.services.booking.response.product.presentation.ProductPresentationResponseDTO
    public ProductInputTypeResponseDTO getInputType() {
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
        return "ImageNumericProductPresentationResponseDTO(imageUrl=" + this.imageUrl + ", singularLabel=" + this.singularLabel + ", pluralLabel=" + this.pluralLabel + ", inputType=" + this.inputType + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageNumericProductPresentationResponseDTO(String imageUrl, String singularLabel, String pluralLabel, ProductInputTypeResponseDTO inputType) {
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
}
