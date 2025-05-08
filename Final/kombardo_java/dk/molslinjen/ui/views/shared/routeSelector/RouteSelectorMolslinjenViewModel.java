package dk.molslinjen.ui.views.shared.routeSelector;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.location.ILocationManager;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.extensions.domain.HarborExtensionsKt;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.model.booking.CommuterBookingData;
import dk.molslinjen.domain.model.booking.MultiRideBookingData;
import dk.molslinjen.domain.model.config.Configuration;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.config.RouteDirectionGroup;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.SiteConfiguration;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.ui.views.shared.routeSelector.helpers.IRouteLocationHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001fB)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ,\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00142\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u001dJ\b\u0010\u001e\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorMolslinjenViewModel;", "Landroidx/lifecycle/ViewModel;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "configurationManager", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "routeLocationHelper", "Ldk/molslinjen/ui/views/shared/routeSelector/helpers/IRouteLocationHelper;", "locationManager", "Ldk/molslinjen/core/location/ILocationManager;", "<init>", "(Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;Ldk/molslinjen/ui/views/shared/routeSelector/helpers/IRouteLocationHelper;Ldk/molslinjen/core/location/ILocationManager;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorMolslinjenViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "molslinjenAarhusOddenRouteId", BuildConfig.FLAVOR, "routeSelected", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/domain/model/config/Site;", "route", "Ldk/molslinjen/domain/model/config/Route;", "defaultTransportationId", "proceed", "Lkotlin/Function0;", "startLoadingCurrentLocation", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RouteSelectorMolslinjenViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IConfigurationManager configurationManager;
    private final ILocationManager locationManager;
    private final String molslinjenAarhusOddenRouteId;
    private final IRouteLocationHelper routeLocationHelper;
    private final IRouteManager routeManager;
    private final StateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorMolslinjenViewModel$1", f = "RouteSelectorMolslinjenViewModel.kt", l = {41}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorMolslinjenViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:52:0x0225 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x01c9 A[SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object configuration;
            List list;
            Object value;
            List<Route> routes;
            Object obj2;
            String id;
            String defaultTransportId;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList = new ArrayList();
                IConfigurationManager iConfigurationManager = RouteSelectorMolslinjenViewModel.this.configurationManager;
                this.L$0 = arrayList;
                this.label = 1;
                configuration = iConfigurationManager.getConfiguration(this);
                if (configuration == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = arrayList;
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                configuration = obj;
            }
            Configuration configuration2 = (Configuration) configuration;
            if (configuration2 == null) {
                return Unit.INSTANCE;
            }
            Collection<SiteConfiguration> values = configuration2.getSiteConfigurations().values();
            ArrayList<LocalizedSiteConfiguration> arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(values, 10));
            Iterator<T> it = values.iterator();
            while (it.hasNext()) {
                arrayList2.add(((SiteConfiguration) it.next()).getActiveConfiguration());
            }
            RouteSharedSelectedState value2 = RouteSelectorMolslinjenViewModel.this.routeManager.getSharedSelectedState().getValue();
            CommuterBookingData commuterBookingData = value2 != null ? value2.getCommuterBookingData() : null;
            MultiRideBookingData multiRideBookingData = value2 != null ? value2.getMultiRideBookingData() : null;
            for (LocalizedSiteConfiguration localizedSiteConfiguration : arrayList2) {
                if (commuterBookingData != null) {
                    List<Route> routes2 = localizedSiteConfiguration.getRoutes();
                    routes = new ArrayList();
                    for (Object obj3 : routes2) {
                        if (commuterBookingData.getRouteIds().contains(((Route) obj3).getId())) {
                            routes.add(obj3);
                        }
                    }
                } else if (multiRideBookingData != null) {
                    List<Route> routes3 = localizedSiteConfiguration.getRoutes();
                    routes = new ArrayList();
                    for (Object obj4 : routes3) {
                        if (multiRideBookingData.getRouteIds().contains(((Route) obj4).getId())) {
                            routes.add(obj4);
                        }
                    }
                } else {
                    routes = localizedSiteConfiguration.getRoutes();
                }
                for (Route route : routes) {
                    if (!localizedSiteConfiguration.getRegions().isEmpty()) {
                        List<Route> routes4 = localizedSiteConfiguration.getRoutes();
                        RouteSelectorMolslinjenViewModel routeSelectorMolslinjenViewModel = RouteSelectorMolslinjenViewModel.this;
                        if (!(routes4 instanceof Collection) || !routes4.isEmpty()) {
                            Iterator<T> it2 = routes4.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                if (Intrinsics.areEqual(((Route) it2.next()).getId(), routeSelectorMolslinjenViewModel.molslinjenAarhusOddenRouteId)) {
                                    if (!Intrinsics.areEqual(route.getId(), RouteSelectorMolslinjenViewModel.this.molslinjenAarhusOddenRouteId)) {
                                    }
                                }
                            }
                        }
                    }
                    RouteDirectionGroup outRoute = route.getOutRoute();
                    String harborName = HarborExtensionsKt.harborName(outRoute.getDepartureHarbor(), outRoute.getUseRegionsAsHarbors());
                    String harborName2 = HarborExtensionsKt.harborName(outRoute.getArrivalHarbor(), outRoute.getUseRegionsAsHarbors());
                    if (commuterBookingData == null || (defaultTransportId = commuterBookingData.getTransportationId()) == null) {
                        if (multiRideBookingData != null) {
                            defaultTransportId = multiRideBookingData.getDefaultTransportId();
                        } else {
                            Iterator<T> it3 = localizedSiteConfiguration.getTransportations().iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    obj2 = null;
                                    break;
                                }
                                obj2 = it3.next();
                                if (((Transportation) obj2).getAllowedRouteIds().contains(route.getId())) {
                                    break;
                                }
                            }
                            Transportation transportation = (Transportation) obj2;
                            id = transportation != null ? transportation.getId() : null;
                            if (id != null) {
                                Logger logger = Logger.INSTANCE;
                                String id2 = route.getId();
                                Site site = localizedSiteConfiguration.getSite();
                                List<Transportation> transportations = localizedSiteConfiguration.getTransportations();
                                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(transportations, 10));
                                Iterator<T> it4 = transportations.iterator();
                                while (it4.hasNext()) {
                                    arrayList3.add(((Transportation) it4.next()).getId());
                                }
                                logger.logCritical(new CriticalLog("No default transportation found for route " + id2 + " on site " + site + " from transportations with ids: " + arrayList3));
                            } else {
                                list.add(new ViewState.RouteRow(harborName, harborName2, localizedSiteConfiguration.getSite(), route, localizedSiteConfiguration.getSiteName(), id));
                            }
                        }
                    }
                    id = defaultTransportId;
                    if (id != null) {
                    }
                }
            }
            String id3 = (value2 == null || !value2.getHasRouteManuallyBeenSelected()) ? null : value2.getSelectedRoute().getId();
            MutableStateFlow mutableStateFlow = RouteSelectorMolslinjenViewModel.this._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, new ViewState(id3, list)));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RouteSelectorMolslinjenViewModel(IRouteManager routeManager, IConfigurationManager configurationManager, IRouteLocationHelper routeLocationHelper, ILocationManager locationManager) {
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(configurationManager, "configurationManager");
        Intrinsics.checkNotNullParameter(routeLocationHelper, "routeLocationHelper");
        Intrinsics.checkNotNullParameter(locationManager, "locationManager");
        this.routeManager = routeManager;
        this.configurationManager = configurationManager;
        this.routeLocationHelper = routeLocationHelper;
        this.locationManager = locationManager;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        this.molslinjenAarhusOddenRouteId = "3";
        startLoadingCurrentLocation();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    private final void startLoadingCurrentLocation() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new RouteSelectorMolslinjenViewModel$startLoadingCurrentLocation$1(this, null), 3, null);
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void routeSelected(Site site, Route route, String defaultTransportationId, Function0<Unit> proceed) {
        ViewState value;
        Intrinsics.checkNotNullParameter(site, "site");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(defaultTransportationId, "defaultTransportationId");
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, route.getId(), null, 2, null)));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new RouteSelectorMolslinjenViewModel$routeSelected$2(this, route, site, defaultTransportationId, proceed, null), 3, null);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0019B#\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorMolslinjenViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "selectedRouteId", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorMolslinjenViewModel$ViewState$RouteRow;", "routeRows", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "copy", "(Ljava/lang/String;Ljava/util/List;)Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorMolslinjenViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSelectedRouteId", "Ljava/util/List;", "getRouteRows", "()Ljava/util/List;", "RouteRow", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final List<RouteRow> routeRows;
        private final String selectedRouteId;

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001f\u0010\u000eR\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b \u0010\u000e¨\u0006!"}, d2 = {"Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorMolslinjenViewModel$ViewState$RouteRow;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "departingHarborName", "arrivalHarborName", "Ldk/molslinjen/domain/model/config/Site;", "site", "Ldk/molslinjen/domain/model/config/Route;", "route", "siteName", "defaultTransportationId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/config/Route;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDepartingHarborName", "getArrivalHarborName", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "Ldk/molslinjen/domain/model/config/Route;", "getRoute", "()Ldk/molslinjen/domain/model/config/Route;", "getSiteName", "getDefaultTransportationId", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final /* data */ class RouteRow {
            private final String arrivalHarborName;
            private final String defaultTransportationId;
            private final String departingHarborName;
            private final Route route;
            private final Site site;
            private final String siteName;

            public RouteRow(String departingHarborName, String arrivalHarborName, Site site, Route route, String siteName, String defaultTransportationId) {
                Intrinsics.checkNotNullParameter(departingHarborName, "departingHarborName");
                Intrinsics.checkNotNullParameter(arrivalHarborName, "arrivalHarborName");
                Intrinsics.checkNotNullParameter(site, "site");
                Intrinsics.checkNotNullParameter(route, "route");
                Intrinsics.checkNotNullParameter(siteName, "siteName");
                Intrinsics.checkNotNullParameter(defaultTransportationId, "defaultTransportationId");
                this.departingHarborName = departingHarborName;
                this.arrivalHarborName = arrivalHarborName;
                this.site = site;
                this.route = route;
                this.siteName = siteName;
                this.defaultTransportationId = defaultTransportationId;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RouteRow)) {
                    return false;
                }
                RouteRow routeRow = (RouteRow) other;
                return Intrinsics.areEqual(this.departingHarborName, routeRow.departingHarborName) && Intrinsics.areEqual(this.arrivalHarborName, routeRow.arrivalHarborName) && this.site == routeRow.site && Intrinsics.areEqual(this.route, routeRow.route) && Intrinsics.areEqual(this.siteName, routeRow.siteName) && Intrinsics.areEqual(this.defaultTransportationId, routeRow.defaultTransportationId);
            }

            public final String getArrivalHarborName() {
                return this.arrivalHarborName;
            }

            public final String getDefaultTransportationId() {
                return this.defaultTransportationId;
            }

            public final String getDepartingHarborName() {
                return this.departingHarborName;
            }

            public final Route getRoute() {
                return this.route;
            }

            public final Site getSite() {
                return this.site;
            }

            public final String getSiteName() {
                return this.siteName;
            }

            public int hashCode() {
                return (((((((((this.departingHarborName.hashCode() * 31) + this.arrivalHarborName.hashCode()) * 31) + this.site.hashCode()) * 31) + this.route.hashCode()) * 31) + this.siteName.hashCode()) * 31) + this.defaultTransportationId.hashCode();
            }

            public String toString() {
                return "RouteRow(departingHarborName=" + this.departingHarborName + ", arrivalHarborName=" + this.arrivalHarborName + ", site=" + this.site + ", route=" + this.route + ", siteName=" + this.siteName + ", defaultTransportationId=" + this.defaultTransportationId + ")";
            }
        }

        public ViewState(String str, List<RouteRow> routeRows) {
            Intrinsics.checkNotNullParameter(routeRows, "routeRows");
            this.selectedRouteId = str;
            this.routeRows = routeRows;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, String str, List list, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = viewState.selectedRouteId;
            }
            if ((i5 & 2) != 0) {
                list = viewState.routeRows;
            }
            return viewState.copy(str, list);
        }

        public final ViewState copy(String selectedRouteId, List<RouteRow> routeRows) {
            Intrinsics.checkNotNullParameter(routeRows, "routeRows");
            return new ViewState(selectedRouteId, routeRows);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.selectedRouteId, viewState.selectedRouteId) && Intrinsics.areEqual(this.routeRows, viewState.routeRows);
        }

        public final List<RouteRow> getRouteRows() {
            return this.routeRows;
        }

        public final String getSelectedRouteId() {
            return this.selectedRouteId;
        }

        public int hashCode() {
            String str = this.selectedRouteId;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.routeRows.hashCode();
        }

        public String toString() {
            return "ViewState(selectedRouteId=" + this.selectedRouteId + ", routeRows=" + this.routeRows + ")";
        }

        public /* synthetic */ ViewState(String str, List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : str, (i5 & 2) != 0 ? CollectionsKt.emptyList() : list);
        }
    }
}
