package dk.molslinjen.ui.views.screens.agreements.commuter;

import dk.molslinjen.domain.extensions.CommuterDataStateExtensionsKt;
import dk.molslinjen.domain.managers.agreement.commuter.CommuterDataState;
import dk.molslinjen.domain.managers.agreement.commuter.oeresund.IOeresundCommuterManager;
import dk.molslinjen.domain.model.agreement.commuter.oeresund.OeresundCommuterAgreement;
import dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewViewModel$listenForOeresundChanges$1", f = "CommuterOverviewViewModel.kt", l = {39}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class CommuterOverviewViewModel$listenForOeresundChanges$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CommuterOverviewViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/domain/managers/agreement/commuter/CommuterDataState;", "Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewViewModel$listenForOeresundChanges$1$1", f = "CommuterOverviewViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewViewModel$listenForOeresundChanges$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CommuterDataState<? extends OeresundCommuterAgreement>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CommuterOverviewViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CommuterOverviewViewModel commuterOverviewViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = commuterOverviewViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CommuterDataState<OeresundCommuterAgreement> commuterDataState, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(commuterDataState, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableStateFlow mutableStateFlow;
            Object value;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CommuterDataState commuterDataState = (CommuterDataState) this.L$0;
            mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, CommuterOverviewViewModel.ViewState.copy$default((CommuterOverviewViewModel.ViewState) value, false, null, false, commuterDataState instanceof CommuterDataState.Undetermined, CommuterDataStateExtensionsKt.getAgreements(commuterDataState), commuterDataState instanceof CommuterDataState.Error, 7, null)));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CommuterDataState<? extends OeresundCommuterAgreement> commuterDataState, Continuation<? super Unit> continuation) {
            return invoke2((CommuterDataState<OeresundCommuterAgreement>) commuterDataState, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommuterOverviewViewModel$listenForOeresundChanges$1(CommuterOverviewViewModel commuterOverviewViewModel, Continuation<? super CommuterOverviewViewModel$listenForOeresundChanges$1> continuation) {
        super(2, continuation);
        this.this$0 = commuterOverviewViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommuterOverviewViewModel$listenForOeresundChanges$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IOeresundCommuterManager iOeresundCommuterManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iOeresundCommuterManager = this.this$0.oeresundCommuterManager;
            StateFlow<CommuterDataState<OeresundCommuterAgreement>> state = iOeresundCommuterManager.getState();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (FlowKt.collectLatest(state, anonymousClass1, this) == coroutine_suspended) {
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
        return ((CommuterOverviewViewModel$listenForOeresundChanges$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
