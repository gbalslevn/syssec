package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u001a{\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0018\u0010\u0019\u001a-\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001e2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Landroidx/compose/foundation/lazy/grid/GridCells;", "columns", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "state", "Landroidx/compose/foundation/layout/PaddingValues;", "contentPadding", BuildConfig.FLAVOR, "reverseLayout", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "horizontalArrangement", "Landroidx/compose/foundation/gestures/FlingBehavior;", "flingBehavior", "userScrollEnabled", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", BuildConfig.FLAVOR, "content", "LazyVerticalGrid", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "rememberColumnWidthSums", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", BuildConfig.FLAVOR, "gridSize", "slotCount", "spacing", BuildConfig.FLAVOR, "calculateCellsCrossAxisSizeImpl", "(III)Ljava/util/List;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LazyGridDslKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyVerticalGrid(final GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z5, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z6, final Function1<? super LazyGridScope, Unit> function1, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        PaddingValues paddingValues2;
        int i9;
        boolean z7;
        Arrangement.Vertical vertical2;
        int i10;
        Arrangement.Horizontal horizontal2;
        int i11;
        Modifier modifier2;
        LazyGridState lazyGridState2;
        PaddingValues m306PaddingValues0680j_4;
        boolean z8;
        Arrangement.Vertical vertical3;
        Arrangement.Horizontal start;
        FlingBehavior flingBehavior2;
        boolean z9;
        final LazyGridState lazyGridState3;
        final boolean z10;
        final Arrangement.Vertical vertical4;
        final FlingBehavior flingBehavior3;
        boolean z11;
        ScopeUpdateScope endRestartGroup;
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(1485410512);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(gridCells) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i15 = i6 & 2;
        if (i15 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i5 & 384) == 0) {
                if ((i6 & 4) == 0 && startRestartGroup.changed(lazyGridState)) {
                    i14 = 256;
                    i7 |= i14;
                }
                i14 = 128;
                i7 |= i14;
            }
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                paddingValues2 = paddingValues;
                i7 |= startRestartGroup.changed(paddingValues2) ? 2048 : 1024;
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    z7 = z5;
                    i7 |= startRestartGroup.changed(z7) ? 16384 : 8192;
                    if ((i5 & 196608) != 0) {
                        if ((i6 & 32) == 0) {
                            vertical2 = vertical;
                            if (startRestartGroup.changed(vertical2)) {
                                i13 = 131072;
                                i7 |= i13;
                            }
                        } else {
                            vertical2 = vertical;
                        }
                        i13 = 65536;
                        i7 |= i13;
                    } else {
                        vertical2 = vertical;
                    }
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                        horizontal2 = horizontal;
                    } else {
                        horizontal2 = horizontal;
                        if ((i5 & 1572864) == 0) {
                            i7 |= startRestartGroup.changed(horizontal2) ? 1048576 : 524288;
                        }
                    }
                    if ((i5 & 12582912) == 0) {
                        if ((i6 & 128) == 0 && startRestartGroup.changed(flingBehavior)) {
                            i12 = 8388608;
                            i7 |= i12;
                        }
                        i12 = 4194304;
                        i7 |= i12;
                    }
                    i11 = i6 & 256;
                    if (i11 == 0) {
                        i7 |= 100663296;
                    } else if ((i5 & 100663296) == 0) {
                        i7 |= startRestartGroup.changed(z6) ? 67108864 : 33554432;
                    }
                    if ((i6 & 512) == 0) {
                        i7 |= 805306368;
                    } else if ((i5 & 805306368) == 0) {
                        i7 |= startRestartGroup.changedInstance(function1) ? 536870912 : 268435456;
                        if ((i7 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                modifier2 = i15 != 0 ? Modifier.INSTANCE : modifier;
                                if ((i6 & 4) != 0) {
                                    lazyGridState2 = LazyGridStateKt.rememberLazyGridState(0, 0, startRestartGroup, 0, 3);
                                    i7 &= -897;
                                } else {
                                    lazyGridState2 = lazyGridState;
                                }
                                m306PaddingValues0680j_4 = i8 != 0 ? PaddingKt.m306PaddingValues0680j_4(Dp.m2599constructorimpl(0)) : paddingValues2;
                                z8 = i9 == 0 ? z7 : false;
                                if ((i6 & 32) != 0) {
                                    Arrangement arrangement = Arrangement.INSTANCE;
                                    vertical3 = !z8 ? arrangement.getTop() : arrangement.getBottom();
                                    i7 &= -458753;
                                } else {
                                    vertical3 = vertical2;
                                }
                                start = i10 != 0 ? Arrangement.INSTANCE.getStart() : horizontal2;
                                if ((i6 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                    i7 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                z9 = i11 != 0 ? true : z6;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i6 & 4) != 0) {
                                    i7 &= -897;
                                }
                                if ((i6 & 32) != 0) {
                                    i7 &= -458753;
                                }
                                if ((i6 & 128) != 0) {
                                    i7 &= -29360129;
                                }
                                modifier2 = modifier;
                                lazyGridState2 = lazyGridState;
                                z9 = z6;
                                m306PaddingValues0680j_4 = paddingValues2;
                                z8 = z7;
                                start = horizontal2;
                                vertical3 = vertical2;
                                flingBehavior2 = flingBehavior;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1485410512, i7, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                            }
                            int i16 = i7 >> 3;
                            int i17 = i7 << 9;
                            LazyGridKt.LazyGrid(modifier2, lazyGridState2, rememberColumnWidthSums(gridCells, start, m306PaddingValues0680j_4, startRestartGroup, (i7 & 14) | ((i7 >> 15) & 112) | (i16 & 896)), m306PaddingValues0680j_4, z8, true, flingBehavior2, z9, vertical3, start, function1, startRestartGroup, (i7 & 7168) | (i16 & 14) | 196608 | (i16 & 112) | (57344 & i7) | (3670016 & i16) | (29360128 & i16) | (234881024 & i17) | (i17 & 1879048192), (i7 >> 27) & 14, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            lazyGridState3 = lazyGridState2;
                            z10 = z8;
                            vertical4 = vertical3;
                            flingBehavior3 = flingBehavior2;
                            z11 = z9;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            lazyGridState3 = lazyGridState;
                            m306PaddingValues0680j_4 = paddingValues2;
                            z10 = z7;
                            start = horizontal2;
                            vertical4 = vertical2;
                            flingBehavior3 = flingBehavior;
                            z11 = z6;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final PaddingValues paddingValues3 = m306PaddingValues0680j_4;
                            final Arrangement.Horizontal horizontal3 = start;
                            final boolean z12 = z11;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyVerticalGrid$1
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

                                public final void invoke(Composer composer2, int i18) {
                                    LazyGridDslKt.LazyVerticalGrid(GridCells.this, modifier3, lazyGridState3, paddingValues3, z10, vertical4, horizontal3, flingBehavior3, z12, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
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
                    if (i15 != 0) {
                    }
                    if ((i6 & 4) != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 == 0) {
                    }
                    if ((i6 & 32) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i6 & 128) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i162 = i7 >> 3;
                    int i172 = i7 << 9;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, rememberColumnWidthSums(gridCells, start, m306PaddingValues0680j_4, startRestartGroup, (i7 & 14) | ((i7 >> 15) & 112) | (i162 & 896)), m306PaddingValues0680j_4, z8, true, flingBehavior2, z9, vertical3, start, function1, startRestartGroup, (i7 & 7168) | (i162 & 14) | 196608 | (i162 & 112) | (57344 & i7) | (3670016 & i162) | (29360128 & i162) | (234881024 & i172) | (i172 & 1879048192), (i7 >> 27) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    lazyGridState3 = lazyGridState2;
                    z10 = z8;
                    vertical4 = vertical3;
                    flingBehavior3 = flingBehavior2;
                    z11 = z9;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z7 = z5;
                if ((i5 & 196608) != 0) {
                }
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                if ((i5 & 12582912) == 0) {
                }
                i11 = i6 & 256;
                if (i11 == 0) {
                }
                if ((i6 & 512) == 0) {
                }
                if ((i7 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i15 != 0) {
                }
                if ((i6 & 4) != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 == 0) {
                }
                if ((i6 & 32) != 0) {
                }
                if (i10 != 0) {
                }
                if ((i6 & 128) != 0) {
                }
                if (i11 != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1622 = i7 >> 3;
                int i1722 = i7 << 9;
                LazyGridKt.LazyGrid(modifier2, lazyGridState2, rememberColumnWidthSums(gridCells, start, m306PaddingValues0680j_4, startRestartGroup, (i7 & 14) | ((i7 >> 15) & 112) | (i1622 & 896)), m306PaddingValues0680j_4, z8, true, flingBehavior2, z9, vertical3, start, function1, startRestartGroup, (i7 & 7168) | (i1622 & 14) | 196608 | (i1622 & 112) | (57344 & i7) | (3670016 & i1622) | (29360128 & i1622) | (234881024 & i1722) | (i1722 & 1879048192), (i7 >> 27) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                lazyGridState3 = lazyGridState2;
                z10 = z8;
                vertical4 = vertical3;
                flingBehavior3 = flingBehavior2;
                z11 = z9;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            paddingValues2 = paddingValues;
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            z7 = z5;
            if ((i5 & 196608) != 0) {
            }
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            if ((i5 & 12582912) == 0) {
            }
            i11 = i6 & 256;
            if (i11 == 0) {
            }
            if ((i6 & 512) == 0) {
            }
            if ((i7 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i15 != 0) {
            }
            if ((i6 & 4) != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 == 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if (i10 != 0) {
            }
            if ((i6 & 128) != 0) {
            }
            if (i11 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i16222 = i7 >> 3;
            int i17222 = i7 << 9;
            LazyGridKt.LazyGrid(modifier2, lazyGridState2, rememberColumnWidthSums(gridCells, start, m306PaddingValues0680j_4, startRestartGroup, (i7 & 14) | ((i7 >> 15) & 112) | (i16222 & 896)), m306PaddingValues0680j_4, z8, true, flingBehavior2, z9, vertical3, start, function1, startRestartGroup, (i7 & 7168) | (i16222 & 14) | 196608 | (i16222 & 112) | (57344 & i7) | (3670016 & i16222) | (29360128 & i16222) | (234881024 & i17222) | (i17222 & 1879048192), (i7 >> 27) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            lazyGridState3 = lazyGridState2;
            z10 = z8;
            vertical4 = vertical3;
            flingBehavior3 = flingBehavior2;
            z11 = z9;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i5 & 384) == 0) {
        }
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        paddingValues2 = paddingValues;
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        z7 = z5;
        if ((i5 & 196608) != 0) {
        }
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        if ((i5 & 12582912) == 0) {
        }
        i11 = i6 & 256;
        if (i11 == 0) {
        }
        if ((i6 & 512) == 0) {
        }
        if ((i7 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i15 != 0) {
        }
        if ((i6 & 4) != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 == 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if (i10 != 0) {
        }
        if ((i6 & 128) != 0) {
        }
        if (i11 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i162222 = i7 >> 3;
        int i172222 = i7 << 9;
        LazyGridKt.LazyGrid(modifier2, lazyGridState2, rememberColumnWidthSums(gridCells, start, m306PaddingValues0680j_4, startRestartGroup, (i7 & 14) | ((i7 >> 15) & 112) | (i162222 & 896)), m306PaddingValues0680j_4, z8, true, flingBehavior2, z9, vertical3, start, function1, startRestartGroup, (i7 & 7168) | (i162222 & 14) | 196608 | (i162222 & 112) | (57344 & i7) | (3670016 & i162222) | (29360128 & i162222) | (234881024 & i172222) | (i172222 & 1879048192), (i7 >> 27) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        lazyGridState3 = lazyGridState2;
        z10 = z8;
        vertical4 = vertical3;
        flingBehavior3 = flingBehavior2;
        z11 = z9;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Integer> calculateCellsCrossAxisSizeImpl(int i5, int i6, int i7) {
        int i8 = i5 - (i7 * (i6 - 1));
        int i9 = i8 / i6;
        int i10 = i8 % i6;
        ArrayList arrayList = new ArrayList(i6);
        int i11 = 0;
        while (i11 < i6) {
            arrayList.add(Integer.valueOf((i11 < i10 ? 1 : 0) + i9));
            i11++;
        }
        return arrayList;
    }

    private static final LazyGridSlotsProvider rememberColumnWidthSums(final GridCells gridCells, final Arrangement.Horizontal horizontal, final PaddingValues paddingValues, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1632454918, i5, -1, "androidx.compose.foundation.lazy.grid.rememberColumnWidthSums (LazyGridDsl.kt:148)");
        }
        boolean z5 = ((((i5 & 14) ^ 6) > 4 && composer.changed(gridCells)) || (i5 & 6) == 4) | ((((i5 & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i5 & 48) == 32) | ((((i5 & 896) ^ 384) > 256 && composer.changed(paddingValues)) || (i5 & 384) == 256);
        Object rememberedValue = composer.rememberedValue();
        if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new GridSlotCache(new Function2<Density, Constraints, LazyGridSlots>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$rememberColumnWidthSums$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyGridSlots invoke(Density density, Constraints constraints) {
                    return m388invoke0kLqBqw(density, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyGridSlots m388invoke0kLqBqw(Density density, long j5) {
                    if (Constraints.m2578getMaxWidthimpl(j5) == Integer.MAX_VALUE) {
                        throw new IllegalArgumentException("LazyVerticalGrid's width should be bound by parent.");
                    }
                    PaddingValues paddingValues2 = PaddingValues.this;
                    LayoutDirection layoutDirection = LayoutDirection.Ltr;
                    int m2578getMaxWidthimpl = Constraints.m2578getMaxWidthimpl(j5) - density.mo206roundToPx0680j_4(Dp.m2599constructorimpl(PaddingKt.calculateStartPadding(paddingValues2, layoutDirection) + PaddingKt.calculateEndPadding(PaddingValues.this, layoutDirection)));
                    GridCells gridCells2 = gridCells;
                    Arrangement.Horizontal horizontal2 = horizontal;
                    int[] intArray = CollectionsKt.toIntArray(gridCells2.calculateCrossAxisCellSizes(density, m2578getMaxWidthimpl, density.mo206roundToPx0680j_4(horizontal2.getSpacing())));
                    int[] iArr = new int[intArray.length];
                    horizontal2.arrange(density, m2578getMaxWidthimpl, intArray, layoutDirection, iArr);
                    return new LazyGridSlots(intArray, iArr);
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        LazyGridSlotsProvider lazyGridSlotsProvider = (LazyGridSlotsProvider) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return lazyGridSlotsProvider;
    }
}
