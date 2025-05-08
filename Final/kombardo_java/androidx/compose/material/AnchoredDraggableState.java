package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\b\u0001\u0018\u0000 k*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001kBU\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001f\u001a\u00020\u001e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\b\b\u0002\u0010\u001d\u001a\u00028\u0000¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010!\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b!\u0010\"JJ\u0010)\u001a\u00020\u001e2\b\b\u0002\u0010$\u001a\u00020#2.\u0010(\u001a*\b\u0001\u0012\u0004\u0012\u00020&\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0'\u0012\u0006\u0012\u0004\u0018\u00010\u00020%H\u0086@¢\u0006\u0004\b)\u0010*JX\u0010)\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00028\u00002\b\b\u0002\u0010$\u001a\u00020#24\u0010(\u001a0\b\u0001\u0012\u0004\u0012\u00020&\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0'\u0012\u0006\u0012\u0004\u0018\u00010\u00020+H\u0086@¢\u0006\u0004\b)\u0010,J\u0017\u00100\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0000¢\u0006\u0004\b.\u0010/J\u0015\u00101\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005¢\u0006\u0004\b1\u0010/R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u00102\u001a\u0004\b3\u00104R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u00105\u001a\u0004\b6\u00107R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0006¢\u0006\f\n\u0004\b\n\u00108\u001a\u0004\b9\u0010:R&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u00102\u001a\u0004\b;\u00104R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001a\u0010@\u001a\u00020?8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR+\u0010\u0010\u001a\u00028\u00002\u0006\u0010D\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001b\u0010\u0016\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010HR\u001b\u0010P\u001a\u00028\u00008@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bN\u0010L\u001a\u0004\bO\u0010HR+\u0010\u000f\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010\u001a\"\u0004\bT\u0010UR\u001b\u0010X\u001a\u00020\u00058GX\u0086\u0084\u0002¢\u0006\f\n\u0004\bV\u0010L\u001a\u0004\bW\u0010\u001aR+\u0010\\\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bY\u0010R\u001a\u0004\bZ\u0010\u001a\"\u0004\b[\u0010UR/\u0010`\u001a\u0004\u0018\u00018\u00002\b\u0010D\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b]\u0010F\u001a\u0004\b^\u0010H\"\u0004\b_\u0010JR7\u0010f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\ba\u0010F\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0014\u0010g\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0011\u0010i\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bi\u0010j¨\u0006l"}, d2 = {"Landroidx/compose/material/AnchoredDraggableState;", "T", BuildConfig.FLAVOR, "initialValue", "Lkotlin/Function1;", BuildConfig.FLAVOR, "positionalThreshold", "Lkotlin/Function0;", "velocityThreshold", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", BuildConfig.FLAVOR, "confirmValueChange", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "offset", "currentValue", "velocity", "computeTarget", "(FLjava/lang/Object;F)Ljava/lang/Object;", "computeTargetWithoutThresholds", "(FLjava/lang/Object;)Ljava/lang/Object;", "targetValue", "trySnapTo", "(Ljava/lang/Object;)Z", "requireOffset", "()F", "Landroidx/compose/material/DraggableAnchors;", "newAnchors", "newTarget", BuildConfig.FLAVOR, "updateAnchors", "(Landroidx/compose/material/DraggableAnchors;Ljava/lang/Object;)V", "settle", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/foundation/MutatePriority;", "dragPriority", "Lkotlin/Function3;", "Landroidx/compose/material/AnchoredDragScope;", "Lkotlin/coroutines/Continuation;", "block", "anchoredDrag", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function4;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delta", "newOffsetForDelta$material_release", "(F)F", "newOffsetForDelta", "dispatchRawDelta", "Lkotlin/jvm/functions/Function1;", "getPositionalThreshold$material_release", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function0;", "getVelocityThreshold$material_release", "()Lkotlin/jvm/functions/Function0;", "Landroidx/compose/animation/core/AnimationSpec;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getConfirmValueChange$material_release", "Landroidx/compose/material/InternalMutatorMutex;", "dragMutex", "Landroidx/compose/material/InternalMutatorMutex;", "Landroidx/compose/foundation/gestures/DraggableState;", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$material_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "<set-?>", "currentValue$delegate", "Landroidx/compose/runtime/MutableState;", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "targetValue$delegate", "Landroidx/compose/runtime/State;", "getTargetValue", "closestValue$delegate", "getClosestValue$material_release", "closestValue", "offset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getOffset", "setOffset", "(F)V", "progress$delegate", "getProgress", "progress", "lastVelocity$delegate", "getLastVelocity", "setLastVelocity", "lastVelocity", "dragTarget$delegate", "getDragTarget", "setDragTarget", "dragTarget", "anchors$delegate", "getAnchors", "()Landroidx/compose/material/DraggableAnchors;", "setAnchors", "(Landroidx/compose/material/DraggableAnchors;)V", "anchors", "anchoredDragScope", "Landroidx/compose/material/AnchoredDragScope;", "isAnimationRunning", "()Z", "Companion", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnchoredDraggableState<T> {
    private final AnchoredDragScope anchoredDragScope;

    /* renamed from: anchors$delegate, reason: from kotlin metadata */
    private final MutableState anchors;
    private final AnimationSpec<Float> animationSpec;

    /* renamed from: closestValue$delegate, reason: from kotlin metadata */
    private final State closestValue;
    private final Function1<T, Boolean> confirmValueChange;

    /* renamed from: currentValue$delegate, reason: from kotlin metadata */
    private final MutableState currentValue;

    /* renamed from: dragTarget$delegate, reason: from kotlin metadata */
    private final MutableState dragTarget;

    /* renamed from: lastVelocity$delegate, reason: from kotlin metadata */
    private final MutableFloatState lastVelocity;

    /* renamed from: offset$delegate, reason: from kotlin metadata */
    private final MutableFloatState offset;
    private final Function1<Float, Float> positionalThreshold;

    /* renamed from: progress$delegate, reason: from kotlin metadata */
    private final State progress;

    /* renamed from: targetValue$delegate, reason: from kotlin metadata */
    private final State targetValue;
    private final Function0<Float> velocityThreshold;
    private final InternalMutatorMutex dragMutex = new InternalMutatorMutex();
    private final DraggableState draggableState = new AnchoredDraggableState$draggableState$1(this);

    /* JADX WARN: Multi-variable type inference failed */
    public AnchoredDraggableState(T t5, Function1<? super Float, Float> function1, Function0<Float> function0, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> function12) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MapDraggableAnchors emptyDraggableAnchors;
        MutableState mutableStateOf$default3;
        this.positionalThreshold = function1;
        this.velocityThreshold = function0;
        this.animationSpec = animationSpec;
        this.confirmValueChange = function12;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t5, null, 2, null);
        this.currentValue = mutableStateOf$default;
        this.targetValue = SnapshotStateKt.derivedStateOf(new Function0<T>(this) { // from class: androidx.compose.material.AnchoredDraggableState$targetValue$2
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                Object dragTarget;
                Object computeTarget;
                dragTarget = this.this$0.getDragTarget();
                T t6 = (T) dragTarget;
                if (t6 != null) {
                    return t6;
                }
                AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                float offset = anchoredDraggableState.getOffset();
                if (Float.isNaN(offset)) {
                    return anchoredDraggableState.getCurrentValue();
                }
                computeTarget = anchoredDraggableState.computeTarget(offset, anchoredDraggableState.getCurrentValue(), 0.0f);
                return (T) computeTarget;
            }
        });
        this.closestValue = SnapshotStateKt.derivedStateOf(new Function0<T>(this) { // from class: androidx.compose.material.AnchoredDraggableState$closestValue$2
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                Object dragTarget;
                Object computeTargetWithoutThresholds;
                dragTarget = this.this$0.getDragTarget();
                T t6 = (T) dragTarget;
                if (t6 != null) {
                    return t6;
                }
                AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                float offset = anchoredDraggableState.getOffset();
                if (Float.isNaN(offset)) {
                    return anchoredDraggableState.getCurrentValue();
                }
                computeTargetWithoutThresholds = anchoredDraggableState.computeTargetWithoutThresholds(offset, anchoredDraggableState.getCurrentValue());
                return (T) computeTargetWithoutThresholds;
            }
        });
        this.offset = PrimitiveSnapshotStateKt.mutableFloatStateOf(Float.NaN);
        this.progress = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Float>(this) { // from class: androidx.compose.material.AnchoredDraggableState$progress$2
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                float positionOf = this.this$0.getAnchors().positionOf(this.this$0.getCurrentValue());
                float positionOf2 = this.this$0.getAnchors().positionOf(this.this$0.getClosestValue$material_release()) - positionOf;
                float abs = Math.abs(positionOf2);
                float f5 = 1.0f;
                if (!Float.isNaN(abs) && abs > 1.0E-6f) {
                    float requireOffset = (this.this$0.requireOffset() - positionOf) / positionOf2;
                    if (requireOffset < 1.0E-6f) {
                        f5 = 0.0f;
                    } else if (requireOffset <= 0.999999f) {
                        f5 = requireOffset;
                    }
                }
                return Float.valueOf(f5);
            }
        });
        this.lastVelocity = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.dragTarget = mutableStateOf$default2;
        emptyDraggableAnchors = AnchoredDraggableKt.emptyDraggableAnchors();
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(emptyDraggableAnchors, null, 2, null);
        this.anchors = mutableStateOf$default3;
        this.anchoredDragScope = new AnchoredDragScope(this) { // from class: androidx.compose.material.AnchoredDraggableState$anchoredDragScope$1
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // androidx.compose.material.AnchoredDragScope
            public void dragTo(float newOffset, float lastKnownVelocity) {
                this.this$0.setOffset(newOffset);
                this.this$0.setLastVelocity(lastKnownVelocity);
            }
        };
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, Object obj, MutatePriority mutatePriority, Function4 function4, Continuation continuation, int i5, Object obj2) {
        if ((i5 & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(obj, mutatePriority, function4, continuation);
    }

    public final T computeTarget(float offset, T currentValue, float velocity) {
        T closestAnchor;
        DraggableAnchors<T> anchors = getAnchors();
        float positionOf = anchors.positionOf(currentValue);
        float floatValue = this.velocityThreshold.invoke().floatValue();
        if (positionOf == offset || Float.isNaN(positionOf)) {
            return currentValue;
        }
        if (positionOf < offset) {
            if (velocity >= floatValue) {
                T closestAnchor2 = anchors.closestAnchor(offset, true);
                Intrinsics.checkNotNull(closestAnchor2);
                return closestAnchor2;
            }
            closestAnchor = anchors.closestAnchor(offset, true);
            Intrinsics.checkNotNull(closestAnchor);
            if (offset < Math.abs(positionOf + Math.abs(this.positionalThreshold.invoke(Float.valueOf(Math.abs(anchors.positionOf(closestAnchor) - positionOf))).floatValue()))) {
                return currentValue;
            }
        } else {
            if (velocity <= (-floatValue)) {
                T closestAnchor3 = anchors.closestAnchor(offset, false);
                Intrinsics.checkNotNull(closestAnchor3);
                return closestAnchor3;
            }
            closestAnchor = anchors.closestAnchor(offset, false);
            Intrinsics.checkNotNull(closestAnchor);
            float abs = Math.abs(positionOf - Math.abs(this.positionalThreshold.invoke(Float.valueOf(Math.abs(positionOf - anchors.positionOf(closestAnchor)))).floatValue()));
            if (offset < 0.0f) {
                if (Math.abs(offset) < abs) {
                    return currentValue;
                }
            } else if (offset > abs) {
                return currentValue;
            }
        }
        return closestAnchor;
    }

    public final T computeTargetWithoutThresholds(float offset, T currentValue) {
        T closestAnchor;
        DraggableAnchors<T> anchors = getAnchors();
        float positionOf = anchors.positionOf(currentValue);
        if (positionOf == offset || Float.isNaN(positionOf)) {
            return currentValue;
        }
        if (positionOf < offset) {
            closestAnchor = anchors.closestAnchor(offset, true);
            if (closestAnchor == null) {
                return currentValue;
            }
        } else {
            closestAnchor = anchors.closestAnchor(offset, false);
            if (closestAnchor == null) {
                return currentValue;
            }
        }
        return closestAnchor;
    }

    public final T getDragTarget() {
        return this.dragTarget.getValue();
    }

    private final void setAnchors(DraggableAnchors<T> draggableAnchors) {
        this.anchors.setValue(draggableAnchors);
    }

    public final void setCurrentValue(T t5) {
        this.currentValue.setValue(t5);
    }

    public final void setDragTarget(T t5) {
        this.dragTarget.setValue(t5);
    }

    public final void setLastVelocity(float f5) {
        this.lastVelocity.setFloatValue(f5);
    }

    public final void setOffset(float f5) {
        this.offset.setFloatValue(f5);
    }

    private final boolean trySnapTo(final T targetValue) {
        return this.dragMutex.tryMutate(new Function0<Unit>(this) { // from class: androidx.compose.material.AnchoredDraggableState$trySnapTo$1
            final /* synthetic */ AnchoredDraggableState<T> this$0;

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
                AnchoredDragScope anchoredDragScope;
                anchoredDragScope = ((AnchoredDraggableState) this.this$0).anchoredDragScope;
                AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                T t5 = targetValue;
                float positionOf = anchoredDraggableState.getAnchors().positionOf(t5);
                if (!Float.isNaN(positionOf)) {
                    AnchoredDragScope.dragTo$default(anchoredDragScope, positionOf, 0.0f, 2, null);
                    anchoredDraggableState.setDragTarget(null);
                }
                anchoredDraggableState.setCurrentValue(t5);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateAnchors$default(AnchoredDraggableState anchoredDraggableState, DraggableAnchors draggableAnchors, Object obj, int i5, Object obj2) {
        if ((i5 & 2) != 0) {
            if (Float.isNaN(anchoredDraggableState.getOffset())) {
                obj = anchoredDraggableState.getTargetValue();
            } else {
                obj = draggableAnchors.closestAnchor(anchoredDraggableState.getOffset());
                if (obj == null) {
                    obj = anchoredDraggableState.getTargetValue();
                }
            }
        }
        anchoredDraggableState.updateAnchors(draggableAnchors, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object anchoredDrag(MutatePriority mutatePriority, Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        AnchoredDraggableState$anchoredDrag$1 anchoredDraggableState$anchoredDrag$1;
        int i5;
        AnchoredDraggableState<T> anchoredDraggableState;
        T closestAnchor;
        T closestAnchor2;
        if (continuation instanceof AnchoredDraggableState$anchoredDrag$1) {
            anchoredDraggableState$anchoredDrag$1 = (AnchoredDraggableState$anchoredDrag$1) continuation;
            int i6 = anchoredDraggableState$anchoredDrag$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                anchoredDraggableState$anchoredDrag$1.label = i6 - Integer.MIN_VALUE;
                Object obj = anchoredDraggableState$anchoredDrag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = anchoredDraggableState$anchoredDrag$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        InternalMutatorMutex internalMutatorMutex = this.dragMutex;
                        AnchoredDraggableState$anchoredDrag$2 anchoredDraggableState$anchoredDrag$2 = new AnchoredDraggableState$anchoredDrag$2(this, function3, null);
                        anchoredDraggableState$anchoredDrag$1.L$0 = this;
                        anchoredDraggableState$anchoredDrag$1.label = 1;
                        if (internalMutatorMutex.mutate(mutatePriority, anchoredDraggableState$anchoredDrag$2, anchoredDraggableState$anchoredDrag$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        anchoredDraggableState = this;
                    } catch (Throwable th) {
                        th = th;
                        anchoredDraggableState = this;
                        closestAnchor = anchoredDraggableState.getAnchors().closestAnchor(anchoredDraggableState.getOffset());
                        if (closestAnchor != null && Math.abs(anchoredDraggableState.getOffset() - anchoredDraggableState.getAnchors().positionOf(closestAnchor)) <= 0.5f && anchoredDraggableState.confirmValueChange.invoke(closestAnchor).booleanValue()) {
                            anchoredDraggableState.setCurrentValue(closestAnchor);
                        }
                        throw th;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    anchoredDraggableState = (AnchoredDraggableState) anchoredDraggableState$anchoredDrag$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        closestAnchor = anchoredDraggableState.getAnchors().closestAnchor(anchoredDraggableState.getOffset());
                        if (closestAnchor != null) {
                            anchoredDraggableState.setCurrentValue(closestAnchor);
                        }
                        throw th;
                    }
                }
                closestAnchor2 = anchoredDraggableState.getAnchors().closestAnchor(anchoredDraggableState.getOffset());
                if (closestAnchor2 != null && Math.abs(anchoredDraggableState.getOffset() - anchoredDraggableState.getAnchors().positionOf(closestAnchor2)) <= 0.5f && anchoredDraggableState.confirmValueChange.invoke(closestAnchor2).booleanValue()) {
                    anchoredDraggableState.setCurrentValue(closestAnchor2);
                }
                return Unit.INSTANCE;
            }
        }
        anchoredDraggableState$anchoredDrag$1 = new AnchoredDraggableState$anchoredDrag$1(this, continuation);
        Object obj2 = anchoredDraggableState$anchoredDrag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = anchoredDraggableState$anchoredDrag$1.label;
        if (i5 != 0) {
        }
        closestAnchor2 = anchoredDraggableState.getAnchors().closestAnchor(anchoredDraggableState.getOffset());
        if (closestAnchor2 != null) {
            anchoredDraggableState.setCurrentValue(closestAnchor2);
        }
        return Unit.INSTANCE;
    }

    public final float dispatchRawDelta(float delta) {
        float newOffsetForDelta$material_release = newOffsetForDelta$material_release(delta);
        float offset = Float.isNaN(getOffset()) ? 0.0f : getOffset();
        setOffset(newOffsetForDelta$material_release);
        return newOffsetForDelta$material_release - offset;
    }

    public final DraggableAnchors<T> getAnchors() {
        return (DraggableAnchors) this.anchors.getValue();
    }

    public final AnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public final T getClosestValue$material_release() {
        return (T) this.closestValue.getValue();
    }

    public final Function1<T, Boolean> getConfirmValueChange$material_release() {
        return this.confirmValueChange;
    }

    public final T getCurrentValue() {
        return this.currentValue.getValue();
    }

    /* renamed from: getDraggableState$material_release, reason: from getter */
    public final DraggableState getDraggableState() {
        return this.draggableState;
    }

    public final float getLastVelocity() {
        return this.lastVelocity.getFloatValue();
    }

    public final float getOffset() {
        return this.offset.getFloatValue();
    }

    public final T getTargetValue() {
        return (T) this.targetValue.getValue();
    }

    public final boolean isAnimationRunning() {
        return getDragTarget() != null;
    }

    public final float newOffsetForDelta$material_release(float delta) {
        return RangesKt.coerceIn((Float.isNaN(getOffset()) ? 0.0f : getOffset()) + delta, getAnchors().minAnchor(), getAnchors().maxAnchor());
    }

    public final float requireOffset() {
        if (Float.isNaN(getOffset())) {
            throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?");
        }
        return getOffset();
    }

    public final Object settle(float f5, Continuation<? super Unit> continuation) {
        T currentValue = getCurrentValue();
        T computeTarget = computeTarget(requireOffset(), currentValue, f5);
        if (this.confirmValueChange.invoke(computeTarget).booleanValue()) {
            Object animateTo = AnchoredDraggableKt.animateTo(this, computeTarget, f5, continuation);
            return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
        }
        Object animateTo2 = AnchoredDraggableKt.animateTo(this, currentValue, f5, continuation);
        return animateTo2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo2 : Unit.INSTANCE;
    }

    public final void updateAnchors(DraggableAnchors<T> newAnchors, T newTarget) {
        if (Intrinsics.areEqual(getAnchors(), newAnchors)) {
            return;
        }
        setAnchors(newAnchors);
        if (trySnapTo(newTarget)) {
            return;
        }
        setDragTarget(newTarget);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object anchoredDrag(T t5, MutatePriority mutatePriority, Function4<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function4, Continuation<? super Unit> continuation) {
        AnchoredDraggableState$anchoredDrag$3 anchoredDraggableState$anchoredDrag$3;
        int i5;
        AnchoredDraggableState<T> anchoredDraggableState;
        T closestAnchor;
        T closestAnchor2;
        if (continuation instanceof AnchoredDraggableState$anchoredDrag$3) {
            anchoredDraggableState$anchoredDrag$3 = (AnchoredDraggableState$anchoredDrag$3) continuation;
            int i6 = anchoredDraggableState$anchoredDrag$3.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                anchoredDraggableState$anchoredDrag$3.label = i6 - Integer.MIN_VALUE;
                Object obj = anchoredDraggableState$anchoredDrag$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = anchoredDraggableState$anchoredDrag$3.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (getAnchors().hasAnchorFor(t5)) {
                        try {
                            InternalMutatorMutex internalMutatorMutex = this.dragMutex;
                            AnchoredDraggableState$anchoredDrag$4 anchoredDraggableState$anchoredDrag$4 = new AnchoredDraggableState$anchoredDrag$4(this, t5, function4, null);
                            anchoredDraggableState$anchoredDrag$3.L$0 = this;
                            anchoredDraggableState$anchoredDrag$3.label = 1;
                            if (internalMutatorMutex.mutate(mutatePriority, anchoredDraggableState$anchoredDrag$4, anchoredDraggableState$anchoredDrag$3) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            anchoredDraggableState = this;
                        } catch (Throwable th) {
                            th = th;
                            anchoredDraggableState = this;
                            anchoredDraggableState.setDragTarget(null);
                            closestAnchor = anchoredDraggableState.getAnchors().closestAnchor(anchoredDraggableState.getOffset());
                            if (closestAnchor != null) {
                                anchoredDraggableState.setCurrentValue(closestAnchor);
                            }
                            throw th;
                        }
                    } else {
                        setCurrentValue(t5);
                        return Unit.INSTANCE;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    anchoredDraggableState = (AnchoredDraggableState) anchoredDraggableState$anchoredDrag$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        anchoredDraggableState.setDragTarget(null);
                        closestAnchor = anchoredDraggableState.getAnchors().closestAnchor(anchoredDraggableState.getOffset());
                        if (closestAnchor != null && Math.abs(anchoredDraggableState.getOffset() - anchoredDraggableState.getAnchors().positionOf(closestAnchor)) <= 0.5f && anchoredDraggableState.confirmValueChange.invoke(closestAnchor).booleanValue()) {
                            anchoredDraggableState.setCurrentValue(closestAnchor);
                        }
                        throw th;
                    }
                }
                anchoredDraggableState.setDragTarget(null);
                closestAnchor2 = anchoredDraggableState.getAnchors().closestAnchor(anchoredDraggableState.getOffset());
                if (closestAnchor2 != null && Math.abs(anchoredDraggableState.getOffset() - anchoredDraggableState.getAnchors().positionOf(closestAnchor2)) <= 0.5f && anchoredDraggableState.confirmValueChange.invoke(closestAnchor2).booleanValue()) {
                    anchoredDraggableState.setCurrentValue(closestAnchor2);
                }
                return Unit.INSTANCE;
            }
        }
        anchoredDraggableState$anchoredDrag$3 = new AnchoredDraggableState$anchoredDrag$3(this, continuation);
        Object obj2 = anchoredDraggableState$anchoredDrag$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = anchoredDraggableState$anchoredDrag$3.label;
        if (i5 != 0) {
        }
        anchoredDraggableState.setDragTarget(null);
        closestAnchor2 = anchoredDraggableState.getAnchors().closestAnchor(anchoredDraggableState.getOffset());
        if (closestAnchor2 != null) {
            anchoredDraggableState.setCurrentValue(closestAnchor2);
        }
        return Unit.INSTANCE;
    }
}
