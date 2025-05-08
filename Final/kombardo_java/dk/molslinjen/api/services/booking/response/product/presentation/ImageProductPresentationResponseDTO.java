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
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Ldk/molslinjen/api/services/booking/response/product/presentation/ImageProductPresentationResponseDTO;", "Ldk/molslinjen/api/services/booking/response/product/presentation/ProductPresentationResponseDTO;", "imageUrl", BuildConfig.FLAVOR, "inputType", "Ldk/molslinjen/api/services/booking/response/ProductInputTypeResponseDTO;", "<init>", "(Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/ProductInputTypeResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldk/molslinjen/api/services/booking/response/ProductInputTypeResponseDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImageUrl", "()Ljava/lang/String;", "getInputType", "()Ldk/molslinjen/api/services/booking/response/ProductInputTypeResponseDTO;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class ImageProductPresentationResponseDTO extends ProductPresentationResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String imageUrl;
    private final ProductInputTypeResponseDTO inputType;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/product/presentation/ImageProductPresentationResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/product/presentation/ImageProductPresentationResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ImageProductPresentationResponseDTO> serializer() {
            return ImageProductPresentationResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageProductPresentationResponseDTO(int i5, String str, ProductInputTypeResponseDTO productInputTypeResponseDTO, SerializationConstructorMarker serializationConstructorMarker) {
        super(null);
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, ImageProductPresentationResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.imageUrl = str;
        this.inputType = productInputTypeResponseDTO;
    }

    public static /* synthetic */ ImageProductPresentationResponseDTO copy$default(ImageProductPresentationResponseDTO imageProductPresentationResponseDTO, String str, ProductInputTypeResponseDTO productInputTypeResponseDTO, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = imageProductPresentationResponseDTO.imageUrl;
        }
        if ((i5 & 2) != 0) {
            productInputTypeResponseDTO = imageProductPresentationResponseDTO.inputType;
        }
        return imageProductPresentationResponseDTO.copy(str, productInputTypeResponseDTO);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(ImageProductPresentationResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.imageUrl);
        output.encodeSerializableElement(serialDesc, 1, ProductInputTypeResponseDTO.Serializer.INSTANCE, self.getInputType());
    }

    /* renamed from: component1, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final ProductInputTypeResponseDTO getInputType() {
        return this.inputType;
    }

    public final ImageProductPresentationResponseDTO copy(String imageUrl, ProductInputTypeResponseDTO inputType) {
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        return new ImageProductPresentationResponseDTO(imageUrl, inputType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageProductPresentationResponseDTO)) {
            return false;
        }
        ImageProductPresentationResponseDTO imageProductPresentationResponseDTO = (ImageProductPresentationResponseDTO) other;
        return Intrinsics.areEqual(this.imageUrl, imageProductPresentationResponseDTO.imageUrl) && this.inputType == imageProductPresentationResponseDTO.inputType;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Override // dk.molslinjen.api.services.booking.response.product.presentation.ProductPresentationResponseDTO
    public ProductInputTypeResponseDTO getInputType() {
        return this.inputType;
    }

    public int hashCode() {
        String str = this.imageUrl;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.inputType.hashCode();
    }

    public String toString() {
        return "ImageProductPresentationResponseDTO(imageUrl=" + this.imageUrl + ", inputType=" + this.inputType + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageProductPresentationResponseDTO(String str, ProductInputTypeResponseDTO inputType) {
        super(null);
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        this.imageUrl = str;
        this.inputType = inputType;
    }
}
