package uniffi.molslinjen_shared;

import java.util.List;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H&J,\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H&¨\u0006\u0018"}, d2 = {"Luniffi/molslinjen_shared/SelectSeatingHelperInterface;", BuildConfig.FLAVOR, "findSeat", "Luniffi/molslinjen_shared/FerrySeat;", "floorPlan", "Luniffi/molslinjen_shared/FerryFloorPlan;", "seatId", "Luniffi/molslinjen_shared/FerrySeatId;", "findSeatGroup", "Luniffi/molslinjen_shared/FerrySeatingGroup;", "findSection", "Luniffi/molslinjen_shared/FerrySeatingSection;", "toDetails", "Luniffi/molslinjen_shared/FerrySeatingSectionDetails;", "section", "targetSeatSize", BuildConfig.FLAVOR, "toOverview", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeatingSectionOverview;", "sections", "targetWidth", "targetHeight", "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SelectSeatingHelperInterface {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Luniffi/molslinjen_shared/SelectSeatingHelperInterface$Companion;", BuildConfig.FLAVOR, "()V", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    FerrySeat findSeat(FerryFloorPlan floorPlan, FerrySeatId seatId);

    FerrySeatingGroup findSeatGroup(FerryFloorPlan floorPlan, FerrySeatId seatId);

    FerrySeatingSection findSection(FerryFloorPlan floorPlan, FerrySeatId seatId);

    FerrySeatingSectionDetails toDetails(FerrySeatingSection section, double targetSeatSize);

    List<FerrySeatingSectionOverview> toOverview(List<FerrySeatingSection> sections, double targetWidth, double targetHeight);
}
