package dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen;

import androidx.compose.foundation.lazy.LazyListState;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardCategory;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListScreenKt$categories$1$1$1$1$1$1$1", f = "SaleOnBoardFoodListScreen.kt", l = {393}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SaleOnBoardFoodListScreenKt$categories$1$1$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IndexedValue<SaleOnBoardCategory> $category;
    final /* synthetic */ LazyListState $scrollState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardFoodListScreenKt$categories$1$1$1$1$1$1$1(LazyListState lazyListState, IndexedValue<SaleOnBoardCategory> indexedValue, Continuation<? super SaleOnBoardFoodListScreenKt$categories$1$1$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$scrollState = lazyListState;
        this.$category = indexedValue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SaleOnBoardFoodListScreenKt$categories$1$1$1$1$1$1$1(this.$scrollState, this.$category, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            LazyListState lazyListState = this.$scrollState;
            int index = this.$category.getIndex();
            this.label = 1;
            if (lazyListState.animateScrollToItem(index, 0, this) == coroutine_suspended) {
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
        return ((SaleOnBoardFoodListScreenKt$categories$1$1$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
