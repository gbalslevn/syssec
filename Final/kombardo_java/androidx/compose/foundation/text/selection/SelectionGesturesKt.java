package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.ViewConfiguration;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u001a'\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a$\u0010\u0011\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b\u0011\u0010\u0012\u001a,\u0010\u0015\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0014\u0010\u0017\u001a\u00020\u000f*\u00020\rH\u0082@¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001f\"\u0014\u0010!\u001a\u00020 8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"\"\u0018\u0010#\u001a\u00020\u0002*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "updateTouchMode", "updateSelectionTouchMode", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "mouseSelectionObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "textDragObserver", "selectionGestureInput", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/TextDragObserver;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "observer", "Landroidx/compose/ui/input/pointer/PointerEvent;", "down", "touchSelection", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/TextDragObserver;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/foundation/text/selection/ClicksCounter;", "clicksCounter", "mouseSelection", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/selection/ClicksCounter;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDown", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "change1", "change2", "distanceIsTolerable", "(Landroidx/compose/ui/platform/ViewConfiguration;Landroidx/compose/ui/input/pointer/PointerInputChange;Landroidx/compose/ui/input/pointer/PointerInputChange;)Z", BuildConfig.FLAVOR, "STATIC_KEY", "I", "isPrecisePointer", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SelectionGesturesKt {
    private static final int STATIC_KEY = 8675309;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0042 -> B:10:0x0045). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitDown(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerEvent> continuation) {
        SelectionGesturesKt$awaitDown$1 selectionGesturesKt$awaitDown$1;
        int i5;
        int size;
        int i6;
        if (continuation instanceof SelectionGesturesKt$awaitDown$1) {
            selectionGesturesKt$awaitDown$1 = (SelectionGesturesKt$awaitDown$1) continuation;
            int i7 = selectionGesturesKt$awaitDown$1.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                selectionGesturesKt$awaitDown$1.label = i7 - Integer.MIN_VALUE;
                Object obj = selectionGesturesKt$awaitDown$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = selectionGesturesKt$awaitDown$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    PointerEventPass pointerEventPass = PointerEventPass.Main;
                    selectionGesturesKt$awaitDown$1.L$0 = awaitPointerEventScope;
                    selectionGesturesKt$awaitDown$1.label = 1;
                    obj = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, selectionGesturesKt$awaitDown$1);
                    if (obj == coroutine_suspended) {
                    }
                    PointerEvent pointerEvent = (PointerEvent) obj;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    size = changes.size();
                    i6 = 0;
                    while (i6 < size) {
                    }
                    return pointerEvent;
                }
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                awaitPointerEventScope = (AwaitPointerEventScope) selectionGesturesKt$awaitDown$1.L$0;
                ResultKt.throwOnFailure(obj);
                PointerEvent pointerEvent2 = (PointerEvent) obj;
                List<PointerInputChange> changes2 = pointerEvent2.getChanges();
                size = changes2.size();
                i6 = 0;
                while (i6 < size) {
                    if (PointerEventKt.changedToDownIgnoreConsumed(changes2.get(i6))) {
                        i6++;
                    } else {
                        PointerEventPass pointerEventPass2 = PointerEventPass.Main;
                        selectionGesturesKt$awaitDown$1.L$0 = awaitPointerEventScope;
                        selectionGesturesKt$awaitDown$1.label = 1;
                        obj = awaitPointerEventScope.awaitPointerEvent(pointerEventPass2, selectionGesturesKt$awaitDown$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        PointerEvent pointerEvent22 = (PointerEvent) obj;
                        List<PointerInputChange> changes22 = pointerEvent22.getChanges();
                        size = changes22.size();
                        i6 = 0;
                        while (i6 < size) {
                        }
                    }
                }
                return pointerEvent22;
            }
        }
        selectionGesturesKt$awaitDown$1 = new SelectionGesturesKt$awaitDown$1(continuation);
        Object obj2 = selectionGesturesKt$awaitDown$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = selectionGesturesKt$awaitDown$1.label;
        if (i5 != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean distanceIsTolerable(ViewConfiguration viewConfiguration, PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2) {
        return Offset.m1335getDistanceimpl(Offset.m1341minusMKHz9U(pointerInputChange.getPosition(), pointerInputChange2.getPosition())) < DragGestureDetectorKt.m187pointerSlopE8SPZFQ(viewConfiguration, pointerInputChange.getType());
    }

    public static final boolean isPrecisePointer(PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (!PointerType.m1904equalsimpl0(changes.get(i5).getType(), PointerType.INSTANCE.m1908getMouseT8wyACA())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object mouseSelection(AwaitPointerEventScope awaitPointerEventScope, final MouseSelectionObserver mouseSelectionObserver, ClicksCounter clicksCounter, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        SelectionGesturesKt$mouseSelection$1 selectionGesturesKt$mouseSelection$1;
        int i5;
        if (continuation instanceof SelectionGesturesKt$mouseSelection$1) {
            selectionGesturesKt$mouseSelection$1 = (SelectionGesturesKt$mouseSelection$1) continuation;
            int i6 = selectionGesturesKt$mouseSelection$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                selectionGesturesKt$mouseSelection$1.label = i6 - Integer.MIN_VALUE;
                Object obj = selectionGesturesKt$mouseSelection$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = selectionGesturesKt$mouseSelection$1.label;
                int i7 = 0;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    clicksCounter.update(pointerEvent);
                    PointerInputChange pointerInputChange = pointerEvent.getChanges().get(0);
                    if (!TextFieldSelectionManager_androidKt.isShiftPressed(pointerEvent)) {
                        int clicks = clicksCounter.getClicks();
                        final SelectionAdjustment paragraph = clicks != 1 ? clicks != 2 ? SelectionAdjustment.INSTANCE.getParagraph() : SelectionAdjustment.INSTANCE.getWord() : SelectionAdjustment.INSTANCE.getNone();
                        if (mouseSelectionObserver.mo627onStart3MmeM6k(pointerInputChange.getPosition(), paragraph)) {
                            long id = pointerInputChange.getId();
                            Function1<PointerInputChange, Unit> function1 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$shouldConsumeUp$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange2) {
                                    invoke2(pointerInputChange2);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(PointerInputChange pointerInputChange2) {
                                    if (MouseSelectionObserver.this.mo624onDrag3MmeM6k(pointerInputChange2.getPosition(), paragraph)) {
                                        pointerInputChange2.consume();
                                    }
                                }
                            };
                            selectionGesturesKt$mouseSelection$1.L$0 = awaitPointerEventScope;
                            selectionGesturesKt$mouseSelection$1.L$1 = mouseSelectionObserver;
                            selectionGesturesKt$mouseSelection$1.label = 2;
                            obj = DragGestureDetectorKt.m185dragjO51t88(awaitPointerEventScope, id, function1, selectionGesturesKt$mouseSelection$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (((Boolean) obj).booleanValue()) {
                            }
                            mouseSelectionObserver.onDragDone();
                        }
                    } else if (mouseSelectionObserver.mo625onExtendk4lQ0M(pointerInputChange.getPosition())) {
                        long id2 = pointerInputChange.getId();
                        Function1<PointerInputChange, Unit> function12 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$shouldConsumeUp$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange2) {
                                invoke2(pointerInputChange2);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PointerInputChange pointerInputChange2) {
                                if (MouseSelectionObserver.this.mo626onExtendDragk4lQ0M(pointerInputChange2.getPosition())) {
                                    pointerInputChange2.consume();
                                }
                            }
                        };
                        selectionGesturesKt$mouseSelection$1.L$0 = awaitPointerEventScope;
                        selectionGesturesKt$mouseSelection$1.L$1 = mouseSelectionObserver;
                        selectionGesturesKt$mouseSelection$1.label = 1;
                        obj = DragGestureDetectorKt.m185dragjO51t88(awaitPointerEventScope, id2, function12, selectionGesturesKt$mouseSelection$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (((Boolean) obj).booleanValue()) {
                        }
                        mouseSelectionObserver.onDragDone();
                    }
                } else if (i5 == 1) {
                    mouseSelectionObserver = (MouseSelectionObserver) selectionGesturesKt$mouseSelection$1.L$1;
                    awaitPointerEventScope = (AwaitPointerEventScope) selectionGesturesKt$mouseSelection$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) obj).booleanValue()) {
                        List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                        int size = changes.size();
                        while (i7 < size) {
                            PointerInputChange pointerInputChange2 = changes.get(i7);
                            if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                pointerInputChange2.consume();
                            }
                            i7++;
                        }
                    }
                    mouseSelectionObserver.onDragDone();
                } else {
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mouseSelectionObserver = (MouseSelectionObserver) selectionGesturesKt$mouseSelection$1.L$1;
                    awaitPointerEventScope = (AwaitPointerEventScope) selectionGesturesKt$mouseSelection$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) obj).booleanValue()) {
                        List<PointerInputChange> changes2 = awaitPointerEventScope.getCurrentEvent().getChanges();
                        int size2 = changes2.size();
                        while (i7 < size2) {
                            PointerInputChange pointerInputChange3 = changes2.get(i7);
                            if (PointerEventKt.changedToUp(pointerInputChange3)) {
                                pointerInputChange3.consume();
                            }
                            i7++;
                        }
                    }
                    mouseSelectionObserver.onDragDone();
                }
                return Unit.INSTANCE;
            }
        }
        selectionGesturesKt$mouseSelection$1 = new SelectionGesturesKt$mouseSelection$1(continuation);
        Object obj2 = selectionGesturesKt$mouseSelection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = selectionGesturesKt$mouseSelection$1.label;
        int i72 = 0;
        if (i5 != 0) {
        }
        return Unit.INSTANCE;
    }

    public static final Modifier selectionGestureInput(Modifier modifier, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, mouseSelectionObserver, textDragObserver, new SelectionGesturesKt$selectionGestureInput$1(mouseSelectionObserver, textDragObserver, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a9 A[Catch: CancellationException -> 0x0035, TryCatch #0 {CancellationException -> 0x0035, blocks: (B:12:0x0031, B:13:0x00a1, B:15:0x00a9, B:17:0x00b8, B:19:0x00c4, B:21:0x00c7, B:24:0x00ca, B:28:0x00ce, B:32:0x004c, B:34:0x0073, B:36:0x0077, B:38:0x0081, B:42:0x0056), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ce A[Catch: CancellationException -> 0x0035, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x0035, blocks: (B:12:0x0031, B:13:0x00a1, B:15:0x00a9, B:17:0x00b8, B:19:0x00c4, B:21:0x00c7, B:24:0x00ca, B:28:0x00ce, B:32:0x004c, B:34:0x0073, B:36:0x0077, B:38:0x0081, B:42:0x0056), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object touchSelection(AwaitPointerEventScope awaitPointerEventScope, final TextDragObserver textDragObserver, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        SelectionGesturesKt$touchSelection$1 selectionGesturesKt$touchSelection$1;
        Object obj;
        Object coroutine_suspended;
        int i5;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        try {
            if (continuation instanceof SelectionGesturesKt$touchSelection$1) {
                selectionGesturesKt$touchSelection$1 = (SelectionGesturesKt$touchSelection$1) continuation;
                int i6 = selectionGesturesKt$touchSelection$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    selectionGesturesKt$touchSelection$1.label = i6 - Integer.MIN_VALUE;
                    obj = selectionGesturesKt$touchSelection$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = selectionGesturesKt$touchSelection$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        pointerInputChange = (PointerInputChange) CollectionsKt.first((List) pointerEvent.getChanges());
                        long id = pointerInputChange.getId();
                        selectionGesturesKt$touchSelection$1.L$0 = awaitPointerEventScope;
                        selectionGesturesKt$touchSelection$1.L$1 = textDragObserver;
                        selectionGesturesKt$touchSelection$1.L$2 = pointerInputChange;
                        selectionGesturesKt$touchSelection$1.label = 1;
                        obj = DragGestureDetectorKt.m184awaitLongPressOrCancellationrnUCldI(awaitPointerEventScope, id, selectionGesturesKt$touchSelection$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i5 != 1) {
                            if (i5 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            textDragObserver = (TextDragObserver) selectionGesturesKt$touchSelection$1.L$1;
                            awaitPointerEventScope = (AwaitPointerEventScope) selectionGesturesKt$touchSelection$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            if (((Boolean) obj).booleanValue()) {
                                List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                                int size = changes.size();
                                for (int i7 = 0; i7 < size; i7++) {
                                    PointerInputChange pointerInputChange3 = changes.get(i7);
                                    if (PointerEventKt.changedToUp(pointerInputChange3)) {
                                        pointerInputChange3.consume();
                                    }
                                }
                                textDragObserver.onStop();
                            } else {
                                textDragObserver.onCancel();
                            }
                            return Unit.INSTANCE;
                        }
                        PointerInputChange pointerInputChange4 = (PointerInputChange) selectionGesturesKt$touchSelection$1.L$2;
                        textDragObserver = (TextDragObserver) selectionGesturesKt$touchSelection$1.L$1;
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) selectionGesturesKt$touchSelection$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        pointerInputChange = pointerInputChange4;
                        awaitPointerEventScope = awaitPointerEventScope2;
                    }
                    pointerInputChange2 = (PointerInputChange) obj;
                    if (pointerInputChange2 != null && distanceIsTolerable(awaitPointerEventScope.getViewConfiguration(), pointerInputChange, pointerInputChange2)) {
                        textDragObserver.mo527onStartk4lQ0M(pointerInputChange2.getPosition());
                        long id2 = pointerInputChange2.getId();
                        Function1<PointerInputChange, Unit> function1 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange5) {
                                invoke2(pointerInputChange5);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PointerInputChange pointerInputChange5) {
                                TextDragObserver.this.mo526onDragk4lQ0M(PointerEventKt.positionChange(pointerInputChange5));
                                pointerInputChange5.consume();
                            }
                        };
                        selectionGesturesKt$touchSelection$1.L$0 = awaitPointerEventScope;
                        selectionGesturesKt$touchSelection$1.L$1 = textDragObserver;
                        selectionGesturesKt$touchSelection$1.L$2 = null;
                        selectionGesturesKt$touchSelection$1.label = 2;
                        obj = DragGestureDetectorKt.m185dragjO51t88(awaitPointerEventScope, id2, function1, selectionGesturesKt$touchSelection$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (((Boolean) obj).booleanValue()) {
                        }
                    }
                    return Unit.INSTANCE;
                }
            }
            if (i5 != 0) {
            }
            pointerInputChange2 = (PointerInputChange) obj;
            if (pointerInputChange2 != null) {
                textDragObserver.mo527onStartk4lQ0M(pointerInputChange2.getPosition());
                long id22 = pointerInputChange2.getId();
                Function1<PointerInputChange, Unit> function12 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange5) {
                        invoke2(pointerInputChange5);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PointerInputChange pointerInputChange5) {
                        TextDragObserver.this.mo526onDragk4lQ0M(PointerEventKt.positionChange(pointerInputChange5));
                        pointerInputChange5.consume();
                    }
                };
                selectionGesturesKt$touchSelection$1.L$0 = awaitPointerEventScope;
                selectionGesturesKt$touchSelection$1.L$1 = textDragObserver;
                selectionGesturesKt$touchSelection$1.L$2 = null;
                selectionGesturesKt$touchSelection$1.label = 2;
                obj = DragGestureDetectorKt.m185dragjO51t88(awaitPointerEventScope, id22, function12, selectionGesturesKt$touchSelection$1);
                if (obj == coroutine_suspended) {
                }
                if (((Boolean) obj).booleanValue()) {
                }
            }
            return Unit.INSTANCE;
        } catch (CancellationException e5) {
            textDragObserver.onCancel();
            throw e5;
        }
        selectionGesturesKt$touchSelection$1 = new SelectionGesturesKt$touchSelection$1(continuation);
        obj = selectionGesturesKt$touchSelection$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = selectionGesturesKt$touchSelection$1.label;
    }

    public static final Modifier updateSelectionTouchMode(Modifier modifier, Function1<? super Boolean, Unit> function1) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, Integer.valueOf(STATIC_KEY), new SelectionGesturesKt$updateSelectionTouchMode$1(function1, null));
    }
}
