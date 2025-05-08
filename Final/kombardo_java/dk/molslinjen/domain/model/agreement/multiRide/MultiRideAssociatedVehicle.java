package dk.molslinjen.domain.model.agreement.multiRide;

import dk.molslinjen.api.services.multiRide.response.MultiRideVehicleResponseDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideAssociatedVehicle;", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "licensePlate", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/multiRide/response/MultiRideVehicleResponseDTO;", "(Ldk/molslinjen/api/services/multiRide/response/MultiRideVehicleResponseDTO;)V", "getName", "()Ljava/lang/String;", "getLicensePlate", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MultiRideAssociatedVehicle {
    private final String licensePlate;
    private final String name;

    public MultiRideAssociatedVehicle(String name, String licensePlate) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(licensePlate, "licensePlate");
        this.name = name;
        this.licensePlate = licensePlate;
    }

    public static /* synthetic */ MultiRideAssociatedVehicle copy$default(MultiRideAssociatedVehicle multiRideAssociatedVehicle, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = multiRideAssociatedVehicle.name;
        }
        if ((i5 & 2) != 0) {
            str2 = multiRideAssociatedVehicle.licensePlate;
        }
        return multiRideAssociatedVehicle.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLicensePlate() {
        return this.licensePlate;
    }

    public final MultiRideAssociatedVehicle copy(String name, String licensePlate) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(licensePlate, "licensePlate");
        return new MultiRideAssociatedVehicle(name, licensePlate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiRideAssociatedVehicle)) {
            return false;
        }
        MultiRideAssociatedVehicle multiRideAssociatedVehicle = (MultiRideAssociatedVehicle) other;
        return Intrinsics.areEqual(this.name, multiRideAssociatedVehicle.name) && Intrinsics.areEqual(this.licensePlate, multiRideAssociatedVehicle.licensePlate);
    }

    public final String getLicensePlate() {
        return this.licensePlate;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.licensePlate.hashCode();
    }

    public String toString() {
        return "MultiRideAssociatedVehicle(name=" + this.name + ", licensePlate=" + this.licensePlate + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiRideAssociatedVehicle(MultiRideVehicleResponseDTO dto) {
        this(dto.getName(), dto.getLicensePlate());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
