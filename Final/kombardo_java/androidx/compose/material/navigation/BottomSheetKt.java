package androidx.compose.material.navigation;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ModalBottomSheetDefaults;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001ad\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Landroidx/compose/material/navigation/BottomSheetNavigator;", "bottomSheetNavigator", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/Shape;", "sheetShape", "Landroidx/compose/ui/unit/Dp;", "sheetElevation", "Landroidx/compose/ui/graphics/Color;", "sheetBackgroundColor", "sheetContentColor", "scrimColor", "Lkotlin/Function0;", BuildConfig.FLAVOR, "content", "ModalBottomSheetLayout-4erKP6g", "(Landroidx/compose/material/navigation/BottomSheetNavigator;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ModalBottomSheetLayout", "material-navigation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BottomSheetKt {
    /* JADX WARN: Code restructure failed: missing block: B:81:0x013e, code lost:
    
        if ((r44 & 64) != 0) goto L119;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x015f  */
    /* renamed from: ModalBottomSheetLayout-4erKP6g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m748ModalBottomSheetLayout4erKP6g(final BottomSheetNavigator bottomSheetNavigator, Modifier modifier, Shape shape, float f5, long j5, long j6, long j7, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        Shape shape2;
        float f6;
        long j8;
        long j9;
        long j10;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(1212945855);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = ((i5 & 8) == 0 ? startRestartGroup.changed(bottomSheetNavigator) : startRestartGroup.changedInstance(bottomSheetNavigator) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i13 = i6 & 2;
        if (i13 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i5 & 384) != 0) {
                if ((i6 & 4) == 0) {
                    shape2 = shape;
                    if (startRestartGroup.changed(shape2)) {
                        i12 = 256;
                        i7 |= i12;
                    }
                } else {
                    shape2 = shape;
                }
                i12 = 128;
                i7 |= i12;
            } else {
                shape2 = shape;
            }
            if ((i5 & 3072) != 0) {
                if ((i6 & 8) == 0) {
                    f6 = f5;
                    if (startRestartGroup.changed(f6)) {
                        i11 = 2048;
                        i7 |= i11;
                    }
                } else {
                    f6 = f5;
                }
                i11 = 1024;
                i7 |= i11;
            } else {
                f6 = f5;
            }
            if ((i5 & 24576) != 0) {
                if ((i6 & 16) == 0) {
                    j8 = j5;
                    if (startRestartGroup.changed(j8)) {
                        i10 = 16384;
                        i7 |= i10;
                    }
                } else {
                    j8 = j5;
                }
                i10 = 8192;
                i7 |= i10;
            } else {
                j8 = j5;
            }
            if ((196608 & i5) != 0) {
                if ((i6 & 32) == 0) {
                    j9 = j6;
                    if (startRestartGroup.changed(j9)) {
                        i9 = 131072;
                        i7 |= i9;
                    }
                } else {
                    j9 = j6;
                }
                i9 = 65536;
                i7 |= i9;
            } else {
                j9 = j6;
            }
            if ((1572864 & i5) != 0) {
                if ((i6 & 64) == 0) {
                    j10 = j7;
                    if (startRestartGroup.changed(j10)) {
                        i8 = 1048576;
                        i7 |= i8;
                    }
                } else {
                    j10 = j7;
                }
                i8 = 524288;
                i7 |= i8;
            } else {
                j10 = j7;
            }
            if ((i6 & 128) == 0) {
                i7 |= 12582912;
            } else if ((i5 & 12582912) == 0) {
                i7 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                if ((i7 & 4793491) == 4793490 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i6 & 4) != 0) {
                            i7 &= -897;
                            shape2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getLarge();
                        }
                        if ((i6 & 8) != 0) {
                            i7 &= -7169;
                            f6 = ModalBottomSheetDefaults.INSTANCE.m707getElevationD9Ej5fM();
                        }
                        if ((i6 & 16) != 0) {
                            j8 = MaterialTheme.INSTANCE.getColors(startRestartGroup, MaterialTheme.$stable).m671getSurface0d7_KjU();
                            i7 &= -57345;
                        }
                        if ((i6 & 32) != 0) {
                            j9 = ColorsKt.m673contentColorForek8zF_U(j8, startRestartGroup, (i7 >> 12) & 14);
                            i7 &= -458753;
                        }
                        if ((i6 & 64) != 0) {
                            j10 = ModalBottomSheetDefaults.INSTANCE.getScrimColor(startRestartGroup, ModalBottomSheetDefaults.$stable);
                            i7 &= -3670017;
                        }
                        long j11 = j10;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1212945855, i7, -1, "androidx.compose.material.navigation.ModalBottomSheetLayout (BottomSheet.kt:45)");
                        }
                        ModalBottomSheetState sheetState = bottomSheetNavigator.getSheetState();
                        Function3<ColumnScope, Composer, Integer, Unit> sheetContent$material_navigation_release = bottomSheetNavigator.getSheetContent$material_navigation_release();
                        int i14 = (i7 & 112) | (ModalBottomSheetState.$stable << 6);
                        int i15 = i7 << 6;
                        ModalBottomSheetKt.m708ModalBottomSheetLayoutGs3lGvM(sheetContent$material_navigation_release, modifier2, sheetState, false, shape2, f6, j8, j9, j11, function2, startRestartGroup, i14 | (57344 & i15) | (458752 & i15) | (3670016 & i15) | (29360128 & i15) | (234881024 & i15) | (i15 & 1879048192), 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j10 = j11;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i6 & 4) != 0) {
                            i7 &= -897;
                        }
                        if ((i6 & 8) != 0) {
                            i7 &= -7169;
                        }
                        if ((i6 & 16) != 0) {
                            i7 &= -57345;
                        }
                        if ((i6 & 32) != 0) {
                            i7 &= -458753;
                        }
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                }
                final Shape shape3 = shape2;
                final float f7 = f6;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier3 = modifier2;
                    final long j12 = j8;
                    final long j13 = j9;
                    final long j14 = j10;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.navigation.BottomSheetKt$ModalBottomSheetLayout$1
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
                            BottomSheetKt.m748ModalBottomSheetLayout4erKP6g(BottomSheetNavigator.this, modifier3, shape3, f7, j12, j13, j14, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                        }
                    });
                    return;
                }
                return;
            }
            if ((i7 & 4793491) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i13 != 0) {
            }
            if ((i6 & 4) != 0) {
            }
            if ((i6 & 8) != 0) {
            }
            if ((i6 & 16) != 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if ((i6 & 64) != 0) {
            }
            long j112 = j10;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ModalBottomSheetState sheetState2 = bottomSheetNavigator.getSheetState();
            Function3<ColumnScope, Composer, Integer, Unit> sheetContent$material_navigation_release2 = bottomSheetNavigator.getSheetContent$material_navigation_release();
            int i142 = (i7 & 112) | (ModalBottomSheetState.$stable << 6);
            int i152 = i7 << 6;
            ModalBottomSheetKt.m708ModalBottomSheetLayoutGs3lGvM(sheetContent$material_navigation_release2, modifier2, sheetState2, false, shape2, f6, j8, j9, j112, function2, startRestartGroup, i142 | (57344 & i152) | (458752 & i152) | (3670016 & i152) | (29360128 & i152) | (234881024 & i152) | (i152 & 1879048192), 8);
            if (ComposerKt.isTraceInProgress()) {
            }
            j10 = j112;
            final Shape shape32 = shape2;
            final float f72 = f6;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i5 & 384) != 0) {
        }
        if ((i5 & 3072) != 0) {
        }
        if ((i5 & 24576) != 0) {
        }
        if ((196608 & i5) != 0) {
        }
        if ((1572864 & i5) != 0) {
        }
        if ((i6 & 128) == 0) {
        }
        if ((i7 & 4793491) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i13 != 0) {
        }
        if ((i6 & 4) != 0) {
        }
        if ((i6 & 8) != 0) {
        }
        if ((i6 & 16) != 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if ((i6 & 64) != 0) {
        }
        long j1122 = j10;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ModalBottomSheetState sheetState22 = bottomSheetNavigator.getSheetState();
        Function3<ColumnScope, Composer, Integer, Unit> sheetContent$material_navigation_release22 = bottomSheetNavigator.getSheetContent$material_navigation_release();
        int i1422 = (i7 & 112) | (ModalBottomSheetState.$stable << 6);
        int i1522 = i7 << 6;
        ModalBottomSheetKt.m708ModalBottomSheetLayoutGs3lGvM(sheetContent$material_navigation_release22, modifier2, sheetState22, false, shape2, f6, j8, j9, j1122, function2, startRestartGroup, i1422 | (57344 & i1522) | (458752 & i1522) | (3670016 & i1522) | (29360128 & i1522) | (234881024 & i1522) | (i1522 & 1879048192), 8);
        if (ComposerKt.isTraceInProgress()) {
        }
        j10 = j1122;
        final Shape shape322 = shape2;
        final float f722 = f6;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
