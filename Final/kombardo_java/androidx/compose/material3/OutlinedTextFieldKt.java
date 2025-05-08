package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.tokens.TypeScaleTokens;
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
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aÕ\u0001\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001b\u0010\u001a\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001aj\u0010(\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001ar\u00103\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a¡\u0001\u0010C\u001a\u00020\u0003*\u0002042\u0006\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u00182\b\u00108\u001a\u0004\u0018\u0001072\b\u00109\u001a\u0004\u0018\u0001072\b\u0010:\u001a\u0004\u0018\u0001072\b\u0010;\u001a\u0004\u0018\u0001072\u0006\u0010<\u001a\u0002072\b\u0010=\u001a\u0004\u0018\u0001072\b\u0010>\u001a\u0004\u0018\u0001072\u0006\u0010?\u001a\u0002072\b\u0010@\u001a\u0004\u0018\u0001072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020A2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\bC\u0010D\u001a)\u0010F\u001a\u00020\u0000*\u00020\u00002\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00100\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\bF\u0010G\"\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010J\"\u001a\u0010L\u001a\u00020K8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006P"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function0;", BuildConfig.FLAVOR, "textField", "Lkotlin/Function1;", "placeholder", "label", "leading", "trailing", "prefix", "suffix", BuildConfig.FLAVOR, "singleLine", BuildConfig.FLAVOR, "animationProgress", "Landroidx/compose/ui/geometry/Size;", "onLabelMeasured", "container", "supporting", "Landroidx/compose/foundation/layout/PaddingValues;", "paddingValues", "OutlinedTextFieldLayout", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", BuildConfig.FLAVOR, "from", "substractConstraintSafely", "(II)I", "leadingPlaceableWidth", "trailingPlaceableWidth", "prefixPlaceableWidth", "suffixPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "Landroidx/compose/ui/unit/Constraints;", "constraints", "density", "calculateWidth-DHJA7U0", "(IIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "textFieldHeight", "labelHeight", "placeholderHeight", "supportingHeight", "calculateHeight-mKXJcVc", "(IIIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateHeight", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "totalHeight", "width", "Landroidx/compose/ui/layout/Placeable;", "leadingPlaceable", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "containerPlaceable", "supportingPlaceable", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "place", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;IILandroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;FZFLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/foundation/layout/PaddingValues;)V", "labelSize", "outlineCutout", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/Dp;", "OutlinedTextFieldInnerPadding", "F", "Landroidx/compose/ui/unit/TextUnit;", "OutlinedTextFieldTopPadding", "J", "getOutlinedTextFieldTopPadding", "()J", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class OutlinedTextFieldKt {
    private static final float OutlinedTextFieldInnerPadding = Dp.m2599constructorimpl(4);
    private static final long OutlinedTextFieldTopPadding;

    static {
        long m1170getBodySmallLineHeightXSAIIZE = TypeScaleTokens.INSTANCE.m1170getBodySmallLineHeightXSAIIZE();
        TextUnitKt.m2681checkArithmeticR2X_6o(m1170getBodySmallLineHeightXSAIIZE);
        OutlinedTextFieldTopPadding = TextUnitKt.pack(TextUnit.m2673getRawTypeimpl(m1170getBodySmallLineHeightXSAIIZE), TextUnit.m2675getValueimpl(m1170getBodySmallLineHeightXSAIIZE) / 2);
    }

    public static final void OutlinedTextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, final Function2<? super Composer, ? super Integer, Unit> function26, final boolean z5, final float f5, final Function1<? super Size, Unit> function1, final Function2<? super Composer, ? super Integer, Unit> function27, final Function2<? super Composer, ? super Integer, Unit> function28, final PaddingValues paddingValues, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        PaddingValues paddingValues2;
        int i9;
        float f6;
        Composer startRestartGroup = composer.startRestartGroup(1408290209);
        if ((i5 & 6) == 0) {
            i7 = i5 | (startRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(function25) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(function26) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 67108864 : 33554432;
        }
        if ((805306368 & i5) == 0) {
            i7 |= startRestartGroup.changed(f5) ? 536870912 : 268435456;
        }
        int i10 = i7;
        if ((i6 & 6) == 0) {
            i8 = i6 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
        } else {
            i8 = i6;
        }
        if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changedInstance(function27) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i8 |= startRestartGroup.changedInstance(function28) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            paddingValues2 = paddingValues;
            i8 |= startRestartGroup.changed(paddingValues2) ? 2048 : 1024;
        } else {
            paddingValues2 = paddingValues;
        }
        int i11 = i8;
        if ((i10 & 306783379) == 306783378 && (i11 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1408290209, i10, i11, "androidx.compose.material3.OutlinedTextFieldLayout (OutlinedTextField.kt:468)");
            }
            boolean z6 = ((i11 & 14) == 4) | ((234881024 & i10) == 67108864) | ((1879048192 & i10) == 536870912) | ((i11 & 7168) == 2048);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new OutlinedTextFieldMeasurePolicy(function1, z5, f5, paddingValues2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = (OutlinedTextFieldMeasurePolicy) rememberedValue;
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
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
            Updater.m1227setimpl(m1226constructorimpl, outlinedTextFieldMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            function27.invoke(startRestartGroup, Integer.valueOf((i11 >> 3) & 14));
            startRestartGroup.startReplaceGroup(250370369);
            if (function23 != null) {
                Modifier then = LayoutIdKt.layoutId(Modifier.INSTANCE, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, then);
                Function0<ComposeUiNode> constructor2 = companion.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                function23.invoke(startRestartGroup, Integer.valueOf((i10 >> 12) & 14));
                startRestartGroup.endNode();
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(250379492);
            if (function24 != null) {
                Modifier then2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, then2);
                Function0<ComposeUiNode> constructor3 = companion.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl3, maybeCachedBoxMeasurePolicy2, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion.getSetCompositeKeyHash();
                if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                function24.invoke(startRestartGroup, Integer.valueOf((i10 >> 15) & 14));
                startRestartGroup.endNode();
            }
            startRestartGroup.endReplaceGroup();
            float calculateStartPadding = PaddingKt.calculateStartPadding(paddingValues2, layoutDirection);
            float calculateEndPadding = PaddingKt.calculateEndPadding(paddingValues2, layoutDirection);
            if (function23 != null) {
                i9 = 0;
                calculateStartPadding = Dp.m2599constructorimpl(RangesKt.coerceAtLeast(Dp.m2599constructorimpl(calculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m2599constructorimpl(0)));
            } else {
                i9 = 0;
            }
            if (function24 != null) {
                calculateEndPadding = Dp.m2599constructorimpl(RangesKt.coerceAtLeast(Dp.m2599constructorimpl(calculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m2599constructorimpl(i9)));
            }
            startRestartGroup.startReplaceGroup(250410106);
            if (function25 != null) {
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m327heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "Prefix"), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), calculateStartPadding, 0.0f, TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, 10, null);
                MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
                Function0<ComposeUiNode> constructor4 = companion.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m1226constructorimpl4 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl4, maybeCachedBoxMeasurePolicy3, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion.getSetCompositeKeyHash();
                if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                function25.invoke(startRestartGroup, Integer.valueOf((i10 >> 18) & 14));
                startRestartGroup.endNode();
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(250422072);
            if (function26 != null) {
                Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m327heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "Suffix"), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, calculateEndPadding, 0.0f, 10, null);
                MeasurePolicy maybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default2);
                Function0<ComposeUiNode> constructor5 = companion.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor5);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m1226constructorimpl5 = Updater.m1226constructorimpl(startRestartGroup);
                f6 = calculateStartPadding;
                Updater.m1227setimpl(m1226constructorimpl5, maybeCachedBoxMeasurePolicy4, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl5, currentCompositionLocalMap5, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = companion.getSetCompositeKeyHash();
                if (m1226constructorimpl5.getInserting() || !Intrinsics.areEqual(m1226constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                    m1226constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                    m1226constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                }
                Updater.m1227setimpl(m1226constructorimpl5, materializeModifier5, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                function26.invoke(startRestartGroup, Integer.valueOf((i10 >> 21) & 14));
                startRestartGroup.endNode();
            } else {
                f6 = calculateStartPadding;
            }
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier wrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.m327heightInVpY3zN4$default(companion2, TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null);
            float m2599constructorimpl = function25 == null ? f6 : Dp.m2599constructorimpl(0);
            if (function26 != null) {
                calculateEndPadding = Dp.m2599constructorimpl(0);
            }
            Modifier m315paddingqDBjuR0$default3 = PaddingKt.m315paddingqDBjuR0$default(wrapContentHeight$default, m2599constructorimpl, 0.0f, calculateEndPadding, 0.0f, 10, null);
            startRestartGroup.startReplaceGroup(250444361);
            if (function3 != null) {
                function3.invoke(LayoutIdKt.layoutId(companion2, "Hint").then(m315paddingqDBjuR0$default3), startRestartGroup, Integer.valueOf((i10 >> 3) & 112));
            }
            startRestartGroup.endReplaceGroup();
            Modifier then3 = LayoutIdKt.layoutId(companion2, "TextField").then(m315paddingqDBjuR0$default3);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), true);
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap6 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(startRestartGroup, then3);
            Function0<ComposeUiNode> constructor6 = companion.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor6);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl6 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl6, maybeCachedBoxMeasurePolicy5, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl6, currentCompositionLocalMap6, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl6.getInserting() || !Intrinsics.areEqual(m1226constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                m1226constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                m1226constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
            }
            Updater.m1227setimpl(m1226constructorimpl6, materializeModifier6, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
            function2.invoke(startRestartGroup, Integer.valueOf((i10 >> 3) & 14));
            startRestartGroup.endNode();
            startRestartGroup.startReplaceGroup(250455481);
            if (function22 != null) {
                Modifier layoutId = LayoutIdKt.layoutId(SizeKt.wrapContentHeight$default(SizeKt.m327heightInVpY3zN4$default(companion2, DpKt.m2611lerpMdfbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), f5), 0.0f, 2, null), null, false, 3, null), "Label");
                MeasurePolicy maybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap7 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier7 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId);
                Function0<ComposeUiNode> constructor7 = companion.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor7);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m1226constructorimpl7 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl7, maybeCachedBoxMeasurePolicy6, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl7, currentCompositionLocalMap7, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = companion.getSetCompositeKeyHash();
                if (m1226constructorimpl7.getInserting() || !Intrinsics.areEqual(m1226constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                    m1226constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                    m1226constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
                }
                Updater.m1227setimpl(m1226constructorimpl7, materializeModifier7, companion.getSetModifier());
                function22.invoke(startRestartGroup, Integer.valueOf((i10 >> 9) & 14));
                startRestartGroup.endNode();
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(250473414);
            if (function28 != null) {
                Modifier padding = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.m327heightInVpY3zN4$default(LayoutIdKt.layoutId(companion2, "Supporting"), TextFieldImplKt.getMinSupportingTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldDefaults.m926supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null));
                MeasurePolicy maybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap8 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier8 = ComposedModifierKt.materializeModifier(startRestartGroup, padding);
                Function0<ComposeUiNode> constructor8 = companion.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor8);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m1226constructorimpl8 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl8, maybeCachedBoxMeasurePolicy7, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl8, currentCompositionLocalMap8, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = companion.getSetCompositeKeyHash();
                if (m1226constructorimpl8.getInserting() || !Intrinsics.areEqual(m1226constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                    m1226constructorimpl8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                    m1226constructorimpl8.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
                }
                Updater.m1227setimpl(m1226constructorimpl8, materializeModifier8, companion.getSetModifier());
                function28.invoke(startRestartGroup, Integer.valueOf((i11 >> 6) & 14));
                startRestartGroup.endNode();
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextFieldLayout$2
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
                    OutlinedTextFieldKt.OutlinedTextFieldLayout(Modifier.this, function2, function3, function22, function23, function24, function25, function26, z5, f5, function1, function27, function28, paddingValues, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-mKXJcVc, reason: not valid java name */
    public static final int m881calculateHeightmKXJcVc(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, float f5, long j5, float f6, PaddingValues paddingValues) {
        int maxOf = ComparisonsKt.maxOf(i9, i11, i7, i8, MathHelpersKt.lerp(i10, 0, f5));
        float top = paddingValues.getTop() * f6;
        return Math.max(Constraints.m2579getMinHeightimpl(j5), Math.max(i5, Math.max(i6, MathKt.roundToInt(MathHelpersKt.lerp(top, Math.max(top, i10 / 2.0f), f5) + maxOf + (paddingValues.getBottom() * f6)))) + i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-DHJA7U0, reason: not valid java name */
    public static final int m882calculateWidthDHJA7U0(int i5, int i6, int i7, int i8, int i9, int i10, int i11, float f5, long j5, float f6, PaddingValues paddingValues) {
        int i12 = i7 + i8;
        int max = i5 + Math.max(i9 + i12, Math.max(i11 + i12, MathHelpersKt.lerp(i10, 0, f5))) + i6;
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        return Math.max(max, Math.max(MathKt.roundToInt((i10 + (Dp.m2599constructorimpl(paddingValues.mo290calculateLeftPaddingu2uoSUM(layoutDirection) + paddingValues.mo291calculateRightPaddingu2uoSUM(layoutDirection)) * f6)) * f5), Constraints.m2580getMinWidthimpl(j5)));
    }

    public static final Modifier outlineCutout(Modifier modifier, final Function0<Size> function0, final PaddingValues paddingValues) {
        return DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$outlineCutout$1

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    try {
                        iArr[LayoutDirection.Rtl.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope contentDrawScope) {
                float f5;
                float coerceAtLeast;
                long packedValue = function0.invoke().getPackedValue();
                float m1377getWidthimpl = Size.m1377getWidthimpl(packedValue);
                if (m1377getWidthimpl > 0.0f) {
                    f5 = OutlinedTextFieldKt.OutlinedTextFieldInnerPadding;
                    float mo212toPx0680j_4 = contentDrawScope.mo212toPx0680j_4(f5);
                    float mo212toPx0680j_42 = contentDrawScope.mo212toPx0680j_4(paddingValues.mo290calculateLeftPaddingu2uoSUM(contentDrawScope.getLayoutDirection())) - mo212toPx0680j_4;
                    float f6 = 2;
                    float f7 = m1377getWidthimpl + mo212toPx0680j_42 + (mo212toPx0680j_4 * f6);
                    LayoutDirection layoutDirection = contentDrawScope.getLayoutDirection();
                    int[] iArr = WhenMappings.$EnumSwitchMapping$0;
                    if (iArr[layoutDirection.ordinal()] == 1) {
                        coerceAtLeast = Size.m1377getWidthimpl(contentDrawScope.mo1703getSizeNHjbRc()) - f7;
                    } else {
                        coerceAtLeast = RangesKt.coerceAtLeast(mo212toPx0680j_42, 0.0f);
                    }
                    float f8 = coerceAtLeast;
                    if (iArr[contentDrawScope.getLayoutDirection().ordinal()] == 1) {
                        f7 = Size.m1377getWidthimpl(contentDrawScope.mo1703getSizeNHjbRc()) - RangesKt.coerceAtLeast(mo212toPx0680j_42, 0.0f);
                    }
                    float f9 = f7;
                    float m1375getHeightimpl = Size.m1375getHeightimpl(packedValue);
                    float f10 = (-m1375getHeightimpl) / f6;
                    float f11 = m1375getHeightimpl / f6;
                    int m1479getDifferencertfAjoo = ClipOp.INSTANCE.m1479getDifferencertfAjoo();
                    DrawContext drawContext = contentDrawScope.getDrawContext();
                    long mo1682getSizeNHjbRc = drawContext.mo1682getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    try {
                        drawContext.getTransform().mo1685clipRectN_I0leg(f8, f10, f9, f11, m1479getDifferencertfAjoo);
                        contentDrawScope.drawContent();
                        return;
                    } finally {
                        drawContext.getCanvas().restore();
                        drawContext.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
                    }
                }
                contentDrawScope.drawContent();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope placementScope, int i5, int i6, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, float f5, boolean z5, float f6, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        Placeable.PlacementScope.m1968place70tqf50$default(placementScope, placeable8, IntOffset.INSTANCE.m2648getZeronOccac(), 0.0f, 2, null);
        int heightOrZero = i5 - TextFieldImplKt.heightOrZero(placeable9);
        int roundToInt = MathKt.roundToInt(paddingValues.getTop() * f6);
        int roundToInt2 = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * f6);
        float horizontalIconPadding = TextFieldImplKt.getHorizontalIconPadding() * f6;
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, MathKt.roundToInt(placeable == null ? 0.0f : (TextFieldImplKt.widthOrZero(placeable) - horizontalIconPadding) * (1 - f5)) + roundToInt2, MathHelpersKt.lerp(z5 ? Alignment.INSTANCE.getCenterVertically().align(placeable6.getHeight(), heightOrZero) : roundToInt, -(placeable6.getHeight() / 2), f5), 0.0f, 4, null);
        }
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable), place$calculateVerticalPosition(z5, heightOrZero, roundToInt, placeable6, placeable3), 0.0f, 4, null);
        }
        int widthOrZero = TextFieldImplKt.widthOrZero(placeable) + TextFieldImplKt.widthOrZero(placeable3);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, widthOrZero, place$calculateVerticalPosition(z5, heightOrZero, roundToInt, placeable6, placeable5), 0.0f, 4, null);
        if (placeable7 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable7, widthOrZero, place$calculateVerticalPosition(z5, heightOrZero, roundToInt, placeable6, placeable7), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, (i6 - TextFieldImplKt.widthOrZero(placeable2)) - placeable4.getWidth(), place$calculateVerticalPosition(z5, heightOrZero, roundToInt, placeable6, placeable4), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i6 - placeable2.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable9 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable9, 0, heightOrZero, 0.0f, 4, null);
        }
    }

    private static final int place$calculateVerticalPosition(boolean z5, int i5, int i6, Placeable placeable, Placeable placeable2) {
        if (z5) {
            i6 = Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), i5);
        }
        return Math.max(i6, TextFieldImplKt.heightOrZero(placeable) / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int substractConstraintSafely(int i5, int i6) {
        return i5 == Integer.MAX_VALUE ? i5 : i5 - i6;
    }
}
