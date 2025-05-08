package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0080@¢\u0006\u0004\b\u0005\u0010\u0006\u001a8\u0010\f\u001a\u00020\u0004*\u00020\u00072\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0086@¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", BuildConfig.FLAVOR, "allPointersUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;)Z", BuildConfig.FLAVOR, "awaitAllPointersUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "block", "awaitEachGesture", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ForEachGestureKt {
    public static final boolean allPointersUp(AwaitPointerEventScope awaitPointerEventScope) {
        List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
        int size = changes.size();
        boolean z5 = false;
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                break;
            }
            if (changes.get(i5).getPressed()) {
                z5 = true;
                break;
            }
            i5++;
        }
        return !z5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x003c, code lost:
    
        if (allPointersUp(r6) == false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0048 -> B:10:0x004b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitAllPointersUp(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        ForEachGestureKt$awaitAllPointersUp$3 forEachGestureKt$awaitAllPointersUp$3;
        int i5;
        if (continuation instanceof ForEachGestureKt$awaitAllPointersUp$3) {
            forEachGestureKt$awaitAllPointersUp$3 = (ForEachGestureKt$awaitAllPointersUp$3) continuation;
            int i6 = forEachGestureKt$awaitAllPointersUp$3.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                forEachGestureKt$awaitAllPointersUp$3.label = i6 - Integer.MIN_VALUE;
                Object obj = forEachGestureKt$awaitAllPointersUp$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = forEachGestureKt$awaitAllPointersUp$3.label;
                if (i5 == 0) {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    awaitPointerEventScope = (AwaitPointerEventScope) forEachGestureKt$awaitAllPointersUp$3.L$0;
                    ResultKt.throwOnFailure(obj);
                    List<PointerInputChange> changes = ((PointerEvent) obj).getChanges();
                    int size = changes.size();
                    int i7 = 0;
                    while (i7 < size) {
                        if (changes.get(i7).getPressed()) {
                            PointerEventPass pointerEventPass = PointerEventPass.Final;
                            forEachGestureKt$awaitAllPointersUp$3.L$0 = awaitPointerEventScope;
                            forEachGestureKt$awaitAllPointersUp$3.label = 1;
                            obj = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, forEachGestureKt$awaitAllPointersUp$3);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            List<PointerInputChange> changes2 = ((PointerEvent) obj).getChanges();
                            int size2 = changes2.size();
                            int i72 = 0;
                            while (i72 < size2) {
                            }
                        } else {
                            i72++;
                        }
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
        }
        forEachGestureKt$awaitAllPointersUp$3 = new ForEachGestureKt$awaitAllPointersUp$3(continuation);
        Object obj2 = forEachGestureKt$awaitAllPointersUp$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = forEachGestureKt$awaitAllPointersUp$3.label;
        if (i5 == 0) {
        }
    }

    public static final Object awaitEachGesture(PointerInputScope pointerInputScope, Function2<? super AwaitPointerEventScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object awaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new ForEachGestureKt$awaitEachGesture$2(continuation.getContext(), function2, null), continuation);
        return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
    }
}
