package dk.molslinjen.ui.views.shared.ticket.ticketSummary;

import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.extensions.PriceWithCurrencyExtensionsKt;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.shared.components.PriceTextKt;
import dk.molslinjen.ui.views.shared.components.PriceViewType;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.SummaryRowKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"SummaryRow", BuildConfig.FLAVOR, "icon", BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, BuildConfig.FLAVOR, "quantity", "price", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "(ILjava/lang/String;Ljava/lang/Integer;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SummaryRowKt {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SummaryRow(final int i5, final String title, Integer num, PriceWithCurrency priceWithCurrency, Composer composer, final int i6, final int i7) {
        int i8;
        final Integer num2;
        int i9;
        PriceWithCurrency priceWithCurrency2;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        PriceWithCurrency nullIfZero;
        Composer composer2;
        final PriceWithCurrency priceWithCurrency3;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer startRestartGroup = composer.startRestartGroup(508311856);
        if ((i7 & 1) != 0) {
            i8 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i8 = (startRestartGroup.changed(i5) ? 4 : 2) | i6;
        } else {
            i8 = i6;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changed(title) ? 32 : 16;
        }
        int i10 = i7 & 4;
        if (i10 != 0) {
            i8 |= 384;
        } else if ((i6 & 384) == 0) {
            num2 = num;
            i8 |= startRestartGroup.changed(num2) ? 256 : 128;
            i9 = i7 & 8;
            if (i9 == 0) {
                i8 |= 3072;
            } else if ((i6 & 3072) == 0) {
                priceWithCurrency2 = priceWithCurrency;
                i8 |= startRestartGroup.changedInstance(priceWithCurrency2) ? 2048 : 1024;
                if ((i8 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                    if (i10 != 0) {
                        num2 = null;
                    }
                    PriceWithCurrency priceWithCurrency4 = i9 != 0 ? null : priceWithCurrency2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(508311856, i8, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.SummaryRow (SummaryRow.kt:30)");
                    }
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(i5, startRestartGroup, i8 & 14), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(16)), AppColor.INSTANCE.m3266getGrey30d7_KjU(), startRestartGroup, 3456, 0);
                    AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
                    if (num2 != null) {
                        int pushStyle = builder.pushStyle(new SpanStyle(0L, 0L, TypographyKt.getSubBold().getFontWeight(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 65531, null));
                        try {
                            builder.append(num2 + " ");
                            Unit unit = Unit.INSTANCE;
                        } finally {
                            builder.pop(pushStyle);
                        }
                    }
                    builder.append(title);
                    float f5 = 8;
                    TextKt.m941TextIbK3jfQ(builder.toAnnotatedString(), RowScope.weight$default(rowScopeInstance, PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, TypographyKt.getSub(), startRestartGroup, 0, 12582912, 131068);
                    nullIfZero = PriceWithCurrencyExtensionsKt.nullIfZero(priceWithCurrency4);
                    composer2 = startRestartGroup;
                    composer2.startReplaceGroup(591746569);
                    if (nullIfZero != null) {
                        PriceTextKt.m3557PriceText1y9Plug((Price) nullIfZero, PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), (PriceViewType) null, false, TypographyKt.getSubBold(), (TextAlign) null, 0, 0L, composer2, 24624, 236);
                    }
                    composer2.endReplaceGroup();
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    priceWithCurrency3 = priceWithCurrency4;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    priceWithCurrency3 = priceWithCurrency2;
                    composer2 = startRestartGroup;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: C4.q
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit SummaryRow$lambda$4;
                            SummaryRow$lambda$4 = SummaryRowKt.SummaryRow$lambda$4(i5, title, num2, priceWithCurrency3, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                            return SummaryRow$lambda$4;
                        }
                    });
                    return;
                }
                return;
            }
            priceWithCurrency2 = priceWithCurrency;
            if ((i8 & 1171) == 1170) {
            }
            if (i10 != 0) {
            }
            if (i9 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, startRestartGroup, 48);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion3);
            ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy2, companion22.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion22.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion22.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion22.getSetModifier());
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(i5, startRestartGroup, i8 & 14), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion3, Dp.m2599constructorimpl(16)), AppColor.INSTANCE.m3266getGrey30d7_KjU(), startRestartGroup, 3456, 0);
            AnnotatedString.Builder builder2 = new AnnotatedString.Builder(0, 1, null);
            if (num2 != null) {
            }
            builder2.append(title);
            float f52 = 8;
            TextKt.m941TextIbK3jfQ(builder2.toAnnotatedString(), RowScope.weight$default(rowScopeInstance2, PaddingKt.m315paddingqDBjuR0$default(companion3, Dp.m2599constructorimpl(f52), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, TypographyKt.getSub(), startRestartGroup, 0, 12582912, 131068);
            nullIfZero = PriceWithCurrencyExtensionsKt.nullIfZero(priceWithCurrency4);
            composer2 = startRestartGroup;
            composer2.startReplaceGroup(591746569);
            if (nullIfZero != null) {
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            priceWithCurrency3 = priceWithCurrency4;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        num2 = num;
        i9 = i7 & 8;
        if (i9 == 0) {
        }
        priceWithCurrency2 = priceWithCurrency;
        if ((i8 & 1171) == 1170) {
        }
        if (i10 != 0) {
        }
        if (i9 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Alignment.Vertical centerVertically22 = Alignment.INSTANCE.getCenterVertically();
        Modifier.Companion companion32 = Modifier.INSTANCE;
        MeasurePolicy rowMeasurePolicy22 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically22, startRestartGroup, 48);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, companion32);
        ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor22 = companion222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy22, companion222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion222.getSetModifier());
        RowScopeInstance rowScopeInstance22 = RowScopeInstance.INSTANCE;
        IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(i5, startRestartGroup, i8 & 14), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion32, Dp.m2599constructorimpl(16)), AppColor.INSTANCE.m3266getGrey30d7_KjU(), startRestartGroup, 3456, 0);
        AnnotatedString.Builder builder22 = new AnnotatedString.Builder(0, 1, null);
        if (num2 != null) {
        }
        builder22.append(title);
        float f522 = 8;
        TextKt.m941TextIbK3jfQ(builder22.toAnnotatedString(), RowScope.weight$default(rowScopeInstance22, PaddingKt.m315paddingqDBjuR0$default(companion32, Dp.m2599constructorimpl(f522), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, TypographyKt.getSub(), startRestartGroup, 0, 12582912, 131068);
        nullIfZero = PriceWithCurrencyExtensionsKt.nullIfZero(priceWithCurrency4);
        composer2 = startRestartGroup;
        composer2.startReplaceGroup(591746569);
        if (nullIfZero != null) {
        }
        composer2.endReplaceGroup();
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        priceWithCurrency3 = priceWithCurrency4;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SummaryRow$lambda$4(int i5, String str, Integer num, PriceWithCurrency priceWithCurrency, int i6, int i7, Composer composer, int i8) {
        SummaryRow(i5, str, num, priceWithCurrency, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }
}
