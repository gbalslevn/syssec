package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\n\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H ¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0007H ¢\u0006\u0004\b\u000b\u0010\u0004R+\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u00008&@`X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u00008&@`X¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019\u0082\u0001\u0002\u001e\u001f¨\u0006 "}, d2 = {"Landroidx/compose/animation/core/TransitionState;", "S", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/animation/core/Transition;", "transition", BuildConfig.FLAVOR, "transitionConfigured$animation_core_release", "(Landroidx/compose/animation/core/Transition;)V", "transitionConfigured", "transitionRemoved$animation_core_release", "transitionRemoved", BuildConfig.FLAVOR, "<set-?>", "isRunning$delegate", "Landroidx/compose/runtime/MutableState;", "isRunning$animation_core_release", "()Z", "setRunning$animation_core_release", "(Z)V", "isRunning", "getCurrentState", "()Ljava/lang/Object;", "setCurrentState$animation_core_release", "(Ljava/lang/Object;)V", "currentState", "getTargetState", "setTargetState$animation_core_release", "targetState", "Landroidx/compose/animation/core/MutableTransitionState;", "Landroidx/compose/animation/core/SeekableTransitionState;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TransitionState<S> {

    /* renamed from: isRunning$delegate, reason: from kotlin metadata */
    private final MutableState isRunning;

    public /* synthetic */ TransitionState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract S getCurrentState();

    public abstract S getTargetState();

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isRunning$animation_core_release() {
        return ((Boolean) this.isRunning.getValue()).booleanValue();
    }

    public abstract void setCurrentState$animation_core_release(S s5);

    public final void setRunning$animation_core_release(boolean z5) {
        this.isRunning.setValue(Boolean.valueOf(z5));
    }

    public abstract void transitionConfigured$animation_core_release(Transition<S> transition);

    public abstract void transitionRemoved$animation_core_release();

    private TransitionState() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.isRunning = mutableStateOf$default;
    }
}
