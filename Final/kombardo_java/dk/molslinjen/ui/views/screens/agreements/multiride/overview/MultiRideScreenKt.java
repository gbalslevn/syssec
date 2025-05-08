package dk.molslinjen.ui.views.screens.agreements.multiride.overview;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.buttons.ButtonConfig;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideOverviewViewModel;
import dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001as\u0010\r\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\u0002H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\u001d\u0010\u000f\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0003¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/multiride/overview/MultiRideOverviewViewModel;", "viewModel", "Lkotlin/Function1;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCardNumber;", BuildConfig.FLAVOR, "navigateToDetails", "Lkotlin/Function0;", "navigateToPurchaseMultiRide", "navigateToAddExistingMultiRide", "navigateToRefillMultiRide", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "navigateToOrderTicket", "MultiRideScreen", "(Ldk/molslinjen/ui/views/screens/agreements/multiride/overview/MultiRideOverviewViewModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "EmptyStateCard", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MultiRideScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void EmptyStateCard(final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1011890631);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1011890631, i6, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.overview.EmptyStateCard (MultiRideScreen.kt:109)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(ModifierExtensionsKt.defaultShadow(companion, ThemeShapesKt.getThemeShapes().getMedium()), 0.0f, 1, null);
            AppColor appColor = AppColor.INSTANCE;
            float f5 = 16;
            float f6 = 24;
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BackgroundKt.m103backgroundbw27NRU(fillMaxWidth$default, appColor.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f6));
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Horizontal centerHorizontally = companion2.getCenterHorizontally();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
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
            String stringResource = StringResources_androidKt.stringResource(R.string.multiRide_purchase_molslinjenDestination_title, startRestartGroup, 6);
            TextStyle paragraph = TypographyKt.getParagraph();
            TextAlign.Companion companion4 = TextAlign.INSTANCE;
            TextKt.m940Text4IGK_g(stringResource, null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion4.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, paragraph, startRestartGroup, 0, 1572864, 65022);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), appColor.m3269getGrey60d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f5));
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getCenter(), companion2.getTop(), startRestartGroup, 6);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
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
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.multiRide_purchase_molslinjenDestination_jutland, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), startRestartGroup, 0, 1572864, 65534);
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_select_route_arrows, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 2, null), appColor.m3267getGrey40d7_KjU(), startRestartGroup, 3456, 0);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.multiRide_purchase_molslinjenDestination_zealand, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), startRestartGroup, 0, 1572864, 65534);
            startRestartGroup.endNode();
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.multiRide_purchase_molslinjenDestination_description, startRestartGroup, 6), null, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion4.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 384, 1572864, 65018);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
            composer2 = startRestartGroup;
            PrimaryButtonKt.PrimaryButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), StringResources_androidKt.stringResource(R.string.agreements_purchaseMultiRide, startRestartGroup, 6), function0, null, ButtonConfig.Regular, false, false, false, startRestartGroup, ((i6 << 6) & 896) | 24582, 232);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: A2.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit EmptyStateCard$lambda$3;
                    EmptyStateCard$lambda$3 = MultiRideScreenKt.EmptyStateCard$lambda$3(Function0.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return EmptyStateCard$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmptyStateCard$lambda$3(Function0 function0, int i5, Composer composer, int i6) {
        EmptyStateCard(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void MultiRideScreen(final MultiRideOverviewViewModel viewModel, final Function1<? super String, Unit> navigateToDetails, final Function0<Unit> navigateToPurchaseMultiRide, final Function0<Unit> navigateToAddExistingMultiRide, final Function1<? super String, Unit> navigateToRefillMultiRide, final Function1<? super MultiRideCard, Unit> navigateToOrderTicket, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigateToDetails, "navigateToDetails");
        Intrinsics.checkNotNullParameter(navigateToPurchaseMultiRide, "navigateToPurchaseMultiRide");
        Intrinsics.checkNotNullParameter(navigateToAddExistingMultiRide, "navigateToAddExistingMultiRide");
        Intrinsics.checkNotNullParameter(navigateToRefillMultiRide, "navigateToRefillMultiRide");
        Intrinsics.checkNotNullParameter(navigateToOrderTicket, "navigateToOrderTicket");
        Composer startRestartGroup = composer.startRestartGroup(-1362149049);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToDetails) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToPurchaseMultiRide) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToAddExistingMultiRide) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToRefillMultiRide) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToOrderTicket) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1362149049, i6, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideScreen (MultiRideScreen.kt:53)");
            }
            MultiRideOverviewViewModel.ViewState viewState = (MultiRideOverviewViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            composer2 = startRestartGroup;
            LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, viewState.getIsLoading(), 0, false, null, ComposableLambdaKt.rememberComposableLambda(-2014423917, true, new MultiRideScreenKt$MultiRideScreen$1(LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3), viewState, navigateToPurchaseMultiRide, navigateToAddExistingMultiRide, navigateToDetails, navigateToOrderTicket, navigateToRefillMultiRide), composer2, 54), composer2, 1572864, 59);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: A2.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MultiRideScreen$lambda$0;
                    MultiRideScreen$lambda$0 = MultiRideScreenKt.MultiRideScreen$lambda$0(MultiRideOverviewViewModel.this, navigateToDetails, navigateToPurchaseMultiRide, navigateToAddExistingMultiRide, navigateToRefillMultiRide, navigateToOrderTicket, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MultiRideScreen$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideScreen$lambda$0(MultiRideOverviewViewModel multiRideOverviewViewModel, Function1 function1, Function0 function0, Function0 function02, Function1 function12, Function1 function13, int i5, Composer composer, int i6) {
        MultiRideScreen(multiRideOverviewViewModel, function1, function0, function02, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
