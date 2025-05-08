package dk.molslinjen.ui.views.screens.saleOnBoard;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$SaleOnBoardScreenKt {
    public static final ComposableSingletons$SaleOnBoardScreenKt INSTANCE = new ComposableSingletons$SaleOnBoardScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f219lambda1 = ComposableLambdaKt.composableLambdaInstance(1450713141, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.ComposableSingletons$SaleOnBoardScreenKt$lambda-1$1
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
                ComposerKt.traceEventStart(1450713141, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.ComposableSingletons$SaleOnBoardScreenKt.lambda-1.<anonymous> (SaleOnBoardScreen.kt:182)");
            }
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(32), 0.0f, Dp.m2599constructorimpl(24), 5, null), 0L, 0.0f, null, composer, 6, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f220lambda2 = ComposableLambdaKt.composableLambdaInstance(2136426704, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.ComposableSingletons$SaleOnBoardScreenKt$lambda-2$1
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
                ComposerKt.traceEventStart(855582005, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.ComposableSingletons$SaleOnBoardScreenKt.lambda-2.<anonymous> (SaleOnBoardScreen.kt:188)");
            }
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(16)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f221lambda3 = ComposableLambdaKt.composableLambdaInstance(-1307272377, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.ComposableSingletons$SaleOnBoardScreenKt$lambda-3$1
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
                ComposerKt.traceEventStart(-1307272377, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.ComposableSingletons$SaleOnBoardScreenKt.lambda-3.<anonymous> (SaleOnBoardScreen.kt:195)");
            }
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(32)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-4, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f222lambda4 = ComposableLambdaKt.composableLambdaInstance(104869562, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.ComposableSingletons$SaleOnBoardScreenKt$lambda-4$1
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
                ComposerKt.traceEventStart(104869562, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.ComposableSingletons$SaleOnBoardScreenKt.lambda-4.<anonymous> (SaleOnBoardScreen.kt:314)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(56), 0.0f, Dp.m2599constructorimpl(42), 5, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Horizontal centerHorizontally = companion2.getCenterHorizontally();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally, composer, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m315paddingqDBjuR0$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            if (composer.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(composer);
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            String stringResource = StringResources_androidKt.stringResource(R.string.saleOnBoard_jumpTheQueue, composer, 6);
            TextStyle h1Bold = TypographyKt.getH1Bold();
            AppColor appColor = AppColor.INSTANCE;
            TextKt.m940Text4IGK_g(stringResource, null, appColor.m3281getWhite0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, h1Bold, composer, 384, 1572864, 65530);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.saleOnBoard_jumpTheQueue_subTitle, composer, 6), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 13, null), appColor.m3281getWhite0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer, 432, 1572864, 65528);
            Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0.0f, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 13, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getCenter(), companion2.getTop(), composer, 6);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, m315paddingqDBjuR0$default2);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (composer.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer);
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_sale_on_board_barista, composer, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(80)), null, null, 0.0f, null, composer, 384, 120);
            composer.endNode();
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3520getLambda1$app_kombardoProd() {
        return f219lambda1;
    }

    /* renamed from: getLambda-2$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3521getLambda2$app_kombardoProd() {
        return f220lambda2;
    }

    /* renamed from: getLambda-3$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3522getLambda3$app_kombardoProd() {
        return f221lambda3;
    }

    /* renamed from: getLambda-4$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3523getLambda4$app_kombardoProd() {
        return f222lambda4;
    }
}
