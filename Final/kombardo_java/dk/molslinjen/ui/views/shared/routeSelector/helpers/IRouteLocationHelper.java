package dk.molslinjen.ui.views.shared.routeSelector.helpers;

import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.config.Site;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/ui/views/shared/routeSelector/helpers/IRouteLocationHelper;", BuildConfig.FLAVOR, "getNearestRouteDirection", "Ldk/molslinjen/domain/model/booking/RouteDirection;", "route", "Ldk/molslinjen/domain/model/config/Route;", "site", "Ldk/molslinjen/domain/model/config/Site;", "maxTimeWaitingInSeconds", BuildConfig.FLAVOR, "(Ldk/molslinjen/domain/model/config/Route;Ldk/molslinjen/domain/model/config/Site;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IRouteLocationHelper {
    Object getNearestRouteDirection(Route route, Site site, int i5, Continuation<? super RouteDirection> continuation);
}
