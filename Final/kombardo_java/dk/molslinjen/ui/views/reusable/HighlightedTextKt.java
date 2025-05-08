package dk.molslinjen.ui.views.reusable;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.views.reusable.HighlightedTextKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u001aO\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\f\u0010\r\u001aE\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u0010H\u0003¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0018²\u0006\u000e\u0010\u0017\u001a\u00020\u00168\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "highlight", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "animateBackgroundPulseWithColor", "Landroidx/compose/ui/graphics/Shape;", "shape", "Lkotlin/Function0;", BuildConfig.FLAVOR, "buildText", "HighlightedText-RuGn9fw", "(Landroidx/compose/ui/Modifier;ZJLandroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "HighlightedText", "pulseColor", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "content", "AnimatedBox-DTcfvLk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AnimatedBox", BuildConfig.FLAVOR, "width", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class HighlightedTextKt {
    /* renamed from: AnimatedBox-DTcfvLk, reason: not valid java name */
    private static final void m3386AnimatedBoxDTcfvLk(Modifier modifier, final long j5, final long j6, final Shape shape, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        Modifier modifier3;
        Composer startRestartGroup = composer.startRestartGroup(-2002777673);
        int i8 = i6 & 1;
        if (i8 != 0) {
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
            i7 |= startRestartGroup.changed(j5) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(j6) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changed(shape) ? 2048 : 1024;
        }
        if ((i6 & 16) != 0) {
            i7 |= 24576;
        } else if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if ((i7 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            modifier3 = i8 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2002777673, i7, -1, "dk.molslinjen.ui.views.reusable.AnimatedBox (HighlightedText.kt:66)");
            }
            State<Float> animateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition(null, startRestartGroup, 0, 1), -0.2f, 1.2f, AnimationSpecKt.m58infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(2500, 0, null, 6, null), RepeatMode.Restart, 0L, 4, null), null, startRestartGroup, InfiniteTransition.$stable | 384 | (InfiniteRepeatableSpec.$stable << 9), 8);
            Pair[] pairArr = (Pair[]) CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(Float.valueOf(-0.2f), Color.m1481boximpl(j5)), TuplesKt.to(Float.valueOf(animateFloat.getValue().floatValue() - 0.2f), Color.m1481boximpl(j5)), TuplesKt.to(Float.valueOf(animateFloat.getValue().floatValue() - 0.05f), Color.m1481boximpl(j6)), TuplesKt.to(animateFloat.getValue(), Color.m1481boximpl(j6)), TuplesKt.to(Float.valueOf(animateFloat.getValue().floatValue() + 0.05f), Color.m1481boximpl(j6)), TuplesKt.to(Float.valueOf(animateFloat.getValue().floatValue() + 0.2f), Color.m1481boximpl(j5)), TuplesKt.to(Float.valueOf(1.2f), Color.m1481boximpl(j5))}).toArray(new Pair[0]);
            startRestartGroup.startReplaceGroup(2014253761);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(2014257052);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: W1.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit AnimatedBox_DTcfvLk$lambda$6$lambda$5;
                        AnimatedBox_DTcfvLk$lambda$6$lambda$5 = HighlightedTextKt.AnimatedBox_DTcfvLk$lambda$6$lambda$5(MutableState.this, (LayoutCoordinates) obj);
                        return AnimatedBox_DTcfvLk$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BackgroundKt.background$default(OnGloballyPositionedModifierKt.onGloballyPositioned(modifier3, (Function1) rememberedValue2), Brush.Companion.m1464horizontalGradient8A3gB4$default(Brush.INSTANCE, (Pair[]) Arrays.copyOf(pairArr, pairArr.length), 0.0f, AnimatedBox_DTcfvLk$lambda$3(mutableState), 0, 8, null), shape, 0.0f, 4, null), Dp.m2599constructorimpl(8), Dp.m2599constructorimpl(4));
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            function3.invoke(BoxScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf(((i7 >> 9) & 112) | 6));
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: W1.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AnimatedBox_DTcfvLk$lambda$8;
                    AnimatedBox_DTcfvLk$lambda$8 = HighlightedTextKt.AnimatedBox_DTcfvLk$lambda$8(Modifier.this, j5, j6, shape, function3, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return AnimatedBox_DTcfvLk$lambda$8;
                }
            });
        }
    }

    private static final int AnimatedBox_DTcfvLk$lambda$3(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void AnimatedBox_DTcfvLk$lambda$4(MutableState<Integer> mutableState, int i5) {
        mutableState.setValue(Integer.valueOf(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnimatedBox_DTcfvLk$lambda$6$lambda$5(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AnimatedBox_DTcfvLk$lambda$4(mutableState, IntSize.m2661getWidthimpl(it.mo1948getSizeYbymL2g()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnimatedBox_DTcfvLk$lambda$8(Modifier modifier, long j5, long j6, Shape shape, Function3 function3, int i5, int i6, Composer composer, int i7) {
        m3386AnimatedBoxDTcfvLk(modifier, j5, j6, shape, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x005e  */
    /* renamed from: HighlightedText-RuGn9fw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3387HighlightedTextRuGn9fw(Modifier modifier, boolean z5, final long j5, Color color, Shape shape, final Function2<? super Composer, ? super Integer, Unit> buildText, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        boolean z6;
        int i8;
        Color color2;
        Shape shape2;
        Color color3;
        int i9;
        boolean z7;
        Shape small;
        Shape shape3;
        final Shape shape4;
        final Modifier modifier3;
        final boolean z8;
        final Color color4;
        ScopeUpdateScope endRestartGroup;
        int i10;
        Intrinsics.checkNotNullParameter(buildText, "buildText");
        Composer startRestartGroup = composer.startRestartGroup(-633689420);
        int i11 = i6 & 1;
        if (i11 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        int i12 = i6 & 2;
        if (i12 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            z6 = z5;
            i7 |= startRestartGroup.changed(z6) ? 32 : 16;
            if ((i6 & 4) == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                i7 |= startRestartGroup.changed(j5) ? 256 : 128;
            }
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                color2 = color;
                i7 |= startRestartGroup.changed(color2) ? 2048 : 1024;
                if ((i5 & 24576) == 0) {
                    if ((i6 & 16) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i10 = 16384;
                            i7 |= i10;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i10 = 8192;
                    i7 |= i10;
                } else {
                    shape2 = shape;
                }
                if ((i6 & 32) != 0) {
                    i7 |= 196608;
                } else if ((i5 & 196608) == 0) {
                    i7 |= startRestartGroup.changedInstance(buildText) ? 131072 : 65536;
                }
                if ((74899 & i7) == 74898 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i12 != 0) {
                            z6 = true;
                        }
                        if (i8 != 0) {
                            color2 = null;
                        }
                        if ((i6 & 16) != 0) {
                            color3 = color2;
                            i9 = i7 & (-57345);
                            z7 = z6;
                            small = ThemeShapesKt.getThemeShapes().getSmall();
                            Modifier modifier4 = modifier2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-633689420, i9, -1, "dk.molslinjen.ui.views.reusable.HighlightedText (HighlightedText.kt:33)");
                            }
                            if (z7) {
                                shape3 = small;
                                startRestartGroup.startReplaceGroup(-1852345716);
                                buildText.invoke(startRestartGroup, Integer.valueOf((i9 >> 15) & 14));
                                startRestartGroup.endReplaceGroup();
                            } else {
                                startRestartGroup.startReplaceGroup(-1852981960);
                                if (color3 != null) {
                                    startRestartGroup.startReplaceGroup(-1852939180);
                                    int i13 = (i9 & 14) | 24576;
                                    int i14 = i9 >> 3;
                                    shape3 = small;
                                    m3386AnimatedBoxDTcfvLk(modifier4, j5, color3.getValue(), small, ComposableLambdaKt.rememberComposableLambda(2055194924, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.HighlightedTextKt$HighlightedText$1
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer2, Integer num) {
                                            invoke(boxScope, composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(BoxScope AnimatedBox, Composer composer2, int i15) {
                                            Intrinsics.checkNotNullParameter(AnimatedBox, "$this$AnimatedBox");
                                            if ((i15 & 17) == 16 && composer2.getSkipping()) {
                                                composer2.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(2055194924, i15, -1, "dk.molslinjen.ui.views.reusable.HighlightedText.<anonymous> (HighlightedText.kt:42)");
                                            }
                                            buildText.invoke(composer2, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, startRestartGroup, 54), startRestartGroup, i13 | (i14 & 112) | (i14 & 896) | (i14 & 7168), 0);
                                    startRestartGroup.endReplaceGroup();
                                } else {
                                    shape3 = small;
                                    startRestartGroup.startReplaceGroup(-1852659250);
                                    Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BackgroundKt.m103backgroundbw27NRU(modifier4, j5, shape3), Dp.m2599constructorimpl(8), Dp.m2599constructorimpl(4));
                                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
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
                                    Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    buildText.invoke(startRestartGroup, Integer.valueOf((i9 >> 15) & 14));
                                    startRestartGroup.endNode();
                                    startRestartGroup.endReplaceGroup();
                                }
                                startRestartGroup.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape4 = shape3;
                            modifier3 = modifier4;
                            z8 = z7;
                            color4 = color3;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i6 & 16) != 0) {
                            i7 &= -57345;
                        }
                    }
                    color3 = color2;
                    i9 = i7;
                    z7 = z6;
                    small = shape2;
                    Modifier modifier42 = modifier2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (z7) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    shape4 = shape3;
                    modifier3 = modifier42;
                    z8 = z7;
                    color4 = color3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    color4 = color2;
                    shape4 = shape2;
                    modifier3 = modifier2;
                    z8 = z6;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: W1.h
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit HighlightedText_RuGn9fw$lambda$1;
                            HighlightedText_RuGn9fw$lambda$1 = HighlightedTextKt.HighlightedText_RuGn9fw$lambda$1(Modifier.this, z8, j5, color4, shape4, buildText, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                            return HighlightedText_RuGn9fw$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            color2 = color;
            if ((i5 & 24576) == 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if ((74899 & i7) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i8 != 0) {
            }
            if ((i6 & 16) != 0) {
            }
            color3 = color2;
            i9 = i7;
            z7 = z6;
            small = shape2;
            Modifier modifier422 = modifier2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            if (z7) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            shape4 = shape3;
            modifier3 = modifier422;
            z8 = z7;
            color4 = color3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        z6 = z5;
        if ((i6 & 4) == 0) {
        }
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        color2 = color;
        if ((i5 & 24576) == 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if ((74899 & i7) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i8 != 0) {
        }
        if ((i6 & 16) != 0) {
        }
        color3 = color2;
        i9 = i7;
        z7 = z6;
        small = shape2;
        Modifier modifier4222 = modifier2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        if (z7) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        shape4 = shape3;
        modifier3 = modifier4222;
        z8 = z7;
        color4 = color3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HighlightedText_RuGn9fw$lambda$1(Modifier modifier, boolean z5, long j5, Color color, Shape shape, Function2 function2, int i5, int i6, Composer composer, int i7) {
        m3387HighlightedTextRuGn9fw(modifier, z5, j5, color, shape, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
