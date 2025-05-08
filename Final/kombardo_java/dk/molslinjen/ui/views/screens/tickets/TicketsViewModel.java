package dk.molslinjen.ui.views.screens.tickets;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.Feature;
import dk.molslinjen.core.location.GoogleMapsNavigationHandler;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.managers.ticket.TicketsManager;
import dk.molslinjen.domain.model.booking.BookingHeader;
import dk.molslinjen.domain.model.config.Configuration;
import dk.molslinjen.domain.model.config.Harbor;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.SiteConfiguration;
import dk.molslinjen.domain.model.config.Transportation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001aB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/TicketsViewModel;", "Landroidx/lifecycle/ViewModel;", "ticketsManager", "Ldk/molslinjen/domain/managers/ticket/ITicketsManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "configurationManager", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "<init>", "(Ldk/molslinjen/domain/managers/ticket/ITicketsManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/tickets/TicketsViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadTickets", BuildConfig.FLAVOR, "ignoreIfLoading", BuildConfig.FLAVOR, "showOnMap", "address", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TicketsViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IConfigurationManager configurationManager;
    private final ISnackbarService snackbarService;
    private final ITicketsManager ticketsManager;
    private final StateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.TicketsViewModel$1", f = "TicketsViewModel.kt", l = {37}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.tickets.TicketsViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "state", "Ldk/molslinjen/domain/managers/ticket/TicketsManager$TicketsState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.TicketsViewModel$1$1", f = "TicketsViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.tickets.TicketsViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00651 extends SuspendLambda implements Function2<TicketsManager.TicketsState, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TicketsViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00651(TicketsViewModel ticketsViewModel, Continuation<? super C00651> continuation) {
                super(2, continuation);
                this.this$0 = ticketsViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00651 c00651 = new C00651(this.this$0, continuation);
                c00651.L$0 = obj;
                return c00651;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(TicketsManager.TicketsState ticketsState, Continuation<? super Unit> continuation) {
                return ((C00651) create(ticketsState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object value;
                ViewState viewState;
                ArrayList arrayList;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                TicketsManager.TicketsState ticketsState = (TicketsManager.TicketsState) this.L$0;
                MutableStateFlow mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                    viewState = (ViewState) value;
                    List<BookingHeader> bookings = ticketsState.getBookings();
                    arrayList = new ArrayList();
                    for (Object obj2 : bookings) {
                        if (((BookingHeader) obj2).isActive()) {
                            arrayList.add(obj2);
                        }
                    }
                } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(viewState, arrayList, null, null, !arrayList.isEmpty() ? false : viewState.getIsLoading(), 6, null)));
                return Unit.INSTANCE;
            }
        }

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<TicketsManager.TicketsState> ticketsState = TicketsViewModel.this.ticketsManager.getTicketsState();
                C00651 c00651 = new C00651(TicketsViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(ticketsState, c00651, this) == coroutine_suspended) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.TicketsViewModel$2", f = "TicketsViewModel.kt", l = {49}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.tickets.TicketsViewModel$2, reason: invalid class name */
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
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                IConfigurationManager iConfigurationManager = TicketsViewModel.this.configurationManager;
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
            Collection<SiteConfiguration> values = configuration.getSiteConfigurations().values();
            ArrayList<LocalizedSiteConfiguration> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(values, 10));
            Iterator<T> it = values.iterator();
            while (it.hasNext()) {
                arrayList.add(((SiteConfiguration) it.next()).getActiveConfiguration());
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CollectionsKt.addAll(arrayList2, ((LocalizedSiteConfiguration) it2.next()).getHarbors());
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
            for (LocalizedSiteConfiguration localizedSiteConfiguration : arrayList) {
                Pair pair = TuplesKt.to(localizedSiteConfiguration.getSite(), localizedSiteConfiguration.getTransportations());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            MutableStateFlow mutableStateFlow = TicketsViewModel.this._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, null, arrayList2, linkedHashMap, false, 9, null)));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public TicketsViewModel(ITicketsManager ticketsManager, ISnackbarService snackbarService, IConfigurationManager configurationManager) {
        Intrinsics.checkNotNullParameter(ticketsManager, "ticketsManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(configurationManager, "configurationManager");
        this.ticketsManager = ticketsManager;
        this.snackbarService = snackbarService;
        this.configurationManager = configurationManager;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, null, null, false, 15, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        loadTickets(false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
    }

    public static /* synthetic */ void loadTickets$default(TicketsViewModel ticketsViewModel, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = true;
        }
        ticketsViewModel.loadTickets(z5);
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void loadTickets(boolean ignoreIfLoading) {
        if (ignoreIfLoading && this._viewState.getValue().getIsLoading()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TicketsViewModel$loadTickets$1(this, null), 3, null);
    }

    public final void showOnMap(String address, Context context) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(context, "context");
        GoogleMapsNavigationHandler.INSTANCE.startNavigation(address, context, !Feature.OnlyWalkingPassengers.isEnabled());
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJV\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR)\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00020\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\f\u0010\"¨\u0006#"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/TicketsViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingHeader;", "bookings", "Ldk/molslinjen/domain/model/config/Harbor;", "allHarbors", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/config/Site;", "Ldk/molslinjen/domain/model/config/Transportation;", "transportationsBySite", BuildConfig.FLAVOR, "isLoading", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/Map;Z)V", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/Map;Z)Ldk/molslinjen/ui/views/screens/tickets/TicketsViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getBookings", "()Ljava/util/List;", "getAllHarbors", "Ljava/util/Map;", "getTransportationsBySite", "()Ljava/util/Map;", "Z", "()Z", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final List<Harbor> allHarbors;
        private final List<BookingHeader> bookings;
        private final boolean isLoading;
        private final Map<Site, List<Transportation>> transportationsBySite;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(List<BookingHeader> bookings, List<Harbor> allHarbors, Map<Site, ? extends List<Transportation>> transportationsBySite, boolean z5) {
            Intrinsics.checkNotNullParameter(bookings, "bookings");
            Intrinsics.checkNotNullParameter(allHarbors, "allHarbors");
            Intrinsics.checkNotNullParameter(transportationsBySite, "transportationsBySite");
            this.bookings = bookings;
            this.allHarbors = allHarbors;
            this.transportationsBySite = transportationsBySite;
            this.isLoading = z5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, List list, List list2, Map map, boolean z5, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                list = viewState.bookings;
            }
            if ((i5 & 2) != 0) {
                list2 = viewState.allHarbors;
            }
            if ((i5 & 4) != 0) {
                map = viewState.transportationsBySite;
            }
            if ((i5 & 8) != 0) {
                z5 = viewState.isLoading;
            }
            return viewState.copy(list, list2, map, z5);
        }

        public final ViewState copy(List<BookingHeader> bookings, List<Harbor> allHarbors, Map<Site, ? extends List<Transportation>> transportationsBySite, boolean isLoading) {
            Intrinsics.checkNotNullParameter(bookings, "bookings");
            Intrinsics.checkNotNullParameter(allHarbors, "allHarbors");
            Intrinsics.checkNotNullParameter(transportationsBySite, "transportationsBySite");
            return new ViewState(bookings, allHarbors, transportationsBySite, isLoading);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.bookings, viewState.bookings) && Intrinsics.areEqual(this.allHarbors, viewState.allHarbors) && Intrinsics.areEqual(this.transportationsBySite, viewState.transportationsBySite) && this.isLoading == viewState.isLoading;
        }

        public final List<Harbor> getAllHarbors() {
            return this.allHarbors;
        }

        public final List<BookingHeader> getBookings() {
            return this.bookings;
        }

        public final Map<Site, List<Transportation>> getTransportationsBySite() {
            return this.transportationsBySite;
        }

        public int hashCode() {
            return (((((this.bookings.hashCode() * 31) + this.allHarbors.hashCode()) * 31) + this.transportationsBySite.hashCode()) * 31) + Boolean.hashCode(this.isLoading);
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(bookings=" + this.bookings + ", allHarbors=" + this.allHarbors + ", transportationsBySite=" + this.transportationsBySite + ", isLoading=" + this.isLoading + ")";
        }

        public /* synthetic */ ViewState(List list, List list2, Map map, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? CollectionsKt.emptyList() : list, (i5 & 2) != 0 ? CollectionsKt.emptyList() : list2, (i5 & 4) != 0 ? MapsKt.emptyMap() : map, (i5 & 8) != 0 ? true : z5);
        }
    }
}
