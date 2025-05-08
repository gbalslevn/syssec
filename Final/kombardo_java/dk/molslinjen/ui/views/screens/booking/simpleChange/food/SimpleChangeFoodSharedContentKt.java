package dk.molslinjen.ui.views.screens.booking.simpleChange.food;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import dk.molslinjen.domain.managers.checkout.AddonHelper;
import dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.ProductGroup;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.booking.addons.ProductsViewKt;
import dk.molslinjen.ui.views.screens.booking.simpleChange.food.SimpleChangeFoodSharedContentKt;
import dk.molslinjen.ui.views.screens.booking.simpleChange.food.SimpleChangeFoodViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001aA\u0010\u0012\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0003¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/simpleChange/food/SimpleChangeFoodViewModel;", "viewModel", "Lkotlin/Function0;", BuildConfig.FLAVOR, "proceed", "dismiss", "SimpleChangeFoodSharedContent", "(Ldk/molslinjen/ui/views/screens/booking/simpleChange/food/SimpleChangeFoodViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/booking/simpleChange/food/SimpleChangeFoodViewModel$ViewState;", "state", "Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;", "addonState", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/booking/product/Product;", BuildConfig.FLAVOR, "onQuantityChanged", "Landroidx/compose/foundation/lazy/LazyListState;", "lazyListState", "ChangeFoodContent", "(Ldk/molslinjen/ui/views/screens/booking/simpleChange/food/SimpleChangeFoodViewModel$ViewState;Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SimpleChangeFoodSharedContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChangeFoodContent(final SimpleChangeFoodViewModel.ViewState viewState, final AddonHelper.AddonState addonState, final Function2<? super Product, ? super Integer, Unit> function2, final LazyListState lazyListState, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1439173739);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(addonState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(lazyListState) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1439173739, i6, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.food.ChangeFoodContent (SimpleChangeFoodSharedContent.kt:79)");
            }
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(Modifier.INSTANCE, AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            ProductsViewKt.ProductsView(ColumnScopeInstance.INSTANCE, viewState.getIsLoading(), addonState.getFood(), null, true, StringResources_androidKt.stringResource(R.string.food_empty, startRestartGroup, 6), CollectionsKt.emptyList(), null, R.drawable.icon_no_addons, function2, lazyListState, null, startRestartGroup, 102263814 | ((i6 << 21) & 1879048192), (i6 >> 9) & 14, 1088);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: f3.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ChangeFoodContent$lambda$7;
                    ChangeFoodContent$lambda$7 = SimpleChangeFoodSharedContentKt.ChangeFoodContent$lambda$7(SimpleChangeFoodViewModel.ViewState.this, addonState, function2, lazyListState, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ChangeFoodContent$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChangeFoodContent$lambda$7(SimpleChangeFoodViewModel.ViewState viewState, AddonHelper.AddonState addonState, Function2 function2, LazyListState lazyListState, int i5, Composer composer, int i6) {
        ChangeFoodContent(viewState, addonState, function2, lazyListState, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x018d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SimpleChangeFoodSharedContent(final SimpleChangeFoodViewModel viewModel, final Function0<Unit> proceed, final Function0<Unit> dismiss, Composer composer, final int i5) {
        ArrayList arrayList;
        Composer composer2;
        List<ProductGroup> food;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        Intrinsics.checkNotNullParameter(dismiss, "dismiss");
        Composer startRestartGroup = composer.startRestartGroup(980128978);
        int i6 = (i5 & 6) == 0 ? (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5 : i5;
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(proceed) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(dismiss) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(980128978, i6, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.food.SimpleChangeFoodSharedContent (SimpleChangeFoodSharedContent.kt:25)");
            }
            boolean z5 = false;
            final SimpleChangeFoodViewModel.ViewState viewState = (SimpleChangeFoodViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState = (SimpleChangeCheckoutManager.SimpleChangeCheckoutState) SnapshotStateKt.collectAsState(viewModel.getSimpleChangeCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            final AddonHelper.AddonState addonState = (AddonHelper.AddonState) SnapshotStateKt.collectAsState(viewModel.getAddonState(), null, startRestartGroup, 0, 1).getValue();
            List<ProductGroup> food2 = addonState.getFood();
            if (food2 != null) {
                arrayList = new ArrayList();
                Iterator<T> it = food2.iterator();
                while (it.hasNext()) {
                    List<Product> products = ((ProductGroup) it.next()).getProducts();
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : products) {
                        if (((Product) obj).getQuantity() > 0) {
                            arrayList2.add(obj);
                        }
                    }
                    CollectionsKt.addAll(arrayList, arrayList2);
                }
            } else {
                arrayList = null;
            }
            Booking existingBooking = simpleChangeCheckoutState.getExistingBooking();
            if (existingBooking == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: f3.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit SimpleChangeFoodSharedContent$lambda$2;
                            SimpleChangeFoodSharedContent$lambda$2 = SimpleChangeFoodSharedContentKt.SimpleChangeFoodSharedContent$lambda$2(SimpleChangeFoodViewModel.this, proceed, dismiss, i5, (Composer) obj2, ((Integer) obj3).intValue());
                            return SimpleChangeFoodSharedContent$lambda$2;
                        }
                    });
                    return;
                }
                return;
            }
            final LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
            if (!viewState.getPreselectedFood()) {
                if (Intrinsics.areEqual(simpleChangeCheckoutState.getEarlyCheckIn(), Boolean.TRUE) && (food = addonState.getFood()) != null) {
                    List<ProductGroup> list = food;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator<T> it2 = list.iterator();
                        loop2: while (it2.hasNext()) {
                            List<Product> products2 = ((ProductGroup) it2.next()).getProducts();
                            if (!(products2 instanceof Collection) || !products2.isEmpty()) {
                                Iterator<T> it3 = products2.iterator();
                                while (it3.hasNext()) {
                                    if (((Product) it3.next()).getQuantity() > 0) {
                                    }
                                }
                            }
                        }
                    }
                }
                composer2 = startRestartGroup;
                BottomSheetContainerKt.m3398BottomSheetContainer8Un_QVk(null, 0.0f, 0L, new AnnotatedString(StringResources_androidKt.stringResource(R.string.food_add_title, startRestartGroup, 6), null, null, 6, null), null, null, !z5 ? null : dismiss, rememberLazyListState, ComposableLambdaKt.rememberComposableLambda(1128163156, true, new SimpleChangeFoodSharedContentKt$SimpleChangeFoodSharedContent$1(existingBooking, arrayList, viewState, simpleChangeCheckoutState, proceed, viewModel), startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(187780261, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.simpleChange.food.SimpleChangeFoodSharedContentKt$SimpleChangeFoodSharedContent$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                        invoke(columnScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i7) {
                        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                        if ((i7 & 17) == 16 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(187780261, i7, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.food.SimpleChangeFoodSharedContent.<anonymous> (SimpleChangeFoodSharedContent.kt:64)");
                        }
                        SimpleChangeFoodViewModel.ViewState viewState2 = SimpleChangeFoodViewModel.ViewState.this;
                        AddonHelper.AddonState addonState2 = addonState;
                        SimpleChangeFoodViewModel simpleChangeFoodViewModel = viewModel;
                        composer3.startReplaceGroup(-1408801583);
                        boolean changedInstance = composer3.changedInstance(simpleChangeFoodViewModel);
                        Object rememberedValue = composer3.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new SimpleChangeFoodSharedContentKt$SimpleChangeFoodSharedContent$2$1$1(simpleChangeFoodViewModel);
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        composer3.endReplaceGroup();
                        SimpleChangeFoodSharedContentKt.ChangeFoodContent(viewState2, addonState2, (Function2) ((KFunction) rememberedValue), rememberLazyListState, composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), composer2, 905969664, 55);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            z5 = true;
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3398BottomSheetContainer8Un_QVk(null, 0.0f, 0L, new AnnotatedString(StringResources_androidKt.stringResource(R.string.food_add_title, startRestartGroup, 6), null, null, 6, null), null, null, !z5 ? null : dismiss, rememberLazyListState, ComposableLambdaKt.rememberComposableLambda(1128163156, true, new SimpleChangeFoodSharedContentKt$SimpleChangeFoodSharedContent$1(existingBooking, arrayList, viewState, simpleChangeCheckoutState, proceed, viewModel), startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(187780261, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.simpleChange.food.SimpleChangeFoodSharedContentKt$SimpleChangeFoodSharedContent$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i7) {
                    Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                    if ((i7 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(187780261, i7, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.food.SimpleChangeFoodSharedContent.<anonymous> (SimpleChangeFoodSharedContent.kt:64)");
                    }
                    SimpleChangeFoodViewModel.ViewState viewState2 = SimpleChangeFoodViewModel.ViewState.this;
                    AddonHelper.AddonState addonState2 = addonState;
                    SimpleChangeFoodViewModel simpleChangeFoodViewModel = viewModel;
                    composer3.startReplaceGroup(-1408801583);
                    boolean changedInstance = composer3.changedInstance(simpleChangeFoodViewModel);
                    Object rememberedValue = composer3.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new SimpleChangeFoodSharedContentKt$SimpleChangeFoodSharedContent$2$1$1(simpleChangeFoodViewModel);
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    composer3.endReplaceGroup();
                    SimpleChangeFoodSharedContentKt.ChangeFoodContent(viewState2, addonState2, (Function2) ((KFunction) rememberedValue), rememberLazyListState, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, 905969664, 55);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: f3.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit SimpleChangeFoodSharedContent$lambda$5;
                    SimpleChangeFoodSharedContent$lambda$5 = SimpleChangeFoodSharedContentKt.SimpleChangeFoodSharedContent$lambda$5(SimpleChangeFoodViewModel.this, proceed, dismiss, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return SimpleChangeFoodSharedContent$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleChangeFoodSharedContent$lambda$2(SimpleChangeFoodViewModel simpleChangeFoodViewModel, Function0 function0, Function0 function02, int i5, Composer composer, int i6) {
        SimpleChangeFoodSharedContent(simpleChangeFoodViewModel, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleChangeFoodSharedContent$lambda$5(SimpleChangeFoodViewModel simpleChangeFoodViewModel, Function0 function0, Function0 function02, int i5, Composer composer, int i6) {
        SimpleChangeFoodSharedContent(simpleChangeFoodViewModel, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
