package dk.molslinjen.domain.model.saleOnBoard;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.saleOnBoard.response.ShopAndProductsResponseDTO;
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

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002%&B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB9\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0006\u0010\u000fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\fHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006'"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariant;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "imageUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$VariantResponseDTO;", "(Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO$VariantResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "getImageUrl", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class SaleOnBoardVariant {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SaleOnBoardVariant mock1 = new SaleOnBoardVariant("{91C734FE-28B4-EC11-864C-005056012047}", "Uden Flødeskum", "https://molslinjen.blob.core.windows.net/images/variant/91c734fe-28b4-ec11-864c-005056012047.png");
    private static final SaleOnBoardVariant mock2 = new SaleOnBoardVariant("{525DFF25-B2B4-EC11-864C-005056012047}", "Med Flødeskum", "https://molslinjen.blob.core.windows.net/images/variant/525dff25-b2b4-ec11-864c-005056012047.png");
    private final String id;
    private final String imageUrl;
    private final String name;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariant$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock1", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariant;", "getMock1", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariant;", "mock2", "getMock2", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaleOnBoardVariant getMock1() {
            return SaleOnBoardVariant.mock1;
        }

        public final SaleOnBoardVariant getMock2() {
            return SaleOnBoardVariant.mock2;
        }

        public final KSerializer<SaleOnBoardVariant> serializer() {
            return SaleOnBoardVariant$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SaleOnBoardVariant(int i5, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, SaleOnBoardVariant$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.name = str2;
        this.imageUrl = str3;
    }

    public static /* synthetic */ SaleOnBoardVariant copy$default(SaleOnBoardVariant saleOnBoardVariant, String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = saleOnBoardVariant.id;
        }
        if ((i5 & 2) != 0) {
            str2 = saleOnBoardVariant.name;
        }
        if ((i5 & 4) != 0) {
            str3 = saleOnBoardVariant.imageUrl;
        }
        return saleOnBoardVariant.copy(str, str2, str3);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(SaleOnBoardVariant self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.name);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.imageUrl);
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
    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final SaleOnBoardVariant copy(String id, String name, String imageUrl) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new SaleOnBoardVariant(id, name, imageUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleOnBoardVariant)) {
            return false;
        }
        SaleOnBoardVariant saleOnBoardVariant = (SaleOnBoardVariant) other;
        return Intrinsics.areEqual(this.id, saleOnBoardVariant.id) && Intrinsics.areEqual(this.name, saleOnBoardVariant.name) && Intrinsics.areEqual(this.imageUrl, saleOnBoardVariant.imageUrl);
    }

    public final String getId() {
        return this.id;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int hashCode = ((this.id.hashCode() * 31) + this.name.hashCode()) * 31;
        String str = this.imageUrl;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SaleOnBoardVariant(id=" + this.id + ", name=" + this.name + ", imageUrl=" + this.imageUrl + ")";
    }

    public SaleOnBoardVariant(String id, String name, String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.name = name;
        this.imageUrl = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardVariant(ShopAndProductsResponseDTO.VariantResponseDTO dto) {
        this(dto.getId(), dto.getDescription(), dto.getImageUrl());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
