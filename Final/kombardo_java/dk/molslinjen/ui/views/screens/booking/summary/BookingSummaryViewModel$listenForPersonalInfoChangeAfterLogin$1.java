package dk.molslinjen.ui.views.screens.booking.summary;

import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.user.AuthenticationType;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.booking.CheckoutContactInfo;
import dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryViewModel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryViewModel$listenForPersonalInfoChangeAfterLogin$1", f = "BookingSummaryViewModel.kt", l = {93}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class BookingSummaryViewModel$listenForPersonalInfoChangeAfterLogin$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BookingSummaryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookingSummaryViewModel$listenForPersonalInfoChangeAfterLogin$1(BookingSummaryViewModel bookingSummaryViewModel, Continuation<? super BookingSummaryViewModel$listenForPersonalInfoChangeAfterLogin$1> continuation) {
        super(2, continuation);
        this.this$0 = bookingSummaryViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookingSummaryViewModel$listenForPersonalInfoChangeAfterLogin$1(this.this$0, continuation);
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [T, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        BookingSummaryViewModel.ViewState viewState;
        boolean z5;
        IUserManager iUserManager;
        IUserManager iUserManager2;
        CheckoutContactInfo personalInfo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._viewState;
            BookingSummaryViewModel bookingSummaryViewModel = this.this$0;
            do {
                value = mutableStateFlow.getValue();
                viewState = (BookingSummaryViewModel.ViewState) value;
                CheckoutManager.CheckoutState value2 = bookingSummaryViewModel.getCheckoutState().getValue();
                z5 = false;
                if (value2 != null && (personalInfo = value2.getPersonalInfo()) != null && personalInfo.getWasPrefilled()) {
                    z5 = true;
                }
            } while (!mutableStateFlow.compareAndSet(value, BookingSummaryViewModel.ViewState.copy$default(viewState, null, null, null, false, !z5, 15, null)));
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            iUserManager = this.this$0.userManager;
            ref$ObjectRef.element = iUserManager.getAuthenticationType().getValue();
            iUserManager2 = this.this$0.userManager;
            StateFlow<AuthenticationType> authenticationType = iUserManager2.getAuthenticationType();
            final BookingSummaryViewModel bookingSummaryViewModel2 = this.this$0;
            FlowCollector<? super AuthenticationType> flowCollector = new FlowCollector() { // from class: dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryViewModel$listenForPersonalInfoChangeAfterLogin$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((AuthenticationType) obj2, (Continuation<? super Unit>) continuation);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public final Object emit(AuthenticationType authenticationType2, Continuation<? super Unit> continuation) {
                    MutableStateFlow mutableStateFlow2;
                    Object value3;
                    if (Intrinsics.areEqual(authenticationType2, ref$ObjectRef.element)) {
                        return Unit.INSTANCE;
                    }
                    mutableStateFlow2 = bookingSummaryViewModel2._viewState;
                    do {
                        value3 = mutableStateFlow2.getValue();
                    } while (!mutableStateFlow2.compareAndSet(value3, BookingSummaryViewModel.ViewState.copy$default((BookingSummaryViewModel.ViewState) value3, null, null, null, false, Intrinsics.areEqual(authenticationType2, AuthenticationType.None.INSTANCE), 15, null)));
                    ref$ObjectRef.element = authenticationType2;
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (authenticationType.collect(flowCollector, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookingSummaryViewModel$listenForPersonalInfoChangeAfterLogin$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
