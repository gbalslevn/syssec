package dk.molslinjen.ui.views.global.bottombar;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.extensions.DestinationSpecExtensionsKt;
import dk.molslinjen.ui.views.global.navigation.SimpleScreenConfig;
import java.util.List;
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

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u0016\u0010\u0012\u001a\u00020\u00102\u000e\u0010\u0013\u001a\n\u0012\u0002\b\u00030\u0014j\u0002`\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/ui/views/global/bottombar/BottomBarViewModel;", "Landroidx/lifecycle/ViewModel;", "bottomBarManager", "Ldk/molslinjen/ui/views/global/bottombar/IBottomBarManager;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/ui/views/global/bottombar/IBottomBarManager;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "_stateConfig", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/global/bottombar/BottomBarConfiguration;", "stateConfig", "Lkotlinx/coroutines/flow/StateFlow;", "getStateConfig", "()Lkotlinx/coroutines/flow/StateFlow;", "updateConfig", BuildConfig.FLAVOR, "bottomBarConfiguration", "trackTabChange", "tab", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Lcom/ramcosta/composedestinations/spec/DestinationSpec;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BottomBarViewModel extends ViewModel {
    private final MutableStateFlow<BottomBarConfiguration> _stateConfig;
    private final IAnalyticsTracker analyticsTracker;
    private final IBottomBarManager bottomBarManager;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.global.bottombar.BottomBarViewModel$1", f = "BottomBarViewModel.kt", l = {27}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.global.bottombar.BottomBarViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/ui/views/global/bottombar/BottomBarConfiguration;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.global.bottombar.BottomBarViewModel$1$1", f = "BottomBarViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.global.bottombar.BottomBarViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00461 extends SuspendLambda implements Function2<BottomBarConfiguration, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ BottomBarViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00461(BottomBarViewModel bottomBarViewModel, Continuation<? super C00461> continuation) {
                super(2, continuation);
                this.this$0 = bottomBarViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00461 c00461 = new C00461(this.this$0, continuation);
                c00461.L$0 = obj;
                return c00461;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(BottomBarConfiguration bottomBarConfiguration, Continuation<? super Unit> continuation) {
                return ((C00461) create(bottomBarConfiguration, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.updateConfig((BottomBarConfiguration) this.L$0);
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
                StateFlow<BottomBarConfiguration> configuration = BottomBarViewModel.this.bottomBarManager.getConfiguration();
                C00461 c00461 = new C00461(BottomBarViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(configuration, c00461, this) == coroutine_suspended) {
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

    public BottomBarViewModel(IBottomBarManager bottomBarManager, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(bottomBarManager, "bottomBarManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.bottomBarManager = bottomBarManager;
        this.analyticsTracker = analyticsTracker;
        this._stateConfig = StateFlowKt.MutableStateFlow(SimpleScreenConfig.INSTANCE.getDefaultBottomNavConfig());
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateConfig(BottomBarConfiguration bottomBarConfiguration) {
        MutableStateFlow<BottomBarConfiguration> mutableStateFlow = this._stateConfig;
        BottomBarConfiguration value = getStateConfig().getValue();
        boolean isVisible = bottomBarConfiguration.getIsVisible();
        List<BottomBarButtonConfiguration> buttons = bottomBarConfiguration.getButtons();
        if (buttons == null) {
            buttons = this._stateConfig.getValue().getButtons();
        }
        mutableStateFlow.setValue(value.copy(isVisible, buttons));
    }

    public final StateFlow<BottomBarConfiguration> getStateConfig() {
        return this._stateConfig;
    }

    public final void trackTabChange(TypedDestinationSpec<?> tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        this.analyticsTracker.updateActiveTab(DestinationSpecExtensionsKt.toTrackingTab(tab));
    }
}
