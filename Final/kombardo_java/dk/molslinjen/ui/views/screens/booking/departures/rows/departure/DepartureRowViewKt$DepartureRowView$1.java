package dk.molslinjen.ui.views.screens.booking.departures.rows.departure;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.ui.views.reusable.modifiers.AnimatedClickableKt;
import dk.molslinjen.ui.views.reusable.ticket.TicketBackgroundViewKt;
import dk.molslinjen.ui.views.reusable.ticket.TicketInfoBannerViewKt;
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
public final class DepartureRowViewKt$DepartureRowView$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ Departure $departure;
    final /* synthetic */ boolean $inSelectForSaleOnBoardMode;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Departure, Unit> $onSelected;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $scale;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ boolean $showDisabled;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public DepartureRowViewKt$DepartureRowView$1(Modifier modifier, boolean z5, CoroutineScope coroutineScope, Animatable<Float, AnimationVector1D> animatable, Function1<? super Departure, Unit> function1, Departure departure, boolean z6, boolean z7) {
        this.$modifier = modifier;
        this.$showDisabled = z5;
        this.$coroutineScope = coroutineScope;
        this.$scale = animatable;
        this.$onSelected = function1;
        this.$departure = departure;
        this.$selected = z6;
        this.$inSelectForSaleOnBoardMode = z7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier invoke$lambda$2$lambda$1(CoroutineScope coroutineScope, Animatable animatable, final Function1 function1, final Departure departure, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return AnimatedClickableKt.clickableWithScaleAnimation(applyIf, coroutineScope, animatable, 200, 0.9f, new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.departures.rows.departure.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit invoke$lambda$2$lambda$1$lambda$0;
                invoke$lambda$2$lambda$1$lambda$0 = DepartureRowViewKt$DepartureRowView$1.invoke$lambda$2$lambda$1$lambda$0(Function1.this, departure);
                return invoke$lambda$2$lambda$1$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1$lambda$0(Function1 function1, Departure departure) {
        function1.invoke(departure);
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
            ComposerKt.traceEventStart(-1678916860, i5, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureRowView.<anonymous> (DepartureRowView.kt:81)");
        }
        Modifier modifier = this.$modifier;
        boolean z5 = !this.$showDisabled;
        composer.startReplaceGroup(1702194371);
        boolean changedInstance = composer.changedInstance(this.$coroutineScope) | composer.changedInstance(this.$scale) | composer.changed(this.$onSelected) | composer.changedInstance(this.$departure);
        final CoroutineScope coroutineScope = this.$coroutineScope;
        final Animatable<Float, AnimationVector1D> animatable = this.$scale;
        final Function1<Departure, Unit> function1 = this.$onSelected;
        final Departure departure = this.$departure;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.booking.departures.rows.departure.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Modifier invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = DepartureRowViewKt$DepartureRowView$1.invoke$lambda$2$lambda$1(CoroutineScope.this, animatable, function1, departure, (Modifier) obj);
                    return invoke$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        Modifier applyIf = ModifierExtensionsKt.applyIf(modifier, z5, (Function1) rememberedValue);
        Departure departure2 = this.$departure;
        boolean z6 = this.$showDisabled;
        boolean z7 = this.$selected;
        boolean z8 = this.$inSelectForSaleOnBoardMode;
        Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
        Alignment.Companion companion = Alignment.INSTANCE;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion.getStart(), composer, 0);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, applyIf);
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        String information = departure2.getInformation();
        composer.startReplaceGroup(-929165839);
        if (information != null) {
            TicketInfoBannerViewKt.TicketInfoBannerView(columnScopeInstance.align(Modifier.INSTANCE, companion.getEnd()), information, departure2.getSoldOut() || departure2.getCancelled(), composer, 0);
        }
        composer.endReplaceGroup();
        Alignment center = companion.getCenter();
        Modifier.Companion companion3 = Modifier.INSTANCE;
        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion3);
        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
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
        Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion2.getSetModifier());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        composer.startReplaceGroup(134324899);
        Object rememberedValue2 = composer.rememberedValue();
        Composer.Companion companion4 = Composer.INSTANCE;
        if (rememberedValue2 == companion4.getEmpty()) {
            rememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(0);
            composer.updateRememberedValue(rememberedValue2);
        }
        MutableIntState mutableIntState = (MutableIntState) rememberedValue2;
        composer.endReplaceGroup();
        composer.startReplaceGroup(134327491);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion4.getEmpty()) {
            rememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
            composer.updateRememberedValue(rememberedValue3);
        }
        MutableIntState mutableIntState2 = (MutableIntState) rememberedValue3;
        composer.endReplaceGroup();
        TicketBackgroundViewKt.TicketBackgroundView(SizeKt.m325height3ABfNKs(companion3, ComposeExtensionsKt.pxToDp(mutableIntState.getIntValue(), composer, 0)), z6, false, information == null, z7, false, composer, 0, 36);
        DepartureRowViewKt.DepartureContentView(mutableIntState, departure2, z6, z7, mutableIntState2, z8, composer, 24582);
        composer.endNode();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
