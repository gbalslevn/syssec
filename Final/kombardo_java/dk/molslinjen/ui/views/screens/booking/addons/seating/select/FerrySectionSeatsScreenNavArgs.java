package dk.molslinjen.ui.views.screens.booking.addons.seating.select;

import androidx.compose.ui.geometry.Offset;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeatingSectionId;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsScreenNavArgs;", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeatingSectionId;", "sectionId", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "direction", "Landroidx/compose/ui/geometry/Offset;", "offset", "<init>", "(Luniffi/molslinjen_shared/FerrySeatingSectionId;Ldk/molslinjen/domain/model/booking/DepartureDirection;Landroidx/compose/ui/geometry/Offset;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Luniffi/molslinjen_shared/FerrySeatingSectionId;", "getSectionId", "()Luniffi/molslinjen_shared/FerrySeatingSectionId;", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "getDirection", "()Ldk/molslinjen/domain/model/booking/DepartureDirection;", "Landroidx/compose/ui/geometry/Offset;", "getOffset-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class FerrySectionSeatsScreenNavArgs {
    private final DepartureDirection direction;
    private final Offset offset;
    private final FerrySeatingSectionId sectionId;

    public /* synthetic */ FerrySectionSeatsScreenNavArgs(FerrySeatingSectionId ferrySeatingSectionId, DepartureDirection departureDirection, Offset offset, DefaultConstructorMarker defaultConstructorMarker) {
        this(ferrySeatingSectionId, departureDirection, offset);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FerrySectionSeatsScreenNavArgs)) {
            return false;
        }
        FerrySectionSeatsScreenNavArgs ferrySectionSeatsScreenNavArgs = (FerrySectionSeatsScreenNavArgs) other;
        return Intrinsics.areEqual(this.sectionId, ferrySectionSeatsScreenNavArgs.sectionId) && this.direction == ferrySectionSeatsScreenNavArgs.direction && Intrinsics.areEqual(this.offset, ferrySectionSeatsScreenNavArgs.offset);
    }

    public final DepartureDirection getDirection() {
        return this.direction;
    }

    /* renamed from: getOffset-_m7T9-E, reason: not valid java name and from getter */
    public final Offset getOffset() {
        return this.offset;
    }

    public final FerrySeatingSectionId getSectionId() {
        return this.sectionId;
    }

    public int hashCode() {
        FerrySeatingSectionId ferrySeatingSectionId = this.sectionId;
        int hashCode = (((ferrySeatingSectionId == null ? 0 : ferrySeatingSectionId.hashCode()) * 31) + this.direction.hashCode()) * 31;
        Offset offset = this.offset;
        return hashCode + (offset != null ? Offset.m1339hashCodeimpl(offset.getPackedValue()) : 0);
    }

    public String toString() {
        return "FerrySectionSeatsScreenNavArgs(sectionId=" + this.sectionId + ", direction=" + this.direction + ", offset=" + this.offset + ")";
    }

    private FerrySectionSeatsScreenNavArgs(FerrySeatingSectionId ferrySeatingSectionId, DepartureDirection direction, Offset offset) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.sectionId = ferrySeatingSectionId;
        this.direction = direction;
        this.offset = offset;
    }
}
