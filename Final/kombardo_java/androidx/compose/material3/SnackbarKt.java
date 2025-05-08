package androidx.compose.material3;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SnackbarTokens;
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
import androidx.compose.ui.graphics.Color;
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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u008a\u0001\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001aj\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001aV\u0010\u001d\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001aX\u0010!\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0003ø\u0001\u0000¢\u0006\u0004\b \u0010\u001c\"\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$\"\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$\"\u0014\u0010&\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010$\"\u0014\u0010'\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010$\"\u0014\u0010(\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010$\"\u0014\u0010)\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010$\"\u0014\u0010*\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010$\"\u0014\u0010+\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010$\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006,"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function0;", BuildConfig.FLAVOR, "action", "dismissAction", BuildConfig.FLAVOR, "actionOnNewLine", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/graphics/Color;", "containerColor", "contentColor", "actionContentColor", "dismissActionContentColor", "content", "Snackbar-eQBnUkQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Snackbar", "Landroidx/compose/material3/SnackbarData;", "snackbarData", "actionColor", "Snackbar-sDKtq54", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJJJLandroidx/compose/runtime/Composer;II)V", "text", "Landroidx/compose/ui/text/TextStyle;", "actionTextStyle", "NewLineButtonSnackbar-kKq0p4A", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JJLandroidx/compose/runtime/Composer;I)V", "NewLineButtonSnackbar", "actionTextColor", "dismissActionColor", "OneRowSnackbar-kKq0p4A", "OneRowSnackbar", "Landroidx/compose/ui/unit/Dp;", "ContainerMaxWidth", "F", "HeightToFirstLine", "HorizontalSpacing", "HorizontalSpacingButtonSide", "SeparateButtonExtraY", "SnackbarVerticalPadding", "TextEndExtraSpacing", "LongButtonVerticalOffset", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SnackbarKt {
    private static final float HorizontalSpacingButtonSide;
    private static final float TextEndExtraSpacing;
    private static final float ContainerMaxWidth = Dp.m2599constructorimpl(600);
    private static final float HeightToFirstLine = Dp.m2599constructorimpl(30);
    private static final float HorizontalSpacing = Dp.m2599constructorimpl(16);
    private static final float SeparateButtonExtraY = Dp.m2599constructorimpl(2);
    private static final float SnackbarVerticalPadding = Dp.m2599constructorimpl(6);
    private static final float LongButtonVerticalOffset = Dp.m2599constructorimpl(12);

    static {
        float f5 = 8;
        HorizontalSpacingButtonSide = Dp.m2599constructorimpl(f5);
        TextEndExtraSpacing = Dp.m2599constructorimpl(f5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: NewLineButtonSnackbar-kKq0p4A, reason: not valid java name */
    public static final void m894NewLineButtonSnackbarkKq0p4A(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final TextStyle textStyle, final long j5, final long j6, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1332496681);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function23) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(textStyle) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(j5) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(j6) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1332496681, i6, -1, "androidx.compose.material3.NewLineButtonSnackbar (Snackbar.kt:263)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m338widthInVpY3zN4$default(companion, 0.0f, ContainerMaxWidth, 1, null), 0.0f, 1, null), HorizontalSpacing, 0.0f, 0.0f, SeparateButtonExtraY, 6, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
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
            Modifier m262paddingFromBaselineVpY3zN4 = AlignmentLineKt.m262paddingFromBaselineVpY3zN4(companion, HeightToFirstLine, LongButtonVerticalOffset);
            float f5 = HorizontalSpacingButtonSide;
            Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(m262paddingFromBaselineVpY3zN4, 0.0f, 0.0f, f5, 0.0f, 11, null);
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
            Modifier m315paddingqDBjuR0$default3 = PaddingKt.m315paddingqDBjuR0$default(columnScopeInstance.align(companion, companion2.getEnd()), 0.0f, 0.0f, function23 == null ? f5 : Dp.m2599constructorimpl(0), 0.0f, 11, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default3);
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
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
            Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl4, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j5)), TextKt.getLocalTextStyle().provides(textStyle)};
            int i7 = ProvidedValue.$stable;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, function22, startRestartGroup, (i6 & 112) | i7);
            startRestartGroup.startReplaceGroup(618603253);
            if (function23 != null) {
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j6)), function23, startRestartGroup, ((i6 >> 3) & 112) | i7);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$NewLineButtonSnackbar$2
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

                public final void invoke(Composer composer2, int i8) {
                    SnackbarKt.m894NewLineButtonSnackbarkKq0p4A(function2, function22, function23, textStyle, j5, j6, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OneRowSnackbar-kKq0p4A, reason: not valid java name */
    public static final void m895OneRowSnackbarkKq0p4A(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final TextStyle textStyle, final long j5, final long j6, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-903235475);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function23) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(textStyle) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(j5) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(j6) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-903235475, i6, -1, "androidx.compose.material3.OneRowSnackbar (Snackbar.kt:308)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, HorizontalSpacing, 0.0f, function23 == null ? HorizontalSpacingButtonSide : Dp.m2599constructorimpl(0), 0.0f, 10, null);
            Object rememberedValue = startRestartGroup.rememberedValue();
            final String str = "text";
            final String str2 = "action";
            final String str3 = "dismissAction";
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j7) {
                        float f5;
                        Measurable measurable;
                        Measurable measurable2;
                        int i7;
                        Placeable placeable;
                        float f6;
                        final int i8;
                        final int height;
                        int i9;
                        int i10;
                        float f7;
                        int m2578getMaxWidthimpl = Constraints.m2578getMaxWidthimpl(j7);
                        f5 = SnackbarKt.ContainerMaxWidth;
                        int min = Math.min(m2578getMaxWidthimpl, measureScope.mo206roundToPx0680j_4(f5));
                        String str4 = str2;
                        int size = list.size();
                        int i11 = 0;
                        while (true) {
                            if (i11 >= size) {
                                measurable = null;
                                break;
                            }
                            measurable = list.get(i11);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), str4)) {
                                break;
                            }
                            i11++;
                        }
                        Measurable measurable3 = measurable;
                        Placeable mo1946measureBRTryo0 = measurable3 != null ? measurable3.mo1946measureBRTryo0(j7) : null;
                        String str5 = str3;
                        int size2 = list.size();
                        int i12 = 0;
                        while (true) {
                            if (i12 >= size2) {
                                measurable2 = null;
                                break;
                            }
                            measurable2 = list.get(i12);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), str5)) {
                                break;
                            }
                            i12++;
                        }
                        Measurable measurable4 = measurable2;
                        final Placeable mo1946measureBRTryo02 = measurable4 != null ? measurable4.mo1946measureBRTryo0(j7) : null;
                        int width = mo1946measureBRTryo0 != null ? mo1946measureBRTryo0.getWidth() : 0;
                        int height2 = mo1946measureBRTryo0 != null ? mo1946measureBRTryo0.getHeight() : 0;
                        int width2 = mo1946measureBRTryo02 != null ? mo1946measureBRTryo02.getWidth() : 0;
                        int height3 = mo1946measureBRTryo02 != null ? mo1946measureBRTryo02.getHeight() : 0;
                        if (width2 == 0) {
                            f7 = SnackbarKt.TextEndExtraSpacing;
                            i7 = measureScope.mo206roundToPx0680j_4(f7);
                        } else {
                            i7 = 0;
                        }
                        int coerceAtLeast = RangesKt.coerceAtLeast(((min - width) - width2) - i7, Constraints.m2580getMinWidthimpl(j7));
                        String str6 = str;
                        int size3 = list.size();
                        int i13 = 0;
                        while (i13 < size3) {
                            Measurable measurable5 = list.get(i13);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable5), str6)) {
                                Placeable placeable2 = mo1946measureBRTryo0;
                                int i14 = height3;
                                final Placeable mo1946measureBRTryo03 = measurable5.mo1946measureBRTryo0(Constraints.m2570copyZbe2FdA$default(j7, 0, coerceAtLeast, 0, 0, 9, null));
                                int i15 = mo1946measureBRTryo03.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline());
                                int i16 = mo1946measureBRTryo03.get(androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline());
                                boolean z5 = true;
                                boolean z6 = (i15 == Integer.MIN_VALUE || i16 == Integer.MIN_VALUE) ? false : true;
                                if (i15 != i16 && z6) {
                                    z5 = false;
                                }
                                final int i17 = min - width2;
                                final int i18 = i17 - width;
                                if (z5) {
                                    i9 = Math.max(measureScope.mo206roundToPx0680j_4(SnackbarTokens.INSTANCE.m1152getSingleLineContainerHeightD9Ej5fM()), Math.max(height2, i14));
                                    int height4 = (i9 - mo1946measureBRTryo03.getHeight()) / 2;
                                    if (placeable2 != null) {
                                        placeable = placeable2;
                                        int i19 = placeable.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline());
                                        if (i19 != Integer.MIN_VALUE) {
                                            i10 = (i15 + height4) - i19;
                                            height = i10;
                                            i8 = height4;
                                        }
                                    } else {
                                        placeable = placeable2;
                                    }
                                    i10 = 0;
                                    height = i10;
                                    i8 = height4;
                                } else {
                                    placeable = placeable2;
                                    f6 = SnackbarKt.HeightToFirstLine;
                                    int mo206roundToPx0680j_4 = measureScope.mo206roundToPx0680j_4(f6) - i15;
                                    int max = Math.max(measureScope.mo206roundToPx0680j_4(SnackbarTokens.INSTANCE.m1153getTwoLinesContainerHeightD9Ej5fM()), mo1946measureBRTryo03.getHeight() + mo206roundToPx0680j_4);
                                    i8 = mo206roundToPx0680j_4;
                                    height = placeable != null ? (max - placeable.getHeight()) / 2 : 0;
                                    i9 = max;
                                }
                                final int height5 = mo1946measureBRTryo02 != null ? (i9 - mo1946measureBRTryo02.getHeight()) / 2 : 0;
                                final Placeable placeable3 = placeable;
                                return MeasureScope.layout$default(measureScope, min, i9, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1.2
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
                                        Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, i8, 0.0f, 4, null);
                                        Placeable placeable4 = mo1946measureBRTryo02;
                                        if (placeable4 != null) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i17, height5, 0.0f, 4, null);
                                        }
                                        Placeable placeable5 = placeable3;
                                        if (placeable5 != null) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, i18, height, 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                            i13++;
                            mo1946measureBRTryo0 = mo1946measureBRTryo0;
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
            startRestartGroup.startReplaceGroup(-904778058);
            if (function22 != null) {
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
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j5)), TextKt.getLocalTextStyle().provides(textStyle)}, function22, startRestartGroup, ProvidedValue.$stable | (i6 & 112));
                startRestartGroup.endNode();
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-904766579);
            if (function23 != null) {
                Modifier layoutId2 = LayoutIdKt.layoutId(companion, "dismissAction");
                MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId2);
                Function0<ComposeUiNode> constructor4 = companion2.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl4, maybeCachedBoxMeasurePolicy3, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion2.getSetCompositeKeyHash();
                if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion2.getSetModifier());
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j6)), function23, startRestartGroup, ((i6 >> 3) & 112) | ProvidedValue.$stable);
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$3
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
                    SnackbarKt.m895OneRowSnackbarkKq0p4A(function2, function22, function23, textStyle, j5, j6, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0191  */
    /* renamed from: Snackbar-eQBnUkQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m896SnackbareQBnUkQ(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z5, Shape shape, long j5, long j6, long j7, long j8, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i5, final int i6) {
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i9;
        long j9;
        long j10;
        Modifier modifier2;
        Function2<? super Composer, ? super Integer, Unit> function26;
        boolean z6;
        Shape shape2;
        long j11;
        long j12;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        Modifier modifier3;
        final Shape shape3;
        final boolean z7;
        final long j13;
        long j14;
        final long j15;
        ScopeUpdateScope endRestartGroup;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-1235788955);
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
            function24 = function2;
            i7 |= startRestartGroup.changedInstance(function24) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                function25 = function22;
                i7 |= startRestartGroup.changedInstance(function25) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    i7 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                    if ((i5 & 24576) == 0) {
                        if ((i6 & 16) == 0 && startRestartGroup.changed(shape)) {
                            i11 = 16384;
                            i7 |= i11;
                        }
                        i11 = 8192;
                        i7 |= i11;
                    }
                    if ((196608 & i5) != 0) {
                        if ((i6 & 32) == 0) {
                            j9 = j5;
                            if (startRestartGroup.changed(j9)) {
                                i10 = 131072;
                                i7 |= i10;
                            }
                        } else {
                            j9 = j5;
                        }
                        i10 = 65536;
                        i7 |= i10;
                    } else {
                        j9 = j5;
                    }
                    if ((i5 & 1572864) == 0) {
                        i7 |= ((i6 & 64) == 0 && startRestartGroup.changed(j6)) ? 1048576 : 524288;
                    }
                    if ((i5 & 12582912) == 0) {
                        i7 |= ((i6 & 128) == 0 && startRestartGroup.changed(j7)) ? 8388608 : 4194304;
                    }
                    if ((100663296 & i5) != 0) {
                        j10 = j8;
                        i7 |= ((i6 & 256) == 0 && startRestartGroup.changed(j10)) ? 67108864 : 33554432;
                    } else {
                        j10 = j8;
                    }
                    if ((i6 & 512) == 0) {
                        i7 |= 805306368;
                    } else if ((i5 & 805306368) == 0) {
                        i7 |= startRestartGroup.changedInstance(function23) ? 536870912 : 268435456;
                        if ((i7 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                modifier2 = i12 != 0 ? Modifier.INSTANCE : modifier;
                                if (i13 != 0) {
                                    function24 = null;
                                }
                                function26 = i8 == 0 ? function25 : null;
                                z6 = i9 != 0 ? false : z5;
                                if ((i6 & 16) != 0) {
                                    shape2 = SnackbarDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                    i7 &= -57345;
                                } else {
                                    shape2 = shape;
                                }
                                if ((i6 & 32) != 0) {
                                    j9 = SnackbarDefaults.INSTANCE.getColor(startRestartGroup, 6);
                                    i7 &= -458753;
                                }
                                if ((i6 & 64) != 0) {
                                    j11 = SnackbarDefaults.INSTANCE.getContentColor(startRestartGroup, 6);
                                    i7 &= -3670017;
                                } else {
                                    j11 = j6;
                                }
                                if ((i6 & 128) != 0) {
                                    j12 = SnackbarDefaults.INSTANCE.getActionContentColor(startRestartGroup, 6);
                                    i7 &= -29360129;
                                } else {
                                    j12 = j7;
                                }
                                if ((i6 & 256) != 0) {
                                    i7 &= -234881025;
                                    j10 = SnackbarDefaults.INSTANCE.getDismissActionContentColor(startRestartGroup, 6);
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i6 & 16) != 0) {
                                    i7 &= -57345;
                                }
                                if ((i6 & 32) != 0) {
                                    i7 &= -458753;
                                }
                                if ((i6 & 64) != 0) {
                                    i7 &= -3670017;
                                }
                                if ((i6 & 128) != 0) {
                                    i7 &= -29360129;
                                }
                                if ((i6 & 256) != 0) {
                                    i7 &= -234881025;
                                }
                                modifier2 = modifier;
                                z6 = z5;
                                shape2 = shape;
                                j11 = j6;
                                j12 = j7;
                                function26 = function25;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1235788955, i7, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:113)");
                            }
                            final boolean z8 = z6;
                            final Function2<? super Composer, ? super Integer, Unit> function28 = function24;
                            final Function2<? super Composer, ? super Integer, Unit> function29 = function26;
                            final long j16 = j12;
                            final long j17 = j10;
                            Function2<? super Composer, ? super Integer, Unit> function210 = function26;
                            boolean z9 = z6;
                            int i14 = (i7 & 14) | 12779520;
                            int i15 = i7 >> 9;
                            SurfaceKt.m900SurfaceT9BRK9s(modifier2, shape2, j9, j11, 0.0f, SnackbarTokens.INSTANCE.m1151getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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
                                        ComposerKt.traceEventStart(-1829663446, i16, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:121)");
                                    }
                                    SnackbarTokens snackbarTokens = SnackbarTokens.INSTANCE;
                                    TextStyle value = TypographyKt.getValue(snackbarTokens.getSupportingTextFont(), composer2, 6);
                                    final TextStyle value2 = TypographyKt.getValue(snackbarTokens.getActionLabelTextFont(), composer2, 6);
                                    ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(value);
                                    final boolean z10 = z8;
                                    final Function2<Composer, Integer, Unit> function211 = function28;
                                    final Function2<Composer, Integer, Unit> function212 = function23;
                                    final Function2<Composer, Integer, Unit> function213 = function29;
                                    final long j18 = j16;
                                    final long j19 = j17;
                                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
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
                                                ComposerKt.traceEventStart(835891690, i17, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:124)");
                                            }
                                            if (z10 && function211 != null) {
                                                composer3.startReplaceGroup(-810715387);
                                                SnackbarKt.m894NewLineButtonSnackbarkKq0p4A(function212, function211, function213, value2, j18, j19, composer3, 0);
                                                composer3.endReplaceGroup();
                                            } else {
                                                composer3.startReplaceGroup(-810701708);
                                                SnackbarKt.m895OneRowSnackbarkKq0p4A(function212, function211, function213, value2, j18, j19, composer3, 0);
                                                composer3.endReplaceGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), startRestartGroup, (i15 & 7168) | i14 | (i15 & 112) | (i15 & 896), 80);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function27 = function210;
                            modifier3 = modifier2;
                            shape3 = shape2;
                            z7 = z9;
                            j13 = j11;
                            j14 = j10;
                            j15 = j12;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier;
                            z7 = z5;
                            shape3 = shape;
                            function27 = function25;
                            j14 = j10;
                            j13 = j6;
                            j15 = j7;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier4 = modifier3;
                            final Function2<? super Composer, ? super Integer, Unit> function211 = function24;
                            final long j18 = j9;
                            final long j19 = j14;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$2
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
                                    SnackbarKt.m896SnackbareQBnUkQ(Modifier.this, function211, function27, z7, shape3, j18, j13, j15, j19, function23, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i7 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i9 != 0) {
                    }
                    if ((i6 & 16) != 0) {
                    }
                    if ((i6 & 32) != 0) {
                    }
                    if ((i6 & 64) != 0) {
                    }
                    if ((i6 & 128) != 0) {
                    }
                    if ((i6 & 256) != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final boolean z82 = z6;
                    final Function2<? super Composer, ? super Integer, Unit> function282 = function24;
                    final Function2<? super Composer, ? super Integer, Unit> function292 = function26;
                    final long j162 = j12;
                    final long j172 = j10;
                    Function2<? super Composer, ? super Integer, Unit> function2102 = function26;
                    boolean z92 = z6;
                    int i142 = (i7 & 14) | 12779520;
                    int i152 = i7 >> 9;
                    SurfaceKt.m900SurfaceT9BRK9s(modifier2, shape2, j9, j11, 0.0f, SnackbarTokens.INSTANCE.m1151getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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
                                ComposerKt.traceEventStart(-1829663446, i16, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:121)");
                            }
                            SnackbarTokens snackbarTokens = SnackbarTokens.INSTANCE;
                            TextStyle value = TypographyKt.getValue(snackbarTokens.getSupportingTextFont(), composer2, 6);
                            final TextStyle value2 = TypographyKt.getValue(snackbarTokens.getActionLabelTextFont(), composer2, 6);
                            ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(value);
                            final boolean z10 = z82;
                            final Function2<? super Composer, ? super Integer, Unit> function2112 = function282;
                            final Function2<? super Composer, ? super Integer, Unit> function212 = function23;
                            final Function2<? super Composer, ? super Integer, Unit> function213 = function292;
                            final long j182 = j162;
                            final long j192 = j172;
                            CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
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
                                        ComposerKt.traceEventStart(835891690, i17, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:124)");
                                    }
                                    if (z10 && function2112 != null) {
                                        composer3.startReplaceGroup(-810715387);
                                        SnackbarKt.m894NewLineButtonSnackbarkKq0p4A(function212, function2112, function213, value2, j182, j192, composer3, 0);
                                        composer3.endReplaceGroup();
                                    } else {
                                        composer3.startReplaceGroup(-810701708);
                                        SnackbarKt.m895OneRowSnackbarkKq0p4A(function212, function2112, function213, value2, j182, j192, composer3, 0);
                                        composer3.endReplaceGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, (i152 & 7168) | i142 | (i152 & 112) | (i152 & 896), 80);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function27 = function2102;
                    modifier3 = modifier2;
                    shape3 = shape2;
                    z7 = z92;
                    j13 = j11;
                    j14 = j10;
                    j15 = j12;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                if ((i5 & 24576) == 0) {
                }
                if ((196608 & i5) != 0) {
                }
                if ((i5 & 1572864) == 0) {
                }
                if ((i5 & 12582912) == 0) {
                }
                if ((100663296 & i5) != 0) {
                }
                if ((i6 & 512) == 0) {
                }
                if ((i7 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i12 != 0) {
                }
                if (i13 != 0) {
                }
                if (i8 == 0) {
                }
                if (i9 != 0) {
                }
                if ((i6 & 16) != 0) {
                }
                if ((i6 & 32) != 0) {
                }
                if ((i6 & 64) != 0) {
                }
                if ((i6 & 128) != 0) {
                }
                if ((i6 & 256) != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final boolean z822 = z6;
                final Function2<? super Composer, ? super Integer, Unit> function2822 = function24;
                final Function2<? super Composer, ? super Integer, Unit> function2922 = function26;
                final long j1622 = j12;
                final long j1722 = j10;
                Function2<? super Composer, ? super Integer, Unit> function21022 = function26;
                boolean z922 = z6;
                int i1422 = (i7 & 14) | 12779520;
                int i1522 = i7 >> 9;
                SurfaceKt.m900SurfaceT9BRK9s(modifier2, shape2, j9, j11, 0.0f, SnackbarTokens.INSTANCE.m1151getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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
                            ComposerKt.traceEventStart(-1829663446, i16, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:121)");
                        }
                        SnackbarTokens snackbarTokens = SnackbarTokens.INSTANCE;
                        TextStyle value = TypographyKt.getValue(snackbarTokens.getSupportingTextFont(), composer2, 6);
                        final TextStyle value2 = TypographyKt.getValue(snackbarTokens.getActionLabelTextFont(), composer2, 6);
                        ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(value);
                        final boolean z10 = z822;
                        final Function2<? super Composer, ? super Integer, Unit> function2112 = function2822;
                        final Function2<? super Composer, ? super Integer, Unit> function212 = function23;
                        final Function2<? super Composer, ? super Integer, Unit> function213 = function2922;
                        final long j182 = j1622;
                        final long j192 = j1722;
                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
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
                                    ComposerKt.traceEventStart(835891690, i17, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:124)");
                                }
                                if (z10 && function2112 != null) {
                                    composer3.startReplaceGroup(-810715387);
                                    SnackbarKt.m894NewLineButtonSnackbarkKq0p4A(function212, function2112, function213, value2, j182, j192, composer3, 0);
                                    composer3.endReplaceGroup();
                                } else {
                                    composer3.startReplaceGroup(-810701708);
                                    SnackbarKt.m895OneRowSnackbarkKq0p4A(function212, function2112, function213, value2, j182, j192, composer3, 0);
                                    composer3.endReplaceGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, (i1522 & 7168) | i1422 | (i1522 & 112) | (i1522 & 896), 80);
                if (ComposerKt.isTraceInProgress()) {
                }
                function27 = function21022;
                modifier3 = modifier2;
                shape3 = shape2;
                z7 = z922;
                j13 = j11;
                j14 = j10;
                j15 = j12;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function25 = function22;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            if ((i5 & 24576) == 0) {
            }
            if ((196608 & i5) != 0) {
            }
            if ((i5 & 1572864) == 0) {
            }
            if ((i5 & 12582912) == 0) {
            }
            if ((100663296 & i5) != 0) {
            }
            if ((i6 & 512) == 0) {
            }
            if ((i7 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            if (i8 == 0) {
            }
            if (i9 != 0) {
            }
            if ((i6 & 16) != 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if ((i6 & 64) != 0) {
            }
            if ((i6 & 128) != 0) {
            }
            if ((i6 & 256) != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final boolean z8222 = z6;
            final Function2<? super Composer, ? super Integer, Unit> function28222 = function24;
            final Function2<? super Composer, ? super Integer, Unit> function29222 = function26;
            final long j16222 = j12;
            final long j17222 = j10;
            Function2<? super Composer, ? super Integer, Unit> function210222 = function26;
            boolean z9222 = z6;
            int i14222 = (i7 & 14) | 12779520;
            int i15222 = i7 >> 9;
            SurfaceKt.m900SurfaceT9BRK9s(modifier2, shape2, j9, j11, 0.0f, SnackbarTokens.INSTANCE.m1151getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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
                        ComposerKt.traceEventStart(-1829663446, i16, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:121)");
                    }
                    SnackbarTokens snackbarTokens = SnackbarTokens.INSTANCE;
                    TextStyle value = TypographyKt.getValue(snackbarTokens.getSupportingTextFont(), composer2, 6);
                    final TextStyle value2 = TypographyKt.getValue(snackbarTokens.getActionLabelTextFont(), composer2, 6);
                    ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(value);
                    final boolean z10 = z8222;
                    final Function2<? super Composer, ? super Integer, Unit> function2112 = function28222;
                    final Function2<? super Composer, ? super Integer, Unit> function212 = function23;
                    final Function2<? super Composer, ? super Integer, Unit> function213 = function29222;
                    final long j182 = j16222;
                    final long j192 = j17222;
                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
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
                                ComposerKt.traceEventStart(835891690, i17, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:124)");
                            }
                            if (z10 && function2112 != null) {
                                composer3.startReplaceGroup(-810715387);
                                SnackbarKt.m894NewLineButtonSnackbarkKq0p4A(function212, function2112, function213, value2, j182, j192, composer3, 0);
                                composer3.endReplaceGroup();
                            } else {
                                composer3.startReplaceGroup(-810701708);
                                SnackbarKt.m895OneRowSnackbarkKq0p4A(function212, function2112, function213, value2, j182, j192, composer3, 0);
                                composer3.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i15222 & 7168) | i14222 | (i15222 & 112) | (i15222 & 896), 80);
            if (ComposerKt.isTraceInProgress()) {
            }
            function27 = function210222;
            modifier3 = modifier2;
            shape3 = shape2;
            z7 = z9222;
            j13 = j11;
            j14 = j10;
            j15 = j12;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function24 = function2;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        function25 = function22;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        if ((i5 & 24576) == 0) {
        }
        if ((196608 & i5) != 0) {
        }
        if ((i5 & 1572864) == 0) {
        }
        if ((i5 & 12582912) == 0) {
        }
        if ((100663296 & i5) != 0) {
        }
        if ((i6 & 512) == 0) {
        }
        if ((i7 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        if (i8 == 0) {
        }
        if (i9 != 0) {
        }
        if ((i6 & 16) != 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if ((i6 & 64) != 0) {
        }
        if ((i6 & 128) != 0) {
        }
        if ((i6 & 256) != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final boolean z82222 = z6;
        final Function2<? super Composer, ? super Integer, Unit> function282222 = function24;
        final Function2<? super Composer, ? super Integer, Unit> function292222 = function26;
        final long j162222 = j12;
        final long j172222 = j10;
        Function2<? super Composer, ? super Integer, Unit> function2102222 = function26;
        boolean z92222 = z6;
        int i142222 = (i7 & 14) | 12779520;
        int i152222 = i7 >> 9;
        SurfaceKt.m900SurfaceT9BRK9s(modifier2, shape2, j9, j11, 0.0f, SnackbarTokens.INSTANCE.m1151getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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
                    ComposerKt.traceEventStart(-1829663446, i16, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:121)");
                }
                SnackbarTokens snackbarTokens = SnackbarTokens.INSTANCE;
                TextStyle value = TypographyKt.getValue(snackbarTokens.getSupportingTextFont(), composer2, 6);
                final TextStyle value2 = TypographyKt.getValue(snackbarTokens.getActionLabelTextFont(), composer2, 6);
                ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(value);
                final boolean z10 = z82222;
                final Function2<? super Composer, ? super Integer, Unit> function2112 = function282222;
                final Function2<? super Composer, ? super Integer, Unit> function212 = function23;
                final Function2<? super Composer, ? super Integer, Unit> function213 = function292222;
                final long j182 = j162222;
                final long j192 = j172222;
                CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
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
                            ComposerKt.traceEventStart(835891690, i17, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:124)");
                        }
                        if (z10 && function2112 != null) {
                            composer3.startReplaceGroup(-810715387);
                            SnackbarKt.m894NewLineButtonSnackbarkKq0p4A(function212, function2112, function213, value2, j182, j192, composer3, 0);
                            composer3.endReplaceGroup();
                        } else {
                            composer3.startReplaceGroup(-810701708);
                            SnackbarKt.m895OneRowSnackbarkKq0p4A(function212, function2112, function213, value2, j182, j192, composer3, 0);
                            composer3.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, (i152222 & 7168) | i142222 | (i152222 & 112) | (i152222 & 896), 80);
        if (ComposerKt.isTraceInProgress()) {
        }
        function27 = function2102222;
        modifier3 = modifier2;
        shape3 = shape2;
        z7 = z92222;
        j13 = j11;
        j14 = j10;
        j15 = j12;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01fc  */
    /* renamed from: Snackbar-sDKtq54, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m897SnackbarsDKtq54(final SnackbarData snackbarData, Modifier modifier, boolean z5, Shape shape, long j5, long j6, long j7, long j8, long j9, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        boolean z6;
        Shape shape2;
        long j10;
        long j11;
        Modifier modifier3;
        boolean z7;
        Shape shape3;
        long j12;
        long j13;
        final long j14;
        long j15;
        long j16;
        long j17;
        final String actionLabel;
        final SnackbarData snackbarData2;
        long j18;
        ComposableLambda composableLambda;
        long j19;
        final boolean z8;
        final Shape shape4;
        ScopeUpdateScope endRestartGroup;
        int i9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(274621471);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(snackbarData) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i12 = i6 & 2;
        if (i12 != 0) {
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
                            i11 = 2048;
                            i7 |= i11;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i11 = 1024;
                    i7 |= i11;
                } else {
                    shape2 = shape;
                }
                if ((i5 & 24576) == 0) {
                    if ((i6 & 16) == 0) {
                        j10 = j5;
                        if (startRestartGroup.changed(j10)) {
                            i10 = 16384;
                            i7 |= i10;
                        }
                    } else {
                        j10 = j5;
                    }
                    i10 = 8192;
                    i7 |= i10;
                } else {
                    j10 = j5;
                }
                if ((196608 & i5) == 0) {
                    if ((i6 & 32) == 0) {
                        j11 = j6;
                        if (startRestartGroup.changed(j11)) {
                            i9 = 131072;
                            i7 |= i9;
                        }
                    } else {
                        j11 = j6;
                    }
                    i9 = 65536;
                    i7 |= i9;
                } else {
                    j11 = j6;
                }
                if ((1572864 & i5) == 0) {
                    i7 |= ((i6 & 64) == 0 && startRestartGroup.changed(j7)) ? 1048576 : 524288;
                }
                if ((i5 & 12582912) == 0) {
                    i7 |= ((i6 & 128) == 0 && startRestartGroup.changed(j8)) ? 8388608 : 4194304;
                }
                if ((100663296 & i5) == 0) {
                    i7 |= ((i6 & 256) == 0 && startRestartGroup.changed(j9)) ? 67108864 : 33554432;
                }
                if ((38347923 & i7) == 38347922 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        modifier3 = i12 != 0 ? Modifier.INSTANCE : modifier2;
                        z7 = i8 != 0 ? false : z6;
                        if ((i6 & 8) != 0) {
                            shape3 = SnackbarDefaults.INSTANCE.getShape(startRestartGroup, 6);
                            i7 &= -7169;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i6 & 16) != 0) {
                            j12 = SnackbarDefaults.INSTANCE.getColor(startRestartGroup, 6);
                            i7 &= -57345;
                        } else {
                            j12 = j10;
                        }
                        if ((i6 & 32) != 0) {
                            j13 = SnackbarDefaults.INSTANCE.getContentColor(startRestartGroup, 6);
                            i7 &= -458753;
                        } else {
                            j13 = j11;
                        }
                        if ((i6 & 64) != 0) {
                            j14 = SnackbarDefaults.INSTANCE.getActionColor(startRestartGroup, 6);
                            i7 &= -3670017;
                        } else {
                            j14 = j7;
                        }
                        if ((i6 & 128) != 0) {
                            j15 = SnackbarDefaults.INSTANCE.getActionContentColor(startRestartGroup, 6);
                            i7 &= -29360129;
                        } else {
                            j15 = j8;
                        }
                        if ((i6 & 256) != 0) {
                            i7 &= -234881025;
                            j17 = j15;
                            j16 = SnackbarDefaults.INSTANCE.getDismissActionContentColor(startRestartGroup, 6);
                        } else {
                            j16 = j9;
                            j17 = j15;
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
                        if ((i6 & 64) != 0) {
                            i7 &= -3670017;
                        }
                        if ((i6 & 128) != 0) {
                            i7 &= -29360129;
                        }
                        if ((i6 & 256) != 0) {
                            i7 &= -234881025;
                        }
                        j17 = j8;
                        j16 = j9;
                        modifier3 = modifier2;
                        z7 = z6;
                        shape3 = shape2;
                        j12 = j10;
                        j13 = j11;
                        j14 = j7;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(274621471, i7, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:211)");
                    }
                    actionLabel = snackbarData.getVisuals().getActionLabel();
                    startRestartGroup.startReplaceGroup(1561344786);
                    if (actionLabel != null) {
                        snackbarData2 = snackbarData;
                        j18 = j14;
                        composableLambda = ComposableLambdaKt.rememberComposableLambda(-1378313599, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i13) {
                                if ((i13 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1378313599, i13, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:216)");
                                }
                                ButtonColors m783textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m783textButtonColorsro_MJ88(0L, j14, 0L, 0L, composer2, 24576, 13);
                                boolean changed = composer2.changed(snackbarData2);
                                final SnackbarData snackbarData3 = snackbarData2;
                                Object rememberedValue = composer2.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$1$1
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
                                            SnackbarData.this.performAction();
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue);
                                }
                                Function0 function0 = (Function0) rememberedValue;
                                final String str = actionLabel;
                                ButtonKt.TextButton(function0, null, false, null, m783textButtonColorsro_MJ88, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(521110564, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                        invoke(rowScope, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(RowScope rowScope, Composer composer3, int i14) {
                                        if ((i14 & 17) == 16 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(521110564, i14, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:219)");
                                        }
                                        TextKt.m940Text4IGK_g(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 131070);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer2, 54), composer2, 805306368, 494);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54);
                    } else {
                        snackbarData2 = snackbarData;
                        j18 = j14;
                        composableLambda = null;
                    }
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(1561358724);
                    ComposableLambda rememberComposableLambda = snackbarData.getVisuals().getWithDismissAction() ? ComposableLambdaKt.rememberComposableLambda(-1812633777, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            if ((i13 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1812633777, i13, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:228)");
                            }
                            boolean changed = composer2.changed(SnackbarData.this);
                            final SnackbarData snackbarData3 = SnackbarData.this;
                            Object rememberedValue = composer2.rememberedValue();
                            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1$1$1
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
                                        SnackbarData.this.dismiss();
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue);
                            }
                            IconButtonKt.IconButton((Function0) rememberedValue, null, false, null, null, ComposableSingletons$SnackbarKt.INSTANCE.m840getLambda1$material3_release(), composer2, 196608, 30);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54) : null;
                    startRestartGroup.endReplaceGroup();
                    int i13 = i7 << 3;
                    m896SnackbareQBnUkQ(PaddingKt.m311padding3ABfNKs(modifier3, Dp.m2599constructorimpl(12)), composableLambda, rememberComposableLambda, z7, shape3, j12, j13, j17, j16, ComposableLambdaKt.rememberComposableLambda(-1266389126, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$3
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
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1266389126, i14, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:251)");
                            }
                            TextKt.m940Text4IGK_g(SnackbarData.this.getVisuals().getMessage(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131070);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, (i13 & 3670016) | (i13 & 7168) | 805306368 | (57344 & i13) | (458752 & i13) | (29360128 & i7) | (i7 & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j19 = j18;
                    z8 = z7;
                    shape4 = shape3;
                    modifier2 = modifier3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    j17 = j8;
                    j16 = j9;
                    z8 = z6;
                    shape4 = shape2;
                    j12 = j10;
                    j13 = j11;
                    j19 = j7;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier2;
                    final long j20 = j12;
                    final long j21 = j13;
                    final long j22 = j19;
                    final long j23 = j17;
                    final long j24 = j16;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$4
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            SnackbarKt.m897SnackbarsDKtq54(SnackbarData.this, modifier4, z8, shape4, j20, j21, j22, j23, j24, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
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
            if ((i5 & 12582912) == 0) {
            }
            if ((100663296 & i5) == 0) {
            }
            if ((38347923 & i7) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i12 != 0) {
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
            if ((i6 & 128) != 0) {
            }
            if ((i6 & 256) != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            actionLabel = snackbarData.getVisuals().getActionLabel();
            startRestartGroup.startReplaceGroup(1561344786);
            if (actionLabel != null) {
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1561358724);
            if (snackbarData.getVisuals().getWithDismissAction()) {
            }
            startRestartGroup.endReplaceGroup();
            int i132 = i7 << 3;
            m896SnackbareQBnUkQ(PaddingKt.m311padding3ABfNKs(modifier3, Dp.m2599constructorimpl(12)), composableLambda, rememberComposableLambda, z7, shape3, j12, j13, j17, j16, ComposableLambdaKt.rememberComposableLambda(-1266389126, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$3
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
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1266389126, i14, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:251)");
                    }
                    TextKt.m940Text4IGK_g(SnackbarData.this.getVisuals().getMessage(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i132 & 3670016) | (i132 & 7168) | 805306368 | (57344 & i132) | (458752 & i132) | (29360128 & i7) | (i7 & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            j19 = j18;
            z8 = z7;
            shape4 = shape3;
            modifier2 = modifier3;
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
        if ((i5 & 12582912) == 0) {
        }
        if ((100663296 & i5) == 0) {
        }
        if ((38347923 & i7) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i12 != 0) {
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
        if ((i6 & 128) != 0) {
        }
        if ((i6 & 256) != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        actionLabel = snackbarData.getVisuals().getActionLabel();
        startRestartGroup.startReplaceGroup(1561344786);
        if (actionLabel != null) {
        }
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(1561358724);
        if (snackbarData.getVisuals().getWithDismissAction()) {
        }
        startRestartGroup.endReplaceGroup();
        int i1322 = i7 << 3;
        m896SnackbareQBnUkQ(PaddingKt.m311padding3ABfNKs(modifier3, Dp.m2599constructorimpl(12)), composableLambda, rememberComposableLambda, z7, shape3, j12, j13, j17, j16, ComposableLambdaKt.rememberComposableLambda(-1266389126, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$3
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
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1266389126, i14, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:251)");
                }
                TextKt.m940Text4IGK_g(SnackbarData.this.getVisuals().getMessage(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131070);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, (i1322 & 3670016) | (i1322 & 7168) | 805306368 | (57344 & i1322) | (458752 & i1322) | (29360128 & i7) | (i7 & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        j19 = j18;
        z8 = z7;
        shape4 = shape3;
        modifier2 = modifier3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
