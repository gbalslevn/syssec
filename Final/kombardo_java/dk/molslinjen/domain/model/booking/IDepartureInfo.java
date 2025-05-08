package dk.molslinjen.domain.model.booking;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0012\u0010\u0010\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0005R\u0012\u0010\"\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0005¨\u0006$"}, d2 = {"Ldk/molslinjen/domain/model/booking/IDepartureInfo;", BuildConfig.FLAVOR, "arrivalHarborName", BuildConfig.FLAVOR, "getArrivalHarborName", "()Ljava/lang/String;", "date", "Lorg/threeten/bp/LocalDate;", "getDate", "()Lorg/threeten/bp/LocalDate;", "arrivalTime", "Lorg/threeten/bp/LocalTime;", "getArrivalTime", "()Lorg/threeten/bp/LocalTime;", "departureHarborName", "getDepartureHarborName", "departureTime", "getDepartureTime", "ferry", "Ldk/molslinjen/domain/model/booking/Ferry;", "getFerry", "()Ldk/molslinjen/domain/model/booking/Ferry;", "routeId", "getRouteId", "routeType", "Ldk/molslinjen/domain/model/booking/RouteType;", "getRouteType", "()Ldk/molslinjen/domain/model/booking/RouteType;", "travelTime", "Lorg/threeten/bp/Duration;", "getTravelTime", "()Lorg/threeten/bp/Duration;", "transportSwitchDescription", "getTransportSwitchDescription", "timeTableId", "getTimeTableId", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IDepartureInfo {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static String getTransportSwitchDescription(IDepartureInfo iDepartureInfo) {
            return null;
        }
    }

    String getArrivalHarborName();

    LocalTime getArrivalTime();

    LocalDate getDate();

    String getDepartureHarborName();

    LocalTime getDepartureTime();

    Ferry getFerry();

    String getRouteId();

    RouteType getRouteType();

    String getTimeTableId();

    String getTransportSwitchDescription();

    Duration getTravelTime();
}
