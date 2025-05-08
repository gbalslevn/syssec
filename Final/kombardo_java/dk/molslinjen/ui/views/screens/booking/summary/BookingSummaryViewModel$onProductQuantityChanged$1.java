package dk.molslinjen.ui.views.screens.booking.summary;

import dk.molslinjen.domain.model.booking.DepartureDirection;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.summary.BookingSummaryViewModel$onProductQuantityChanged$1", f = "BookingSummaryViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class BookingSummaryViewModel$onProductQuantityChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DepartureDirection $direction;
    final /* synthetic */ Product $product;
    final /* synthetic */ int $quantity;
    int label;
    final /* synthetic */ BookingSummaryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookingSummaryViewModel$onProductQuantityChanged$1(BookingSummaryViewModel bookingSummaryViewModel, Product product, int i5, DepartureDirection departureDirection, Continuation<? super BookingSummaryViewModel$onProductQuantityChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = bookingSummaryViewModel;
        this.$product = product;
        this.$quantity = i5;
        this.$direction = departureDirection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookingSummaryViewModel$onProductQuantityChanged$1(this.this$0, this.$product, this.$quantity, this.$direction, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.summaryAddonHelper.updateProductQuantity(this.$product, this.$quantity, this.$direction);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookingSummaryViewModel$onProductQuantityChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
