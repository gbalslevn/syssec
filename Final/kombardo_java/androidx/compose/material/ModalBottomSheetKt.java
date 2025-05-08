package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
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
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001aG\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u0084\u0001\u0010\u001f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001b\u0010 \u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010!\u001a0\u0010'\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00172\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\u001b2\u0006\u0010$\u001a\u00020\u0006H\u0003ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a#\u0010-\u001a\u00020,2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030(2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b-\u0010.\"\u0014\u0010/\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100\"\u0014\u00101\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00100\"\u0014\u00102\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00100\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00064²\u0006\f\u00103\u001a\u00020\u00038\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material/ModalBottomSheetValue;", "initialValue", "Landroidx/compose/animation/core/AnimationSpec;", BuildConfig.FLAVOR, "animationSpec", "Lkotlin/Function1;", BuildConfig.FLAVOR, "confirmValueChange", "skipHalfExpanded", "Landroidx/compose/material/ModalBottomSheetState;", "rememberModalBottomSheetState", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "Landroidx/compose/foundation/layout/ColumnScope;", BuildConfig.FLAVOR, "sheetContent", "Landroidx/compose/ui/Modifier;", "modifier", "sheetState", "sheetGesturesEnabled", "Landroidx/compose/ui/graphics/Shape;", "sheetShape", "Landroidx/compose/ui/unit/Dp;", "sheetElevation", "Landroidx/compose/ui/graphics/Color;", "sheetBackgroundColor", "sheetContentColor", "scrimColor", "Lkotlin/Function0;", "content", "ModalBottomSheetLayout-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ModalBottomSheetState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ModalBottomSheetLayout", "modalBottomSheetAnchors", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ModalBottomSheetState;)Landroidx/compose/ui/Modifier;", "color", "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "Scrim", "Landroidx/compose/material/AnchoredDraggableState;", "state", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "(Landroidx/compose/material/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "ModalBottomSheetPositionalThreshold", "F", "ModalBottomSheetVelocityThreshold", "MaxModalBottomSheetWidth", "alpha", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ModalBottomSheetKt {
    private static final float ModalBottomSheetPositionalThreshold = Dp.m2599constructorimpl(56);
    private static final float ModalBottomSheetVelocityThreshold = Dp.m2599constructorimpl(125);
    private static final float MaxModalBottomSheetWidth = Dp.m2599constructorimpl(640);

    private static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
        return new ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(anchoredDraggableState, orientation);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0228  */
    /* renamed from: ModalBottomSheetLayout-Gs3lGvM */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m708ModalBottomSheetLayoutGs3lGvM(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, ModalBottomSheetState modalBottomSheetState, boolean z5, Shape shape, float f5, long j5, long j6, long j7, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        ModalBottomSheetState modalBottomSheetState2;
        int i8;
        boolean z6;
        int i9;
        long j8;
        long j9;
        int i10;
        Modifier modifier3;
        boolean z7;
        final ModalBottomSheetState modalBottomSheetState3;
        Shape shape2;
        float f6;
        long j10;
        long j11;
        float f7;
        Object rememberedValue;
        Composer.Companion companion;
        final CoroutineScope coroutineScope;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        Shape shape3;
        boolean changedInstance;
        Object rememberedValue2;
        Modifier modifier4;
        final float f8;
        final boolean z8;
        final long j12;
        final Modifier modifier5;
        ScopeUpdateScope endRestartGroup;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-92970288);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(function3) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i12 = i6 & 2;
        if (i12 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i5 & 384) != 0) {
                if ((i6 & 4) == 0) {
                    modalBottomSheetState2 = modalBottomSheetState;
                    if (startRestartGroup.changedInstance(modalBottomSheetState2)) {
                        i11 = 256;
                        i7 |= i11;
                    }
                } else {
                    modalBottomSheetState2 = modalBottomSheetState;
                }
                i11 = 128;
                i7 |= i11;
            } else {
                modalBottomSheetState2 = modalBottomSheetState;
            }
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
                z6 = z5;
            } else {
                z6 = z5;
                if ((i5 & 3072) == 0) {
                    i7 |= startRestartGroup.changed(z6) ? 2048 : 1024;
                }
            }
            if ((i5 & 24576) == 0) {
                i7 |= ((i6 & 16) == 0 && startRestartGroup.changed(shape)) ? 16384 : 8192;
            }
            if ((196608 & i5) == 0) {
                i7 |= ((i6 & 32) == 0 && startRestartGroup.changed(f5)) ? 131072 : 65536;
            }
            if ((i5 & 1572864) == 0) {
                i7 |= ((i6 & 64) == 0 && startRestartGroup.changed(j5)) ? 1048576 : 524288;
            }
            if ((12582912 & i5) != 0) {
                i9 = i8;
                j8 = j6;
                i7 |= ((i6 & 128) == 0 && startRestartGroup.changed(j8)) ? 8388608 : 4194304;
            } else {
                i9 = i8;
                j8 = j6;
            }
            if ((100663296 & i5) != 0) {
                j9 = j7;
                i7 |= ((i6 & 256) == 0 && startRestartGroup.changed(j9)) ? 67108864 : 33554432;
            } else {
                j9 = j7;
            }
            if ((i6 & 512) == 0) {
                i7 |= 805306368;
            } else if ((i5 & 805306368) == 0) {
                i7 |= startRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
            }
            i10 = i7;
            if ((306783379 & i10) == 306783378 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    Modifier modifier6 = i12 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i6 & 4) == 0) {
                        modifier3 = modifier6;
                        z7 = true;
                        modalBottomSheetState3 = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, null, null, false, startRestartGroup, 6, 14);
                        i10 &= -897;
                    } else {
                        modifier3 = modifier6;
                        z7 = true;
                        modalBottomSheetState3 = modalBottomSheetState2;
                    }
                    if (i9 != 0) {
                        z6 = z7;
                    }
                    if ((i6 & 16) == 0) {
                        shape2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getLarge();
                        i10 &= -57345;
                    } else {
                        shape2 = shape;
                    }
                    if ((i6 & 32) == 0) {
                        f6 = ModalBottomSheetDefaults.INSTANCE.m707getElevationD9Ej5fM();
                        i10 &= -458753;
                    } else {
                        f6 = f5;
                    }
                    if ((i6 & 64) == 0) {
                        j10 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m671getSurface0d7_KjU();
                        i10 &= -3670017;
                    } else {
                        j10 = j5;
                    }
                    if ((i6 & 128) != 0) {
                        j8 = ColorsKt.m673contentColorForek8zF_U(j10, startRestartGroup, (i10 >> 18) & 14);
                        i10 = (-29360129) & i10;
                    }
                    if ((i6 & 256) == 0) {
                        i10 &= -234881025;
                        f7 = f6;
                        j11 = ModalBottomSheetDefaults.INSTANCE.getScrimColor(startRestartGroup, 0);
                    } else {
                        j11 = j7;
                        f7 = f6;
                    }
                    modifier2 = modifier3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i6 & 4) != 0) {
                        i10 &= -897;
                    }
                    if ((i6 & 16) != 0) {
                        i10 &= -57345;
                    }
                    if ((i6 & 32) != 0) {
                        i10 &= -458753;
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
                    shape2 = shape;
                    f7 = f5;
                    j11 = j7;
                    j10 = j5;
                    modalBottomSheetState3 = modalBottomSheetState2;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-92970288, i10, -1, "androidx.compose.material.ModalBottomSheetLayout (ModalBottomSheet.kt:361)");
                }
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                    startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                    rememberedValue = compositionScopedCoroutineScopeCanceller;
                }
                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                Orientation orientation = Orientation.Vertical;
                Alignment.Companion companion2 = Alignment.INSTANCE;
                float f9 = f7;
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                long j13 = j8;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                Modifier modifier7 = modifier2;
                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor);
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                long j14 = j10;
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                Modifier modifier8 = Modifier.INSTANCE;
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier8, 0.0f, 1, null);
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor2);
                }
                m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                shape3 = shape2;
                Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                if (!m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                function2.invoke(startRestartGroup, Integer.valueOf((i10 >> 27) & 14));
                changedInstance = startRestartGroup.changedInstance(modalBottomSheetState3) | startRestartGroup.changedInstance(coroutineScope);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changedInstance || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1

                        /* JADX INFO: Access modifiers changed from: package-private */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1$1", f = "ModalBottomSheet.kt", l = {372}, m = "invokeSuspend")
                        /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1$1, reason: invalid class name */
                        /* loaded from: classes.dex */
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ ModalBottomSheetState $sheetState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$sheetState = modalBottomSheetState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$sheetState, continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i5 = this.label;
                                if (i5 == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                                    this.label = 1;
                                    if (modalBottomSheetState.hide(this) == coroutine_suspended) {
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
                            if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(ModalBottomSheetState.this, null), 3, null);
                            }
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                Function0 function0 = (Function0) rememberedValue2;
                ModalBottomSheetValue targetValue = modalBottomSheetState3.getAnchoredDraggableState$material_release().getTargetValue();
                ModalBottomSheetValue modalBottomSheetValue = ModalBottomSheetValue.Hidden;
                m709Scrim3JVO9M(j11, function0, targetValue == modalBottomSheetValue, startRestartGroup, (i10 >> 24) & 14);
                startRestartGroup.endNode();
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m338widthInVpY3zN4$default(boxScopeInstance.align(modifier8, companion2.getTopCenter()), 0.0f, MaxModalBottomSheetWidth, 1, null), 0.0f, 1, null);
                if (z6) {
                    startRestartGroup.startReplaceGroup(-167338882);
                    startRestartGroup.endReplaceGroup();
                    modifier4 = modifier8;
                } else {
                    startRestartGroup.startReplaceGroup(-893004563);
                    boolean changed = startRestartGroup.changed(modalBottomSheetState3.getAnchoredDraggableState$material_release());
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue3 == companion.getEmpty()) {
                        rememberedValue3 = ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(modalBottomSheetState3.getAnchoredDraggableState$material_release(), orientation);
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    modifier4 = NestedScrollModifierKt.nestedScroll$default(modifier8, (NestedScrollConnection) rememberedValue3, null, 2, null);
                    startRestartGroup.endReplaceGroup();
                }
                Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(modalBottomSheetAnchors(fillMaxWidth$default.then(modifier4), modalBottomSheetState3), modalBottomSheetState3.getAnchoredDraggableState$material_release(), orientation, (z6 || modalBottomSheetState3.getAnchoredDraggableState$material_release().getCurrentValue() == modalBottomSheetValue) ? false : true, false, null, false, 56, null);
                if (z6) {
                    startRestartGroup.startReplaceGroup(-167264258);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-892034697);
                    boolean changedInstance2 = startRestartGroup.changedInstance(modalBottomSheetState3) | startRestartGroup.changedInstance(coroutineScope);
                    Object rememberedValue4 = startRestartGroup.rememberedValue();
                    if (changedInstance2 || rememberedValue4 == companion.getEmpty()) {
                        rememberedValue4 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1
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
                                if (ModalBottomSheetState.this.isVisible()) {
                                    final ModalBottomSheetState modalBottomSheetState4 = ModalBottomSheetState.this;
                                    final CoroutineScope coroutineScope2 = coroutineScope;
                                    SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1.1

                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                        @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1$1$1", f = "ModalBottomSheet.kt", l = {410}, m = "invokeSuspend")
                                        /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1$1$1, reason: invalid class name and collision with other inner class name */
                                        /* loaded from: classes.dex */
                                        public static final class C00201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ ModalBottomSheetState $sheetState;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            C00201(ModalBottomSheetState modalBottomSheetState, Continuation<? super C00201> continuation) {
                                                super(2, continuation);
                                                this.$sheetState = modalBottomSheetState;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                return new C00201(this.$sheetState, continuation);
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Object invokeSuspend(Object obj) {
                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                int i5 = this.label;
                                                if (i5 == 0) {
                                                    ResultKt.throwOnFailure(obj);
                                                    ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                                                    this.label = 1;
                                                    if (modalBottomSheetState.hide(this) == coroutine_suspended) {
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
                                                return ((C00201) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                            }
                                        }

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C00201(ModalBottomSheetState.this, null), 3, null);
                                            }
                                            return Boolean.TRUE;
                                        }
                                    }, 1, null);
                                    if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getCurrentValue() == ModalBottomSheetValue.HalfExpanded) {
                                        final ModalBottomSheetState modalBottomSheetState5 = ModalBottomSheetState.this;
                                        final CoroutineScope coroutineScope3 = coroutineScope;
                                        SemanticsPropertiesKt.expand$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1.2

                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                            @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1$2$1", f = "ModalBottomSheet.kt", l = {422}, m = "invokeSuspend")
                                            /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1$2$1, reason: invalid class name */
                                            /* loaded from: classes.dex */
                                            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ ModalBottomSheetState $sheetState;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                                    super(2, continuation);
                                                    this.$sheetState = modalBottomSheetState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new AnonymousClass1(this.$sheetState, continuation);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object obj) {
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    int i5 = this.label;
                                                    if (i5 == 0) {
                                                        ResultKt.throwOnFailure(obj);
                                                        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                                                        this.label = 1;
                                                        if (modalBottomSheetState.expand$material_release(this) == coroutine_suspended) {
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

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.Expanded).booleanValue()) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass1(ModalBottomSheetState.this, null), 3, null);
                                                }
                                                return Boolean.TRUE;
                                            }
                                        }, 1, null);
                                    } else if (ModalBottomSheetState.this.getHasHalfExpandedState$material_release()) {
                                        final ModalBottomSheetState modalBottomSheetState6 = ModalBottomSheetState.this;
                                        final CoroutineScope coroutineScope4 = coroutineScope;
                                        SemanticsPropertiesKt.collapse$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1.3

                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                            @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1$3$1", f = "ModalBottomSheet.kt", l = {432}, m = "invokeSuspend")
                                            /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1$3$1, reason: invalid class name */
                                            /* loaded from: classes.dex */
                                            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ ModalBottomSheetState $sheetState;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                                    super(2, continuation);
                                                    this.$sheetState = modalBottomSheetState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new AnonymousClass1(this.$sheetState, continuation);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object obj) {
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    int i5 = this.label;
                                                    if (i5 == 0) {
                                                        ResultKt.throwOnFailure(obj);
                                                        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                                                        this.label = 1;
                                                        if (modalBottomSheetState.halfExpand$material_release(this) == coroutine_suspended) {
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

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.HalfExpanded).booleanValue()) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, null, new AnonymousClass1(ModalBottomSheetState.this, null), 3, null);
                                                }
                                                return Boolean.TRUE;
                                            }
                                        }, 1, null);
                                    }
                                }
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                    }
                    modifier8 = SemanticsModifierKt.semantics$default(modifier8, false, (Function1) rememberedValue4, 1, null);
                    startRestartGroup.endReplaceGroup();
                }
                int i13 = i10 >> 12;
                SurfaceKt.m736SurfaceFjzlyU(anchoredDraggable$default.then(modifier8), shape3, j14, j13, null, f9, ComposableLambdaKt.rememberComposableLambda(17396558, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4
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

                    public final void invoke(Composer composer2, int i14) {
                        if ((i14 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(17396558, i14, -1, "androidx.compose.material.ModalBottomSheetLayout.<anonymous>.<anonymous> (ModalBottomSheet.kt:445)");
                        }
                        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                        Modifier.Companion companion4 = Modifier.INSTANCE;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, companion4);
                        ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor3 = companion5.getConstructor();
                        if (composer2.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor3);
                        } else {
                            composer2.useNode();
                        }
                        Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer2);
                        Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy, companion5.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion5.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion5.getSetCompositeKeyHash();
                        if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion5.getSetModifier());
                        function32.invoke(ColumnScopeInstance.INSTANCE, composer2, 6);
                        composer2.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, ((i10 >> 9) & 112) | 1572864 | (i13 & 896) | (i13 & 7168) | (458752 & i10), 16);
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f8 = f9;
                modalBottomSheetState2 = modalBottomSheetState3;
                z8 = z6;
                j8 = j13;
                j12 = j14;
                modifier5 = modifier7;
            } else {
                startRestartGroup.skipToGroupEnd();
                shape3 = shape;
                f8 = f5;
                modifier5 = modifier2;
                j11 = j9;
                z8 = z6;
                j12 = j5;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final ModalBottomSheetState modalBottomSheetState4 = modalBottomSheetState2;
                final Shape shape4 = shape3;
                final long j15 = j8;
                final long j16 = j11;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2
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

                    public final void invoke(Composer composer2, int i14) {
                        ModalBottomSheetKt.m708ModalBottomSheetLayoutGs3lGvM(function3, modifier5, modalBottomSheetState4, z8, shape4, f8, j12, j15, j16, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i5 & 384) != 0) {
        }
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        if ((i5 & 24576) == 0) {
        }
        if ((196608 & i5) == 0) {
        }
        if ((i5 & 1572864) == 0) {
        }
        if ((12582912 & i5) != 0) {
        }
        if ((100663296 & i5) != 0) {
        }
        if ((i6 & 512) == 0) {
        }
        i10 = i7;
        if ((306783379 & i10) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i12 == 0) {
        }
        if ((i6 & 4) == 0) {
        }
        if (i9 != 0) {
        }
        if ((i6 & 16) == 0) {
        }
        if ((i6 & 32) == 0) {
        }
        if ((i6 & 64) == 0) {
        }
        if ((i6 & 128) != 0) {
        }
        if ((i6 & 256) == 0) {
        }
        modifier2 = modifier3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        Orientation orientation2 = Orientation.Vertical;
        Alignment.Companion companion22 = Alignment.INSTANCE;
        float f92 = f7;
        MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion22.getTopStart(), false);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
        long j132 = j8;
        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
        ComposeUiNode.Companion companion32 = ComposeUiNode.INSTANCE;
        Modifier modifier72 = modifier2;
        Function0<ComposeUiNode> constructor3 = companion32.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        long j142 = j10;
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy3, companion32.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap3, companion32.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion32.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier3, companion32.getSetModifier());
        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
        Modifier modifier82 = Modifier.INSTANCE;
        Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier82, 0.0f, 1, null);
        MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(companion22.getTopStart(), false);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default2);
        Function0<ComposeUiNode> constructor22 = companion32.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        shape3 = shape2;
        Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy22, companion32.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion32.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion32.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion32.getSetModifier());
        function2.invoke(startRestartGroup, Integer.valueOf((i10 >> 27) & 14));
        changedInstance = startRestartGroup.changedInstance(modalBottomSheetState3) | startRestartGroup.changedInstance(coroutineScope);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1$1", f = "ModalBottomSheet.kt", l = {372}, m = "invokeSuspend")
            /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1$1, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ ModalBottomSheetState $sheetState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$sheetState = modalBottomSheetState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$sheetState, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i5 = this.label;
                    if (i5 == 0) {
                        ResultKt.throwOnFailure(obj);
                        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                        this.label = 1;
                        if (modalBottomSheetState.hide(this) == coroutine_suspended) {
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
                if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(ModalBottomSheetState.this, null), 3, null);
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        Function0 function02 = (Function0) rememberedValue2;
        ModalBottomSheetValue targetValue2 = modalBottomSheetState3.getAnchoredDraggableState$material_release().getTargetValue();
        ModalBottomSheetValue modalBottomSheetValue2 = ModalBottomSheetValue.Hidden;
        m709Scrim3JVO9M(j11, function02, targetValue2 == modalBottomSheetValue2, startRestartGroup, (i10 >> 24) & 14);
        startRestartGroup.endNode();
        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(SizeKt.m338widthInVpY3zN4$default(boxScopeInstance2.align(modifier82, companion22.getTopCenter()), 0.0f, MaxModalBottomSheetWidth, 1, null), 0.0f, 1, null);
        if (z6) {
        }
        Modifier anchoredDraggable$default2 = AnchoredDraggableKt.anchoredDraggable$default(modalBottomSheetAnchors(fillMaxWidth$default2.then(modifier4), modalBottomSheetState3), modalBottomSheetState3.getAnchoredDraggableState$material_release(), orientation2, (z6 || modalBottomSheetState3.getAnchoredDraggableState$material_release().getCurrentValue() == modalBottomSheetValue2) ? false : true, false, null, false, 56, null);
        if (z6) {
        }
        int i132 = i10 >> 12;
        SurfaceKt.m736SurfaceFjzlyU(anchoredDraggable$default2.then(modifier82), shape3, j142, j132, null, f92, ComposableLambdaKt.rememberComposableLambda(17396558, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1$4
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

            public final void invoke(Composer composer2, int i14) {
                if ((i14 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(17396558, i14, -1, "androidx.compose.material.ModalBottomSheetLayout.<anonymous>.<anonymous> (ModalBottomSheet.kt:445)");
                }
                Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                Modifier.Companion companion4 = Modifier.INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap32 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(composer2, companion4);
                ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor32 = companion5.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor32);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy, companion5.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap32, companion5.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = companion5.getSetCompositeKeyHash();
                if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash32);
                }
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier32, companion5.getSetModifier());
                function32.invoke(ColumnScopeInstance.INSTANCE, composer2, 6);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, ((i10 >> 9) & 112) | 1572864 | (i132 & 896) | (i132 & 7168) | (458752 & i10), 16);
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        f8 = f92;
        modalBottomSheetState2 = modalBottomSheetState3;
        z8 = z6;
        j8 = j132;
        j12 = j142;
        modifier5 = modifier72;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* renamed from: Scrim-3J-VO9M */
    public static final void m709Scrim3JVO9M(final long j5, final Function0<Unit> function0, final boolean z5, Composer composer, final int i5) {
        int i6;
        Modifier modifier;
        Composer startRestartGroup = composer.startRestartGroup(-526532668);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(j5) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        int i7 = i6;
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-526532668, i7, -1, "androidx.compose.material.Scrim (ModalBottomSheet.kt:496)");
            }
            if (j5 != 16) {
                startRestartGroup.startReplaceGroup(477285297);
                final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z5 ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, startRestartGroup, 48, 28);
                final String m735getString4foXLRw = Strings_androidKt.m735getString4foXLRw(Strings.INSTANCE.m729getCloseSheetUdPEhr4(), startRestartGroup, 6);
                if (z5) {
                    startRestartGroup.startReplaceGroup(477511845);
                    Modifier.Companion companion = Modifier.INSTANCE;
                    int i8 = i7 & 112;
                    boolean z6 = i8 == 32;
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new ModalBottomSheetKt$Scrim$dismissModifier$1$1(function0, null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2) rememberedValue);
                    boolean changed = startRestartGroup.changed(m735getString4foXLRw) | (i8 == 32);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$dismissModifier$2$1
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
                                final Function0<Unit> function02 = function0;
                                SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$dismissModifier$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        function02.invoke();
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
                    startRestartGroup.startReplaceGroup(477792674);
                    startRestartGroup.endReplaceGroup();
                    modifier = Modifier.INSTANCE;
                }
                Modifier then = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(modifier);
                boolean changed2 = startRestartGroup.changed(animateFloatAsState) | ((i7 & 14) == 4);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$1$1
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
                            float Scrim_3J_VO9M$lambda$6;
                            long j6 = j5;
                            Scrim_3J_VO9M$lambda$6 = ModalBottomSheetKt.Scrim_3J_VO9M$lambda$6(animateFloatAsState);
                            DrawScope.m1698drawRectnJ9OG0$default(drawScope, j6, 0L, 0L, Scrim_3J_VO9M$lambda$6, null, null, 0, 118, null);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                CanvasKt.Canvas(then, (Function1) rememberedValue3, startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(478008930);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$2
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

                public final void invoke(Composer composer2, int i9) {
                    ModalBottomSheetKt.m709Scrim3JVO9M(j5, function0, z5, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    public static final float Scrim_3J_VO9M$lambda$6(State<Float> state) {
        return state.getValue().floatValue();
    }

    public static final /* synthetic */ float access$getModalBottomSheetPositionalThreshold$p() {
        return ModalBottomSheetPositionalThreshold;
    }

    public static final /* synthetic */ float access$getModalBottomSheetVelocityThreshold$p() {
        return ModalBottomSheetVelocityThreshold;
    }

    private static final Modifier modalBottomSheetAnchors(Modifier modifier, final ModalBottomSheetState modalBottomSheetState) {
        return AnchoredDraggableKt.draggableAnchors(modifier, modalBottomSheetState.getAnchoredDraggableState$material_release(), Orientation.Vertical, new Function2<IntSize, Constraints, Pair<? extends DraggableAnchors<ModalBottomSheetValue>, ? extends ModalBottomSheetValue>>() { // from class: androidx.compose.material.ModalBottomSheetKt$modalBottomSheetAnchors$1

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ModalBottomSheetValue.values().length];
                    try {
                        iArr[ModalBottomSheetValue.Hidden.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ModalBottomSheetValue.HalfExpanded.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ModalBottomSheetValue.Expanded.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Pair<? extends DraggableAnchors<ModalBottomSheetValue>, ? extends ModalBottomSheetValue> invoke(IntSize intSize, Constraints constraints) {
                return m713invokeGpV2Q24(intSize.getPackedValue(), constraints.getValue());
            }

            /* renamed from: invoke-GpV2Q24, reason: not valid java name */
            public final Pair<DraggableAnchors<ModalBottomSheetValue>, ModalBottomSheetValue> m713invokeGpV2Q24(final long j5, long j6) {
                final float m2577getMaxHeightimpl = Constraints.m2577getMaxHeightimpl(j6);
                final ModalBottomSheetState modalBottomSheetState2 = ModalBottomSheetState.this;
                DraggableAnchors DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<ModalBottomSheetValue>, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$modalBottomSheetAnchors$1$newAnchors$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<ModalBottomSheetValue> draggableAnchorsConfig) {
                        invoke2(draggableAnchorsConfig);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DraggableAnchorsConfig<ModalBottomSheetValue> draggableAnchorsConfig) {
                        draggableAnchorsConfig.at(ModalBottomSheetValue.Hidden, m2577getMaxHeightimpl);
                        float f5 = m2577getMaxHeightimpl / 2.0f;
                        if (!modalBottomSheetState2.getIsSkipHalfExpanded() && IntSize.m2660getHeightimpl(j5) > f5) {
                            draggableAnchorsConfig.at(ModalBottomSheetValue.HalfExpanded, f5);
                        }
                        if (IntSize.m2660getHeightimpl(j5) != 0) {
                            draggableAnchorsConfig.at(ModalBottomSheetValue.Expanded, Math.max(0.0f, m2577getMaxHeightimpl - IntSize.m2660getHeightimpl(j5)));
                        }
                    }
                });
                boolean z5 = ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getAnchors().getSize() > 0;
                ModalBottomSheetValue currentValue = ModalBottomSheetState.this.getCurrentValue();
                if (z5 || !DraggableAnchors.hasAnchorFor(currentValue)) {
                    int i5 = WhenMappings.$EnumSwitchMapping$0[ModalBottomSheetState.this.getTargetValue().ordinal()];
                    if (i5 == 1) {
                        currentValue = ModalBottomSheetValue.Hidden;
                    } else {
                        if (i5 != 2 && i5 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        ModalBottomSheetValue modalBottomSheetValue = ModalBottomSheetValue.HalfExpanded;
                        if (!DraggableAnchors.hasAnchorFor(modalBottomSheetValue)) {
                            modalBottomSheetValue = ModalBottomSheetValue.Expanded;
                            if (!DraggableAnchors.hasAnchorFor(modalBottomSheetValue)) {
                                modalBottomSheetValue = ModalBottomSheetValue.Hidden;
                            }
                        }
                        currentValue = modalBottomSheetValue;
                    }
                }
                return TuplesKt.to(DraggableAnchors, currentValue);
            }
        });
    }

    public static final ModalBottomSheetState rememberModalBottomSheetState(final ModalBottomSheetValue modalBottomSheetValue, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> function1, boolean z5, Composer composer, int i5, int i6) {
        final AnimationSpec<Float> animationSpec2 = (i6 & 2) != 0 ? ModalBottomSheetDefaults.INSTANCE.getAnimationSpec() : animationSpec;
        final Function1<? super ModalBottomSheetValue, Boolean> function12 = (i6 & 4) != 0 ? new Function1<ModalBottomSheetValue, Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ModalBottomSheetValue modalBottomSheetValue2) {
                return Boolean.TRUE;
            }
        } : function1;
        boolean z6 = (i6 & 8) != 0 ? false : z5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-126412120, i5, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:291)");
        }
        final Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        composer.startMovableGroup(976450751, modalBottomSheetValue);
        Object[] objArr = {modalBottomSheetValue, animationSpec2, Boolean.valueOf(z6), function12, density};
        Saver<ModalBottomSheetState, ?> Saver = ModalBottomSheetState.INSTANCE.Saver(animationSpec2, function12, z6, density);
        boolean changed = ((((i5 & 14) ^ 6) > 4 && composer.changed(modalBottomSheetValue)) || (i5 & 6) == 4) | composer.changed(density) | ((((i5 & 896) ^ 384) > 256 && composer.changed(function12)) || (i5 & 384) == 256) | composer.changedInstance(animationSpec2) | ((((i5 & 7168) ^ 3072) > 2048 && composer.changed(z6)) || (i5 & 3072) == 2048);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            final boolean z7 = z6;
            Object obj = new Function0<ModalBottomSheetState>() { // from class: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ModalBottomSheetState invoke() {
                    return new ModalBottomSheetState(ModalBottomSheetValue.this, density, function12, animationSpec2, z7);
                }
            };
            composer.updateRememberedValue(obj);
            rememberedValue = obj;
        }
        ModalBottomSheetState modalBottomSheetState = (ModalBottomSheetState) RememberSaveableKt.rememberSaveable(objArr, Saver, null, (Function0) rememberedValue, composer, 0, 4);
        composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return modalBottomSheetState;
    }
}
