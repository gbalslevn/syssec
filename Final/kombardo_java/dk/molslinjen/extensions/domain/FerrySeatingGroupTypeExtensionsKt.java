package dk.molslinjen.extensions.domain;

import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeatingGroupType;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"tableRes", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeatingGroupType;", "getTableRes", "(Luniffi/molslinjen_shared/FerrySeatingGroupType;)Ljava/lang/Integer;", "numberOfSeatsInGroup", "getNumberOfSeatsInGroup", "(Luniffi/molslinjen_shared/FerrySeatingGroupType;)I", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FerrySeatingGroupTypeExtensionsKt {
    public static final int getNumberOfSeatsInGroup(FerrySeatingGroupType ferrySeatingGroupType) {
        Intrinsics.checkNotNullParameter(ferrySeatingGroupType, "<this>");
        if (ferrySeatingGroupType instanceof FerrySeatingGroupType.SingleSeat) {
            return 1;
        }
        if ((ferrySeatingGroupType instanceof FerrySeatingGroupType.DoubleSeat) || (ferrySeatingGroupType instanceof FerrySeatingGroupType.SmallTable)) {
            return 2;
        }
        if (ferrySeatingGroupType instanceof FerrySeatingGroupType.CornerTable) {
            return 5;
        }
        if (ferrySeatingGroupType instanceof FerrySeatingGroupType.LargeTable) {
            return 4;
        }
        if (ferrySeatingGroupType instanceof FerrySeatingGroupType.CornerTableLarge) {
            return 7;
        }
        if (ferrySeatingGroupType instanceof FerrySeatingGroupType.XLargeTable) {
            return 6;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Integer getTableRes(FerrySeatingGroupType ferrySeatingGroupType) {
        Intrinsics.checkNotNullParameter(ferrySeatingGroupType, "<this>");
        if ((ferrySeatingGroupType instanceof FerrySeatingGroupType.SingleSeat) || (ferrySeatingGroupType instanceof FerrySeatingGroupType.DoubleSeat)) {
            return null;
        }
        if ((ferrySeatingGroupType instanceof FerrySeatingGroupType.SmallTable) || (ferrySeatingGroupType instanceof FerrySeatingGroupType.CornerTable)) {
            return Integer.valueOf(R.drawable.seat_table_single);
        }
        if ((ferrySeatingGroupType instanceof FerrySeatingGroupType.LargeTable) || (ferrySeatingGroupType instanceof FerrySeatingGroupType.CornerTableLarge)) {
            return Integer.valueOf(R.drawable.seat_table_double);
        }
        if (ferrySeatingGroupType instanceof FerrySeatingGroupType.XLargeTable) {
            return Integer.valueOf(R.drawable.seat_table_triple);
        }
        throw new NoWhenBranchMatchedException();
    }
}
