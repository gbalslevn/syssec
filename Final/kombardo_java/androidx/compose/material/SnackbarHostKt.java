package androidx.compose.material;

import android.support.v4.media.session.a;
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

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u001a7\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a7\u0010\f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0003¢\u0006\u0004\b\f\u0010\r\u001a;\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00152\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013H\u0003¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00152\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0003¢\u0006\u0004\b\u0018\u0010\u0019\"\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c\"\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001c\"\u0014\u0010\u001e\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001c*0\b\u0002\u0010\u001f\"\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0013\u0012\u0004\u0012\u00020\u00060\u00042\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0013\u0012\u0004\u0012\u00020\u00060\u0004¨\u0006 "}, d2 = {"Landroidx/compose/material/SnackbarHostState;", "hostState", "Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarData;", BuildConfig.FLAVOR, "snackbar", "SnackbarHost", "(Landroidx/compose/material/SnackbarHostState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "current", "content", "FadeInFadeOutWithScale", "(Landroidx/compose/material/SnackbarData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/animation/core/AnimationSpec;", BuildConfig.FLAVOR, "animation", BuildConfig.FLAVOR, "visible", "Lkotlin/Function0;", "onAnimationFinish", "Landroidx/compose/runtime/State;", "animatedOpacity", "(Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animatedScale", "(Landroidx/compose/animation/core/AnimationSpec;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", BuildConfig.FLAVOR, "SnackbarFadeInMillis", "I", "SnackbarFadeOutMillis", "SnackbarInBetweenDelayMillis", "FadeInFadeOutTransition", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SnackbarHostKt {
    private static final int SnackbarFadeInMillis = 150;
    private static final int SnackbarFadeOutMillis = 75;
    private static final int SnackbarInBetweenDelayMillis = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01bf A[LOOP:2: B:56:0x01bd->B:57:0x01bf, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0055  */
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
        Composer startRestartGroup = composer.startRestartGroup(2036134589);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = ((i5 & 8) == 0 ? startRestartGroup.changed(snackbarData2) : startRestartGroup.changedInstance(snackbarData2) ? 4 : 2) | i5;
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
                    ComposerKt.traceEventStart(2036134589, i7, -1, "androidx.compose.material.FadeInFadeOutWithScale (SnackbarHost.kt:263)");
                }
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new FadeInFadeOutState();
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                fadeInFadeOutState = (FadeInFadeOutState) rememberedValue;
                final SnackbarData snackbarData3 = null;
                if (Intrinsics.areEqual(snackbarData2, fadeInFadeOutState.getCurrent())) {
                    startRestartGroup.startReplaceGroup(1521898746);
                    fadeInFadeOutState.setCurrent(snackbarData2);
                    List items = fadeInFadeOutState.getItems();
                    ArrayList arrayList = new ArrayList(items.size());
                    int size2 = items.size();
                    for (int i10 = 0; i10 < size2; i10++) {
                        a.a(((FadeInFadeOutAnimationItem) items.get(i10)).getKey());
                        arrayList.add(null);
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
                        a.a(fastFilterNotNull.get(i11));
                        items2.add(new FadeInFadeOutAnimationItem(null, ComposableLambdaKt.rememberComposableLambda(1471040642, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>(snackbarData3, snackbarData2, mutableList, fadeInFadeOutState) { // from class: androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$1$1
                            final /* synthetic */ List<SnackbarData> $keys;
                            final /* synthetic */ FadeInFadeOutState<SnackbarData> $state;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                                this.$keys = mutableList;
                                this.$state = fadeInFadeOutState;
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
                                    ComposerKt.traceEventStart(1471040642, i13, -1, "androidx.compose.material.FadeInFadeOutWithScale.<anonymous>.<anonymous> (SnackbarHost.kt:274)");
                                }
                                final SnackbarData snackbarData4 = null;
                                boolean areEqual = Intrinsics.areEqual((Object) null, (Object) null);
                                int i14 = areEqual ? 150 : 75;
                                int i15 = (!areEqual || ListUtilsKt.fastFilterNotNull(this.$keys).size() == 1) ? 0 : 75;
                                TweenSpec tween = AnimationSpecKt.tween(i14, i15, EasingKt.getLinearEasing());
                                boolean changedInstance = composer2.changedInstance(null) | composer2.changedInstance(this.$state);
                                final FadeInFadeOutState<SnackbarData> fadeInFadeOutState2 = this.$state;
                                Object rememberedValue2 = composer2.rememberedValue();
                                if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = new Function0<Unit>(snackbarData4, fadeInFadeOutState2) { // from class: androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1$1
                                        final /* synthetic */ FadeInFadeOutState<SnackbarData> $state;

                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                            this.$state = fadeInFadeOutState2;
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                            invoke2();
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2() {
                                            SnackbarData snackbarData5 = null;
                                            if (Intrinsics.areEqual((Object) null, this.$state.getCurrent())) {
                                                return;
                                            }
                                            CollectionsKt.removeAll((List) this.$state.getItems(), (Function1) new Function1<FadeInFadeOutAnimationItem<SnackbarData>, Boolean>(snackbarData5) { // from class: androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1$1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Boolean invoke(FadeInFadeOutAnimationItem<SnackbarData> fadeInFadeOutAnimationItem) {
                                                    return Boolean.valueOf(Intrinsics.areEqual(fadeInFadeOutAnimationItem.getKey(), (Object) null));
                                                }
                                            });
                                            RecomposeScope scope = this.$state.getScope();
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
                                boolean changedInstance2 = composer2.changedInstance(null);
                                Object rememberedValue3 = composer2.rememberedValue();
                                if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = new Function1<SemanticsPropertyReceiver, Unit>(snackbarData4) { // from class: androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$1$1$1$1
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
                                            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>(null) { // from class: androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$1$1$1$1.1
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    throw null;
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
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(1524065801);
                    startRestartGroup.endReplaceGroup();
                }
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
                startRestartGroup.startReplaceGroup(1801432280);
                List items3 = fadeInFadeOutState.getItems();
                size = items3.size();
                for (i8 = 0; i8 < size; i8++) {
                    FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem = (FadeInFadeOutAnimationItem) items3.get(i8);
                    a.a(fadeInFadeOutAnimationItem.component1());
                    Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> component2 = fadeInFadeOutAnimationItem.component2();
                    startRestartGroup.startMovableGroup(2123976768, null);
                    component2.invoke(ComposableLambdaKt.rememberComposableLambda(2041982076, true, new Function2<Composer, Integer, Unit>(function3, snackbarData3) { // from class: androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$2$1$1
                        final /* synthetic */ Function3<SnackbarData, Composer, Integer, Unit> $content;

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
                                ComposerKt.traceEventStart(2041982076, i12, -1, "androidx.compose.material.FadeInFadeOutWithScale.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SnackbarHost.kt:327)");
                            }
                            Function3<SnackbarData, Composer, Integer, Unit> function32 = this.$content;
                            Intrinsics.checkNotNull(null);
                            function32.invoke(null, composer2, 0);
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
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>(snackbarData, modifier3, function3, i5, i6) { // from class: androidx.compose.material.SnackbarHostKt$FadeInFadeOutWithScale$3
                    final /* synthetic */ int $$changed;
                    final /* synthetic */ int $$default;
                    final /* synthetic */ Function3<SnackbarData, Composer, Integer, Unit> $content;
                    final /* synthetic */ Modifier $modifier;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                        this.$modifier = modifier3;
                        this.$content = function3;
                        this.$$changed = i5;
                        this.$$default = i6;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i12) {
                        SnackbarHostKt.FadeInFadeOutWithScale(null, this.$modifier, this.$content, composer2, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
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
        final SnackbarData snackbarData32 = null;
        if (Intrinsics.areEqual(snackbarData2, fadeInFadeOutState.getCurrent())) {
        }
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
        startRestartGroup.startReplaceGroup(1801432280);
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
        Composer startRestartGroup = composer.startRestartGroup(431012348);
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
                function3 = ComposableSingletons$SnackbarHostKt.INSTANCE.m684getLambda1$material_release();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(431012348, i7, -1, "androidx.compose.material.SnackbarHost (SnackbarHost.kt:157)");
            }
            snackbarHostState.getCurrentSnackbarData();
            AccessibilityManager accessibilityManager = (AccessibilityManager) startRestartGroup.consume(CompositionLocalsKt.getLocalAccessibilityManager());
            boolean changedInstance = startRestartGroup.changedInstance(null) | startRestartGroup.changedInstance(accessibilityManager);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new SnackbarHostKt$SnackbarHost$1$1(null, accessibilityManager, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            EffectsKt.LaunchedEffect((Object) null, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 0);
            snackbarHostState.getCurrentSnackbarData();
            FadeInFadeOutWithScale(null, modifier, function3, startRestartGroup, i7 & 1008, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        final Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function32 = function3;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarHostKt$SnackbarHost$2
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
            function0 = new Function0<Unit>() { // from class: androidx.compose.material.SnackbarHostKt$animatedOpacity$1
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
            ComposerKt.traceEventStart(1016418159, i5, -1, "androidx.compose.material.animatedOpacity (SnackbarHost.kt:353)");
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
            ComposerKt.traceEventStart(2003504988, i5, -1, "androidx.compose.material.animatedScale (SnackbarHost.kt:366)");
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
}
