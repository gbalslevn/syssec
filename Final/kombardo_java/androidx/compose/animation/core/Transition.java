package androidx.compose.animation.core;

import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.List;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\b\u000b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\b\u0090\u0001\u0091\u0001\u0092\u0001\u0093\u0001B1\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB#\b\u0011\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\nB\u001b\b\u0010\u0012\u0006\u0010\u000b\u001a\u00028\u0000\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u001f\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001bH\u0000¢\u0006\u0004\b\u0017\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\rH\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\"\u001a\u00020\u0010H\u0000¢\u0006\u0004\b!\u0010\u0012J\u000f\u0010$\u001a\u00020\u0010H\u0000¢\u0006\u0004\b#\u0010\u0012J'\u0010)\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010%\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\rH\u0007¢\u0006\u0004\b'\u0010(J\u001b\u0010-\u001a\u00020\u001b2\n\u0010*\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0004\b+\u0010,J\u001b\u0010/\u001a\u00020\u001b2\n\u0010*\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0004\b.\u0010,J)\u00104\u001a\u00020\u001b2\u0018\u00101\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u000300R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0004\b2\u00103J)\u00107\u001a\u00020\u00102\u0018\u00101\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u000300R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0004\b5\u00106J\u0017\u0010:\u001a\u00020\u00102\u0006\u0010%\u001a\u00028\u0000H\u0000¢\u0006\u0004\b8\u00109J\u0017\u0010=\u001a\u00020\u00102\u0006\u0010%\u001a\u00028\u0000H\u0001¢\u0006\u0004\b;\u0010<J\u0017\u0010?\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\rH\u0000¢\u0006\u0004\b>\u0010\u001fJ\u0017\u0010D\u001a\u00020\u00102\u0006\u0010A\u001a\u00020@H\u0000¢\u0006\u0004\bB\u0010CJ\u0017\u0010H\u001a\u00020\u00102\u0006\u0010E\u001a\u00020\u0015H\u0000¢\u0006\u0004\bF\u0010GJ\u000f\u0010J\u001a\u00020\u0010H\u0000¢\u0006\u0004\bI\u0010\u0012J\u000f\u0010L\u001a\u00020\u0010H\u0000¢\u0006\u0004\bK\u0010\u0012J\u000f\u0010M\u001a\u00020\u0006H\u0016¢\u0006\u0004\bM\u0010NJ)\u00107\u001a\u00020\u00102\u0018\u0010P\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030OR\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0004\b5\u0010QR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010RR\u001d\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\b\u0005\u0010S\u001a\u0004\bT\u0010UR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010V\u001a\u0004\bW\u0010NR+\u0010%\u001a\u00028\u00002\u0006\u0010X\u001a\u00028\u00008F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u00109R7\u0010d\u001a\b\u0012\u0004\u0012\u00028\u00000^2\f\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00000^8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b_\u0010Z\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR+\u0010i\u001a\u00020\r2\u0006\u0010X\u001a\u00020\r8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010\u000f\"\u0004\bh\u0010\u001fR+\u0010m\u001a\u00020\r2\u0006\u0010X\u001a\u00020\r8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bj\u0010f\u001a\u0004\bk\u0010\u000f\"\u0004\bl\u0010\u001fR+\u0010s\u001a\u00020\u001b2\u0006\u0010X\u001a\u00020\u001b8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bn\u0010Z\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR,\u0010u\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u000300R\b\u0012\u0004\u0012\u00028\u00000\u00000t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u001e\u0010w\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010vR+\u0010y\u001a\u00020\u001b2\u0006\u0010X\u001a\u00020\u001b8G@AX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bx\u0010Z\u001a\u0004\by\u0010p\"\u0004\bz\u0010rR\"\u0010{\u001a\u00020\r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b{\u0010|\u001a\u0004\b}\u0010\u000f\"\u0004\b~\u0010\u001fR\u001e\u0010\u0082\u0001\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0005\b\u0081\u0001\u0010\u000fR\u0013\u0010\u0084\u0001\u001a\u00028\u00008F¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010\\R\u0013\u0010\u0085\u0001\u001a\u00020\u001b8F¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010pR'\u0010&\u001a\u00020\r2\u0007\u0010\u0086\u0001\u001a\u00020\r8G@GX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0087\u0001\u0010\u000f\"\u0005\b\u0088\u0001\u0010\u001fR-\u0010\u008c\u0001\u001a\u001b\u0012\u0016\u0012\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u000300R\b\u0012\u0004\u0012\u00028\u00000\u00000\u0089\u00018F¢\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001d\u0010\u008f\u0001\u001a\u00020\u001b8GX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u008e\u0001\u0010\u0012\u001a\u0005\b\u008d\u0001\u0010p¨\u0006\u0094\u0001"}, d2 = {"Landroidx/compose/animation/core/Transition;", "S", BuildConfig.FLAVOR, "Landroidx/compose/animation/core/TransitionState;", "transitionState", "parentTransition", BuildConfig.FLAVOR, "label", "<init>", "(Landroidx/compose/animation/core/TransitionState;Landroidx/compose/animation/core/Transition;Ljava/lang/String;)V", "(Landroidx/compose/animation/core/TransitionState;Ljava/lang/String;)V", "initialState", "(Ljava/lang/Object;Ljava/lang/String;)V", BuildConfig.FLAVOR, "calculateTotalDurationNanos", "()J", BuildConfig.FLAVOR, "resetAnimations", "()V", "onChildAnimationUpdated", "frameTimeNanos", BuildConfig.FLAVOR, "durationScale", "onFrame$animation_core_release", "(JF)V", "onFrame", "scaledPlayTimeNanos", BuildConfig.FLAVOR, "scaleToEnd", "(JZ)V", "onTransitionStart$animation_core_release", "(J)V", "onTransitionStart", "onDisposed$animation_core_release", "onDisposed", "onTransitionEnd$animation_core_release", "onTransitionEnd", "targetState", "playTimeNanos", "seek", "(Ljava/lang/Object;Ljava/lang/Object;J)V", "setPlaytimeAfterInitialAndTargetStateEstablished", "transition", "addTransition$animation_core_release", "(Landroidx/compose/animation/core/Transition;)Z", "addTransition", "removeTransition$animation_core_release", "removeTransition", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "animation", "addAnimation$animation_core_release", "(Landroidx/compose/animation/core/Transition$TransitionAnimationState;)Z", "addAnimation", "removeAnimation$animation_core_release", "(Landroidx/compose/animation/core/Transition$TransitionAnimationState;)V", "removeAnimation", "updateTarget$animation_core_release", "(Ljava/lang/Object;)V", "updateTarget", "animateTo$animation_core_release", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "animateTo", "seekAnimations$animation_core_release", "seekAnimations", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "animationState", "setInitialAnimations$animation_core_release", "(Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;)V", "setInitialAnimations", "fraction", "resetAnimationFraction$animation_core_release", "(F)V", "resetAnimationFraction", "clearInitialAnimations$animation_core_release", "clearInitialAnimations", "updateInitialValues$animation_core_release", "updateInitialValues", "toString", "()Ljava/lang/String;", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "deferredAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "Landroidx/compose/animation/core/TransitionState;", "Landroidx/compose/animation/core/Transition;", "getParentTransition", "()Landroidx/compose/animation/core/Transition;", "Ljava/lang/String;", "getLabel", "<set-?>", "targetState$delegate", "Landroidx/compose/runtime/MutableState;", "getTargetState", "()Ljava/lang/Object;", "setTargetState$animation_core_release", "Landroidx/compose/animation/core/Transition$Segment;", "segment$delegate", "getSegment", "()Landroidx/compose/animation/core/Transition$Segment;", "setSegment", "(Landroidx/compose/animation/core/Transition$Segment;)V", "segment", "_playTimeNanos$delegate", "Landroidx/compose/runtime/MutableLongState;", "get_playTimeNanos", "set_playTimeNanos", "_playTimeNanos", "startTimeNanos$delegate", "getStartTimeNanos$animation_core_release", "setStartTimeNanos$animation_core_release", "startTimeNanos", "updateChildrenNeeded$delegate", "getUpdateChildrenNeeded", "()Z", "setUpdateChildrenNeeded", "(Z)V", "updateChildrenNeeded", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "_animations", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "_transitions", "isSeeking$delegate", "isSeeking", "setSeeking$animation_core_release", "lastSeekedTimeNanos", "J", "getLastSeekedTimeNanos$animation_core_release", "setLastSeekedTimeNanos$animation_core_release", "totalDurationNanos$delegate", "Landroidx/compose/runtime/State;", "getTotalDurationNanos", "totalDurationNanos", "getCurrentState", "currentState", "isRunning", "value", "getPlayTimeNanos", "setPlayTimeNanos", BuildConfig.FLAVOR, "getAnimations", "()Ljava/util/List;", "animations", "getHasInitialValueAnimations", "getHasInitialValueAnimations$annotations", "hasInitialValueAnimations", "DeferredAnimation", "Segment", "SegmentImpl", "TransitionAnimationState", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Transition<S> {
    private final SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> _animations;

    /* renamed from: _playTimeNanos$delegate, reason: from kotlin metadata */
    private final MutableLongState _playTimeNanos;
    private final SnapshotStateList<Transition<?>> _transitions;

    /* renamed from: isSeeking$delegate, reason: from kotlin metadata */
    private final MutableState isSeeking;
    private final String label;
    private long lastSeekedTimeNanos;
    private final Transition<?> parentTransition;

    /* renamed from: segment$delegate, reason: from kotlin metadata */
    private final MutableState segment;

    /* renamed from: startTimeNanos$delegate, reason: from kotlin metadata */
    private final MutableLongState startTimeNanos;

    /* renamed from: targetState$delegate, reason: from kotlin metadata */
    private final MutableState targetState;

    /* renamed from: totalDurationNanos$delegate, reason: from kotlin metadata */
    private final State totalDurationNanos;
    private final TransitionState<S> transitionState;

    /* renamed from: updateChildrenNeeded$delegate, reason: from kotlin metadata */
    private final MutableState updateChildrenNeeded;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\b\b\u0002\u0010\u0003*\u00020\u00022\u00020\u0004:\u0001'B%\b\u0000\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJG\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u00102\u001e\u0010\u000e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0016\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0014\u0010\u0015R#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR{\u0010&\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u001dR\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000R\b\u0012\u0004\u0012\u00028\u00000\u001e2.\u0010\u001f\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u001dR\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000R\b\u0012\u0004\u0012\u00028\u00000\u001e8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Landroidx/compose/animation/core/Transition$DeferredAnimation;", "T", "Landroidx/compose/animation/core/AnimationVector;", "V", BuildConfig.FLAVOR, "Landroidx/compose/animation/core/TwoWayConverter;", "typeConverter", BuildConfig.FLAVOR, "label", "<init>", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "transitionSpec", "targetValueByState", "Landroidx/compose/runtime/State;", "animate", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/State;", BuildConfig.FLAVOR, "setupSeeking$animation_core_release", "()V", "setupSeeking", "Landroidx/compose/animation/core/TwoWayConverter;", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "Ljava/lang/String;", "getLabel", "()Ljava/lang/String;", "Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "Landroidx/compose/animation/core/Transition;", "<set-?>", "data$delegate", "Landroidx/compose/runtime/MutableState;", "getData$animation_core_release", "()Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "setData$animation_core_release", "(Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;)V", "data", "DeferredAnimationData", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class DeferredAnimation<T, V extends AnimationVector> {

        /* renamed from: data$delegate, reason: from kotlin metadata */
        private final MutableState data;
        private final String label;
        private final TwoWayConverter<T, V> typeConverter;

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0080\u0004\u0018\u0000*\u0004\b\u0003\u0010\u0001*\b\b\u0004\u0010\u0003*\u00020\u00022\b\u0012\u0004\u0012\u00028\u00030\u0004BY\u0012\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0005R\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u001e\u0010\u000b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\n0\b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00030\b¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\u0011\u0010\u0012R-\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0005R\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R:\u0010\u000b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\n0\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR.\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00030\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001f\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "T", "Landroidx/compose/animation/core/AnimationVector;", "V", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "Landroidx/compose/animation/core/Transition;", "animation", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "transitionSpec", "targetValueByState", "<init>", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$TransitionAnimationState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "segment", BuildConfig.FLAVOR, "updateAnimationStates", "(Landroidx/compose/animation/core/Transition$Segment;)V", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "getAnimation", "()Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "Lkotlin/jvm/functions/Function1;", "getTransitionSpec", "()Lkotlin/jvm/functions/Function1;", "setTransitionSpec", "(Lkotlin/jvm/functions/Function1;)V", "getTargetValueByState", "setTargetValueByState", "getValue", "()Ljava/lang/Object;", "value", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        public final class DeferredAnimationData<T, V extends AnimationVector> implements State<T> {
            private final Transition<S>.TransitionAnimationState<T, V> animation;
            private Function1<? super S, ? extends T> targetValueByState;
            private Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> transitionSpec;

            public DeferredAnimationData(Transition<S>.TransitionAnimationState<T, V> transitionAnimationState, Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> function1, Function1<? super S, ? extends T> function12) {
                this.animation = transitionAnimationState;
                this.transitionSpec = function1;
                this.targetValueByState = function12;
            }

            public final Transition<S>.TransitionAnimationState<T, V> getAnimation() {
                return this.animation;
            }

            public final Function1<S, T> getTargetValueByState() {
                return this.targetValueByState;
            }

            public final Function1<Segment<S>, FiniteAnimationSpec<T>> getTransitionSpec() {
                return this.transitionSpec;
            }

            @Override // androidx.compose.runtime.State
            public T getValue() {
                updateAnimationStates(Transition.this.getSegment());
                return this.animation.getValue();
            }

            public final void setTargetValueByState(Function1<? super S, ? extends T> function1) {
                this.targetValueByState = function1;
            }

            public final void setTransitionSpec(Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> function1) {
                this.transitionSpec = function1;
            }

            public final void updateAnimationStates(Segment<S> segment) {
                T invoke = this.targetValueByState.invoke(segment.getTargetState());
                if (!Transition.this.isSeeking()) {
                    this.animation.updateTargetValue$animation_core_release(invoke, this.transitionSpec.invoke(segment));
                } else {
                    this.animation.updateInitialAndTargetValue$animation_core_release(this.targetValueByState.invoke(segment.getInitialState()), invoke, this.transitionSpec.invoke(segment));
                }
            }
        }

        public DeferredAnimation(TwoWayConverter<T, V> twoWayConverter, String str) {
            MutableState mutableStateOf$default;
            this.typeConverter = twoWayConverter;
            this.label = str;
            mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            this.data = mutableStateOf$default;
        }

        public final State<T> animate(Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> transitionSpec, Function1<? super S, ? extends T> targetValueByState) {
            Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> data$animation_core_release = getData$animation_core_release();
            if (data$animation_core_release == null) {
                Transition<S> transition = Transition.this;
                data$animation_core_release = new DeferredAnimationData<>(new TransitionAnimationState(targetValueByState.invoke(transition.getCurrentState()), AnimationStateKt.createZeroVectorFrom(this.typeConverter, targetValueByState.invoke(Transition.this.getCurrentState())), this.typeConverter, this.label), transitionSpec, targetValueByState);
                Transition<S> transition2 = Transition.this;
                setData$animation_core_release(data$animation_core_release);
                transition2.addAnimation$animation_core_release(data$animation_core_release.getAnimation());
            }
            Transition<S> transition3 = Transition.this;
            data$animation_core_release.setTargetValueByState(targetValueByState);
            data$animation_core_release.setTransitionSpec(transitionSpec);
            data$animation_core_release.updateAnimationStates(transition3.getSegment());
            return data$animation_core_release;
        }

        public final Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> getData$animation_core_release() {
            return (DeferredAnimationData) this.data.getValue();
        }

        public final void setData$animation_core_release(Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> deferredAnimationData) {
            this.data.setValue(deferredAnimationData);
        }

        public final void setupSeeking$animation_core_release() {
            Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> data$animation_core_release = getData$animation_core_release();
            if (data$animation_core_release != null) {
                Transition<S> transition = Transition.this;
                data$animation_core_release.getAnimation().updateInitialAndTargetValue$animation_core_release(data$animation_core_release.getTargetValueByState().invoke(transition.getSegment().getInitialState()), data$animation_core_release.getTargetValueByState().invoke(transition.getSegment().getTargetState()), data$animation_core_release.getTransitionSpec().invoke(transition.getSegment()));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u001a\u0010\b\u001a\u00020\t*\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0001H\u0096\u0004¢\u0006\u0002\u0010\nR\u0012\u0010\u0003\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Landroidx/compose/animation/core/Transition$Segment;", "S", BuildConfig.FLAVOR, "initialState", "getInitialState", "()Ljava/lang/Object;", "targetState", "getTargetState", "isTransitioningTo", BuildConfig.FLAVOR, "(Ljava/lang/Object;Ljava/lang/Object;)Z", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Segment<S> {
        S getInitialState();

        S getTargetState();

        default boolean isTransitioningTo(S s5, S s6) {
            return Intrinsics.areEqual(s5, getInitialState()) && Intrinsics.areEqual(s6, getTargetState());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0016\u0010\u0003\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/compose/animation/core/Transition$SegmentImpl;", "S", "Landroidx/compose/animation/core/Transition$Segment;", "initialState", "targetState", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getInitialState", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTargetState", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class SegmentImpl<S> implements Segment<S> {
        private final S initialState;
        private final S targetState;

        public SegmentImpl(S s5, S s6) {
            this.initialState = s5;
            this.targetState = s6;
        }

        public boolean equals(Object other) {
            if (other instanceof Segment) {
                Segment segment = (Segment) other;
                if (Intrinsics.areEqual(getInitialState(), segment.getInitialState()) && Intrinsics.areEqual(getTargetState(), segment.getTargetState())) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public S getInitialState() {
            return this.initialState;
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public S getTargetState() {
            return this.targetState;
        }

        public int hashCode() {
            S initialState = getInitialState();
            int hashCode = (initialState != null ? initialState.hashCode() : 0) * 31;
            S targetState = getTargetState();
            return hashCode + (targetState != null ? targetState.hashCode() : 0);
        }
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b+\b\u0087\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\b\b\u0002\u0010\u0003*\u00020\u00022\b\u0012\u0004\u0012\u00028\u00010\u0004B5\b\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\u0006\u0010\u0006\u001a\u00028\u0002\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0005\u001a\u00028\u00012\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001d\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u001e\u0010\u001cJ\u0017\u0010$\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 H\u0000¢\u0006\u0004\b\"\u0010#J\u0017\u0010)\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020%H\u0000¢\u0006\u0004\b'\u0010(J\u000f\u0010+\u001a\u00020\u000fH\u0000¢\u0006\u0004\b*\u0010\u001cJ\u000f\u0010,\u001a\u00020\tH\u0016¢\u0006\u0004\b,\u0010-J%\u00103\u001a\u00020\u000f2\u0006\u0010.\u001a\u00028\u00012\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00010/H\u0000¢\u0006\u0004\b1\u00102J-\u00106\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00028\u00012\u0006\u0010.\u001a\u00028\u00012\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00010/H\u0000¢\u0006\u0004\b4\u00105R#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u00107\u001a\u0004\b8\u00109R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010:\u001a\u0004\b;\u0010-R+\u0010.\u001a\u00028\u00012\u0006\u0010<\u001a\u00028\u00018B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00010C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER7\u00100\u001a\b\u0012\u0004\u0012\u00028\u00010/2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00010/8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bF\u0010>\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JRC\u0010Q\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020K2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020K8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bL\u0010>\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010R\u001a\u0004\u0018\u00010%8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010(R$\u0010W\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR+\u0010^\u001a\u00020\r2\u0006\u0010<\u001a\u00020\r8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bY\u0010>\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R+\u0010d\u001a\u00020 2\u0006\u0010<\u001a\u00020 8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010#R\u0016\u0010e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR+\u0010j\u001a\u00028\u00012\u0006\u0010<\u001a\u00028\u00018V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bg\u0010>\u001a\u0004\bh\u0010@\"\u0004\bi\u0010BR\u0016\u0010k\u001a\u00028\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR+\u0010r\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u00128@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010\u0019R\u0016\u0010s\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010fR\u001a\u0010t\u001a\b\u0012\u0004\u0012\u00028\u00010/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010u¨\u0006v"}, d2 = {"Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "T", "Landroidx/compose/animation/core/AnimationVector;", "V", "Landroidx/compose/runtime/State;", "initialValue", "initialVelocityVector", "Landroidx/compose/animation/core/TwoWayConverter;", "typeConverter", BuildConfig.FLAVOR, "label", "<init>", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", BuildConfig.FLAVOR, "isInterrupted", BuildConfig.FLAVOR, "updateAnimation", "(Ljava/lang/Object;Z)V", BuildConfig.FLAVOR, "playTimeNanos", "scaleToEnd", "onPlayTimeChanged$animation_core_release", "(JZ)V", "onPlayTimeChanged", "seekTo$animation_core_release", "(J)V", "seekTo", "updateInitialValue$animation_core_release", "()V", "updateInitialValue", "resetAnimation$animation_core_release", "resetAnimation", BuildConfig.FLAVOR, "fraction", "resetAnimationValue$animation_core_release", "(F)V", "resetAnimationValue", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "animationState", "setInitialValueAnimation$animation_core_release", "(Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;)V", "setInitialValueAnimation", "clearInitialAnimation$animation_core_release", "clearInitialAnimation", "toString", "()Ljava/lang/String;", "targetValue", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "animationSpec", "updateTargetValue$animation_core_release", "(Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "updateTargetValue", "updateInitialAndTargetValue$animation_core_release", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "updateInitialAndTargetValue", "Landroidx/compose/animation/core/TwoWayConverter;", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "Ljava/lang/String;", "getLabel", "<set-?>", "targetValue$delegate", "Landroidx/compose/runtime/MutableState;", "getTargetValue", "()Ljava/lang/Object;", "setTargetValue", "(Ljava/lang/Object;)V", "Landroidx/compose/animation/core/SpringSpec;", "defaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "animationSpec$delegate", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "Landroidx/compose/animation/core/TargetBasedAnimation;", "animation$delegate", "getAnimation", "()Landroidx/compose/animation/core/TargetBasedAnimation;", "setAnimation", "(Landroidx/compose/animation/core/TargetBasedAnimation;)V", "animation", "initialValueState", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "getInitialValueState$animation_core_release", "()Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "setInitialValueState$animation_core_release", "initialValueAnimation", "Landroidx/compose/animation/core/TargetBasedAnimation;", "isFinished$delegate", "isFinished$animation_core_release", "()Z", "setFinished$animation_core_release", "(Z)V", "isFinished", "resetSnapValue$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getResetSnapValue$animation_core_release", "()F", "setResetSnapValue$animation_core_release", "resetSnapValue", "useOnlyInitialValue", "Z", "value$delegate", "getValue", "setValue$animation_core_release", "value", "velocityVector", "Landroidx/compose/animation/core/AnimationVector;", "durationNanos$delegate", "Landroidx/compose/runtime/MutableLongState;", "getDurationNanos$animation_core_release", "()J", "setDurationNanos$animation_core_release", "durationNanos", "isSeeking", "interruptionSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class TransitionAnimationState<T, V extends AnimationVector> implements State<T> {

        /* renamed from: animation$delegate, reason: from kotlin metadata */
        private final MutableState animation;

        /* renamed from: animationSpec$delegate, reason: from kotlin metadata */
        private final MutableState animationSpec;
        private final SpringSpec<T> defaultSpring;

        /* renamed from: durationNanos$delegate, reason: from kotlin metadata */
        private final MutableLongState durationNanos;
        private TargetBasedAnimation<T, V> initialValueAnimation;
        private SeekableTransitionState.SeekingAnimationState initialValueState;
        private final FiniteAnimationSpec<T> interruptionSpec;

        /* renamed from: isFinished$delegate, reason: from kotlin metadata */
        private final MutableState isFinished;
        private boolean isSeeking;
        private final String label;

        /* renamed from: resetSnapValue$delegate, reason: from kotlin metadata */
        private final MutableFloatState resetSnapValue;

        /* renamed from: targetValue$delegate, reason: from kotlin metadata */
        private final MutableState targetValue;
        private final TwoWayConverter<T, V> typeConverter;
        private boolean useOnlyInitialValue;

        /* renamed from: value$delegate, reason: from kotlin metadata */
        private final MutableState value;
        private V velocityVector;

        public TransitionAnimationState(T t5, V v5, TwoWayConverter<T, V> twoWayConverter, String str) {
            MutableState mutableStateOf$default;
            MutableState mutableStateOf$default2;
            MutableState mutableStateOf$default3;
            MutableState mutableStateOf$default4;
            MutableState mutableStateOf$default5;
            T t6;
            this.typeConverter = twoWayConverter;
            this.label = str;
            mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t5, null, 2, null);
            this.targetValue = mutableStateOf$default;
            SpringSpec<T> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            this.defaultSpring = spring$default;
            mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(spring$default, null, 2, null);
            this.animationSpec = mutableStateOf$default2;
            mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TargetBasedAnimation(getAnimationSpec(), twoWayConverter, t5, getTargetValue(), v5), null, 2, null);
            this.animation = mutableStateOf$default3;
            mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
            this.isFinished = mutableStateOf$default4;
            this.resetSnapValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(-1.0f);
            mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t5, null, 2, null);
            this.value = mutableStateOf$default5;
            this.velocityVector = v5;
            this.durationNanos = SnapshotLongStateKt.mutableLongStateOf(getAnimation().getDurationNanos());
            Float f5 = VisibilityThresholdsKt.getVisibilityThresholdMap().get(twoWayConverter);
            if (f5 != null) {
                float floatValue = f5.floatValue();
                V invoke = twoWayConverter.getConvertToVector().invoke(t5);
                int size = invoke.getSize();
                for (int i5 = 0; i5 < size; i5++) {
                    invoke.set$animation_core_release(i5, floatValue);
                }
                t6 = this.typeConverter.getConvertFromVector().invoke(invoke);
            } else {
                t6 = null;
            }
            this.interruptionSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, t6, 3, null);
        }

        private final T getTargetValue() {
            return this.targetValue.getValue();
        }

        private final void setAnimation(TargetBasedAnimation<T, V> targetBasedAnimation) {
            this.animation.setValue(targetBasedAnimation);
        }

        private final void setAnimationSpec(FiniteAnimationSpec<T> finiteAnimationSpec) {
            this.animationSpec.setValue(finiteAnimationSpec);
        }

        private final void setTargetValue(T t5) {
            this.targetValue.setValue(t5);
        }

        private final void updateAnimation(T initialValue, boolean isInterrupted) {
            TargetBasedAnimation<T, V> targetBasedAnimation = this.initialValueAnimation;
            if (Intrinsics.areEqual(targetBasedAnimation != null ? targetBasedAnimation.getTargetValue() : null, getTargetValue())) {
                setAnimation(new TargetBasedAnimation<>(this.interruptionSpec, this.typeConverter, initialValue, initialValue, AnimationVectorsKt.newInstance(this.velocityVector)));
                this.useOnlyInitialValue = true;
                setDurationNanos$animation_core_release(getAnimation().getDurationNanos());
                return;
            }
            AnimationSpec animationSpec = (!isInterrupted || this.isSeeking) ? getAnimationSpec() : getAnimationSpec() instanceof SpringSpec ? getAnimationSpec() : this.interruptionSpec;
            if (Transition.this.getPlayTimeNanos() > 0) {
                animationSpec = AnimationSpecKt.delayed(animationSpec, Transition.this.getPlayTimeNanos());
            }
            setAnimation(new TargetBasedAnimation<>(animationSpec, this.typeConverter, initialValue, getTargetValue(), this.velocityVector));
            setDurationNanos$animation_core_release(getAnimation().getDurationNanos());
            this.useOnlyInitialValue = false;
            Transition.this.onChildAnimationUpdated();
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ void updateAnimation$default(TransitionAnimationState transitionAnimationState, Object obj, boolean z5, int i5, Object obj2) {
            if ((i5 & 1) != 0) {
                obj = transitionAnimationState.getValue();
            }
            if ((i5 & 2) != 0) {
                z5 = false;
            }
            transitionAnimationState.updateAnimation(obj, z5);
        }

        public final void clearInitialAnimation$animation_core_release() {
            this.initialValueAnimation = null;
            this.initialValueState = null;
            this.useOnlyInitialValue = false;
        }

        public final TargetBasedAnimation<T, V> getAnimation() {
            return (TargetBasedAnimation) this.animation.getValue();
        }

        public final FiniteAnimationSpec<T> getAnimationSpec() {
            return (FiniteAnimationSpec) this.animationSpec.getValue();
        }

        public final long getDurationNanos$animation_core_release() {
            return this.durationNanos.getLongValue();
        }

        /* renamed from: getInitialValueState$animation_core_release, reason: from getter */
        public final SeekableTransitionState.SeekingAnimationState getInitialValueState() {
            return this.initialValueState;
        }

        public final float getResetSnapValue$animation_core_release() {
            return this.resetSnapValue.getFloatValue();
        }

        @Override // androidx.compose.runtime.State
        public T getValue() {
            return this.value.getValue();
        }

        public final boolean isFinished$animation_core_release() {
            return ((Boolean) this.isFinished.getValue()).booleanValue();
        }

        public final void onPlayTimeChanged$animation_core_release(long playTimeNanos, boolean scaleToEnd) {
            if (scaleToEnd) {
                playTimeNanos = getAnimation().getDurationNanos();
            }
            setValue$animation_core_release(getAnimation().getValueFromNanos(playTimeNanos));
            this.velocityVector = getAnimation().getVelocityVectorFromNanos(playTimeNanos);
            if (getAnimation().isFinishedFromNanos(playTimeNanos)) {
                setFinished$animation_core_release(true);
            }
        }

        public final void resetAnimation$animation_core_release() {
            setResetSnapValue$animation_core_release(-2.0f);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void resetAnimationValue$animation_core_release(float fraction) {
            if (fraction != -4.0f && fraction != -5.0f) {
                setResetSnapValue$animation_core_release(fraction);
                return;
            }
            TargetBasedAnimation<T, V> targetBasedAnimation = this.initialValueAnimation;
            if (targetBasedAnimation != null) {
                getAnimation().setMutableInitialValue$animation_core_release(targetBasedAnimation.getTargetValue());
                this.initialValueState = null;
                this.initialValueAnimation = null;
            }
            Object initialValue = fraction == -4.0f ? getAnimation().getInitialValue() : getAnimation().getTargetValue();
            getAnimation().setMutableInitialValue$animation_core_release(initialValue);
            getAnimation().setMutableTargetValue$animation_core_release(initialValue);
            setValue$animation_core_release(initialValue);
            setDurationNanos$animation_core_release(getAnimation().getDurationNanos());
        }

        public final void seekTo$animation_core_release(long playTimeNanos) {
            if (getResetSnapValue$animation_core_release() == -1.0f) {
                this.isSeeking = true;
                if (Intrinsics.areEqual(getAnimation().getTargetValue(), getAnimation().getInitialValue())) {
                    setValue$animation_core_release(getAnimation().getTargetValue());
                } else {
                    setValue$animation_core_release(getAnimation().getValueFromNanos(playTimeNanos));
                    this.velocityVector = getAnimation().getVelocityVectorFromNanos(playTimeNanos);
                }
            }
        }

        public final void setDurationNanos$animation_core_release(long j5) {
            this.durationNanos.setLongValue(j5);
        }

        public final void setFinished$animation_core_release(boolean z5) {
            this.isFinished.setValue(Boolean.valueOf(z5));
        }

        public final void setInitialValueAnimation$animation_core_release(SeekableTransitionState.SeekingAnimationState animationState) {
            if (!Intrinsics.areEqual(getAnimation().getTargetValue(), getAnimation().getInitialValue())) {
                this.initialValueAnimation = getAnimation();
                this.initialValueState = animationState;
            }
            setAnimation(new TargetBasedAnimation<>(this.interruptionSpec, this.typeConverter, getValue(), getValue(), AnimationVectorsKt.newInstance(this.velocityVector)));
            setDurationNanos$animation_core_release(getAnimation().getDurationNanos());
            this.useOnlyInitialValue = true;
        }

        public final void setResetSnapValue$animation_core_release(float f5) {
            this.resetSnapValue.setFloatValue(f5);
        }

        public void setValue$animation_core_release(T t5) {
            this.value.setValue(t5);
        }

        public String toString() {
            return "current value: " + getValue() + ", target: " + getTargetValue() + ", spec: " + getAnimationSpec();
        }

        public final void updateInitialAndTargetValue$animation_core_release(T initialValue, T targetValue, FiniteAnimationSpec<T> animationSpec) {
            setTargetValue(targetValue);
            setAnimationSpec(animationSpec);
            if (Intrinsics.areEqual(getAnimation().getInitialValue(), initialValue) && Intrinsics.areEqual(getAnimation().getTargetValue(), targetValue)) {
                return;
            }
            updateAnimation$default(this, initialValue, false, 2, null);
        }

        public final void updateInitialValue$animation_core_release() {
            TargetBasedAnimation<T, V> targetBasedAnimation;
            SeekableTransitionState.SeekingAnimationState seekingAnimationState = this.initialValueState;
            if (seekingAnimationState == null || (targetBasedAnimation = this.initialValueAnimation) == null) {
                return;
            }
            long roundToLong = MathKt.roundToLong(seekingAnimationState.getDurationNanos() * seekingAnimationState.getValue());
            T valueFromNanos = targetBasedAnimation.getValueFromNanos(roundToLong);
            if (this.useOnlyInitialValue) {
                getAnimation().setMutableTargetValue$animation_core_release(valueFromNanos);
            }
            getAnimation().setMutableInitialValue$animation_core_release(valueFromNanos);
            setDurationNanos$animation_core_release(getAnimation().getDurationNanos());
            if (getResetSnapValue$animation_core_release() == -2.0f || this.useOnlyInitialValue) {
                setValue$animation_core_release(valueFromNanos);
            } else {
                seekTo$animation_core_release(Transition.this.getPlayTimeNanos());
            }
            if (roundToLong < seekingAnimationState.getDurationNanos()) {
                seekingAnimationState.setComplete(false);
            } else {
                this.initialValueState = null;
                this.initialValueAnimation = null;
            }
        }

        public final void updateTargetValue$animation_core_release(T targetValue, FiniteAnimationSpec<T> animationSpec) {
            if (this.useOnlyInitialValue) {
                TargetBasedAnimation<T, V> targetBasedAnimation = this.initialValueAnimation;
                if (Intrinsics.areEqual(targetValue, targetBasedAnimation != null ? targetBasedAnimation.getTargetValue() : null)) {
                    return;
                }
            }
            if (Intrinsics.areEqual(getTargetValue(), targetValue) && getResetSnapValue$animation_core_release() == -1.0f) {
                return;
            }
            setTargetValue(targetValue);
            setAnimationSpec(animationSpec);
            updateAnimation(getResetSnapValue$animation_core_release() == -3.0f ? targetValue : getValue(), !isFinished$animation_core_release());
            setFinished$animation_core_release(getResetSnapValue$animation_core_release() == -3.0f);
            if (getResetSnapValue$animation_core_release() >= 0.0f) {
                setValue$animation_core_release(getAnimation().getValueFromNanos(((float) getAnimation().getDurationNanos()) * getResetSnapValue$animation_core_release()));
            } else if (getResetSnapValue$animation_core_release() == -3.0f) {
                setValue$animation_core_release(targetValue);
            }
            this.useOnlyInitialValue = false;
            setResetSnapValue$animation_core_release(-1.0f);
        }
    }

    public Transition(TransitionState<S> transitionState, Transition<?> transition, String str) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        this.transitionState = transitionState;
        this.parentTransition = transition;
        this.label = str;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getCurrentState(), null, 2, null);
        this.targetState = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new SegmentImpl(getCurrentState(), getCurrentState()), null, 2, null);
        this.segment = mutableStateOf$default2;
        this._playTimeNanos = SnapshotLongStateKt.mutableLongStateOf(0L);
        this.startTimeNanos = SnapshotLongStateKt.mutableLongStateOf(Long.MIN_VALUE);
        Boolean bool = Boolean.FALSE;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.updateChildrenNeeded = mutableStateOf$default3;
        this._animations = SnapshotStateKt.mutableStateListOf();
        this._transitions = SnapshotStateKt.mutableStateListOf();
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isSeeking = mutableStateOf$default4;
        this.totalDurationNanos = SnapshotStateKt.derivedStateOf(new Function0<Long>(this) { // from class: androidx.compose.animation.core.Transition$totalDurationNanos$2
            final /* synthetic */ Transition<S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                long calculateTotalDurationNanos;
                calculateTotalDurationNanos = this.this$0.calculateTotalDurationNanos();
                return Long.valueOf(calculateTotalDurationNanos);
            }
        });
        transitionState.transitionConfigured$animation_core_release(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long calculateTotalDurationNanos() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        long j5 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            j5 = Math.max(j5, snapshotStateList.get(i5).getDurationNanos$animation_core_release());
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            j5 = Math.max(j5, snapshotStateList2.get(i6).calculateTotalDurationNanos());
        }
        return j5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getUpdateChildrenNeeded() {
        return ((Boolean) this.updateChildrenNeeded.getValue()).booleanValue();
    }

    private final long get_playTimeNanos() {
        return this._playTimeNanos.getLongValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onChildAnimationUpdated() {
        setUpdateChildrenNeeded(true);
        if (isSeeking()) {
            SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
            int size = snapshotStateList.size();
            long j5 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                Transition<S>.TransitionAnimationState<?, ?> transitionAnimationState = snapshotStateList.get(i5);
                j5 = Math.max(j5, transitionAnimationState.getDurationNanos$animation_core_release());
                transitionAnimationState.seekTo$animation_core_release(this.lastSeekedTimeNanos);
            }
            setUpdateChildrenNeeded(false);
        }
    }

    private final void resetAnimations() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i5 = 0; i5 < size; i5++) {
            snapshotStateList.get(i5).resetAnimation$animation_core_release();
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            snapshotStateList2.get(i6).resetAnimations();
        }
    }

    private final void setSegment(Segment<S> segment) {
        this.segment.setValue(segment);
    }

    private final void setUpdateChildrenNeeded(boolean z5) {
        this.updateChildrenNeeded.setValue(Boolean.valueOf(z5));
    }

    private final void set_playTimeNanos(long j5) {
        this._playTimeNanos.setLongValue(j5);
    }

    public final boolean addAnimation$animation_core_release(Transition<S>.TransitionAnimationState<?, ?> animation) {
        return this._animations.add(animation);
    }

    public final boolean addTransition$animation_core_release(Transition<?> transition) {
        return this._transitions.add(transition);
    }

    public final void animateTo$animation_core_release(final S s5, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1493585151);
        if ((i5 & 6) == 0) {
            i6 = ((i5 & 8) == 0 ? startRestartGroup.changed(s5) : startRestartGroup.changedInstance(s5) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(this) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1493585151, i6, -1, "androidx.compose.animation.core.Transition.animateTo (Transition.kt:1211)");
            }
            if (isSeeking()) {
                startRestartGroup.startReplaceGroup(1823992347);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1822507602);
                updateTarget$animation_core_release(s5);
                if (!Intrinsics.areEqual(s5, getCurrentState()) || isRunning() || getUpdateChildrenNeeded()) {
                    startRestartGroup.startReplaceGroup(1822738893);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    Composer.Companion companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                        startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                        rememberedValue = compositionScopedCoroutineScopeCanceller;
                    }
                    final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                    int i7 = i6 & 112;
                    boolean changedInstance = (i7 == 32) | startRestartGroup.changedInstance(coroutineScope);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.Transition$animateTo$1$1

                            /* JADX INFO: Access modifiers changed from: package-private */
                            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "S", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.animation.core.Transition$animateTo$1$1$1", f = "Transition.kt", l = {1227}, m = "invokeSuspend")
                            /* renamed from: androidx.compose.animation.core.Transition$animateTo$1$1$1, reason: invalid class name */
                            /* loaded from: classes.dex */
                            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                float F$0;
                                private /* synthetic */ Object L$0;
                                int label;
                                final /* synthetic */ Transition<S> this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(Transition<S> transition, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.this$0 = transition;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                                    anonymousClass1.L$0 = obj;
                                    return anonymousClass1;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    final float durationScale;
                                    CoroutineScope coroutineScope;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i5 = this.label;
                                    if (i5 == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                                        durationScale = SuspendAnimationKt.getDurationScale(coroutineScope2.getCoroutineContext());
                                        coroutineScope = coroutineScope2;
                                    } else {
                                        if (i5 != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        durationScale = this.F$0;
                                        coroutineScope = (CoroutineScope) this.L$0;
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    while (CoroutineScopeKt.isActive(coroutineScope)) {
                                        final Transition<S> transition = this.this$0;
                                        Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: androidx.compose.animation.core.Transition.animateTo.1.1.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Long l5) {
                                                invoke(l5.longValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(long j5) {
                                                if (transition.isSeeking()) {
                                                    return;
                                                }
                                                transition.onFrame$animation_core_release(j5, durationScale);
                                            }
                                        };
                                        this.L$0 = coroutineScope;
                                        this.F$0 = durationScale;
                                        this.label = 1;
                                        if (MonotonicFrameClockKt.withFrameNanos(function1, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
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
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(this, null), 1, null);
                                return new DisposableEffectResult() { // from class: androidx.compose.animation.core.Transition$animateTo$1$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                    }
                                };
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    EffectsKt.DisposableEffect(coroutineScope, this, (Function1) rememberedValue2, startRestartGroup, i7);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(1823982427);
                    startRestartGroup.endReplaceGroup();
                }
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>(this) { // from class: androidx.compose.animation.core.Transition$animateTo$2
                final /* synthetic */ Transition<S> $tmp1_rcvr;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.$tmp1_rcvr = this;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i8) {
                    this.$tmp1_rcvr.animateTo$animation_core_release(s5, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    public final void clearInitialAnimations$animation_core_release() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i5 = 0; i5 < size; i5++) {
            snapshotStateList.get(i5).clearInitialAnimation$animation_core_release();
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            snapshotStateList2.get(i6).clearInitialAnimations$animation_core_release();
        }
    }

    public final List<Transition<S>.TransitionAnimationState<?, ?>> getAnimations() {
        return this._animations;
    }

    public final S getCurrentState() {
        return this.transitionState.getCurrentState();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002f, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean getHasInitialValueAnimations() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
                int size2 = snapshotStateList2.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    if (!snapshotStateList2.get(i6).getHasInitialValueAnimations()) {
                    }
                }
                return false;
            }
            if (snapshotStateList.get(i5).getInitialValueState() != null) {
                break;
            }
            i5++;
        }
    }

    public final String getLabel() {
        return this.label;
    }

    /* renamed from: getLastSeekedTimeNanos$animation_core_release, reason: from getter */
    public final long getLastSeekedTimeNanos() {
        return this.lastSeekedTimeNanos;
    }

    public final long getPlayTimeNanos() {
        Transition<?> transition = this.parentTransition;
        return transition != null ? transition.getPlayTimeNanos() : get_playTimeNanos();
    }

    public final Segment<S> getSegment() {
        return (Segment) this.segment.getValue();
    }

    public final long getStartTimeNanos$animation_core_release() {
        return this.startTimeNanos.getLongValue();
    }

    public final S getTargetState() {
        return (S) this.targetState.getValue();
    }

    public final long getTotalDurationNanos() {
        return ((Number) this.totalDurationNanos.getValue()).longValue();
    }

    public final boolean isRunning() {
        return getStartTimeNanos$animation_core_release() != Long.MIN_VALUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isSeeking() {
        return ((Boolean) this.isSeeking.getValue()).booleanValue();
    }

    public final void onDisposed$animation_core_release() {
        onTransitionEnd$animation_core_release();
        this.transitionState.transitionRemoved$animation_core_release();
    }

    public final void onFrame$animation_core_release(long frameTimeNanos, float durationScale) {
        if (getStartTimeNanos$animation_core_release() == Long.MIN_VALUE) {
            onTransitionStart$animation_core_release(frameTimeNanos);
        }
        long startTimeNanos$animation_core_release = frameTimeNanos - getStartTimeNanos$animation_core_release();
        if (durationScale != 0.0f) {
            startTimeNanos$animation_core_release = MathKt.roundToLong(startTimeNanos$animation_core_release / durationScale);
        }
        setPlayTimeNanos(startTimeNanos$animation_core_release);
        onFrame$animation_core_release(startTimeNanos$animation_core_release, durationScale == 0.0f);
    }

    public final void onTransitionEnd$animation_core_release() {
        setStartTimeNanos$animation_core_release(Long.MIN_VALUE);
        TransitionState<S> transitionState = this.transitionState;
        if (transitionState instanceof MutableTransitionState) {
            transitionState.setCurrentState$animation_core_release(getTargetState());
        }
        setPlayTimeNanos(0L);
        this.transitionState.setRunning$animation_core_release(false);
        SnapshotStateList<Transition<?>> snapshotStateList = this._transitions;
        int size = snapshotStateList.size();
        for (int i5 = 0; i5 < size; i5++) {
            snapshotStateList.get(i5).onTransitionEnd$animation_core_release();
        }
    }

    public final void onTransitionStart$animation_core_release(long frameTimeNanos) {
        setStartTimeNanos$animation_core_release(frameTimeNanos);
        this.transitionState.setRunning$animation_core_release(true);
    }

    public final void removeAnimation$animation_core_release(Transition<S>.TransitionAnimationState<?, ?> animation) {
        this._animations.remove(animation);
    }

    public final boolean removeTransition$animation_core_release(Transition<?> transition) {
        return this._transitions.remove(transition);
    }

    public final void resetAnimationFraction$animation_core_release(float fraction) {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i5 = 0; i5 < size; i5++) {
            snapshotStateList.get(i5).resetAnimationValue$animation_core_release(fraction);
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            snapshotStateList2.get(i6).resetAnimationFraction$animation_core_release(fraction);
        }
    }

    public final void seek(S initialState, S targetState, long playTimeNanos) {
        setStartTimeNanos$animation_core_release(Long.MIN_VALUE);
        this.transitionState.setRunning$animation_core_release(false);
        if (!isSeeking() || !Intrinsics.areEqual(getCurrentState(), initialState) || !Intrinsics.areEqual(getTargetState(), targetState)) {
            if (!Intrinsics.areEqual(getCurrentState(), initialState)) {
                TransitionState<S> transitionState = this.transitionState;
                if (transitionState instanceof MutableTransitionState) {
                    transitionState.setCurrentState$animation_core_release(initialState);
                }
            }
            setTargetState$animation_core_release(targetState);
            setSeeking$animation_core_release(true);
            setSegment(new SegmentImpl(initialState, targetState));
        }
        SnapshotStateList<Transition<?>> snapshotStateList = this._transitions;
        int size = snapshotStateList.size();
        for (int i5 = 0; i5 < size; i5++) {
            Transition<?> transition = snapshotStateList.get(i5);
            Intrinsics.checkNotNull(transition, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Any>");
            if (transition.isSeeking()) {
                transition.seek(transition.getCurrentState(), transition.getTargetState(), playTimeNanos);
            }
        }
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList2 = this._animations;
        int size2 = snapshotStateList2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            snapshotStateList2.get(i6).seekTo$animation_core_release(playTimeNanos);
        }
        this.lastSeekedTimeNanos = playTimeNanos;
    }

    public final void seekAnimations$animation_core_release(long playTimeNanos) {
        if (getStartTimeNanos$animation_core_release() == Long.MIN_VALUE) {
            setStartTimeNanos$animation_core_release(playTimeNanos);
        }
        setPlayTimeNanos(playTimeNanos);
        setUpdateChildrenNeeded(false);
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i5 = 0; i5 < size; i5++) {
            snapshotStateList.get(i5).seekTo$animation_core_release(playTimeNanos);
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            Transition<?> transition = snapshotStateList2.get(i6);
            if (!Intrinsics.areEqual(transition.getTargetState(), transition.getCurrentState())) {
                transition.seekAnimations$animation_core_release(playTimeNanos);
            }
        }
    }

    public final void setInitialAnimations$animation_core_release(SeekableTransitionState.SeekingAnimationState animationState) {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i5 = 0; i5 < size; i5++) {
            snapshotStateList.get(i5).setInitialValueAnimation$animation_core_release(animationState);
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            snapshotStateList2.get(i6).setInitialAnimations$animation_core_release(animationState);
        }
    }

    public final void setPlayTimeNanos(long j5) {
        if (this.parentTransition == null) {
            set_playTimeNanos(j5);
        }
    }

    public final void setSeeking$animation_core_release(boolean z5) {
        this.isSeeking.setValue(Boolean.valueOf(z5));
    }

    public final void setStartTimeNanos$animation_core_release(long j5) {
        this.startTimeNanos.setLongValue(j5);
    }

    public final void setTargetState$animation_core_release(S s5) {
        this.targetState.setValue(s5);
    }

    public String toString() {
        List<Transition<S>.TransitionAnimationState<?, ?>> animations = getAnimations();
        int size = animations.size();
        String str = "Transition animation values: ";
        for (int i5 = 0; i5 < size; i5++) {
            str = str + animations.get(i5) + ", ";
        }
        return str;
    }

    public final void updateInitialValues$animation_core_release() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i5 = 0; i5 < size; i5++) {
            snapshotStateList.get(i5).updateInitialValue$animation_core_release();
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            snapshotStateList2.get(i6).updateInitialValues$animation_core_release();
        }
    }

    public final void updateTarget$animation_core_release(S targetState) {
        if (Intrinsics.areEqual(getTargetState(), targetState)) {
            return;
        }
        setSegment(new SegmentImpl(getTargetState(), targetState));
        if (!Intrinsics.areEqual(getCurrentState(), getTargetState())) {
            this.transitionState.setCurrentState$animation_core_release(getTargetState());
        }
        setTargetState$animation_core_release(targetState);
        if (!isRunning()) {
            setUpdateChildrenNeeded(true);
        }
        resetAnimations();
    }

    public final void removeAnimation$animation_core_release(Transition<S>.DeferredAnimation<?, ?> deferredAnimation) {
        Transition<S>.TransitionAnimationState<?, ?> animation;
        Transition<S>.DeferredAnimationData<?, V>.DeferredAnimationData<?, ?> data$animation_core_release = deferredAnimation.getData$animation_core_release();
        if (data$animation_core_release == null || (animation = data$animation_core_release.getAnimation()) == null) {
            return;
        }
        removeAnimation$animation_core_release(animation);
    }

    public final void onFrame$animation_core_release(long scaledPlayTimeNanos, boolean scaleToEnd) {
        boolean z5 = true;
        if (getStartTimeNanos$animation_core_release() == Long.MIN_VALUE) {
            onTransitionStart$animation_core_release(scaledPlayTimeNanos);
        } else if (!this.transitionState.isRunning$animation_core_release()) {
            this.transitionState.setRunning$animation_core_release(true);
        }
        setUpdateChildrenNeeded(false);
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> snapshotStateList = this._animations;
        int size = snapshotStateList.size();
        for (int i5 = 0; i5 < size; i5++) {
            Transition<S>.TransitionAnimationState<?, ?> transitionAnimationState = snapshotStateList.get(i5);
            if (!transitionAnimationState.isFinished$animation_core_release()) {
                transitionAnimationState.onPlayTimeChanged$animation_core_release(scaledPlayTimeNanos, scaleToEnd);
            }
            if (!transitionAnimationState.isFinished$animation_core_release()) {
                z5 = false;
            }
        }
        SnapshotStateList<Transition<?>> snapshotStateList2 = this._transitions;
        int size2 = snapshotStateList2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            Transition<?> transition = snapshotStateList2.get(i6);
            if (!Intrinsics.areEqual(transition.getTargetState(), transition.getCurrentState())) {
                transition.onFrame$animation_core_release(scaledPlayTimeNanos, scaleToEnd);
            }
            if (!Intrinsics.areEqual(transition.getTargetState(), transition.getCurrentState())) {
                z5 = false;
            }
        }
        if (z5) {
            onTransitionEnd$animation_core_release();
        }
    }

    public Transition(TransitionState<S> transitionState, String str) {
        this(transitionState, null, str);
    }

    public Transition(S s5, String str) {
        this(new MutableTransitionState(s5), null, str);
    }
}
