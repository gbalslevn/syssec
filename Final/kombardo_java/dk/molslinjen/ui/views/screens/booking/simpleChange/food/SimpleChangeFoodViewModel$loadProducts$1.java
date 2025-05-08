package dk.molslinjen.ui.views.screens.booking.simpleChange.food;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.IAddonHelper;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.ui.views.screens.booking.simpleChange.food.SimpleChangeFoodViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.simpleChange.food.SimpleChangeFoodViewModel$loadProducts$1", f = "SimpleChangeFoodViewModel.kt", l = {49, 59}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SimpleChangeFoodViewModel$loadProducts$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Booking $booking;
    final /* synthetic */ List<Product> $preselectedFood;
    int label;
    final /* synthetic */ SimpleChangeFoodViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SimpleChangeFoodViewModel$loadProducts$1(SimpleChangeFoodViewModel simpleChangeFoodViewModel, Booking booking, List<? extends Product> list, Continuation<? super SimpleChangeFoodViewModel$loadProducts$1> continuation) {
        super(2, continuation);
        this.this$0 = simpleChangeFoodViewModel;
        this.$booking = booking;
        this.$preselectedFood = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SimpleChangeFoodViewModel$loadProducts$1(this.this$0, this.$booking, this.$preselectedFood, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x00b8 A[LOOP:0: B:7:0x00b2->B:9:0x00b8, LOOP_END] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        IAddonHelper iAddonHelper;
        Object loadProducts;
        ISnackbarService iSnackbarService;
        MutableStateFlow mutableStateFlow;
        Booking booking;
        List<Product> list;
        Object value;
        IAddonHelper iAddonHelper2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iAddonHelper = this.this$0.addonHelper;
            String carId = this.$booking.getTicket().getCarId();
            String departureId = this.$booking.getTicket().getDeparture().getDepartureId();
            DepartureDirection departureDirection = DepartureDirection.Outbound;
            int totalPassengerCount = this.$booking.getTicket().getPassengerInfo().getTotalPassengerCount();
            Site site = this.$booking.getSite();
            String reservationNumber = this.$booking.getReservationNumber();
            String nationalNumber = this.$booking.getCustomerInfo().getPhoneNumber().getNationalNumber();
            CurrencyType currencyType = this.$booking.getOrderTotal().getPrice().getCurrencyType();
            TicketCategoryType type = this.$booking.getTicket().toTicketCategory().getType();
            this.label = 1;
            loadProducts = iAddonHelper.loadProducts(carId, departureId, departureDirection, totalPassengerCount, site, reservationNumber, nationalNumber, currencyType, type, this);
            if (loadProducts == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                for (Product product : this.$preselectedFood) {
                    iAddonHelper2 = this.this$0.addonHelper;
                    iAddonHelper2.updateFoodQuantity(product, product.getQuantity());
                }
                mutableStateFlow = this.this$0._viewState;
                booking = this.$booking;
                list = this.$preselectedFood;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ((SimpleChangeFoodViewModel.ViewState) value).copy(false, booking.getTicket().getPassengerInfo().getTotalPassengerCount(), CollectionsKt.any(list))));
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
        while (r0.hasNext()) {
        }
        mutableStateFlow = this.this$0._viewState;
        booking = this.$booking;
        list = this.$preselectedFood;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ((SimpleChangeFoodViewModel.ViewState) value).copy(false, booking.getTicket().getPassengerInfo().getTotalPassengerCount(), CollectionsKt.any(list))));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SimpleChangeFoodViewModel$loadProducts$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
