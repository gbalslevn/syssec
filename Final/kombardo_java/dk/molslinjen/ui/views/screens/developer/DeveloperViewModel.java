package dk.molslinjen.ui.views.screens.developer;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.ApiEnvironment;
import dk.molslinjen.domain.managers.api.IApiProviderManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/ui/views/screens/developer/DeveloperViewModel;", "Landroidx/lifecycle/ViewModel;", "apiProviderManager", "Ldk/molslinjen/domain/managers/api/IApiProviderManager;", "<init>", "(Ldk/molslinjen/domain/managers/api/IApiProviderManager;)V", "apiEnvironmentState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/core/ApiEnvironment;", "getApiEnvironmentState", "()Lkotlinx/coroutines/flow/StateFlow;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeveloperViewModel extends ViewModel {
    private final StateFlow<ApiEnvironment> apiEnvironmentState;

    public DeveloperViewModel(final IApiProviderManager apiProviderManager) {
        Intrinsics.checkNotNullParameter(apiProviderManager, "apiProviderManager");
        final StateFlow<ApiEnvironment> overrideApiState = apiProviderManager.getOverrideApiState();
        this.apiEnvironmentState = FlowKt.stateIn(new Flow<ApiEnvironment>() { // from class: dk.molslinjen.ui.views.screens.developer.DeveloperViewModel$special$$inlined$map$1

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", BuildConfig.FLAVOR, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
            /* renamed from: dk.molslinjen.ui.views.screens.developer.DeveloperViewModel$special$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ IApiProviderManager $apiProviderManager$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "dk.molslinjen.ui.views.screens.developer.DeveloperViewModel$special$$inlined$map$1$2", f = "DeveloperViewModel.kt", l = {223}, m = "emit")
                /* renamed from: dk.molslinjen.ui.views.screens.developer.DeveloperViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, IApiProviderManager iApiProviderManager) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$apiProviderManager$inlined = iApiProviderManager;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i5;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i6 = anonymousClass1.label;
                        if ((i6 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i6 - Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i5 = anonymousClass1.label;
                            if (i5 != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                ApiEnvironment apiEnvironment = (ApiEnvironment) obj;
                                if (apiEnvironment == null) {
                                    apiEnvironment = this.$apiProviderManager$inlined.getOriginalApi();
                                }
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(apiEnvironment, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i5 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = anonymousClass1.label;
                    if (i5 != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super ApiEnvironment> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, apiProviderManager), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, ViewModelKt.getViewModelScope(this), SharingStarted.INSTANCE.getLazily(), apiProviderManager.getActiveApi());
    }

    public final StateFlow<ApiEnvironment> getApiEnvironmentState() {
        return this.apiEnvironmentState;
    }
}
