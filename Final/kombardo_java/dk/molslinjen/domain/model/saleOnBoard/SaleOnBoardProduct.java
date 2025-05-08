package dk.molslinjen.domain.model.saleOnBoard;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.saleOnBoard.response.ShopAndProductsResponseDTO;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardCrossSales;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProductAddOn;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardVariants;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.domain.model.shared.PriceWithCurrency$$serializer;
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
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 M2\u00020\u0001:\u0002MNB\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019B©\u0001\b\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u0018\u0010\u001dJ\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u00109\u001a\u00020\u000fHÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0013HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0017HÆ\u0003J¡\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u0017HÆ\u0001J\u0013\u0010A\u001a\u00020\u00132\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\u0017HÖ\u0001J\t\u0010D\u001a\u00020\u0003HÖ\u0001J%\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0001¢\u0006\u0002\bLR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010-R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u0006O"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "addOns", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOn;", "crossSale", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCrossSales;", "name", "description", "itemNumber", "variants", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariants;", "price", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "squareImageUrl", "wideImageUrl", "isSoldOut", BuildConfig.FLAVOR, "categoryName", "categoryId", "positionInCategory", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/util/List;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCrossSales;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariants;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCrossSales;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariants;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getAddOns", "()Ljava/util/List;", "getCrossSale", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCrossSales;", "getName", "getDescription", "getItemNumber", "getVariants", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariants;", "getPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getSquareImageUrl", "getWideImageUrl", "()Z", "getCategoryName", "getCategoryId", "getPositionInCategory", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class SaleOnBoardProduct {
    private static final SaleOnBoardProduct mock1;
    private static final SaleOnBoardProduct mock2;
    private final List<SaleOnBoardProductAddOn> addOns;
    private final String categoryId;
    private final String categoryName;
    private final SaleOnBoardCrossSales crossSale;
    private final String description;
    private final String id;
    private final boolean isSoldOut;
    private final String itemNumber;
    private final String name;
    private final int positionInCategory;
    private final PriceWithCurrency price;
    private final String squareImageUrl;
    private final SaleOnBoardVariants variants;
    private final String wideImageUrl;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(SaleOnBoardProductAddOn$$serializer.INSTANCE), null, null, null, null, null, null, null, null, null, null, null, null};

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086\u0002J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;", "dto", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardProductResponseDTO;", "squareImageUrl", BuildConfig.FLAVOR, "wideImageUrl", "categoryName", "categoryId", "positionInCategory", BuildConfig.FLAVOR, "currencyType", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "mock1", "getMock1", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;", "mock2", "getMock2", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaleOnBoardProduct getMock1() {
            return SaleOnBoardProduct.mock1;
        }

        public final SaleOnBoardProduct getMock2() {
            return SaleOnBoardProduct.mock2;
        }

        public final SaleOnBoardProduct invoke(ShopAndProductsResponseDTO.SaleOnBoardProductResponseDTO dto, String squareImageUrl, String wideImageUrl, String categoryName, String categoryId, int positionInCategory, CurrencyType currencyType) {
            List emptyList;
            Intrinsics.checkNotNullParameter(dto, "dto");
            Intrinsics.checkNotNullParameter(squareImageUrl, "squareImageUrl");
            Intrinsics.checkNotNullParameter(wideImageUrl, "wideImageUrl");
            Intrinsics.checkNotNullParameter(categoryName, "categoryName");
            Intrinsics.checkNotNullParameter(categoryId, "categoryId");
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
            String id = dto.getId();
            List<ShopAndProductsResponseDTO.SaleOnBoardProductAddOnResponseDTO> addOn = dto.getAddOn();
            if (addOn != null) {
                List<ShopAndProductsResponseDTO.SaleOnBoardProductAddOnResponseDTO> list = addOn;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new SaleOnBoardProductAddOn((ShopAndProductsResponseDTO.SaleOnBoardProductAddOnResponseDTO) it.next(), currencyType));
                }
                emptyList = arrayList;
            } else {
                emptyList = CollectionsKt.emptyList();
            }
            ShopAndProductsResponseDTO.SaleOnBoardCrossSalesResponseDTO crossSale = dto.getCrossSale();
            SaleOnBoardCrossSales saleOnBoardCrossSales = crossSale != null ? new SaleOnBoardCrossSales(crossSale, currencyType) : null;
            String name = dto.getName();
            String nullIfEmpty = StringExtensionsKt.nullIfEmpty(str);
            String itemNumber = dto.getItemNumber();
            ShopAndProductsResponseDTO.VariantsResponseDTO variants = dto.getVariants();
            SaleOnBoardVariants saleOnBoardVariants = variants != null ? new SaleOnBoardVariants(variants) : null;
            PriceWithCurrency priceWithCurrency = new PriceWithCurrency((int) dto.getPrice(), currencyType);
            String imageUrl = dto.getImageUrl();
            if (imageUrl == null) {
                imageUrl = squareImageUrl;
            }
            String imageUrl2 = dto.getImageUrl();
            return new SaleOnBoardProduct(id, emptyList, saleOnBoardCrossSales, name, nullIfEmpty, itemNumber, saleOnBoardVariants, priceWithCurrency, imageUrl, imageUrl2 == null ? wideImageUrl : imageUrl2, false, categoryName, categoryId, positionInCategory);
        }

        public final KSerializer<SaleOnBoardProduct> serializer() {
            return SaleOnBoardProduct$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        SaleOnBoardProductAddOn.Companion companion = SaleOnBoardProductAddOn.INSTANCE;
        List listOf = CollectionsKt.listOf(companion.getMock());
        SaleOnBoardCrossSales.Companion companion2 = SaleOnBoardCrossSales.INSTANCE;
        SaleOnBoardCrossSales mock = companion2.getMock();
        SaleOnBoardVariants.Companion companion3 = SaleOnBoardVariants.INSTANCE;
        SaleOnBoardVariants mock3 = companion3.getMock();
        PriceWithCurrency.Companion companion4 = PriceWithCurrency.INSTANCE;
        mock1 = new SaleOnBoardProduct("{92C39206-10D8-4447-8A84-77059443E476}", listOf, mock, "Caffé Latte, Triple Shot", "Vi skruer op for styrken i denne italienske specialitet.\nVi tilføjer 3 shots af vores Kifaru kaffe, og topper op med let skummende mælk. ", "301230", mock3, companion4.mock(50), "https://www.molslinjen.dk/~/media/Files/Molslinjen/Menukort/2019/2019-04-01/301230.jpg", "https://www.molslinjen.dk/~/media/Files/Molslinjen/Menukort/2019/2019-04-01/301230.jpg", false, "Kaffe", "1", 1);
        mock2 = new SaleOnBoardProduct("{92C39206-10D8-4447-8A84-77059443E476}", CollectionsKt.listOf(companion.getMock()), companion2.getMock(), "Cappuccino", "En cremet og lækker kaffe, med tydelig smag af espresso.\n1/3 espresso, 1/3 mælkeskum og 1/3 steamet mælk, helt klassisk. ", "301517", companion3.getMock(), companion4.mock(49), "https://www.molslinjen.dk/~/media/Files/Molslinjen/Menukort/2019/2019-04-01/301517.jpg", "https://www.molslinjen.dk/~/media/Files/Molslinjen/Menukort/2019/2019-04-01/301517.jpg", false, "Kaffe", "1", 2);
    }

    public /* synthetic */ SaleOnBoardProduct(int i5, String str, List list, SaleOnBoardCrossSales saleOnBoardCrossSales, String str2, String str3, String str4, SaleOnBoardVariants saleOnBoardVariants, PriceWithCurrency priceWithCurrency, String str5, String str6, boolean z5, String str7, String str8, int i6, SerializationConstructorMarker serializationConstructorMarker) {
        if (16383 != (i5 & 16383)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 16383, SaleOnBoardProduct$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.addOns = list;
        this.crossSale = saleOnBoardCrossSales;
        this.name = str2;
        this.description = str3;
        this.itemNumber = str4;
        this.variants = saleOnBoardVariants;
        this.price = priceWithCurrency;
        this.squareImageUrl = str5;
        this.wideImageUrl = str6;
        this.isSoldOut = z5;
        this.categoryName = str7;
        this.categoryId = str8;
        this.positionInCategory = i6;
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(SaleOnBoardProduct self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.addOns);
        output.encodeNullableSerializableElement(serialDesc, 2, SaleOnBoardCrossSales$$serializer.INSTANCE, self.crossSale);
        output.encodeStringElement(serialDesc, 3, self.name);
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.description);
        output.encodeStringElement(serialDesc, 5, self.itemNumber);
        output.encodeNullableSerializableElement(serialDesc, 6, SaleOnBoardVariants$$serializer.INSTANCE, self.variants);
        output.encodeSerializableElement(serialDesc, 7, PriceWithCurrency$$serializer.INSTANCE, self.price);
        output.encodeStringElement(serialDesc, 8, self.squareImageUrl);
        output.encodeStringElement(serialDesc, 9, self.wideImageUrl);
        output.encodeBooleanElement(serialDesc, 10, self.isSoldOut);
        output.encodeStringElement(serialDesc, 11, self.categoryName);
        output.encodeStringElement(serialDesc, 12, self.categoryId);
        output.encodeIntElement(serialDesc, 13, self.positionInCategory);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getWideImageUrl() {
        return this.wideImageUrl;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsSoldOut() {
        return this.isSoldOut;
    }

    /* renamed from: component12, reason: from getter */
    public final String getCategoryName() {
        return this.categoryName;
    }

    /* renamed from: component13, reason: from getter */
    public final String getCategoryId() {
        return this.categoryId;
    }

    /* renamed from: component14, reason: from getter */
    public final int getPositionInCategory() {
        return this.positionInCategory;
    }

    public final List<SaleOnBoardProductAddOn> component2() {
        return this.addOns;
    }

    /* renamed from: component3, reason: from getter */
    public final SaleOnBoardCrossSales getCrossSale() {
        return this.crossSale;
    }

    /* renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component6, reason: from getter */
    public final String getItemNumber() {
        return this.itemNumber;
    }

    /* renamed from: component7, reason: from getter */
    public final SaleOnBoardVariants getVariants() {
        return this.variants;
    }

    /* renamed from: component8, reason: from getter */
    public final PriceWithCurrency getPrice() {
        return this.price;
    }

    /* renamed from: component9, reason: from getter */
    public final String getSquareImageUrl() {
        return this.squareImageUrl;
    }

    public final SaleOnBoardProduct copy(String id, List<SaleOnBoardProductAddOn> addOns, SaleOnBoardCrossSales crossSale, String name, String description, String itemNumber, SaleOnBoardVariants variants, PriceWithCurrency price, String squareImageUrl, String wideImageUrl, boolean isSoldOut, String categoryName, String categoryId, int positionInCategory) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(addOns, "addOns");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(itemNumber, "itemNumber");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(squareImageUrl, "squareImageUrl");
        Intrinsics.checkNotNullParameter(wideImageUrl, "wideImageUrl");
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        return new SaleOnBoardProduct(id, addOns, crossSale, name, description, itemNumber, variants, price, squareImageUrl, wideImageUrl, isSoldOut, categoryName, categoryId, positionInCategory);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleOnBoardProduct)) {
            return false;
        }
        SaleOnBoardProduct saleOnBoardProduct = (SaleOnBoardProduct) other;
        return Intrinsics.areEqual(this.id, saleOnBoardProduct.id) && Intrinsics.areEqual(this.addOns, saleOnBoardProduct.addOns) && Intrinsics.areEqual(this.crossSale, saleOnBoardProduct.crossSale) && Intrinsics.areEqual(this.name, saleOnBoardProduct.name) && Intrinsics.areEqual(this.description, saleOnBoardProduct.description) && Intrinsics.areEqual(this.itemNumber, saleOnBoardProduct.itemNumber) && Intrinsics.areEqual(this.variants, saleOnBoardProduct.variants) && Intrinsics.areEqual(this.price, saleOnBoardProduct.price) && Intrinsics.areEqual(this.squareImageUrl, saleOnBoardProduct.squareImageUrl) && Intrinsics.areEqual(this.wideImageUrl, saleOnBoardProduct.wideImageUrl) && this.isSoldOut == saleOnBoardProduct.isSoldOut && Intrinsics.areEqual(this.categoryName, saleOnBoardProduct.categoryName) && Intrinsics.areEqual(this.categoryId, saleOnBoardProduct.categoryId) && this.positionInCategory == saleOnBoardProduct.positionInCategory;
    }

    public final List<SaleOnBoardProductAddOn> getAddOns() {
        return this.addOns;
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final SaleOnBoardCrossSales getCrossSale() {
        return this.crossSale;
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

    public final int getPositionInCategory() {
        return this.positionInCategory;
    }

    public final PriceWithCurrency getPrice() {
        return this.price;
    }

    public final String getSquareImageUrl() {
        return this.squareImageUrl;
    }

    public final SaleOnBoardVariants getVariants() {
        return this.variants;
    }

    public final String getWideImageUrl() {
        return this.wideImageUrl;
    }

    public int hashCode() {
        int hashCode = ((this.id.hashCode() * 31) + this.addOns.hashCode()) * 31;
        SaleOnBoardCrossSales saleOnBoardCrossSales = this.crossSale;
        int hashCode2 = (((hashCode + (saleOnBoardCrossSales == null ? 0 : saleOnBoardCrossSales.hashCode())) * 31) + this.name.hashCode()) * 31;
        String str = this.description;
        int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.itemNumber.hashCode()) * 31;
        SaleOnBoardVariants saleOnBoardVariants = this.variants;
        return ((((((((((((((hashCode3 + (saleOnBoardVariants != null ? saleOnBoardVariants.hashCode() : 0)) * 31) + this.price.hashCode()) * 31) + this.squareImageUrl.hashCode()) * 31) + this.wideImageUrl.hashCode()) * 31) + Boolean.hashCode(this.isSoldOut)) * 31) + this.categoryName.hashCode()) * 31) + this.categoryId.hashCode()) * 31) + Integer.hashCode(this.positionInCategory);
    }

    public final boolean isSoldOut() {
        return this.isSoldOut;
    }

    public String toString() {
        return "SaleOnBoardProduct(id=" + this.id + ", addOns=" + this.addOns + ", crossSale=" + this.crossSale + ", name=" + this.name + ", description=" + this.description + ", itemNumber=" + this.itemNumber + ", variants=" + this.variants + ", price=" + this.price + ", squareImageUrl=" + this.squareImageUrl + ", wideImageUrl=" + this.wideImageUrl + ", isSoldOut=" + this.isSoldOut + ", categoryName=" + this.categoryName + ", categoryId=" + this.categoryId + ", positionInCategory=" + this.positionInCategory + ")";
    }

    public SaleOnBoardProduct(String id, List<SaleOnBoardProductAddOn> addOns, SaleOnBoardCrossSales saleOnBoardCrossSales, String name, String str, String itemNumber, SaleOnBoardVariants saleOnBoardVariants, PriceWithCurrency price, String squareImageUrl, String wideImageUrl, boolean z5, String categoryName, String categoryId, int i5) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(addOns, "addOns");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(itemNumber, "itemNumber");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(squareImageUrl, "squareImageUrl");
        Intrinsics.checkNotNullParameter(wideImageUrl, "wideImageUrl");
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        this.id = id;
        this.addOns = addOns;
        this.crossSale = saleOnBoardCrossSales;
        this.name = name;
        this.description = str;
        this.itemNumber = itemNumber;
        this.variants = saleOnBoardVariants;
        this.price = price;
        this.squareImageUrl = squareImageUrl;
        this.wideImageUrl = wideImageUrl;
        this.isSoldOut = z5;
        this.categoryName = categoryName;
        this.categoryId = categoryId;
        this.positionInCategory = i5;
    }
}
