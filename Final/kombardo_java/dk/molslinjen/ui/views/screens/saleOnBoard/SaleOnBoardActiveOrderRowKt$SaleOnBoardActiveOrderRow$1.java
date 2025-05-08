package dk.molslinjen.ui.views.screens.saleOnBoard;

import android.content.Context;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.extensions.ColorExtensionsKt;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.extensions.domain.SaleOnBoardOrderExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HighlightedTextKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.buttons.SecondaryButtonKt;
import dk.molslinjen.ui.views.reusable.modifiers.AnimatedClickableKt;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryBackgroundViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardActiveOrderRowKt$SaleOnBoardActiveOrderRow$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ SaleOnBoardOrder $order;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $scale;
    final /* synthetic */ Function1<SaleOnBoardOrder, Unit> $showOrderDetails;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SaleOnBoardActiveOrderRowKt$SaleOnBoardActiveOrderRow$1(CoroutineScope coroutineScope, Animatable<Float, AnimationVector1D> animatable, Function1<? super SaleOnBoardOrder, Unit> function1, SaleOnBoardOrder saleOnBoardOrder) {
        this.$coroutineScope = coroutineScope;
        this.$scale = animatable;
        this.$showOrderDetails = function1;
        this.$order = saleOnBoardOrder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function1 function1, SaleOnBoardOrder saleOnBoardOrder) {
        function1.invoke(saleOnBoardOrder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$16$lambda$15$lambda$14$lambda$13$lambda$10$lambda$9(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$16$lambda$15$lambda$14$lambda$13$lambda$12$lambda$11(Function1 function1, SaleOnBoardOrder saleOnBoardOrder) {
        function1.invoke(saleOnBoardOrder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$16$lambda$15$lambda$14$lambda$7$lambda$6$lambda$5(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState invoke$lambda$16$lambda$3$lambda$2() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        return mutableStateOf$default;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        int i6;
        Modifier.Companion companion;
        Object obj;
        int i7;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2034092196, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardActiveOrderRow.<anonymous> (SaleOnBoardActiveOrderRow.kt:68)");
        }
        Modifier.Companion companion2 = Modifier.INSTANCE;
        Modifier height = IntrinsicKt.height(companion2, IntrinsicSize.Max);
        CoroutineScope coroutineScope = this.$coroutineScope;
        Animatable<Float, AnimationVector1D> animatable = this.$scale;
        composer.startReplaceGroup(-1735200859);
        boolean changed = composer.changed(this.$showOrderDetails) | composer.changedInstance(this.$order);
        final Function1<SaleOnBoardOrder, Unit> function1 = this.$showOrderDetails;
        final SaleOnBoardOrder saleOnBoardOrder = this.$order;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = SaleOnBoardActiveOrderRowKt$SaleOnBoardActiveOrderRow$1.invoke$lambda$1$lambda$0(Function1.this, saleOnBoardOrder);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        Modifier clickableWithScaleAnimation = AnimatedClickableKt.clickableWithScaleAnimation(height, coroutineScope, animatable, 200, 0.9f, (Function0) rememberedValue);
        final SaleOnBoardOrder saleOnBoardOrder2 = this.$order;
        final Function1<SaleOnBoardOrder, Unit> function12 = this.$showOrderDetails;
        Alignment.Companion companion3 = Alignment.INSTANCE;
        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, clickableWithScaleAnimation);
        ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion4.getConstructor();
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
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        Object[] objArr = new Object[0];
        composer.startReplaceGroup(-1869973550);
        Object rememberedValue2 = composer.rememberedValue();
        Composer.Companion companion5 = Composer.INSTANCE;
        if (rememberedValue2 == companion5.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    MutableState invoke$lambda$16$lambda$3$lambda$2;
                    invoke$lambda$16$lambda$3$lambda$2 = SaleOnBoardActiveOrderRowKt$SaleOnBoardActiveOrderRow$1.invoke$lambda$16$lambda$3$lambda$2();
                    return invoke$lambda$16$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, null, null, (Function0) rememberedValue2, composer, 3072, 6);
        TicketSummaryBackgroundViewKt.m3562TicketBackgroundSingleCutOutViewFNF3uiM(ModifierExtensionsKt.defaultShadow$default(SizeKt.fillMaxHeight$default(companion2, 0.0f, 1, null), null, 1, null), ((Number) mutableState.getValue()).intValue(), 0L, composer, 0, 4);
        float f5 = 16;
        Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion2, Dp.m2599constructorimpl(f5), 0.0f, 2, null);
        Arrangement arrangement = Arrangement.INSTANCE;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), composer, 0);
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, m313paddingVpY3zN4$default);
        Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
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
        Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion4.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        SaleOnBoardActiveOrderRowKt.HeaderRow(mutableState, saleOnBoardOrder2, composer, 0);
        HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 7, null), 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(2)), composer, 3078, 6);
        boolean isActive = saleOnBoardOrder2.isActive();
        Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 7, null);
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), composer, 0);
        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, m315paddingqDBjuR0$default);
        Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
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
        Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy2, companion4.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
        if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
            m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
        }
        Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getCenterVertically(), composer, 48);
        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, companion2);
        Function0<ComposeUiNode> constructor4 = companion4.getConstructor();
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
        Updater.m1227setimpl(m1226constructorimpl4, rowMeasurePolicy, companion4.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion4.getSetCompositeKeyHash();
        if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
            m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
            m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
        }
        Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion4.getSetModifier());
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        long statusColor = SaleOnBoardOrderExtensionsKt.getStatusColor(saleOnBoardOrder2);
        HighlightedTextKt.m3387HighlightedTextRuGn9fw(null, false, statusColor, Color.m1481boximpl(ColorExtensionsKt.m3249withAlphaDxMtmZc(statusColor, 0.4f)), null, ComposableLambdaKt.rememberComposableLambda(782080126, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardActiveOrderRowKt$SaleOnBoardActiveOrderRow$1$2$1$1$1$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i8) {
                if ((i8 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(782080126, i8, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardActiveOrderRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SaleOnBoardActiveOrderRow.kt:103)");
                }
                TextKt.m940Text4IGK_g(SaleOnBoardOrderExtensionsKt.getStatusMediumTitle(SaleOnBoardOrder.this, (Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext())), null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2533getStarte0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 0, 1572864, 65022);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, 196608, 19);
        SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), composer, 0);
        composer.startReplaceGroup(1005151548);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion5.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            composer.updateRememberedValue(rememberedValue3);
        }
        final MutableState mutableState2 = (MutableState) rememberedValue3;
        composer.endReplaceGroup();
        composer.startReplaceGroup(1005153990);
        if (((Boolean) mutableState2.getValue()).booleanValue()) {
            i6 = 48;
            companion = companion2;
        } else {
            Modifier m325height3ABfNKs = SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(33));
            String shopImageUrl = saleOnBoardOrder2.getShopImageUrl();
            composer.startReplaceGroup(1005163561);
            Object rememberedValue4 = composer.rememberedValue();
            if (rememberedValue4 == companion5.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit invoke$lambda$16$lambda$15$lambda$14$lambda$7$lambda$6$lambda$5;
                        invoke$lambda$16$lambda$15$lambda$14$lambda$7$lambda$6$lambda$5 = SaleOnBoardActiveOrderRowKt$SaleOnBoardActiveOrderRow$1.invoke$lambda$16$lambda$15$lambda$14$lambda$7$lambda$6$lambda$5(MutableState.this, (AsyncImagePainter.State.Error) obj2);
                        return invoke$lambda$16$lambda$15$lambda$14$lambda$7$lambda$6$lambda$5;
                    }
                };
                composer.updateRememberedValue(rememberedValue4);
            }
            composer.endReplaceGroup();
            i6 = 48;
            companion = companion2;
            ImageKt.Image(SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(shopImageUrl, null, null, null, null, null, (Function1) rememberedValue4, null, 0, composer, 1572864, 446), Accessibility.INSTANCE.getSkip(), m325height3ABfNKs, null, null, 0.0f, null, composer, 384, 120);
        }
        composer.endReplaceGroup();
        composer.endNode();
        int i8 = 6;
        if (!isActive) {
            composer.startReplaceGroup(1520664291);
            SaleOnBoardActiveOrderRowKt.TitlesView(StringExtensionsKt.uppercaseFirstLetter(saleOnBoardOrder2.getShopLocation()), null, composer, i6);
            composer.endReplaceGroup();
        } else if (saleOnBoardOrder2.getStatus() == SaleOnBoardOrder.OrderStatus.Done) {
            composer.startReplaceGroup(1520970819);
            SaleOnBoardActiveOrderRowKt.TitlesView(StringExtensionsKt.uppercaseFirstLetter(saleOnBoardOrder2.getShopLocation()), StringResources_androidKt.stringResource(R.string.saleOnBoard_goDirectlyToPickupLocation, composer, 6), composer, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1521298675);
            SaleOnBoardActiveOrderRowKt.TitlesView(StringResources_androidKt.stringResource(R.string.saleOnBoard_order_pickup, new Object[]{SaleOnBoardOrderExtensionsKt.timeFormatted(saleOnBoardOrder2)}, composer, 6), StringResources_androidKt.stringResource(R.string.saleOnBoard_pickupAt, new Object[]{saleOnBoardOrder2.getShopLocation()}, composer, 6), composer, 0);
            composer.endReplaceGroup();
        }
        Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getCenterVertically(), composer, i6);
        int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer, m315paddingqDBjuR0$default2);
        Function0<ComposeUiNode> constructor5 = companion4.getConstructor();
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
        Updater.m1227setimpl(m1226constructorimpl5, rowMeasurePolicy2, companion4.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl5, currentCompositionLocalMap5, companion4.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = companion4.getSetCompositeKeyHash();
        if (m1226constructorimpl5.getInserting() || !Intrinsics.areEqual(m1226constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
            m1226constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
            m1226constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
        }
        Updater.m1227setimpl(m1226constructorimpl5, materializeModifier5, companion4.getSetModifier());
        int size = saleOnBoardOrder2.getLineItems().size() > 3 ? 2 : saleOnBoardOrder2.getLineItems().size();
        composer.startReplaceGroup(1005220711);
        for (SaleOnBoardLineItem saleOnBoardLineItem : CollectionsKt.take(saleOnBoardOrder2.getLineItems(), size)) {
            composer.startReplaceGroup(1005222908);
            Object rememberedValue5 = composer.rememberedValue();
            Composer.Companion companion6 = Composer.INSTANCE;
            if (rememberedValue5 == companion6.getEmpty()) {
                obj = null;
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(rememberedValue5);
            } else {
                obj = null;
            }
            final MutableState mutableState3 = (MutableState) rememberedValue5;
            composer.endReplaceGroup();
            composer.startReplaceGroup(1005225639);
            if (((Boolean) mutableState3.getValue()).booleanValue()) {
                i7 = i8;
            } else {
                Modifier clip = ClipKt.clip(SizeKt.m331size3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(40)), ThemeShapesKt.getThemeShapes().getSmall());
                String squareImageUrl = saleOnBoardLineItem.getProduct().getSquareImageUrl();
                composer.startReplaceGroup(1005239441);
                Object rememberedValue6 = composer.rememberedValue();
                if (rememberedValue6 == companion6.getEmpty()) {
                    rememberedValue6 = new Function1() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit invoke$lambda$16$lambda$15$lambda$14$lambda$13$lambda$10$lambda$9;
                            invoke$lambda$16$lambda$15$lambda$14$lambda$13$lambda$10$lambda$9 = SaleOnBoardActiveOrderRowKt$SaleOnBoardActiveOrderRow$1.invoke$lambda$16$lambda$15$lambda$14$lambda$13$lambda$10$lambda$9(MutableState.this, (AsyncImagePainter.State.Error) obj2);
                            return invoke$lambda$16$lambda$15$lambda$14$lambda$13$lambda$10$lambda$9;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue6);
                }
                composer.endReplaceGroup();
                i7 = i8;
                ImageKt.Image(SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(squareImageUrl, null, null, null, null, null, (Function1) rememberedValue6, null, 0, composer, 1572864, 446), Accessibility.INSTANCE.getSkip(), clip, null, null, 0.0f, null, composer, 0, 120);
            }
            composer.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(8)), composer, i7);
            i8 = i7;
        }
        composer.endReplaceGroup();
        composer.startReplaceGroup(1005252919);
        if (saleOnBoardOrder2.getLineItems().size() > 3) {
            TextKt.m940Text4IGK_g("+" + (saleOnBoardOrder2.getLineItems().size() - 2), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), composer, 0, 1572864, 65534);
        }
        composer.endReplaceGroup();
        SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0);
        String stringResource = StringResources_androidKt.stringResource(isActive ? R.string.saleOnBoard_order_followOrder : R.string.saleOnBoard_order_showOrder, composer, 0);
        composer.startReplaceGroup(1005272433);
        boolean changed2 = composer.changed(function12) | composer.changedInstance(saleOnBoardOrder2);
        Object rememberedValue7 = composer.rememberedValue();
        if (changed2 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
            rememberedValue7 = new Function0() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$16$lambda$15$lambda$14$lambda$13$lambda$12$lambda$11;
                    invoke$lambda$16$lambda$15$lambda$14$lambda$13$lambda$12$lambda$11 = SaleOnBoardActiveOrderRowKt$SaleOnBoardActiveOrderRow$1.invoke$lambda$16$lambda$15$lambda$14$lambda$13$lambda$12$lambda$11(Function1.this, saleOnBoardOrder2);
                    return invoke$lambda$16$lambda$15$lambda$14$lambda$13$lambda$12$lambda$11;
                }
            };
            composer.updateRememberedValue(rememberedValue7);
        }
        composer.endReplaceGroup();
        SecondaryButtonKt.m3406SecondaryButtonbZJ32A(null, stringResource, (Function0) rememberedValue7, null, false, null, false, null, null, 0L, false, composer, 0, 0, 2041);
        composer.endNode();
        composer.endNode();
        composer.endNode();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
