package dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProduct;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProductAddOn;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProductAddOnOption;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardStore;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardStoreTimeSlots;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardTimeSlot;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardVariant;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.buttons.NavigationButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.NavigationButtonType;
import dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.SaleOnBoardProductDetailsScreenKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.SaleOnBoardProductDetailsViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u008d\u0001\u0010\u0018\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00040\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000f2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0003¢\u0006\u0004\b\u0018\u0010\u0019\u001a#\u0010\u001f\u001a\u00020\u0004*\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 \u001a)\u0010$\u001a\u00020\u0004*\u00020\u001a2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b$\u0010%¨\u0006(²\u0006\f\u0010'\u001a\u00020&8\nX\u008a\u0084\u0002"}, d2 = {"Ldk/molslinjen/ui/views/screens/saleOnBoard/produdctDetails/SaleOnBoardProductDetailsViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "SaleOnBoardProductDetailsScreen", "(Ldk/molslinjen/ui/views/screens/saleOnBoard/produdctDetails/SaleOnBoardProductDetailsViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/saleOnBoard/produdctDetails/SaleOnBoardProductDetailsViewModel$ViewState;", "state", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "saleOnBoardCheckoutState", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOn;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOnOption;", "selectOption", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariant;", "selectVariant", BuildConfig.FLAVOR, "onAddToBasket", "Lkotlin/Function0;", "onRemoveFromBasket", "showSoldOutMessage", "dismiss", "SaleOnBoardProductDetailsContent", "(Ldk/molslinjen/ui/views/screens/saleOnBoard/produdctDetails/SaleOnBoardProductDetailsViewModel$ViewState;Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/lazy/LazyListScope;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;", "product", "Landroidx/compose/foundation/lazy/LazyListState;", "listState", "titleAndPrice", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;Landroidx/compose/foundation/lazy/LazyListState;)V", "Landroidx/compose/runtime/MutableState;", BuildConfig.FLAVOR, "imageLoadingFailed", "topImage", "(Landroidx/compose/foundation/lazy/LazyListScope;Landroidx/compose/runtime/MutableState;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;)V", "Landroidx/compose/ui/unit/Dp;", "endPadding", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SaleOnBoardProductDetailsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void SaleOnBoardProductDetailsContent(final SaleOnBoardProductDetailsViewModel.ViewState viewState, final SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, final Function2<? super SaleOnBoardProductAddOn, ? super SaleOnBoardProductAddOnOption, Unit> function2, final Function1<? super SaleOnBoardVariant, Unit> function1, final Function1<? super Integer, Unit> function12, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, Composer composer, final int i5) {
        int i6;
        Object obj;
        int i7;
        float f5;
        boolean z5;
        Modifier.Companion companion;
        BoxScopeInstance boxScopeInstance;
        LazyListState lazyListState;
        Composer composer2;
        MutableState mutableStateOf$default;
        List<SaleOnBoardTimeSlot> timeSlots;
        Composer startRestartGroup = composer.startRestartGroup(804995136);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(saleOnBoardCheckoutState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function03) ? 8388608 : 4194304;
        }
        if ((i6 & 4793491) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(804995136, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.SaleOnBoardProductDetailsContent (SaleOnBoardProductDetailsScreen.kt:114)");
            }
            final SaleOnBoardLineItem lineItem = viewState.getLineItem();
            if (lineItem == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: j4.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit SaleOnBoardProductDetailsContent$lambda$1;
                            SaleOnBoardProductDetailsContent$lambda$1 = SaleOnBoardProductDetailsScreenKt.SaleOnBoardProductDetailsContent$lambda$1(SaleOnBoardProductDetailsViewModel.ViewState.this, saleOnBoardCheckoutState, function2, function1, function12, function0, function02, function03, i5, (Composer) obj2, ((Integer) obj3).intValue());
                            return SaleOnBoardProductDetailsContent$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            final SaleOnBoardProduct product = lineItem.getProduct();
            Iterator<T> it = saleOnBoardCheckoutState.getStoresWithTimeSlots().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                SaleOnBoardStoreTimeSlots saleOnBoardStoreTimeSlots = (SaleOnBoardStoreTimeSlots) obj;
                SaleOnBoardStore selectedStore = saleOnBoardCheckoutState.getSelectedStore();
                if (Intrinsics.areEqual(selectedStore != null ? selectedStore.getId() : null, saleOnBoardStoreTimeSlots.getStoreId())) {
                    break;
                }
            }
            SaleOnBoardStoreTimeSlots saleOnBoardStoreTimeSlots2 = (SaleOnBoardStoreTimeSlots) obj;
            boolean z6 = (saleOnBoardStoreTimeSlots2 == null || (timeSlots = saleOnBoardStoreTimeSlots2.getTimeSlots()) == null) ? false : !timeSlots.isEmpty();
            startRestartGroup.startReplaceGroup(1591638270);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion2 = Composer.INSTANCE;
            if (rememberedValue == companion2.getEmpty()) {
                mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default);
                rememberedValue = mutableStateOf$default;
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1591640346);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion2.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(3, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1591642235);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion2.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(40, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            final int m3250dpToPx8Feqmps = (int) ComposeExtensionsKt.m3250dpToPx8Feqmps(Dp.m2599constructorimpl(98), startRestartGroup, 6);
            float f6 = 24;
            final float m2599constructorimpl = Dp.m2599constructorimpl(f6);
            final int m3250dpToPx8Feqmps2 = (int) ComposeExtensionsKt.m3250dpToPx8Feqmps(m2599constructorimpl, startRestartGroup, 6);
            final LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Alignment.Companion companion4 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion3);
            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion5.getConstructor();
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
            int i8 = i6;
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion5.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion5.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion5.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(-737305292);
            boolean changed = startRestartGroup.changed(m3250dpToPx8Feqmps2) | startRestartGroup.changed(m3250dpToPx8Feqmps);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue4 == companion2.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: j4.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit SaleOnBoardProductDetailsContent$lambda$12$lambda$7$lambda$6;
                        SaleOnBoardProductDetailsContent$lambda$12$lambda$7$lambda$6 = SaleOnBoardProductDetailsScreenKt.SaleOnBoardProductDetailsContent$lambda$12$lambda$7$lambda$6(m3250dpToPx8Feqmps2, mutableState2, m3250dpToPx8Feqmps, mutableState3, (LayoutCoordinates) obj2);
                        return SaleOnBoardProductDetailsContent$lambda$12$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(fillMaxSize$default, (Function1) rememberedValue4);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion4.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned);
            Function0<ComposeUiNode> constructor2 = companion5.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion5.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion5.getSetModifier());
            Modifier weight$default = ColumnScope.weight$default(ColumnScopeInstance.INSTANCE, companion3, 1.0f, false, 2, null);
            PaddingValues m310PaddingValuesa9UjIt4$default = PaddingKt.m310PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f6), 7, null);
            startRestartGroup.startReplaceGroup(-1013070547);
            boolean changedInstance = startRestartGroup.changedInstance(product) | startRestartGroup.changed(rememberLazyListState) | startRestartGroup.changed(z6) | startRestartGroup.changedInstance(viewState) | ((i8 & 7168) == 2048) | startRestartGroup.changedInstance(lineItem) | ((i8 & 896) == 256);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue5 == companion2.getEmpty()) {
                i7 = i8;
                f5 = f6;
                final boolean z7 = z6;
                z5 = z6;
                companion = companion3;
                boxScopeInstance = boxScopeInstance2;
                lazyListState = rememberLazyListState;
                Function1 function13 = new Function1() { // from class: j4.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit SaleOnBoardProductDetailsContent$lambda$12$lambda$11$lambda$10$lambda$9;
                        SaleOnBoardProductDetailsContent$lambda$12$lambda$11$lambda$10$lambda$9 = SaleOnBoardProductDetailsScreenKt.SaleOnBoardProductDetailsContent$lambda$12$lambda$11$lambda$10$lambda$9(MutableState.this, product, rememberLazyListState, z7, viewState, mutableState2, mutableState3, function1, m2599constructorimpl, lineItem, function2, (LazyListScope) obj2);
                        return SaleOnBoardProductDetailsContent$lambda$12$lambda$11$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(function13);
                rememberedValue5 = function13;
            } else {
                i7 = i8;
                f5 = f6;
                z5 = z6;
                companion = companion3;
                lazyListState = rememberLazyListState;
                boxScopeInstance = boxScopeInstance2;
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LazyDslKt.LazyColumn(weight$default, lazyListState, m310PaddingValuesa9UjIt4$default, false, null, null, null, false, (Function1) rememberedValue5, composer2, 384, 248);
            SaleOnBoardAddToBasketViewKt.SaleOnBoardAddToBasketView(viewState.getLineItem(), function12, function0, function02, z5, viewState.getIsEditing(), composer2, (i7 >> 9) & 8176);
            composer2.endNode();
            NavigationButtonKt.NavigationButton(NavigationButtonType.Close, boxScopeInstance.align(PaddingKt.m312paddingVpY3zN4(companion, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(16)), companion4.getTopEnd()), function03, composer2, ((i7 >> 15) & 896) | 6, 0);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: j4.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit SaleOnBoardProductDetailsContent$lambda$13;
                    SaleOnBoardProductDetailsContent$lambda$13 = SaleOnBoardProductDetailsScreenKt.SaleOnBoardProductDetailsContent$lambda$13(SaleOnBoardProductDetailsViewModel.ViewState.this, saleOnBoardCheckoutState, function2, function1, function12, function0, function02, function03, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return SaleOnBoardProductDetailsContent$lambda$13;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardProductDetailsContent$lambda$1(SaleOnBoardProductDetailsViewModel.ViewState viewState, SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, Function2 function2, Function1 function1, Function1 function12, Function0 function0, Function0 function02, Function0 function03, int i5, Composer composer, int i6) {
        SaleOnBoardProductDetailsContent(viewState, saleOnBoardCheckoutState, function2, function1, function12, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardProductDetailsContent$lambda$12$lambda$11$lambda$10$lambda$9(MutableState mutableState, SaleOnBoardProduct saleOnBoardProduct, LazyListState lazyListState, boolean z5, SaleOnBoardProductDetailsViewModel.ViewState viewState, MutableState mutableState2, MutableState mutableState3, Function1 function1, float f5, SaleOnBoardLineItem saleOnBoardLineItem, Function2 function2, LazyListScope LazyColumn) {
        Function2 function22;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        topImage(LazyColumn, mutableState, saleOnBoardProduct);
        titleAndPrice(LazyColumn, saleOnBoardProduct, lazyListState);
        final String description = saleOnBoardProduct.getDescription();
        boolean z6 = true;
        if (description != null) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1183853904, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.SaleOnBoardProductDetailsScreenKt$SaleOnBoardProductDetailsContent$1$2$1$1$1$1
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
                        ComposerKt.traceEventStart(-1183853904, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.SaleOnBoardProductDetailsContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SaleOnBoardProductDetailsScreen.kt:156)");
                    }
                    TextKt.m940Text4IGK_g(description, PaddingKt.m313paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m2599constructorimpl(24), 0.0f, 2, null), AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer, 432, 1572864, 65528);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
        }
        VariantsSectionKt.m3536variantsSectionQMuTD5c(LazyColumn, saleOnBoardProduct.getVariants(), viewState.getLineItem().getVariant(), !saleOnBoardProduct.isSoldOut() && z5, function1, ((Number) mutableState2.getValue()).intValue(), ((Number) mutableState3.getValue()).intValue(), f5);
        List<SaleOnBoardProductAddOn> addOns = saleOnBoardProduct.getAddOns();
        List<SaleOnBoardProductAddOnOption> addOns2 = saleOnBoardLineItem.getAddOns();
        if (saleOnBoardProduct.isSoldOut() || !z5) {
            function22 = function2;
            z6 = false;
        } else {
            function22 = function2;
        }
        AddonsSectionKt.addonsSection(LazyColumn, addOns, addOns2, function22, z6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardProductDetailsContent$lambda$12$lambda$7$lambda$6(int i5, MutableState mutableState, int i6, MutableState mutableState2, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        int m2661getWidthimpl = IntSize.m2661getWidthimpl(it.mo1948getSizeYbymL2g()) - (i5 * 2);
        mutableState.setValue(Integer.valueOf((int) (m2661getWidthimpl / i6)));
        mutableState2.setValue(Integer.valueOf((m2661getWidthimpl - (((Number) mutableState.getValue()).intValue() * i6)) / (((Number) mutableState.getValue()).intValue() - 1)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardProductDetailsContent$lambda$13(SaleOnBoardProductDetailsViewModel.ViewState viewState, SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, Function2 function2, Function1 function1, Function1 function12, Function0 function0, Function0 function02, Function0 function03, int i5, Composer composer, int i6) {
        SaleOnBoardProductDetailsContent(viewState, saleOnBoardCheckoutState, function2, function1, function12, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void SaleOnBoardProductDetailsScreen(final SaleOnBoardProductDetailsViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-2061086589);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2061086589, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.SaleOnBoardProductDetailsScreen (SaleOnBoardProductDetailsScreen.kt:76)");
            }
            SaleOnBoardProductDetailsViewModel.ViewState viewState = (SaleOnBoardProductDetailsViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState = (SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState) SnapshotStateKt.collectAsState(viewModel.getSaleOnBoardState(), null, startRestartGroup, 0, 1).getValue();
            Modifier closeKeyboardOnClickOutside = ModifierExtensionsKt.closeKeyboardOnClickOutside(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager()));
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(65198352, true, new SaleOnBoardProductDetailsScreenKt$SaleOnBoardProductDetailsScreen$1(viewModel, navigator, viewState, saleOnBoardCheckoutState), startRestartGroup, 54);
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(closeKeyboardOnClickOutside, 0.0f, null, null, 0L, null, null, null, null, rememberComposableLambda, startRestartGroup, 806879616, 442);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: j4.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardProductDetailsScreen$lambda$0;
                    SaleOnBoardProductDetailsScreen$lambda$0 = SaleOnBoardProductDetailsScreenKt.SaleOnBoardProductDetailsScreen$lambda$0(SaleOnBoardProductDetailsViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardProductDetailsScreen$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardProductDetailsScreen$lambda$0(SaleOnBoardProductDetailsViewModel saleOnBoardProductDetailsViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        SaleOnBoardProductDetailsScreen(saleOnBoardProductDetailsViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void titleAndPrice(LazyListScope lazyListScope, SaleOnBoardProduct saleOnBoardProduct, LazyListState lazyListState) {
        LazyListScope.stickyHeader$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(718252939, true, new SaleOnBoardProductDetailsScreenKt$titleAndPrice$1(lazyListState, saleOnBoardProduct)), 3, null);
    }

    private static final void topImage(LazyListScope lazyListScope, MutableState<Boolean> mutableState, SaleOnBoardProduct saleOnBoardProduct) {
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-210997124, true, new SaleOnBoardProductDetailsScreenKt$topImage$1(mutableState, saleOnBoardProduct)), 3, null);
    }
}
