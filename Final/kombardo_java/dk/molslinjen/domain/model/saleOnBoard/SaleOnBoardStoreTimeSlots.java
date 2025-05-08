package dk.molslinjen.domain.model.saleOnBoard;

import dk.molslinjen.api.services.saleOnBoard.response.TimeSlotsResponseDTO;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardTimeSlot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStoreTimeSlots;", BuildConfig.FLAVOR, "storeId", BuildConfig.FLAVOR, "timeSlots", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "dto", "Ldk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO$StoreTimeSlotsResponseDTO;", "(Ldk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO$StoreTimeSlotsResponseDTO;)V", "getStoreId", "()Ljava/lang/String;", "getTimeSlots", "()Ljava/util/List;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SaleOnBoardStoreTimeSlots {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SaleOnBoardStoreTimeSlots mock;
    private final String storeId;
    private final List<SaleOnBoardTimeSlot> timeSlots;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStoreTimeSlots$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStoreTimeSlots;", "getMock", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStoreTimeSlots;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaleOnBoardStoreTimeSlots getMock() {
            return SaleOnBoardStoreTimeSlots.mock;
        }

        private Companion() {
        }
    }

    static {
        SaleOnBoardTimeSlot.Companion companion = SaleOnBoardTimeSlot.INSTANCE;
        mock = new SaleOnBoardStoreTimeSlots("{FDB7A82B-A7D6-EC11-B856-005056873A34}", CollectionsKt.listOf((Object[]) new SaleOnBoardTimeSlot[]{companion.getMock1(), companion.getMock2(), companion.getMock3()}));
    }

    public SaleOnBoardStoreTimeSlots(String storeId, List<SaleOnBoardTimeSlot> timeSlots) {
        Intrinsics.checkNotNullParameter(storeId, "storeId");
        Intrinsics.checkNotNullParameter(timeSlots, "timeSlots");
        this.storeId = storeId;
        this.timeSlots = timeSlots;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SaleOnBoardStoreTimeSlots copy$default(SaleOnBoardStoreTimeSlots saleOnBoardStoreTimeSlots, String str, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = saleOnBoardStoreTimeSlots.storeId;
        }
        if ((i5 & 2) != 0) {
            list = saleOnBoardStoreTimeSlots.timeSlots;
        }
        return saleOnBoardStoreTimeSlots.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getStoreId() {
        return this.storeId;
    }

    public final List<SaleOnBoardTimeSlot> component2() {
        return this.timeSlots;
    }

    public final SaleOnBoardStoreTimeSlots copy(String storeId, List<SaleOnBoardTimeSlot> timeSlots) {
        Intrinsics.checkNotNullParameter(storeId, "storeId");
        Intrinsics.checkNotNullParameter(timeSlots, "timeSlots");
        return new SaleOnBoardStoreTimeSlots(storeId, timeSlots);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleOnBoardStoreTimeSlots)) {
            return false;
        }
        SaleOnBoardStoreTimeSlots saleOnBoardStoreTimeSlots = (SaleOnBoardStoreTimeSlots) other;
        return Intrinsics.areEqual(this.storeId, saleOnBoardStoreTimeSlots.storeId) && Intrinsics.areEqual(this.timeSlots, saleOnBoardStoreTimeSlots.timeSlots);
    }

    public final String getStoreId() {
        return this.storeId;
    }

    public final List<SaleOnBoardTimeSlot> getTimeSlots() {
        return this.timeSlots;
    }

    public int hashCode() {
        return (this.storeId.hashCode() * 31) + this.timeSlots.hashCode();
    }

    public String toString() {
        return "SaleOnBoardStoreTimeSlots(storeId=" + this.storeId + ", timeSlots=" + this.timeSlots + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SaleOnBoardStoreTimeSlots(TimeSlotsResponseDTO.StoreTimeSlotsResponseDTO dto) {
        this(r0, r1);
        Intrinsics.checkNotNullParameter(dto, "dto");
        String id = dto.getId();
        List<TimeSlotsResponseDTO.TimeSlotResponseDTO> timeSlots = dto.getTimeSlots();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(timeSlots, 10));
        Iterator<T> it = timeSlots.iterator();
        while (it.hasNext()) {
            arrayList.add(new SaleOnBoardTimeSlot((TimeSlotsResponseDTO.TimeSlotResponseDTO) it.next()));
        }
    }
}
