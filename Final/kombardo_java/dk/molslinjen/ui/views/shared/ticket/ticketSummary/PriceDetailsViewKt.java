package dk.molslinjen.ui.views.shared.ticket.ticketSummary;

import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.managers.checkout.PriceDetails;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.extensions.domain.PriceFormatExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.ShowDetailsButtonKt;
import dk.molslinjen.ui.views.shared.components.PriceTextKt;
import dk.molslinjen.ui.views.shared.components.PriceViewType;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.PriceDetailsViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a7\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u0011\u001a\u00020\u0004*\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u0000H\u0003¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0014H\u0003¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0018²\u0006\u000e\u0010\u0017\u001a\u00020\n8\n@\nX\u008a\u008e\u0002"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/PriceDetails;", "priceDetails", "Landroidx/compose/ui/text/TextStyle;", "totalPriceTextStyle", BuildConfig.FLAVOR, "PriceDetailsView", "(Ldk/molslinjen/domain/managers/checkout/PriceDetails;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;II)V", "Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "price", "titleTextStyle", BuildConfig.FLAVOR, "isEditing", BuildConfig.FLAVOR, "priceTotalText", "TotalPriceRow", "(Ldk/molslinjen/domain/managers/checkout/PriceTotal;Landroidx/compose/ui/text/TextStyle;ZLjava/lang/String;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/ColumnScope;", "DetailsSection", "(Landroidx/compose/foundation/layout/ColumnScope;Ldk/molslinjen/domain/managers/checkout/PriceDetails;Landroidx/compose/runtime/Composer;I)V", Constants.IntentExtra.PushTitle, "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "PriceRow", "(Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Landroidx/compose/runtime/Composer;I)V", "showDetails", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PriceDetailsViewKt {
    private static final void DetailsSection(final ColumnScope columnScope, final PriceDetails priceDetails, Composer composer, final int i5) {
        int i6;
        final MutableState mutableState;
        Composer startRestartGroup = composer.startRestartGroup(-200592783);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(columnScope) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(priceDetails) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-200592783, i6, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.DetailsSection (PriceDetailsView.kt:115)");
            }
            if (!priceDetails.getIsEditing() || (priceDetails.getChangeFee() == null && !priceDetails.getNonRefundableAddons() && priceDetails.getUnavailableFood() == null)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: C4.i
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit DetailsSection$lambda$8;
                            DetailsSection$lambda$8 = PriceDetailsViewKt.DetailsSection$lambda$8(ColumnScope.this, priceDetails, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return DetailsSection$lambda$8;
                        }
                    });
                    return;
                }
                return;
            }
            startRestartGroup.startReplaceGroup(613294320);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState2 = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            AnimatedVisibilityKt.AnimatedVisibility(columnScope, DetailsSection$lambda$10(mutableState2), (Modifier) null, EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null), EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null), (String) null, ComposableLambdaKt.rememberComposableLambda(325718681, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.PriceDetailsViewKt$DetailsSection$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                    invoke(animatedVisibilityScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i7) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(325718681, i7, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.DetailsSection.<anonymous> (PriceDetailsView.kt:129)");
                    }
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion2, Dp.m2599constructorimpl(8), 0.0f, 2, null);
                    PriceDetails priceDetails2 = PriceDetails.this;
                    boolean z5 = false;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m313paddingVpY3zN4$default);
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
                    PriceWithCurrency changeFee = priceDetails2.getChangeFee();
                    composer2.startReplaceGroup(-1582883902);
                    if (changeFee != null) {
                        PriceDetailsViewKt.PriceRow(StringResources_androidKt.stringResource(R.string.priceDetails_changeFee, composer2, 6), changeFee, composer2, 0);
                        z5 = true;
                    }
                    composer2.endReplaceGroup();
                    composer2.startReplaceGroup(-1582848055);
                    if (z5) {
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(14)), composer2, 6);
                    }
                    composer2.endReplaceGroup();
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i6 & 14) | 1600512, 18);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(16), 7, null), 0.0f, 1, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.priceDetails_showDetails, startRestartGroup, 6);
            String stringResource2 = StringResources_androidKt.stringResource(R.string.priceDetails_hideDetails, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(613352844);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                mutableState = mutableState2;
                rememberedValue2 = new Function0() { // from class: C4.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DetailsSection$lambda$13$lambda$12;
                        DetailsSection$lambda$13$lambda$12 = PriceDetailsViewKt.DetailsSection$lambda$13$lambda$12(MutableState.this);
                        return DetailsSection$lambda$13$lambda$12;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            } else {
                mutableState = mutableState2;
            }
            startRestartGroup.endReplaceGroup();
            ShowDetailsButtonKt.ShowDetailsButton(fillMaxWidth$default, stringResource, stringResource2, (Function0) rememberedValue2, DetailsSection$lambda$10(mutableState), startRestartGroup, 3078, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: C4.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DetailsSection$lambda$14;
                    DetailsSection$lambda$14 = PriceDetailsViewKt.DetailsSection$lambda$14(ColumnScope.this, priceDetails, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DetailsSection$lambda$14;
                }
            });
        }
    }

    private static final boolean DetailsSection$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void DetailsSection$lambda$11(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailsSection$lambda$13$lambda$12(MutableState mutableState) {
        DetailsSection$lambda$11(mutableState, !DetailsSection$lambda$10(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailsSection$lambda$14(ColumnScope columnScope, PriceDetails priceDetails, int i5, Composer composer, int i6) {
        DetailsSection(columnScope, priceDetails, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailsSection$lambda$8(ColumnScope columnScope, PriceDetails priceDetails, int i5, Composer composer, int i6) {
        DetailsSection(columnScope, priceDetails, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void PriceDetailsView(final PriceDetails priceDetails, final TextStyle textStyle, Composer composer, final int i5, final int i6) {
        int i7;
        Intrinsics.checkNotNullParameter(priceDetails, "priceDetails");
        Composer startRestartGroup = composer.startRestartGroup(-22633980);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(priceDetails) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i8 = i6 & 2;
        if (i8 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(textStyle) ? 32 : 16;
        }
        int i9 = i7;
        if ((i9 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i8 != 0) {
                textStyle = TypographyKt.getSubBold();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-22633980, i9, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.PriceDetailsView (PriceDetailsView.kt:46)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
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
            TotalPriceRow(priceDetails.getTotalPrice(), textStyle, priceDetails.getIsEditing(), null, startRestartGroup, i9 & 112, 8);
            DetailsSection(columnScopeInstance, priceDetails, startRestartGroup, ((i9 << 3) & 112) | 6);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: C4.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PriceDetailsView$lambda$1;
                    PriceDetailsView$lambda$1 = PriceDetailsViewKt.PriceDetailsView$lambda$1(PriceDetails.this, textStyle, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return PriceDetailsView$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PriceDetailsView$lambda$1(PriceDetails priceDetails, TextStyle textStyle, int i5, int i6, Composer composer, int i7) {
        PriceDetailsView(priceDetails, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PriceRow(final String str, final PriceWithCurrency priceWithCurrency, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1310868579);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(priceWithCurrency) ? 32 : 16;
        }
        int i7 = i6;
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1310868579, i7, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.PriceRow (PriceDetailsView.kt:178)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion, 0.0f, Dp.m2599constructorimpl(10), 1, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, i7 & 14, 1572864, 65534);
            PriceTextKt.m3557PriceText1y9Plug((Price) priceWithCurrency, RowScope.weight$default(rowScopeInstance, PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null), (PriceViewType) null, false, TypographyKt.getSubBold(), TextAlign.m2521boximpl(TextAlign.INSTANCE.m2529getEnde0LSkKk()), 1, 0L, composer2, ((i7 >> 3) & 14) | 1597440, 140);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: C4.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PriceRow$lambda$16;
                    PriceRow$lambda$16 = PriceDetailsViewKt.PriceRow$lambda$16(str, priceWithCurrency, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PriceRow$lambda$16;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PriceRow$lambda$16(String str, PriceWithCurrency priceWithCurrency, int i5, Composer composer, int i6) {
        PriceRow(str, priceWithCurrency, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TotalPriceRow(final PriceTotal price, TextStyle textStyle, boolean z5, String str, Composer composer, final int i5, final int i6) {
        int i7;
        TextStyle textStyle2;
        int i8;
        boolean z6;
        int i9;
        String str2;
        boolean z7;
        String stringResource;
        String str3;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        boolean changedInstance;
        Object rememberedValue;
        int currentCompositeKeyHash3;
        Composer m1226constructorimpl3;
        Composer composer2;
        final TextStyle textStyle3;
        final boolean z8;
        final String str4;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(price, "price");
        Composer startRestartGroup = composer.startRestartGroup(-1736133596);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(price) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i10 = i6 & 2;
        if (i10 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            textStyle2 = textStyle;
            i7 |= startRestartGroup.changed(textStyle2) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                z6 = z5;
                i7 |= startRestartGroup.changed(z6) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    str2 = str;
                    i7 |= startRestartGroup.changed(str2) ? 2048 : 1024;
                    if ((i7 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                        TextStyle sub = i10 == 0 ? TypographyKt.getSub() : textStyle2;
                        z7 = i8 == 0 ? false : z6;
                        String str5 = i9 == 0 ? null : str2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1736133596, i7, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.TotalPriceRow (PriceDetailsView.kt:64)");
                        }
                        if (!z7) {
                            startRestartGroup.startReplaceGroup(653992704);
                            stringResource = StringResources_androidKt.stringResource(R.string.priceDetails_changePrice, startRestartGroup, 6);
                            startRestartGroup.endReplaceGroup();
                        } else if (str5 != null) {
                            startRestartGroup.startReplaceGroup(653995512);
                            startRestartGroup.endReplaceGroup();
                            str3 = str5;
                            Modifier.Companion companion = Modifier.INSTANCE;
                            float f5 = 8;
                            Modifier m314paddingqDBjuR0 = PaddingKt.m314paddingqDBjuR0(companion, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(10), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(16));
                            Arrangement arrangement = Arrangement.INSTANCE;
                            Arrangement.Vertical top = arrangement.getTop();
                            Alignment.Companion companion2 = Alignment.INSTANCE;
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m314paddingqDBjuR0);
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
                            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                            if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), startRestartGroup, 48);
                            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
                            m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                            if (!m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            TextKt.m940Text4IGK_g(str3, RowScope.weight$default(rowScopeInstance, rowScopeInstance.alignByBaseline(companion), 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, sub, startRestartGroup, 0, (i7 << 15) & 3670016, 65532);
                            final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                            startRestartGroup.startReplaceGroup(-927147975);
                            changedInstance = startRestartGroup.changedInstance(price) | startRestartGroup.changedInstance(context);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new Function1() { // from class: C4.f
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Unit TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2;
                                        TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2 = PriceDetailsViewKt.TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2(PriceTotal.this, context, (SemanticsPropertyReceiver) obj);
                                        return TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceGroup();
                            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) rememberedValue);
                            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), startRestartGroup, 48);
                            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics);
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
                            m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
                            Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
                            if (!m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                            }
                            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
                            int i11 = (i7 & 14) | 24960;
                            PriceTextKt.m3556PriceText1y9Plug(price, rowScopeInstance.alignByBaseline(companion), PriceViewType.PriceOnly, false, TypographyKt.getH2Bold(), (TextAlign) null, 0, 0L, startRestartGroup, i11, 232);
                            PriceTextKt.m3556PriceText1y9Plug(price, PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance.alignByBaseline(companion), Dp.m2599constructorimpl(2), 0.0f, 0.0f, 0.0f, 14, null), PriceViewType.CurrencyOnly, false, TypographyKt.getSub(), (TextAlign) null, 0, 0L, startRestartGroup, i11, 232);
                            startRestartGroup.endNode();
                            startRestartGroup.endNode();
                            composer2 = startRestartGroup;
                            composer2.startReplaceGroup(-1305983584);
                            if (price.getPrice().getValue() < 0) {
                                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.priceDetails_refundDetails, composer2, 6), null, AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 384, 1572864, 65530);
                            }
                            composer2.endReplaceGroup();
                            composer2.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            textStyle3 = sub;
                            z8 = z7;
                            str4 = str5;
                        } else {
                            startRestartGroup.startReplaceGroup(653996536);
                            stringResource = StringResources_androidKt.stringResource(R.string.ticketInfo_totalPrice, startRestartGroup, 6);
                            startRestartGroup.endReplaceGroup();
                        }
                        str3 = stringResource;
                        Modifier.Companion companion4 = Modifier.INSTANCE;
                        float f52 = 8;
                        Modifier m314paddingqDBjuR02 = PaddingKt.m314paddingqDBjuR0(companion4, Dp.m2599constructorimpl(f52), Dp.m2599constructorimpl(10), Dp.m2599constructorimpl(f52), Dp.m2599constructorimpl(16));
                        Arrangement arrangement2 = Arrangement.INSTANCE;
                        Arrangement.Vertical top2 = arrangement2.getTop();
                        Alignment.Companion companion22 = Alignment.INSTANCE;
                        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(top2, companion22.getStart(), startRestartGroup, 0);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, m314paddingqDBjuR02);
                        ComposeUiNode.Companion companion32 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor4 = companion32.getConstructor();
                        if (startRestartGroup.getApplier() == null) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion32.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap4, companion32.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion32.getSetCompositeKeyHash();
                        if (!m1226constructorimpl.getInserting()) {
                        }
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash4);
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier4, companion32.getSetModifier());
                        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                        MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion22.getCenterVertically(), startRestartGroup, 48);
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, companion4);
                        Function0<ComposeUiNode> constructor22 = companion32.getConstructor();
                        if (startRestartGroup.getApplier() == null) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                        Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy3, companion32.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion32.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion32.getSetCompositeKeyHash();
                        if (!m1226constructorimpl2.getInserting()) {
                        }
                        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
                        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion32.getSetModifier());
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        TextKt.m940Text4IGK_g(str3, RowScope.weight$default(rowScopeInstance2, rowScopeInstance2.alignByBaseline(companion4), 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, sub, startRestartGroup, 0, (i7 << 15) & 3670016, 65532);
                        final Context context2 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        startRestartGroup.startReplaceGroup(-927147975);
                        changedInstance = startRestartGroup.changedInstance(price) | startRestartGroup.changedInstance(context2);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changedInstance) {
                        }
                        rememberedValue = new Function1() { // from class: C4.f
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2;
                                TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2 = PriceDetailsViewKt.TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2(PriceTotal.this, context2, (SemanticsPropertyReceiver) obj);
                                return TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        startRestartGroup.endReplaceGroup();
                        Modifier clearAndSetSemantics2 = SemanticsModifierKt.clearAndSetSemantics(companion4, (Function1) rememberedValue);
                        MeasurePolicy rowMeasurePolicy22 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion22.getCenterVertically(), startRestartGroup, 48);
                        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics2);
                        Function0<ComposeUiNode> constructor32 = companion32.getConstructor();
                        if (startRestartGroup.getApplier() == null) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
                        Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy22, companion32.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap32, companion32.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = companion32.getSetCompositeKeyHash();
                        if (!m1226constructorimpl3.getInserting()) {
                        }
                        m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash32);
                        Updater.m1227setimpl(m1226constructorimpl3, materializeModifier32, companion32.getSetModifier());
                        int i112 = (i7 & 14) | 24960;
                        PriceTextKt.m3556PriceText1y9Plug(price, rowScopeInstance2.alignByBaseline(companion4), PriceViewType.PriceOnly, false, TypographyKt.getH2Bold(), (TextAlign) null, 0, 0L, startRestartGroup, i112, 232);
                        PriceTextKt.m3556PriceText1y9Plug(price, PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance2.alignByBaseline(companion4), Dp.m2599constructorimpl(2), 0.0f, 0.0f, 0.0f, 14, null), PriceViewType.CurrencyOnly, false, TypographyKt.getSub(), (TextAlign) null, 0, 0L, startRestartGroup, i112, 232);
                        startRestartGroup.endNode();
                        startRestartGroup.endNode();
                        composer2 = startRestartGroup;
                        composer2.startReplaceGroup(-1305983584);
                        if (price.getPrice().getValue() < 0) {
                        }
                        composer2.endReplaceGroup();
                        composer2.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        textStyle3 = sub;
                        z8 = z7;
                        str4 = str5;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        textStyle3 = textStyle2;
                        z8 = z6;
                        composer2 = startRestartGroup;
                        str4 = str2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: C4.g
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit TotalPriceRow$lambda$7;
                                TotalPriceRow$lambda$7 = PriceDetailsViewKt.TotalPriceRow$lambda$7(PriceTotal.this, textStyle3, z8, str4, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                return TotalPriceRow$lambda$7;
                            }
                        });
                        return;
                    }
                    return;
                }
                str2 = str;
                if ((i7 & 1171) == 1170) {
                }
                if (i10 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                if (!z7) {
                }
                str3 = stringResource;
                Modifier.Companion companion42 = Modifier.INSTANCE;
                float f522 = 8;
                Modifier m314paddingqDBjuR022 = PaddingKt.m314paddingqDBjuR0(companion42, Dp.m2599constructorimpl(f522), Dp.m2599constructorimpl(10), Dp.m2599constructorimpl(f522), Dp.m2599constructorimpl(16));
                Arrangement arrangement22 = Arrangement.INSTANCE;
                Arrangement.Vertical top22 = arrangement22.getTop();
                Alignment.Companion companion222 = Alignment.INSTANCE;
                MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(top22, companion222.getStart(), startRestartGroup, 0);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap42 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier42 = ComposedModifierKt.materializeModifier(startRestartGroup, m314paddingqDBjuR022);
                ComposeUiNode.Companion companion322 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor42 = companion322.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy22, companion322.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap42, companion322.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash42 = companion322.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash42);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier42, companion322.getSetModifier());
                ColumnScopeInstance columnScopeInstance22 = ColumnScopeInstance.INSTANCE;
                MeasurePolicy rowMeasurePolicy32 = RowKt.rowMeasurePolicy(arrangement22.getStart(), companion222.getCenterVertically(), startRestartGroup, 48);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, companion42);
                Function0<ComposeUiNode> constructor222 = companion322.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy32, companion322.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap222, companion322.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion322.getSetCompositeKeyHash();
                if (!m1226constructorimpl2.getInserting()) {
                }
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222);
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier222, companion322.getSetModifier());
                RowScopeInstance rowScopeInstance22 = RowScopeInstance.INSTANCE;
                TextKt.m940Text4IGK_g(str3, RowScope.weight$default(rowScopeInstance22, rowScopeInstance22.alignByBaseline(companion42), 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, sub, startRestartGroup, 0, (i7 << 15) & 3670016, 65532);
                final Context context22 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                startRestartGroup.startReplaceGroup(-927147975);
                changedInstance = startRestartGroup.changedInstance(price) | startRestartGroup.changedInstance(context22);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changedInstance) {
                }
                rememberedValue = new Function1() { // from class: C4.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2;
                        TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2 = PriceDetailsViewKt.TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2(PriceTotal.this, context22, (SemanticsPropertyReceiver) obj);
                        return TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceGroup();
                Modifier clearAndSetSemantics22 = SemanticsModifierKt.clearAndSetSemantics(companion42, (Function1) rememberedValue);
                MeasurePolicy rowMeasurePolicy222 = RowKt.rowMeasurePolicy(arrangement22.getStart(), companion222.getCenterVertically(), startRestartGroup, 48);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap322 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier322 = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics22);
                Function0<ComposeUiNode> constructor322 = companion322.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy222, companion322.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap322, companion322.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash322 = companion322.getSetCompositeKeyHash();
                if (!m1226constructorimpl3.getInserting()) {
                }
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash322);
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier322, companion322.getSetModifier());
                int i1122 = (i7 & 14) | 24960;
                PriceTextKt.m3556PriceText1y9Plug(price, rowScopeInstance22.alignByBaseline(companion42), PriceViewType.PriceOnly, false, TypographyKt.getH2Bold(), (TextAlign) null, 0, 0L, startRestartGroup, i1122, 232);
                PriceTextKt.m3556PriceText1y9Plug(price, PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance22.alignByBaseline(companion42), Dp.m2599constructorimpl(2), 0.0f, 0.0f, 0.0f, 14, null), PriceViewType.CurrencyOnly, false, TypographyKt.getSub(), (TextAlign) null, 0, 0L, startRestartGroup, i1122, 232);
                startRestartGroup.endNode();
                startRestartGroup.endNode();
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(-1305983584);
                if (price.getPrice().getValue() < 0) {
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                textStyle3 = sub;
                z8 = z7;
                str4 = str5;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z6 = z5;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            str2 = str;
            if ((i7 & 1171) == 1170) {
            }
            if (i10 == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (!z7) {
            }
            str3 = stringResource;
            Modifier.Companion companion422 = Modifier.INSTANCE;
            float f5222 = 8;
            Modifier m314paddingqDBjuR0222 = PaddingKt.m314paddingqDBjuR0(companion422, Dp.m2599constructorimpl(f5222), Dp.m2599constructorimpl(10), Dp.m2599constructorimpl(f5222), Dp.m2599constructorimpl(16));
            Arrangement arrangement222 = Arrangement.INSTANCE;
            Arrangement.Vertical top222 = arrangement222.getTop();
            Alignment.Companion companion2222 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy222 = ColumnKt.columnMeasurePolicy(top222, companion2222.getStart(), startRestartGroup, 0);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap422 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier422 = ComposedModifierKt.materializeModifier(startRestartGroup, m314paddingqDBjuR0222);
            ComposeUiNode.Companion companion3222 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor422 = companion3222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy222, companion3222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap422, companion3222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash422 = companion3222.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash422);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier422, companion3222.getSetModifier());
            ColumnScopeInstance columnScopeInstance222 = ColumnScopeInstance.INSTANCE;
            MeasurePolicy rowMeasurePolicy322 = RowKt.rowMeasurePolicy(arrangement222.getStart(), companion2222.getCenterVertically(), startRestartGroup, 48);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, companion422);
            Function0<ComposeUiNode> constructor2222 = companion3222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy322, companion3222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2222, companion3222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = companion3222.getSetCompositeKeyHash();
            if (!m1226constructorimpl2.getInserting()) {
            }
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2222);
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2222, companion3222.getSetModifier());
            RowScopeInstance rowScopeInstance222 = RowScopeInstance.INSTANCE;
            TextKt.m940Text4IGK_g(str3, RowScope.weight$default(rowScopeInstance222, rowScopeInstance222.alignByBaseline(companion422), 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, sub, startRestartGroup, 0, (i7 << 15) & 3670016, 65532);
            final Context context222 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            startRestartGroup.startReplaceGroup(-927147975);
            changedInstance = startRestartGroup.changedInstance(price) | startRestartGroup.changedInstance(context222);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            rememberedValue = new Function1() { // from class: C4.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2;
                    TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2 = PriceDetailsViewKt.TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2(PriceTotal.this, context222, (SemanticsPropertyReceiver) obj);
                    return TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceGroup();
            Modifier clearAndSetSemantics222 = SemanticsModifierKt.clearAndSetSemantics(companion422, (Function1) rememberedValue);
            MeasurePolicy rowMeasurePolicy2222 = RowKt.rowMeasurePolicy(arrangement222.getStart(), companion2222.getCenterVertically(), startRestartGroup, 48);
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3222 = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics222);
            Function0<ComposeUiNode> constructor3222 = companion3222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2222, companion3222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3222, companion3222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3222 = companion3222.getSetCompositeKeyHash();
            if (!m1226constructorimpl3.getInserting()) {
            }
            m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3222);
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3222, companion3222.getSetModifier());
            int i11222 = (i7 & 14) | 24960;
            PriceTextKt.m3556PriceText1y9Plug(price, rowScopeInstance222.alignByBaseline(companion422), PriceViewType.PriceOnly, false, TypographyKt.getH2Bold(), (TextAlign) null, 0, 0L, startRestartGroup, i11222, 232);
            PriceTextKt.m3556PriceText1y9Plug(price, PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance222.alignByBaseline(companion422), Dp.m2599constructorimpl(2), 0.0f, 0.0f, 0.0f, 14, null), PriceViewType.CurrencyOnly, false, TypographyKt.getSub(), (TextAlign) null, 0, 0L, startRestartGroup, i11222, 232);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            composer2 = startRestartGroup;
            composer2.startReplaceGroup(-1305983584);
            if (price.getPrice().getValue() < 0) {
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            textStyle3 = sub;
            z8 = z7;
            str4 = str5;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        textStyle2 = textStyle;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        z6 = z5;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        str2 = str;
        if ((i7 & 1171) == 1170) {
        }
        if (i10 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (!z7) {
        }
        str3 = stringResource;
        Modifier.Companion companion4222 = Modifier.INSTANCE;
        float f52222 = 8;
        Modifier m314paddingqDBjuR02222 = PaddingKt.m314paddingqDBjuR0(companion4222, Dp.m2599constructorimpl(f52222), Dp.m2599constructorimpl(10), Dp.m2599constructorimpl(f52222), Dp.m2599constructorimpl(16));
        Arrangement arrangement2222 = Arrangement.INSTANCE;
        Arrangement.Vertical top2222 = arrangement2222.getTop();
        Alignment.Companion companion22222 = Alignment.INSTANCE;
        MeasurePolicy columnMeasurePolicy2222 = ColumnKt.columnMeasurePolicy(top2222, companion22222.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap4222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier4222 = ComposedModifierKt.materializeModifier(startRestartGroup, m314paddingqDBjuR02222);
        ComposeUiNode.Companion companion32222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor4222 = companion32222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2222, companion32222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap4222, companion32222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4222 = companion32222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash4222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier4222, companion32222.getSetModifier());
        ColumnScopeInstance columnScopeInstance2222 = ColumnScopeInstance.INSTANCE;
        MeasurePolicy rowMeasurePolicy3222 = RowKt.rowMeasurePolicy(arrangement2222.getStart(), companion22222.getCenterVertically(), startRestartGroup, 48);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22222 = ComposedModifierKt.materializeModifier(startRestartGroup, companion4222);
        Function0<ComposeUiNode> constructor22222 = companion32222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy3222, companion32222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22222, companion32222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22222 = companion32222.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22222);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22222, companion32222.getSetModifier());
        RowScopeInstance rowScopeInstance2222 = RowScopeInstance.INSTANCE;
        TextKt.m940Text4IGK_g(str3, RowScope.weight$default(rowScopeInstance2222, rowScopeInstance2222.alignByBaseline(companion4222), 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, sub, startRestartGroup, 0, (i7 << 15) & 3670016, 65532);
        final Context context2222 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        startRestartGroup.startReplaceGroup(-927147975);
        changedInstance = startRestartGroup.changedInstance(price) | startRestartGroup.changedInstance(context2222);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue = new Function1() { // from class: C4.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2;
                TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2 = PriceDetailsViewKt.TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2(PriceTotal.this, context2222, (SemanticsPropertyReceiver) obj);
                return TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        Modifier clearAndSetSemantics2222 = SemanticsModifierKt.clearAndSetSemantics(companion4222, (Function1) rememberedValue);
        MeasurePolicy rowMeasurePolicy22222 = RowKt.rowMeasurePolicy(arrangement2222.getStart(), companion22222.getCenterVertically(), startRestartGroup, 48);
        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap32222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier32222 = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics2222);
        Function0<ComposeUiNode> constructor32222 = companion32222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy22222, companion32222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap32222, companion32222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32222 = companion32222.getSetCompositeKeyHash();
        if (!m1226constructorimpl3.getInserting()) {
        }
        m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
        m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash32222);
        Updater.m1227setimpl(m1226constructorimpl3, materializeModifier32222, companion32222.getSetModifier());
        int i112222 = (i7 & 14) | 24960;
        PriceTextKt.m3556PriceText1y9Plug(price, rowScopeInstance2222.alignByBaseline(companion4222), PriceViewType.PriceOnly, false, TypographyKt.getH2Bold(), (TextAlign) null, 0, 0L, startRestartGroup, i112222, 232);
        PriceTextKt.m3556PriceText1y9Plug(price, PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance2222.alignByBaseline(companion4222), Dp.m2599constructorimpl(2), 0.0f, 0.0f, 0.0f, 14, null), PriceViewType.CurrencyOnly, false, TypographyKt.getSub(), (TextAlign) null, 0, 0L, startRestartGroup, i112222, 232);
        startRestartGroup.endNode();
        startRestartGroup.endNode();
        composer2 = startRestartGroup;
        composer2.startReplaceGroup(-1305983584);
        if (price.getPrice().getValue() < 0) {
        }
        composer2.endReplaceGroup();
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        textStyle3 = sub;
        z8 = z7;
        str4 = str5;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TotalPriceRow$lambda$6$lambda$5$lambda$3$lambda$2(PriceTotal priceTotal, Context context, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, PriceFormatExtensionsKt.formatted$default(priceTotal, context, false, false, 6, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TotalPriceRow$lambda$7(PriceTotal priceTotal, TextStyle textStyle, boolean z5, String str, int i5, int i6, Composer composer, int i7) {
        TotalPriceRow(priceTotal, textStyle, z5, str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
