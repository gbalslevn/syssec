package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.response.DeparturesResponseDTO;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/domain/model/booking/Fee;", BuildConfig.FLAVOR, "text", BuildConfig.FLAVOR, "price", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "<init>", "(Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;)V", "dto", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$FeeResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$FeeResponseDTO;)V", "getText", "()Ljava/lang/String;", "getPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Fee {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Fee mock = new Fee("Gebyr", PriceWithCurrency.INSTANCE.mock(30));
    private final PriceWithCurrency price;
    private final String text;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/Fee$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/Fee;", "getMock", "()Ldk/molslinjen/domain/model/booking/Fee;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Fee getMock() {
            return Fee.mock;
        }

        private Companion() {
        }
    }

    public Fee(String text, PriceWithCurrency price) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(price, "price");
        this.text = text;
        this.price = price;
    }

    public static /* synthetic */ Fee copy$default(Fee fee, String str, PriceWithCurrency priceWithCurrency, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = fee.text;
        }
        if ((i5 & 2) != 0) {
            priceWithCurrency = fee.price;
        }
        return fee.copy(str, priceWithCurrency);
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component2, reason: from getter */
    public final PriceWithCurrency getPrice() {
        return this.price;
    }

    public final Fee copy(String text, PriceWithCurrency price) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(price, "price");
        return new Fee(text, price);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Fee)) {
            return false;
        }
        Fee fee = (Fee) other;
        return Intrinsics.areEqual(this.text, fee.text) && Intrinsics.areEqual(this.price, fee.price);
    }

    public final PriceWithCurrency getPrice() {
        return this.price;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.price.hashCode();
    }

    public String toString() {
        return "Fee(text=" + this.text + ", price=" + this.price + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Fee(DeparturesResponseDTO.FeeResponseDTO dto) {
        this(dto.getText(), new PriceWithCurrency(dto.getPrice()));
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
