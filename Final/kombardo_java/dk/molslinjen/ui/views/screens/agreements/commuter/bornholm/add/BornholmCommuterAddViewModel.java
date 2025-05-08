package dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.add;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.domain.managers.agreement.commuter.bornholm.IBornholmCommuterManager;
import dk.molslinjen.ui.views.reusable.model.UIUploadState;
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

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0010J\u0014\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015J\u0006\u0010\u0016\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/add/BornholmCommuterAddViewModel;", "Landroidx/lifecycle/ViewModel;", "commuterManager", "Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager;", "<init>", "(Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/add/BornholmCommuterAddViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "onEmailChanged", BuildConfig.FLAVOR, "email", BuildConfig.FLAVOR, "onPasswordChanged", "password", "addCommuterCard", "proceed", "Lkotlin/Function0;", "hideErrorDialog", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BornholmCommuterAddViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IBornholmCommuterManager commuterManager;

    public BornholmCommuterAddViewModel(IBornholmCommuterManager commuterManager) {
        Intrinsics.checkNotNullParameter(commuterManager, "commuterManager");
        this.commuterManager = commuterManager;
        this._viewState = StateFlowKt.MutableStateFlow(new ViewState(null, false, null, null, 15, null));
    }

    public final void addCommuterCard(Function0<Unit> proceed) {
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BornholmCommuterAddViewModel$addCommuterCard$1(this, proceed, null), 3, null);
    }

    public final StateFlow<ViewState> getViewState() {
        return this._viewState;
    }

    public final void hideErrorDialog() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, false, null, null, 13, null)));
    }

    public final void onEmailChanged(String email) {
        ViewState value;
        Intrinsics.checkNotNullParameter(email, "email");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, false, email, null, 11, null)));
    }

    public final void onPasswordChanged(String password) {
        ViewState value;
        Intrinsics.checkNotNullParameter(password, "password");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, false, null, password, 7, null)));
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ8\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u000eR\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001d\u0010\u000e¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/add/BornholmCommuterAddViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/reusable/model/UIUploadState;", "uploadState", BuildConfig.FLAVOR, "showErrorDialog", BuildConfig.FLAVOR, "email", "password", "<init>", "(Ldk/molslinjen/ui/views/reusable/model/UIUploadState;ZLjava/lang/String;Ljava/lang/String;)V", "copy", "(Ldk/molslinjen/ui/views/reusable/model/UIUploadState;ZLjava/lang/String;Ljava/lang/String;)Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/add/BornholmCommuterAddViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/ui/views/reusable/model/UIUploadState;", "getUploadState", "()Ldk/molslinjen/ui/views/reusable/model/UIUploadState;", "Z", "getShowErrorDialog", "()Z", "Ljava/lang/String;", "getEmail", "getPassword", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final String email;
        private final String password;
        private final boolean showErrorDialog;
        private final UIUploadState uploadState;

        public ViewState(UIUploadState uploadState, boolean z5, String email, String password) {
            Intrinsics.checkNotNullParameter(uploadState, "uploadState");
            Intrinsics.checkNotNullParameter(email, "email");
            Intrinsics.checkNotNullParameter(password, "password");
            this.uploadState = uploadState;
            this.showErrorDialog = z5;
            this.email = email;
            this.password = password;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, UIUploadState uIUploadState, boolean z5, String str, String str2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                uIUploadState = viewState.uploadState;
            }
            if ((i5 & 2) != 0) {
                z5 = viewState.showErrorDialog;
            }
            if ((i5 & 4) != 0) {
                str = viewState.email;
            }
            if ((i5 & 8) != 0) {
                str2 = viewState.password;
            }
            return viewState.copy(uIUploadState, z5, str, str2);
        }

        public final ViewState copy(UIUploadState uploadState, boolean showErrorDialog, String email, String password) {
            Intrinsics.checkNotNullParameter(uploadState, "uploadState");
            Intrinsics.checkNotNullParameter(email, "email");
            Intrinsics.checkNotNullParameter(password, "password");
            return new ViewState(uploadState, showErrorDialog, email, password);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.uploadState == viewState.uploadState && this.showErrorDialog == viewState.showErrorDialog && Intrinsics.areEqual(this.email, viewState.email) && Intrinsics.areEqual(this.password, viewState.password);
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getPassword() {
            return this.password;
        }

        public final boolean getShowErrorDialog() {
            return this.showErrorDialog;
        }

        public final UIUploadState getUploadState() {
            return this.uploadState;
        }

        public int hashCode() {
            return (((((this.uploadState.hashCode() * 31) + Boolean.hashCode(this.showErrorDialog)) * 31) + this.email.hashCode()) * 31) + this.password.hashCode();
        }

        public String toString() {
            return "ViewState(uploadState=" + this.uploadState + ", showErrorDialog=" + this.showErrorDialog + ", email=" + this.email + ", password=" + this.password + ")";
        }

        public /* synthetic */ ViewState(UIUploadState uIUploadState, boolean z5, String str, String str2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? UIUploadState.Idle : uIUploadState, (i5 & 2) != 0 ? false : z5, (i5 & 4) != 0 ? BuildConfig.FLAVOR : str, (i5 & 8) != 0 ? BuildConfig.FLAVOR : str2);
        }
    }
}
