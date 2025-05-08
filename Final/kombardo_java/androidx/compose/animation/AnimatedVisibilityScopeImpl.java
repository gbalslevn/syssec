package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0006R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "transition", "<init>", "(Landroidx/compose/animation/core/Transition;)V", "Landroidx/compose/animation/core/Transition;", "getTransition", "()Landroidx/compose/animation/core/Transition;", "setTransition", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/unit/IntSize;", "targetSize", "Landroidx/compose/runtime/MutableState;", "getTargetSize$animation_release", "()Landroidx/compose/runtime/MutableState;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnimatedVisibilityScopeImpl implements AnimatedVisibilityScope {
    private final MutableState<IntSize> targetSize;
    private Transition<EnterExitState> transition;

    public AnimatedVisibilityScopeImpl(Transition<EnterExitState> transition) {
        MutableState<IntSize> mutableStateOf$default;
        this.transition = transition;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m2656boximpl(IntSize.INSTANCE.m2665getZeroYbymL2g()), null, 2, null);
        this.targetSize = mutableStateOf$default;
    }

    public final MutableState<IntSize> getTargetSize$animation_release() {
        return this.targetSize;
    }
}
