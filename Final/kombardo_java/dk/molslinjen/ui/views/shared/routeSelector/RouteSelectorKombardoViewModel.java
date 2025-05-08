package dk.molslinjen.ui.views.shared.routeSelector;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.RouteSelectorScreenDestination;
import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.core.location.IDirectionsManager;
import dk.molslinjen.core.location.ILocationManager;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.model.booking.HarborTravelTime;
import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.booking.TravelMode;
import dk.molslinjen.domain.model.booking.TravelTime;
import dk.molslinjen.domain.model.booking.TravelTimeToNearestHarbor;
import dk.molslinjen.domain.model.config.Area;
import dk.molslinjen.domain.model.config.Configuration;
import dk.molslinjen.domain.model.config.HarborReference;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.config.RouteDirectionDetails;
import dk.molslinjen.domain.model.config.RouteDirectionGroup;
import dk.molslinjen.domain.model.config.SiteConfiguration;
import dk.molslinjen.domain.model.config.Subline;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.extensions.domain.RouteExtensionsKt;
import dk.molslinjen.extensions.domain.TravelTimeExtensionsKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectRoute.RouteSelectorScreenNavArgs;
import dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u00016B;\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002JH\u0010#\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180$2\u0018\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0&0\u00182\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J(\u0010*\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180$2\u0006\u0010+\u001a\u00020'H\u0002J\u000e\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020.J\u001c\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\u00192\f\u00101\u001a\b\u0012\u0004\u0012\u00020!02J\u0016\u00103\u001a\u00020!2\u0006\u0010\f\u001a\u00020\rH\u0082@¢\u0006\u0002\u00104J\u000e\u00105\u001a\u00020!2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u00067"}, d2 = {"Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "locationManager", "Ldk/molslinjen/core/location/ILocationManager;", "directionsManager", "Ldk/molslinjen/core/location/IDirectionsManager;", "configurationManager", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "context", "Landroid/content/Context;", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/core/location/ILocationManager;Ldk/molslinjen/core/location/IDirectionsManager;Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;Landroid/content/Context;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "allCityRows", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState$CityRow;", "siteConfiguration", "Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;", "routes", "Ldk/molslinjen/domain/model/config/Route;", "getRoutes", "()Ljava/util/List;", "setCurrentSelectedCities", BuildConfig.FLAVOR, "updateAvailableCityRows", "frequentlyUsedCities", "Lkotlin/Pair;", "purchaseCountPerCityId", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "cities", "getCityRows", "oppositeCityId", "focusDirection", "direction", "Ldk/molslinjen/domain/model/booking/RouteDirection;", "selectedCity", "cityRow", "onRouteSelected", "Lkotlin/Function0;", "loadTimeToPickupPoint", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "locationPermissionGranted", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RouteSelectorKombardoViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private List<ViewState.CityRow> allCityRows;
    private final IConfigurationManager configurationManager;
    private final IDirectionsManager directionsManager;
    private final ILocationManager locationManager;
    private final IRouteManager routeManager;
    private LocalizedSiteConfiguration siteConfiguration;
    private final StateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoViewModel$2", f = "RouteSelectorKombardoViewModel.kt", l = {60}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoViewModel$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                IConfigurationManager iConfigurationManager = RouteSelectorKombardoViewModel.this.configurationManager;
                this.label = 1;
                obj = iConfigurationManager.getConfiguration(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Configuration configuration = (Configuration) obj;
            if (configuration == null) {
                return Unit.INSTANCE;
            }
            RouteSelectorKombardoViewModel routeSelectorKombardoViewModel = RouteSelectorKombardoViewModel.this;
            Collection<SiteConfiguration> values = configuration.getSiteConfigurations().values();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(values, 10));
            Iterator<T> it = values.iterator();
            while (it.hasNext()) {
                arrayList.add(((SiteConfiguration) it.next()).getActiveConfiguration());
            }
            routeSelectorKombardoViewModel.siteConfiguration = (LocalizedSiteConfiguration) CollectionsKt.first((List) arrayList);
            RouteSelectorKombardoViewModel routeSelectorKombardoViewModel2 = RouteSelectorKombardoViewModel.this;
            List<Route> routes = routeSelectorKombardoViewModel2.getRoutes();
            ArrayList arrayList2 = new ArrayList();
            for (Route route : routes) {
                CollectionsKt.addAll(arrayList2, CollectionsKt.listOf((Object[]) new HarborReference[]{route.getOutRoute().getDepartureHarbor(), route.getOutRoute().getArrivalHarbor()}));
            }
            List<HarborReference> sortedWith = CollectionsKt.sortedWith(CollectionsKt.distinct(arrayList2), new Comparator() { // from class: dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoViewModel$2$invokeSuspend$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t5, T t6) {
                    return ComparisonsKt.compareValues(((HarborReference) t5).getName(), ((HarborReference) t6).getName());
                }
            });
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
            for (HarborReference harborReference : sortedWith) {
                arrayList3.add(new ViewState.CityRow(harborReference.getId(), harborReference.getName(), harborReference.isFrequentlyUsed(), harborReference.getArea()));
            }
            routeSelectorKombardoViewModel2.allCityRows = arrayList3;
            RouteSelectorKombardoViewModel.this.setCurrentSelectedCities();
            RouteSelectorKombardoViewModel.this.updateAvailableCityRows();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoViewModel$3", f = "RouteSelectorKombardoViewModel.kt", l = {72}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoViewModel$3, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Context context, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$context, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                RouteSelectorKombardoViewModel routeSelectorKombardoViewModel = RouteSelectorKombardoViewModel.this;
                Context context = this.$context;
                this.label = 1;
                if (routeSelectorKombardoViewModel.loadTimeToPickupPoint(context, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public RouteSelectorKombardoViewModel(SavedStateHandle savedStateHandle, IRouteManager routeManager, ILocationManager locationManager, IDirectionsManager directionsManager, IConfigurationManager configurationManager, Context context) {
        ViewState value;
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(locationManager, "locationManager");
        Intrinsics.checkNotNullParameter(directionsManager, "directionsManager");
        Intrinsics.checkNotNullParameter(configurationManager, "configurationManager");
        Intrinsics.checkNotNullParameter(context, "context");
        this.routeManager = routeManager;
        this.locationManager = locationManager;
        this.directionsManager = directionsManager;
        this.configurationManager = configurationManager;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, null, null, null, null, null, null, 127, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        this.allCityRows = CollectionsKt.emptyList();
        try {
            RouteSelectorScreenNavArgs argsFrom = RouteSelectorScreenDestination.INSTANCE.argsFrom(savedStateHandle);
            do {
                value = MutableStateFlow.getValue();
            } while (!MutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, null, null, null, argsFrom.getDirection(), null, 95, null)));
        } catch (RuntimeException unused) {
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass3(context, null), 3, null);
    }

    private final Pair<List<ViewState.CityRow>, List<ViewState.CityRow>> frequentlyUsedCities(List<? extends Map.Entry<String, Integer>> purchaseCountPerCityId, List<ViewState.CityRow> cities) {
        Object obj;
        List sortedWith = CollectionsKt.sortedWith(purchaseCountPerCityId, new Comparator() { // from class: dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoViewModel$frequentlyUsedCities$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                return ComparisonsKt.compareValues((Integer) ((Map.Entry) t6).getValue(), (Integer) ((Map.Entry) t5).getValue());
            }
        });
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
        Iterator it = sortedWith.iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map.Entry) it.next()).getKey());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            String str = (String) obj2;
            List<ViewState.CityRow> list = cities;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (Intrinsics.areEqual(((ViewState.CityRow) it2.next()).getId(), str)) {
                        arrayList2.add(obj2);
                        break;
                    }
                }
            }
        }
        List<String> take = CollectionsKt.take(arrayList2, 4);
        ArrayList arrayList3 = new ArrayList();
        for (String str2 : take) {
            Iterator<T> it3 = cities.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it3.next();
                if (Intrinsics.areEqual(((ViewState.CityRow) obj).getId(), str2)) {
                    break;
                }
            }
            ViewState.CityRow cityRow = (ViewState.CityRow) obj;
            if (cityRow != null) {
                arrayList3.add(cityRow);
            }
        }
        if (arrayList3.isEmpty()) {
            arrayList3 = new ArrayList();
            for (Object obj3 : cities) {
                if (((ViewState.CityRow) obj3).getDefaultFrequentlyUsed()) {
                    arrayList3.add(obj3);
                }
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj4 : cities) {
            ViewState.CityRow cityRow2 = (ViewState.CityRow) obj4;
            if (!arrayList3.isEmpty()) {
                Iterator it4 = arrayList3.iterator();
                while (it4.hasNext()) {
                    if (Intrinsics.areEqual(cityRow2.getId(), ((ViewState.CityRow) it4.next()).getId())) {
                        break;
                    }
                }
            }
            arrayList4.add(obj4);
        }
        return new Pair<>(arrayList3, arrayList4);
    }

    private final Pair<List<Route>, List<ViewState.CityRow>> getCityRows(final String oppositeCityId) {
        List<Route> routes = getRoutes();
        ArrayList arrayList = new ArrayList();
        for (Object obj : routes) {
            Route route = (Route) obj;
            if (Intrinsics.areEqual(route.getOutRoute().getDepartureHarbor().getId(), oppositeCityId) || Intrinsics.areEqual(route.getOutRoute().getArrivalHarbor().getId(), oppositeCityId)) {
                arrayList.add(obj);
            }
        }
        return new Pair<>(arrayList, SequencesKt.toList(SequencesKt.map(SequencesKt.sortedWith(SequencesKt.distinct(SequencesKt.filter(SequencesKt.flatMapIterable(CollectionsKt.asSequence(arrayList), new Function1() { // from class: A4.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                Iterable cityRows$lambda$22;
                cityRows$lambda$22 = RouteSelectorKombardoViewModel.getCityRows$lambda$22((Route) obj2);
                return cityRows$lambda$22;
            }
        }), new Function1() { // from class: A4.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                boolean cityRows$lambda$23;
                cityRows$lambda$23 = RouteSelectorKombardoViewModel.getCityRows$lambda$23(oppositeCityId, (HarborReference) obj2);
                return Boolean.valueOf(cityRows$lambda$23);
            }
        })), new Comparator() { // from class: dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoViewModel$getCityRows$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                return ComparisonsKt.compareValues(((HarborReference) t5).getName(), ((HarborReference) t6).getName());
            }
        }), new Function1() { // from class: A4.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                RouteSelectorKombardoViewModel.ViewState.CityRow cityRows$lambda$25;
                cityRows$lambda$25 = RouteSelectorKombardoViewModel.getCityRows$lambda$25((HarborReference) obj2);
                return cityRows$lambda$25;
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable getCityRows$lambda$22(Route it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.listOf((Object[]) new HarborReference[]{it.getOutRoute().getDepartureHarbor(), it.getOutRoute().getArrivalHarbor()});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getCityRows$lambda$23(String str, HarborReference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !Intrinsics.areEqual(it.getId(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewState.CityRow getCityRows$lambda$25(HarborReference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new ViewState.CityRow(it.getId(), it.getName(), it.isFrequentlyUsed(), it.getArea());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Route> getRoutes() {
        LocalizedSiteConfiguration localizedSiteConfiguration = this.siteConfiguration;
        if (localizedSiteConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("siteConfiguration");
            localizedSiteConfiguration = null;
        }
        return localizedSiteConfiguration.getRoutes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadTimeToPickupPoint(Context context, Continuation<? super Unit> continuation) {
        RouteSelectorKombardoViewModel$loadTimeToPickupPoint$1 routeSelectorKombardoViewModel$loadTimeToPickupPoint$1;
        int i5;
        RouteSelectorKombardoViewModel routeSelectorKombardoViewModel;
        Context context2;
        ManagerResult managerResult;
        ViewState value;
        Object obj;
        Object obj2;
        ViewState value2;
        if (continuation instanceof RouteSelectorKombardoViewModel$loadTimeToPickupPoint$1) {
            routeSelectorKombardoViewModel$loadTimeToPickupPoint$1 = (RouteSelectorKombardoViewModel$loadTimeToPickupPoint$1) continuation;
            int i6 = routeSelectorKombardoViewModel$loadTimeToPickupPoint$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                routeSelectorKombardoViewModel$loadTimeToPickupPoint$1.label = i6 - Integer.MIN_VALUE;
                Object obj3 = routeSelectorKombardoViewModel$loadTimeToPickupPoint$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = routeSelectorKombardoViewModel$loadTimeToPickupPoint$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj3);
                    if (this.locationManager.isAuthorized()) {
                        IDirectionsManager iDirectionsManager = this.directionsManager;
                        routeSelectorKombardoViewModel$loadTimeToPickupPoint$1.L$0 = this;
                        routeSelectorKombardoViewModel$loadTimeToPickupPoint$1.L$1 = context;
                        routeSelectorKombardoViewModel$loadTimeToPickupPoint$1.label = 1;
                        obj3 = IDirectionsManager.DefaultImpls.getTravelTimeToNearestHarbor$default(iDirectionsManager, null, routeSelectorKombardoViewModel$loadTimeToPickupPoint$1, 1, null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        routeSelectorKombardoViewModel = this;
                        context2 = context;
                    }
                    return Unit.INSTANCE;
                }
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                context2 = (Context) routeSelectorKombardoViewModel$loadTimeToPickupPoint$1.L$1;
                routeSelectorKombardoViewModel = (RouteSelectorKombardoViewModel) routeSelectorKombardoViewModel$loadTimeToPickupPoint$1.L$0;
                ResultKt.throwOnFailure(obj3);
                managerResult = (ManagerResult) obj3;
                if (!(managerResult instanceof ManagerResult.Success)) {
                    ManagerResult.Success success = (ManagerResult.Success) managerResult;
                    List<TravelTime> travelTimes = ((TravelTimeToNearestHarbor) success.getData()).getTravelTimes();
                    Iterator<T> it = travelTimes.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (((TravelTime) obj).getTravelMode() == TravelMode.Bus) {
                            break;
                        }
                    }
                    TravelTime travelTime = (TravelTime) obj;
                    String formatTravelTime = travelTime != null ? TravelTimeExtensionsKt.formatTravelTime(travelTime, context2) : null;
                    Iterator<T> it2 = travelTimes.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it2.next();
                        if (((TravelTime) obj2).getTravelMode() == TravelMode.Pedestrian) {
                            break;
                        }
                    }
                    TravelTime travelTime2 = (TravelTime) obj2;
                    String formatTravelTime2 = travelTime2 != null ? TravelTimeExtensionsKt.formatTravelTime(travelTime2, context2) : null;
                    MutableStateFlow<ViewState> mutableStateFlow = routeSelectorKombardoViewModel._viewState;
                    do {
                        value2 = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value2, ViewState.copy$default(value2, null, null, null, null, null, null, new HarborTravelTime(formatTravelTime, formatTravelTime2, ((TravelTimeToNearestHarbor) success.getData()).getHarborName()), 63, null)));
                } else {
                    if (!(managerResult instanceof ManagerResult.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    MutableStateFlow<ViewState> mutableStateFlow2 = routeSelectorKombardoViewModel._viewState;
                    do {
                        value = mutableStateFlow2.getValue();
                    } while (!mutableStateFlow2.compareAndSet(value, ViewState.copy$default(value, null, null, null, null, null, null, null, 63, null)));
                }
                return Unit.INSTANCE;
            }
        }
        routeSelectorKombardoViewModel$loadTimeToPickupPoint$1 = new RouteSelectorKombardoViewModel$loadTimeToPickupPoint$1(this, continuation);
        Object obj32 = routeSelectorKombardoViewModel$loadTimeToPickupPoint$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = routeSelectorKombardoViewModel$loadTimeToPickupPoint$1.label;
        if (i5 != 0) {
        }
        managerResult = (ManagerResult) obj32;
        if (!(managerResult instanceof ManagerResult.Success)) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentSelectedCities() {
        Object obj;
        Object obj2;
        ViewState value;
        ViewState viewState;
        RouteDirection routeDirection;
        RouteSelectedState value2 = this.routeManager.getActiveSelectedState().getValue();
        RouteSharedSelectedState value3 = this.routeManager.getSharedSelectedState().getValue();
        Object obj3 = null;
        String id = (value3 == null || !value3.getHasRouteManuallyBeenSelected()) ? null : value3.getSelectedRoute().getId();
        RouteDirection selectedRouteDirection = value2 != null ? value2.getSelectedRouteDirection() : null;
        if (id != null) {
            Iterator<T> it = getRoutes().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.areEqual(((Route) obj).getId(), id)) {
                        break;
                    }
                }
            }
            Route route = (Route) obj;
            if (route != null) {
                HarborReference departureHarbor = route.getOutRoute().getDepartureHarbor();
                HarborReference arrivalHarbor = route.getOutRoute().getArrivalHarbor();
                Iterator<T> it2 = this.allCityRows.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj2 = null;
                        break;
                    } else {
                        obj2 = it2.next();
                        if (Intrinsics.areEqual(((ViewState.CityRow) obj2).getId(), departureHarbor.getId())) {
                            break;
                        }
                    }
                }
                ViewState.CityRow cityRow = (ViewState.CityRow) obj2;
                Iterator<T> it3 = this.allCityRows.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    Object next = it3.next();
                    if (Intrinsics.areEqual(((ViewState.CityRow) next).getId(), arrivalHarbor.getId())) {
                        obj3 = next;
                        break;
                    }
                }
                ViewState.CityRow cityRow2 = (ViewState.CityRow) obj3;
                if (cityRow == null || cityRow2 == null) {
                    return;
                }
                MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
                do {
                    value = mutableStateFlow.getValue();
                    viewState = value;
                    routeDirection = RouteDirection.Outbound;
                } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(viewState, selectedRouteDirection == routeDirection ? cityRow : cityRow2, selectedRouteDirection == routeDirection ? cityRow2 : cityRow, null, null, null, null, null, 124, null)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAvailableCityRows() {
        ViewState value;
        RouteDirectionGroup outRoute;
        List<RouteDirectionDetails> routes;
        RouteDirectionDetails routeDirectionDetails;
        List<ViewState.CityRow> list = this.allCityRows;
        List<Route> emptyList = CollectionsKt.emptyList();
        ViewState.CityRow selectedFromCity = this.viewState.getValue().getSelectedFromCity();
        List list2 = null;
        String id = selectedFromCity != null ? selectedFromCity.getId() : null;
        if (this.viewState.getValue().getFocusedDirection() == RouteDirection.Return && id != null) {
            Pair<List<Route>, List<ViewState.CityRow>> cityRows = getCityRows(id);
            emptyList = cityRows.component1();
            list = cityRows.component2();
        }
        Pair<List<ViewState.CityRow>, List<ViewState.CityRow>> frequentlyUsedCities = frequentlyUsedCities(this.routeManager.purchaseCountPerCityId(), list);
        List<ViewState.CityRow> component1 = frequentlyUsedCities.component1();
        List<ViewState.CityRow> component2 = frequentlyUsedCities.component2();
        List<ViewState.CityRow> list3 = component2;
        boolean z5 = false;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator<T> it = list3.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((ViewState.CityRow) it.next()).getArea() == null) {
                        z5 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = list3.iterator();
        while (it2.hasNext()) {
            Area area = ((ViewState.CityRow) it2.next()).getArea();
            if (area != null) {
                arrayList.add(area);
            }
        }
        List distinct = CollectionsKt.distinct(arrayList);
        if (!z5) {
            List<Area> list4 = distinct;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
            for (Area area2 : list4) {
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : list3) {
                    if (Intrinsics.areEqual(((ViewState.CityRow) obj).getArea(), area2)) {
                        arrayList3.add(obj);
                    }
                }
                ViewState.CityRow cityRow = (ViewState.CityRow) CollectionsKt.firstOrNull((List) arrayList3);
                Route findRoute = RouteExtensionsKt.findRoute(emptyList, id, cityRow != null ? cityRow.getId() : null);
                arrayList2.add(new ViewState.AreaGroup(area2.getName(), (findRoute == null || (outRoute = findRoute.getOutRoute()) == null || (routes = outRoute.getRoutes()) == null || (routeDirectionDetails = (RouteDirectionDetails) CollectionsKt.firstOrNull((List) routes)) == null) ? null : routeDirectionDetails.getSubline(), arrayList3));
            }
            list2 = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorKombardoViewModel$updateAvailableCityRows$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t5, T t6) {
                    return ComparisonsKt.compareValues(((RouteSelectorKombardoViewModel.ViewState.AreaGroup) t5).getName(), ((RouteSelectorKombardoViewModel.ViewState.AreaGroup) t6).getName());
                }
            });
        }
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, component1, list2, component2, null, null, 99, null)));
    }

    public final void focusDirection(RouteDirection direction) {
        ViewState value;
        Intrinsics.checkNotNullParameter(direction, "direction");
        if (direction == RouteDirection.Return && this.viewState.getValue().getSelectedFromCity() == null) {
            return;
        }
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, null, null, null, direction, null, 95, null)));
        updateAvailableCityRows();
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void locationPermissionGranted(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new RouteSelectorKombardoViewModel$locationPermissionGranted$1(this, context, null), 3, null);
    }

    public final void selectedCity(ViewState.CityRow cityRow, Function0<Unit> onRouteSelected) {
        ViewState value;
        ViewState value2;
        ViewState viewState;
        Intrinsics.checkNotNullParameter(cityRow, "cityRow");
        Intrinsics.checkNotNullParameter(onRouteSelected, "onRouteSelected");
        LocalizedSiteConfiguration localizedSiteConfiguration = null;
        if (this.viewState.getValue().getFocusedDirection() == RouteDirection.Outbound) {
            boolean areEqual = Intrinsics.areEqual(this._viewState.getValue().getSelectedFromCity(), cityRow);
            MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
            do {
                value2 = mutableStateFlow.getValue();
                viewState = value2;
            } while (!mutableStateFlow.compareAndSet(value2, ViewState.copy$default(viewState, cityRow, !areEqual ? null : viewState.getSelectedToCity(), null, null, null, RouteDirection.Return, null, 92, null)));
            updateAvailableCityRows();
            return;
        }
        MutableStateFlow<ViewState> mutableStateFlow2 = this._viewState;
        do {
            value = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value, ViewState.copy$default(value, null, cityRow, null, null, null, null, null, 125, null)));
        List<Route> routes = getRoutes();
        ViewState.CityRow selectedFromCity = this.viewState.getValue().getSelectedFromCity();
        String id = selectedFromCity != null ? selectedFromCity.getId() : null;
        ViewState.CityRow selectedToCity = this.viewState.getValue().getSelectedToCity();
        Route findRoute = RouteExtensionsKt.findRoute(routes, id, selectedToCity != null ? selectedToCity.getId() : null);
        if (findRoute != null) {
            String id2 = findRoute.getOutRoute().getDepartureHarbor().getId();
            ViewState.CityRow selectedFromCity2 = this.viewState.getValue().getSelectedFromCity();
            RouteDirection routeDirection = Intrinsics.areEqual(id2, selectedFromCity2 != null ? selectedFromCity2.getId() : null) ? RouteDirection.Outbound : RouteDirection.Return;
            LocalizedSiteConfiguration localizedSiteConfiguration2 = this.siteConfiguration;
            if (localizedSiteConfiguration2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("siteConfiguration");
            } else {
                localizedSiteConfiguration = localizedSiteConfiguration2;
            }
            for (Transportation transportation : localizedSiteConfiguration.getTransportations()) {
                if (transportation.getAllowedRouteIds().contains(findRoute.getId())) {
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new RouteSelectorKombardoViewModel$selectedCity$3$1(this, findRoute, routeDirection, transportation, onRouteSelected, null), 3, null);
                    return;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001:\u0002+,Bg\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJp\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b!\u0010\"R\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b#\u0010\"R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b$\u0010\"R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010(\u001a\u0004\b)\u0010*¨\u0006-"}, d2 = {"Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState$CityRow;", "selectedFromCity", "selectedToCity", BuildConfig.FLAVOR, "frequentlyUsedCityRows", "Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState$AreaGroup;", "areaGroups", "cityRows", "Ldk/molslinjen/domain/model/booking/RouteDirection;", "focusedDirection", "Ldk/molslinjen/domain/model/booking/HarborTravelTime;", "harborTravelTime", "<init>", "(Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState$CityRow;Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState$CityRow;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/domain/model/booking/RouteDirection;Ldk/molslinjen/domain/model/booking/HarborTravelTime;)V", "copy", "(Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState$CityRow;Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState$CityRow;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/domain/model/booking/RouteDirection;Ldk/molslinjen/domain/model/booking/HarborTravelTime;)Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState$CityRow;", "getSelectedFromCity", "()Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState$CityRow;", "getSelectedToCity", "Ljava/util/List;", "getFrequentlyUsedCityRows", "()Ljava/util/List;", "getAreaGroups", "getCityRows", "Ldk/molslinjen/domain/model/booking/RouteDirection;", "getFocusedDirection", "()Ldk/molslinjen/domain/model/booking/RouteDirection;", "Ldk/molslinjen/domain/model/booking/HarborTravelTime;", "getHarborTravelTime", "()Ldk/molslinjen/domain/model/booking/HarborTravelTime;", "CityRow", "AreaGroup", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final List<AreaGroup> areaGroups;
        private final List<CityRow> cityRows;
        private final RouteDirection focusedDirection;
        private final List<CityRow> frequentlyUsedCityRows;
        private final HarborTravelTime harborTravelTime;
        private final CityRow selectedFromCity;
        private final CityRow selectedToCity;

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState$AreaGroup;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "name", "Ldk/molslinjen/domain/model/config/Subline;", "subline", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState$CityRow;", "cityRows", "<init>", "(Ljava/lang/String;Ldk/molslinjen/domain/model/config/Subline;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "Ldk/molslinjen/domain/model/config/Subline;", "getSubline", "()Ldk/molslinjen/domain/model/config/Subline;", "Ljava/util/List;", "getCityRows", "()Ljava/util/List;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final /* data */ class AreaGroup {
            private final List<CityRow> cityRows;
            private final String name;
            private final Subline subline;

            public AreaGroup(String name, Subline subline, List<CityRow> cityRows) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(cityRows, "cityRows");
                this.name = name;
                this.subline = subline;
                this.cityRows = cityRows;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AreaGroup)) {
                    return false;
                }
                AreaGroup areaGroup = (AreaGroup) other;
                return Intrinsics.areEqual(this.name, areaGroup.name) && Intrinsics.areEqual(this.subline, areaGroup.subline) && Intrinsics.areEqual(this.cityRows, areaGroup.cityRows);
            }

            public final List<CityRow> getCityRows() {
                return this.cityRows;
            }

            public final String getName() {
                return this.name;
            }

            public final Subline getSubline() {
                return this.subline;
            }

            public int hashCode() {
                int hashCode = this.name.hashCode() * 31;
                Subline subline = this.subline;
                return ((hashCode + (subline == null ? 0 : subline.hashCode())) * 31) + this.cityRows.hashCode();
            }

            public String toString() {
                return "AreaGroup(name=" + this.name + ", subline=" + this.subline + ", cityRows=" + this.cityRows + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorKombardoViewModel$ViewState$CityRow;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "name", BuildConfig.FLAVOR, "defaultFrequentlyUsed", "Ldk/molslinjen/domain/model/config/Area;", "area", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLdk/molslinjen/domain/model/config/Area;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getName", "Z", "getDefaultFrequentlyUsed", "()Z", "Ldk/molslinjen/domain/model/config/Area;", "getArea", "()Ldk/molslinjen/domain/model/config/Area;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final /* data */ class CityRow {
            private final Area area;
            private final boolean defaultFrequentlyUsed;
            private final String id;
            private final String name;

            public CityRow(String id, String name, boolean z5, Area area) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(name, "name");
                this.id = id;
                this.name = name;
                this.defaultFrequentlyUsed = z5;
                this.area = area;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CityRow)) {
                    return false;
                }
                CityRow cityRow = (CityRow) other;
                return Intrinsics.areEqual(this.id, cityRow.id) && Intrinsics.areEqual(this.name, cityRow.name) && this.defaultFrequentlyUsed == cityRow.defaultFrequentlyUsed && Intrinsics.areEqual(this.area, cityRow.area);
            }

            public final Area getArea() {
                return this.area;
            }

            public final boolean getDefaultFrequentlyUsed() {
                return this.defaultFrequentlyUsed;
            }

            public final String getId() {
                return this.id;
            }

            public final String getName() {
                return this.name;
            }

            public int hashCode() {
                int hashCode = ((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + Boolean.hashCode(this.defaultFrequentlyUsed)) * 31;
                Area area = this.area;
                return hashCode + (area == null ? 0 : area.hashCode());
            }

            public String toString() {
                return "CityRow(id=" + this.id + ", name=" + this.name + ", defaultFrequentlyUsed=" + this.defaultFrequentlyUsed + ", area=" + this.area + ")";
            }
        }

        public ViewState(CityRow cityRow, CityRow cityRow2, List<CityRow> frequentlyUsedCityRows, List<AreaGroup> list, List<CityRow> cityRows, RouteDirection focusedDirection, HarborTravelTime harborTravelTime) {
            Intrinsics.checkNotNullParameter(frequentlyUsedCityRows, "frequentlyUsedCityRows");
            Intrinsics.checkNotNullParameter(cityRows, "cityRows");
            Intrinsics.checkNotNullParameter(focusedDirection, "focusedDirection");
            this.selectedFromCity = cityRow;
            this.selectedToCity = cityRow2;
            this.frequentlyUsedCityRows = frequentlyUsedCityRows;
            this.areaGroups = list;
            this.cityRows = cityRows;
            this.focusedDirection = focusedDirection;
            this.harborTravelTime = harborTravelTime;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, CityRow cityRow, CityRow cityRow2, List list, List list2, List list3, RouteDirection routeDirection, HarborTravelTime harborTravelTime, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                cityRow = viewState.selectedFromCity;
            }
            if ((i5 & 2) != 0) {
                cityRow2 = viewState.selectedToCity;
            }
            CityRow cityRow3 = cityRow2;
            if ((i5 & 4) != 0) {
                list = viewState.frequentlyUsedCityRows;
            }
            List list4 = list;
            if ((i5 & 8) != 0) {
                list2 = viewState.areaGroups;
            }
            List list5 = list2;
            if ((i5 & 16) != 0) {
                list3 = viewState.cityRows;
            }
            List list6 = list3;
            if ((i5 & 32) != 0) {
                routeDirection = viewState.focusedDirection;
            }
            RouteDirection routeDirection2 = routeDirection;
            if ((i5 & 64) != 0) {
                harborTravelTime = viewState.harborTravelTime;
            }
            return viewState.copy(cityRow, cityRow3, list4, list5, list6, routeDirection2, harborTravelTime);
        }

        public final ViewState copy(CityRow selectedFromCity, CityRow selectedToCity, List<CityRow> frequentlyUsedCityRows, List<AreaGroup> areaGroups, List<CityRow> cityRows, RouteDirection focusedDirection, HarborTravelTime harborTravelTime) {
            Intrinsics.checkNotNullParameter(frequentlyUsedCityRows, "frequentlyUsedCityRows");
            Intrinsics.checkNotNullParameter(cityRows, "cityRows");
            Intrinsics.checkNotNullParameter(focusedDirection, "focusedDirection");
            return new ViewState(selectedFromCity, selectedToCity, frequentlyUsedCityRows, areaGroups, cityRows, focusedDirection, harborTravelTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.selectedFromCity, viewState.selectedFromCity) && Intrinsics.areEqual(this.selectedToCity, viewState.selectedToCity) && Intrinsics.areEqual(this.frequentlyUsedCityRows, viewState.frequentlyUsedCityRows) && Intrinsics.areEqual(this.areaGroups, viewState.areaGroups) && Intrinsics.areEqual(this.cityRows, viewState.cityRows) && this.focusedDirection == viewState.focusedDirection && Intrinsics.areEqual(this.harborTravelTime, viewState.harborTravelTime);
        }

        public final List<AreaGroup> getAreaGroups() {
            return this.areaGroups;
        }

        public final List<CityRow> getCityRows() {
            return this.cityRows;
        }

        public final RouteDirection getFocusedDirection() {
            return this.focusedDirection;
        }

        public final List<CityRow> getFrequentlyUsedCityRows() {
            return this.frequentlyUsedCityRows;
        }

        public final HarborTravelTime getHarborTravelTime() {
            return this.harborTravelTime;
        }

        public final CityRow getSelectedFromCity() {
            return this.selectedFromCity;
        }

        public final CityRow getSelectedToCity() {
            return this.selectedToCity;
        }

        public int hashCode() {
            CityRow cityRow = this.selectedFromCity;
            int hashCode = (cityRow == null ? 0 : cityRow.hashCode()) * 31;
            CityRow cityRow2 = this.selectedToCity;
            int hashCode2 = (((hashCode + (cityRow2 == null ? 0 : cityRow2.hashCode())) * 31) + this.frequentlyUsedCityRows.hashCode()) * 31;
            List<AreaGroup> list = this.areaGroups;
            int hashCode3 = (((((hashCode2 + (list == null ? 0 : list.hashCode())) * 31) + this.cityRows.hashCode()) * 31) + this.focusedDirection.hashCode()) * 31;
            HarborTravelTime harborTravelTime = this.harborTravelTime;
            return hashCode3 + (harborTravelTime != null ? harborTravelTime.hashCode() : 0);
        }

        public String toString() {
            return "ViewState(selectedFromCity=" + this.selectedFromCity + ", selectedToCity=" + this.selectedToCity + ", frequentlyUsedCityRows=" + this.frequentlyUsedCityRows + ", areaGroups=" + this.areaGroups + ", cityRows=" + this.cityRows + ", focusedDirection=" + this.focusedDirection + ", harborTravelTime=" + this.harborTravelTime + ")";
        }

        public /* synthetic */ ViewState(CityRow cityRow, CityRow cityRow2, List list, List list2, List list3, RouteDirection routeDirection, HarborTravelTime harborTravelTime, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : cityRow, (i5 & 2) != 0 ? null : cityRow2, (i5 & 4) != 0 ? CollectionsKt.emptyList() : list, (i5 & 8) != 0 ? null : list2, (i5 & 16) != 0 ? CollectionsKt.emptyList() : list3, (i5 & 32) != 0 ? RouteDirection.Outbound : routeDirection, (i5 & 64) != 0 ? null : harborTravelTime);
        }
    }
}
