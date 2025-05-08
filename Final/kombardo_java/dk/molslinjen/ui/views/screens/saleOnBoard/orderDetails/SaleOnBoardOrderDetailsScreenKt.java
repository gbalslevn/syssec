package dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
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
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.extensions.ColorExtensionsKt;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.extensions.domain.SaleOnBoardOrderExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HighlightedTextKt;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsScreenKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001aU\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0003¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\nH\u0003¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/ui/views/screens/saleOnBoard/orderDetails/SaleOnBoardOrderDetailsViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "SaleOnBoardOrderDetailsScreen", "(Ldk/molslinjen/ui/views/screens/saleOnBoard/orderDetails/SaleOnBoardOrderDetailsViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/saleOnBoard/orderDetails/SaleOnBoardOrderDetailsViewModel$ViewState;", "state", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "cancelOrder", "Lkotlin/Function0;", "showCancelOrderDisabledMessage", "startCancelOrder", "stopCancelOrder", "SaleOnBoardOrderDetailsContent", "(Ldk/molslinjen/ui/views/screens/saleOnBoard/orderDetails/SaleOnBoardOrderDetailsViewModel$ViewState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "order", "HeadlineStatus", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;Landroidx/compose/runtime/Composer;I)V", "Landroid/content/Context;", "context", "StatusProgressBar", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;Landroid/content/Context;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/unit/Dp;", "dp", "abs-0680j_4", "(F)F", "abs", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SaleOnBoardOrderDetailsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void HeadlineStatus(final SaleOnBoardOrder saleOnBoardOrder, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-984588805);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(saleOnBoardOrder) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-984588805, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.HeadlineStatus (SaleOnBoardOrderDetailsScreen.kt:173)");
            }
            final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i7 = i6;
            TextKt.m940Text4IGK_g(SaleOnBoardOrderExtensionsKt.getStatusLongTitle(saleOnBoardOrder, context), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(24), 0.0f, Dp.m2599constructorimpl(8), 5, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH2Bold(), startRestartGroup, 48, 1572864, 65532);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.saleOnBoard_receipt_orderNumber, new Object[]{saleOnBoardOrder.getOrderNumber()}, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(16), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 48, 1572864, 65532);
            if (saleOnBoardOrder.isActive()) {
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(-1151469923);
                StatusProgressBar(saleOnBoardOrder, context, composer2, i7 & 14);
                composer2.endReplaceGroup();
            } else {
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(-1151393756);
                long statusColor = SaleOnBoardOrderExtensionsKt.getStatusColor(saleOnBoardOrder);
                HighlightedTextKt.m3387HighlightedTextRuGn9fw(null, false, statusColor, Color.m1481boximpl(ColorExtensionsKt.m3249withAlphaDxMtmZc(statusColor, 0.4f)), null, ComposableLambdaKt.rememberComposableLambda(1127696145, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsScreenKt$HeadlineStatus$1$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i8) {
                        if ((i8 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1127696145, i8, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.HeadlineStatus.<anonymous>.<anonymous> (SaleOnBoardOrderDetailsScreen.kt:199)");
                        }
                        TextKt.m940Text4IGK_g(SaleOnBoardOrderExtensionsKt.getStatusMediumTitle(SaleOnBoardOrder.this, context), null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2533getStarte0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer3, 0, 1572864, 65022);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, 196608, 19);
                composer2.endReplaceGroup();
            }
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h4.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit HeadlineStatus$lambda$7;
                    HeadlineStatus$lambda$7 = SaleOnBoardOrderDetailsScreenKt.HeadlineStatus$lambda$7(SaleOnBoardOrder.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return HeadlineStatus$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeadlineStatus$lambda$7(SaleOnBoardOrder saleOnBoardOrder, int i5, Composer composer, int i6) {
        HeadlineStatus(saleOnBoardOrder, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SaleOnBoardOrderDetailsContent(final SaleOnBoardOrderDetailsViewModel.ViewState viewState, final Function1<? super SaleOnBoardOrder, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1506850805);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function03) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1506850805, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsContent (SaleOnBoardOrderDetailsScreen.kt:116)");
            }
            ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
            SaleOnBoardOrder order = viewState.getOrder();
            SaleOnBoardOrder.OrderStatus status = order != null ? order.getStatus() : null;
            startRestartGroup.startReplaceGroup(-148476619);
            boolean changedInstance = startRestartGroup.changedInstance(viewState) | startRestartGroup.changed(rememberScrollState);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsContent$1$1(viewState, rememberScrollState, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(status, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 0);
            composer2 = startRestartGroup;
            LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, viewState.getIsLoading(), 0, false, null, ComposableLambdaKt.rememberComposableLambda(998197289, true, new SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsContent$2(viewState, rememberScrollState, function1, function03, function02, function0), startRestartGroup, 54), composer2, 1572864, 59);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h4.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardOrderDetailsContent$lambda$5;
                    SaleOnBoardOrderDetailsContent$lambda$5 = SaleOnBoardOrderDetailsScreenKt.SaleOnBoardOrderDetailsContent$lambda$5(SaleOnBoardOrderDetailsViewModel.ViewState.this, function1, function0, function02, function03, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardOrderDetailsContent$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardOrderDetailsContent$lambda$5(SaleOnBoardOrderDetailsViewModel.ViewState viewState, Function1 function1, Function0 function0, Function0 function02, Function0 function03, int i5, Composer composer, int i6) {
        SaleOnBoardOrderDetailsContent(viewState, function1, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void SaleOnBoardOrderDetailsScreen(final SaleOnBoardOrderDetailsViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-96708399);
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
                ComposerKt.traceEventStart(-96708399, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsScreen (SaleOnBoardOrderDetailsScreen.kt:74)");
            }
            final SaleOnBoardOrderDetailsViewModel.ViewState viewState = (SaleOnBoardOrderDetailsViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            Boolean valueOf = Boolean.valueOf(viewState.getIsLoading());
            startRestartGroup.startReplaceGroup(289578758);
            int i7 = i6 & 112;
            boolean changedInstance = startRestartGroup.changedInstance(viewState) | (i7 == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsScreen$1$1(viewState, navigator, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 0);
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(289583108);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsScreen$2$1(viewModel, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, 6);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            AppColor appColor = AppColor.INSTANCE;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(BackgroundKt.m104backgroundbw27NRU$default(fillMaxSize$default, appColor.m3269getGrey60d7_KjU(), null, 2, null), Dp.m2599constructorimpl(24), 0.0f, 2, null);
            long m3269getGrey60d7_KjU = appColor.m3269getGrey60d7_KjU();
            startRestartGroup.startReplaceGroup(289594736);
            boolean z5 = i7 == 32;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsScreen$3$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1438813604, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsScreen$4
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i8) {
                    Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                    if ((i8 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1438813604, i8, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsScreen.<anonymous> (SaleOnBoardOrderDetailsScreen.kt:99)");
                    }
                    SaleOnBoardOrderDetailsViewModel.ViewState viewState2 = SaleOnBoardOrderDetailsViewModel.ViewState.this;
                    SaleOnBoardOrderDetailsViewModel saleOnBoardOrderDetailsViewModel = viewModel;
                    composer3.startReplaceGroup(-1617370738);
                    boolean changedInstance3 = composer3.changedInstance(saleOnBoardOrderDetailsViewModel);
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (changedInstance3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsScreen$4$1$1(saleOnBoardOrderDetailsViewModel);
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    composer3.endReplaceGroup();
                    Function1 function1 = (Function1) ((KFunction) rememberedValue4);
                    SaleOnBoardOrderDetailsViewModel saleOnBoardOrderDetailsViewModel2 = viewModel;
                    composer3.startReplaceGroup(-1617368511);
                    boolean changedInstance4 = composer3.changedInstance(saleOnBoardOrderDetailsViewModel2);
                    Object rememberedValue5 = composer3.rememberedValue();
                    if (changedInstance4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5 = new SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsScreen$4$2$1(saleOnBoardOrderDetailsViewModel2);
                        composer3.updateRememberedValue(rememberedValue5);
                    }
                    composer3.endReplaceGroup();
                    Function0 function0 = (Function0) ((KFunction) rememberedValue5);
                    SaleOnBoardOrderDetailsViewModel saleOnBoardOrderDetailsViewModel3 = viewModel;
                    composer3.startReplaceGroup(-1617366157);
                    boolean changedInstance5 = composer3.changedInstance(saleOnBoardOrderDetailsViewModel3);
                    Object rememberedValue6 = composer3.rememberedValue();
                    if (changedInstance5 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue6 = new SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsScreen$4$3$1(saleOnBoardOrderDetailsViewModel3);
                        composer3.updateRememberedValue(rememberedValue6);
                    }
                    composer3.endReplaceGroup();
                    Function0 function02 = (Function0) ((KFunction) rememberedValue6);
                    SaleOnBoardOrderDetailsViewModel saleOnBoardOrderDetailsViewModel4 = viewModel;
                    composer3.startReplaceGroup(-1617364270);
                    boolean changedInstance6 = composer3.changedInstance(saleOnBoardOrderDetailsViewModel4);
                    Object rememberedValue7 = composer3.rememberedValue();
                    if (changedInstance6 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue7 = new SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsScreen$4$4$1(saleOnBoardOrderDetailsViewModel4);
                        composer3.updateRememberedValue(rememberedValue7);
                    }
                    composer3.endReplaceGroup();
                    SaleOnBoardOrderDetailsScreenKt.SaleOnBoardOrderDetailsContent(viewState2, function1, function0, function02, (Function0) ((KFunction) rememberedValue7), composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(m313paddingVpY3zN4$default, 0.0f, null, null, m3269getGrey60d7_KjU, null, (Function0) rememberedValue3, null, null, rememberComposableLambda, startRestartGroup, 805331334, 426);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h4.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardOrderDetailsScreen$lambda$3;
                    SaleOnBoardOrderDetailsScreen$lambda$3 = SaleOnBoardOrderDetailsScreenKt.SaleOnBoardOrderDetailsScreen$lambda$3(SaleOnBoardOrderDetailsViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardOrderDetailsScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardOrderDetailsScreen$lambda$3(SaleOnBoardOrderDetailsViewModel saleOnBoardOrderDetailsViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        SaleOnBoardOrderDetailsScreen(saleOnBoardOrderDetailsViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void StatusProgressBar(final SaleOnBoardOrder saleOnBoardOrder, final Context context, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1537286134);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(saleOnBoardOrder) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(context) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1537286134, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.StatusProgressBar (SaleOnBoardOrderDetailsScreen.kt:211)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(665820938);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (rememberedValue == companion4.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(665822890);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion4.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            float m2599constructorimpl = Dp.m2599constructorimpl(20);
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            float f5 = 2;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, m3533abs0680j_4(Dp.m2599constructorimpl(Dp.m2599constructorimpl(ComposeExtensionsKt.pxToDp(((Number) mutableState.getValue()).intValue(), startRestartGroup, 0) - m2599constructorimpl) / f5)), Dp.m2599constructorimpl(16), m3533abs0680j_4(Dp.m2599constructorimpl(Dp.m2599constructorimpl(ComposeExtensionsKt.pxToDp(((Number) mutableState2.getValue()).intValue(), startRestartGroup, 0) - m2599constructorimpl) / f5)), 0.0f, 8, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
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
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier m331size3ABfNKs = SizeKt.m331size3ABfNKs(companion, m2599constructorimpl);
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.icon_checkmark_tick_small, startRestartGroup, 6);
            Accessibility accessibility = Accessibility.INSTANCE;
            String skip = accessibility.getSkip();
            Color.Companion companion5 = Color.INSTANCE;
            IconKt.m857Iconww6aTOc(painterResource, skip, m331size3ABfNKs, companion5.m1501getUnspecified0d7_KjU(), startRestartGroup, 3456, 0);
            float f6 = 1;
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), 1.0f, false, 2, null);
            int step = saleOnBoardOrder.getStatus().getStep();
            SaleOnBoardOrder.OrderStatus orderStatus = SaleOnBoardOrder.OrderStatus.Printed;
            BoxKt.Box(BackgroundKt.m104backgroundbw27NRU$default(weight$default, step >= orderStatus.getStep() ? AppColor.INSTANCE.m3263getContrastGreen20d7_KjU() : AppColor.INSTANCE.m3267getGrey40d7_KjU(), null, 2, null), startRestartGroup, 0);
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(saleOnBoardOrder.getStatus().getStep() >= orderStatus.getStep() ? R.drawable.icon_checkmark_tick_small : R.drawable.icon_circle, startRestartGroup, 0), accessibility.getSkip(), SizeKt.m331size3ABfNKs(companion, m2599constructorimpl), companion5.m1501getUnspecified0d7_KjU(), startRestartGroup, 3456, 0);
            Modifier weight$default2 = RowScope.weight$default(rowScopeInstance, SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), 1.0f, false, 2, null);
            int step2 = saleOnBoardOrder.getStatus().getStep();
            SaleOnBoardOrder.OrderStatus orderStatus2 = SaleOnBoardOrder.OrderStatus.Done;
            BoxKt.Box(BackgroundKt.m104backgroundbw27NRU$default(weight$default2, step2 >= orderStatus2.getStep() ? AppColor.INSTANCE.m3263getContrastGreen20d7_KjU() : AppColor.INSTANCE.m3267getGrey40d7_KjU(), null, 2, null), startRestartGroup, 0);
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(saleOnBoardOrder.getStatus().getStep() >= orderStatus2.getStep() ? R.drawable.icon_checkmark_tick_small : R.drawable.icon_circle, startRestartGroup, 0), accessibility.getSkip(), SizeKt.m331size3ABfNKs(companion, m2599constructorimpl), companion5.m1501getUnspecified0d7_KjU(), startRestartGroup, 3456, 0);
            startRestartGroup.endNode();
            Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0.0f, Dp.m2599constructorimpl(8), 0.0f, Dp.m2599constructorimpl(32), 5, null);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getSpaceBetween(), companion2.getTop(), startRestartGroup, 6);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default2);
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
            Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
            IntrinsicSize intrinsicSize = IntrinsicSize.Min;
            Modifier width = IntrinsicKt.width(companion, intrinsicSize);
            startRestartGroup.startReplaceGroup(-509919338);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion4.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: h4.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit StatusProgressBar$lambda$16$lambda$15$lambda$12$lambda$11;
                        StatusProgressBar$lambda$16$lambda$15$lambda$12$lambda$11 = SaleOnBoardOrderDetailsScreenKt.StatusProgressBar$lambda$16$lambda$15$lambda$12$lambda$11(MutableState.this, (LayoutCoordinates) obj);
                        return StatusProgressBar$lambda$16$lambda$15$lambda$12$lambda$11;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            TextKt.m940Text4IGK_g(SaleOnBoardOrderExtensionsKt.getShortTitle(SaleOnBoardOrder.OrderStatus.Received, context), OnGloballyPositionedModifierKt.onGloballyPositioned(width, (Function1) rememberedValue3), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 48, 1572864, 65532);
            TextKt.m940Text4IGK_g(SaleOnBoardOrderExtensionsKt.getShortTitle(SaleOnBoardOrder.OrderStatus.Processing, context), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 0, 1572864, 65534);
            Modifier width2 = IntrinsicKt.width(companion, intrinsicSize);
            startRestartGroup.startReplaceGroup(-509904588);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion4.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: h4.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit StatusProgressBar$lambda$16$lambda$15$lambda$14$lambda$13;
                        StatusProgressBar$lambda$16$lambda$15$lambda$14$lambda$13 = SaleOnBoardOrderDetailsScreenKt.StatusProgressBar$lambda$16$lambda$15$lambda$14$lambda$13(MutableState.this, (LayoutCoordinates) obj);
                        return StatusProgressBar$lambda$16$lambda$15$lambda$14$lambda$13;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(SaleOnBoardOrderExtensionsKt.getShortTitle(orderStatus2, context), OnGloballyPositionedModifierKt.onGloballyPositioned(width2, (Function1) rememberedValue4), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 48, 1572864, 65532);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h4.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit StatusProgressBar$lambda$17;
                    StatusProgressBar$lambda$17 = SaleOnBoardOrderDetailsScreenKt.StatusProgressBar$lambda$17(SaleOnBoardOrder.this, context, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return StatusProgressBar$lambda$17;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatusProgressBar$lambda$16$lambda$15$lambda$12$lambda$11(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf(IntSize.m2661getWidthimpl(it.mo1948getSizeYbymL2g())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatusProgressBar$lambda$16$lambda$15$lambda$14$lambda$13(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf(IntSize.m2661getWidthimpl(it.mo1948getSizeYbymL2g())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatusProgressBar$lambda$17(SaleOnBoardOrder saleOnBoardOrder, Context context, int i5, Composer composer, int i6) {
        StatusProgressBar(saleOnBoardOrder, context, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* renamed from: abs-0680j_4, reason: not valid java name */
    private static final float m3533abs0680j_4(float f5) {
        return f5 < 0.0f ? Dp.m2599constructorimpl(0.0f) : f5;
    }
}
