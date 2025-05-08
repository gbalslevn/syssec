package dk.molslinjen.ui.views.screens.booking.shared;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.PriceDetails;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.ProductType;
import dk.molslinjen.domain.model.booking.TicketCategory;
import dk.molslinjen.domain.model.booking.TicketSection;
import dk.molslinjen.domain.model.booking.TicketSurcharge;
import dk.molslinjen.domain.model.booking.TransportationCargoInfo;
import dk.molslinjen.domain.model.booking.product.CheckoutSeatReservation;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.extensions.LazyListStateExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.booking.shared.CheckoutDetailsScreenKt;
import dk.molslinjen.ui.views.screens.booking.shared.CheckoutDetailsViewModel;
import dk.molslinjen.ui.views.shared.components.PriceTextKt;
import dk.molslinjen.ui.views.shared.components.PriceViewType;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryViewKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001aM\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u0010H\u0003¢\u0006\u0004\b\u0013\u0010\u0014\u001a+\u0010\u0015\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u0010H\u0003¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0019²\u0006\f\u0010\u0018\u001a\u00020\u00178\nX\u008a\u0084\u0002"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/shared/CheckoutDetailsViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "CheckoutDetailsScreen", "(Ldk/molslinjen/ui/views/screens/booking/shared/CheckoutDetailsViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "checkoutState", "Ldk/molslinjen/ui/views/screens/booking/shared/CheckoutDetailsViewModel$ViewState;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "lazyListState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;", "outboundCheckoutState", "returnCheckoutState", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "changedSelectedDirection", "CheckoutDetailsContent", "(Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;Ldk/molslinjen/ui/views/screens/booking/shared/CheckoutDetailsViewModel$ViewState;Landroidx/compose/foundation/lazy/LazyListState;Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "DirectionTabs", "(Ldk/molslinjen/ui/views/screens/booking/shared/CheckoutDetailsViewModel$ViewState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "hasScrollToEnd", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CheckoutDetailsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void CheckoutDetailsContent(final CheckoutManager.CheckoutState checkoutState, final CheckoutDetailsViewModel.ViewState viewState, final LazyListState lazyListState, final CheckoutManager.CheckoutDirectionState checkoutDirectionState, final CheckoutManager.CheckoutDirectionState checkoutDirectionState2, final Function1<? super DepartureDirection, Unit> function1, Composer composer, final int i5) {
        int i6;
        Modifier.Companion companion;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(438501535);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(checkoutState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(viewState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(lazyListState) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(checkoutDirectionState) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(checkoutDirectionState2) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 131072 : 65536;
        }
        int i7 = i6;
        if ((74899 & i7) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(438501535, i7, -1, "dk.molslinjen.ui.views.screens.booking.shared.CheckoutDetailsContent (CheckoutDetailsScreen.kt:101)");
            }
            float m2599constructorimpl = Dp.m2599constructorimpl(24);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxHeight$default(companion2, 0.0f, 1, null), AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null);
            PaddingValues m310PaddingValuesa9UjIt4$default = PaddingKt.m310PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, m2599constructorimpl, 7, null);
            startRestartGroup.startReplaceGroup(1414087653);
            boolean changedInstance = startRestartGroup.changedInstance(checkoutState) | ((i7 & 112) == 32) | ((458752 & i7) == 131072) | startRestartGroup.changedInstance(checkoutDirectionState2) | startRestartGroup.changedInstance(checkoutDirectionState);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                companion = companion2;
                Function1 function12 = new Function1() { // from class: a3.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit CheckoutDetailsContent$lambda$13$lambda$5$lambda$4;
                        CheckoutDetailsContent$lambda$13$lambda$5$lambda$4 = CheckoutDetailsScreenKt.CheckoutDetailsContent$lambda$13$lambda$5$lambda$4(CheckoutManager.CheckoutState.this, viewState, function1, checkoutDirectionState2, checkoutDirectionState, (LazyListScope) obj);
                        return CheckoutDetailsContent$lambda$13$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(function12);
                rememberedValue = function12;
            } else {
                companion = companion2;
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LazyDslKt.LazyColumn(m104backgroundbw27NRU$default, lazyListState, m310PaddingValuesa9UjIt4$default, false, null, null, null, false, (Function1) rememberedValue, composer2, ((i7 >> 3) & 112) | 390, 248);
            final float m3250dpToPx8Feqmps = ComposeExtensionsKt.m3250dpToPx8Feqmps(m2599constructorimpl, composer2, 6);
            composer2.startReplaceGroup(1414274293);
            Object rememberedValue2 = composer2.rememberedValue();
            Composer.Companion companion5 = Composer.INSTANCE;
            if (rememberedValue2 == companion5.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: a3.m
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean CheckoutDetailsContent$lambda$13$lambda$7$lambda$6;
                        CheckoutDetailsContent$lambda$13$lambda$7$lambda$6 = CheckoutDetailsScreenKt.CheckoutDetailsContent$lambda$13$lambda$7$lambda$6(LazyListState.this, m3250dpToPx8Feqmps);
                        return Boolean.valueOf(CheckoutDetailsContent$lambda$13$lambda$7$lambda$6);
                    }
                });
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer2.endReplaceGroup();
            Modifier align = boxScopeInstance.align(companion, companion3.getBottomCenter());
            boolean CheckoutDetailsContent$lambda$13$lambda$8 = CheckoutDetailsContent$lambda$13$lambda$8((State) rememberedValue2);
            composer2.startReplaceGroup(1414284501);
            Object rememberedValue3 = composer2.rememberedValue();
            if (rememberedValue3 == companion5.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: a3.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        int CheckoutDetailsContent$lambda$13$lambda$10$lambda$9;
                        CheckoutDetailsContent$lambda$13$lambda$10$lambda$9 = CheckoutDetailsScreenKt.CheckoutDetailsContent$lambda$13$lambda$10$lambda$9(((Integer) obj).intValue());
                        return Integer.valueOf(CheckoutDetailsContent$lambda$13$lambda$10$lambda$9);
                    }
                };
                composer2.updateRememberedValue(rememberedValue3);
            }
            composer2.endReplaceGroup();
            EnterTransition slideInVertically$default = EnterExitTransitionKt.slideInVertically$default(null, (Function1) rememberedValue3, 1, null);
            composer2.startReplaceGroup(1414286645);
            Object rememberedValue4 = composer2.rememberedValue();
            if (rememberedValue4 == companion5.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: a3.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        int CheckoutDetailsContent$lambda$13$lambda$12$lambda$11;
                        CheckoutDetailsContent$lambda$13$lambda$12$lambda$11 = CheckoutDetailsScreenKt.CheckoutDetailsContent$lambda$13$lambda$12$lambda$11(((Integer) obj).intValue());
                        return Integer.valueOf(CheckoutDetailsContent$lambda$13$lambda$12$lambda$11);
                    }
                };
                composer2.updateRememberedValue(rememberedValue4);
            }
            composer2.endReplaceGroup();
            AnimatedVisibilityKt.AnimatedVisibility(CheckoutDetailsContent$lambda$13$lambda$8, align, slideInVertically$default, EnterExitTransitionKt.slideOutVertically$default(null, (Function1) rememberedValue4, 1, null), null, ComposableSingletons$CheckoutDetailsScreenKt.INSTANCE.m3466getLambda1$app_kombardoProd(), composer2, 200064, 16);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: a3.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CheckoutDetailsContent$lambda$14;
                    CheckoutDetailsContent$lambda$14 = CheckoutDetailsScreenKt.CheckoutDetailsContent$lambda$14(CheckoutManager.CheckoutState.this, viewState, lazyListState, checkoutDirectionState, checkoutDirectionState2, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CheckoutDetailsContent$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int CheckoutDetailsContent$lambda$13$lambda$10$lambda$9(int i5) {
        return i5 * 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int CheckoutDetailsContent$lambda$13$lambda$12$lambda$11(int i5) {
        return i5 * 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutDetailsContent$lambda$13$lambda$5$lambda$4(final CheckoutManager.CheckoutState checkoutState, final CheckoutDetailsViewModel.ViewState viewState, final Function1 function1, final CheckoutManager.CheckoutDirectionState checkoutDirectionState, final CheckoutManager.CheckoutDirectionState checkoutDirectionState2, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final boolean z5 = checkoutState.getSite() == Site.Fanoe;
        final boolean z6 = checkoutState.getBookingType() == BookingType.TwoWay;
        if (z6 || z5) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-462418604, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.shared.CheckoutDetailsScreenKt$CheckoutDetailsContent$1$1$1$1
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
                        ComposerKt.traceEventStart(-462418604, i5, -1, "dk.molslinjen.ui.views.screens.booking.shared.CheckoutDetailsContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CheckoutDetailsScreen.kt:117)");
                    }
                    CheckoutDetailsScreenKt.DirectionTabs(CheckoutDetailsViewModel.ViewState.this, function1, composer, 0);
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(24)), composer, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
        }
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1713694151, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.shared.CheckoutDetailsScreenKt$CheckoutDetailsContent$1$1$1$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i5) {
                CheckoutManager.CheckoutDirectionState checkoutDirectionState3;
                Intrinsics.checkNotNullParameter(item, "$this$item");
                if ((i5 & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1713694151, i5, -1, "dk.molslinjen.ui.views.screens.booking.shared.CheckoutDetailsContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CheckoutDetailsScreen.kt:123)");
                }
                if (CheckoutDetailsViewModel.ViewState.this.getSelectedDirection() == DepartureDirection.Return) {
                    checkoutDirectionState3 = checkoutDirectionState;
                } else {
                    checkoutDirectionState3 = checkoutDirectionState2;
                }
                CheckoutManager.CheckoutDirectionState checkoutDirectionState4 = checkoutDirectionState3;
                TweenSpec tweenSpec = new TweenSpec(300, 0, EasingKt.getFastOutSlowInEasing());
                final boolean z7 = z5;
                final CheckoutDetailsViewModel.ViewState viewState2 = CheckoutDetailsViewModel.ViewState.this;
                final CheckoutManager.CheckoutState checkoutState2 = checkoutState;
                final boolean z8 = z6;
                CrossfadeKt.Crossfade(checkoutDirectionState4, (Modifier) null, tweenSpec, (String) null, ComposableLambdaKt.rememberComposableLambda(1779392798, true, new Function3<CheckoutManager.CheckoutDirectionState, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.shared.CheckoutDetailsScreenKt$CheckoutDetailsContent$1$1$1$2.1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(CheckoutManager.CheckoutDirectionState checkoutDirectionState5, Composer composer2, Integer num) {
                        invoke(checkoutDirectionState5, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(CheckoutManager.CheckoutDirectionState checkoutDirectionState5, Composer composer2, int i6) {
                        String stringResource;
                        String str;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1779392798, i6, -1, "dk.molslinjen.ui.views.screens.booking.shared.CheckoutDetailsContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CheckoutDetailsScreen.kt:132)");
                        }
                        if (z7 && viewState2.getSelectedDirection() == DepartureDirection.Return) {
                            composer2.startReplaceGroup(-911521692);
                            FanoeReturnInfoViewKt.FanoeReturnInfoViewWithoutBackground(checkoutState2.getCurrency(), composer2, 0);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(-911252767);
                            if (checkoutDirectionState5 == null) {
                                composer2.endReplaceGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            CheckoutManager.CheckoutState checkoutState3 = checkoutState2;
                            CheckoutDetailsViewModel.ViewState viewState3 = viewState2;
                            boolean z9 = z8;
                            Modifier.Companion companion = Modifier.INSTANCE;
                            Arrangement arrangement = Arrangement.INSTANCE;
                            Arrangement.Vertical top = arrangement.getTop();
                            Alignment.Companion companion2 = Alignment.INSTANCE;
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer2, 0);
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, companion);
                            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion3.getConstructor();
                            if (composer2.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor);
                            } else {
                                composer2.useNode();
                            }
                            Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            Departure departure = checkoutDirectionState5.getDeparture();
                            TicketCategory category = checkoutDirectionState5.getDepartureTicket().getCategory();
                            Transportation transportation = checkoutState3.getTransportation();
                            TransportationCargoInfo transportationCargoInfo = checkoutDirectionState5.getTransportationCargoInfo();
                            List<TicketSurcharge> surcharges = checkoutDirectionState5.getDepartureTicket().getSurcharges();
                            PassengerInfo passengerInfo = checkoutDirectionState5.getPassengerInfo();
                            List<Product> addons = checkoutDirectionState5.getAddons();
                            List<Product> food = checkoutDirectionState5.getFood();
                            CheckoutSeatReservation seatReservation = checkoutDirectionState5.getSeatReservation();
                            TrailerProduct trailer = checkoutDirectionState5.getTrailer();
                            List<Product> transportProducts = checkoutDirectionState5.getTransportProducts();
                            PriceDetails priceDetails = (viewState3.getSelectedDirection() != DepartureDirection.Outbound || checkoutState3.getEditingBooking() == null) ? null : checkoutState3.getPriceDetails();
                            PriceTotal totalPrice = checkoutDirectionState5.getTotalPrice();
                            Price price = checkoutDirectionState5.getDepartureTicket().getPrice();
                            TicketSection ticketSection = viewState3.getTicketSection();
                            List<BookingPassenger> passengers = checkoutDirectionState5.getPassengers();
                            boolean askForPersonData = checkoutDirectionState5.getRouteDirectionDetails().getAskForPersonData();
                            List<ProductType> availableProductTypes = checkoutDirectionState5.getDeparture().getAvailableProductTypes();
                            if (!z9) {
                                composer2.startReplaceGroup(-1180025513);
                                composer2.endReplaceGroup();
                                str = null;
                            } else {
                                if (viewState3.getSelectedDirection() == DepartureDirection.Return) {
                                    composer2.startReplaceGroup(1208863802);
                                    stringResource = StringResources_androidKt.stringResource(R.string.ticketInfo_returnPrice, composer2, 6);
                                    composer2.endReplaceGroup();
                                } else {
                                    composer2.startReplaceGroup(1208866908);
                                    stringResource = StringResources_androidKt.stringResource(R.string.ticketInfo_outboundPrice, composer2, 6);
                                    composer2.endReplaceGroup();
                                }
                                str = stringResource;
                            }
                            TicketSummaryViewKt.TicketSummaryView(null, departure, category, transportation, transportationCargoInfo, surcharges, passengerInfo, addons, food, seatReservation, trailer, transportProducts, priceDetails, totalPrice, price, null, false, null, ticketSection, false, passengers, askForPersonData, false, null, null, str, availableProductTypes, checkoutDirectionState5.getRouteDirectionDetails().getSubline(), checkoutState3.getLineLogoUrl(), composer2, 6, 819462144, 0, 29392896);
                            composer2.startReplaceGroup(1208878915);
                            if (z9) {
                                float f5 = 2;
                                float f6 = 16;
                                HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f6), 0.0f, 2, null), 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(f5)), composer2, 3078, 6);
                                float f7 = 8;
                                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f6), 0.0f, 2, null), 0.0f, Dp.m2599constructorimpl(f7), 0.0f, 0.0f, 13, null);
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composer2, 48);
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, m315paddingqDBjuR0$default);
                                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                if (composer2.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor2);
                                } else {
                                    composer2.useNode();
                                }
                                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                                Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), composer2, 0);
                                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.ticketInfo_summedTotalPrice, composer2, 6), PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance.alignByBaseline(companion), 0.0f, 0.0f, Dp.m2599constructorimpl(f7), 0.0f, 11, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 0, 1572864, 65532);
                                PriceTextKt.m3556PriceText1y9Plug(checkoutState3.getPriceDetails().getTotalPrice(), rowScopeInstance.alignByBaseline(companion), PriceViewType.PriceOnly, false, TypographyKt.getH2Bold(), (TextAlign) null, 0, 0L, composer2, 24960, 232);
                                PriceTextKt.m3556PriceText1y9Plug(checkoutState3.getPriceDetails().getTotalPrice(), PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance.alignByBaseline(companion), Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), PriceViewType.CurrencyOnly, false, TypographyKt.getSub(), (TextAlign) null, 0, 0L, composer2, 24960, 232);
                                composer2.endNode();
                            }
                            composer2.endReplaceGroup();
                            composer2.endNode();
                            composer2.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer, 54), composer, 24576, 10);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CheckoutDetailsContent$lambda$13$lambda$7$lambda$6(LazyListState lazyListState, float f5) {
        return !LazyListStateExtensionsKt.isScrolledToTheEnd(lazyListState, f5);
    }

    private static final boolean CheckoutDetailsContent$lambda$13$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutDetailsContent$lambda$14(CheckoutManager.CheckoutState checkoutState, CheckoutDetailsViewModel.ViewState viewState, LazyListState lazyListState, CheckoutManager.CheckoutDirectionState checkoutDirectionState, CheckoutManager.CheckoutDirectionState checkoutDirectionState2, Function1 function1, int i5, Composer composer, int i6) {
        CheckoutDetailsContent(checkoutState, viewState, lazyListState, checkoutDirectionState, checkoutDirectionState2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void CheckoutDetailsScreen(final CheckoutDetailsViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-752953455);
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
                ComposerKt.traceEventStart(-752953455, i6, -1, "dk.molslinjen.ui.views.screens.booking.shared.CheckoutDetailsScreen (CheckoutDetailsScreen.kt:70)");
            }
            final LazyListState lazyListState = new LazyListState(0, 0, 3, null);
            final CheckoutManager.CheckoutState checkoutState = (CheckoutManager.CheckoutState) SnapshotStateKt.collectAsState(viewModel.getCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            if (checkoutState == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: a3.i
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit CheckoutDetailsScreen$lambda$0;
                            CheckoutDetailsScreen$lambda$0 = CheckoutDetailsScreenKt.CheckoutDetailsScreen$lambda$0(CheckoutDetailsViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return CheckoutDetailsScreen$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            final CheckoutManager.CheckoutDirectionState checkoutDirectionState = (CheckoutManager.CheckoutDirectionState) SnapshotStateKt.collectAsState(viewModel.getOutboundCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            if (checkoutDirectionState == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
                if (endRestartGroup2 != null) {
                    endRestartGroup2.updateScope(new Function2() { // from class: a3.j
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit CheckoutDetailsScreen$lambda$1;
                            CheckoutDetailsScreen$lambda$1 = CheckoutDetailsScreenKt.CheckoutDetailsScreen$lambda$1(CheckoutDetailsViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return CheckoutDetailsScreen$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            final CheckoutManager.CheckoutDirectionState checkoutDirectionState2 = (CheckoutManager.CheckoutDirectionState) SnapshotStateKt.collectAsState(viewModel.getReturnCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            final CheckoutDetailsViewModel.ViewState viewState = (CheckoutDetailsViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            String stringResource = StringResources_androidKt.stringResource(R.string.checkout_details_title, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(494499632);
            boolean z5 = (i6 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new CheckoutDetailsScreenKt$CheckoutDetailsScreen$1$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(null, 0.0f, stringResource, null, 0L, null, (Function0) rememberedValue, lazyListState, null, ComposableLambdaKt.rememberComposableLambda(1057304868, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.shared.CheckoutDetailsScreenKt$CheckoutDetailsScreen$2
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
                        ComposerKt.traceEventStart(1057304868, i7, -1, "dk.molslinjen.ui.views.screens.booking.shared.CheckoutDetailsScreen.<anonymous> (CheckoutDetailsScreen.kt:82)");
                    }
                    CheckoutDetailsViewModel checkoutDetailsViewModel = CheckoutDetailsViewModel.this;
                    composer3.startReplaceGroup(440818075);
                    boolean changedInstance = composer3.changedInstance(checkoutDetailsViewModel);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new CheckoutDetailsScreenKt$CheckoutDetailsScreen$2$1$1(checkoutDetailsViewModel);
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceGroup();
                    CheckoutDetailsScreenKt.CheckoutDetailsContent(checkoutState, viewState, lazyListState, checkoutDirectionState, checkoutDirectionState2, (Function1) ((KFunction) rememberedValue2), composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, 805306368, 315);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup3 = composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            endRestartGroup3.updateScope(new Function2() { // from class: a3.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CheckoutDetailsScreen$lambda$3;
                    CheckoutDetailsScreen$lambda$3 = CheckoutDetailsScreenKt.CheckoutDetailsScreen$lambda$3(CheckoutDetailsViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CheckoutDetailsScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutDetailsScreen$lambda$0(CheckoutDetailsViewModel checkoutDetailsViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        CheckoutDetailsScreen(checkoutDetailsViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutDetailsScreen$lambda$1(CheckoutDetailsViewModel checkoutDetailsViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        CheckoutDetailsScreen(checkoutDetailsViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutDetailsScreen$lambda$3(CheckoutDetailsViewModel checkoutDetailsViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        CheckoutDetailsScreen(checkoutDetailsViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DirectionTabs(final CheckoutDetailsViewModel.ViewState viewState, final Function1<? super DepartureDirection, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-625326675);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-625326675, i6, -1, "dk.molslinjen.ui.views.screens.booking.shared.DirectionTabs (CheckoutDetailsScreen.kt:237)");
            }
            CrossfadeKt.Crossfade(viewState.getSelectedDirection(), (Modifier) null, new TweenSpec(300, 0, EasingKt.getFastOutSlowInEasing()), (String) null, ComposableLambdaKt.rememberComposableLambda(930891797, true, new CheckoutDetailsScreenKt$DirectionTabs$1(function1), startRestartGroup, 54), startRestartGroup, 24576, 10);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: a3.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DirectionTabs$lambda$15;
                    DirectionTabs$lambda$15 = CheckoutDetailsScreenKt.DirectionTabs$lambda$15(CheckoutDetailsViewModel.ViewState.this, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DirectionTabs$lambda$15;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DirectionTabs$lambda$15(CheckoutDetailsViewModel.ViewState viewState, Function1 function1, int i5, Composer composer, int i6) {
        DirectionTabs(viewState, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
