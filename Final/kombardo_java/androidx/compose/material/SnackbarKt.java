package androidx.compose.material;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\u001an\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a`\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001d\u0010\u0017\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a+\u0010\u001a\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0003¢\u0006\u0004\b\u001a\u0010\u001b\u001a+\u0010\u001c\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0003¢\u0006\u0004\b\u001c\u0010\u001b\"\u0014\u0010\u001d\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e\"\u0014\u0010\u001f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001e\"\u0014\u0010 \u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001e\"\u0014\u0010!\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001e\"\u0014\u0010\"\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001e\"\u0014\u0010#\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001e\"\u0014\u0010$\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u001e\"\u0014\u0010%\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001e\"\u0014\u0010&\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function0;", BuildConfig.FLAVOR, "action", BuildConfig.FLAVOR, "actionOnNewLine", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "contentColor", "Landroidx/compose/ui/unit/Dp;", "elevation", "content", "Snackbar-7zSek6w", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Snackbar", "Landroidx/compose/material/SnackbarData;", "snackbarData", "actionColor", "Snackbar-sPrSdHI", "(Landroidx/compose/material/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJFLandroidx/compose/runtime/Composer;II)V", "TextOnlySnackbar", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "text", "NewLineButtonSnackbar", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "HeightToFirstLine", "F", "HorizontalSpacing", "HorizontalSpacingButtonSide", "SeparateButtonExtraY", "SnackbarVerticalPadding", "TextEndExtraSpacing", "LongButtonVerticalOffset", "SnackbarMinHeightOneLine", "SnackbarMinHeightTwoLines", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SnackbarKt {
    private static final float HorizontalSpacingButtonSide;
    private static final float TextEndExtraSpacing;
    private static final float HeightToFirstLine = Dp.m2599constructorimpl(30);
    private static final float HorizontalSpacing = Dp.m2599constructorimpl(16);
    private static final float SeparateButtonExtraY = Dp.m2599constructorimpl(2);
    private static final float SnackbarVerticalPadding = Dp.m2599constructorimpl(6);
    private static final float LongButtonVerticalOffset = Dp.m2599constructorimpl(12);
    private static final float SnackbarMinHeightOneLine = Dp.m2599constructorimpl(48);
    private static final float SnackbarMinHeightTwoLines = Dp.m2599constructorimpl(68);

    static {
        float f5 = 8;
        HorizontalSpacingButtonSide = Dp.m2599constructorimpl(f5);
        TextEndExtraSpacing = Dp.m2599constructorimpl(f5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NewLineButtonSnackbar(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1229075900);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1229075900, i6, -1, "androidx.compose.material.NewLineButtonSnackbar (Snackbar.kt:293)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            float f5 = HorizontalSpacing;
            float f6 = HorizontalSpacingButtonSide;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(fillMaxWidth$default, f5, 0.0f, f6, SeparateButtonExtraY, 2, null);
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(AlignmentLineKt.m262paddingFromBaselineVpY3zN4(companion, HeightToFirstLine, LongButtonVerticalOffset), 0.0f, 0.0f, f6, 0.0f, 11, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default2);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            function2.invoke(startRestartGroup, Integer.valueOf(i6 & 14));
            startRestartGroup.endNode();
            Modifier align = columnScopeInstance.align(companion, companion2.getEnd());
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, align);
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl3, maybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
            function22.invoke(startRestartGroup, Integer.valueOf((i6 >> 3) & 14));
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$NewLineButtonSnackbar$2
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
                    SnackbarKt.NewLineButtonSnackbar(function2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OneRowSnackbar(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-534813202);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-534813202, i6, -1, "androidx.compose.material.OneRowSnackbar (Snackbar.kt:314)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, HorizontalSpacing, 0.0f, HorizontalSpacingButtonSide, 0.0f, 10, null);
            Object rememberedValue = startRestartGroup.rememberedValue();
            final String str = "text";
            final String str2 = "action";
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material.SnackbarKt$OneRowSnackbar$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                        float f5;
                        float f6;
                        float f7;
                        final int i7;
                        final int height;
                        int i8;
                        float f8;
                        String str3 = str2;
                        int size = list.size();
                        for (int i9 = 0; i9 < size; i9++) {
                            Measurable measurable = list.get(i9);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), str3)) {
                                final Placeable mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(j5);
                                int m2578getMaxWidthimpl = Constraints.m2578getMaxWidthimpl(j5) - mo1946measureBRTryo0.getWidth();
                                f5 = SnackbarKt.TextEndExtraSpacing;
                                int coerceAtLeast = RangesKt.coerceAtLeast(m2578getMaxWidthimpl - measureScope.mo206roundToPx0680j_4(f5), Constraints.m2580getMinWidthimpl(j5));
                                String str4 = str;
                                int size2 = list.size();
                                for (int i10 = 0; i10 < size2; i10++) {
                                    Measurable measurable2 = list.get(i10);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), str4)) {
                                        final Placeable mo1946measureBRTryo02 = measurable2.mo1946measureBRTryo0(Constraints.m2570copyZbe2FdA$default(j5, 0, coerceAtLeast, 0, 0, 9, null));
                                        int i11 = mo1946measureBRTryo02.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline());
                                        int i12 = mo1946measureBRTryo02.get(androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline());
                                        boolean z5 = true;
                                        boolean z6 = (i11 == Integer.MIN_VALUE || i12 == Integer.MIN_VALUE) ? false : true;
                                        if (i11 != i12 && z6) {
                                            z5 = false;
                                        }
                                        final int m2578getMaxWidthimpl2 = Constraints.m2578getMaxWidthimpl(j5) - mo1946measureBRTryo0.getWidth();
                                        if (z5) {
                                            f8 = SnackbarKt.SnackbarMinHeightOneLine;
                                            i8 = Math.max(measureScope.mo206roundToPx0680j_4(f8), mo1946measureBRTryo0.getHeight());
                                            int height2 = (i8 - mo1946measureBRTryo02.getHeight()) / 2;
                                            int i13 = mo1946measureBRTryo0.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline());
                                            height = i13 != Integer.MIN_VALUE ? (i11 + height2) - i13 : 0;
                                            i7 = height2;
                                        } else {
                                            f6 = SnackbarKt.HeightToFirstLine;
                                            int mo206roundToPx0680j_4 = measureScope.mo206roundToPx0680j_4(f6) - i11;
                                            f7 = SnackbarKt.SnackbarMinHeightTwoLines;
                                            int max = Math.max(measureScope.mo206roundToPx0680j_4(f7), mo1946measureBRTryo02.getHeight() + mo206roundToPx0680j_4);
                                            i7 = mo206roundToPx0680j_4;
                                            height = (max - mo1946measureBRTryo0.getHeight()) / 2;
                                            i8 = max;
                                        }
                                        return MeasureScope.layout$default(measureScope, Constraints.m2578getMaxWidthimpl(j5), i8, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.SnackbarKt$OneRowSnackbar$2$1.2
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
                                                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, i7, 0.0f, 4, null);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, mo1946measureBRTryo0, m2578getMaxWidthimpl2, height, 0.0f, 4, null);
                                            }
                                        }, 4, null);
                                    }
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
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
            Updater.m1227setimpl(m1226constructorimpl, measurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(LayoutIdKt.layoutId(companion, "text"), 0.0f, SnackbarVerticalPadding, 1, null);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            function2.invoke(startRestartGroup, Integer.valueOf(i6 & 14));
            startRestartGroup.endNode();
            Modifier layoutId = LayoutIdKt.layoutId(companion, "action");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId);
            Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl3, maybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion2.getSetModifier());
            function22.invoke(startRestartGroup, Integer.valueOf((i6 >> 3) & 14));
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$OneRowSnackbar$3
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
                    SnackbarKt.OneRowSnackbar(function2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00da  */
    /* renamed from: Snackbar-7zSek6w, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m724Snackbar7zSek6w(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, boolean z5, Shape shape, long j5, long j6, float f5, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i5, final int i6) {
        int i7;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        int i8;
        long j7;
        long j8;
        int i9;
        Modifier modifier2;
        final boolean z6;
        Shape shape2;
        float m2599constructorimpl;
        Modifier modifier3;
        final Shape shape3;
        final boolean z7;
        final float f6;
        final long j9;
        ScopeUpdateScope endRestartGroup;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-558258760);
        int i12 = i6 & 1;
        if (i12 != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i13 = i6 & 2;
        if (i13 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            function23 = function2;
            i7 |= startRestartGroup.changedInstance(function23) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                i7 |= startRestartGroup.changed(z5) ? 256 : 128;
                if ((i5 & 3072) == 0) {
                    if ((i6 & 8) == 0 && startRestartGroup.changed(shape)) {
                        i11 = 2048;
                        i7 |= i11;
                    }
                    i11 = 1024;
                    i7 |= i11;
                }
                if ((i5 & 24576) == 0) {
                    if ((i6 & 16) == 0) {
                        j7 = j5;
                        if (startRestartGroup.changed(j7)) {
                            i10 = 16384;
                            i7 |= i10;
                        }
                    } else {
                        j7 = j5;
                    }
                    i10 = 8192;
                    i7 |= i10;
                } else {
                    j7 = j5;
                }
                if ((196608 & i5) == 0) {
                    j8 = j6;
                    i7 |= ((i6 & 32) == 0 && startRestartGroup.changed(j8)) ? 131072 : 65536;
                } else {
                    j8 = j6;
                }
                i9 = i6 & 64;
                if (i9 != 0) {
                    i7 |= 1572864;
                } else if ((i5 & 1572864) == 0) {
                    i7 |= startRestartGroup.changed(f5) ? 1048576 : 524288;
                }
                if ((i6 & 128) != 0) {
                    i7 |= 12582912;
                } else if ((i5 & 12582912) == 0) {
                    i7 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                }
                if ((4793491 & i7) == 4793490 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        modifier2 = i12 != 0 ? Modifier.INSTANCE : modifier;
                        if (i13 != 0) {
                            function23 = null;
                        }
                        z6 = i8 != 0 ? false : z5;
                        if ((i6 & 8) != 0) {
                            shape2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getSmall();
                            i7 &= -7169;
                        } else {
                            shape2 = shape;
                        }
                        if ((i6 & 16) != 0) {
                            j7 = SnackbarDefaults.INSTANCE.getBackgroundColor(startRestartGroup, 6);
                            i7 &= -57345;
                        }
                        if ((i6 & 32) != 0) {
                            j8 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m671getSurface0d7_KjU();
                            i7 = (-458753) & i7;
                        }
                        if (i9 != 0) {
                            m2599constructorimpl = Dp.m2599constructorimpl(6);
                            long j10 = j7;
                            int i14 = i7;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-558258760, i14, -1, "androidx.compose.material.Snackbar (Snackbar.kt:92)");
                            }
                            boolean z8 = z6;
                            int i15 = i14 >> 6;
                            SurfaceKt.m736SurfaceFjzlyU(modifier2, shape2, j10, j8, null, m2599constructorimpl, ComposableLambdaKt.rememberComposableLambda(-2084221700, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1
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

                                public final void invoke(Composer composer2, int i16) {
                                    if ((i16 & 3) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2084221700, i16, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:100)");
                                    }
                                    ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)));
                                    final Function2<Composer, Integer, Unit> function24 = function23;
                                    final Function2<Composer, Integer, Unit> function25 = function22;
                                    final boolean z9 = z6;
                                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(1939362236, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1.1
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

                                        public final void invoke(Composer composer3, int i17) {
                                            if ((i17 & 3) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1939362236, i17, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:101)");
                                            }
                                            TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer3, 6).getBody2();
                                            final Function2<Composer, Integer, Unit> function26 = function24;
                                            final Function2<Composer, Integer, Unit> function27 = function25;
                                            final boolean z10 = z9;
                                            TextKt.ProvideTextStyle(body2, ComposableLambdaKt.rememberComposableLambda(225114541, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.Snackbar.1.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                    invoke(composer4, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer4, int i18) {
                                                    if ((i18 & 3) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(225114541, i18, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous>.<anonymous> (Snackbar.kt:103)");
                                                    }
                                                    if (function26 == null) {
                                                        composer4.startReplaceGroup(1850967489);
                                                        SnackbarKt.TextOnlySnackbar(function27, composer4, 0);
                                                        composer4.endReplaceGroup();
                                                    } else if (z10) {
                                                        composer4.startReplaceGroup(1850969582);
                                                        SnackbarKt.NewLineButtonSnackbar(function27, function26, composer4, 0);
                                                        composer4.endReplaceGroup();
                                                    } else {
                                                        composer4.startReplaceGroup(1850971719);
                                                        SnackbarKt.OneRowSnackbar(function27, function26, composer4, 0);
                                                        composer4.endReplaceGroup();
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, composer3, 54), composer3, 48);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), startRestartGroup, (i14 & 14) | 1572864 | (i15 & 112) | (i15 & 896) | (i15 & 7168) | ((i14 >> 3) & 458752), 16);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            j7 = j10;
                            shape3 = shape2;
                            z7 = z8;
                            f6 = m2599constructorimpl;
                            j9 = j8;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i6 & 8) != 0) {
                            i7 &= -7169;
                        }
                        if ((i6 & 16) != 0) {
                            i7 &= -57345;
                        }
                        if ((i6 & 32) != 0) {
                            i7 &= -458753;
                        }
                        modifier2 = modifier;
                        z6 = z5;
                        shape2 = shape;
                    }
                    m2599constructorimpl = f5;
                    long j102 = j7;
                    int i142 = i7;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    boolean z82 = z6;
                    int i152 = i142 >> 6;
                    SurfaceKt.m736SurfaceFjzlyU(modifier2, shape2, j102, j8, null, m2599constructorimpl, ComposableLambdaKt.rememberComposableLambda(-2084221700, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1
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

                        public final void invoke(Composer composer2, int i16) {
                            if ((i16 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2084221700, i16, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:100)");
                            }
                            ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)));
                            final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
                            final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                            final boolean z9 = z6;
                            CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(1939362236, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1.1
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

                                public final void invoke(Composer composer3, int i17) {
                                    if ((i17 & 3) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1939362236, i17, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:101)");
                                    }
                                    TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer3, 6).getBody2();
                                    final Function2<? super Composer, ? super Integer, Unit> function26 = function24;
                                    final Function2<? super Composer, ? super Integer, Unit> function27 = function25;
                                    final boolean z10 = z9;
                                    TextKt.ProvideTextStyle(body2, ComposableLambdaKt.rememberComposableLambda(225114541, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.Snackbar.1.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i18) {
                                            if ((i18 & 3) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(225114541, i18, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous>.<anonymous> (Snackbar.kt:103)");
                                            }
                                            if (function26 == null) {
                                                composer4.startReplaceGroup(1850967489);
                                                SnackbarKt.TextOnlySnackbar(function27, composer4, 0);
                                                composer4.endReplaceGroup();
                                            } else if (z10) {
                                                composer4.startReplaceGroup(1850969582);
                                                SnackbarKt.NewLineButtonSnackbar(function27, function26, composer4, 0);
                                                composer4.endReplaceGroup();
                                            } else {
                                                composer4.startReplaceGroup(1850971719);
                                                SnackbarKt.OneRowSnackbar(function27, function26, composer4, 0);
                                                composer4.endReplaceGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer3, 54), composer3, 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, (i142 & 14) | 1572864 | (i152 & 112) | (i152 & 896) | (i152 & 7168) | ((i142 >> 3) & 458752), 16);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier2;
                    j7 = j102;
                    shape3 = shape2;
                    z7 = z82;
                    f6 = m2599constructorimpl;
                    j9 = j8;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier3 = modifier;
                    z7 = z5;
                    shape3 = shape;
                    j9 = j8;
                    f6 = f5;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
                    final long j11 = j7;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$2
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

                        public final void invoke(Composer composer2, int i16) {
                            SnackbarKt.m724Snackbar7zSek6w(Modifier.this, function24, z7, shape3, j11, j9, f6, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                        }
                    });
                    return;
                }
                return;
            }
            if ((i5 & 3072) == 0) {
            }
            if ((i5 & 24576) == 0) {
            }
            if ((196608 & i5) == 0) {
            }
            i9 = i6 & 64;
            if (i9 != 0) {
            }
            if ((i6 & 128) != 0) {
            }
            if ((4793491 & i7) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            if (i8 != 0) {
            }
            if ((i6 & 8) != 0) {
            }
            if ((i6 & 16) != 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if (i9 != 0) {
            }
            m2599constructorimpl = f5;
            long j1022 = j7;
            int i1422 = i7;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            boolean z822 = z6;
            int i1522 = i1422 >> 6;
            SurfaceKt.m736SurfaceFjzlyU(modifier2, shape2, j1022, j8, null, m2599constructorimpl, ComposableLambdaKt.rememberComposableLambda(-2084221700, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1
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

                public final void invoke(Composer composer2, int i16) {
                    if ((i16 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2084221700, i16, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:100)");
                    }
                    ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)));
                    final Function2<? super Composer, ? super Integer, Unit> function242 = function23;
                    final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                    final boolean z9 = z6;
                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(1939362236, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1.1
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

                        public final void invoke(Composer composer3, int i17) {
                            if ((i17 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1939362236, i17, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:101)");
                            }
                            TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer3, 6).getBody2();
                            final Function2<? super Composer, ? super Integer, Unit> function26 = function242;
                            final Function2<? super Composer, ? super Integer, Unit> function27 = function25;
                            final boolean z10 = z9;
                            TextKt.ProvideTextStyle(body2, ComposableLambdaKt.rememberComposableLambda(225114541, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.Snackbar.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i18) {
                                    if ((i18 & 3) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(225114541, i18, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous>.<anonymous> (Snackbar.kt:103)");
                                    }
                                    if (function26 == null) {
                                        composer4.startReplaceGroup(1850967489);
                                        SnackbarKt.TextOnlySnackbar(function27, composer4, 0);
                                        composer4.endReplaceGroup();
                                    } else if (z10) {
                                        composer4.startReplaceGroup(1850969582);
                                        SnackbarKt.NewLineButtonSnackbar(function27, function26, composer4, 0);
                                        composer4.endReplaceGroup();
                                    } else {
                                        composer4.startReplaceGroup(1850971719);
                                        SnackbarKt.OneRowSnackbar(function27, function26, composer4, 0);
                                        composer4.endReplaceGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), composer3, 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i1422 & 14) | 1572864 | (i1522 & 112) | (i1522 & 896) | (i1522 & 7168) | ((i1422 >> 3) & 458752), 16);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            j7 = j1022;
            shape3 = shape2;
            z7 = z822;
            f6 = m2599constructorimpl;
            j9 = j8;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function23 = function2;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        if ((i5 & 3072) == 0) {
        }
        if ((i5 & 24576) == 0) {
        }
        if ((196608 & i5) == 0) {
        }
        i9 = i6 & 64;
        if (i9 != 0) {
        }
        if ((i6 & 128) != 0) {
        }
        if ((4793491 & i7) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        if (i8 != 0) {
        }
        if ((i6 & 8) != 0) {
        }
        if ((i6 & 16) != 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if (i9 != 0) {
        }
        m2599constructorimpl = f5;
        long j10222 = j7;
        int i14222 = i7;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        boolean z8222 = z6;
        int i15222 = i14222 >> 6;
        SurfaceKt.m736SurfaceFjzlyU(modifier2, shape2, j10222, j8, null, m2599constructorimpl, ComposableLambdaKt.rememberComposableLambda(-2084221700, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1
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

            public final void invoke(Composer composer2, int i16) {
                if ((i16 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2084221700, i16, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:100)");
                }
                ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)));
                final Function2<? super Composer, ? super Integer, Unit> function242 = function23;
                final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                final boolean z9 = z6;
                CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(1939362236, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1.1
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

                    public final void invoke(Composer composer3, int i17) {
                        if ((i17 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1939362236, i17, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:101)");
                        }
                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer3, 6).getBody2();
                        final Function2<? super Composer, ? super Integer, Unit> function26 = function242;
                        final Function2<? super Composer, ? super Integer, Unit> function27 = function25;
                        final boolean z10 = z9;
                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.rememberComposableLambda(225114541, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.Snackbar.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i18) {
                                if ((i18 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(225114541, i18, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous>.<anonymous> (Snackbar.kt:103)");
                                }
                                if (function26 == null) {
                                    composer4.startReplaceGroup(1850967489);
                                    SnackbarKt.TextOnlySnackbar(function27, composer4, 0);
                                    composer4.endReplaceGroup();
                                } else if (z10) {
                                    composer4.startReplaceGroup(1850969582);
                                    SnackbarKt.NewLineButtonSnackbar(function27, function26, composer4, 0);
                                    composer4.endReplaceGroup();
                                } else {
                                    composer4.startReplaceGroup(1850971719);
                                    SnackbarKt.OneRowSnackbar(function27, function26, composer4, 0);
                                    composer4.endReplaceGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54), composer3, 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, (i14222 & 14) | 1572864 | (i15222 & 112) | (i15222 & 896) | (i15222 & 7168) | ((i14222 >> 3) & 458752), 16);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        j7 = j10222;
        shape3 = shape2;
        z7 = z8222;
        f6 = m2599constructorimpl;
        j9 = j8;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x016c  */
    /* renamed from: Snackbar-sPrSdHI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m725SnackbarsPrSdHI(final SnackbarData snackbarData, Modifier modifier, boolean z5, Shape shape, long j5, long j6, long j7, float f5, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        boolean z6;
        Shape shape2;
        long j8;
        long j9;
        int i9;
        long j10;
        float m2599constructorimpl;
        int i10;
        long j11;
        final long j12;
        final String actionLabel;
        final SnackbarData snackbarData2;
        long j13;
        ComposableLambda composableLambda;
        long j14;
        float f6;
        final boolean z7;
        final Shape shape3;
        final long j15;
        ScopeUpdateScope endRestartGroup;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(258660814);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = ((i5 & 8) == 0 ? startRestartGroup.changed(snackbarData) : startRestartGroup.changedInstance(snackbarData) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i13 = i6 & 2;
        if (i13 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                z6 = z5;
                i7 |= startRestartGroup.changed(z6) ? 256 : 128;
                if ((i5 & 3072) == 0) {
                    if ((i6 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i12 = 2048;
                            i7 |= i12;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i12 = 1024;
                    i7 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((i5 & 24576) == 0) {
                    if ((i6 & 16) == 0) {
                        j8 = j5;
                        if (startRestartGroup.changed(j8)) {
                            i11 = 16384;
                            i7 |= i11;
                        }
                    } else {
                        j8 = j5;
                    }
                    i11 = 8192;
                    i7 |= i11;
                } else {
                    j8 = j5;
                }
                if ((196608 & i5) == 0) {
                    j9 = j6;
                    i7 |= ((i6 & 32) == 0 && startRestartGroup.changed(j9)) ? 131072 : 65536;
                } else {
                    j9 = j6;
                }
                if ((1572864 & i5) == 0) {
                    i7 |= ((i6 & 64) == 0 && startRestartGroup.changed(j7)) ? 1048576 : 524288;
                }
                i9 = i6 & 128;
                if (i9 != 0) {
                    i7 |= 12582912;
                } else if ((i5 & 12582912) == 0) {
                    i7 |= startRestartGroup.changed(f5) ? 8388608 : 4194304;
                }
                if ((4793491 & i7) == 4793490 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        }
                        if ((i6 & 8) != 0) {
                            i7 &= -7169;
                            shape2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getSmall();
                        }
                        if ((i6 & 16) != 0) {
                            j8 = SnackbarDefaults.INSTANCE.getBackgroundColor(startRestartGroup, 6);
                            i7 &= -57345;
                        }
                        if ((i6 & 32) != 0) {
                            j9 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m671getSurface0d7_KjU();
                            i7 &= -458753;
                        }
                        if ((i6 & 64) != 0) {
                            j10 = SnackbarDefaults.INSTANCE.getPrimaryActionColor(startRestartGroup, 6);
                            i7 &= -3670017;
                        } else {
                            j10 = j7;
                        }
                        m2599constructorimpl = i9 != 0 ? Dp.m2599constructorimpl(6) : f5;
                        i10 = i7;
                        j11 = j9;
                        j12 = j10;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i6 & 8) != 0) {
                            i7 &= -7169;
                        }
                        if ((i6 & 16) != 0) {
                            i7 &= -57345;
                        }
                        if ((i6 & 32) != 0) {
                            i7 &= -458753;
                        }
                        if ((i6 & 64) != 0) {
                            i7 &= -3670017;
                        }
                        m2599constructorimpl = f5;
                        i10 = i7;
                        j11 = j9;
                        j12 = j7;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(258660814, i10, -1, "androidx.compose.material.Snackbar (Snackbar.kt:163)");
                    }
                    actionLabel = snackbarData.getActionLabel();
                    if (actionLabel != null) {
                        startRestartGroup.startReplaceGroup(1609178760);
                        snackbarData2 = snackbarData;
                        j13 = j12;
                        ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1843479216, true, new Function2<Composer, Integer, Unit>(j12, snackbarData2, actionLabel) { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1
                            final /* synthetic */ long $actionColor;
                            final /* synthetic */ String $actionLabel;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                                this.$actionLabel = actionLabel;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i14) {
                                if ((i14 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1843479216, i14, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:167)");
                                }
                                ButtonColors m659textButtonColorsRGew2ao = ButtonDefaults.INSTANCE.m659textButtonColorsRGew2ao(0L, this.$actionColor, 0L, composer2, 3072, 5);
                                final SnackbarData snackbarData3 = null;
                                boolean changedInstance = composer2.changedInstance(null);
                                Object rememberedValue = composer2.rememberedValue();
                                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function0<Unit>(snackbarData3) { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
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
                                            throw null;
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue);
                                }
                                Function0 function0 = (Function0) rememberedValue;
                                final String str = this.$actionLabel;
                                ButtonKt.TextButton(function0, null, false, null, null, null, null, m659textButtonColorsRGew2ao, null, ComposableLambdaKt.rememberComposableLambda(-929149933, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                        invoke(rowScope, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(RowScope rowScope, Composer composer3, int i15) {
                                        if ((i15 & 17) == 16 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-929149933, i15, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:170)");
                                        }
                                        TextKt.m746Text4IGK_g(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 131070);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer2, 54), composer2, 805306368, 382);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54);
                        startRestartGroup.endReplaceGroup();
                        composableLambda = rememberComposableLambda;
                    } else {
                        snackbarData2 = snackbarData;
                        j13 = j12;
                        startRestartGroup.startReplaceGroup(1609445763);
                        startRestartGroup.endReplaceGroup();
                        composableLambda = null;
                    }
                    Modifier modifier3 = modifier2;
                    m724Snackbar7zSek6w(PaddingKt.m311padding3ABfNKs(modifier2, Dp.m2599constructorimpl(12)), composableLambda, z6, shape2, j8, j11, m2599constructorimpl, ComposableLambdaKt.rememberComposableLambda(-261845785, true, new Function2<Composer, Integer, Unit>(snackbarData2) { // from class: androidx.compose.material.SnackbarKt$Snackbar$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            if ((i14 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-261845785, i14, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:178)");
                                }
                                throw null;
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, (i10 & 896) | 12582912 | (i10 & 7168) | (57344 & i10) | (458752 & i10) | ((i10 >> 3) & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j14 = j13;
                    modifier2 = modifier3;
                    f6 = m2599constructorimpl;
                    z7 = z6;
                    shape3 = shape2;
                    j15 = j11;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    j14 = j7;
                    f6 = f5;
                    z7 = z6;
                    shape3 = shape2;
                    j15 = j9;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier2;
                    final long j16 = j8;
                    final long j17 = j14;
                    final float f7 = f6;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>(snackbarData, modifier4, z7, shape3, j16, j15, j17, f7, i5, i6) { // from class: androidx.compose.material.SnackbarKt$Snackbar$4
                        final /* synthetic */ int $$changed;
                        final /* synthetic */ int $$default;
                        final /* synthetic */ long $actionColor;
                        final /* synthetic */ boolean $actionOnNewLine;
                        final /* synthetic */ long $backgroundColor;
                        final /* synthetic */ long $contentColor;
                        final /* synthetic */ float $elevation;
                        final /* synthetic */ Modifier $modifier;
                        final /* synthetic */ Shape $shape;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                            this.$modifier = modifier4;
                            this.$actionOnNewLine = z7;
                            this.$shape = shape3;
                            this.$backgroundColor = j16;
                            this.$contentColor = j15;
                            this.$actionColor = j17;
                            this.$elevation = f7;
                            this.$$changed = i5;
                            this.$$default = i6;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            SnackbarKt.m725SnackbarsPrSdHI(null, this.$modifier, this.$actionOnNewLine, this.$shape, this.$backgroundColor, this.$contentColor, this.$actionColor, this.$elevation, composer2, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
                        }
                    });
                    return;
                }
                return;
            }
            z6 = z5;
            if ((i5 & 3072) == 0) {
            }
            if ((i5 & 24576) == 0) {
            }
            if ((196608 & i5) == 0) {
            }
            if ((1572864 & i5) == 0) {
            }
            i9 = i6 & 128;
            if (i9 != 0) {
            }
            if ((4793491 & i7) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i13 != 0) {
            }
            if (i8 != 0) {
            }
            if ((i6 & 8) != 0) {
            }
            if ((i6 & 16) != 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if ((i6 & 64) != 0) {
            }
            if (i9 != 0) {
            }
            i10 = i7;
            j11 = j9;
            j12 = j10;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            actionLabel = snackbarData.getActionLabel();
            if (actionLabel != null) {
            }
            Modifier modifier32 = modifier2;
            m724Snackbar7zSek6w(PaddingKt.m311padding3ABfNKs(modifier2, Dp.m2599constructorimpl(12)), composableLambda, z6, shape2, j8, j11, m2599constructorimpl, ComposableLambdaKt.rememberComposableLambda(-261845785, true, new Function2<Composer, Integer, Unit>(snackbarData2) { // from class: androidx.compose.material.SnackbarKt$Snackbar$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i14) {
                    if ((i14 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-261845785, i14, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:178)");
                        }
                        throw null;
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i10 & 896) | 12582912 | (i10 & 7168) | (57344 & i10) | (458752 & i10) | ((i10 >> 3) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            j14 = j13;
            modifier2 = modifier32;
            f6 = m2599constructorimpl;
            z7 = z6;
            shape3 = shape2;
            j15 = j11;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        z6 = z5;
        if ((i5 & 3072) == 0) {
        }
        if ((i5 & 24576) == 0) {
        }
        if ((196608 & i5) == 0) {
        }
        if ((1572864 & i5) == 0) {
        }
        i9 = i6 & 128;
        if (i9 != 0) {
        }
        if ((4793491 & i7) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i13 != 0) {
        }
        if (i8 != 0) {
        }
        if ((i6 & 8) != 0) {
        }
        if ((i6 & 16) != 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if ((i6 & 64) != 0) {
        }
        if (i9 != 0) {
        }
        i10 = i7;
        j11 = j9;
        j12 = j10;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        actionLabel = snackbarData.getActionLabel();
        if (actionLabel != null) {
        }
        Modifier modifier322 = modifier2;
        m724Snackbar7zSek6w(PaddingKt.m311padding3ABfNKs(modifier2, Dp.m2599constructorimpl(12)), composableLambda, z6, shape2, j8, j11, m2599constructorimpl, ComposableLambdaKt.rememberComposableLambda(-261845785, true, new Function2<Composer, Integer, Unit>(snackbarData2) { // from class: androidx.compose.material.SnackbarKt$Snackbar$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i14) {
                if ((i14 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-261845785, i14, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:178)");
                    }
                    throw null;
                }
            }
        }, startRestartGroup, 54), startRestartGroup, (i10 & 896) | 12582912 | (i10 & 7168) | (57344 & i10) | (458752 & i10) | ((i10 >> 3) & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        j14 = j13;
        modifier2 = modifier322;
        f6 = m2599constructorimpl;
        z7 = z6;
        shape3 = shape2;
        j15 = j11;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextOnlySnackbar(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(917397959);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(917397959, i6, -1, "androidx.compose.material.TextOnlySnackbar (Snackbar.kt:238)");
            }
            SnackbarKt$TextOnlySnackbar$2 snackbarKt$TextOnlySnackbar$2 = new MeasurePolicy() { // from class: androidx.compose.material.SnackbarKt$TextOnlySnackbar$2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                    final ArrayList arrayList = new ArrayList(list.size());
                    int size = list.size();
                    boolean z5 = false;
                    int i7 = Integer.MIN_VALUE;
                    int i8 = Integer.MIN_VALUE;
                    int i9 = 0;
                    for (int i10 = 0; i10 < size; i10++) {
                        Placeable mo1946measureBRTryo0 = list.get(i10).mo1946measureBRTryo0(j5);
                        arrayList.add(mo1946measureBRTryo0);
                        if (mo1946measureBRTryo0.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline()) != Integer.MIN_VALUE && (i7 == Integer.MIN_VALUE || mo1946measureBRTryo0.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline()) < i7)) {
                            i7 = mo1946measureBRTryo0.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline());
                        }
                        if (mo1946measureBRTryo0.get(androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline()) != Integer.MIN_VALUE && (i8 == Integer.MIN_VALUE || mo1946measureBRTryo0.get(androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline()) > i8)) {
                            i8 = mo1946measureBRTryo0.get(androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline());
                        }
                        i9 = Math.max(i9, mo1946measureBRTryo0.getHeight());
                    }
                    if (i7 != Integer.MIN_VALUE && i8 != Integer.MIN_VALUE) {
                        z5 = true;
                    }
                    final int max = Math.max(measureScope.mo206roundToPx0680j_4((i7 == i8 || !z5) ? SnackbarKt.SnackbarMinHeightOneLine : SnackbarKt.SnackbarMinHeightTwoLines), i9);
                    return MeasureScope.layout$default(measureScope, Constraints.m2578getMaxWidthimpl(j5), max, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.SnackbarKt$TextOnlySnackbar$2.2
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
                            ArrayList<Placeable> arrayList2 = arrayList;
                            int i11 = max;
                            int size2 = arrayList2.size();
                            for (int i12 = 0; i12 < size2; i12++) {
                                Placeable placeable = arrayList2.get(i12);
                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, (i11 - placeable.getHeight()) / 2, 0.0f, 4, null);
                            }
                        }
                    }, 4, null);
                }
            };
            Modifier.Companion companion = Modifier.INSTANCE;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
            Updater.m1227setimpl(m1226constructorimpl, snackbarKt$TextOnlySnackbar$2, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(companion, HorizontalSpacing, SnackbarVerticalPadding);
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            function2.invoke(startRestartGroup, Integer.valueOf(i6 & 14));
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$TextOnlySnackbar$3
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
                    SnackbarKt.TextOnlySnackbar(function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }
}
