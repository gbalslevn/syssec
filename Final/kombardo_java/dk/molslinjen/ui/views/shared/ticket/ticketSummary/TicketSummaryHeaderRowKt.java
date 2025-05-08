package dk.molslinjen.ui.views.shared.ticket.ticketSummary;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.AccessibilityKt;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryHeaderRowKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a-\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, "reservationNumber", BuildConfig.FLAVOR, "TicketSummaryHeaderRow", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TicketSummaryHeaderRowKt {
    /* JADX WARN: Removed duplicated region for block: B:19:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TicketSummaryHeaderRow(Modifier modifier, final String title, String str, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        String str2;
        int i8;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        final String str3;
        Modifier modifier3;
        Composer composer2;
        final String str4;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer startRestartGroup = composer.startRestartGroup(1908927326);
        int i9 = i6 & 1;
        if (i9 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(title) ? 32 : 16;
        }
        int i10 = i6 & 4;
        if (i10 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            str2 = str;
            i7 |= startRestartGroup.changed(str2) ? 256 : 128;
            i8 = i7;
            if ((i8 & 147) == 146 || !startRestartGroup.getSkipping()) {
                Modifier modifier4 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                String str5 = i10 == 0 ? null : str2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1908927326, i8, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryHeaderRow (TicketSummaryHeaderRow.kt:20)");
                }
                float f5 = 8;
                Modifier m314paddingqDBjuR0 = PaddingKt.m314paddingqDBjuR0(modifier4, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(16), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(14));
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m314paddingqDBjuR0);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor);
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Modifier.Companion companion2 = Modifier.INSTANCE;
                str3 = str5;
                modifier3 = modifier4;
                TextKt.m940Text4IGK_g(title, RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH3Bold(), startRestartGroup, (i8 >> 3) & 14, 1572864, 65532);
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(861484581);
                if (str3 != null) {
                    final String stringResource = StringResources_androidKt.stringResource(R.string.common_reservationNumber, composer2, 6);
                    composer2.startReplaceGroup(861490228);
                    boolean changed = composer2.changed(stringResource) | ((i8 & 896) == 256);
                    Object rememberedValue = composer2.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function1() { // from class: C4.B
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit TicketSummaryHeaderRow$lambda$2$lambda$1$lambda$0;
                                TicketSummaryHeaderRow$lambda$2$lambda$1$lambda$0 = TicketSummaryHeaderRowKt.TicketSummaryHeaderRow$lambda$2$lambda$1$lambda$0(stringResource, str3, (SemanticsPropertyReceiver) obj);
                                return TicketSummaryHeaderRow$lambda$2$lambda$1$lambda$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    composer2.endReplaceGroup();
                    TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.ticketSummary_resNr, new Object[]{str3}, composer2, 6), SemanticsModifierKt.semantics$default(companion2, false, (Function1) rememberedValue, 1, null), AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 384, 1572864, 65528);
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str3;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                str4 = str2;
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier5 = modifier3;
                endRestartGroup.updateScope(new Function2() { // from class: C4.C
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit TicketSummaryHeaderRow$lambda$3;
                        TicketSummaryHeaderRow$lambda$3 = TicketSummaryHeaderRowKt.TicketSummaryHeaderRow$lambda$3(Modifier.this, title, str4, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return TicketSummaryHeaderRow$lambda$3;
                    }
                });
                return;
            }
            return;
        }
        str2 = str;
        i8 = i7;
        if ((i8 & 147) == 146) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        float f52 = 8;
        Modifier m314paddingqDBjuR02 = PaddingKt.m314paddingqDBjuR0(modifier4, Dp.m2599constructorimpl(f52), Dp.m2599constructorimpl(16), Dp.m2599constructorimpl(f52), Dp.m2599constructorimpl(14));
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m314paddingqDBjuR02);
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion3.getSetModifier());
        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
        Modifier.Companion companion22 = Modifier.INSTANCE;
        str3 = str5;
        modifier3 = modifier4;
        TextKt.m940Text4IGK_g(title, RowScope.weight$default(rowScopeInstance2, companion22, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH3Bold(), startRestartGroup, (i8 >> 3) & 14, 1572864, 65532);
        composer2 = startRestartGroup;
        composer2.startReplaceGroup(861484581);
        if (str3 != null) {
        }
        composer2.endReplaceGroup();
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        str4 = str3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketSummaryHeaderRow$lambda$2$lambda$1$lambda$0(String str, String str2, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str + " " + AccessibilityKt.splitNumberForAccessibility(str2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketSummaryHeaderRow$lambda$3(Modifier modifier, String str, String str2, int i5, int i6, Composer composer, int i7) {
        TicketSummaryHeaderRow(modifier, str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
