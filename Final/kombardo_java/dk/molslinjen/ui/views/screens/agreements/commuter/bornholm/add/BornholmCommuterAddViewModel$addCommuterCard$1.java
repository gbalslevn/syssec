package dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.add;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.agreement.commuter.bornholm.IBornholmCommuterManager;
import dk.molslinjen.ui.views.reusable.model.UIUploadState;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.add.BornholmCommuterAddViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.add.BornholmCommuterAddViewModel$addCommuterCard$1", f = "BornholmCommuterAddViewModel.kt", l = {31}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class BornholmCommuterAddViewModel$addCommuterCard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $proceed;
    int label;
    final /* synthetic */ BornholmCommuterAddViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BornholmCommuterAddViewModel$addCommuterCard$1(BornholmCommuterAddViewModel bornholmCommuterAddViewModel, Function0<Unit> function0, Continuation<? super BornholmCommuterAddViewModel$addCommuterCard$1> continuation) {
        super(2, continuation);
        this.this$0 = bornholmCommuterAddViewModel;
        this.$proceed = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BornholmCommuterAddViewModel$addCommuterCard$1(this.this$0, this.$proceed, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        IBornholmCommuterManager iBornholmCommuterManager;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        MutableStateFlow mutableStateFlow4;
        Object value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, BornholmCommuterAddViewModel.ViewState.copy$default((BornholmCommuterAddViewModel.ViewState) value, UIUploadState.Loading, false, null, null, 14, null)));
            iBornholmCommuterManager = this.this$0.commuterManager;
            mutableStateFlow2 = this.this$0._viewState;
            String email = ((BornholmCommuterAddViewModel.ViewState) mutableStateFlow2.getValue()).getEmail();
            mutableStateFlow3 = this.this$0._viewState;
            String password = ((BornholmCommuterAddViewModel.ViewState) mutableStateFlow3.getValue()).getPassword();
            this.label = 1;
            obj = iBornholmCommuterManager.addAgreements(email, password, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ManagerResult managerResult = (ManagerResult) obj;
        if (managerResult instanceof ManagerResult.Error) {
            mutableStateFlow4 = this.this$0._viewState;
            do {
                value2 = mutableStateFlow4.getValue();
            } while (!mutableStateFlow4.compareAndSet(value2, BornholmCommuterAddViewModel.ViewState.copy$default((BornholmCommuterAddViewModel.ViewState) value2, UIUploadState.Idle, true, null, null, 12, null)));
        } else {
            if (!(managerResult instanceof ManagerResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            this.$proceed.invoke();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BornholmCommuterAddViewModel$addCommuterCard$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
