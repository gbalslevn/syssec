package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001as\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001as\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0007¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/foundation/lazy/LazyListState;", "state", "Landroidx/compose/foundation/layout/PaddingValues;", "contentPadding", BuildConfig.FLAVOR, "reverseLayout", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "horizontalArrangement", "Landroidx/compose/ui/Alignment$Vertical;", "verticalAlignment", "Landroidx/compose/foundation/gestures/FlingBehavior;", "flingBehavior", "userScrollEnabled", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", BuildConfig.FLAVOR, "content", "LazyRow", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalArrangement", "Landroidx/compose/ui/Alignment$Horizontal;", "horizontalAlignment", "LazyColumn", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LazyDslKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyColumn(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z5, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, boolean z6, final Function1<? super LazyListScope, Unit> function1, Composer composer, final int i5, final int i6) {
        int i7;
        PaddingValues paddingValues2;
        int i8;
        boolean z7;
        Arrangement.Vertical vertical2;
        int i9;
        Alignment.Horizontal horizontal2;
        FlingBehavior flingBehavior2;
        int i10;
        Modifier modifier2;
        LazyListState lazyListState2;
        PaddingValues m306PaddingValues0680j_4;
        boolean z8;
        Arrangement.Vertical vertical3;
        Alignment.Horizontal start;
        FlingBehavior flingBehavior3;
        boolean z9;
        final boolean z10;
        final Arrangement.Vertical vertical4;
        final FlingBehavior flingBehavior4;
        boolean z11;
        ScopeUpdateScope endRestartGroup;
        int i11;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-740714857);
        int i14 = i6 & 1;
        if (i14 != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            if ((i6 & 2) == 0 && startRestartGroup.changed(lazyListState)) {
                i13 = 32;
                i7 |= i13;
            }
            i13 = 16;
            i7 |= i13;
        }
        int i15 = i6 & 4;
        if (i15 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            paddingValues2 = paddingValues;
            i7 |= startRestartGroup.changed(paddingValues2) ? 256 : 128;
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                z7 = z5;
                i7 |= startRestartGroup.changed(z7) ? 2048 : 1024;
                if ((i5 & 24576) == 0) {
                    if ((i6 & 16) == 0) {
                        vertical2 = vertical;
                        if (startRestartGroup.changed(vertical2)) {
                            i12 = 16384;
                            i7 |= i12;
                        }
                    } else {
                        vertical2 = vertical;
                    }
                    i12 = 8192;
                    i7 |= i12;
                } else {
                    vertical2 = vertical;
                }
                i9 = i6 & 32;
                if (i9 != 0) {
                    i7 |= 196608;
                } else if ((196608 & i5) == 0) {
                    horizontal2 = horizontal;
                    i7 |= startRestartGroup.changed(horizontal2) ? 131072 : 65536;
                    if ((1572864 & i5) != 0) {
                        if ((i6 & 64) == 0) {
                            flingBehavior2 = flingBehavior;
                            if (startRestartGroup.changed(flingBehavior2)) {
                                i11 = 1048576;
                                i7 |= i11;
                            }
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        i11 = 524288;
                        i7 |= i11;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    i10 = i6 & 128;
                    if (i10 == 0) {
                        i7 |= 12582912;
                    } else if ((i5 & 12582912) == 0) {
                        i7 |= startRestartGroup.changed(z6) ? 8388608 : 4194304;
                    }
                    if ((i6 & 256) == 0) {
                        i7 |= 100663296;
                    } else if ((i5 & 100663296) == 0) {
                        i7 |= startRestartGroup.changedInstance(function1) ? 67108864 : 33554432;
                        if ((i7 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                modifier2 = i14 != 0 ? Modifier.INSTANCE : modifier;
                                if ((i6 & 2) != 0) {
                                    lazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
                                    i7 &= -113;
                                } else {
                                    lazyListState2 = lazyListState;
                                }
                                m306PaddingValues0680j_4 = i15 != 0 ? PaddingKt.m306PaddingValues0680j_4(Dp.m2599constructorimpl(0)) : paddingValues2;
                                z8 = i8 == 0 ? z7 : false;
                                if ((i6 & 16) != 0) {
                                    Arrangement arrangement = Arrangement.INSTANCE;
                                    vertical3 = !z8 ? arrangement.getTop() : arrangement.getBottom();
                                    i7 &= -57345;
                                } else {
                                    vertical3 = vertical2;
                                }
                                start = i9 != 0 ? Alignment.INSTANCE.getStart() : horizontal2;
                                if ((i6 & 64) != 0) {
                                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                    i7 &= -3670017;
                                } else {
                                    flingBehavior3 = flingBehavior2;
                                }
                                z9 = i10 != 0 ? true : z6;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i6 & 2) != 0) {
                                    i7 &= -113;
                                }
                                if ((i6 & 16) != 0) {
                                    i7 &= -57345;
                                }
                                if ((i6 & 64) != 0) {
                                    i7 &= -3670017;
                                }
                                modifier2 = modifier;
                                lazyListState2 = lazyListState;
                                z9 = z6;
                                m306PaddingValues0680j_4 = paddingValues2;
                                z8 = z7;
                                vertical3 = vertical2;
                                start = horizontal2;
                                flingBehavior3 = flingBehavior2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-740714857, i7, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:366)");
                            }
                            int i16 = i7 >> 3;
                            LazyListKt.LazyList(modifier2, lazyListState2, m306PaddingValues0680j_4, z8, true, flingBehavior3, z9, 0, start, vertical3, null, null, function1, startRestartGroup, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (458752 & i16) | (i16 & 3670016) | ((i7 << 9) & 234881024) | ((i7 << 15) & 1879048192), (i7 >> 18) & 896, 3200);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z10 = z8;
                            vertical4 = vertical3;
                            flingBehavior4 = flingBehavior3;
                            z11 = z9;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            lazyListState2 = lazyListState;
                            m306PaddingValues0680j_4 = paddingValues2;
                            z10 = z7;
                            vertical4 = vertical2;
                            start = horizontal2;
                            flingBehavior4 = flingBehavior2;
                            z11 = z6;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final LazyListState lazyListState3 = lazyListState2;
                            final PaddingValues paddingValues3 = m306PaddingValues0680j_4;
                            final Alignment.Horizontal horizontal3 = start;
                            final boolean z12 = z11;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyColumn$1
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
                                    LazyDslKt.LazyColumn(Modifier.this, lazyListState3, paddingValues3, z10, vertical4, horizontal3, flingBehavior4, z12, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i7 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if ((i6 & 2) != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i8 == 0) {
                    }
                    if ((i6 & 16) != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if ((i6 & 64) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i162 = i7 >> 3;
                    LazyListKt.LazyList(modifier2, lazyListState2, m306PaddingValues0680j_4, z8, true, flingBehavior3, z9, 0, start, vertical3, null, null, function1, startRestartGroup, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (458752 & i162) | (i162 & 3670016) | ((i7 << 9) & 234881024) | ((i7 << 15) & 1879048192), (i7 >> 18) & 896, 3200);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z10 = z8;
                    vertical4 = vertical3;
                    flingBehavior4 = flingBehavior3;
                    z11 = z9;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                horizontal2 = horizontal;
                if ((1572864 & i5) != 0) {
                }
                i10 = i6 & 128;
                if (i10 == 0) {
                }
                if ((i6 & 256) == 0) {
                }
                if ((i7 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i14 != 0) {
                }
                if ((i6 & 2) != 0) {
                }
                if (i15 != 0) {
                }
                if (i8 == 0) {
                }
                if ((i6 & 16) != 0) {
                }
                if (i9 != 0) {
                }
                if ((i6 & 64) != 0) {
                }
                if (i10 != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1622 = i7 >> 3;
                LazyListKt.LazyList(modifier2, lazyListState2, m306PaddingValues0680j_4, z8, true, flingBehavior3, z9, 0, start, vertical3, null, null, function1, startRestartGroup, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (458752 & i1622) | (i1622 & 3670016) | ((i7 << 9) & 234881024) | ((i7 << 15) & 1879048192), (i7 >> 18) & 896, 3200);
                if (ComposerKt.isTraceInProgress()) {
                }
                z10 = z8;
                vertical4 = vertical3;
                flingBehavior4 = flingBehavior3;
                z11 = z9;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z7 = z5;
            if ((i5 & 24576) == 0) {
            }
            i9 = i6 & 32;
            if (i9 != 0) {
            }
            horizontal2 = horizontal;
            if ((1572864 & i5) != 0) {
            }
            i10 = i6 & 128;
            if (i10 == 0) {
            }
            if ((i6 & 256) == 0) {
            }
            if ((i7 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i14 != 0) {
            }
            if ((i6 & 2) != 0) {
            }
            if (i15 != 0) {
            }
            if (i8 == 0) {
            }
            if ((i6 & 16) != 0) {
            }
            if (i9 != 0) {
            }
            if ((i6 & 64) != 0) {
            }
            if (i10 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i16222 = i7 >> 3;
            LazyListKt.LazyList(modifier2, lazyListState2, m306PaddingValues0680j_4, z8, true, flingBehavior3, z9, 0, start, vertical3, null, null, function1, startRestartGroup, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (458752 & i16222) | (i16222 & 3670016) | ((i7 << 9) & 234881024) | ((i7 << 15) & 1879048192), (i7 >> 18) & 896, 3200);
            if (ComposerKt.isTraceInProgress()) {
            }
            z10 = z8;
            vertical4 = vertical3;
            flingBehavior4 = flingBehavior3;
            z11 = z9;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        paddingValues2 = paddingValues;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        z7 = z5;
        if ((i5 & 24576) == 0) {
        }
        i9 = i6 & 32;
        if (i9 != 0) {
        }
        horizontal2 = horizontal;
        if ((1572864 & i5) != 0) {
        }
        i10 = i6 & 128;
        if (i10 == 0) {
        }
        if ((i6 & 256) == 0) {
        }
        if ((i7 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i14 != 0) {
        }
        if ((i6 & 2) != 0) {
        }
        if (i15 != 0) {
        }
        if (i8 == 0) {
        }
        if ((i6 & 16) != 0) {
        }
        if (i9 != 0) {
        }
        if ((i6 & 64) != 0) {
        }
        if (i10 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i162222 = i7 >> 3;
        LazyListKt.LazyList(modifier2, lazyListState2, m306PaddingValues0680j_4, z8, true, flingBehavior3, z9, 0, start, vertical3, null, null, function1, startRestartGroup, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (458752 & i162222) | (i162222 & 3670016) | ((i7 << 9) & 234881024) | ((i7 << 15) & 1879048192), (i7 >> 18) & 896, 3200);
        if (ComposerKt.isTraceInProgress()) {
        }
        z10 = z8;
        vertical4 = vertical3;
        flingBehavior4 = flingBehavior3;
        z11 = z9;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyRow(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z5, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, boolean z6, final Function1<? super LazyListScope, Unit> function1, Composer composer, final int i5, final int i6) {
        int i7;
        PaddingValues paddingValues2;
        int i8;
        boolean z7;
        Arrangement.Horizontal horizontal2;
        int i9;
        Alignment.Vertical vertical2;
        FlingBehavior flingBehavior2;
        int i10;
        Modifier modifier2;
        LazyListState lazyListState2;
        PaddingValues m306PaddingValues0680j_4;
        boolean z8;
        Arrangement.Horizontal horizontal3;
        Alignment.Vertical top;
        FlingBehavior flingBehavior3;
        boolean z9;
        final boolean z10;
        final Arrangement.Horizontal horizontal4;
        final FlingBehavior flingBehavior4;
        boolean z11;
        ScopeUpdateScope endRestartGroup;
        int i11;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-1724297413);
        int i14 = i6 & 1;
        if (i14 != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            if ((i6 & 2) == 0 && startRestartGroup.changed(lazyListState)) {
                i13 = 32;
                i7 |= i13;
            }
            i13 = 16;
            i7 |= i13;
        }
        int i15 = i6 & 4;
        if (i15 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            paddingValues2 = paddingValues;
            i7 |= startRestartGroup.changed(paddingValues2) ? 256 : 128;
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                z7 = z5;
                i7 |= startRestartGroup.changed(z7) ? 2048 : 1024;
                if ((i5 & 24576) == 0) {
                    if ((i6 & 16) == 0) {
                        horizontal2 = horizontal;
                        if (startRestartGroup.changed(horizontal2)) {
                            i12 = 16384;
                            i7 |= i12;
                        }
                    } else {
                        horizontal2 = horizontal;
                    }
                    i12 = 8192;
                    i7 |= i12;
                } else {
                    horizontal2 = horizontal;
                }
                i9 = i6 & 32;
                if (i9 != 0) {
                    i7 |= 196608;
                } else if ((196608 & i5) == 0) {
                    vertical2 = vertical;
                    i7 |= startRestartGroup.changed(vertical2) ? 131072 : 65536;
                    if ((1572864 & i5) != 0) {
                        if ((i6 & 64) == 0) {
                            flingBehavior2 = flingBehavior;
                            if (startRestartGroup.changed(flingBehavior2)) {
                                i11 = 1048576;
                                i7 |= i11;
                            }
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        i11 = 524288;
                        i7 |= i11;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    i10 = i6 & 128;
                    if (i10 == 0) {
                        i7 |= 12582912;
                    } else if ((i5 & 12582912) == 0) {
                        i7 |= startRestartGroup.changed(z6) ? 8388608 : 4194304;
                    }
                    if ((i6 & 256) == 0) {
                        i7 |= 100663296;
                    } else if ((i5 & 100663296) == 0) {
                        i7 |= startRestartGroup.changedInstance(function1) ? 67108864 : 33554432;
                        if ((i7 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                modifier2 = i14 != 0 ? Modifier.INSTANCE : modifier;
                                if ((i6 & 2) != 0) {
                                    lazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
                                    i7 &= -113;
                                } else {
                                    lazyListState2 = lazyListState;
                                }
                                m306PaddingValues0680j_4 = i15 != 0 ? PaddingKt.m306PaddingValues0680j_4(Dp.m2599constructorimpl(0)) : paddingValues2;
                                z8 = i8 == 0 ? z7 : false;
                                if ((i6 & 16) != 0) {
                                    Arrangement arrangement = Arrangement.INSTANCE;
                                    horizontal3 = !z8 ? arrangement.getStart() : arrangement.getEnd();
                                    i7 &= -57345;
                                } else {
                                    horizontal3 = horizontal2;
                                }
                                top = i9 != 0 ? Alignment.INSTANCE.getTop() : vertical2;
                                if ((i6 & 64) != 0) {
                                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                    i7 &= -3670017;
                                } else {
                                    flingBehavior3 = flingBehavior2;
                                }
                                z9 = i10 != 0 ? true : z6;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i6 & 2) != 0) {
                                    i7 &= -113;
                                }
                                if ((i6 & 16) != 0) {
                                    i7 &= -57345;
                                }
                                if ((i6 & 64) != 0) {
                                    i7 &= -3670017;
                                }
                                modifier2 = modifier;
                                lazyListState2 = lazyListState;
                                z9 = z6;
                                m306PaddingValues0680j_4 = paddingValues2;
                                z8 = z7;
                                horizontal3 = horizontal2;
                                top = vertical2;
                                flingBehavior3 = flingBehavior2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1724297413, i7, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:310)");
                            }
                            int i16 = i7 >> 3;
                            LazyListKt.LazyList(modifier2, lazyListState2, m306PaddingValues0680j_4, z8, false, flingBehavior3, z9, 0, null, null, top, horizontal3, function1, startRestartGroup, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (458752 & i16) | (i16 & 3670016), ((i7 >> 15) & 14) | ((i7 >> 9) & 112) | ((i7 >> 18) & 896), 896);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z10 = z8;
                            horizontal4 = horizontal3;
                            flingBehavior4 = flingBehavior3;
                            z11 = z9;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            lazyListState2 = lazyListState;
                            m306PaddingValues0680j_4 = paddingValues2;
                            z10 = z7;
                            horizontal4 = horizontal2;
                            top = vertical2;
                            flingBehavior4 = flingBehavior2;
                            z11 = z6;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final LazyListState lazyListState3 = lazyListState2;
                            final PaddingValues paddingValues3 = m306PaddingValues0680j_4;
                            final Alignment.Vertical vertical3 = top;
                            final boolean z12 = z11;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt$LazyRow$1
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
                                    LazyDslKt.LazyRow(Modifier.this, lazyListState3, paddingValues3, z10, horizontal4, vertical3, flingBehavior4, z12, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i7 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if ((i6 & 2) != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i8 == 0) {
                    }
                    if ((i6 & 16) != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if ((i6 & 64) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i162 = i7 >> 3;
                    LazyListKt.LazyList(modifier2, lazyListState2, m306PaddingValues0680j_4, z8, false, flingBehavior3, z9, 0, null, null, top, horizontal3, function1, startRestartGroup, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (458752 & i162) | (i162 & 3670016), ((i7 >> 15) & 14) | ((i7 >> 9) & 112) | ((i7 >> 18) & 896), 896);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z10 = z8;
                    horizontal4 = horizontal3;
                    flingBehavior4 = flingBehavior3;
                    z11 = z9;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                vertical2 = vertical;
                if ((1572864 & i5) != 0) {
                }
                i10 = i6 & 128;
                if (i10 == 0) {
                }
                if ((i6 & 256) == 0) {
                }
                if ((i7 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i14 != 0) {
                }
                if ((i6 & 2) != 0) {
                }
                if (i15 != 0) {
                }
                if (i8 == 0) {
                }
                if ((i6 & 16) != 0) {
                }
                if (i9 != 0) {
                }
                if ((i6 & 64) != 0) {
                }
                if (i10 != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1622 = i7 >> 3;
                LazyListKt.LazyList(modifier2, lazyListState2, m306PaddingValues0680j_4, z8, false, flingBehavior3, z9, 0, null, null, top, horizontal3, function1, startRestartGroup, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (458752 & i1622) | (i1622 & 3670016), ((i7 >> 15) & 14) | ((i7 >> 9) & 112) | ((i7 >> 18) & 896), 896);
                if (ComposerKt.isTraceInProgress()) {
                }
                z10 = z8;
                horizontal4 = horizontal3;
                flingBehavior4 = flingBehavior3;
                z11 = z9;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z7 = z5;
            if ((i5 & 24576) == 0) {
            }
            i9 = i6 & 32;
            if (i9 != 0) {
            }
            vertical2 = vertical;
            if ((1572864 & i5) != 0) {
            }
            i10 = i6 & 128;
            if (i10 == 0) {
            }
            if ((i6 & 256) == 0) {
            }
            if ((i7 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i14 != 0) {
            }
            if ((i6 & 2) != 0) {
            }
            if (i15 != 0) {
            }
            if (i8 == 0) {
            }
            if ((i6 & 16) != 0) {
            }
            if (i9 != 0) {
            }
            if ((i6 & 64) != 0) {
            }
            if (i10 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i16222 = i7 >> 3;
            LazyListKt.LazyList(modifier2, lazyListState2, m306PaddingValues0680j_4, z8, false, flingBehavior3, z9, 0, null, null, top, horizontal3, function1, startRestartGroup, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (458752 & i16222) | (i16222 & 3670016), ((i7 >> 15) & 14) | ((i7 >> 9) & 112) | ((i7 >> 18) & 896), 896);
            if (ComposerKt.isTraceInProgress()) {
            }
            z10 = z8;
            horizontal4 = horizontal3;
            flingBehavior4 = flingBehavior3;
            z11 = z9;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        paddingValues2 = paddingValues;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        z7 = z5;
        if ((i5 & 24576) == 0) {
        }
        i9 = i6 & 32;
        if (i9 != 0) {
        }
        vertical2 = vertical;
        if ((1572864 & i5) != 0) {
        }
        i10 = i6 & 128;
        if (i10 == 0) {
        }
        if ((i6 & 256) == 0) {
        }
        if ((i7 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i14 != 0) {
        }
        if ((i6 & 2) != 0) {
        }
        if (i15 != 0) {
        }
        if (i8 == 0) {
        }
        if ((i6 & 16) != 0) {
        }
        if (i9 != 0) {
        }
        if ((i6 & 64) != 0) {
        }
        if (i10 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i162222 = i7 >> 3;
        LazyListKt.LazyList(modifier2, lazyListState2, m306PaddingValues0680j_4, z8, false, flingBehavior3, z9, 0, null, null, top, horizontal3, function1, startRestartGroup, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (458752 & i162222) | (i162222 & 3670016), ((i7 >> 15) & 14) | ((i7 >> 9) & 112) | ((i7 >> 18) & 896), 896);
        if (ComposerKt.isTraceInProgress()) {
        }
        z10 = z8;
        horizontal4 = horizontal3;
        flingBehavior4 = flingBehavior3;
        z11 = z9;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
