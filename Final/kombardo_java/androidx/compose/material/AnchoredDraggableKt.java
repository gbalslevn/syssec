package androidx.compose.material;

import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a9\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0001¢\u0006\u0004\b\u0007\u0010\b\u001aY\u0010\u0014\u001a\u00020\t\"\u0004\b\u0000\u0010\u0001*\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a2\u0010\u0019\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0016\u001a\u00028\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0081@¢\u0006\u0004\b\u0019\u0010\u001a\u001aH\u0010!\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\"\u0010 \u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u001eH\u0082@¢\u0006\u0004\b!\u0010\"\u001a\u001b\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#\"\u0004\b\u0000\u0010\u0001H\u0002¢\u0006\u0004\b$\u0010%\u001a[\u0010*\u001a\u00020\t\"\u0004\b\u0000\u0010\u0001*\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\r\u001a\u00020\f2*\u0010)\u001a&\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00028\u00000(0\u001eH\u0001¢\u0006\u0004\b*\u0010+¨\u0006,"}, d2 = {BuildConfig.FLAVOR, "T", "Lkotlin/Function1;", "Landroidx/compose/material/DraggableAnchorsConfig;", BuildConfig.FLAVOR, "builder", "Landroidx/compose/material/DraggableAnchors;", "DraggableAnchors", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/material/DraggableAnchors;", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/material/AnchoredDraggableState;", "state", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", BuildConfig.FLAVOR, "enabled", "reverseDirection", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "startDragImmediately", "anchoredDraggable", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Z)Landroidx/compose/ui/Modifier;", "targetValue", BuildConfig.FLAVOR, "velocity", "animateTo", "(Landroidx/compose/material/AnchoredDraggableState;Ljava/lang/Object;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "I", "Lkotlin/Function0;", "inputs", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "block", "restartable", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/material/MapDraggableAnchors;", "emptyDraggableAnchors", "()Landroidx/compose/material/MapDraggableAnchors;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/Constraints;", "Lkotlin/Pair;", "anchors", "draggableAnchors", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/Modifier;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AnchoredDraggableKt {
    public static final <T> DraggableAnchors<T> DraggableAnchors(Function1<? super DraggableAnchorsConfig<T>, Unit> function1) {
        DraggableAnchorsConfig draggableAnchorsConfig = new DraggableAnchorsConfig();
        function1.invoke(draggableAnchorsConfig);
        return new MapDraggableAnchors(draggableAnchorsConfig.getAnchors$material_release());
    }

    public static final <T> Modifier anchoredDraggable(Modifier modifier, AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, boolean z5, boolean z6, MutableInteractionSource mutableInteractionSource, boolean z7) {
        return DraggableKt.draggable$default(modifier, anchoredDraggableState.getDraggableState(), orientation, z5, mutableInteractionSource, z7, null, new AnchoredDraggableKt$anchoredDraggable$1(anchoredDraggableState, null), z6, 32, null);
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier modifier, AnchoredDraggableState anchoredDraggableState, Orientation orientation, boolean z5, boolean z6, MutableInteractionSource mutableInteractionSource, boolean z7, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            z5 = true;
        }
        boolean z8 = z5;
        if ((i5 & 8) != 0) {
            z6 = false;
        }
        boolean z9 = z6;
        if ((i5 & 16) != 0) {
            mutableInteractionSource = null;
        }
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        if ((i5 & 32) != 0) {
            z7 = anchoredDraggableState.isAnimationRunning();
        }
        return anchoredDraggable(modifier, anchoredDraggableState, orientation, z8, z9, mutableInteractionSource2, z7);
    }

    public static final <T> Object animateTo(AnchoredDraggableState<T> anchoredDraggableState, T t5, float f5, Continuation<? super Unit> continuation) {
        Object anchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t5, null, new AnchoredDraggableKt$animateTo$2(anchoredDraggableState, f5, null), continuation, 2, null);
        return anchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? anchoredDrag$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(AnchoredDraggableState anchoredDraggableState, Object obj, float f5, Continuation continuation, int i5, Object obj2) {
        if ((i5 & 2) != 0) {
            f5 = anchoredDraggableState.getLastVelocity();
        }
        return animateTo(anchoredDraggableState, obj, f5, continuation);
    }

    public static final <T> Modifier draggableAnchors(Modifier modifier, AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, Function2<? super IntSize, ? super Constraints, ? extends Pair<? extends DraggableAnchors<T>, ? extends T>> function2) {
        return modifier.then(new DraggableAnchorsElement(anchoredDraggableState, function2, orientation));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> MapDraggableAnchors<T> emptyDraggableAnchors() {
        return new MapDraggableAnchors<>(MapsKt.emptyMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(1:21))|11|12|13))|23|6|7|(0)(0)|11|12|13) */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <I> Object restartable(Function0<? extends I> function0, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        AnchoredDraggableKt$restartable$1 anchoredDraggableKt$restartable$1;
        int i5;
        if (continuation instanceof AnchoredDraggableKt$restartable$1) {
            anchoredDraggableKt$restartable$1 = (AnchoredDraggableKt$restartable$1) continuation;
            int i6 = anchoredDraggableKt$restartable$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                anchoredDraggableKt$restartable$1.label = i6 - Integer.MIN_VALUE;
                Object obj = anchoredDraggableKt$restartable$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = anchoredDraggableKt$restartable$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    AnchoredDraggableKt$restartable$2 anchoredDraggableKt$restartable$2 = new AnchoredDraggableKt$restartable$2(function0, function2, null);
                    anchoredDraggableKt$restartable$1.label = 1;
                    if (CoroutineScopeKt.coroutineScope(anchoredDraggableKt$restartable$2, anchoredDraggableKt$restartable$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
        anchoredDraggableKt$restartable$1 = new AnchoredDraggableKt$restartable$1(continuation);
        Object obj2 = anchoredDraggableKt$restartable$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = anchoredDraggableKt$restartable$1.label;
        if (i5 != 0) {
        }
        return Unit.INSTANCE;
    }
}
