package androidx.compose.animation.core;

import androidx.collection.MutableObjectList;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0007\u0018\u0000 X*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002XYB\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u000e\u0010<\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010=J*\u0010>\u001a\u00020\b2\b\b\u0002\u00101\u001a\u00028\u00002\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010@H\u0086@¢\u0006\u0002\u0010AJ\u000e\u0010B\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010=J\b\u0010C\u001a\u00020\bH\u0002J\b\u0010D\u001a\u00020\bH\u0002J\r\u0010E\u001a\u00020\bH\u0000¢\u0006\u0002\bFJ\r\u0010G\u001a\u00020\bH\u0000¢\u0006\u0002\bHJ\u0018\u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020\u00192\u0006\u0010K\u001a\u00020\u0007H\u0002J\u000e\u0010L\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010=J\"\u0010M\u001a\u00020\b2\b\b\u0001\u0010#\u001a\u00020!2\b\b\u0002\u00101\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020\bH\u0002J\u0016\u0010P\u001a\u00020\b2\u0006\u00101\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010QJ\u001b\u0010R\u001a\u00020\b2\f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;H\u0010¢\u0006\u0002\bSJ\r\u0010T\u001a\u00020\bH\u0010¢\u0006\u0002\bUJ\u000e\u0010V\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010=J\u000e\u0010W\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010=R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00028\u0000X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0004R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\u0004R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010#\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020!8G@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00190+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\b00X\u0082\u0004¢\u0006\u0002\n\u0000R+\u00101\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u001f\u001a\u0004\b2\u0010\u000b\"\u0004\b3\u0010\u0004R\u001a\u00105\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010:\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Landroidx/compose/animation/core/SeekableTransitionState;", "S", "Landroidx/compose/animation/core/TransitionState;", "initialState", "(Ljava/lang/Object;)V", "animateOneFrameLambda", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "composedTargetState", "getComposedTargetState$animation_core_release", "()Ljava/lang/Object;", "setComposedTargetState$animation_core_release", "Ljava/lang/Object;", "compositionContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "getCompositionContinuation$animation_core_release", "()Lkotlinx/coroutines/CancellableContinuation;", "setCompositionContinuation$animation_core_release", "(Lkotlinx/coroutines/CancellableContinuation;)V", "compositionContinuationMutex", "Lkotlinx/coroutines/sync/Mutex;", "getCompositionContinuationMutex$animation_core_release", "()Lkotlinx/coroutines/sync/Mutex;", "currentAnimation", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "<set-?>", "currentState", "getCurrentState", "setCurrentState$animation_core_release", "currentState$delegate", "Landroidx/compose/runtime/MutableState;", "durationScale", BuildConfig.FLAVOR, "firstFrameLambda", "fraction", "getFraction", "()F", "setFraction", "(F)V", "fraction$delegate", "Landroidx/compose/runtime/MutableFloatState;", "initialValueAnimations", "Landroidx/collection/MutableObjectList;", "lastFrameTimeNanos", "mutatorMutex", "Landroidx/compose/animation/core/MutatorMutex;", "recalculateTotalDurationNanos", "Lkotlin/Function0;", "targetState", "getTargetState", "setTargetState$animation_core_release", "targetState$delegate", "totalDurationNanos", "getTotalDurationNanos$animation_core_release", "()J", "setTotalDurationNanos$animation_core_release", "(J)V", "transition", "Landroidx/compose/animation/core/Transition;", "animateOneFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "(Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doOneFrame", "endAllAnimations", "moveAnimationToInitialState", "observeTotalDuration", "observeTotalDuration$animation_core_release", "onTotalDurationChanged", "onTotalDurationChanged$animation_core_release", "recalculateAnimationValue", "animation", "deltaPlayTimeNanos", "runAnimations", "seekTo", "(FLjava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "seekToFraction", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transitionConfigured", "transitionConfigured$animation_core_release", "transitionRemoved", "transitionRemoved$animation_core_release", "waitForComposition", "waitForCompositionAfterTargetStateChange", "Companion", "SeekingAnimationState", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SeekableTransitionState<S> extends TransitionState<S> {
    private final Function1<Long, Unit> animateOneFrameLambda;
    private S composedTargetState;
    private CancellableContinuation<? super S> compositionContinuation;
    private final Mutex compositionContinuationMutex;
    private SeekingAnimationState currentAnimation;

    /* renamed from: currentState$delegate, reason: from kotlin metadata */
    private final MutableState currentState;
    private float durationScale;
    private final Function1<Long, Unit> firstFrameLambda;

    /* renamed from: fraction$delegate, reason: from kotlin metadata */
    private final MutableFloatState fraction;
    private final MutableObjectList<SeekingAnimationState> initialValueAnimations;
    private long lastFrameTimeNanos;
    private final MutatorMutex mutatorMutex;
    private final Function0<Unit> recalculateTotalDurationNanos;

    /* renamed from: targetState$delegate, reason: from kotlin metadata */
    private final MutableState targetState;
    private long totalDurationNanos;
    private Transition<S> transition;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final AnimationVector1D ZeroVelocity = new AnimationVector1D(0.0f);
    private static final AnimationVector1D Target1 = new AnimationVector1D(1.0f);

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/compose/animation/core/SeekableTransitionState$Companion;", BuildConfig.FLAVOR, "()V", "Target1", "Landroidx/compose/animation/core/AnimationVector1D;", "getTarget1", "()Landroidx/compose/animation/core/AnimationVector1D;", "ZeroVelocity", "getZeroVelocity", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AnimationVector1D getTarget1() {
            return SeekableTransitionState.Target1;
        }

        public final AnimationVector1D getZeroVelocity() {
            return SeekableTransitionState.ZeroVelocity;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0016\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\"\u0010,\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\t\u001a\u0004\b-\u0010\u000b\"\u0004\b.\u0010\rR\"\u0010/\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\t\u001a\u0004\b0\u0010\u000b\"\u0004\b1\u0010\r¨\u00062"}, d2 = {"Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "progressNanos", "J", "getProgressNanos", "()J", "setProgressNanos", "(J)V", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "Landroidx/compose/animation/core/AnimationVector1D;", "animationSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "getAnimationSpec", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;)V", BuildConfig.FLAVOR, "isComplete", "Z", "()Z", "setComplete", "(Z)V", BuildConfig.FLAVOR, "value", "F", "getValue", "()F", "setValue", "(F)V", "start", "Landroidx/compose/animation/core/AnimationVector1D;", "getStart", "()Landroidx/compose/animation/core/AnimationVector1D;", "setStart", "(Landroidx/compose/animation/core/AnimationVector1D;)V", "initialVelocity", "getInitialVelocity", "setInitialVelocity", "durationNanos", "getDurationNanos", "setDurationNanos", "animationSpecDuration", "getAnimationSpecDuration", "setAnimationSpecDuration", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class SeekingAnimationState {
        private VectorizedAnimationSpec<AnimationVector1D> animationSpec;
        private long animationSpecDuration;
        private long durationNanos;
        private AnimationVector1D initialVelocity;
        private boolean isComplete;
        private long progressNanos;
        private AnimationVector1D start = new AnimationVector1D(0.0f);
        private float value;

        public final VectorizedAnimationSpec<AnimationVector1D> getAnimationSpec() {
            return this.animationSpec;
        }

        public final long getAnimationSpecDuration() {
            return this.animationSpecDuration;
        }

        public final long getDurationNanos() {
            return this.durationNanos;
        }

        public final AnimationVector1D getInitialVelocity() {
            return this.initialVelocity;
        }

        public final long getProgressNanos() {
            return this.progressNanos;
        }

        public final AnimationVector1D getStart() {
            return this.start;
        }

        public final float getValue() {
            return this.value;
        }

        /* renamed from: isComplete, reason: from getter */
        public final boolean getIsComplete() {
            return this.isComplete;
        }

        public final void setAnimationSpec(VectorizedAnimationSpec<AnimationVector1D> vectorizedAnimationSpec) {
            this.animationSpec = vectorizedAnimationSpec;
        }

        public final void setAnimationSpecDuration(long j5) {
            this.animationSpecDuration = j5;
        }

        public final void setComplete(boolean z5) {
            this.isComplete = z5;
        }

        public final void setDurationNanos(long j5) {
            this.durationNanos = j5;
        }

        public final void setInitialVelocity(AnimationVector1D animationVector1D) {
            this.initialVelocity = animationVector1D;
        }

        public final void setProgressNanos(long j5) {
            this.progressNanos = j5;
        }

        public final void setValue(float f5) {
            this.value = f5;
        }

        public String toString() {
            return "progress nanos: " + this.progressNanos + ", animationSpec: " + this.animationSpec + ", isComplete: " + this.isComplete + ", value: " + this.value + ", start: " + this.start + ", initialVelocity: " + this.initialVelocity + ", durationNanos: " + this.durationNanos + ", animationSpecDuration: " + this.animationSpecDuration;
        }
    }

    public SeekableTransitionState(S s5) {
        super(null);
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(s5, null, 2, null);
        this.targetState = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(s5, null, 2, null);
        this.currentState = mutableStateOf$default2;
        this.composedTargetState = s5;
        this.recalculateTotalDurationNanos = new Function0<Unit>(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$recalculateTotalDurationNanos$1
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Transition transition;
                SeekableTransitionState<S> seekableTransitionState = this.this$0;
                transition = ((SeekableTransitionState) seekableTransitionState).transition;
                seekableTransitionState.setTotalDurationNanos$animation_core_release(transition != null ? transition.getTotalDurationNanos() : 0L);
            }
        };
        this.fraction = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.compositionContinuationMutex = MutexKt.Mutex$default(false, 1, null);
        this.mutatorMutex = new MutatorMutex();
        this.lastFrameTimeNanos = Long.MIN_VALUE;
        this.initialValueAnimations = new MutableObjectList<>(0, 1, null);
        this.firstFrameLambda = new Function1<Long, Unit>(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$firstFrameLambda$1
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l5) {
                invoke(l5.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j5) {
                ((SeekableTransitionState) this.this$0).lastFrameTimeNanos = j5;
            }
        };
        this.animateOneFrameLambda = new Function1<Long, Unit>(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$animateOneFrameLambda$1
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l5) {
                invoke(l5.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j5) {
                long j6;
                float f5;
                MutableObjectList mutableObjectList;
                SeekableTransitionState.SeekingAnimationState seekingAnimationState;
                MutableObjectList mutableObjectList2;
                Transition transition;
                MutableObjectList mutableObjectList3;
                j6 = ((SeekableTransitionState) this.this$0).lastFrameTimeNanos;
                ((SeekableTransitionState) this.this$0).lastFrameTimeNanos = j5;
                double d5 = j5 - j6;
                f5 = ((SeekableTransitionState) this.this$0).durationScale;
                long roundToLong = MathKt.roundToLong(d5 / f5);
                mutableObjectList = ((SeekableTransitionState) this.this$0).initialValueAnimations;
                if (mutableObjectList.isNotEmpty()) {
                    mutableObjectList2 = ((SeekableTransitionState) this.this$0).initialValueAnimations;
                    SeekableTransitionState<S> seekableTransitionState = this.this$0;
                    Object[] objArr = mutableObjectList2.content;
                    int i5 = mutableObjectList2._size;
                    int i6 = 0;
                    for (int i7 = 0; i7 < i5; i7++) {
                        SeekableTransitionState.SeekingAnimationState seekingAnimationState2 = (SeekableTransitionState.SeekingAnimationState) objArr[i7];
                        seekableTransitionState.recalculateAnimationValue(seekingAnimationState2, roundToLong);
                        seekingAnimationState2.setComplete(true);
                    }
                    transition = ((SeekableTransitionState) this.this$0).transition;
                    if (transition != null) {
                        transition.updateInitialValues$animation_core_release();
                    }
                    mutableObjectList3 = ((SeekableTransitionState) this.this$0).initialValueAnimations;
                    int i8 = mutableObjectList3._size;
                    Object[] objArr2 = mutableObjectList3.content;
                    IntRange until = RangesKt.until(0, i8);
                    int first = until.getFirst();
                    int last = until.getLast();
                    if (first <= last) {
                        while (true) {
                            objArr2[first - i6] = objArr2[first];
                            if (((SeekableTransitionState.SeekingAnimationState) objArr2[first]).getIsComplete()) {
                                i6++;
                            }
                            if (first == last) {
                                break;
                            } else {
                                first++;
                            }
                        }
                    }
                    ArraysKt.fill(objArr2, (Object) null, i8 - i6, i8);
                    mutableObjectList3._size -= i6;
                }
                seekingAnimationState = ((SeekableTransitionState) this.this$0).currentAnimation;
                if (seekingAnimationState != null) {
                    seekingAnimationState.setDurationNanos(this.this$0.getTotalDurationNanos());
                    this.this$0.recalculateAnimationValue(seekingAnimationState, roundToLong);
                    this.this$0.setFraction(seekingAnimationState.getValue());
                    if (seekingAnimationState.getValue() == 1.0f) {
                        ((SeekableTransitionState) this.this$0).currentAnimation = null;
                    }
                    this.this$0.seekToFraction();
                }
            }
        };
    }

    private final Object animateOneFrame(Continuation<? super Unit> continuation) {
        float durationScale = SuspendAnimationKt.getDurationScale(continuation.getContext());
        if (durationScale <= 0.0f) {
            endAllAnimations();
            return Unit.INSTANCE;
        }
        this.durationScale = durationScale;
        Object withFrameNanos = MonotonicFrameClockKt.withFrameNanos(this.animateOneFrameLambda, continuation);
        return withFrameNanos == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withFrameNanos : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(SeekableTransitionState seekableTransitionState, Object obj, FiniteAnimationSpec finiteAnimationSpec, Continuation continuation, int i5, Object obj2) {
        if ((i5 & 1) != 0) {
            obj = seekableTransitionState.getTargetState();
        }
        if ((i5 & 2) != 0) {
            finiteAnimationSpec = null;
        }
        return seekableTransitionState.animateTo(obj, finiteAnimationSpec, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doOneFrame(Continuation<? super Unit> continuation) {
        if (this.lastFrameTimeNanos == Long.MIN_VALUE) {
            Object withFrameNanos = MonotonicFrameClockKt.withFrameNanos(this.firstFrameLambda, continuation);
            return withFrameNanos == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withFrameNanos : Unit.INSTANCE;
        }
        Object animateOneFrame = animateOneFrame(continuation);
        return animateOneFrame == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateOneFrame : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endAllAnimations() {
        Transition<S> transition = this.transition;
        if (transition != null) {
            transition.clearInitialAnimations$animation_core_release();
        }
        this.initialValueAnimations.clear();
        if (this.currentAnimation != null) {
            this.currentAnimation = null;
            setFraction(1.0f);
            seekToFraction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveAnimationToInitialState() {
        Transition<S> transition = this.transition;
        if (transition == null) {
            return;
        }
        SeekingAnimationState seekingAnimationState = this.currentAnimation;
        if (seekingAnimationState == null) {
            if (this.totalDurationNanos <= 0 || getFraction() == 1.0f || Intrinsics.areEqual(getCurrentState(), getTargetState())) {
                seekingAnimationState = null;
            } else {
                seekingAnimationState = new SeekingAnimationState();
                seekingAnimationState.setValue(getFraction());
                long j5 = this.totalDurationNanos;
                seekingAnimationState.setDurationNanos(j5);
                seekingAnimationState.setAnimationSpecDuration(MathKt.roundToLong(j5 * (1.0d - getFraction())));
                seekingAnimationState.getStart().set$animation_core_release(0, getFraction());
            }
        }
        if (seekingAnimationState != null) {
            seekingAnimationState.setDurationNanos(this.totalDurationNanos);
            this.initialValueAnimations.add(seekingAnimationState);
            transition.setInitialAnimations$animation_core_release(seekingAnimationState);
        }
        this.currentAnimation = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recalculateAnimationValue(SeekingAnimationState animation, long deltaPlayTimeNanos) {
        long progressNanos = animation.getProgressNanos() + deltaPlayTimeNanos;
        animation.setProgressNanos(progressNanos);
        long animationSpecDuration = animation.getAnimationSpecDuration();
        if (progressNanos >= animationSpecDuration) {
            animation.setValue(1.0f);
            return;
        }
        VectorizedAnimationSpec<AnimationVector1D> animationSpec = animation.getAnimationSpec();
        if (animationSpec == null) {
            animation.setValue(VectorConvertersKt.lerp(animation.getStart().get$animation_core_release(0), 1.0f, ((float) progressNanos) / ((float) animationSpecDuration)));
            return;
        }
        AnimationVector1D start = animation.getStart();
        AnimationVector1D animationVector1D = Target1;
        AnimationVector1D initialVelocity = animation.getInitialVelocity();
        if (initialVelocity == null) {
            initialVelocity = ZeroVelocity;
        }
        animation.setValue(RangesKt.coerceIn(animationSpec.getValueFromNanos(progressNanos, start, animationVector1D, initialVelocity).get$animation_core_release(0), 0.0f, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runAnimations(Continuation<? super Unit> continuation) {
        SeekableTransitionState$runAnimations$1 seekableTransitionState$runAnimations$1;
        Object coroutine_suspended;
        int i5;
        SeekableTransitionState seekableTransitionState;
        if (continuation instanceof SeekableTransitionState$runAnimations$1) {
            seekableTransitionState$runAnimations$1 = (SeekableTransitionState$runAnimations$1) continuation;
            int i6 = seekableTransitionState$runAnimations$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                seekableTransitionState$runAnimations$1.label = i6 - Integer.MIN_VALUE;
                Object obj = seekableTransitionState$runAnimations$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = seekableTransitionState$runAnimations$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.initialValueAnimations.isEmpty() && this.currentAnimation == null) {
                        return Unit.INSTANCE;
                    }
                    if (SuspendAnimationKt.getDurationScale(seekableTransitionState$runAnimations$1.getContext()) == 0.0f) {
                        endAllAnimations();
                        this.lastFrameTimeNanos = Long.MIN_VALUE;
                        return Unit.INSTANCE;
                    }
                    if (this.lastFrameTimeNanos == Long.MIN_VALUE) {
                        Function1<Long, Unit> function1 = this.firstFrameLambda;
                        seekableTransitionState$runAnimations$1.L$0 = this;
                        seekableTransitionState$runAnimations$1.label = 1;
                        if (MonotonicFrameClockKt.withFrameNanos(function1, seekableTransitionState$runAnimations$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    seekableTransitionState = this;
                } else {
                    if (i5 != 1 && i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    seekableTransitionState = (SeekableTransitionState) seekableTransitionState$runAnimations$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                do {
                    if (seekableTransitionState.initialValueAnimations.isNotEmpty() && seekableTransitionState.currentAnimation == null) {
                        seekableTransitionState.lastFrameTimeNanos = Long.MIN_VALUE;
                        return Unit.INSTANCE;
                    }
                    seekableTransitionState$runAnimations$1.L$0 = seekableTransitionState;
                    seekableTransitionState$runAnimations$1.label = 2;
                } while (seekableTransitionState.animateOneFrame(seekableTransitionState$runAnimations$1) != coroutine_suspended);
                return coroutine_suspended;
            }
        }
        seekableTransitionState$runAnimations$1 = new SeekableTransitionState$runAnimations$1(this, continuation);
        Object obj2 = seekableTransitionState$runAnimations$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = seekableTransitionState$runAnimations$1.label;
        if (i5 != 0) {
        }
        do {
            if (seekableTransitionState.initialValueAnimations.isNotEmpty()) {
            }
            seekableTransitionState$runAnimations$1.L$0 = seekableTransitionState;
            seekableTransitionState$runAnimations$1.label = 2;
        } while (seekableTransitionState.animateOneFrame(seekableTransitionState$runAnimations$1) != coroutine_suspended);
        return coroutine_suspended;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object seekTo$default(SeekableTransitionState seekableTransitionState, float f5, Object obj, Continuation continuation, int i5, Object obj2) {
        if ((i5 & 2) != 0) {
            obj = seekableTransitionState.getTargetState();
        }
        return seekableTransitionState.seekTo(f5, obj, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void seekToFraction() {
        Transition<S> transition = this.transition;
        if (transition == null) {
            return;
        }
        transition.seekAnimations$animation_core_release(MathKt.roundToLong(getFraction() * transition.getTotalDurationNanos()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFraction(float f5) {
        this.fraction.setFloatValue(f5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object waitForComposition(Continuation<? super Unit> continuation) {
        SeekableTransitionState$waitForComposition$1 seekableTransitionState$waitForComposition$1;
        Object coroutine_suspended;
        int i5;
        Object targetState;
        SeekableTransitionState seekableTransitionState;
        Object result;
        Object obj;
        SeekableTransitionState seekableTransitionState2;
        if (continuation instanceof SeekableTransitionState$waitForComposition$1) {
            seekableTransitionState$waitForComposition$1 = (SeekableTransitionState$waitForComposition$1) continuation;
            int i6 = seekableTransitionState$waitForComposition$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                seekableTransitionState$waitForComposition$1.label = i6 - Integer.MIN_VALUE;
                Object obj2 = seekableTransitionState$waitForComposition$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = seekableTransitionState$waitForComposition$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    targetState = getTargetState();
                    Mutex mutex = this.compositionContinuationMutex;
                    seekableTransitionState$waitForComposition$1.L$0 = this;
                    seekableTransitionState$waitForComposition$1.L$1 = targetState;
                    seekableTransitionState$waitForComposition$1.label = 1;
                    if (Mutex.DefaultImpls.lock$default(mutex, null, seekableTransitionState$waitForComposition$1, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    seekableTransitionState = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        obj = seekableTransitionState$waitForComposition$1.L$1;
                        seekableTransitionState2 = (SeekableTransitionState) seekableTransitionState$waitForComposition$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        if (!Intrinsics.areEqual(obj2, obj)) {
                            return Unit.INSTANCE;
                        }
                        seekableTransitionState2.lastFrameTimeNanos = Long.MIN_VALUE;
                        throw new CancellationException("targetState while waiting for composition");
                    }
                    Object obj3 = seekableTransitionState$waitForComposition$1.L$1;
                    seekableTransitionState = (SeekableTransitionState) seekableTransitionState$waitForComposition$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    targetState = obj3;
                }
                seekableTransitionState$waitForComposition$1.L$0 = seekableTransitionState;
                seekableTransitionState$waitForComposition$1.L$1 = targetState;
                seekableTransitionState$waitForComposition$1.label = 2;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(seekableTransitionState$waitForComposition$1), 1);
                cancellableContinuationImpl.initCancellability();
                seekableTransitionState.setCompositionContinuation$animation_core_release(cancellableContinuationImpl);
                Mutex.DefaultImpls.unlock$default(seekableTransitionState.getCompositionContinuationMutex(), null, 1, null);
                result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(seekableTransitionState$waitForComposition$1);
                }
                if (result != coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = targetState;
                obj2 = result;
                seekableTransitionState2 = seekableTransitionState;
                if (!Intrinsics.areEqual(obj2, obj)) {
                }
            }
        }
        seekableTransitionState$waitForComposition$1 = new SeekableTransitionState$waitForComposition$1(this, continuation);
        Object obj22 = seekableTransitionState$waitForComposition$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = seekableTransitionState$waitForComposition$1.label;
        if (i5 != 0) {
        }
        seekableTransitionState$waitForComposition$1.L$0 = seekableTransitionState;
        seekableTransitionState$waitForComposition$1.L$1 = targetState;
        seekableTransitionState$waitForComposition$1.label = 2;
        CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(seekableTransitionState$waitForComposition$1), 1);
        cancellableContinuationImpl2.initCancellability();
        seekableTransitionState.setCompositionContinuation$animation_core_release(cancellableContinuationImpl2);
        Mutex.DefaultImpls.unlock$default(seekableTransitionState.getCompositionContinuationMutex(), null, 1, null);
        result = cancellableContinuationImpl2.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        }
        if (result != coroutine_suspended) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object waitForCompositionAfterTargetStateChange(Continuation<? super Unit> continuation) {
        SeekableTransitionState$waitForCompositionAfterTargetStateChange$1 seekableTransitionState$waitForCompositionAfterTargetStateChange$1;
        int i5;
        Object targetState;
        SeekableTransitionState seekableTransitionState;
        Object obj;
        SeekableTransitionState seekableTransitionState2;
        if (continuation instanceof SeekableTransitionState$waitForCompositionAfterTargetStateChange$1) {
            seekableTransitionState$waitForCompositionAfterTargetStateChange$1 = (SeekableTransitionState$waitForCompositionAfterTargetStateChange$1) continuation;
            int i6 = seekableTransitionState$waitForCompositionAfterTargetStateChange$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                seekableTransitionState$waitForCompositionAfterTargetStateChange$1.label = i6 - Integer.MIN_VALUE;
                Object obj2 = seekableTransitionState$waitForCompositionAfterTargetStateChange$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = seekableTransitionState$waitForCompositionAfterTargetStateChange$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    targetState = getTargetState();
                    Mutex mutex = this.compositionContinuationMutex;
                    seekableTransitionState$waitForCompositionAfterTargetStateChange$1.L$0 = this;
                    seekableTransitionState$waitForCompositionAfterTargetStateChange$1.L$1 = targetState;
                    seekableTransitionState$waitForCompositionAfterTargetStateChange$1.label = 1;
                    if (Mutex.DefaultImpls.lock$default(mutex, null, seekableTransitionState$waitForCompositionAfterTargetStateChange$1, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    seekableTransitionState = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        obj = seekableTransitionState$waitForCompositionAfterTargetStateChange$1.L$1;
                        seekableTransitionState2 = (SeekableTransitionState) seekableTransitionState$waitForCompositionAfterTargetStateChange$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        if (!Intrinsics.areEqual(obj2, obj)) {
                            seekableTransitionState2.lastFrameTimeNanos = Long.MIN_VALUE;
                            throw new CancellationException("snapTo() was canceled because state was changed to " + obj2 + " instead of " + obj);
                        }
                        return Unit.INSTANCE;
                    }
                    Object obj3 = seekableTransitionState$waitForCompositionAfterTargetStateChange$1.L$1;
                    seekableTransitionState = (SeekableTransitionState) seekableTransitionState$waitForCompositionAfterTargetStateChange$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    targetState = obj3;
                }
                if (!Intrinsics.areEqual(targetState, seekableTransitionState.composedTargetState)) {
                    Mutex.DefaultImpls.unlock$default(seekableTransitionState.compositionContinuationMutex, null, 1, null);
                    return Unit.INSTANCE;
                }
                seekableTransitionState$waitForCompositionAfterTargetStateChange$1.L$0 = seekableTransitionState;
                seekableTransitionState$waitForCompositionAfterTargetStateChange$1.L$1 = targetState;
                seekableTransitionState$waitForCompositionAfterTargetStateChange$1.label = 2;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(seekableTransitionState$waitForCompositionAfterTargetStateChange$1), 1);
                cancellableContinuationImpl.initCancellability();
                seekableTransitionState.setCompositionContinuation$animation_core_release(cancellableContinuationImpl);
                Mutex.DefaultImpls.unlock$default(seekableTransitionState.getCompositionContinuationMutex(), null, 1, null);
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(seekableTransitionState$waitForCompositionAfterTargetStateChange$1);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = targetState;
                obj2 = result;
                seekableTransitionState2 = seekableTransitionState;
                if (!Intrinsics.areEqual(obj2, obj)) {
                }
                return Unit.INSTANCE;
            }
        }
        seekableTransitionState$waitForCompositionAfterTargetStateChange$1 = new SeekableTransitionState$waitForCompositionAfterTargetStateChange$1(this, continuation);
        Object obj22 = seekableTransitionState$waitForCompositionAfterTargetStateChange$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = seekableTransitionState$waitForCompositionAfterTargetStateChange$1.label;
        if (i5 != 0) {
        }
        if (!Intrinsics.areEqual(targetState, seekableTransitionState.composedTargetState)) {
        }
    }

    public final Object animateTo(S s5, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super Unit> continuation) {
        Object mutate$default;
        Transition<S> transition = this.transition;
        return (transition != null && (mutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new SeekableTransitionState$animateTo$2(transition, this, s5, finiteAnimationSpec, null), continuation, 1, null)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? mutate$default : Unit.INSTANCE;
    }

    public final S getComposedTargetState$animation_core_release() {
        return this.composedTargetState;
    }

    public final CancellableContinuation<S> getCompositionContinuation$animation_core_release() {
        return this.compositionContinuation;
    }

    /* renamed from: getCompositionContinuationMutex$animation_core_release, reason: from getter */
    public final Mutex getCompositionContinuationMutex() {
        return this.compositionContinuationMutex;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public S getCurrentState() {
        return (S) this.currentState.getValue();
    }

    public final float getFraction() {
        return this.fraction.getFloatValue();
    }

    @Override // androidx.compose.animation.core.TransitionState
    public S getTargetState() {
        return (S) this.targetState.getValue();
    }

    /* renamed from: getTotalDurationNanos$animation_core_release, reason: from getter */
    public final long getTotalDurationNanos() {
        return this.totalDurationNanos;
    }

    public final void observeTotalDuration$animation_core_release() {
        TransitionKt.getSeekableStateObserver().observeReads(this, TransitionKt.access$getSeekableTransitionStateTotalDurationChanged$p(), this.recalculateTotalDurationNanos);
    }

    public final void onTotalDurationChanged$animation_core_release() {
        long j5 = this.totalDurationNanos;
        observeTotalDuration$animation_core_release();
        long j6 = this.totalDurationNanos;
        if (j5 != j6) {
            SeekingAnimationState seekingAnimationState = this.currentAnimation;
            if (seekingAnimationState == null) {
                if (j6 != 0) {
                    seekToFraction();
                }
            } else {
                seekingAnimationState.setDurationNanos(j6);
                if (seekingAnimationState.getAnimationSpec() == null) {
                    seekingAnimationState.setAnimationSpecDuration(MathKt.roundToLong((1.0d - seekingAnimationState.getStart().get$animation_core_release(0)) * this.totalDurationNanos));
                }
            }
        }
    }

    public final Object seekTo(float f5, S s5, Continuation<? super Unit> continuation) {
        boolean z5 = false;
        if (0.0f <= f5 && f5 <= 1.0f) {
            z5 = true;
        }
        if (!z5) {
            PreconditionsKt.throwIllegalArgumentException("Expecting fraction between 0 and 1. Got " + f5);
        }
        Transition<S> transition = this.transition;
        if (transition == null) {
            return Unit.INSTANCE;
        }
        Object mutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new SeekableTransitionState$seekTo$3(s5, getTargetState(), this, transition, f5, null), continuation, 1, null);
        return mutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate$default : Unit.INSTANCE;
    }

    public final void setComposedTargetState$animation_core_release(S s5) {
        this.composedTargetState = s5;
    }

    public final void setCompositionContinuation$animation_core_release(CancellableContinuation<? super S> cancellableContinuation) {
        this.compositionContinuation = cancellableContinuation;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void setCurrentState$animation_core_release(S s5) {
        this.currentState.setValue(s5);
    }

    public void setTargetState$animation_core_release(S s5) {
        this.targetState.setValue(s5);
    }

    public final void setTotalDurationNanos$animation_core_release(long j5) {
        this.totalDurationNanos = j5;
    }

    public final Object snapTo(S s5, Continuation<? super Unit> continuation) {
        Object mutate$default;
        Transition<S> transition = this.transition;
        return transition == null ? Unit.INSTANCE : (!(Intrinsics.areEqual(getCurrentState(), s5) && Intrinsics.areEqual(getTargetState(), s5)) && (mutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new SeekableTransitionState$snapTo$2(this, s5, transition, null), continuation, 1, null)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? mutate$default : Unit.INSTANCE;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void transitionConfigured$animation_core_release(Transition<S> transition) {
        Transition<S> transition2 = this.transition;
        if (!(transition2 == null || Intrinsics.areEqual(transition, transition2))) {
            PreconditionsKt.throwIllegalStateException("An instance of SeekableTransitionState has been used in different Transitions. Previous instance: " + this.transition + ", new instance: " + transition);
        }
        this.transition = transition;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void transitionRemoved$animation_core_release() {
        this.transition = null;
        TransitionKt.getSeekableStateObserver().clear(this);
    }
}
