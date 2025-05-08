package dk.molslinjen.extensions.domain;

import dk.molslinjen.domain.model.config.Route;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\u0006"}, d2 = {"findRoute", "Ldk/molslinjen/domain/model/config/Route;", BuildConfig.FLAVOR, "departureHarborId", BuildConfig.FLAVOR, "arrivalHarborId", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class RouteExtensionsKt {
    public static final Route findRoute(List<Route> list, String str, String str2) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Route route = (Route) obj;
            if (Intrinsics.areEqual(route.getOutRoute().getArrivalHarbor().getId(), str2) || Intrinsics.areEqual(route.getOutRoute().getArrivalHarbor().getId(), str)) {
                if (Intrinsics.areEqual(route.getOutRoute().getDepartureHarbor().getId(), str2) || Intrinsics.areEqual(route.getOutRoute().getDepartureHarbor().getId(), str)) {
                    break;
                }
            }
        }
        return (Route) obj;
    }
}
