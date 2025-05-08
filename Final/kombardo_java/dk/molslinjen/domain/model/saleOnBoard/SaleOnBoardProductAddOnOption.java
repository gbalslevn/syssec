package dk.molslinjen.domain.model.saleOnBoard;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.saleOnBoard.response.ShopAndProductsResponseDTO;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.domain.model.shared.PriceWithCurrency$$serializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002*+B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nBM\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J=\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\fHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOnOption;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "description", "itemNumber", "price", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "getDescription", "getItemNumber", "getPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class SaleOnBoardProductAddOnOption {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SaleOnBoardProductAddOnOption mock1;
    private static final SaleOnBoardProductAddOnOption mock2;
    private final String description;
    private final String id;
    private final String itemNumber;
    private final String name;
    private final PriceWithCurrency price;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086\u0002J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOnOption$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOnOption;", "dto", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardProductAddOnSelectionResponseDTO;", "currencyType", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "mock1", "getMock1", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOnOption;", "mock2", "getMock2", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaleOnBoardProductAddOnOption getMock1() {
            return SaleOnBoardProductAddOnOption.mock1;
        }

        public final SaleOnBoardProductAddOnOption getMock2() {
            return SaleOnBoardProductAddOnOption.mock2;
        }

        public final SaleOnBoardProductAddOnOption invoke(ShopAndProductsResponseDTO.SaleOnBoardProductAddOnSelectionResponseDTO dto, CurrencyType currencyType) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            Intrinsics.checkNotNullParameter(currencyType, "currencyType");
            List<String> extendedTexts = dto.getExtendedTexts();
            String str = BuildConfig.FLAVOR;
            if (extendedTexts != null) {
                for (String str2 : extendedTexts) {
                    if (str.length() > 0) {
                        str = ((Object) str) + "\n";
                    }
                    str = ((Object) str) + str2;
                }
            }
            return new SaleOnBoardProductAddOnOption(dto.getId(), dto.getName(), StringExtensionsKt.nullIfEmpty(str), dto.getItemNumber(), new PriceWithCurrency((int) dto.getPrice(), currencyType));
        }

        public final KSerializer<SaleOnBoardProductAddOnOption> serializer() {
            return SaleOnBoardProductAddOnOption$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        PriceWithCurrency.Companion companion = PriceWithCurrency.INSTANCE;
        mock1 = new SaleOnBoardProductAddOnOption("{0C8D872F-D98A-4BC9-BBDF-7C86CC35F945}", "Havremælk", null, "301579", companion.mock(5));
        mock2 = new SaleOnBoardProductAddOnOption("{462228A9-68C6-4281-99AA-AE631AAF65FC}", "Laktosefri mælk", "Detaljer om laktosefri mælk", "301590", companion.mock(5));
    }

    public /* synthetic */ SaleOnBoardProductAddOnOption(int i5, String str, String str2, String str3, String str4, PriceWithCurrency priceWithCurrency, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i5 & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 31, SaleOnBoardProductAddOnOption$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.name = str2;
        this.description = str3;
        this.itemNumber = str4;
        this.price = priceWithCurrency;
    }

    public static /* synthetic */ SaleOnBoardProductAddOnOption copy$default(SaleOnBoardProductAddOnOption saleOnBoardProductAddOnOption, String str, String str2, String str3, String str4, PriceWithCurrency priceWithCurrency, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = saleOnBoardProductAddOnOption.id;
        }
        if ((i5 & 2) != 0) {
            str2 = saleOnBoardProductAddOnOption.name;
        }
        String str5 = str2;
        if ((i5 & 4) != 0) {
            str3 = saleOnBoardProductAddOnOption.description;
        }
        String str6 = str3;
        if ((i5 & 8) != 0) {
            str4 = saleOnBoardProductAddOnOption.itemNumber;
        }
        String str7 = str4;
        if ((i5 & 16) != 0) {
            priceWithCurrency = saleOnBoardProductAddOnOption.price;
        }
        return saleOnBoardProductAddOnOption.copy(str, str5, str6, str7, priceWithCurrency);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(SaleOnBoardProductAddOnOption self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.name);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.description);
        output.encodeStringElement(serialDesc, 3, self.itemNumber);
        output.encodeSerializableElement(serialDesc, 4, PriceWithCurrency$$serializer.INSTANCE, self.price);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final String getItemNumber() {
        return this.itemNumber;
    }

    /* renamed from: component5, reason: from getter */
    public final PriceWithCurrency getPrice() {
        return this.price;
    }

    public final SaleOnBoardProductAddOnOption copy(String id, String name, String description, String itemNumber, PriceWithCurrency price) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(itemNumber, "itemNumber");
        Intrinsics.checkNotNullParameter(price, "price");
        return new SaleOnBoardProductAddOnOption(id, name, description, itemNumber, price);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleOnBoardProductAddOnOption)) {
            return false;
        }
        SaleOnBoardProductAddOnOption saleOnBoardProductAddOnOption = (SaleOnBoardProductAddOnOption) other;
        return Intrinsics.areEqual(this.id, saleOnBoardProductAddOnOption.id) && Intrinsics.areEqual(this.name, saleOnBoardProductAddOnOption.name) && Intrinsics.areEqual(this.description, saleOnBoardProductAddOnOption.description) && Intrinsics.areEqual(this.itemNumber, saleOnBoardProductAddOnOption.itemNumber) && Intrinsics.areEqual(this.price, saleOnBoardProductAddOnOption.price);
    }

    public final String getDescription() {
        return this.description;
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

    public final PriceWithCurrency getPrice() {
        return this.price;
    }

    public int hashCode() {
        int hashCode = ((this.id.hashCode() * 31) + this.name.hashCode()) * 31;
        String str = this.description;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.itemNumber.hashCode()) * 31) + this.price.hashCode();
    }

    public String toString() {
        return "SaleOnBoardProductAddOnOption(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", itemNumber=" + this.itemNumber + ", price=" + this.price + ")";
    }

    public SaleOnBoardProductAddOnOption(String id, String name, String str, String itemNumber, PriceWithCurrency price) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(itemNumber, "itemNumber");
        Intrinsics.checkNotNullParameter(price, "price");
        this.id = id;
        this.name = name;
        this.description = str;
        this.itemNumber = itemNumber;
        this.price = price;
    }
}
