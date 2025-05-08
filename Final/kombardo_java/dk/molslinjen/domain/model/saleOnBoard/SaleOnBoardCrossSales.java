package dk.molslinjen.domain.model.saleOnBoard;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.saleOnBoard.response.ShopAndProductsResponseDTO;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardCrossSaleProduct;
import dk.molslinjen.domain.model.shared.CurrencyType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002*+B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000eB?\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\b\u0010\u0013J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J-\u0010\u001c\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0010HÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006,"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCrossSales;", BuildConfig.FLAVOR, "crossSaleProducts", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCrossSaleProduct;", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardCrossSalesResponseDTO;", "currencyType", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "(Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardCrossSalesResponseDTO;Ldk/molslinjen/domain/model/shared/CurrencyType;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCrossSaleProducts", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class SaleOnBoardCrossSales {
    private static final SaleOnBoardCrossSales mock;
    private final List<SaleOnBoardCrossSaleProduct> crossSaleProducts;
    private final String id;
    private final String title;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(SaleOnBoardCrossSaleProduct$$serializer.INSTANCE), null, null};

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCrossSales$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCrossSales;", "getMock", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCrossSales;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaleOnBoardCrossSales getMock() {
            return SaleOnBoardCrossSales.mock;
        }

        public final KSerializer<SaleOnBoardCrossSales> serializer() {
            return SaleOnBoardCrossSales$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        SaleOnBoardCrossSaleProduct.Companion companion = SaleOnBoardCrossSaleProduct.INSTANCE;
        mock = new SaleOnBoardCrossSales(CollectionsKt.listOf((Object[]) new SaleOnBoardCrossSaleProduct[]{companion.getMock1(), companion.getMock2(), companion.getMock3()}), "{61C835A7-B8CA-EC11-864C-005056012047}", "Noget til kaffen?");
    }

    public /* synthetic */ SaleOnBoardCrossSales(int i5, List list, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, SaleOnBoardCrossSales$$serializer.INSTANCE.getDescriptor());
        }
        this.crossSaleProducts = list;
        this.id = str;
        this.title = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SaleOnBoardCrossSales copy$default(SaleOnBoardCrossSales saleOnBoardCrossSales, List list, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            list = saleOnBoardCrossSales.crossSaleProducts;
        }
        if ((i5 & 2) != 0) {
            str = saleOnBoardCrossSales.id;
        }
        if ((i5 & 4) != 0) {
            str2 = saleOnBoardCrossSales.title;
        }
        return saleOnBoardCrossSales.copy(list, str, str2);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(SaleOnBoardCrossSales self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.crossSaleProducts);
        output.encodeStringElement(serialDesc, 1, self.id);
        output.encodeStringElement(serialDesc, 2, self.title);
    }

    public final List<SaleOnBoardCrossSaleProduct> component1() {
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

    public final SaleOnBoardCrossSales copy(List<SaleOnBoardCrossSaleProduct> crossSaleProducts, String id, String title) {
        Intrinsics.checkNotNullParameter(crossSaleProducts, "crossSaleProducts");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        return new SaleOnBoardCrossSales(crossSaleProducts, id, title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleOnBoardCrossSales)) {
            return false;
        }
        SaleOnBoardCrossSales saleOnBoardCrossSales = (SaleOnBoardCrossSales) other;
        return Intrinsics.areEqual(this.crossSaleProducts, saleOnBoardCrossSales.crossSaleProducts) && Intrinsics.areEqual(this.id, saleOnBoardCrossSales.id) && Intrinsics.areEqual(this.title, saleOnBoardCrossSales.title);
    }

    public final List<SaleOnBoardCrossSaleProduct> getCrossSaleProducts() {
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
        return "SaleOnBoardCrossSales(crossSaleProducts=" + this.crossSaleProducts + ", id=" + this.id + ", title=" + this.title + ")";
    }

    public SaleOnBoardCrossSales(List<SaleOnBoardCrossSaleProduct> crossSaleProducts, String id, String title) {
        Intrinsics.checkNotNullParameter(crossSaleProducts, "crossSaleProducts");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        this.crossSaleProducts = crossSaleProducts;
        this.id = id;
        this.title = title;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SaleOnBoardCrossSales(ShopAndProductsResponseDTO.SaleOnBoardCrossSalesResponseDTO dto, CurrencyType currencyType) {
        this(r1, dto.getId(), dto.getTitle());
        Intrinsics.checkNotNullParameter(dto, "dto");
        Intrinsics.checkNotNullParameter(currencyType, "currencyType");
        List<ShopAndProductsResponseDTO.SaleOnBoardCrossSaleProductResponseDTO> crossSaleProducts = dto.getCrossSaleProducts();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(crossSaleProducts, 10));
        Iterator<T> it = crossSaleProducts.iterator();
        while (it.hasNext()) {
            arrayList.add(SaleOnBoardCrossSaleProduct.INSTANCE.invoke((ShopAndProductsResponseDTO.SaleOnBoardCrossSaleProductResponseDTO) it.next(), currencyType));
        }
    }
}
