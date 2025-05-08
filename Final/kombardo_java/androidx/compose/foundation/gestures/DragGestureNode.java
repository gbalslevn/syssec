package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.DragInteraction$Cancel;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.DragInteraction$Stop;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.channels.Channel;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B7\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0082@¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0019H\u0082@¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJ@\u0010#\u001a\u00020\u000f2.\u0010\"\u001a*\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000f0\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001eH¦@¢\u0006\u0004\b#\u0010$J\u001a\u0010)\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020%H&ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001a\u0010-\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020*H&ø\u0001\u0000¢\u0006\u0004\b,\u0010(J\u000f\u0010.\u001a\u00020\u0006H&¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u000fH\u0016¢\u0006\u0004\b0\u0010\u0011J*\u00109\u001a\u00020\u000f2\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u000205H\u0016ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u000f\u0010:\u001a\u00020\u000fH\u0016¢\u0006\u0004\b:\u0010\u0011J\r\u0010;\u001a\u00020\u000f¢\u0006\u0004\b;\u0010\u0011JO\u0010=\u001a\u00020\u000f2\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010<\u001a\u00020\u0006¢\u0006\u0004\b=\u0010>R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010?R<\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u0007\u0010A\u001a\u0004\bB\u0010CR$\u0010\b\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u00068\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\b\u0010D\u001a\u0004\bE\u0010/R(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010@\u001a\u0004\u0018\u00010\t8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\n\u0010F\u001a\u0004\bG\u0010HR \u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010AR\u001e\u0010L\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010DR\u0018\u0010R\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010S\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006T"}, d2 = {"Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", BuildConfig.FLAVOR, "canDrag", "enabled", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Landroidx/compose/foundation/gestures/Orientation;", "orientationLock", "<init>", "(Lkotlin/jvm/functions/Function1;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/Orientation;)V", BuildConfig.FLAVOR, "startListeningForEvents", "()V", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "initializePointerInputNode", "()Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "event", "processDragStart", "(Landroidx/compose/foundation/gestures/DragEvent$DragStarted;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "processDragStop", "(Landroidx/compose/foundation/gestures/DragEvent$DragStopped;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragCancel", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "forEachDelta", "drag", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/ui/geometry/Offset;", "startedPosition", "onDragStarted-k-4lQ0M", "(J)V", "onDragStarted", "Landroidx/compose/ui/unit/Velocity;", "velocity", "onDragStopped-TH1AsA0", "onDragStopped", "startDragImmediately", "()Z", "onDetach", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "pass", "Landroidx/compose/ui/unit/IntSize;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onPointerEvent", "onCancelPointerInput", "disposeInteractionSource", "shouldResetPointerInputHandling", "update", "(Lkotlin/jvm/functions/Function1;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/Orientation;Z)V", "Landroidx/compose/foundation/gestures/Orientation;", "<set-?>", "Lkotlin/jvm/functions/Function1;", "getCanDrag", "()Lkotlin/jvm/functions/Function1;", "Z", "getEnabled", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "_canDrag", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/DragEvent;", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "dragInteraction", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "isListeningForEvents", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DragGestureNode extends DelegatingNode implements PointerInputModifierNode, CompositionLocalConsumerModifierNode {
    private final Function1<PointerInputChange, Boolean> _canDrag = new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$_canDrag$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(PointerInputChange pointerInputChange) {
            return DragGestureNode.this.getCanDrag().invoke(pointerInputChange);
        }
    };
    private Function1<? super PointerInputChange, Boolean> canDrag;
    private Channel<DragEvent> channel;
    private DragInteraction$Start dragInteraction;
    private boolean enabled;
    private MutableInteractionSource interactionSource;
    private boolean isListeningForEvents;
    private Orientation orientationLock;
    private SuspendingPointerInputModifierNode pointerInputNode;

    public DragGestureNode(Function1<? super PointerInputChange, Boolean> function1, boolean z5, MutableInteractionSource mutableInteractionSource, Orientation orientation) {
        this.orientationLock = orientation;
        this.canDrag = function1;
        this.enabled = z5;
        this.interactionSource = mutableInteractionSource;
    }

    private final SuspendingPointerInputModifierNode initializePointerInputNode() {
        return SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new DragGestureNode$initializePointerInputNode$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processDragCancel(Continuation<? super Unit> continuation) {
        DragGestureNode$processDragCancel$1 dragGestureNode$processDragCancel$1;
        int i5;
        DragGestureNode dragGestureNode;
        if (continuation instanceof DragGestureNode$processDragCancel$1) {
            dragGestureNode$processDragCancel$1 = (DragGestureNode$processDragCancel$1) continuation;
            int i6 = dragGestureNode$processDragCancel$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                dragGestureNode$processDragCancel$1.label = i6 - Integer.MIN_VALUE;
                Object obj = dragGestureNode$processDragCancel$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = dragGestureNode$processDragCancel$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    DragInteraction$Start dragInteraction$Start = this.dragInteraction;
                    if (dragInteraction$Start == null) {
                        dragGestureNode = this;
                        dragGestureNode.mo190onDragStoppedTH1AsA0(Velocity.INSTANCE.m2709getZero9UxMQ8M());
                        return Unit.INSTANCE;
                    }
                    MutableInteractionSource mutableInteractionSource = this.interactionSource;
                    if (mutableInteractionSource != null) {
                        DragInteraction$Cancel dragInteraction$Cancel = new DragInteraction$Cancel(dragInteraction$Start);
                        dragGestureNode$processDragCancel$1.L$0 = this;
                        dragGestureNode$processDragCancel$1.label = 1;
                        if (mutableInteractionSource.emit(dragInteraction$Cancel, dragGestureNode$processDragCancel$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    dragGestureNode = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    dragGestureNode = (DragGestureNode) dragGestureNode$processDragCancel$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                dragGestureNode.dragInteraction = null;
                dragGestureNode.mo190onDragStoppedTH1AsA0(Velocity.INSTANCE.m2709getZero9UxMQ8M());
                return Unit.INSTANCE;
            }
        }
        dragGestureNode$processDragCancel$1 = new DragGestureNode$processDragCancel$1(this, continuation);
        Object obj2 = dragGestureNode$processDragCancel$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = dragGestureNode$processDragCancel$1.label;
        if (i5 != 0) {
        }
        dragGestureNode.dragInteraction = null;
        dragGestureNode.mo190onDragStoppedTH1AsA0(Velocity.INSTANCE.m2709getZero9UxMQ8M());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processDragStart(DragEvent.DragStarted dragStarted, Continuation<? super Unit> continuation) {
        DragGestureNode$processDragStart$1 dragGestureNode$processDragStart$1;
        int i5;
        DragGestureNode dragGestureNode;
        MutableInteractionSource mutableInteractionSource;
        MutableInteractionSource mutableInteractionSource2;
        DragEvent.DragStarted dragStarted2;
        Interaction interaction;
        DragGestureNode dragGestureNode2;
        DragInteraction$Start dragInteraction$Start;
        if (continuation instanceof DragGestureNode$processDragStart$1) {
            dragGestureNode$processDragStart$1 = (DragGestureNode$processDragStart$1) continuation;
            int i6 = dragGestureNode$processDragStart$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                dragGestureNode$processDragStart$1.label = i6 - Integer.MIN_VALUE;
                Object obj = dragGestureNode$processDragStart$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = dragGestureNode$processDragStart$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    DragInteraction$Start dragInteraction$Start2 = this.dragInteraction;
                    if (dragInteraction$Start2 != null && (mutableInteractionSource = this.interactionSource) != null) {
                        DragInteraction$Cancel dragInteraction$Cancel = new DragInteraction$Cancel(dragInteraction$Start2);
                        dragGestureNode$processDragStart$1.L$0 = this;
                        dragGestureNode$processDragStart$1.L$1 = dragStarted;
                        dragGestureNode$processDragStart$1.label = 1;
                        if (mutableInteractionSource.emit(dragInteraction$Cancel, dragGestureNode$processDragStart$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    dragGestureNode = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        interaction = (DragInteraction$Start) dragGestureNode$processDragStart$1.L$2;
                        dragStarted2 = (DragEvent.DragStarted) dragGestureNode$processDragStart$1.L$1;
                        dragGestureNode2 = (DragGestureNode) dragGestureNode$processDragStart$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        dragInteraction$Start = interaction;
                        dragGestureNode = dragGestureNode2;
                        dragStarted = dragStarted2;
                        dragGestureNode.dragInteraction = dragInteraction$Start;
                        dragGestureNode.mo189onDragStartedk4lQ0M(dragStarted.getStartPoint());
                        return Unit.INSTANCE;
                    }
                    dragStarted = (DragEvent.DragStarted) dragGestureNode$processDragStart$1.L$1;
                    dragGestureNode = (DragGestureNode) dragGestureNode$processDragStart$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Interaction interaction2 = new Interaction() { // from class: androidx.compose.foundation.interaction.DragInteraction$Start
                };
                mutableInteractionSource2 = dragGestureNode.interactionSource;
                dragInteraction$Start = interaction2;
                if (mutableInteractionSource2 != null) {
                    dragGestureNode$processDragStart$1.L$0 = dragGestureNode;
                    dragGestureNode$processDragStart$1.L$1 = dragStarted;
                    dragGestureNode$processDragStart$1.L$2 = interaction2;
                    dragGestureNode$processDragStart$1.label = 2;
                    if (mutableInteractionSource2.emit(interaction2, dragGestureNode$processDragStart$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    dragStarted2 = dragStarted;
                    interaction = interaction2;
                    dragGestureNode2 = dragGestureNode;
                    dragInteraction$Start = interaction;
                    dragGestureNode = dragGestureNode2;
                    dragStarted = dragStarted2;
                }
                dragGestureNode.dragInteraction = dragInteraction$Start;
                dragGestureNode.mo189onDragStartedk4lQ0M(dragStarted.getStartPoint());
                return Unit.INSTANCE;
            }
        }
        dragGestureNode$processDragStart$1 = new DragGestureNode$processDragStart$1(this, continuation);
        Object obj2 = dragGestureNode$processDragStart$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = dragGestureNode$processDragStart$1.label;
        if (i5 != 0) {
        }
        Interaction interaction22 = new Interaction() { // from class: androidx.compose.foundation.interaction.DragInteraction$Start
        };
        mutableInteractionSource2 = dragGestureNode.interactionSource;
        dragInteraction$Start = interaction22;
        if (mutableInteractionSource2 != null) {
        }
        dragGestureNode.dragInteraction = dragInteraction$Start;
        dragGestureNode.mo189onDragStartedk4lQ0M(dragStarted.getStartPoint());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processDragStop(DragEvent.DragStopped dragStopped, Continuation<? super Unit> continuation) {
        DragGestureNode$processDragStop$1 dragGestureNode$processDragStop$1;
        int i5;
        DragGestureNode dragGestureNode;
        if (continuation instanceof DragGestureNode$processDragStop$1) {
            dragGestureNode$processDragStop$1 = (DragGestureNode$processDragStop$1) continuation;
            int i6 = dragGestureNode$processDragStop$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                dragGestureNode$processDragStop$1.label = i6 - Integer.MIN_VALUE;
                Object obj = dragGestureNode$processDragStop$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = dragGestureNode$processDragStop$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    DragInteraction$Start dragInteraction$Start = this.dragInteraction;
                    if (dragInteraction$Start == null) {
                        dragGestureNode = this;
                        dragGestureNode.mo190onDragStoppedTH1AsA0(dragStopped.getVelocity());
                        return Unit.INSTANCE;
                    }
                    MutableInteractionSource mutableInteractionSource = this.interactionSource;
                    if (mutableInteractionSource != null) {
                        DragInteraction$Stop dragInteraction$Stop = new DragInteraction$Stop(dragInteraction$Start);
                        dragGestureNode$processDragStop$1.L$0 = this;
                        dragGestureNode$processDragStop$1.L$1 = dragStopped;
                        dragGestureNode$processDragStop$1.label = 1;
                        if (mutableInteractionSource.emit(dragInteraction$Stop, dragGestureNode$processDragStop$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    dragGestureNode = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    dragStopped = (DragEvent.DragStopped) dragGestureNode$processDragStop$1.L$1;
                    dragGestureNode = (DragGestureNode) dragGestureNode$processDragStop$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                dragGestureNode.dragInteraction = null;
                dragGestureNode.mo190onDragStoppedTH1AsA0(dragStopped.getVelocity());
                return Unit.INSTANCE;
            }
        }
        dragGestureNode$processDragStop$1 = new DragGestureNode$processDragStop$1(this, continuation);
        Object obj2 = dragGestureNode$processDragStop$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = dragGestureNode$processDragStop$1.label;
        if (i5 != 0) {
        }
        dragGestureNode.dragInteraction = null;
        dragGestureNode.mo190onDragStoppedTH1AsA0(dragStopped.getVelocity());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startListeningForEvents() {
        this.isListeningForEvents = true;
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new DragGestureNode$startListeningForEvents$1(this, null), 3, null);
    }

    public final void disposeInteractionSource() {
        DragInteraction$Start dragInteraction$Start = this.dragInteraction;
        if (dragInteraction$Start != null) {
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                mutableInteractionSource.tryEmit(new DragInteraction$Cancel(dragInteraction$Start));
            }
            this.dragInteraction = null;
        }
    }

    public abstract Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation);

    /* JADX INFO: Access modifiers changed from: protected */
    public final Function1<PointerInputChange, Boolean> getCanDrag() {
        return this.canDrag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean getEnabled() {
        return this.enabled;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.onCancelPointerInput();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.isListeningForEvents = false;
        disposeInteractionSource();
    }

    /* renamed from: onDragStarted-k-4lQ0M, reason: not valid java name */
    public abstract void mo189onDragStartedk4lQ0M(long startedPosition);

    /* renamed from: onDragStopped-TH1AsA0, reason: not valid java name */
    public abstract void mo190onDragStoppedTH1AsA0(long velocity);

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo91onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        if (this.enabled && this.pointerInputNode == null) {
            this.pointerInputNode = (SuspendingPointerInputModifierNode) delegate(initializePointerInputNode());
        }
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.mo91onPointerEventH0pRuoY(pointerEvent, pass, bounds);
        }
    }

    public abstract boolean startDragImmediately();

    public final void update(Function1<? super PointerInputChange, Boolean> canDrag, boolean enabled, MutableInteractionSource interactionSource, Orientation orientationLock, boolean shouldResetPointerInputHandling) {
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode;
        this.canDrag = canDrag;
        boolean z5 = true;
        if (this.enabled != enabled) {
            this.enabled = enabled;
            if (!enabled) {
                disposeInteractionSource();
                SuspendingPointerInputModifierNode suspendingPointerInputModifierNode2 = this.pointerInputNode;
                if (suspendingPointerInputModifierNode2 != null) {
                    undelegate(suspendingPointerInputModifierNode2);
                }
                this.pointerInputNode = null;
            }
            shouldResetPointerInputHandling = true;
        }
        if (!Intrinsics.areEqual(this.interactionSource, interactionSource)) {
            disposeInteractionSource();
            this.interactionSource = interactionSource;
        }
        if (this.orientationLock != orientationLock) {
            this.orientationLock = orientationLock;
        } else {
            z5 = shouldResetPointerInputHandling;
        }
        if (!z5 || (suspendingPointerInputModifierNode = this.pointerInputNode) == null) {
            return;
        }
        suspendingPointerInputModifierNode.resetPointerInputHandler();
    }
}
