package androidx.compose.foundation.contextmenu;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt$onRightClickDown$2", f = "ContextMenuGestures.android.kt", l = {53, 56}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ContextMenuGestures_androidKt$onRightClickDown$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Offset, Unit> $onDown;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContextMenuGestures_androidKt$onRightClickDown$2(Function1<? super Offset, Unit> function1, Continuation<? super ContextMenuGestures_androidKt$onRightClickDown$2> continuation) {
        super(2, continuation);
        this.$onDown = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ContextMenuGestures_androidKt$onRightClickDown$2 contextMenuGestures_androidKt$onRightClickDown$2 = new ContextMenuGestures_androidKt$onRightClickDown$2(this.$onDown, continuation);
        contextMenuGestures_androidKt$onRightClickDown$2.L$0 = obj;
        return contextMenuGestures_androidKt$onRightClickDown$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((ContextMenuGestures_androidKt$onRightClickDown$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0057  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AwaitPointerEventScope awaitPointerEventScope;
        PointerInputChange pointerInputChange;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            this.L$0 = awaitPointerEventScope;
            this.label = 1;
            obj = ContextMenuGestures_androidKt.awaitFirstRightClickDown(awaitPointerEventScope, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                    pointerInputChange.consume();
                }
                return Unit.INSTANCE;
            }
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        PointerInputChange pointerInputChange2 = (PointerInputChange) obj;
        pointerInputChange2.consume();
        this.$onDown.invoke(Offset.m1328boximpl(pointerInputChange2.getPosition()));
        this.L$0 = null;
        this.label = 2;
        obj = TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope, null, this, 1, null);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        pointerInputChange = (PointerInputChange) obj;
        if (pointerInputChange != null) {
        }
        return Unit.INSTANCE;
    }
}
