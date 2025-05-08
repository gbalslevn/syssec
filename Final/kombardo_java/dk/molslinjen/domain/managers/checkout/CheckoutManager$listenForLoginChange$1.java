package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.account.user.UserInfo;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.CheckoutContactInfo;
import dk.molslinjen.domain.model.booking.CustomerInfo;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.checkout.CheckoutManager$listenForLoginChange$1", f = "CheckoutManager.kt", l = {310}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class CheckoutManager$listenForLoginChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CheckoutManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckoutManager$listenForLoginChange$1(CheckoutManager checkoutManager, Continuation<? super CheckoutManager$listenForLoginChange$1> continuation) {
        super(2, continuation);
        this.this$0 = checkoutManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CheckoutManager$listenForLoginChange$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IUserManager iUserManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iUserManager = this.this$0.userManager;
            StateFlow<IUserManager.UserState> currentUserState = iUserManager.getCurrentUserState();
            final CheckoutManager checkoutManager = this.this$0;
            FlowCollector<? super IUserManager.UserState> flowCollector = new FlowCollector() { // from class: dk.molslinjen.domain.managers.checkout.CheckoutManager$listenForLoginChange$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((IUserManager.UserState) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(IUserManager.UserState userState, Continuation<? super Unit> continuation) {
                    CheckoutManager.CheckoutState value;
                    CheckoutManager.CheckoutState checkoutState;
                    IEditManager iEditManager;
                    CheckoutContactInfo checkoutContactInfo;
                    CustomerInfo customerInfo;
                    UserInfo details = userState.getUser().getDetails();
                    MutableStateFlow<CheckoutManager.CheckoutState> checkoutState2 = CheckoutManager.this.getCheckoutState();
                    CheckoutManager checkoutManager2 = CheckoutManager.this;
                    do {
                        value = checkoutState2.getValue();
                        checkoutState = value;
                        iEditManager = checkoutManager2.editManager;
                        Booking booking = iEditManager.getEditState().getValue().getBooking();
                        if (booking == null || (customerInfo = booking.getCustomerInfo()) == null) {
                            checkoutContactInfo = new CheckoutContactInfo(details != null ? details.getContactDetails() : null);
                        } else {
                            checkoutContactInfo = new CheckoutContactInfo(customerInfo);
                        }
                    } while (!checkoutState2.compareAndSet(value, checkoutState != null ? CheckoutManager.CheckoutState.copy$default(checkoutState, null, null, null, null, false, false, null, null, null, null, null, null, false, null, false, checkoutContactInfo, null, null, null, false, null, 2064383, null) : null));
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (currentUserState.collect(flowCollector, this) == coroutine_suspended) {
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
        return ((CheckoutManager$listenForLoginChange$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
