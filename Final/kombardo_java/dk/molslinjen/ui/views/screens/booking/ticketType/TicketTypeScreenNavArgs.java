package dk.molslinjen.ui.views.screens.booking.ticketType;

import dk.molslinjen.domain.model.booking.DepartureDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeScreenNavArgs;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "departureId", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "direction", "<init>", "(Ljava/lang/String;Ldk/molslinjen/domain/model/booking/DepartureDirection;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDepartureId", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "getDirection", "()Ldk/molslinjen/domain/model/booking/DepartureDirection;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TicketTypeScreenNavArgs {
    private final String departureId;
    private final DepartureDirection direction;

    public TicketTypeScreenNavArgs(String departureId, DepartureDirection direction) {
        Intrinsics.checkNotNullParameter(departureId, "departureId");
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.departureId = departureId;
        this.direction = direction;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TicketTypeScreenNavArgs)) {
            return false;
        }
        TicketTypeScreenNavArgs ticketTypeScreenNavArgs = (TicketTypeScreenNavArgs) other;
        return Intrinsics.areEqual(this.departureId, ticketTypeScreenNavArgs.departureId) && this.direction == ticketTypeScreenNavArgs.direction;
    }

    public final String getDepartureId() {
        return this.departureId;
    }

    public final DepartureDirection getDirection() {
        return this.direction;
    }

    public int hashCode() {
        return (this.departureId.hashCode() * 31) + this.direction.hashCode();
    }

    public String toString() {
        return "TicketTypeScreenNavArgs(departureId=" + this.departureId + ", direction=" + this.direction + ")";
    }
}
