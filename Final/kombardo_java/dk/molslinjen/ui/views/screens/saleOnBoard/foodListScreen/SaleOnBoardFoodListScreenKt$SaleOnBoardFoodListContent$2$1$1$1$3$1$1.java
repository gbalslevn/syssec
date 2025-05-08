package dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen;

import androidx.compose.foundation.lazy.LazyListState;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListScreenKt$SaleOnBoardFoodListContent$2$1$1$1$3$1$1", f = "SaleOnBoardFoodListScreen.kt", l = {193}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SaleOnBoardFoodListScreenKt$SaleOnBoardFoodListContent$2$1$1$1$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $categoriesBarHeight;
    final /* synthetic */ int $index;
    final /* synthetic */ LazyListState $listState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardFoodListScreenKt$SaleOnBoardFoodListContent$2$1$1$1$3$1$1(LazyListState lazyListState, int i5, int i6, Continuation<? super SaleOnBoardFoodListScreenKt$SaleOnBoardFoodListContent$2$1$1$1$3$1$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.$index = i5;
        this.$categoriesBarHeight = i6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SaleOnBoardFoodListScreenKt$SaleOnBoardFoodListContent$2$1$1$1$3$1$1(this.$listState, this.$index, this.$categoriesBarHeight, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            LazyListState lazyListState = this.$listState;
            int i6 = this.$index;
            int i7 = -this.$categoriesBarHeight;
            this.label = 1;
            if (lazyListState.animateScrollToItem(i6, i7, this) == coroutine_suspended) {
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
        return ((SaleOnBoardFoodListScreenKt$SaleOnBoardFoodListContent$2$1$1$1$3$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
