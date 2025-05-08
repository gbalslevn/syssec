package dk.molslinjen.domain.managers.seating;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/managers/seating/SelectSeatingManagerError;", BuildConfig.FLAVOR, "<init>", "()V", "SeatLimitReached", "Ldk/molslinjen/domain/managers/seating/SelectSeatingManagerError$SeatLimitReached;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SelectSeatingManagerError {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/managers/seating/SelectSeatingManagerError$SeatLimitReached;", "Ldk/molslinjen/domain/managers/seating/SelectSeatingManagerError;", "<init>", "()V", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class SeatLimitReached extends SelectSeatingManagerError {
        public static final SeatLimitReached INSTANCE = new SeatLimitReached();

        private SeatLimitReached() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof SeatLimitReached);
        }

        public int hashCode() {
            return -24322535;
        }

        public String toString() {
            return "SeatLimitReached";
        }
    }

    public /* synthetic */ SelectSeatingManagerError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SelectSeatingManagerError() {
    }
}
