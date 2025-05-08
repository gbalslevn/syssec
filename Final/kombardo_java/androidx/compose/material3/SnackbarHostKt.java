package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u001a7\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a%\u0010\u0010\u001a\u00020\u000f*\u00020\n2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a7\u0010\u0014\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001a;\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001c2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0019\u001a\u00020\u000b2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u001aH\u0003¢\u0006\u0004\b\u001d\u0010\u001e\u001a+\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\u001c2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0019\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u001f\u0010 \"\u0014\u0010\"\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010#\"\u0014\u0010$\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010#\"\u0014\u0010%\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010#*0\b\u0002\u0010&\"\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0004\u0012\u00020\u00060\u00042\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0004\u0012\u00020\u00060\u0004¨\u0006'"}, d2 = {"Landroidx/compose/material3/SnackbarHostState;", "hostState", "Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function1;", "Landroidx/compose/material3/SnackbarData;", BuildConfig.FLAVOR, "snackbar", "SnackbarHost", "(Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/material3/SnackbarDuration;", BuildConfig.FLAVOR, "hasAction", "Landroidx/compose/ui/platform/AccessibilityManager;", "accessibilityManager", BuildConfig.FLAVOR, "toMillis", "(Landroidx/compose/material3/SnackbarDuration;ZLandroidx/compose/ui/platform/AccessibilityManager;)J", "current", "content", "FadeInFadeOutWithScale", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/animation/core/AnimationSpec;", BuildConfig.FLAVOR, "animation", "visible", "Lkotlin/Function0;", "onAnimationFinish", "Landroidx/compose/runtime/State;", "animatedOpacity", "(Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animatedScale", "(Landroidx/compose/animation/core/AnimationSpec;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", BuildConfig.FLAVOR, "SnackbarFadeInMillis", "I", "SnackbarFadeOutMillis", "SnackbarInBetweenDelayMillis", "FadeInFadeOutTransition", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SnackbarHostKt {
    private static final int SnackbarFadeInMillis = 150;
    private static final int SnackbarFadeOutMillis = 75;
    private static final int SnackbarInBetweenDelayMillis = 0;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SnackbarDuration.values().length];
            try {
                iArr[SnackbarDuration.Indefinite.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SnackbarDuration.Long.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SnackbarDuration.Short.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a9 A[LOOP:2: B:56:0x01a7->B:57:0x01a9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FadeInFadeOutWithScale(final SnackbarData snackbarData, Modifier modifier, final Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        Object rememberedValue;
        final FadeInFadeOutState fadeInFadeOutState;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        int size;
        int i8;
        ScopeUpdateScope endRestartGroup;
        final SnackbarData snackbarData2 = snackbarData;
        Composer startRestartGroup = composer.startRestartGroup(-1316639904);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(snackbarData2) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i9 = i6 & 2;
        if (i9 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i6 & 4) == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                i7 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
            }
            if ((i7 & 147) == 146 || !startRestartGroup.getSkipping()) {
                if (i9 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1316639904, i7, -1, "androidx.compose.material3.FadeInFadeOutWithScale (SnackbarHost.kt:327)");
                }
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new FadeInFadeOutState();
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                fadeInFadeOutState = (FadeInFadeOutState) rememberedValue;
                startRestartGroup.startReplaceGroup(-1256811491);
                if (!Intrinsics.areEqual(snackbarData2, fadeInFadeOutState.getCurrent())) {
                    fadeInFadeOutState.setCurrent(snackbarData2);
                    List items = fadeInFadeOutState.getItems();
                    ArrayList arrayList = new ArrayList(items.size());
                    int size2 = items.size();
                    for (int i10 = 0; i10 < size2; i10++) {
                        arrayList.add((SnackbarData) ((FadeInFadeOutAnimationItem) items.get(i10)).getKey());
                    }
                    final List mutableList = CollectionsKt.toMutableList((Collection) arrayList);
                    if (!mutableList.contains(snackbarData2)) {
                        mutableList.add(snackbarData2);
                    }
                    fadeInFadeOutState.getItems().clear();
                    List fastFilterNotNull = ListUtilsKt.fastFilterNotNull(mutableList);
                    List items2 = fadeInFadeOutState.getItems();
                    int size3 = fastFilterNotNull.size();
                    int i11 = 0;
                    while (i11 < size3) {
                        final SnackbarData snackbarData3 = (SnackbarData) fastFilterNotNull.get(i11);
                        items2.add(new FadeInFadeOutAnimationItem(snackbarData3, ComposableLambdaKt.rememberComposableLambda(-1654683077, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function2, Composer composer2, Integer num) {
                                invoke((Function2<? super Composer, ? super Integer, Unit>) function2, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer2, int i12) {
                                int i13;
                                State animatedOpacity;
                                State animatedScale;
                                if ((i12 & 6) == 0) {
                                    i13 = i12 | (composer2.changedInstance(function2) ? 4 : 2);
                                } else {
                                    i13 = i12;
                                }
                                if ((i13 & 19) == 18 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1654683077, i13, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous> (SnackbarHost.kt:338)");
                                }
                                boolean areEqual = Intrinsics.areEqual(SnackbarData.this, snackbarData2);
                                int i14 = areEqual ? 150 : 75;
                                int i15 = (!areEqual || ListUtilsKt.fastFilterNotNull(mutableList).size() == 1) ? 0 : 75;
                                TweenSpec tween = AnimationSpecKt.tween(i14, i15, EasingKt.getLinearEasing());
                                boolean changed = composer2.changed(SnackbarData.this) | composer2.changedInstance(fadeInFadeOutState);
                                final SnackbarData snackbarData4 = SnackbarData.this;
                                final FadeInFadeOutState<SnackbarData> fadeInFadeOutState2 = fadeInFadeOutState;
                                Object rememberedValue2 = composer2.rememberedValue();
                                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                            invoke2();
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2() {
                                            if (Intrinsics.areEqual(SnackbarData.this, fadeInFadeOutState2.getCurrent())) {
                                                return;
                                            }
                                            List<FadeInFadeOutAnimationItem<SnackbarData>> items3 = fadeInFadeOutState2.getItems();
                                            final SnackbarData snackbarData5 = SnackbarData.this;
                                            CollectionsKt.removeAll((List) items3, (Function1) new Function1<FadeInFadeOutAnimationItem<SnackbarData>, Boolean>() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1$1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Boolean invoke(FadeInFadeOutAnimationItem<SnackbarData> fadeInFadeOutAnimationItem) {
                                                    return Boolean.valueOf(Intrinsics.areEqual(fadeInFadeOutAnimationItem.getKey(), SnackbarData.this));
                                                }
                                            });
                                            RecomposeScope scope = fadeInFadeOutState2.getScope();
                                            if (scope != null) {
                                                scope.invalidate();
                                            }
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue2);
                                }
                                animatedOpacity = SnackbarHostKt.animatedOpacity(tween, areEqual, (Function0) rememberedValue2, composer2, 0, 0);
                                animatedScale = SnackbarHostKt.animatedScale(AnimationSpecKt.tween(i14, i15, EasingKt.getFastOutSlowInEasing()), areEqual, composer2, 0);
                                Modifier m1525graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m1525graphicsLayerAp8cVGQ$default(Modifier.INSTANCE, ((Number) animatedScale.getValue()).floatValue(), ((Number) animatedScale.getValue()).floatValue(), ((Number) animatedOpacity.getValue()).floatValue(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131064, null);
                                boolean changed2 = composer2.changed(SnackbarData.this);
                                final SnackbarData snackbarData5 = SnackbarData.this;
                                Object rememberedValue3 = composer2.rememberedValue();
                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            invoke2(semanticsPropertyReceiver);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            SemanticsPropertiesKt.m2183setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.INSTANCE.m2162getPolite0phEisY());
                                            final SnackbarData snackbarData6 = SnackbarData.this;
                                            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$1$1.1
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    SnackbarData.this.dismiss();
                                                    return Boolean.TRUE;
                                                }
                                            }, 1, null);
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue3);
                                }
                                Modifier semantics$default = SemanticsModifierKt.semantics$default(m1525graphicsLayerAp8cVGQ$default, false, (Function1) rememberedValue3, 1, null);
                                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, semantics$default);
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                if (composer2.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor);
                                } else {
                                    composer2.useNode();
                                }
                                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                                Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash);
                                }
                                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier, companion.getSetModifier());
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                function2.invoke(composer2, Integer.valueOf(i13 & 14));
                                composer2.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54)));
                        i11++;
                        snackbarData2 = snackbarData;
                    }
                }
                startRestartGroup.endReplaceGroup();
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
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
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                fadeInFadeOutState.setScope(ComposablesKt.getCurrentRecomposeScope(startRestartGroup, 0));
                startRestartGroup.startReplaceGroup(1748085441);
                List items3 = fadeInFadeOutState.getItems();
                size = items3.size();
                for (i8 = 0; i8 < size; i8++) {
                    FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem = (FadeInFadeOutAnimationItem) items3.get(i8);
                    final SnackbarData snackbarData4 = (SnackbarData) fadeInFadeOutAnimationItem.component1();
                    Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> component2 = fadeInFadeOutAnimationItem.component2();
                    startRestartGroup.startMovableGroup(1201076541, snackbarData4);
                    component2.invoke(ComposableLambdaKt.rememberComposableLambda(-1135367807, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$2$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i12) {
                            if ((i12 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1135367807, i12, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SnackbarHost.kt:395)");
                            }
                            Function3<SnackbarData, Composer, Integer, Unit> function32 = function3;
                            SnackbarData snackbarData5 = snackbarData4;
                            Intrinsics.checkNotNull(snackbarData5);
                            function32.invoke(snackbarData5, composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, 6);
                    startRestartGroup.endMovableGroup();
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
            }
            final Modifier modifier3 = modifier2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i12) {
                        SnackbarHostKt.FadeInFadeOutWithScale(SnackbarData.this, modifier3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i6 & 4) == 0) {
        }
        if ((i7 & 147) == 146) {
        }
        if (i9 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        fadeInFadeOutState = (FadeInFadeOutState) rememberedValue;
        startRestartGroup.startReplaceGroup(-1256811491);
        if (!Intrinsics.areEqual(snackbarData2, fadeInFadeOutState.getCurrent())) {
        }
        startRestartGroup.endReplaceGroup();
        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion2.getSetModifier());
        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
        fadeInFadeOutState.setScope(ComposablesKt.getCurrentRecomposeScope(startRestartGroup, 0));
        startRestartGroup.startReplaceGroup(1748085441);
        List items32 = fadeInFadeOutState.getItems();
        size = items32.size();
        while (i8 < size) {
        }
        startRestartGroup.endReplaceGroup();
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        final Modifier modifier32 = modifier2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final void SnackbarHost(final SnackbarHostState snackbarHostState, Modifier modifier, Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i5, final int i6) {
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(464178177);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(snackbarHostState) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i8 = i6 & 2;
        if (i8 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i9 = i6 & 4;
        if (i9 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i8 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i9 != 0) {
                function3 = ComposableSingletons$SnackbarHostKt.INSTANCE.m839getLambda1$material3_release();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(464178177, i7, -1, "androidx.compose.material3.SnackbarHost (SnackbarHost.kt:221)");
            }
            SnackbarData currentSnackbarData = snackbarHostState.getCurrentSnackbarData();
            AccessibilityManager accessibilityManager = (AccessibilityManager) startRestartGroup.consume(CompositionLocalsKt.getLocalAccessibilityManager());
            boolean changed = startRestartGroup.changed(currentSnackbarData) | startRestartGroup.changedInstance(accessibilityManager);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new SnackbarHostKt$SnackbarHost$1$1(currentSnackbarData, accessibilityManager, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            EffectsKt.LaunchedEffect(currentSnackbarData, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 0);
            FadeInFadeOutWithScale(snackbarHostState.getCurrentSnackbarData(), modifier, function3, startRestartGroup, i7 & 1008, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        final Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function32 = function3;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarHostKt$SnackbarHost$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i10) {
                    SnackbarHostKt.SnackbarHost(SnackbarHostState.this, modifier2, function32, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final State<Float> animatedOpacity(AnimationSpec<Float> animationSpec, boolean z5, Function0<Unit> function0, Composer composer, int i5, int i6) {
        if ((i6 & 4) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarHostKt$animatedOpacity$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0<Unit> function02 = function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1431889134, i5, -1, "androidx.compose.material3.animatedOpacity (SnackbarHost.kt:418)");
        }
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = AnimatableKt.Animatable$default(!z5 ? 1.0f : 0.0f, 0.0f, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        Animatable animatable = (Animatable) rememberedValue;
        Boolean valueOf = Boolean.valueOf(z5);
        boolean changedInstance = composer.changedInstance(animatable) | ((((i5 & 112) ^ 48) > 32 && composer.changed(z5)) || (i5 & 48) == 32) | composer.changedInstance(animationSpec) | ((((i5 & 896) ^ 384) > 256 && composer.changed(function02)) || (i5 & 384) == 256);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance || rememberedValue2 == companion.getEmpty()) {
            Object snackbarHostKt$animatedOpacity$2$1 = new SnackbarHostKt$animatedOpacity$2$1(animatable, z5, animationSpec, function02, null);
            composer.updateRememberedValue(snackbarHostKt$animatedOpacity$2$1);
            rememberedValue2 = snackbarHostKt$animatedOpacity$2$1;
        }
        EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, composer, (i5 >> 3) & 14);
        State<Float> asState = animatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return asState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final State<Float> animatedScale(AnimationSpec<Float> animationSpec, boolean z5, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1966809761, i5, -1, "androidx.compose.material3.animatedScale (SnackbarHost.kt:428)");
        }
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = AnimatableKt.Animatable$default(!z5 ? 1.0f : 0.8f, 0.0f, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        Animatable animatable = (Animatable) rememberedValue;
        Boolean valueOf = Boolean.valueOf(z5);
        boolean changedInstance = composer.changedInstance(animatable) | ((((i5 & 112) ^ 48) > 32 && composer.changed(z5)) || (i5 & 48) == 32) | composer.changedInstance(animationSpec);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new SnackbarHostKt$animatedScale$1$1(animatable, z5, animationSpec, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, composer, (i5 >> 3) & 14);
        State<Float> asState = animatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return asState;
    }

    public static final long toMillis(SnackbarDuration snackbarDuration, boolean z5, AccessibilityManager accessibilityManager) {
        long j5;
        int i5 = WhenMappings.$EnumSwitchMapping$0[snackbarDuration.ordinal()];
        if (i5 == 1) {
            j5 = Long.MAX_VALUE;
        } else if (i5 == 2) {
            j5 = 10000;
        } else {
            if (i5 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            j5 = 4000;
        }
        long j6 = j5;
        return accessibilityManager == null ? j6 : accessibilityManager.calculateRecommendedTimeoutMillis(j6, true, true, z5);
    }
}
