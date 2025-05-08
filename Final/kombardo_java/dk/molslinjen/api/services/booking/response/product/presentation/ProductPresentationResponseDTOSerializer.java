package dk.molslinjen.api.services.booking.response.product.presentation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.JsonContentPolymorphicSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014¨\u0006\t"}, d2 = {"Ldk/molslinjen/api/services/booking/response/product/presentation/ProductPresentationResponseDTOSerializer;", "Lkotlinx/serialization/json/JsonContentPolymorphicSerializer;", "Ldk/molslinjen/api/services/booking/response/product/presentation/ProductPresentationResponseDTO;", "<init>", "()V", "selectDeserializer", "Lkotlinx/serialization/DeserializationStrategy;", "element", "Lkotlinx/serialization/json/JsonElement;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProductPresentationResponseDTOSerializer extends JsonContentPolymorphicSerializer<ProductPresentationResponseDTO> {
    public static final ProductPresentationResponseDTOSerializer INSTANCE = new ProductPresentationResponseDTOSerializer();

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProductPresentationResponseType.values().length];
            try {
                iArr[ProductPresentationResponseType.TextProduct.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProductPresentationResponseType.ImageProduct.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProductPresentationResponseType.ImageNumericProduct.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProductPresentationResponseType.RecommendedProduct.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ProductPresentationResponseDTOSerializer() {
        super(Reflection.getOrCreateKotlinClass(ProductPresentationResponseDTO.class));
    }

    @Override // kotlinx.serialization.json.JsonContentPolymorphicSerializer
    protected DeserializationStrategy<ProductPresentationResponseDTO> selectDeserializer(JsonElement element) {
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter(element, "element");
        JsonElement jsonElement = (JsonElement) JsonElementKt.getJsonObject(element).get((Object) "$type");
        String content = (jsonElement == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? null : jsonPrimitive.getContent();
        ProductPresentationResponseType invoke = ProductPresentationResponseType.INSTANCE.invoke(content);
        int i5 = invoke == null ? -1 : WhenMappings.$EnumSwitchMapping$0[invoke.ordinal()];
        if (i5 == 1) {
            return TextProductPresentationResponseDTO.INSTANCE.serializer();
        }
        if (i5 == 2) {
            return ImageProductPresentationResponseDTO.INSTANCE.serializer();
        }
        if (i5 == 3) {
            return ImageNumericProductPresentationResponseDTO.INSTANCE.serializer();
        }
        if (i5 == 4) {
            return ImageProductPresentationResponseDTO.INSTANCE.serializer();
        }
        throw new IllegalArgumentException("Unknown type: " + content);
    }
}
