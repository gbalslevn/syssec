package dk.molslinjen.ui.views.screens.booking.departures.selectTransportation;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.config.TransportationCategory;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001%B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\nJ'\u0010\u0018\u001a\u00020\b2\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportation/TransportationSelectorViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "snackbarService", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "routeManager", "<init>", "(Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/managers/route/IRouteManager;)V", BuildConfig.FLAVOR, "load", "()V", "Ldk/molslinjen/domain/model/config/TransportationCategory;", "transportationCategory", "transportationCategorySelected", "(Ldk/molslinjen/domain/model/config/TransportationCategory;)V", "Ldk/molslinjen/domain/model/config/Transportation;", "transportation", "transportationSelected", "(Ldk/molslinjen/domain/model/config/Transportation;)V", "showValidationMessage", "Lkotlin/Function2;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "proceed", "saveAndClose", "(Lkotlin/jvm/functions/Function2;)V", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportation/TransportationSelectorViewModel$ViewState;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TransportationSelectorViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IRouteManager routeManager;
    private final ISnackbarService snackbarService;
    private final StateFlow<ViewState> viewState;

    public TransportationSelectorViewModel(ISnackbarService snackbarService, IRouteManager routeManager) {
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        this.snackbarService = snackbarService;
        this.routeManager = routeManager;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, null, null, null, 15, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        load();
    }

    private final void load() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TransportationSelectorViewModel$load$1(this, null), 3, null);
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void saveAndClose(Function2<? super Boolean, ? super String, Unit> proceed) {
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        Transportation selectedTransportation = this.viewState.getValue().getSelectedTransportation();
        if (selectedTransportation == null) {
            showValidationMessage();
        } else {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TransportationSelectorViewModel$saveAndClose$1(selectedTransportation.isFreightPossible(), proceed, selectedTransportation, this, null), 3, null);
        }
    }

    public final void showValidationMessage() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TransportationSelectorViewModel$showValidationMessage$1(this, null), 3, null);
    }

    public final void transportationCategorySelected(TransportationCategory transportationCategory) {
        ViewState value;
        Intrinsics.checkNotNullParameter(transportationCategory, "transportationCategory");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, (Transportation) CollectionsKt.firstOrNull((List) transportationCategory.getTransportations()), transportationCategory, transportationCategory.getTransportations(), null, 8, null)));
    }

    public final void transportationSelected(Transportation transportation) {
        ViewState value;
        Intrinsics.checkNotNullParameter(transportation, "transportation");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, transportation, null, null, null, 14, null)));
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJJ\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b \u0010\u001f¨\u0006!"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportation/TransportationSelectorViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/config/Transportation;", "selectedTransportation", "Ldk/molslinjen/domain/model/config/TransportationCategory;", "selectedTransportationCategory", BuildConfig.FLAVOR, "transportations", "transportationCategories", "<init>", "(Ldk/molslinjen/domain/model/config/Transportation;Ldk/molslinjen/domain/model/config/TransportationCategory;Ljava/util/List;Ljava/util/List;)V", "copy", "(Ldk/molslinjen/domain/model/config/Transportation;Ldk/molslinjen/domain/model/config/TransportationCategory;Ljava/util/List;Ljava/util/List;)Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportation/TransportationSelectorViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/config/Transportation;", "getSelectedTransportation", "()Ldk/molslinjen/domain/model/config/Transportation;", "Ldk/molslinjen/domain/model/config/TransportationCategory;", "getSelectedTransportationCategory", "()Ldk/molslinjen/domain/model/config/TransportationCategory;", "Ljava/util/List;", "getTransportations", "()Ljava/util/List;", "getTransportationCategories", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final Transportation selectedTransportation;
        private final TransportationCategory selectedTransportationCategory;
        private final List<TransportationCategory> transportationCategories;
        private final List<Transportation> transportations;

        public ViewState(Transportation transportation, TransportationCategory transportationCategory, List<Transportation> transportations, List<TransportationCategory> list) {
            Intrinsics.checkNotNullParameter(transportations, "transportations");
            this.selectedTransportation = transportation;
            this.selectedTransportationCategory = transportationCategory;
            this.transportations = transportations;
            this.transportationCategories = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, Transportation transportation, TransportationCategory transportationCategory, List list, List list2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                transportation = viewState.selectedTransportation;
            }
            if ((i5 & 2) != 0) {
                transportationCategory = viewState.selectedTransportationCategory;
            }
            if ((i5 & 4) != 0) {
                list = viewState.transportations;
            }
            if ((i5 & 8) != 0) {
                list2 = viewState.transportationCategories;
            }
            return viewState.copy(transportation, transportationCategory, list, list2);
        }

        public final ViewState copy(Transportation selectedTransportation, TransportationCategory selectedTransportationCategory, List<Transportation> transportations, List<TransportationCategory> transportationCategories) {
            Intrinsics.checkNotNullParameter(transportations, "transportations");
            return new ViewState(selectedTransportation, selectedTransportationCategory, transportations, transportationCategories);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.selectedTransportation, viewState.selectedTransportation) && Intrinsics.areEqual(this.selectedTransportationCategory, viewState.selectedTransportationCategory) && Intrinsics.areEqual(this.transportations, viewState.transportations) && Intrinsics.areEqual(this.transportationCategories, viewState.transportationCategories);
        }

        public final Transportation getSelectedTransportation() {
            return this.selectedTransportation;
        }

        public final TransportationCategory getSelectedTransportationCategory() {
            return this.selectedTransportationCategory;
        }

        public final List<TransportationCategory> getTransportationCategories() {
            return this.transportationCategories;
        }

        public final List<Transportation> getTransportations() {
            return this.transportations;
        }

        public int hashCode() {
            Transportation transportation = this.selectedTransportation;
            int hashCode = (transportation == null ? 0 : transportation.hashCode()) * 31;
            TransportationCategory transportationCategory = this.selectedTransportationCategory;
            int hashCode2 = (((hashCode + (transportationCategory == null ? 0 : transportationCategory.hashCode())) * 31) + this.transportations.hashCode()) * 31;
            List<TransportationCategory> list = this.transportationCategories;
            return hashCode2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "ViewState(selectedTransportation=" + this.selectedTransportation + ", selectedTransportationCategory=" + this.selectedTransportationCategory + ", transportations=" + this.transportations + ", transportationCategories=" + this.transportationCategories + ")";
        }

        public /* synthetic */ ViewState(Transportation transportation, TransportationCategory transportationCategory, List list, List list2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : transportation, (i5 & 2) != 0 ? null : transportationCategory, (i5 & 4) != 0 ? CollectionsKt.emptyList() : list, (i5 & 8) != 0 ? null : list2);
        }
    }
}
