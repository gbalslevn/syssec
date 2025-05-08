package dk.molslinjen.domain.model.saleOnBoard;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.saleOnBoard.response.ShopAndProductsResponseDTO;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardVariant;
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

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002()B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fB?\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\b\u0010\u0011J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J-\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u000eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013¨\u0006*"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariants;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "variants", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariant;", Constants.IntentExtra.PushTitle, "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$VariantsResponseDTO;", "(Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$VariantsResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getVariants", "()Ljava/util/List;", "getTitle", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class SaleOnBoardVariants {
    private static final SaleOnBoardVariants mock;
    private final String id;
    private final String title;
    private final List<SaleOnBoardVariant> variants;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(SaleOnBoardVariant$$serializer.INSTANCE), null};

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariants$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariants;", "getMock", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariants;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaleOnBoardVariants getMock() {
            return SaleOnBoardVariants.mock;
        }

        public final KSerializer<SaleOnBoardVariants> serializer() {
            return SaleOnBoardVariants$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        SaleOnBoardVariant.Companion companion = SaleOnBoardVariant.INSTANCE;
        mock = new SaleOnBoardVariants("{7F093BC6-29B4-EC11-864C-005056012047}", CollectionsKt.listOf((Object[]) new SaleOnBoardVariant[]{companion.getMock1(), companion.getMock2()}), "Flødeskum?");
    }

    public /* synthetic */ SaleOnBoardVariants(int i5, String str, List list, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, SaleOnBoardVariants$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.variants = list;
        this.title = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SaleOnBoardVariants copy$default(SaleOnBoardVariants saleOnBoardVariants, String str, List list, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = saleOnBoardVariants.id;
        }
        if ((i5 & 2) != 0) {
            list = saleOnBoardVariants.variants;
        }
        if ((i5 & 4) != 0) {
            str2 = saleOnBoardVariants.title;
        }
        return saleOnBoardVariants.copy(str, list, str2);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(SaleOnBoardVariants self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.variants);
        output.encodeStringElement(serialDesc, 2, self.title);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<SaleOnBoardVariant> component2() {
        return this.variants;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final SaleOnBoardVariants copy(String id, List<SaleOnBoardVariant> variants, String title) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(variants, "variants");
        Intrinsics.checkNotNullParameter(title, "title");
        return new SaleOnBoardVariants(id, variants, title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleOnBoardVariants)) {
            return false;
        }
        SaleOnBoardVariants saleOnBoardVariants = (SaleOnBoardVariants) other;
        return Intrinsics.areEqual(this.id, saleOnBoardVariants.id) && Intrinsics.areEqual(this.variants, saleOnBoardVariants.variants) && Intrinsics.areEqual(this.title, saleOnBoardVariants.title);
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<SaleOnBoardVariant> getVariants() {
        return this.variants;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.variants.hashCode()) * 31) + this.title.hashCode();
    }

    public String toString() {
        return "SaleOnBoardVariants(id=" + this.id + ", variants=" + this.variants + ", title=" + this.title + ")";
    }

    public SaleOnBoardVariants(String id, List<SaleOnBoardVariant> variants, String title) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(variants, "variants");
        Intrinsics.checkNotNullParameter(title, "title");
        this.id = id;
        this.variants = variants;
        this.title = title;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SaleOnBoardVariants(ShopAndProductsResponseDTO.VariantsResponseDTO dto) {
        this(r0, r2, dto.getTitle());
        Intrinsics.checkNotNullParameter(dto, "dto");
        String id = dto.getId();
        List<ShopAndProductsResponseDTO.VariantResponseDTO> variants = dto.getVariants();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(variants, 10));
        Iterator<T> it = variants.iterator();
        while (it.hasNext()) {
            arrayList.add(new SaleOnBoardVariant((ShopAndProductsResponseDTO.VariantResponseDTO) it.next()));
        }
    }
}
