package dk.molslinjen.ui.views.screens.saleOnBoard.orderHistory;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardOrderDetailsScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardActiveOrderRowKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.orderHistory.SaleOnBoardOrderHistoryScreenKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.orderHistory.SaleOnBoardOrderHistoryViewModel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a+\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tH\u0003¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u000f\u001a\u00020\u0004*\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/ui/views/screens/saleOnBoard/orderHistory/SaleOnBoardOrderHistoryViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "SaleOnBoardOrderHistoryScreen", "(Ldk/molslinjen/ui/views/screens/saleOnBoard/orderHistory/SaleOnBoardOrderHistoryViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardManager$SaleOnBoardState;", "state", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "showOrderDetails", "SaleOnBoardOrderHistoryContent", "(Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardManager$SaleOnBoardState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/lazy/LazyListScope;", "empty", "(Landroidx/compose/foundation/lazy/LazyListScope;)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SaleOnBoardOrderHistoryScreenKt {
    private static final void SaleOnBoardOrderHistoryContent(final SaleOnBoardManager.SaleOnBoardState saleOnBoardState, final Function1<? super SaleOnBoardOrder, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1797826328);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(saleOnBoardState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1797826328, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.orderHistory.SaleOnBoardOrderHistoryContent (SaleOnBoardOrderHistoryScreen.kt:56)");
            }
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null);
            float f5 = 16;
            PaddingValues m309PaddingValuesa9UjIt4 = PaddingKt.m309PaddingValuesa9UjIt4(Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(32), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(40));
            startRestartGroup.startReplaceGroup(1105274843);
            boolean changedInstance = startRestartGroup.changedInstance(saleOnBoardState) | ((i6 & 112) == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: i4.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SaleOnBoardOrderHistoryContent$lambda$6$lambda$5;
                        SaleOnBoardOrderHistoryContent$lambda$6$lambda$5 = SaleOnBoardOrderHistoryScreenKt.SaleOnBoardOrderHistoryContent$lambda$6$lambda$5(SaleOnBoardManager.SaleOnBoardState.this, function1, (LazyListScope) obj);
                        return SaleOnBoardOrderHistoryContent$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LazyDslKt.LazyColumn(m104backgroundbw27NRU$default, null, m309PaddingValuesa9UjIt4, false, null, null, null, false, (Function1) rememberedValue, startRestartGroup, 6, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: i4.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardOrderHistoryContent$lambda$7;
                    SaleOnBoardOrderHistoryContent$lambda$7 = SaleOnBoardOrderHistoryScreenKt.SaleOnBoardOrderHistoryContent$lambda$7(SaleOnBoardManager.SaleOnBoardState.this, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardOrderHistoryContent$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardOrderHistoryContent$lambda$6$lambda$5(SaleOnBoardManager.SaleOnBoardState saleOnBoardState, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        List<SaleOnBoardOrder> orders = saleOnBoardState.getOrders();
        ArrayList arrayList = new ArrayList();
        for (Object obj : orders) {
            if (!((SaleOnBoardOrder) obj).isActive()) {
                arrayList.add(obj);
            }
        }
        List<SaleOnBoardOrder> sortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.orderHistory.SaleOnBoardOrderHistoryScreenKt$SaleOnBoardOrderHistoryContent$lambda$6$lambda$5$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                return ComparisonsKt.compareValues(((SaleOnBoardOrder) t6).getStartDateTime(), ((SaleOnBoardOrder) t5).getStartDateTime());
            }
        });
        if (sortedWith.isEmpty()) {
            empty(LazyColumn);
        }
        final int i5 = 0;
        for (final SaleOnBoardOrder saleOnBoardOrder : sortedWith) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1153029837, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.orderHistory.SaleOnBoardOrderHistoryScreenKt$SaleOnBoardOrderHistoryContent$1$1$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                    invoke(lazyItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope item, Composer composer, int i6) {
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    if ((i6 & 17) == 16 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2067800944, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.orderHistory.SaleOnBoardOrderHistoryContent.<anonymous>.<anonymous>.<anonymous> (SaleOnBoardOrderHistoryScreen.kt:70)");
                    }
                    composer.startReplaceGroup(1396614213);
                    if (i5 > 0) {
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(16)), composer, 6);
                    }
                    composer.endReplaceGroup();
                    SaleOnBoardActiveOrderRowKt.SaleOnBoardActiveOrderRow(saleOnBoardOrder, function1, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
            i5++;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardOrderHistoryContent$lambda$7(SaleOnBoardManager.SaleOnBoardState saleOnBoardState, Function1 function1, int i5, Composer composer, int i6) {
        SaleOnBoardOrderHistoryContent(saleOnBoardState, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void SaleOnBoardOrderHistoryScreen(final SaleOnBoardOrderHistoryViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(1287022005);
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
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1287022005, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.orderHistory.SaleOnBoardOrderHistoryScreen (SaleOnBoardOrderHistoryScreen.kt:44)");
            }
            SaleOnBoardManager.SaleOnBoardState saleOnBoardState = (SaleOnBoardManager.SaleOnBoardState) SnapshotStateKt.collectAsState(viewModel.getSaleOnBoardState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(1438364955);
            boolean z5 = (i6 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: i4.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SaleOnBoardOrderHistoryScreen$lambda$1$lambda$0;
                        SaleOnBoardOrderHistoryScreen$lambda$1$lambda$0 = SaleOnBoardOrderHistoryScreenKt.SaleOnBoardOrderHistoryScreen$lambda$1$lambda$0(DestinationsNavigator.this, (SaleOnBoardOrder) obj);
                        return SaleOnBoardOrderHistoryScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            SaleOnBoardOrderHistoryContent(saleOnBoardState, (Function1) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: i4.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardOrderHistoryScreen$lambda$2;
                    SaleOnBoardOrderHistoryScreen$lambda$2 = SaleOnBoardOrderHistoryScreenKt.SaleOnBoardOrderHistoryScreen$lambda$2(SaleOnBoardOrderHistoryViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardOrderHistoryScreen$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardOrderHistoryScreen$lambda$1$lambda$0(DestinationsNavigator destinationsNavigator, SaleOnBoardOrder order) {
        Intrinsics.checkNotNullParameter(order, "order");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SaleOnBoardOrderDetailsScreenDestination.INSTANCE.invoke(order.getOrderNumber()), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardOrderHistoryScreen$lambda$2(SaleOnBoardOrderHistoryViewModel saleOnBoardOrderHistoryViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        SaleOnBoardOrderHistoryScreen(saleOnBoardOrderHistoryViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void empty(LazyListScope lazyListScope) {
        LazyListScope.item$default(lazyListScope, null, null, ComposableSingletons$SaleOnBoardOrderHistoryScreenKt.INSTANCE.m3534getLambda1$app_kombardoProd(), 3, null);
    }
}
