package androidx.compose.material;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.adjust.sdk.Constants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a-\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0084\u0001\u0010\u001b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00022\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH\u0002¢\u0006\u0004\b \u0010!\u001a>\u0010(\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00032\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u00172\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00172\u0006\u0010%\u001a\u00020\u0013H\u0003ø\u0001\u0000¢\u0006\u0004\b&\u0010'\"\u0014\u0010)\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*\"\u0014\u0010+\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010*\"\u0014\u0010,\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010*\"\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001c0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/\"\u0014\u00100\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010*\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00062²\u0006\f\u00101\u001a\u00020\u001c8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material/DrawerValue;", "initialValue", "Lkotlin/Function1;", BuildConfig.FLAVOR, "confirmStateChange", "Landroidx/compose/material/DrawerState;", "rememberDrawerState", "(Landroidx/compose/material/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DrawerState;", "Landroidx/compose/foundation/layout/ColumnScope;", BuildConfig.FLAVOR, "drawerContent", "Landroidx/compose/ui/Modifier;", "modifier", "drawerState", "gesturesEnabled", "Landroidx/compose/ui/graphics/Shape;", "drawerShape", "Landroidx/compose/ui/unit/Dp;", "drawerElevation", "Landroidx/compose/ui/graphics/Color;", "drawerBackgroundColor", "drawerContentColor", "scrimColor", "Lkotlin/Function0;", "content", "ModalDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/DrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ModalDrawer", BuildConfig.FLAVOR, "a", "b", "pos", "calculateFraction", "(FFF)F", "open", "onClose", "fraction", "color", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "Scrim", "EndDrawerPadding", "F", "DrawerPositionalThreshold", "DrawerVelocityThreshold", "Landroidx/compose/animation/core/TweenSpec;", "AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "BottomDrawerOpenFraction", "alpha", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DrawerKt {
    private static final float BottomDrawerOpenFraction = 0.5f;
    private static final float DrawerPositionalThreshold;
    private static final float EndDrawerPadding;
    private static final float DrawerVelocityThreshold = Dp.m2599constructorimpl(Constants.MINIMAL_ERROR_STATUS_CODE);
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(256, 0, null, 6, null);

    static {
        float f5 = 56;
        EndDrawerPadding = Dp.m2599constructorimpl(f5);
        DrawerPositionalThreshold = Dp.m2599constructorimpl(f5);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x026f  */
    /* renamed from: ModalDrawer-Gs3lGvM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m689ModalDrawerGs3lGvM(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, DrawerState drawerState, boolean z5, Shape shape, float f5, long j5, long j6, long j7, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        DrawerState drawerState2;
        int i8;
        boolean z6;
        Shape shape2;
        int i9;
        float f6;
        int i10;
        Modifier modifier3;
        DrawerState drawerState3;
        Shape shape3;
        float m688getElevationD9Ej5fM;
        long j8;
        long j9;
        long j10;
        int i11;
        long j11;
        Object rememberedValue;
        final DrawerState drawerState4;
        final float f7;
        final boolean z7;
        final long j12;
        final long j13;
        final long j14;
        final Shape shape4;
        final Modifier modifier4;
        ScopeUpdateScope endRestartGroup;
        int i12;
        int i13;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(1305806945);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(function3) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i16 = i6 & 2;
        if (i16 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i5 & 384) != 0) {
                if ((i6 & 4) == 0) {
                    drawerState2 = drawerState;
                    if (startRestartGroup.changed(drawerState2)) {
                        i15 = 256;
                        i7 |= i15;
                    }
                } else {
                    drawerState2 = drawerState;
                }
                i15 = 128;
                i7 |= i15;
            } else {
                drawerState2 = drawerState;
            }
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                z6 = z5;
                i7 |= startRestartGroup.changed(z6) ? 2048 : 1024;
                if ((i5 & 24576) == 0) {
                    if ((i6 & 16) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i14 = 16384;
                            i7 |= i14;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i14 = 8192;
                    i7 |= i14;
                } else {
                    shape2 = shape;
                }
                i9 = i6 & 32;
                if (i9 != 0) {
                    i7 |= 196608;
                } else if ((196608 & i5) == 0) {
                    f6 = f5;
                    i7 |= startRestartGroup.changed(f6) ? 131072 : 65536;
                    if ((1572864 & i5) != 0) {
                        if ((i6 & 64) == 0) {
                            i12 = i7;
                            if (startRestartGroup.changed(j5)) {
                                i13 = 1048576;
                                i10 = i12 | i13;
                            }
                        } else {
                            i12 = i7;
                        }
                        i13 = 524288;
                        i10 = i12 | i13;
                    } else {
                        i10 = i7;
                    }
                    if ((i5 & 12582912) == 0) {
                        i10 |= ((i6 & 128) == 0 && startRestartGroup.changed(j6)) ? 8388608 : 4194304;
                    }
                    if ((100663296 & i5) == 0) {
                        i10 |= ((i6 & 256) == 0 && startRestartGroup.changed(j7)) ? 67108864 : 33554432;
                    }
                    if ((i6 & 512) == 0) {
                        i10 |= 805306368;
                    } else if ((i5 & 805306368) == 0) {
                        i10 |= startRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                    }
                    if ((306783379 & i10) == 306783378 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            modifier3 = i16 == 0 ? Modifier.INSTANCE : modifier2;
                            if ((i6 & 4) == 0) {
                                drawerState3 = rememberDrawerState(DrawerValue.Closed, null, startRestartGroup, 6, 2);
                                i10 &= -897;
                            } else {
                                drawerState3 = drawerState2;
                            }
                            if (i8 != 0) {
                                z6 = true;
                            }
                            if ((i6 & 16) == 0) {
                                shape3 = DrawerDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                i10 &= -57345;
                            } else {
                                shape3 = shape2;
                            }
                            m688getElevationD9Ej5fM = i9 == 0 ? DrawerDefaults.INSTANCE.m688getElevationD9Ej5fM() : f6;
                            if ((i6 & 64) == 0) {
                                j8 = DrawerDefaults.INSTANCE.getBackgroundColor(startRestartGroup, 6);
                                i10 &= -3670017;
                            } else {
                                j8 = j5;
                            }
                            if ((i6 & 128) == 0) {
                                j9 = ColorsKt.m673contentColorForek8zF_U(j8, startRestartGroup, (i10 >> 18) & 14);
                                i10 &= -29360129;
                            } else {
                                j9 = j6;
                            }
                            if ((i6 & 256) == 0) {
                                i11 = i10 & (-234881025);
                                j11 = j9;
                                j10 = DrawerDefaults.INSTANCE.getScrimColor(startRestartGroup, 6);
                            } else {
                                j10 = j7;
                                i11 = i10;
                                j11 = j9;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i6 & 4) != 0) {
                                i10 &= -897;
                            }
                            if ((i6 & 16) != 0) {
                                i10 &= -57345;
                            }
                            if ((i6 & 64) != 0) {
                                i10 &= -3670017;
                            }
                            if ((i6 & 128) != 0) {
                                i10 &= -29360129;
                            }
                            if ((i6 & 256) != 0) {
                                i10 &= -234881025;
                            }
                            j10 = j7;
                            modifier3 = modifier2;
                            drawerState3 = drawerState2;
                            shape3 = shape2;
                            m688getElevationD9Ej5fM = f6;
                            i11 = i10;
                            j8 = j5;
                            j11 = j6;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1305806945, i11, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:500)");
                        }
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                            startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                            rememberedValue = compositionScopedCoroutineScopeCanceller;
                        }
                        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                        final DrawerState drawerState5 = drawerState3;
                        final boolean z8 = z6;
                        final long j15 = j10;
                        final Shape shape5 = shape3;
                        final long j16 = j8;
                        final long j17 = j11;
                        final float f8 = m688getElevationD9Ej5fM;
                        Modifier modifier5 = modifier3;
                        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.rememberComposableLambda(816674999, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                                invoke(boxWithConstraintsScope, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i17) {
                                int i18;
                                float f9;
                                if ((i17 & 6) == 0) {
                                    i18 = i17 | (composer2.changed(boxWithConstraintsScope) ? 4 : 2);
                                } else {
                                    i18 = i17;
                                }
                                if ((i18 & 19) == 18 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(816674999, i18, -1, "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:503)");
                                }
                                long constraints = boxWithConstraintsScope.getConstraints();
                                if (Constraints.m2574getHasBoundedWidthimpl(constraints)) {
                                    final float f10 = -Constraints.m2578getMaxWidthimpl(constraints);
                                    final Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                    boolean changed = composer2.changed(DrawerState.this) | composer2.changed(density) | composer2.changed(f10);
                                    final DrawerState drawerState6 = DrawerState.this;
                                    Object rememberedValue2 = composer2.rememberedValue();
                                    final float f11 = 0.0f;
                                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                                DrawerState.this.setDensity$material_release(density);
                                                final float f12 = f10;
                                                final float f13 = f11;
                                                AnchoredDraggableState.updateAnchors$default(DrawerState.this.getAnchoredDraggableState$material_release(), AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1$anchors$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                                        invoke2(draggableAnchorsConfig);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                                        draggableAnchorsConfig.at(DrawerValue.Closed, f12);
                                                        draggableAnchorsConfig.at(DrawerValue.Open, f13);
                                                    }
                                                }), null, 2, null);
                                            }
                                        };
                                        composer2.updateRememberedValue(rememberedValue2);
                                    }
                                    EffectsKt.SideEffect((Function0) rememberedValue2, composer2, 0);
                                    boolean z9 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(companion, DrawerState.this.getAnchoredDraggableState$material_release(), Orientation.Horizontal, z8, z9, null, false, 48, null);
                                    final DrawerState drawerState7 = DrawerState.this;
                                    final boolean z10 = z8;
                                    final CoroutineScope coroutineScope2 = coroutineScope;
                                    long j18 = j15;
                                    Shape shape6 = shape5;
                                    long j19 = j16;
                                    long j20 = j17;
                                    float f12 = f8;
                                    Function2<Composer, Integer, Unit> function22 = function2;
                                    final Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                    Alignment.Companion companion2 = Alignment.INSTANCE;
                                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, anchoredDraggable$default);
                                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
                                    Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
                                    Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
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
                                    Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                                    if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                                    function22.invoke(composer2, 0);
                                    composer2.endNode();
                                    boolean isOpen = drawerState7.isOpen();
                                    boolean changed2 = composer2.changed(z10) | composer2.changed(drawerState7) | composer2.changedInstance(coroutineScope2);
                                    Object rememberedValue3 = composer2.rememberedValue();
                                    if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue3 = new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1

                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                            @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1$1", f = "Drawer.kt", l = {542}, m = "invokeSuspend")
                                            /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1$1, reason: invalid class name */
                                            /* loaded from: classes.dex */
                                            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ DrawerState $drawerState;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                                    super(2, continuation);
                                                    this.$drawerState = drawerState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new AnonymousClass1(this.$drawerState, continuation);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object obj) {
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    int i5 = this.label;
                                                    if (i5 == 0) {
                                                        ResultKt.throwOnFailure(obj);
                                                        DrawerState drawerState = this.$drawerState;
                                                        this.label = 1;
                                                        if (drawerState.close(this) == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                    } else {
                                                        if (i5 != 1) {
                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                        }
                                                        ResultKt.throwOnFailure(obj);
                                                    }
                                                    return Unit.INSTANCE;
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                }
                                            }

                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                                if (z10 && drawerState7.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(drawerState7, null), 3, null);
                                                }
                                            }
                                        };
                                        composer2.updateRememberedValue(rememberedValue3);
                                    }
                                    Function0 function0 = (Function0) rememberedValue3;
                                    boolean changed3 = composer2.changed(f10) | composer2.changed(drawerState7);
                                    Object rememberedValue4 = composer2.rememberedValue();
                                    if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                        final float f13 = 0.0f;
                                        rememberedValue4 = new Function0<Float>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$3$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Float invoke() {
                                                float calculateFraction;
                                                calculateFraction = DrawerKt.calculateFraction(f10, f13, drawerState7.requireOffset$material_release());
                                                return Float.valueOf(calculateFraction);
                                            }
                                        };
                                        composer2.updateRememberedValue(rememberedValue4);
                                    }
                                    DrawerKt.m690ScrimBx497Mc(isOpen, function0, (Function0) rememberedValue4, j18, composer2, 0);
                                    final String m735getString4foXLRw = Strings_androidKt.m735getString4foXLRw(Strings.INSTANCE.m732getNavigationMenuUdPEhr4(), composer2, 6);
                                    Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                    Modifier m334sizeInqDBjuR0 = SizeKt.m334sizeInqDBjuR0(companion, density2.mo209toDpu2uoSUM(Constraints.m2580getMinWidthimpl(constraints)), density2.mo209toDpu2uoSUM(Constraints.m2579getMinHeightimpl(constraints)), density2.mo209toDpu2uoSUM(Constraints.m2578getMaxWidthimpl(constraints)), density2.mo209toDpu2uoSUM(Constraints.m2577getMaxHeightimpl(constraints)));
                                    boolean changed4 = composer2.changed(drawerState7);
                                    Object rememberedValue5 = composer2.rememberedValue();
                                    if (changed4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue5 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$5$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ IntOffset invoke(Density density3) {
                                                return IntOffset.m2632boximpl(m692invokeBjo55l4(density3));
                                            }

                                            /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                            public final long m692invokeBjo55l4(Density density3) {
                                                return IntOffsetKt.IntOffset(MathKt.roundToInt(DrawerState.this.requireOffset$material_release()), 0);
                                            }
                                        };
                                        composer2.updateRememberedValue(rememberedValue5);
                                    }
                                    Modifier offset = OffsetKt.offset(m334sizeInqDBjuR0, (Function1) rememberedValue5);
                                    f9 = DrawerKt.EndDrawerPadding;
                                    Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(offset, 0.0f, 0.0f, f9, 0.0f, 11, null);
                                    boolean changed5 = composer2.changed(m735getString4foXLRw) | composer2.changed(drawerState7) | composer2.changedInstance(coroutineScope2);
                                    Object rememberedValue6 = composer2.rememberedValue();
                                    if (changed5 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue6 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1
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
                                                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m735getString4foXLRw);
                                                if (drawerState7.isOpen()) {
                                                    final DrawerState drawerState8 = drawerState7;
                                                    final CoroutineScope coroutineScope3 = coroutineScope2;
                                                    SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1.1

                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                        @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1$1", f = "Drawer.kt", l = {577}, m = "invokeSuspend")
                                                        /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1$1, reason: invalid class name and collision with other inner class name */
                                                        /* loaded from: classes.dex */
                                                        public static final class C00181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                            final /* synthetic */ DrawerState $drawerState;
                                                            int label;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            C00181(DrawerState drawerState, Continuation<? super C00181> continuation) {
                                                                super(2, continuation);
                                                                this.$drawerState = drawerState;
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                return new C00181(this.$drawerState, continuation);
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Object invokeSuspend(Object obj) {
                                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                int i5 = this.label;
                                                                if (i5 == 0) {
                                                                    ResultKt.throwOnFailure(obj);
                                                                    DrawerState drawerState = this.$drawerState;
                                                                    this.label = 1;
                                                                    if (drawerState.close(this) == coroutine_suspended) {
                                                                        return coroutine_suspended;
                                                                    }
                                                                } else {
                                                                    if (i5 != 1) {
                                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                    }
                                                                    ResultKt.throwOnFailure(obj);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                return ((C00181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                            }
                                                        }

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Boolean invoke() {
                                                            if (DrawerState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C00181(DrawerState.this, null), 3, null);
                                                            }
                                                            return Boolean.TRUE;
                                                        }
                                                    }, 1, null);
                                                }
                                            }
                                        };
                                        composer2.updateRememberedValue(rememberedValue6);
                                    }
                                    SurfaceKt.m736SurfaceFjzlyU(SemanticsModifierKt.semantics$default(m315paddingqDBjuR0$default, false, (Function1) rememberedValue6, 1, null), shape6, j19, j20, null, f12, ComposableLambdaKt.rememberComposableLambda(-1941234439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$7
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

                                        public final void invoke(Composer composer3, int i19) {
                                            if ((i19 & 3) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1941234439, i19, -1, "androidx.compose.material.ModalDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:586)");
                                            }
                                            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer3, fillMaxSize$default);
                                            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
                                            if (composer3.getApplier() == null) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor3);
                                            } else {
                                                composer3.useNode();
                                            }
                                            Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer3);
                                            Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy, companion4.getSetMeasurePolicy());
                                            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
                                            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                            }
                                            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
                                            function33.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                                            composer3.endNode();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer2, 54), composer2, 1572864, 16);
                                    composer2.endNode();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                throw new IllegalStateException("Drawer shouldn't have infinite width");
                            }
                        }, startRestartGroup, 54), startRestartGroup, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        drawerState4 = drawerState3;
                        f7 = m688getElevationD9Ej5fM;
                        z7 = z6;
                        j12 = j8;
                        j13 = j11;
                        j14 = j10;
                        shape4 = shape3;
                        modifier4 = modifier5;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        drawerState4 = drawerState2;
                        z7 = z6;
                        shape4 = shape2;
                        f7 = f6;
                        j12 = j5;
                        j13 = j6;
                        j14 = j7;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$2
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
                                DrawerKt.m689ModalDrawerGs3lGvM(function3, modifier4, drawerState4, z7, shape4, f7, j12, j13, j14, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                            }
                        });
                        return;
                    }
                    return;
                }
                f6 = f5;
                if ((1572864 & i5) != 0) {
                }
                if ((i5 & 12582912) == 0) {
                }
                if ((100663296 & i5) == 0) {
                }
                if ((i6 & 512) == 0) {
                }
                if ((306783379 & i10) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i16 == 0) {
                }
                if ((i6 & 4) == 0) {
                }
                if (i8 != 0) {
                }
                if ((i6 & 16) == 0) {
                }
                if (i9 == 0) {
                }
                if ((i6 & 64) == 0) {
                }
                if ((i6 & 128) == 0) {
                }
                if ((i6 & 256) == 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                final CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                final DrawerState drawerState52 = drawerState3;
                final boolean z82 = z6;
                final long j152 = j10;
                final Shape shape52 = shape3;
                final long j162 = j8;
                final long j172 = j11;
                final float f82 = m688getElevationD9Ej5fM;
                Modifier modifier52 = modifier3;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.rememberComposableLambda(816674999, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                        invoke(boxWithConstraintsScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i17) {
                        int i18;
                        float f9;
                        if ((i17 & 6) == 0) {
                            i18 = i17 | (composer2.changed(boxWithConstraintsScope) ? 4 : 2);
                        } else {
                            i18 = i17;
                        }
                        if ((i18 & 19) == 18 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(816674999, i18, -1, "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:503)");
                        }
                        long constraints = boxWithConstraintsScope.getConstraints();
                        if (Constraints.m2574getHasBoundedWidthimpl(constraints)) {
                            final float f10 = -Constraints.m2578getMaxWidthimpl(constraints);
                            final Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                            boolean changed = composer2.changed(DrawerState.this) | composer2.changed(density) | composer2.changed(f10);
                            final DrawerState drawerState6 = DrawerState.this;
                            Object rememberedValue2 = composer2.rememberedValue();
                            final float f11 = 0.0f;
                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        DrawerState.this.setDensity$material_release(density);
                                        final float f12 = f10;
                                        final float f13 = f11;
                                        AnchoredDraggableState.updateAnchors$default(DrawerState.this.getAnchoredDraggableState$material_release(), AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1$anchors$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                                invoke2(draggableAnchorsConfig);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                                draggableAnchorsConfig.at(DrawerValue.Closed, f12);
                                                draggableAnchorsConfig.at(DrawerValue.Open, f13);
                                            }
                                        }), null, 2, null);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue2);
                            }
                            EffectsKt.SideEffect((Function0) rememberedValue2, composer2, 0);
                            boolean z9 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
                            Modifier.Companion companion = Modifier.INSTANCE;
                            Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(companion, DrawerState.this.getAnchoredDraggableState$material_release(), Orientation.Horizontal, z82, z9, null, false, 48, null);
                            final DrawerState drawerState7 = DrawerState.this;
                            final boolean z10 = z82;
                            final CoroutineScope coroutineScope22 = coroutineScope2;
                            long j18 = j152;
                            Shape shape6 = shape52;
                            long j19 = j162;
                            long j20 = j172;
                            float f12 = f82;
                            Function2<Composer, Integer, Unit> function22 = function2;
                            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                            Alignment.Companion companion2 = Alignment.INSTANCE;
                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, anchoredDraggable$default);
                            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
                            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
                            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
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
                            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                            function22.invoke(composer2, 0);
                            composer2.endNode();
                            boolean isOpen = drawerState7.isOpen();
                            boolean changed2 = composer2.changed(z10) | composer2.changed(drawerState7) | composer2.changedInstance(coroutineScope22);
                            Object rememberedValue3 = composer2.rememberedValue();
                            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1

                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1$1", f = "Drawer.kt", l = {542}, m = "invokeSuspend")
                                    /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1$1, reason: invalid class name */
                                    /* loaded from: classes.dex */
                                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ DrawerState $drawerState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                            super(2, continuation);
                                            this.$drawerState = drawerState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass1(this.$drawerState, continuation);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            int i5 = this.label;
                                            if (i5 == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                DrawerState drawerState = this.$drawerState;
                                                this.label = 1;
                                                if (drawerState.close(this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                            } else {
                                                if (i5 != 1) {
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }
                                                ResultKt.throwOnFailure(obj);
                                            }
                                            return Unit.INSTANCE;
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }
                                    }

                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        if (z10 && drawerState7.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope22, null, null, new AnonymousClass1(drawerState7, null), 3, null);
                                        }
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue3);
                            }
                            Function0 function0 = (Function0) rememberedValue3;
                            boolean changed3 = composer2.changed(f10) | composer2.changed(drawerState7);
                            Object rememberedValue4 = composer2.rememberedValue();
                            if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                final float f13 = 0.0f;
                                rememberedValue4 = new Function0<Float>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$3$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        float calculateFraction;
                                        calculateFraction = DrawerKt.calculateFraction(f10, f13, drawerState7.requireOffset$material_release());
                                        return Float.valueOf(calculateFraction);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue4);
                            }
                            DrawerKt.m690ScrimBx497Mc(isOpen, function0, (Function0) rememberedValue4, j18, composer2, 0);
                            final String m735getString4foXLRw = Strings_androidKt.m735getString4foXLRw(Strings.INSTANCE.m732getNavigationMenuUdPEhr4(), composer2, 6);
                            Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                            Modifier m334sizeInqDBjuR0 = SizeKt.m334sizeInqDBjuR0(companion, density2.mo209toDpu2uoSUM(Constraints.m2580getMinWidthimpl(constraints)), density2.mo209toDpu2uoSUM(Constraints.m2579getMinHeightimpl(constraints)), density2.mo209toDpu2uoSUM(Constraints.m2578getMaxWidthimpl(constraints)), density2.mo209toDpu2uoSUM(Constraints.m2577getMaxHeightimpl(constraints)));
                            boolean changed4 = composer2.changed(drawerState7);
                            Object rememberedValue5 = composer2.rememberedValue();
                            if (changed4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue5 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$5$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density3) {
                                        return IntOffset.m2632boximpl(m692invokeBjo55l4(density3));
                                    }

                                    /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                    public final long m692invokeBjo55l4(Density density3) {
                                        return IntOffsetKt.IntOffset(MathKt.roundToInt(DrawerState.this.requireOffset$material_release()), 0);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue5);
                            }
                            Modifier offset = OffsetKt.offset(m334sizeInqDBjuR0, (Function1) rememberedValue5);
                            f9 = DrawerKt.EndDrawerPadding;
                            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(offset, 0.0f, 0.0f, f9, 0.0f, 11, null);
                            boolean changed5 = composer2.changed(m735getString4foXLRw) | composer2.changed(drawerState7) | composer2.changedInstance(coroutineScope22);
                            Object rememberedValue6 = composer2.rememberedValue();
                            if (changed5 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue6 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1
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
                                        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m735getString4foXLRw);
                                        if (drawerState7.isOpen()) {
                                            final DrawerState drawerState8 = drawerState7;
                                            final CoroutineScope coroutineScope3 = coroutineScope22;
                                            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1.1

                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1$1", f = "Drawer.kt", l = {577}, m = "invokeSuspend")
                                                /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1$1, reason: invalid class name and collision with other inner class name */
                                                /* loaded from: classes.dex */
                                                public static final class C00181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ DrawerState $drawerState;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    C00181(DrawerState drawerState, Continuation<? super C00181> continuation) {
                                                        super(2, continuation);
                                                        this.$drawerState = drawerState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new C00181(this.$drawerState, continuation);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Object invokeSuspend(Object obj) {
                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        int i5 = this.label;
                                                        if (i5 == 0) {
                                                            ResultKt.throwOnFailure(obj);
                                                            DrawerState drawerState = this.$drawerState;
                                                            this.label = 1;
                                                            if (drawerState.close(this) == coroutine_suspended) {
                                                                return coroutine_suspended;
                                                            }
                                                        } else {
                                                            if (i5 != 1) {
                                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                            }
                                                            ResultKt.throwOnFailure(obj);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                        return ((C00181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                    }
                                                }

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    if (DrawerState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C00181(DrawerState.this, null), 3, null);
                                                    }
                                                    return Boolean.TRUE;
                                                }
                                            }, 1, null);
                                        }
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue6);
                            }
                            SurfaceKt.m736SurfaceFjzlyU(SemanticsModifierKt.semantics$default(m315paddingqDBjuR0$default, false, (Function1) rememberedValue6, 1, null), shape6, j19, j20, null, f12, ComposableLambdaKt.rememberComposableLambda(-1941234439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$7
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

                                public final void invoke(Composer composer3, int i19) {
                                    if ((i19 & 3) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1941234439, i19, -1, "androidx.compose.material.ModalDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:586)");
                                    }
                                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer3, fillMaxSize$default);
                                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
                                    if (composer3.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor3);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer3);
                                    Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy, companion4.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
                                    if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                        m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                        m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                    }
                                    Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
                                    function33.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                                    composer3.endNode();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer2, 54), composer2, 1572864, 16);
                            composer2.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        throw new IllegalStateException("Drawer shouldn't have infinite width");
                    }
                }, startRestartGroup, 54), startRestartGroup, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                }
                drawerState4 = drawerState3;
                f7 = m688getElevationD9Ej5fM;
                z7 = z6;
                j12 = j8;
                j13 = j11;
                j14 = j10;
                shape4 = shape3;
                modifier4 = modifier52;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z6 = z5;
            if ((i5 & 24576) == 0) {
            }
            i9 = i6 & 32;
            if (i9 != 0) {
            }
            f6 = f5;
            if ((1572864 & i5) != 0) {
            }
            if ((i5 & 12582912) == 0) {
            }
            if ((100663296 & i5) == 0) {
            }
            if ((i6 & 512) == 0) {
            }
            if ((306783379 & i10) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i16 == 0) {
            }
            if ((i6 & 4) == 0) {
            }
            if (i8 != 0) {
            }
            if ((i6 & 16) == 0) {
            }
            if (i9 == 0) {
            }
            if ((i6 & 64) == 0) {
            }
            if ((i6 & 128) == 0) {
            }
            if ((i6 & 256) == 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            final CoroutineScope coroutineScope22 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            final DrawerState drawerState522 = drawerState3;
            final boolean z822 = z6;
            final long j1522 = j10;
            final Shape shape522 = shape3;
            final long j1622 = j8;
            final long j1722 = j11;
            final float f822 = m688getElevationD9Ej5fM;
            Modifier modifier522 = modifier3;
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.rememberComposableLambda(816674999, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                    invoke(boxWithConstraintsScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i17) {
                    int i18;
                    float f9;
                    if ((i17 & 6) == 0) {
                        i18 = i17 | (composer2.changed(boxWithConstraintsScope) ? 4 : 2);
                    } else {
                        i18 = i17;
                    }
                    if ((i18 & 19) == 18 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(816674999, i18, -1, "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:503)");
                    }
                    long constraints = boxWithConstraintsScope.getConstraints();
                    if (Constraints.m2574getHasBoundedWidthimpl(constraints)) {
                        final float f10 = -Constraints.m2578getMaxWidthimpl(constraints);
                        final Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        boolean changed = composer2.changed(DrawerState.this) | composer2.changed(density) | composer2.changed(f10);
                        final DrawerState drawerState6 = DrawerState.this;
                        Object rememberedValue2 = composer2.rememberedValue();
                        final float f11 = 0.0f;
                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    DrawerState.this.setDensity$material_release(density);
                                    final float f12 = f10;
                                    final float f13 = f11;
                                    AnchoredDraggableState.updateAnchors$default(DrawerState.this.getAnchoredDraggableState$material_release(), AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1$anchors$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                            invoke2(draggableAnchorsConfig);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                            draggableAnchorsConfig.at(DrawerValue.Closed, f12);
                                            draggableAnchorsConfig.at(DrawerValue.Open, f13);
                                        }
                                    }), null, 2, null);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue2);
                        }
                        EffectsKt.SideEffect((Function0) rememberedValue2, composer2, 0);
                        boolean z9 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
                        Modifier.Companion companion = Modifier.INSTANCE;
                        Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(companion, DrawerState.this.getAnchoredDraggableState$material_release(), Orientation.Horizontal, z822, z9, null, false, 48, null);
                        final DrawerState drawerState7 = DrawerState.this;
                        final boolean z10 = z822;
                        final CoroutineScope coroutineScope222 = coroutineScope22;
                        long j18 = j1522;
                        Shape shape6 = shape522;
                        long j19 = j1622;
                        long j20 = j1722;
                        float f12 = f822;
                        Function2<Composer, Integer, Unit> function22 = function2;
                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                        Alignment.Companion companion2 = Alignment.INSTANCE;
                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, anchoredDraggable$default);
                        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
                        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
                        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
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
                        Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                        function22.invoke(composer2, 0);
                        composer2.endNode();
                        boolean isOpen = drawerState7.isOpen();
                        boolean changed2 = composer2.changed(z10) | composer2.changed(drawerState7) | composer2.changedInstance(coroutineScope222);
                        Object rememberedValue3 = composer2.rememberedValue();
                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1

                                /* JADX INFO: Access modifiers changed from: package-private */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1$1", f = "Drawer.kt", l = {542}, m = "invokeSuspend")
                                /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1$1, reason: invalid class name */
                                /* loaded from: classes.dex */
                                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ DrawerState $drawerState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$drawerState = drawerState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$drawerState, continuation);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i5 = this.label;
                                        if (i5 == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            DrawerState drawerState = this.$drawerState;
                                            this.label = 1;
                                            if (drawerState.close(this) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        } else {
                                            if (i5 != 1) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            ResultKt.throwOnFailure(obj);
                                        }
                                        return Unit.INSTANCE;
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }
                                }

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    if (z10 && drawerState7.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope222, null, null, new AnonymousClass1(drawerState7, null), 3, null);
                                    }
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue3);
                        }
                        Function0 function0 = (Function0) rememberedValue3;
                        boolean changed3 = composer2.changed(f10) | composer2.changed(drawerState7);
                        Object rememberedValue4 = composer2.rememberedValue();
                        if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            final float f13 = 0.0f;
                            rememberedValue4 = new Function0<Float>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$3$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    float calculateFraction;
                                    calculateFraction = DrawerKt.calculateFraction(f10, f13, drawerState7.requireOffset$material_release());
                                    return Float.valueOf(calculateFraction);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue4);
                        }
                        DrawerKt.m690ScrimBx497Mc(isOpen, function0, (Function0) rememberedValue4, j18, composer2, 0);
                        final String m735getString4foXLRw = Strings_androidKt.m735getString4foXLRw(Strings.INSTANCE.m732getNavigationMenuUdPEhr4(), composer2, 6);
                        Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        Modifier m334sizeInqDBjuR0 = SizeKt.m334sizeInqDBjuR0(companion, density2.mo209toDpu2uoSUM(Constraints.m2580getMinWidthimpl(constraints)), density2.mo209toDpu2uoSUM(Constraints.m2579getMinHeightimpl(constraints)), density2.mo209toDpu2uoSUM(Constraints.m2578getMaxWidthimpl(constraints)), density2.mo209toDpu2uoSUM(Constraints.m2577getMaxHeightimpl(constraints)));
                        boolean changed4 = composer2.changed(drawerState7);
                        Object rememberedValue5 = composer2.rememberedValue();
                        if (changed4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue5 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$5$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ IntOffset invoke(Density density3) {
                                    return IntOffset.m2632boximpl(m692invokeBjo55l4(density3));
                                }

                                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                public final long m692invokeBjo55l4(Density density3) {
                                    return IntOffsetKt.IntOffset(MathKt.roundToInt(DrawerState.this.requireOffset$material_release()), 0);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue5);
                        }
                        Modifier offset = OffsetKt.offset(m334sizeInqDBjuR0, (Function1) rememberedValue5);
                        f9 = DrawerKt.EndDrawerPadding;
                        Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(offset, 0.0f, 0.0f, f9, 0.0f, 11, null);
                        boolean changed5 = composer2.changed(m735getString4foXLRw) | composer2.changed(drawerState7) | composer2.changedInstance(coroutineScope222);
                        Object rememberedValue6 = composer2.rememberedValue();
                        if (changed5 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue6 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1
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
                                    SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m735getString4foXLRw);
                                    if (drawerState7.isOpen()) {
                                        final DrawerState drawerState8 = drawerState7;
                                        final CoroutineScope coroutineScope3 = coroutineScope222;
                                        SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1.1

                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                            @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1$1", f = "Drawer.kt", l = {577}, m = "invokeSuspend")
                                            /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1$1, reason: invalid class name and collision with other inner class name */
                                            /* loaded from: classes.dex */
                                            public static final class C00181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ DrawerState $drawerState;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                C00181(DrawerState drawerState, Continuation<? super C00181> continuation) {
                                                    super(2, continuation);
                                                    this.$drawerState = drawerState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new C00181(this.$drawerState, continuation);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object obj) {
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    int i5 = this.label;
                                                    if (i5 == 0) {
                                                        ResultKt.throwOnFailure(obj);
                                                        DrawerState drawerState = this.$drawerState;
                                                        this.label = 1;
                                                        if (drawerState.close(this) == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                    } else {
                                                        if (i5 != 1) {
                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                        }
                                                        ResultKt.throwOnFailure(obj);
                                                    }
                                                    return Unit.INSTANCE;
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                    return ((C00181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                }
                                            }

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                if (DrawerState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C00181(DrawerState.this, null), 3, null);
                                                }
                                                return Boolean.TRUE;
                                            }
                                        }, 1, null);
                                    }
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue6);
                        }
                        SurfaceKt.m736SurfaceFjzlyU(SemanticsModifierKt.semantics$default(m315paddingqDBjuR0$default, false, (Function1) rememberedValue6, 1, null), shape6, j19, j20, null, f12, ComposableLambdaKt.rememberComposableLambda(-1941234439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$7
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

                            public final void invoke(Composer composer3, int i19) {
                                if ((i19 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1941234439, i19, -1, "androidx.compose.material.ModalDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:586)");
                                }
                                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer3, fillMaxSize$default);
                                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
                                if (composer3.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor3);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer3);
                                Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy, companion4.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
                                if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                }
                                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
                                function33.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                                composer3.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, 1572864, 16);
                        composer2.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    throw new IllegalStateException("Drawer shouldn't have infinite width");
                }
            }, startRestartGroup, 54), startRestartGroup, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
            }
            drawerState4 = drawerState3;
            f7 = m688getElevationD9Ej5fM;
            z7 = z6;
            j12 = j8;
            j13 = j11;
            j14 = j10;
            shape4 = shape3;
            modifier4 = modifier522;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i5 & 384) != 0) {
        }
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        z6 = z5;
        if ((i5 & 24576) == 0) {
        }
        i9 = i6 & 32;
        if (i9 != 0) {
        }
        f6 = f5;
        if ((1572864 & i5) != 0) {
        }
        if ((i5 & 12582912) == 0) {
        }
        if ((100663296 & i5) == 0) {
        }
        if ((i6 & 512) == 0) {
        }
        if ((306783379 & i10) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i16 == 0) {
        }
        if ((i6 & 4) == 0) {
        }
        if (i8 != 0) {
        }
        if ((i6 & 16) == 0) {
        }
        if (i9 == 0) {
        }
        if ((i6 & 64) == 0) {
        }
        if ((i6 & 128) == 0) {
        }
        if ((i6 & 256) == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        final CoroutineScope coroutineScope222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        final DrawerState drawerState5222 = drawerState3;
        final boolean z8222 = z6;
        final long j15222 = j10;
        final Shape shape5222 = shape3;
        final long j16222 = j8;
        final long j17222 = j11;
        final float f8222 = m688getElevationD9Ej5fM;
        Modifier modifier5222 = modifier3;
        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.rememberComposableLambda(816674999, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                invoke(boxWithConstraintsScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i17) {
                int i18;
                float f9;
                if ((i17 & 6) == 0) {
                    i18 = i17 | (composer2.changed(boxWithConstraintsScope) ? 4 : 2);
                } else {
                    i18 = i17;
                }
                if ((i18 & 19) == 18 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(816674999, i18, -1, "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:503)");
                }
                long constraints = boxWithConstraintsScope.getConstraints();
                if (Constraints.m2574getHasBoundedWidthimpl(constraints)) {
                    final float f10 = -Constraints.m2578getMaxWidthimpl(constraints);
                    final Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    boolean changed = composer2.changed(DrawerState.this) | composer2.changed(density) | composer2.changed(f10);
                    final DrawerState drawerState6 = DrawerState.this;
                    Object rememberedValue2 = composer2.rememberedValue();
                    final float f11 = 0.0f;
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                DrawerState.this.setDensity$material_release(density);
                                final float f12 = f10;
                                final float f13 = f11;
                                AnchoredDraggableState.updateAnchors$default(DrawerState.this.getAnchoredDraggableState$material_release(), AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1$anchors$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                        invoke2(draggableAnchorsConfig);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                        draggableAnchorsConfig.at(DrawerValue.Closed, f12);
                                        draggableAnchorsConfig.at(DrawerValue.Open, f13);
                                    }
                                }), null, 2, null);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    EffectsKt.SideEffect((Function0) rememberedValue2, composer2, 0);
                    boolean z9 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(companion, DrawerState.this.getAnchoredDraggableState$material_release(), Orientation.Horizontal, z8222, z9, null, false, 48, null);
                    final DrawerState drawerState7 = DrawerState.this;
                    final boolean z10 = z8222;
                    final CoroutineScope coroutineScope2222 = coroutineScope222;
                    long j18 = j15222;
                    Shape shape6 = shape5222;
                    long j19 = j16222;
                    long j20 = j17222;
                    float f12 = f8222;
                    Function2<Composer, Integer, Unit> function22 = function2;
                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                    Alignment.Companion companion2 = Alignment.INSTANCE;
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, anchoredDraggable$default);
                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
                    Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
                    Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
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
                    Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                    if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                    function22.invoke(composer2, 0);
                    composer2.endNode();
                    boolean isOpen = drawerState7.isOpen();
                    boolean changed2 = composer2.changed(z10) | composer2.changed(drawerState7) | composer2.changedInstance(coroutineScope2222);
                    Object rememberedValue3 = composer2.rememberedValue();
                    if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1

                            /* JADX INFO: Access modifiers changed from: package-private */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1$1", f = "Drawer.kt", l = {542}, m = "invokeSuspend")
                            /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1$1, reason: invalid class name */
                            /* loaded from: classes.dex */
                            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = drawerState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$drawerState, continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i5 = this.label;
                                    if (i5 == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        DrawerState drawerState = this.$drawerState;
                                        this.label = 1;
                                        if (drawerState.close(this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i5 != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    return Unit.INSTANCE;
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                if (z10 && drawerState7.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2222, null, null, new AnonymousClass1(drawerState7, null), 3, null);
                                }
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue3);
                    }
                    Function0 function0 = (Function0) rememberedValue3;
                    boolean changed3 = composer2.changed(f10) | composer2.changed(drawerState7);
                    Object rememberedValue4 = composer2.rememberedValue();
                    if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        final float f13 = 0.0f;
                        rememberedValue4 = new Function0<Float>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$3$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Float invoke() {
                                float calculateFraction;
                                calculateFraction = DrawerKt.calculateFraction(f10, f13, drawerState7.requireOffset$material_release());
                                return Float.valueOf(calculateFraction);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue4);
                    }
                    DrawerKt.m690ScrimBx497Mc(isOpen, function0, (Function0) rememberedValue4, j18, composer2, 0);
                    final String m735getString4foXLRw = Strings_androidKt.m735getString4foXLRw(Strings.INSTANCE.m732getNavigationMenuUdPEhr4(), composer2, 6);
                    Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    Modifier m334sizeInqDBjuR0 = SizeKt.m334sizeInqDBjuR0(companion, density2.mo209toDpu2uoSUM(Constraints.m2580getMinWidthimpl(constraints)), density2.mo209toDpu2uoSUM(Constraints.m2579getMinHeightimpl(constraints)), density2.mo209toDpu2uoSUM(Constraints.m2578getMaxWidthimpl(constraints)), density2.mo209toDpu2uoSUM(Constraints.m2577getMaxHeightimpl(constraints)));
                    boolean changed4 = composer2.changed(drawerState7);
                    Object rememberedValue5 = composer2.rememberedValue();
                    if (changed4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$5$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ IntOffset invoke(Density density3) {
                                return IntOffset.m2632boximpl(m692invokeBjo55l4(density3));
                            }

                            /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                            public final long m692invokeBjo55l4(Density density3) {
                                return IntOffsetKt.IntOffset(MathKt.roundToInt(DrawerState.this.requireOffset$material_release()), 0);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue5);
                    }
                    Modifier offset = OffsetKt.offset(m334sizeInqDBjuR0, (Function1) rememberedValue5);
                    f9 = DrawerKt.EndDrawerPadding;
                    Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(offset, 0.0f, 0.0f, f9, 0.0f, 11, null);
                    boolean changed5 = composer2.changed(m735getString4foXLRw) | composer2.changed(drawerState7) | composer2.changedInstance(coroutineScope2222);
                    Object rememberedValue6 = composer2.rememberedValue();
                    if (changed5 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue6 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1
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
                                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m735getString4foXLRw);
                                if (drawerState7.isOpen()) {
                                    final DrawerState drawerState8 = drawerState7;
                                    final CoroutineScope coroutineScope3 = coroutineScope2222;
                                    SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1.1

                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                        @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1$1", f = "Drawer.kt", l = {577}, m = "invokeSuspend")
                                        /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1$1, reason: invalid class name and collision with other inner class name */
                                        /* loaded from: classes.dex */
                                        public static final class C00181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ DrawerState $drawerState;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            C00181(DrawerState drawerState, Continuation<? super C00181> continuation) {
                                                super(2, continuation);
                                                this.$drawerState = drawerState;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                return new C00181(this.$drawerState, continuation);
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Object invokeSuspend(Object obj) {
                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                int i5 = this.label;
                                                if (i5 == 0) {
                                                    ResultKt.throwOnFailure(obj);
                                                    DrawerState drawerState = this.$drawerState;
                                                    this.label = 1;
                                                    if (drawerState.close(this) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                } else {
                                                    if (i5 != 1) {
                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                    }
                                                    ResultKt.throwOnFailure(obj);
                                                }
                                                return Unit.INSTANCE;
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                return ((C00181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                            }
                                        }

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            if (DrawerState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C00181(DrawerState.this, null), 3, null);
                                            }
                                            return Boolean.TRUE;
                                        }
                                    }, 1, null);
                                }
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue6);
                    }
                    SurfaceKt.m736SurfaceFjzlyU(SemanticsModifierKt.semantics$default(m315paddingqDBjuR0$default, false, (Function1) rememberedValue6, 1, null), shape6, j19, j20, null, f12, ComposableLambdaKt.rememberComposableLambda(-1941234439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$7
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

                        public final void invoke(Composer composer3, int i19) {
                            if ((i19 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1941234439, i19, -1, "androidx.compose.material.ModalDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:586)");
                            }
                            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer3, fillMaxSize$default);
                            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
                            if (composer3.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor3);
                            } else {
                                composer3.useNode();
                            }
                            Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer3);
                            Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy, companion4.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
                            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                            }
                            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
                            function33.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                            composer3.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 1572864, 16);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Drawer shouldn't have infinite width");
            }
        }, startRestartGroup, 54), startRestartGroup, 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
        }
        drawerState4 = drawerState3;
        f7 = m688getElevationD9Ej5fM;
        z7 = z6;
        j12 = j8;
        j13 = j11;
        j14 = j10;
        shape4 = shape3;
        modifier4 = modifier5222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim-Bx497Mc, reason: not valid java name */
    public static final void m690ScrimBx497Mc(final boolean z5, final Function0<Unit> function0, final Function0<Float> function02, final long j5, Composer composer, final int i5) {
        int i6;
        Modifier modifier;
        Composer startRestartGroup = composer.startRestartGroup(1983403750);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(j5) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1983403750, i6, -1, "androidx.compose.material.Scrim (Drawer.kt:829)");
            }
            final String m735getString4foXLRw = Strings_androidKt.m735getString4foXLRw(Strings.INSTANCE.m728getCloseDrawerUdPEhr4(), startRestartGroup, 6);
            if (z5) {
                startRestartGroup.startReplaceGroup(487729414);
                Modifier.Companion companion = Modifier.INSTANCE;
                int i7 = i6 & 112;
                boolean z6 = i7 == 32;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new DrawerKt$Scrim$dismissDrawer$1$1(function0, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2) rememberedValue);
                boolean changed = (i7 == 32) | startRestartGroup.changed(m735getString4foXLRw);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1
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
                            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, m735getString4foXLRw);
                            final Function0<Unit> function03 = function0;
                            SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    function03.invoke();
                                    return Boolean.TRUE;
                                }
                            }, 1, null);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                modifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) rememberedValue2);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(487978282);
                startRestartGroup.endReplaceGroup();
                modifier = Modifier.INSTANCE;
            }
            Modifier then = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(modifier);
            boolean z7 = ((i6 & 7168) == 2048) | ((i6 & 896) == 256);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope drawScope) {
                        DrawScope.m1698drawRectnJ9OG0$default(drawScope, j5, 0L, 0L, function02.invoke().floatValue(), null, null, 0, 118, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            CanvasKt.Canvas(then, (Function1) rememberedValue3, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$2
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

                public final void invoke(Composer composer2, int i8) {
                    DrawerKt.m690ScrimBx497Mc(z5, function0, function02, j5, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateFraction(float f5, float f6, float f7) {
        float f8 = (f7 - f5) / (f6 - f5);
        if (f8 < 0.0f) {
            f8 = 0.0f;
        }
        if (f8 > 1.0f) {
            return 1.0f;
        }
        return f8;
    }

    public static final DrawerState rememberDrawerState(final DrawerValue drawerValue, final Function1<? super DrawerValue, Boolean> function1, Composer composer, int i5, int i6) {
        if ((i6 & 2) != 0) {
            function1 = new Function1<DrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt$rememberDrawerState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(DrawerValue drawerValue2) {
                    return Boolean.TRUE;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1435874229, i5, -1, "androidx.compose.material.rememberDrawerState (Drawer.kt:429)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.INSTANCE.Saver(function1);
        boolean z5 = ((((i5 & 14) ^ 6) > 4 && composer.changed(drawerValue)) || (i5 & 6) == 4) | ((((i5 & 112) ^ 48) > 32 && composer.changed(function1)) || (i5 & 48) == 32);
        Object rememberedValue = composer.rememberedValue();
        if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0<DrawerState>() { // from class: androidx.compose.material.DrawerKt$rememberDrawerState$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DrawerState invoke() {
                    return new DrawerState(DrawerValue.this, function1);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        DrawerState drawerState = (DrawerState) RememberSaveableKt.rememberSaveable(objArr, Saver, null, (Function0) rememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return drawerState;
    }
}
