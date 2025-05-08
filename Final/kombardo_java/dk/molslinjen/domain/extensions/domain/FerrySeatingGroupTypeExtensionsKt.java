package dk.molslinjen.domain.extensions.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeat;
import uniffi.molslinjen_shared.FerrySeatingGroupType;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"seats", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeat;", "Luniffi/molslinjen_shared/FerrySeatingGroupType;", "getSeats", "(Luniffi/molslinjen_shared/FerrySeatingGroupType;)Ljava/util/List;", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FerrySeatingGroupTypeExtensionsKt {
    public static final List<FerrySeat> getSeats(FerrySeatingGroupType ferrySeatingGroupType) {
        Intrinsics.checkNotNullParameter(ferrySeatingGroupType, "<this>");
        if (ferrySeatingGroupType instanceof FerrySeatingGroupType.CornerTable) {
            FerrySeatingGroupType.CornerTable cornerTable = (FerrySeatingGroupType.CornerTable) ferrySeatingGroupType;
            return CollectionsKt.listOf((Object[]) new FerrySeat[]{cornerTable.getTopLeft(), cornerTable.getTopRight(), cornerTable.getMiddle(), cornerTable.getBottomLeft(), cornerTable.getBottomRight()});
        }
        if (ferrySeatingGroupType instanceof FerrySeatingGroupType.CornerTableLarge) {
            FerrySeatingGroupType.CornerTableLarge cornerTableLarge = (FerrySeatingGroupType.CornerTableLarge) ferrySeatingGroupType;
            return CollectionsKt.listOf((Object[]) new FerrySeat[]{cornerTableLarge.getTopLeft(), cornerTableLarge.getTopMiddle(), cornerTableLarge.getTopRight(), cornerTableLarge.getMiddle(), cornerTableLarge.getBottomLeft(), cornerTableLarge.getBottomMiddle(), cornerTableLarge.getBottomRight()});
        }
        if (ferrySeatingGroupType instanceof FerrySeatingGroupType.DoubleSeat) {
            FerrySeatingGroupType.DoubleSeat doubleSeat = (FerrySeatingGroupType.DoubleSeat) ferrySeatingGroupType;
            return CollectionsKt.listOf((Object[]) new FerrySeat[]{doubleSeat.getLeft(), doubleSeat.getRight()});
        }
        if (ferrySeatingGroupType instanceof FerrySeatingGroupType.LargeTable) {
            FerrySeatingGroupType.LargeTable largeTable = (FerrySeatingGroupType.LargeTable) ferrySeatingGroupType;
            return CollectionsKt.listOf((Object[]) new FerrySeat[]{largeTable.getTopLeft(), largeTable.getTopRight(), largeTable.getBottomLeft(), largeTable.getBottomRight()});
        }
        if (ferrySeatingGroupType instanceof FerrySeatingGroupType.SingleSeat) {
            return CollectionsKt.listOf(((FerrySeatingGroupType.SingleSeat) ferrySeatingGroupType).getSeat());
        }
        if (ferrySeatingGroupType instanceof FerrySeatingGroupType.SmallTable) {
            FerrySeatingGroupType.SmallTable smallTable = (FerrySeatingGroupType.SmallTable) ferrySeatingGroupType;
            return CollectionsKt.listOf((Object[]) new FerrySeat[]{smallTable.getTop(), smallTable.getBottom()});
        }
        if (!(ferrySeatingGroupType instanceof FerrySeatingGroupType.XLargeTable)) {
            throw new NoWhenBranchMatchedException();
        }
        FerrySeatingGroupType.XLargeTable xLargeTable = (FerrySeatingGroupType.XLargeTable) ferrySeatingGroupType;
        return CollectionsKt.listOf((Object[]) new FerrySeat[]{xLargeTable.getTopLeft(), xLargeTable.getTopMiddle(), xLargeTable.getTopRight(), xLargeTable.getBottomLeft(), xLargeTable.getBottomMiddle(), xLargeTable.getBottomRight()});
    }
}
