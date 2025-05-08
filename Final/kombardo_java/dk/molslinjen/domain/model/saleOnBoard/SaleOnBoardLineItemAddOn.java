package dk.molslinjen.domain.model.saleOnBoard;

import com.sdk.growthbook.utils.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItemAddOn;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "itemNumber", "name", "price", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;D)V", "getId", "()Ljava/lang/String;", "getItemNumber", "getName", "getPrice", "()D", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SaleOnBoardLineItemAddOn {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SaleOnBoardLineItemAddOn mock = new SaleOnBoardLineItemAddOn("1", "{0C8D872F-D98A-4BC9-BBDF-7C86CC35F945}", "Havremælk", 50.0d);
    private final String id;
    private final String itemNumber;
    private final String name;
    private final double price;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItemAddOn$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItemAddOn;", "getMock", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItemAddOn;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaleOnBoardLineItemAddOn getMock() {
            return SaleOnBoardLineItemAddOn.mock;
        }

        private Companion() {
        }
    }

    public SaleOnBoardLineItemAddOn(String id, String itemNumber, String name, double d5) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(itemNumber, "itemNumber");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.itemNumber = itemNumber;
        this.name = name;
        this.price = d5;
    }

    public static /* synthetic */ SaleOnBoardLineItemAddOn copy$default(SaleOnBoardLineItemAddOn saleOnBoardLineItemAddOn, String str, String str2, String str3, double d5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = saleOnBoardLineItemAddOn.id;
        }
        if ((i5 & 2) != 0) {
            str2 = saleOnBoardLineItemAddOn.itemNumber;
        }
        String str4 = str2;
        if ((i5 & 4) != 0) {
            str3 = saleOnBoardLineItemAddOn.name;
        }
        String str5 = str3;
        if ((i5 & 8) != 0) {
            d5 = saleOnBoardLineItemAddOn.price;
        }
        return saleOnBoardLineItemAddOn.copy(str, str4, str5, d5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getItemNumber() {
        return this.itemNumber;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final double getPrice() {
        return this.price;
    }

    public final SaleOnBoardLineItemAddOn copy(String id, String itemNumber, String name, double price) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(itemNumber, "itemNumber");
        Intrinsics.checkNotNullParameter(name, "name");
        return new SaleOnBoardLineItemAddOn(id, itemNumber, name, price);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleOnBoardLineItemAddOn)) {
            return false;
        }
        SaleOnBoardLineItemAddOn saleOnBoardLineItemAddOn = (SaleOnBoardLineItemAddOn) other;
        return Intrinsics.areEqual(this.id, saleOnBoardLineItemAddOn.id) && Intrinsics.areEqual(this.itemNumber, saleOnBoardLineItemAddOn.itemNumber) && Intrinsics.areEqual(this.name, saleOnBoardLineItemAddOn.name) && Double.compare(this.price, saleOnBoardLineItemAddOn.price) == 0;
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
        return (((((this.id.hashCode() * 31) + this.itemNumber.hashCode()) * 31) + this.name.hashCode()) * 31) + Double.hashCode(this.price);
    }

    public String toString() {
        return "SaleOnBoardLineItemAddOn(id=" + this.id + ", itemNumber=" + this.itemNumber + ", name=" + this.name + ", price=" + this.price + ")";
    }
}
