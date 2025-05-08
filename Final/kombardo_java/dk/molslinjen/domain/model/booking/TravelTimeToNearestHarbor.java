package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.geolocator.response.TravelTimeResponseDTO;
import dk.molslinjen.api.services.geolocator.response.TravelTimeToNearestHarborResponseDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/domain/model/booking/TravelTimeToNearestHarbor;", BuildConfig.FLAVOR, "harborName", BuildConfig.FLAVOR, "travelTimes", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/TravelTime;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "dto", "Ldk/molslinjen/api/services/geolocator/response/TravelTimeToNearestHarborResponseDTO;", "(Ldk/molslinjen/api/services/geolocator/response/TravelTimeToNearestHarborResponseDTO;)V", "getHarborName", "()Ljava/lang/String;", "getTravelTimes", "()Ljava/util/List;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TravelTimeToNearestHarbor {
    private final String harborName;
    private final List<TravelTime> travelTimes;

    public TravelTimeToNearestHarbor(String harborName, List<TravelTime> travelTimes) {
        Intrinsics.checkNotNullParameter(harborName, "harborName");
        Intrinsics.checkNotNullParameter(travelTimes, "travelTimes");
        this.harborName = harborName;
        this.travelTimes = travelTimes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TravelTimeToNearestHarbor copy$default(TravelTimeToNearestHarbor travelTimeToNearestHarbor, String str, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = travelTimeToNearestHarbor.harborName;
        }
        if ((i5 & 2) != 0) {
            list = travelTimeToNearestHarbor.travelTimes;
        }
        return travelTimeToNearestHarbor.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getHarborName() {
        return this.harborName;
    }

    public final List<TravelTime> component2() {
        return this.travelTimes;
    }

    public final TravelTimeToNearestHarbor copy(String harborName, List<TravelTime> travelTimes) {
        Intrinsics.checkNotNullParameter(harborName, "harborName");
        Intrinsics.checkNotNullParameter(travelTimes, "travelTimes");
        return new TravelTimeToNearestHarbor(harborName, travelTimes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TravelTimeToNearestHarbor)) {
            return false;
        }
        TravelTimeToNearestHarbor travelTimeToNearestHarbor = (TravelTimeToNearestHarbor) other;
        return Intrinsics.areEqual(this.harborName, travelTimeToNearestHarbor.harborName) && Intrinsics.areEqual(this.travelTimes, travelTimeToNearestHarbor.travelTimes);
    }

    public final String getHarborName() {
        return this.harborName;
    }

    public final List<TravelTime> getTravelTimes() {
        return this.travelTimes;
    }

    public int hashCode() {
        return (this.harborName.hashCode() * 31) + this.travelTimes.hashCode();
    }

    public String toString() {
        return "TravelTimeToNearestHarbor(harborName=" + this.harborName + ", travelTimes=" + this.travelTimes + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TravelTimeToNearestHarbor(TravelTimeToNearestHarborResponseDTO dto) {
        this(r0, r1);
        Intrinsics.checkNotNullParameter(dto, "dto");
        String harborName = dto.getHarborName();
        List<TravelTimeResponseDTO> travels = dto.getTravels();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(travels, 10));
        Iterator<T> it = travels.iterator();
        while (it.hasNext()) {
            arrayList.add(new TravelTime((TravelTimeResponseDTO) it.next()));
        }
    }
}
