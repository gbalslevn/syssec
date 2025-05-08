package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1", f = "Draggable.kt", l = {431, 433, 435, 442, 444, 447}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DragGestureNode$startListeningForEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DragGestureNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", BuildConfig.FLAVOR, "processDelta", "<anonymous>", "(Lkotlin/jvm/functions/Function1;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1", f = "Draggable.kt", l = {438}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Function1<? super DragEvent.DragDelta, ? extends Unit>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref$ObjectRef<DragEvent> $event;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ DragGestureNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref$ObjectRef<DragEvent> ref$ObjectRef, DragGestureNode dragGestureNode, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$event = ref$ObjectRef;
            this.this$0 = dragGestureNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$event, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Function1<? super DragEvent.DragDelta, ? extends Unit> function1, Continuation<? super Unit> continuation) {
            return invoke2((Function1<? super DragEvent.DragDelta, Unit>) function1, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:9:0x002f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:6:0x005b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:5:0x0058). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Function1 function1;
            DragEvent dragEvent;
            Channel channel;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                function1 = (Function1) this.L$0;
                dragEvent = this.$event.element;
                if (dragEvent instanceof DragEvent.DragStopped) {
                }
                return Unit.INSTANCE;
            }
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref$ObjectRef<DragEvent> ref$ObjectRef = (Ref$ObjectRef) this.L$1;
            function1 = (Function1) this.L$0;
            ResultKt.throwOnFailure(obj);
            T t5 = (DragEvent) obj;
            ref$ObjectRef.element = t5;
            dragEvent = this.$event.element;
            if (!(dragEvent instanceof DragEvent.DragStopped) || (dragEvent instanceof DragEvent.DragCancelled)) {
                return Unit.INSTANCE;
            }
            t5 = 0;
            DragEvent.DragDelta dragDelta = dragEvent instanceof DragEvent.DragDelta ? (DragEvent.DragDelta) dragEvent : null;
            if (dragDelta != null) {
                function1.invoke(dragDelta);
            }
            ref$ObjectRef = this.$event;
            channel = this.this$0.channel;
            if (channel != null) {
                this.L$0 = function1;
                this.L$1 = ref$ObjectRef;
                this.label = 1;
                obj = channel.receive(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                T t52 = (DragEvent) obj;
            }
            ref$ObjectRef.element = t52;
            dragEvent = this.$event.element;
            if (dragEvent instanceof DragEvent.DragStopped) {
            }
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Function1<? super DragEvent.DragDelta, Unit> function1, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(function1, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragGestureNode$startListeningForEvents$1(DragGestureNode dragGestureNode, Continuation<? super DragGestureNode$startListeningForEvents$1> continuation) {
        super(2, continuation);
        this.this$0 = dragGestureNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureNode$startListeningForEvents$1 dragGestureNode$startListeningForEvents$1 = new DragGestureNode$startListeningForEvents$1(this.this$0, continuation);
        dragGestureNode$startListeningForEvents$1.L$0 = obj;
        return dragGestureNode$startListeningForEvents$1;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:22|23|(1:42)|25|26|27|(2:32|(2:34|(1:36)))(2:29|(1:31))) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d7, code lost:
    
        r1 = r4;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c0 A[Catch: CancellationException -> 0x00d7, TryCatch #1 {CancellationException -> 0x00d7, blocks: (B:27:0x00ba, B:29:0x00c0, B:32:0x00d9, B:34:0x00dd), top: B:26:0x00ba }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d9 A[Catch: CancellationException -> 0x00d7, TryCatch #1 {CancellationException -> 0x00d7, blocks: (B:27:0x00ba, B:29:0x00c0, B:32:0x00d9, B:34:0x00dd), top: B:26:0x00ba }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fd  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x008d -> B:8:0x005e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00d4 -> B:8:0x005e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00db -> B:8:0x005e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00ea -> B:8:0x005e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00fa -> B:7:0x0027). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Ref$ObjectRef ref$ObjectRef;
        Ref$ObjectRef ref$ObjectRef2;
        Ref$ObjectRef ref$ObjectRef3;
        CoroutineScope coroutineScope2;
        CoroutineScope coroutineScope3;
        Object processDragCancel;
        T t5;
        Object processDragCancel2;
        Object processDragStop;
        DragGestureNode dragGestureNode;
        AnonymousClass1 anonymousClass1;
        T t6;
        T t7;
        Object processDragStart;
        Channel channel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                    ref$ObjectRef = new Ref$ObjectRef();
                    channel = this.this$0.channel;
                    if (channel != null) {
                        this.L$0 = coroutineScope;
                        this.L$1 = ref$ObjectRef;
                        this.L$2 = ref$ObjectRef;
                        this.label = 1;
                        obj = channel.receive(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ref$ObjectRef2 = ref$ObjectRef;
                        t6 = (DragEvent) obj;
                        ref$ObjectRef.element = t6;
                        t7 = ref$ObjectRef2.element;
                        if (t7 instanceof DragEvent.DragStarted) {
                            this.L$0 = coroutineScope;
                            this.L$1 = ref$ObjectRef2;
                            this.L$2 = null;
                            this.label = 2;
                            processDragStart = this.this$0.processDragStart((DragEvent.DragStarted) t7, this);
                            if (processDragStart == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ref$ObjectRef3 = ref$ObjectRef2;
                            coroutineScope2 = coroutineScope;
                            dragGestureNode = this.this$0;
                            anonymousClass1 = new AnonymousClass1(ref$ObjectRef3, dragGestureNode, null);
                            this.L$0 = coroutineScope2;
                            this.L$1 = ref$ObjectRef3;
                            this.label = 3;
                            if (dragGestureNode.drag(anonymousClass1, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            coroutineScope = coroutineScope2;
                            t5 = ref$ObjectRef3.element;
                            if (t5 instanceof DragEvent.DragStopped) {
                                DragGestureNode dragGestureNode2 = this.this$0;
                                Intrinsics.checkNotNull(t5, "null cannot be cast to non-null type androidx.compose.foundation.gestures.DragEvent.DragStopped");
                                this.L$0 = coroutineScope;
                                this.L$1 = null;
                                this.label = 4;
                                processDragStop = dragGestureNode2.processDragStop((DragEvent.DragStopped) t5, this);
                                if (processDragStop == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (t5 instanceof DragEvent.DragCancelled) {
                                DragGestureNode dragGestureNode3 = this.this$0;
                                this.L$0 = coroutineScope;
                                this.L$1 = null;
                                this.label = 5;
                                processDragCancel2 = dragGestureNode3.processDragCancel(this);
                                if (processDragCancel2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
                        if (!CoroutineScopeKt.isActive(coroutineScope)) {
                            return Unit.INSTANCE;
                        }
                    } else {
                        ref$ObjectRef2 = ref$ObjectRef;
                        t6 = 0;
                        ref$ObjectRef.element = t6;
                        t7 = ref$ObjectRef2.element;
                        if (t7 instanceof DragEvent.DragStarted) {
                        }
                        if (!CoroutineScopeKt.isActive(coroutineScope)) {
                        }
                    }
                }
            case 1:
                ref$ObjectRef = (Ref$ObjectRef) this.L$2;
                ref$ObjectRef2 = (Ref$ObjectRef) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                t6 = (DragEvent) obj;
                ref$ObjectRef.element = t6;
                t7 = ref$ObjectRef2.element;
                if (t7 instanceof DragEvent.DragStarted) {
                }
                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                }
                break;
            case 2:
                ref$ObjectRef3 = (Ref$ObjectRef) this.L$1;
                coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                dragGestureNode = this.this$0;
                anonymousClass1 = new AnonymousClass1(ref$ObjectRef3, dragGestureNode, null);
                this.L$0 = coroutineScope2;
                this.L$1 = ref$ObjectRef3;
                this.label = 3;
                if (dragGestureNode.drag(anonymousClass1, this) == coroutine_suspended) {
                }
                coroutineScope = coroutineScope2;
                t5 = ref$ObjectRef3.element;
                if (t5 instanceof DragEvent.DragStopped) {
                }
                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                }
                break;
            case 3:
                ref$ObjectRef3 = (Ref$ObjectRef) this.L$1;
                coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (CancellationException unused) {
                    coroutineScope3 = coroutineScope2;
                    DragGestureNode dragGestureNode4 = this.this$0;
                    this.L$0 = coroutineScope3;
                    this.L$1 = null;
                    this.label = 6;
                    processDragCancel = dragGestureNode4.processDragCancel(this);
                    if (processDragCancel == coroutine_suspended) {
                    }
                    coroutineScope = coroutineScope3;
                    if (!CoroutineScopeKt.isActive(coroutineScope)) {
                    }
                }
                coroutineScope = coroutineScope2;
                t5 = ref$ObjectRef3.element;
                if (t5 instanceof DragEvent.DragStopped) {
                }
                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                }
                break;
            case 4:
                coroutineScope3 = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (CancellationException unused2) {
                    DragGestureNode dragGestureNode42 = this.this$0;
                    this.L$0 = coroutineScope3;
                    this.L$1 = null;
                    this.label = 6;
                    processDragCancel = dragGestureNode42.processDragCancel(this);
                    if (processDragCancel == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coroutineScope = coroutineScope3;
                    if (!CoroutineScopeKt.isActive(coroutineScope)) {
                    }
                }
                coroutineScope = coroutineScope3;
                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                }
                break;
            case 5:
                coroutineScope3 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                coroutineScope = coroutineScope3;
                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                }
                break;
            case 6:
                coroutineScope3 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                coroutineScope = coroutineScope3;
                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DragGestureNode$startListeningForEvents$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
