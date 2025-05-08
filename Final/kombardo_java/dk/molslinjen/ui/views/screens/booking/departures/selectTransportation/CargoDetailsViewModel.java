package dk.molslinjen.ui.views.screens.booking.departures.selectTransportation;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.CargoDetailsScreenDestination;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.TransportationCargoInfo;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u00015B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0014\u001a\u00020\f2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f0\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0016¢\u0006\u0004\b\u001f\u0010\u0019J\u0015\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0016¢\u0006\u0004\b!\u0010\u0019J\u0015\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0016¢\u0006\u0004\b#\u0010\u0019J\u0015\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0016¢\u0006\u0004\b%\u0010\u0019J!\u0010&\u001a\u00020\f2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f0\u0011¢\u0006\u0004\b&\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010'R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020-008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00066"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportation/CargoDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "snackbarService", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "routeManager", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/managers/route/IRouteManager;)V", "Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "newInfo", BuildConfig.FLAVOR, "updateTransportationInfo", "(Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;)V", "getTransportationInfoOrCreate", "()Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "Lkotlin/Function1;", BuildConfig.FLAVOR, "proceed", "load", "(Lkotlin/jvm/functions/Function1;)V", BuildConfig.FLAVOR, "errorMessage", "showValidationMessage", "(Ljava/lang/String;)V", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "direction", "changeSection", "(Ldk/molslinjen/domain/model/booking/DepartureDirection;)V", "totalWeight", "onTotalWeightChange", "note1", "onNote1Change", "note2", "onNote2Change", "note3", "onNote3Change", "saveAndProceed", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportation/CargoDetailsScreenNavArgs;", "navArgs", "Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportation/CargoDetailsScreenNavArgs;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportation/CargoDetailsViewModel$ViewState;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CargoDetailsViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final CargoDetailsScreenNavArgs navArgs;
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

    public CargoDetailsViewModel(SavedStateHandle savedStateHandle, ISnackbarService snackbarService, IRouteManager routeManager) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        this.snackbarService = snackbarService;
        this.routeManager = routeManager;
        CargoDetailsScreenNavArgs argsFrom = CargoDetailsScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(argsFrom.getTransportationId(), false, 0.0d, false, null, null, null, false, false, 510, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
    }

    private final TransportationCargoInfo getTransportationInfoOrCreate() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[this._viewState.getValue().getActiveDirectionTab().ordinal()];
        if (i5 == 1) {
            return this.viewState.getValue().getOutboundCargoInfo();
        }
        if (i5 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        TransportationCargoInfo returnCargoInfo = this.viewState.getValue().getReturnCargoInfo();
        if (returnCargoInfo != null) {
            return returnCargoInfo;
        }
        return new TransportationCargoInfo((Double) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    private final void updateTransportationInfo(TransportationCargoInfo newInfo) {
        ViewState value;
        ViewState copy$default;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
            ViewState viewState = value;
            int i5 = WhenMappings.$EnumSwitchMapping$0[this._viewState.getValue().getActiveDirectionTab().ordinal()];
            if (i5 == 1) {
                copy$default = ViewState.copy$default(viewState, null, false, 0.0d, false, newInfo, null, null, false, false, 495, null);
            } else {
                if (i5 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                copy$default = ViewState.copy$default(viewState, null, false, 0.0d, false, null, newInfo, null, false, false, 479, null);
            }
        } while (!mutableStateFlow.compareAndSet(value, copy$default));
    }

    public final void changeSection(DepartureDirection direction) {
        ViewState value;
        Intrinsics.checkNotNullParameter(direction, "direction");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, false, 0.0d, false, null, null, direction, false, false, 447, null)));
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void load(Function1<? super Boolean, Unit> proceed) {
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CargoDetailsViewModel$load$1(this, proceed, null), 3, null);
    }

    public final void onNote1Change(String note1) {
        Intrinsics.checkNotNullParameter(note1, "note1");
        updateTransportationInfo(TransportationCargoInfo.copy$default(getTransportationInfoOrCreate(), null, note1, null, null, 13, null));
    }

    public final void onNote2Change(String note2) {
        Intrinsics.checkNotNullParameter(note2, "note2");
        updateTransportationInfo(TransportationCargoInfo.copy$default(getTransportationInfoOrCreate(), null, null, note2, null, 11, null));
    }

    public final void onNote3Change(String note3) {
        Intrinsics.checkNotNullParameter(note3, "note3");
        updateTransportationInfo(TransportationCargoInfo.copy$default(getTransportationInfoOrCreate(), null, null, null, note3, 7, null));
    }

    public final void onTotalWeightChange(String totalWeight) {
        Intrinsics.checkNotNullParameter(totalWeight, "totalWeight");
        updateTransportationInfo(TransportationCargoInfo.copy$default(getTransportationInfoOrCreate(), StringsKt.toDoubleOrNull(totalWeight), null, null, null, 14, null));
    }

    public final void saveAndProceed(Function1<? super Boolean, Unit> proceed) {
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CargoDetailsViewModel$saveAndProceed$1(this, proceed, null), 3, null);
    }

    public final void showValidationMessage(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CargoDetailsViewModel$showValidationMessage$1(this, errorMessage, null), 3, null);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011Jl\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u0005\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b#\u0010\u001fR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b'\u0010&R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\u000e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b+\u0010\u001fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u000f\u0010\u001f¨\u0006,"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportation/CargoDetailsViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "transportationId", BuildConfig.FLAVOR, "isWeightRequired", BuildConfig.FLAVOR, "maxWeightAllowed", "notesRequired", "Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "outboundCargoInfo", "returnCargoInfo", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "activeDirectionTab", "hasReturn", "isLoading", "<init>", "(Ljava/lang/String;ZDZLdk/molslinjen/domain/model/booking/TransportationCargoInfo;Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;Ldk/molslinjen/domain/model/booking/DepartureDirection;ZZ)V", "copy", "(Ljava/lang/String;ZDZLdk/molslinjen/domain/model/booking/TransportationCargoInfo;Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;Ldk/molslinjen/domain/model/booking/DepartureDirection;ZZ)Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportation/CargoDetailsViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTransportationId", "Z", "()Z", "D", "getMaxWeightAllowed", "()D", "getNotesRequired", "Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "getOutboundCargoInfo", "()Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "getReturnCargoInfo", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "getActiveDirectionTab", "()Ldk/molslinjen/domain/model/booking/DepartureDirection;", "getHasReturn", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final DepartureDirection activeDirectionTab;
        private final boolean hasReturn;
        private final boolean isLoading;
        private final boolean isWeightRequired;
        private final double maxWeightAllowed;
        private final boolean notesRequired;
        private final TransportationCargoInfo outboundCargoInfo;
        private final TransportationCargoInfo returnCargoInfo;
        private final String transportationId;

        public ViewState(String transportationId, boolean z5, double d5, boolean z6, TransportationCargoInfo outboundCargoInfo, TransportationCargoInfo transportationCargoInfo, DepartureDirection activeDirectionTab, boolean z7, boolean z8) {
            Intrinsics.checkNotNullParameter(transportationId, "transportationId");
            Intrinsics.checkNotNullParameter(outboundCargoInfo, "outboundCargoInfo");
            Intrinsics.checkNotNullParameter(activeDirectionTab, "activeDirectionTab");
            this.transportationId = transportationId;
            this.isWeightRequired = z5;
            this.maxWeightAllowed = d5;
            this.notesRequired = z6;
            this.outboundCargoInfo = outboundCargoInfo;
            this.returnCargoInfo = transportationCargoInfo;
            this.activeDirectionTab = activeDirectionTab;
            this.hasReturn = z7;
            this.isLoading = z8;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, String str, boolean z5, double d5, boolean z6, TransportationCargoInfo transportationCargoInfo, TransportationCargoInfo transportationCargoInfo2, DepartureDirection departureDirection, boolean z7, boolean z8, int i5, Object obj) {
            return viewState.copy((i5 & 1) != 0 ? viewState.transportationId : str, (i5 & 2) != 0 ? viewState.isWeightRequired : z5, (i5 & 4) != 0 ? viewState.maxWeightAllowed : d5, (i5 & 8) != 0 ? viewState.notesRequired : z6, (i5 & 16) != 0 ? viewState.outboundCargoInfo : transportationCargoInfo, (i5 & 32) != 0 ? viewState.returnCargoInfo : transportationCargoInfo2, (i5 & 64) != 0 ? viewState.activeDirectionTab : departureDirection, (i5 & 128) != 0 ? viewState.hasReturn : z7, (i5 & 256) != 0 ? viewState.isLoading : z8);
        }

        public final ViewState copy(String transportationId, boolean isWeightRequired, double maxWeightAllowed, boolean notesRequired, TransportationCargoInfo outboundCargoInfo, TransportationCargoInfo returnCargoInfo, DepartureDirection activeDirectionTab, boolean hasReturn, boolean isLoading) {
            Intrinsics.checkNotNullParameter(transportationId, "transportationId");
            Intrinsics.checkNotNullParameter(outboundCargoInfo, "outboundCargoInfo");
            Intrinsics.checkNotNullParameter(activeDirectionTab, "activeDirectionTab");
            return new ViewState(transportationId, isWeightRequired, maxWeightAllowed, notesRequired, outboundCargoInfo, returnCargoInfo, activeDirectionTab, hasReturn, isLoading);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.transportationId, viewState.transportationId) && this.isWeightRequired == viewState.isWeightRequired && Double.compare(this.maxWeightAllowed, viewState.maxWeightAllowed) == 0 && this.notesRequired == viewState.notesRequired && Intrinsics.areEqual(this.outboundCargoInfo, viewState.outboundCargoInfo) && Intrinsics.areEqual(this.returnCargoInfo, viewState.returnCargoInfo) && this.activeDirectionTab == viewState.activeDirectionTab && this.hasReturn == viewState.hasReturn && this.isLoading == viewState.isLoading;
        }

        public final DepartureDirection getActiveDirectionTab() {
            return this.activeDirectionTab;
        }

        public final boolean getHasReturn() {
            return this.hasReturn;
        }

        public final double getMaxWeightAllowed() {
            return this.maxWeightAllowed;
        }

        public final boolean getNotesRequired() {
            return this.notesRequired;
        }

        public final TransportationCargoInfo getOutboundCargoInfo() {
            return this.outboundCargoInfo;
        }

        public final TransportationCargoInfo getReturnCargoInfo() {
            return this.returnCargoInfo;
        }

        public final String getTransportationId() {
            return this.transportationId;
        }

        public int hashCode() {
            int hashCode = ((((((((this.transportationId.hashCode() * 31) + Boolean.hashCode(this.isWeightRequired)) * 31) + Double.hashCode(this.maxWeightAllowed)) * 31) + Boolean.hashCode(this.notesRequired)) * 31) + this.outboundCargoInfo.hashCode()) * 31;
            TransportationCargoInfo transportationCargoInfo = this.returnCargoInfo;
            return ((((((hashCode + (transportationCargoInfo == null ? 0 : transportationCargoInfo.hashCode())) * 31) + this.activeDirectionTab.hashCode()) * 31) + Boolean.hashCode(this.hasReturn)) * 31) + Boolean.hashCode(this.isLoading);
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        /* renamed from: isWeightRequired, reason: from getter */
        public final boolean getIsWeightRequired() {
            return this.isWeightRequired;
        }

        public String toString() {
            return "ViewState(transportationId=" + this.transportationId + ", isWeightRequired=" + this.isWeightRequired + ", maxWeightAllowed=" + this.maxWeightAllowed + ", notesRequired=" + this.notesRequired + ", outboundCargoInfo=" + this.outboundCargoInfo + ", returnCargoInfo=" + this.returnCargoInfo + ", activeDirectionTab=" + this.activeDirectionTab + ", hasReturn=" + this.hasReturn + ", isLoading=" + this.isLoading + ")";
        }

        public /* synthetic */ ViewState(String str, boolean z5, double d5, boolean z6, TransportationCargoInfo transportationCargoInfo, TransportationCargoInfo transportationCargoInfo2, DepartureDirection departureDirection, boolean z7, boolean z8, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i5 & 2) != 0 ? false : z5, (i5 & 4) != 0 ? 0.0d : d5, (i5 & 8) != 0 ? false : z6, (i5 & 16) != 0 ? new TransportationCargoInfo((Double) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null) : transportationCargoInfo, (i5 & 32) != 0 ? null : transportationCargoInfo2, (i5 & 64) != 0 ? DepartureDirection.Outbound : departureDirection, (i5 & 128) == 0 ? z7 : false, (i5 & 256) != 0 ? true : z8);
        }
    }
}
