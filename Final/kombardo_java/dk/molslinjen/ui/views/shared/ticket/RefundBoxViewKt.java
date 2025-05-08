package dk.molslinjen.ui.views.shared.ticket;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.tickets.refund.RefundAmountsViewKt;
import dk.molslinjen.ui.views.shared.ticket.RefundBoxViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a+\u0010\u0006\u001a\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "refundAmount", "handlingFee", BuildConfig.FLAVOR, "transferDetails", BuildConfig.FLAVOR, "RefundBoxView", "(Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class RefundBoxViewKt {
    public static final void RefundBoxView(final PriceWithCurrency priceWithCurrency, final PriceWithCurrency priceWithCurrency2, final String transferDetails, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        final int i7;
        final String str;
        Intrinsics.checkNotNullParameter(transferDetails, "transferDetails");
        Composer startRestartGroup = composer.startRestartGroup(1180444834);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(priceWithCurrency) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(priceWithCurrency2) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(transferDetails) ? 256 : 128;
        }
        int i8 = i6;
        if ((i8 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            str = transferDetails;
            composer2 = startRestartGroup;
            i7 = i5;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1180444834, i8, -1, "dk.molslinjen.ui.views.shared.ticket.RefundBoxView (RefundBoxView.kt:17)");
            }
            if (priceWithCurrency == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: B4.a
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit RefundBoxView$lambda$0;
                            RefundBoxView$lambda$0 = RefundBoxViewKt.RefundBoxView$lambda$0(PriceWithCurrency.this, priceWithCurrency2, transferDetails, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return RefundBoxView$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), ThemeShapesKt.getThemeShapes().getMedium()), AppColor.INSTANCE.m3268getGrey50d7_KjU(), null, 2, null), Dp.m2599constructorimpl(16));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
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
            RefundAmountsViewKt.RefundAmountsView(priceWithCurrency, priceWithCurrency2, true, startRestartGroup, (i8 & 14) | 384 | (i8 & 112), 0);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(24)), startRestartGroup, 6);
            composer2 = startRestartGroup;
            i7 = i5;
            str = transferDetails;
            TextKt.m940Text4IGK_g(transferDetails, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, (i8 >> 6) & 14, 1572864, 65534);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: B4.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RefundBoxView$lambda$2;
                    RefundBoxView$lambda$2 = RefundBoxViewKt.RefundBoxView$lambda$2(PriceWithCurrency.this, priceWithCurrency2, str, i7, (Composer) obj, ((Integer) obj2).intValue());
                    return RefundBoxView$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RefundBoxView$lambda$0(PriceWithCurrency priceWithCurrency, PriceWithCurrency priceWithCurrency2, String str, int i5, Composer composer, int i6) {
        RefundBoxView(priceWithCurrency, priceWithCurrency2, str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RefundBoxView$lambda$2(PriceWithCurrency priceWithCurrency, PriceWithCurrency priceWithCurrency2, String str, int i5, Composer composer, int i6) {
        RefundBoxView(priceWithCurrency, priceWithCurrency2, str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
