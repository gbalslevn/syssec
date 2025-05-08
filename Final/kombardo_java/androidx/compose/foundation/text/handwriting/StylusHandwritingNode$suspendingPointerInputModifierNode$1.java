package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1", f = "StylusHandwriting.kt", l = {132}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class StylusHandwritingNode$suspendingPointerInputModifierNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StylusHandwritingNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1$1", f = "StylusHandwriting.kt", l = {134, 158, 186}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ StylusHandwritingNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StylusHandwritingNode stylusHandwritingNode, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = stylusHandwritingNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x01b8  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x01bb  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0180 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x01b3 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00f7  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x01c2  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00e9 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x011d A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x018e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x017e -> B:7:0x0181). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00e7 -> B:29:0x00ea). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AwaitPointerEventScope awaitPointerEventScope;
            Object awaitFirstDown;
            boolean z5;
            AwaitPointerEventScope awaitPointerEventScope2;
            PointerEventPass pointerEventPass;
            PointerInputChange pointerInputChange;
            Object awaitPointerEvent;
            int size;
            int i5;
            PointerInputChange pointerInputChange2;
            PointerInputChange pointerInputChange3;
            PointerInputChange pointerInputChange4;
            AwaitPointerEventScope awaitPointerEventScope3;
            Object awaitPointerEvent2;
            int size2;
            int i6;
            PointerInputChange pointerInputChange5;
            PointerInputChange pointerInputChange6;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i7 = this.label;
            int i8 = 2;
            if (i7 == 0) {
                ResultKt.throwOnFailure(obj);
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                PointerEventPass pointerEventPass2 = PointerEventPass.Initial;
                this.L$0 = awaitPointerEventScope;
                this.label = 1;
                awaitFirstDown = TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, true, pointerEventPass2, this);
                if (awaitFirstDown == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i7 == 1) {
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                awaitFirstDown = obj;
            } else if (i7 == 2) {
                pointerEventPass = (PointerEventPass) this.L$2;
                pointerInputChange = (PointerInputChange) this.L$1;
                awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                awaitPointerEvent = obj;
                List<PointerInputChange> changes = ((PointerEvent) awaitPointerEvent).getChanges();
                size = changes.size();
                i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes.get(i5);
                    PointerInputChange pointerInputChange7 = pointerInputChange2;
                    if (!pointerInputChange7.isConsumed() && PointerId.m1872equalsimpl0(pointerInputChange7.getId(), pointerInputChange.getId()) && pointerInputChange7.getPressed()) {
                        break;
                    }
                    i5++;
                }
                pointerInputChange3 = pointerInputChange2;
                if (pointerInputChange3 == null || pointerInputChange3.getUptimeMillis() - pointerInputChange.getUptimeMillis() >= awaitPointerEventScope2.getViewConfiguration().getLongPressTimeoutMillis()) {
                    pointerInputChange3 = null;
                } else if (Offset.m1335getDistanceimpl(Offset.m1341minusMKHz9U(pointerInputChange3.getPosition(), pointerInputChange.getPosition())) <= awaitPointerEventScope2.getViewConfiguration().getHandwritingSlop()) {
                    i8 = 2;
                    this.L$0 = awaitPointerEventScope2;
                    this.L$1 = pointerInputChange;
                    this.L$2 = pointerEventPass;
                    this.label = i8;
                    awaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass, this);
                    if (awaitPointerEvent == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    List<PointerInputChange> changes2 = ((PointerEvent) awaitPointerEvent).getChanges();
                    size = changes2.size();
                    i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                        }
                        i5++;
                    }
                    pointerInputChange3 = pointerInputChange2;
                    if (pointerInputChange3 == null) {
                        if (Offset.m1335getDistanceimpl(Offset.m1341minusMKHz9U(pointerInputChange3.getPosition(), pointerInputChange.getPosition())) <= awaitPointerEventScope2.getViewConfiguration().getHandwritingSlop()) {
                        }
                    }
                    pointerInputChange3 = null;
                }
                if (pointerInputChange3 != null || !this.this$0.getOnHandwritingSlopExceeded().invoke().booleanValue()) {
                    return Unit.INSTANCE;
                }
                pointerInputChange3.consume();
                pointerInputChange4 = pointerInputChange;
                awaitPointerEventScope3 = awaitPointerEventScope2;
                PointerEventPass pointerEventPass3 = PointerEventPass.Initial;
                this.L$0 = awaitPointerEventScope3;
                this.L$1 = pointerInputChange4;
                this.L$2 = null;
                this.label = 3;
                awaitPointerEvent2 = awaitPointerEventScope3.awaitPointerEvent(pointerEventPass3, this);
                if (awaitPointerEvent2 == coroutine_suspended) {
                }
                List<PointerInputChange> changes3 = ((PointerEvent) awaitPointerEvent2).getChanges();
                size2 = changes3.size();
                i6 = 0;
                while (true) {
                    if (i6 >= size2) {
                    }
                    i6++;
                }
                pointerInputChange6 = pointerInputChange5;
                if (pointerInputChange6 == null) {
                }
            } else {
                if (i7 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pointerInputChange4 = (PointerInputChange) this.L$1;
                awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                awaitPointerEvent2 = obj;
                List<PointerInputChange> changes32 = ((PointerEvent) awaitPointerEvent2).getChanges();
                size2 = changes32.size();
                i6 = 0;
                while (true) {
                    if (i6 >= size2) {
                        pointerInputChange5 = null;
                        break;
                    }
                    pointerInputChange5 = changes32.get(i6);
                    PointerInputChange pointerInputChange8 = pointerInputChange5;
                    if (!pointerInputChange8.isConsumed() && PointerId.m1872equalsimpl0(pointerInputChange8.getId(), pointerInputChange4.getId()) && pointerInputChange8.getPressed()) {
                        break;
                    }
                    i6++;
                }
                pointerInputChange6 = pointerInputChange5;
                if (pointerInputChange6 == null) {
                    return Unit.INSTANCE;
                }
                pointerInputChange6.consume();
                PointerEventPass pointerEventPass32 = PointerEventPass.Initial;
                this.L$0 = awaitPointerEventScope3;
                this.L$1 = pointerInputChange4;
                this.L$2 = null;
                this.label = 3;
                awaitPointerEvent2 = awaitPointerEventScope3.awaitPointerEvent(pointerEventPass32, this);
                if (awaitPointerEvent2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                List<PointerInputChange> changes322 = ((PointerEvent) awaitPointerEvent2).getChanges();
                size2 = changes322.size();
                i6 = 0;
                while (true) {
                    if (i6 >= size2) {
                    }
                    i6++;
                }
                pointerInputChange6 = pointerInputChange5;
                if (pointerInputChange6 == null) {
                }
            }
            PointerInputChange pointerInputChange9 = (PointerInputChange) awaitFirstDown;
            int type = pointerInputChange9.getType();
            PointerType.Companion companion = PointerType.INSTANCE;
            if (!PointerType.m1904equalsimpl0(type, companion.m1909getStylusT8wyACA()) && !PointerType.m1904equalsimpl0(pointerInputChange9.getType(), companion.m1907getEraserT8wyACA())) {
                return Unit.INSTANCE;
            }
            boolean z6 = Offset.m1337getXimpl(pointerInputChange9.getPosition()) >= 0.0f && Offset.m1337getXimpl(pointerInputChange9.getPosition()) < ((float) IntSize.m2661getWidthimpl(awaitPointerEventScope.mo1844getSizeYbymL2g())) && Offset.m1338getYimpl(pointerInputChange9.getPosition()) >= 0.0f && Offset.m1338getYimpl(pointerInputChange9.getPosition()) < ((float) IntSize.m2660getHeightimpl(awaitPointerEventScope.mo1844getSizeYbymL2g()));
            z5 = this.this$0.focused;
            awaitPointerEventScope2 = awaitPointerEventScope;
            pointerEventPass = (z5 || z6) ? PointerEventPass.Initial : PointerEventPass.Main;
            pointerInputChange = pointerInputChange9;
            this.L$0 = awaitPointerEventScope2;
            this.L$1 = pointerInputChange;
            this.L$2 = pointerEventPass;
            this.label = i8;
            awaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass, this);
            if (awaitPointerEvent == coroutine_suspended) {
            }
            List<PointerInputChange> changes22 = ((PointerEvent) awaitPointerEvent).getChanges();
            size = changes22.size();
            i5 = 0;
            while (true) {
                if (i5 >= size) {
                }
                i5++;
            }
            pointerInputChange3 = pointerInputChange2;
            if (pointerInputChange3 == null) {
            }
            pointerInputChange3 = null;
            if (pointerInputChange3 != null) {
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StylusHandwritingNode$suspendingPointerInputModifierNode$1(StylusHandwritingNode stylusHandwritingNode, Continuation<? super StylusHandwritingNode$suspendingPointerInputModifierNode$1> continuation) {
        super(2, continuation);
        this.this$0 = stylusHandwritingNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StylusHandwritingNode$suspendingPointerInputModifierNode$1 stylusHandwritingNode$suspendingPointerInputModifierNode$1 = new StylusHandwritingNode$suspendingPointerInputModifierNode$1(this.this$0, continuation);
        stylusHandwritingNode$suspendingPointerInputModifierNode$1.L$0 = obj;
        return stylusHandwritingNode$suspendingPointerInputModifierNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((StylusHandwritingNode$suspendingPointerInputModifierNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (ForEachGestureKt.awaitEachGesture(pointerInputScope, anonymousClass1, this) == coroutine_suspended) {
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
