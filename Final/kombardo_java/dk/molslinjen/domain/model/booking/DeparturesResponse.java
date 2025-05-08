package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.response.DeparturesResponseDTO;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB!\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\t\u0010\u0010J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Ldk/molslinjen/domain/model/booking/DeparturesResponse;", BuildConfig.FLAVOR, "departures", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/Departure;", "timeTableStatus", "Ldk/molslinjen/domain/model/booking/TimeTableStatus;", "siteDeparturesNotice", BuildConfig.FLAVOR, "<init>", "(Ljava/util/List;Ldk/molslinjen/domain/model/booking/TimeTableStatus;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO;", "isMultiRide", BuildConfig.FLAVOR, "isEdit", "(Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO;ZZ)V", "getDepartures", "()Ljava/util/List;", "getTimeTableStatus", "()Ldk/molslinjen/domain/model/booking/TimeTableStatus;", "getSiteDeparturesNotice", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DeparturesResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DeparturesResponse mock = new DeparturesResponse((List<Departure>) CollectionsKt.listOf(Departure.INSTANCE.getMock()), TimeTableStatus.Available, "In **December** it *sometimes* rains, however **sometimes** it ***snows*** instead.");
    private final List<Departure> departures;
    private final String siteDeparturesNotice;
    private final TimeTableStatus timeTableStatus;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/DeparturesResponse$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/DeparturesResponse;", "getMock", "()Ldk/molslinjen/domain/model/booking/DeparturesResponse;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DeparturesResponse getMock() {
            return DeparturesResponse.mock;
        }

        private Companion() {
        }
    }

    public DeparturesResponse(List<Departure> departures, TimeTableStatus timeTableStatus, String str) {
        Intrinsics.checkNotNullParameter(departures, "departures");
        Intrinsics.checkNotNullParameter(timeTableStatus, "timeTableStatus");
        this.departures = departures;
        this.timeTableStatus = timeTableStatus;
        this.siteDeparturesNotice = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeparturesResponse copy$default(DeparturesResponse departuresResponse, List list, TimeTableStatus timeTableStatus, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            list = departuresResponse.departures;
        }
        if ((i5 & 2) != 0) {
            timeTableStatus = departuresResponse.timeTableStatus;
        }
        if ((i5 & 4) != 0) {
            str = departuresResponse.siteDeparturesNotice;
        }
        return departuresResponse.copy(list, timeTableStatus, str);
    }

    public final List<Departure> component1() {
        return this.departures;
    }

    /* renamed from: component2, reason: from getter */
    public final TimeTableStatus getTimeTableStatus() {
        return this.timeTableStatus;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSiteDeparturesNotice() {
        return this.siteDeparturesNotice;
    }

    public final DeparturesResponse copy(List<Departure> departures, TimeTableStatus timeTableStatus, String siteDeparturesNotice) {
        Intrinsics.checkNotNullParameter(departures, "departures");
        Intrinsics.checkNotNullParameter(timeTableStatus, "timeTableStatus");
        return new DeparturesResponse(departures, timeTableStatus, siteDeparturesNotice);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeparturesResponse)) {
            return false;
        }
        DeparturesResponse departuresResponse = (DeparturesResponse) other;
        return Intrinsics.areEqual(this.departures, departuresResponse.departures) && this.timeTableStatus == departuresResponse.timeTableStatus && Intrinsics.areEqual(this.siteDeparturesNotice, departuresResponse.siteDeparturesNotice);
    }

    public final List<Departure> getDepartures() {
        return this.departures;
    }

    public final String getSiteDeparturesNotice() {
        return this.siteDeparturesNotice;
    }

    public final TimeTableStatus getTimeTableStatus() {
        return this.timeTableStatus;
    }

    public int hashCode() {
        int hashCode = ((this.departures.hashCode() * 31) + this.timeTableStatus.hashCode()) * 31;
        String str = this.siteDeparturesNotice;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "DeparturesResponse(departures=" + this.departures + ", timeTableStatus=" + this.timeTableStatus + ", siteDeparturesNotice=" + this.siteDeparturesNotice + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DeparturesResponse(DeparturesResponseDTO dto, boolean z5, boolean z6) {
        this(r1, TimeTableStatus.INSTANCE.invoke(dto.getTimeTableStatus()), StringExtensionsKt.nullIfEmpty(dto.getSiteDeparturesNotice()));
        Intrinsics.checkNotNullParameter(dto, "dto");
        List<DeparturesResponseDTO.DepartureResponseDTO> departures = dto.getDepartures();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(departures, 10));
        Iterator<T> it = departures.iterator();
        while (it.hasNext()) {
            arrayList.add(new Departure((DeparturesResponseDTO.DepartureResponseDTO) it.next(), z5, z6));
        }
    }
}
