package dk.molslinjen.ui.views.screens.tickets;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
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
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.extensions.domain.BookingExtensionsKt;
import dk.molslinjen.domain.model.booking.BookingHeader;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.extensions.domain.TicketCategoryExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.views.reusable.VerticalDividerKt;
import dk.molslinjen.ui.views.reusable.modifiers.AnimatedClickableKt;
import dk.molslinjen.ui.views.reusable.ticket.TicketBackgroundViewKt;
import dk.molslinjen.ui.views.reusable.ticket.TicketInfoBannerViewKt;
import dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureInfoSectionViewKt;
import dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.LineIconViewKt;
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
public final class TicketRowViewKt$TicketRowView$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ String $address;
    final /* synthetic */ boolean $allowedToShowDetails;
    final /* synthetic */ BookingHeader $bookingHeader;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ boolean $isHistory;
    final /* synthetic */ boolean $isWalkingForEarlyCheckIn;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $scale;
    final /* synthetic */ Function0<Unit> $showDetails;
    final /* synthetic */ Function1<String, Unit> $showOnMap;
    final /* synthetic */ Function0<Unit> $startEarlyCheckIn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public TicketRowViewKt$TicketRowView$1(boolean z5, CoroutineScope coroutineScope, Animatable<Float, AnimationVector1D> animatable, Function0<Unit> function0, BookingHeader bookingHeader, boolean z6, String str, Function1<? super String, Unit> function1, boolean z7, Function0<Unit> function02) {
        this.$allowedToShowDetails = z5;
        this.$coroutineScope = coroutineScope;
        this.$scale = animatable;
        this.$showDetails = function0;
        this.$bookingHeader = bookingHeader;
        this.$isHistory = z6;
        this.$address = str;
        this.$showOnMap = function1;
        this.$isWalkingForEarlyCheckIn = z7;
        this.$startEarlyCheckIn = function02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$12$lambda$11$lambda$5$lambda$4(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier invoke$lambda$2$lambda$1(CoroutineScope coroutineScope, Animatable animatable, final Function0 function0, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return AnimatedClickableKt.clickableWithScaleAnimation(applyIf, coroutineScope, animatable, 200, 0.9f, new Function0() { // from class: dk.molslinjen.ui.views.screens.tickets.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit invoke$lambda$2$lambda$1$lambda$0;
                invoke$lambda$2$lambda$1$lambda$0 = TicketRowViewKt$TicketRowView$1.invoke$lambda$2$lambda$1$lambda$0(Function0.this);
                return invoke$lambda$2$lambda$1$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2044508738, i5, -1, "dk.molslinjen.ui.views.screens.tickets.TicketRowView.<anonymous> (TicketRowView.kt:65)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        boolean z5 = this.$allowedToShowDetails;
        composer.startReplaceGroup(-131675619);
        boolean changedInstance = composer.changedInstance(this.$coroutineScope) | composer.changedInstance(this.$scale) | composer.changed(this.$showDetails);
        final CoroutineScope coroutineScope = this.$coroutineScope;
        final Animatable<Float, AnimationVector1D> animatable = this.$scale;
        final Function0<Unit> function0 = this.$showDetails;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.tickets.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Modifier invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = TicketRowViewKt$TicketRowView$1.invoke$lambda$2$lambda$1(CoroutineScope.this, animatable, function0, (Modifier) obj);
                    return invoke$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        Modifier applyIf = ModifierExtensionsKt.applyIf(companion, z5, (Function1) rememberedValue);
        BookingHeader bookingHeader = this.$bookingHeader;
        boolean z6 = this.$isHistory;
        String str = this.$address;
        Function1<String, Unit> function1 = this.$showOnMap;
        boolean z7 = this.$isWalkingForEarlyCheckIn;
        Function0<Unit> function02 = this.$startEarlyCheckIn;
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
        composer.startReplaceGroup(-1780207402);
        if (bookingHeader.getRefunded()) {
            TicketInfoBannerViewKt.TicketInfoBannerView(columnScopeInstance.align(companion, companion2.getEnd()), StringResources_androidKt.stringResource(R.string.tickets_ticketRefunded, composer, 6), true, composer, 384);
        }
        composer.endReplaceGroup();
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
        composer.startReplaceGroup(-1106179422);
        Object rememberedValue2 = composer.rememberedValue();
        Composer.Companion companion4 = Composer.INSTANCE;
        if (rememberedValue2 == companion4.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        final MutableState mutableState = (MutableState) rememberedValue2;
        composer.endReplaceGroup();
        TicketBackgroundViewKt.TicketBackgroundView(SizeKt.m325height3ABfNKs(companion, ComposeExtensionsKt.pxToDp(((Number) mutableState.getValue()).intValue(), composer, 0)), false, false, !bookingHeader.getRefunded(), false, false, composer, 196656, 20);
        IntrinsicSize intrinsicSize = IntrinsicSize.Max;
        Modifier height = IntrinsicKt.height(companion, intrinsicSize);
        composer.startReplaceGroup(-1106164443);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion4.getEmpty()) {
            rememberedValue3 = new Function1() { // from class: dk.molslinjen.ui.views.screens.tickets.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$12$lambda$11$lambda$5$lambda$4;
                    invoke$lambda$12$lambda$11$lambda$5$lambda$4 = TicketRowViewKt$TicketRowView$1.invoke$lambda$12$lambda$11$lambda$5$lambda$4(MutableState.this, (LayoutCoordinates) obj);
                    return invoke$lambda$12$lambda$11$lambda$5$lambda$4;
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
        BoxKt.Box(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(f5)), 0.0f, 1, null), TicketCategoryExtensionsKt.getColor(bookingHeader.getTicketCategory()), null, 2, null), composer, 0);
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer, 0);
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
        Updater.m1227setimpl(m1226constructorimpl4, columnMeasurePolicy2, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
            m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
            m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
        }
        Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion3.getSetModifier());
        Modifier height2 = IntrinsicKt.height(companion, intrinsicSize);
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer, 0);
        int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer, height2);
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
        Updater.m1227setimpl(m1226constructorimpl5, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl5, currentCompositionLocalMap5, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl5.getInserting() || !Intrinsics.areEqual(m1226constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
            m1226constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
            m1226constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
        }
        Updater.m1227setimpl(m1226constructorimpl5, materializeModifier5, companion3.getSetModifier());
        float f6 = 16;
        float f7 = 10;
        Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(RowScope.weight$default(rowScopeInstance, companion, 5.0f, false, 2, null), Dp.m2599constructorimpl(f6), 0.0f, 2, null), 0.0f, Dp.m2599constructorimpl(12), 0.0f, Dp.m2599constructorimpl(f7), 5, null);
        MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer, 0);
        int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap6 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(composer, m315paddingqDBjuR0$default);
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
        Updater.m1227setimpl(m1226constructorimpl6, columnMeasurePolicy3, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl6, currentCompositionLocalMap6, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl6.getInserting() || !Intrinsics.areEqual(m1226constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
            m1226constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
            m1226constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
        }
        Updater.m1227setimpl(m1226constructorimpl6, materializeModifier6, companion3.getSetModifier());
        LineIconViewKt.LineIconView(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f7), 7, null), bookingHeader.getSubline(), bookingHeader.getLineLogoUrl(), composer, 6, 0);
        FlowLayoutKt.FlowRow(null, null, null, 0, 0, null, ComposableLambdaKt.rememberComposableLambda(1483163725, true, new TicketRowViewKt$TicketRowView$1$2$1$2$1$1$1$1(bookingHeader), composer, 54), composer, 1572864, 63);
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), composer, 6);
        DepartureInfoSectionViewKt.DepartureInfoSection(null, null, bookingHeader, false, false, composer, 3072, 19);
        boolean isEarlyCheckInAllowedNow = BookingExtensionsKt.isEarlyCheckInAllowedNow(bookingHeader);
        composer.startReplaceGroup(91429651);
        if (!z6 && (isEarlyCheckInAllowedNow || bookingHeader.isCheckedIn())) {
            TicketRowViewKt.EarlyCheckInSection(isEarlyCheckInAllowedNow, bookingHeader.isCheckedIn(), z7, function02, composer, 0);
        }
        composer.endReplaceGroup();
        composer.endNode();
        VerticalDividerKt.m3394VerticalDividertZIQpXc(PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), 0.0f, Dp.m2599constructorimpl(f6), 0.0f, Dp.m2599constructorimpl(f5), 5, null), 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(2)), composer, 3078, 6);
        Modifier weight$default = RowScope.weight$default(rowScopeInstance, SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), 1.0f, false, 2, null);
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
        composer.endNode();
        TicketRowViewKt.DepartingAddressInfo(z6, str, bookingHeader, function1, composer, 0);
        composer.endNode();
        composer.endNode();
        composer.startReplaceGroup(-1106022428);
        if (z6) {
            TicketBackgroundViewKt.TicketBackgroundView(SizeKt.m325height3ABfNKs(companion, ComposeExtensionsKt.pxToDp(((Number) mutableState.getValue()).intValue(), composer, 0)), true, true, !bookingHeader.getRefunded(), false, false, composer, 197040, 16);
        }
        composer.endReplaceGroup();
        composer.endNode();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
