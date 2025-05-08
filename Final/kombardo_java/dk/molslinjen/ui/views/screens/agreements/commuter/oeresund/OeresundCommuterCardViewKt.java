package dk.molslinjen.ui.views.screens.agreements.commuter.oeresund;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.agreement.commuter.oeresund.OeresundCommuterAgreement;
import dk.molslinjen.domain.model.agreement.commuter.oeresund.OeresundCommuterAgreementType;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.views.reusable.VerticalDividerKt;
import dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.OeresundCommuterCardViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a+\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement;", "agreement", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "navigateToDetails", "OeresundCommuterCardView", "(Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class OeresundCommuterCardViewKt {
    public static final void OeresundCommuterCardView(final OeresundCommuterAgreement agreement, final Function1<? super String, Unit> navigateToDetails, Composer composer, final int i5) {
        int i6;
        Modifier.Companion companion;
        Intrinsics.checkNotNullParameter(agreement, "agreement");
        Intrinsics.checkNotNullParameter(navigateToDetails, "navigateToDetails");
        Composer startRestartGroup = composer.startRestartGroup(-1674568763);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(agreement) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToDetails) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1674568763, i6, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.OeresundCommuterCardView (OeresundCommuterCardView.kt:33)");
            }
            boolean z5 = agreement.getAgreementType() != OeresundCommuterAgreementType.Bizz;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(ModifierExtensionsKt.defaultShadow(companion2, ThemeShapesKt.getThemeShapes().getMedium()), 0.0f, 1, null);
            IntrinsicSize intrinsicSize = IntrinsicSize.Max;
            Modifier m103backgroundbw27NRU = BackgroundKt.m103backgroundbw27NRU(IntrinsicKt.height(fillMaxWidth$default, intrinsicSize), agreement.isAvailable() ? AppColor.INSTANCE.m3281getWhite0d7_KjU() : AppColor.INSTANCE.m3269getGrey60d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium());
            startRestartGroup.startReplaceGroup(-505743340);
            boolean changedInstance = ((i6 & 112) == 32) | startRestartGroup.changedInstance(agreement);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: u2.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit OeresundCommuterCardView$lambda$1$lambda$0;
                        OeresundCommuterCardView$lambda$1$lambda$0 = OeresundCommuterCardViewKt.OeresundCommuterCardView$lambda$1$lambda$0(Function1.this, agreement);
                        return OeresundCommuterCardView$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            float f5 = 16;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(ClickableKt.m122clickableXHw0xAI$default(m103backgroundbw27NRU, z5, null, null, (Function0) rememberedValue, 6, null), Dp.m2599constructorimpl(f5), 0.0f, 2, null), 0.0f, Dp.m2599constructorimpl(24), 0.0f, Dp.m2599constructorimpl(f5), 5, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
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
            Modifier height = IntrinsicKt.height(companion2, intrinsicSize);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, height);
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
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            OeresundAgreementInfoViewKt.OeresundAgreementInfoView(RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), agreement, startRestartGroup, (i6 << 3) & 112, 0);
            startRestartGroup.startReplaceGroup(2068770001);
            if (z5) {
                startRestartGroup.startReplaceGroup(2068770727);
                if (agreement.getAgreementType() == OeresundCommuterAgreementType.Punchcard) {
                    companion = companion2;
                    VerticalDividerKt.m3394VerticalDividertZIQpXc(null, 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(2)), startRestartGroup, 3072, 7);
                } else {
                    companion = companion2;
                }
                startRestartGroup.endReplaceGroup();
                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_chevron_right, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(rowScopeInstance.align(companion, companion3.getCenterVertically()), Dp.m2599constructorimpl(f5)), AppColor.INSTANCE.m3253getBrandBlack10d7_KjU(), startRestartGroup, 3072, 0);
            } else {
                companion = companion2;
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            startRestartGroup.startReplaceGroup(-813775120);
            if (!agreement.isAvailable()) {
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                OeresundAgreementExpiredInfoViewKt.OeresundAgreementExpiredInfoView(startRestartGroup, 0);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: u2.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OeresundCommuterCardView$lambda$4;
                    OeresundCommuterCardView$lambda$4 = OeresundCommuterCardViewKt.OeresundCommuterCardView$lambda$4(OeresundCommuterAgreement.this, navigateToDetails, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return OeresundCommuterCardView$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OeresundCommuterCardView$lambda$1$lambda$0(Function1 function1, OeresundCommuterAgreement oeresundCommuterAgreement) {
        function1.invoke(oeresundCommuterAgreement.getAgreementId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OeresundCommuterCardView$lambda$4(OeresundCommuterAgreement oeresundCommuterAgreement, Function1 function1, int i5, Composer composer, int i6) {
        OeresundCommuterCardView(oeresundCommuterAgreement, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
