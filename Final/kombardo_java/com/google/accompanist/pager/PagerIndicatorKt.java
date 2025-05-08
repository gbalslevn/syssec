package com.google.accompanist.pager;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ContentAlpha;
import androidx.compose.material.ContentAlphaKt;
import androidx.compose.material.ContentColorKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a~\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a~\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0003ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/pager/PagerState;", "pagerState", BuildConfig.FLAVOR, "pageCount", "Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function1;", "pageIndexMapping", "Landroidx/compose/ui/graphics/Color;", "activeColor", "inactiveColor", "Landroidx/compose/ui/unit/Dp;", "indicatorWidth", "indicatorHeight", "spacing", "Landroidx/compose/ui/graphics/Shape;", "indicatorShape", BuildConfig.FLAVOR, "HorizontalPagerIndicator-K_mkGiw", "(Landroidx/compose/foundation/pager/PagerState;ILandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;JJFFFLandroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "HorizontalPagerIndicator", "Lcom/google/accompanist/pager/PagerStateBridge;", "(Lcom/google/accompanist/pager/PagerStateBridge;ILandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;JJFFFLandroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "pager-indicators_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PagerIndicatorKt {
    /* JADX WARN: Removed duplicated region for block: B:103:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x024f  */
    @Deprecated
    /* renamed from: HorizontalPagerIndicator-K_mkGiw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2902HorizontalPagerIndicatorK_mkGiw(final PagerState pagerState, final int i5, Modifier modifier, Function1<? super Integer, Integer> function1, long j5, long j6, float f5, float f6, float f7, Shape shape, Composer composer, final int i6, final int i7) {
        int i8;
        int i9;
        Modifier modifier2;
        int i10;
        Function1<? super Integer, Integer> function12;
        long j7;
        int i11;
        float f8;
        long j8;
        float f9;
        int i12;
        float f10;
        Shape shape2;
        float f11;
        int i13;
        long j9;
        float f12;
        float f13;
        boolean z5;
        Object rememberedValue;
        final Shape shape3;
        final float f14;
        final float f15;
        final float f16;
        final long j10;
        final Modifier modifier3;
        final long j11;
        final Function1<? super Integer, Integer> function13;
        ScopeUpdateScope endRestartGroup;
        int i14;
        int i15;
        int i16;
        int i17;
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Composer startRestartGroup = composer.startRestartGroup(870455235);
        if ((i7 & 1) != 0) {
            i8 = i6 | 6;
        } else if ((i6 & 14) == 0) {
            i8 = (startRestartGroup.changed(pagerState) ? 4 : 2) | i6;
        } else {
            i8 = i6;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i6 & 112) == 0) {
            i8 |= startRestartGroup.changed(i5) ? 32 : 16;
            i9 = i7 & 4;
            if (i9 == 0) {
                i8 |= 384;
            } else if ((i6 & 896) == 0) {
                modifier2 = modifier;
                i8 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i10 = i7 & 8;
                if (i10 != 0) {
                    i8 |= 3072;
                } else if ((i6 & 7168) == 0) {
                    function12 = function1;
                    i8 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    if ((57344 & i6) != 0) {
                        if ((i7 & 16) == 0) {
                            j7 = j5;
                            if (startRestartGroup.changed(j7)) {
                                i17 = 16384;
                                i8 |= i17;
                            }
                        } else {
                            j7 = j5;
                        }
                        i17 = 8192;
                        i8 |= i17;
                    } else {
                        j7 = j5;
                    }
                    if ((458752 & i6) == 0) {
                        i8 |= ((i7 & 32) == 0 && startRestartGroup.changed(j6)) ? 131072 : 65536;
                    }
                    i11 = i7 & 64;
                    if (i11 == 0) {
                        i8 |= 1572864;
                    } else if ((3670016 & i6) == 0) {
                        f8 = f5;
                        i8 |= startRestartGroup.changed(f8) ? 1048576 : 524288;
                        if ((i6 & 29360128) == 0) {
                            if ((i7 & 128) == 0 && startRestartGroup.changed(f6)) {
                                i16 = 8388608;
                                i8 |= i16;
                            }
                            i16 = 4194304;
                            i8 |= i16;
                        }
                        if ((i6 & 234881024) == 0) {
                            if ((i7 & 256) == 0 && startRestartGroup.changed(f7)) {
                                i15 = 67108864;
                                i8 |= i15;
                            }
                            i15 = 33554432;
                            i8 |= i15;
                        }
                        if ((i6 & 1879048192) == 0) {
                            if ((i7 & 512) == 0 && startRestartGroup.changed(shape)) {
                                i14 = 536870912;
                                i8 |= i14;
                            }
                            i14 = 268435456;
                            i8 |= i14;
                        }
                        if ((i8 & 1533916891) != 306783378 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            shape3 = shape;
                            modifier3 = modifier2;
                            function13 = function12;
                            j10 = j7;
                            f14 = f8;
                            j11 = j6;
                            f15 = f6;
                            f16 = f7;
                        } else {
                            startRestartGroup.startDefaults();
                            if ((i6 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i9 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i10 != 0) {
                                    function12 = new Function1<Integer, Integer>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$3
                                        public final Integer invoke(int i18) {
                                            return Integer.valueOf(i18);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                                            return invoke(num.intValue());
                                        }
                                    };
                                }
                                if ((i7 & 16) != 0) {
                                    j7 = Color.m1485copywmQWz5c$default(((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).getValue(), ((Number) startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                                    i8 &= -57345;
                                }
                                if ((i7 & 32) != 0) {
                                    j8 = Color.m1485copywmQWz5c$default(j7, ContentAlpha.INSTANCE.getDisabled(startRestartGroup, ContentAlpha.$stable), 0.0f, 0.0f, 0.0f, 14, null);
                                    i8 &= -458753;
                                } else {
                                    j8 = j6;
                                }
                                if (i11 != 0) {
                                    f8 = Dp.m2599constructorimpl(8);
                                }
                                if ((i7 & 128) != 0) {
                                    i8 &= -29360129;
                                    f9 = f8;
                                } else {
                                    f9 = f6;
                                }
                                if ((i7 & 256) != 0) {
                                    i12 = i8 & (-234881025);
                                    f10 = f8;
                                } else {
                                    i12 = i8;
                                    f10 = f7;
                                }
                                if ((i7 & 512) != 0) {
                                    int i18 = (-1879048193) & i12;
                                    f12 = f9;
                                    i13 = i18;
                                    shape2 = RoundedCornerShapeKt.getCircleShape();
                                    f13 = f8;
                                    f11 = f10;
                                    j9 = j8;
                                } else {
                                    shape2 = shape;
                                    f11 = f10;
                                    i13 = i12;
                                    j9 = j8;
                                    f12 = f9;
                                    f13 = f8;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i7 & 16) != 0) {
                                    i8 &= -57345;
                                }
                                if ((i7 & 32) != 0) {
                                    i8 &= -458753;
                                }
                                if ((i7 & 128) != 0) {
                                    i8 &= -29360129;
                                }
                                if ((i7 & 256) != 0) {
                                    i8 &= -234881025;
                                }
                                if ((i7 & 512) != 0) {
                                    i8 &= -1879048193;
                                }
                                f12 = f6;
                                f11 = f7;
                                shape2 = shape;
                                i13 = i8;
                                f13 = f8;
                                j9 = j6;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(870455235, i13, -1, "com.google.accompanist.pager.HorizontalPagerIndicator (PagerIndicator.kt:158)");
                            }
                            startRestartGroup.startReplaceableGroup(-1521403359);
                            z5 = (i13 & 14) == 4;
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new PagerStateBridge() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$stateBridge$2$1
                                    @Override // com.google.accompanist.pager.PagerStateBridge
                                    public int getCurrentPage() {
                                        return PagerState.this.getCurrentPage();
                                    }

                                    @Override // com.google.accompanist.pager.PagerStateBridge
                                    public float getCurrentPageOffset() {
                                        return PagerState.this.getCurrentPageOffsetFraction();
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            m2903HorizontalPagerIndicatorK_mkGiw((PagerIndicatorKt$HorizontalPagerIndicator$stateBridge$2$1) rememberedValue, i5, modifier2, function12, j7, j9, f13, f12, f11, shape2, startRestartGroup, i13 & 2147483632, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape3 = shape2;
                            Function1<? super Integer, Integer> function14 = function12;
                            f14 = f13;
                            long j12 = j7;
                            f15 = f12;
                            f16 = f11;
                            j10 = j12;
                            long j13 = j9;
                            modifier3 = modifier2;
                            j11 = j13;
                            function13 = function14;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$4
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

                                public final void invoke(Composer composer2, int i19) {
                                    PagerIndicatorKt.m2902HorizontalPagerIndicatorK_mkGiw(PagerState.this, i5, modifier3, function13, j10, j11, f14, f15, f16, shape3, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    f8 = f5;
                    if ((i6 & 29360128) == 0) {
                    }
                    if ((i6 & 234881024) == 0) {
                    }
                    if ((i6 & 1879048192) == 0) {
                    }
                    if ((i8 & 1533916891) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i6 & 1) != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i7 & 16) != 0) {
                    }
                    if ((i7 & 32) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if ((i7 & 128) != 0) {
                    }
                    if ((i7 & 256) != 0) {
                    }
                    if ((i7 & 512) != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(-1521403359);
                    if ((i13 & 14) == 4) {
                    }
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z5) {
                    }
                    rememberedValue = new PagerStateBridge() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$stateBridge$2$1
                        @Override // com.google.accompanist.pager.PagerStateBridge
                        public int getCurrentPage() {
                            return PagerState.this.getCurrentPage();
                        }

                        @Override // com.google.accompanist.pager.PagerStateBridge
                        public float getCurrentPageOffset() {
                            return PagerState.this.getCurrentPageOffsetFraction();
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    m2903HorizontalPagerIndicatorK_mkGiw((PagerIndicatorKt$HorizontalPagerIndicator$stateBridge$2$1) rememberedValue, i5, modifier2, function12, j7, j9, f13, f12, f11, shape2, startRestartGroup, i13 & 2147483632, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    shape3 = shape2;
                    Function1<? super Integer, Integer> function142 = function12;
                    f14 = f13;
                    long j122 = j7;
                    f15 = f12;
                    f16 = f11;
                    j10 = j122;
                    long j132 = j9;
                    modifier3 = modifier2;
                    j11 = j132;
                    function13 = function142;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function12 = function1;
                if ((57344 & i6) != 0) {
                }
                if ((458752 & i6) == 0) {
                }
                i11 = i7 & 64;
                if (i11 == 0) {
                }
                f8 = f5;
                if ((i6 & 29360128) == 0) {
                }
                if ((i6 & 234881024) == 0) {
                }
                if ((i6 & 1879048192) == 0) {
                }
                if ((i8 & 1533916891) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i6 & 1) != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if ((i7 & 16) != 0) {
                }
                if ((i7 & 32) != 0) {
                }
                if (i11 != 0) {
                }
                if ((i7 & 128) != 0) {
                }
                if ((i7 & 256) != 0) {
                }
                if ((i7 & 512) != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-1521403359);
                if ((i13 & 14) == 4) {
                }
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z5) {
                }
                rememberedValue = new PagerStateBridge() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$stateBridge$2$1
                    @Override // com.google.accompanist.pager.PagerStateBridge
                    public int getCurrentPage() {
                        return PagerState.this.getCurrentPage();
                    }

                    @Override // com.google.accompanist.pager.PagerStateBridge
                    public float getCurrentPageOffset() {
                        return PagerState.this.getCurrentPageOffsetFraction();
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                m2903HorizontalPagerIndicatorK_mkGiw((PagerIndicatorKt$HorizontalPagerIndicator$stateBridge$2$1) rememberedValue, i5, modifier2, function12, j7, j9, f13, f12, f11, shape2, startRestartGroup, i13 & 2147483632, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                shape3 = shape2;
                Function1<? super Integer, Integer> function1422 = function12;
                f14 = f13;
                long j1222 = j7;
                f15 = f12;
                f16 = f11;
                j10 = j1222;
                long j1322 = j9;
                modifier3 = modifier2;
                j11 = j1322;
                function13 = function1422;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i10 = i7 & 8;
            if (i10 != 0) {
            }
            function12 = function1;
            if ((57344 & i6) != 0) {
            }
            if ((458752 & i6) == 0) {
            }
            i11 = i7 & 64;
            if (i11 == 0) {
            }
            f8 = f5;
            if ((i6 & 29360128) == 0) {
            }
            if ((i6 & 234881024) == 0) {
            }
            if ((i6 & 1879048192) == 0) {
            }
            if ((i8 & 1533916891) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i6 & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if ((i7 & 16) != 0) {
            }
            if ((i7 & 32) != 0) {
            }
            if (i11 != 0) {
            }
            if ((i7 & 128) != 0) {
            }
            if ((i7 & 256) != 0) {
            }
            if ((i7 & 512) != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-1521403359);
            if ((i13 & 14) == 4) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z5) {
            }
            rememberedValue = new PagerStateBridge() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$stateBridge$2$1
                @Override // com.google.accompanist.pager.PagerStateBridge
                public int getCurrentPage() {
                    return PagerState.this.getCurrentPage();
                }

                @Override // com.google.accompanist.pager.PagerStateBridge
                public float getCurrentPageOffset() {
                    return PagerState.this.getCurrentPageOffsetFraction();
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            m2903HorizontalPagerIndicatorK_mkGiw((PagerIndicatorKt$HorizontalPagerIndicator$stateBridge$2$1) rememberedValue, i5, modifier2, function12, j7, j9, f13, f12, f11, shape2, startRestartGroup, i13 & 2147483632, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            shape3 = shape2;
            Function1<? super Integer, Integer> function14222 = function12;
            f14 = f13;
            long j12222 = j7;
            f15 = f12;
            f16 = f11;
            j10 = j12222;
            long j13222 = j9;
            modifier3 = modifier2;
            j11 = j13222;
            function13 = function14222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i9 = i7 & 4;
        if (i9 == 0) {
        }
        modifier2 = modifier;
        i10 = i7 & 8;
        if (i10 != 0) {
        }
        function12 = function1;
        if ((57344 & i6) != 0) {
        }
        if ((458752 & i6) == 0) {
        }
        i11 = i7 & 64;
        if (i11 == 0) {
        }
        f8 = f5;
        if ((i6 & 29360128) == 0) {
        }
        if ((i6 & 234881024) == 0) {
        }
        if ((i6 & 1879048192) == 0) {
        }
        if ((i8 & 1533916891) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i6 & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if ((i7 & 16) != 0) {
        }
        if ((i7 & 32) != 0) {
        }
        if (i11 != 0) {
        }
        if ((i7 & 128) != 0) {
        }
        if ((i7 & 256) != 0) {
        }
        if ((i7 & 512) != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-1521403359);
        if ((i13 & 14) == 4) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z5) {
        }
        rememberedValue = new PagerStateBridge() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$stateBridge$2$1
            @Override // com.google.accompanist.pager.PagerStateBridge
            public int getCurrentPage() {
                return PagerState.this.getCurrentPage();
            }

            @Override // com.google.accompanist.pager.PagerStateBridge
            public float getCurrentPageOffset() {
                return PagerState.this.getCurrentPageOffsetFraction();
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        m2903HorizontalPagerIndicatorK_mkGiw((PagerIndicatorKt$HorizontalPagerIndicator$stateBridge$2$1) rememberedValue, i5, modifier2, function12, j7, j9, f13, f12, f11, shape2, startRestartGroup, i13 & 2147483632, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        shape3 = shape2;
        Function1<? super Integer, Integer> function142222 = function12;
        f14 = f13;
        long j122222 = j7;
        f15 = f12;
        f16 = f11;
        j10 = j122222;
        long j132222 = j9;
        modifier3 = modifier2;
        j11 = j132222;
        function13 = function142222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x036e A[LOOP:0: B:113:0x036c->B:114:0x036e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0296  */
    /* renamed from: HorizontalPagerIndicator-K_mkGiw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2903HorizontalPagerIndicatorK_mkGiw(final PagerStateBridge pagerStateBridge, final int i5, Modifier modifier, Function1<? super Integer, Integer> function1, long j5, long j6, float f5, float f6, float f7, Shape shape, Composer composer, final int i6, final int i7) {
        int i8;
        Modifier modifier2;
        int i9;
        long j7;
        int i10;
        float f8;
        float f9;
        Shape shape2;
        Function1<? super Integer, Integer> function12;
        long j8;
        float m2599constructorimpl;
        float f10;
        int i11;
        Shape shape3;
        float f11;
        long j9;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        int i12;
        long j10;
        final Function1<? super Integer, Integer> function13;
        float f12;
        final long j11;
        Shape shape4;
        float f13;
        final long j12;
        final float f14;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i13;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(-1605247238);
        if ((i7 & 1) != 0) {
            i8 = i6 | 6;
        } else if ((i6 & 14) == 0) {
            i8 = (startRestartGroup.changed(pagerStateBridge) ? 4 : 2) | i6;
        } else {
            i8 = i6;
        }
        if ((2 & i7) != 0) {
            i8 |= 48;
        } else if ((i6 & 112) == 0) {
            i8 |= startRestartGroup.changed(i5) ? 32 : 16;
        }
        int i16 = i7 & 4;
        if (i16 != 0) {
            i8 |= 384;
        } else if ((i6 & 896) == 0) {
            modifier2 = modifier;
            i8 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i9 = i7 & 8;
            if (i9 == 0) {
                i8 |= 3072;
            } else if ((i6 & 7168) == 0) {
                i8 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
                if ((i6 & 57344) == 0) {
                    i8 |= ((i7 & 16) == 0 && startRestartGroup.changed(j5)) ? 16384 : 8192;
                }
                if ((i6 & 458752) == 0) {
                    j7 = j6;
                    i8 |= ((i7 & 32) == 0 && startRestartGroup.changed(j7)) ? 131072 : 65536;
                } else {
                    j7 = j6;
                }
                i10 = i7 & 64;
                if (i10 != 0) {
                    i8 |= 1572864;
                    f8 = f5;
                } else {
                    f8 = f5;
                    if ((i6 & 3670016) == 0) {
                        i8 |= startRestartGroup.changed(f8) ? 1048576 : 524288;
                    }
                }
                if ((i6 & 29360128) == 0) {
                    if ((i7 & 128) == 0) {
                        f9 = f6;
                        if (startRestartGroup.changed(f9)) {
                            i15 = 8388608;
                            i8 |= i15;
                        }
                    } else {
                        f9 = f6;
                    }
                    i15 = 4194304;
                    i8 |= i15;
                } else {
                    f9 = f6;
                }
                if ((i6 & 234881024) == 0) {
                    if ((i7 & 256) == 0 && startRestartGroup.changed(f7)) {
                        i14 = 67108864;
                        i8 |= i14;
                    }
                    i14 = 33554432;
                    i8 |= i14;
                }
                if ((1879048192 & i6) == 0) {
                    if ((i7 & 512) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i13 = 536870912;
                            i8 |= i13;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i13 = 268435456;
                    i8 |= i13;
                } else {
                    shape2 = shape;
                }
                if ((1533916891 & i8) != 306783378 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    f13 = f7;
                    shape4 = shape2;
                    modifier3 = modifier2;
                    f12 = f9;
                    function13 = function1;
                    j11 = j5;
                    f14 = f8;
                    j12 = j7;
                } else {
                    startRestartGroup.startDefaults();
                    if ((i6 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                        startRestartGroup.skipToGroupEnd();
                        if ((16 & i7) != 0) {
                            i8 &= -57345;
                        }
                        if ((32 & i7) != 0) {
                            i8 &= -458753;
                        }
                        if ((128 & i7) != 0) {
                            i8 &= -29360129;
                        }
                        if ((256 & i7) != 0) {
                            i8 &= -234881025;
                        }
                        if ((i7 & 512) != 0) {
                            i8 &= -1879048193;
                        }
                        function12 = function1;
                        m2599constructorimpl = f8;
                        i11 = i8;
                        f10 = f7;
                        shape3 = shape2;
                        f11 = f9;
                        j9 = j5;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        function12 = i9 != 0 ? new Function1<Integer, Integer>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$5
                            public final Integer invoke(int i17) {
                                return Integer.valueOf(i17);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                                return invoke(num.intValue());
                            }
                        } : function1;
                        if ((16 & i7) != 0) {
                            j8 = Color.m1485copywmQWz5c$default(((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).getValue(), ((Number) startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -57345;
                        } else {
                            j8 = j5;
                        }
                        if ((32 & i7) != 0) {
                            j7 = Color.m1485copywmQWz5c$default(j8, ContentAlpha.INSTANCE.getDisabled(startRestartGroup, ContentAlpha.$stable), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -458753;
                        }
                        m2599constructorimpl = i10 != 0 ? Dp.m2599constructorimpl(8) : f8;
                        if ((128 & i7) != 0) {
                            i8 &= -29360129;
                            f9 = m2599constructorimpl;
                        }
                        if ((256 & i7) != 0) {
                            i8 &= -234881025;
                            f10 = m2599constructorimpl;
                        } else {
                            f10 = f7;
                        }
                        if ((i7 & 512) != 0) {
                            shape2 = RoundedCornerShapeKt.getCircleShape();
                            i8 &= -1879048193;
                        }
                        i11 = i8;
                        shape3 = shape2;
                        f11 = f9;
                        j9 = j8;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1605247238, i11, -1, "com.google.accompanist.pager.HorizontalPagerIndicator (PagerIndicator.kt:194)");
                    }
                    final int mo206roundToPx0680j_4 = ((Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo206roundToPx0680j_4(m2599constructorimpl);
                    final int mo206roundToPx0680j_42 = ((Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo206roundToPx0680j_4(f10);
                    Alignment.Companion companion = Alignment.INSTANCE;
                    long j13 = j9;
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenterStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    Modifier modifier4 = modifier2;
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
                    Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = Arrangement.INSTANCE.m265spacedBy0680j_4(f10);
                    Alignment.Vertical centerVertically = companion.getCenterVertically();
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m265spacedBy0680j_4, centerVertically, startRestartGroup, 48);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion3);
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
                    m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                    if (!m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion2.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    Modifier m103backgroundbw27NRU = BackgroundKt.m103backgroundbw27NRU(SizeKt.m333sizeVpY3zN4(companion3, m2599constructorimpl, f11), j7, shape3);
                    startRestartGroup.startReplaceableGroup(-29719881);
                    for (i12 = 0; i12 < i5; i12++) {
                        BoxKt.Box(m103backgroundbw27NRU, startRestartGroup, 0);
                    }
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    Modifier modifier5 = Modifier.INSTANCE;
                    final Function1<? super Integer, Integer> function14 = function12;
                    Modifier m333sizeVpY3zN4 = SizeKt.m333sizeVpY3zN4(OffsetKt.offset(modifier5, new Function1<Density, IntOffset>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$6$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                            return IntOffset.m2632boximpl(m2905invokeBjo55l4(density));
                        }

                        /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                        public final long m2905invokeBjo55l4(Density offset) {
                            Intrinsics.checkNotNullParameter(offset, "$this$offset");
                            return IntOffsetKt.IntOffset((int) ((mo206roundToPx0680j_42 + mo206roundToPx0680j_4) * RangesKt.coerceIn(((function14.invoke(Integer.valueOf(pagerStateBridge.getCurrentPage() + ((int) Math.signum(r0)))).intValue() - r5) * Math.abs(pagerStateBridge.getCurrentPageOffset())) + function14.invoke(Integer.valueOf(pagerStateBridge.getCurrentPage())).intValue(), 0.0f, RangesKt.coerceAtLeast(i5 - 1, 0))), 0);
                        }
                    }), m2599constructorimpl, f11);
                    if (i5 > 0) {
                        j10 = j13;
                        modifier5 = BackgroundKt.m103backgroundbw27NRU(modifier5, j10, shape3);
                    } else {
                        j10 = j13;
                    }
                    BoxKt.Box(m333sizeVpY3zN4.then(modifier5), startRestartGroup, 0);
                    startRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function13 = function12;
                    f12 = f11;
                    j11 = j10;
                    shape4 = shape3;
                    f13 = f10;
                    j12 = j7;
                    f14 = m2599constructorimpl;
                    modifier3 = modifier4;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final float f15 = f12;
                    final float f16 = f13;
                    final Shape shape5 = shape4;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$7
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

                        public final void invoke(Composer composer2, int i17) {
                            PagerIndicatorKt.m2903HorizontalPagerIndicatorK_mkGiw(PagerStateBridge.this, i5, modifier3, (Function1<? super Integer, Integer>) function13, j11, j12, f14, f15, f16, shape5, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
                        }
                    });
                    return;
                }
                return;
            }
            if ((i6 & 57344) == 0) {
            }
            if ((i6 & 458752) == 0) {
            }
            i10 = i7 & 64;
            if (i10 != 0) {
            }
            if ((i6 & 29360128) == 0) {
            }
            if ((i6 & 234881024) == 0) {
            }
            if ((1879048192 & i6) == 0) {
            }
            if ((1533916891 & i8) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i6 & 1) == 0) {
            }
            if (i16 != 0) {
            }
            if (i9 != 0) {
            }
            if ((16 & i7) != 0) {
            }
            if ((32 & i7) != 0) {
            }
            if (i10 != 0) {
            }
            if ((128 & i7) != 0) {
            }
            if ((256 & i7) != 0) {
            }
            if ((i7 & 512) != 0) {
            }
            i11 = i8;
            shape3 = shape2;
            f11 = f9;
            j9 = j8;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final int mo206roundToPx0680j_43 = ((Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo206roundToPx0680j_4(m2599constructorimpl);
            final int mo206roundToPx0680j_422 = ((Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo206roundToPx0680j_4(f10);
            Alignment.Companion companion4 = Alignment.INSTANCE;
            long j132 = j9;
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getCenterStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
            ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
            Modifier modifier42 = modifier2;
            Function0<ComposeUiNode> constructor3 = companion22.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2, companion22.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap3, companion22.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion22.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier3, companion22.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            Arrangement.HorizontalOrVertical m265spacedBy0680j_42 = Arrangement.INSTANCE.m265spacedBy0680j_4(f10);
            Alignment.Vertical centerVertically2 = companion4.getCenterVertically();
            Modifier.Companion companion32 = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m265spacedBy0680j_42, centerVertically2, startRestartGroup, 48);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, companion32);
            Function0<ComposeUiNode> constructor22 = companion22.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2, companion22.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion22.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion22.getSetCompositeKeyHash();
            if (!m1226constructorimpl2.getInserting()) {
            }
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion22.getSetModifier());
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            Modifier m103backgroundbw27NRU2 = BackgroundKt.m103backgroundbw27NRU(SizeKt.m333sizeVpY3zN4(companion32, m2599constructorimpl, f11), j7, shape3);
            startRestartGroup.startReplaceableGroup(-29719881);
            while (i12 < i5) {
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            Modifier modifier52 = Modifier.INSTANCE;
            final Function1<? super Integer, Integer> function142 = function12;
            Modifier m333sizeVpY3zN42 = SizeKt.m333sizeVpY3zN4(OffsetKt.offset(modifier52, new Function1<Density, IntOffset>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$6$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                    return IntOffset.m2632boximpl(m2905invokeBjo55l4(density));
                }

                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                public final long m2905invokeBjo55l4(Density offset) {
                    Intrinsics.checkNotNullParameter(offset, "$this$offset");
                    return IntOffsetKt.IntOffset((int) ((mo206roundToPx0680j_422 + mo206roundToPx0680j_43) * RangesKt.coerceIn(((function142.invoke(Integer.valueOf(pagerStateBridge.getCurrentPage() + ((int) Math.signum(r0)))).intValue() - r5) * Math.abs(pagerStateBridge.getCurrentPageOffset())) + function142.invoke(Integer.valueOf(pagerStateBridge.getCurrentPage())).intValue(), 0.0f, RangesKt.coerceAtLeast(i5 - 1, 0))), 0);
                }
            }), m2599constructorimpl, f11);
            if (i5 > 0) {
            }
            BoxKt.Box(m333sizeVpY3zN42.then(modifier52), startRestartGroup, 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            function13 = function12;
            f12 = f11;
            j11 = j10;
            shape4 = shape3;
            f13 = f10;
            j12 = j7;
            f14 = m2599constructorimpl;
            modifier3 = modifier42;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i9 = i7 & 8;
        if (i9 == 0) {
        }
        if ((i6 & 57344) == 0) {
        }
        if ((i6 & 458752) == 0) {
        }
        i10 = i7 & 64;
        if (i10 != 0) {
        }
        if ((i6 & 29360128) == 0) {
        }
        if ((i6 & 234881024) == 0) {
        }
        if ((1879048192 & i6) == 0) {
        }
        if ((1533916891 & i8) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i6 & 1) == 0) {
        }
        if (i16 != 0) {
        }
        if (i9 != 0) {
        }
        if ((16 & i7) != 0) {
        }
        if ((32 & i7) != 0) {
        }
        if (i10 != 0) {
        }
        if ((128 & i7) != 0) {
        }
        if ((256 & i7) != 0) {
        }
        if ((i7 & 512) != 0) {
        }
        i11 = i8;
        shape3 = shape2;
        f11 = f9;
        j9 = j8;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final int mo206roundToPx0680j_432 = ((Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo206roundToPx0680j_4(m2599constructorimpl);
        final int mo206roundToPx0680j_4222 = ((Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo206roundToPx0680j_4(f10);
        Alignment.Companion companion42 = Alignment.INSTANCE;
        long j1322 = j9;
        MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(companion42.getCenterStart(), false);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
        ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
        Modifier modifier422 = modifier2;
        Function0<ComposeUiNode> constructor32 = companion222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy22, companion222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap32, companion222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = companion222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash32);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier32, companion222.getSetModifier());
        BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
        Arrangement.HorizontalOrVertical m265spacedBy0680j_422 = Arrangement.INSTANCE.m265spacedBy0680j_4(f10);
        Alignment.Vertical centerVertically22 = companion42.getCenterVertically();
        Modifier.Companion companion322 = Modifier.INSTANCE;
        MeasurePolicy rowMeasurePolicy22 = RowKt.rowMeasurePolicy(m265spacedBy0680j_422, centerVertically22, startRestartGroup, 48);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, companion322);
        Function0<ComposeUiNode> constructor222 = companion222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy22, companion222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap222, companion222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion222.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier222, companion222.getSetModifier());
        RowScopeInstance rowScopeInstance22 = RowScopeInstance.INSTANCE;
        Modifier m103backgroundbw27NRU22 = BackgroundKt.m103backgroundbw27NRU(SizeKt.m333sizeVpY3zN4(companion322, m2599constructorimpl, f11), j7, shape3);
        startRestartGroup.startReplaceableGroup(-29719881);
        while (i12 < i5) {
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        Modifier modifier522 = Modifier.INSTANCE;
        final Function1<? super Integer, Integer> function1422 = function12;
        Modifier m333sizeVpY3zN422 = SizeKt.m333sizeVpY3zN4(OffsetKt.offset(modifier522, new Function1<Density, IntOffset>() { // from class: com.google.accompanist.pager.PagerIndicatorKt$HorizontalPagerIndicator$6$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                return IntOffset.m2632boximpl(m2905invokeBjo55l4(density));
            }

            /* renamed from: invoke-Bjo55l4, reason: not valid java name */
            public final long m2905invokeBjo55l4(Density offset) {
                Intrinsics.checkNotNullParameter(offset, "$this$offset");
                return IntOffsetKt.IntOffset((int) ((mo206roundToPx0680j_4222 + mo206roundToPx0680j_432) * RangesKt.coerceIn(((function1422.invoke(Integer.valueOf(pagerStateBridge.getCurrentPage() + ((int) Math.signum(r0)))).intValue() - r5) * Math.abs(pagerStateBridge.getCurrentPageOffset())) + function1422.invoke(Integer.valueOf(pagerStateBridge.getCurrentPage())).intValue(), 0.0f, RangesKt.coerceAtLeast(i5 - 1, 0))), 0);
            }
        }), m2599constructorimpl, f11);
        if (i5 > 0) {
        }
        BoxKt.Box(m333sizeVpY3zN422.then(modifier522), startRestartGroup, 0);
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        function13 = function12;
        f12 = f11;
        j11 = j10;
        shape4 = shape3;
        f13 = f10;
        j12 = j7;
        f14 = m2599constructorimpl;
        modifier3 = modifier422;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
