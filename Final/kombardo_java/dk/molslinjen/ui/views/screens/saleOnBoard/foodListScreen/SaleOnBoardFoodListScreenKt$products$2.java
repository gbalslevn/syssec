package dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardCategory;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProduct;
import dk.molslinjen.ui.views.reusable.IndexHolder;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class SaleOnBoardFoodListScreenKt$products$2 implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ List<SaleOnBoardLineItem> $basketLineItems;
    final /* synthetic */ SaleOnBoardCategory $category;
    final /* synthetic */ int $firstVisibleItemIndex;
    final /* synthetic */ IndexHolder $indexCounter;
    final /* synthetic */ SaleOnBoardProduct $product;
    final /* synthetic */ Function2<SaleOnBoardProduct, Integer, Unit> $seenProduct;
    final /* synthetic */ Function1<SaleOnBoardCategory, Unit> $selectCategory;
    final /* synthetic */ Function2<SaleOnBoardProduct, Integer, Unit> $showProductDetails;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SaleOnBoardFoodListScreenKt$products$2(int i5, Function1<? super SaleOnBoardCategory, Unit> function1, SaleOnBoardCategory saleOnBoardCategory, SaleOnBoardProduct saleOnBoardProduct, Function2<? super SaleOnBoardProduct, ? super Integer, Unit> function2, IndexHolder indexHolder, List<SaleOnBoardLineItem> list, Function2<? super SaleOnBoardProduct, ? super Integer, Unit> function22) {
        this.$firstVisibleItemIndex = i5;
        this.$selectCategory = function1;
        this.$category = saleOnBoardCategory;
        this.$product = saleOnBoardProduct;
        this.$showProductDetails = function2;
        this.$indexCounter = indexHolder;
        this.$basketLineItems = list;
        this.$seenProduct = function22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function2 function2, SaleOnBoardProduct saleOnBoardProduct, IndexHolder indexHolder) {
        function2.invoke(saleOnBoardProduct, Integer.valueOf(indexHolder.getValue()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3(Function2 function2, SaleOnBoardProduct saleOnBoardProduct, IndexHolder indexHolder) {
        function2.invoke(saleOnBoardProduct, Integer.valueOf(indexHolder.getValue()));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope itemIndexed, int i5, Composer composer, int i6) {
        boolean z5;
        Intrinsics.checkNotNullParameter(itemIndexed, "$this$itemIndexed");
        if ((i6 & 48) == 0) {
            i6 |= composer.changed(i5) ? 32 : 16;
        }
        if ((i6 & 145) == 144 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(947687299, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.products.<anonymous> (SaleOnBoardFoodListScreen.kt:433)");
        }
        if (this.$firstVisibleItemIndex == i5 - 1) {
            this.$selectCategory.invoke(this.$category);
        }
        SaleOnBoardProduct saleOnBoardProduct = this.$product;
        composer.startReplaceGroup(-1384327403);
        boolean changed = composer.changed(this.$showProductDetails) | composer.changedInstance(this.$product) | composer.changedInstance(this.$indexCounter);
        final Function2<SaleOnBoardProduct, Integer, Unit> function2 = this.$showProductDetails;
        final SaleOnBoardProduct saleOnBoardProduct2 = this.$product;
        final IndexHolder indexHolder = this.$indexCounter;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = SaleOnBoardFoodListScreenKt$products$2.invoke$lambda$1$lambda$0(Function2.this, saleOnBoardProduct2, indexHolder);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function0 function0 = (Function0) rememberedValue;
        composer.endReplaceGroup();
        List<SaleOnBoardLineItem> list = this.$basketLineItems;
        SaleOnBoardProduct saleOnBoardProduct3 = this.$product;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((SaleOnBoardLineItem) it.next()).getProduct().getId(), saleOnBoardProduct3.getId())) {
                    z5 = true;
                    break;
                }
            }
        }
        z5 = false;
        composer.startReplaceGroup(-1384320466);
        boolean changed2 = composer.changed(this.$seenProduct) | composer.changedInstance(this.$product) | composer.changedInstance(this.$indexCounter);
        final Function2<SaleOnBoardProduct, Integer, Unit> function22 = this.$seenProduct;
        final SaleOnBoardProduct saleOnBoardProduct4 = this.$product;
        final IndexHolder indexHolder2 = this.$indexCounter;
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$4$lambda$3;
                    invoke$lambda$4$lambda$3 = SaleOnBoardFoodListScreenKt$products$2.invoke$lambda$4$lambda$3(Function2.this, saleOnBoardProduct4, indexHolder2);
                    return invoke$lambda$4$lambda$3;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        SaleOnBoardProductRowViewKt.SaleOnBoardProductRowView(saleOnBoardProduct, function0, z5, (Function0) rememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
