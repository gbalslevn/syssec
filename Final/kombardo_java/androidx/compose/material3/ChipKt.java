package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\u001aµ\u0001\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00002\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a¼\u0001\u0010 \u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0080\u0001\u0010'\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020!2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0003ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a-\u0010+\u001a\u00020\u001c2\b\b\u0002\u0010(\u001a\u00020\u00002\b\b\u0002\u0010)\u001a\u00020\u00002\b\b\u0002\u0010*\u001a\u00020\u0000H\u0002¢\u0006\u0004\b+\u0010,\"\u0014\u0010-\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.\"\u0014\u0010/\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100\"\u0014\u00101\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00100\"\u0014\u00102\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00100\"\u0014\u00104\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00105\"\u0014\u00106\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00105\"\u0014\u00107\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00105\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00068"}, d2 = {BuildConfig.FLAVOR, "selected", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", ChipKt.LabelLayoutId, "Landroidx/compose/ui/Modifier;", "modifier", "enabled", ChipKt.LeadingIconLayoutId, "avatar", ChipKt.TrailingIconLayoutId, "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/material3/SelectableChipColors;", "colors", "Landroidx/compose/material3/SelectableChipElevation;", "elevation", "Landroidx/compose/foundation/BorderStroke;", "border", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "InputChip", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/ui/text/TextStyle;", "labelTextStyle", "Landroidx/compose/ui/unit/Dp;", "minHeight", "Landroidx/compose/foundation/layout/PaddingValues;", "paddingValues", "SelectableChip-u0RnIRE", "(ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SelectableChip", "Landroidx/compose/ui/graphics/Color;", "labelColor", "leadingIconColor", "trailingIconColor", "ChipContent-fe0OD_I", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "ChipContent", "hasAvatar", "hasLeadingIcon", "hasTrailingIcon", "inputChipPadding", "(ZZZ)Landroidx/compose/foundation/layout/PaddingValues;", "HorizontalElementsPadding", "F", "AssistChipPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "FilterChipPadding", "SuggestionChipPadding", BuildConfig.FLAVOR, "LeadingIconLayoutId", "Ljava/lang/String;", "LabelLayoutId", "TrailingIconLayoutId", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ChipKt {
    private static final PaddingValues AssistChipPadding;
    private static final PaddingValues FilterChipPadding;
    private static final float HorizontalElementsPadding;
    private static final String LabelLayoutId = "label";
    private static final String LeadingIconLayoutId = "leadingIcon";
    private static final PaddingValues SuggestionChipPadding;
    private static final String TrailingIconLayoutId = "trailingIcon";

    static {
        float m2599constructorimpl = Dp.m2599constructorimpl(8);
        HorizontalElementsPadding = m2599constructorimpl;
        AssistChipPadding = PaddingKt.m308PaddingValuesYgX7TsA$default(m2599constructorimpl, HorizontalElementsPadding, 2, null);
        FilterChipPadding = PaddingKt.m308PaddingValuesYgX7TsA$default(m2599constructorimpl, HorizontalElementsPadding, 2, null);
        SuggestionChipPadding = PaddingKt.m308PaddingValuesYgX7TsA$default(m2599constructorimpl, HorizontalElementsPadding, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ChipContent-fe0OD_I, reason: not valid java name */
    public static final void m784ChipContentfe0OD_I(final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final long j5, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final long j6, final long j7, final float f5, final PaddingValues paddingValues, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-782878228);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(j5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changed(j6) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= startRestartGroup.changed(j7) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i6 |= startRestartGroup.changed(f5) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i6 |= startRestartGroup.changed(paddingValues) ? 536870912 : 268435456;
        }
        if ((i6 & 306783379) == 306783378 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-782878228, i6, -1, "androidx.compose.material3.ChipContent (Chip.kt:2051)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j5)), TextKt.getLocalTextStyle().provides(textStyle)}, ComposableLambdaKt.rememberComposableLambda(1748799148, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ChipContent$1
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

                public final void invoke(Composer composer2, int i7) {
                    float f6;
                    if ((i7 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1748799148, i7, -1, "androidx.compose.material3.ChipContent.<anonymous> (Chip.kt:2056)");
                    }
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Modifier padding = PaddingKt.padding(SizeKt.m324defaultMinSizeVpY3zN4$default(companion, 0.0f, f5, 1, null), paddingValues);
                    AnonymousClass1 anonymousClass1 = new MeasurePolicy() { // from class: androidx.compose.material3.ChipKt$ChipContent$1.1
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* renamed from: measure-3p2s80s */
                        public final MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j8) {
                            Measurable measurable;
                            Measurable measurable2;
                            int size = list.size();
                            int i8 = 0;
                            while (true) {
                                if (i8 >= size) {
                                    measurable = null;
                                    break;
                                }
                                measurable = list.get(i8);
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "leadingIcon")) {
                                    break;
                                }
                                i8++;
                            }
                            Measurable measurable3 = measurable;
                            final Placeable mo1946measureBRTryo0 = measurable3 != null ? measurable3.mo1946measureBRTryo0(Constraints.m2570copyZbe2FdA$default(j8, 0, 0, 0, 0, 10, null)) : null;
                            final int widthOrZero = TextFieldImplKt.widthOrZero(mo1946measureBRTryo0);
                            final int heightOrZero = TextFieldImplKt.heightOrZero(mo1946measureBRTryo0);
                            int size2 = list.size();
                            int i9 = 0;
                            while (true) {
                                if (i9 >= size2) {
                                    measurable2 = null;
                                    break;
                                }
                                measurable2 = list.get(i9);
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "trailingIcon")) {
                                    break;
                                }
                                i9++;
                            }
                            Measurable measurable4 = measurable2;
                            final Placeable mo1946measureBRTryo02 = measurable4 != null ? measurable4.mo1946measureBRTryo0(Constraints.m2570copyZbe2FdA$default(j8, 0, 0, 0, 0, 10, null)) : null;
                            int widthOrZero2 = TextFieldImplKt.widthOrZero(mo1946measureBRTryo02);
                            final int heightOrZero2 = TextFieldImplKt.heightOrZero(mo1946measureBRTryo02);
                            int size3 = list.size();
                            for (int i10 = 0; i10 < size3; i10++) {
                                Measurable measurable5 = list.get(i10);
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable5), "label")) {
                                    final Placeable mo1946measureBRTryo03 = measurable5.mo1946measureBRTryo0(ConstraintsKt.m2596offsetNN6EwU$default(j8, -(widthOrZero + widthOrZero2), 0, 2, null));
                                    int width = mo1946measureBRTryo03.getWidth() + widthOrZero + widthOrZero2;
                                    final int max = Math.max(heightOrZero, Math.max(mo1946measureBRTryo03.getHeight(), heightOrZero2));
                                    return MeasureScope.layout$default(measureScope, width, max, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ChipKt.ChipContent.1.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                            invoke2(placementScope);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(Placeable.PlacementScope placementScope) {
                                            Placeable placeable = Placeable.this;
                                            if (placeable != null) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, Alignment.INSTANCE.getCenterVertically().align(heightOrZero, max), 0.0f, 4, null);
                                            }
                                            Placeable.PlacementScope.placeRelative$default(placementScope, mo1946measureBRTryo03, widthOrZero, 0, 0.0f, 4, null);
                                            Placeable placeable2 = mo1946measureBRTryo02;
                                            if (placeable2 != null) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, mo1946measureBRTryo03.getWidth() + widthOrZero, Alignment.INSTANCE.getCenterVertically().align(heightOrZero2, max), 0.0f, 4, null);
                                            }
                                        }
                                    }, 4, null);
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                    };
                    Function2<Composer, Integer, Unit> function25 = function23;
                    Function2<Composer, Integer, Unit> function26 = function22;
                    Function2<Composer, Integer, Unit> function27 = function24;
                    long j8 = j6;
                    Function2<Composer, Integer, Unit> function28 = function2;
                    long j9 = j7;
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, padding);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
                    Updater.m1227setimpl(m1226constructorimpl, anonymousClass1, companion2.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                    composer2.startReplaceGroup(-1293169671);
                    if (function25 != null || function26 != null) {
                        Modifier layoutId = LayoutIdKt.layoutId(companion, "leadingIcon");
                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, layoutId);
                        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                        if (composer2.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor2);
                        } else {
                            composer2.useNode();
                        }
                        Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                        Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion2.getSetModifier());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        if (function25 != null) {
                            composer2.startReplaceGroup(832680499);
                            function25.invoke(composer2, 0);
                            composer2.endReplaceGroup();
                        } else if (function26 != null) {
                            composer2.startReplaceGroup(832788565);
                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j8)), function26, composer2, ProvidedValue.$stable);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(833040347);
                            composer2.endReplaceGroup();
                        }
                        composer2.endNode();
                    }
                    composer2.endReplaceGroup();
                    Modifier layoutId2 = LayoutIdKt.layoutId(companion, "label");
                    f6 = ChipKt.HorizontalElementsPadding;
                    Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(layoutId2, f6, Dp.m2599constructorimpl(0));
                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                    Alignment.Companion companion3 = Alignment.INSTANCE;
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion3.getCenterVertically(), composer2, 54);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, m312paddingVpY3zN4);
                    Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer2);
                    Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion2.getSetCompositeKeyHash();
                    if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion2.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    function28.invoke(composer2, 0);
                    composer2.endNode();
                    composer2.startReplaceGroup(-1293135324);
                    if (function27 != null) {
                        Modifier layoutId3 = LayoutIdKt.layoutId(companion, "trailingIcon");
                        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getCenter(), false);
                        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, layoutId3);
                        Function0<ComposeUiNode> constructor4 = companion2.getConstructor();
                        if (composer2.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor4);
                        } else {
                            composer2.useNode();
                        }
                        Composer m1226constructorimpl4 = Updater.m1226constructorimpl(composer2);
                        Updater.m1227setimpl(m1226constructorimpl4, maybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion2.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion2.getSetCompositeKeyHash();
                        if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                        }
                        Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion2.getSetModifier());
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j9)), function27, composer2, ProvidedValue.$stable);
                        composer2.endNode();
                    }
                    composer2.endReplaceGroup();
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ChipContent$2
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

                public final void invoke(Composer composer2, int i7) {
                    ChipKt.m784ChipContentfe0OD_I(function2, textStyle, j5, function22, function23, function24, j6, j7, f5, paddingValues, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void InputChip(final boolean z5, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z6, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i5, final int i6, final int i7) {
        int i8;
        int i9;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i11;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        int i12;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        int i13;
        int i14;
        boolean z7;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Shape shape2;
        SelectableChipColors selectableChipColors2;
        int i15;
        boolean z8;
        int i16;
        SelectableChipElevation selectableChipElevation2;
        BorderStroke borderStroke2;
        MutableInteractionSource mutableInteractionSource2;
        int i17;
        Modifier modifier2;
        int i18;
        int i19;
        ComposableLambda composableLambda;
        final Modifier modifier3;
        SelectableChipElevation selectableChipElevation3;
        BorderStroke borderStroke3;
        MutableInteractionSource mutableInteractionSource3;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final boolean z9;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Shape shape3;
        final SelectableChipColors selectableChipColors3;
        ScopeUpdateScope endRestartGroup;
        int i20;
        int i21;
        int i22;
        int i23;
        Composer startRestartGroup = composer.startRestartGroup(1658928131);
        if ((i7 & 1) != 0) {
            i8 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i8 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i8 = i5;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i5 & 48) == 0) {
            i8 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i7 & 4) != 0) {
            i8 |= 384;
        } else if ((i5 & 384) == 0) {
            i8 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        int i24 = i7 & 8;
        if (i24 != 0) {
            i8 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i8 |= startRestartGroup.changed(modifier) ? 2048 : 1024;
            i9 = i7 & 16;
            if (i9 == 0) {
                i8 |= 24576;
            } else if ((i5 & 24576) == 0) {
                i8 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                i10 = i7 & 32;
                if (i10 != 0) {
                    i8 |= 196608;
                    function25 = function22;
                } else {
                    function25 = function22;
                    if ((i5 & 196608) == 0) {
                        i8 |= startRestartGroup.changedInstance(function25) ? 131072 : 65536;
                    }
                }
                i11 = i7 & 64;
                if (i11 != 0) {
                    i8 |= 1572864;
                    function26 = function23;
                } else {
                    function26 = function23;
                    if ((i5 & 1572864) == 0) {
                        i8 |= startRestartGroup.changedInstance(function26) ? 1048576 : 524288;
                    }
                }
                i12 = i7 & 128;
                if (i12 != 0) {
                    i8 |= 12582912;
                    function27 = function24;
                } else {
                    function27 = function24;
                    if ((i5 & 12582912) == 0) {
                        i8 |= startRestartGroup.changedInstance(function27) ? 8388608 : 4194304;
                    }
                }
                if ((i5 & 100663296) == 0) {
                    if ((i7 & 256) == 0 && startRestartGroup.changed(shape)) {
                        i23 = 67108864;
                        i8 |= i23;
                    }
                    i23 = 33554432;
                    i8 |= i23;
                }
                if ((i5 & 805306368) == 0) {
                    if ((i7 & 512) == 0 && startRestartGroup.changed(selectableChipColors)) {
                        i22 = 536870912;
                        i8 |= i22;
                    }
                    i22 = 268435456;
                    i8 |= i22;
                }
                if ((i6 & 6) == 0) {
                    if ((i7 & 1024) == 0 && startRestartGroup.changed(selectableChipElevation)) {
                        i21 = 4;
                        i13 = i6 | i21;
                    }
                    i21 = 2;
                    i13 = i6 | i21;
                } else {
                    i13 = i6;
                }
                if ((i6 & 48) == 0) {
                    if ((i7 & 2048) == 0 && startRestartGroup.changed(borderStroke)) {
                        i20 = 32;
                        i13 |= i20;
                    }
                    i20 = 16;
                    i13 |= i20;
                }
                int i25 = i13;
                i14 = i7 & 4096;
                if (i14 != 0) {
                    i25 |= 384;
                } else if ((i6 & 384) == 0) {
                    i25 |= startRestartGroup.changed(mutableInteractionSource) ? 256 : 128;
                    if ((i8 & 306783379) != 306783378 && (i25 & 147) == 146 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        shape3 = shape;
                        selectableChipColors3 = selectableChipColors;
                        selectableChipElevation3 = selectableChipElevation;
                        borderStroke3 = borderStroke;
                        mutableInteractionSource3 = mutableInteractionSource;
                        function210 = function26;
                        function211 = function25;
                        z9 = z6;
                    } else {
                        startRestartGroup.startDefaults();
                        if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier4 = i24 == 0 ? Modifier.INSTANCE : modifier;
                            z7 = i9 == 0 ? true : z6;
                            function28 = i10 == 0 ? null : function25;
                            Function2<? super Composer, ? super Integer, Unit> function212 = i11 == 0 ? null : function26;
                            function29 = i12 == 0 ? null : function27;
                            if ((i7 & 256) == 0) {
                                i8 &= -234881025;
                                shape2 = InputChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                            } else {
                                shape2 = shape;
                            }
                            if ((i7 & 512) == 0) {
                                i15 = i8 & (-1879048193);
                                selectableChipColors2 = InputChipDefaults.INSTANCE.inputChipColors(startRestartGroup, 6);
                            } else {
                                selectableChipColors2 = selectableChipColors;
                                i15 = i8;
                            }
                            if ((i7 & 1024) == 0) {
                                z8 = true;
                                i16 = i14;
                                selectableChipElevation2 = InputChipDefaults.INSTANCE.m862inputChipElevationaqJV_2Y(HorizontalElementsPadding, HorizontalElementsPadding, HorizontalElementsPadding, HorizontalElementsPadding, HorizontalElementsPadding, HorizontalElementsPadding, startRestartGroup, 1572864, 63);
                                i25 &= -15;
                            } else {
                                z8 = true;
                                i16 = i14;
                                selectableChipElevation2 = selectableChipElevation;
                            }
                            if ((i7 & 2048) == 0) {
                                borderStroke2 = InputChipDefaults.INSTANCE.m861inputChipBorder_7El2pE(z7, z5, 0L, 0L, 0L, 0L, HorizontalElementsPadding, HorizontalElementsPadding, startRestartGroup, ((i15 >> 12) & 14) | 100663296 | ((i15 << 3) & 112), 252);
                                i25 &= -113;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if (i16 == 0) {
                                i17 = i25;
                                mutableInteractionSource2 = null;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                                i17 = i25;
                            }
                            modifier2 = modifier4;
                            function26 = function212;
                            i18 = i15;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i7 & 256) != 0) {
                                i8 &= -234881025;
                            }
                            if ((i7 & 512) != 0) {
                                i8 &= -1879048193;
                            }
                            if ((i7 & 1024) != 0) {
                                i25 &= -15;
                            }
                            if ((i7 & 2048) != 0) {
                                i25 &= -113;
                            }
                            z7 = z6;
                            shape2 = shape;
                            selectableChipColors2 = selectableChipColors;
                            borderStroke2 = borderStroke;
                            mutableInteractionSource2 = mutableInteractionSource;
                            i17 = i25;
                            function28 = function25;
                            function29 = function27;
                            z8 = true;
                            modifier2 = modifier;
                            i18 = i8;
                            selectableChipElevation2 = selectableChipElevation;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1658928131, i18, i17, "androidx.compose.material3.InputChip (Chip.kt:643)");
                        }
                        startRestartGroup.startReplaceGroup(417920884);
                        if (function26 == null) {
                            final float f5 = z7 ? 1.0f : 0.38f;
                            i19 = 6;
                            final Shape value = ShapesKt.getValue(InputChipTokens.INSTANCE.getAvatarShape(), startRestartGroup, 6);
                            composableLambda = ComposableLambdaKt.rememberComposableLambda(1154227507, z8, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$InputChip$1
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

                                public final void invoke(Composer composer2, int i26) {
                                    if ((i26 & 3) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1154227507, i26, -1, "androidx.compose.material3.InputChip.<anonymous> (Chip.kt:652)");
                                    }
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    boolean changed = composer2.changed(f5) | composer2.changed(value);
                                    final float f6 = f5;
                                    final Shape shape4 = value;
                                    Object rememberedValue = composer2.rememberedValue();
                                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.ChipKt$InputChip$1$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                                                invoke2(graphicsLayerScope);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                                                graphicsLayerScope.setAlpha(f6);
                                                graphicsLayerScope.setShape(shape4);
                                                graphicsLayerScope.setClip(true);
                                            }
                                        };
                                        composer2.updateRememberedValue(rememberedValue);
                                    }
                                    Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) rememberedValue);
                                    Alignment center = Alignment.INSTANCE.getCenter();
                                    Function2<Composer, Integer, Unit> function213 = function26;
                                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, graphicsLayer);
                                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
                                    Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    function213.invoke(composer2, 0);
                                    composer2.endNode();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54);
                        } else {
                            i19 = 6;
                            composableLambda = null;
                        }
                        startRestartGroup.endReplaceGroup();
                        int i26 = i18 << 3;
                        int i27 = i17 << 3;
                        m785SelectableChipu0RnIRE(z5, modifier2, function0, z7, function2, TypographyKt.getValue(InputChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i19), function28, composableLambda, function29, shape2, selectableChipColors2, selectableChipElevation2, borderStroke2, InputChipDefaults.INSTANCE.m860getHeightD9Ej5fM(), inputChipPadding(composableLambda == null ? z8 : false, function28 == null ? z8 : false, function29 != null ? z8 : false), mutableInteractionSource2, startRestartGroup, (i18 & 14) | ((i18 >> 6) & 112) | (i26 & 896) | ((i18 >> 3) & 7168) | ((i18 << 6) & 57344) | (3670016 & i26) | (234881024 & i26) | (i26 & 1879048192), ((i18 >> 27) & 14) | 3072 | (i27 & 112) | (i27 & 896) | ((i17 << 9) & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        selectableChipElevation3 = selectableChipElevation2;
                        borderStroke3 = borderStroke2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function210 = function26;
                        z9 = z7;
                        function211 = function28;
                        function27 = function29;
                        shape3 = shape2;
                        selectableChipColors3 = selectableChipColors2;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final SelectableChipElevation selectableChipElevation4 = selectableChipElevation3;
                        final BorderStroke borderStroke4 = borderStroke3;
                        final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$InputChip$2
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

                            public final void invoke(Composer composer2, int i28) {
                                ChipKt.InputChip(z5, function0, function2, modifier3, z9, function211, function210, function27, shape3, selectableChipColors3, selectableChipElevation4, borderStroke4, mutableInteractionSource4, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), i7);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i8 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i24 == 0) {
                }
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if (i12 == 0) {
                }
                if ((i7 & 256) == 0) {
                }
                if ((i7 & 512) == 0) {
                }
                if ((i7 & 1024) == 0) {
                }
                if ((i7 & 2048) == 0) {
                }
                if (i16 == 0) {
                }
                modifier2 = modifier4;
                function26 = function212;
                i18 = i15;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceGroup(417920884);
                if (function26 == null) {
                }
                startRestartGroup.endReplaceGroup();
                int i262 = i18 << 3;
                int i272 = i17 << 3;
                m785SelectableChipu0RnIRE(z5, modifier2, function0, z7, function2, TypographyKt.getValue(InputChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i19), function28, composableLambda, function29, shape2, selectableChipColors2, selectableChipElevation2, borderStroke2, InputChipDefaults.INSTANCE.m860getHeightD9Ej5fM(), inputChipPadding(composableLambda == null ? z8 : false, function28 == null ? z8 : false, function29 != null ? z8 : false), mutableInteractionSource2, startRestartGroup, (i18 & 14) | ((i18 >> 6) & 112) | (i262 & 896) | ((i18 >> 3) & 7168) | ((i18 << 6) & 57344) | (3670016 & i262) | (234881024 & i262) | (i262 & 1879048192), ((i18 >> 27) & 14) | 3072 | (i272 & 112) | (i272 & 896) | ((i17 << 9) & 458752));
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                selectableChipElevation3 = selectableChipElevation2;
                borderStroke3 = borderStroke2;
                mutableInteractionSource3 = mutableInteractionSource2;
                function210 = function26;
                z9 = z7;
                function211 = function28;
                function27 = function29;
                shape3 = shape2;
                selectableChipColors3 = selectableChipColors2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i10 = i7 & 32;
            if (i10 != 0) {
            }
            i11 = i7 & 64;
            if (i11 != 0) {
            }
            i12 = i7 & 128;
            if (i12 != 0) {
            }
            if ((i5 & 100663296) == 0) {
            }
            if ((i5 & 805306368) == 0) {
            }
            if ((i6 & 6) == 0) {
            }
            if ((i6 & 48) == 0) {
            }
            int i252 = i13;
            i14 = i7 & 4096;
            if (i14 != 0) {
            }
            if ((i8 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i24 == 0) {
            }
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if (i12 == 0) {
            }
            if ((i7 & 256) == 0) {
            }
            if ((i7 & 512) == 0) {
            }
            if ((i7 & 1024) == 0) {
            }
            if ((i7 & 2048) == 0) {
            }
            if (i16 == 0) {
            }
            modifier2 = modifier4;
            function26 = function212;
            i18 = i15;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(417920884);
            if (function26 == null) {
            }
            startRestartGroup.endReplaceGroup();
            int i2622 = i18 << 3;
            int i2722 = i17 << 3;
            m785SelectableChipu0RnIRE(z5, modifier2, function0, z7, function2, TypographyKt.getValue(InputChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i19), function28, composableLambda, function29, shape2, selectableChipColors2, selectableChipElevation2, borderStroke2, InputChipDefaults.INSTANCE.m860getHeightD9Ej5fM(), inputChipPadding(composableLambda == null ? z8 : false, function28 == null ? z8 : false, function29 != null ? z8 : false), mutableInteractionSource2, startRestartGroup, (i18 & 14) | ((i18 >> 6) & 112) | (i2622 & 896) | ((i18 >> 3) & 7168) | ((i18 << 6) & 57344) | (3670016 & i2622) | (234881024 & i2622) | (i2622 & 1879048192), ((i18 >> 27) & 14) | 3072 | (i2722 & 112) | (i2722 & 896) | ((i17 << 9) & 458752));
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            selectableChipElevation3 = selectableChipElevation2;
            borderStroke3 = borderStroke2;
            mutableInteractionSource3 = mutableInteractionSource2;
            function210 = function26;
            z9 = z7;
            function211 = function28;
            function27 = function29;
            shape3 = shape2;
            selectableChipColors3 = selectableChipColors2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i9 = i7 & 16;
        if (i9 == 0) {
        }
        i10 = i7 & 32;
        if (i10 != 0) {
        }
        i11 = i7 & 64;
        if (i11 != 0) {
        }
        i12 = i7 & 128;
        if (i12 != 0) {
        }
        if ((i5 & 100663296) == 0) {
        }
        if ((i5 & 805306368) == 0) {
        }
        if ((i6 & 6) == 0) {
        }
        if ((i6 & 48) == 0) {
        }
        int i2522 = i13;
        i14 = i7 & 4096;
        if (i14 != 0) {
        }
        if ((i8 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i24 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (i12 == 0) {
        }
        if ((i7 & 256) == 0) {
        }
        if ((i7 & 512) == 0) {
        }
        if ((i7 & 1024) == 0) {
        }
        if ((i7 & 2048) == 0) {
        }
        if (i16 == 0) {
        }
        modifier2 = modifier4;
        function26 = function212;
        i18 = i15;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(417920884);
        if (function26 == null) {
        }
        startRestartGroup.endReplaceGroup();
        int i26222 = i18 << 3;
        int i27222 = i17 << 3;
        m785SelectableChipu0RnIRE(z5, modifier2, function0, z7, function2, TypographyKt.getValue(InputChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i19), function28, composableLambda, function29, shape2, selectableChipColors2, selectableChipElevation2, borderStroke2, InputChipDefaults.INSTANCE.m860getHeightD9Ej5fM(), inputChipPadding(composableLambda == null ? z8 : false, function28 == null ? z8 : false, function29 != null ? z8 : false), mutableInteractionSource2, startRestartGroup, (i18 & 14) | ((i18 >> 6) & 112) | (i26222 & 896) | ((i18 >> 3) & 7168) | ((i18 << 6) & 57344) | (3670016 & i26222) | (234881024 & i26222) | (i26222 & 1879048192), ((i18 >> 27) & 14) | 3072 | (i27222 & 112) | (i27222 & 896) | ((i17 << 9) & 458752));
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        selectableChipElevation3 = selectableChipElevation2;
        borderStroke3 = borderStroke2;
        mutableInteractionSource3 = mutableInteractionSource2;
        function210 = function26;
        z9 = z7;
        function211 = function28;
        function27 = function29;
        shape3 = shape2;
        selectableChipColors3 = selectableChipColors2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: SelectableChip-u0RnIRE, reason: not valid java name */
    public static final void m785SelectableChipu0RnIRE(final boolean z5, final Modifier modifier, final Function0<Unit> function0, final boolean z6, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Shape shape, final SelectableChipColors selectableChipColors, final SelectableChipElevation selectableChipElevation, final BorderStroke borderStroke, final float f5, final PaddingValues paddingValues, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(402951308);
        if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changed(z6) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((i5 & 196608) == 0) {
            i7 |= startRestartGroup.changed(textStyle) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i7 |= startRestartGroup.changedInstance(function22) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i7 |= startRestartGroup.changedInstance(function23) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i7 |= startRestartGroup.changedInstance(function24) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i7 |= startRestartGroup.changed(shape) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            i8 = (startRestartGroup.changed(selectableChipColors) ? 4 : 2) | i6;
        } else {
            i8 = i6;
        }
        if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changed(selectableChipElevation) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i8 |= startRestartGroup.changed(borderStroke) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i8 |= startRestartGroup.changed(f5) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i8 |= startRestartGroup.changed(paddingValues) ? 16384 : 8192;
        }
        if ((i6 & 196608) == 0) {
            i8 |= startRestartGroup.changed(mutableInteractionSource) ? 131072 : 65536;
        }
        if ((i7 & 306783379) == 306783378 && (74899 & i8) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(402951308, i7, i8, "androidx.compose.material3.SelectableChip (Chip.kt:2009)");
            }
            startRestartGroup.startReplaceGroup(2072749057);
            if (mutableInteractionSource == null) {
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
            }
            startRestartGroup.endReplaceGroup();
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m2184setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m2171getCheckboxo7Vup1c());
                }
            }, 1, null);
            long m890containerColorWaAFU9c$material3_release = selectableChipColors.m890containerColorWaAFU9c$material3_release(z6, z5);
            startRestartGroup.startReplaceGroup(2072762384);
            State<Dp> shadowElevation$material3_release = selectableChipElevation != null ? selectableChipElevation.shadowElevation$material3_release(z6, mutableInteractionSource2, startRestartGroup, ((i7 >> 9) & 14) | ((i8 << 3) & 896)) : null;
            startRestartGroup.endReplaceGroup();
            int i9 = i7;
            composer2 = startRestartGroup;
            SurfaceKt.m901Surfaced85dljk(z5, function0, semantics$default, z6, shape, m890containerColorWaAFU9c$material3_release, 0L, HorizontalElementsPadding, shadowElevation$material3_release != null ? shadowElevation$material3_release.getValue().getValue() : Dp.m2599constructorimpl(0), borderStroke, mutableInteractionSource2, ComposableLambdaKt.rememberComposableLambda(-577614814, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i10) {
                    if ((i10 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-577614814, i10, -1, "androidx.compose.material3.SelectableChip.<anonymous> (Chip.kt:2024)");
                    }
                    ChipKt.m784ChipContentfe0OD_I(function2, textStyle, SelectableChipColors.this.m891labelColorWaAFU9c$material3_release(z6, z5), function22, function23, function24, SelectableChipColors.this.m892leadingIconContentColorWaAFU9c$material3_release(z6, z5), SelectableChipColors.this.m893trailingIconContentColorWaAFU9c$material3_release(z6, z5), f5, paddingValues, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i9 & 14) | ((i9 >> 3) & 112) | (i9 & 7168) | ((i9 >> 15) & 57344) | ((i8 << 21) & 1879048192), 48, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i10) {
                    ChipKt.m785SelectableChipu0RnIRE(z5, modifier, function0, z6, function2, textStyle, function22, function23, function24, shape, selectableChipColors, selectableChipElevation, borderStroke, f5, paddingValues, mutableInteractionSource, composer3, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
                }
            });
        }
    }

    private static final PaddingValues inputChipPadding(boolean z5, boolean z6, boolean z7) {
        return PaddingKt.m310PaddingValuesa9UjIt4$default(Dp.m2599constructorimpl((z5 || !z6) ? 4 : 8), HorizontalElementsPadding, Dp.m2599constructorimpl(z7 ? 8 : 4), HorizontalElementsPadding, 10, null);
    }
}
