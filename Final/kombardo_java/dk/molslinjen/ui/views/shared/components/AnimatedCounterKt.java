package dk.molslinjen.ui.views.shared.components;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
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
import androidx.compose.ui.text.TextStyle;
import dk.molslinjen.ui.views.shared.components.AnimatedCounterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\t¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"AnimatedCounter", BuildConfig.FLAVOR, "count", BuildConfig.FLAVOR, "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "postfix", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd", "oldCount"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AnimatedCounterKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedCounter(final String count, Modifier modifier, final TextStyle style, String str, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        String str2;
        int i9;
        String str3;
        Object rememberedValue;
        Composer.Companion companion;
        boolean z5;
        Object rememberedValue2;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        int length;
        int i10;
        Composer composer2;
        final String str4;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(count, "count");
        Intrinsics.checkNotNullParameter(style, "style");
        Composer startRestartGroup = composer.startRestartGroup(-1552509260);
        boolean z6 = true;
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(count) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i11 = i6 & 2;
        if (i11 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i6 & 4) == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                i7 |= startRestartGroup.changed(style) ? 256 : 128;
            }
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                str2 = str;
                i7 |= startRestartGroup.changed(str2) ? 2048 : 1024;
                i9 = i7;
                if ((i9 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                    Modifier modifier4 = i11 != 0 ? Modifier.INSTANCE : modifier2;
                    str3 = i8 != 0 ? null : str2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1552509260, i9, -1, "dk.molslinjen.ui.views.shared.components.AnimatedCounter (AnimatedCounter.kt:19)");
                    }
                    startRestartGroup.startReplaceGroup(-280232518);
                    rememberedValue = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                        rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(count, null, 2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    final MutableState mutableState = (MutableState) rememberedValue;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(-280230548);
                    z5 = (i9 & 14) == 4;
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!z5 || rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: w4.a
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit AnimatedCounter$lambda$4$lambda$3;
                                AnimatedCounter$lambda$4$lambda$3 = AnimatedCounterKt.AnimatedCounter$lambda$4$lambda$3(count, mutableState);
                                return AnimatedCounter$lambda$4$lambda$3;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceGroup();
                    EffectsKt.SideEffect((Function0) rememberedValue2, startRestartGroup, 0);
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getEnd(), Alignment.INSTANCE.getTop(), startRestartGroup, 6);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
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
                    String AnimatedCounter$lambda$1 = AnimatedCounter$lambda$1(mutableState);
                    startRestartGroup.startReplaceGroup(884666135);
                    length = count.length();
                    i10 = 0;
                    while (i10 < length) {
                        Character orNull = StringsKt.getOrNull(AnimatedCounter$lambda$1, i10);
                        char charAt = (orNull != null && orNull.charValue() == count.charAt(i10)) ? AnimatedCounter$lambda$1.charAt(i10) : count.charAt(i10);
                        final int length2 = (count.length() - i10) * 100;
                        Character valueOf = Character.valueOf(charAt);
                        startRestartGroup.startReplaceGroup(884680966);
                        boolean changed = startRestartGroup.changed(length2);
                        Object rememberedValue3 = startRestartGroup.rememberedValue();
                        if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            final int i12 = 600;
                            rememberedValue3 = new Function1() { // from class: w4.b
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    ContentTransform AnimatedCounter$lambda$10$lambda$8$lambda$7;
                                    AnimatedCounter$lambda$10$lambda$8$lambda$7 = AnimatedCounterKt.AnimatedCounter$lambda$10$lambda$8$lambda$7(i12, length2, (AnimatedContentTransitionScope) obj);
                                    return AnimatedCounter$lambda$10$lambda$8$lambda$7;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        startRestartGroup.endReplaceGroup();
                        AnimatedContentKt.AnimatedContent(valueOf, null, (Function1) rememberedValue3, null, null, null, ComposableLambdaKt.rememberComposableLambda(1662256543, z6, new Function4<AnimatedContentScope, Character, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.components.AnimatedCounterKt$AnimatedCounter$2$2
                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, Character ch, Composer composer3, Integer num) {
                                invoke(animatedContentScope, ch.charValue(), composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedContentScope AnimatedContent, char c5, Composer composer3, int i13) {
                                Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1662256543, i13, -1, "dk.molslinjen.ui.views.shared.components.AnimatedCounter.<anonymous>.<anonymous> (AnimatedCounter.kt:54)");
                                }
                                TextKt.m940Text4IGK_g(String.valueOf(c5), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.this, composer3, 0, 384, 61438);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54), startRestartGroup, 1572864, 58);
                        i10++;
                        i9 = i9;
                        z6 = z6;
                        modifier4 = modifier4;
                    }
                    Modifier modifier5 = modifier4;
                    int i13 = i9;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(884698963);
                    if (str3 == null) {
                        composer2 = startRestartGroup;
                    } else {
                        composer2 = startRestartGroup;
                        TextKt.m940Text4IGK_g(str3, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, style, composer2, 0, (i13 << 12) & 3670016, 65534);
                    }
                    composer2.endReplaceGroup();
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    modifier3 = modifier5;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    str4 = str2;
                    composer2 = startRestartGroup;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: w4.c
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit AnimatedCounter$lambda$11;
                            AnimatedCounter$lambda$11 = AnimatedCounterKt.AnimatedCounter$lambda$11(count, modifier3, style, str4, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                            return AnimatedCounter$lambda$11;
                        }
                    });
                    return;
                }
                return;
            }
            str2 = str;
            i9 = i7;
            if ((i9 & 1171) == 1170) {
            }
            if (i11 != 0) {
            }
            if (i8 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(-280232518);
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
            }
            final MutableState mutableState2 = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-280230548);
            if ((i9 & 14) == 4) {
            }
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z5) {
            }
            rememberedValue2 = new Function0() { // from class: w4.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit AnimatedCounter$lambda$4$lambda$3;
                    AnimatedCounter$lambda$4$lambda$3 = AnimatedCounterKt.AnimatedCounter$lambda$4$lambda$3(count, mutableState2);
                    return AnimatedCounter$lambda$4$lambda$3;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceGroup();
            EffectsKt.SideEffect((Function0) rememberedValue2, startRestartGroup, 0);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getEnd(), Alignment.INSTANCE.getTop(), startRestartGroup, 6);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
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
            String AnimatedCounter$lambda$12 = AnimatedCounter$lambda$1(mutableState2);
            startRestartGroup.startReplaceGroup(884666135);
            length = count.length();
            i10 = 0;
            while (i10 < length) {
            }
            Modifier modifier52 = modifier4;
            int i132 = i9;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(884698963);
            if (str3 == null) {
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            str4 = str3;
            modifier3 = modifier52;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i6 & 4) == 0) {
        }
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        str2 = str;
        i9 = i7;
        if ((i9 & 1171) == 1170) {
        }
        if (i11 != 0) {
        }
        if (i8 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(-280232518);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        final MutableState mutableState22 = (MutableState) rememberedValue;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(-280230548);
        if ((i9 & 14) == 4) {
        }
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!z5) {
        }
        rememberedValue2 = new Function0() { // from class: w4.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit AnimatedCounter$lambda$4$lambda$3;
                AnimatedCounter$lambda$4$lambda$3 = AnimatedCounterKt.AnimatedCounter$lambda$4$lambda$3(count, mutableState22);
                return AnimatedCounter$lambda$4$lambda$3;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceGroup();
        EffectsKt.SideEffect((Function0) rememberedValue2, startRestartGroup, 0);
        MeasurePolicy rowMeasurePolicy22 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getEnd(), Alignment.INSTANCE.getTop(), startRestartGroup, 6);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
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
        String AnimatedCounter$lambda$122 = AnimatedCounter$lambda$1(mutableState22);
        startRestartGroup.startReplaceGroup(884666135);
        length = count.length();
        i10 = 0;
        while (i10 < length) {
        }
        Modifier modifier522 = modifier4;
        int i1322 = i9;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(884698963);
        if (str3 == null) {
        }
        composer2.endReplaceGroup();
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        str4 = str3;
        modifier3 = modifier522;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final String AnimatedCounter$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentTransform AnimatedCounter$lambda$10$lambda$8$lambda$7(int i5, int i6, AnimatedContentTransitionScope AnimatedContent) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInVertically(new TweenSpec(i5, i6, EasingKt.getFastOutSlowInEasing()), new Function1() { // from class: w4.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int AnimatedCounter$lambda$10$lambda$8$lambda$7$lambda$5;
                AnimatedCounter$lambda$10$lambda$8$lambda$7$lambda$5 = AnimatedCounterKt.AnimatedCounter$lambda$10$lambda$8$lambda$7$lambda$5(((Integer) obj).intValue());
                return Integer.valueOf(AnimatedCounter$lambda$10$lambda$8$lambda$7$lambda$5);
            }
        }), EnterExitTransitionKt.slideOutVertically(new TweenSpec(i5, i6, EasingKt.getFastOutSlowInEasing()), new Function1() { // from class: w4.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int AnimatedCounter$lambda$10$lambda$8$lambda$7$lambda$6;
                AnimatedCounter$lambda$10$lambda$8$lambda$7$lambda$6 = AnimatedCounterKt.AnimatedCounter$lambda$10$lambda$8$lambda$7$lambda$6(((Integer) obj).intValue());
                return Integer.valueOf(AnimatedCounter$lambda$10$lambda$8$lambda$7$lambda$6);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AnimatedCounter$lambda$10$lambda$8$lambda$7$lambda$5(int i5) {
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AnimatedCounter$lambda$10$lambda$8$lambda$7$lambda$6(int i5) {
        return -i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnimatedCounter$lambda$11(String str, Modifier modifier, TextStyle textStyle, String str2, int i5, int i6, Composer composer, int i7) {
        AnimatedCounter(str, modifier, textStyle, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnimatedCounter$lambda$4$lambda$3(String str, MutableState mutableState) {
        mutableState.setValue(str);
        return Unit.INSTANCE;
    }
}
