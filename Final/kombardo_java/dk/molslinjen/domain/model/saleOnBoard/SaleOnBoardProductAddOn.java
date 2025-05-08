package dk.molslinjen.domain.model.saleOnBoard;

import dk.molslinjen.api.services.saleOnBoard.response.ShopAndProductsResponseDTO;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProductAddOnOption;
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

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002'(B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0007\u0010\rB5\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0007\u0010\u0012J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u000fHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006)"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOn;", BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, BuildConfig.FLAVOR, "options", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOnOption;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "dto", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardProductAddOnResponseDTO;", "currencyType", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "(Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$SaleOnBoardProductAddOnResponseDTO;Ldk/molslinjen/domain/model/shared/CurrencyType;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle", "()Ljava/lang/String;", "getOptions", "()Ljava/util/List;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class SaleOnBoardProductAddOn {
    private static final SaleOnBoardProductAddOn mock;
    private final List<SaleOnBoardProductAddOnOption> options;
    private final String title;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(SaleOnBoardProductAddOnOption$$serializer.INSTANCE)};

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOn$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOn;", "getMock", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOn;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaleOnBoardProductAddOn getMock() {
            return SaleOnBoardProductAddOn.mock;
        }

        public final KSerializer<SaleOnBoardProductAddOn> serializer() {
            return SaleOnBoardProductAddOn$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        SaleOnBoardProductAddOnOption.Companion companion = SaleOnBoardProductAddOnOption.INSTANCE;
        mock = new SaleOnBoardProductAddOn("Vælg mælk", (List<SaleOnBoardProductAddOnOption>) CollectionsKt.listOf((Object[]) new SaleOnBoardProductAddOnOption[]{companion.getMock1(), companion.getMock2()}));
    }

    public /* synthetic */ SaleOnBoardProductAddOn(int i5, String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, SaleOnBoardProductAddOn$$serializer.INSTANCE.getDescriptor());
        }
        this.title = str;
        this.options = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SaleOnBoardProductAddOn copy$default(SaleOnBoardProductAddOn saleOnBoardProductAddOn, String str, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = saleOnBoardProductAddOn.title;
        }
        if ((i5 & 2) != 0) {
            list = saleOnBoardProductAddOn.options;
        }
        return saleOnBoardProductAddOn.copy(str, list);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(SaleOnBoardProductAddOn self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.title);
        output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.options);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final List<SaleOnBoardProductAddOnOption> component2() {
        return this.options;
    }

    public final SaleOnBoardProductAddOn copy(String title, List<SaleOnBoardProductAddOnOption> options) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(options, "options");
        return new SaleOnBoardProductAddOn(title, options);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleOnBoardProductAddOn)) {
            return false;
        }
        SaleOnBoardProductAddOn saleOnBoardProductAddOn = (SaleOnBoardProductAddOn) other;
        return Intrinsics.areEqual(this.title, saleOnBoardProductAddOn.title) && Intrinsics.areEqual(this.options, saleOnBoardProductAddOn.options);
    }

    public final List<SaleOnBoardProductAddOnOption> getOptions() {
        return this.options;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.options.hashCode();
    }

    public String toString() {
        return "SaleOnBoardProductAddOn(title=" + this.title + ", options=" + this.options + ")";
    }

    public SaleOnBoardProductAddOn(String title, List<SaleOnBoardProductAddOnOption> options) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(options, "options");
        this.title = title;
        this.options = options;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SaleOnBoardProductAddOn(ShopAndProductsResponseDTO.SaleOnBoardProductAddOnResponseDTO dto, CurrencyType currencyType) {
        this(r0, r1);
        Intrinsics.checkNotNullParameter(dto, "dto");
        Intrinsics.checkNotNullParameter(currencyType, "currencyType");
        String title = dto.getTitle();
        List<ShopAndProductsResponseDTO.SaleOnBoardProductAddOnSelectionResponseDTO> selections = dto.getSelections();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(selections, 10));
        Iterator<T> it = selections.iterator();
        while (it.hasNext()) {
            arrayList.add(SaleOnBoardProductAddOnOption.INSTANCE.invoke((ShopAndProductsResponseDTO.SaleOnBoardProductAddOnSelectionResponseDTO) it.next(), currencyType));
        }
    }
}
