package dk.molslinjen.api.services.saleOnBoard.response;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.domain.model.constants.Constants;
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
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u000b\u001e\u001f !\"#$%&'(B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\bHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006)"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO;", BuildConfig.FLAVOR, "stores", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$StoreResponseDTO;", "<init>", "(Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getStores", "()Ljava/util/List;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "StoreResponseDTO", "CategoryResponseDTO", "SaleOnBoardProductResponseDTO", "SaleOnBoardProductAddOnResponseDTO", "SaleOnBoardCrossSalesResponseDTO", "VariantsResponseDTO", "SaleOnBoardProductAddOnSelectionResponseDTO", "SaleOnBoardCrossSaleProductResponseDTO", "VariantResponseDTO", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class ShopAndProductsResponseDTO {
    private final List<StoreResponseDTO> stores;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(ShopAndProductsResponseDTO$StoreResponseDTO$$serializer.INSTANCE)};

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bBS\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003JA\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\rHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006-"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$CategoryResponseDTO;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "code", "iconType", "name", "products", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardProductResponseDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getCode", "getIconType", "getName", "getProducts", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class CategoryResponseDTO {
        private final String code;
        private final String iconType;
        private final String id;
        private final String name;
        private final List<SaleOnBoardProductResponseDTO> products;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, new ArrayListSerializer(ShopAndProductsResponseDTO$SaleOnBoardProductResponseDTO$$serializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$CategoryResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$CategoryResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<CategoryResponseDTO> serializer() {
                return ShopAndProductsResponseDTO$CategoryResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ CategoryResponseDTO(int i5, String str, String str2, String str3, String str4, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (31 != (i5 & 31)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 31, ShopAndProductsResponseDTO$CategoryResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.code = str2;
            this.iconType = str3;
            this.name = str4;
            this.products = list;
        }

        public static /* synthetic */ CategoryResponseDTO copy$default(CategoryResponseDTO categoryResponseDTO, String str, String str2, String str3, String str4, List list, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = categoryResponseDTO.id;
            }
            if ((i5 & 2) != 0) {
                str2 = categoryResponseDTO.code;
            }
            String str5 = str2;
            if ((i5 & 4) != 0) {
                str3 = categoryResponseDTO.iconType;
            }
            String str6 = str3;
            if ((i5 & 8) != 0) {
                str4 = categoryResponseDTO.name;
            }
            String str7 = str4;
            if ((i5 & 16) != 0) {
                list = categoryResponseDTO.products;
            }
            return categoryResponseDTO.copy(str, str5, str6, str7, list);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(CategoryResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeStringElement(serialDesc, 1, self.code);
            output.encodeStringElement(serialDesc, 2, self.iconType);
            output.encodeStringElement(serialDesc, 3, self.name);
            output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.products);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        /* renamed from: component3, reason: from getter */
        public final String getIconType() {
            return this.iconType;
        }

        /* renamed from: component4, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final List<SaleOnBoardProductResponseDTO> component5() {
            return this.products;
        }

        public final CategoryResponseDTO copy(String id, String code, String iconType, String name, List<SaleOnBoardProductResponseDTO> products) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(iconType, "iconType");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(products, "products");
            return new CategoryResponseDTO(id, code, iconType, name, products);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CategoryResponseDTO)) {
                return false;
            }
            CategoryResponseDTO categoryResponseDTO = (CategoryResponseDTO) other;
            return Intrinsics.areEqual(this.id, categoryResponseDTO.id) && Intrinsics.areEqual(this.code, categoryResponseDTO.code) && Intrinsics.areEqual(this.iconType, categoryResponseDTO.iconType) && Intrinsics.areEqual(this.name, categoryResponseDTO.name) && Intrinsics.areEqual(this.products, categoryResponseDTO.products);
        }

        public final String getCode() {
            return this.code;
        }

        public final String getIconType() {
            return this.iconType;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final List<SaleOnBoardProductResponseDTO> getProducts() {
            return this.products;
        }

        public int hashCode() {
            return (((((((this.id.hashCode() * 31) + this.code.hashCode()) * 31) + this.iconType.hashCode()) * 31) + this.name.hashCode()) * 31) + this.products.hashCode();
        }

        public String toString() {
            return "CategoryResponseDTO(id=" + this.id + ", code=" + this.code + ", iconType=" + this.iconType + ", name=" + this.name + ", products=" + this.products + ")";
        }

        public CategoryResponseDTO(String id, String code, String iconType, String name, List<SaleOnBoardProductResponseDTO> products) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(iconType, "iconType");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(products, "products");
            this.id = id;
            this.code = code;
            this.iconType = iconType;
            this.name = name;
            this.products = products;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ShopAndProductsResponseDTO> serializer() {
            return ShopAndProductsResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nBG\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J9\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\fHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0011R$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006."}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardCrossSaleProductResponseDTO;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "extendedTexts", BuildConfig.FLAVOR, "price", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;D)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;DLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName$annotations", "()V", "getName", "getExtendedTexts$annotations", "getExtendedTexts", "()Ljava/util/List;", "getPrice", "()D", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class SaleOnBoardCrossSaleProductResponseDTO {
        private final List<String> extendedTexts;
        private final String id;
        private final String name;
        private final double price;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(StringSerializer.INSTANCE), null};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardCrossSaleProductResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardCrossSaleProductResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<SaleOnBoardCrossSaleProductResponseDTO> serializer() {
                return ShopAndProductsResponseDTO$SaleOnBoardCrossSaleProductResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ SaleOnBoardCrossSaleProductResponseDTO(int i5, String str, String str2, List list, double d5, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i5 & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 15, ShopAndProductsResponseDTO$SaleOnBoardCrossSaleProductResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.name = str2;
            this.extendedTexts = list;
            this.price = d5;
        }

        public static /* synthetic */ SaleOnBoardCrossSaleProductResponseDTO copy$default(SaleOnBoardCrossSaleProductResponseDTO saleOnBoardCrossSaleProductResponseDTO, String str, String str2, List list, double d5, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = saleOnBoardCrossSaleProductResponseDTO.id;
            }
            if ((i5 & 2) != 0) {
                str2 = saleOnBoardCrossSaleProductResponseDTO.name;
            }
            String str3 = str2;
            if ((i5 & 4) != 0) {
                list = saleOnBoardCrossSaleProductResponseDTO.extendedTexts;
            }
            List list2 = list;
            if ((i5 & 8) != 0) {
                d5 = saleOnBoardCrossSaleProductResponseDTO.price;
            }
            return saleOnBoardCrossSaleProductResponseDTO.copy(str, str3, list2, d5);
        }

        public static /* synthetic */ void getExtendedTexts$annotations() {
        }

        public static /* synthetic */ void getName$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(SaleOnBoardCrossSaleProductResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeStringElement(serialDesc, 1, self.name);
            output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.extendedTexts);
            output.encodeDoubleElement(serialDesc, 3, self.price);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final List<String> component3() {
            return this.extendedTexts;
        }

        /* renamed from: component4, reason: from getter */
        public final double getPrice() {
            return this.price;
        }

        public final SaleOnBoardCrossSaleProductResponseDTO copy(String id, String name, List<String> extendedTexts, double price) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            return new SaleOnBoardCrossSaleProductResponseDTO(id, name, extendedTexts, price);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SaleOnBoardCrossSaleProductResponseDTO)) {
                return false;
            }
            SaleOnBoardCrossSaleProductResponseDTO saleOnBoardCrossSaleProductResponseDTO = (SaleOnBoardCrossSaleProductResponseDTO) other;
            return Intrinsics.areEqual(this.id, saleOnBoardCrossSaleProductResponseDTO.id) && Intrinsics.areEqual(this.name, saleOnBoardCrossSaleProductResponseDTO.name) && Intrinsics.areEqual(this.extendedTexts, saleOnBoardCrossSaleProductResponseDTO.extendedTexts) && Double.compare(this.price, saleOnBoardCrossSaleProductResponseDTO.price) == 0;
        }

        public final List<String> getExtendedTexts() {
            return this.extendedTexts;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final double getPrice() {
            return this.price;
        }

        public int hashCode() {
            int hashCode = ((this.id.hashCode() * 31) + this.name.hashCode()) * 31;
            List<String> list = this.extendedTexts;
            return ((hashCode + (list == null ? 0 : list.hashCode())) * 31) + Double.hashCode(this.price);
        }

        public String toString() {
            return "SaleOnBoardCrossSaleProductResponseDTO(id=" + this.id + ", name=" + this.name + ", extendedTexts=" + this.extendedTexts + ", price=" + this.price + ")";
        }

        public SaleOnBoardCrossSaleProductResponseDTO(String id, String name, List<String> list, double d5) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            this.id = id;
            this.name = name;
            this.extendedTexts = list;
            this.price = d5;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB?\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J-\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0014¨\u0006*"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardCrossSalesResponseDTO;", BuildConfig.FLAVOR, "crossSaleProducts", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardCrossSaleProductResponseDTO;", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCrossSaleProducts$annotations", "()V", "getCrossSaleProducts", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getTitle$annotations", "getTitle", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class SaleOnBoardCrossSalesResponseDTO {
        private final List<SaleOnBoardCrossSaleProductResponseDTO> crossSaleProducts;
        private final String id;
        private final String title;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(ShopAndProductsResponseDTO$SaleOnBoardCrossSaleProductResponseDTO$$serializer.INSTANCE), null, null};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardCrossSalesResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardCrossSalesResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<SaleOnBoardCrossSalesResponseDTO> serializer() {
                return ShopAndProductsResponseDTO$SaleOnBoardCrossSalesResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ SaleOnBoardCrossSalesResponseDTO(int i5, List list, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, ShopAndProductsResponseDTO$SaleOnBoardCrossSalesResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.crossSaleProducts = list;
            this.id = str;
            this.title = str2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SaleOnBoardCrossSalesResponseDTO copy$default(SaleOnBoardCrossSalesResponseDTO saleOnBoardCrossSalesResponseDTO, List list, String str, String str2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                list = saleOnBoardCrossSalesResponseDTO.crossSaleProducts;
            }
            if ((i5 & 2) != 0) {
                str = saleOnBoardCrossSalesResponseDTO.id;
            }
            if ((i5 & 4) != 0) {
                str2 = saleOnBoardCrossSalesResponseDTO.title;
            }
            return saleOnBoardCrossSalesResponseDTO.copy(list, str, str2);
        }

        public static /* synthetic */ void getCrossSaleProducts$annotations() {
        }

        public static /* synthetic */ void getTitle$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(SaleOnBoardCrossSalesResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.crossSaleProducts);
            output.encodeStringElement(serialDesc, 1, self.id);
            output.encodeStringElement(serialDesc, 2, self.title);
        }

        public final List<SaleOnBoardCrossSaleProductResponseDTO> component1() {
            return this.crossSaleProducts;
        }

        /* renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final SaleOnBoardCrossSalesResponseDTO copy(List<SaleOnBoardCrossSaleProductResponseDTO> crossSaleProducts, String id, String title) {
            Intrinsics.checkNotNullParameter(crossSaleProducts, "crossSaleProducts");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            return new SaleOnBoardCrossSalesResponseDTO(crossSaleProducts, id, title);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SaleOnBoardCrossSalesResponseDTO)) {
                return false;
            }
            SaleOnBoardCrossSalesResponseDTO saleOnBoardCrossSalesResponseDTO = (SaleOnBoardCrossSalesResponseDTO) other;
            return Intrinsics.areEqual(this.crossSaleProducts, saleOnBoardCrossSalesResponseDTO.crossSaleProducts) && Intrinsics.areEqual(this.id, saleOnBoardCrossSalesResponseDTO.id) && Intrinsics.areEqual(this.title, saleOnBoardCrossSalesResponseDTO.title);
        }

        public final List<SaleOnBoardCrossSaleProductResponseDTO> getCrossSaleProducts() {
            return this.crossSaleProducts;
        }

        public final String getId() {
            return this.id;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((this.crossSaleProducts.hashCode() * 31) + this.id.hashCode()) * 31) + this.title.hashCode();
        }

        public String toString() {
            return "SaleOnBoardCrossSalesResponseDTO(crossSaleProducts=" + this.crossSaleProducts + ", id=" + this.id + ", title=" + this.title + ")";
        }

        public SaleOnBoardCrossSalesResponseDTO(List<SaleOnBoardCrossSaleProductResponseDTO> crossSaleProducts, String id, String title) {
            Intrinsics.checkNotNullParameter(crossSaleProducts, "crossSaleProducts");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            this.crossSaleProducts = crossSaleProducts;
            this.id = id;
            this.title = title;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardProductAddOnResponseDTO;", BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, BuildConfig.FLAVOR, "selections", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardProductAddOnSelectionResponseDTO;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle$annotations", "()V", "getTitle", "()Ljava/lang/String;", "getSelections", "()Ljava/util/List;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class SaleOnBoardProductAddOnResponseDTO {
        private final List<SaleOnBoardProductAddOnSelectionResponseDTO> selections;
        private final String title;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(ShopAndProductsResponseDTO$SaleOnBoardProductAddOnSelectionResponseDTO$$serializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardProductAddOnResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardProductAddOnResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<SaleOnBoardProductAddOnResponseDTO> serializer() {
                return ShopAndProductsResponseDTO$SaleOnBoardProductAddOnResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ SaleOnBoardProductAddOnResponseDTO(int i5, String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i5 & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 3, ShopAndProductsResponseDTO$SaleOnBoardProductAddOnResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.title = str;
            this.selections = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SaleOnBoardProductAddOnResponseDTO copy$default(SaleOnBoardProductAddOnResponseDTO saleOnBoardProductAddOnResponseDTO, String str, List list, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = saleOnBoardProductAddOnResponseDTO.title;
            }
            if ((i5 & 2) != 0) {
                list = saleOnBoardProductAddOnResponseDTO.selections;
            }
            return saleOnBoardProductAddOnResponseDTO.copy(str, list);
        }

        public static /* synthetic */ void getTitle$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(SaleOnBoardProductAddOnResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.title);
            output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.selections);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final List<SaleOnBoardProductAddOnSelectionResponseDTO> component2() {
            return this.selections;
        }

        public final SaleOnBoardProductAddOnResponseDTO copy(String title, List<SaleOnBoardProductAddOnSelectionResponseDTO> selections) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(selections, "selections");
            return new SaleOnBoardProductAddOnResponseDTO(title, selections);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SaleOnBoardProductAddOnResponseDTO)) {
                return false;
            }
            SaleOnBoardProductAddOnResponseDTO saleOnBoardProductAddOnResponseDTO = (SaleOnBoardProductAddOnResponseDTO) other;
            return Intrinsics.areEqual(this.title, saleOnBoardProductAddOnResponseDTO.title) && Intrinsics.areEqual(this.selections, saleOnBoardProductAddOnResponseDTO.selections);
        }

        public final List<SaleOnBoardProductAddOnSelectionResponseDTO> getSelections() {
            return this.selections;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (this.title.hashCode() * 31) + this.selections.hashCode();
        }

        public String toString() {
            return "SaleOnBoardProductAddOnResponseDTO(title=" + this.title + ", selections=" + this.selections + ")";
        }

        public SaleOnBoardProductAddOnResponseDTO(String title, List<SaleOnBoardProductAddOnSelectionResponseDTO> selections) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(selections, "selections");
            this.title = title;
            this.selections = selections;
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bBQ\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003JC\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\rHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001¢\u0006\u0002\b/R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0012R$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u00062"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardProductAddOnSelectionResponseDTO;", BuildConfig.FLAVOR, com.sdk.growthbook.utils.Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "extendedTexts", BuildConfig.FLAVOR, "itemNumber", "price", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;D)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;DLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName$annotations", "()V", "getName", "getExtendedTexts$annotations", "getExtendedTexts", "()Ljava/util/List;", "getItemNumber$annotations", "getItemNumber", "getPrice", "()D", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class SaleOnBoardProductAddOnSelectionResponseDTO {
        private final List<String> extendedTexts;
        private final String id;
        private final String itemNumber;
        private final String name;
        private final double price;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(StringSerializer.INSTANCE), null, null};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardProductAddOnSelectionResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardProductAddOnSelectionResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<SaleOnBoardProductAddOnSelectionResponseDTO> serializer() {
                return ShopAndProductsResponseDTO$SaleOnBoardProductAddOnSelectionResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ SaleOnBoardProductAddOnSelectionResponseDTO(int i5, String str, String str2, List list, String str3, double d5, SerializationConstructorMarker serializationConstructorMarker) {
            if (31 != (i5 & 31)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 31, ShopAndProductsResponseDTO$SaleOnBoardProductAddOnSelectionResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.name = str2;
            this.extendedTexts = list;
            this.itemNumber = str3;
            this.price = d5;
        }

        public static /* synthetic */ SaleOnBoardProductAddOnSelectionResponseDTO copy$default(SaleOnBoardProductAddOnSelectionResponseDTO saleOnBoardProductAddOnSelectionResponseDTO, String str, String str2, List list, String str3, double d5, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = saleOnBoardProductAddOnSelectionResponseDTO.id;
            }
            if ((i5 & 2) != 0) {
                str2 = saleOnBoardProductAddOnSelectionResponseDTO.name;
            }
            String str4 = str2;
            if ((i5 & 4) != 0) {
                list = saleOnBoardProductAddOnSelectionResponseDTO.extendedTexts;
            }
            List list2 = list;
            if ((i5 & 8) != 0) {
                str3 = saleOnBoardProductAddOnSelectionResponseDTO.itemNumber;
            }
            String str5 = str3;
            if ((i5 & 16) != 0) {
                d5 = saleOnBoardProductAddOnSelectionResponseDTO.price;
            }
            return saleOnBoardProductAddOnSelectionResponseDTO.copy(str, str4, list2, str5, d5);
        }

        public static /* synthetic */ void getExtendedTexts$annotations() {
        }

        public static /* synthetic */ void getItemNumber$annotations() {
        }

        public static /* synthetic */ void getName$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(SaleOnBoardProductAddOnSelectionResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeStringElement(serialDesc, 1, self.name);
            output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.extendedTexts);
            output.encodeStringElement(serialDesc, 3, self.itemNumber);
            output.encodeDoubleElement(serialDesc, 4, self.price);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final List<String> component3() {
            return this.extendedTexts;
        }

        /* renamed from: component4, reason: from getter */
        public final String getItemNumber() {
            return this.itemNumber;
        }

        /* renamed from: component5, reason: from getter */
        public final double getPrice() {
            return this.price;
        }

        public final SaleOnBoardProductAddOnSelectionResponseDTO copy(String id, String name, List<String> extendedTexts, String itemNumber, double price) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(itemNumber, "itemNumber");
            return new SaleOnBoardProductAddOnSelectionResponseDTO(id, name, extendedTexts, itemNumber, price);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SaleOnBoardProductAddOnSelectionResponseDTO)) {
                return false;
            }
            SaleOnBoardProductAddOnSelectionResponseDTO saleOnBoardProductAddOnSelectionResponseDTO = (SaleOnBoardProductAddOnSelectionResponseDTO) other;
            return Intrinsics.areEqual(this.id, saleOnBoardProductAddOnSelectionResponseDTO.id) && Intrinsics.areEqual(this.name, saleOnBoardProductAddOnSelectionResponseDTO.name) && Intrinsics.areEqual(this.extendedTexts, saleOnBoardProductAddOnSelectionResponseDTO.extendedTexts) && Intrinsics.areEqual(this.itemNumber, saleOnBoardProductAddOnSelectionResponseDTO.itemNumber) && Double.compare(this.price, saleOnBoardProductAddOnSelectionResponseDTO.price) == 0;
        }

        public final List<String> getExtendedTexts() {
            return this.extendedTexts;
        }

        public final String getId() {
            return this.id;
        }

        public final String getItemNumber() {
            return this.itemNumber;
        }

        public final String getName() {
            return this.name;
        }

        public final double getPrice() {
            return this.price;
        }

        public int hashCode() {
            int hashCode = ((this.id.hashCode() * 31) + this.name.hashCode()) * 31;
            List<String> list = this.extendedTexts;
            return ((((hashCode + (list == null ? 0 : list.hashCode())) * 31) + this.itemNumber.hashCode()) * 31) + Double.hashCode(this.price);
        }

        public String toString() {
            return "SaleOnBoardProductAddOnSelectionResponseDTO(id=" + this.id + ", name=" + this.name + ", extendedTexts=" + this.extendedTexts + ", itemNumber=" + this.itemNumber + ", price=" + this.price + ")";
        }

        public SaleOnBoardProductAddOnSelectionResponseDTO(String id, String name, List<String> list, String itemNumber, double d5) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(itemNumber, "itemNumber");
            this.id = id;
            this.name = name;
            this.extendedTexts = list;
            this.itemNumber = itemNumber;
            this.price = d5;
        }
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 D2\u00020\u0001:\u0002CDBe\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012B\u007f\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0011\u0010\u0017J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u00103\u001a\u00020\u000fHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jy\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0014HÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001J%\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0001¢\u0006\u0002\bBR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u0019R$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001bR\u001c\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\u0019R\u001e\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001d\u001a\u0004\b'\u0010(R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019¨\u0006E"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardProductResponseDTO;", BuildConfig.FLAVOR, com.sdk.growthbook.utils.Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "addOn", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardProductAddOnResponseDTO;", "crossSale", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardCrossSalesResponseDTO;", "name", "extendedTexts", "itemNumber", "variants", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$VariantsResponseDTO;", "price", BuildConfig.FLAVOR, "imageUrl", "<init>", "(Ljava/lang/String;Ljava/util/List;Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardCrossSalesResponseDTO;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$VariantsResponseDTO;DLjava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardCrossSalesResponseDTO;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$VariantsResponseDTO;DLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getAddOn", "()Ljava/util/List;", "getCrossSale$annotations", "()V", "getCrossSale", "()Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardCrossSalesResponseDTO;", "getName$annotations", "getName", "getExtendedTexts$annotations", "getExtendedTexts", "getItemNumber$annotations", "getItemNumber", "getVariants$annotations", "getVariants", "()Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$VariantsResponseDTO;", "getPrice", "()D", "getImageUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class SaleOnBoardProductResponseDTO {
        private final List<SaleOnBoardProductAddOnResponseDTO> addOn;
        private final SaleOnBoardCrossSalesResponseDTO crossSale;
        private final List<String> extendedTexts;
        private final String id;
        private final String imageUrl;
        private final String itemNumber;
        private final String name;
        private final double price;
        private final VariantsResponseDTO variants;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(ShopAndProductsResponseDTO$SaleOnBoardProductAddOnResponseDTO$$serializer.INSTANCE), null, null, new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null, null};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardProductResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardProductResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<SaleOnBoardProductResponseDTO> serializer() {
                return ShopAndProductsResponseDTO$SaleOnBoardProductResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ SaleOnBoardProductResponseDTO(int i5, String str, List list, SaleOnBoardCrossSalesResponseDTO saleOnBoardCrossSalesResponseDTO, String str2, List list2, String str3, VariantsResponseDTO variantsResponseDTO, double d5, String str4, SerializationConstructorMarker serializationConstructorMarker) {
            if (511 != (i5 & 511)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 511, ShopAndProductsResponseDTO$SaleOnBoardProductResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.addOn = list;
            this.crossSale = saleOnBoardCrossSalesResponseDTO;
            this.name = str2;
            this.extendedTexts = list2;
            this.itemNumber = str3;
            this.variants = variantsResponseDTO;
            this.price = d5;
            this.imageUrl = str4;
        }

        public static /* synthetic */ void getCrossSale$annotations() {
        }

        public static /* synthetic */ void getExtendedTexts$annotations() {
        }

        public static /* synthetic */ void getItemNumber$annotations() {
        }

        public static /* synthetic */ void getName$annotations() {
        }

        public static /* synthetic */ void getVariants$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(SaleOnBoardProductResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.addOn);
            output.encodeNullableSerializableElement(serialDesc, 2, ShopAndProductsResponseDTO$SaleOnBoardCrossSalesResponseDTO$$serializer.INSTANCE, self.crossSale);
            output.encodeStringElement(serialDesc, 3, self.name);
            output.encodeNullableSerializableElement(serialDesc, 4, kSerializerArr[4], self.extendedTexts);
            output.encodeStringElement(serialDesc, 5, self.itemNumber);
            output.encodeNullableSerializableElement(serialDesc, 6, ShopAndProductsResponseDTO$VariantsResponseDTO$$serializer.INSTANCE, self.variants);
            output.encodeDoubleElement(serialDesc, 7, self.price);
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.imageUrl);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final List<SaleOnBoardProductAddOnResponseDTO> component2() {
            return this.addOn;
        }

        /* renamed from: component3, reason: from getter */
        public final SaleOnBoardCrossSalesResponseDTO getCrossSale() {
            return this.crossSale;
        }

        /* renamed from: component4, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final List<String> component5() {
            return this.extendedTexts;
        }

        /* renamed from: component6, reason: from getter */
        public final String getItemNumber() {
            return this.itemNumber;
        }

        /* renamed from: component7, reason: from getter */
        public final VariantsResponseDTO getVariants() {
            return this.variants;
        }

        /* renamed from: component8, reason: from getter */
        public final double getPrice() {
            return this.price;
        }

        /* renamed from: component9, reason: from getter */
        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final SaleOnBoardProductResponseDTO copy(String id, List<SaleOnBoardProductAddOnResponseDTO> addOn, SaleOnBoardCrossSalesResponseDTO crossSale, String name, List<String> extendedTexts, String itemNumber, VariantsResponseDTO variants, double price, String imageUrl) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(itemNumber, "itemNumber");
            return new SaleOnBoardProductResponseDTO(id, addOn, crossSale, name, extendedTexts, itemNumber, variants, price, imageUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SaleOnBoardProductResponseDTO)) {
                return false;
            }
            SaleOnBoardProductResponseDTO saleOnBoardProductResponseDTO = (SaleOnBoardProductResponseDTO) other;
            return Intrinsics.areEqual(this.id, saleOnBoardProductResponseDTO.id) && Intrinsics.areEqual(this.addOn, saleOnBoardProductResponseDTO.addOn) && Intrinsics.areEqual(this.crossSale, saleOnBoardProductResponseDTO.crossSale) && Intrinsics.areEqual(this.name, saleOnBoardProductResponseDTO.name) && Intrinsics.areEqual(this.extendedTexts, saleOnBoardProductResponseDTO.extendedTexts) && Intrinsics.areEqual(this.itemNumber, saleOnBoardProductResponseDTO.itemNumber) && Intrinsics.areEqual(this.variants, saleOnBoardProductResponseDTO.variants) && Double.compare(this.price, saleOnBoardProductResponseDTO.price) == 0 && Intrinsics.areEqual(this.imageUrl, saleOnBoardProductResponseDTO.imageUrl);
        }

        public final List<SaleOnBoardProductAddOnResponseDTO> getAddOn() {
            return this.addOn;
        }

        public final SaleOnBoardCrossSalesResponseDTO getCrossSale() {
            return this.crossSale;
        }

        public final List<String> getExtendedTexts() {
            return this.extendedTexts;
        }

        public final String getId() {
            return this.id;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final String getItemNumber() {
            return this.itemNumber;
        }

        public final String getName() {
            return this.name;
        }

        public final double getPrice() {
            return this.price;
        }

        public final VariantsResponseDTO getVariants() {
            return this.variants;
        }

        public int hashCode() {
            int hashCode = this.id.hashCode() * 31;
            List<SaleOnBoardProductAddOnResponseDTO> list = this.addOn;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            SaleOnBoardCrossSalesResponseDTO saleOnBoardCrossSalesResponseDTO = this.crossSale;
            int hashCode3 = (((hashCode2 + (saleOnBoardCrossSalesResponseDTO == null ? 0 : saleOnBoardCrossSalesResponseDTO.hashCode())) * 31) + this.name.hashCode()) * 31;
            List<String> list2 = this.extendedTexts;
            int hashCode4 = (((hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31) + this.itemNumber.hashCode()) * 31;
            VariantsResponseDTO variantsResponseDTO = this.variants;
            int hashCode5 = (((hashCode4 + (variantsResponseDTO == null ? 0 : variantsResponseDTO.hashCode())) * 31) + Double.hashCode(this.price)) * 31;
            String str = this.imageUrl;
            return hashCode5 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "SaleOnBoardProductResponseDTO(id=" + this.id + ", addOn=" + this.addOn + ", crossSale=" + this.crossSale + ", name=" + this.name + ", extendedTexts=" + this.extendedTexts + ", itemNumber=" + this.itemNumber + ", variants=" + this.variants + ", price=" + this.price + ", imageUrl=" + this.imageUrl + ")";
        }

        public SaleOnBoardProductResponseDTO(String id, List<SaleOnBoardProductAddOnResponseDTO> list, SaleOnBoardCrossSalesResponseDTO saleOnBoardCrossSalesResponseDTO, String name, List<String> list2, String itemNumber, VariantsResponseDTO variantsResponseDTO, double d5, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(itemNumber, "itemNumber");
            this.id = id;
            this.addOn = list;
            this.crossSale = saleOnBoardCrossSalesResponseDTO;
            this.name = name;
            this.extendedTexts = list2;
            this.itemNumber = itemNumber;
            this.variants = variantsResponseDTO;
            this.price = d5;
            this.imageUrl = str;
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u00029:BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fB{\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000e\u0010\u0014J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jk\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0011HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001J%\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016¨\u0006;"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$StoreResponseDTO;", BuildConfig.FLAVOR, com.sdk.growthbook.utils.Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "storeLocation", "storeName", "storeNumber", "categories", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$CategoryResponseDTO;", "bannerImageUrl", "squareImageUrl", "wideImageUrl", "storeLogoImageUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getStoreLocation", "getStoreName", "getStoreNumber$annotations", "()V", "getStoreNumber", "getCategories", "()Ljava/util/List;", "getBannerImageUrl", "getSquareImageUrl", "getWideImageUrl", "getStoreLogoImageUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class StoreResponseDTO {
        private final String bannerImageUrl;
        private final List<CategoryResponseDTO> categories;
        private final String id;
        private final String squareImageUrl;
        private final String storeLocation;
        private final String storeLogoImageUrl;
        private final String storeName;
        private final String storeNumber;
        private final String wideImageUrl;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, new ArrayListSerializer(ShopAndProductsResponseDTO$CategoryResponseDTO$$serializer.INSTANCE), null, null, null, null};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$StoreResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$StoreResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<StoreResponseDTO> serializer() {
                return ShopAndProductsResponseDTO$StoreResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ StoreResponseDTO(int i5, String str, String str2, String str3, String str4, List list, String str5, String str6, String str7, String str8, SerializationConstructorMarker serializationConstructorMarker) {
            if (511 != (i5 & 511)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 511, ShopAndProductsResponseDTO$StoreResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.storeLocation = str2;
            this.storeName = str3;
            this.storeNumber = str4;
            this.categories = list;
            this.bannerImageUrl = str5;
            this.squareImageUrl = str6;
            this.wideImageUrl = str7;
            this.storeLogoImageUrl = str8;
        }

        public static /* synthetic */ void getStoreNumber$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(StoreResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeStringElement(serialDesc, 1, self.storeLocation);
            output.encodeStringElement(serialDesc, 2, self.storeName);
            output.encodeStringElement(serialDesc, 3, self.storeNumber);
            output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.categories);
            output.encodeStringElement(serialDesc, 5, self.bannerImageUrl);
            output.encodeStringElement(serialDesc, 6, self.squareImageUrl);
            output.encodeStringElement(serialDesc, 7, self.wideImageUrl);
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.storeLogoImageUrl);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getStoreLocation() {
            return this.storeLocation;
        }

        /* renamed from: component3, reason: from getter */
        public final String getStoreName() {
            return this.storeName;
        }

        /* renamed from: component4, reason: from getter */
        public final String getStoreNumber() {
            return this.storeNumber;
        }

        public final List<CategoryResponseDTO> component5() {
            return this.categories;
        }

        /* renamed from: component6, reason: from getter */
        public final String getBannerImageUrl() {
            return this.bannerImageUrl;
        }

        /* renamed from: component7, reason: from getter */
        public final String getSquareImageUrl() {
            return this.squareImageUrl;
        }

        /* renamed from: component8, reason: from getter */
        public final String getWideImageUrl() {
            return this.wideImageUrl;
        }

        /* renamed from: component9, reason: from getter */
        public final String getStoreLogoImageUrl() {
            return this.storeLogoImageUrl;
        }

        public final StoreResponseDTO copy(String id, String storeLocation, String storeName, String storeNumber, List<CategoryResponseDTO> categories, String bannerImageUrl, String squareImageUrl, String wideImageUrl, String storeLogoImageUrl) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(storeLocation, "storeLocation");
            Intrinsics.checkNotNullParameter(storeName, "storeName");
            Intrinsics.checkNotNullParameter(storeNumber, "storeNumber");
            Intrinsics.checkNotNullParameter(categories, "categories");
            Intrinsics.checkNotNullParameter(bannerImageUrl, "bannerImageUrl");
            Intrinsics.checkNotNullParameter(squareImageUrl, "squareImageUrl");
            Intrinsics.checkNotNullParameter(wideImageUrl, "wideImageUrl");
            return new StoreResponseDTO(id, storeLocation, storeName, storeNumber, categories, bannerImageUrl, squareImageUrl, wideImageUrl, storeLogoImageUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreResponseDTO)) {
                return false;
            }
            StoreResponseDTO storeResponseDTO = (StoreResponseDTO) other;
            return Intrinsics.areEqual(this.id, storeResponseDTO.id) && Intrinsics.areEqual(this.storeLocation, storeResponseDTO.storeLocation) && Intrinsics.areEqual(this.storeName, storeResponseDTO.storeName) && Intrinsics.areEqual(this.storeNumber, storeResponseDTO.storeNumber) && Intrinsics.areEqual(this.categories, storeResponseDTO.categories) && Intrinsics.areEqual(this.bannerImageUrl, storeResponseDTO.bannerImageUrl) && Intrinsics.areEqual(this.squareImageUrl, storeResponseDTO.squareImageUrl) && Intrinsics.areEqual(this.wideImageUrl, storeResponseDTO.wideImageUrl) && Intrinsics.areEqual(this.storeLogoImageUrl, storeResponseDTO.storeLogoImageUrl);
        }

        public final String getBannerImageUrl() {
            return this.bannerImageUrl;
        }

        public final List<CategoryResponseDTO> getCategories() {
            return this.categories;
        }

        public final String getId() {
            return this.id;
        }

        public final String getSquareImageUrl() {
            return this.squareImageUrl;
        }

        public final String getStoreLocation() {
            return this.storeLocation;
        }

        public final String getStoreLogoImageUrl() {
            return this.storeLogoImageUrl;
        }

        public final String getStoreName() {
            return this.storeName;
        }

        public final String getStoreNumber() {
            return this.storeNumber;
        }

        public final String getWideImageUrl() {
            return this.wideImageUrl;
        }

        public int hashCode() {
            int hashCode = ((((((((((((((this.id.hashCode() * 31) + this.storeLocation.hashCode()) * 31) + this.storeName.hashCode()) * 31) + this.storeNumber.hashCode()) * 31) + this.categories.hashCode()) * 31) + this.bannerImageUrl.hashCode()) * 31) + this.squareImageUrl.hashCode()) * 31) + this.wideImageUrl.hashCode()) * 31;
            String str = this.storeLogoImageUrl;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "StoreResponseDTO(id=" + this.id + ", storeLocation=" + this.storeLocation + ", storeName=" + this.storeName + ", storeNumber=" + this.storeNumber + ", categories=" + this.categories + ", bannerImageUrl=" + this.bannerImageUrl + ", squareImageUrl=" + this.squareImageUrl + ", wideImageUrl=" + this.wideImageUrl + ", storeLogoImageUrl=" + this.storeLogoImageUrl + ")";
        }

        public StoreResponseDTO(String id, String storeLocation, String storeName, String storeNumber, List<CategoryResponseDTO> categories, String bannerImageUrl, String squareImageUrl, String wideImageUrl, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(storeLocation, "storeLocation");
            Intrinsics.checkNotNullParameter(storeName, "storeName");
            Intrinsics.checkNotNullParameter(storeNumber, "storeNumber");
            Intrinsics.checkNotNullParameter(categories, "categories");
            Intrinsics.checkNotNullParameter(bannerImageUrl, "bannerImageUrl");
            Intrinsics.checkNotNullParameter(squareImageUrl, "squareImageUrl");
            Intrinsics.checkNotNullParameter(wideImageUrl, "wideImageUrl");
            this.id = id;
            this.storeLocation = storeLocation;
            this.storeName = storeName;
            this.storeNumber = storeNumber;
            this.categories = categories;
            this.bannerImageUrl = bannerImageUrl;
            this.squareImageUrl = squareImageUrl;
            this.wideImageUrl = wideImageUrl;
            this.storeLogoImageUrl = str;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$VariantResponseDTO;", BuildConfig.FLAVOR, com.sdk.growthbook.utils.Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "description", "imageUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getDescription", "getImageUrl", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class VariantResponseDTO {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String description;
        private final String id;
        private final String imageUrl;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$VariantResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$VariantResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<VariantResponseDTO> serializer() {
                return ShopAndProductsResponseDTO$VariantResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ VariantResponseDTO(int i5, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, ShopAndProductsResponseDTO$VariantResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.description = str2;
            this.imageUrl = str3;
        }

        public static /* synthetic */ VariantResponseDTO copy$default(VariantResponseDTO variantResponseDTO, String str, String str2, String str3, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = variantResponseDTO.id;
            }
            if ((i5 & 2) != 0) {
                str2 = variantResponseDTO.description;
            }
            if ((i5 & 4) != 0) {
                str3 = variantResponseDTO.imageUrl;
            }
            return variantResponseDTO.copy(str, str2, str3);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(VariantResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeStringElement(serialDesc, 1, self.description);
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.imageUrl);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: component3, reason: from getter */
        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final VariantResponseDTO copy(String id, String description, String imageUrl) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(description, "description");
            return new VariantResponseDTO(id, description, imageUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VariantResponseDTO)) {
                return false;
            }
            VariantResponseDTO variantResponseDTO = (VariantResponseDTO) other;
            return Intrinsics.areEqual(this.id, variantResponseDTO.id) && Intrinsics.areEqual(this.description, variantResponseDTO.description) && Intrinsics.areEqual(this.imageUrl, variantResponseDTO.imageUrl);
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getId() {
            return this.id;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public int hashCode() {
            int hashCode = ((this.id.hashCode() * 31) + this.description.hashCode()) * 31;
            String str = this.imageUrl;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "VariantResponseDTO(id=" + this.id + ", description=" + this.description + ", imageUrl=" + this.imageUrl + ")";
        }

        public VariantResponseDTO(String id, String description, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(description, "description");
            this.id = id;
            this.description = description;
            this.imageUrl = str;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tB?\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J-\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0010¨\u0006*"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$VariantsResponseDTO;", BuildConfig.FLAVOR, com.sdk.growthbook.utils.Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "variants", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$VariantResponseDTO;", Constants.IntentExtra.PushTitle, "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getVariants$annotations", "()V", "getVariants", "()Ljava/util/List;", "getTitle$annotations", "getTitle", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class VariantsResponseDTO {
        private final String id;
        private final String title;
        private final List<VariantResponseDTO> variants;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(ShopAndProductsResponseDTO$VariantResponseDTO$$serializer.INSTANCE), null};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$VariantsResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$VariantsResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<VariantsResponseDTO> serializer() {
                return ShopAndProductsResponseDTO$VariantsResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ VariantsResponseDTO(int i5, String str, List list, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, ShopAndProductsResponseDTO$VariantsResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.variants = list;
            this.title = str2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VariantsResponseDTO copy$default(VariantsResponseDTO variantsResponseDTO, String str, List list, String str2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = variantsResponseDTO.id;
            }
            if ((i5 & 2) != 0) {
                list = variantsResponseDTO.variants;
            }
            if ((i5 & 4) != 0) {
                str2 = variantsResponseDTO.title;
            }
            return variantsResponseDTO.copy(str, list, str2);
        }

        public static /* synthetic */ void getTitle$annotations() {
        }

        public static /* synthetic */ void getVariants$annotations() {
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(VariantsResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.variants);
            output.encodeStringElement(serialDesc, 2, self.title);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final List<VariantResponseDTO> component2() {
            return this.variants;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final VariantsResponseDTO copy(String id, List<VariantResponseDTO> variants, String title) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(variants, "variants");
            Intrinsics.checkNotNullParameter(title, "title");
            return new VariantsResponseDTO(id, variants, title);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VariantsResponseDTO)) {
                return false;
            }
            VariantsResponseDTO variantsResponseDTO = (VariantsResponseDTO) other;
            return Intrinsics.areEqual(this.id, variantsResponseDTO.id) && Intrinsics.areEqual(this.variants, variantsResponseDTO.variants) && Intrinsics.areEqual(this.title, variantsResponseDTO.title);
        }

        public final String getId() {
            return this.id;
        }

        public final String getTitle() {
            return this.title;
        }

        public final List<VariantResponseDTO> getVariants() {
            return this.variants;
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + this.variants.hashCode()) * 31) + this.title.hashCode();
        }

        public String toString() {
            return "VariantsResponseDTO(id=" + this.id + ", variants=" + this.variants + ", title=" + this.title + ")";
        }

        public VariantsResponseDTO(String id, List<VariantResponseDTO> variants, String title) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(variants, "variants");
            Intrinsics.checkNotNullParameter(title, "title");
            this.id = id;
            this.variants = variants;
            this.title = title;
        }
    }

    public /* synthetic */ ShopAndProductsResponseDTO(int i5, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i5 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 1, ShopAndProductsResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.stores = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShopAndProductsResponseDTO copy$default(ShopAndProductsResponseDTO shopAndProductsResponseDTO, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            list = shopAndProductsResponseDTO.stores;
        }
        return shopAndProductsResponseDTO.copy(list);
    }

    public final List<StoreResponseDTO> component1() {
        return this.stores;
    }

    public final ShopAndProductsResponseDTO copy(List<StoreResponseDTO> stores) {
        Intrinsics.checkNotNullParameter(stores, "stores");
        return new ShopAndProductsResponseDTO(stores);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ShopAndProductsResponseDTO) && Intrinsics.areEqual(this.stores, ((ShopAndProductsResponseDTO) other).stores);
    }

    public final List<StoreResponseDTO> getStores() {
        return this.stores;
    }

    public int hashCode() {
        return this.stores.hashCode();
    }

    public String toString() {
        return "ShopAndProductsResponseDTO(stores=" + this.stores + ")";
    }

    public ShopAndProductsResponseDTO(List<StoreResponseDTO> stores) {
        Intrinsics.checkNotNullParameter(stores, "stores");
        this.stores = stores;
    }
}
