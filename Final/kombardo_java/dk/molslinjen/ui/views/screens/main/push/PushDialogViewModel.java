package dk.molslinjen.ui.views.screens.main.push;

import androidx.appcompat.R$styleable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.domain.managers.notification.INotificationManager;
import dk.molslinjen.domain.model.push.PushMessage;
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
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/ui/views/screens/main/push/PushDialogViewModel;", "Landroidx/lifecycle/ViewModel;", "notificationManager", "Ldk/molslinjen/domain/managers/notification/INotificationManager;", "<init>", "(Ldk/molslinjen/domain/managers/notification/INotificationManager;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/main/push/PushDialogViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "setAsShown", BuildConfig.FLAVOR, "pushMessage", "Ldk/molslinjen/domain/model/push/PushMessage;", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PushDialogViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final INotificationManager notificationManager;
    private final StateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.main.push.PushDialogViewModel$1", f = "PushDialogViewModel.kt", l = {R$styleable.Toolbar_titleMarginEnd}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.main.push.PushDialogViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "pushMessage", "Ldk/molslinjen/domain/model/push/PushMessage;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.main.push.PushDialogViewModel$1$1", f = "PushDialogViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.main.push.PushDialogViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00591 extends SuspendLambda implements Function2<PushMessage, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ PushDialogViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00591(PushDialogViewModel pushDialogViewModel, Continuation<? super C00591> continuation) {
                super(2, continuation);
                this.this$0 = pushDialogViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00591 c00591 = new C00591(this.this$0, continuation);
                c00591.L$0 = obj;
                return c00591;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(PushMessage pushMessage, Continuation<? super Unit> continuation) {
                return ((C00591) create(pushMessage, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object value;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                PushMessage pushMessage = (PushMessage) this.L$0;
                MutableStateFlow mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ((ViewState) value).copy(pushMessage)));
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
                StateFlow<PushMessage> pushMessageReadyToShownInDialog = PushDialogViewModel.this.notificationManager.getPushMessageReadyToShownInDialog();
                C00591 c00591 = new C00591(PushDialogViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(pushMessageReadyToShownInDialog, c00591, this) == coroutine_suspended) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public PushDialogViewModel(INotificationManager notificationManager) {
        Intrinsics.checkNotNullParameter(notificationManager, "notificationManager");
        this.notificationManager = notificationManager;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, 1, 0 == true ? 1 : 0));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void setAsShown(PushMessage pushMessage) {
        Intrinsics.checkNotNullParameter(pushMessage, "pushMessage");
        this.notificationManager.markPushMessageAsShownInDialog(pushMessage);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/ui/views/screens/main/push/PushDialogViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/push/PushMessage;", "pushMessageReadyToShownInDialog", "<init>", "(Ldk/molslinjen/domain/model/push/PushMessage;)V", "copy", "(Ldk/molslinjen/domain/model/push/PushMessage;)Ldk/molslinjen/ui/views/screens/main/push/PushDialogViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/push/PushMessage;", "getPushMessageReadyToShownInDialog", "()Ldk/molslinjen/domain/model/push/PushMessage;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final PushMessage pushMessageReadyToShownInDialog;

        public ViewState(PushMessage pushMessage) {
            this.pushMessageReadyToShownInDialog = pushMessage;
        }

        public final ViewState copy(PushMessage pushMessageReadyToShownInDialog) {
            return new ViewState(pushMessageReadyToShownInDialog);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ViewState) && Intrinsics.areEqual(this.pushMessageReadyToShownInDialog, ((ViewState) other).pushMessageReadyToShownInDialog);
        }

        public final PushMessage getPushMessageReadyToShownInDialog() {
            return this.pushMessageReadyToShownInDialog;
        }

        public int hashCode() {
            PushMessage pushMessage = this.pushMessageReadyToShownInDialog;
            if (pushMessage == null) {
                return 0;
            }
            return pushMessage.hashCode();
        }

        public String toString() {
            return "ViewState(pushMessageReadyToShownInDialog=" + this.pushMessageReadyToShownInDialog + ")";
        }

        public /* synthetic */ ViewState(PushMessage pushMessage, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : pushMessage);
        }
    }
}
