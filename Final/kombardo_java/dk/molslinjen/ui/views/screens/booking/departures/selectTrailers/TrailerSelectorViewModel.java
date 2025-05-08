package dk.molslinjen.ui.views.screens.booking.departures.selectTrailers;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.checkout.IReturnManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002%&B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0014\u0010\"\u001a\u00020\u00192\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006'"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectTrailers/TrailerSelectorViewModel;", "Landroidx/lifecycle/ViewModel;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "returnManager", "Ldk/molslinjen/domain/managers/checkout/IReturnManager;", "<init>", "(Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/managers/checkout/IReturnManager;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/departures/selectTrailers/TrailerSelectorViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "_outboundTrailerState", "Ldk/molslinjen/ui/views/screens/booking/departures/selectTrailers/TrailerSelectorViewModel$TrailerSelectedState;", "outboundTrailerState", "getOutboundTrailerState", "_returnTrailerState", "returnTrailerState", "getReturnTrailerState", "loadTrailers", BuildConfig.FLAVOR, "trailerSelected", "trailerProduct", "Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "onChangedForDirection", "departureDirection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "selected", BuildConfig.FLAVOR, "saveAndClose", "proceed", "Lkotlin/Function0;", "TrailerSelectedState", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TrailerSelectorViewModel extends ViewModel {
    private final MutableStateFlow<TrailerSelectedState> _outboundTrailerState;
    private final MutableStateFlow<TrailerSelectedState> _returnTrailerState;
    private final MutableStateFlow<ViewState> _viewState;
    private final StateFlow<TrailerSelectedState> outboundTrailerState;
    private final IReturnManager returnManager;
    private final StateFlow<TrailerSelectedState> returnTrailerState;
    private final IRouteManager routeManager;
    private final ISnackbarService snackbarService;
    private final StateFlow<ViewState> viewState;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DepartureDirection.values().length];
            try {
                iArr[DepartureDirection.Outbound.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DepartureDirection.Return.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TrailerSelectorViewModel(IRouteManager routeManager, ISnackbarService snackbarService, IReturnManager returnManager) {
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(returnManager, "returnManager");
        this.routeManager = routeManager;
        this.snackbarService = snackbarService;
        this.returnManager = returnManager;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, false, false, null, null, false, 63, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        int i5 = 1;
        MutableStateFlow<TrailerSelectedState> MutableStateFlow2 = StateFlowKt.MutableStateFlow(new TrailerSelectedState(null, i5, 0 == true ? 1 : 0));
        this._outboundTrailerState = MutableStateFlow2;
        this.outboundTrailerState = MutableStateFlow2;
        MutableStateFlow<TrailerSelectedState> MutableStateFlow3 = StateFlowKt.MutableStateFlow(new TrailerSelectedState(0 == true ? 1 : 0, i5, 0 == true ? 1 : 0));
        this._returnTrailerState = MutableStateFlow3;
        this.returnTrailerState = MutableStateFlow3;
        loadTrailers();
    }

    public final StateFlow<TrailerSelectedState> getOutboundTrailerState() {
        return this.outboundTrailerState;
    }

    public final StateFlow<TrailerSelectedState> getReturnTrailerState() {
        return this.returnTrailerState;
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void loadTrailers() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TrailerSelectorViewModel$loadTrailers$1(this, null), 3, null);
    }

    public final void onChangedForDirection(DepartureDirection departureDirection, boolean selected) {
        MutableStateFlow<TrailerSelectedState> mutableStateFlow;
        TrailerSelectedState value;
        MutableStateFlow<TrailerSelectedState> mutableStateFlow2;
        TrailerSelectedState value2;
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        int i5 = iArr[departureDirection.ordinal()];
        if (i5 == 1) {
            mutableStateFlow = this._outboundTrailerState;
        } else {
            if (i5 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            mutableStateFlow = this._returnTrailerState;
        }
        if (selected) {
            int i6 = iArr[departureDirection.ordinal()];
            if (i6 == 1) {
                mutableStateFlow2 = this._returnTrailerState;
            } else {
                if (i6 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                mutableStateFlow2 = this._outboundTrailerState;
            }
            TrailerProduct selectedTrailer = mutableStateFlow2.getValue().getSelectedTrailer();
            do {
                value2 = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value2, value2.copy(selectedTrailer)));
            return;
        }
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, value.copy(null)));
    }

    public final void saveAndClose(Function0<Unit> proceed) {
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TrailerSelectorViewModel$saveAndClose$1(this, this._outboundTrailerState.getValue().getSelectedTrailer(), this._returnTrailerState.getValue().getSelectedTrailer(), proceed, null), 3, null);
    }

    public final void trailerSelected(TrailerProduct trailerProduct) {
        TrailerSelectedState value;
        TrailerSelectedState value2;
        TrailerSelectedState value3;
        Intrinsics.checkNotNullParameter(trailerProduct, "trailerProduct");
        if (this.viewState.getValue().getIsAddingReturnFromBookingSummary() && this._outboundTrailerState.getValue().getSelectedTrailer() == null) {
            MutableStateFlow<TrailerSelectedState> mutableStateFlow = this._returnTrailerState;
            do {
                value3 = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value3, value3.copy(trailerProduct)));
        } else {
            MutableStateFlow<TrailerSelectedState> mutableStateFlow2 = this._outboundTrailerState;
            do {
                value = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value, value.copy(trailerProduct)));
            MutableStateFlow<TrailerSelectedState> mutableStateFlow3 = this._returnTrailerState;
            do {
                value2 = mutableStateFlow3.getValue();
            } while (!mutableStateFlow3.compareAndSet(value2, value2.copy(trailerProduct)));
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectTrailers/TrailerSelectorViewModel$TrailerSelectedState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "selectedTrailer", "<init>", "(Ldk/molslinjen/domain/model/booking/product/TrailerProduct;)V", "copy", "(Ldk/molslinjen/domain/model/booking/product/TrailerProduct;)Ldk/molslinjen/ui/views/screens/booking/departures/selectTrailers/TrailerSelectorViewModel$TrailerSelectedState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "getSelectedTrailer", "()Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class TrailerSelectedState {
        private final TrailerProduct selectedTrailer;

        public TrailerSelectedState(TrailerProduct trailerProduct) {
            this.selectedTrailer = trailerProduct;
        }

        public final TrailerSelectedState copy(TrailerProduct selectedTrailer) {
            return new TrailerSelectedState(selectedTrailer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TrailerSelectedState) && Intrinsics.areEqual(this.selectedTrailer, ((TrailerSelectedState) other).selectedTrailer);
        }

        public final TrailerProduct getSelectedTrailer() {
            return this.selectedTrailer;
        }

        public int hashCode() {
            TrailerProduct trailerProduct = this.selectedTrailer;
            if (trailerProduct == null) {
                return 0;
            }
            return trailerProduct.hashCode();
        }

        public String toString() {
            return "TrailerSelectedState(selectedTrailer=" + this.selectedTrailer + ")";
        }

        public /* synthetic */ TrailerSelectedState(TrailerProduct trailerProduct, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : trailerProduct);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJR\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u0004\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u0005\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\"\u0010\u001b¨\u0006#"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectTrailers/TrailerSelectorViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "hasError", "isLoading", "isAddingReturnFromBookingSummary", "Ldk/molslinjen/domain/model/booking/BookingType;", "bookingType", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "trailers", "hadSelectedTrailerOnShow", "<init>", "(ZZZLdk/molslinjen/domain/model/booking/BookingType;Ljava/util/List;Z)V", "copy", "(ZZZLdk/molslinjen/domain/model/booking/BookingType;Ljava/util/List;Z)Ldk/molslinjen/ui/views/screens/booking/departures/selectTrailers/TrailerSelectorViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getHasError", "()Z", "Ldk/molslinjen/domain/model/booking/BookingType;", "getBookingType", "()Ldk/molslinjen/domain/model/booking/BookingType;", "Ljava/util/List;", "getTrailers", "()Ljava/util/List;", "getHadSelectedTrailerOnShow", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final BookingType bookingType;
        private final boolean hadSelectedTrailerOnShow;
        private final boolean hasError;
        private final boolean isAddingReturnFromBookingSummary;
        private final boolean isLoading;
        private final List<TrailerProduct> trailers;

        public ViewState(boolean z5, boolean z6, boolean z7, BookingType bookingType, List<TrailerProduct> trailers, boolean z8) {
            Intrinsics.checkNotNullParameter(bookingType, "bookingType");
            Intrinsics.checkNotNullParameter(trailers, "trailers");
            this.hasError = z5;
            this.isLoading = z6;
            this.isAddingReturnFromBookingSummary = z7;
            this.bookingType = bookingType;
            this.trailers = trailers;
            this.hadSelectedTrailerOnShow = z8;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, boolean z6, boolean z7, BookingType bookingType, List list, boolean z8, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = viewState.hasError;
            }
            if ((i5 & 2) != 0) {
                z6 = viewState.isLoading;
            }
            boolean z9 = z6;
            if ((i5 & 4) != 0) {
                z7 = viewState.isAddingReturnFromBookingSummary;
            }
            boolean z10 = z7;
            if ((i5 & 8) != 0) {
                bookingType = viewState.bookingType;
            }
            BookingType bookingType2 = bookingType;
            if ((i5 & 16) != 0) {
                list = viewState.trailers;
            }
            List list2 = list;
            if ((i5 & 32) != 0) {
                z8 = viewState.hadSelectedTrailerOnShow;
            }
            return viewState.copy(z5, z9, z10, bookingType2, list2, z8);
        }

        public final ViewState copy(boolean hasError, boolean isLoading, boolean isAddingReturnFromBookingSummary, BookingType bookingType, List<TrailerProduct> trailers, boolean hadSelectedTrailerOnShow) {
            Intrinsics.checkNotNullParameter(bookingType, "bookingType");
            Intrinsics.checkNotNullParameter(trailers, "trailers");
            return new ViewState(hasError, isLoading, isAddingReturnFromBookingSummary, bookingType, trailers, hadSelectedTrailerOnShow);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.hasError == viewState.hasError && this.isLoading == viewState.isLoading && this.isAddingReturnFromBookingSummary == viewState.isAddingReturnFromBookingSummary && this.bookingType == viewState.bookingType && Intrinsics.areEqual(this.trailers, viewState.trailers) && this.hadSelectedTrailerOnShow == viewState.hadSelectedTrailerOnShow;
        }

        public final BookingType getBookingType() {
            return this.bookingType;
        }

        public final boolean getHadSelectedTrailerOnShow() {
            return this.hadSelectedTrailerOnShow;
        }

        public final boolean getHasError() {
            return this.hasError;
        }

        public final List<TrailerProduct> getTrailers() {
            return this.trailers;
        }

        public int hashCode() {
            return (((((((((Boolean.hashCode(this.hasError) * 31) + Boolean.hashCode(this.isLoading)) * 31) + Boolean.hashCode(this.isAddingReturnFromBookingSummary)) * 31) + this.bookingType.hashCode()) * 31) + this.trailers.hashCode()) * 31) + Boolean.hashCode(this.hadSelectedTrailerOnShow);
        }

        /* renamed from: isAddingReturnFromBookingSummary, reason: from getter */
        public final boolean getIsAddingReturnFromBookingSummary() {
            return this.isAddingReturnFromBookingSummary;
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(hasError=" + this.hasError + ", isLoading=" + this.isLoading + ", isAddingReturnFromBookingSummary=" + this.isAddingReturnFromBookingSummary + ", bookingType=" + this.bookingType + ", trailers=" + this.trailers + ", hadSelectedTrailerOnShow=" + this.hadSelectedTrailerOnShow + ")";
        }

        public /* synthetic */ ViewState(boolean z5, boolean z6, boolean z7, BookingType bookingType, List list, boolean z8, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? false : z5, (i5 & 2) != 0 ? true : z6, (i5 & 4) != 0 ? false : z7, (i5 & 8) != 0 ? BookingType.Single : bookingType, (i5 & 16) != 0 ? CollectionsKt.emptyList() : list, (i5 & 32) != 0 ? false : z8);
        }
    }
}
