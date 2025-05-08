package dk.molslinjen.ui.views.screens.profile.merge;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.LoginResult;
import dk.molslinjen.domain.managers.user.merge.AssetsMergeMethod;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002!\"B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007JU\u0010\u000e\u001a\u00020\u000f2\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00112$\u0010\u0016\u001a \b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0017¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0014\u0010\u001d\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006#"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel;", "Landroidx/lifecycle/ViewModel;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "<init>", "(Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/core/snackbar/ISnackbarService;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$ViewState;", "viewState", "getViewState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "perform", "Lkotlinx/coroutines/Job;", "action", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/managers/user/LoginResult;", BuildConfig.FLAVOR, "failure", "Lkotlin/Function2;", "Ldk/molslinjen/domain/managers/ManagerResult$Error;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "merge", "method", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeMethod;", "cancelMerge", "dismiss", "Lkotlin/Function0;", BuildConfig.FLAVOR, "ViewState", "MergeState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AssetsMergeViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final ISnackbarService snackbarService;
    private final IUserManager userManager;
    private final MutableStateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState;", BuildConfig.FLAVOR, "<init>", "()V", "Merge", "Loading", "MergingError", "ActionError", "Success", "Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState$ActionError;", "Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState$Loading;", "Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState$Merge;", "Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState$MergingError;", "Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState$Success;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class MergeState {

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState$ActionError;", "Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState;", "Ldk/molslinjen/domain/managers/ManagerResult$Error;", "error", "<init>", "(Ldk/molslinjen/domain/managers/ManagerResult$Error;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/managers/ManagerResult$Error;", "getError", "()Ldk/molslinjen/domain/managers/ManagerResult$Error;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final /* data */ class ActionError extends MergeState {
            private final ManagerResult.Error error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ActionError(ManagerResult.Error error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ActionError) && Intrinsics.areEqual(this.error, ((ActionError) other).error);
            }

            public final ManagerResult.Error getError() {
                return this.error;
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "ActionError(error=" + this.error + ")";
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState$Loading;", "Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Loading extends MergeState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState$Merge;", "Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Merge extends MergeState {
            public static final Merge INSTANCE = new Merge();

            private Merge() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState$MergingError;", "Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState;", "Ldk/molslinjen/domain/managers/ManagerResult$Error;", "error", "<init>", "(Ldk/molslinjen/domain/managers/ManagerResult$Error;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/managers/ManagerResult$Error;", "getError", "()Ldk/molslinjen/domain/managers/ManagerResult$Error;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final /* data */ class MergingError extends MergeState {
            private final ManagerResult.Error error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MergingError(ManagerResult.Error error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof MergingError) && Intrinsics.areEqual(this.error, ((MergingError) other).error);
            }

            public final ManagerResult.Error getError() {
                return this.error;
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "MergingError(error=" + this.error + ")";
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState$Success;", "Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Success extends MergeState {
            public static final Success INSTANCE = new Success();

            private Success() {
                super(null);
            }
        }

        public /* synthetic */ MergeState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private MergeState() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AssetsMergeViewModel(IUserManager userManager, ISnackbarService snackbarService) {
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        this.userManager = userManager;
        this.snackbarService = snackbarService;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, 1, 0 == true ? 1 : 0));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
    }

    public final Job cancelMerge(Function0<Unit> dismiss) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(dismiss, "dismiss");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AssetsMergeViewModel$cancelMerge$1(this, dismiss, null), 3, null);
        return launch$default;
    }

    public final MutableStateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final Job merge(AssetsMergeMethod method) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(method, "method");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AssetsMergeViewModel$merge$1(this, method, null), 3, null);
        return launch$default;
    }

    public final Job perform(Function1<? super Continuation<? super ManagerResult<? extends LoginResult>>, ? extends Object> action, Function2<? super ManagerResult.Error, ? super Continuation<? super ManagerResult.Error>, ? extends Object> failure) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(failure, "failure");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AssetsMergeViewModel$perform$1(this, action, failure, null), 3, null);
        return launch$default;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState;", "state", "<init>", "(Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState;)V", "copy", "(Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState;)Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState;", "getState", "()Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final MergeState state;

        public ViewState(MergeState state) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
        }

        public final ViewState copy(MergeState state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new ViewState(state);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ViewState) && Intrinsics.areEqual(this.state, ((ViewState) other).state);
        }

        public final MergeState getState() {
            return this.state;
        }

        public int hashCode() {
            return this.state.hashCode();
        }

        public String toString() {
            return "ViewState(state=" + this.state + ")";
        }

        public /* synthetic */ ViewState(MergeState mergeState, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? MergeState.Loading.INSTANCE : mergeState);
        }
    }
}
