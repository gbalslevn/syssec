package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u001a!\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a¥\u0001\u0010\u001a\u001a\u00020\t*\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2*\b\u0002\u0010\u0017\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00122*\b\u0002\u0010\u0018\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00122\b\b\u0002\u0010\u0019\u001a\u00020\rH\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001e\u0010\u001e\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\f\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001e\u0010\u001e\u001a\u00020\u0001*\u00020\u001f2\u0006\u0010\f\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010\u001d\u001a\u0016\u0010#\u001a\u00020\u001f*\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\"6\u0010$\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%\"6\u0010&\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010%\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "onDelta", "Landroidx/compose/foundation/gestures/DraggableState;", "DraggableState", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/gestures/DraggableState;", "rememberDraggableState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/DraggableState;", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", BuildConfig.FLAVOR, "enabled", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "startDragImmediately", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "onDragStarted", "onDragStopped", "reverseDirection", "draggable", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/DraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "toFloat-3MmeM6k", "(JLandroidx/compose/foundation/gestures/Orientation;)F", "toFloat", "Landroidx/compose/ui/unit/Velocity;", "toFloat-sF-c-tU", "toValidVelocity-TH1AsA0", "(J)J", "toValidVelocity", "NoOpOnDragStarted", "Lkotlin/jvm/functions/Function3;", "NoOpOnDragStopped", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DraggableKt {
    private static final Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> NoOpOnDragStarted = new DraggableKt$NoOpOnDragStarted$1(null);
    private static final Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> NoOpOnDragStopped = new DraggableKt$NoOpOnDragStopped$1(null);

    public static final DraggableState DraggableState(Function1<? super Float, Unit> function1) {
        return new DefaultDraggableState(function1);
    }

    public static final Modifier draggable(Modifier modifier, DraggableState draggableState, Orientation orientation, boolean z5, MutableInteractionSource mutableInteractionSource, boolean z6, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> function32, boolean z7) {
        return modifier.then(new DraggableElement(draggableState, orientation, z5, mutableInteractionSource, z6, function3, function32, z7));
    }

    public static final DraggableState rememberDraggableState(Function1<? super Float, Unit> function1, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-183245213, i5, -1, "androidx.compose.foundation.gestures.rememberDraggableState (Draggable.kt:135)");
        }
        final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer, i5 & 14);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = DraggableState(new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.DraggableKt$rememberDraggableState$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f5) {
                    invoke(f5.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f5) {
                    rememberUpdatedState.getValue().invoke(Float.valueOf(f5));
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        DraggableState draggableState = (DraggableState) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return draggableState;
    }

    /* renamed from: toFloat-3MmeM6k */
    public static final float m196toFloat3MmeM6k(long j5, Orientation orientation) {
        return orientation == Orientation.Vertical ? Offset.m1338getYimpl(j5) : Offset.m1337getXimpl(j5);
    }

    /* renamed from: toFloat-sF-c-tU */
    public static final float m197toFloatsFctU(long j5, Orientation orientation) {
        return orientation == Orientation.Vertical ? Velocity.m2702getYimpl(j5) : Velocity.m2701getXimpl(j5);
    }

    /* renamed from: toValidVelocity-TH1AsA0 */
    public static final long m198toValidVelocityTH1AsA0(long j5) {
        return VelocityKt.Velocity(Float.isNaN(Velocity.m2701getXimpl(j5)) ? 0.0f : Velocity.m2701getXimpl(j5), Float.isNaN(Velocity.m2702getYimpl(j5)) ? 0.0f : Velocity.m2702getYimpl(j5));
    }
}
