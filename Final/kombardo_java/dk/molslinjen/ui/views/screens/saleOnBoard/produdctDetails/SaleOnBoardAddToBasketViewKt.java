package dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.adjust.sdk.Constants;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.ButtonConfig;
import dk.molslinjen.ui.views.reusable.buttons.ButtonWithPriceKt;
import dk.molslinjen.ui.views.reusable.input.NumberSelectorKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.SaleOnBoardAddToBasketViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0006X\u008a\u008e\u0002"}, d2 = {"SaleOnBoardAddToBasketView", BuildConfig.FLAVOR, "lineItem", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "onAddToBasket", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onRemoveFromBasket", "Lkotlin/Function0;", "showSoldOutMessage", "timeSlotsAvailable", BuildConfig.FLAVOR, "isEditing", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZZLandroidx/compose/runtime/Composer;I)V", "app_kombardoProd", "quantity"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SaleOnBoardAddToBasketViewKt {
    public static final void SaleOnBoardAddToBasketView(final SaleOnBoardLineItem lineItem, final Function1<? super Integer, Unit> onAddToBasket, final Function0<Unit> onRemoveFromBasket, final Function0<Unit> showSoldOutMessage, final boolean z5, final boolean z6, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(lineItem, "lineItem");
        Intrinsics.checkNotNullParameter(onAddToBasket, "onAddToBasket");
        Intrinsics.checkNotNullParameter(onRemoveFromBasket, "onRemoveFromBasket");
        Intrinsics.checkNotNullParameter(showSoldOutMessage, "showSoldOutMessage");
        Composer startRestartGroup = composer.startRestartGroup(-1252569886);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(lineItem) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(onAddToBasket) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(onRemoveFromBasket) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(showSoldOutMessage) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 131072 : 65536;
        }
        int i7 = i6;
        if ((74899 & i7) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1252569886, i7, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.SaleOnBoardAddToBasketView (SaleOnBoardAddToBasketView.kt:39)");
            }
            startRestartGroup.startReplaceGroup(-1043422661);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(1, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion4.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-1937131382);
            if (!z5) {
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.saleOnBoard_noAvailableTimes, startRestartGroup, 6), SizeKt.fillMaxWidth$default(PaddingKt.m311padding3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(companion2, AppColor.INSTANCE.m3277getTagPurple0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(8)), 0.0f, 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 48, 1572864, 65532);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier = ModifierExtensionsKt.topShadow(companion2);
            AppColor appColor = AppColor.INSTANCE;
            float f5 = 16;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(modifier, appColor.m3281getWhite0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(f5));
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
            Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
            Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int SaleOnBoardAddToBasketView$lambda$1 = SaleOnBoardAddToBasketView$lambda$1(mutableState);
            boolean z7 = z5 && !lineItem.getProduct().isSoldOut();
            startRestartGroup.startReplaceGroup(-704145397);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: j4.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SaleOnBoardAddToBasketView$lambda$13$lambda$12$lambda$9$lambda$4$lambda$3;
                        SaleOnBoardAddToBasketView$lambda$13$lambda$12$lambda$9$lambda$4$lambda$3 = SaleOnBoardAddToBasketViewKt.SaleOnBoardAddToBasketView$lambda$13$lambda$12$lambda$9$lambda$4$lambda$3(MutableState.this, ((Integer) obj).intValue());
                        return SaleOnBoardAddToBasketView$lambda$13$lambda$12$lambda$9$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function1 function1 = (Function1) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-704143573);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: j4.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SaleOnBoardAddToBasketView$lambda$13$lambda$12$lambda$9$lambda$6$lambda$5;
                        SaleOnBoardAddToBasketView$lambda$13$lambda$12$lambda$9$lambda$6$lambda$5 = SaleOnBoardAddToBasketViewKt.SaleOnBoardAddToBasketView$lambda$13$lambda$12$lambda$9$lambda$6$lambda$5(MutableState.this, ((Integer) obj).intValue());
                        return SaleOnBoardAddToBasketView$lambda$13$lambda$12$lambda$9$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            NumberSelectorKt.NumberSelector(null, SaleOnBoardAddToBasketView$lambda$1, 0, 1, 0, null, null, null, function1, (Function1) rememberedValue3, null, false, true, z7, false, startRestartGroup, 905972736, 384, 19701);
            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion2, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null);
            String stringResource = StringResources_androidKt.stringResource(z6 ? R.string.saleOnBoard_updateItem : R.string.saleOnBoard_addToBasket, startRestartGroup, 0);
            PriceWithCurrency copy$default = PriceWithCurrency.copy$default(lineItem.getUnitPrice(), lineItem.getUnitPrice().getValue() * SaleOnBoardAddToBasketView$lambda$1(mutableState), null, 2, null);
            boolean z8 = z5 && !lineItem.getProduct().isSoldOut();
            startRestartGroup.startReplaceGroup(-704124415);
            boolean z9 = (i7 & 112) == 32;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z9 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: j4.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SaleOnBoardAddToBasketView$lambda$13$lambda$12$lambda$9$lambda$8$lambda$7;
                        SaleOnBoardAddToBasketView$lambda$13$lambda$12$lambda$9$lambda$8$lambda$7 = SaleOnBoardAddToBasketViewKt.SaleOnBoardAddToBasketView$lambda$13$lambda$12$lambda$9$lambda$8$lambda$7(Function1.this, mutableState);
                        return SaleOnBoardAddToBasketView$lambda$13$lambda$12$lambda$9$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            ButtonWithPriceKt.ButtonWithPrice(weight$default, (Function0<Unit>) rememberedValue4, stringResource, copy$default, (String) null, z8, showSoldOutMessage, (ButtonConfig) null, false, startRestartGroup, (i7 << 9) & 3670016, Constants.MINIMAL_ERROR_STATUS_CODE);
            startRestartGroup.endNode();
            startRestartGroup.startReplaceGroup(-1809792734);
            if (z6) {
                composer2 = startRestartGroup;
                IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_delete, startRestartGroup, 6), StringResources_androidKt.stringResource(R.string.accessibilityLabel_remove, startRestartGroup, 6), columnScopeInstance.align(PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(8), 0.0f, 9, null), companion3.getCenterHorizontally()), 0L, startRestartGroup, 0, 8);
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
                composer2.startReplaceGroup(-1809776781);
                boolean z10 = (i7 & 896) == 256;
                Object rememberedValue5 = composer2.rememberedValue();
                if (z10 || rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new Function0() { // from class: j4.h
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SaleOnBoardAddToBasketView$lambda$13$lambda$12$lambda$11$lambda$10;
                            SaleOnBoardAddToBasketView$lambda$13$lambda$12$lambda$11$lambda$10 = SaleOnBoardAddToBasketViewKt.SaleOnBoardAddToBasketView$lambda$13$lambda$12$lambda$11$lambda$10(Function0.this);
                            return SaleOnBoardAddToBasketView$lambda$13$lambda$12$lambda$11$lambda$10;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue5);
                }
                composer2.endReplaceGroup();
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.saleOnBoard_removeFromBasket, composer2, 6), columnScopeInstance.align(ClickableKt.m122clickableXHw0xAI$default(m315paddingqDBjuR0$default, false, null, null, (Function0) rememberedValue5, 7, null), companion3.getCenterHorizontally()), appColor.m3272getSignalRed0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer2, 384, 1572864, 65528);
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: j4.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardAddToBasketView$lambda$14;
                    SaleOnBoardAddToBasketView$lambda$14 = SaleOnBoardAddToBasketViewKt.SaleOnBoardAddToBasketView$lambda$14(SaleOnBoardLineItem.this, onAddToBasket, onRemoveFromBasket, showSoldOutMessage, z5, z6, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardAddToBasketView$lambda$14;
                }
            });
        }
    }

    private static final int SaleOnBoardAddToBasketView$lambda$1(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardAddToBasketView$lambda$13$lambda$12$lambda$11$lambda$10(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardAddToBasketView$lambda$13$lambda$12$lambda$9$lambda$4$lambda$3(MutableState mutableState, int i5) {
        SaleOnBoardAddToBasketView$lambda$2(mutableState, i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardAddToBasketView$lambda$13$lambda$12$lambda$9$lambda$6$lambda$5(MutableState mutableState, int i5) {
        SaleOnBoardAddToBasketView$lambda$2(mutableState, i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardAddToBasketView$lambda$13$lambda$12$lambda$9$lambda$8$lambda$7(Function1 function1, MutableState mutableState) {
        function1.invoke(Integer.valueOf(SaleOnBoardAddToBasketView$lambda$1(mutableState)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardAddToBasketView$lambda$14(SaleOnBoardLineItem saleOnBoardLineItem, Function1 function1, Function0 function0, Function0 function02, boolean z5, boolean z6, int i5, Composer composer, int i6) {
        SaleOnBoardAddToBasketView(saleOnBoardLineItem, function1, function0, function02, z5, z6, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void SaleOnBoardAddToBasketView$lambda$2(MutableState<Integer> mutableState, int i5) {
        mutableState.setValue(Integer.valueOf(i5));
    }
}
