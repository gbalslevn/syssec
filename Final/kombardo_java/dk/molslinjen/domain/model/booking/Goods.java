package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/domain/model/booking/Goods;", BuildConfig.FLAVOR, "weight", BuildConfig.FLAVOR, "weightFee", BuildConfig.FLAVOR, "<init>", "(DI)V", "dto", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$GoodsResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO$GoodsResponseDTO;)V", "getWeight", "()D", "getWeightFee", "()I", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Goods {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Goods mock = new Goods(40.0d, 50);
    private final double weight;
    private final int weightFee;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/Goods$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/Goods;", "getMock", "()Ldk/molslinjen/domain/model/booking/Goods;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Goods getMock() {
            return Goods.mock;
        }

        private Companion() {
        }
    }

    public Goods(double d5, int i5) {
        this.weight = d5;
        this.weightFee = i5;
    }

    public static /* synthetic */ Goods copy$default(Goods goods, double d5, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            d5 = goods.weight;
        }
        if ((i6 & 2) != 0) {
            i5 = goods.weightFee;
        }
        return goods.copy(d5, i5);
    }

    /* renamed from: component1, reason: from getter */
    public final double getWeight() {
        return this.weight;
    }

    /* renamed from: component2, reason: from getter */
    public final int getWeightFee() {
        return this.weightFee;
    }

    public final Goods copy(double weight, int weightFee) {
        return new Goods(weight, weightFee);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Goods)) {
            return false;
        }
        Goods goods = (Goods) other;
        return Double.compare(this.weight, goods.weight) == 0 && this.weightFee == goods.weightFee;
    }

    public final double getWeight() {
        return this.weight;
    }

    public final int getWeightFee() {
        return this.weightFee;
    }

    public int hashCode() {
        return (Double.hashCode(this.weight) * 31) + Integer.hashCode(this.weightFee);
    }

    public String toString() {
        return "Goods(weight=" + this.weight + ", weightFee=" + this.weightFee + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Goods(BookingResponseDTO.GoodsResponseDTO dto) {
        this(dto.getWeight(), (int) dto.getWeightFee());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
