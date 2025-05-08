package dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails;

import android.content.Context;
import dk.molslinjen.domain.model.booking.Ferry;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.booking.RouteType;
import dk.molslinjen.domain.model.config.Harbor;
import dk.molslinjen.extensions.domain.RouteTypeExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.booking.ticketType.HarborStep;
import dk.molslinjen.ui.views.screens.booking.ticketType.IconStep;
import dk.molslinjen.ui.views.screens.booking.ticketType.Step;
import dk.molslinjen.ui.views.screens.booking.ticketType.WalkStep;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a<\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000e"}, d2 = {"buildNoneShuttleSteps", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/screens/booking/ticketType/Step;", "departure", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "departureHarbor", "Ldk/molslinjen/domain/model/config/Harbor;", "arrivalHarbor", "routeType", "Ldk/molslinjen/domain/model/booking/RouteType;", "harbors", "context", "Landroid/content/Context;", "buildShuttleSteps", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class KombardoTravelDetailsHandlerKt {
    public static final /* synthetic */ List access$buildNoneShuttleSteps(IDepartureInfo iDepartureInfo, Harbor harbor, Harbor harbor2, RouteType routeType, List list, Context context) {
        return buildNoneShuttleSteps(iDepartureInfo, harbor, harbor2, routeType, list, context);
    }

    public static final /* synthetic */ List access$buildShuttleSteps(IDepartureInfo iDepartureInfo, Harbor harbor, Harbor harbor2, List list, Context context) {
        return buildShuttleSteps(iDepartureInfo, harbor, harbor2, list, context);
    }

    public static final List<Step> buildNoneShuttleSteps(IDepartureInfo iDepartureInfo, Harbor harbor, Harbor harbor2, RouteType routeType, List<Harbor> list, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HarborStep(harbor, iDepartureInfo.getDepartureTime(), false, false, false, 28, null));
        Ferry ferry = iDepartureInfo.getFerry();
        if (ferry != null && iDepartureInfo.getRouteType() != RouteType.BusOnly) {
            Harbor departureHarbor = ferry.getDepartureHarbor(list);
            Harbor arrivalHarbor = ferry.getArrivalHarbor(list);
            LocalTime departureTime = ferry.getDepartureTime();
            LocalTime arrivalTime = ferry.getArrivalTime();
            if (departureTime != null && arrivalTime != null && departureHarbor != null && arrivalHarbor != null) {
                arrayList.add(new HarborStep(departureHarbor, departureTime, true, true, false, 16, null));
                if (routeType != null) {
                    Ferry ferry2 = iDepartureInfo.getFerry();
                    arrayList.add(new IconStep(RouteTypeExtensionsKt.icon(routeType, ferry2 != null ? ferry2.getType() : null), RouteTypeExtensionsKt.supplementaryDescription(routeType), true, routeType == RouteType.BusBus, context.getString(R.string.ticketInfo_busChangeOnFerry)));
                }
                arrayList.add(new HarborStep(arrivalHarbor, arrivalTime, false, false, false, 28, null));
            }
        } else if (routeType != null) {
            Ferry ferry3 = iDepartureInfo.getFerry();
            arrayList.add(new IconStep(RouteTypeExtensionsKt.icon(routeType, ferry3 != null ? ferry3.getType() : null), RouteTypeExtensionsKt.supplementaryDescription(routeType), false, false, null, 28, null));
        }
        arrayList.add(new HarborStep(harbor2, iDepartureInfo.getArrivalTime(), false, true, true, 4, null));
        return arrayList;
    }

    public static final List<Step> buildShuttleSteps(IDepartureInfo iDepartureInfo, Harbor harbor, Harbor harbor2, List<Harbor> list, Context context) {
        LocalTime departureTime;
        Harbor departureHarbor;
        Harbor arrivalHarbor;
        Ferry ferry = iDepartureInfo.getFerry();
        if (ferry == null || (departureTime = ferry.getDepartureTime()) == null) {
            return CollectionsKt.emptyList();
        }
        LocalTime arrivalTime = ferry.getArrivalTime();
        if (arrivalTime != null && (departureHarbor = ferry.getDepartureHarbor(list)) != null && (arrivalHarbor = ferry.getArrivalHarbor(list)) != null) {
            ArrayList arrayList = new ArrayList();
            if (!Intrinsics.areEqual(harbor, departureHarbor)) {
                arrayList.add(new HarborStep(harbor, iDepartureInfo.getDepartureTime(), false, false, false, 28, null));
                RouteType routeType = RouteType.BusOnly;
                Ferry ferry2 = iDepartureInfo.getFerry();
                arrayList.add(new IconStep(RouteTypeExtensionsKt.icon(routeType, ferry2 != null ? ferry2.getType() : null), null, false, false, null, 30, null));
                arrayList.add(new HarborStep(departureHarbor, departureTime, false, true, true, 4, null));
            }
            String string = context.getString(R.string.ticketInfo_walkOnFerry);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            arrayList.add(new WalkStep(string));
            arrayList.add(new HarborStep(departureHarbor, departureTime, true, false, false, 24, null));
            RouteType routeType2 = RouteType.Ferry;
            Ferry ferry3 = iDepartureInfo.getFerry();
            arrayList.add(new IconStep(RouteTypeExtensionsKt.icon(routeType2, ferry3 != null ? ferry3.getType() : null), null, true, false, null, 26, null));
            arrayList.add(new HarborStep(arrivalHarbor, arrivalTime, false, false, true, 12, null));
            String transportSwitchDescription = iDepartureInfo.getTransportSwitchDescription();
            if (transportSwitchDescription != null) {
                arrayList.add(new WalkStep(transportSwitchDescription));
            }
            if (!Intrinsics.areEqual(harbor2, arrivalHarbor)) {
                arrayList.add(new HarborStep(arrivalHarbor, arrivalTime, false, false, false, 28, null));
                RouteType routeType3 = RouteType.BusOnly;
                Ferry ferry4 = iDepartureInfo.getFerry();
                arrayList.add(new IconStep(RouteTypeExtensionsKt.icon(routeType3, ferry4 != null ? ferry4.getType() : null), null, false, false, null, 30, null));
                arrayList.add(new HarborStep(harbor2, iDepartureInfo.getArrivalTime(), false, true, true, 4, null));
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }
}
