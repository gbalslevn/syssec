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

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0003&'(B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nB=\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\fHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, d2 = {"Ldk/molslinjen/api/services/booking/response/TransportProductsResponseDTO;", BuildConfig.FLAVOR, "goods", "Ldk/molslinjen/api/services/booking/response/TransportProductsResponseDTO$GoodsResponseDTO;", "isNotesAvailable", BuildConfig.FLAVOR, "products", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/booking/response/product/ProductResponseDTO;", "<init>", "(Ldk/molslinjen/api/services/booking/response/TransportProductsResponseDTO$GoodsResponseDTO;ZLjava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/api/services/booking/response/TransportProductsResponseDTO$GoodsResponseDTO;ZLjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGoods", "()Ldk/molslinjen/api/services/booking/response/TransportProductsResponseDTO$GoodsResponseDTO;", "()Z", "getProducts", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "GoodsResponseDTO", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class TransportProductsResponseDTO {
    private final GoodsResponseDTO goods;
    private final boolean isNotesAvailable;
    private final List<ProductResponseDTO> products;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(ProductResponseDTOSerializer.INSTANCE)};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/TransportProductsResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/TransportProductsResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<TransportProductsResponseDTO> serializer() {
            return TransportProductsResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B+\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\tHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Ldk/molslinjen/api/services/booking/response/TransportProductsResponseDTO$GoodsResponseDTO;", BuildConfig.FLAVOR, "isWeightRequired", BuildConfig.FLAVOR, "maxWeight", BuildConfig.FLAVOR, "<init>", "(ZD)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "()Z", "getMaxWeight", "()D", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class GoodsResponseDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean isWeightRequired;
        private final double maxWeight;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/TransportProductsResponseDTO$GoodsResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/TransportProductsResponseDTO$GoodsResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<GoodsResponseDTO> serializer() {
                return TransportProductsResponseDTO$GoodsResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ GoodsResponseDTO(int i5, boolean z5, double d5, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i5 & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 3, TransportProductsResponseDTO$GoodsResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.isWeightRequired = z5;
            this.maxWeight = d5;
        }

        public static /* synthetic */ GoodsResponseDTO copy$default(GoodsResponseDTO goodsResponseDTO, boolean z5, double d5, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = goodsResponseDTO.isWeightRequired;
            }
            if ((i5 & 2) != 0) {
                d5 = goodsResponseDTO.maxWeight;
            }
            return goodsResponseDTO.copy(z5, d5);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(GoodsResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeBooleanElement(serialDesc, 0, self.isWeightRequired);
            output.encodeDoubleElement(serialDesc, 1, self.maxWeight);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsWeightRequired() {
            return this.isWeightRequired;
        }

        /* renamed from: component2, reason: from getter */
        public final double getMaxWeight() {
            return this.maxWeight;
        }

        public final GoodsResponseDTO copy(boolean isWeightRequired, double maxWeight) {
            return new GoodsResponseDTO(isWeightRequired, maxWeight);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GoodsResponseDTO)) {
                return false;
            }
            GoodsResponseDTO goodsResponseDTO = (GoodsResponseDTO) other;
            return this.isWeightRequired == goodsResponseDTO.isWeightRequired && Double.compare(this.maxWeight, goodsResponseDTO.maxWeight) == 0;
        }

        public final double getMaxWeight() {
            return this.maxWeight;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.isWeightRequired) * 31) + Double.hashCode(this.maxWeight);
        }

        public final boolean isWeightRequired() {
            return this.isWeightRequired;
        }

        public String toString() {
            return "GoodsResponseDTO(isWeightRequired=" + this.isWeightRequired + ", maxWeight=" + this.maxWeight + ")";
        }

        public GoodsResponseDTO(boolean z5, double d5) {
            this.isWeightRequired = z5;
            this.maxWeight = d5;
        }
    }

    public /* synthetic */ TransportProductsResponseDTO(int i5, GoodsResponseDTO goodsResponseDTO, boolean z5, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, TransportProductsResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.goods = goodsResponseDTO;
        this.isNotesAvailable = z5;
        this.products = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TransportProductsResponseDTO copy$default(TransportProductsResponseDTO transportProductsResponseDTO, GoodsResponseDTO goodsResponseDTO, boolean z5, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            goodsResponseDTO = transportProductsResponseDTO.goods;
        }
        if ((i5 & 2) != 0) {
            z5 = transportProductsResponseDTO.isNotesAvailable;
        }
        if ((i5 & 4) != 0) {
            list = transportProductsResponseDTO.products;
        }
        return transportProductsResponseDTO.copy(goodsResponseDTO, z5, list);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(TransportProductsResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, TransportProductsResponseDTO$GoodsResponseDTO$$serializer.INSTANCE, self.goods);
        output.encodeBooleanElement(serialDesc, 1, self.isNotesAvailable);
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.products);
    }

    /* renamed from: component1, reason: from getter */
    public final GoodsResponseDTO getGoods() {
        return this.goods;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsNotesAvailable() {
        return this.isNotesAvailable;
    }

    public final List<ProductResponseDTO> component3() {
        return this.products;
    }

    public final TransportProductsResponseDTO copy(GoodsResponseDTO goods, boolean isNotesAvailable, List<? extends ProductResponseDTO> products) {
        Intrinsics.checkNotNullParameter(goods, "goods");
        Intrinsics.checkNotNullParameter(products, "products");
        return new TransportProductsResponseDTO(goods, isNotesAvailable, products);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransportProductsResponseDTO)) {
            return false;
        }
        TransportProductsResponseDTO transportProductsResponseDTO = (TransportProductsResponseDTO) other;
        return Intrinsics.areEqual(this.goods, transportProductsResponseDTO.goods) && this.isNotesAvailable == transportProductsResponseDTO.isNotesAvailable && Intrinsics.areEqual(this.products, transportProductsResponseDTO.products);
    }

    public final GoodsResponseDTO getGoods() {
        return this.goods;
    }

    public final List<ProductResponseDTO> getProducts() {
        return this.products;
    }

    public int hashCode() {
        return (((this.goods.hashCode() * 31) + Boolean.hashCode(this.isNotesAvailable)) * 31) + this.products.hashCode();
    }

    public final boolean isNotesAvailable() {
        return this.isNotesAvailable;
    }

    public String toString() {
        return "TransportProductsResponseDTO(goods=" + this.goods + ", isNotesAvailable=" + this.isNotesAvailable + ", products=" + this.products + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TransportProductsResponseDTO(GoodsResponseDTO goods, boolean z5, List<? extends ProductResponseDTO> products) {
        Intrinsics.checkNotNullParameter(goods, "goods");
        Intrinsics.checkNotNullParameter(products, "products");
        this.goods = goods;
        this.isNotesAvailable = z5;
        this.products = products;
    }
}
