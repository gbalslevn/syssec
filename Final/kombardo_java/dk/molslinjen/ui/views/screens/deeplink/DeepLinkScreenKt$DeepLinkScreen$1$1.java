package dk.molslinjen.ui.views.screens.deeplink;

import com.ramcosta.composedestinations.generated.destinations.AccountActivationScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeparturesScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ResetPasswordScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketDetailsScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.ui.views.screens.deeplink.DeepLinkState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.deeplink.DeepLinkScreenKt$DeepLinkScreen$1$1", f = "DeepLinkScreen.kt", l = {30}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class DeepLinkScreenKt$DeepLinkScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ DeepLinkViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/ui/views/screens/deeplink/DeepLinkState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.deeplink.DeepLinkScreenKt$DeepLinkScreen$1$1$1", f = "DeepLinkScreen.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.deeplink.DeepLinkScreenKt$DeepLinkScreen$1$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<DeepLinkState, Continuation<? super Unit>, Object> {
        final /* synthetic */ DestinationsNavigator $navigator;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DestinationsNavigator destinationsNavigator, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$navigator = destinationsNavigator;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$navigator, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(DeepLinkState deepLinkState, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(deepLinkState, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            DeepLinkState deepLinkState = (DeepLinkState) this.L$0;
            if (Intrinsics.areEqual(deepLinkState, DeepLinkState.ShowHomeScreen.INSTANCE)) {
                DeepLinkScreenKt.navigateWithPop(this.$navigator, DeparturesScreenDestination.invoke$default(DeparturesScreenDestination.INSTANCE, false, 1, null));
            } else if (deepLinkState instanceof DeepLinkState.ShowEarlyCheckIn) {
                DeepLinkState.ShowEarlyCheckIn showEarlyCheckIn = (DeepLinkState.ShowEarlyCheckIn) deepLinkState;
                DeepLinkScreenKt.navigateWithPop(this.$navigator, TicketDetailsScreenDestination.INSTANCE.invoke(showEarlyCheckIn.getReservationNumber(), showEarlyCheckIn.getPhone(), showEarlyCheckIn.getSite(), false));
            } else if (deepLinkState instanceof DeepLinkState.ShowPasswordReset) {
                DeepLinkState.ShowPasswordReset showPasswordReset = (DeepLinkState.ShowPasswordReset) deepLinkState;
                DeepLinkScreenKt.navigateWithPop(this.$navigator, ResetPasswordScreenDestination.INSTANCE.invoke(showPasswordReset.getToken(), showPasswordReset.getOriginalUrl()));
            } else if (deepLinkState instanceof DeepLinkState.ShowAccountActivation) {
                DeepLinkState.ShowAccountActivation showAccountActivation = (DeepLinkState.ShowAccountActivation) deepLinkState;
                DeepLinkScreenKt.navigateWithPop(this.$navigator, AccountActivationScreenDestination.INSTANCE.invoke(showAccountActivation.getToken(), showAccountActivation.getOriginalUrl()));
            } else {
                if (deepLinkState != null) {
                    throw new NoWhenBranchMatchedException();
                }
                DeepLinkScreenKt.navigateWithPop(this.$navigator, DeparturesScreenDestination.invoke$default(DeparturesScreenDestination.INSTANCE, false, 1, null));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepLinkScreenKt$DeepLinkScreen$1$1(DeepLinkViewModel deepLinkViewModel, DestinationsNavigator destinationsNavigator, Continuation<? super DeepLinkScreenKt$DeepLinkScreen$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = deepLinkViewModel;
        this.$navigator = destinationsNavigator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeepLinkScreenKt$DeepLinkScreen$1$1(this.$viewModel, this.$navigator, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow<DeepLinkState> deepLinkState = this.$viewModel.getDeepLinkState();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$navigator, null);
            this.label = 1;
            if (FlowKt.collectLatest(deepLinkState, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$viewModel.resetDeepLinkState();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeepLinkScreenKt$DeepLinkScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
