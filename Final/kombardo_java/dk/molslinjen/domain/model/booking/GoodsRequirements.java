package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.response.TransportProductsResponseDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/domain/model/booking/GoodsRequirements;", BuildConfig.FLAVOR, "isWeightRequired", BuildConfig.FLAVOR, "maxWeight", BuildConfig.FLAVOR, "<init>", "(ZD)V", "dto", "Ldk/molslinjen/api/services/booking/response/TransportProductsResponseDTO$GoodsResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/TransportProductsResponseDTO$GoodsResponseDTO;)V", "()Z", "getMaxWeight", "()D", "component1", "component2", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class GoodsRequirements {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final GoodsRequirements mock = new GoodsRequirements(false, 40.0d);
    private final boolean isWeightRequired;
    private final double maxWeight;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/GoodsRequirements$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/GoodsRequirements;", "getMock", "()Ldk/molslinjen/domain/model/booking/GoodsRequirements;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GoodsRequirements getMock() {
            return GoodsRequirements.mock;
        }

        private Companion() {
        }
    }

    public GoodsRequirements(boolean z5, double d5) {
        this.isWeightRequired = z5;
        this.maxWeight = d5;
    }

    public static /* synthetic */ GoodsRequirements copy$default(GoodsRequirements goodsRequirements, boolean z5, double d5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = goodsRequirements.isWeightRequired;
        }
        if ((i5 & 2) != 0) {
            d5 = goodsRequirements.maxWeight;
        }
        return goodsRequirements.copy(z5, d5);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsWeightRequired() {
        return this.isWeightRequired;
    }

    /* renamed from: component2, reason: from getter */
    public final double getMaxWeight() {
        return this.maxWeight;
    }

    public final GoodsRequirements copy(boolean isWeightRequired, double maxWeight) {
        return new GoodsRequirements(isWeightRequired, maxWeight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoodsRequirements)) {
            return false;
        }
        GoodsRequirements goodsRequirements = (GoodsRequirements) other;
        return this.isWeightRequired == goodsRequirements.isWeightRequired && Double.compare(this.maxWeight, goodsRequirements.maxWeight) == 0;
    }

    public final double getMaxWeight() {
        return this.maxWeight;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.isWeightRequired) * 31) + Double.hashCode(this.maxWeight);
    }

    public final boolean isWeightRequired() {
        return this.isWeightRequired;
    }

    public String toString() {
        return "GoodsRequirements(isWeightRequired=" + this.isWeightRequired + ", maxWeight=" + this.maxWeight + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GoodsRequirements(TransportProductsResponseDTO.GoodsResponseDTO dto) {
        this(dto.isWeightRequired(), dto.getMaxWeight());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
