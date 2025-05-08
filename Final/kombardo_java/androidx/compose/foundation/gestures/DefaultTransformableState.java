package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScopeKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bJ<\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011R/\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/gestures/DefaultTransformableState;", "Landroidx/compose/foundation/gestures/TransformableState;", "Lkotlin/Function3;", BuildConfig.FLAVOR, "Landroidx/compose/ui/geometry/Offset;", BuildConfig.FLAVOR, "onTransformation", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "Landroidx/compose/foundation/MutatePriority;", "transformPriority", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/TransformScope;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "block", "transform", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/jvm/functions/Function3;", "getOnTransformation", "()Lkotlin/jvm/functions/Function3;", "transformScope", "Landroidx/compose/foundation/gestures/TransformScope;", "Landroidx/compose/foundation/MutatorMutex;", "transformMutex", "Landroidx/compose/foundation/MutatorMutex;", "Landroidx/compose/runtime/MutableState;", BuildConfig.FLAVOR, "isTransformingState", "Landroidx/compose/runtime/MutableState;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DefaultTransformableState implements TransformableState {
    private final MutableState<Boolean> isTransformingState;
    private final Function3<Float, Offset, Float, Unit> onTransformation;
    private final TransformScope transformScope = new TransformScope() { // from class: androidx.compose.foundation.gestures.DefaultTransformableState$transformScope$1
        @Override // androidx.compose.foundation.gestures.TransformScope
        /* renamed from: transformBy-d-4ec7I, reason: not valid java name */
        public void mo178transformByd4ec7I(float zoomChange, long panChange, float rotationChange) {
            DefaultTransformableState.this.getOnTransformation().invoke(Float.valueOf(zoomChange), Offset.m1328boximpl(panChange), Float.valueOf(rotationChange));
        }
    };
    private final MutatorMutex transformMutex = new MutatorMutex();

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultTransformableState(Function3<? super Float, ? super Offset, ? super Float, Unit> function3) {
        MutableState<Boolean> mutableStateOf$default;
        this.onTransformation = function3;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.isTransformingState = mutableStateOf$default;
    }

    public final Function3<Float, Offset, Float, Unit> getOnTransformation() {
        return this.onTransformation;
    }

    @Override // androidx.compose.foundation.gestures.TransformableState
    public Object transform(MutatePriority mutatePriority, Function2<? super TransformScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new DefaultTransformableState$transform$2(this, mutatePriority, function2, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }
}
