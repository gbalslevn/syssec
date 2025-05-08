package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", BuildConfig.FLAVOR, "Landroidx/compose/animation/core/AnimationVector1D;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1", f = "SnapFlingBehavior.kt", l = {142, 161}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SnapFlingBehavior$fling$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AnimationResult<Float, AnimationVector1D>>, Object> {
    final /* synthetic */ float $initialVelocity;
    final /* synthetic */ Function1<Float, Unit> $onRemainingScrollOffsetUpdate;
    final /* synthetic */ ScrollScope $this_fling;
    Object L$0;
    int label;
    final /* synthetic */ SnapFlingBehavior this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SnapFlingBehavior$fling$result$1(SnapFlingBehavior snapFlingBehavior, float f5, Function1<? super Float, Unit> function1, ScrollScope scrollScope, Continuation<? super SnapFlingBehavior$fling$result$1> continuation) {
        super(2, continuation);
        this.this$0 = snapFlingBehavior;
        this.$initialVelocity = f5;
        this.$onRemainingScrollOffsetUpdate = function1;
        this.$this_fling = scrollScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SnapFlingBehavior$fling$result$1(this.this$0, this.$initialVelocity, this.$onRemainingScrollOffsetUpdate, this.$this_fling, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DecayAnimationSpec decayAnimationSpec;
        SnapLayoutInfoProvider snapLayoutInfoProvider;
        final Ref$FloatRef ref$FloatRef;
        SnapLayoutInfoProvider snapLayoutInfoProvider2;
        AnimationSpec animationSpec;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            decayAnimationSpec = this.this$0.decayAnimationSpec;
            float calculateTargetValue = DecayAnimationSpecKt.calculateTargetValue(decayAnimationSpec, 0.0f, this.$initialVelocity);
            snapLayoutInfoProvider = this.this$0.snapLayoutInfoProvider;
            float calculateApproachOffset = snapLayoutInfoProvider.calculateApproachOffset(this.$initialVelocity, calculateTargetValue);
            if (Float.isNaN(calculateApproachOffset)) {
                throw new IllegalStateException("calculateApproachOffset returned NaN. Please use a valid value.");
            }
            ref$FloatRef = new Ref$FloatRef();
            float abs = Math.abs(calculateApproachOffset) * Math.signum(this.$initialVelocity);
            ref$FloatRef.element = abs;
            this.$onRemainingScrollOffsetUpdate.invoke(Boxing.boxFloat(abs));
            SnapFlingBehavior snapFlingBehavior = this.this$0;
            ScrollScope scrollScope = this.$this_fling;
            float f5 = ref$FloatRef.element;
            float f6 = this.$initialVelocity;
            final Function1<Float, Unit> function1 = this.$onRemainingScrollOffsetUpdate;
            Function1<Float, Unit> function12 = new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1$animationState$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f7) {
                    invoke(f7.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f7) {
                    Ref$FloatRef ref$FloatRef2 = Ref$FloatRef.this;
                    float f8 = ref$FloatRef2.element - f7;
                    ref$FloatRef2.element = f8;
                    function1.invoke(Float.valueOf(f8));
                }
            };
            this.L$0 = ref$FloatRef;
            this.label = 1;
            obj = snapFlingBehavior.tryApproach(scrollScope, f5, f6, function12, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 == 2) {
                    ResultKt.throwOnFailure(obj);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$FloatRef = (Ref$FloatRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        AnimationState animationState = (AnimationState) obj;
        snapLayoutInfoProvider2 = this.this$0.snapLayoutInfoProvider;
        float calculateSnapOffset = snapLayoutInfoProvider2.calculateSnapOffset(((Number) animationState.getVelocity()).floatValue());
        if (Float.isNaN(calculateSnapOffset)) {
            throw new IllegalStateException("calculateSnapOffset returned NaN. Please use a valid value.");
        }
        ref$FloatRef.element = calculateSnapOffset;
        ScrollScope scrollScope2 = this.$this_fling;
        AnimationState copy$default = AnimationStateKt.copy$default(animationState, 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
        animationSpec = this.this$0.snapAnimationSpec;
        final Function1<Float, Unit> function13 = this.$onRemainingScrollOffsetUpdate;
        Function1<Float, Unit> function14 = new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f7) {
                invoke(f7.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f7) {
                Ref$FloatRef ref$FloatRef2 = Ref$FloatRef.this;
                float f8 = ref$FloatRef2.element - f7;
                ref$FloatRef2.element = f8;
                function13.invoke(Float.valueOf(f8));
            }
        };
        this.L$0 = null;
        this.label = 2;
        obj = SnapFlingBehaviorKt.animateWithTarget(scrollScope2, calculateSnapOffset, calculateSnapOffset, copy$default, animationSpec, function14, this);
        return obj == coroutine_suspended ? coroutine_suspended : obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        return ((SnapFlingBehavior$fling$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
