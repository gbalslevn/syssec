package dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardCategory;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardFoodListScreenKt$categories$1$1$1$1 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ IndexedValue<SaleOnBoardCategory> $category;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ LazyListState $scrollState;
    final /* synthetic */ Function1<SaleOnBoardCategory, Unit> $selectCategory;
    final /* synthetic */ SaleOnBoardCategory $selectedCategory;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SaleOnBoardFoodListScreenKt$categories$1$1$1$1(IndexedValue<SaleOnBoardCategory> indexedValue, SaleOnBoardCategory saleOnBoardCategory, CoroutineScope coroutineScope, LazyListState lazyListState, Function1<? super SaleOnBoardCategory, Unit> function1) {
        this.$category = indexedValue;
        this.$selectedCategory = saleOnBoardCategory;
        this.$scope = coroutineScope;
        this.$scrollState = lazyListState;
        this.$selectCategory = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(CoroutineScope coroutineScope, Function1 function1, IndexedValue indexedValue, LazyListState lazyListState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SaleOnBoardFoodListScreenKt$categories$1$1$1$1$1$1$1(lazyListState, indexedValue, null), 3, null);
        function1.invoke(indexedValue.getValue());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope item, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2086967591, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.categories.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SaleOnBoardFoodListScreen.kt:376)");
        }
        boolean areEqual = Intrinsics.areEqual(this.$category.getValue(), this.$selectedCategory);
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
        AppColor appColor = AppColor.INSTANCE;
        Modifier m103backgroundbw27NRU = BackgroundKt.m103backgroundbw27NRU(fillMaxWidth$default, areEqual ? appColor.m3255getBrandBlue10d7_KjU() : appColor.m3281getWhite0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
        float m2599constructorimpl = Dp.m2599constructorimpl(1);
        AppColor appColor2 = AppColor.INSTANCE;
        Modifier clip = ClipKt.clip(BorderKt.m108borderxT4_qwU(m103backgroundbw27NRU, m2599constructorimpl, areEqual ? appColor2.m3255getBrandBlue10d7_KjU() : appColor2.m3268getGrey50d7_KjU(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
        composer.startReplaceGroup(499438417);
        boolean changedInstance = composer.changedInstance(this.$scope) | composer.changed(this.$scrollState) | composer.changedInstance(this.$category) | composer.changed(this.$selectCategory);
        final CoroutineScope coroutineScope = this.$scope;
        final Function1<SaleOnBoardCategory, Unit> function1 = this.$selectCategory;
        final IndexedValue<SaleOnBoardCategory> indexedValue = this.$category;
        final LazyListState lazyListState = this.$scrollState;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = SaleOnBoardFoodListScreenKt$categories$1$1$1$1.invoke$lambda$1$lambda$0(CoroutineScope.this, function1, indexedValue, lazyListState);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        TextKt.m940Text4IGK_g(this.$category.getValue().getName(), PaddingKt.m312paddingVpY3zN4(ClickableKt.m122clickableXHw0xAI$default(clip, false, null, null, (Function0) rememberedValue, 7, null), Dp.m2599constructorimpl(16), Dp.m2599constructorimpl(8)), areEqual ? AppColor.INSTANCE.m3281getWhite0d7_KjU() : AppColor.INSTANCE.m3253getBrandBlack10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer, 0, 1572864, 65528);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
