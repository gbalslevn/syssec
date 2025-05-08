package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.geolocator.response.TravelTimeResponseDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/domain/model/booking/TravelTime;", BuildConfig.FLAVOR, "travelMode", "Ldk/molslinjen/domain/model/booking/TravelMode;", "travelTimeMinutes", BuildConfig.FLAVOR, "travelTimeHours", "<init>", "(Ldk/molslinjen/domain/model/booking/TravelMode;II)V", "dto", "Ldk/molslinjen/api/services/geolocator/response/TravelTimeResponseDTO;", "(Ldk/molslinjen/api/services/geolocator/response/TravelTimeResponseDTO;)V", "getTravelMode", "()Ldk/molslinjen/domain/model/booking/TravelMode;", "getTravelTimeMinutes", "()I", "getTravelTimeHours", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TravelTime {
    private final TravelMode travelMode;
    private final int travelTimeHours;
    private final int travelTimeMinutes;

    public TravelTime(TravelMode travelMode, int i5, int i6) {
        Intrinsics.checkNotNullParameter(travelMode, "travelMode");
        this.travelMode = travelMode;
        this.travelTimeMinutes = i5;
        this.travelTimeHours = i6;
    }

    public static /* synthetic */ TravelTime copy$default(TravelTime travelTime, TravelMode travelMode, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            travelMode = travelTime.travelMode;
        }
        if ((i7 & 2) != 0) {
            i5 = travelTime.travelTimeMinutes;
        }
        if ((i7 & 4) != 0) {
            i6 = travelTime.travelTimeHours;
        }
        return travelTime.copy(travelMode, i5, i6);
    }

    /* renamed from: component1, reason: from getter */
    public final TravelMode getTravelMode() {
        return this.travelMode;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTravelTimeMinutes() {
        return this.travelTimeMinutes;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTravelTimeHours() {
        return this.travelTimeHours;
    }

    public final TravelTime copy(TravelMode travelMode, int travelTimeMinutes, int travelTimeHours) {
        Intrinsics.checkNotNullParameter(travelMode, "travelMode");
        return new TravelTime(travelMode, travelTimeMinutes, travelTimeHours);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TravelTime)) {
            return false;
        }
        TravelTime travelTime = (TravelTime) other;
        return this.travelMode == travelTime.travelMode && this.travelTimeMinutes == travelTime.travelTimeMinutes && this.travelTimeHours == travelTime.travelTimeHours;
    }

    public final TravelMode getTravelMode() {
        return this.travelMode;
    }

    public final int getTravelTimeHours() {
        return this.travelTimeHours;
    }

    public final int getTravelTimeMinutes() {
        return this.travelTimeMinutes;
    }

    public int hashCode() {
        return (((this.travelMode.hashCode() * 31) + Integer.hashCode(this.travelTimeMinutes)) * 31) + Integer.hashCode(this.travelTimeHours);
    }

    public String toString() {
        return "TravelTime(travelMode=" + this.travelMode + ", travelTimeMinutes=" + this.travelTimeMinutes + ", travelTimeHours=" + this.travelTimeHours + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TravelTime(TravelTimeResponseDTO dto) {
        this(TravelMode.INSTANCE.invoke(dto.getTravelMode()), dto.getTravelTimeMinutes(), dto.getTravelTimeHours());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
