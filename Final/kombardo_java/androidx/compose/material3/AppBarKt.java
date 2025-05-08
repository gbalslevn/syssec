package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.TopAppBarSmallTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.constants.Constants;
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

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\u001az\u0010\u0013\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a~\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0003ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0094\u0001\u0010,\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00162\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0003ø\u0001\u0000¢\u0006\u0004\b*\u0010+\"\u0014\u0010-\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.\"\u001a\u0010/\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b/\u0010.\u001a\u0004\b0\u00101\"\u0014\u00102\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010.\"\u0014\u00103\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010.\"\u001a\u00105\u001a\u0002048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0014\u00109\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010.\"\u0014\u0010:\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010.\"\u0014\u0010;\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010.\"\u0014\u0010<\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010.\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006?²\u0006\f\u0010=\u001a\u00020!8\nX\u008a\u0084\u0002²\u0006\f\u0010>\u001a\u00020\u001d8\nX\u008a\u0084\u0002"}, d2 = {"Lkotlin/Function0;", BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, "Landroidx/compose/ui/Modifier;", "modifier", "navigationIcon", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "actions", "Landroidx/compose/ui/unit/Dp;", "expandedHeight", "Landroidx/compose/foundation/layout/WindowInsets;", "windowInsets", "Landroidx/compose/material3/TopAppBarColors;", "colors", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "scrollBehavior", "CenterAlignedTopAppBar-GHTll3U", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "CenterAlignedTopAppBar", "Landroidx/compose/ui/text/TextStyle;", "titleTextStyle", BuildConfig.FLAVOR, "centeredTitle", "SingleRowTopAppBar-cJHQLPU", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "SingleRowTopAppBar", "Landroidx/compose/material3/ScrolledOffset;", "scrolledOffset", "Landroidx/compose/ui/graphics/Color;", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", BuildConfig.FLAVOR, "titleAlpha", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "titleHorizontalArrangement", BuildConfig.FLAVOR, "titleBottomPadding", "hideTitleSemantics", "TopAppBarLayout-kXwM9vE", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/ScrolledOffset;JJJLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TopAppBarLayout", "BottomAppBarHorizontalPadding", "F", "BottomAppBarVerticalPadding", "getBottomAppBarVerticalPadding", "()F", "FABHorizontalPadding", "FABVerticalPadding", "Landroidx/compose/animation/core/CubicBezierEasing;", "TopTitleAlphaEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getTopTitleAlphaEasing", "()Landroidx/compose/animation/core/CubicBezierEasing;", "MediumTitleBottomPadding", "LargeTitleBottomPadding", "TopAppBarHorizontalPadding", "TopAppBarTitleInset", "colorTransitionFraction", "appBarContainerColor", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AppBarKt {
    private static final float BottomAppBarHorizontalPadding;
    private static final float BottomAppBarVerticalPadding;
    private static final float FABHorizontalPadding;
    private static final float FABVerticalPadding;
    private static final float LargeTitleBottomPadding;
    private static final float MediumTitleBottomPadding;
    private static final float TopAppBarHorizontalPadding;
    private static final float TopAppBarTitleInset;
    private static final CubicBezierEasing TopTitleAlphaEasing;

    static {
        float f5 = 16;
        float f6 = 12;
        float m2599constructorimpl = Dp.m2599constructorimpl(Dp.m2599constructorimpl(f5) - Dp.m2599constructorimpl(f6));
        BottomAppBarHorizontalPadding = m2599constructorimpl;
        float m2599constructorimpl2 = Dp.m2599constructorimpl(Dp.m2599constructorimpl(f5) - Dp.m2599constructorimpl(f6));
        BottomAppBarVerticalPadding = m2599constructorimpl2;
        FABHorizontalPadding = Dp.m2599constructorimpl(Dp.m2599constructorimpl(f5) - m2599constructorimpl);
        FABVerticalPadding = Dp.m2599constructorimpl(Dp.m2599constructorimpl(f6) - m2599constructorimpl2);
        TopTitleAlphaEasing = new CubicBezierEasing(0.8f, 0.0f, 0.8f, 0.15f);
        MediumTitleBottomPadding = Dp.m2599constructorimpl(24);
        LargeTitleBottomPadding = Dp.m2599constructorimpl(28);
        float m2599constructorimpl3 = Dp.m2599constructorimpl(4);
        TopAppBarHorizontalPadding = m2599constructorimpl3;
        TopAppBarTitleInset = Dp.m2599constructorimpl(Dp.m2599constructorimpl(f5) - m2599constructorimpl3);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00db  */
    /* renamed from: CenterAlignedTopAppBar-GHTll3U, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m770CenterAlignedTopAppBarGHTll3U(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, float f5, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i9;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        int i10;
        float f6;
        WindowInsets windowInsets2;
        TopAppBarColors topAppBarColors2;
        int i11;
        final Modifier modifier2;
        final TopAppBarScrollBehavior topAppBarScrollBehavior2;
        final float f7;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final TopAppBarColors topAppBarColors3;
        final WindowInsets windowInsets3;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        ScopeUpdateScope endRestartGroup;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(1952988048);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i14 = i6 & 2;
        if (i14 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                function23 = function22;
                i7 |= startRestartGroup.changedInstance(function23) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    function32 = function3;
                    i7 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else if ((i5 & 24576) == 0) {
                        f6 = f5;
                        i7 |= startRestartGroup.changed(f6) ? 16384 : 8192;
                        if ((196608 & i5) == 0) {
                            if ((i6 & 32) == 0) {
                                windowInsets2 = windowInsets;
                                if (startRestartGroup.changed(windowInsets2)) {
                                    i13 = 131072;
                                    i7 |= i13;
                                }
                            } else {
                                windowInsets2 = windowInsets;
                            }
                            i13 = 65536;
                            i7 |= i13;
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        if ((1572864 & i5) == 0) {
                            if ((i6 & 64) == 0) {
                                topAppBarColors2 = topAppBarColors;
                                if (startRestartGroup.changed(topAppBarColors2)) {
                                    i12 = 1048576;
                                    i7 |= i12;
                                }
                            } else {
                                topAppBarColors2 = topAppBarColors;
                            }
                            i12 = 524288;
                            i7 |= i12;
                        } else {
                            topAppBarColors2 = topAppBarColors;
                        }
                        i11 = i6 & 128;
                        if (i11 != 0) {
                            i7 |= 12582912;
                        } else if ((i5 & 12582912) == 0) {
                            i7 |= startRestartGroup.changed(topAppBarScrollBehavior) ? 8388608 : 4194304;
                        }
                        if ((i7 & 4793491) == 4793490 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                modifier2 = i14 != 0 ? Modifier.INSTANCE : modifier;
                                if (i8 != 0) {
                                    function23 = ComposableSingletons$AppBarKt.INSTANCE.m833getLambda7$material3_release();
                                }
                                if (i9 != 0) {
                                    function32 = ComposableSingletons$AppBarKt.INSTANCE.m834getLambda8$material3_release();
                                }
                                if (i10 != 0) {
                                    f6 = TopAppBarDefaults.INSTANCE.m989getTopAppBarExpandedHeightD9Ej5fM();
                                }
                                if ((i6 & 32) != 0) {
                                    i7 &= -458753;
                                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                }
                                if ((i6 & 64) != 0) {
                                    i7 &= -3670017;
                                    topAppBarColors2 = TopAppBarDefaults.INSTANCE.centerAlignedTopAppBarColors(startRestartGroup, 6);
                                }
                                if (i11 != 0) {
                                    topAppBarScrollBehavior2 = null;
                                    Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34 = function32;
                                    WindowInsets windowInsets4 = windowInsets2;
                                    TopAppBarColors topAppBarColors4 = topAppBarColors2;
                                    int i15 = i7;
                                    float f8 = f6;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1952988048, i15, -1, "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:332)");
                                    }
                                    TextStyle value = TypographyKt.getValue(TopAppBarSmallTokens.INSTANCE.getHeadlineFont(), startRestartGroup, 6);
                                    Dp.Companion companion = Dp.INSTANCE;
                                    int i16 = i15 << 6;
                                    m771SingleRowTopAppBarcJHQLPU(modifier2, function2, value, true, function23, function34, (!Dp.m2601equalsimpl0(f8, companion.m2608getUnspecifiedD9Ej5fM()) || Dp.m2601equalsimpl0(f8, companion.m2607getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m989getTopAppBarExpandedHeightD9Ej5fM() : f8, windowInsets4, topAppBarColors4, topAppBarScrollBehavior2, startRestartGroup, (57344 & i16) | ((i15 >> 3) & 14) | 3072 | ((i15 << 3) & 112) | (458752 & i16) | (29360128 & i16) | (234881024 & i16) | (i16 & 1879048192), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    f7 = f8;
                                    function24 = function23;
                                    topAppBarColors3 = topAppBarColors4;
                                    windowInsets3 = windowInsets4;
                                    function33 = function34;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i6 & 32) != 0) {
                                    i7 &= -458753;
                                }
                                if ((i6 & 64) != 0) {
                                    i7 &= -3670017;
                                }
                                modifier2 = modifier;
                            }
                            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                            Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function342 = function32;
                            WindowInsets windowInsets42 = windowInsets2;
                            TopAppBarColors topAppBarColors42 = topAppBarColors2;
                            int i152 = i7;
                            float f82 = f6;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            TextStyle value2 = TypographyKt.getValue(TopAppBarSmallTokens.INSTANCE.getHeadlineFont(), startRestartGroup, 6);
                            Dp.Companion companion2 = Dp.INSTANCE;
                            if (Dp.m2601equalsimpl0(f82, companion2.m2608getUnspecifiedD9Ej5fM())) {
                            }
                            int i162 = i152 << 6;
                            m771SingleRowTopAppBarcJHQLPU(modifier2, function2, value2, true, function23, function342, (!Dp.m2601equalsimpl0(f82, companion2.m2608getUnspecifiedD9Ej5fM()) || Dp.m2601equalsimpl0(f82, companion2.m2607getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m989getTopAppBarExpandedHeightD9Ej5fM() : f82, windowInsets42, topAppBarColors42, topAppBarScrollBehavior2, startRestartGroup, (57344 & i162) | ((i152 >> 3) & 14) | 3072 | ((i152 << 3) & 112) | (458752 & i162) | (29360128 & i162) | (234881024 & i162) | (i162 & 1879048192), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            f7 = f82;
                            function24 = function23;
                            topAppBarColors3 = topAppBarColors42;
                            windowInsets3 = windowInsets42;
                            function33 = function342;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                            function24 = function23;
                            function33 = function32;
                            f7 = f6;
                            windowInsets3 = windowInsets2;
                            topAppBarColors3 = topAppBarColors2;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>(function2, modifier2, function24, function33, f7, windowInsets3, topAppBarColors3, topAppBarScrollBehavior2, i5, i6) { // from class: androidx.compose.material3.AppBarKt$CenterAlignedTopAppBar$2
                                final /* synthetic */ int $$changed;
                                final /* synthetic */ int $$default;
                                final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $actions;
                                final /* synthetic */ TopAppBarColors $colors;
                                final /* synthetic */ float $expandedHeight;
                                final /* synthetic */ Modifier $modifier;
                                final /* synthetic */ Function2<Composer, Integer, Unit> $navigationIcon;
                                final /* synthetic */ Function2<Composer, Integer, Unit> $title;
                                final /* synthetic */ WindowInsets $windowInsets;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                    this.$$changed = i5;
                                    this.$$default = i6;
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i17) {
                                    AppBarKt.m770CenterAlignedTopAppBarGHTll3U(this.$title, this.$modifier, this.$navigationIcon, this.$actions, this.$expandedHeight, this.$windowInsets, this.$colors, null, composer2, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    f6 = f5;
                    if ((196608 & i5) == 0) {
                    }
                    if ((1572864 & i5) == 0) {
                    }
                    i11 = i6 & 128;
                    if (i11 != 0) {
                    }
                    if ((i7 & 4793491) == 4793490) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i6 & 32) != 0) {
                    }
                    if ((i6 & 64) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                    Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3422 = function32;
                    WindowInsets windowInsets422 = windowInsets2;
                    TopAppBarColors topAppBarColors422 = topAppBarColors2;
                    int i1522 = i7;
                    float f822 = f6;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    TextStyle value22 = TypographyKt.getValue(TopAppBarSmallTokens.INSTANCE.getHeadlineFont(), startRestartGroup, 6);
                    Dp.Companion companion22 = Dp.INSTANCE;
                    if (Dp.m2601equalsimpl0(f822, companion22.m2608getUnspecifiedD9Ej5fM())) {
                    }
                    int i1622 = i1522 << 6;
                    m771SingleRowTopAppBarcJHQLPU(modifier2, function2, value22, true, function23, function3422, (!Dp.m2601equalsimpl0(f822, companion22.m2608getUnspecifiedD9Ej5fM()) || Dp.m2601equalsimpl0(f822, companion22.m2607getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m989getTopAppBarExpandedHeightD9Ej5fM() : f822, windowInsets422, topAppBarColors422, topAppBarScrollBehavior2, startRestartGroup, (57344 & i1622) | ((i1522 >> 3) & 14) | 3072 | ((i1522 << 3) & 112) | (458752 & i1622) | (29360128 & i1622) | (234881024 & i1622) | (i1622 & 1879048192), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f7 = f822;
                    function24 = function23;
                    topAppBarColors3 = topAppBarColors422;
                    windowInsets3 = windowInsets422;
                    function33 = function3422;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function32 = function3;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                f6 = f5;
                if ((196608 & i5) == 0) {
                }
                if ((1572864 & i5) == 0) {
                }
                i11 = i6 & 128;
                if (i11 != 0) {
                }
                if ((i7 & 4793491) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i14 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if ((i6 & 32) != 0) {
                }
                if ((i6 & 64) != 0) {
                }
                if (i11 != 0) {
                }
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34222 = function32;
                WindowInsets windowInsets4222 = windowInsets2;
                TopAppBarColors topAppBarColors4222 = topAppBarColors2;
                int i15222 = i7;
                float f8222 = f6;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                TextStyle value222 = TypographyKt.getValue(TopAppBarSmallTokens.INSTANCE.getHeadlineFont(), startRestartGroup, 6);
                Dp.Companion companion222 = Dp.INSTANCE;
                if (Dp.m2601equalsimpl0(f8222, companion222.m2608getUnspecifiedD9Ej5fM())) {
                }
                int i16222 = i15222 << 6;
                m771SingleRowTopAppBarcJHQLPU(modifier2, function2, value222, true, function23, function34222, (!Dp.m2601equalsimpl0(f8222, companion222.m2608getUnspecifiedD9Ej5fM()) || Dp.m2601equalsimpl0(f8222, companion222.m2607getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m989getTopAppBarExpandedHeightD9Ej5fM() : f8222, windowInsets4222, topAppBarColors4222, topAppBarScrollBehavior2, startRestartGroup, (57344 & i16222) | ((i15222 >> 3) & 14) | 3072 | ((i15222 << 3) & 112) | (458752 & i16222) | (29360128 & i16222) | (234881024 & i16222) | (i16222 & 1879048192), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                f7 = f8222;
                function24 = function23;
                topAppBarColors3 = topAppBarColors4222;
                windowInsets3 = windowInsets4222;
                function33 = function34222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function23 = function22;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            function32 = function3;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            f6 = f5;
            if ((196608 & i5) == 0) {
            }
            if ((1572864 & i5) == 0) {
            }
            i11 = i6 & 128;
            if (i11 != 0) {
            }
            if ((i7 & 4793491) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i14 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if ((i6 & 64) != 0) {
            }
            if (i11 != 0) {
            }
            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
            Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function342222 = function32;
            WindowInsets windowInsets42222 = windowInsets2;
            TopAppBarColors topAppBarColors42222 = topAppBarColors2;
            int i152222 = i7;
            float f82222 = f6;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            TextStyle value2222 = TypographyKt.getValue(TopAppBarSmallTokens.INSTANCE.getHeadlineFont(), startRestartGroup, 6);
            Dp.Companion companion2222 = Dp.INSTANCE;
            if (Dp.m2601equalsimpl0(f82222, companion2222.m2608getUnspecifiedD9Ej5fM())) {
            }
            int i162222 = i152222 << 6;
            m771SingleRowTopAppBarcJHQLPU(modifier2, function2, value2222, true, function23, function342222, (!Dp.m2601equalsimpl0(f82222, companion2222.m2608getUnspecifiedD9Ej5fM()) || Dp.m2601equalsimpl0(f82222, companion2222.m2607getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m989getTopAppBarExpandedHeightD9Ej5fM() : f82222, windowInsets42222, topAppBarColors42222, topAppBarScrollBehavior2, startRestartGroup, (57344 & i162222) | ((i152222 >> 3) & 14) | 3072 | ((i152222 << 3) & 112) | (458752 & i162222) | (29360128 & i162222) | (234881024 & i162222) | (i162222 & 1879048192), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            f7 = f82222;
            function24 = function23;
            topAppBarColors3 = topAppBarColors42222;
            windowInsets3 = windowInsets42222;
            function33 = function342222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        function23 = function22;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        function32 = function3;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        f6 = f5;
        if ((196608 & i5) == 0) {
        }
        if ((1572864 & i5) == 0) {
        }
        i11 = i6 & 128;
        if (i11 != 0) {
        }
        if ((i7 & 4793491) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i14 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if ((i6 & 64) != 0) {
        }
        if (i11 != 0) {
        }
        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3422222 = function32;
        WindowInsets windowInsets422222 = windowInsets2;
        TopAppBarColors topAppBarColors422222 = topAppBarColors2;
        int i1522222 = i7;
        float f822222 = f6;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        TextStyle value22222 = TypographyKt.getValue(TopAppBarSmallTokens.INSTANCE.getHeadlineFont(), startRestartGroup, 6);
        Dp.Companion companion22222 = Dp.INSTANCE;
        if (Dp.m2601equalsimpl0(f822222, companion22222.m2608getUnspecifiedD9Ej5fM())) {
        }
        int i1622222 = i1522222 << 6;
        m771SingleRowTopAppBarcJHQLPU(modifier2, function2, value22222, true, function23, function3422222, (!Dp.m2601equalsimpl0(f822222, companion22222.m2608getUnspecifiedD9Ej5fM()) || Dp.m2601equalsimpl0(f822222, companion22222.m2607getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m989getTopAppBarExpandedHeightD9Ej5fM() : f822222, windowInsets422222, topAppBarColors422222, topAppBarScrollBehavior2, startRestartGroup, (57344 & i1622222) | ((i1522222 >> 3) & 14) | 3072 | ((i1522222 << 3) & 112) | (458752 & i1622222) | (29360128 & i1622222) | (234881024 & i1622222) | (i1622222 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        f7 = f822222;
        function24 = function23;
        topAppBarColors3 = topAppBarColors422222;
        windowInsets3 = windowInsets422222;
        function33 = function3422222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0153  */
    /* renamed from: SingleRowTopAppBar-cJHQLPU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m771SingleRowTopAppBarcJHQLPU(Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final boolean z5, final Function2<? super Composer, ? super Integer, Unit> function22, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, final float f5, final WindowInsets windowInsets, final TopAppBarColors topAppBarColors, final TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        Modifier modifier3;
        Modifier modifier4;
        Composer composer2;
        final Modifier modifier5;
        Composer startRestartGroup = composer.startRestartGroup(-342194911);
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
            i7 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(textStyle) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 2048 : 1024;
        }
        if ((i6 & 16) != 0) {
            i7 |= 24576;
        } else if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((i6 & 32) != 0) {
            i7 |= 196608;
        } else if ((i5 & 196608) == 0) {
            i7 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
        }
        if ((i6 & 64) != 0) {
            i7 |= 1572864;
        } else if ((i5 & 1572864) == 0) {
            i7 |= startRestartGroup.changed(f5) ? 1048576 : 524288;
        }
        if ((i6 & 128) != 0) {
            i7 |= 12582912;
        } else if ((i5 & 12582912) == 0) {
            i7 |= startRestartGroup.changed(windowInsets) ? 8388608 : 4194304;
            if ((i6 & 256) == 0) {
                i7 |= 100663296;
            } else if ((i5 & 100663296) == 0) {
                i7 |= startRestartGroup.changed(topAppBarColors) ? 67108864 : 33554432;
            }
            if ((i6 & 512) == 0) {
                i7 |= 805306368;
            } else if ((i5 & 805306368) == 0) {
                i7 |= startRestartGroup.changed(topAppBarScrollBehavior) ? 536870912 : 268435456;
            }
            if ((306783379 & i7) == 306783378 || !startRestartGroup.getSkipping()) {
                Modifier modifier6 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-342194911, i7, -1, "androidx.compose.material3.SingleRowTopAppBar (AppBar.kt:1861)");
                }
                if (!Float.isNaN(f5)) {
                    if (!(f5 == Float.POSITIVE_INFINITY)) {
                        final float coerceAtLeast = RangesKt.coerceAtLeast(((Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo212toPx0680j_4(f5), 0.0f);
                        int i9 = i7 & 1879048192;
                        boolean changed = (i9 == 536870912) | startRestartGroup.changed(coerceAtLeast);
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new Function0<Unit>(topAppBarScrollBehavior, coerceAtLeast) { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2$1
                                final /* synthetic */ float $expandedHeightPx;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                    this.$expandedHeightPx = coerceAtLeast;
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    Intrinsics.areEqual((Float) null, -this.$expandedHeightPx);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
                        boolean z6 = i9 == 536870912;
                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                        if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Float>(topAppBarScrollBehavior) { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$colorTransitionFraction$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(0.0f > 0.01f ? 1.0f : 0.0f);
                                }
                            });
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        boolean z7 = false;
                        State<Color> m54animateColorAsStateeuL9pac = SingleValueAnimationKt.m54animateColorAsStateeuL9pac(topAppBarColors.m984containerColorvNxB06k$material3_release(SingleRowTopAppBar_cJHQLPU$lambda$9((State) rememberedValue2)), AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null), null, null, startRestartGroup, 48, 12);
                        ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1370231018, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1
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
                                    ComposerKt.traceEventStart(1370231018, i10, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1895)");
                                }
                                Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                Modifier.Companion companion = Modifier.INSTANCE;
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer3, 54);
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, companion);
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                if (composer3.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer3);
                                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                                function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
                                composer3.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54);
                        startRestartGroup.startReplaceGroup(-1193605157);
                        if (topAppBarScrollBehavior == null || topAppBarScrollBehavior.isPinned()) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            Modifier.Companion companion = Modifier.INSTANCE;
                            Orientation orientation = Orientation.Vertical;
                            boolean z8 = i9 == 536870912;
                            Object rememberedValue3 = startRestartGroup.rememberedValue();
                            if (z8 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = new Function1<Float, Unit>(topAppBarScrollBehavior) { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Float f6) {
                                        invoke(f6.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f6) {
                                        throw null;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            DraggableState rememberDraggableState = DraggableKt.rememberDraggableState((Function1) rememberedValue3, startRestartGroup, 0);
                            if (i9 == 536870912) {
                                z7 = true;
                            }
                            Object rememberedValue4 = startRestartGroup.rememberedValue();
                            if (z7 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = new AppBarKt$SingleRowTopAppBar$appBarDragModifier$2$1(topAppBarScrollBehavior, null);
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            modifier3 = DraggableKt.draggable(companion, rememberDraggableState, orientation, (r20 & 4) != 0, (r20 & 8) != 0 ? null : null, (r20 & 16) != 0 ? false : false, (r20 & 32) != 0 ? DraggableKt.NoOpOnDragStarted : null, (r20 & 64) != 0 ? DraggableKt.NoOpOnDragStopped : (Function3) rememberedValue4, (r20 & 128) != 0 ? false : false);
                        }
                        startRestartGroup.endReplaceGroup();
                        modifier4 = modifier6;
                        composer2 = startRestartGroup;
                        SurfaceKt.m900SurfaceT9BRK9s(modifier6.then(modifier3), null, SingleRowTopAppBar_cJHQLPU$lambda$10(m54animateColorAsStateeuL9pac), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1943739546, true, new AppBarKt$SingleRowTopAppBar$3(windowInsets, f5, topAppBarScrollBehavior, topAppBarColors, function2, textStyle, z5, function22, rememberComposableLambda), composer2, 54), composer2, 12582912, 122);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                    }
                }
                throw new IllegalArgumentException("The expandedHeight is expected to be specified and finite");
            }
            startRestartGroup.skipToGroupEnd();
            modifier5 = modifier2;
            composer2 = startRestartGroup;
            ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>(function2, textStyle, z5, function22, function3, f5, windowInsets, topAppBarColors, topAppBarScrollBehavior, i5, i6) { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$4
                    final /* synthetic */ int $$changed;
                    final /* synthetic */ int $$default;
                    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $actions;
                    final /* synthetic */ boolean $centeredTitle;
                    final /* synthetic */ TopAppBarColors $colors;
                    final /* synthetic */ float $expandedHeight;
                    final /* synthetic */ Function2<Composer, Integer, Unit> $navigationIcon;
                    final /* synthetic */ Function2<Composer, Integer, Unit> $title;
                    final /* synthetic */ TextStyle $titleTextStyle;
                    final /* synthetic */ WindowInsets $windowInsets;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                        this.$$changed = i5;
                        this.$$default = i6;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i10) {
                        AppBarKt.m771SingleRowTopAppBarcJHQLPU(Modifier.this, this.$title, this.$titleTextStyle, this.$centeredTitle, this.$navigationIcon, this.$actions, this.$expandedHeight, this.$windowInsets, this.$colors, null, composer3, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
                    }
                });
                return;
            }
            return;
        }
        if ((i6 & 256) == 0) {
        }
        if ((i6 & 512) == 0) {
        }
        if ((306783379 & i7) == 306783378) {
        }
        if (i8 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (!Float.isNaN(f5)) {
        }
        throw new IllegalArgumentException("The expandedHeight is expected to be specified and finite");
    }

    private static final long SingleRowTopAppBar_cJHQLPU$lambda$10(State<Color> state) {
        return state.getValue().getValue();
    }

    private static final float SingleRowTopAppBar_cJHQLPU$lambda$9(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TopAppBarLayout-kXwM9vE, reason: not valid java name */
    public static final void m772TopAppBarLayoutkXwM9vE(final Modifier modifier, final ScrolledOffset scrolledOffset, final long j5, final long j6, final long j7, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final float f5, final Arrangement.Vertical vertical, final Arrangement.Horizontal horizontal, final int i5, final boolean z5, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i6, final int i7) {
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-742442296);
        if ((i6 & 6) == 0) {
            i8 = (startRestartGroup.changed(modifier) ? 4 : 2) | i6;
        } else {
            i8 = i6;
        }
        if ((i6 & 48) == 0) {
            i8 |= (i6 & 64) == 0 ? startRestartGroup.changed(scrolledOffset) : startRestartGroup.changedInstance(scrolledOffset) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i8 |= startRestartGroup.changed(j5) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i8 |= startRestartGroup.changed(j6) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i8 |= startRestartGroup.changed(j7) ? 16384 : 8192;
        }
        if ((196608 & i6) == 0) {
            i8 |= startRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if ((i6 & 1572864) == 0) {
            i8 |= startRestartGroup.changed(textStyle) ? 1048576 : 524288;
        }
        if ((i6 & 12582912) == 0) {
            i8 |= startRestartGroup.changed(f5) ? 8388608 : 4194304;
        }
        if ((i6 & 100663296) == 0) {
            i8 |= startRestartGroup.changed(vertical) ? 67108864 : 33554432;
        }
        if ((805306368 & i6) == 0) {
            i8 |= startRestartGroup.changed(horizontal) ? 536870912 : 268435456;
        }
        if ((i7 & 6) == 0) {
            i9 = (startRestartGroup.changed(i5) ? 4 : 2) | i7;
        } else {
            i9 = i7;
        }
        if ((i7 & 48) == 0) {
            i9 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i7 & 384) == 0) {
            i9 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
        }
        if ((i7 & 3072) == 0) {
            i9 |= startRestartGroup.changedInstance(function23) ? 2048 : 1024;
        }
        if ((306783379 & i8) == 306783378 && (i9 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-742442296, i8, i9, "androidx.compose.material3.TopAppBarLayout (AppBar.kt:2134)");
            }
            boolean z6 = ((i8 & 112) == 32 || ((i8 & 64) != 0 && startRestartGroup.changedInstance(scrolledOffset))) | ((1879048192 & i8) == 536870912) | ((234881024 & i8) == 67108864) | ((i9 & 14) == 4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo19measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, final long j8) {
                        int size = list.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            Measurable measurable = list.get(i10);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "navigationIcon")) {
                                final Placeable mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(Constraints.m2570copyZbe2FdA$default(j8, 0, 0, 0, 0, 14, null));
                                int size2 = list.size();
                                for (int i11 = 0; i11 < size2; i11++) {
                                    Measurable measurable2 = list.get(i11);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "actionIcons")) {
                                        final Placeable mo1946measureBRTryo02 = measurable2.mo1946measureBRTryo0(Constraints.m2570copyZbe2FdA$default(j8, 0, 0, 0, 0, 14, null));
                                        int m2578getMaxWidthimpl = Constraints.m2578getMaxWidthimpl(j8) == Integer.MAX_VALUE ? Constraints.m2578getMaxWidthimpl(j8) : RangesKt.coerceAtLeast((Constraints.m2578getMaxWidthimpl(j8) - mo1946measureBRTryo0.getWidth()) - mo1946measureBRTryo02.getWidth(), 0);
                                        int size3 = list.size();
                                        for (int i12 = 0; i12 < size3; i12++) {
                                            Measurable measurable3 = list.get(i12);
                                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), Constants.IntentExtra.PushTitle)) {
                                                final Placeable mo1946measureBRTryo03 = measurable3.mo1946measureBRTryo0(Constraints.m2570copyZbe2FdA$default(j8, 0, m2578getMaxWidthimpl, 0, 0, 12, null));
                                                final int i13 = mo1946measureBRTryo03.get(AlignmentLineKt.getLastBaseline()) != Integer.MIN_VALUE ? mo1946measureBRTryo03.get(AlignmentLineKt.getLastBaseline()) : 0;
                                                float offset = ScrolledOffset.this.offset();
                                                final int m2577getMaxHeightimpl = Constraints.m2577getMaxHeightimpl(j8) == Integer.MAX_VALUE ? Constraints.m2577getMaxHeightimpl(j8) : Constraints.m2577getMaxHeightimpl(j8) + (Float.isNaN(offset) ? 0 : MathKt.roundToInt(offset));
                                                int m2578getMaxWidthimpl2 = Constraints.m2578getMaxWidthimpl(j8);
                                                final Arrangement.Horizontal horizontal2 = horizontal;
                                                final Arrangement.Vertical vertical2 = vertical;
                                                final int i14 = i5;
                                                return MeasureScope.layout$default(measureScope, m2578getMaxWidthimpl2, m2577getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$2$1.1
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
                                                        float f6;
                                                        int max;
                                                        int i15;
                                                        int height;
                                                        int m2578getMaxWidthimpl3;
                                                        Placeable placeable = Placeable.this;
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, (m2577getMaxHeightimpl - placeable.getHeight()) / 2, 0.0f, 4, null);
                                                        Placeable placeable2 = mo1946measureBRTryo03;
                                                        Arrangement.Horizontal horizontal3 = horizontal2;
                                                        Arrangement arrangement = Arrangement.INSTANCE;
                                                        if (Intrinsics.areEqual(horizontal3, arrangement.getCenter())) {
                                                            max = (Constraints.m2578getMaxWidthimpl(j8) - mo1946measureBRTryo03.getWidth()) / 2;
                                                            if (max < Placeable.this.getWidth()) {
                                                                m2578getMaxWidthimpl3 = Placeable.this.getWidth() - max;
                                                            } else if (mo1946measureBRTryo03.getWidth() + max > Constraints.m2578getMaxWidthimpl(j8) - mo1946measureBRTryo02.getWidth()) {
                                                                m2578getMaxWidthimpl3 = (Constraints.m2578getMaxWidthimpl(j8) - mo1946measureBRTryo02.getWidth()) - (mo1946measureBRTryo03.getWidth() + max);
                                                            }
                                                            max += m2578getMaxWidthimpl3;
                                                        } else if (Intrinsics.areEqual(horizontal3, arrangement.getEnd())) {
                                                            max = (Constraints.m2578getMaxWidthimpl(j8) - mo1946measureBRTryo03.getWidth()) - mo1946measureBRTryo02.getWidth();
                                                        } else {
                                                            MeasureScope measureScope2 = measureScope;
                                                            f6 = AppBarKt.TopAppBarTitleInset;
                                                            max = Math.max(measureScope2.mo206roundToPx0680j_4(f6), Placeable.this.getWidth());
                                                        }
                                                        int i16 = max;
                                                        Arrangement.Vertical vertical3 = vertical2;
                                                        if (!Intrinsics.areEqual(vertical3, arrangement.getCenter())) {
                                                            if (Intrinsics.areEqual(vertical3, arrangement.getBottom())) {
                                                                int i17 = i14;
                                                                if (i17 == 0) {
                                                                    height = m2577getMaxHeightimpl - mo1946measureBRTryo03.getHeight();
                                                                } else {
                                                                    int height2 = i17 - (mo1946measureBRTryo03.getHeight() - i13);
                                                                    int height3 = mo1946measureBRTryo03.getHeight() + height2;
                                                                    if (height3 > Constraints.m2577getMaxHeightimpl(j8)) {
                                                                        height2 -= height3 - Constraints.m2577getMaxHeightimpl(j8);
                                                                    }
                                                                    i15 = (m2577getMaxHeightimpl - mo1946measureBRTryo03.getHeight()) - Math.max(0, height2);
                                                                }
                                                            } else {
                                                                i15 = 0;
                                                            }
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i16, i15, 0.0f, 4, null);
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, mo1946measureBRTryo02, Constraints.m2578getMaxWidthimpl(j8) - mo1946measureBRTryo02.getWidth(), (m2577getMaxHeightimpl - mo1946measureBRTryo02.getHeight()) / 2, 0.0f, 4, null);
                                                        }
                                                        height = (m2577getMaxHeightimpl - mo1946measureBRTryo03.getHeight()) / 2;
                                                        i15 = height;
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i16, i15, 0.0f, 4, null);
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, mo1946measureBRTryo02, Constraints.m2578getMaxWidthimpl(j8) - mo1946measureBRTryo02.getWidth(), (m2577getMaxHeightimpl - mo1946measureBRTryo02.getHeight()) / 2, 0.0f, 4, null);
                                                    }
                                                }, 4, null);
                                            }
                                        }
                                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
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
            Updater.m1227setimpl(m1226constructorimpl, measurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier layoutId = LayoutIdKt.layoutId(companion2, "navigationIcon");
            float f6 = TopAppBarHorizontalPadding;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(layoutId, f6, 0.0f, 0.0f, 0.0f, 14, null);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
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
            ProvidedValue<Color> provides = ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j5));
            int i10 = ProvidedValue.$stable;
            CompositionLocalKt.CompositionLocalProvider(provides, function22, startRestartGroup, ((i9 >> 3) & 112) | i10);
            startRestartGroup.endNode();
            Modifier m1525graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m1525graphicsLayerAp8cVGQ$default(PaddingKt.m313paddingVpY3zN4$default(LayoutIdKt.layoutId(companion2, Constants.IntentExtra.PushTitle), f6, 0.0f, 2, null).then(z5 ? SemanticsModifierKt.clearAndSetSemantics(companion2, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$1$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }
            }) : companion2), 0.0f, 0.0f, f5, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131067, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m1525graphicsLayerAp8cVGQ$default);
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
            int i11 = i8 >> 9;
            ProvideContentColorTextStyleKt.m994ProvideContentColorTextStyle3JVO9M(j6, textStyle, function2, startRestartGroup, ((i8 >> 15) & 112) | (i11 & 14) | (i11 & 896));
            startRestartGroup.endNode();
            Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(LayoutIdKt.layoutId(companion2, "actionIcons"), 0.0f, 0.0f, f6, 0.0f, 11, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default2);
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
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j7)), function23, startRestartGroup, ((i9 >> 6) & 112) | i10);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$3
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
                    AppBarKt.m772TopAppBarLayoutkXwM9vE(Modifier.this, scrolledOffset, j5, j6, j7, function2, textStyle, f5, vertical, horizontal, i5, z5, function22, function23, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), RecomposeScopeImplKt.updateChangedFlags(i7));
                }
            });
        }
    }
}
