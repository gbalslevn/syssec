package dk.molslinjen.api.services.booking.response.product.presentation;

import dk.molslinjen.api.services.booking.response.ProductInputTypeResponseDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Ldk/molslinjen/api/services/booking/response/product/presentation/TextProductPresentationResponseDTO;", "Ldk/molslinjen/api/services/booking/response/product/presentation/ProductPresentationResponseDTO;", "inputType", "Ldk/molslinjen/api/services/booking/response/ProductInputTypeResponseDTO;", "<init>", "(Ldk/molslinjen/api/services/booking/response/ProductInputTypeResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/api/services/booking/response/ProductInputTypeResponseDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getInputType", "()Ldk/molslinjen/api/services/booking/response/ProductInputTypeResponseDTO;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class TextProductPresentationResponseDTO extends ProductPresentationResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ProductInputTypeResponseDTO inputType;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/product/presentation/TextProductPresentationResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/product/presentation/TextProductPresentationResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<TextProductPresentationResponseDTO> serializer() {
            return TextProductPresentationResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextProductPresentationResponseDTO(int i5, ProductInputTypeResponseDTO productInputTypeResponseDTO, SerializationConstructorMarker serializationConstructorMarker) {
        super(null);
        if (1 != (i5 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 1, TextProductPresentationResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.inputType = productInputTypeResponseDTO;
    }

    public static /* synthetic */ TextProductPresentationResponseDTO copy$default(TextProductPresentationResponseDTO textProductPresentationResponseDTO, ProductInputTypeResponseDTO productInputTypeResponseDTO, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            productInputTypeResponseDTO = textProductPresentationResponseDTO.inputType;
        }
        return textProductPresentationResponseDTO.copy(productInputTypeResponseDTO);
    }

    /* renamed from: component1, reason: from getter */
    public final ProductInputTypeResponseDTO getInputType() {
        return this.inputType;
    }

    public final TextProductPresentationResponseDTO copy(ProductInputTypeResponseDTO inputType) {
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        return new TextProductPresentationResponseDTO(inputType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TextProductPresentationResponseDTO) && this.inputType == ((TextProductPresentationResponseDTO) other).inputType;
    }

    @Override // dk.molslinjen.api.services.booking.response.product.presentation.ProductPresentationResponseDTO
    public ProductInputTypeResponseDTO getInputType() {
        return this.inputType;
    }

    public int hashCode() {
        return this.inputType.hashCode();
    }

    public String toString() {
        return "TextProductPresentationResponseDTO(inputType=" + this.inputType + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextProductPresentationResponseDTO(ProductInputTypeResponseDTO inputType) {
        super(null);
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        this.inputType = inputType;
    }
}
