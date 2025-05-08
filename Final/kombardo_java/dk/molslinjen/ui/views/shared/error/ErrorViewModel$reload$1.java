package dk.molslinjen.ui.views.shared.error;

import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.model.config.Configuration;
import dk.molslinjen.ui.views.shared.error.ErrorViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.shared.error.ErrorViewModel$reload$1", f = "ErrorViewModel.kt", l = {34, 34}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ErrorViewModel$reload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ErrorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/domain/model/config/Configuration;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.shared.error.ErrorViewModel$reload$1$2", f = "ErrorViewModel.kt", l = {35}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.shared.error.ErrorViewModel$reload$1$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Configuration, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ErrorViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ErrorViewModel errorViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = errorViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Configuration configuration, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(configuration, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IConfigurationManager iConfigurationManager;
            MutableStateFlow mutableStateFlow;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                iConfigurationManager = this.this$0.configurationManager;
                this.label = 1;
                obj = iConfigurationManager.getConfiguration(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (obj != null) {
                mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ErrorViewModel.ViewState.copy$default((ErrorViewModel.ViewState) value, false, false, 1, null)));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorViewModel$reload$1(ErrorViewModel errorViewModel, Continuation<? super ErrorViewModel$reload$1> continuation) {
        super(2, continuation);
        this.this$0 = errorViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ErrorViewModel$reload$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        IConfigurationManager iConfigurationManager;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ErrorViewModel.ViewState.copy$default((ErrorViewModel.ViewState) value, true, false, 2, null)));
            iConfigurationManager = this.this$0.configurationManager;
            this.label = 1;
            obj = iConfigurationManager.loadConfiguration(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                mutableStateFlow2 = this.this$0._viewState;
                do {
                    value2 = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value2, ErrorViewModel.ViewState.copy$default((ErrorViewModel.ViewState) value2, false, false, 2, null)));
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, null);
        this.label = 2;
        if (ManagerResultExtensionsKt.onSuccess((ManagerResult) obj, anonymousClass2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        mutableStateFlow2 = this.this$0._viewState;
        do {
            value2 = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value2, ErrorViewModel.ViewState.copy$default((ErrorViewModel.ViewState) value2, false, false, 2, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ErrorViewModel$reload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
