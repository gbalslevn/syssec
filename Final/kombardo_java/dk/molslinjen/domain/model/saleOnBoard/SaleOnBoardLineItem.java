package dk.molslinjen.domain.model.saleOnBoard;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.domain.model.shared.PriceWithCurrency$$serializer;
import java.util.List;
import java.util.UUID;
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

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0002>?BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0011B[\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\u0006\u0010(\u001a\u00020\u0007J\b\u0010)\u001a\u0004\u0018\u00010\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003JM\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\tHÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001J%\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0001¢\u0006\u0002\b=R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006@"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "product", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;", "unitPrice", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "quantity", BuildConfig.FLAVOR, "variant", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariant;", "addOns", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOnOption;", "<init>", "(Ljava/lang/String;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;ILdk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariant;Ljava/util/List;)V", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;ILdk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariant;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getProduct", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;", "getUnitPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getQuantity", "()I", "setQuantity", "(I)V", "getVariant", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariant;", "setVariant", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariant;)V", "getAddOns", "()Ljava/util/List;", "setAddOns", "(Ljava/util/List;)V", "totalPrice", "description", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class SaleOnBoardLineItem {
    private List<SaleOnBoardProductAddOnOption> addOns;
    private final String id;
    private final SaleOnBoardProduct product;
    private int quantity;
    private final PriceWithCurrency unitPrice;
    private SaleOnBoardVariant variant;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, new ArrayListSerializer(SaleOnBoardProductAddOnOption$$serializer.INSTANCE)};
    private static final SaleOnBoardLineItem mock = new SaleOnBoardLineItem((String) null, SaleOnBoardProduct.INSTANCE.getMock1(), PriceWithCurrency.INSTANCE.mock(50), 2, SaleOnBoardVariant.INSTANCE.getMock1(), CollectionsKt.listOf(SaleOnBoardProductAddOnOption.INSTANCE.getMock1()), 1, (DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "getMock", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaleOnBoardLineItem getMock() {
            return SaleOnBoardLineItem.mock;
        }

        public final KSerializer<SaleOnBoardLineItem> serializer() {
            return SaleOnBoardLineItem$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SaleOnBoardLineItem(int i5, String str, SaleOnBoardProduct saleOnBoardProduct, PriceWithCurrency priceWithCurrency, int i6, SaleOnBoardVariant saleOnBoardVariant, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (62 != (i5 & 62)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 62, SaleOnBoardLineItem$$serializer.INSTANCE.getDescriptor());
        }
        if ((i5 & 1) == 0) {
            this.id = UUID.randomUUID().toString();
        } else {
            this.id = str;
        }
        this.product = saleOnBoardProduct;
        this.unitPrice = priceWithCurrency;
        this.quantity = i6;
        this.variant = saleOnBoardVariant;
        this.addOns = list;
    }

    public static /* synthetic */ SaleOnBoardLineItem copy$default(SaleOnBoardLineItem saleOnBoardLineItem, String str, SaleOnBoardProduct saleOnBoardProduct, PriceWithCurrency priceWithCurrency, int i5, SaleOnBoardVariant saleOnBoardVariant, List list, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = saleOnBoardLineItem.id;
        }
        if ((i6 & 2) != 0) {
            saleOnBoardProduct = saleOnBoardLineItem.product;
        }
        SaleOnBoardProduct saleOnBoardProduct2 = saleOnBoardProduct;
        if ((i6 & 4) != 0) {
            priceWithCurrency = saleOnBoardLineItem.unitPrice;
        }
        PriceWithCurrency priceWithCurrency2 = priceWithCurrency;
        if ((i6 & 8) != 0) {
            i5 = saleOnBoardLineItem.quantity;
        }
        int i7 = i5;
        if ((i6 & 16) != 0) {
            saleOnBoardVariant = saleOnBoardLineItem.variant;
        }
        SaleOnBoardVariant saleOnBoardVariant2 = saleOnBoardVariant;
        if ((i6 & 32) != 0) {
            list = saleOnBoardLineItem.addOns;
        }
        return saleOnBoardLineItem.copy(str, saleOnBoardProduct2, priceWithCurrency2, i7, saleOnBoardVariant2, list);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(SaleOnBoardLineItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.id, UUID.randomUUID().toString())) {
            output.encodeStringElement(serialDesc, 0, self.id);
        }
        output.encodeSerializableElement(serialDesc, 1, SaleOnBoardProduct$$serializer.INSTANCE, self.product);
        output.encodeSerializableElement(serialDesc, 2, PriceWithCurrency$$serializer.INSTANCE, self.unitPrice);
        output.encodeIntElement(serialDesc, 3, self.quantity);
        output.encodeNullableSerializableElement(serialDesc, 4, SaleOnBoardVariant$$serializer.INSTANCE, self.variant);
        output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.addOns);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final SaleOnBoardProduct getProduct() {
        return this.product;
    }

    /* renamed from: component3, reason: from getter */
    public final PriceWithCurrency getUnitPrice() {
        return this.unitPrice;
    }

    /* renamed from: component4, reason: from getter */
    public final int getQuantity() {
        return this.quantity;
    }

    /* renamed from: component5, reason: from getter */
    public final SaleOnBoardVariant getVariant() {
        return this.variant;
    }

    public final List<SaleOnBoardProductAddOnOption> component6() {
        return this.addOns;
    }

    public final SaleOnBoardLineItem copy(String id, SaleOnBoardProduct product, PriceWithCurrency unitPrice, int quantity, SaleOnBoardVariant variant, List<SaleOnBoardProductAddOnOption> addOns) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(unitPrice, "unitPrice");
        Intrinsics.checkNotNullParameter(addOns, "addOns");
        return new SaleOnBoardLineItem(id, product, unitPrice, quantity, variant, addOns);
    }

    public final String description() {
        StringBuilder sb = new StringBuilder();
        SaleOnBoardVariant saleOnBoardVariant = this.variant;
        if (saleOnBoardVariant != null) {
            sb.append(saleOnBoardVariant != null ? saleOnBoardVariant.getName() : null);
        }
        for (SaleOnBoardProductAddOnOption saleOnBoardProductAddOnOption : this.addOns) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(saleOnBoardProductAddOnOption.getName());
        }
        return StringExtensionsKt.nullIfEmpty(sb.toString());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleOnBoardLineItem)) {
            return false;
        }
        SaleOnBoardLineItem saleOnBoardLineItem = (SaleOnBoardLineItem) other;
        return Intrinsics.areEqual(this.id, saleOnBoardLineItem.id) && Intrinsics.areEqual(this.product, saleOnBoardLineItem.product) && Intrinsics.areEqual(this.unitPrice, saleOnBoardLineItem.unitPrice) && this.quantity == saleOnBoardLineItem.quantity && Intrinsics.areEqual(this.variant, saleOnBoardLineItem.variant) && Intrinsics.areEqual(this.addOns, saleOnBoardLineItem.addOns);
    }

    public final List<SaleOnBoardProductAddOnOption> getAddOns() {
        return this.addOns;
    }

    public final String getId() {
        return this.id;
    }

    public final SaleOnBoardProduct getProduct() {
        return this.product;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public final PriceWithCurrency getUnitPrice() {
        return this.unitPrice;
    }

    public final SaleOnBoardVariant getVariant() {
        return this.variant;
    }

    public int hashCode() {
        int hashCode = ((((((this.id.hashCode() * 31) + this.product.hashCode()) * 31) + this.unitPrice.hashCode()) * 31) + Integer.hashCode(this.quantity)) * 31;
        SaleOnBoardVariant saleOnBoardVariant = this.variant;
        return ((hashCode + (saleOnBoardVariant == null ? 0 : saleOnBoardVariant.hashCode())) * 31) + this.addOns.hashCode();
    }

    public final void setAddOns(List<SaleOnBoardProductAddOnOption> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.addOns = list;
    }

    public final void setQuantity(int i5) {
        this.quantity = i5;
    }

    public final void setVariant(SaleOnBoardVariant saleOnBoardVariant) {
        this.variant = saleOnBoardVariant;
    }

    public String toString() {
        return "SaleOnBoardLineItem(id=" + this.id + ", product=" + this.product + ", unitPrice=" + this.unitPrice + ", quantity=" + this.quantity + ", variant=" + this.variant + ", addOns=" + this.addOns + ")";
    }

    public final PriceWithCurrency totalPrice() {
        PriceWithCurrency priceWithCurrency = this.unitPrice;
        return PriceWithCurrency.copy$default(priceWithCurrency, priceWithCurrency.getValue() * this.quantity, null, 2, null);
    }

    public SaleOnBoardLineItem(String id, SaleOnBoardProduct product, PriceWithCurrency unitPrice, int i5, SaleOnBoardVariant saleOnBoardVariant, List<SaleOnBoardProductAddOnOption> addOns) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(unitPrice, "unitPrice");
        Intrinsics.checkNotNullParameter(addOns, "addOns");
        this.id = id;
        this.product = product;
        this.unitPrice = unitPrice;
        this.quantity = i5;
        this.variant = saleOnBoardVariant;
        this.addOns = addOns;
    }

    public /* synthetic */ SaleOnBoardLineItem(String str, SaleOnBoardProduct saleOnBoardProduct, PriceWithCurrency priceWithCurrency, int i5, SaleOnBoardVariant saleOnBoardVariant, List list, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? UUID.randomUUID().toString() : str, saleOnBoardProduct, priceWithCurrency, i5, saleOnBoardVariant, list);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SaleOnBoardLineItem(SaleOnBoardProduct product) {
        this((String) null, product, r4, 1, (r0 == null || (r0 = r0.getVariants()) == null) ? null : (SaleOnBoardVariant) CollectionsKt.firstOrNull((List) r0), CollectionsKt.emptyList(), 1, (DefaultConstructorMarker) null);
        List<SaleOnBoardVariant> variants;
        Intrinsics.checkNotNullParameter(product, "product");
        PriceWithCurrency price = product.getPrice();
        SaleOnBoardVariants variants2 = product.getVariants();
    }
}
