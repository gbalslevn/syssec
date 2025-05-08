package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import androidx.compose.foundation.gestures.UpdatableAnimationState;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.math.MathKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J=\u0010\f\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0086@\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState;", BuildConfig.FLAVOR, "Landroidx/compose/animation/core/AnimationSpec;", BuildConfig.FLAVOR, "animationSpec", "<init>", "(Landroidx/compose/animation/core/AnimationSpec;)V", "Lkotlin/Function1;", BuildConfig.FLAVOR, "beforeFrame", "Lkotlin/Function0;", "afterFrame", "animateToZero", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "Landroidx/compose/animation/core/AnimationVector1D;", "vectorizedSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", BuildConfig.FLAVOR, "lastFrameTime", "J", "lastVelocity", "Landroidx/compose/animation/core/AnimationVector1D;", BuildConfig.FLAVOR, "isRunning", "Z", "value", "F", "getValue", "()F", "setValue", "(F)V", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UpdatableAnimationState {
    private boolean isRunning;
    private long lastFrameTime = Long.MIN_VALUE;
    private AnimationVector1D lastVelocity = ZeroVector;
    private float value;
    private final VectorizedAnimationSpec<AnimationVector1D> vectorizedSpec;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final AnimationVector1D ZeroVector = new AnimationVector1D(0.0f);

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u00020\n*\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState$Companion;", BuildConfig.FLAVOR, "()V", "VisibilityThreshold", BuildConfig.FLAVOR, "ZeroVector", "Landroidx/compose/animation/core/AnimationVector1D;", "getZeroVector", "()Landroidx/compose/animation/core/AnimationVector1D;", "isZeroish", BuildConfig.FLAVOR, "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AnimationVector1D getZeroVector() {
            return UpdatableAnimationState.ZeroVector;
        }

        public final boolean isZeroish(float f5) {
            return Math.abs(f5) < 0.01f;
        }

        private Companion() {
        }
    }

    public UpdatableAnimationState(AnimationSpec<Float> animationSpec) {
        this.vectorizedSpec = animationSpec.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a7, code lost:
    
        if (r13 != 0.0f) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x009f -> B:24:0x00a2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object animateToZero(Function1<? super Float, Unit> function1, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        UpdatableAnimationState$animateToZero$1 updatableAnimationState$animateToZero$1;
        int i5;
        UpdatableAnimationState$animateToZero$1 updatableAnimationState$animateToZero$12;
        Function0 function02;
        final Function1<? super Float, Unit> function12;
        final float f5;
        final UpdatableAnimationState updatableAnimationState;
        Function0 function03;
        UpdatableAnimationState updatableAnimationState2;
        try {
            if (continuation instanceof UpdatableAnimationState$animateToZero$1) {
                updatableAnimationState$animateToZero$1 = (UpdatableAnimationState$animateToZero$1) continuation;
                int i6 = updatableAnimationState$animateToZero$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    updatableAnimationState$animateToZero$1.label = i6 - Integer.MIN_VALUE;
                    Object obj = updatableAnimationState$animateToZero$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = updatableAnimationState$animateToZero$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (this.isRunning) {
                            throw new IllegalStateException("animateToZero called while previous animation is running");
                        }
                        MotionDurationScale motionDurationScale = (MotionDurationScale) updatableAnimationState$animateToZero$1.getContext().get(MotionDurationScale.INSTANCE);
                        float scaleFactor = motionDurationScale != null ? motionDurationScale.getScaleFactor() : 1.0f;
                        this.isRunning = true;
                        updatableAnimationState$animateToZero$12 = updatableAnimationState$animateToZero$1;
                        function02 = function0;
                        function12 = function1;
                        f5 = scaleFactor;
                        updatableAnimationState = this;
                        if (!Companion.isZeroish(updatableAnimationState.value)) {
                            Function1<Long, Unit> function13 = new Function1<Long, Unit>() { // from class: androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$4
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Long l5) {
                                    invoke(l5.longValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(long j5) {
                                    long j6;
                                    long j7;
                                    long roundToLong;
                                    VectorizedAnimationSpec vectorizedAnimationSpec;
                                    UpdatableAnimationState.Companion companion;
                                    AnimationVector1D animationVector1D;
                                    VectorizedAnimationSpec vectorizedAnimationSpec2;
                                    UpdatableAnimationState.Companion companion2;
                                    AnimationVector1D animationVector1D2;
                                    VectorizedAnimationSpec vectorizedAnimationSpec3;
                                    UpdatableAnimationState.Companion companion3;
                                    AnimationVector1D animationVector1D3;
                                    j6 = UpdatableAnimationState.this.lastFrameTime;
                                    if (j6 == Long.MIN_VALUE) {
                                        UpdatableAnimationState.this.lastFrameTime = j5;
                                    }
                                    AnimationVector1D animationVector1D4 = new AnimationVector1D(UpdatableAnimationState.this.getValue());
                                    if (f5 == 0.0f) {
                                        vectorizedAnimationSpec3 = UpdatableAnimationState.this.vectorizedSpec;
                                        AnimationVector1D animationVector1D5 = new AnimationVector1D(UpdatableAnimationState.this.getValue());
                                        companion3 = UpdatableAnimationState.Companion;
                                        AnimationVector1D zeroVector = companion3.getZeroVector();
                                        animationVector1D3 = UpdatableAnimationState.this.lastVelocity;
                                        roundToLong = vectorizedAnimationSpec3.getDurationNanos(animationVector1D5, zeroVector, animationVector1D3);
                                    } else {
                                        j7 = UpdatableAnimationState.this.lastFrameTime;
                                        roundToLong = MathKt.roundToLong(((float) (j5 - j7)) / f5);
                                    }
                                    long j8 = roundToLong;
                                    vectorizedAnimationSpec = UpdatableAnimationState.this.vectorizedSpec;
                                    companion = UpdatableAnimationState.Companion;
                                    AnimationVector1D zeroVector2 = companion.getZeroVector();
                                    animationVector1D = UpdatableAnimationState.this.lastVelocity;
                                    float value = ((AnimationVector1D) vectorizedAnimationSpec.getValueFromNanos(j8, animationVector1D4, zeroVector2, animationVector1D)).getValue();
                                    UpdatableAnimationState updatableAnimationState3 = UpdatableAnimationState.this;
                                    vectorizedAnimationSpec2 = updatableAnimationState3.vectorizedSpec;
                                    companion2 = UpdatableAnimationState.Companion;
                                    AnimationVector1D zeroVector3 = companion2.getZeroVector();
                                    animationVector1D2 = UpdatableAnimationState.this.lastVelocity;
                                    updatableAnimationState3.lastVelocity = (AnimationVector1D) vectorizedAnimationSpec2.getVelocityFromNanos(j8, animationVector1D4, zeroVector3, animationVector1D2);
                                    UpdatableAnimationState.this.lastFrameTime = j5;
                                    float value2 = UpdatableAnimationState.this.getValue() - value;
                                    UpdatableAnimationState.this.setValue(value);
                                    function12.invoke(Float.valueOf(value2));
                                }
                            };
                            updatableAnimationState$animateToZero$12.L$0 = updatableAnimationState;
                            updatableAnimationState$animateToZero$12.L$1 = function12;
                            updatableAnimationState$animateToZero$12.L$2 = function02;
                            updatableAnimationState$animateToZero$12.F$0 = f5;
                            updatableAnimationState$animateToZero$12.label = 1;
                            if (MonotonicFrameClockKt.withFrameNanos(function13, updatableAnimationState$animateToZero$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function02.invoke();
                        }
                        function03 = function02;
                        UpdatableAnimationState updatableAnimationState3 = updatableAnimationState;
                        final Function1<? super Float, Unit> function14 = function12;
                        final UpdatableAnimationState updatableAnimationState4 = updatableAnimationState3;
                        if (Math.abs(updatableAnimationState4.value) == 0.0f) {
                            updatableAnimationState2 = updatableAnimationState4;
                            updatableAnimationState2.lastFrameTime = Long.MIN_VALUE;
                            updatableAnimationState2.lastVelocity = ZeroVector;
                            updatableAnimationState2.isRunning = false;
                            return Unit.INSTANCE;
                        }
                        Function1<Long, Unit> function15 = new Function1<Long, Unit>() { // from class: androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$5
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Long l5) {
                                invoke(l5.longValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(long j5) {
                                float value = UpdatableAnimationState.this.getValue();
                                UpdatableAnimationState.this.setValue(0.0f);
                                function14.invoke(Float.valueOf(value));
                            }
                        };
                        updatableAnimationState$animateToZero$12.L$0 = updatableAnimationState4;
                        updatableAnimationState$animateToZero$12.L$1 = function03;
                        updatableAnimationState$animateToZero$12.L$2 = null;
                        updatableAnimationState$animateToZero$12.label = 2;
                        function0 = updatableAnimationState4;
                        if (MonotonicFrameClockKt.withFrameNanos(function15, updatableAnimationState$animateToZero$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function03.invoke();
                        updatableAnimationState2 = function0;
                        updatableAnimationState2.lastFrameTime = Long.MIN_VALUE;
                        updatableAnimationState2.lastVelocity = ZeroVector;
                        updatableAnimationState2.isRunning = false;
                        return Unit.INSTANCE;
                    }
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        function03 = (Function0) updatableAnimationState$animateToZero$1.L$1;
                        UpdatableAnimationState updatableAnimationState5 = (UpdatableAnimationState) updatableAnimationState$animateToZero$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        function0 = updatableAnimationState5;
                        function03.invoke();
                        updatableAnimationState2 = function0;
                        updatableAnimationState2.lastFrameTime = Long.MIN_VALUE;
                        updatableAnimationState2.lastVelocity = ZeroVector;
                        updatableAnimationState2.isRunning = false;
                        return Unit.INSTANCE;
                    }
                    f5 = updatableAnimationState$animateToZero$1.F$0;
                    Function0 function04 = (Function0) updatableAnimationState$animateToZero$1.L$2;
                    Function1<? super Float, Unit> function16 = (Function1) updatableAnimationState$animateToZero$1.L$1;
                    UpdatableAnimationState updatableAnimationState6 = (UpdatableAnimationState) updatableAnimationState$animateToZero$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        updatableAnimationState = updatableAnimationState6;
                        UpdatableAnimationState$animateToZero$1 updatableAnimationState$animateToZero$13 = updatableAnimationState$animateToZero$1;
                        function02 = function04;
                        function12 = function16;
                        updatableAnimationState$animateToZero$12 = updatableAnimationState$animateToZero$13;
                    } catch (Throwable th) {
                        th = th;
                        function0 = updatableAnimationState6;
                        function0.lastFrameTime = Long.MIN_VALUE;
                        function0.lastVelocity = ZeroVector;
                        function0.isRunning = false;
                        throw th;
                    }
                    try {
                        function02.invoke();
                    } catch (Throwable th2) {
                        th = th2;
                        function0 = updatableAnimationState;
                        function0.lastFrameTime = Long.MIN_VALUE;
                        function0.lastVelocity = ZeroVector;
                        function0.isRunning = false;
                        throw th;
                    }
                }
            }
            if (i5 != 0) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
        updatableAnimationState$animateToZero$1 = new UpdatableAnimationState$animateToZero$1(this, continuation);
        Object obj2 = updatableAnimationState$animateToZero$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = updatableAnimationState$animateToZero$1.label;
    }

    public final float getValue() {
        return this.value;
    }

    public final void setValue(float f5) {
        this.value = f5;
    }
}
