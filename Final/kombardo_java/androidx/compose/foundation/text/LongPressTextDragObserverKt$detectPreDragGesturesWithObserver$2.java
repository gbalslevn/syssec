package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2", f = "LongPressTextDragObserver.kt", l = {99, 103}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextDragObserver $observer;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2(TextDragObserver textDragObserver, Continuation<? super LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2> continuation) {
        super(2, continuation);
        this.$observer = textDragObserver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2 longPressTextDragObserverKt$detectPreDragGesturesWithObserver$2 = new LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2(this.$observer, continuation);
        longPressTextDragObserverKt$detectPreDragGesturesWithObserver$2.L$0 = obj;
        return longPressTextDragObserverKt$detectPreDragGesturesWithObserver$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x006b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x005b -> B:6:0x005e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AwaitPointerEventScope awaitPointerEventScope;
        AwaitPointerEventScope awaitPointerEventScope2;
        PointerInputChange pointerInputChange;
        int size;
        int i5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = this.label;
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj);
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            this.L$0 = awaitPointerEventScope;
            this.label = 1;
            obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, this, 2, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i6 != 1) {
                if (i6 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pointerInputChange = (PointerInputChange) this.L$1;
                awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                List<PointerInputChange> changes = ((PointerEvent) obj).getChanges();
                size = changes.size();
                i5 = 0;
                while (i5 < size) {
                    PointerInputChange pointerInputChange2 = changes.get(i5);
                    if (PointerId.m1872equalsimpl0(pointerInputChange2.getId(), pointerInputChange.getId()) && pointerInputChange2.getPressed()) {
                        this.L$0 = awaitPointerEventScope2;
                        this.L$1 = pointerInputChange;
                        this.label = 2;
                        obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, this, 1, null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        List<PointerInputChange> changes2 = ((PointerEvent) obj).getChanges();
                        size = changes2.size();
                        i5 = 0;
                        while (i5 < size) {
                        }
                    } else {
                        i5++;
                    }
                }
                this.$observer.onUp();
                return Unit.INSTANCE;
            }
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        PointerInputChange pointerInputChange3 = (PointerInputChange) obj;
        this.$observer.mo525onDownk4lQ0M(pointerInputChange3.getPosition());
        awaitPointerEventScope2 = awaitPointerEventScope;
        pointerInputChange = pointerInputChange3;
        this.L$0 = awaitPointerEventScope2;
        this.L$1 = pointerInputChange;
        this.label = 2;
        obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, this, 1, null);
        if (obj == coroutine_suspended) {
        }
        List<PointerInputChange> changes22 = ((PointerEvent) obj).getChanges();
        size = changes22.size();
        i5 = 0;
        while (i5 < size) {
        }
        this.$observer.onUp();
        return Unit.INSTANCE;
    }
}
