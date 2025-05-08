package dk.molslinjen.ui.views.reusable.bottomsheet;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntSize;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BottomSheetContainerKt$BottomSheetContainer$4$2$3 implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $footer;
    final /* synthetic */ ScrollableState $scrollState;
    final /* synthetic */ MutableIntState $stickyFooterHeight$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public BottomSheetContainerKt$BottomSheetContainer$4$2$3(ScrollableState scrollableState, MutableIntState mutableIntState, Function2<? super Composer, ? super Integer, Unit> function2) {
        this.$scrollState = scrollableState;
        this.$stickyFooterHeight$delegate = mutableIntState;
        this.$footer = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableIntState mutableIntState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableIntState.setIntValue(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier invoke$lambda$3$lambda$2(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return ModifierExtensionsKt.topShadow(applyIf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$5$lambda$4(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setTraversalGroup(semantics, true);
        SemanticsPropertiesKt.setTraversalIndex(semantics, -20.0f);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
        invoke(animatedVisibilityScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(654420022, i5, -1, "dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainer.<anonymous>.<anonymous>.<anonymous> (BottomSheetContainer.kt:126)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        composer.startReplaceGroup(1942820848);
        final MutableIntState mutableIntState = this.$stickyFooterHeight$delegate;
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion2 = Composer.INSTANCE;
        if (rememberedValue == companion2.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.reusable.bottomsheet.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = BottomSheetContainerKt$BottomSheetContainer$4$2$3.invoke$lambda$1$lambda$0(MutableIntState.this, (LayoutCoordinates) obj);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) rememberedValue);
        ScrollableState scrollableState = this.$scrollState;
        boolean z5 = scrollableState != null && scrollableState.getCanScrollForward();
        composer.startReplaceGroup(1942824408);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion2.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.reusable.bottomsheet.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Modifier invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = BottomSheetContainerKt$BottomSheetContainer$4$2$3.invoke$lambda$3$lambda$2((Modifier) obj);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(ModifierExtensionsKt.applyIf(onGloballyPositioned, z5, (Function1) rememberedValue2), AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null);
        composer.startReplaceGroup(1942828074);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion2.getEmpty()) {
            rememberedValue3 = new Function1() { // from class: dk.molslinjen.ui.views.reusable.bottomsheet.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$5$lambda$4;
                    invoke$lambda$5$lambda$4 = BottomSheetContainerKt$BottomSheetContainer$4$2$3.invoke$lambda$5$lambda$4((SemanticsPropertyReceiver) obj);
                    return invoke$lambda$5$lambda$4;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        Modifier semantics$default = SemanticsModifierKt.semantics$default(m104backgroundbw27NRU$default, false, (Function1) rememberedValue3, 1, null);
        Function2<Composer, Integer, Unit> function2 = this.$footer;
        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, semantics$default);
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
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        function2.invoke(composer, 0);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
