package dk.molslinjen.ui.views.screens.agreements.common;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.extensions.AccessibilityKt;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.agreement.IAgreementDeparture;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.extensions.domain.TicketCategoryExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.VerticalDividerKt;
import dk.molslinjen.ui.views.reusable.modifiers.AnimatedClickableKt;
import dk.molslinjen.ui.views.reusable.ticket.TicketBackgroundViewKt;
import dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureInfoSectionViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgreementDepartureRowViewKt$AgreementDepartureRowView$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ IAgreementDeparture $agreementDeparture;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ boolean $enableDetails;
    final /* synthetic */ boolean $isHistory;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $scale;
    final /* synthetic */ Function2<String, String, Unit> $showDetails;
    final /* synthetic */ TicketCategoryType $ticketCategory;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public AgreementDepartureRowViewKt$AgreementDepartureRowView$1(boolean z5, CoroutineScope coroutineScope, Animatable<Float, AnimationVector1D> animatable, IAgreementDeparture iAgreementDeparture, Function2<? super String, ? super String, Unit> function2, boolean z6, TicketCategoryType ticketCategoryType) {
        this.$enableDetails = z5;
        this.$coroutineScope = coroutineScope;
        this.$scale = animatable;
        this.$agreementDeparture = iAgreementDeparture;
        this.$showDetails = function2;
        this.$isHistory = z6;
        this.$ticketCategory = ticketCategoryType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$15$lambda$14$lambda$13$lambda$12$lambda$10$lambda$9$lambda$8$lambda$7(String str, IAgreementDeparture iAgreementDeparture, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str + " " + AccessibilityKt.splitNumberForAccessibility(iAgreementDeparture.getReservationNumber()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$15$lambda$14$lambda$6$lambda$5(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier invoke$lambda$3$lambda$2(CoroutineScope coroutineScope, Animatable animatable, final IAgreementDeparture iAgreementDeparture, final Function2 function2, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return AnimatedClickableKt.clickableWithScaleAnimation(applyIf, coroutineScope, animatable, 200, 0.9f, new Function0() { // from class: dk.molslinjen.ui.views.screens.agreements.common.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit invoke$lambda$3$lambda$2$lambda$1;
                invoke$lambda$3$lambda$2$lambda$1 = AgreementDepartureRowViewKt$AgreementDepartureRowView$1.invoke$lambda$3$lambda$2$lambda$1(IAgreementDeparture.this, function2);
                return invoke$lambda$3$lambda$2$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2$lambda$1(IAgreementDeparture iAgreementDeparture, Function2 function2) {
        String phone = iAgreementDeparture.getPhone();
        if (phone != null) {
            function2.invoke(iAgreementDeparture.getReservationNumber(), phone);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        int i6;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(694791226, i5, -1, "dk.molslinjen.ui.views.screens.agreements.common.AgreementDepartureRowView.<anonymous> (AgreementDepartureRowView.kt:66)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        boolean z5 = this.$enableDetails;
        composer.startReplaceGroup(-1163486908);
        boolean changedInstance = composer.changedInstance(this.$coroutineScope) | composer.changedInstance(this.$scale) | composer.changedInstance(this.$agreementDeparture) | composer.changed(this.$showDetails);
        final CoroutineScope coroutineScope = this.$coroutineScope;
        final Animatable<Float, AnimationVector1D> animatable = this.$scale;
        final IAgreementDeparture iAgreementDeparture = this.$agreementDeparture;
        final Function2<String, String, Unit> function2 = this.$showDetails;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.agreements.common.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Modifier invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = AgreementDepartureRowViewKt$AgreementDepartureRowView$1.invoke$lambda$3$lambda$2(CoroutineScope.this, animatable, iAgreementDeparture, function2, (Modifier) obj);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        Modifier applyIf = ModifierExtensionsKt.applyIf(companion, z5, (Function1) rememberedValue);
        boolean z6 = this.$isHistory;
        TicketCategoryType ticketCategoryType = this.$ticketCategory;
        boolean z7 = this.$enableDetails;
        final IAgreementDeparture iAgreementDeparture2 = this.$agreementDeparture;
        Arrangement arrangement = Arrangement.INSTANCE;
        Arrangement.Vertical top = arrangement.getTop();
        Alignment.Companion companion2 = Alignment.INSTANCE;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, applyIf);
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion);
        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor2);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        composer.startReplaceGroup(1492549517);
        Object rememberedValue2 = composer.rememberedValue();
        Composer.Companion companion4 = Composer.INSTANCE;
        if (rememberedValue2 == companion4.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        final MutableState mutableState = (MutableState) rememberedValue2;
        composer.endReplaceGroup();
        TicketBackgroundViewKt.TicketBackgroundView(SizeKt.m325height3ABfNKs(companion, ComposeExtensionsKt.pxToDp(((Number) mutableState.getValue()).intValue(), composer, 0)), false, false, false, false, false, composer, 196656, 28);
        Modifier height = IntrinsicKt.height(companion, IntrinsicSize.Min);
        composer.startReplaceGroup(1492562288);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion4.getEmpty()) {
            rememberedValue3 = new Function1() { // from class: dk.molslinjen.ui.views.screens.agreements.common.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$15$lambda$14$lambda$6$lambda$5;
                    invoke$lambda$15$lambda$14$lambda$6$lambda$5 = AgreementDepartureRowViewKt$AgreementDepartureRowView$1.invoke$lambda$15$lambda$14$lambda$6$lambda$5(MutableState.this, (LayoutCoordinates) obj);
                    return invoke$lambda$15$lambda$14$lambda$6$lambda$5;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        Modifier clip = ClipKt.clip(OnGloballyPositionedModifierKt.onGloballyPositioned(height, (Function1) rememberedValue3), ThemeShapesKt.getThemeShapes().getMedium());
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer, 0);
        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, clip);
        Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor3);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
            m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
        }
        Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        float f5 = 8;
        BoxKt.Box(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(f5)), 0.0f, 1, null), ticketCategoryType != null ? TicketCategoryExtensionsKt.getColor(ticketCategoryType) : AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null), composer, 0);
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer, 0);
        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, companion);
        Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor4);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl4 = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl4, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
            m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
            m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
        }
        Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion3.getSetModifier());
        float f6 = 16;
        Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(RowScope.weight$default(rowScopeInstance, companion, 5.0f, false, 2, null), Dp.m2599constructorimpl(f6));
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer, 0);
        int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer, m311padding3ABfNKs);
        Function0<ComposeUiNode> constructor5 = companion3.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor5);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl5 = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl5, columnMeasurePolicy2, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl5, currentCompositionLocalMap5, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl5.getInserting() || !Intrinsics.areEqual(m1226constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
            m1226constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
            m1226constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
        }
        Updater.m1227setimpl(m1226constructorimpl5, materializeModifier5, companion3.getSetModifier());
        MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer, 0);
        int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap6 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(composer, companion);
        Function0<ComposeUiNode> constructor6 = companion3.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor6);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl6 = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl6, rowMeasurePolicy3, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl6, currentCompositionLocalMap6, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl6.getInserting() || !Intrinsics.areEqual(m1226constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
            m1226constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
            m1226constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
        }
        Updater.m1227setimpl(m1226constructorimpl6, materializeModifier6, companion3.getSetModifier());
        String formatWeekdayWithDate = LocalDateTimeExtensionsKt.toFormatWeekdayWithDate(iAgreementDeparture2.getDate());
        TextStyle sub = TypographyKt.getSub();
        AppColor appColor = AppColor.INSTANCE;
        TextKt.m940Text4IGK_g(formatWeekdayWithDate, null, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, sub, composer, 384, 1572864, 65530);
        SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
        final String stringResource = StringResources_androidKt.stringResource(R.string.common_reservationNumber, composer, 6);
        composer.startReplaceGroup(-1995690407);
        boolean changed = composer.changed(stringResource) | composer.changedInstance(iAgreementDeparture2);
        Object rememberedValue4 = composer.rememberedValue();
        if (changed || rememberedValue4 == companion4.getEmpty()) {
            rememberedValue4 = new Function1() { // from class: dk.molslinjen.ui.views.screens.agreements.common.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$15$lambda$14$lambda$13$lambda$12$lambda$10$lambda$9$lambda$8$lambda$7;
                    invoke$lambda$15$lambda$14$lambda$13$lambda$12$lambda$10$lambda$9$lambda$8$lambda$7 = AgreementDepartureRowViewKt$AgreementDepartureRowView$1.invoke$lambda$15$lambda$14$lambda$13$lambda$12$lambda$10$lambda$9$lambda$8$lambda$7(stringResource, iAgreementDeparture2, (SemanticsPropertyReceiver) obj);
                    return invoke$lambda$15$lambda$14$lambda$13$lambda$12$lambda$10$lambda$9$lambda$8$lambda$7;
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceGroup();
        TextKt.m940Text4IGK_g("#" + iAgreementDeparture2.getReservationNumber(), SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue4, 1, null), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer, 384, 1572864, 65528);
        composer.endNode();
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), composer, 6);
        DepartureInfoSectionViewKt.DepartureInfoSection(null, null, iAgreementDeparture2, false, false, composer, 3072, 19);
        composer.endNode();
        composer.startReplaceGroup(-664850162);
        if (z7) {
            VerticalDividerKt.m3394VerticalDividertZIQpXc(PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), 0.0f, Dp.m2599constructorimpl(f6), 0.0f, Dp.m2599constructorimpl(f5), 5, null), 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(2)), composer, 3078, 6);
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), 1.0f, false, 2, null);
            i6 = 0;
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier7 = ComposedModifierKt.materializeModifier(composer, weight$default);
            Function0<ComposeUiNode> constructor7 = companion3.getConstructor();
            if (composer.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor7);
            } else {
                composer.useNode();
            }
            Composer m1226constructorimpl7 = Updater.m1226constructorimpl(composer);
            Updater.m1227setimpl(m1226constructorimpl7, maybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl7, currentCompositionLocalMap7, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl7.getInserting() || !Intrinsics.areEqual(m1226constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                m1226constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                m1226constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
            }
            Updater.m1227setimpl(m1226constructorimpl7, materializeModifier7, companion3.getSetModifier());
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_forward_arrow, composer, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 11, null), Dp.m2599constructorimpl(f6)), 0L, composer, 384, 8);
            composer.endNode();
        } else {
            i6 = 0;
        }
        composer.endReplaceGroup();
        composer.endNode();
        composer.endNode();
        composer.startReplaceGroup(1492663526);
        if (z6) {
            TicketBackgroundViewKt.TicketBackgroundView(SizeKt.m325height3ABfNKs(companion, ComposeExtensionsKt.pxToDp(((Number) mutableState.getValue()).intValue(), composer, i6)), true, true, false, false, false, composer, 197040, 24);
        }
        composer.endReplaceGroup();
        composer.endNode();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
