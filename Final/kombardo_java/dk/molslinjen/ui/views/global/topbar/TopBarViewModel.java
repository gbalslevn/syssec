package dk.molslinjen.ui.views.global.topbar;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/ui/views/global/topbar/TopBarViewModel;", "Landroidx/lifecycle/ViewModel;", "topBarManager", "Ldk/molslinjen/ui/views/global/topbar/ITopBarManager;", "<init>", "(Ldk/molslinjen/ui/views/global/topbar/ITopBarManager;)V", "_configState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/global/topbar/TopBarConfiguration;", "configState", "Lkotlinx/coroutines/flow/StateFlow;", "getConfigState", "()Lkotlinx/coroutines/flow/StateFlow;", "apply", BuildConfig.FLAVOR, "newConfig", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TopBarViewModel extends ViewModel {
    private final MutableStateFlow<TopBarConfiguration> _configState;
    private final ITopBarManager topBarManager;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.global.topbar.TopBarViewModel$1", f = "TopBarViewModel.kt", l = {22}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.global.topbar.TopBarViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/ui/views/global/topbar/TopBarConfiguration;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.global.topbar.TopBarViewModel$1$1", f = "TopBarViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.global.topbar.TopBarViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00471 extends SuspendLambda implements Function2<TopBarConfiguration, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TopBarViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00471(TopBarViewModel topBarViewModel, Continuation<? super C00471> continuation) {
                super(2, continuation);
                this.this$0 = topBarViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00471 c00471 = new C00471(this.this$0, continuation);
                c00471.L$0 = obj;
                return c00471;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(TopBarConfiguration topBarConfiguration, Continuation<? super Unit> continuation) {
                return ((C00471) create(topBarConfiguration, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.apply((TopBarConfiguration) this.L$0);
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
                StateFlow<TopBarConfiguration> configuration = TopBarViewModel.this.topBarManager.getConfiguration();
                C00471 c00471 = new C00471(TopBarViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(configuration, c00471, this) == coroutine_suspended) {
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

    public TopBarViewModel(ITopBarManager topBarManager) {
        Intrinsics.checkNotNullParameter(topBarManager, "topBarManager");
        this.topBarManager = topBarManager;
        this._configState = StateFlowKt.MutableStateFlow(new TopBarConfiguration(false, null, null, null, 15, null));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final void apply(TopBarConfiguration newConfig) {
        if (newConfig == null) {
            this._configState.setValue(TopBarConfiguration.copy$default(getConfigState().getValue(), false, null, null, null, 14, null));
        } else {
            this._configState.setValue(getConfigState().getValue().copy(newConfig.getIsVisible(), newConfig.getTitle(), newConfig.getNavigationButton(), newConfig.getButtons()));
        }
    }

    public final StateFlow<TopBarConfiguration> getConfigState() {
        return this._configState;
    }
}
