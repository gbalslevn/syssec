package dk.molslinjen.api.services.booking.response;

import dk.molslinjen.api.services.booking.response.product.ProductResponseDTO;
import dk.molslinjen.api.services.booking.response.product.ProductResponseDTOSerializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B;\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\tHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006#"}, d2 = {"Ldk/molslinjen/api/services/booking/response/SummaryProductsResponseDTO;", BuildConfig.FLAVOR, "outboundProducts", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/booking/response/product/ProductResponseDTO;", "returnProducts", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOutboundProducts", "()Ljava/util/List;", "getReturnProducts", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class SummaryProductsResponseDTO {
    private static final KSerializer<Object>[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<ProductResponseDTO> outboundProducts;
    private final List<ProductResponseDTO> returnProducts;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/SummaryProductsResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/SummaryProductsResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<SummaryProductsResponseDTO> serializer() {
            return SummaryProductsResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProductResponseDTOSerializer productResponseDTOSerializer = ProductResponseDTOSerializer.INSTANCE;
        $childSerializers = new KSerializer[]{new ArrayListSerializer(productResponseDTOSerializer), new ArrayListSerializer(productResponseDTOSerializer)};
    }

    public /* synthetic */ SummaryProductsResponseDTO(int i5, List list, List list2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, SummaryProductsResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.outboundProducts = list;
        this.returnProducts = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SummaryProductsResponseDTO copy$default(SummaryProductsResponseDTO summaryProductsResponseDTO, List list, List list2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            list = summaryProductsResponseDTO.outboundProducts;
        }
        if ((i5 & 2) != 0) {
            list2 = summaryProductsResponseDTO.returnProducts;
        }
        return summaryProductsResponseDTO.copy(list, list2);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(SummaryProductsResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeNullableSerializableElement(serialDesc, 0, kSerializerArr[0], self.outboundProducts);
        output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.returnProducts);
    }

    public final List<ProductResponseDTO> component1() {
        return this.outboundProducts;
    }

    public final List<ProductResponseDTO> component2() {
        return this.returnProducts;
    }

    public final SummaryProductsResponseDTO copy(List<? extends ProductResponseDTO> outboundProducts, List<? extends ProductResponseDTO> returnProducts) {
        return new SummaryProductsResponseDTO(outboundProducts, returnProducts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SummaryProductsResponseDTO)) {
            return false;
        }
        SummaryProductsResponseDTO summaryProductsResponseDTO = (SummaryProductsResponseDTO) other;
        return Intrinsics.areEqual(this.outboundProducts, summaryProductsResponseDTO.outboundProducts) && Intrinsics.areEqual(this.returnProducts, summaryProductsResponseDTO.returnProducts);
    }

    public final List<ProductResponseDTO> getOutboundProducts() {
        return this.outboundProducts;
    }

    public final List<ProductResponseDTO> getReturnProducts() {
        return this.returnProducts;
    }

    public int hashCode() {
        List<ProductResponseDTO> list = this.outboundProducts;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<ProductResponseDTO> list2 = this.returnProducts;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "SummaryProductsResponseDTO(outboundProducts=" + this.outboundProducts + ", returnProducts=" + this.returnProducts + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SummaryProductsResponseDTO(List<? extends ProductResponseDTO> list, List<? extends ProductResponseDTO> list2) {
        this.outboundProducts = list;
        this.returnProducts = list2;
    }
}
