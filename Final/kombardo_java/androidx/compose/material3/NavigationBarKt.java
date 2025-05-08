package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\u001aX\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a}\u0010\u001c\u001a\u00020\u000b*\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00102\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00182\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a_\u0010\"\u001a\u00020\u000b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u0012H\u0003¢\u0006\u0004\b\"\u0010#\u001a8\u0010.\u001a\u00020+*\u00020$2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010%2\u0006\u0010*\u001a\u00020)H\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001aP\u00102\u001a\u00020+*\u00020$2\u0006\u0010/\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010%2\u0006\u0010*\u001a\u00020)2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 H\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101\"\u0014\u00104\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00105\"\u0014\u00106\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00105\"\u0014\u00107\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00105\"\u0014\u00108\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00105\"\u0014\u00109\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:\"\u0014\u0010<\u001a\u00020;8\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u0010=\"\u001a\u0010>\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b>\u0010:\u001a\u0004\b?\u0010@\"\u001a\u0010A\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\bA\u0010:\u001a\u0004\bB\u0010@\"\u0014\u0010C\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010:\"\u001a\u0010D\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\bD\u0010:\u001a\u0004\bE\u0010@\"\u0014\u0010F\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010:\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006J²\u0006\f\u0010G\u001a\u00020\u00028\nX\u008a\u0084\u0002²\u0006\f\u0010H\u001a\u00020\u00028\nX\u008a\u0084\u0002²\u0006\u000e\u0010I\u001a\u00020;8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/Color;", "containerColor", "contentColor", "Landroidx/compose/ui/unit/Dp;", "tonalElevation", "Landroidx/compose/foundation/layout/WindowInsets;", "windowInsets", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", BuildConfig.FLAVOR, "content", "NavigationBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationBar", BuildConfig.FLAVOR, "selected", "Lkotlin/Function0;", "onClick", NavigationBarKt.IconLayoutIdTag, "enabled", NavigationBarKt.LabelLayoutIdTag, "alwaysShowLabel", "Landroidx/compose/material3/NavigationBarItemColors;", "colors", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "NavigationBarItem", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationBarItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", NavigationBarKt.IndicatorRippleLayoutIdTag, NavigationBarKt.IndicatorLayoutIdTag, BuildConfig.FLAVOR, "animationProgress", "NavigationBarItemLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "indicatorRipplePlaceable", "indicatorPlaceable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", BuildConfig.FLAVOR, "IndicatorRippleLayoutIdTag", "Ljava/lang/String;", "IndicatorLayoutIdTag", "IconLayoutIdTag", "LabelLayoutIdTag", "NavigationBarHeight", "F", BuildConfig.FLAVOR, "ItemAnimationDurationMillis", "I", "NavigationBarItemHorizontalPadding", "getNavigationBarItemHorizontalPadding", "()F", "NavigationBarIndicatorToLabelPadding", "getNavigationBarIndicatorToLabelPadding", "IndicatorHorizontalPadding", "IndicatorVerticalPadding", "getIndicatorVerticalPadding", "IndicatorVerticalOffset", "iconColor", "textColor", "itemWidth", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class NavigationBarKt {
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalOffset;
    private static final float IndicatorVerticalPadding;
    private static final int ItemAnimationDurationMillis = 100;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationBarHeight;
    private static final float NavigationBarIndicatorToLabelPadding;
    private static final float NavigationBarItemHorizontalPadding;

    static {
        NavigationBarTokens navigationBarTokens = NavigationBarTokens.INSTANCE;
        NavigationBarHeight = navigationBarTokens.m1099getContainerHeightD9Ej5fM();
        NavigationBarItemHorizontalPadding = Dp.m2599constructorimpl(8);
        NavigationBarIndicatorToLabelPadding = Dp.m2599constructorimpl(4);
        float f5 = 2;
        IndicatorHorizontalPadding = Dp.m2599constructorimpl(Dp.m2599constructorimpl(navigationBarTokens.m1098getActiveIndicatorWidthD9Ej5fM() - navigationBarTokens.m1100getIconSizeD9Ej5fM()) / f5);
        IndicatorVerticalPadding = Dp.m2599constructorimpl(Dp.m2599constructorimpl(navigationBarTokens.m1097getActiveIndicatorHeightD9Ej5fM() - navigationBarTokens.m1100getIconSizeD9Ej5fM()) / f5);
        IndicatorVerticalOffset = Dp.m2599constructorimpl(12);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0093  */
    /* renamed from: NavigationBar-HsRjFd4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m873NavigationBarHsRjFd4(Modifier modifier, long j5, long j6, float f5, WindowInsets windowInsets, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        long j7;
        long j8;
        float f6;
        WindowInsets windowInsets2;
        Modifier modifier3;
        final WindowInsets windowInsets3;
        float f7;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(1596802123);
        int i10 = i6 & 1;
        if (i10 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            if ((i6 & 2) == 0) {
                j7 = j5;
                if (startRestartGroup.changed(j7)) {
                    i9 = 32;
                    i7 |= i9;
                }
            } else {
                j7 = j5;
            }
            i9 = 16;
            i7 |= i9;
        } else {
            j7 = j5;
        }
        if ((i5 & 384) == 0) {
            j8 = j6;
            i7 |= ((i6 & 4) == 0 && startRestartGroup.changed(j8)) ? 256 : 128;
        } else {
            j8 = j6;
        }
        int i11 = i6 & 8;
        if (i11 != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            f6 = f5;
            i7 |= startRestartGroup.changed(f6) ? 2048 : 1024;
            if ((i5 & 24576) != 0) {
                if ((i6 & 16) == 0) {
                    windowInsets2 = windowInsets;
                    if (startRestartGroup.changed(windowInsets2)) {
                        i8 = 16384;
                        i7 |= i8;
                    }
                } else {
                    windowInsets2 = windowInsets;
                }
                i8 = 8192;
                i7 |= i8;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((i6 & 32) == 0) {
                i7 |= 196608;
            } else if ((i5 & 196608) == 0) {
                i7 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
            }
            if ((74899 & i7) == 74898 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    modifier3 = i10 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i6 & 2) != 0) {
                        j7 = NavigationBarDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                        i7 &= -113;
                    }
                    if ((i6 & 4) != 0) {
                        j8 = ColorSchemeKt.m826contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6), j7);
                        i7 &= -897;
                    }
                    if (i11 != 0) {
                        f6 = NavigationBarDefaults.INSTANCE.m867getElevationD9Ej5fM();
                    }
                    if ((i6 & 16) != 0) {
                        i7 &= -57345;
                        windowInsets3 = NavigationBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                        f7 = f6;
                        long j9 = j8;
                        int i12 = i7;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1596802123, i12, -1, "androidx.compose.material3.NavigationBar (NavigationBar.kt:116)");
                        }
                        int i13 = (i12 & 14) | 12582912;
                        int i14 = i12 << 3;
                        int i15 = i13 | (i14 & 896) | (i14 & 7168) | (i14 & 57344);
                        WindowInsets windowInsets4 = windowInsets3;
                        SurfaceKt.m900SurfaceT9BRK9s(modifier3, null, j7, j9, f7, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(105663120, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBar$1
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
                                float f8;
                                if ((i16 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(105663120, i16, -1, "androidx.compose.material3.NavigationBar.<anonymous> (NavigationBar.kt:123)");
                                }
                                Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this);
                                f8 = NavigationBarKt.NavigationBarHeight;
                                Modifier selectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m324defaultMinSizeVpY3zN4$default(windowInsetsPadding, 0.0f, f8, 1, null));
                                Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = Arrangement.INSTANCE.m265spacedBy0680j_4(NavigationBarKt.getNavigationBarItemHorizontalPadding());
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m265spacedBy0680j_4, centerVertically, composer2, 54);
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, selectableGroup);
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
                                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                                function32.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                                composer2.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54), startRestartGroup, i15, 98);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = windowInsets4;
                        j8 = j9;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i6 & 2) != 0) {
                        i7 &= -113;
                    }
                    if ((i6 & 4) != 0) {
                        i7 &= -897;
                    }
                    if ((i6 & 16) != 0) {
                        i7 &= -57345;
                    }
                    modifier3 = modifier2;
                }
                f7 = f6;
                windowInsets3 = windowInsets2;
                long j92 = j8;
                int i122 = i7;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i132 = (i122 & 14) | 12582912;
                int i142 = i122 << 3;
                int i152 = i132 | (i142 & 896) | (i142 & 7168) | (i142 & 57344);
                WindowInsets windowInsets42 = windowInsets3;
                SurfaceKt.m900SurfaceT9BRK9s(modifier3, null, j7, j92, f7, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(105663120, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBar$1
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
                        float f8;
                        if ((i16 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(105663120, i16, -1, "androidx.compose.material3.NavigationBar.<anonymous> (NavigationBar.kt:123)");
                        }
                        Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this);
                        f8 = NavigationBarKt.NavigationBarHeight;
                        Modifier selectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m324defaultMinSizeVpY3zN4$default(windowInsetsPadding, 0.0f, f8, 1, null));
                        Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = Arrangement.INSTANCE.m265spacedBy0680j_4(NavigationBarKt.getNavigationBarItemHorizontalPadding());
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m265spacedBy0680j_4, centerVertically, composer2, 54);
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, selectableGroup);
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
                        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                        function32.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                        composer2.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, i152, 98);
                if (ComposerKt.isTraceInProgress()) {
                }
                windowInsets2 = windowInsets42;
                j8 = j92;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                f7 = f6;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier4 = modifier3;
                final long j10 = j7;
                final long j11 = j8;
                final float f8 = f7;
                final WindowInsets windowInsets5 = windowInsets2;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBar$2
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
                        NavigationBarKt.m873NavigationBarHsRjFd4(Modifier.this, j10, j11, f8, windowInsets5, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                    }
                });
                return;
            }
            return;
        }
        f6 = f5;
        if ((i5 & 24576) != 0) {
        }
        if ((i6 & 32) == 0) {
        }
        if ((74899 & i7) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i10 == 0) {
        }
        if ((i6 & 2) != 0) {
        }
        if ((i6 & 4) != 0) {
        }
        if (i11 != 0) {
        }
        if ((i6 & 16) != 0) {
        }
        f7 = f6;
        windowInsets3 = windowInsets2;
        long j922 = j8;
        int i1222 = i7;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i1322 = (i1222 & 14) | 12582912;
        int i1422 = i1222 << 3;
        int i1522 = i1322 | (i1422 & 896) | (i1422 & 7168) | (i1422 & 57344);
        WindowInsets windowInsets422 = windowInsets3;
        SurfaceKt.m900SurfaceT9BRK9s(modifier3, null, j7, j922, f7, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(105663120, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBar$1
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
                float f82;
                if ((i16 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(105663120, i16, -1, "androidx.compose.material3.NavigationBar.<anonymous> (NavigationBar.kt:123)");
                }
                Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this);
                f82 = NavigationBarKt.NavigationBarHeight;
                Modifier selectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m324defaultMinSizeVpY3zN4$default(windowInsetsPadding, 0.0f, f82, 1, null));
                Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = Arrangement.INSTANCE.m265spacedBy0680j_4(NavigationBarKt.getNavigationBarItemHorizontalPadding());
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m265spacedBy0680j_4, centerVertically, composer2, 54);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, selectableGroup);
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
                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                function32.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, i1522, 98);
        if (ComposerKt.isTraceInProgress()) {
        }
        windowInsets2 = windowInsets422;
        j8 = j922;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0382  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationBarItem(final RowScope rowScope, final boolean z5, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z6, Function2<? super Composer, ? super Integer, Unit> function22, boolean z7, NavigationBarItemColors navigationBarItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        Modifier modifier2;
        int i9;
        final boolean z8;
        int i10;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        int i11;
        boolean z9;
        int i12;
        Modifier modifier3;
        final NavigationBarItemColors navigationBarItemColors2;
        int i13;
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        MutableInteractionSource mutableInteractionSource4;
        Object rememberedValue;
        Composer.Companion companion;
        Object rememberedValue2;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        boolean changed;
        Object rememberedValue3;
        boolean changed2;
        Object rememberedValue4;
        NavigationBarItemColors navigationBarItemColors3;
        final boolean z10;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final boolean z11;
        ScopeUpdateScope endRestartGroup;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(-663510974);
        if ((Integer.MIN_VALUE & i6) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(rowScope) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 1) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i6 & 2) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
            if ((4 & i6) == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                i7 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
                i8 = i6 & 8;
                if (i8 != 0) {
                    i7 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    modifier2 = modifier;
                    i7 |= startRestartGroup.changed(modifier2) ? 16384 : 8192;
                    i9 = 16 & i6;
                    if (i9 == 0) {
                        i7 |= 196608;
                        z8 = z6;
                    } else {
                        z8 = z6;
                        if ((i5 & 196608) == 0) {
                            i7 |= startRestartGroup.changed(z8) ? 131072 : 65536;
                        }
                    }
                    i10 = 32 & i6;
                    if (i10 == 0) {
                        i7 |= 1572864;
                        function23 = function22;
                    } else {
                        function23 = function22;
                        if ((i5 & 1572864) == 0) {
                            i7 |= startRestartGroup.changedInstance(function23) ? 1048576 : 524288;
                        }
                    }
                    i11 = i6 & 64;
                    if (i11 == 0) {
                        i7 |= 12582912;
                        z9 = z7;
                    } else {
                        z9 = z7;
                        if ((i5 & 12582912) == 0) {
                            i7 |= startRestartGroup.changed(z9) ? 8388608 : 4194304;
                        }
                    }
                    if ((i5 & 100663296) == 0) {
                        if ((i6 & 128) == 0 && startRestartGroup.changed(navigationBarItemColors)) {
                            i14 = 67108864;
                            i7 |= i14;
                        }
                        i14 = 33554432;
                        i7 |= i14;
                    }
                    i12 = 256 & i6;
                    if (i12 == 0) {
                        i7 |= 805306368;
                    } else if ((i5 & 805306368) == 0) {
                        i7 |= startRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                    }
                    if ((i7 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            modifier3 = i8 == 0 ? Modifier.INSTANCE : modifier;
                            if (i9 != 0) {
                                z8 = true;
                            }
                            if (i10 != 0) {
                                function23 = null;
                            }
                            if (i11 != 0) {
                                z9 = true;
                            }
                            if ((128 & i6) == 0) {
                                navigationBarItemColors2 = NavigationBarItemDefaults.INSTANCE.colors(startRestartGroup, 6);
                                i7 &= -234881025;
                            } else {
                                navigationBarItemColors2 = navigationBarItemColors;
                            }
                            if (i12 != 0) {
                                i13 = i7;
                                mutableInteractionSource2 = null;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-663510974, i13, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:181)");
                                }
                                startRestartGroup.startReplaceGroup(-103235253);
                                if (mutableInteractionSource2 == null) {
                                    Object rememberedValue5 = startRestartGroup.rememberedValue();
                                    if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue5);
                                    }
                                    mutableInteractionSource3 = (MutableInteractionSource) rememberedValue5;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                startRestartGroup.endReplaceGroup();
                                final NavigationBarItemColors navigationBarItemColors4 = navigationBarItemColors2;
                                final boolean z12 = z8;
                                final Function2<? super Composer, ? super Integer, Unit> function25 = function23;
                                final boolean z13 = z9;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1419576100, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    private static final long invoke$lambda$0(State<Color> state) {
                                        return state.getValue().getValue();
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i15) {
                                        if ((i15 & 3) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1419576100, i15, -1, "androidx.compose.material3.NavigationBarItem.<anonymous> (NavigationBar.kt:186)");
                                        }
                                        State<Color> m54animateColorAsStateeuL9pac = SingleValueAnimationKt.m54animateColorAsStateeuL9pac(NavigationBarItemColors.this.m870iconColorWaAFU9c$material3_release(z5, z12), AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composer2, 48, 12);
                                        Modifier clearAndSetSemantics = (function25 == null || !(z13 || z5)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1.1
                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                invoke2(semanticsPropertyReceiver);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        Function2<Composer, Integer, Unit> function26 = function2;
                                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, clearAndSetSemantics);
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
                                        Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                                        Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                                        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash);
                                        }
                                        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier, companion2.getSetModifier());
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(invoke$lambda$0(m54animateColorAsStateeuL9pac))), function26, composer2, ProvidedValue.$stable);
                                        composer2.endNode();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, startRestartGroup, 54);
                                startRestartGroup.startReplaceGroup(-103209106);
                                ComposableLambda rememberComposableLambda2 = function23 == null ? null : ComposableLambdaKt.rememberComposableLambda(1644987592, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledLabel$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    private static final long invoke$lambda$0(State<Color> state) {
                                        return state.getValue().getValue();
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i15) {
                                        if ((i15 & 3) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1644987592, i15, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:201)");
                                        }
                                        ProvideContentColorTextStyleKt.m994ProvideContentColorTextStyle3JVO9M(invoke$lambda$0(SingleValueAnimationKt.m54animateColorAsStateeuL9pac(NavigationBarItemColors.this.m871textColorWaAFU9c$material3_release(z5, z8), AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composer2, 48, 12)), TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composer2, 6), function23, composer2, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, startRestartGroup, 54);
                                startRestartGroup.endReplaceGroup();
                                rememberedValue = startRestartGroup.rememberedValue();
                                companion = Composer.INSTANCE;
                                if (rememberedValue == companion.getEmpty()) {
                                    rememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                final MutableIntState mutableIntState = (MutableIntState) rememberedValue;
                                Modifier modifier5 = modifier3;
                                Function2<? super Composer, ? super Integer, Unit> function26 = function23;
                                boolean z14 = z8;
                                Modifier weight$default = RowScope.weight$default(rowScope, SizeKt.m324defaultMinSizeVpY3zN4$default(SelectableKt.m450selectableO2vRcR0(modifier3, z5, mutableInteractionSource3, null, z8, Role.m2163boximpl(Role.INSTANCE.m2176getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == companion.getEmpty()) {
                                    rememberedValue2 = new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                            m878invokeozmzZPI(intSize.getPackedValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                        public final void m878invokeozmzZPI(long j5) {
                                            MutableIntState.this.setIntValue(IntSize.m2661getWidthimpl(j5));
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(weight$default, (Function1) rememberedValue2);
                                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), true);
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, onSizeChanged);
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
                                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z5 ? 1.0f : 0.0f, AnimationSpecKt.tween$default(ItemAnimationDurationMillis, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
                                long Offset = OffsetKt.Offset((mutableIntState.getIntValue() - r8.mo206roundToPx0680j_4(NavigationBarTokens.INSTANCE.m1098getActiveIndicatorWidthD9Ej5fM())) / 2, ((Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo212toPx0680j_4(IndicatorVerticalOffset));
                                Unit unit = Unit.INSTANCE;
                                changed = startRestartGroup.changed(mutableInteractionSource3) | startRestartGroup.changed(Offset);
                                rememberedValue3 = startRestartGroup.rememberedValue();
                                if (!changed || rememberedValue3 == companion.getEmpty()) {
                                    rememberedValue3 = new MappedInteractionSource(mutableInteractionSource3, Offset, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                final MappedInteractionSource mappedInteractionSource = (MappedInteractionSource) rememberedValue3;
                                ComposableLambda rememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(691730997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$indicatorRipple$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i15) {
                                        if ((i15 & 3) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(691730997, i15, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:257)");
                                        }
                                        BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), MappedInteractionSource.this, RippleKt.m885rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7)), composer2, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, startRestartGroup, 54);
                                ComposableLambda rememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-474426875, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$indicator$1
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

                                    public final void invoke(Composer composer2, int i15) {
                                        if ((i15 & 3) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-474426875, i15, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:265)");
                                        }
                                        Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                                        boolean changed3 = composer2.changed(animateFloatAsState);
                                        final State<Float> state = animateFloatAsState;
                                        Object rememberedValue6 = composer2.rememberedValue();
                                        if (changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue6 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$indicator$1$1$1
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
                                                    graphicsLayerScope.setAlpha(state.getValue().floatValue());
                                                }
                                            };
                                            composer2.updateRememberedValue(rememberedValue6);
                                        }
                                        BoxKt.Box(BackgroundKt.m103backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue6), navigationBarItemColors2.getSelectedIndicatorColor(), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), composer2, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, startRestartGroup, 54);
                                changed2 = startRestartGroup.changed(animateFloatAsState);
                                rememberedValue4 = startRestartGroup.rememberedValue();
                                if (!changed2 || rememberedValue4 == companion.getEmpty()) {
                                    rememberedValue4 = new Function0<Float>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$2$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Float invoke() {
                                            return animateFloatAsState.getValue();
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                }
                                NavigationBarItemLayout(rememberComposableLambda3, rememberComposableLambda4, rememberComposableLambda, rememberComposableLambda2, z9, (Function0) rememberedValue4, startRestartGroup, ((i13 >> 9) & 57344) | 438);
                                startRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                navigationBarItemColors3 = navigationBarItemColors2;
                                z10 = z9;
                                modifier4 = modifier5;
                                function24 = function26;
                                z11 = z14;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((128 & i6) != 0) {
                                i7 &= -234881025;
                            }
                            modifier3 = modifier;
                            navigationBarItemColors2 = navigationBarItemColors;
                        }
                        mutableInteractionSource2 = mutableInteractionSource;
                        i13 = i7;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceGroup(-103235253);
                        if (mutableInteractionSource2 == null) {
                        }
                        startRestartGroup.endReplaceGroup();
                        final NavigationBarItemColors navigationBarItemColors42 = navigationBarItemColors2;
                        final boolean z122 = z8;
                        final Function2<? super Composer, ? super Integer, Unit> function252 = function23;
                        final boolean z132 = z9;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        ComposableLambda rememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(-1419576100, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            private static final long invoke$lambda$0(State<Color> state) {
                                return state.getValue().getValue();
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                if ((i15 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1419576100, i15, -1, "androidx.compose.material3.NavigationBarItem.<anonymous> (NavigationBar.kt:186)");
                                }
                                State<Color> m54animateColorAsStateeuL9pac = SingleValueAnimationKt.m54animateColorAsStateeuL9pac(NavigationBarItemColors.this.m870iconColorWaAFU9c$material3_release(z5, z122), AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composer2, 48, 12);
                                Modifier clearAndSetSemantics = (function252 == null || !(z132 || z5)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1.1
                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }
                                });
                                Function2<Composer, Integer, Unit> function262 = function2;
                                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, clearAndSetSemantics);
                                ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
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
                                Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy2, companion22.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion22.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion22.getSetCompositeKeyHash();
                                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion22.getSetModifier());
                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(invoke$lambda$0(m54animateColorAsStateeuL9pac))), function262, composer2, ProvidedValue.$stable);
                                composer2.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54);
                        startRestartGroup.startReplaceGroup(-103209106);
                        if (function23 == null) {
                        }
                        startRestartGroup.endReplaceGroup();
                        rememberedValue = startRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (rememberedValue == companion.getEmpty()) {
                        }
                        final MutableIntState mutableIntState2 = (MutableIntState) rememberedValue;
                        Modifier modifier52 = modifier3;
                        Function2<? super Composer, ? super Integer, Unit> function262 = function23;
                        boolean z142 = z8;
                        Modifier weight$default2 = RowScope.weight$default(rowScope, SizeKt.m324defaultMinSizeVpY3zN4$default(SelectableKt.m450selectableO2vRcR0(modifier3, z5, mutableInteractionSource3, null, z8, Role.m2163boximpl(Role.INSTANCE.m2176getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == companion.getEmpty()) {
                        }
                        Modifier onSizeChanged2 = OnRemeasuredModifierKt.onSizeChanged(weight$default2, (Function1) rememberedValue2);
                        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), true);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, onSizeChanged2);
                        ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
                        if (startRestartGroup.getApplier() == null) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2, companion22.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion22.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion22.getSetCompositeKeyHash();
                        if (!m1226constructorimpl.getInserting()) {
                        }
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion22.getSetModifier());
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        final State<Float> animateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(z5 ? 1.0f : 0.0f, AnimationSpecKt.tween$default(ItemAnimationDurationMillis, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
                        long Offset2 = OffsetKt.Offset((mutableIntState2.getIntValue() - r8.mo206roundToPx0680j_4(NavigationBarTokens.INSTANCE.m1098getActiveIndicatorWidthD9Ej5fM())) / 2, ((Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo212toPx0680j_4(IndicatorVerticalOffset));
                        Unit unit2 = Unit.INSTANCE;
                        changed = startRestartGroup.changed(mutableInteractionSource3) | startRestartGroup.changed(Offset2);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue3 = new MappedInteractionSource(mutableInteractionSource3, Offset2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                        final MappedInteractionSource mappedInteractionSource2 = (MappedInteractionSource) rememberedValue3;
                        ComposableLambda rememberComposableLambda32 = ComposableLambdaKt.rememberComposableLambda(691730997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$indicatorRipple$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                if ((i15 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(691730997, i15, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:257)");
                                }
                                BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), MappedInteractionSource.this, RippleKt.m885rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7)), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54);
                        ComposableLambda rememberComposableLambda42 = ComposableLambdaKt.rememberComposableLambda(-474426875, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$indicator$1
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

                            public final void invoke(Composer composer2, int i15) {
                                if ((i15 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-474426875, i15, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:265)");
                                }
                                Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                                boolean changed3 = composer2.changed(animateFloatAsState2);
                                final State<Float> state = animateFloatAsState2;
                                Object rememberedValue6 = composer2.rememberedValue();
                                if (changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue6 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$indicator$1$1$1
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
                                            graphicsLayerScope.setAlpha(state.getValue().floatValue());
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue6);
                                }
                                BoxKt.Box(BackgroundKt.m103backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue6), navigationBarItemColors2.getSelectedIndicatorColor(), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54);
                        changed2 = startRestartGroup.changed(animateFloatAsState2);
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (!changed2) {
                        }
                        rememberedValue4 = new Function0<Float>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Float invoke() {
                                return animateFloatAsState2.getValue();
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                        NavigationBarItemLayout(rememberComposableLambda32, rememberComposableLambda42, rememberComposableLambda5, rememberComposableLambda2, z9, (Function0) rememberedValue4, startRestartGroup, ((i13 >> 9) & 57344) | 438);
                        startRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        navigationBarItemColors3 = navigationBarItemColors2;
                        z10 = z9;
                        modifier4 = modifier52;
                        function24 = function262;
                        z11 = z142;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        navigationBarItemColors3 = navigationBarItemColors;
                        mutableInteractionSource4 = mutableInteractionSource;
                        function24 = function23;
                        z11 = z8;
                        z10 = z9;
                        modifier4 = modifier2;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final NavigationBarItemColors navigationBarItemColors5 = navigationBarItemColors3;
                        final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3
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

                            public final void invoke(Composer composer2, int i15) {
                                NavigationBarKt.NavigationBarItem(RowScope.this, z5, function0, function2, modifier4, z11, function24, z10, navigationBarItemColors5, mutableInteractionSource5, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                            }
                        });
                        return;
                    }
                    return;
                }
                modifier2 = modifier;
                i9 = 16 & i6;
                if (i9 == 0) {
                }
                i10 = 32 & i6;
                if (i10 == 0) {
                }
                i11 = i6 & 64;
                if (i11 == 0) {
                }
                if ((i5 & 100663296) == 0) {
                }
                i12 = 256 & i6;
                if (i12 == 0) {
                }
                if ((i7 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i8 == 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if ((128 & i6) == 0) {
                }
                if (i12 != 0) {
                }
                mutableInteractionSource2 = mutableInteractionSource;
                i13 = i7;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceGroup(-103235253);
                if (mutableInteractionSource2 == null) {
                }
                startRestartGroup.endReplaceGroup();
                final NavigationBarItemColors navigationBarItemColors422 = navigationBarItemColors2;
                final boolean z1222 = z8;
                final Function2<? super Composer, ? super Integer, Unit> function2522 = function23;
                final boolean z1322 = z9;
                mutableInteractionSource4 = mutableInteractionSource2;
                ComposableLambda rememberComposableLambda52 = ComposableLambdaKt.rememberComposableLambda(-1419576100, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    private static final long invoke$lambda$0(State<Color> state) {
                        return state.getValue().getValue();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        if ((i15 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1419576100, i15, -1, "androidx.compose.material3.NavigationBarItem.<anonymous> (NavigationBar.kt:186)");
                        }
                        State<Color> m54animateColorAsStateeuL9pac = SingleValueAnimationKt.m54animateColorAsStateeuL9pac(NavigationBarItemColors.this.m870iconColorWaAFU9c$material3_release(z5, z1222), AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composer2, 48, 12);
                        Modifier clearAndSetSemantics = (function2522 == null || !(z1322 || z5)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1.1
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        Function2<Composer, Integer, Unit> function2622 = function2;
                        MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap22 = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(composer2, clearAndSetSemantics);
                        ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor22 = companion222.getConstructor();
                        if (composer2.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor22);
                        } else {
                            composer2.useNode();
                        }
                        Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                        Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy22, companion222.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion222.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion222.getSetCompositeKeyHash();
                        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
                        }
                        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion222.getSetModifier());
                        BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(invoke$lambda$0(m54animateColorAsStateeuL9pac))), function2622, composer2, ProvidedValue.$stable);
                        composer2.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54);
                startRestartGroup.startReplaceGroup(-103209106);
                if (function23 == null) {
                }
                startRestartGroup.endReplaceGroup();
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                }
                final MutableIntState mutableIntState22 = (MutableIntState) rememberedValue;
                Modifier modifier522 = modifier3;
                Function2<? super Composer, ? super Integer, Unit> function2622 = function23;
                boolean z1422 = z8;
                Modifier weight$default22 = RowScope.weight$default(rowScope, SizeKt.m324defaultMinSizeVpY3zN4$default(SelectableKt.m450selectableO2vRcR0(modifier3, z5, mutableInteractionSource3, null, z8, Role.m2163boximpl(Role.INSTANCE.m2176getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                }
                Modifier onSizeChanged22 = OnRemeasuredModifierKt.onSizeChanged(weight$default22, (Function1) rememberedValue2);
                MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), true);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, onSizeChanged22);
                ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor22 = companion222.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy22, companion222.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion222.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion222.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion222.getSetModifier());
                BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                final State<Float> animateFloatAsState22 = AnimateAsStateKt.animateFloatAsState(z5 ? 1.0f : 0.0f, AnimationSpecKt.tween$default(ItemAnimationDurationMillis, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
                long Offset22 = OffsetKt.Offset((mutableIntState22.getIntValue() - r8.mo206roundToPx0680j_4(NavigationBarTokens.INSTANCE.m1098getActiveIndicatorWidthD9Ej5fM())) / 2, ((Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo212toPx0680j_4(IndicatorVerticalOffset));
                Unit unit22 = Unit.INSTANCE;
                changed = startRestartGroup.changed(mutableInteractionSource3) | startRestartGroup.changed(Offset22);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue3 = new MappedInteractionSource(mutableInteractionSource3, Offset22, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
                final MappedInteractionSource mappedInteractionSource22 = (MappedInteractionSource) rememberedValue3;
                ComposableLambda rememberComposableLambda322 = ComposableLambdaKt.rememberComposableLambda(691730997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$indicatorRipple$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        if ((i15 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(691730997, i15, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:257)");
                        }
                        BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), MappedInteractionSource.this, RippleKt.m885rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7)), composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54);
                ComposableLambda rememberComposableLambda422 = ComposableLambdaKt.rememberComposableLambda(-474426875, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$indicator$1
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

                    public final void invoke(Composer composer2, int i15) {
                        if ((i15 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-474426875, i15, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:265)");
                        }
                        Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                        boolean changed3 = composer2.changed(animateFloatAsState22);
                        final State<Float> state = animateFloatAsState22;
                        Object rememberedValue6 = composer2.rememberedValue();
                        if (changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue6 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$indicator$1$1$1
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
                                    graphicsLayerScope.setAlpha(state.getValue().floatValue());
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue6);
                        }
                        BoxKt.Box(BackgroundKt.m103backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue6), navigationBarItemColors2.getSelectedIndicatorColor(), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54);
                changed2 = startRestartGroup.changed(animateFloatAsState22);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changed2) {
                }
                rememberedValue4 = new Function0<Float>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return animateFloatAsState22.getValue();
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
                NavigationBarItemLayout(rememberComposableLambda322, rememberComposableLambda422, rememberComposableLambda52, rememberComposableLambda2, z9, (Function0) rememberedValue4, startRestartGroup, ((i13 >> 9) & 57344) | 438);
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                navigationBarItemColors3 = navigationBarItemColors2;
                z10 = z9;
                modifier4 = modifier522;
                function24 = function2622;
                z11 = z1422;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i8 = i6 & 8;
            if (i8 != 0) {
            }
            modifier2 = modifier;
            i9 = 16 & i6;
            if (i9 == 0) {
            }
            i10 = 32 & i6;
            if (i10 == 0) {
            }
            i11 = i6 & 64;
            if (i11 == 0) {
            }
            if ((i5 & 100663296) == 0) {
            }
            i12 = 256 & i6;
            if (i12 == 0) {
            }
            if ((i7 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i8 == 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if ((128 & i6) == 0) {
            }
            if (i12 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            i13 = i7;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(-103235253);
            if (mutableInteractionSource2 == null) {
            }
            startRestartGroup.endReplaceGroup();
            final NavigationBarItemColors navigationBarItemColors4222 = navigationBarItemColors2;
            final boolean z12222 = z8;
            final Function2<? super Composer, ? super Integer, Unit> function25222 = function23;
            final boolean z13222 = z9;
            mutableInteractionSource4 = mutableInteractionSource2;
            ComposableLambda rememberComposableLambda522 = ComposableLambdaKt.rememberComposableLambda(-1419576100, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                private static final long invoke$lambda$0(State<Color> state) {
                    return state.getValue().getValue();
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i15) {
                    if ((i15 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1419576100, i15, -1, "androidx.compose.material3.NavigationBarItem.<anonymous> (NavigationBar.kt:186)");
                    }
                    State<Color> m54animateColorAsStateeuL9pac = SingleValueAnimationKt.m54animateColorAsStateeuL9pac(NavigationBarItemColors.this.m870iconColorWaAFU9c$material3_release(z5, z12222), AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composer2, 48, 12);
                    Modifier clearAndSetSemantics = (function25222 == null || !(z13222 || z5)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    Function2<Composer, Integer, Unit> function26222 = function2;
                    MeasurePolicy maybeCachedBoxMeasurePolicy222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap222 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(composer2, clearAndSetSemantics);
                    ComposeUiNode.Companion companion2222 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor222 = companion2222.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor222);
                    } else {
                        composer2.useNode();
                    }
                    Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                    Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy222, companion2222.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap222, companion2222.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion2222.getSetCompositeKeyHash();
                    if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222);
                    }
                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier222, companion2222.getSetModifier());
                    BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(invoke$lambda$0(m54animateColorAsStateeuL9pac))), function26222, composer2, ProvidedValue.$stable);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            startRestartGroup.startReplaceGroup(-103209106);
            if (function23 == null) {
            }
            startRestartGroup.endReplaceGroup();
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
            }
            final MutableIntState mutableIntState222 = (MutableIntState) rememberedValue;
            Modifier modifier5222 = modifier3;
            Function2<? super Composer, ? super Integer, Unit> function26222 = function23;
            boolean z14222 = z8;
            Modifier weight$default222 = RowScope.weight$default(rowScope, SizeKt.m324defaultMinSizeVpY3zN4$default(SelectableKt.m450selectableO2vRcR0(modifier3, z5, mutableInteractionSource3, null, z8, Role.m2163boximpl(Role.INSTANCE.m2176getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
            }
            Modifier onSizeChanged222 = OnRemeasuredModifierKt.onSizeChanged(weight$default222, (Function1) rememberedValue2);
            MeasurePolicy maybeCachedBoxMeasurePolicy222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), true);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, onSizeChanged222);
            ComposeUiNode.Companion companion2222 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor222 = companion2222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy222, companion2222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap222, companion2222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion2222.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier222, companion2222.getSetModifier());
            BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
            final State<Float> animateFloatAsState222 = AnimateAsStateKt.animateFloatAsState(z5 ? 1.0f : 0.0f, AnimationSpecKt.tween$default(ItemAnimationDurationMillis, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
            long Offset222 = OffsetKt.Offset((mutableIntState222.getIntValue() - r8.mo206roundToPx0680j_4(NavigationBarTokens.INSTANCE.m1098getActiveIndicatorWidthD9Ej5fM())) / 2, ((Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo212toPx0680j_4(IndicatorVerticalOffset));
            Unit unit222 = Unit.INSTANCE;
            changed = startRestartGroup.changed(mutableInteractionSource3) | startRestartGroup.changed(Offset222);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue3 = new MappedInteractionSource(mutableInteractionSource3, Offset222, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
            final MappedInteractionSource mappedInteractionSource222 = (MappedInteractionSource) rememberedValue3;
            ComposableLambda rememberComposableLambda3222 = ComposableLambdaKt.rememberComposableLambda(691730997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$indicatorRipple$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i15) {
                    if ((i15 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(691730997, i15, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:257)");
                    }
                    BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), MappedInteractionSource.this, RippleKt.m885rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7)), composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            ComposableLambda rememberComposableLambda4222 = ComposableLambdaKt.rememberComposableLambda(-474426875, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$indicator$1
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

                public final void invoke(Composer composer2, int i15) {
                    if ((i15 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-474426875, i15, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:265)");
                    }
                    Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                    boolean changed3 = composer2.changed(animateFloatAsState222);
                    final State<Float> state = animateFloatAsState222;
                    Object rememberedValue6 = composer2.rememberedValue();
                    if (changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue6 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$indicator$1$1$1
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
                                graphicsLayerScope.setAlpha(state.getValue().floatValue());
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue6);
                    }
                    BoxKt.Box(BackgroundKt.m103backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue6), navigationBarItemColors2.getSelectedIndicatorColor(), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            changed2 = startRestartGroup.changed(animateFloatAsState222);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            rememberedValue4 = new Function0<Float>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return animateFloatAsState222.getValue();
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue4);
            NavigationBarItemLayout(rememberComposableLambda3222, rememberComposableLambda4222, rememberComposableLambda522, rememberComposableLambda2, z9, (Function0) rememberedValue4, startRestartGroup, ((i13 >> 9) & 57344) | 438);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            navigationBarItemColors3 = navigationBarItemColors2;
            z10 = z9;
            modifier4 = modifier5222;
            function24 = function26222;
            z11 = z14222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((4 & i6) == 0) {
        }
        i8 = i6 & 8;
        if (i8 != 0) {
        }
        modifier2 = modifier;
        i9 = 16 & i6;
        if (i9 == 0) {
        }
        i10 = 32 & i6;
        if (i10 == 0) {
        }
        i11 = i6 & 64;
        if (i11 == 0) {
        }
        if ((i5 & 100663296) == 0) {
        }
        i12 = 256 & i6;
        if (i12 == 0) {
        }
        if ((i7 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i8 == 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if ((128 & i6) == 0) {
        }
        if (i12 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        i13 = i7;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(-103235253);
        if (mutableInteractionSource2 == null) {
        }
        startRestartGroup.endReplaceGroup();
        final NavigationBarItemColors navigationBarItemColors42222 = navigationBarItemColors2;
        final boolean z122222 = z8;
        final Function2<? super Composer, ? super Integer, Unit> function252222 = function23;
        final boolean z132222 = z9;
        mutableInteractionSource4 = mutableInteractionSource2;
        ComposableLambda rememberComposableLambda5222 = ComposableLambdaKt.rememberComposableLambda(-1419576100, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            private static final long invoke$lambda$0(State<Color> state) {
                return state.getValue().getValue();
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i15) {
                if ((i15 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1419576100, i15, -1, "androidx.compose.material3.NavigationBarItem.<anonymous> (NavigationBar.kt:186)");
                }
                State<Color> m54animateColorAsStateeuL9pac = SingleValueAnimationKt.m54animateColorAsStateeuL9pac(NavigationBarItemColors.this.m870iconColorWaAFU9c$material3_release(z5, z122222), AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, composer2, 48, 12);
                Modifier clearAndSetSemantics = (function252222 == null || !(z132222 || z5)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1.1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }
                });
                Function2<Composer, Integer, Unit> function262222 = function2;
                MeasurePolicy maybeCachedBoxMeasurePolicy2222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2222 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(composer2, clearAndSetSemantics);
                ComposeUiNode.Companion companion22222 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2222 = companion22222.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2222);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy2222, companion22222.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2222, companion22222.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = companion22222.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2222);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2222, companion22222.getSetModifier());
                BoxScopeInstance boxScopeInstance2222 = BoxScopeInstance.INSTANCE;
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(invoke$lambda$0(m54animateColorAsStateeuL9pac))), function262222, composer2, ProvidedValue.$stable);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54);
        startRestartGroup.startReplaceGroup(-103209106);
        if (function23 == null) {
        }
        startRestartGroup.endReplaceGroup();
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        final MutableIntState mutableIntState2222 = (MutableIntState) rememberedValue;
        Modifier modifier52222 = modifier3;
        Function2<? super Composer, ? super Integer, Unit> function262222 = function23;
        boolean z142222 = z8;
        Modifier weight$default2222 = RowScope.weight$default(rowScope, SizeKt.m324defaultMinSizeVpY3zN4$default(SelectableKt.m450selectableO2vRcR0(modifier3, z5, mutableInteractionSource3, null, z8, Role.m2163boximpl(Role.INSTANCE.m2176getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        Modifier onSizeChanged2222 = OnRemeasuredModifierKt.onSizeChanged(weight$default2222, (Function1) rememberedValue2);
        MeasurePolicy maybeCachedBoxMeasurePolicy2222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), true);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, onSizeChanged2222);
        ComposeUiNode.Companion companion22222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2222 = companion22222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2222, companion22222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2222, companion22222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = companion22222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2222, companion22222.getSetModifier());
        BoxScopeInstance boxScopeInstance2222 = BoxScopeInstance.INSTANCE;
        final State<Float> animateFloatAsState2222 = AnimateAsStateKt.animateFloatAsState(z5 ? 1.0f : 0.0f, AnimationSpecKt.tween$default(ItemAnimationDurationMillis, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
        long Offset2222 = OffsetKt.Offset((mutableIntState2222.getIntValue() - r8.mo206roundToPx0680j_4(NavigationBarTokens.INSTANCE.m1098getActiveIndicatorWidthD9Ej5fM())) / 2, ((Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo212toPx0680j_4(IndicatorVerticalOffset));
        Unit unit2222 = Unit.INSTANCE;
        changed = startRestartGroup.changed(mutableInteractionSource3) | startRestartGroup.changed(Offset2222);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue3 = new MappedInteractionSource(mutableInteractionSource3, Offset2222, null);
        startRestartGroup.updateRememberedValue(rememberedValue3);
        final MappedInteractionSource mappedInteractionSource2222 = (MappedInteractionSource) rememberedValue3;
        ComposableLambda rememberComposableLambda32222 = ComposableLambdaKt.rememberComposableLambda(691730997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$indicatorRipple$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i15) {
                if ((i15 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(691730997, i15, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:257)");
                }
                BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), MappedInteractionSource.this, RippleKt.m885rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7)), composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54);
        ComposableLambda rememberComposableLambda42222 = ComposableLambdaKt.rememberComposableLambda(-474426875, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$indicator$1
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

            public final void invoke(Composer composer2, int i15) {
                if ((i15 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-474426875, i15, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:265)");
                }
                Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                boolean changed3 = composer2.changed(animateFloatAsState2222);
                final State<Float> state = animateFloatAsState2222;
                Object rememberedValue6 = composer2.rememberedValue();
                if (changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue6 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$indicator$1$1$1
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
                            graphicsLayerScope.setAlpha(state.getValue().floatValue());
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue6);
                }
                BoxKt.Box(BackgroundKt.m103backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue6), navigationBarItemColors2.getSelectedIndicatorColor(), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54);
        changed2 = startRestartGroup.changed(animateFloatAsState2222);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue4 = new Function0<Float>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return animateFloatAsState2222.getValue();
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        NavigationBarItemLayout(rememberComposableLambda32222, rememberComposableLambda42222, rememberComposableLambda5222, rememberComposableLambda2, z9, (Function0) rememberedValue4, startRestartGroup, ((i13 >> 9) & 57344) | 438);
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        navigationBarItemColors3 = navigationBarItemColors2;
        z10 = z9;
        modifier4 = modifier52222;
        function24 = function262222;
        z11 = z142222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NavigationBarItemLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final boolean z5, final Function0<Float> function0, Composer composer, final int i5) {
        int i6;
        int i7;
        boolean z6;
        Composer startRestartGroup = composer.startRestartGroup(-1427075886);
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
            i6 |= startRestartGroup.changedInstance(function24) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1427075886, i6, -1, "androidx.compose.material3.NavigationBarItemLayout (NavigationBar.kt:516)");
            }
            int i8 = 458752 & i6;
            int i9 = 57344 & i6;
            boolean z7 = (i8 == 131072) | ((i6 & 7168) == 2048) | (i9 == 16384);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItemLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                        float f5;
                        Measurable measurable;
                        Placeable placeable;
                        MeasureResult m877placeLabelAndIconzUg2_y0;
                        MeasureResult m876placeIconX9ElhV4;
                        float floatValue = function0.invoke().floatValue();
                        long m2570copyZbe2FdA$default = Constraints.m2570copyZbe2FdA$default(j5, 0, 0, 0, 0, 10, null);
                        int size = list.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            Measurable measurable2 = list.get(i10);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "icon")) {
                                Placeable mo1946measureBRTryo0 = measurable2.mo1946measureBRTryo0(m2570copyZbe2FdA$default);
                                int width = mo1946measureBRTryo0.getWidth();
                                f5 = NavigationBarKt.IndicatorHorizontalPadding;
                                float f6 = 2;
                                int mo206roundToPx0680j_4 = width + measureScope.mo206roundToPx0680j_4(Dp.m2599constructorimpl(f5 * f6));
                                int roundToInt = MathKt.roundToInt(mo206roundToPx0680j_4 * floatValue);
                                int height = mo1946measureBRTryo0.getHeight() + measureScope.mo206roundToPx0680j_4(Dp.m2599constructorimpl(NavigationBarKt.getIndicatorVerticalPadding() * f6));
                                int size2 = list.size();
                                for (int i11 = 0; i11 < size2; i11++) {
                                    Measurable measurable3 = list.get(i11);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "indicatorRipple")) {
                                        Placeable mo1946measureBRTryo02 = measurable3.mo1946measureBRTryo0(Constraints.INSTANCE.m2587fixedJhjzzOo(mo206roundToPx0680j_4, height));
                                        int size3 = list.size();
                                        int i12 = 0;
                                        while (true) {
                                            if (i12 >= size3) {
                                                measurable = null;
                                                break;
                                            }
                                            measurable = list.get(i12);
                                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "indicator")) {
                                                break;
                                            }
                                            i12++;
                                        }
                                        Measurable measurable4 = measurable;
                                        Placeable mo1946measureBRTryo03 = measurable4 != null ? measurable4.mo1946measureBRTryo0(Constraints.INSTANCE.m2587fixedJhjzzOo(roundToInt, height)) : null;
                                        if (function24 != null) {
                                            int size4 = list.size();
                                            for (int i13 = 0; i13 < size4; i13++) {
                                                Measurable measurable5 = list.get(i13);
                                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable5), "label")) {
                                                    placeable = measurable5.mo1946measureBRTryo0(m2570copyZbe2FdA$default);
                                                }
                                            }
                                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                        }
                                        placeable = null;
                                        if (function24 == null) {
                                            m876placeIconX9ElhV4 = NavigationBarKt.m876placeIconX9ElhV4(measureScope, mo1946measureBRTryo0, mo1946measureBRTryo02, mo1946measureBRTryo03, j5);
                                            return m876placeIconX9ElhV4;
                                        }
                                        Intrinsics.checkNotNull(placeable);
                                        m877placeLabelAndIconzUg2_y0 = NavigationBarKt.m877placeLabelAndIconzUg2_y0(measureScope, placeable, mo1946measureBRTryo0, mo1946measureBRTryo02, mo1946measureBRTryo03, j5, z5, floatValue);
                                        return m877placeLabelAndIconzUg2_y0;
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
            Updater.m1227setimpl(m1226constructorimpl, measurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            function2.invoke(startRestartGroup, Integer.valueOf(i6 & 14));
            function22.invoke(startRestartGroup, Integer.valueOf((i6 >> 3) & 14));
            Modifier layoutId = LayoutIdKt.layoutId(companion, IconLayoutIdTag);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId);
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
            function23.invoke(startRestartGroup, Integer.valueOf((i6 >> 6) & 14));
            startRestartGroup.endNode();
            startRestartGroup.startReplaceGroup(1087198243);
            if (function24 != null) {
                Modifier layoutId2 = LayoutIdKt.layoutId(companion, LabelLayoutIdTag);
                if (i9 == 16384) {
                    i7 = 131072;
                    z6 = true;
                } else {
                    i7 = 131072;
                    z6 = false;
                }
                boolean z8 = z6 | (i8 == i7);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z8 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItemLayout$1$2$1
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
                            graphicsLayerScope.setAlpha(z5 ? 1.0f : function0.invoke().floatValue());
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(GraphicsLayerModifierKt.graphicsLayer(layoutId2, (Function1) rememberedValue2), Dp.m2599constructorimpl(NavigationBarItemHorizontalPadding / 2), 0.0f, 2, null);
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
                function24.invoke(startRestartGroup, Integer.valueOf((i6 >> 9) & 14));
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItemLayout$3
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
                    NavigationBarKt.NavigationBarItemLayout(function2, function22, function23, function24, z5, function0, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    public static final float getIndicatorVerticalPadding() {
        return IndicatorVerticalPadding;
    }

    public static final float getNavigationBarItemHorizontalPadding() {
        return NavigationBarItemHorizontalPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m876placeIconX9ElhV4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, long j5) {
        final int m2578getMaxWidthimpl = Constraints.m2578getMaxWidthimpl(j5);
        final int m2592constrainHeightK40F9xA = ConstraintsKt.m2592constrainHeightK40F9xA(j5, measureScope.mo206roundToPx0680j_4(NavigationBarHeight));
        final int width = (m2578getMaxWidthimpl - placeable.getWidth()) / 2;
        final int height = (m2592constrainHeightK40F9xA - placeable.getHeight()) / 2;
        final int width2 = (m2578getMaxWidthimpl - placeable2.getWidth()) / 2;
        final int height2 = (m2592constrainHeightK40F9xA - placeable2.getHeight()) / 2;
        return MeasureScope.layout$default(measureScope, m2578getMaxWidthimpl, m2592constrainHeightK40F9xA, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$placeIcon$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Placeable placeable4 = Placeable.this;
                if (placeable4 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, (m2578getMaxWidthimpl - placeable4.getWidth()) / 2, (m2592constrainHeightK40F9xA - placeable4.getHeight()) / 2, 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, width, height, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, width2, height2, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-zUg2_y0, reason: not valid java name */
    public static final MeasureResult m877placeLabelAndIconzUg2_y0(final MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j5, final boolean z5, final float f5) {
        float height = placeable2.getHeight();
        float f6 = IndicatorVerticalPadding;
        float mo212toPx0680j_4 = height + measureScope.mo212toPx0680j_4(f6);
        float f7 = NavigationBarIndicatorToLabelPadding;
        float mo212toPx0680j_42 = mo212toPx0680j_4 + measureScope.mo212toPx0680j_4(f7) + placeable.getHeight();
        float f8 = 2;
        final float coerceAtLeast = RangesKt.coerceAtLeast((Constraints.m2579getMinHeightimpl(j5) - mo212toPx0680j_42) / f8, measureScope.mo212toPx0680j_4(f6));
        float f9 = mo212toPx0680j_42 + (coerceAtLeast * f8);
        final float height2 = ((z5 ? coerceAtLeast : (f9 - placeable2.getHeight()) / f8) - coerceAtLeast) * (1 - f5);
        final float height3 = placeable2.getHeight() + coerceAtLeast + measureScope.mo212toPx0680j_4(f6) + measureScope.mo212toPx0680j_4(f7);
        final int m2578getMaxWidthimpl = Constraints.m2578getMaxWidthimpl(j5);
        final int width = (m2578getMaxWidthimpl - placeable.getWidth()) / 2;
        final int width2 = (m2578getMaxWidthimpl - placeable2.getWidth()) / 2;
        final int width3 = (m2578getMaxWidthimpl - placeable3.getWidth()) / 2;
        final float mo212toPx0680j_43 = coerceAtLeast - measureScope.mo212toPx0680j_4(f6);
        return MeasureScope.layout$default(measureScope, m2578getMaxWidthimpl, MathKt.roundToInt(f9), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$placeLabelAndIcon$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Placeable placeable5 = Placeable.this;
                if (placeable5 != null) {
                    int i5 = m2578getMaxWidthimpl;
                    float f10 = coerceAtLeast;
                    MeasureScope measureScope2 = measureScope;
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, (i5 - placeable5.getWidth()) / 2, MathKt.roundToInt((f10 - measureScope2.mo206roundToPx0680j_4(NavigationBarKt.getIndicatorVerticalPadding())) + height2), 0.0f, 4, null);
                }
                if (z5 || f5 != 0.0f) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, width, MathKt.roundToInt(height3 + height2), 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, width2, MathKt.roundToInt(coerceAtLeast + height2), 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, width3, MathKt.roundToInt(mo212toPx0680j_43 + height2), 0.0f, 4, null);
            }
        }, 4, null);
    }
}
