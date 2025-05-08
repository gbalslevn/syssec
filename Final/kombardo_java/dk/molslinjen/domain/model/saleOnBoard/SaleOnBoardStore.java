package dk.molslinjen.domain.model.saleOnBoard;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.saleOnBoard.response.ShopAndProductsResponseDTO;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardCategory;
import dk.molslinjen.domain.model.shared.CurrencyType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fB\u0019\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JK\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013¨\u0006("}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStore;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "storeLocation", "storeName", "storeNumber", "categories", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCategory;", "iconUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$StoreResponseDTO;", "currencyType", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "(Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$StoreResponseDTO;Ldk/molslinjen/domain/model/shared/CurrencyType;)V", "getId", "()Ljava/lang/String;", "getStoreLocation", "getStoreName", "getStoreNumber", "getCategories", "()Ljava/util/List;", "getIconUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SaleOnBoardStore {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SaleOnBoardStore mock;
    private final List<SaleOnBoardCategory> categories;
    private final String iconUrl;
    private final String id;
    private final String storeLocation;
    private final String storeName;
    private final String storeNumber;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStore$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStore;", "getMock", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStore;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaleOnBoardStore getMock() {
            return SaleOnBoardStore.mock;
        }

        private Companion() {
        }
    }

    static {
        SaleOnBoardCategory.Companion companion = SaleOnBoardCategory.INSTANCE;
        mock = new SaleOnBoardStore("{FDB7A82B-A7D6-EC11-B856-005056873A34}", "kaffebaren midtskibs", "Express 3 Restaurant 1 (APP)", "S0590", CollectionsKt.listOf((Object[]) new SaleOnBoardCategory[]{companion.getMock(), companion.getMock(), companion.getMock()}), "https://molsmediaprod.blob.core.windows.net/catering/Kvadratisk-til-placeholderbillede-i-produktliste-m.m._640x640px.jpg");
    }

    public SaleOnBoardStore(String id, String storeLocation, String storeName, String storeNumber, List<SaleOnBoardCategory> categories, String iconUrl) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(storeLocation, "storeLocation");
        Intrinsics.checkNotNullParameter(storeName, "storeName");
        Intrinsics.checkNotNullParameter(storeNumber, "storeNumber");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        this.id = id;
        this.storeLocation = storeLocation;
        this.storeName = storeName;
        this.storeNumber = storeNumber;
        this.categories = categories;
        this.iconUrl = iconUrl;
    }

    public static /* synthetic */ SaleOnBoardStore copy$default(SaleOnBoardStore saleOnBoardStore, String str, String str2, String str3, String str4, List list, String str5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = saleOnBoardStore.id;
        }
        if ((i5 & 2) != 0) {
            str2 = saleOnBoardStore.storeLocation;
        }
        String str6 = str2;
        if ((i5 & 4) != 0) {
            str3 = saleOnBoardStore.storeName;
        }
        String str7 = str3;
        if ((i5 & 8) != 0) {
            str4 = saleOnBoardStore.storeNumber;
        }
        String str8 = str4;
        if ((i5 & 16) != 0) {
            list = saleOnBoardStore.categories;
        }
        List list2 = list;
        if ((i5 & 32) != 0) {
            str5 = saleOnBoardStore.iconUrl;
        }
        return saleOnBoardStore.copy(str, str6, str7, str8, list2, str5);
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

    public final List<SaleOnBoardCategory> component5() {
        return this.categories;
    }

    /* renamed from: component6, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final SaleOnBoardStore copy(String id, String storeLocation, String storeName, String storeNumber, List<SaleOnBoardCategory> categories, String iconUrl) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(storeLocation, "storeLocation");
        Intrinsics.checkNotNullParameter(storeName, "storeName");
        Intrinsics.checkNotNullParameter(storeNumber, "storeNumber");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        return new SaleOnBoardStore(id, storeLocation, storeName, storeNumber, categories, iconUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleOnBoardStore)) {
            return false;
        }
        SaleOnBoardStore saleOnBoardStore = (SaleOnBoardStore) other;
        return Intrinsics.areEqual(this.id, saleOnBoardStore.id) && Intrinsics.areEqual(this.storeLocation, saleOnBoardStore.storeLocation) && Intrinsics.areEqual(this.storeName, saleOnBoardStore.storeName) && Intrinsics.areEqual(this.storeNumber, saleOnBoardStore.storeNumber) && Intrinsics.areEqual(this.categories, saleOnBoardStore.categories) && Intrinsics.areEqual(this.iconUrl, saleOnBoardStore.iconUrl);
    }

    public final List<SaleOnBoardCategory> getCategories() {
        return this.categories;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getId() {
        return this.id;
    }

    public final String getStoreLocation() {
        return this.storeLocation;
    }

    public final String getStoreName() {
        return this.storeName;
    }

    public final String getStoreNumber() {
        return this.storeNumber;
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.storeLocation.hashCode()) * 31) + this.storeName.hashCode()) * 31) + this.storeNumber.hashCode()) * 31) + this.categories.hashCode()) * 31) + this.iconUrl.hashCode();
    }

    public String toString() {
        return "SaleOnBoardStore(id=" + this.id + ", storeLocation=" + this.storeLocation + ", storeName=" + this.storeName + ", storeNumber=" + this.storeNumber + ", categories=" + this.categories + ", iconUrl=" + this.iconUrl + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SaleOnBoardStore(ShopAndProductsResponseDTO.StoreResponseDTO dto, CurrencyType currencyType) {
        this(r2, r3, r4, r5, r6, r12 == null ? dto.getSquareImageUrl() : r12);
        Intrinsics.checkNotNullParameter(dto, "dto");
        Intrinsics.checkNotNullParameter(currencyType, "currencyType");
        String id = dto.getId();
        String storeLocation = dto.getStoreLocation();
        String storeName = dto.getStoreName();
        String storeNumber = dto.getStoreNumber();
        List<ShopAndProductsResponseDTO.CategoryResponseDTO> categories = dto.getCategories();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(categories, 10));
        Iterator<T> it = categories.iterator();
        while (it.hasNext()) {
            arrayList.add(new SaleOnBoardCategory((ShopAndProductsResponseDTO.CategoryResponseDTO) it.next(), dto.getSquareImageUrl(), dto.getWideImageUrl(), currencyType));
        }
        String storeLogoImageUrl = dto.getStoreLogoImageUrl();
    }
}
