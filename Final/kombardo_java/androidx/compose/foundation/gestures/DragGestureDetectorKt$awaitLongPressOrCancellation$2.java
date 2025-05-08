package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
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
import kotlin.jvm.internal.Ref$ObjectRef;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2", f = "DragGestureDetector.kt", l = {901, 918}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DragGestureDetectorKt$awaitLongPressOrCancellation$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref$ObjectRef<PointerInputChange> $currentDown;
    final /* synthetic */ Ref$ObjectRef<PointerInputChange> $longPress;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragGestureDetectorKt$awaitLongPressOrCancellation$2(Ref$ObjectRef<PointerInputChange> ref$ObjectRef, Ref$ObjectRef<PointerInputChange> ref$ObjectRef2, Continuation<? super DragGestureDetectorKt$awaitLongPressOrCancellation$2> continuation) {
        super(2, continuation);
        this.$currentDown = ref$ObjectRef;
        this.$longPress = ref$ObjectRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$2 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(this.$currentDown, this.$longPress, continuation);
        dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$0 = obj;
        return dragGestureDetectorKt$awaitLongPressOrCancellation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$awaitLongPressOrCancellation$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x009a, code lost:
    
        r2 = r6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ab A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x006f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cd A[EDGE_INSN: B:67:0x00cd->B:13:0x00cd BREAK  A[LOOP:0: B:7:0x00ba->B:10:0x00ca], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00bc  */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v7, types: [androidx.compose.ui.input.pointer.PointerInputChange, T] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00ac -> B:6:0x00af). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AwaitPointerEventScope awaitPointerEventScope;
        int i5;
        Object obj2;
        int size;
        int i6;
        int size2;
        int i7;
        Object awaitPointerEvent;
        boolean m186isPointerUpDmW0f2w;
        T t5;
        PointerInputChange pointerInputChange;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        Object obj3 = null;
        int i9 = 1;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            i5 = 0;
            if (i5 != 0) {
            }
        } else if (i8 == 1) {
            i5 = this.I$0;
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
            PointerEvent pointerEvent = (PointerEvent) obj2;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            i6 = 0;
            while (true) {
                if (i6 >= size) {
                }
                i6++;
            }
            List<PointerInputChange> changes2 = pointerEvent.getChanges();
            size2 = changes2.size();
            while (i7 < size2) {
            }
            PointerEventPass pointerEventPass = PointerEventPass.Final;
            this.L$0 = awaitPointerEventScope;
            this.L$1 = pointerEvent;
            this.I$0 = i5;
            this.label = 2;
            awaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, this);
            if (awaitPointerEvent != coroutine_suspended) {
            }
        } else {
            if (i8 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i5 = this.I$0;
            PointerEvent pointerEvent2 = (PointerEvent) this.L$1;
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            awaitPointerEvent = obj;
            List<PointerInputChange> changes3 = ((PointerEvent) awaitPointerEvent).getChanges();
            int size3 = changes3.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size3) {
                    break;
                }
                if (changes3.get(i10).isConsumed()) {
                    i5 = i9;
                    break;
                }
                i10++;
            }
            m186isPointerUpDmW0f2w = DragGestureDetectorKt.m186isPointerUpDmW0f2w(pointerEvent2, this.$currentDown.element.getId());
            if (!m186isPointerUpDmW0f2w) {
                List<PointerInputChange> changes4 = pointerEvent2.getChanges();
                int size4 = changes4.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size4) {
                        pointerInputChange = null;
                        break;
                    }
                    pointerInputChange = changes4.get(i11);
                    if (pointerInputChange.getPressed()) {
                        break;
                    }
                    i11++;
                }
                PointerInputChange pointerInputChange2 = pointerInputChange;
                if (pointerInputChange2 != 0) {
                    this.$currentDown.element = pointerInputChange2;
                    this.$longPress.element = pointerInputChange2;
                } else {
                    i5 = i9;
                    awaitPointerEventScope = awaitPointerEventScope2;
                    obj3 = null;
                    if (i5 != 0) {
                        return Unit.INSTANCE;
                    }
                    PointerEventPass pointerEventPass2 = PointerEventPass.Main;
                    this.L$0 = awaitPointerEventScope;
                    this.L$1 = obj3;
                    this.I$0 = i5;
                    this.label = i9;
                    obj2 = awaitPointerEventScope.awaitPointerEvent(pointerEventPass2, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    PointerEvent pointerEvent3 = (PointerEvent) obj2;
                    List<PointerInputChange> changes5 = pointerEvent3.getChanges();
                    size = changes5.size();
                    i6 = 0;
                    while (true) {
                        if (i6 >= size) {
                            i5 = i9;
                            break;
                        }
                        if (!PointerEventKt.changedToUpIgnoreConsumed(changes5.get(i6))) {
                            break;
                        }
                        i6++;
                    }
                    List<PointerInputChange> changes22 = pointerEvent3.getChanges();
                    size2 = changes22.size();
                    for (i7 = 0; i7 < size2; i7++) {
                        PointerInputChange pointerInputChange3 = changes22.get(i7);
                        if (pointerInputChange3.isConsumed() || PointerEventKt.m1857isOutOfBoundsjwHxaWs(pointerInputChange3, awaitPointerEventScope.mo1844getSizeYbymL2g(), awaitPointerEventScope.mo1843getExtendedTouchPaddingNHjbRc())) {
                            break;
                        }
                    }
                    PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                    this.L$0 = awaitPointerEventScope;
                    this.L$1 = pointerEvent3;
                    this.I$0 = i5;
                    this.label = 2;
                    awaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(pointerEventPass3, this);
                    if (awaitPointerEvent != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    pointerEvent2 = pointerEvent3;
                    List<PointerInputChange> changes32 = ((PointerEvent) awaitPointerEvent).getChanges();
                    int size32 = changes32.size();
                    int i102 = 0;
                    while (true) {
                        if (i102 >= size32) {
                        }
                        i102++;
                    }
                    m186isPointerUpDmW0f2w = DragGestureDetectorKt.m186isPointerUpDmW0f2w(pointerEvent2, this.$currentDown.element.getId());
                    if (!m186isPointerUpDmW0f2w) {
                        Ref$ObjectRef<PointerInputChange> ref$ObjectRef = this.$longPress;
                        List<PointerInputChange> changes6 = pointerEvent2.getChanges();
                        Ref$ObjectRef<PointerInputChange> ref$ObjectRef2 = this.$currentDown;
                        int size5 = changes6.size();
                        int i12 = 0;
                        while (true) {
                            if (i12 >= size5) {
                                t5 = 0;
                                break;
                            }
                            t5 = changes6.get(i12);
                            Ref$ObjectRef<PointerInputChange> ref$ObjectRef3 = ref$ObjectRef2;
                            if (PointerId.m1872equalsimpl0(((PointerInputChange) t5).getId(), ref$ObjectRef2.element.getId())) {
                                break;
                            }
                            i12++;
                            ref$ObjectRef2 = ref$ObjectRef3;
                        }
                        ref$ObjectRef.element = t5;
                    }
                }
            }
            awaitPointerEventScope = awaitPointerEventScope2;
            obj3 = null;
            i9 = 1;
            if (i5 != 0) {
            }
        }
    }
}
