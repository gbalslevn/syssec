package dk.molslinjen.ui.views.screens.booking.food;

import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.model.booking.product.Product;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.food.FoodViewModel$onQuantityChanged$1", f = "FoodViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class FoodViewModel$onQuantityChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Product $product;
    final /* synthetic */ int $quantity;
    int label;
    final /* synthetic */ FoodViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FoodViewModel$onQuantityChanged$1(int i5, Product product, FoodViewModel foodViewModel, Continuation<? super FoodViewModel$onQuantityChanged$1> continuation) {
        super(2, continuation);
        this.$quantity = i5;
        this.$product = product;
        this.this$0 = foodViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FoodViewModel$onQuantityChanged$1(this.$quantity, this.$product, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IAnalyticsTracker iAnalyticsTracker;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        int quantity = this.$quantity - this.$product.getQuantity();
        this.this$0.addonHelper.updateFoodQuantity(this.$product, this.$quantity);
        CheckoutManager.CheckoutState value = this.this$0.getCheckoutState().getValue();
        if (value == null) {
            return Unit.INSTANCE;
        }
        iAnalyticsTracker = this.this$0.analyticsTracker;
        Product product = this.$product;
        CheckoutManager.CheckoutDirectionState value2 = this.this$0.checkoutManager.directionState(this.this$0.getViewState().getValue().getDepartureDirection()).getValue();
        if (value2 == null) {
            return Unit.INSTANCE;
        }
        iAnalyticsTracker.trackAddAddon(product, value, value2, this.this$0.getViewState().getValue().getDepartureDirection(), quantity, true, value.getSite());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FoodViewModel$onQuantityChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
