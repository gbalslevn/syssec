package dk.molslinjen.ui.views.screens.saleOnBoard;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardDepartureSelectorScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardFoodListScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardOrderDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardOrderHistoryScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager;
import dk.molslinjen.domain.managers.ticket.TicketsManager;
import dk.molslinjen.domain.model.booking.BookingHeader;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.extensions.ColorExtensionsKt;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardScreenKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001ac\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u000eH\u0003¢\u0006\u0004\b\u0013\u0010\u0014\u001a-\u0010\u0018\u001a\u00020\u0004*\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00162\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0004\b\u0018\u0010\u0019\u001a?\u0010\u001d\u001a\u00020\u0004*\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0013\u0010\u001f\u001a\u00020\u0004*\u00020\u0015H\u0002¢\u0006\u0004\b\u001f\u0010 \u001a!\u0010!\u001a\u00020\u0004*\u00020\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0002¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Ldk/molslinjen/ui/views/screens/saleOnBoard/SaleOnBoardViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "SaleOnBoardScreen", "(Ldk/molslinjen/ui/views/screens/saleOnBoard/SaleOnBoardViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardManager$SaleOnBoardState;", "saleOnBoardState", "Ldk/molslinjen/domain/managers/ticket/TicketsManager$TicketsState;", "ticketsState", "Lkotlin/Function0;", "orderFood", "showHistory", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "orderFoodWithDepartureSelected", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "showOrderDetails", "SaleOnBoardContent", "(Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardManager$SaleOnBoardState;Ldk/molslinjen/domain/managers/ticket/TicketsManager$TicketsState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/lazy/LazyListScope;", "Ldk/molslinjen/domain/model/booking/BookingHeader;", "bookingHeader", "nextDepartureTicket", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/domain/model/booking/BookingHeader;Lkotlin/jvm/functions/Function1;)V", BuildConfig.FLAVOR, "hasDepartureTickets", "hasSaleOnBoardOrders", "buttonsBar", "(Landroidx/compose/foundation/lazy/LazyListScope;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "headerItem", "(Landroidx/compose/foundation/lazy/LazyListScope;)V", "empty", "(Landroidx/compose/foundation/lazy/LazyListScope;Lkotlin/jvm/functions/Function0;)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SaleOnBoardScreenKt {
    private static final void SaleOnBoardContent(final SaleOnBoardManager.SaleOnBoardState saleOnBoardState, final TicketsManager.TicketsState ticketsState, final Function0<Unit> function0, final Function0<Unit> function02, final Function1<? super IDepartureInfo, Unit> function1, final Function1<? super SaleOnBoardOrder, Unit> function12, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer composer3;
        Composer startRestartGroup = composer.startRestartGroup(-1833785695);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(saleOnBoardState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(ticketsState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer3 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1833785695, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardContent (SaleOnBoardScreen.kt:122)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            AppColor appColor = AppColor.INSTANCE;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(fillMaxSize$default, appColor.m3269getGrey60d7_KjU(), null, 2, null);
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
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            float f5 = 370;
            ImageKt.Image(PainterResources_androidKt.painterResource(2131165439, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m325height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m2599constructorimpl(f5)), null, ContentScale.INSTANCE.getCrop(), 0.0f, null, startRestartGroup, 24960, 104);
            BoxKt.Box(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.m325height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m2599constructorimpl(f5)), ColorExtensionsKt.m3249withAlphaDxMtmZc(appColor.m3253getBrandBlack10d7_KjU(), 0.2f), null, 2, null), startRestartGroup, 0);
            BoxKt.Box(boxScopeInstance.align(BackgroundKt.background$default(SizeKt.fillMaxWidth$default(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(112)), 0.0f, 1, null), Brush.Companion.m1466verticalGradient8A3gB4$default(Brush.INSTANCE, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.m1481boximpl(ColorKt.Color(16054781))), TuplesKt.to(Float.valueOf(1.0f), Color.m1481boximpl(ColorKt.Color(4294244861L)))}, 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), companion2.getBottomCenter()), startRestartGroup, 0);
            startRestartGroup.endNode();
            Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            float f6 = 16;
            PaddingValues m310PaddingValuesa9UjIt4$default = PaddingKt.m310PaddingValuesa9UjIt4$default(Dp.m2599constructorimpl(f6), 0.0f, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(44), 2, null);
            startRestartGroup.startReplaceGroup(-1714741850);
            boolean changedInstance = startRestartGroup.changedInstance(ticketsState) | startRestartGroup.changedInstance(saleOnBoardState) | ((i6 & 896) == 256) | ((458752 & i6) == 131072) | ((57344 & i6) == 16384) | ((i6 & 7168) == 2048);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                composer2 = startRestartGroup;
                Function1 function13 = new Function1() { // from class: e4.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SaleOnBoardContent$lambda$17$lambda$16$lambda$15;
                        SaleOnBoardContent$lambda$17$lambda$16$lambda$15 = SaleOnBoardScreenKt.SaleOnBoardContent$lambda$17$lambda$16$lambda$15(TicketsManager.TicketsState.this, saleOnBoardState, function0, function1, function02, function12, (LazyListScope) obj);
                        return SaleOnBoardContent$lambda$17$lambda$16$lambda$15;
                    }
                };
                composer2.updateRememberedValue(function13);
                rememberedValue = function13;
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceGroup();
            composer3 = composer2;
            LazyDslKt.LazyColumn(fillMaxSize$default2, null, m310PaddingValuesa9UjIt4$default, false, null, null, null, false, (Function1) rememberedValue, composer3, 6, 250);
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: e4.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardContent$lambda$18;
                    SaleOnBoardContent$lambda$18 = SaleOnBoardScreenKt.SaleOnBoardContent$lambda$18(SaleOnBoardManager.SaleOnBoardState.this, ticketsState, function0, function02, function1, function12, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardContent$lambda$18;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardContent$lambda$17$lambda$16$lambda$15(TicketsManager.TicketsState ticketsState, SaleOnBoardManager.SaleOnBoardState saleOnBoardState, Function0 function0, Function1 function1, Function0 function02, final Function1 function12, LazyListScope LazyColumn) {
        boolean z5;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        List<BookingHeader> bookings = ticketsState.getBookings();
        int i5 = 0;
        if (!(bookings instanceof Collection) || !bookings.isEmpty()) {
            for (BookingHeader bookingHeader : bookings) {
                if (bookingHeader.getSite() == Site.Mols && bookingHeader.isActive()) {
                    z5 = true;
                    break;
                }
            }
        }
        z5 = false;
        List<SaleOnBoardOrder> orders = saleOnBoardState.getOrders();
        ArrayList<SaleOnBoardOrder> arrayList = new ArrayList();
        for (Object obj : orders) {
            if (((SaleOnBoardOrder) obj).isActive()) {
                arrayList.add(obj);
            }
        }
        boolean isEmpty = arrayList.isEmpty();
        boolean z6 = !isEmpty;
        headerItem(LazyColumn);
        if (!z5 && isEmpty) {
            empty(LazyColumn, function0);
        }
        final int i6 = 0;
        for (final SaleOnBoardOrder saleOnBoardOrder : arrayList) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(2136426704, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardScreenKt$SaleOnBoardContent$1$2$1$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                    invoke(lazyItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope item, Composer composer, int i7) {
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    if ((i7 & 17) == 16 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-472224211, i7, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SaleOnBoardScreen.kt:171)");
                    }
                    composer.startReplaceGroup(-948350672);
                    if (i6 > 0) {
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(16)), composer, 6);
                    }
                    composer.endReplaceGroup();
                    SaleOnBoardActiveOrderRowKt.SaleOnBoardActiveOrderRow(saleOnBoardOrder, function12, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
            i6++;
        }
        if (z5 && !isEmpty) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$SaleOnBoardScreenKt.INSTANCE.m3520getLambda1$app_kombardoProd(), 3, null);
        }
        List<BookingHeader> bookings2 = ticketsState.getBookings();
        ArrayList<BookingHeader> arrayList2 = new ArrayList();
        for (Object obj2 : bookings2) {
            BookingHeader bookingHeader2 = (BookingHeader) obj2;
            if (bookingHeader2.getSite() == Site.Mols && bookingHeader2.isActive()) {
                arrayList2.add(obj2);
            }
        }
        for (BookingHeader bookingHeader3 : arrayList2) {
            int i7 = i5 + 1;
            if (i5 > 0) {
                LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$SaleOnBoardScreenKt.INSTANCE.m3521getLambda2$app_kombardoProd(), 3, null);
            }
            nextDepartureTicket(LazyColumn, bookingHeader3, function1);
            i5 = i7;
        }
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$SaleOnBoardScreenKt.INSTANCE.m3522getLambda3$app_kombardoProd(), 3, null);
        buttonsBar(LazyColumn, z5, z6, function0, function02);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardContent$lambda$18(SaleOnBoardManager.SaleOnBoardState saleOnBoardState, TicketsManager.TicketsState ticketsState, Function0 function0, Function0 function02, Function1 function1, Function1 function12, int i5, Composer composer, int i6) {
        SaleOnBoardContent(saleOnBoardState, ticketsState, function0, function02, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void SaleOnBoardScreen(final SaleOnBoardViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-899959041);
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
                ComposerKt.traceEventStart(-899959041, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardScreen (SaleOnBoardScreen.kt:80)");
            }
            SaleOnBoardManager.SaleOnBoardState saleOnBoardState = (SaleOnBoardManager.SaleOnBoardState) SnapshotStateKt.collectAsState(viewModel.getSaleOnBoardState(), null, startRestartGroup, 0, 1).getValue();
            TicketsManager.TicketsState ticketsState = (TicketsManager.TicketsState) SnapshotStateKt.collectAsState(viewModel.getTicketsState(), null, startRestartGroup, 0, 1).getValue();
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(1336376575);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new SaleOnBoardScreenKt$SaleOnBoardScreen$1$1(viewModel, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(1336383922);
            int i7 = i6 & 112;
            boolean z5 = i7 == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: e4.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SaleOnBoardScreen$lambda$2$lambda$1;
                        SaleOnBoardScreen$lambda$2$lambda$1 = SaleOnBoardScreenKt.SaleOnBoardScreen$lambda$2$lambda$1(DestinationsNavigator.this);
                        return SaleOnBoardScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function0 function0 = (Function0) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1336395981);
            boolean z6 = i7 == 32;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: e4.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SaleOnBoardScreen$lambda$4$lambda$3;
                        SaleOnBoardScreen$lambda$4$lambda$3 = SaleOnBoardScreenKt.SaleOnBoardScreen$lambda$4$lambda$3(DestinationsNavigator.this);
                        return SaleOnBoardScreen$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            Function0 function02 = (Function0) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1336388278);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel) | (i7 == 32);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: e4.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SaleOnBoardScreen$lambda$7$lambda$6;
                        SaleOnBoardScreen$lambda$7$lambda$6 = SaleOnBoardScreenKt.SaleOnBoardScreen$lambda$7$lambda$6(SaleOnBoardViewModel.this, navigator, (IDepartureInfo) obj);
                        return SaleOnBoardScreen$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            Function1 function1 = (Function1) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1336399639);
            boolean z7 = i7 == 32;
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: e4.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SaleOnBoardScreen$lambda$9$lambda$8;
                        SaleOnBoardScreen$lambda$9$lambda$8 = SaleOnBoardScreenKt.SaleOnBoardScreen$lambda$9$lambda$8(DestinationsNavigator.this, (SaleOnBoardOrder) obj);
                        return SaleOnBoardScreen$lambda$9$lambda$8;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            SaleOnBoardContent(saleOnBoardState, ticketsState, function0, function02, function1, (Function1) rememberedValue5, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: e4.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardScreen$lambda$10;
                    SaleOnBoardScreen$lambda$10 = SaleOnBoardScreenKt.SaleOnBoardScreen$lambda$10(SaleOnBoardViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardScreen$lambda$10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardScreen$lambda$10(SaleOnBoardViewModel saleOnBoardViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        SaleOnBoardScreen(saleOnBoardViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardScreen$lambda$2$lambda$1(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SaleOnBoardDepartureSelectorScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardScreen$lambda$4$lambda$3(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SaleOnBoardOrderHistoryScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardScreen$lambda$7$lambda$6(SaleOnBoardViewModel saleOnBoardViewModel, final DestinationsNavigator destinationsNavigator, IDepartureInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        saleOnBoardViewModel.departureSelected(it, new Function0() { // from class: e4.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit SaleOnBoardScreen$lambda$7$lambda$6$lambda$5;
                SaleOnBoardScreen$lambda$7$lambda$6$lambda$5 = SaleOnBoardScreenKt.SaleOnBoardScreen$lambda$7$lambda$6$lambda$5(DestinationsNavigator.this);
                return SaleOnBoardScreen$lambda$7$lambda$6$lambda$5;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardScreen$lambda$7$lambda$6$lambda$5(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SaleOnBoardFoodListScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardScreen$lambda$9$lambda$8(DestinationsNavigator destinationsNavigator, SaleOnBoardOrder order) {
        Intrinsics.checkNotNullParameter(order, "order");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SaleOnBoardOrderDetailsScreenDestination.INSTANCE.invoke(order.getOrderNumber()), null, null, 6, null);
        return Unit.INSTANCE;
    }

    private static final void buttonsBar(LazyListScope lazyListScope, final boolean z5, final boolean z6, final Function0<Unit> function0, final Function0<Unit> function02) {
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-1067417846, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardScreenKt$buttonsBar$1

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            /* renamed from: dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardScreenKt$buttonsBar$1$1, reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass1 implements Function3<FlowRowScope, Composer, Integer, Unit> {
                final /* synthetic */ boolean $hasDepartureTickets;
                final /* synthetic */ boolean $hasSaleOnBoardOrders;
                final /* synthetic */ Function0<Unit> $orderFood;
                final /* synthetic */ Function0<Unit> $showHistory;

                AnonymousClass1(boolean z5, boolean z6, Function0<Unit> function0, Function0<Unit> function02) {
                    this.$hasDepartureTickets = z5;
                    this.$hasSaleOnBoardOrders = z6;
                    this.$orderFood = function0;
                    this.$showHistory = function02;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit invoke$lambda$1$lambda$0(Function0 function0) {
                    function0.invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit invoke$lambda$3$lambda$2(Function0 function0) {
                    function0.invoke();
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(FlowRowScope flowRowScope, Composer composer, Integer num) {
                    invoke(flowRowScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(FlowRowScope FlowRow, Composer composer, int i5) {
                    Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
                    if ((i5 & 17) == 16 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(791907013, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.buttonsBar.<anonymous>.<anonymous> (SaleOnBoardScreen.kt:283)");
                    }
                    composer.startReplaceGroup(919966106);
                    if (this.$hasDepartureTickets || this.$hasSaleOnBoardOrders) {
                        Modifier.Companion companion = Modifier.INSTANCE;
                        composer.startReplaceGroup(919970130);
                        boolean changed = composer.changed(this.$orderFood);
                        final Function0<Unit> function0 = this.$orderFood;
                        Object rememberedValue = composer.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005e: CONSTRUCTOR (r4v3 'rememberedValue' java.lang.Object) = (r3v3 'function0' kotlin.jvm.functions.Function0<kotlin.Unit> A[DONT_INLINE]) A[MD:(kotlin.jvm.functions.Function0):void (m)] (LINE:9) call: dk.molslinjen.ui.views.screens.saleOnBoard.f.<init>(kotlin.jvm.functions.Function0):void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardScreenKt$buttonsBar$1.1.invoke(androidx.compose.foundation.layout.FlowRowScope, androidx.compose.runtime.Composer, int):void, file: classes2.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.saleOnBoard.f, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 31 more
                                */
                            /*
                                Method dump skipped, instructions count: 365
                                To view this dump add '--comments-level debug' option
                            */
                            throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardScreenKt$buttonsBar$1.AnonymousClass1.invoke(androidx.compose.foundation.layout.FlowRowScope, androidx.compose.runtime.Composer, int):void");
                        }
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
                            ComposerKt.traceEventStart(-1067417846, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.buttonsBar.<anonymous> (SaleOnBoardScreen.kt:277)");
                        }
                        FlowLayoutKt.FlowRow(IntrinsicKt.height(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), IntrinsicSize.Min), Arrangement.INSTANCE.getCenter(), null, 0, 0, null, ComposableLambdaKt.rememberComposableLambda(791907013, true, new AnonymousClass1(z5, z6, function0, function02), composer, 54), composer, 1572918, 60);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), 3, null);
            }

            private static final void empty(LazyListScope lazyListScope, final Function0<Unit> function0) {
                LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(119300783, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardScreenKt$empty$1
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
                            ComposerKt.traceEventStart(119300783, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.empty.<anonymous> (SaleOnBoardScreen.kt:347)");
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        Modifier defaultShadow = ModifierExtensionsKt.defaultShadow(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), ThemeShapesKt.getThemeShapes().getMedium());
                        float m2599constructorimpl = Dp.m2599constructorimpl(1);
                        AppColor appColor = AppColor.INSTANCE;
                        float f5 = 16;
                        Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BackgroundKt.m104backgroundbw27NRU$default(BorderKt.m108borderxT4_qwU(defaultShadow, m2599constructorimpl, appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), appColor.m3281getWhite0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(32));
                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                        Function0<Unit> function02 = function0;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer, 48);
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m312paddingVpY3zN4);
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
                        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_sale_on_board_food, composer, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(48)), Color.INSTANCE.m1501getUnspecified0d7_KjU(), composer, 3456, 0);
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer, 6);
                        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.saleOnBoard_noCurrentDepartureTickets, composer, 6), null, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer, 384, 1572864, 65018);
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(24)), composer, 6);
                        PrimaryButtonKt.PrimaryButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), StringResources_androidKt.stringResource(R.string.saleOnBoard_orderFood, composer, 6), function02, null, null, false, false, false, composer, 6, 248);
                        composer.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), 3, null);
            }

            private static final void headerItem(LazyListScope lazyListScope) {
                LazyListScope.item$default(lazyListScope, null, null, ComposableSingletons$SaleOnBoardScreenKt.INSTANCE.m3523getLambda4$app_kombardoProd(), 3, null);
            }

            public static final void nextDepartureTicket(LazyListScope lazyListScope, BookingHeader bookingHeader, Function1<? super IDepartureInfo, Unit> orderFood) {
                Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
                Intrinsics.checkNotNullParameter(bookingHeader, "bookingHeader");
                Intrinsics.checkNotNullParameter(orderFood, "orderFood");
                LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(1419067530, true, new SaleOnBoardScreenKt$nextDepartureTicket$1(bookingHeader, orderFood)), 3, null);
            }
        }
