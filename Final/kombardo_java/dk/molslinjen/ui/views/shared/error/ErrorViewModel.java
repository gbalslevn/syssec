package dk.molslinjen.ui.views.shared.error;

import androidx.appcompat.R$styleable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/ui/views/shared/error/ErrorViewModel;", "Landroidx/lifecycle/ViewModel;", "configurationManager", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "<init>", "(Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/shared/error/ErrorViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "updateShowBlockingErrorScreen", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reload", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ErrorViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IConfigurationManager configurationManager;
    private final StateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.shared.error.ErrorViewModel$1", f = "ErrorViewModel.kt", l = {R$styleable.Toolbar_titleMarginBottom}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.shared.error.ErrorViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

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
                ErrorViewModel errorViewModel = ErrorViewModel.this;
                this.label = 1;
                if (errorViewModel.updateShowBlockingErrorScreen(this) == coroutine_suspended) {
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

    public ErrorViewModel(IConfigurationManager configurationManager) {
        Intrinsics.checkNotNullParameter(configurationManager, "configurationManager");
        this.configurationManager = configurationManager;
        boolean z5 = false;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(z5, z5, 3, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0065 -> B:10:0x0066). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateShowBlockingErrorScreen(Continuation<? super Unit> continuation) {
        ErrorViewModel$updateShowBlockingErrorScreen$1 errorViewModel$updateShowBlockingErrorScreen$1;
        int i5;
        ErrorViewModel errorViewModel;
        MutableStateFlow mutableStateFlow;
        if (continuation instanceof ErrorViewModel$updateShowBlockingErrorScreen$1) {
            errorViewModel$updateShowBlockingErrorScreen$1 = (ErrorViewModel$updateShowBlockingErrorScreen$1) continuation;
            int i6 = errorViewModel$updateShowBlockingErrorScreen$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                errorViewModel$updateShowBlockingErrorScreen$1.label = i6 - Integer.MIN_VALUE;
                Object obj = errorViewModel$updateShowBlockingErrorScreen$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = errorViewModel$updateShowBlockingErrorScreen$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    errorViewModel = this;
                    mutableStateFlow = this._viewState;
                    r6 = mutableStateFlow.getValue();
                    r5 = (ViewState) r6;
                    IConfigurationManager iConfigurationManager = errorViewModel.configurationManager;
                    errorViewModel$updateShowBlockingErrorScreen$1.L$0 = errorViewModel;
                    errorViewModel$updateShowBlockingErrorScreen$1.L$1 = mutableStateFlow;
                    errorViewModel$updateShowBlockingErrorScreen$1.L$2 = r6;
                    errorViewModel$updateShowBlockingErrorScreen$1.L$3 = r5;
                    errorViewModel$updateShowBlockingErrorScreen$1.I$0 = 0;
                    errorViewModel$updateShowBlockingErrorScreen$1.label = 1;
                    obj = iConfigurationManager.getConfiguration(errorViewModel$updateShowBlockingErrorScreen$1);
                    if (obj == coroutine_suspended) {
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i7 = errorViewModel$updateShowBlockingErrorScreen$1.I$0;
                    ViewState viewState = (ViewState) errorViewModel$updateShowBlockingErrorScreen$1.L$3;
                    Object value = errorViewModel$updateShowBlockingErrorScreen$1.L$2;
                    mutableStateFlow = (MutableStateFlow) errorViewModel$updateShowBlockingErrorScreen$1.L$1;
                    errorViewModel = (ErrorViewModel) errorViewModel$updateShowBlockingErrorScreen$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (mutableStateFlow.compareAndSet(value, ViewState.copy$default(viewState, i7 == 0, obj != null, 1, null))) {
                        return Unit.INSTANCE;
                    }
                    value = mutableStateFlow.getValue();
                    viewState = (ViewState) value;
                    IConfigurationManager iConfigurationManager2 = errorViewModel.configurationManager;
                    errorViewModel$updateShowBlockingErrorScreen$1.L$0 = errorViewModel;
                    errorViewModel$updateShowBlockingErrorScreen$1.L$1 = mutableStateFlow;
                    errorViewModel$updateShowBlockingErrorScreen$1.L$2 = value;
                    errorViewModel$updateShowBlockingErrorScreen$1.L$3 = viewState;
                    errorViewModel$updateShowBlockingErrorScreen$1.I$0 = 0;
                    errorViewModel$updateShowBlockingErrorScreen$1.label = 1;
                    obj = iConfigurationManager2.getConfiguration(errorViewModel$updateShowBlockingErrorScreen$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i7 = 0;
                    if (mutableStateFlow.compareAndSet(value, ViewState.copy$default(viewState, i7 == 0, obj != null, 1, null))) {
                    }
                    value = mutableStateFlow.getValue();
                    viewState = (ViewState) value;
                    IConfigurationManager iConfigurationManager22 = errorViewModel.configurationManager;
                    errorViewModel$updateShowBlockingErrorScreen$1.L$0 = errorViewModel;
                    errorViewModel$updateShowBlockingErrorScreen$1.L$1 = mutableStateFlow;
                    errorViewModel$updateShowBlockingErrorScreen$1.L$2 = value;
                    errorViewModel$updateShowBlockingErrorScreen$1.L$3 = viewState;
                    errorViewModel$updateShowBlockingErrorScreen$1.I$0 = 0;
                    errorViewModel$updateShowBlockingErrorScreen$1.label = 1;
                    obj = iConfigurationManager22.getConfiguration(errorViewModel$updateShowBlockingErrorScreen$1);
                    if (obj == coroutine_suspended) {
                    }
                }
            }
        }
        errorViewModel$updateShowBlockingErrorScreen$1 = new ErrorViewModel$updateShowBlockingErrorScreen$1(this, continuation);
        Object obj2 = errorViewModel$updateShowBlockingErrorScreen$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = errorViewModel$updateShowBlockingErrorScreen$1.label;
        if (i5 != 0) {
        }
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void reload() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ErrorViewModel$reload$1(this, null), 3, null);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0003\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/ui/views/shared/error/ErrorViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", "shouldShowBlockingErrorScreen", "<init>", "(ZZ)V", "copy", "(ZZ)Ldk/molslinjen/ui/views/shared/error/ErrorViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "getShouldShowBlockingErrorScreen", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final boolean isLoading;
        private final boolean shouldShowBlockingErrorScreen;

        public ViewState(boolean z5, boolean z6) {
            this.isLoading = z5;
            this.shouldShowBlockingErrorScreen = z6;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, boolean z6, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i5 & 2) != 0) {
                z6 = viewState.shouldShowBlockingErrorScreen;
            }
            return viewState.copy(z5, z6);
        }

        public final ViewState copy(boolean isLoading, boolean shouldShowBlockingErrorScreen) {
            return new ViewState(isLoading, shouldShowBlockingErrorScreen);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && this.shouldShowBlockingErrorScreen == viewState.shouldShowBlockingErrorScreen;
        }

        public final boolean getShouldShowBlockingErrorScreen() {
            return this.shouldShowBlockingErrorScreen;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.isLoading) * 31) + Boolean.hashCode(this.shouldShowBlockingErrorScreen);
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", shouldShowBlockingErrorScreen=" + this.shouldShowBlockingErrorScreen + ")";
        }

        public /* synthetic */ ViewState(boolean z5, boolean z6, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? false : z5, (i5 & 2) != 0 ? false : z6);
        }
    }
}
