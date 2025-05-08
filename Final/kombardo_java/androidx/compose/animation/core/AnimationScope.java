package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b)\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0004B[\b\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0010\b\u001a\u00028\u0001\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00028\u0000\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015R#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u000b\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\f\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001fR+\u0010&\u001a\u00028\u00002\u0006\u0010 \u001a\u00028\u00008F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010%R*\u0010'\u001a\u00028\u00012\u0006\u0010 \u001a\u00028\u00018\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R*\u0010\n\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t8F@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001c\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010/R*\u00100\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t8F@@X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010\u001c\u001a\u0004\b1\u0010\u001e\"\u0004\b2\u0010/R+\u0010\u000e\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r8F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b3\u0010\"\u001a\u0004\b\u000e\u00104\"\u0004\b5\u00106R\u0011\u00108\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b7\u0010\u001b¨\u00069"}, d2 = {"Landroidx/compose/animation/core/AnimationScope;", "T", "Landroidx/compose/animation/core/AnimationVector;", "V", BuildConfig.FLAVOR, "initialValue", "Landroidx/compose/animation/core/TwoWayConverter;", "typeConverter", "initialVelocityVector", BuildConfig.FLAVOR, "lastFrameTimeNanos", "targetValue", "startTimeNanos", BuildConfig.FLAVOR, "isRunning", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onCancel", "<init>", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationVector;JLjava/lang/Object;JZLkotlin/jvm/functions/Function0;)V", "cancelAnimation", "()V", "Landroidx/compose/animation/core/TwoWayConverter;", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "Ljava/lang/Object;", "getTargetValue", "()Ljava/lang/Object;", "J", "getStartTimeNanos", "()J", "Lkotlin/jvm/functions/Function0;", "<set-?>", "value$delegate", "Landroidx/compose/runtime/MutableState;", "getValue", "setValue$animation_core_release", "(Ljava/lang/Object;)V", "value", "velocityVector", "Landroidx/compose/animation/core/AnimationVector;", "getVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "setVelocityVector$animation_core_release", "(Landroidx/compose/animation/core/AnimationVector;)V", "getLastFrameTimeNanos", "setLastFrameTimeNanos$animation_core_release", "(J)V", "finishedTimeNanos", "getFinishedTimeNanos", "setFinishedTimeNanos$animation_core_release", "isRunning$delegate", "()Z", "setRunning$animation_core_release", "(Z)V", "getVelocity", "velocity", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnimationScope<T, V extends AnimationVector> {
    private long finishedTimeNanos;

    /* renamed from: isRunning$delegate, reason: from kotlin metadata */
    private final MutableState isRunning;
    private long lastFrameTimeNanos;
    private final Function0<Unit> onCancel;
    private final long startTimeNanos;
    private final T targetValue;
    private final TwoWayConverter<T, V> typeConverter;

    /* renamed from: value$delegate, reason: from kotlin metadata */
    private final MutableState value;
    private V velocityVector;

    public AnimationScope(T t5, TwoWayConverter<T, V> twoWayConverter, V v5, long j5, T t6, long j6, boolean z5, Function0<Unit> function0) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        this.typeConverter = twoWayConverter;
        this.targetValue = t6;
        this.startTimeNanos = j6;
        this.onCancel = function0;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t5, null, 2, null);
        this.value = mutableStateOf$default;
        this.velocityVector = (V) AnimationVectorsKt.copy(v5);
        this.lastFrameTimeNanos = j5;
        this.finishedTimeNanos = Long.MIN_VALUE;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z5), null, 2, null);
        this.isRunning = mutableStateOf$default2;
    }

    public final void cancelAnimation() {
        setRunning$animation_core_release(false);
        this.onCancel.invoke();
    }

    public final long getFinishedTimeNanos() {
        return this.finishedTimeNanos;
    }

    public final long getLastFrameTimeNanos() {
        return this.lastFrameTimeNanos;
    }

    public final long getStartTimeNanos() {
        return this.startTimeNanos;
    }

    public final T getValue() {
        return this.value.getValue();
    }

    public final T getVelocity() {
        return this.typeConverter.getConvertFromVector().invoke(this.velocityVector);
    }

    public final V getVelocityVector() {
        return this.velocityVector;
    }

    public final boolean isRunning() {
        return ((Boolean) this.isRunning.getValue()).booleanValue();
    }

    public final void setFinishedTimeNanos$animation_core_release(long j5) {
        this.finishedTimeNanos = j5;
    }

    public final void setLastFrameTimeNanos$animation_core_release(long j5) {
        this.lastFrameTimeNanos = j5;
    }

    public final void setRunning$animation_core_release(boolean z5) {
        this.isRunning.setValue(Boolean.valueOf(z5));
    }

    public final void setValue$animation_core_release(T t5) {
        this.value.setValue(t5);
    }

    public final void setVelocityVector$animation_core_release(V v5) {
        this.velocityVector = v5;
    }
}
