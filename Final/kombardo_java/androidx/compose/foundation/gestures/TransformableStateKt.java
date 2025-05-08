package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$LongRef;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a-\u0010\u0006\u001a\u00020\u00052\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a/\u0010\b\u001a\u00020\u00052\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0000H\u0007¢\u0006\u0004\b\b\u0010\t\u001a/\u0010\u000f\u001a\u00020\u0003*\u00020\u00052\u0006\u0010\n\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"Lkotlin/Function3;", BuildConfig.FLAVOR, "Landroidx/compose/ui/geometry/Offset;", BuildConfig.FLAVOR, "onTransformation", "Landroidx/compose/foundation/gestures/TransformableState;", "TransformableState", "(Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/gestures/TransformableState;", "rememberTransformableState", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TransformableState;", "offset", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "animatePanBy-ubNVwUQ", "(Landroidx/compose/foundation/gestures/TransformableState;JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animatePanBy", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TransformableStateKt {
    public static final TransformableState TransformableState(Function3<? super Float, ? super Offset, ? super Float, Unit> function3) {
        return new DefaultTransformableState(function3);
    }

    /* renamed from: animatePanBy-ubNVwUQ, reason: not valid java name */
    public static final Object m248animatePanByubNVwUQ(TransformableState transformableState, long j5, AnimationSpec<Offset> animationSpec, Continuation<? super Unit> continuation) {
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = Offset.INSTANCE.m1349getZeroF1C5BW0();
        Object transform$default = TransformableState.transform$default(transformableState, null, new TransformableStateKt$animatePanBy$2(ref$LongRef, j5, animationSpec, null), continuation, 1, null);
        return transform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? transform$default : Unit.INSTANCE;
    }

    /* renamed from: animatePanBy-ubNVwUQ$default, reason: not valid java name */
    public static /* synthetic */ Object m249animatePanByubNVwUQ$default(TransformableState transformableState, long j5, AnimationSpec animationSpec, Continuation continuation, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return m248animatePanByubNVwUQ(transformableState, j5, animationSpec, continuation);
    }

    public static final TransformableState rememberTransformableState(Function3<? super Float, ? super Offset, ? super Float, Unit> function3, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1681419281, i5, -1, "androidx.compose.foundation.gestures.rememberTransformableState (TransformableState.kt:116)");
        }
        final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function3, composer, i5 & 14);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = TransformableState(new Function3<Float, Offset, Float, Unit>() { // from class: androidx.compose.foundation.gestures.TransformableStateKt$rememberTransformableState$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Float f5, Offset offset, Float f6) {
                    m250invoked4ec7I(f5.floatValue(), offset.getPackedValue(), f6.floatValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-d-4ec7I, reason: not valid java name */
                public final void m250invoked4ec7I(float f5, long j5, float f6) {
                    rememberUpdatedState.getValue().invoke(Float.valueOf(f5), Offset.m1328boximpl(j5), Float.valueOf(f6));
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        TransformableState transformableState = (TransformableState) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transformableState;
    }
}
