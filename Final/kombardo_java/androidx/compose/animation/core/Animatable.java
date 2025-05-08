package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0004B9\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJZ\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00132\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u000f\u001a\u00028\u00002 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJb\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00132\u0006\u0010\u001b\u001a\u00028\u00002\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\b\b\u0002\u0010\u000f\u001a\u00028\u00002\"\b\u0002\u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0086@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010 \u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00028\u0000H\u0086@¢\u0006\u0004\b \u0010!J\u0013\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"¢\u0006\u0004\b#\u0010$R#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010\b\u001a\u0004\u0018\u00018\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010(R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010)\u001a\u0004\b*\u0010+R&\u0010-\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010,8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R+\u00105\u001a\u0002012\u0006\u00102\u001a\u0002018F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R+\u0010\u001b\u001a\u00028\u00002\u0006\u00102\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b9\u00104\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010>\u001a\u0004\u0018\u00018\u00002\b\u00102\u001a\u0004\u0018\u00018\u00008\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b>\u0010(\u001a\u0004\b?\u0010;R(\u0010@\u001a\u0004\u0018\u00018\u00002\b\u00102\u001a\u0004\u0018\u00018\u00008\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b@\u0010(\u001a\u0004\bA\u0010;R\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR \u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000E8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001a\u0010J\u001a\u00028\u00018\u0002X\u0082\u0004¢\u0006\f\n\u0004\bJ\u0010K\u0012\u0004\bL\u0010\u001aR\u001a\u0010M\u001a\u00028\u00018\u0002X\u0082\u0004¢\u0006\f\n\u0004\bM\u0010K\u0012\u0004\bN\u0010\u001aR\u0016\u0010O\u001a\u00028\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010KR\u0016\u0010P\u001a\u00028\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010KR\u0011\u0010\u0016\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\bQ\u0010;R\u0011\u0010T\u001a\u00028\u00018F¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0011\u0010V\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\bU\u0010;¨\u0006W"}, d2 = {"Landroidx/compose/animation/core/Animatable;", "T", "Landroidx/compose/animation/core/AnimationVector;", "V", BuildConfig.FLAVOR, "initialValue", "Landroidx/compose/animation/core/TwoWayConverter;", "typeConverter", "visibilityThreshold", BuildConfig.FLAVOR, "label", "<init>", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/String;)V", "Landroidx/compose/animation/core/Animation;", "animation", "initialVelocity", "Lkotlin/Function1;", BuildConfig.FLAVOR, "block", "Landroidx/compose/animation/core/AnimationResult;", "runAnimation", "(Landroidx/compose/animation/core/Animation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "clampToBounds", "(Ljava/lang/Object;)Ljava/lang/Object;", "endAnimation", "()V", "targetValue", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "animateTo", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/runtime/State;", "asState", "()Landroidx/compose/runtime/State;", "Landroidx/compose/animation/core/TwoWayConverter;", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "Ljava/lang/Object;", "Ljava/lang/String;", "getLabel", "()Ljava/lang/String;", "Landroidx/compose/animation/core/AnimationState;", "internalState", "Landroidx/compose/animation/core/AnimationState;", "getInternalState$animation_core_release", "()Landroidx/compose/animation/core/AnimationState;", BuildConfig.FLAVOR, "<set-?>", "isRunning$delegate", "Landroidx/compose/runtime/MutableState;", "isRunning", "()Z", "setRunning", "(Z)V", "targetValue$delegate", "getTargetValue", "()Ljava/lang/Object;", "setTargetValue", "(Ljava/lang/Object;)V", "lowerBound", "getLowerBound", "upperBound", "getUpperBound", "Landroidx/compose/animation/core/MutatorMutex;", "mutatorMutex", "Landroidx/compose/animation/core/MutatorMutex;", "Landroidx/compose/animation/core/SpringSpec;", "defaultSpringSpec", "Landroidx/compose/animation/core/SpringSpec;", "getDefaultSpringSpec$animation_core_release", "()Landroidx/compose/animation/core/SpringSpec;", "negativeInfinityBounds", "Landroidx/compose/animation/core/AnimationVector;", "getNegativeInfinityBounds$annotations", "positiveInfinityBounds", "getPositiveInfinityBounds$annotations", "lowerBoundVector", "upperBoundVector", "getValue", "getVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "getVelocity", "velocity", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Animatable<T, V extends AnimationVector> {
    private final SpringSpec<T> defaultSpringSpec;
    private final AnimationState<T, V> internalState;

    /* renamed from: isRunning$delegate, reason: from kotlin metadata */
    private final MutableState isRunning;
    private final String label;
    private T lowerBound;
    private V lowerBoundVector;
    private final MutatorMutex mutatorMutex;
    private final V negativeInfinityBounds;
    private final V positiveInfinityBounds;

    /* renamed from: targetValue$delegate, reason: from kotlin metadata */
    private final MutableState targetValue;
    private final TwoWayConverter<T, V> typeConverter;
    private T upperBound;
    private V upperBoundVector;
    private final T visibilityThreshold;

    public Animatable(T t5, TwoWayConverter<T, V> twoWayConverter, T t6, String str) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        V access$getNegativeInfinityBounds3D$p;
        V access$getPositiveInfinityBounds3D$p;
        this.typeConverter = twoWayConverter;
        this.visibilityThreshold = t6;
        this.label = str;
        this.internalState = new AnimationState<>(twoWayConverter, t5, null, 0L, 0L, false, 60, null);
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.isRunning = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t5, null, 2, null);
        this.targetValue = mutableStateOf$default2;
        this.mutatorMutex = new MutatorMutex();
        this.defaultSpringSpec = new SpringSpec<>(0.0f, 0.0f, t6, 3, null);
        V velocityVector = getVelocityVector();
        if (velocityVector instanceof AnimationVector1D) {
            access$getNegativeInfinityBounds3D$p = AnimatableKt.access$getNegativeInfinityBounds1D$p();
        } else if (velocityVector instanceof AnimationVector2D) {
            access$getNegativeInfinityBounds3D$p = AnimatableKt.access$getNegativeInfinityBounds2D$p();
        } else {
            access$getNegativeInfinityBounds3D$p = velocityVector instanceof AnimationVector3D ? AnimatableKt.access$getNegativeInfinityBounds3D$p() : AnimatableKt.access$getNegativeInfinityBounds4D$p();
        }
        Intrinsics.checkNotNull(access$getNegativeInfinityBounds3D$p, "null cannot be cast to non-null type V of androidx.compose.animation.core.Animatable");
        this.negativeInfinityBounds = access$getNegativeInfinityBounds3D$p;
        V velocityVector2 = getVelocityVector();
        if (velocityVector2 instanceof AnimationVector1D) {
            access$getPositiveInfinityBounds3D$p = AnimatableKt.access$getPositiveInfinityBounds1D$p();
        } else if (velocityVector2 instanceof AnimationVector2D) {
            access$getPositiveInfinityBounds3D$p = AnimatableKt.access$getPositiveInfinityBounds2D$p();
        } else {
            access$getPositiveInfinityBounds3D$p = velocityVector2 instanceof AnimationVector3D ? AnimatableKt.access$getPositiveInfinityBounds3D$p() : AnimatableKt.access$getPositiveInfinityBounds4D$p();
        }
        Intrinsics.checkNotNull(access$getPositiveInfinityBounds3D$p, "null cannot be cast to non-null type V of androidx.compose.animation.core.Animatable");
        this.positiveInfinityBounds = access$getPositiveInfinityBounds3D$p;
        this.lowerBoundVector = access$getNegativeInfinityBounds3D$p;
        this.upperBoundVector = access$getPositiveInfinityBounds3D$p;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(Animatable animatable, Object obj, AnimationSpec animationSpec, Object obj2, Function1 function1, Continuation continuation, int i5, Object obj3) {
        if ((i5 & 2) != 0) {
            animationSpec = animatable.defaultSpringSpec;
        }
        AnimationSpec animationSpec2 = animationSpec;
        T t5 = obj2;
        if ((i5 & 4) != 0) {
            t5 = animatable.getVelocity();
        }
        T t6 = t5;
        if ((i5 & 8) != 0) {
            function1 = null;
        }
        return animatable.animateTo(obj, animationSpec2, t6, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T clampToBounds(T value) {
        if (Intrinsics.areEqual(this.lowerBoundVector, this.negativeInfinityBounds) && Intrinsics.areEqual(this.upperBoundVector, this.positiveInfinityBounds)) {
            return value;
        }
        V invoke = this.typeConverter.getConvertToVector().invoke(value);
        int size = invoke.getSize();
        boolean z5 = false;
        for (int i5 = 0; i5 < size; i5++) {
            if (invoke.get$animation_core_release(i5) < this.lowerBoundVector.get$animation_core_release(i5) || invoke.get$animation_core_release(i5) > this.upperBoundVector.get$animation_core_release(i5)) {
                invoke.set$animation_core_release(i5, RangesKt.coerceIn(invoke.get$animation_core_release(i5), this.lowerBoundVector.get$animation_core_release(i5), this.upperBoundVector.get$animation_core_release(i5)));
                z5 = true;
            }
        }
        return z5 ? this.typeConverter.getConvertFromVector().invoke(invoke) : value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endAnimation() {
        AnimationState<T, V> animationState = this.internalState;
        animationState.getVelocityVector().reset$animation_core_release();
        animationState.setLastFrameTimeNanos$animation_core_release(Long.MIN_VALUE);
        setRunning(false);
    }

    private final Object runAnimation(Animation<T, V> animation, T t5, Function1<? super Animatable<T, V>, Unit> function1, Continuation<? super AnimationResult<T, V>> continuation) {
        return MutatorMutex.mutate$default(this.mutatorMutex, null, new Animatable$runAnimation$2(this, t5, animation, this.internalState.getLastFrameTimeNanos(), function1, null), continuation, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRunning(boolean z5) {
        this.isRunning.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTargetValue(T t5) {
        this.targetValue.setValue(t5);
    }

    public final Object animateTo(T t5, AnimationSpec<T> animationSpec, T t6, Function1<? super Animatable<T, V>, Unit> function1, Continuation<? super AnimationResult<T, V>> continuation) {
        return runAnimation(AnimationKt.TargetBasedAnimation(animationSpec, this.typeConverter, getValue(), t5, t6), t6, function1, continuation);
    }

    public final State<T> asState() {
        return this.internalState;
    }

    public final AnimationState<T, V> getInternalState$animation_core_release() {
        return this.internalState;
    }

    public final T getTargetValue() {
        return this.targetValue.getValue();
    }

    public final TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    public final T getValue() {
        return this.internalState.getValue();
    }

    public final T getVelocity() {
        return this.typeConverter.getConvertFromVector().invoke(getVelocityVector());
    }

    public final V getVelocityVector() {
        return this.internalState.getVelocityVector();
    }

    public final Object snapTo(T t5, Continuation<? super Unit> continuation) {
        Object mutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new Animatable$snapTo$2(this, t5, null), continuation, 1, null);
        return mutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate$default : Unit.INSTANCE;
    }

    public /* synthetic */ Animatable(Object obj, TwoWayConverter twoWayConverter, Object obj2, String str, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, twoWayConverter, (i5 & 4) != 0 ? null : obj2, (i5 & 8) != 0 ? "Animatable" : str);
    }
}
