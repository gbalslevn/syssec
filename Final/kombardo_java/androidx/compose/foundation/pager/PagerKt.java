package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aº\u0001\u0010 \u001a\u00020\u001c2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001aS\u0010)\u001a\u00020\b*\u00020\u00182\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\bH\u0000¢\u0006\u0004\b)\u0010*\u001a3\u0010.\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u00102\u0006\u0010-\u001a\u00020,2\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b.\u0010/\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Landroidx/compose/foundation/pager/PagerState;", "state", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/foundation/layout/PaddingValues;", "contentPadding", "Landroidx/compose/foundation/pager/PageSize;", "pageSize", BuildConfig.FLAVOR, "beyondViewportPageCount", "Landroidx/compose/ui/unit/Dp;", "pageSpacing", "Landroidx/compose/ui/Alignment$Vertical;", "verticalAlignment", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "flingBehavior", BuildConfig.FLAVOR, "userScrollEnabled", "reverseLayout", "Lkotlin/Function1;", BuildConfig.FLAVOR, "key", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "pageNestedScrollConnection", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "snapPosition", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", BuildConfig.FLAVOR, "pageContent", "HorizontalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "HorizontalPager", "layoutSize", "spaceBetweenPages", "beforeContentPadding", "afterContentPadding", "currentPage", BuildConfig.FLAVOR, "currentPageOffsetFraction", "pageCount", "currentPageOffset", "(Landroidx/compose/foundation/gestures/snapping/SnapPosition;IIIIIIFI)I", "isVertical", "Lkotlinx/coroutines/CoroutineScope;", "scope", "pagerSemantics", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;ZLkotlinx/coroutines/CoroutineScope;Z)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PagerKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0249  */
    /* renamed from: HorizontalPager-oI3XNZo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m438HorizontalPageroI3XNZo(final PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i5, float f5, Alignment.Vertical vertical, TargetedFlingBehavior targetedFlingBehavior, boolean z5, boolean z6, Function1<? super Integer, ? extends Object> function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i6, final int i7, final int i8) {
        int i9;
        Modifier modifier2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        float f6;
        int i15;
        TargetedFlingBehavior targetedFlingBehavior2;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        boolean z7;
        int i25;
        int i26;
        int i27;
        TargetedFlingBehavior targetedFlingBehavior3;
        NestedScrollConnection nestedScrollConnection2;
        int i28;
        SnapPosition snapPosition2;
        TargetedFlingBehavior targetedFlingBehavior4;
        boolean z8;
        NestedScrollConnection nestedScrollConnection3;
        PageSize pageSize2;
        int i29;
        Alignment.Vertical vertical2;
        boolean z9;
        int i30;
        Function1<? super Integer, ? extends Object> function12;
        PaddingValues paddingValues2;
        float f7;
        Modifier modifier3;
        Composer composer2;
        final Modifier modifier4;
        final PaddingValues paddingValues3;
        final PageSize pageSize3;
        final int i31;
        final float f8;
        final Alignment.Vertical vertical3;
        final TargetedFlingBehavior targetedFlingBehavior5;
        final boolean z10;
        final boolean z11;
        final Function1<? super Integer, ? extends Object> function13;
        final NestedScrollConnection nestedScrollConnection4;
        final SnapPosition snapPosition3;
        ScopeUpdateScope endRestartGroup;
        int i32;
        int i33;
        Composer startRestartGroup = composer.startRestartGroup(1870896258);
        if ((i8 & 1) != 0) {
            i9 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i9 = (startRestartGroup.changed(pagerState) ? 4 : 2) | i6;
        } else {
            i9 = i6;
        }
        int i34 = i8 & 2;
        if (i34 != 0) {
            i9 |= 48;
        } else if ((i6 & 48) == 0) {
            modifier2 = modifier;
            i9 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i10 = i8 & 4;
            if (i10 == 0) {
                i9 |= 384;
            } else if ((i6 & 384) == 0) {
                i9 |= startRestartGroup.changed(paddingValues) ? 256 : 128;
                i11 = i8 & 8;
                if (i11 != 0) {
                    i9 |= 3072;
                } else if ((i6 & 3072) == 0) {
                    i9 |= startRestartGroup.changed(pageSize) ? 2048 : 1024;
                    i12 = i8 & 16;
                    if (i12 == 0) {
                        i9 |= 24576;
                    } else if ((i6 & 24576) == 0) {
                        i13 = i5;
                        i9 |= startRestartGroup.changed(i13) ? 16384 : 8192;
                        i14 = i8 & 32;
                        if (i14 != 0) {
                            i9 |= 196608;
                            f6 = f5;
                        } else {
                            f6 = f5;
                            if ((i6 & 196608) == 0) {
                                i9 |= startRestartGroup.changed(f6) ? 131072 : 65536;
                            }
                        }
                        i15 = i8 & 64;
                        if (i15 != 0) {
                            i9 |= 1572864;
                        } else if ((i6 & 1572864) == 0) {
                            i9 |= startRestartGroup.changed(vertical) ? 1048576 : 524288;
                        }
                        if ((i6 & 12582912) == 0) {
                            if ((i8 & 128) == 0) {
                                targetedFlingBehavior2 = targetedFlingBehavior;
                                if (startRestartGroup.changed(targetedFlingBehavior2)) {
                                    i33 = 8388608;
                                    i9 |= i33;
                                }
                            } else {
                                targetedFlingBehavior2 = targetedFlingBehavior;
                            }
                            i33 = 4194304;
                            i9 |= i33;
                        } else {
                            targetedFlingBehavior2 = targetedFlingBehavior;
                        }
                        i16 = i8 & 256;
                        if (i16 != 0) {
                            i9 |= 100663296;
                        } else if ((i6 & 100663296) == 0) {
                            i9 |= startRestartGroup.changed(z5) ? 67108864 : 33554432;
                        }
                        i17 = i8 & 512;
                        if (i17 != 0) {
                            i19 = i9 | 805306368;
                            i18 = i17;
                        } else {
                            if ((i6 & 805306368) == 0) {
                                i18 = i17;
                                i9 |= startRestartGroup.changed(z6) ? 536870912 : 268435456;
                            } else {
                                i18 = i17;
                            }
                            i19 = i9;
                        }
                        i20 = i8 & 1024;
                        if (i20 != 0) {
                            i21 = i7 | 6;
                        } else if ((i7 & 6) == 0) {
                            i21 = i7 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i21 = i7;
                        }
                        if ((i7 & 48) == 0) {
                            i22 = i20;
                            if ((i8 & 2048) == 0 && startRestartGroup.changedInstance(nestedScrollConnection)) {
                                i32 = 32;
                                i21 |= i32;
                            }
                            i32 = 16;
                            i21 |= i32;
                        } else {
                            i22 = i20;
                        }
                        int i35 = i21;
                        i23 = i8 & 4096;
                        if (i23 != 0) {
                            i35 |= 384;
                        } else if ((i7 & 384) == 0) {
                            i35 |= startRestartGroup.changed(snapPosition) ? 256 : 128;
                            if ((i8 & 8192) == 0) {
                                i35 |= 3072;
                            } else if ((i7 & 3072) == 0) {
                                i35 |= startRestartGroup.changedInstance(function4) ? 2048 : 1024;
                                if ((i19 & 306783379) != 306783378 && (i35 & 1171) == 1170 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    paddingValues3 = paddingValues;
                                    vertical3 = vertical;
                                    z10 = z5;
                                    function13 = function1;
                                    snapPosition3 = snapPosition;
                                    modifier4 = modifier2;
                                    composer2 = startRestartGroup;
                                    targetedFlingBehavior5 = targetedFlingBehavior2;
                                    z11 = z6;
                                    nestedScrollConnection4 = nestedScrollConnection;
                                    f8 = f6;
                                    i31 = i13;
                                    pageSize3 = pageSize;
                                } else {
                                    startRestartGroup.startDefaults();
                                    if ((i6 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        Modifier modifier5 = i34 != 0 ? Modifier.INSTANCE : modifier2;
                                        PaddingValues m306PaddingValues0680j_4 = i10 != 0 ? PaddingKt.m306PaddingValues0680j_4(Dp.m2599constructorimpl(0)) : paddingValues;
                                        PageSize pageSize4 = i11 != 0 ? PageSize.Fill.INSTANCE : pageSize;
                                        int i36 = i12 != 0 ? 0 : i13;
                                        float m2599constructorimpl = i14 != 0 ? Dp.m2599constructorimpl(0) : f6;
                                        Alignment.Vertical centerVertically = i15 != 0 ? Alignment.INSTANCE.getCenterVertically() : vertical;
                                        if ((i8 & 128) != 0) {
                                            i24 = i35;
                                            i27 = i22;
                                            z7 = false;
                                            i25 = i23;
                                            i26 = i18;
                                            targetedFlingBehavior3 = PagerDefaults.INSTANCE.flingBehavior(pagerState, null, null, null, 0.0f, startRestartGroup, (i19 & 14) | 196608, 30);
                                            i19 &= -29360129;
                                        } else {
                                            i24 = i35;
                                            z7 = false;
                                            i25 = i23;
                                            i26 = i18;
                                            i27 = i22;
                                            targetedFlingBehavior3 = targetedFlingBehavior2;
                                        }
                                        boolean z12 = i16 != 0 ? true : z5;
                                        if (i26 == 0) {
                                            z7 = z6;
                                        }
                                        Function1<? super Integer, ? extends Object> function14 = i27 != 0 ? null : function1;
                                        if ((i8 & 2048) != 0) {
                                            nestedScrollConnection2 = PagerDefaults.INSTANCE.pageNestedScrollConnection(pagerState, Orientation.Horizontal, startRestartGroup, (i19 & 14) | 432);
                                            i28 = i24 & (-113);
                                        } else {
                                            nestedScrollConnection2 = nestedScrollConnection;
                                            i28 = i24;
                                        }
                                        if (i25 != 0) {
                                            targetedFlingBehavior4 = targetedFlingBehavior3;
                                            z8 = z12;
                                            nestedScrollConnection3 = nestedScrollConnection2;
                                            i35 = i28;
                                            snapPosition2 = SnapPosition.Start.INSTANCE;
                                        } else {
                                            snapPosition2 = snapPosition;
                                            targetedFlingBehavior4 = targetedFlingBehavior3;
                                            z8 = z12;
                                            nestedScrollConnection3 = nestedScrollConnection2;
                                            i35 = i28;
                                        }
                                        pageSize2 = pageSize4;
                                        i29 = i36;
                                        vertical2 = centerVertically;
                                        z9 = z7;
                                        i30 = i19;
                                        function12 = function14;
                                        paddingValues2 = m306PaddingValues0680j_4;
                                        f7 = m2599constructorimpl;
                                        modifier3 = modifier5;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i8 & 128) != 0) {
                                            i19 &= -29360129;
                                        }
                                        if ((i8 & 2048) != 0) {
                                            i35 &= -113;
                                        }
                                        paddingValues2 = paddingValues;
                                        pageSize2 = pageSize;
                                        vertical2 = vertical;
                                        z8 = z5;
                                        z9 = z6;
                                        nestedScrollConnection3 = nestedScrollConnection;
                                        snapPosition2 = snapPosition;
                                        i29 = i13;
                                        f7 = f6;
                                        modifier3 = modifier2;
                                        targetedFlingBehavior4 = targetedFlingBehavior2;
                                        i30 = i19;
                                        function12 = function1;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1870896258, i30, i35, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:124)");
                                    }
                                    int i37 = i30 >> 6;
                                    int i38 = ((i30 >> 3) & 14) | 24576 | ((i30 << 3) & 112) | (i30 & 896) | ((i30 >> 18) & 7168) | (458752 & i37) | (i37 & 3670016);
                                    int i39 = i30 << 9;
                                    int i40 = i38 | (29360128 & i39) | (i39 & 234881024) | ((i30 << 18) & 1879048192);
                                    int i41 = ((i30 >> 9) & 7168) | ((i35 >> 3) & 14) | 384 | ((i35 << 3) & 112);
                                    int i42 = i35 << 6;
                                    composer2 = startRestartGroup;
                                    LazyLayoutPagerKt.m436PageruYRUAWA(modifier3, pagerState, paddingValues2, z9, Orientation.Horizontal, targetedFlingBehavior4, z8, i29, f7, pageSize2, nestedScrollConnection3, function12, Alignment.INSTANCE.getCenterHorizontally(), vertical2, snapPosition2, function4, composer2, i40, i41 | (57344 & i42) | (i42 & 458752), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier4 = modifier3;
                                    paddingValues3 = paddingValues2;
                                    pageSize3 = pageSize2;
                                    i31 = i29;
                                    f8 = f7;
                                    vertical3 = vertical2;
                                    targetedFlingBehavior5 = targetedFlingBehavior4;
                                    z10 = z8;
                                    z11 = z9;
                                    function13 = function12;
                                    nestedScrollConnection4 = nestedScrollConnection3;
                                    snapPosition3 = snapPosition2;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$HorizontalPager$1
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

                                        public final void invoke(Composer composer3, int i43) {
                                            PagerKt.m438HorizontalPageroI3XNZo(PagerState.this, modifier4, paddingValues3, pageSize3, i31, f8, vertical3, targetedFlingBehavior5, z10, z11, function13, nestedScrollConnection4, snapPosition3, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), RecomposeScopeImplKt.updateChangedFlags(i7), i8);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if ((i19 & 306783379) != 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i6 & 1) != 0) {
                            }
                            if (i34 != 0) {
                            }
                            if (i10 != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i12 != 0) {
                            }
                            if (i14 != 0) {
                            }
                            if (i15 != 0) {
                            }
                            if ((i8 & 128) != 0) {
                            }
                            if (i16 != 0) {
                            }
                            if (i26 == 0) {
                            }
                            if (i27 != 0) {
                            }
                            if ((i8 & 2048) != 0) {
                            }
                            if (i25 != 0) {
                            }
                            pageSize2 = pageSize4;
                            i29 = i36;
                            vertical2 = centerVertically;
                            z9 = z7;
                            i30 = i19;
                            function12 = function14;
                            paddingValues2 = m306PaddingValues0680j_4;
                            f7 = m2599constructorimpl;
                            modifier3 = modifier5;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i372 = i30 >> 6;
                            int i382 = ((i30 >> 3) & 14) | 24576 | ((i30 << 3) & 112) | (i30 & 896) | ((i30 >> 18) & 7168) | (458752 & i372) | (i372 & 3670016);
                            int i392 = i30 << 9;
                            int i402 = i382 | (29360128 & i392) | (i392 & 234881024) | ((i30 << 18) & 1879048192);
                            int i412 = ((i30 >> 9) & 7168) | ((i35 >> 3) & 14) | 384 | ((i35 << 3) & 112);
                            int i422 = i35 << 6;
                            composer2 = startRestartGroup;
                            LazyLayoutPagerKt.m436PageruYRUAWA(modifier3, pagerState, paddingValues2, z9, Orientation.Horizontal, targetedFlingBehavior4, z8, i29, f7, pageSize2, nestedScrollConnection3, function12, Alignment.INSTANCE.getCenterHorizontally(), vertical2, snapPosition2, function4, composer2, i402, i412 | (57344 & i422) | (i422 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier3;
                            paddingValues3 = paddingValues2;
                            pageSize3 = pageSize2;
                            i31 = i29;
                            f8 = f7;
                            vertical3 = vertical2;
                            targetedFlingBehavior5 = targetedFlingBehavior4;
                            z10 = z8;
                            z11 = z9;
                            function13 = function12;
                            nestedScrollConnection4 = nestedScrollConnection3;
                            snapPosition3 = snapPosition2;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        if ((i8 & 8192) == 0) {
                        }
                        if ((i19 & 306783379) != 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i6 & 1) != 0) {
                        }
                        if (i34 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i14 != 0) {
                        }
                        if (i15 != 0) {
                        }
                        if ((i8 & 128) != 0) {
                        }
                        if (i16 != 0) {
                        }
                        if (i26 == 0) {
                        }
                        if (i27 != 0) {
                        }
                        if ((i8 & 2048) != 0) {
                        }
                        if (i25 != 0) {
                        }
                        pageSize2 = pageSize4;
                        i29 = i36;
                        vertical2 = centerVertically;
                        z9 = z7;
                        i30 = i19;
                        function12 = function14;
                        paddingValues2 = m306PaddingValues0680j_4;
                        f7 = m2599constructorimpl;
                        modifier3 = modifier5;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i3722 = i30 >> 6;
                        int i3822 = ((i30 >> 3) & 14) | 24576 | ((i30 << 3) & 112) | (i30 & 896) | ((i30 >> 18) & 7168) | (458752 & i3722) | (i3722 & 3670016);
                        int i3922 = i30 << 9;
                        int i4022 = i3822 | (29360128 & i3922) | (i3922 & 234881024) | ((i30 << 18) & 1879048192);
                        int i4122 = ((i30 >> 9) & 7168) | ((i35 >> 3) & 14) | 384 | ((i35 << 3) & 112);
                        int i4222 = i35 << 6;
                        composer2 = startRestartGroup;
                        LazyLayoutPagerKt.m436PageruYRUAWA(modifier3, pagerState, paddingValues2, z9, Orientation.Horizontal, targetedFlingBehavior4, z8, i29, f7, pageSize2, nestedScrollConnection3, function12, Alignment.INSTANCE.getCenterHorizontally(), vertical2, snapPosition2, function4, composer2, i4022, i4122 | (57344 & i4222) | (i4222 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier3;
                        paddingValues3 = paddingValues2;
                        pageSize3 = pageSize2;
                        i31 = i29;
                        f8 = f7;
                        vertical3 = vertical2;
                        targetedFlingBehavior5 = targetedFlingBehavior4;
                        z10 = z8;
                        z11 = z9;
                        function13 = function12;
                        nestedScrollConnection4 = nestedScrollConnection3;
                        snapPosition3 = snapPosition2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i13 = i5;
                    i14 = i8 & 32;
                    if (i14 != 0) {
                    }
                    i15 = i8 & 64;
                    if (i15 != 0) {
                    }
                    if ((i6 & 12582912) == 0) {
                    }
                    i16 = i8 & 256;
                    if (i16 != 0) {
                    }
                    i17 = i8 & 512;
                    if (i17 != 0) {
                    }
                    i20 = i8 & 1024;
                    if (i20 != 0) {
                    }
                    if ((i7 & 48) == 0) {
                    }
                    int i352 = i21;
                    i23 = i8 & 4096;
                    if (i23 != 0) {
                    }
                    if ((i8 & 8192) == 0) {
                    }
                    if ((i19 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i6 & 1) != 0) {
                    }
                    if (i34 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if ((i8 & 128) != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if (i26 == 0) {
                    }
                    if (i27 != 0) {
                    }
                    if ((i8 & 2048) != 0) {
                    }
                    if (i25 != 0) {
                    }
                    pageSize2 = pageSize4;
                    i29 = i36;
                    vertical2 = centerVertically;
                    z9 = z7;
                    i30 = i19;
                    function12 = function14;
                    paddingValues2 = m306PaddingValues0680j_4;
                    f7 = m2599constructorimpl;
                    modifier3 = modifier5;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i37222 = i30 >> 6;
                    int i38222 = ((i30 >> 3) & 14) | 24576 | ((i30 << 3) & 112) | (i30 & 896) | ((i30 >> 18) & 7168) | (458752 & i37222) | (i37222 & 3670016);
                    int i39222 = i30 << 9;
                    int i40222 = i38222 | (29360128 & i39222) | (i39222 & 234881024) | ((i30 << 18) & 1879048192);
                    int i41222 = ((i30 >> 9) & 7168) | ((i352 >> 3) & 14) | 384 | ((i352 << 3) & 112);
                    int i42222 = i352 << 6;
                    composer2 = startRestartGroup;
                    LazyLayoutPagerKt.m436PageruYRUAWA(modifier3, pagerState, paddingValues2, z9, Orientation.Horizontal, targetedFlingBehavior4, z8, i29, f7, pageSize2, nestedScrollConnection3, function12, Alignment.INSTANCE.getCenterHorizontally(), vertical2, snapPosition2, function4, composer2, i40222, i41222 | (57344 & i42222) | (i42222 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    paddingValues3 = paddingValues2;
                    pageSize3 = pageSize2;
                    i31 = i29;
                    f8 = f7;
                    vertical3 = vertical2;
                    targetedFlingBehavior5 = targetedFlingBehavior4;
                    z10 = z8;
                    z11 = z9;
                    function13 = function12;
                    nestedScrollConnection4 = nestedScrollConnection3;
                    snapPosition3 = snapPosition2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i12 = i8 & 16;
                if (i12 == 0) {
                }
                i13 = i5;
                i14 = i8 & 32;
                if (i14 != 0) {
                }
                i15 = i8 & 64;
                if (i15 != 0) {
                }
                if ((i6 & 12582912) == 0) {
                }
                i16 = i8 & 256;
                if (i16 != 0) {
                }
                i17 = i8 & 512;
                if (i17 != 0) {
                }
                i20 = i8 & 1024;
                if (i20 != 0) {
                }
                if ((i7 & 48) == 0) {
                }
                int i3522 = i21;
                i23 = i8 & 4096;
                if (i23 != 0) {
                }
                if ((i8 & 8192) == 0) {
                }
                if ((i19 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i6 & 1) != 0) {
                }
                if (i34 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i14 != 0) {
                }
                if (i15 != 0) {
                }
                if ((i8 & 128) != 0) {
                }
                if (i16 != 0) {
                }
                if (i26 == 0) {
                }
                if (i27 != 0) {
                }
                if ((i8 & 2048) != 0) {
                }
                if (i25 != 0) {
                }
                pageSize2 = pageSize4;
                i29 = i36;
                vertical2 = centerVertically;
                z9 = z7;
                i30 = i19;
                function12 = function14;
                paddingValues2 = m306PaddingValues0680j_4;
                f7 = m2599constructorimpl;
                modifier3 = modifier5;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i372222 = i30 >> 6;
                int i382222 = ((i30 >> 3) & 14) | 24576 | ((i30 << 3) & 112) | (i30 & 896) | ((i30 >> 18) & 7168) | (458752 & i372222) | (i372222 & 3670016);
                int i392222 = i30 << 9;
                int i402222 = i382222 | (29360128 & i392222) | (i392222 & 234881024) | ((i30 << 18) & 1879048192);
                int i412222 = ((i30 >> 9) & 7168) | ((i3522 >> 3) & 14) | 384 | ((i3522 << 3) & 112);
                int i422222 = i3522 << 6;
                composer2 = startRestartGroup;
                LazyLayoutPagerKt.m436PageruYRUAWA(modifier3, pagerState, paddingValues2, z9, Orientation.Horizontal, targetedFlingBehavior4, z8, i29, f7, pageSize2, nestedScrollConnection3, function12, Alignment.INSTANCE.getCenterHorizontally(), vertical2, snapPosition2, function4, composer2, i402222, i412222 | (57344 & i422222) | (i422222 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                paddingValues3 = paddingValues2;
                pageSize3 = pageSize2;
                i31 = i29;
                f8 = f7;
                vertical3 = vertical2;
                targetedFlingBehavior5 = targetedFlingBehavior4;
                z10 = z8;
                z11 = z9;
                function13 = function12;
                nestedScrollConnection4 = nestedScrollConnection3;
                snapPosition3 = snapPosition2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i11 = i8 & 8;
            if (i11 != 0) {
            }
            i12 = i8 & 16;
            if (i12 == 0) {
            }
            i13 = i5;
            i14 = i8 & 32;
            if (i14 != 0) {
            }
            i15 = i8 & 64;
            if (i15 != 0) {
            }
            if ((i6 & 12582912) == 0) {
            }
            i16 = i8 & 256;
            if (i16 != 0) {
            }
            i17 = i8 & 512;
            if (i17 != 0) {
            }
            i20 = i8 & 1024;
            if (i20 != 0) {
            }
            if ((i7 & 48) == 0) {
            }
            int i35222 = i21;
            i23 = i8 & 4096;
            if (i23 != 0) {
            }
            if ((i8 & 8192) == 0) {
            }
            if ((i19 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i6 & 1) != 0) {
            }
            if (i34 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i14 != 0) {
            }
            if (i15 != 0) {
            }
            if ((i8 & 128) != 0) {
            }
            if (i16 != 0) {
            }
            if (i26 == 0) {
            }
            if (i27 != 0) {
            }
            if ((i8 & 2048) != 0) {
            }
            if (i25 != 0) {
            }
            pageSize2 = pageSize4;
            i29 = i36;
            vertical2 = centerVertically;
            z9 = z7;
            i30 = i19;
            function12 = function14;
            paddingValues2 = m306PaddingValues0680j_4;
            f7 = m2599constructorimpl;
            modifier3 = modifier5;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i3722222 = i30 >> 6;
            int i3822222 = ((i30 >> 3) & 14) | 24576 | ((i30 << 3) & 112) | (i30 & 896) | ((i30 >> 18) & 7168) | (458752 & i3722222) | (i3722222 & 3670016);
            int i3922222 = i30 << 9;
            int i4022222 = i3822222 | (29360128 & i3922222) | (i3922222 & 234881024) | ((i30 << 18) & 1879048192);
            int i4122222 = ((i30 >> 9) & 7168) | ((i35222 >> 3) & 14) | 384 | ((i35222 << 3) & 112);
            int i4222222 = i35222 << 6;
            composer2 = startRestartGroup;
            LazyLayoutPagerKt.m436PageruYRUAWA(modifier3, pagerState, paddingValues2, z9, Orientation.Horizontal, targetedFlingBehavior4, z8, i29, f7, pageSize2, nestedScrollConnection3, function12, Alignment.INSTANCE.getCenterHorizontally(), vertical2, snapPosition2, function4, composer2, i4022222, i4122222 | (57344 & i4222222) | (i4222222 & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            paddingValues3 = paddingValues2;
            pageSize3 = pageSize2;
            i31 = i29;
            f8 = f7;
            vertical3 = vertical2;
            targetedFlingBehavior5 = targetedFlingBehavior4;
            z10 = z8;
            z11 = z9;
            function13 = function12;
            nestedScrollConnection4 = nestedScrollConnection3;
            snapPosition3 = snapPosition2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i10 = i8 & 4;
        if (i10 == 0) {
        }
        i11 = i8 & 8;
        if (i11 != 0) {
        }
        i12 = i8 & 16;
        if (i12 == 0) {
        }
        i13 = i5;
        i14 = i8 & 32;
        if (i14 != 0) {
        }
        i15 = i8 & 64;
        if (i15 != 0) {
        }
        if ((i6 & 12582912) == 0) {
        }
        i16 = i8 & 256;
        if (i16 != 0) {
        }
        i17 = i8 & 512;
        if (i17 != 0) {
        }
        i20 = i8 & 1024;
        if (i20 != 0) {
        }
        if ((i7 & 48) == 0) {
        }
        int i352222 = i21;
        i23 = i8 & 4096;
        if (i23 != 0) {
        }
        if ((i8 & 8192) == 0) {
        }
        if ((i19 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i6 & 1) != 0) {
        }
        if (i34 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i14 != 0) {
        }
        if (i15 != 0) {
        }
        if ((i8 & 128) != 0) {
        }
        if (i16 != 0) {
        }
        if (i26 == 0) {
        }
        if (i27 != 0) {
        }
        if ((i8 & 2048) != 0) {
        }
        if (i25 != 0) {
        }
        pageSize2 = pageSize4;
        i29 = i36;
        vertical2 = centerVertically;
        z9 = z7;
        i30 = i19;
        function12 = function14;
        paddingValues2 = m306PaddingValues0680j_4;
        f7 = m2599constructorimpl;
        modifier3 = modifier5;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i37222222 = i30 >> 6;
        int i38222222 = ((i30 >> 3) & 14) | 24576 | ((i30 << 3) & 112) | (i30 & 896) | ((i30 >> 18) & 7168) | (458752 & i37222222) | (i37222222 & 3670016);
        int i39222222 = i30 << 9;
        int i40222222 = i38222222 | (29360128 & i39222222) | (i39222222 & 234881024) | ((i30 << 18) & 1879048192);
        int i41222222 = ((i30 >> 9) & 7168) | ((i352222 >> 3) & 14) | 384 | ((i352222 << 3) & 112);
        int i42222222 = i352222 << 6;
        composer2 = startRestartGroup;
        LazyLayoutPagerKt.m436PageruYRUAWA(modifier3, pagerState, paddingValues2, z9, Orientation.Horizontal, targetedFlingBehavior4, z8, i29, f7, pageSize2, nestedScrollConnection3, function12, Alignment.INSTANCE.getCenterHorizontally(), vertical2, snapPosition2, function4, composer2, i40222222, i41222222 | (57344 & i42222222) | (i42222222 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        paddingValues3 = paddingValues2;
        pageSize3 = pageSize2;
        i31 = i29;
        f8 = f7;
        vertical3 = vertical2;
        targetedFlingBehavior5 = targetedFlingBehavior4;
        z10 = z8;
        z11 = z9;
        function13 = function12;
        nestedScrollConnection4 = nestedScrollConnection3;
        snapPosition3 = snapPosition2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final int currentPageOffset(SnapPosition snapPosition, int i5, int i6, int i7, int i8, int i9, int i10, float f5, int i11) {
        return MathKt.roundToInt(snapPosition.position(i5, i6, i8, i9, i10, i11) - (f5 * (i6 + i7)));
    }

    public static final Modifier pagerSemantics(Modifier modifier, final PagerState pagerState, final boolean z5, final CoroutineScope coroutineScope, boolean z6) {
        return z6 ? modifier.then(SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                if (z5) {
                    final PagerState pagerState2 = pagerState;
                    final CoroutineScope coroutineScope2 = coroutineScope;
                    SemanticsPropertiesKt.pageUp$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            boolean pagerSemantics$performBackwardPaging;
                            pagerSemantics$performBackwardPaging = PagerKt.pagerSemantics$performBackwardPaging(PagerState.this, coroutineScope2);
                            return Boolean.valueOf(pagerSemantics$performBackwardPaging);
                        }
                    }, 1, null);
                    final PagerState pagerState3 = pagerState;
                    final CoroutineScope coroutineScope3 = coroutineScope;
                    SemanticsPropertiesKt.pageDown$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            boolean pagerSemantics$performForwardPaging;
                            pagerSemantics$performForwardPaging = PagerKt.pagerSemantics$performForwardPaging(PagerState.this, coroutineScope3);
                            return Boolean.valueOf(pagerSemantics$performForwardPaging);
                        }
                    }, 1, null);
                    return;
                }
                final PagerState pagerState4 = pagerState;
                final CoroutineScope coroutineScope4 = coroutineScope;
                SemanticsPropertiesKt.pageLeft$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        boolean pagerSemantics$performBackwardPaging;
                        pagerSemantics$performBackwardPaging = PagerKt.pagerSemantics$performBackwardPaging(PagerState.this, coroutineScope4);
                        return Boolean.valueOf(pagerSemantics$performBackwardPaging);
                    }
                }, 1, null);
                final PagerState pagerState5 = pagerState;
                final CoroutineScope coroutineScope5 = coroutineScope;
                SemanticsPropertiesKt.pageRight$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        boolean pagerSemantics$performForwardPaging;
                        pagerSemantics$performForwardPaging = PagerKt.pagerSemantics$performForwardPaging(PagerState.this, coroutineScope5);
                        return Boolean.valueOf(pagerSemantics$performForwardPaging);
                    }
                }, 1, null);
            }
        }, 1, null)) : modifier.then(Modifier.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performBackwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (!pagerState.getCanScrollBackward()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PagerKt$pagerSemantics$performBackwardPaging$1(pagerState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performForwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (!pagerState.getCanScrollForward()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PagerKt$pagerSemantics$performForwardPaging$1(pagerState, null), 3, null);
        return true;
    }
}
