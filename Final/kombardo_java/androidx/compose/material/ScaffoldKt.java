package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material.FabPosition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a#\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0084\u0002\u0010(\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u00102\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020\u001e2\b\b\u0002\u0010\"\u001a\u00020\u001e2\b\b\u0002\u0010#\u001a\u00020\u001e2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\r0\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001aü\u0001\u0010(\u001a\u00020\r2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u00102\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020\u001e2\b\b\u0002\u0010\"\u001a\u00020\u001e2\b\b\u0002\u0010#\u001a\u00020\u001e2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\r0\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001av\u00101\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00132\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\r0\u00102\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0003ø\u0001\u0000¢\u0006\u0004\b/\u00100\"\"\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u000103028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0014\u00108\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006:"}, d2 = {"Landroidx/compose/material/DrawerState;", "drawerState", "Landroidx/compose/material/SnackbarHostState;", "snackbarHostState", "Landroidx/compose/material/ScaffoldState;", "rememberScaffoldState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ScaffoldState;", "Landroidx/compose/foundation/layout/WindowInsets;", "contentWindowInsets", "Landroidx/compose/ui/Modifier;", "modifier", "scaffoldState", "Lkotlin/Function0;", BuildConfig.FLAVOR, "topBar", "bottomBar", "Lkotlin/Function1;", "snackbarHost", "floatingActionButton", "Landroidx/compose/material/FabPosition;", "floatingActionButtonPosition", BuildConfig.FLAVOR, "isFloatingActionButtonDocked", "Landroidx/compose/foundation/layout/ColumnScope;", "drawerContent", "drawerGesturesEnabled", "Landroidx/compose/ui/graphics/Shape;", "drawerShape", "Landroidx/compose/ui/unit/Dp;", "drawerElevation", "Landroidx/compose/ui/graphics/Color;", "drawerBackgroundColor", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Scaffold-u4IkXBM", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Scaffold", "Scaffold-27mzLpw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "isFabDocked", "fabPosition", "snackbar", "fab", "ScaffoldLayout-i1QSOvI", "(ZILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ScaffoldLayout", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/FabPlacement;", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "FabSpacing", "F", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ScaffoldKt {
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(new Function0<FabPlacement>() { // from class: androidx.compose.material.ScaffoldKt$LocalFabPlacement$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FabPlacement invoke() {
            return null;
        }
    });
    private static final float FabSpacing = Dp.m2599constructorimpl(16);

    /* JADX WARN: Code restructure failed: missing block: B:63:0x01a2, code lost:
    
        if (r0.changed(r72) == false) goto L147;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0225  */
    /* renamed from: Scaffold-27mzLpw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m719Scaffold27mzLpw(Modifier modifier, ScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function23, int i5, boolean z5, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, boolean z6, Shape shape, float f5, long j5, long j6, long j7, long j8, long j9, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33, Composer composer, final int i6, final int i7, final int i8) {
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z7;
        int i16;
        int i17;
        int i18;
        int i19;
        Modifier modifier2;
        ScaffoldState scaffoldState2;
        Function2<? super Composer, ? super Integer, Unit> m680getLambda5$material_release;
        Function2<? super Composer, ? super Integer, Unit> m681getLambda6$material_release;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> m682getLambda7$material_release;
        Function2<? super Composer, ? super Integer, Unit> m683getLambda8$material_release;
        int m700getEnd5ygKITE;
        boolean z8;
        final Shape shape2;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function34;
        boolean z9;
        int i20;
        long j10;
        long j11;
        long j12;
        int i21;
        long j13;
        long j14;
        boolean z10;
        long j15;
        long j16;
        int i22;
        int i23;
        long j17;
        long j18;
        long j19;
        final Modifier modifier3;
        final ScaffoldState scaffoldState3;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function35;
        float f6;
        Composer composer2;
        final long j20;
        long j21;
        final long j22;
        final long j23;
        final long j24;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function36;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final boolean z11;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final int i24;
        final float f7;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function37;
        final boolean z12;
        ScopeUpdateScope endRestartGroup;
        int i25;
        int i26;
        int i27;
        Composer startRestartGroup = composer.startRestartGroup(1037492569);
        int i28 = i8 & 1;
        if (i28 != 0) {
            i9 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i9 = (startRestartGroup.changed(modifier) ? 4 : 2) | i6;
        } else {
            i9 = i6;
        }
        if ((i6 & 48) == 0) {
            if ((i8 & 2) == 0 && startRestartGroup.changed(scaffoldState)) {
                i27 = 32;
                i9 |= i27;
            }
            i27 = 16;
            i9 |= i27;
        }
        int i29 = i8 & 4;
        if (i29 != 0) {
            i9 |= 384;
        } else if ((i6 & 384) == 0) {
            function24 = function2;
            i9 |= startRestartGroup.changedInstance(function24) ? 256 : 128;
            i10 = i8 & 8;
            int i30 = 2048;
            if (i10 == 0) {
                i9 |= 3072;
            } else if ((i6 & 3072) == 0) {
                i9 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
                i11 = i8 & 16;
                int i31 = 8192;
                if (i11 != 0) {
                    i9 |= 24576;
                } else if ((i6 & 24576) == 0) {
                    i9 |= startRestartGroup.changedInstance(function3) ? 16384 : 8192;
                    i12 = i8 & 32;
                    if (i12 == 0) {
                        i9 |= 196608;
                    } else if ((i6 & 196608) == 0) {
                        i9 |= startRestartGroup.changedInstance(function23) ? 131072 : 65536;
                    }
                    i13 = i8 & 64;
                    if (i13 == 0) {
                        i9 |= 1572864;
                        i14 = i5;
                    } else {
                        i14 = i5;
                        if ((i6 & 1572864) == 0) {
                            i9 |= startRestartGroup.changed(i14) ? 1048576 : 524288;
                        }
                    }
                    i15 = i8 & 128;
                    if (i15 == 0) {
                        i9 |= 12582912;
                        z7 = z5;
                    } else {
                        z7 = z5;
                        if ((i6 & 12582912) == 0) {
                            i9 |= startRestartGroup.changed(z7) ? 8388608 : 4194304;
                        }
                    }
                    i16 = i8 & 256;
                    if (i16 == 0) {
                        i9 |= 100663296;
                    } else if ((i6 & 100663296) == 0) {
                        i9 |= startRestartGroup.changedInstance(function32) ? 67108864 : 33554432;
                    }
                    i17 = i8 & 512;
                    if (i17 == 0) {
                        i9 |= 805306368;
                    } else if ((i6 & 805306368) == 0) {
                        i9 |= startRestartGroup.changed(z6) ? 536870912 : 268435456;
                    }
                    if ((i7 & 6) != 0) {
                        if ((i8 & 1024) == 0 && startRestartGroup.changed(shape)) {
                            i26 = 4;
                            i18 = i7 | i26;
                        }
                        i26 = 2;
                        i18 = i7 | i26;
                    } else {
                        i18 = i7;
                    }
                    i19 = i8 & 2048;
                    if (i19 == 0) {
                        i18 |= 48;
                    } else if ((i7 & 48) == 0) {
                        i18 |= startRestartGroup.changed(f5) ? 32 : 16;
                    }
                    if ((i7 & 384) == 0) {
                        if ((i8 & 4096) == 0 && startRestartGroup.changed(j5)) {
                            i25 = 256;
                            i18 |= i25;
                        }
                        i25 = 128;
                        i18 |= i25;
                    }
                    if ((i7 & 3072) == 0) {
                        if ((i8 & 8192) != 0) {
                        }
                        i30 = 1024;
                        i18 |= i30;
                    }
                    if ((i7 & 24576) == 0) {
                        if ((i8 & 16384) == 0 && startRestartGroup.changed(j7)) {
                            i31 = 16384;
                        }
                        i18 |= i31;
                    }
                    if ((i7 & 196608) == 0) {
                        i18 |= ((i8 & 32768) == 0 && startRestartGroup.changed(j8)) ? 131072 : 65536;
                    }
                    if ((i7 & 1572864) == 0) {
                        i18 |= ((i8 & 65536) == 0 && startRestartGroup.changed(j9)) ? 1048576 : 524288;
                    }
                    if ((i8 & 131072) == 0) {
                        i18 |= 12582912;
                    } else if ((i7 & 12582912) == 0) {
                        i18 |= startRestartGroup.changedInstance(function33) ? 8388608 : 4194304;
                    }
                    if ((i9 & 306783379) != 306783378 && (i18 & 4793491) == 4793490 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        scaffoldState3 = scaffoldState;
                        function27 = function22;
                        function37 = function3;
                        function26 = function23;
                        function36 = function32;
                        z11 = z6;
                        j20 = j5;
                        j21 = j6;
                        j22 = j7;
                        j23 = j8;
                        j24 = j9;
                        composer2 = startRestartGroup;
                        i24 = i14;
                        z12 = z7;
                        function25 = function24;
                        shape2 = shape;
                        f7 = f5;
                    } else {
                        startRestartGroup.startDefaults();
                        if ((i6 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier4 = i28 == 0 ? Modifier.INSTANCE : modifier;
                            if ((i8 & 2) == 0) {
                                modifier2 = modifier4;
                                scaffoldState2 = rememberScaffoldState(null, null, startRestartGroup, 0, 3);
                                i9 &= -113;
                            } else {
                                modifier2 = modifier4;
                                scaffoldState2 = scaffoldState;
                            }
                            m680getLambda5$material_release = i29 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m680getLambda5$material_release() : function24;
                            m681getLambda6$material_release = i10 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m681getLambda6$material_release() : function22;
                            m682getLambda7$material_release = i11 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m682getLambda7$material_release() : function3;
                            m683getLambda8$material_release = i12 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m683getLambda8$material_release() : function23;
                            m700getEnd5ygKITE = i13 == 0 ? FabPosition.INSTANCE.m700getEnd5ygKITE() : i5;
                            z8 = i15 == 0 ? false : z7;
                            Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function38 = i16 == 0 ? null : function32;
                            boolean z13 = i17 == 0 ? true : z6;
                            ScaffoldState scaffoldState4 = scaffoldState2;
                            if ((i8 & 1024) == 0) {
                                shape2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getLarge();
                                i18 &= -15;
                            } else {
                                shape2 = shape;
                            }
                            int i32 = i18;
                            float m688getElevationD9Ej5fM = i19 == 0 ? DrawerDefaults.INSTANCE.m688getElevationD9Ej5fM() : f5;
                            if ((i8 & 4096) == 0) {
                                function34 = function38;
                                boolean z14 = z13;
                                i20 = i32 & (-897);
                                j10 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m671getSurface0d7_KjU();
                                z9 = z14;
                            } else {
                                function34 = function38;
                                z9 = z13;
                                i20 = i32;
                                j10 = j5;
                            }
                            float f8 = m688getElevationD9Ej5fM;
                            if ((i8 & 8192) == 0) {
                                j11 = ColorsKt.m673contentColorForek8zF_U(j10, startRestartGroup, (i20 >> 6) & 14);
                                i20 &= -7169;
                            } else {
                                j11 = j6;
                            }
                            if ((i8 & 16384) == 0) {
                                j12 = j10;
                                i21 = 6;
                                j13 = DrawerDefaults.INSTANCE.getScrimColor(startRestartGroup, 6);
                                i20 &= -57345;
                            } else {
                                j12 = j10;
                                i21 = 6;
                                j13 = j7;
                            }
                            if ((32768 & i8) == 0) {
                                j14 = MaterialTheme.INSTANCE.getColors(startRestartGroup, i21).m660getBackground0d7_KjU();
                                i20 &= -458753;
                            } else {
                                j14 = j8;
                            }
                            if ((i8 & 65536) == 0) {
                                z10 = z9;
                                j16 = j14;
                                i22 = i20 & (-3670017);
                                i23 = i9;
                                j17 = j11;
                                j18 = j12;
                                j19 = j13;
                                j15 = ColorsKt.m673contentColorForek8zF_U(j14, startRestartGroup, (i20 >> 15) & 14);
                            } else {
                                z10 = z9;
                                j15 = j9;
                                j16 = j14;
                                i22 = i20;
                                i23 = i9;
                                j17 = j11;
                                j18 = j12;
                                j19 = j13;
                            }
                            modifier3 = modifier2;
                            scaffoldState3 = scaffoldState4;
                            function35 = function34;
                            f6 = f8;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i8 & 2) != 0) {
                                i9 &= -113;
                            }
                            if ((i8 & 1024) != 0) {
                                i18 &= -15;
                            }
                            int i33 = i18;
                            if ((i8 & 4096) != 0) {
                                i33 &= -897;
                            }
                            if ((i8 & 8192) != 0) {
                                i33 &= -7169;
                            }
                            if ((i8 & 16384) != 0) {
                                i33 &= -57345;
                            }
                            if ((32768 & i8) != 0) {
                                i33 &= -458753;
                            }
                            if ((i8 & 65536) != 0) {
                                i33 &= -3670017;
                            }
                            scaffoldState3 = scaffoldState;
                            m681getLambda6$material_release = function22;
                            m683getLambda8$material_release = function23;
                            function35 = function32;
                            z10 = z6;
                            j18 = j5;
                            j17 = j6;
                            j19 = j7;
                            j16 = j8;
                            j15 = j9;
                            i22 = i33;
                            i23 = i9;
                            z8 = z7;
                            m680getLambda5$material_release = function24;
                            modifier3 = modifier;
                            shape2 = shape;
                            f6 = f5;
                            m700getEnd5ygKITE = i14;
                            m682getLambda7$material_release = function3;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            composer2 = startRestartGroup;
                        } else {
                            composer2 = startRestartGroup;
                            ComposerKt.traceEventStart(1037492569, i23, i22, "androidx.compose.material.Scaffold (Scaffold.kt:330)");
                        }
                        int i34 = i22 << 3;
                        m720Scaffoldu4IkXBM(WindowInsetsKt.m347WindowInsetsa9UjIt4$default(Dp.m2599constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null), modifier3, scaffoldState3, m680getLambda5$material_release, m681getLambda6$material_release, m682getLambda7$material_release, m683getLambda8$material_release, m700getEnd5ygKITE, z8, function35, z10, shape2, f6, j18, j17, j19, j16, j15, function33, composer2, (i23 << 3) & 2147483632, ((i23 >> 27) & 14) | (i34 & 112) | (i34 & 896) | (i34 & 7168) | (57344 & i34) | (458752 & i34) | (3670016 & i34) | (29360128 & i34) | (i34 & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j20 = j18;
                        j21 = j17;
                        j22 = j19;
                        j23 = j16;
                        j24 = j15;
                        Function2<? super Composer, ? super Integer, Unit> function28 = m683getLambda8$material_release;
                        function36 = function35;
                        function25 = m680getLambda5$material_release;
                        function26 = function28;
                        boolean z15 = z8;
                        z11 = z10;
                        function27 = m681getLambda6$material_release;
                        i24 = m700getEnd5ygKITE;
                        f7 = f6;
                        function37 = m682getLambda7$material_release;
                        z12 = z15;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        final long j25 = j21;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$3
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

                            public final void invoke(Composer composer3, int i35) {
                                ScaffoldKt.m719Scaffold27mzLpw(Modifier.this, scaffoldState3, function25, function27, function37, function26, i24, z12, function36, z11, shape2, f7, j20, j25, j22, j23, j24, function33, composer3, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), RecomposeScopeImplKt.updateChangedFlags(i7), i8);
                            }
                        });
                        return;
                    }
                    return;
                }
                i12 = i8 & 32;
                if (i12 == 0) {
                }
                i13 = i8 & 64;
                if (i13 == 0) {
                }
                i15 = i8 & 128;
                if (i15 == 0) {
                }
                i16 = i8 & 256;
                if (i16 == 0) {
                }
                i17 = i8 & 512;
                if (i17 == 0) {
                }
                if ((i7 & 6) != 0) {
                }
                i19 = i8 & 2048;
                if (i19 == 0) {
                }
                if ((i7 & 384) == 0) {
                }
                if ((i7 & 3072) == 0) {
                }
                if ((i7 & 24576) == 0) {
                }
                if ((i7 & 196608) == 0) {
                }
                if ((i7 & 1572864) == 0) {
                }
                if ((i8 & 131072) == 0) {
                }
                if ((i9 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i6 & 1) != 0) {
                }
                if (i28 == 0) {
                }
                if ((i8 & 2) == 0) {
                }
                if (i29 == 0) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if (i12 == 0) {
                }
                if (i13 == 0) {
                }
                if (i15 == 0) {
                }
                if (i16 == 0) {
                }
                if (i17 == 0) {
                }
                ScaffoldState scaffoldState42 = scaffoldState2;
                if ((i8 & 1024) == 0) {
                }
                int i322 = i18;
                if (i19 == 0) {
                }
                if ((i8 & 4096) == 0) {
                }
                float f82 = m688getElevationD9Ej5fM;
                if ((i8 & 8192) == 0) {
                }
                if ((i8 & 16384) == 0) {
                }
                if ((32768 & i8) == 0) {
                }
                if ((i8 & 65536) == 0) {
                }
                modifier3 = modifier2;
                scaffoldState3 = scaffoldState42;
                function35 = function34;
                f6 = f82;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i342 = i22 << 3;
                m720Scaffoldu4IkXBM(WindowInsetsKt.m347WindowInsetsa9UjIt4$default(Dp.m2599constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null), modifier3, scaffoldState3, m680getLambda5$material_release, m681getLambda6$material_release, m682getLambda7$material_release, m683getLambda8$material_release, m700getEnd5ygKITE, z8, function35, z10, shape2, f6, j18, j17, j19, j16, j15, function33, composer2, (i23 << 3) & 2147483632, ((i23 >> 27) & 14) | (i342 & 112) | (i342 & 896) | (i342 & 7168) | (57344 & i342) | (458752 & i342) | (3670016 & i342) | (29360128 & i342) | (i342 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                j20 = j18;
                j21 = j17;
                j22 = j19;
                j23 = j16;
                j24 = j15;
                Function2<? super Composer, ? super Integer, Unit> function282 = m683getLambda8$material_release;
                function36 = function35;
                function25 = m680getLambda5$material_release;
                function26 = function282;
                boolean z152 = z8;
                z11 = z10;
                function27 = m681getLambda6$material_release;
                i24 = m700getEnd5ygKITE;
                f7 = f6;
                function37 = m682getLambda7$material_release;
                z12 = z152;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i11 = i8 & 16;
            int i312 = 8192;
            if (i11 != 0) {
            }
            i12 = i8 & 32;
            if (i12 == 0) {
            }
            i13 = i8 & 64;
            if (i13 == 0) {
            }
            i15 = i8 & 128;
            if (i15 == 0) {
            }
            i16 = i8 & 256;
            if (i16 == 0) {
            }
            i17 = i8 & 512;
            if (i17 == 0) {
            }
            if ((i7 & 6) != 0) {
            }
            i19 = i8 & 2048;
            if (i19 == 0) {
            }
            if ((i7 & 384) == 0) {
            }
            if ((i7 & 3072) == 0) {
            }
            if ((i7 & 24576) == 0) {
            }
            if ((i7 & 196608) == 0) {
            }
            if ((i7 & 1572864) == 0) {
            }
            if ((i8 & 131072) == 0) {
            }
            if ((i9 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i6 & 1) != 0) {
            }
            if (i28 == 0) {
            }
            if ((i8 & 2) == 0) {
            }
            if (i29 == 0) {
            }
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if (i12 == 0) {
            }
            if (i13 == 0) {
            }
            if (i15 == 0) {
            }
            if (i16 == 0) {
            }
            if (i17 == 0) {
            }
            ScaffoldState scaffoldState422 = scaffoldState2;
            if ((i8 & 1024) == 0) {
            }
            int i3222 = i18;
            if (i19 == 0) {
            }
            if ((i8 & 4096) == 0) {
            }
            float f822 = m688getElevationD9Ej5fM;
            if ((i8 & 8192) == 0) {
            }
            if ((i8 & 16384) == 0) {
            }
            if ((32768 & i8) == 0) {
            }
            if ((i8 & 65536) == 0) {
            }
            modifier3 = modifier2;
            scaffoldState3 = scaffoldState422;
            function35 = function34;
            f6 = f822;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i3422 = i22 << 3;
            m720Scaffoldu4IkXBM(WindowInsetsKt.m347WindowInsetsa9UjIt4$default(Dp.m2599constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null), modifier3, scaffoldState3, m680getLambda5$material_release, m681getLambda6$material_release, m682getLambda7$material_release, m683getLambda8$material_release, m700getEnd5ygKITE, z8, function35, z10, shape2, f6, j18, j17, j19, j16, j15, function33, composer2, (i23 << 3) & 2147483632, ((i23 >> 27) & 14) | (i3422 & 112) | (i3422 & 896) | (i3422 & 7168) | (57344 & i3422) | (458752 & i3422) | (3670016 & i3422) | (29360128 & i3422) | (i3422 & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            j20 = j18;
            j21 = j17;
            j22 = j19;
            j23 = j16;
            j24 = j15;
            Function2<? super Composer, ? super Integer, Unit> function2822 = m683getLambda8$material_release;
            function36 = function35;
            function25 = m680getLambda5$material_release;
            function26 = function2822;
            boolean z1522 = z8;
            z11 = z10;
            function27 = m681getLambda6$material_release;
            i24 = m700getEnd5ygKITE;
            f7 = f6;
            function37 = m682getLambda7$material_release;
            z12 = z1522;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        function24 = function2;
        i10 = i8 & 8;
        int i302 = 2048;
        if (i10 == 0) {
        }
        i11 = i8 & 16;
        int i3122 = 8192;
        if (i11 != 0) {
        }
        i12 = i8 & 32;
        if (i12 == 0) {
        }
        i13 = i8 & 64;
        if (i13 == 0) {
        }
        i15 = i8 & 128;
        if (i15 == 0) {
        }
        i16 = i8 & 256;
        if (i16 == 0) {
        }
        i17 = i8 & 512;
        if (i17 == 0) {
        }
        if ((i7 & 6) != 0) {
        }
        i19 = i8 & 2048;
        if (i19 == 0) {
        }
        if ((i7 & 384) == 0) {
        }
        if ((i7 & 3072) == 0) {
        }
        if ((i7 & 24576) == 0) {
        }
        if ((i7 & 196608) == 0) {
        }
        if ((i7 & 1572864) == 0) {
        }
        if ((i8 & 131072) == 0) {
        }
        if ((i9 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i6 & 1) != 0) {
        }
        if (i28 == 0) {
        }
        if ((i8 & 2) == 0) {
        }
        if (i29 == 0) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (i12 == 0) {
        }
        if (i13 == 0) {
        }
        if (i15 == 0) {
        }
        if (i16 == 0) {
        }
        if (i17 == 0) {
        }
        ScaffoldState scaffoldState4222 = scaffoldState2;
        if ((i8 & 1024) == 0) {
        }
        int i32222 = i18;
        if (i19 == 0) {
        }
        if ((i8 & 4096) == 0) {
        }
        float f8222 = m688getElevationD9Ej5fM;
        if ((i8 & 8192) == 0) {
        }
        if ((i8 & 16384) == 0) {
        }
        if ((32768 & i8) == 0) {
        }
        if ((i8 & 65536) == 0) {
        }
        modifier3 = modifier2;
        scaffoldState3 = scaffoldState4222;
        function35 = function34;
        f6 = f8222;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i34222 = i22 << 3;
        m720Scaffoldu4IkXBM(WindowInsetsKt.m347WindowInsetsa9UjIt4$default(Dp.m2599constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null), modifier3, scaffoldState3, m680getLambda5$material_release, m681getLambda6$material_release, m682getLambda7$material_release, m683getLambda8$material_release, m700getEnd5ygKITE, z8, function35, z10, shape2, f6, j18, j17, j19, j16, j15, function33, composer2, (i23 << 3) & 2147483632, ((i23 >> 27) & 14) | (i34222 & 112) | (i34222 & 896) | (i34222 & 7168) | (57344 & i34222) | (458752 & i34222) | (3670016 & i34222) | (29360128 & i34222) | (i34222 & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        j20 = j18;
        j21 = j17;
        j22 = j19;
        j23 = j16;
        j24 = j15;
        Function2<? super Composer, ? super Integer, Unit> function28222 = m683getLambda8$material_release;
        function36 = function35;
        function25 = m680getLambda5$material_release;
        function26 = function28222;
        boolean z15222 = z8;
        z11 = z10;
        function27 = m681getLambda6$material_release;
        i24 = m700getEnd5ygKITE;
        f7 = f6;
        function37 = m682getLambda7$material_release;
        z12 = z15222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x021f  */
    /* renamed from: Scaffold-u4IkXBM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m720Scaffoldu4IkXBM(final WindowInsets windowInsets, Modifier modifier, ScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function23, int i5, boolean z5, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, boolean z6, Shape shape, float f5, long j5, long j6, long j7, long j8, long j9, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33, Composer composer, final int i6, final int i7, final int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        Modifier modifier2;
        ScaffoldState scaffoldState2;
        Function2<? super Composer, ? super Integer, Unit> m676getLambda1$material_release;
        Function2<? super Composer, ? super Integer, Unit> m677getLambda2$material_release;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> m678getLambda3$material_release;
        Function2<? super Composer, ? super Integer, Unit> m679getLambda4$material_release;
        int m700getEnd5ygKITE;
        boolean z7;
        Shape shape2;
        float m688getElevationD9Ej5fM;
        Shape shape3;
        long j10;
        final long j11;
        long j12;
        int i20;
        long j13;
        long j14;
        int i21;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function34;
        long j15;
        long j16;
        long j17;
        int i22;
        final Modifier modifier3;
        boolean z8;
        Shape shape4;
        Shape shape5;
        float f6;
        boolean z9;
        Object rememberedValue;
        ScaffoldState scaffoldState3;
        final float f7;
        final ScaffoldState scaffoldState4;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final int i23;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final long j18;
        final long j19;
        final long j20;
        final long j21;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function35;
        final boolean z10;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function36;
        final Shape shape6;
        final boolean z11;
        ScopeUpdateScope endRestartGroup;
        int i24;
        int i25;
        Composer startRestartGroup = composer.startRestartGroup(-1288630565);
        if ((i8 & 1) != 0) {
            i9 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i9 = (startRestartGroup.changed(windowInsets) ? 4 : 2) | i6;
        } else {
            i9 = i6;
        }
        int i26 = i8 & 2;
        if (i26 != 0) {
            i9 |= 48;
        } else if ((i6 & 48) == 0) {
            i9 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i6 & 384) == 0) {
                if ((i8 & 4) == 0 && startRestartGroup.changed(scaffoldState)) {
                    i25 = 256;
                    i9 |= i25;
                }
                i25 = 128;
                i9 |= i25;
            }
            i10 = i8 & 8;
            int i27 = 1024;
            if (i10 == 0) {
                i9 |= 3072;
            } else if ((i6 & 3072) == 0) {
                i9 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
                i11 = i8 & 16;
                int i28 = 8192;
                if (i11 != 0) {
                    i9 |= 24576;
                } else if ((i6 & 24576) == 0) {
                    i9 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
                    i12 = i8 & 32;
                    if (i12 == 0) {
                        i9 |= 196608;
                    } else if ((i6 & 196608) == 0) {
                        i9 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
                    }
                    i13 = i8 & 64;
                    if (i13 == 0) {
                        i9 |= 1572864;
                    } else if ((i6 & 1572864) == 0) {
                        i9 |= startRestartGroup.changedInstance(function23) ? 1048576 : 524288;
                    }
                    i14 = i8 & 128;
                    if (i14 == 0) {
                        i9 |= 12582912;
                    } else if ((i6 & 12582912) == 0) {
                        i9 |= startRestartGroup.changed(i5) ? 8388608 : 4194304;
                    }
                    i15 = i8 & 256;
                    if (i15 == 0) {
                        i9 |= 100663296;
                    } else if ((i6 & 100663296) == 0) {
                        i9 |= startRestartGroup.changed(z5) ? 67108864 : 33554432;
                    }
                    i16 = i8 & 512;
                    if (i16 == 0) {
                        i9 |= 805306368;
                    } else if ((i6 & 805306368) == 0) {
                        i9 |= startRestartGroup.changedInstance(function32) ? 536870912 : 268435456;
                    }
                    i17 = i8 & 1024;
                    if (i17 == 0) {
                        i18 = i7 | 6;
                    } else if ((i7 & 6) == 0) {
                        i18 = i7 | (startRestartGroup.changed(z6) ? 4 : 2);
                    } else {
                        i18 = i7;
                    }
                    if ((i7 & 48) == 0) {
                        if ((i8 & 2048) == 0 && startRestartGroup.changed(shape)) {
                            i24 = 32;
                            i18 |= i24;
                        }
                        i24 = 16;
                        i18 |= i24;
                    }
                    int i29 = i18;
                    i19 = i8 & 4096;
                    if (i19 == 0) {
                        i29 |= 384;
                    } else if ((i7 & 384) == 0) {
                        i29 |= startRestartGroup.changed(f5) ? 256 : 128;
                        if ((i7 & 3072) == 0) {
                            if ((i8 & 8192) == 0 && startRestartGroup.changed(j5)) {
                                i27 = 2048;
                            }
                            i29 |= i27;
                        }
                        if ((i7 & 24576) == 0) {
                            if ((i8 & 16384) == 0 && startRestartGroup.changed(j6)) {
                                i28 = 16384;
                            }
                            i29 |= i28;
                        }
                        if ((i7 & 196608) == 0) {
                            i29 |= ((i8 & 32768) == 0 && startRestartGroup.changed(j7)) ? 131072 : 65536;
                        }
                        if ((i7 & 1572864) == 0) {
                            i29 |= ((i8 & 65536) == 0 && startRestartGroup.changed(j8)) ? 1048576 : 524288;
                        }
                        if ((i7 & 12582912) == 0) {
                            i29 |= ((i8 & 131072) == 0 && startRestartGroup.changed(j9)) ? 8388608 : 4194304;
                        }
                        if ((i8 & 262144) != 0) {
                            i29 |= 100663296;
                        } else if ((i7 & 100663296) == 0) {
                            i29 |= startRestartGroup.changedInstance(function33) ? 67108864 : 33554432;
                        }
                        if ((i9 & 306783379) != 306783378 && (38347923 & i29) == 38347922 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier;
                            scaffoldState4 = scaffoldState;
                            function26 = function2;
                            function24 = function22;
                            function36 = function3;
                            function25 = function23;
                            i23 = i5;
                            z11 = z5;
                            function35 = function32;
                            z10 = z6;
                            shape6 = shape;
                            f7 = f5;
                            j18 = j5;
                            j11 = j6;
                            j19 = j7;
                            j20 = j8;
                            j21 = j9;
                        } else {
                            startRestartGroup.startDefaults();
                            if ((i6 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier modifier4 = i26 != 0 ? Modifier.INSTANCE : modifier;
                                if ((i8 & 4) != 0) {
                                    modifier2 = modifier4;
                                    scaffoldState2 = rememberScaffoldState(null, null, startRestartGroup, 0, 3);
                                    i9 &= -897;
                                } else {
                                    modifier2 = modifier4;
                                    scaffoldState2 = scaffoldState;
                                }
                                m676getLambda1$material_release = i10 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m676getLambda1$material_release() : function2;
                                m677getLambda2$material_release = i11 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m677getLambda2$material_release() : function22;
                                m678getLambda3$material_release = i12 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m678getLambda3$material_release() : function3;
                                m679getLambda4$material_release = i13 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m679getLambda4$material_release() : function23;
                                m700getEnd5ygKITE = i14 != 0 ? FabPosition.INSTANCE.m700getEnd5ygKITE() : i5;
                                boolean z12 = i15 != 0 ? false : z5;
                                Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function37 = i16 != 0 ? null : function32;
                                z7 = i17 != 0 ? true : z6;
                                int i30 = i9;
                                boolean z13 = z12;
                                if ((i8 & 2048) != 0) {
                                    shape2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getLarge();
                                    i29 &= -113;
                                } else {
                                    shape2 = shape;
                                }
                                m688getElevationD9Ej5fM = i19 != 0 ? DrawerDefaults.INSTANCE.m688getElevationD9Ej5fM() : f5;
                                if ((i8 & 8192) != 0) {
                                    shape3 = shape2;
                                    j10 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m671getSurface0d7_KjU();
                                    i29 &= -7169;
                                } else {
                                    shape3 = shape2;
                                    j10 = j5;
                                }
                                Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function38 = function37;
                                if ((i8 & 16384) != 0) {
                                    j11 = ColorsKt.m673contentColorForek8zF_U(j10, startRestartGroup, (i29 >> 9) & 14);
                                    i29 &= -57345;
                                } else {
                                    j11 = j6;
                                }
                                if ((32768 & i8) != 0) {
                                    j12 = j10;
                                    i20 = 6;
                                    j13 = DrawerDefaults.INSTANCE.getScrimColor(startRestartGroup, 6);
                                    i29 &= -458753;
                                } else {
                                    j12 = j10;
                                    i20 = 6;
                                    j13 = j7;
                                }
                                long j22 = j13;
                                if ((i8 & 65536) != 0) {
                                    j14 = MaterialTheme.INSTANCE.getColors(startRestartGroup, i20).m660getBackground0d7_KjU();
                                    i29 = (-3670017) & i29;
                                } else {
                                    j14 = j8;
                                }
                                if ((i8 & 131072) != 0) {
                                    i21 = i30;
                                    function34 = function38;
                                    j17 = j14;
                                    i22 = i29 & (-29360129);
                                    j16 = ColorsKt.m673contentColorForek8zF_U(j14, startRestartGroup, (i29 >> 18) & 14);
                                    modifier3 = modifier2;
                                    z8 = z13;
                                    shape4 = shape3;
                                    j15 = j22;
                                } else {
                                    i21 = i30;
                                    function34 = function38;
                                    j15 = j22;
                                    j16 = j9;
                                    j17 = j14;
                                    i22 = i29;
                                    modifier3 = modifier2;
                                    z8 = z13;
                                    shape4 = shape3;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i8 & 4) != 0) {
                                    i9 &= -897;
                                }
                                if ((i8 & 2048) != 0) {
                                    i29 &= -113;
                                }
                                if ((i8 & 8192) != 0) {
                                    i29 &= -7169;
                                }
                                if ((i8 & 16384) != 0) {
                                    i29 &= -57345;
                                }
                                if ((32768 & i8) != 0) {
                                    i29 &= -458753;
                                }
                                if ((i8 & 65536) != 0) {
                                    i29 &= -3670017;
                                }
                                if ((i8 & 131072) != 0) {
                                    i29 &= -29360129;
                                }
                                scaffoldState2 = scaffoldState;
                                m676getLambda1$material_release = function2;
                                m677getLambda2$material_release = function22;
                                m678getLambda3$material_release = function3;
                                m679getLambda4$material_release = function23;
                                m700getEnd5ygKITE = i5;
                                z8 = z5;
                                function34 = function32;
                                z7 = z6;
                                m688getElevationD9Ej5fM = f5;
                                j12 = j5;
                                j11 = j6;
                                j15 = j7;
                                j17 = j8;
                                j16 = j9;
                                i21 = i9;
                                i22 = i29;
                                modifier3 = modifier;
                                shape4 = shape;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                f6 = m688getElevationD9Ej5fM;
                                shape5 = shape4;
                                ComposerKt.traceEventStart(-1288630565, i21, i22, "androidx.compose.material.Scaffold (Scaffold.kt:202)");
                            } else {
                                shape5 = shape4;
                                f6 = m688getElevationD9Ej5fM;
                            }
                            z9 = (i21 & 14) == 4;
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!z9 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new MutableWindowInsets(windowInsets);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            final MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) rememberedValue;
                            final long j23 = j17;
                            final long j24 = j16;
                            final boolean z14 = z8;
                            final int i31 = m700getEnd5ygKITE;
                            final Function2<? super Composer, ? super Integer, Unit> function27 = m676getLambda1$material_release;
                            final Function2<? super Composer, ? super Integer, Unit> function28 = m679getLambda4$material_release;
                            final Function2<? super Composer, ? super Integer, Unit> function29 = m677getLambda2$material_release;
                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function39 = m678getLambda3$material_release;
                            final ScaffoldState scaffoldState5 = scaffoldState2;
                            boolean z15 = z8;
                            final ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-219833176, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier5, Composer composer2, Integer num) {
                                    invoke(modifier5, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Modifier modifier5, Composer composer2, int i32) {
                                    int i33;
                                    if ((i32 & 6) == 0) {
                                        i33 = i32 | (composer2.changed(modifier5) ? 4 : 2);
                                    } else {
                                        i33 = i32;
                                    }
                                    if ((i33 & 19) == 18 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-219833176, i33, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:207)");
                                    }
                                    boolean changed = composer2.changed(MutableWindowInsets.this) | composer2.changed(windowInsets);
                                    final MutableWindowInsets mutableWindowInsets2 = MutableWindowInsets.this;
                                    final WindowInsets windowInsets2 = windowInsets;
                                    Object rememberedValue2 = composer2.rememberedValue();
                                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1$1$1
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
                                                MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets2, windowInsets3));
                                            }
                                        };
                                        composer2.updateRememberedValue(rememberedValue2);
                                    }
                                    Modifier onConsumedWindowInsetsChanged = WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier5, (Function1) rememberedValue2);
                                    long j25 = j23;
                                    long j26 = j24;
                                    final boolean z16 = z14;
                                    final int i34 = i31;
                                    final Function2<Composer, Integer, Unit> function210 = function27;
                                    final Function3<PaddingValues, Composer, Integer, Unit> function310 = function33;
                                    final Function2<Composer, Integer, Unit> function211 = function28;
                                    final MutableWindowInsets mutableWindowInsets3 = MutableWindowInsets.this;
                                    final Function2<Composer, Integer, Unit> function212 = function29;
                                    final Function3<SnackbarHostState, Composer, Integer, Unit> function311 = function39;
                                    final ScaffoldState scaffoldState6 = scaffoldState5;
                                    SurfaceKt.m736SurfaceFjzlyU(onConsumedWindowInsetsChanged, null, j25, j26, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(1772955108, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.2
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

                                        public final void invoke(Composer composer3, int i35) {
                                            if ((i35 & 3) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1772955108, i35, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:216)");
                                            }
                                            boolean z17 = z16;
                                            int i36 = i34;
                                            Function2<Composer, Integer, Unit> function213 = function210;
                                            Function3<PaddingValues, Composer, Integer, Unit> function312 = function310;
                                            final Function3<SnackbarHostState, Composer, Integer, Unit> function313 = function311;
                                            final ScaffoldState scaffoldState7 = scaffoldState6;
                                            ScaffoldKt.m721ScaffoldLayouti1QSOvI(z17, i36, function213, function312, ComposableLambdaKt.rememberComposableLambda(433906483, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.2.1
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

                                                public final void invoke(Composer composer4, int i37) {
                                                    if ((i37 & 3) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(433906483, i37, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:223)");
                                                    }
                                                    function313.invoke(scaffoldState7.getSnackbarHostState(), composer4, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, composer3, 54), function211, mutableWindowInsets3, function212, composer3, 24576);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer2, 54), composer2, 1572864, 50);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54);
                            if (function34 != null) {
                                startRestartGroup.startReplaceGroup(651509775);
                                scaffoldState3 = scaffoldState2;
                                int i32 = i22 << 9;
                                DrawerKt.m689ModalDrawerGs3lGvM(function34, modifier3, scaffoldState2.getDrawerState(), z7, shape5, f6, j12, j11, j15, ComposableLambdaKt.rememberComposableLambda(-1409196448, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
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

                                    public final void invoke(Composer composer2, int i33) {
                                        if ((i33 & 3) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1409196448, i33, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:242)");
                                        }
                                        rememberComposableLambda.invoke(Modifier.INSTANCE, composer2, 54);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, startRestartGroup, 54), startRestartGroup, ((i21 >> 27) & 14) | 805306368 | (i21 & 112) | (i32 & 7168) | (57344 & i32) | (458752 & i32) | (3670016 & i32) | (29360128 & i32) | (i32 & 234881024), 0);
                                startRestartGroup.endReplaceGroup();
                            } else {
                                scaffoldState3 = scaffoldState2;
                                startRestartGroup.startReplaceGroup(652000071);
                                rememberComposableLambda.invoke(modifier3, startRestartGroup, Integer.valueOf(((i21 >> 3) & 14) | 48));
                                startRestartGroup.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            f7 = f6;
                            scaffoldState4 = scaffoldState3;
                            function24 = m677getLambda2$material_release;
                            i23 = m700getEnd5ygKITE;
                            function25 = m679getLambda4$material_release;
                            j18 = j12;
                            j19 = j15;
                            j20 = j17;
                            j21 = j16;
                            function35 = function34;
                            z10 = z7;
                            function26 = m676getLambda1$material_release;
                            function36 = m678getLambda3$material_release;
                            shape6 = shape5;
                            z11 = z15;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$2
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

                                public final void invoke(Composer composer2, int i33) {
                                    ScaffoldKt.m720Scaffoldu4IkXBM(WindowInsets.this, modifier3, scaffoldState4, function26, function24, function36, function25, i23, z11, function35, z10, shape6, f7, j18, j11, j19, j20, j21, function33, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), RecomposeScopeImplKt.updateChangedFlags(i7), i8);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i7 & 3072) == 0) {
                    }
                    if ((i7 & 24576) == 0) {
                    }
                    if ((i7 & 196608) == 0) {
                    }
                    if ((i7 & 1572864) == 0) {
                    }
                    if ((i7 & 12582912) == 0) {
                    }
                    if ((i8 & 262144) != 0) {
                    }
                    if ((i9 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i6 & 1) != 0) {
                    }
                    if (i26 != 0) {
                    }
                    if ((i8 & 4) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    int i302 = i9;
                    boolean z132 = z12;
                    if ((i8 & 2048) != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if ((i8 & 8192) != 0) {
                    }
                    Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function382 = function37;
                    if ((i8 & 16384) != 0) {
                    }
                    if ((32768 & i8) != 0) {
                    }
                    long j222 = j13;
                    if ((i8 & 65536) != 0) {
                    }
                    if ((i8 & 131072) != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if ((i21 & 14) == 4) {
                    }
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z9) {
                    }
                    rememberedValue = new MutableWindowInsets(windowInsets);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    final MutableWindowInsets mutableWindowInsets2 = (MutableWindowInsets) rememberedValue;
                    final long j232 = j17;
                    final long j242 = j16;
                    final boolean z142 = z8;
                    final int i312 = m700getEnd5ygKITE;
                    final Function2<? super Composer, ? super Integer, Unit> function272 = m676getLambda1$material_release;
                    final Function2<? super Composer, ? super Integer, Unit> function282 = m679getLambda4$material_release;
                    final Function2<? super Composer, ? super Integer, Unit> function292 = m677getLambda2$material_release;
                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function392 = m678getLambda3$material_release;
                    final ScaffoldState scaffoldState52 = scaffoldState2;
                    boolean z152 = z8;
                    final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-219833176, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier5, Composer composer2, Integer num) {
                            invoke(modifier5, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Modifier modifier5, Composer composer2, int i322) {
                            int i33;
                            if ((i322 & 6) == 0) {
                                i33 = i322 | (composer2.changed(modifier5) ? 4 : 2);
                            } else {
                                i33 = i322;
                            }
                            if ((i33 & 19) == 18 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-219833176, i33, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:207)");
                            }
                            boolean changed = composer2.changed(MutableWindowInsets.this) | composer2.changed(windowInsets);
                            final MutableWindowInsets mutableWindowInsets22 = MutableWindowInsets.this;
                            final WindowInsets windowInsets2 = windowInsets;
                            Object rememberedValue2 = composer2.rememberedValue();
                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1$1$1
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
                                        MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets2, windowInsets3));
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue2);
                            }
                            Modifier onConsumedWindowInsetsChanged = WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier5, (Function1) rememberedValue2);
                            long j25 = j232;
                            long j26 = j242;
                            final boolean z16 = z142;
                            final int i34 = i312;
                            final Function2<? super Composer, ? super Integer, Unit> function210 = function272;
                            final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function310 = function33;
                            final Function2<? super Composer, ? super Integer, Unit> function211 = function282;
                            final MutableWindowInsets mutableWindowInsets3 = MutableWindowInsets.this;
                            final Function2<? super Composer, ? super Integer, Unit> function212 = function292;
                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function311 = function392;
                            final ScaffoldState scaffoldState6 = scaffoldState52;
                            SurfaceKt.m736SurfaceFjzlyU(onConsumedWindowInsetsChanged, null, j25, j26, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(1772955108, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.2
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

                                public final void invoke(Composer composer3, int i35) {
                                    if ((i35 & 3) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1772955108, i35, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:216)");
                                    }
                                    boolean z17 = z16;
                                    int i36 = i34;
                                    Function2<Composer, Integer, Unit> function213 = function210;
                                    Function3<PaddingValues, Composer, Integer, Unit> function312 = function310;
                                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function313 = function311;
                                    final ScaffoldState scaffoldState7 = scaffoldState6;
                                    ScaffoldKt.m721ScaffoldLayouti1QSOvI(z17, i36, function213, function312, ComposableLambdaKt.rememberComposableLambda(433906483, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.2.1
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

                                        public final void invoke(Composer composer4, int i37) {
                                            if ((i37 & 3) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(433906483, i37, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:223)");
                                            }
                                            function313.invoke(scaffoldState7.getSnackbarHostState(), composer4, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer3, 54), function211, mutableWindowInsets3, function212, composer3, 24576);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer2, 54), composer2, 1572864, 50);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54);
                    if (function34 != null) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f7 = f6;
                    scaffoldState4 = scaffoldState3;
                    function24 = m677getLambda2$material_release;
                    i23 = m700getEnd5ygKITE;
                    function25 = m679getLambda4$material_release;
                    j18 = j12;
                    j19 = j15;
                    j20 = j17;
                    j21 = j16;
                    function35 = function34;
                    z10 = z7;
                    function26 = m676getLambda1$material_release;
                    function36 = m678getLambda3$material_release;
                    shape6 = shape5;
                    z11 = z152;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i12 = i8 & 32;
                if (i12 == 0) {
                }
                i13 = i8 & 64;
                if (i13 == 0) {
                }
                i14 = i8 & 128;
                if (i14 == 0) {
                }
                i15 = i8 & 256;
                if (i15 == 0) {
                }
                i16 = i8 & 512;
                if (i16 == 0) {
                }
                i17 = i8 & 1024;
                if (i17 == 0) {
                }
                if ((i7 & 48) == 0) {
                }
                int i292 = i18;
                i19 = i8 & 4096;
                if (i19 == 0) {
                }
                if ((i7 & 3072) == 0) {
                }
                if ((i7 & 24576) == 0) {
                }
                if ((i7 & 196608) == 0) {
                }
                if ((i7 & 1572864) == 0) {
                }
                if ((i7 & 12582912) == 0) {
                }
                if ((i8 & 262144) != 0) {
                }
                if ((i9 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i6 & 1) != 0) {
                }
                if (i26 != 0) {
                }
                if ((i8 & 4) != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i13 != 0) {
                }
                if (i14 != 0) {
                }
                if (i15 != 0) {
                }
                if (i16 != 0) {
                }
                if (i17 != 0) {
                }
                int i3022 = i9;
                boolean z1322 = z12;
                if ((i8 & 2048) != 0) {
                }
                if (i19 != 0) {
                }
                if ((i8 & 8192) != 0) {
                }
                Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3822 = function37;
                if ((i8 & 16384) != 0) {
                }
                if ((32768 & i8) != 0) {
                }
                long j2222 = j13;
                if ((i8 & 65536) != 0) {
                }
                if ((i8 & 131072) != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                if ((i21 & 14) == 4) {
                }
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z9) {
                }
                rememberedValue = new MutableWindowInsets(windowInsets);
                startRestartGroup.updateRememberedValue(rememberedValue);
                final MutableWindowInsets mutableWindowInsets22 = (MutableWindowInsets) rememberedValue;
                final long j2322 = j17;
                final long j2422 = j16;
                final boolean z1422 = z8;
                final int i3122 = m700getEnd5ygKITE;
                final Function2<? super Composer, ? super Integer, Unit> function2722 = m676getLambda1$material_release;
                final Function2<? super Composer, ? super Integer, Unit> function2822 = m679getLambda4$material_release;
                final Function2<? super Composer, ? super Integer, Unit> function2922 = m677getLambda2$material_release;
                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3922 = m678getLambda3$material_release;
                final ScaffoldState scaffoldState522 = scaffoldState2;
                boolean z1522 = z8;
                final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> rememberComposableLambda22 = ComposableLambdaKt.rememberComposableLambda(-219833176, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier5, Composer composer2, Integer num) {
                        invoke(modifier5, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Modifier modifier5, Composer composer2, int i322) {
                        int i33;
                        if ((i322 & 6) == 0) {
                            i33 = i322 | (composer2.changed(modifier5) ? 4 : 2);
                        } else {
                            i33 = i322;
                        }
                        if ((i33 & 19) == 18 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-219833176, i33, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:207)");
                        }
                        boolean changed = composer2.changed(MutableWindowInsets.this) | composer2.changed(windowInsets);
                        final MutableWindowInsets mutableWindowInsets222 = MutableWindowInsets.this;
                        final WindowInsets windowInsets2 = windowInsets;
                        Object rememberedValue2 = composer2.rememberedValue();
                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1$1$1
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
                                    MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets2, windowInsets3));
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue2);
                        }
                        Modifier onConsumedWindowInsetsChanged = WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier5, (Function1) rememberedValue2);
                        long j25 = j2322;
                        long j26 = j2422;
                        final boolean z16 = z1422;
                        final int i34 = i3122;
                        final Function2<? super Composer, ? super Integer, Unit> function210 = function2722;
                        final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function310 = function33;
                        final Function2<? super Composer, ? super Integer, Unit> function211 = function2822;
                        final MutableWindowInsets mutableWindowInsets3 = MutableWindowInsets.this;
                        final Function2<? super Composer, ? super Integer, Unit> function212 = function2922;
                        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function311 = function3922;
                        final ScaffoldState scaffoldState6 = scaffoldState522;
                        SurfaceKt.m736SurfaceFjzlyU(onConsumedWindowInsetsChanged, null, j25, j26, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(1772955108, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.2
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

                            public final void invoke(Composer composer3, int i35) {
                                if ((i35 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1772955108, i35, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:216)");
                                }
                                boolean z17 = z16;
                                int i36 = i34;
                                Function2<Composer, Integer, Unit> function213 = function210;
                                Function3<PaddingValues, Composer, Integer, Unit> function312 = function310;
                                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function313 = function311;
                                final ScaffoldState scaffoldState7 = scaffoldState6;
                                ScaffoldKt.m721ScaffoldLayouti1QSOvI(z17, i36, function213, function312, ComposableLambdaKt.rememberComposableLambda(433906483, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.2.1
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

                                    public final void invoke(Composer composer4, int i37) {
                                        if ((i37 & 3) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(433906483, i37, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:223)");
                                        }
                                        function313.invoke(scaffoldState7.getSnackbarHostState(), composer4, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer3, 54), function211, mutableWindowInsets3, function212, composer3, 24576);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, 1572864, 50);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54);
                if (function34 != null) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                f7 = f6;
                scaffoldState4 = scaffoldState3;
                function24 = m677getLambda2$material_release;
                i23 = m700getEnd5ygKITE;
                function25 = m679getLambda4$material_release;
                j18 = j12;
                j19 = j15;
                j20 = j17;
                j21 = j16;
                function35 = function34;
                z10 = z7;
                function26 = m676getLambda1$material_release;
                function36 = m678getLambda3$material_release;
                shape6 = shape5;
                z11 = z1522;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i11 = i8 & 16;
            int i282 = 8192;
            if (i11 != 0) {
            }
            i12 = i8 & 32;
            if (i12 == 0) {
            }
            i13 = i8 & 64;
            if (i13 == 0) {
            }
            i14 = i8 & 128;
            if (i14 == 0) {
            }
            i15 = i8 & 256;
            if (i15 == 0) {
            }
            i16 = i8 & 512;
            if (i16 == 0) {
            }
            i17 = i8 & 1024;
            if (i17 == 0) {
            }
            if ((i7 & 48) == 0) {
            }
            int i2922 = i18;
            i19 = i8 & 4096;
            if (i19 == 0) {
            }
            if ((i7 & 3072) == 0) {
            }
            if ((i7 & 24576) == 0) {
            }
            if ((i7 & 196608) == 0) {
            }
            if ((i7 & 1572864) == 0) {
            }
            if ((i7 & 12582912) == 0) {
            }
            if ((i8 & 262144) != 0) {
            }
            if ((i9 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i6 & 1) != 0) {
            }
            if (i26 != 0) {
            }
            if ((i8 & 4) != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            if (i14 != 0) {
            }
            if (i15 != 0) {
            }
            if (i16 != 0) {
            }
            if (i17 != 0) {
            }
            int i30222 = i9;
            boolean z13222 = z12;
            if ((i8 & 2048) != 0) {
            }
            if (i19 != 0) {
            }
            if ((i8 & 8192) != 0) {
            }
            Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function38222 = function37;
            if ((i8 & 16384) != 0) {
            }
            if ((32768 & i8) != 0) {
            }
            long j22222 = j13;
            if ((i8 & 65536) != 0) {
            }
            if ((i8 & 131072) != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            if ((i21 & 14) == 4) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z9) {
            }
            rememberedValue = new MutableWindowInsets(windowInsets);
            startRestartGroup.updateRememberedValue(rememberedValue);
            final MutableWindowInsets mutableWindowInsets222 = (MutableWindowInsets) rememberedValue;
            final long j23222 = j17;
            final long j24222 = j16;
            final boolean z14222 = z8;
            final int i31222 = m700getEnd5ygKITE;
            final Function2<? super Composer, ? super Integer, Unit> function27222 = m676getLambda1$material_release;
            final Function2<? super Composer, ? super Integer, Unit> function28222 = m679getLambda4$material_release;
            final Function2<? super Composer, ? super Integer, Unit> function29222 = m677getLambda2$material_release;
            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function39222 = m678getLambda3$material_release;
            final ScaffoldState scaffoldState5222 = scaffoldState2;
            boolean z15222 = z8;
            final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> rememberComposableLambda222 = ComposableLambdaKt.rememberComposableLambda(-219833176, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier5, Composer composer2, Integer num) {
                    invoke(modifier5, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Modifier modifier5, Composer composer2, int i322) {
                    int i33;
                    if ((i322 & 6) == 0) {
                        i33 = i322 | (composer2.changed(modifier5) ? 4 : 2);
                    } else {
                        i33 = i322;
                    }
                    if ((i33 & 19) == 18 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-219833176, i33, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:207)");
                    }
                    boolean changed = composer2.changed(MutableWindowInsets.this) | composer2.changed(windowInsets);
                    final MutableWindowInsets mutableWindowInsets2222 = MutableWindowInsets.this;
                    final WindowInsets windowInsets2 = windowInsets;
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1$1$1
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
                                MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets2, windowInsets3));
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    Modifier onConsumedWindowInsetsChanged = WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier5, (Function1) rememberedValue2);
                    long j25 = j23222;
                    long j26 = j24222;
                    final boolean z16 = z14222;
                    final int i34 = i31222;
                    final Function2<? super Composer, ? super Integer, Unit> function210 = function27222;
                    final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function310 = function33;
                    final Function2<? super Composer, ? super Integer, Unit> function211 = function28222;
                    final MutableWindowInsets mutableWindowInsets3 = MutableWindowInsets.this;
                    final Function2<? super Composer, ? super Integer, Unit> function212 = function29222;
                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function311 = function39222;
                    final ScaffoldState scaffoldState6 = scaffoldState5222;
                    SurfaceKt.m736SurfaceFjzlyU(onConsumedWindowInsetsChanged, null, j25, j26, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(1772955108, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.2
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

                        public final void invoke(Composer composer3, int i35) {
                            if ((i35 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1772955108, i35, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:216)");
                            }
                            boolean z17 = z16;
                            int i36 = i34;
                            Function2<Composer, Integer, Unit> function213 = function210;
                            Function3<PaddingValues, Composer, Integer, Unit> function312 = function310;
                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function313 = function311;
                            final ScaffoldState scaffoldState7 = scaffoldState6;
                            ScaffoldKt.m721ScaffoldLayouti1QSOvI(z17, i36, function213, function312, ComposableLambdaKt.rememberComposableLambda(433906483, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.2.1
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

                                public final void invoke(Composer composer4, int i37) {
                                    if ((i37 & 3) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(433906483, i37, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:223)");
                                    }
                                    function313.invoke(scaffoldState7.getSnackbarHostState(), composer4, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), function211, mutableWindowInsets3, function212, composer3, 24576);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 1572864, 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            if (function34 != null) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            f7 = f6;
            scaffoldState4 = scaffoldState3;
            function24 = m677getLambda2$material_release;
            i23 = m700getEnd5ygKITE;
            function25 = m679getLambda4$material_release;
            j18 = j12;
            j19 = j15;
            j20 = j17;
            j21 = j16;
            function35 = function34;
            z10 = z7;
            function26 = m676getLambda1$material_release;
            function36 = m678getLambda3$material_release;
            shape6 = shape5;
            z11 = z15222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i6 & 384) == 0) {
        }
        i10 = i8 & 8;
        int i272 = 1024;
        if (i10 == 0) {
        }
        i11 = i8 & 16;
        int i2822 = 8192;
        if (i11 != 0) {
        }
        i12 = i8 & 32;
        if (i12 == 0) {
        }
        i13 = i8 & 64;
        if (i13 == 0) {
        }
        i14 = i8 & 128;
        if (i14 == 0) {
        }
        i15 = i8 & 256;
        if (i15 == 0) {
        }
        i16 = i8 & 512;
        if (i16 == 0) {
        }
        i17 = i8 & 1024;
        if (i17 == 0) {
        }
        if ((i7 & 48) == 0) {
        }
        int i29222 = i18;
        i19 = i8 & 4096;
        if (i19 == 0) {
        }
        if ((i7 & 3072) == 0) {
        }
        if ((i7 & 24576) == 0) {
        }
        if ((i7 & 196608) == 0) {
        }
        if ((i7 & 1572864) == 0) {
        }
        if ((i7 & 12582912) == 0) {
        }
        if ((i8 & 262144) != 0) {
        }
        if ((i9 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i6 & 1) != 0) {
        }
        if (i26 != 0) {
        }
        if ((i8 & 4) != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        if (i14 != 0) {
        }
        if (i15 != 0) {
        }
        if (i16 != 0) {
        }
        if (i17 != 0) {
        }
        int i302222 = i9;
        boolean z132222 = z12;
        if ((i8 & 2048) != 0) {
        }
        if (i19 != 0) {
        }
        if ((i8 & 8192) != 0) {
        }
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function382222 = function37;
        if ((i8 & 16384) != 0) {
        }
        if ((32768 & i8) != 0) {
        }
        long j222222 = j13;
        if ((i8 & 65536) != 0) {
        }
        if ((i8 & 131072) != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        if ((i21 & 14) == 4) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z9) {
        }
        rememberedValue = new MutableWindowInsets(windowInsets);
        startRestartGroup.updateRememberedValue(rememberedValue);
        final MutableWindowInsets mutableWindowInsets2222 = (MutableWindowInsets) rememberedValue;
        final long j232222 = j17;
        final long j242222 = j16;
        final boolean z142222 = z8;
        final int i312222 = m700getEnd5ygKITE;
        final Function2<? super Composer, ? super Integer, Unit> function272222 = m676getLambda1$material_release;
        final Function2<? super Composer, ? super Integer, Unit> function282222 = m679getLambda4$material_release;
        final Function2<? super Composer, ? super Integer, Unit> function292222 = m677getLambda2$material_release;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function392222 = m678getLambda3$material_release;
        final ScaffoldState scaffoldState52222 = scaffoldState2;
        boolean z152222 = z8;
        final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> rememberComposableLambda2222 = ComposableLambdaKt.rememberComposableLambda(-219833176, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier5, Composer composer2, Integer num) {
                invoke(modifier5, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Modifier modifier5, Composer composer2, int i322) {
                int i33;
                if ((i322 & 6) == 0) {
                    i33 = i322 | (composer2.changed(modifier5) ? 4 : 2);
                } else {
                    i33 = i322;
                }
                if ((i33 & 19) == 18 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-219833176, i33, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:207)");
                }
                boolean changed = composer2.changed(MutableWindowInsets.this) | composer2.changed(windowInsets);
                final MutableWindowInsets mutableWindowInsets22222 = MutableWindowInsets.this;
                final WindowInsets windowInsets2 = windowInsets;
                Object rememberedValue2 = composer2.rememberedValue();
                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1$1$1
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
                            MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets2, windowInsets3));
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue2);
                }
                Modifier onConsumedWindowInsetsChanged = WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier5, (Function1) rememberedValue2);
                long j25 = j232222;
                long j26 = j242222;
                final boolean z16 = z142222;
                final int i34 = i312222;
                final Function2<? super Composer, ? super Integer, Unit> function210 = function272222;
                final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function310 = function33;
                final Function2<? super Composer, ? super Integer, Unit> function211 = function282222;
                final MutableWindowInsets mutableWindowInsets3 = MutableWindowInsets.this;
                final Function2<? super Composer, ? super Integer, Unit> function212 = function292222;
                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function311 = function392222;
                final ScaffoldState scaffoldState6 = scaffoldState52222;
                SurfaceKt.m736SurfaceFjzlyU(onConsumedWindowInsetsChanged, null, j25, j26, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(1772955108, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.2
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

                    public final void invoke(Composer composer3, int i35) {
                        if ((i35 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1772955108, i35, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:216)");
                        }
                        boolean z17 = z16;
                        int i36 = i34;
                        Function2<Composer, Integer, Unit> function213 = function210;
                        Function3<PaddingValues, Composer, Integer, Unit> function312 = function310;
                        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function313 = function311;
                        final ScaffoldState scaffoldState7 = scaffoldState6;
                        ScaffoldKt.m721ScaffoldLayouti1QSOvI(z17, i36, function213, function312, ComposableLambdaKt.rememberComposableLambda(433906483, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.2.1
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

                            public final void invoke(Composer composer4, int i37) {
                                if ((i37 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(433906483, i37, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:223)");
                                }
                                function313.invoke(scaffoldState7.getSnackbarHostState(), composer4, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54), function211, mutableWindowInsets3, function212, composer3, 24576);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, 1572864, 50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54);
        if (function34 != null) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        f7 = f6;
        scaffoldState4 = scaffoldState3;
        function24 = m677getLambda2$material_release;
        i23 = m700getEnd5ygKITE;
        function25 = m679getLambda4$material_release;
        j18 = j12;
        j19 = j15;
        j20 = j17;
        j21 = j16;
        function35 = function34;
        z10 = z7;
        function26 = m676getLambda1$material_release;
        function36 = m678getLambda3$material_release;
        shape6 = shape5;
        z11 = z152222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScaffoldLayout-i1QSOvI, reason: not valid java name */
    public static final void m721ScaffoldLayouti1QSOvI(final boolean z5, final int i5, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i6) {
        int i7;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-468424875);
        if ((i6 & 6) == 0) {
            i7 = (startRestartGroup.changed(z5) ? 4 : 2) | i6;
        } else {
            i7 = i6;
        }
        if ((i6 & 48) == 0) {
            i7 |= startRestartGroup.changed(i5) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((196608 & i6) == 0) {
            i7 |= startRestartGroup.changedInstance(function23) ? 131072 : 65536;
        }
        if ((i6 & 1572864) == 0) {
            i7 |= startRestartGroup.changed(windowInsets) ? 1048576 : 524288;
        }
        if ((i6 & 12582912) == 0) {
            i7 |= startRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
        }
        if ((i7 & 4793491) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-468424875, i7, -1, "androidx.compose.material.ScaffoldLayout (Scaffold.kt:390)");
            }
            boolean z6 = ((i7 & 896) == 256) | ((57344 & i7) == 16384) | ((3670016 & i7) == 1048576) | ((458752 & i7) == 131072) | ((i7 & 112) == 32) | ((i7 & 14) == 4) | ((29360128 & i7) == 8388608) | ((i7 & 7168) == 2048);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                i8 = 1;
                i9 = 0;
                rememberedValue = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m723invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* JADX WARN: Removed duplicated region for block: B:49:0x0253 A[LOOP:3: B:48:0x0251->B:49:0x0253, LOOP_END] */
                    /* JADX WARN: Removed duplicated region for block: B:53:0x0269  */
                    /* JADX WARN: Removed duplicated region for block: B:56:0x029a  */
                    /* JADX WARN: Removed duplicated region for block: B:58:0x02a9  */
                    /* JADX WARN: Removed duplicated region for block: B:63:0x02ed  */
                    /* JADX WARN: Removed duplicated region for block: B:68:0x0344 A[LOOP:4: B:67:0x0342->B:68:0x0344, LOOP_END] */
                    /* JADX WARN: Removed duplicated region for block: B:76:0x0305  */
                    /* JADX WARN: Removed duplicated region for block: B:81:0x02e9  */
                    /* JADX WARN: Removed duplicated region for block: B:82:0x02a5  */
                    /* JADX WARN: Removed duplicated region for block: B:83:0x026b  */
                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final MeasureResult m723invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, long j5) {
                        Object obj;
                        Object obj2;
                        final FabPlacement fabPlacement;
                        final ArrayList arrayList;
                        int size;
                        int i10;
                        Object obj3;
                        final Integer num;
                        int size2;
                        int i11;
                        int intValue;
                        float f5;
                        int mo206roundToPx0680j_4;
                        int i12;
                        float f6;
                        Object obj4;
                        Object obj5;
                        int i13;
                        float f7;
                        float f8;
                        int mo206roundToPx0680j_42;
                        float f9;
                        float f10;
                        int m2578getMaxWidthimpl = Constraints.m2578getMaxWidthimpl(j5);
                        final int m2577getMaxHeightimpl = Constraints.m2577getMaxHeightimpl(j5);
                        long m2570copyZbe2FdA$default = Constraints.m2570copyZbe2FdA$default(j5, 0, 0, 0, 0, 10, null);
                        List<Measurable> subcompose = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.TopBar, function2);
                        final ArrayList arrayList2 = new ArrayList(subcompose.size());
                        int size3 = subcompose.size();
                        for (int i14 = 0; i14 < size3; i14++) {
                            arrayList2.add(subcompose.get(i14).mo1946measureBRTryo0(m2570copyZbe2FdA$default));
                        }
                        if (arrayList2.isEmpty()) {
                            obj = null;
                        } else {
                            obj = arrayList2.get(0);
                            int height = ((Placeable) obj).getHeight();
                            int lastIndex = CollectionsKt.getLastIndex(arrayList2);
                            if (1 <= lastIndex) {
                                int i15 = 1;
                                while (true) {
                                    Object obj6 = arrayList2.get(i15);
                                    int height2 = ((Placeable) obj6).getHeight();
                                    if (height < height2) {
                                        obj = obj6;
                                        height = height2;
                                    }
                                    if (i15 == lastIndex) {
                                        break;
                                    }
                                    i15++;
                                }
                            }
                        }
                        Placeable placeable = (Placeable) obj;
                        final int height3 = placeable != null ? placeable.getHeight() : 0;
                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Snackbar, function22);
                        WindowInsets windowInsets2 = windowInsets;
                        final ArrayList arrayList3 = new ArrayList(subcompose2.size());
                        int size4 = subcompose2.size();
                        for (int i16 = 0; i16 < size4; i16++) {
                            arrayList3.add(subcompose2.get(i16).mo1946measureBRTryo0(ConstraintsKt.m2595offsetNN6EwU(m2570copyZbe2FdA$default, (-windowInsets2.getLeft(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection())) - windowInsets2.getRight(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection()), -windowInsets2.getBottom(subcomposeMeasureScope))));
                        }
                        if (arrayList3.isEmpty()) {
                            obj2 = null;
                        } else {
                            obj2 = arrayList3.get(0);
                            int height4 = ((Placeable) obj2).getHeight();
                            int lastIndex2 = CollectionsKt.getLastIndex(arrayList3);
                            if (1 <= lastIndex2) {
                                Object obj7 = obj2;
                                int i17 = height4;
                                int i18 = 1;
                                while (true) {
                                    Object obj8 = arrayList3.get(i18);
                                    int height5 = ((Placeable) obj8).getHeight();
                                    if (i17 < height5) {
                                        obj7 = obj8;
                                        i17 = height5;
                                    }
                                    if (i18 == lastIndex2) {
                                        break;
                                    }
                                    i18++;
                                }
                                obj2 = obj7;
                            }
                        }
                        Placeable placeable2 = (Placeable) obj2;
                        int height6 = placeable2 != null ? placeable2.getHeight() : 0;
                        List<Measurable> subcompose3 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Fab, function23);
                        WindowInsets windowInsets3 = windowInsets;
                        final ArrayList arrayList4 = new ArrayList(subcompose3.size());
                        int size5 = subcompose3.size();
                        int i19 = 0;
                        while (i19 < size5) {
                            arrayList4.add(subcompose3.get(i19).mo1946measureBRTryo0(ConstraintsKt.m2595offsetNN6EwU(m2570copyZbe2FdA$default, (-windowInsets3.getLeft(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection())) - windowInsets3.getRight(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection()), -windowInsets3.getBottom(subcomposeMeasureScope))));
                            i19++;
                            windowInsets3 = windowInsets3;
                            subcompose3 = subcompose3;
                        }
                        if (!arrayList4.isEmpty()) {
                            if (arrayList4.isEmpty()) {
                                obj4 = null;
                            } else {
                                obj4 = arrayList4.get(0);
                                int width = ((Placeable) obj4).getWidth();
                                int lastIndex3 = CollectionsKt.getLastIndex(arrayList4);
                                if (1 <= lastIndex3) {
                                    Object obj9 = obj4;
                                    int i20 = width;
                                    int i21 = 1;
                                    while (true) {
                                        Object obj10 = arrayList4.get(i21);
                                        int width2 = ((Placeable) obj10).getWidth();
                                        if (i20 < width2) {
                                            obj9 = obj10;
                                            i20 = width2;
                                        }
                                        if (i21 == lastIndex3) {
                                            break;
                                        }
                                        i21++;
                                    }
                                    obj4 = obj9;
                                }
                            }
                            Placeable placeable3 = (Placeable) obj4;
                            int width3 = placeable3 != null ? placeable3.getWidth() : 0;
                            if (arrayList4.isEmpty()) {
                                obj5 = null;
                            } else {
                                obj5 = arrayList4.get(0);
                                int height7 = ((Placeable) obj5).getHeight();
                                int lastIndex4 = CollectionsKt.getLastIndex(arrayList4);
                                if (1 <= lastIndex4) {
                                    Object obj11 = obj5;
                                    int i22 = height7;
                                    int i23 = 1;
                                    while (true) {
                                        Object obj12 = arrayList4.get(i23);
                                        int height8 = ((Placeable) obj12).getHeight();
                                        if (i22 < height8) {
                                            obj11 = obj12;
                                            i22 = height8;
                                        }
                                        if (i23 == lastIndex4) {
                                            break;
                                        }
                                        i23++;
                                    }
                                    obj5 = obj11;
                                }
                            }
                            Placeable placeable4 = (Placeable) obj5;
                            int height9 = placeable4 != null ? placeable4.getHeight() : 0;
                            if (width3 != 0 && height9 != 0) {
                                int i24 = i5;
                                FabPosition.Companion companion = FabPosition.INSTANCE;
                                if (!FabPosition.m699equalsimpl0(i24, companion.m701getStart5ygKITE())) {
                                    if (!FabPosition.m699equalsimpl0(i24, companion.m700getEnd5ygKITE())) {
                                        i13 = (m2578getMaxWidthimpl - width3) / 2;
                                    } else if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                                        f8 = ScaffoldKt.FabSpacing;
                                        mo206roundToPx0680j_42 = subcomposeMeasureScope.mo206roundToPx0680j_4(f8);
                                        i13 = (m2578getMaxWidthimpl - mo206roundToPx0680j_42) - width3;
                                    } else {
                                        f7 = ScaffoldKt.FabSpacing;
                                        i13 = subcomposeMeasureScope.mo206roundToPx0680j_4(f7);
                                    }
                                    fabPlacement = new FabPlacement(z5, i13, width3, height9);
                                } else if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                                    f10 = ScaffoldKt.FabSpacing;
                                    i13 = subcomposeMeasureScope.mo206roundToPx0680j_4(f10);
                                    fabPlacement = new FabPlacement(z5, i13, width3, height9);
                                } else {
                                    f9 = ScaffoldKt.FabSpacing;
                                    mo206roundToPx0680j_42 = subcomposeMeasureScope.mo206roundToPx0680j_4(f9);
                                    i13 = (m2578getMaxWidthimpl - mo206roundToPx0680j_42) - width3;
                                    fabPlacement = new FabPlacement(z5, i13, width3, height9);
                                }
                                ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                                final Function2<Composer, Integer, Unit> function25 = function24;
                                List<Measurable> subcompose4 = subcomposeMeasureScope.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(424088350, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$bottomBarPlaceables$1
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

                                    public final void invoke(Composer composer2, int i25) {
                                        if ((i25 & 3) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(424088350, i25, -1, "androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:476)");
                                        }
                                        CompositionLocalKt.CompositionLocalProvider(ScaffoldKt.getLocalFabPlacement().provides(FabPlacement.this), function25, composer2, ProvidedValue.$stable);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }));
                                arrayList = new ArrayList(subcompose4.size());
                                size = subcompose4.size();
                                for (i10 = 0; i10 < size; i10++) {
                                    arrayList.add(subcompose4.get(i10).mo1946measureBRTryo0(m2570copyZbe2FdA$default));
                                }
                                if (arrayList.isEmpty()) {
                                    obj3 = arrayList.get(0);
                                    int height10 = ((Placeable) obj3).getHeight();
                                    int lastIndex5 = CollectionsKt.getLastIndex(arrayList);
                                    if (1 <= lastIndex5) {
                                        int i25 = 1;
                                        while (true) {
                                            Object obj13 = arrayList.get(i25);
                                            int height11 = ((Placeable) obj13).getHeight();
                                            if (height10 < height11) {
                                                height10 = height11;
                                                obj3 = obj13;
                                            }
                                            if (i25 == lastIndex5) {
                                                break;
                                            }
                                            i25++;
                                        }
                                    }
                                } else {
                                    obj3 = null;
                                }
                                Placeable placeable5 = (Placeable) obj3;
                                Integer valueOf = placeable5 == null ? Integer.valueOf(placeable5.getHeight()) : null;
                                if (fabPlacement == null) {
                                    WindowInsets windowInsets4 = windowInsets;
                                    boolean z7 = z5;
                                    if (valueOf == null) {
                                        int height12 = fabPlacement.getHeight();
                                        f6 = ScaffoldKt.FabSpacing;
                                        i12 = height12 + subcomposeMeasureScope.mo206roundToPx0680j_4(f6) + windowInsets4.getBottom(subcomposeMeasureScope);
                                    } else {
                                        if (z7) {
                                            intValue = valueOf.intValue();
                                            mo206roundToPx0680j_4 = fabPlacement.getHeight() / 2;
                                        } else {
                                            intValue = valueOf.intValue() + fabPlacement.getHeight();
                                            f5 = ScaffoldKt.FabSpacing;
                                            mo206roundToPx0680j_4 = subcomposeMeasureScope.mo206roundToPx0680j_4(f5);
                                        }
                                        i12 = mo206roundToPx0680j_4 + intValue;
                                    }
                                    num = Integer.valueOf(i12);
                                } else {
                                    num = null;
                                }
                                final int intValue2 = height6 == 0 ? height6 + (num != null ? num.intValue() : valueOf != null ? valueOf.intValue() : windowInsets.getBottom(subcomposeMeasureScope)) : 0;
                                int i26 = m2577getMaxHeightimpl - height3;
                                ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                                final WindowInsets windowInsets5 = windowInsets;
                                final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
                                final FabPlacement fabPlacement2 = fabPlacement;
                                final Integer num2 = valueOf;
                                List<Measurable> subcompose5 = subcomposeMeasureScope.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(-570781649, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$bodyContentPlaceables$1
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

                                    public final void invoke(Composer composer2, int i27) {
                                        float m2599constructorimpl;
                                        float bottom;
                                        Integer num3;
                                        if ((i27 & 3) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-570781649, i27, -1, "androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:510)");
                                        }
                                        PaddingValues asPaddingValues = WindowInsetsKt.asPaddingValues(WindowInsets.this, subcomposeMeasureScope);
                                        if (arrayList2.isEmpty()) {
                                            m2599constructorimpl = asPaddingValues.getTop();
                                        } else {
                                            m2599constructorimpl = Dp.m2599constructorimpl(0);
                                        }
                                        if (!arrayList.isEmpty() && (num3 = num2) != null) {
                                            bottom = subcomposeMeasureScope.mo209toDpu2uoSUM(num3.intValue());
                                        } else {
                                            bottom = asPaddingValues.getBottom();
                                        }
                                        function32.invoke(PaddingKt.m309PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(asPaddingValues, subcomposeMeasureScope.getLayoutDirection()), m2599constructorimpl, PaddingKt.calculateEndPadding(asPaddingValues, subcomposeMeasureScope.getLayoutDirection()), bottom), composer2, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }));
                                final ArrayList arrayList5 = new ArrayList(subcompose5.size());
                                size2 = subcompose5.size();
                                for (i11 = 0; i11 < size2; i11++) {
                                    arrayList5.add(subcompose5.get(i11).mo1946measureBRTryo0(Constraints.m2570copyZbe2FdA$default(m2570copyZbe2FdA$default, 0, 0, 0, i26, 7, null)));
                                }
                                final Integer num3 = valueOf;
                                return MeasureScope.layout$default(subcomposeMeasureScope, m2578getMaxWidthimpl, m2577getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1.1
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
                                        List<Placeable> list = arrayList5;
                                        int i27 = height3;
                                        int size6 = list.size();
                                        for (int i28 = 0; i28 < size6; i28++) {
                                            Placeable.PlacementScope.place$default(placementScope, list.get(i28), 0, i27, 0.0f, 4, null);
                                        }
                                        List<Placeable> list2 = arrayList2;
                                        int size7 = list2.size();
                                        for (int i29 = 0; i29 < size7; i29++) {
                                            Placeable.PlacementScope.place$default(placementScope, list2.get(i29), 0, 0, 0.0f, 4, null);
                                        }
                                        List<Placeable> list3 = arrayList3;
                                        int i30 = m2577getMaxHeightimpl;
                                        int i31 = intValue2;
                                        int size8 = list3.size();
                                        for (int i32 = 0; i32 < size8; i32++) {
                                            Placeable.PlacementScope.place$default(placementScope, list3.get(i32), 0, i30 - i31, 0.0f, 4, null);
                                        }
                                        List<Placeable> list4 = arrayList;
                                        int i33 = m2577getMaxHeightimpl;
                                        Integer num4 = num3;
                                        int size9 = list4.size();
                                        for (int i34 = 0; i34 < size9; i34++) {
                                            Placeable.PlacementScope.place$default(placementScope, list4.get(i34), 0, i33 - (num4 != null ? num4.intValue() : 0), 0.0f, 4, null);
                                        }
                                        List<Placeable> list5 = arrayList4;
                                        FabPlacement fabPlacement3 = fabPlacement2;
                                        int i35 = m2577getMaxHeightimpl;
                                        Integer num5 = num;
                                        int size10 = list5.size();
                                        for (int i36 = 0; i36 < size10; i36++) {
                                            Placeable.PlacementScope.place$default(placementScope, list5.get(i36), fabPlacement3 != null ? fabPlacement3.getLeft() : 0, i35 - (num5 != null ? num5.intValue() : 0), 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                        }
                        fabPlacement = null;
                        ScaffoldLayoutContent scaffoldLayoutContent3 = ScaffoldLayoutContent.BottomBar;
                        final Function2<? super Composer, ? super Integer, Unit> function252 = function24;
                        List<Measurable> subcompose42 = subcomposeMeasureScope.subcompose(scaffoldLayoutContent3, ComposableLambdaKt.composableLambdaInstance(424088350, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$bottomBarPlaceables$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num22) {
                                invoke(composer2, num22.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i252) {
                                if ((i252 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(424088350, i252, -1, "androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:476)");
                                }
                                CompositionLocalKt.CompositionLocalProvider(ScaffoldKt.getLocalFabPlacement().provides(FabPlacement.this), function252, composer2, ProvidedValue.$stable);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        arrayList = new ArrayList(subcompose42.size());
                        size = subcompose42.size();
                        while (i10 < size) {
                        }
                        if (arrayList.isEmpty()) {
                        }
                        Placeable placeable52 = (Placeable) obj3;
                        if (placeable52 == null) {
                        }
                        if (fabPlacement == null) {
                        }
                        if (height6 == 0) {
                        }
                        int i262 = m2577getMaxHeightimpl - height3;
                        ScaffoldLayoutContent scaffoldLayoutContent22 = ScaffoldLayoutContent.MainContent;
                        final WindowInsets windowInsets52 = windowInsets;
                        final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function322 = function3;
                        final FabPlacement fabPlacement22 = fabPlacement;
                        final Integer num22 = valueOf;
                        List<Measurable> subcompose52 = subcomposeMeasureScope.subcompose(scaffoldLayoutContent22, ComposableLambdaKt.composableLambdaInstance(-570781649, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$bodyContentPlaceables$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num32) {
                                invoke(composer2, num32.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i27) {
                                float m2599constructorimpl;
                                float bottom;
                                Integer num32;
                                if ((i27 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-570781649, i27, -1, "androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:510)");
                                }
                                PaddingValues asPaddingValues = WindowInsetsKt.asPaddingValues(WindowInsets.this, subcomposeMeasureScope);
                                if (arrayList2.isEmpty()) {
                                    m2599constructorimpl = asPaddingValues.getTop();
                                } else {
                                    m2599constructorimpl = Dp.m2599constructorimpl(0);
                                }
                                if (!arrayList.isEmpty() && (num32 = num22) != null) {
                                    bottom = subcomposeMeasureScope.mo209toDpu2uoSUM(num32.intValue());
                                } else {
                                    bottom = asPaddingValues.getBottom();
                                }
                                function322.invoke(PaddingKt.m309PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(asPaddingValues, subcomposeMeasureScope.getLayoutDirection()), m2599constructorimpl, PaddingKt.calculateEndPadding(asPaddingValues, subcomposeMeasureScope.getLayoutDirection()), bottom), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        final List<? extends Placeable> arrayList52 = new ArrayList(subcompose52.size());
                        size2 = subcompose52.size();
                        while (i11 < size2) {
                        }
                        final Integer num32 = valueOf;
                        return MeasureScope.layout$default(subcomposeMeasureScope, m2578getMaxWidthimpl, m2577getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1.1
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
                                List<Placeable> list = arrayList52;
                                int i27 = height3;
                                int size6 = list.size();
                                for (int i28 = 0; i28 < size6; i28++) {
                                    Placeable.PlacementScope.place$default(placementScope, list.get(i28), 0, i27, 0.0f, 4, null);
                                }
                                List<Placeable> list2 = arrayList2;
                                int size7 = list2.size();
                                for (int i29 = 0; i29 < size7; i29++) {
                                    Placeable.PlacementScope.place$default(placementScope, list2.get(i29), 0, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list3 = arrayList3;
                                int i30 = m2577getMaxHeightimpl;
                                int i31 = intValue2;
                                int size8 = list3.size();
                                for (int i32 = 0; i32 < size8; i32++) {
                                    Placeable.PlacementScope.place$default(placementScope, list3.get(i32), 0, i30 - i31, 0.0f, 4, null);
                                }
                                List<Placeable> list4 = arrayList;
                                int i33 = m2577getMaxHeightimpl;
                                Integer num4 = num32;
                                int size9 = list4.size();
                                for (int i34 = 0; i34 < size9; i34++) {
                                    Placeable.PlacementScope.place$default(placementScope, list4.get(i34), 0, i33 - (num4 != null ? num4.intValue() : 0), 0.0f, 4, null);
                                }
                                List<Placeable> list5 = arrayList4;
                                FabPlacement fabPlacement3 = fabPlacement22;
                                int i35 = m2577getMaxHeightimpl;
                                Integer num5 = num;
                                int size10 = list5.size();
                                for (int i36 = 0; i36 < size10; i36++) {
                                    Placeable.PlacementScope.place$default(placementScope, list5.get(i36), fabPlacement3 != null ? fabPlacement3.getLeft() : 0, i35 - (num5 != null ? num5.intValue() : 0), 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            } else {
                i8 = 1;
                i9 = 0;
            }
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) rememberedValue, startRestartGroup, i9, i8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$2
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
                    ScaffoldKt.m721ScaffoldLayouti1QSOvI(z5, i5, function2, function3, function22, function23, windowInsets, function24, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
                }
            });
        }
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }

    public static final ScaffoldState rememberScaffoldState(DrawerState drawerState, SnackbarHostState snackbarHostState, Composer composer, int i5, int i6) {
        if ((i6 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, composer, 6, 2);
        }
        if ((i6 & 2) != 0) {
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(rememberedValue);
            }
            snackbarHostState = (SnackbarHostState) rememberedValue;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1569641925, i5, -1, "androidx.compose.material.rememberScaffoldState (Scaffold.kt:74)");
        }
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new ScaffoldState(drawerState, snackbarHostState);
            composer.updateRememberedValue(rememberedValue2);
        }
        ScaffoldState scaffoldState = (ScaffoldState) rememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return scaffoldState;
    }
}
