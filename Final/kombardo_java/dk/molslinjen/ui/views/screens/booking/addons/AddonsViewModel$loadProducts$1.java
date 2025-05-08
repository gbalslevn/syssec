package dk.molslinjen.ui.views.screens.booking.addons;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.IAddonHelper;
import dk.molslinjen.domain.managers.checkout.IEditManager;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.ui.views.screens.booking.addons.AddonsViewModel;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.AddonsViewModel$loadProducts$1", f = "AddonsViewModel.kt", l = {ModuleDescriptor.MODULE_VERSION, 146}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class AddonsViewModel$loadProducts$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CheckoutManager.CheckoutDirectionState $checkoutDirectionState;
    final /* synthetic */ CheckoutManager.CheckoutState $checkoutState;
    final /* synthetic */ DepartureDirection $departureDirection;
    int label;
    final /* synthetic */ AddonsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddonsViewModel$loadProducts$1(AddonsViewModel addonsViewModel, CheckoutManager.CheckoutDirectionState checkoutDirectionState, DepartureDirection departureDirection, CheckoutManager.CheckoutState checkoutState, Continuation<? super AddonsViewModel$loadProducts$1> continuation) {
        super(2, continuation);
        this.this$0 = addonsViewModel;
        this.$checkoutDirectionState = checkoutDirectionState;
        this.$departureDirection = departureDirection;
        this.$checkoutState = checkoutState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddonsViewModel$loadProducts$1(this.this$0, this.$checkoutDirectionState, this.$departureDirection, this.$checkoutState, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IEditManager iEditManager;
        IEditManager iEditManager2;
        Object loadProducts;
        ISnackbarService iSnackbarService;
        MutableStateFlow mutableStateFlow;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            IAddonHelper iAddonHelper = this.this$0.addonHelper;
            String carId = this.$checkoutDirectionState.getDepartureTicket().getCarId();
            String id = this.$checkoutDirectionState.getDeparture().getId();
            DepartureDirection departureDirection = this.$departureDirection;
            int passengerCount = this.$checkoutDirectionState.getPassengerCount();
            Site site = this.$checkoutState.getSite();
            iEditManager = this.this$0.editManager;
            String editingReservationNumber = iEditManager.getEditState().getValue().getEditingReservationNumber();
            iEditManager2 = this.this$0.editManager;
            String editingPhoneNumber = iEditManager2.getEditState().getValue().getEditingPhoneNumber();
            CurrencyType currency = this.$checkoutState.getCurrency();
            TicketCategoryType type = this.$checkoutDirectionState.getDepartureTicket().getCategory().getType();
            this.label = 1;
            loadProducts = iAddonHelper.loadProducts(carId, id, departureDirection, passengerCount, site, editingReservationNumber, editingPhoneNumber, currency, type, this);
            if (loadProducts == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, AddonsViewModel.ViewState.copy$default((AddonsViewModel.ViewState) value, false, null, 0, null, null, null, 62, null)));
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            loadProducts = obj;
        }
        iSnackbarService = this.this$0.snackbarService;
        this.label = 2;
        if (ManagerResultExtensionsKt.handlePotentialError((ManagerResult) loadProducts, iSnackbarService, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        mutableStateFlow = this.this$0._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, AddonsViewModel.ViewState.copy$default((AddonsViewModel.ViewState) value, false, null, 0, null, null, null, 62, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddonsViewModel$loadProducts$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
