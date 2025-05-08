package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.FabPosition;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0098\u0001\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001an\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\"\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function0;", BuildConfig.FLAVOR, "topBar", "bottomBar", "snackbarHost", "floatingActionButton", "Landroidx/compose/material3/FabPosition;", "floatingActionButtonPosition", "Landroidx/compose/ui/graphics/Color;", "containerColor", "contentColor", "Landroidx/compose/foundation/layout/WindowInsets;", "contentWindowInsets", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Scaffold-TvnljyQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;IJJLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Scaffold", "fabPosition", "snackbar", "fab", "ScaffoldLayout-FMILGgc", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ScaffoldLayout", "Landroidx/compose/ui/unit/Dp;", "FabSpacing", "F", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ScaffoldKt {
    private static final float FabSpacing = Dp.m2599constructorimpl(16);

    /* JADX WARN: Removed duplicated region for block: B:101:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x025e  */
    /* renamed from: Scaffold-TvnljyQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m886ScaffoldTvnljyQ(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, int i5, long j5, long j6, WindowInsets windowInsets, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i6, final int i7) {
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i10;
        int i11;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i12;
        int i13;
        long j7;
        Modifier modifier2;
        Function2<? super Composer, ? super Integer, Unit> m835getLambda1$material3_release;
        Function2<? super Composer, ? super Integer, Unit> m836getLambda2$material3_release;
        Function2<? super Composer, ? super Integer, Unit> m837getLambda3$material3_release;
        Function2<? super Composer, ? super Integer, Unit> m838getLambda4$material3_release;
        int m847getEndERTFSPs;
        int i14;
        long j8;
        final WindowInsets contentWindowInsets;
        int i15;
        long j9;
        boolean z5;
        Object rememberedValue;
        boolean changed;
        Object rememberedValue2;
        long j10;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        WindowInsets windowInsets2;
        long j11;
        Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(-1219521777);
        int i17 = i7 & 1;
        if (i17 != 0) {
            i8 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i8 = (startRestartGroup.changed(modifier) ? 4 : 2) | i6;
        } else {
            i8 = i6;
        }
        int i18 = i7 & 2;
        if (i18 != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            function25 = function2;
            i8 |= startRestartGroup.changedInstance(function25) ? 32 : 16;
            i9 = i7 & 4;
            if (i9 == 0) {
                i8 |= 384;
            } else if ((i6 & 384) == 0) {
                function26 = function22;
                i8 |= startRestartGroup.changedInstance(function26) ? 256 : 128;
                i10 = i7 & 8;
                if (i10 != 0) {
                    i8 |= 3072;
                } else if ((i6 & 3072) == 0) {
                    i8 |= startRestartGroup.changedInstance(function23) ? 2048 : 1024;
                    i11 = i7 & 16;
                    if (i11 == 0) {
                        i8 |= 24576;
                    } else if ((i6 & 24576) == 0) {
                        function27 = function24;
                        i8 |= startRestartGroup.changedInstance(function27) ? 16384 : 8192;
                        i12 = i7 & 32;
                        if (i12 != 0) {
                            i8 |= 196608;
                        } else if ((i6 & 196608) == 0) {
                            i8 |= startRestartGroup.changed(i5) ? 131072 : 65536;
                        }
                        if ((i6 & 1572864) == 0) {
                            i13 = i11;
                            i8 |= ((i7 & 64) == 0 && startRestartGroup.changed(j5)) ? 1048576 : 524288;
                        } else {
                            i13 = i11;
                        }
                        if ((i6 & 12582912) == 0) {
                            j7 = j6;
                            i8 |= ((i7 & 128) == 0 && startRestartGroup.changed(j7)) ? 8388608 : 4194304;
                        } else {
                            j7 = j6;
                        }
                        if ((i6 & 100663296) == 0) {
                            if ((i7 & 256) == 0 && startRestartGroup.changed(windowInsets)) {
                                i16 = 67108864;
                                i8 |= i16;
                            }
                            i16 = 33554432;
                            i8 |= i16;
                        }
                        if ((i7 & 512) != 0) {
                            i8 |= 805306368;
                        } else if ((i6 & 805306368) == 0) {
                            i8 |= startRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                            if ((i8 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i6 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    modifier2 = i17 == 0 ? Modifier.INSTANCE : modifier;
                                    m835getLambda1$material3_release = i18 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m835getLambda1$material3_release() : function25;
                                    m836getLambda2$material3_release = i9 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m836getLambda2$material3_release() : function26;
                                    m837getLambda3$material3_release = i10 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m837getLambda3$material3_release() : function23;
                                    m838getLambda4$material3_release = i13 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m838getLambda4$material3_release() : function27;
                                    m847getEndERTFSPs = i12 == 0 ? FabPosition.INSTANCE.m847getEndERTFSPs() : i5;
                                    if ((i7 & 64) == 0) {
                                        i14 = i8 & (-3670017);
                                        j8 = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6).getBackground();
                                    } else {
                                        i14 = i8;
                                        j8 = j5;
                                    }
                                    if ((i7 & 128) != 0) {
                                        j7 = ColorSchemeKt.m827contentColorForek8zF_U(j8, startRestartGroup, (i14 >> 18) & 14);
                                        i14 &= -29360129;
                                    }
                                    if ((i7 & 256) != 0) {
                                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(startRestartGroup, 6);
                                        i14 &= -234881025;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1219521777, i14, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:94)");
                                        }
                                        i15 = (234881024 & i14) ^ 100663296;
                                        if (i15 > 67108864 || !startRestartGroup.changed(contentWindowInsets)) {
                                            j9 = j7;
                                            if ((i14 & 100663296) != 67108864) {
                                                z5 = false;
                                                rememberedValue = startRestartGroup.rememberedValue();
                                                if (!z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue = new MutableWindowInsets(contentWindowInsets);
                                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                                }
                                                final MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) rememberedValue;
                                                changed = startRestartGroup.changed(mutableWindowInsets) | ((i15 <= 67108864 && startRestartGroup.changed(contentWindowInsets)) || (100663296 & i14) == 67108864);
                                                rememberedValue2 = startRestartGroup.rememberedValue();
                                                if (!changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue2 = new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets3) {
                                                            invoke2(windowInsets3);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2(WindowInsets windowInsets3) {
                                                            MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(contentWindowInsets, windowInsets3));
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                                }
                                                final int i19 = m847getEndERTFSPs;
                                                final Function2<? super Composer, ? super Integer, Unit> function211 = m835getLambda1$material3_release;
                                                final Function2<? super Composer, ? super Integer, Unit> function212 = m837getLambda3$material3_release;
                                                final Function2<? super Composer, ? super Integer, Unit> function213 = m838getLambda4$material3_release;
                                                final Function2<? super Composer, ? super Integer, Unit> function214 = m836getLambda2$material3_release;
                                                int i20 = i14 >> 12;
                                                SurfaceKt.m900SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier2, (Function1) rememberedValue2), null, j8, j9, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

                                                    public final void invoke(Composer composer2, int i21) {
                                                        if ((i21 & 3) == 2 && composer2.getSkipping()) {
                                                            composer2.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1979205334, i21, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:105)");
                                                        }
                                                        ScaffoldKt.m887ScaffoldLayoutFMILGgc(i19, function211, function3, function212, function213, mutableWindowInsets, function214, composer2, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, startRestartGroup, 54), startRestartGroup, (i20 & 896) | 12582912 | (i20 & 7168), 114);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                j10 = j8;
                                                function28 = m836getLambda2$material3_release;
                                                function29 = m837getLambda3$material3_release;
                                                function210 = m838getLambda4$material3_release;
                                                windowInsets2 = contentWindowInsets;
                                                j11 = j9;
                                                function25 = m835getLambda1$material3_release;
                                                modifier3 = modifier2;
                                            }
                                        } else {
                                            j9 = j7;
                                        }
                                        z5 = true;
                                        rememberedValue = startRestartGroup.rememberedValue();
                                        if (!z5) {
                                        }
                                        rememberedValue = new MutableWindowInsets(contentWindowInsets);
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                        final MutableWindowInsets mutableWindowInsets2 = (MutableWindowInsets) rememberedValue;
                                        changed = startRestartGroup.changed(mutableWindowInsets2) | ((i15 <= 67108864 && startRestartGroup.changed(contentWindowInsets)) || (100663296 & i14) == 67108864);
                                        rememberedValue2 = startRestartGroup.rememberedValue();
                                        if (!changed) {
                                        }
                                        rememberedValue2 = new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets3) {
                                                invoke2(windowInsets3);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(WindowInsets windowInsets3) {
                                                MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(contentWindowInsets, windowInsets3));
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                        final int i192 = m847getEndERTFSPs;
                                        final Function2<? super Composer, ? super Integer, Unit> function2112 = m835getLambda1$material3_release;
                                        final Function2<? super Composer, ? super Integer, Unit> function2122 = m837getLambda3$material3_release;
                                        final Function2<? super Composer, ? super Integer, Unit> function2132 = m838getLambda4$material3_release;
                                        final Function2<? super Composer, ? super Integer, Unit> function2142 = m836getLambda2$material3_release;
                                        int i202 = i14 >> 12;
                                        SurfaceKt.m900SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier2, (Function1) rememberedValue2), null, j8, j9, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

                                            public final void invoke(Composer composer2, int i21) {
                                                if ((i21 & 3) == 2 && composer2.getSkipping()) {
                                                    composer2.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1979205334, i21, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:105)");
                                                }
                                                ScaffoldKt.m887ScaffoldLayoutFMILGgc(i192, function2112, function3, function2122, function2132, mutableWindowInsets2, function2142, composer2, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, startRestartGroup, 54), startRestartGroup, (i202 & 896) | 12582912 | (i202 & 7168), 114);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        j10 = j8;
                                        function28 = m836getLambda2$material3_release;
                                        function29 = m837getLambda3$material3_release;
                                        function210 = m838getLambda4$material3_release;
                                        windowInsets2 = contentWindowInsets;
                                        j11 = j9;
                                        function25 = m835getLambda1$material3_release;
                                        modifier3 = modifier2;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i7 & 64) != 0) {
                                        i8 &= -3670017;
                                    }
                                    if ((i7 & 128) != 0) {
                                        i8 &= -29360129;
                                    }
                                    if ((i7 & 256) != 0) {
                                        i8 &= -234881025;
                                    }
                                    modifier2 = modifier;
                                    i14 = i8;
                                    m835getLambda1$material3_release = function25;
                                    m836getLambda2$material3_release = function26;
                                    m838getLambda4$material3_release = function27;
                                    m837getLambda3$material3_release = function23;
                                    m847getEndERTFSPs = i5;
                                    j8 = j5;
                                }
                                contentWindowInsets = windowInsets;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                i15 = (234881024 & i14) ^ 100663296;
                                if (i15 > 67108864) {
                                }
                                j9 = j7;
                                if ((i14 & 100663296) != 67108864) {
                                }
                                z5 = true;
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!z5) {
                                }
                                rememberedValue = new MutableWindowInsets(contentWindowInsets);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                                final MutableWindowInsets mutableWindowInsets22 = (MutableWindowInsets) rememberedValue;
                                changed = startRestartGroup.changed(mutableWindowInsets22) | ((i15 <= 67108864 && startRestartGroup.changed(contentWindowInsets)) || (100663296 & i14) == 67108864);
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!changed) {
                                }
                                rememberedValue2 = new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets3) {
                                        invoke2(windowInsets3);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(WindowInsets windowInsets3) {
                                        MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(contentWindowInsets, windowInsets3));
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                final int i1922 = m847getEndERTFSPs;
                                final Function2<? super Composer, ? super Integer, Unit> function21122 = m835getLambda1$material3_release;
                                final Function2<? super Composer, ? super Integer, Unit> function21222 = m837getLambda3$material3_release;
                                final Function2<? super Composer, ? super Integer, Unit> function21322 = m838getLambda4$material3_release;
                                final Function2<? super Composer, ? super Integer, Unit> function21422 = m836getLambda2$material3_release;
                                int i2022 = i14 >> 12;
                                SurfaceKt.m900SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier2, (Function1) rememberedValue2), null, j8, j9, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

                                    public final void invoke(Composer composer2, int i21) {
                                        if ((i21 & 3) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1979205334, i21, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:105)");
                                        }
                                        ScaffoldKt.m887ScaffoldLayoutFMILGgc(i1922, function21122, function3, function21222, function21322, mutableWindowInsets22, function21422, composer2, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, startRestartGroup, 54), startRestartGroup, (i2022 & 896) | 12582912 | (i2022 & 7168), 114);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                j10 = j8;
                                function28 = m836getLambda2$material3_release;
                                function29 = m837getLambda3$material3_release;
                                function210 = m838getLambda4$material3_release;
                                windowInsets2 = contentWindowInsets;
                                j11 = j9;
                                function25 = m835getLambda1$material3_release;
                                modifier3 = modifier2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier3 = modifier;
                                function29 = function23;
                                windowInsets2 = windowInsets;
                                function28 = function26;
                                function210 = function27;
                                m847getEndERTFSPs = i5;
                                j11 = j7;
                                j10 = j5;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                final Modifier modifier4 = modifier3;
                                final Function2<? super Composer, ? super Integer, Unit> function215 = function25;
                                final int i21 = m847getEndERTFSPs;
                                final long j12 = j10;
                                final long j13 = j11;
                                final WindowInsets windowInsets3 = windowInsets2;
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$3
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

                                    public final void invoke(Composer composer2, int i22) {
                                        ScaffoldKt.m886ScaffoldTvnljyQ(Modifier.this, function215, function28, function29, function210, i21, j12, j13, windowInsets3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i8 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i6 & 1) != 0) {
                        }
                        if (i17 == 0) {
                        }
                        if (i18 == 0) {
                        }
                        if (i9 == 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (i12 == 0) {
                        }
                        if ((i7 & 64) == 0) {
                        }
                        if ((i7 & 128) != 0) {
                        }
                        if ((i7 & 256) != 0) {
                        }
                        contentWindowInsets = windowInsets;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        i15 = (234881024 & i14) ^ 100663296;
                        if (i15 > 67108864) {
                        }
                        j9 = j7;
                        if ((i14 & 100663296) != 67108864) {
                        }
                        z5 = true;
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!z5) {
                        }
                        rememberedValue = new MutableWindowInsets(contentWindowInsets);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        final MutableWindowInsets mutableWindowInsets222 = (MutableWindowInsets) rememberedValue;
                        changed = startRestartGroup.changed(mutableWindowInsets222) | ((i15 <= 67108864 && startRestartGroup.changed(contentWindowInsets)) || (100663296 & i14) == 67108864);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue2 = new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets32) {
                                invoke2(windowInsets32);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(WindowInsets windowInsets32) {
                                MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(contentWindowInsets, windowInsets32));
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        final int i19222 = m847getEndERTFSPs;
                        final Function2<? super Composer, ? super Integer, Unit> function211222 = m835getLambda1$material3_release;
                        final Function2<? super Composer, ? super Integer, Unit> function212222 = m837getLambda3$material3_release;
                        final Function2<? super Composer, ? super Integer, Unit> function213222 = m838getLambda4$material3_release;
                        final Function2<? super Composer, ? super Integer, Unit> function214222 = m836getLambda2$material3_release;
                        int i20222 = i14 >> 12;
                        SurfaceKt.m900SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier2, (Function1) rememberedValue2), null, j8, j9, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

                            public final void invoke(Composer composer2, int i212) {
                                if ((i212 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1979205334, i212, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:105)");
                                }
                                ScaffoldKt.m887ScaffoldLayoutFMILGgc(i19222, function211222, function3, function212222, function213222, mutableWindowInsets222, function214222, composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54), startRestartGroup, (i20222 & 896) | 12582912 | (i20222 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        j10 = j8;
                        function28 = m836getLambda2$material3_release;
                        function29 = m837getLambda3$material3_release;
                        function210 = m838getLambda4$material3_release;
                        windowInsets2 = contentWindowInsets;
                        j11 = j9;
                        function25 = m835getLambda1$material3_release;
                        modifier3 = modifier2;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    function27 = function24;
                    i12 = i7 & 32;
                    if (i12 != 0) {
                    }
                    if ((i6 & 1572864) == 0) {
                    }
                    if ((i6 & 12582912) == 0) {
                    }
                    if ((i6 & 100663296) == 0) {
                    }
                    if ((i7 & 512) != 0) {
                    }
                    if ((i8 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i6 & 1) != 0) {
                    }
                    if (i17 == 0) {
                    }
                    if (i18 == 0) {
                    }
                    if (i9 == 0) {
                    }
                    if (i10 == 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i12 == 0) {
                    }
                    if ((i7 & 64) == 0) {
                    }
                    if ((i7 & 128) != 0) {
                    }
                    if ((i7 & 256) != 0) {
                    }
                    contentWindowInsets = windowInsets;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i15 = (234881024 & i14) ^ 100663296;
                    if (i15 > 67108864) {
                    }
                    j9 = j7;
                    if ((i14 & 100663296) != 67108864) {
                    }
                    z5 = true;
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z5) {
                    }
                    rememberedValue = new MutableWindowInsets(contentWindowInsets);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    final MutableWindowInsets mutableWindowInsets2222 = (MutableWindowInsets) rememberedValue;
                    changed = startRestartGroup.changed(mutableWindowInsets2222) | ((i15 <= 67108864 && startRestartGroup.changed(contentWindowInsets)) || (100663296 & i14) == 67108864);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue2 = new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets32) {
                            invoke2(windowInsets32);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(WindowInsets windowInsets32) {
                            MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(contentWindowInsets, windowInsets32));
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    final int i192222 = m847getEndERTFSPs;
                    final Function2<? super Composer, ? super Integer, Unit> function2112222 = m835getLambda1$material3_release;
                    final Function2<? super Composer, ? super Integer, Unit> function2122222 = m837getLambda3$material3_release;
                    final Function2<? super Composer, ? super Integer, Unit> function2132222 = m838getLambda4$material3_release;
                    final Function2<? super Composer, ? super Integer, Unit> function2142222 = m836getLambda2$material3_release;
                    int i202222 = i14 >> 12;
                    SurfaceKt.m900SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier2, (Function1) rememberedValue2), null, j8, j9, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

                        public final void invoke(Composer composer2, int i212) {
                            if ((i212 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1979205334, i212, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:105)");
                            }
                            ScaffoldKt.m887ScaffoldLayoutFMILGgc(i192222, function2112222, function3, function2122222, function2132222, mutableWindowInsets2222, function2142222, composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, (i202222 & 896) | 12582912 | (i202222 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    j10 = j8;
                    function28 = m836getLambda2$material3_release;
                    function29 = m837getLambda3$material3_release;
                    function210 = m838getLambda4$material3_release;
                    windowInsets2 = contentWindowInsets;
                    j11 = j9;
                    function25 = m835getLambda1$material3_release;
                    modifier3 = modifier2;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i11 = i7 & 16;
                if (i11 == 0) {
                }
                function27 = function24;
                i12 = i7 & 32;
                if (i12 != 0) {
                }
                if ((i6 & 1572864) == 0) {
                }
                if ((i6 & 12582912) == 0) {
                }
                if ((i6 & 100663296) == 0) {
                }
                if ((i7 & 512) != 0) {
                }
                if ((i8 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i6 & 1) != 0) {
                }
                if (i17 == 0) {
                }
                if (i18 == 0) {
                }
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
                if (i13 == 0) {
                }
                if (i12 == 0) {
                }
                if ((i7 & 64) == 0) {
                }
                if ((i7 & 128) != 0) {
                }
                if ((i7 & 256) != 0) {
                }
                contentWindowInsets = windowInsets;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                i15 = (234881024 & i14) ^ 100663296;
                if (i15 > 67108864) {
                }
                j9 = j7;
                if ((i14 & 100663296) != 67108864) {
                }
                z5 = true;
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z5) {
                }
                rememberedValue = new MutableWindowInsets(contentWindowInsets);
                startRestartGroup.updateRememberedValue(rememberedValue);
                final MutableWindowInsets mutableWindowInsets22222 = (MutableWindowInsets) rememberedValue;
                changed = startRestartGroup.changed(mutableWindowInsets22222) | ((i15 <= 67108864 && startRestartGroup.changed(contentWindowInsets)) || (100663296 & i14) == 67108864);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue2 = new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets32) {
                        invoke2(windowInsets32);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(WindowInsets windowInsets32) {
                        MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(contentWindowInsets, windowInsets32));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                final int i1922222 = m847getEndERTFSPs;
                final Function2<? super Composer, ? super Integer, Unit> function21122222 = m835getLambda1$material3_release;
                final Function2<? super Composer, ? super Integer, Unit> function21222222 = m837getLambda3$material3_release;
                final Function2<? super Composer, ? super Integer, Unit> function21322222 = m838getLambda4$material3_release;
                final Function2<? super Composer, ? super Integer, Unit> function21422222 = m836getLambda2$material3_release;
                int i2022222 = i14 >> 12;
                SurfaceKt.m900SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier2, (Function1) rememberedValue2), null, j8, j9, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

                    public final void invoke(Composer composer2, int i212) {
                        if ((i212 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1979205334, i212, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:105)");
                        }
                        ScaffoldKt.m887ScaffoldLayoutFMILGgc(i1922222, function21122222, function3, function21222222, function21322222, mutableWindowInsets22222, function21422222, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, (i2022222 & 896) | 12582912 | (i2022222 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                }
                j10 = j8;
                function28 = m836getLambda2$material3_release;
                function29 = m837getLambda3$material3_release;
                function210 = m838getLambda4$material3_release;
                windowInsets2 = contentWindowInsets;
                j11 = j9;
                function25 = m835getLambda1$material3_release;
                modifier3 = modifier2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            function26 = function22;
            i10 = i7 & 8;
            if (i10 != 0) {
            }
            i11 = i7 & 16;
            if (i11 == 0) {
            }
            function27 = function24;
            i12 = i7 & 32;
            if (i12 != 0) {
            }
            if ((i6 & 1572864) == 0) {
            }
            if ((i6 & 12582912) == 0) {
            }
            if ((i6 & 100663296) == 0) {
            }
            if ((i7 & 512) != 0) {
            }
            if ((i8 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i6 & 1) != 0) {
            }
            if (i17 == 0) {
            }
            if (i18 == 0) {
            }
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
            if (i13 == 0) {
            }
            if (i12 == 0) {
            }
            if ((i7 & 64) == 0) {
            }
            if ((i7 & 128) != 0) {
            }
            if ((i7 & 256) != 0) {
            }
            contentWindowInsets = windowInsets;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            i15 = (234881024 & i14) ^ 100663296;
            if (i15 > 67108864) {
            }
            j9 = j7;
            if ((i14 & 100663296) != 67108864) {
            }
            z5 = true;
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z5) {
            }
            rememberedValue = new MutableWindowInsets(contentWindowInsets);
            startRestartGroup.updateRememberedValue(rememberedValue);
            final MutableWindowInsets mutableWindowInsets222222 = (MutableWindowInsets) rememberedValue;
            changed = startRestartGroup.changed(mutableWindowInsets222222) | ((i15 <= 67108864 && startRestartGroup.changed(contentWindowInsets)) || (100663296 & i14) == 67108864);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue2 = new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets32) {
                    invoke2(windowInsets32);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(WindowInsets windowInsets32) {
                    MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(contentWindowInsets, windowInsets32));
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            final int i19222222 = m847getEndERTFSPs;
            final Function2<? super Composer, ? super Integer, Unit> function211222222 = m835getLambda1$material3_release;
            final Function2<? super Composer, ? super Integer, Unit> function212222222 = m837getLambda3$material3_release;
            final Function2<? super Composer, ? super Integer, Unit> function213222222 = m838getLambda4$material3_release;
            final Function2<? super Composer, ? super Integer, Unit> function214222222 = m836getLambda2$material3_release;
            int i20222222 = i14 >> 12;
            SurfaceKt.m900SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier2, (Function1) rememberedValue2), null, j8, j9, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

                public final void invoke(Composer composer2, int i212) {
                    if ((i212 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1979205334, i212, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:105)");
                    }
                    ScaffoldKt.m887ScaffoldLayoutFMILGgc(i19222222, function211222222, function3, function212222222, function213222222, mutableWindowInsets222222, function214222222, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i20222222 & 896) | 12582912 | (i20222222 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
            }
            j10 = j8;
            function28 = m836getLambda2$material3_release;
            function29 = m837getLambda3$material3_release;
            function210 = m838getLambda4$material3_release;
            windowInsets2 = contentWindowInsets;
            j11 = j9;
            function25 = m835getLambda1$material3_release;
            modifier3 = modifier2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        function25 = function2;
        i9 = i7 & 4;
        if (i9 == 0) {
        }
        function26 = function22;
        i10 = i7 & 8;
        if (i10 != 0) {
        }
        i11 = i7 & 16;
        if (i11 == 0) {
        }
        function27 = function24;
        i12 = i7 & 32;
        if (i12 != 0) {
        }
        if ((i6 & 1572864) == 0) {
        }
        if ((i6 & 12582912) == 0) {
        }
        if ((i6 & 100663296) == 0) {
        }
        if ((i7 & 512) != 0) {
        }
        if ((i8 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i6 & 1) != 0) {
        }
        if (i17 == 0) {
        }
        if (i18 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (i13 == 0) {
        }
        if (i12 == 0) {
        }
        if ((i7 & 64) == 0) {
        }
        if ((i7 & 128) != 0) {
        }
        if ((i7 & 256) != 0) {
        }
        contentWindowInsets = windowInsets;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        i15 = (234881024 & i14) ^ 100663296;
        if (i15 > 67108864) {
        }
        j9 = j7;
        if ((i14 & 100663296) != 67108864) {
        }
        z5 = true;
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z5) {
        }
        rememberedValue = new MutableWindowInsets(contentWindowInsets);
        startRestartGroup.updateRememberedValue(rememberedValue);
        final MutableWindowInsets mutableWindowInsets2222222 = (MutableWindowInsets) rememberedValue;
        changed = startRestartGroup.changed(mutableWindowInsets2222222) | ((i15 <= 67108864 && startRestartGroup.changed(contentWindowInsets)) || (100663296 & i14) == 67108864);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue2 = new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets32) {
                invoke2(windowInsets32);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WindowInsets windowInsets32) {
                MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(contentWindowInsets, windowInsets32));
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        final int i192222222 = m847getEndERTFSPs;
        final Function2<? super Composer, ? super Integer, Unit> function2112222222 = m835getLambda1$material3_release;
        final Function2<? super Composer, ? super Integer, Unit> function2122222222 = m837getLambda3$material3_release;
        final Function2<? super Composer, ? super Integer, Unit> function2132222222 = m838getLambda4$material3_release;
        final Function2<? super Composer, ? super Integer, Unit> function2142222222 = m836getLambda2$material3_release;
        int i202222222 = i14 >> 12;
        SurfaceKt.m900SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier2, (Function1) rememberedValue2), null, j8, j9, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

            public final void invoke(Composer composer2, int i212) {
                if ((i212 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1979205334, i212, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:105)");
                }
                ScaffoldKt.m887ScaffoldLayoutFMILGgc(i192222222, function2112222222, function3, function2122222222, function2132222222, mutableWindowInsets2222222, function2142222222, composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, (i202222222 & 896) | 12582912 | (i202222222 & 7168), 114);
        if (ComposerKt.isTraceInProgress()) {
        }
        j10 = j8;
        function28 = m836getLambda2$material3_release;
        function29 = m837getLambda3$material3_release;
        function210 = m838getLambda4$material3_release;
        windowInsets2 = contentWindowInsets;
        j11 = j9;
        function25 = m835getLambda1$material3_release;
        modifier3 = modifier2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScaffoldLayout-FMILGgc, reason: not valid java name */
    public static final void m887ScaffoldLayoutFMILGgc(final int i5, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i6) {
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-975511942);
        if ((i6 & 6) == 0) {
            i7 = (startRestartGroup.changed(i5) ? 4 : 2) | i6;
        } else {
            i7 = i6;
        }
        if ((i6 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((196608 & i6) == 0) {
            i7 |= startRestartGroup.changed(windowInsets) ? 131072 : 65536;
        }
        if ((i6 & 1572864) == 0) {
            i7 |= startRestartGroup.changedInstance(function24) ? 1048576 : 524288;
        }
        if ((i7 & 599187) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-975511942, i7, -1, "androidx.compose.material3.ScaffoldLayout (Scaffold.kt:138)");
            }
            boolean z5 = ((i7 & 112) == 32) | ((i7 & 7168) == 2048) | ((458752 & i7) == 131072) | ((57344 & i7) == 16384) | ((i7 & 14) == 4) | ((3670016 & i7) == 1048576) | ((i7 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                i8 = 1;
                rememberedValue = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m889invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m889invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, long j5) {
                        Object obj;
                        Object obj2;
                        Object obj3;
                        FabPlacement fabPlacement;
                        Object obj4;
                        Integer num;
                        float f5;
                        int mo206roundToPx0680j_4;
                        int bottom;
                        float f6;
                        Object obj5;
                        Object obj6;
                        int i9;
                        float f7;
                        float f8;
                        int mo206roundToPx0680j_42;
                        float f9;
                        float f10;
                        final int m2578getMaxWidthimpl = Constraints.m2578getMaxWidthimpl(j5);
                        final int m2577getMaxHeightimpl = Constraints.m2577getMaxHeightimpl(j5);
                        long m2570copyZbe2FdA$default = Constraints.m2570copyZbe2FdA$default(j5, 0, 0, 0, 0, 10, null);
                        List<Measurable> subcompose = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.TopBar, function2);
                        final ArrayList arrayList = new ArrayList(subcompose.size());
                        int size = subcompose.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            arrayList.add(subcompose.get(i10).mo1946measureBRTryo0(m2570copyZbe2FdA$default));
                        }
                        if (arrayList.isEmpty()) {
                            obj = null;
                        } else {
                            obj = arrayList.get(0);
                            int height = ((Placeable) obj).getHeight();
                            int lastIndex = CollectionsKt.getLastIndex(arrayList);
                            if (1 <= lastIndex) {
                                int i11 = 1;
                                while (true) {
                                    Object obj7 = arrayList.get(i11);
                                    int height2 = ((Placeable) obj7).getHeight();
                                    if (height < height2) {
                                        obj = obj7;
                                        height = height2;
                                    }
                                    if (i11 == lastIndex) {
                                        break;
                                    }
                                    i11++;
                                }
                            }
                        }
                        Placeable placeable = (Placeable) obj;
                        final int height3 = placeable != null ? placeable.getHeight() : 0;
                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Snackbar, function22);
                        WindowInsets windowInsets2 = windowInsets;
                        final ArrayList arrayList2 = new ArrayList(subcompose2.size());
                        int size2 = subcompose2.size();
                        for (int i12 = 0; i12 < size2; i12++) {
                            arrayList2.add(subcompose2.get(i12).mo1946measureBRTryo0(ConstraintsKt.m2595offsetNN6EwU(m2570copyZbe2FdA$default, (-windowInsets2.getLeft(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection())) - windowInsets2.getRight(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection()), -windowInsets2.getBottom(subcomposeMeasureScope))));
                        }
                        if (arrayList2.isEmpty()) {
                            obj2 = null;
                        } else {
                            obj2 = arrayList2.get(0);
                            int height4 = ((Placeable) obj2).getHeight();
                            int lastIndex2 = CollectionsKt.getLastIndex(arrayList2);
                            if (1 <= lastIndex2) {
                                Object obj8 = obj2;
                                int i13 = height4;
                                int i14 = 1;
                                while (true) {
                                    Object obj9 = arrayList2.get(i14);
                                    int height5 = ((Placeable) obj9).getHeight();
                                    if (i13 < height5) {
                                        obj8 = obj9;
                                        i13 = height5;
                                    }
                                    if (i14 == lastIndex2) {
                                        break;
                                    }
                                    i14++;
                                }
                                obj2 = obj8;
                            }
                        }
                        Placeable placeable2 = (Placeable) obj2;
                        int height6 = placeable2 != null ? placeable2.getHeight() : 0;
                        if (arrayList2.isEmpty()) {
                            obj3 = null;
                        } else {
                            obj3 = arrayList2.get(0);
                            int width = ((Placeable) obj3).getWidth();
                            int lastIndex3 = CollectionsKt.getLastIndex(arrayList2);
                            if (1 <= lastIndex3) {
                                Object obj10 = obj3;
                                int i15 = width;
                                int i16 = 1;
                                while (true) {
                                    Object obj11 = arrayList2.get(i16);
                                    int width2 = ((Placeable) obj11).getWidth();
                                    if (i15 < width2) {
                                        obj10 = obj11;
                                        i15 = width2;
                                    }
                                    if (i16 == lastIndex3) {
                                        break;
                                    }
                                    i16++;
                                }
                                obj3 = obj10;
                            }
                        }
                        Placeable placeable3 = (Placeable) obj3;
                        int width3 = placeable3 != null ? placeable3.getWidth() : 0;
                        List<Measurable> subcompose3 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Fab, function23);
                        WindowInsets windowInsets3 = windowInsets;
                        final ArrayList arrayList3 = new ArrayList(subcompose3.size());
                        int size3 = subcompose3.size();
                        int i17 = 0;
                        while (i17 < size3) {
                            List<Measurable> list = subcompose3;
                            int i18 = size3;
                            WindowInsets windowInsets4 = windowInsets3;
                            Placeable mo1946measureBRTryo0 = subcompose3.get(i17).mo1946measureBRTryo0(ConstraintsKt.m2595offsetNN6EwU(m2570copyZbe2FdA$default, (-windowInsets3.getLeft(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection())) - windowInsets3.getRight(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection()), -windowInsets3.getBottom(subcomposeMeasureScope)));
                            if (mo1946measureBRTryo0.getHeight() == 0 || mo1946measureBRTryo0.getWidth() == 0) {
                                mo1946measureBRTryo0 = null;
                            }
                            if (mo1946measureBRTryo0 != null) {
                                arrayList3.add(mo1946measureBRTryo0);
                            }
                            i17++;
                            windowInsets3 = windowInsets4;
                            subcompose3 = list;
                            size3 = i18;
                        }
                        if (arrayList3.isEmpty()) {
                            fabPlacement = null;
                        } else {
                            if (arrayList3.isEmpty()) {
                                obj5 = null;
                            } else {
                                obj5 = arrayList3.get(0);
                                int width4 = ((Placeable) obj5).getWidth();
                                int lastIndex4 = CollectionsKt.getLastIndex(arrayList3);
                                if (1 <= lastIndex4) {
                                    Object obj12 = obj5;
                                    int i19 = width4;
                                    int i20 = 1;
                                    while (true) {
                                        Object obj13 = arrayList3.get(i20);
                                        int width5 = ((Placeable) obj13).getWidth();
                                        if (i19 < width5) {
                                            obj12 = obj13;
                                            i19 = width5;
                                        }
                                        if (i20 == lastIndex4) {
                                            break;
                                        }
                                        i20++;
                                    }
                                    obj5 = obj12;
                                }
                            }
                            Intrinsics.checkNotNull(obj5);
                            int width6 = ((Placeable) obj5).getWidth();
                            if (arrayList3.isEmpty()) {
                                obj6 = null;
                            } else {
                                obj6 = arrayList3.get(0);
                                int height7 = ((Placeable) obj6).getHeight();
                                int lastIndex5 = CollectionsKt.getLastIndex(arrayList3);
                                if (1 <= lastIndex5) {
                                    Object obj14 = obj6;
                                    int i21 = height7;
                                    int i22 = 1;
                                    while (true) {
                                        Object obj15 = arrayList3.get(i22);
                                        Object obj16 = obj14;
                                        int height8 = ((Placeable) obj15).getHeight();
                                        if (i21 < height8) {
                                            i21 = height8;
                                            obj14 = obj15;
                                        } else {
                                            obj14 = obj16;
                                        }
                                        if (i22 == lastIndex5) {
                                            break;
                                        }
                                        i22++;
                                    }
                                    obj6 = obj14;
                                }
                            }
                            Intrinsics.checkNotNull(obj6);
                            int height9 = ((Placeable) obj6).getHeight();
                            int i23 = i5;
                            FabPosition.Companion companion = FabPosition.INSTANCE;
                            if (!FabPosition.m846equalsimpl0(i23, companion.m849getStartERTFSPs())) {
                                if (!(FabPosition.m846equalsimpl0(i23, companion.m847getEndERTFSPs()) ? true : FabPosition.m846equalsimpl0(i23, companion.m848getEndOverlayERTFSPs()))) {
                                    i9 = (m2578getMaxWidthimpl - width6) / 2;
                                } else if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                                    f8 = ScaffoldKt.FabSpacing;
                                    mo206roundToPx0680j_42 = subcomposeMeasureScope.mo206roundToPx0680j_4(f8);
                                    i9 = (m2578getMaxWidthimpl - mo206roundToPx0680j_42) - width6;
                                } else {
                                    f7 = ScaffoldKt.FabSpacing;
                                    i9 = subcomposeMeasureScope.mo206roundToPx0680j_4(f7);
                                }
                                fabPlacement = new FabPlacement(i9, width6, height9);
                            } else if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                                f10 = ScaffoldKt.FabSpacing;
                                i9 = subcomposeMeasureScope.mo206roundToPx0680j_4(f10);
                                fabPlacement = new FabPlacement(i9, width6, height9);
                            } else {
                                f9 = ScaffoldKt.FabSpacing;
                                mo206roundToPx0680j_42 = subcomposeMeasureScope.mo206roundToPx0680j_4(f9);
                                i9 = (m2578getMaxWidthimpl - mo206roundToPx0680j_42) - width6;
                                fabPlacement = new FabPlacement(i9, width6, height9);
                            }
                        }
                        ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                        final Function2<Composer, Integer, Unit> function25 = function24;
                        List<Measurable> subcompose4 = subcomposeMeasureScope.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(-2146438447, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1$bottomBarPlaceables$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num2) {
                                invoke(composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i24) {
                                if ((i24 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2146438447, i24, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:209)");
                                }
                                function25.invoke(composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        final ArrayList arrayList4 = new ArrayList(subcompose4.size());
                        int size4 = subcompose4.size();
                        for (int i24 = 0; i24 < size4; i24++) {
                            arrayList4.add(subcompose4.get(i24).mo1946measureBRTryo0(m2570copyZbe2FdA$default));
                        }
                        if (arrayList4.isEmpty()) {
                            obj4 = null;
                        } else {
                            obj4 = arrayList4.get(0);
                            int height10 = ((Placeable) obj4).getHeight();
                            int lastIndex6 = CollectionsKt.getLastIndex(arrayList4);
                            if (1 <= lastIndex6) {
                                int i25 = 1;
                                while (true) {
                                    Object obj17 = arrayList4.get(i25);
                                    int height11 = ((Placeable) obj17).getHeight();
                                    if (height10 < height11) {
                                        height10 = height11;
                                        obj4 = obj17;
                                    }
                                    if (i25 == lastIndex6) {
                                        break;
                                    }
                                    i25++;
                                }
                            }
                        }
                        Placeable placeable4 = (Placeable) obj4;
                        Integer valueOf = placeable4 != null ? Integer.valueOf(placeable4.getHeight()) : null;
                        if (fabPlacement != null) {
                            int i26 = i5;
                            WindowInsets windowInsets5 = windowInsets;
                            if (valueOf == null || FabPosition.m846equalsimpl0(i26, FabPosition.INSTANCE.m848getEndOverlayERTFSPs())) {
                                int height12 = fabPlacement.getHeight();
                                f5 = ScaffoldKt.FabSpacing;
                                mo206roundToPx0680j_4 = height12 + subcomposeMeasureScope.mo206roundToPx0680j_4(f5);
                                bottom = windowInsets5.getBottom(subcomposeMeasureScope);
                            } else {
                                mo206roundToPx0680j_4 = valueOf.intValue() + fabPlacement.getHeight();
                                f6 = ScaffoldKt.FabSpacing;
                                bottom = subcomposeMeasureScope.mo206roundToPx0680j_4(f6);
                            }
                            num = Integer.valueOf(mo206roundToPx0680j_4 + bottom);
                        } else {
                            num = null;
                        }
                        int intValue = height6 != 0 ? height6 + (num != null ? num.intValue() : valueOf != null ? valueOf.intValue() : windowInsets.getBottom(subcomposeMeasureScope)) : 0;
                        ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                        final WindowInsets windowInsets6 = windowInsets;
                        final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
                        final int i27 = width3;
                        final Integer num2 = valueOf;
                        List<Measurable> subcompose5 = subcomposeMeasureScope.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(-1213360416, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1$bodyContentPlaceables$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num3) {
                                invoke(composer2, num3.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i28) {
                                float mo209toDpu2uoSUM;
                                float bottom2;
                                Integer num3;
                                if ((i28 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1213360416, i28, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:238)");
                                }
                                PaddingValues asPaddingValues = WindowInsetsKt.asPaddingValues(WindowInsets.this, subcomposeMeasureScope);
                                if (arrayList.isEmpty()) {
                                    mo209toDpu2uoSUM = asPaddingValues.getTop();
                                } else {
                                    mo209toDpu2uoSUM = subcomposeMeasureScope.mo209toDpu2uoSUM(height3);
                                }
                                if (!arrayList4.isEmpty() && (num3 = num2) != null) {
                                    bottom2 = subcomposeMeasureScope.mo209toDpu2uoSUM(num3.intValue());
                                } else {
                                    bottom2 = asPaddingValues.getBottom();
                                }
                                function32.invoke(PaddingKt.m309PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(asPaddingValues, subcomposeMeasureScope.getLayoutDirection()), mo209toDpu2uoSUM, PaddingKt.calculateEndPadding(asPaddingValues, subcomposeMeasureScope.getLayoutDirection()), bottom2), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        final ArrayList arrayList5 = new ArrayList(subcompose5.size());
                        int size5 = subcompose5.size();
                        for (int i28 = 0; i28 < size5; i28++) {
                            arrayList5.add(subcompose5.get(i28).mo1946measureBRTryo0(m2570copyZbe2FdA$default));
                        }
                        final WindowInsets windowInsets7 = windowInsets;
                        final FabPlacement fabPlacement2 = fabPlacement;
                        final int i29 = intValue;
                        final Integer num3 = valueOf;
                        final Integer num4 = num;
                        return MeasureScope.layout$default(subcomposeMeasureScope, m2578getMaxWidthimpl, m2577getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                List<Placeable> list2 = arrayList5;
                                int size6 = list2.size();
                                for (int i30 = 0; i30 < size6; i30++) {
                                    Placeable.PlacementScope.place$default(placementScope, list2.get(i30), 0, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list3 = arrayList;
                                int size7 = list3.size();
                                for (int i31 = 0; i31 < size7; i31++) {
                                    Placeable.PlacementScope.place$default(placementScope, list3.get(i31), 0, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list4 = arrayList2;
                                int i32 = m2578getMaxWidthimpl;
                                int i33 = i27;
                                WindowInsets windowInsets8 = windowInsets7;
                                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                int i34 = m2577getMaxHeightimpl;
                                int i35 = i29;
                                int size8 = list4.size();
                                for (int i36 = 0; i36 < size8; i36++) {
                                    Placeable.PlacementScope.place$default(placementScope, list4.get(i36), ((i32 - i33) / 2) + windowInsets8.getLeft(subcomposeMeasureScope2, subcomposeMeasureScope2.getLayoutDirection()), i34 - i35, 0.0f, 4, null);
                                }
                                List<Placeable> list5 = arrayList4;
                                int i37 = m2577getMaxHeightimpl;
                                Integer num5 = num3;
                                int size9 = list5.size();
                                for (int i38 = 0; i38 < size9; i38++) {
                                    Placeable.PlacementScope.place$default(placementScope, list5.get(i38), 0, i37 - (num5 != null ? num5.intValue() : 0), 0.0f, 4, null);
                                }
                                FabPlacement fabPlacement3 = fabPlacement2;
                                if (fabPlacement3 != null) {
                                    List<Placeable> list6 = arrayList3;
                                    int i39 = m2577getMaxHeightimpl;
                                    Integer num6 = num4;
                                    int size10 = list6.size();
                                    for (int i40 = 0; i40 < size10; i40++) {
                                        Placeable placeable5 = list6.get(i40);
                                        int left = fabPlacement3.getLeft();
                                        Intrinsics.checkNotNull(num6);
                                        Placeable.PlacementScope.place$default(placementScope, placeable5, left, i39 - num6.intValue(), 0.0f, 4, null);
                                    }
                                }
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            } else {
                i8 = 1;
            }
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) rememberedValue, startRestartGroup, 0, i8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$2
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

                public final void invoke(Composer composer2, int i9) {
                    ScaffoldKt.m887ScaffoldLayoutFMILGgc(i5, function2, function3, function22, function23, windowInsets, function24, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
                }
            });
        }
    }
}
