package dk.molslinjen.domain.model.booking.product;

import dk.molslinjen.api.services.booking.response.product.ProductTagDTO;
import dk.molslinjen.domain.model.shared.HexColor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/ProductTag;", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "backgroundColour", "Ldk/molslinjen/domain/model/shared/HexColor;", "<init>", "(Ljava/lang/String;Ldk/molslinjen/domain/model/shared/HexColor;)V", "dto", "Ldk/molslinjen/api/services/booking/response/product/ProductTagDTO;", "(Ldk/molslinjen/api/services/booking/response/product/ProductTagDTO;)V", "getName", "()Ljava/lang/String;", "getBackgroundColour", "()Ldk/molslinjen/domain/model/shared/HexColor;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ProductTag {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ProductTag mock = new ProductTag("Populært", new HexColor("FFD689"));
    private static final ProductTag mockRecommended = new ProductTag("Vi anbefaler", new HexColor("16F6A5"));
    private final HexColor backgroundColour;
    private final String name;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/ProductTag$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/product/ProductTag;", "getMock", "()Ldk/molslinjen/domain/model/booking/product/ProductTag;", "mockRecommended", "getMockRecommended", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProductTag getMock() {
            return ProductTag.mock;
        }

        public final ProductTag getMockRecommended() {
            return ProductTag.mockRecommended;
        }

        private Companion() {
        }
    }

    public ProductTag(String name, HexColor backgroundColour) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(backgroundColour, "backgroundColour");
        this.name = name;
        this.backgroundColour = backgroundColour;
    }

    public static /* synthetic */ ProductTag copy$default(ProductTag productTag, String str, HexColor hexColor, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = productTag.name;
        }
        if ((i5 & 2) != 0) {
            hexColor = productTag.backgroundColour;
        }
        return productTag.copy(str, hexColor);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final HexColor getBackgroundColour() {
        return this.backgroundColour;
    }

    public final ProductTag copy(String name, HexColor backgroundColour) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(backgroundColour, "backgroundColour");
        return new ProductTag(name, backgroundColour);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProductTag)) {
            return false;
        }
        ProductTag productTag = (ProductTag) other;
        return Intrinsics.areEqual(this.name, productTag.name) && Intrinsics.areEqual(this.backgroundColour, productTag.backgroundColour);
    }

    public final HexColor getBackgroundColour() {
        return this.backgroundColour;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.backgroundColour.hashCode();
    }

    public String toString() {
        return "ProductTag(name=" + this.name + ", backgroundColour=" + this.backgroundColour + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProductTag(ProductTagDTO dto) {
        this(dto.getName(), new HexColor(dto.getBackgroundColour()));
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
