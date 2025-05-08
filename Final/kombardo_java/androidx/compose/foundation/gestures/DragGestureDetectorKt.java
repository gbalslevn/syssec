package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a3\u0010\n\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a!\u0010\r\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001ad\u0010\u0015\u001a\u00020\u0005*\u00020\u000e2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u00032\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u0014H\u0086@¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0088\u0001\u0010\u0015\u001a\u00020\u0005*\u00020\u000e2\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u00172\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u0014H\u0080@¢\u0006\u0004\b\u0015\u0010\u001b\u001a!\u0010\u001d\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\f\u001a\u001e\u0010!\u001a\u00020\u0007*\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u001e\u0010(\u001a\u00020%*\u00020\"2\u0006\u0010$\u001a\u00020#H\u0000ø\u0001\u0000¢\u0006\u0004\b&\u0010'\"\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+\"\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010+\"\u0014\u0010-\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010+\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerId", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", BuildConfig.FLAVOR, "onDrag", BuildConfig.FLAVOR, "drag-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "drag", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Landroidx/compose/ui/geometry/Offset;", "onDragStart", "Lkotlin/Function0;", "onDragEnd", "onDragCancel", "Lkotlin/Function2;", "detectDragGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function3;", "shouldAwaitTouchSlop", "Landroidx/compose/foundation/gestures/Orientation;", "orientationLock", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLongPressOrCancellation-rnUCldI", "awaitLongPressOrCancellation", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "isPointerUp", "Landroidx/compose/ui/platform/ViewConfiguration;", "Landroidx/compose/ui/input/pointer/PointerType;", "pointerType", BuildConfig.FLAVOR, "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "pointerSlop", "Landroidx/compose/ui/unit/Dp;", "mouseSlop", "F", "defaultTouchSlop", "mouseToTouchSlopRatio", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DragGestureDetectorKt {
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    static {
        float m2599constructorimpl = Dp.m2599constructorimpl((float) 0.125d);
        mouseSlop = m2599constructorimpl;
        float m2599constructorimpl2 = Dp.m2599constructorimpl(18);
        defaultTouchSlop = m2599constructorimpl2;
        mouseToTouchSlopRatio = m2599constructorimpl / m2599constructorimpl2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ca, code lost:
    
        if (androidx.compose.ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r11) != false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0067 -> B:10:0x006c). Please report as a decompilation issue!!! */
    /* renamed from: awaitDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m183awaitDragOrCancellationrnUCldI(AwaitPointerEventScope awaitPointerEventScope, long j5, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitDragOrCancellation$1 dragGestureDetectorKt$awaitDragOrCancellation$1;
        int i5;
        Ref$LongRef ref$LongRef;
        AwaitPointerEventScope awaitPointerEventScope2;
        Object awaitPointerEvent$default;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$awaitDragOrCancellation$1) {
            dragGestureDetectorKt$awaitDragOrCancellation$1 = (DragGestureDetectorKt$awaitDragOrCancellation$1) continuation;
            int i6 = dragGestureDetectorKt$awaitDragOrCancellation$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitDragOrCancellation$1.label = i6 - Integer.MIN_VALUE;
                Object obj = dragGestureDetectorKt$awaitDragOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = dragGestureDetectorKt$awaitDragOrCancellation$1.label;
                if (i5 == 0) {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Ref$LongRef ref$LongRef2 = (Ref$LongRef) dragGestureDetectorKt$awaitDragOrCancellation$1.L$1;
                    AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitDragOrCancellation$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    Ref$LongRef ref$LongRef3 = ref$LongRef2;
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    PointerEvent pointerEvent = (PointerEvent) obj;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    int size = changes.size();
                    int i7 = 0;
                    int i8 = 0;
                    while (true) {
                        if (i8 < size) {
                            pointerInputChange = null;
                            break;
                        }
                        pointerInputChange = changes.get(i8);
                        if (PointerId.m1872equalsimpl0(pointerInputChange.getId(), ref$LongRef3.element)) {
                            break;
                        }
                        i8++;
                    }
                    PointerInputChange pointerInputChange3 = pointerInputChange;
                    if (pointerInputChange3 == null) {
                        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            int size2 = changes2.size();
                            while (true) {
                                if (i7 >= size2) {
                                    pointerInputChange2 = null;
                                    break;
                                }
                                pointerInputChange2 = changes2.get(i7);
                                if (pointerInputChange2.getPressed()) {
                                    break;
                                }
                                i7++;
                            }
                            PointerInputChange pointerInputChange4 = pointerInputChange2;
                            if (pointerInputChange4 != null) {
                                ref$LongRef3.element = pointerInputChange4.getId();
                                ref$LongRef = ref$LongRef3;
                            }
                        }
                        dragGestureDetectorKt$awaitDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                        dragGestureDetectorKt$awaitDragOrCancellation$1.L$1 = ref$LongRef;
                        dragGestureDetectorKt$awaitDragOrCancellation$1.label = 1;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitDragOrCancellation$1, 1, null);
                        if (awaitPointerEvent$default != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Ref$LongRef ref$LongRef4 = ref$LongRef;
                        obj = awaitPointerEvent$default;
                        ref$LongRef3 = ref$LongRef4;
                        PointerEvent pointerEvent2 = (PointerEvent) obj;
                        List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                        int size3 = changes3.size();
                        int i72 = 0;
                        int i82 = 0;
                        while (true) {
                            if (i82 < size3) {
                            }
                            i82++;
                        }
                        PointerInputChange pointerInputChange32 = pointerInputChange;
                        if (pointerInputChange32 == null) {
                            pointerInputChange32 = null;
                        }
                    }
                    if (pointerInputChange32 == null || pointerInputChange32.isConsumed()) {
                        return null;
                    }
                    return pointerInputChange32;
                }
                ResultKt.throwOnFailure(obj);
                if (m186isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j5)) {
                    return null;
                }
                ref$LongRef = new Ref$LongRef();
                ref$LongRef.element = j5;
                awaitPointerEventScope2 = awaitPointerEventScope;
                dragGestureDetectorKt$awaitDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                dragGestureDetectorKt$awaitDragOrCancellation$1.L$1 = ref$LongRef;
                dragGestureDetectorKt$awaitDragOrCancellation$1.label = 1;
                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitDragOrCancellation$1, 1, null);
                if (awaitPointerEvent$default != coroutine_suspended) {
                }
            }
        }
        dragGestureDetectorKt$awaitDragOrCancellation$1 = new DragGestureDetectorKt$awaitDragOrCancellation$1(continuation);
        Object obj2 = dragGestureDetectorKt$awaitDragOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = dragGestureDetectorKt$awaitDragOrCancellation$1.label;
        if (i5 == 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r10v2, types: [androidx.compose.ui.input.pointer.PointerInputChange, T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v6, types: [androidx.compose.ui.input.pointer.PointerInputChange] */
    /* renamed from: awaitLongPressOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m184awaitLongPressOrCancellationrnUCldI(AwaitPointerEventScope awaitPointerEventScope, long j5, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$1 dragGestureDetectorKt$awaitLongPressOrCancellation$1;
        int i5;
        PointerInputChange pointerInputChange;
        Object obj;
        Ref$ObjectRef ref$ObjectRef;
        if (continuation instanceof DragGestureDetectorKt$awaitLongPressOrCancellation$1) {
            dragGestureDetectorKt$awaitLongPressOrCancellation$1 = (DragGestureDetectorKt$awaitLongPressOrCancellation$1) continuation;
            int i6 = dragGestureDetectorKt$awaitLongPressOrCancellation$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.label = i6 - Integer.MIN_VALUE;
                Object obj2 = dragGestureDetectorKt$awaitLongPressOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = dragGestureDetectorKt$awaitLongPressOrCancellation$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    if (m186isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j5)) {
                        return null;
                    }
                    List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                    int size = changes.size();
                    int i7 = 0;
                    while (true) {
                        if (i7 >= size) {
                            pointerInputChange = null;
                            break;
                        }
                        pointerInputChange = changes.get(i7);
                        if (PointerId.m1872equalsimpl0(pointerInputChange.getId(), j5)) {
                            break;
                        }
                        i7++;
                    }
                    obj = pointerInputChange;
                    if (obj == 0) {
                        return null;
                    }
                    Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
                    ref$ObjectRef3.element = obj;
                    long longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
                    try {
                        DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$2 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(ref$ObjectRef3, ref$ObjectRef2, null);
                        dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0 = obj;
                        dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1 = ref$ObjectRef2;
                        dragGestureDetectorKt$awaitLongPressOrCancellation$1.label = 1;
                        if (awaitPointerEventScope.withTimeout(longPressTimeoutMillis, dragGestureDetectorKt$awaitLongPressOrCancellation$2, dragGestureDetectorKt$awaitLongPressOrCancellation$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return null;
                    } catch (PointerEventTimeoutCancellationException unused) {
                        ref$ObjectRef = ref$ObjectRef2;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ref$ObjectRef = (Ref$ObjectRef) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1;
                    obj = (PointerInputChange) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        return null;
                    } catch (PointerEventTimeoutCancellationException unused2) {
                    }
                }
                PointerInputChange pointerInputChange2 = (PointerInputChange) ref$ObjectRef.element;
                return pointerInputChange2 != null ? obj : pointerInputChange2;
            }
        }
        dragGestureDetectorKt$awaitLongPressOrCancellation$1 = new DragGestureDetectorKt$awaitLongPressOrCancellation$1(continuation);
        Object obj22 = dragGestureDetectorKt$awaitLongPressOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = dragGestureDetectorKt$awaitLongPressOrCancellation$1.label;
        if (i5 != 0) {
        }
        PointerInputChange pointerInputChange22 = (PointerInputChange) ref$ObjectRef.element;
        if (pointerInputChange22 != null) {
        }
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, final Function1<? super Offset, Unit> function1, final Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object detectDragGestures = detectDragGestures(pointerInputScope, new Function3<PointerInputChange, PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, Offset offset) {
                m188invoke0AR0LA0(pointerInputChange, pointerInputChange2, offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-0AR0LA0, reason: not valid java name */
            public final void m188invoke0AR0LA0(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, long j5) {
                function1.invoke(Offset.m1328boximpl(pointerInputChange2.getPosition()));
            }
        }, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$6
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange) {
                invoke2(pointerInputChange);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PointerInputChange pointerInputChange) {
                function0.invoke();
            }
        }, function02, new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.TRUE;
            }
        }, null, function2, continuation);
        return detectDragGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectDragGestures : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0048 -> B:10:0x004b). Please report as a decompilation issue!!! */
    /* renamed from: drag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m185dragjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j5, Function1<? super PointerInputChange, Unit> function1, Continuation<? super Boolean> continuation) {
        DragGestureDetectorKt$drag$1 dragGestureDetectorKt$drag$1;
        int i5;
        PointerInputChange pointerInputChange;
        if (continuation instanceof DragGestureDetectorKt$drag$1) {
            dragGestureDetectorKt$drag$1 = (DragGestureDetectorKt$drag$1) continuation;
            int i6 = dragGestureDetectorKt$drag$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$drag$1.label = i6 - Integer.MIN_VALUE;
                Object obj = dragGestureDetectorKt$drag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = dragGestureDetectorKt$drag$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    dragGestureDetectorKt$drag$1.L$0 = awaitPointerEventScope;
                    dragGestureDetectorKt$drag$1.L$1 = function1;
                    dragGestureDetectorKt$drag$1.label = 1;
                    obj = m183awaitDragOrCancellationrnUCldI(awaitPointerEventScope, j5, dragGestureDetectorKt$drag$1);
                    if (obj == coroutine_suspended) {
                    }
                    pointerInputChange = (PointerInputChange) obj;
                    if (pointerInputChange == null) {
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Function1<? super PointerInputChange, Unit> function12 = (Function1) dragGestureDetectorKt$drag$1.L$1;
                    AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) dragGestureDetectorKt$drag$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    function1 = function12;
                    awaitPointerEventScope = awaitPointerEventScope2;
                    pointerInputChange = (PointerInputChange) obj;
                    if (pointerInputChange == null) {
                        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                            return Boxing.boxBoolean(true);
                        }
                        function1.invoke(pointerInputChange);
                        j5 = pointerInputChange.getId();
                        dragGestureDetectorKt$drag$1.L$0 = awaitPointerEventScope;
                        dragGestureDetectorKt$drag$1.L$1 = function1;
                        dragGestureDetectorKt$drag$1.label = 1;
                        obj = m183awaitDragOrCancellationrnUCldI(awaitPointerEventScope, j5, dragGestureDetectorKt$drag$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pointerInputChange = (PointerInputChange) obj;
                        if (pointerInputChange == null) {
                            return Boxing.boxBoolean(false);
                        }
                    }
                }
            }
        }
        dragGestureDetectorKt$drag$1 = new DragGestureDetectorKt$drag$1(continuation);
        Object obj2 = dragGestureDetectorKt$drag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = dragGestureDetectorKt$drag$1.label;
        if (i5 != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    public static final boolean m186isPointerUpDmW0f2w(PointerEvent pointerEvent, long j5) {
        PointerInputChange pointerInputChange;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z5 = false;
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i5);
            if (PointerId.m1872equalsimpl0(pointerInputChange.getId(), j5)) {
                break;
            }
            i5++;
        }
        PointerInputChange pointerInputChange2 = pointerInputChange;
        if (pointerInputChange2 != null && pointerInputChange2.getPressed()) {
            z5 = true;
        }
        return true ^ z5;
    }

    /* renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m187pointerSlopE8SPZFQ(ViewConfiguration viewConfiguration, int i5) {
        return PointerType.m1904equalsimpl0(i5, PointerType.INSTANCE.m1908getMouseT8wyACA()) ? viewConfiguration.getTouchSlop() * mouseToTouchSlopRatio : viewConfiguration.getTouchSlop();
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function1<? super PointerInputChange, Unit> function1, Function0<Unit> function0, Function0<Boolean> function02, Orientation orientation, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectDragGestures$9(function02, new Ref$LongRef(), orientation, function3, function2, function0, function1, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }
}
