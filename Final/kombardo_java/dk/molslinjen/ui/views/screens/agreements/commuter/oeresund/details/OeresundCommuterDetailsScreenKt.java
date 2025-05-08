package dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.details;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.model.agreement.commuter.oeresund.OeresundCommuterAgreement;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.barcode.BarcodeViewType;
import dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.OeresundAgreementExpiredInfoViewKt;
import dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.OeresundAgreementInfoViewKt;
import dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.details.OeresundCommuterDetailsScreenKt;
import dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.details.OeresundCommuterDetailsViewModel;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeValidity;
import dk.molslinjen.ui.views.shared.components.BarcodeWidgetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001aC\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072*\u0010\u000e\u001a&\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\tj\u0002`\rH\u0003¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/commuter/oeresund/details/OeresundCommuterDetailsViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "OeresundCommuterDetailsScreen", "(Ldk/molslinjen/ui/views/screens/agreements/commuter/oeresund/details/OeresundCommuterDetailsViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement;", "agreement", "Lkotlin/Function4;", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/reusable/barcode/BarcodeViewType;", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeValidity;", "Ldk/molslinjen/ui/views/shared/components/ExpandBarcodeCallback;", "expandBarcode", "Content", "(Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class OeresundCommuterDetailsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void Content(final OeresundCommuterAgreement oeresundCommuterAgreement, final Function4<? super String, ? super String, ? super BarcodeViewType, ? super BarcodeValidity, Unit> function4, Composer composer, final int i5) {
        int i6;
        int i7;
        float f5;
        Modifier.Companion companion;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-2102389560);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(oeresundCommuterAgreement) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function4) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2102389560, i6, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.details.Content (OeresundCommuterDetailsScreen.kt:72)");
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f6 = 16;
            float f7 = 24;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(BackgroundKt.m103backgroundbw27NRU(IntrinsicKt.height(SizeKt.fillMaxWidth$default(ModifierExtensionsKt.defaultShadow(PaddingKt.m314paddingqDBjuR0(companion2, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f7), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(46)), ThemeShapesKt.getThemeShapes().getMedium()), 0.0f, 1, null), IntrinsicSize.Max), oeresundCommuterAgreement.isAvailable() ? AppColor.INSTANCE.m3281getWhite0d7_KjU() : AppColor.INSTANCE.m3269getGrey60d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f6), 0.0f, 2, null), 0.0f, Dp.m2599constructorimpl(f7), 0.0f, Dp.m2599constructorimpl(f6), 5, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
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
            OeresundAgreementInfoViewKt.OeresundAgreementInfoView(IntrinsicKt.height(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), IntrinsicSize.Min), oeresundCommuterAgreement, startRestartGroup, ((i6 << 3) & 112) | 6, 0);
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m313paddingVpY3zN4$default(companion2, 0.0f, Dp.m2599constructorimpl(f6), 1, null), 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(2)), startRestartGroup, 3078, 6);
            String number = oeresundCommuterAgreement.getNumber();
            startRestartGroup.startReplaceGroup(994740966);
            if (number == null) {
                f5 = f6;
                companion = companion2;
                composer2 = startRestartGroup;
                i7 = 6;
            } else {
                i7 = 6;
                f5 = f6;
                companion = companion2;
                composer2 = startRestartGroup;
                BarcodeWidgetKt.BarcodeWidget(number, StringResources_androidKt.stringResource(R.string.ticketDetails_scanAtTerminal_molslinjen, startRestartGroup, 6), BarcodeViewType.QR_CODE, function4, oeresundCommuterAgreement.isAvailable() ? BarcodeValidity.Valid : BarcodeValidity.Expired, startRestartGroup, ((i6 << 6) & 7168) | 384, 0);
            }
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(994753857);
            if (!oeresundCommuterAgreement.isAvailable()) {
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer2, i7);
                OeresundAgreementExpiredInfoViewKt.OeresundAgreementExpiredInfoView(composer2, 0);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: v2.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$4;
                    Content$lambda$4 = OeresundCommuterDetailsScreenKt.Content$lambda$4(OeresundCommuterAgreement.this, function4, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$4(OeresundCommuterAgreement oeresundCommuterAgreement, Function4 function4, int i5, Composer composer, int i6) {
        Content(oeresundCommuterAgreement, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void OeresundCommuterDetailsScreen(final OeresundCommuterDetailsViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(330452970);
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
                ComposerKt.traceEventStart(330452970, i6, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.details.OeresundCommuterDetailsScreen (OeresundCommuterDetailsScreen.kt:48)");
            }
            OeresundCommuterAgreement oeresundCommuterAgreement = (OeresundCommuterAgreement) SnapshotStateKt.collectAsState(viewModel.getAgreement(), null, startRestartGroup, 0, 1).getValue();
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, oeresundCommuterAgreement == null, 0, false, null, ComposableLambdaKt.rememberComposableLambda(-917209948, true, new OeresundCommuterDetailsScreenKt$OeresundCommuterDetailsScreen$1$1(oeresundCommuterAgreement, navigator), startRestartGroup, 54), startRestartGroup, 1572864, 59);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: v2.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OeresundCommuterDetailsScreen$lambda$1;
                    OeresundCommuterDetailsScreen$lambda$1 = OeresundCommuterDetailsScreenKt.OeresundCommuterDetailsScreen$lambda$1(OeresundCommuterDetailsViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return OeresundCommuterDetailsScreen$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OeresundCommuterDetailsScreen$lambda$1(OeresundCommuterDetailsViewModel oeresundCommuterDetailsViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        OeresundCommuterDetailsScreen(oeresundCommuterDetailsViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
