package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.checkout.ISimpleChangeCheckoutManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/processing/EarlyCheckInProcessingViewModel;", "Landroidx/lifecycle/ViewModel;", "simpleChangeCheckoutManager", "Ldk/molslinjen/domain/managers/checkout/ISimpleChangeCheckoutManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "<init>", "(Ldk/molslinjen/domain/managers/checkout/ISimpleChangeCheckoutManager;Ldk/molslinjen/core/snackbar/ISnackbarService;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/processing/EarlyCheckInProcessingViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "startEarlyCheckIn", BuildConfig.FLAVOR, "dismiss", "Lkotlin/Function0;", "screenWidth", BuildConfig.FLAVOR, "screenHeight", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EarlyCheckInProcessingViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final ISimpleChangeCheckoutManager simpleChangeCheckoutManager;
    private final ISnackbarService snackbarService;
    private final StateFlow<ViewState> viewState;

    public EarlyCheckInProcessingViewModel(ISimpleChangeCheckoutManager simpleChangeCheckoutManager, ISnackbarService snackbarService) {
        Intrinsics.checkNotNullParameter(simpleChangeCheckoutManager, "simpleChangeCheckoutManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        this.simpleChangeCheckoutManager = simpleChangeCheckoutManager;
        this.snackbarService = snackbarService;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, 1, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void startEarlyCheckIn(Function0<Unit> dismiss, float screenWidth, float screenHeight) {
        Intrinsics.checkNotNullParameter(dismiss, "dismiss");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new EarlyCheckInProcessingViewModel$startEarlyCheckIn$1(this, screenWidth, screenHeight, dismiss, null), 3, null);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0003\u0010\u0012¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/processing/EarlyCheckInProcessingViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isCompleted", "<init>", "(Z)V", "copy", "(Z)Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/processing/EarlyCheckInProcessingViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final boolean isCompleted;

        public ViewState(boolean z5) {
            this.isCompleted = z5;
        }

        public final ViewState copy(boolean isCompleted) {
            return new ViewState(isCompleted);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ViewState) && this.isCompleted == ((ViewState) other).isCompleted;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isCompleted);
        }

        /* renamed from: isCompleted, reason: from getter */
        public final boolean getIsCompleted() {
            return this.isCompleted;
        }

        public String toString() {
            return "ViewState(isCompleted=" + this.isCompleted + ")";
        }

        public /* synthetic */ ViewState(boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? false : z5);
        }
    }
}
