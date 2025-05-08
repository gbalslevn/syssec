package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$LongRef;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$9", f = "DragGestureDetector.kt", l = {247, 253, 972, 1014, 1025}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DragGestureDetectorKt$detectDragGestures$9 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function1<PointerInputChange, Unit> $onDragEnd;
    final /* synthetic */ Function3<PointerInputChange, PointerInputChange, Offset, Unit> $onDragStart;
    final /* synthetic */ Orientation $orientationLock;
    final /* synthetic */ Ref$LongRef $overSlop;
    final /* synthetic */ Function0<Boolean> $shouldAwaitTouchSlop;
    float F$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DragGestureDetectorKt$detectDragGestures$9(Function0<Boolean> function0, Ref$LongRef ref$LongRef, Orientation orientation, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function02, Function1<? super PointerInputChange, Unit> function1, Continuation<? super DragGestureDetectorKt$detectDragGestures$9> continuation) {
        super(2, continuation);
        this.$shouldAwaitTouchSlop = function0;
        this.$overSlop = ref$LongRef;
        this.$orientationLock = orientation;
        this.$onDragStart = function3;
        this.$onDrag = function2;
        this.$onDragCancel = function02;
        this.$onDragEnd = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGestures$9 dragGestureDetectorKt$detectDragGestures$9 = new DragGestureDetectorKt$detectDragGestures$9(this.$shouldAwaitTouchSlop, this.$overSlop, this.$orientationLock, this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
        dragGestureDetectorKt$detectDragGestures$9.L$0 = obj;
        return dragGestureDetectorKt$detectDragGestures$9;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectDragGestures$9) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x0253, code lost:
    
        if (r5 != false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0108, code lost:
    
        if (r17 == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x02ff, code lost:
    
        if (((r2 != null ? r2 == androidx.compose.foundation.gestures.Orientation.Vertical ? androidx.compose.ui.geometry.Offset.m1338getYimpl(r5) : androidx.compose.ui.geometry.Offset.m1337getXimpl(r5) : androidx.compose.ui.geometry.Offset.m1335getDistanceimpl(r5)) == 0.0f) == false) goto L128;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:38:0x02b3, B:51:0x02df], limit reached: 144 */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x017e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x027c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02a6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0151 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x019a  */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v4, types: [androidx.compose.ui.input.pointer.PointerEventPass, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:111:0x0208 -> B:64:0x020b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x027a -> B:9:0x027d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0120 -> B:67:0x0213). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AwaitPointerEventScope awaitPointerEventScope;
        Object awaitFirstDown;
        boolean z5;
        Object awaitFirstDown$default;
        AwaitPointerEventScope awaitPointerEventScope2;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        long id;
        Function2<PointerInputChange, Offset, Unit> function2;
        Orientation orientation;
        boolean m186isPointerUpDmW0f2w;
        Ref$LongRef ref$LongRef;
        Ref$LongRef ref$LongRef2;
        Object obj2;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope3;
        float f5;
        int size;
        int i5;
        Ref$LongRef ref$LongRef3;
        PointerInputChange pointerInputChange3;
        PointerInputChange pointerInputChange4;
        PointerInputChange pointerInputChange5;
        boolean m186isPointerUpDmW0f2w2;
        PointerInputChange pointerInputChange6;
        PointerInputChange pointerInputChange7;
        PointerInputChange pointerInputChange8;
        DragGestureDetectorKt$detectDragGestures$9 dragGestureDetectorKt$detectDragGestures$9 = this;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = dragGestureDetectorKt$detectDragGestures$9.label;
        int i7 = 3;
        int i8 = 1;
        ?? r13 = 0;
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj);
            awaitPointerEventScope = (AwaitPointerEventScope) dragGestureDetectorKt$detectDragGestures$9.L$0;
            PointerEventPass pointerEventPass = PointerEventPass.Initial;
            dragGestureDetectorKt$detectDragGestures$9.L$0 = awaitPointerEventScope;
            dragGestureDetectorKt$detectDragGestures$9.label = 1;
            awaitFirstDown = TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, false, pointerEventPass, dragGestureDetectorKt$detectDragGestures$9);
            if (awaitFirstDown == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i6 == 1) {
            awaitPointerEventScope = (AwaitPointerEventScope) dragGestureDetectorKt$detectDragGestures$9.L$0;
            ResultKt.throwOnFailure(obj);
            awaitFirstDown = obj;
        } else if (i6 == 2) {
            boolean z6 = dragGestureDetectorKt$detectDragGestures$9.Z$0;
            pointerInputChange = (PointerInputChange) dragGestureDetectorKt$detectDragGestures$9.L$1;
            awaitPointerEventScope2 = (AwaitPointerEventScope) dragGestureDetectorKt$detectDragGestures$9.L$0;
            ResultKt.throwOnFailure(obj);
            z5 = z6;
            awaitFirstDown$default = obj;
            pointerInputChange2 = (PointerInputChange) awaitFirstDown$default;
            dragGestureDetectorKt$detectDragGestures$9.$overSlop.element = Offset.INSTANCE.m1349getZeroF1C5BW0();
        } else if (i6 == 3) {
            float f6 = dragGestureDetectorKt$detectDragGestures$9.F$0;
            TouchSlopDetector touchSlopDetector2 = (TouchSlopDetector) dragGestureDetectorKt$detectDragGestures$9.L$5;
            Ref$LongRef ref$LongRef4 = (Ref$LongRef) dragGestureDetectorKt$detectDragGestures$9.L$4;
            Ref$LongRef ref$LongRef5 = (Ref$LongRef) dragGestureDetectorKt$detectDragGestures$9.L$3;
            AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$detectDragGestures$9.L$2;
            PointerInputChange pointerInputChange9 = (PointerInputChange) dragGestureDetectorKt$detectDragGestures$9.L$1;
            AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) dragGestureDetectorKt$detectDragGestures$9.L$0;
            ResultKt.throwOnFailure(obj);
            ref$LongRef = ref$LongRef4;
            awaitPointerEventScope2 = awaitPointerEventScope4;
            touchSlopDetector = touchSlopDetector2;
            f5 = f6;
            pointerInputChange2 = pointerInputChange9;
            obj2 = obj;
            ref$LongRef2 = ref$LongRef5;
            awaitPointerEventScope3 = awaitPointerEventScope5;
            PointerEvent pointerEvent = (PointerEvent) obj2;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            i5 = 0;
            while (true) {
                if (i5 < size) {
                }
                i5++;
                ref$LongRef2 = ref$LongRef3;
            }
            pointerInputChange4 = pointerInputChange3;
            if (pointerInputChange4 != null) {
            }
            awaitPointerEventScope2 = awaitPointerEventScope3;
            pointerInputChange = null;
            if (pointerInputChange != null) {
            }
            if (pointerInputChange != null) {
            }
        } else {
            if (i6 != 4) {
                if (i6 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Ref$LongRef ref$LongRef6 = (Ref$LongRef) dragGestureDetectorKt$detectDragGestures$9.L$4;
                AwaitPointerEventScope awaitPointerEventScope6 = (AwaitPointerEventScope) dragGestureDetectorKt$detectDragGestures$9.L$3;
                Orientation orientation2 = (Orientation) dragGestureDetectorKt$detectDragGestures$9.L$2;
                function2 = (Function2) dragGestureDetectorKt$detectDragGestures$9.L$1;
                AwaitPointerEventScope awaitPointerEventScope7 = (AwaitPointerEventScope) dragGestureDetectorKt$detectDragGestures$9.L$0;
                ResultKt.throwOnFailure(obj);
                Object awaitPointerEvent$default = obj;
                PointerEvent pointerEvent2 = (PointerEvent) awaitPointerEvent$default;
                List<PointerInputChange> changes2 = pointerEvent2.getChanges();
                int size2 = changes2.size();
                int i9 = 0;
                while (true) {
                    if (i9 >= size2) {
                        pointerInputChange7 = null;
                        break;
                    }
                    pointerInputChange7 = changes2.get(i9);
                    if (PointerId.m1872equalsimpl0(pointerInputChange7.getId(), ref$LongRef6.element)) {
                        break;
                    }
                    i9++;
                }
                PointerInputChange pointerInputChange10 = pointerInputChange7;
                if (pointerInputChange10 == null) {
                    if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange10)) {
                        List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                        int size3 = changes3.size();
                        int i10 = 0;
                        while (true) {
                            if (i10 >= size3) {
                                pointerInputChange8 = null;
                                break;
                            }
                            pointerInputChange8 = changes3.get(i10);
                            if (pointerInputChange8.getPressed()) {
                                break;
                            }
                            i10++;
                        }
                        PointerInputChange pointerInputChange11 = pointerInputChange8;
                        if (pointerInputChange11 != null) {
                            ref$LongRef6.element = pointerInputChange11.getId();
                            dragGestureDetectorKt$detectDragGestures$9 = this;
                            dragGestureDetectorKt$detectDragGestures$9.L$0 = awaitPointerEventScope7;
                            dragGestureDetectorKt$detectDragGestures$9.L$1 = function2;
                            dragGestureDetectorKt$detectDragGestures$9.L$2 = orientation2;
                            dragGestureDetectorKt$detectDragGestures$9.L$3 = awaitPointerEventScope6;
                            dragGestureDetectorKt$detectDragGestures$9.L$4 = ref$LongRef6;
                            dragGestureDetectorKt$detectDragGestures$9.L$5 = null;
                            dragGestureDetectorKt$detectDragGestures$9.L$6 = null;
                            dragGestureDetectorKt$detectDragGestures$9.label = 5;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope6, null, dragGestureDetectorKt$detectDragGestures$9, 1, null);
                            if (awaitPointerEvent$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            PointerEvent pointerEvent22 = (PointerEvent) awaitPointerEvent$default;
                            List<PointerInputChange> changes22 = pointerEvent22.getChanges();
                            int size22 = changes22.size();
                            int i92 = 0;
                            while (true) {
                                if (i92 >= size22) {
                                }
                                i92++;
                            }
                            PointerInputChange pointerInputChange102 = pointerInputChange7;
                            if (pointerInputChange102 == null) {
                                pointerInputChange102 = null;
                            }
                        }
                    } else {
                        long positionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange102);
                    }
                }
                if (pointerInputChange102 != null && !pointerInputChange102.isConsumed()) {
                    if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange102)) {
                        pointerInputChange6 = pointerInputChange102;
                        if (pointerInputChange6 != null) {
                            this.$onDragCancel.invoke();
                        } else {
                            this.$onDragEnd.invoke(pointerInputChange6);
                        }
                        return Unit.INSTANCE;
                    }
                    function2.invoke(pointerInputChange102, Offset.m1328boximpl(PointerEventKt.positionChange(pointerInputChange102)));
                    pointerInputChange102.consume();
                    id = pointerInputChange102.getId();
                    dragGestureDetectorKt$detectDragGestures$9 = this;
                    AwaitPointerEventScope awaitPointerEventScope8 = awaitPointerEventScope7;
                    orientation = orientation2;
                    awaitPointerEventScope2 = awaitPointerEventScope8;
                    Ref$LongRef ref$LongRef7 = new Ref$LongRef();
                    ref$LongRef7.element = id;
                    awaitPointerEventScope6 = awaitPointerEventScope2;
                    ref$LongRef6 = ref$LongRef7;
                    orientation2 = orientation;
                    awaitPointerEventScope7 = awaitPointerEventScope6;
                    dragGestureDetectorKt$detectDragGestures$9.L$0 = awaitPointerEventScope7;
                    dragGestureDetectorKt$detectDragGestures$9.L$1 = function2;
                    dragGestureDetectorKt$detectDragGestures$9.L$2 = orientation2;
                    dragGestureDetectorKt$detectDragGestures$9.L$3 = awaitPointerEventScope6;
                    dragGestureDetectorKt$detectDragGestures$9.L$4 = ref$LongRef6;
                    dragGestureDetectorKt$detectDragGestures$9.L$5 = null;
                    dragGestureDetectorKt$detectDragGestures$9.L$6 = null;
                    dragGestureDetectorKt$detectDragGestures$9.label = 5;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope6, null, dragGestureDetectorKt$detectDragGestures$9, 1, null);
                    if (awaitPointerEvent$default == coroutine_suspended) {
                    }
                    PointerEvent pointerEvent222 = (PointerEvent) awaitPointerEvent$default;
                    List<PointerInputChange> changes222 = pointerEvent222.getChanges();
                    int size222 = changes222.size();
                    int i922 = 0;
                    while (true) {
                        if (i922 >= size222) {
                        }
                        i922++;
                    }
                    PointerInputChange pointerInputChange1022 = pointerInputChange7;
                    if (pointerInputChange1022 == null) {
                    }
                    if (pointerInputChange1022 != null) {
                        if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange1022)) {
                        }
                    }
                }
                pointerInputChange6 = null;
                if (pointerInputChange6 != null) {
                }
                return Unit.INSTANCE;
            }
            float f7 = dragGestureDetectorKt$detectDragGestures$9.F$0;
            PointerInputChange pointerInputChange12 = (PointerInputChange) dragGestureDetectorKt$detectDragGestures$9.L$6;
            TouchSlopDetector touchSlopDetector3 = (TouchSlopDetector) dragGestureDetectorKt$detectDragGestures$9.L$5;
            Ref$LongRef ref$LongRef8 = (Ref$LongRef) dragGestureDetectorKt$detectDragGestures$9.L$4;
            Ref$LongRef ref$LongRef9 = (Ref$LongRef) dragGestureDetectorKt$detectDragGestures$9.L$3;
            AwaitPointerEventScope awaitPointerEventScope9 = (AwaitPointerEventScope) dragGestureDetectorKt$detectDragGestures$9.L$2;
            PointerInputChange pointerInputChange13 = (PointerInputChange) dragGestureDetectorKt$detectDragGestures$9.L$1;
            AwaitPointerEventScope awaitPointerEventScope10 = (AwaitPointerEventScope) dragGestureDetectorKt$detectDragGestures$9.L$0;
            ResultKt.throwOnFailure(obj);
            float f8 = f7;
            pointerInputChange2 = pointerInputChange13;
            ref$LongRef2 = ref$LongRef9;
            touchSlopDetector = touchSlopDetector3;
            ref$LongRef = ref$LongRef8;
            awaitPointerEventScope3 = awaitPointerEventScope10;
            if (!pointerInputChange12.isConsumed()) {
                awaitPointerEventScope2 = awaitPointerEventScope3;
                pointerInputChange = null;
                if (pointerInputChange != null && !pointerInputChange.isConsumed()) {
                    i7 = 3;
                    i8 = 1;
                    r13 = 0;
                    long id2 = pointerInputChange2.getId();
                    int type = pointerInputChange2.getType();
                    Orientation orientation3 = dragGestureDetectorKt$detectDragGestures$9.$orientationLock;
                    ref$LongRef2 = dragGestureDetectorKt$detectDragGestures$9.$overSlop;
                    m186isPointerUpDmW0f2w2 = DragGestureDetectorKt.m186isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), id2);
                    if (!m186isPointerUpDmW0f2w2) {
                        pointerInputChange = r13;
                        if (pointerInputChange != null) {
                            i7 = 3;
                            i8 = 1;
                            r13 = 0;
                            long id22 = pointerInputChange2.getId();
                            int type2 = pointerInputChange2.getType();
                            Orientation orientation32 = dragGestureDetectorKt$detectDragGestures$9.$orientationLock;
                            ref$LongRef2 = dragGestureDetectorKt$detectDragGestures$9.$overSlop;
                            m186isPointerUpDmW0f2w2 = DragGestureDetectorKt.m186isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), id22);
                            if (!m186isPointerUpDmW0f2w2) {
                                f5 = DragGestureDetectorKt.m187pointerSlopE8SPZFQ(awaitPointerEventScope2.getViewConfiguration(), type2);
                                ref$LongRef = new Ref$LongRef();
                                ref$LongRef.element = id22;
                                touchSlopDetector = new TouchSlopDetector(orientation32);
                                awaitPointerEventScope3 = awaitPointerEventScope2;
                                dragGestureDetectorKt$detectDragGestures$9.L$0 = awaitPointerEventScope3;
                                dragGestureDetectorKt$detectDragGestures$9.L$1 = pointerInputChange2;
                                dragGestureDetectorKt$detectDragGestures$9.L$2 = awaitPointerEventScope2;
                                dragGestureDetectorKt$detectDragGestures$9.L$3 = ref$LongRef2;
                                dragGestureDetectorKt$detectDragGestures$9.L$4 = ref$LongRef;
                                dragGestureDetectorKt$detectDragGestures$9.L$5 = touchSlopDetector;
                                dragGestureDetectorKt$detectDragGestures$9.L$6 = r13;
                                dragGestureDetectorKt$detectDragGestures$9.F$0 = f5;
                                dragGestureDetectorKt$detectDragGestures$9.label = i7;
                                obj2 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, r13, dragGestureDetectorKt$detectDragGestures$9, i8, r13);
                                if (obj2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                PointerEvent pointerEvent3 = (PointerEvent) obj2;
                                List<PointerInputChange> changes4 = pointerEvent3.getChanges();
                                size = changes4.size();
                                i5 = 0;
                                while (true) {
                                    if (i5 < size) {
                                        ref$LongRef3 = ref$LongRef2;
                                        pointerInputChange3 = null;
                                        break;
                                    }
                                    pointerInputChange3 = changes4.get(i5);
                                    ref$LongRef3 = ref$LongRef2;
                                    if (PointerId.m1872equalsimpl0(pointerInputChange3.getId(), ref$LongRef.element)) {
                                        break;
                                    }
                                    i5++;
                                    ref$LongRef2 = ref$LongRef3;
                                }
                                pointerInputChange4 = pointerInputChange3;
                                if (pointerInputChange4 != null && !pointerInputChange4.isConsumed()) {
                                    if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange4)) {
                                        Offset m240addPointerInputChangeGcwITfU = touchSlopDetector.m240addPointerInputChangeGcwITfU(pointerInputChange4, f5);
                                        if (m240addPointerInputChangeGcwITfU != null) {
                                            long packedValue = m240addPointerInputChangeGcwITfU.getPackedValue();
                                            pointerInputChange4.consume();
                                            ref$LongRef2 = ref$LongRef3;
                                            ref$LongRef2.element = packedValue;
                                            if (pointerInputChange4.isConsumed()) {
                                                awaitPointerEventScope2 = awaitPointerEventScope3;
                                                pointerInputChange = pointerInputChange4;
                                                if (pointerInputChange != null) {
                                                }
                                            } else {
                                                touchSlopDetector.reset();
                                            }
                                        } else {
                                            ref$LongRef2 = ref$LongRef3;
                                            PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                                            dragGestureDetectorKt$detectDragGestures$9.L$0 = awaitPointerEventScope3;
                                            dragGestureDetectorKt$detectDragGestures$9.L$1 = pointerInputChange2;
                                            dragGestureDetectorKt$detectDragGestures$9.L$2 = awaitPointerEventScope2;
                                            dragGestureDetectorKt$detectDragGestures$9.L$3 = ref$LongRef2;
                                            dragGestureDetectorKt$detectDragGestures$9.L$4 = ref$LongRef;
                                            dragGestureDetectorKt$detectDragGestures$9.L$5 = touchSlopDetector;
                                            dragGestureDetectorKt$detectDragGestures$9.L$6 = pointerInputChange4;
                                            dragGestureDetectorKt$detectDragGestures$9.F$0 = f5;
                                            dragGestureDetectorKt$detectDragGestures$9.label = 4;
                                            if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass2, dragGestureDetectorKt$detectDragGestures$9) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            awaitPointerEventScope9 = awaitPointerEventScope2;
                                            f8 = f5;
                                            pointerInputChange12 = pointerInputChange4;
                                            if (!pointerInputChange12.isConsumed()) {
                                                f5 = f8;
                                                awaitPointerEventScope2 = awaitPointerEventScope9;
                                                i7 = 3;
                                                i8 = 1;
                                                r13 = 0;
                                                dragGestureDetectorKt$detectDragGestures$9.L$0 = awaitPointerEventScope3;
                                                dragGestureDetectorKt$detectDragGestures$9.L$1 = pointerInputChange2;
                                                dragGestureDetectorKt$detectDragGestures$9.L$2 = awaitPointerEventScope2;
                                                dragGestureDetectorKt$detectDragGestures$9.L$3 = ref$LongRef2;
                                                dragGestureDetectorKt$detectDragGestures$9.L$4 = ref$LongRef;
                                                dragGestureDetectorKt$detectDragGestures$9.L$5 = touchSlopDetector;
                                                dragGestureDetectorKt$detectDragGestures$9.L$6 = r13;
                                                dragGestureDetectorKt$detectDragGestures$9.F$0 = f5;
                                                dragGestureDetectorKt$detectDragGestures$9.label = i7;
                                                obj2 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, r13, dragGestureDetectorKt$detectDragGestures$9, i8, r13);
                                                if (obj2 == coroutine_suspended) {
                                                }
                                                PointerEvent pointerEvent32 = (PointerEvent) obj2;
                                                List<PointerInputChange> changes42 = pointerEvent32.getChanges();
                                                size = changes42.size();
                                                i5 = 0;
                                                while (true) {
                                                    if (i5 < size) {
                                                    }
                                                    i5++;
                                                    ref$LongRef2 = ref$LongRef3;
                                                }
                                                pointerInputChange4 = pointerInputChange3;
                                                if (pointerInputChange4 != null) {
                                                    if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange4)) {
                                                        List<PointerInputChange> changes5 = pointerEvent32.getChanges();
                                                        int size4 = changes5.size();
                                                        int i11 = 0;
                                                        while (true) {
                                                            if (i11 >= size4) {
                                                                pointerInputChange5 = null;
                                                                break;
                                                            }
                                                            pointerInputChange5 = changes5.get(i11);
                                                            if (pointerInputChange5.getPressed()) {
                                                                break;
                                                            }
                                                            i11++;
                                                        }
                                                        PointerInputChange pointerInputChange14 = pointerInputChange5;
                                                        if (pointerInputChange14 != null) {
                                                            ref$LongRef.element = pointerInputChange14.getId();
                                                            ref$LongRef2 = ref$LongRef3;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i7 = 3;
                                    i8 = 1;
                                    r13 = 0;
                                    dragGestureDetectorKt$detectDragGestures$9.L$0 = awaitPointerEventScope3;
                                    dragGestureDetectorKt$detectDragGestures$9.L$1 = pointerInputChange2;
                                    dragGestureDetectorKt$detectDragGestures$9.L$2 = awaitPointerEventScope2;
                                    dragGestureDetectorKt$detectDragGestures$9.L$3 = ref$LongRef2;
                                    dragGestureDetectorKt$detectDragGestures$9.L$4 = ref$LongRef;
                                    dragGestureDetectorKt$detectDragGestures$9.L$5 = touchSlopDetector;
                                    dragGestureDetectorKt$detectDragGestures$9.L$6 = r13;
                                    dragGestureDetectorKt$detectDragGestures$9.F$0 = f5;
                                    dragGestureDetectorKt$detectDragGestures$9.label = i7;
                                    obj2 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, r13, dragGestureDetectorKt$detectDragGestures$9, i8, r13);
                                    if (obj2 == coroutine_suspended) {
                                    }
                                    PointerEvent pointerEvent322 = (PointerEvent) obj2;
                                    List<PointerInputChange> changes422 = pointerEvent322.getChanges();
                                    size = changes422.size();
                                    i5 = 0;
                                    while (true) {
                                        if (i5 < size) {
                                        }
                                        i5++;
                                        ref$LongRef2 = ref$LongRef3;
                                    }
                                    pointerInputChange4 = pointerInputChange3;
                                    if (pointerInputChange4 != null) {
                                    }
                                }
                                awaitPointerEventScope2 = awaitPointerEventScope3;
                                pointerInputChange = null;
                                if (pointerInputChange != null) {
                                }
                            }
                        }
                    }
                }
                if (pointerInputChange != null) {
                    return Unit.INSTANCE;
                }
                dragGestureDetectorKt$detectDragGestures$9.$onDragStart.invoke(pointerInputChange2, pointerInputChange, Offset.m1328boximpl(dragGestureDetectorKt$detectDragGestures$9.$overSlop.element));
                dragGestureDetectorKt$detectDragGestures$9.$onDrag.invoke(pointerInputChange, Offset.m1328boximpl(dragGestureDetectorKt$detectDragGestures$9.$overSlop.element));
                id = pointerInputChange.getId();
                function2 = dragGestureDetectorKt$detectDragGestures$9.$onDrag;
                orientation = dragGestureDetectorKt$detectDragGestures$9.$orientationLock;
                m186isPointerUpDmW0f2w = DragGestureDetectorKt.m186isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), id);
            }
        }
        AwaitPointerEventScope awaitPointerEventScope11 = awaitPointerEventScope;
        PointerInputChange pointerInputChange15 = (PointerInputChange) awaitFirstDown;
        boolean booleanValue = dragGestureDetectorKt$detectDragGestures$9.$shouldAwaitTouchSlop.invoke().booleanValue();
        if (!booleanValue) {
            pointerInputChange15.consume();
        }
        dragGestureDetectorKt$detectDragGestures$9.L$0 = awaitPointerEventScope11;
        dragGestureDetectorKt$detectDragGestures$9.L$1 = pointerInputChange15;
        dragGestureDetectorKt$detectDragGestures$9.Z$0 = booleanValue;
        dragGestureDetectorKt$detectDragGestures$9.label = 2;
        z5 = booleanValue;
        awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope11, false, null, this, 2, null);
        if (awaitFirstDown$default == coroutine_suspended) {
            return coroutine_suspended;
        }
        awaitPointerEventScope2 = awaitPointerEventScope11;
        pointerInputChange = pointerInputChange15;
        pointerInputChange2 = (PointerInputChange) awaitFirstDown$default;
        dragGestureDetectorKt$detectDragGestures$9.$overSlop.element = Offset.INSTANCE.m1349getZeroF1C5BW0();
    }
}
