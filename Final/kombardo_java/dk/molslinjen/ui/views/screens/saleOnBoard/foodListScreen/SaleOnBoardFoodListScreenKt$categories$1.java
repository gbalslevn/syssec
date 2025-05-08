package dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardCategory;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class SaleOnBoardFoodListScreenKt$categories$1 implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ List<SaleOnBoardCategory> $categories;
    final /* synthetic */ Function1<SaleOnBoardCategory, Unit> $selectCategory;
    final /* synthetic */ SaleOnBoardCategory $selectedCategory;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SaleOnBoardFoodListScreenKt$categories$1(List<SaleOnBoardCategory> list, SaleOnBoardCategory saleOnBoardCategory, Function1<? super SaleOnBoardCategory, Unit> function1) {
        this.$categories = list;
        this.$selectedCategory = saleOnBoardCategory;
        this.$selectCategory = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(List list, SaleOnBoardCategory saleOnBoardCategory, CoroutineScope coroutineScope, LazyListState lazyListState, Function1 function1, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        Iterator it = CollectionsKt.withIndex(list).iterator();
        while (it.hasNext()) {
            LazyListScope.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(2086967591, true, new SaleOnBoardFoodListScreenKt$categories$1$1$1$1((IndexedValue) it.next(), saleOnBoardCategory, coroutineScope, lazyListState, function1)), 3, null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope stickyHeaderIndexed, int i5, Composer composer, int i6) {
        Intrinsics.checkNotNullParameter(stickyHeaderIndexed, "$this$stickyHeaderIndexed");
        if ((i6 & 129) == 128 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1390472547, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.categories.<anonymous> (SaleOnBoardFoodListScreen.kt:363)");
        }
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        final LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composer, 0, 3);
        Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(ModifierExtensionsKt.defaultShadow(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RectangleShapeKt.getRectangleShape()), AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null);
        float f5 = 8;
        PaddingValues m307PaddingValuesYgX7TsA = PaddingKt.m307PaddingValuesYgX7TsA(Dp.m2599constructorimpl(16), Dp.m2599constructorimpl(f5));
        Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(f5));
        composer.startReplaceGroup(-1884730337);
        boolean changedInstance = composer.changedInstance(this.$categories) | composer.changedInstance(this.$selectedCategory) | composer.changedInstance(coroutineScope) | composer.changed(rememberLazyListState) | composer.changed(this.$selectCategory);
        final List<SaleOnBoardCategory> list = this.$categories;
        final SaleOnBoardCategory saleOnBoardCategory = this.$selectedCategory;
        final Function1<SaleOnBoardCategory, Unit> function1 = this.$selectCategory;
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance || rememberedValue2 == companion.getEmpty()) {
            Object obj = new Function1() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = SaleOnBoardFoodListScreenKt$categories$1.invoke$lambda$1$lambda$0(list, saleOnBoardCategory, coroutineScope, rememberLazyListState, function1, (LazyListScope) obj2);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(obj);
            rememberedValue2 = obj;
        }
        composer.endReplaceGroup();
        LazyDslKt.LazyRow(m104backgroundbw27NRU$default, rememberLazyListState, m307PaddingValuesYgX7TsA, false, m265spacedBy0680j_4, null, null, false, (Function1) rememberedValue2, composer, 24576, 232);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
