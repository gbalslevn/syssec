package dk.molslinjen.domain.model.saleOnBoard;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.saleOnBoard.response.ShopAndProductsResponseDTO;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProduct;
import dk.molslinjen.domain.model.shared.CurrencyType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bB)\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\n\u0010\u0012J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003JA\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCategory;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "code", "iconType", "name", "products", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "dto", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$CategoryResponseDTO;", "squareImageUrl", "wideImageUrl", "currencyType", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "(Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$CategoryResponseDTO;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/CurrencyType;)V", "getId", "()Ljava/lang/String;", "getCode", "getIconType", "getName", "getProducts", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SaleOnBoardCategory {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SaleOnBoardCategory mock;
    private final String code;
    private final String iconType;
    private final String id;
    private final String name;
    private final List<SaleOnBoardProduct> products;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCategory$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCategory;", "getMock", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCategory;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaleOnBoardCategory getMock() {
            return SaleOnBoardCategory.mock;
        }

        private Companion() {
        }
    }

    static {
        SaleOnBoardProduct.Companion companion = SaleOnBoardProduct.INSTANCE;
        mock = new SaleOnBoardCategory("{21EE1E12-A5D6-EC11-B856-005056873A34}", "01", "hotBeverages", "Varme drikke", CollectionsKt.listOf((Object[]) new SaleOnBoardProduct[]{companion.getMock1(), companion.getMock2()}));
    }

    public SaleOnBoardCategory(String id, String code, String iconType, String name, List<SaleOnBoardProduct> products) {
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

    public static /* synthetic */ SaleOnBoardCategory copy$default(SaleOnBoardCategory saleOnBoardCategory, String str, String str2, String str3, String str4, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = saleOnBoardCategory.id;
        }
        if ((i5 & 2) != 0) {
            str2 = saleOnBoardCategory.code;
        }
        String str5 = str2;
        if ((i5 & 4) != 0) {
            str3 = saleOnBoardCategory.iconType;
        }
        String str6 = str3;
        if ((i5 & 8) != 0) {
            str4 = saleOnBoardCategory.name;
        }
        String str7 = str4;
        if ((i5 & 16) != 0) {
            list = saleOnBoardCategory.products;
        }
        return saleOnBoardCategory.copy(str, str5, str6, str7, list);
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

    public final List<SaleOnBoardProduct> component5() {
        return this.products;
    }

    public final SaleOnBoardCategory copy(String id, String code, String iconType, String name, List<SaleOnBoardProduct> products) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(iconType, "iconType");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(products, "products");
        return new SaleOnBoardCategory(id, code, iconType, name, products);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleOnBoardCategory)) {
            return false;
        }
        SaleOnBoardCategory saleOnBoardCategory = (SaleOnBoardCategory) other;
        return Intrinsics.areEqual(this.id, saleOnBoardCategory.id) && Intrinsics.areEqual(this.code, saleOnBoardCategory.code) && Intrinsics.areEqual(this.iconType, saleOnBoardCategory.iconType) && Intrinsics.areEqual(this.name, saleOnBoardCategory.name) && Intrinsics.areEqual(this.products, saleOnBoardCategory.products);
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

    public final List<SaleOnBoardProduct> getProducts() {
        return this.products;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.code.hashCode()) * 31) + this.iconType.hashCode()) * 31) + this.name.hashCode()) * 31) + this.products.hashCode();
    }

    public String toString() {
        return "SaleOnBoardCategory(id=" + this.id + ", code=" + this.code + ", iconType=" + this.iconType + ", name=" + this.name + ", products=" + this.products + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SaleOnBoardCategory(ShopAndProductsResponseDTO.CategoryResponseDTO dto, String squareImageUrl, String wideImageUrl, CurrencyType currencyType) {
        this(r0, r13, r14, r15, r9);
        Intrinsics.checkNotNullParameter(dto, "dto");
        Intrinsics.checkNotNullParameter(squareImageUrl, "squareImageUrl");
        Intrinsics.checkNotNullParameter(wideImageUrl, "wideImageUrl");
        Intrinsics.checkNotNullParameter(currencyType, "currencyType");
        String id = dto.getId();
        String code = dto.getCode();
        String iconType = dto.getIconType();
        String name = dto.getName();
        List<ShopAndProductsResponseDTO.SaleOnBoardProductResponseDTO> products = dto.getProducts();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(products, 10));
        int i5 = 0;
        for (Object obj : products) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ArrayList arrayList2 = arrayList;
            arrayList2.add(SaleOnBoardProduct.INSTANCE.invoke((ShopAndProductsResponseDTO.SaleOnBoardProductResponseDTO) obj, squareImageUrl, wideImageUrl, dto.getName(), dto.getId(), i6, currencyType));
            arrayList = arrayList2;
            i5 = i6;
        }
    }
}
