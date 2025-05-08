package dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.view.compose.BackHandlerKt;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardBasketScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardProductDetailsScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardCategory;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProduct;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardStore;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardTimeSlot;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.extensions.ColorExtensionsKt;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.IndexHolder;
import dk.molslinjen.ui.views.reusable.ItemIndexedKt;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.buttons.ButtonConfig;
import dk.molslinjen.ui.views.reusable.buttons.ButtonWithPriceKt;
import dk.molslinjen.ui.views.reusable.dialog.SimpleButtonData;
import dk.molslinjen.ui.views.reusable.dialog.TextDialogKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListScreenKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListViewModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\b\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0083\u0001\u0010\u0016\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000b2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000eH\u0003¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a3\u0010%\u001a\u00020\u0004*\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&\u001a%\u0010(\u001a\u00020\u0004*\u00020'2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010 \u001a\u00020\u001fH\u0003¢\u0006\u0004\b(\u0010)\u001aE\u0010+\u001a\u00020\u0004*\u00020\u001c2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0*2\b\u0010,\u001a\u0004\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b+\u0010-\u001a\u0099\u0001\u00104\u001a\u00020\u0004*\u00020\u001c2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0*2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0*2\u0006\u0010$\u001a\u00020#2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0010002\u0006\u00103\u001a\u00020\u00102\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000b2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000e2\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0004\b4\u00105\u001a+\u00107\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020.0*2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0003¢\u0006\u0004\b7\u00108¨\u00069"}, d2 = {"Ldk/molslinjen/ui/views/screens/saleOnBoard/foodListScreen/SaleOnBoardFoodListViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "SaleOnBoardFoodListScreen", "(Ldk/molslinjen/ui/views/screens/saleOnBoard/foodListScreen/SaleOnBoardFoodListViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/saleOnBoard/foodListScreen/SaleOnBoardFoodListViewModel$ViewState;", "state", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "saleOnBoardCheckoutState", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCategory;", "selectCategory", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;", BuildConfig.FLAVOR, "showProductDetails", "Lkotlin/Function0;", "goToBasket", "reloadData", "seenProduct", "SaleOnBoardFoodListContent", "(Ldk/molslinjen/ui/views/screens/saleOnBoard/foodListScreen/SaleOnBoardFoodListViewModel$ViewState;Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "departure", "DepartureInfoBar", "(Ldk/molslinjen/domain/model/booking/IDepartureInfo;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/lazy/LazyListScope;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStore;", "store", BuildConfig.FLAVOR, "isLoading", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;", "firstAvailableTimeSlot", "Ldk/molslinjen/ui/views/reusable/IndexHolder;", "indexCounter", "shopImage", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStore;ZLdk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;Ldk/molslinjen/ui/views/reusable/IndexHolder;)V", "Landroidx/compose/foundation/layout/BoxScope;", "NextAvailableTimeSlotView", "(Landroidx/compose/foundation/layout/BoxScope;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;ZLandroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "categories", "selectedCategory", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCategory;Lkotlin/jvm/functions/Function1;Ldk/molslinjen/ui/views/reusable/IndexHolder;)V", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "basketLineItems", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "indexByCategoryId", "firstVisibleItemIndex", "products", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/ui/views/reusable/IndexHolder;Ljava/util/Map;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "lineItems", "BasketButtonView", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SaleOnBoardFoodListScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void BasketButtonView(final List<SaleOnBoardLineItem> list, final Function0<Unit> function0, Composer composer, final int i5) {
        PriceWithCurrency priceWithCurrency;
        Composer startRestartGroup = composer.startRestartGroup(-816648830);
        int i6 = (i5 & 6) == 0 ? (startRestartGroup.changedInstance(list) ? 4 : 2) | i5 : i5;
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-816648830, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.BasketButtonView (SaleOnBoardFoodListScreen.kt:455)");
            }
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(ModifierExtensionsKt.topShadow(Modifier.INSTANCE), AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(16));
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            SaleOnBoardLineItem saleOnBoardLineItem = (SaleOnBoardLineItem) CollectionsKt.firstOrNull((List) list);
            if (saleOnBoardLineItem == null || (priceWithCurrency = saleOnBoardLineItem.getUnitPrice()) == null) {
                priceWithCurrency = new PriceWithCurrency(0, CurrencyType.DKK);
            }
            int i7 = 0;
            for (SaleOnBoardLineItem saleOnBoardLineItem2 : list) {
                i7 += saleOnBoardLineItem2.getUnitPrice().getValue() * saleOnBoardLineItem2.getQuantity();
            }
            PriceWithCurrency copy$default = PriceWithCurrency.copy$default(priceWithCurrency, i7, null, 2, null);
            int size = list.size();
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.saleOnBoard_toSummary, startRestartGroup, 6);
            PriceWithCurrency priceWithCurrency2 = ((SaleOnBoardLineItem) CollectionsKt.firstOrNull((List) list)) != null ? copy$default : null;
            startRestartGroup.startReplaceGroup(396368769);
            String stringResource2 = size != 0 ? StringResources_androidKt.stringResource(R.string.saleOnBoard_button_added, new Object[]{Integer.valueOf(size)}, startRestartGroup, 6) : null;
            startRestartGroup.endReplaceGroup();
            ButtonWithPriceKt.ButtonWithPrice(fillMaxWidth$default, function0, stringResource, priceWithCurrency2, stringResource2, size > 0, (Function0<Unit>) null, (ButtonConfig) null, false, startRestartGroup, (i6 & 112) | 6, 448);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: g4.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BasketButtonView$lambda$42;
                    BasketButtonView$lambda$42 = SaleOnBoardFoodListScreenKt.BasketButtonView$lambda$42(list, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return BasketButtonView$lambda$42;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasketButtonView$lambda$42(List list, Function0 function0, int i5, Composer composer, int i6) {
        BasketButtonView(list, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void DepartureInfoBar(final IDepartureInfo departure, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(departure, "departure");
        Composer startRestartGroup = composer.startRestartGroup(724000839);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(departure) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(724000839, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.DepartureInfoBar (SaleOnBoardFoodListScreen.kt:235)");
            }
            float f5 = 8;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), AppColor.INSTANCE.m3259getBrandDarkBlue10d7_KjU(), null, 2, null), 0.0f, Dp.m2599constructorimpl(f5), 1, null);
            startRestartGroup.startReplaceGroup(1208611815);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: g4.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DepartureInfoBar$lambda$34$lambda$33;
                        DepartureInfoBar$lambda$34$lambda$33 = SaleOnBoardFoodListScreenKt.DepartureInfoBar$lambda$34$lambda$33((SemanticsPropertyReceiver) obj);
                        return DepartureInfoBar$lambda$34$lambda$33;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier semantics = SemanticsModifierKt.semantics(m313paddingVpY3zN4$default, true, (Function1) rememberedValue);
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, semantics);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            FlowLayoutKt.FlowRow(null, Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(f5)), null, 0, 0, null, ComposableLambdaKt.rememberComposableLambda(786799292, true, new SaleOnBoardFoodListScreenKt$DepartureInfoBar$2$1(departure), startRestartGroup, 54), startRestartGroup, 1572912, 61);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: g4.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DepartureInfoBar$lambda$36;
                    DepartureInfoBar$lambda$36 = SaleOnBoardFoodListScreenKt.DepartureInfoBar$lambda$36(IDepartureInfo.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DepartureInfoBar$lambda$36;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureInfoBar$lambda$34$lambda$33(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureInfoBar$lambda$36(IDepartureInfo iDepartureInfo, int i5, Composer composer, int i6) {
        DepartureInfoBar(iDepartureInfo, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NextAvailableTimeSlotView(final BoxScope boxScope, final SaleOnBoardTimeSlot saleOnBoardTimeSlot, final boolean z5, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        String stringResource;
        Composer startRestartGroup = composer.startRestartGroup(-1355667525);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(boxScope) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(saleOnBoardTimeSlot) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1355667525, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.NextAvailableTimeSlotView (SaleOnBoardFoodListScreen.kt:318)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(24), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(48), 7, null);
            AppColor appColor = AppColor.INSTANCE;
            float f5 = 8;
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BackgroundKt.m103backgroundbw27NRU(m315paddingqDBjuR0$default, saleOnBoardTimeSlot != null ? appColor.m3268getGrey50d7_KjU() : appColor.m3277getTagPurple0d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(4));
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Modifier align = boxScope.align(m312paddingVpY3zN4, companion2.getBottomCenter());
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), companion2.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, align);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-1231100198);
            if (saleOnBoardTimeSlot != null) {
                IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_clock, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 11, null), Dp.m2599constructorimpl(16)), Color.INSTANCE.m1501getUnspecified0d7_KjU(), startRestartGroup, 3456, 0);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1231088184);
            if (z5) {
                composer2 = startRestartGroup;
            } else {
                if (saleOnBoardTimeSlot != null) {
                    startRestartGroup.startReplaceGroup(491057088);
                    LocalTime localTime = saleOnBoardTimeSlot.getStartDateTime().toLocalTime();
                    Intrinsics.checkNotNullExpressionValue(localTime, "toLocalTime(...)");
                    stringResource = StringResources_androidKt.stringResource(R.string.saleOnBoard_foodList_nextAvailableTime, new Object[]{LocalDateTimeExtensionsKt.toFormatTime(localTime)}, startRestartGroup, 6);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(491296563);
                    stringResource = StringResources_androidKt.stringResource(R.string.saleOnBoard_noAvailableTimes, startRestartGroup, 6);
                    startRestartGroup.endReplaceGroup();
                }
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(stringResource, null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 0, 1572864, 65022);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: g4.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NextAvailableTimeSlotView$lambda$38;
                    NextAvailableTimeSlotView$lambda$38 = SaleOnBoardFoodListScreenKt.NextAvailableTimeSlotView$lambda$38(BoxScope.this, saleOnBoardTimeSlot, z5, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return NextAvailableTimeSlotView$lambda$38;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NextAvailableTimeSlotView$lambda$38(BoxScope boxScope, SaleOnBoardTimeSlot saleOnBoardTimeSlot, boolean z5, int i5, Composer composer, int i6) {
        NextAvailableTimeSlotView(boxScope, saleOnBoardTimeSlot, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void SaleOnBoardFoodListContent(final SaleOnBoardFoodListViewModel.ViewState viewState, final SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, final Function1<? super SaleOnBoardCategory, Unit> function1, final Function2<? super SaleOnBoardProduct, ? super Integer, Unit> function2, final Function0<Unit> function0, final Function0<Unit> function02, final Function2<? super SaleOnBoardProduct, ? super Integer, Unit> function22, Composer composer, final int i5) {
        int i6;
        LazyListState lazyListState;
        int i7;
        boolean z5;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-336587072);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(saleOnBoardCheckoutState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i6 |= startRestartGroup.changedInstance(function22) ? 1048576 : 524288;
        }
        int i8 = i6;
        if ((599187 & i8) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-336587072, i8, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListContent (SaleOnBoardFoodListScreen.kt:146)");
            }
            final IDepartureInfo selectedDeparture = saleOnBoardCheckoutState.getSelectedDeparture();
            if (selectedDeparture == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: g4.r
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit SaleOnBoardFoodListContent$lambda$18;
                            SaleOnBoardFoodListContent$lambda$18 = SaleOnBoardFoodListScreenKt.SaleOnBoardFoodListContent$lambda$18(SaleOnBoardFoodListViewModel.ViewState.this, saleOnBoardCheckoutState, function1, function2, function0, function02, function22, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return SaleOnBoardFoodListContent$lambda$18;
                        }
                    });
                    return;
                }
                return;
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            AppColor appColor = AppColor.INSTANCE;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(companion, appColor.m3259getBrandDarkBlue10d7_KjU(), null, 2, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, ColorExtensionsKt.m3249withAlphaDxMtmZc(appColor.m3268getGrey50d7_KjU(), 0.2f), ComposeExtensionsKt.pxToDp(1, startRestartGroup, 6), null, startRestartGroup, 0, 9);
            startRestartGroup.endNode();
            final int m3250dpToPx8Feqmps = (int) ComposeExtensionsKt.m3250dpToPx8Feqmps(Dp.m2599constructorimpl(54), startRestartGroup, 6);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (rememberedValue == companion4.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.startReplaceGroup(721233208);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion4.getEmpty()) {
                rememberedValue2 = new LinkedHashMap();
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final Map map = (Map) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            final LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier weight$default = ColumnScope.weight$default(columnScopeInstance, companion, 1.0f, false, 2, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, weight$default);
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl3, maybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
            final SaleOnBoardStore selectedStore = saleOnBoardCheckoutState.getSelectedStore();
            Modifier m104backgroundbw27NRU$default2 = BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), appColor.m3269getGrey60d7_KjU(), null, 2, null);
            PaddingValues m310PaddingValuesa9UjIt4$default = PaddingKt.m310PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(24), 7, null);
            startRestartGroup.startReplaceGroup(-801843960);
            boolean changedInstance = startRestartGroup.changedInstance(selectedDeparture) | startRestartGroup.changedInstance(viewState) | startRestartGroup.changedInstance(selectedStore) | startRestartGroup.changedInstance(map) | startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changed(rememberLazyListState) | startRestartGroup.changed(m3250dpToPx8Feqmps) | startRestartGroup.changedInstance(saleOnBoardCheckoutState) | ((i8 & 896) == 256) | ((i8 & 7168) == 2048) | ((3670016 & i8) == 1048576);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue3 == companion4.getEmpty()) {
                lazyListState = rememberLazyListState;
                i7 = i8;
                z5 = false;
                composer2 = startRestartGroup;
                Function1 function12 = new Function1() { // from class: g4.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SaleOnBoardFoodListContent$lambda$31$lambda$26$lambda$25$lambda$24;
                        SaleOnBoardFoodListContent$lambda$31$lambda$26$lambda$25$lambda$24 = SaleOnBoardFoodListScreenKt.SaleOnBoardFoodListContent$lambda$31$lambda$26$lambda$25$lambda$24(SaleOnBoardFoodListViewModel.ViewState.this, selectedStore, saleOnBoardCheckoutState, map, rememberLazyListState, function1, function2, function22, selectedDeparture, coroutineScope, m3250dpToPx8Feqmps, (LazyListScope) obj);
                        return SaleOnBoardFoodListContent$lambda$31$lambda$26$lambda$25$lambda$24;
                    }
                };
                composer2.updateRememberedValue(function12);
                rememberedValue3 = function12;
            } else {
                lazyListState = rememberLazyListState;
                i7 = i8;
                composer2 = startRestartGroup;
                z5 = false;
            }
            composer2.endReplaceGroup();
            LazyDslKt.LazyColumn(m104backgroundbw27NRU$default2, lazyListState, m310PaddingValuesa9UjIt4$default, false, null, null, null, false, (Function1) rememberedValue3, composer2, 390, 248);
            LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, viewState.getIsLoading(), 0, selectedStore == null ? true : z5, function02, ComposableSingletons$SaleOnBoardFoodListScreenKt.INSTANCE.m3531getLambda1$app_kombardoProd(), composer2, (i7 & 458752) | 1572864, 11);
            composer2.endNode();
            boolean z6 = !saleOnBoardCheckoutState.getBasketLineItems().isEmpty();
            composer2.startReplaceGroup(-1149292171);
            Object rememberedValue4 = composer2.rememberedValue();
            if (rememberedValue4 == companion4.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: g4.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        int SaleOnBoardFoodListContent$lambda$31$lambda$28$lambda$27;
                        SaleOnBoardFoodListContent$lambda$31$lambda$28$lambda$27 = SaleOnBoardFoodListScreenKt.SaleOnBoardFoodListContent$lambda$31$lambda$28$lambda$27(((Integer) obj).intValue());
                        return Integer.valueOf(SaleOnBoardFoodListContent$lambda$31$lambda$28$lambda$27);
                    }
                };
                composer2.updateRememberedValue(rememberedValue4);
            }
            composer2.endReplaceGroup();
            EnterTransition slideInVertically$default = EnterExitTransitionKt.slideInVertically$default(null, (Function1) rememberedValue4, 1, null);
            composer2.startReplaceGroup(-1149290155);
            Object rememberedValue5 = composer2.rememberedValue();
            if (rememberedValue5 == companion4.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: g4.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        int SaleOnBoardFoodListContent$lambda$31$lambda$30$lambda$29;
                        SaleOnBoardFoodListContent$lambda$31$lambda$30$lambda$29 = SaleOnBoardFoodListScreenKt.SaleOnBoardFoodListContent$lambda$31$lambda$30$lambda$29(((Integer) obj).intValue());
                        return Integer.valueOf(SaleOnBoardFoodListContent$lambda$31$lambda$30$lambda$29);
                    }
                };
                composer2.updateRememberedValue(rememberedValue5);
            }
            composer2.endReplaceGroup();
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z6, (Modifier) null, slideInVertically$default, EnterExitTransitionKt.slideOutVertically$default(null, (Function1) rememberedValue5, 1, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-404272462, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListScreenKt$SaleOnBoardFoodListContent$2$4
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                    invoke(animatedVisibilityScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int i9) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-404272462, i9, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListContent.<anonymous>.<anonymous> (SaleOnBoardFoodListScreen.kt:225)");
                    }
                    SaleOnBoardFoodListScreenKt.BasketButtonView(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState.this.getBasketLineItems(), function0, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer2, 54), composer2, 1600518, 18);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: g4.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardFoodListContent$lambda$32;
                    SaleOnBoardFoodListContent$lambda$32 = SaleOnBoardFoodListScreenKt.SaleOnBoardFoodListContent$lambda$32(SaleOnBoardFoodListViewModel.ViewState.this, saleOnBoardCheckoutState, function1, function2, function0, function02, function22, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardFoodListContent$lambda$32;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardFoodListContent$lambda$18(SaleOnBoardFoodListViewModel.ViewState viewState, SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, Function1 function1, Function2 function2, Function0 function0, Function0 function02, Function2 function22, int i5, Composer composer, int i6) {
        SaleOnBoardFoodListContent(viewState, saleOnBoardCheckoutState, function1, function2, function0, function02, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardFoodListContent$lambda$31$lambda$26$lambda$25$lambda$24(SaleOnBoardFoodListViewModel.ViewState viewState, SaleOnBoardStore saleOnBoardStore, SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, final Map map, final LazyListState lazyListState, Function1 function1, Function2 function2, Function2 function22, final IDepartureInfo iDepartureInfo, final CoroutineScope coroutineScope, final int i5, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        Object obj = null;
        IndexHolder indexHolder = new IndexHolder(0, 1, null);
        ItemIndexedKt.itemIndexed$default(LazyColumn, indexHolder, null, null, ComposableLambdaKt.composableLambdaInstance(-1710081047, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListScreenKt$SaleOnBoardFoodListContent$2$1$1$1$1
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope itemIndexed, int i6, Composer composer, int i7) {
                Intrinsics.checkNotNullParameter(itemIndexed, "$this$itemIndexed");
                if ((i7 & 129) == 128 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1710081047, i7, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SaleOnBoardFoodListScreen.kt:174)");
                }
                SaleOnBoardFoodListScreenKt.DepartureInfoBar(IDepartureInfo.this, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
        if (!viewState.getIsLoading() && saleOnBoardStore != null) {
            Iterator<T> it = viewState.getTimeSlots().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (!((SaleOnBoardTimeSlot) next).getFullyBooked()) {
                    obj = next;
                    break;
                }
            }
            shopImage(LazyColumn, saleOnBoardStore, viewState.getIsLoadingTimeSlots(), (SaleOnBoardTimeSlot) obj, indexHolder);
            if (!saleOnBoardStore.getCategories().isEmpty()) {
                categories(LazyColumn, saleOnBoardStore.getCategories(), viewState.getSelectedCategory(), new Function1() { // from class: g4.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit SaleOnBoardFoodListContent$lambda$31$lambda$26$lambda$25$lambda$24$lambda$23;
                        SaleOnBoardFoodListContent$lambda$31$lambda$26$lambda$25$lambda$24$lambda$23 = SaleOnBoardFoodListScreenKt.SaleOnBoardFoodListContent$lambda$31$lambda$26$lambda$25$lambda$24$lambda$23(map, coroutineScope, lazyListState, i5, (SaleOnBoardCategory) obj2);
                        return SaleOnBoardFoodListContent$lambda$31$lambda$26$lambda$25$lambda$24$lambda$23;
                    }
                }, indexHolder);
            }
            products(LazyColumn, saleOnBoardStore.getCategories(), saleOnBoardCheckoutState.getBasketLineItems(), indexHolder, map, lazyListState.getFirstVisibleItemIndex(), function1, function2, function22);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardFoodListContent$lambda$31$lambda$26$lambda$25$lambda$24$lambda$23(Map map, CoroutineScope coroutineScope, LazyListState lazyListState, int i5, SaleOnBoardCategory it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Integer num = (Integer) map.get(it.getId());
        if (num != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SaleOnBoardFoodListScreenKt$SaleOnBoardFoodListContent$2$1$1$1$3$1$1(lazyListState, num.intValue(), i5, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int SaleOnBoardFoodListContent$lambda$31$lambda$28$lambda$27(int i5) {
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int SaleOnBoardFoodListContent$lambda$31$lambda$30$lambda$29(int i5) {
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardFoodListContent$lambda$32(SaleOnBoardFoodListViewModel.ViewState viewState, SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, Function1 function1, Function2 function2, Function0 function0, Function0 function02, Function2 function22, int i5, Composer composer, int i6) {
        SaleOnBoardFoodListContent(viewState, saleOnBoardCheckoutState, function1, function2, function0, function02, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void SaleOnBoardFoodListScreen(final SaleOnBoardFoodListViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        boolean z5;
        boolean z6;
        int i7;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(2116004461);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        int i8 = i6;
        if ((i8 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2116004461, i8, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListScreen (SaleOnBoardFoodListScreen.kt:91)");
            }
            SaleOnBoardFoodListViewModel.ViewState viewState = (SaleOnBoardFoodListViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState = (SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState) SnapshotStateKt.collectAsState(viewModel.getSaleOnBoardCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(2118788183);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            boolean z7 = !saleOnBoardCheckoutState.getBasketLineItems().isEmpty();
            startRestartGroup.startReplaceGroup(2118791356);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: g4.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SaleOnBoardFoodListScreen$lambda$2$lambda$1;
                        SaleOnBoardFoodListScreen$lambda$2$lambda$1 = SaleOnBoardFoodListScreenKt.SaleOnBoardFoodListScreen$lambda$2$lambda$1(MutableState.this);
                        return SaleOnBoardFoodListScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            BackHandlerKt.BackHandler(z7, (Function0) rememberedValue2, startRestartGroup, 48, 0);
            startRestartGroup.startReplaceGroup(2118793430);
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                String stringResource = StringResources_androidKt.stringResource(R.string.saleOnBoard_abortDialog_title, startRestartGroup, 6);
                String stringResource2 = StringResources_androidKt.stringResource(R.string.saleOnBoard_abortDialog_abandon, startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(2118804002);
                boolean z8 = (i8 & 112) == 32;
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (z8 || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: g4.k
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SaleOnBoardFoodListScreen$lambda$4$lambda$3;
                            SaleOnBoardFoodListScreen$lambda$4$lambda$3 = SaleOnBoardFoodListScreenKt.SaleOnBoardFoodListScreen$lambda$4$lambda$3(MutableState.this, navigator);
                            return SaleOnBoardFoodListScreen$lambda$4$lambda$3;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                SimpleButtonData simpleButtonData = new SimpleButtonData(stringResource2, false, false, (Function0) rememberedValue3, 6, null);
                String stringResource3 = StringResources_androidKt.stringResource(R.string.button_cancel, startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(2118812465);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: g4.l
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SaleOnBoardFoodListScreen$lambda$6$lambda$5;
                            SaleOnBoardFoodListScreen$lambda$6$lambda$5 = SaleOnBoardFoodListScreenKt.SaleOnBoardFoodListScreen$lambda$6$lambda$5(MutableState.this);
                            return SaleOnBoardFoodListScreen$lambda$6$lambda$5;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                SimpleButtonData simpleButtonData2 = new SimpleButtonData(stringResource3, false, false, (Function0) rememberedValue4, 6, null);
                startRestartGroup.startReplaceGroup(2118797777);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new Function0() { // from class: g4.m
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SaleOnBoardFoodListScreen$lambda$8$lambda$7;
                            SaleOnBoardFoodListScreen$lambda$8$lambda$7 = SaleOnBoardFoodListScreenKt.SaleOnBoardFoodListScreen$lambda$8$lambda$7(MutableState.this);
                            return SaleOnBoardFoodListScreen$lambda$8$lambda$7;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceGroup();
                z5 = true;
                z6 = false;
                i7 = i8;
                TextDialogKt.TextDialog(stringResource, null, null, simpleButtonData, simpleButtonData2, false, (Function0) rememberedValue5, startRestartGroup, 1572864, 38);
            } else {
                z5 = true;
                z6 = false;
                i7 = i8;
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(2118818638);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new SaleOnBoardFoodListScreenKt$SaleOnBoardFoodListScreen$5$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function1 = (Function1) ((KFunction) rememberedValue6);
            startRestartGroup.startReplaceGroup(2118820701);
            int i9 = i7 & 112;
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel) | (i9 == 32 ? z5 : z6);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = new Function2() { // from class: g4.n
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit SaleOnBoardFoodListScreen$lambda$12$lambda$11;
                        SaleOnBoardFoodListScreen$lambda$12$lambda$11 = SaleOnBoardFoodListScreenKt.SaleOnBoardFoodListScreen$lambda$12$lambda$11(SaleOnBoardFoodListViewModel.this, navigator, (SaleOnBoardProduct) obj, ((Integer) obj2).intValue());
                        return SaleOnBoardFoodListScreen$lambda$12$lambda$11;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            Function2 function2 = (Function2) rememberedValue7;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(2118830691);
            boolean z9 = i9 == 32 ? z5 : z6;
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (z9 || rememberedValue8 == companion.getEmpty()) {
                rememberedValue8 = new Function0() { // from class: g4.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SaleOnBoardFoodListScreen$lambda$14$lambda$13;
                        SaleOnBoardFoodListScreen$lambda$14$lambda$13 = SaleOnBoardFoodListScreenKt.SaleOnBoardFoodListScreen$lambda$14$lambda$13(DestinationsNavigator.this);
                        return SaleOnBoardFoodListScreen$lambda$14$lambda$13;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            Function0 function0 = (Function0) rememberedValue8;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(2118833878);
            boolean changedInstance3 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue9 == companion.getEmpty()) {
                rememberedValue9 = new SaleOnBoardFoodListScreenKt$SaleOnBoardFoodListScreen$8$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            startRestartGroup.endReplaceGroup();
            Function0 function02 = (Function0) ((KFunction) rememberedValue9);
            startRestartGroup.startReplaceGroup(2118835691);
            boolean changedInstance4 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue10 == companion.getEmpty()) {
                rememberedValue10 = new SaleOnBoardFoodListScreenKt$SaleOnBoardFoodListScreen$9$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            startRestartGroup.endReplaceGroup();
            SaleOnBoardFoodListContent(viewState, saleOnBoardCheckoutState, function1, function2, function0, function02, (Function2) ((KFunction) rememberedValue10), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: g4.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardFoodListScreen$lambda$17;
                    SaleOnBoardFoodListScreen$lambda$17 = SaleOnBoardFoodListScreenKt.SaleOnBoardFoodListScreen$lambda$17(SaleOnBoardFoodListViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardFoodListScreen$lambda$17;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardFoodListScreen$lambda$12$lambda$11(SaleOnBoardFoodListViewModel saleOnBoardFoodListViewModel, final DestinationsNavigator destinationsNavigator, SaleOnBoardProduct product, int i5) {
        Intrinsics.checkNotNullParameter(product, "product");
        saleOnBoardFoodListViewModel.showProductDetails(product, i5, new Function1() { // from class: g4.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit SaleOnBoardFoodListScreen$lambda$12$lambda$11$lambda$10;
                SaleOnBoardFoodListScreen$lambda$12$lambda$11$lambda$10 = SaleOnBoardFoodListScreenKt.SaleOnBoardFoodListScreen$lambda$12$lambda$11$lambda$10(DestinationsNavigator.this, (String) obj);
                return SaleOnBoardFoodListScreen$lambda$12$lambda$11$lambda$10;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardFoodListScreen$lambda$12$lambda$11$lambda$10(DestinationsNavigator destinationsNavigator, String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SaleOnBoardProductDetailsScreenDestination.invoke$default(SaleOnBoardProductDetailsScreenDestination.INSTANCE, productId, null, 2, null), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardFoodListScreen$lambda$14$lambda$13(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SaleOnBoardBasketScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardFoodListScreen$lambda$17(SaleOnBoardFoodListViewModel saleOnBoardFoodListViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        SaleOnBoardFoodListScreen(saleOnBoardFoodListViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardFoodListScreen$lambda$2$lambda$1(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardFoodListScreen$lambda$4$lambda$3(MutableState mutableState, DestinationsNavigator destinationsNavigator) {
        mutableState.setValue(Boolean.FALSE);
        destinationsNavigator.popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardFoodListScreen$lambda$6$lambda$5(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardFoodListScreen$lambda$8$lambda$7(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    public static final void categories(LazyListScope lazyListScope, List<SaleOnBoardCategory> categories, SaleOnBoardCategory saleOnBoardCategory, Function1<? super SaleOnBoardCategory, Unit> selectCategory, IndexHolder indexCounter) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(selectCategory, "selectCategory");
        Intrinsics.checkNotNullParameter(indexCounter, "indexCounter");
        ItemIndexedKt.stickyHeaderIndexed$default(lazyListScope, indexCounter, null, null, ComposableLambdaKt.composableLambdaInstance(1390472547, true, new SaleOnBoardFoodListScreenKt$categories$1(categories, saleOnBoardCategory, selectCategory)), 6, null);
    }

    public static final void products(LazyListScope lazyListScope, List<SaleOnBoardCategory> categories, List<SaleOnBoardLineItem> basketLineItems, IndexHolder indexCounter, Map<String, Integer> map, final int i5, final Function1<? super SaleOnBoardCategory, Unit> selectCategory, Function2<? super SaleOnBoardProduct, ? super Integer, Unit> showProductDetails, Function2<? super SaleOnBoardProduct, ? super Integer, Unit> seenProduct) {
        Map<String, Integer> indexByCategoryId = map;
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(basketLineItems, "basketLineItems");
        Intrinsics.checkNotNullParameter(indexCounter, "indexCounter");
        Intrinsics.checkNotNullParameter(indexByCategoryId, "indexByCategoryId");
        Intrinsics.checkNotNullParameter(selectCategory, "selectCategory");
        Intrinsics.checkNotNullParameter(showProductDetails, "showProductDetails");
        Intrinsics.checkNotNullParameter(seenProduct, "seenProduct");
        Iterator<SaleOnBoardCategory> it = categories.iterator();
        while (it.hasNext()) {
            final SaleOnBoardCategory next = it.next();
            indexByCategoryId.put(next.getId(), Integer.valueOf(indexCounter.getValue()));
            ItemIndexedKt.itemIndexed$default(lazyListScope, indexCounter, null, null, ComposableLambdaKt.composableLambdaInstance(468719397, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListScreenKt$products$1
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope itemIndexed, int i6, Composer composer, int i7) {
                    int i8;
                    Intrinsics.checkNotNullParameter(itemIndexed, "$this$itemIndexed");
                    if ((i7 & 48) == 0) {
                        i8 = i7 | (composer.changed(i6) ? 32 : 16);
                    } else {
                        i8 = i7;
                    }
                    if ((i8 & 145) == 144 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(468719397, i8, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.products.<anonymous> (SaleOnBoardFoodListScreen.kt:420)");
                    }
                    if (i5 == i6 - 1) {
                        selectCategory.invoke(next);
                    }
                    TextKt.m940Text4IGK_g(next.getName(), PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m2599constructorimpl(16), 0.0f, 2, null), 0.0f, Dp.m2599constructorimpl(24), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), composer, 48, 1572864, 65532);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 6, null);
            Iterator<SaleOnBoardProduct> it2 = next.getProducts().iterator();
            while (it2.hasNext()) {
                ItemIndexedKt.itemIndexed$default(lazyListScope, indexCounter, null, null, ComposableLambdaKt.composableLambdaInstance(947687299, true, new SaleOnBoardFoodListScreenKt$products$2(i5, selectCategory, next, it2.next(), showProductDetails, indexCounter, basketLineItems, seenProduct)), 6, null);
                next = next;
            }
            indexByCategoryId = map;
        }
        ItemIndexedKt.itemIndexed$default(lazyListScope, indexCounter, null, null, ComposableSingletons$SaleOnBoardFoodListScreenKt.INSTANCE.m3532getLambda2$app_kombardoProd(), 6, null);
    }

    public static final void shopImage(LazyListScope lazyListScope, SaleOnBoardStore store, boolean z5, SaleOnBoardTimeSlot saleOnBoardTimeSlot, IndexHolder indexCounter) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(indexCounter, "indexCounter");
        ItemIndexedKt.itemIndexed$default(lazyListScope, indexCounter, null, null, ComposableLambdaKt.composableLambdaInstance(680615142, true, new SaleOnBoardFoodListScreenKt$shopImage$1(store, saleOnBoardTimeSlot, z5)), 6, null);
    }
}
