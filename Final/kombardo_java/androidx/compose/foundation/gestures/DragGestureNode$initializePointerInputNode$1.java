package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.VelocityKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1", f = "Draggable.kt", l = {524}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DragGestureNode$initializePointerInputNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DragGestureNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1", f = "Draggable.kt", l = {526}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputScope $$this$SuspendingPointerInputModifierNode;
        final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function1<PointerInputChange, Unit> $onDragEnd;
        final /* synthetic */ Function3<PointerInputChange, PointerInputChange, Offset, Unit> $onDragStart;
        final /* synthetic */ Function0<Boolean> $shouldAwaitTouchSlop;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DragGestureNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(DragGestureNode dragGestureNode, PointerInputScope pointerInputScope, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function1<? super PointerInputChange, Unit> function1, Function0<Unit> function0, Function0<Boolean> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = dragGestureNode;
            this.$$this$SuspendingPointerInputModifierNode = pointerInputScope;
            this.$onDragStart = function3;
            this.$onDragEnd = function1;
            this.$onDragCancel = function0;
            this.$shouldAwaitTouchSlop = function02;
            this.$onDrag = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$$this$SuspendingPointerInputModifierNode, this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$shouldAwaitTouchSlop, this.$onDrag, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            CancellationException e5;
            Orientation orientation;
            Channel channel;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    orientation = this.this$0.orientationLock;
                    PointerInputScope pointerInputScope = this.$$this$SuspendingPointerInputModifierNode;
                    Function3<PointerInputChange, PointerInputChange, Offset, Unit> function3 = this.$onDragStart;
                    Function1<PointerInputChange, Unit> function1 = this.$onDragEnd;
                    Function0<Unit> function0 = this.$onDragCancel;
                    Function0<Boolean> function02 = this.$shouldAwaitTouchSlop;
                    Function2<PointerInputChange, Offset, Unit> function2 = this.$onDrag;
                    this.L$0 = coroutineScope2;
                    this.label = 1;
                    if (DragGestureDetectorKt.detectDragGestures(pointerInputScope, function3, function1, function0, function02, orientation, function2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (CancellationException e6) {
                    coroutineScope = coroutineScope2;
                    e5 = e6;
                    channel = this.this$0.channel;
                    if (channel != null) {
                        ChannelResult.m3768boximpl(channel.mo3767trySendJP2dKIU(DragEvent.DragCancelled.INSTANCE));
                    }
                    if (!CoroutineScopeKt.isActive(coroutineScope)) {
                        throw e5;
                    }
                    return Unit.INSTANCE;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (CancellationException e7) {
                    e5 = e7;
                    channel = this.this$0.channel;
                    if (channel != null) {
                    }
                    if (!CoroutineScopeKt.isActive(coroutineScope)) {
                    }
                    return Unit.INSTANCE;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragGestureNode$initializePointerInputNode$1(DragGestureNode dragGestureNode, Continuation<? super DragGestureNode$initializePointerInputNode$1> continuation) {
        super(2, continuation);
        this.this$0 = dragGestureNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureNode$initializePointerInputNode$1 dragGestureNode$initializePointerInputNode$1 = new DragGestureNode$initializePointerInputNode$1(this.this$0, continuation);
        dragGestureNode$initializePointerInputNode$1.L$0 = obj;
        return dragGestureNode$initializePointerInputNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((DragGestureNode$initializePointerInputNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            final VelocityTracker velocityTracker = new VelocityTracker();
            final DragGestureNode dragGestureNode = this.this$0;
            Function3<PointerInputChange, PointerInputChange, Offset, Unit> function3 = new Function3<PointerInputChange, PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragStart$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, Offset offset) {
                    m192invoke0AR0LA0(pointerInputChange, pointerInputChange2, offset.getPackedValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-0AR0LA0, reason: not valid java name */
                public final void m192invoke0AR0LA0(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, long j5) {
                    boolean z5;
                    Channel channel;
                    Channel channel2;
                    if (DragGestureNode.this.getCanDrag().invoke(pointerInputChange).booleanValue()) {
                        z5 = DragGestureNode.this.isListeningForEvents;
                        if (!z5) {
                            channel2 = DragGestureNode.this.channel;
                            if (channel2 == null) {
                                DragGestureNode.this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
                            }
                            DragGestureNode.this.startListeningForEvents();
                        }
                        VelocityTrackerKt.addPointerInputChange(velocityTracker, pointerInputChange);
                        long m1341minusMKHz9U = Offset.m1341minusMKHz9U(pointerInputChange2.getPosition(), j5);
                        channel = DragGestureNode.this.channel;
                        if (channel != null) {
                            ChannelResult.m3768boximpl(channel.mo3767trySendJP2dKIU(new DragEvent.DragStarted(m1341minusMKHz9U, null)));
                        }
                    }
                }
            };
            final DragGestureNode dragGestureNode2 = this.this$0;
            Function1<PointerInputChange, Unit> function1 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragEnd$1
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
                    Channel channel;
                    long m198toValidVelocityTH1AsA0;
                    VelocityTrackerKt.addPointerInputChange(VelocityTracker.this, pointerInputChange);
                    float maximumFlingVelocity = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(dragGestureNode2, CompositionLocalsKt.getLocalViewConfiguration())).getMaximumFlingVelocity();
                    long m1924calculateVelocityAH228Gc = VelocityTracker.this.m1924calculateVelocityAH228Gc(VelocityKt.Velocity(maximumFlingVelocity, maximumFlingVelocity));
                    VelocityTracker.this.resetTracking();
                    channel = dragGestureNode2.channel;
                    if (channel != null) {
                        m198toValidVelocityTH1AsA0 = DraggableKt.m198toValidVelocityTH1AsA0(m1924calculateVelocityAH228Gc);
                        ChannelResult.m3768boximpl(channel.mo3767trySendJP2dKIU(new DragEvent.DragStopped(m198toValidVelocityTH1AsA0, null)));
                    }
                }
            };
            final DragGestureNode dragGestureNode3 = this.this$0;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragCancel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Channel channel;
                    channel = DragGestureNode.this.channel;
                    if (channel != null) {
                        ChannelResult.m3768boximpl(channel.mo3767trySendJP2dKIU(DragEvent.DragCancelled.INSTANCE));
                    }
                }
            };
            final DragGestureNode dragGestureNode4 = this.this$0;
            Function0<Boolean> function02 = new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$shouldAwaitTouchSlop$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(!DragGestureNode.this.getStartDragImmediately());
                }
            };
            final DragGestureNode dragGestureNode5 = this.this$0;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, pointerInputScope, function3, function1, function0, function02, new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDrag$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                    m191invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
                public final void m191invokeUv8p0NA(PointerInputChange pointerInputChange, long j5) {
                    Channel channel;
                    VelocityTrackerKt.addPointerInputChange(VelocityTracker.this, pointerInputChange);
                    channel = dragGestureNode5.channel;
                    if (channel != null) {
                        ChannelResult.m3768boximpl(channel.mo3767trySendJP2dKIU(new DragEvent.DragDelta(j5, null)));
                    }
                }
            }, null);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(anonymousClass1, this) == coroutine_suspended) {
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
