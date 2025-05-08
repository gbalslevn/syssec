package dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen;

import android.content.Context;
import android.view.animation.AnticipateOvershootInterpolator;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FloatTweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProduct;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.extensions.domain.PriceFormatExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.modifiers.AnimatedClickableKt;
import dk.molslinjen.ui.views.shared.components.PriceTextKt;
import dk.molslinjen.ui.views.shared.components.PriceViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class SaleOnBoardProductRowViewKt$SaleOnBoardProductRowView$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ boolean $isInBasket;
    final /* synthetic */ SaleOnBoardProduct $product;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $scale;
    final /* synthetic */ Function0<Unit> $showProductDetails;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardProductRowViewKt$SaleOnBoardProductRowView$1(CoroutineScope coroutineScope, Animatable<Float, AnimationVector1D> animatable, Function0<Unit> function0, SaleOnBoardProduct saleOnBoardProduct, boolean z5) {
        this.$coroutineScope = coroutineScope;
        this.$scale = animatable;
        this.$showProductDetails = function0;
        this.$product = saleOnBoardProduct;
        this.$isInBasket = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$12$lambda$11$lambda$10$lambda$6$lambda$5(SaleOnBoardProduct saleOnBoardProduct, Context context, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, PriceFormatExtensionsKt.formatted(saleOnBoardProduct.getPrice(), context));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8(float f5) {
        return new AnticipateOvershootInterpolator().getInterpolation(f5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$12$lambda$3$lambda$2$lambda$1(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        RowScopeInstance rowScopeInstance;
        float f5;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1605530088, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardProductRowView.<anonymous> (SaleOnBoardProductRowView.kt:68)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        float f6 = 16;
        Modifier defaultShadow$default = ModifierExtensionsKt.defaultShadow$default(AnimatedClickableKt.clickableWithScaleAnimation(PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m2599constructorimpl(f6), 0.0f, 2, null), 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 13, null), this.$coroutineScope, this.$scale, 200, 0.9f, this.$showProductDetails), null, 1, null);
        AppColor appColor = AppColor.INSTANCE;
        Modifier height = IntrinsicKt.height(BackgroundKt.m104backgroundbw27NRU$default(defaultShadow$default, appColor.m3281getWhite0d7_KjU(), null, 2, null), IntrinsicSize.Max);
        final SaleOnBoardProduct saleOnBoardProduct = this.$product;
        boolean z5 = this.$isInBasket;
        Arrangement arrangement = Arrangement.INSTANCE;
        Arrangement.Horizontal start = arrangement.getStart();
        Alignment.Companion companion2 = Alignment.INSTANCE;
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion2.getTop(), composer, 0);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, height);
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
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
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
        composer.startReplaceGroup(-1213597219);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion4 = Composer.INSTANCE;
        if (rememberedValue == companion4.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        composer.endReplaceGroup();
        float f7 = 8;
        Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(ClipKt.clip(SizeKt.m333sizeVpY3zN4(PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f7), Dp.m2599constructorimpl(f7), 0.0f, Dp.m2599constructorimpl(f7), 4, null), Dp.m2599constructorimpl(86), Dp.m2599constructorimpl(121)), MaterialTheme.INSTANCE.getShapes(composer, MaterialTheme.$stable).getSmall()), appColor.m3268getGrey50d7_KjU(), null, 2, null);
        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, m104backgroundbw27NRU$default);
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
        Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        if (!((Boolean) mutableState.getValue()).booleanValue()) {
            composer.startReplaceGroup(224275826);
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null);
            String squareImageUrl = saleOnBoardProduct.getSquareImageUrl();
            composer.startReplaceGroup(7242233);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == companion4.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$12$lambda$3$lambda$2$lambda$1;
                        invoke$lambda$12$lambda$3$lambda$2$lambda$1 = SaleOnBoardProductRowViewKt$SaleOnBoardProductRowView$1.invoke$lambda$12$lambda$3$lambda$2$lambda$1(MutableState.this, (AsyncImagePainter.State.Error) obj);
                        return invoke$lambda$12$lambda$3$lambda$2$lambda$1;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            rowScopeInstance = rowScopeInstance2;
            f5 = f6;
            ImageKt.Image(SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(squareImageUrl, null, null, null, null, null, (Function1) rememberedValue2, null, 0, composer, 1572864, 446), Accessibility.INSTANCE.getSkip(), fillMaxHeight$default, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, composer, 24960, 104);
            composer.endReplaceGroup();
        } else {
            rowScopeInstance = rowScopeInstance2;
            f5 = f6;
            composer.startReplaceGroup(224803694);
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_food_image_missing, composer, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(24)), null, null, 0.0f, null, composer, 384, 120);
            composer.endReplaceGroup();
        }
        composer.endNode();
        Modifier fillMaxHeight$default2 = SizeKt.fillMaxHeight$default(PaddingKt.m311padding3ABfNKs(companion, Dp.m2599constructorimpl(f5)), 0.0f, 1, null);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer, 0);
        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, fillMaxHeight$default2);
        Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor3);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
            m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
        }
        Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        TextKt.m940Text4IGK_g(saleOnBoardProduct.getName(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer, 0, 1572864, 65534);
        String description = saleOnBoardProduct.getDescription();
        String takeFirstSentence = description != null ? StringExtensionsKt.takeFirstSentence(description) : null;
        composer.startReplaceGroup(7271632);
        if (takeFirstSentence != null) {
            TextKt.m940Text4IGK_g(takeFirstSentence, null, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer, 384, 1572864, 65530);
            Unit unit = Unit.INSTANCE;
        }
        composer.endReplaceGroup();
        SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
        Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f7), 0.0f, 0.0f, 13, null);
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer, 0);
        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, m315paddingqDBjuR0$default);
        Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor4);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl4 = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl4, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
            m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
            m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
        }
        Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion3.getSetModifier());
        final Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        composer.startReplaceGroup(-1435363374);
        boolean changedInstance = composer.changedInstance(saleOnBoardProduct) | composer.changedInstance(context);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance || rememberedValue3 == companion4.getEmpty()) {
            rememberedValue3 = new Function1() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$12$lambda$11$lambda$10$lambda$6$lambda$5;
                    invoke$lambda$12$lambda$11$lambda$10$lambda$6$lambda$5 = SaleOnBoardProductRowViewKt$SaleOnBoardProductRowView$1.invoke$lambda$12$lambda$11$lambda$10$lambda$6$lambda$5(SaleOnBoardProduct.this, context, (SemanticsPropertyReceiver) obj);
                    return invoke$lambda$12$lambda$11$lambda$10$lambda$6$lambda$5;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) rememberedValue3);
        MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer, 0);
        int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer, clearAndSetSemantics);
        Function0<ComposeUiNode> constructor5 = companion3.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor5);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl5 = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl5, rowMeasurePolicy3, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl5, currentCompositionLocalMap5, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl5.getInserting() || !Intrinsics.areEqual(m1226constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
            m1226constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
            m1226constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
        }
        Updater.m1227setimpl(m1226constructorimpl5, materializeModifier5, companion3.getSetModifier());
        RowScopeInstance rowScopeInstance3 = rowScopeInstance;
        PriceTextKt.m3557PriceText1y9Plug((Price) saleOnBoardProduct.getPrice(), rowScopeInstance3.alignByBaseline(companion), PriceViewType.PriceOnly, false, TypographyKt.getParagraph(), (TextAlign) null, 0, 0L, composer, 24960, 232);
        PriceTextKt.m3557PriceText1y9Plug((Price) saleOnBoardProduct.getPrice(), PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance3.alignByBaseline(companion), Dp.m2599constructorimpl(2), 0.0f, 0.0f, 0.0f, 14, null), PriceViewType.CurrencyOnly, false, TypographyKt.getSubSmall(), (TextAlign) null, 0, 0L, composer, 24960, 232);
        composer.endNode();
        float f8 = z5 ? 1.0f : 0.0f;
        composer.startReplaceGroup(-1435332857);
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == companion4.getEmpty()) {
            rememberedValue4 = new Easing() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.j
                @Override // androidx.compose.animation.core.Easing
                public final float transform(float f9) {
                    float invoke$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8;
                    invoke$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8 = SaleOnBoardProductRowViewKt$SaleOnBoardProductRowView$1.invoke$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8(f9);
                    return invoke$lambda$12$lambda$11$lambda$10$lambda$9$lambda$8;
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceGroup();
        State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(f8, new FloatTweenSpec(500, 300, (Easing) rememberedValue4), 0.0f, null, null, composer, FloatTweenSpec.$stable << 3, 28);
        SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance3, companion, 1.0f, false, 2, null), composer, 0);
        ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_checkmark_tick_small, composer, 6), Accessibility.INSTANCE.getSkip(), ScaleKt.scale(SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(20)), animateFloatAsState.getValue().floatValue()), null, null, 0.0f, null, composer, 0, 120);
        composer.endNode();
        composer.endNode();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
