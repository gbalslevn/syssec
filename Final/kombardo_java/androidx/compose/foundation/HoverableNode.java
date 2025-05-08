package androidx.compose.foundation;

import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.node.PointerInputModifierNode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\nJ\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J*\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001a\u00020\tH\u0002J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/HoverableNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "hoverInteraction", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "emitEnter", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitExit", "onCancelPointerInput", "onDetach", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "tryEmitExit", "updateInteractionSource", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class HoverableNode extends Modifier.Node implements PointerInputModifierNode {
    private HoverInteraction$Enter hoverInteraction;
    private MutableInteractionSource interactionSource;

    public HoverableNode(MutableInteractionSource mutableInteractionSource) {
        this.interactionSource = mutableInteractionSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emitEnter(Continuation<? super Unit> continuation) {
        HoverableNode$emitEnter$1 hoverableNode$emitEnter$1;
        int i5;
        HoverableNode hoverableNode;
        HoverInteraction$Enter hoverInteraction$Enter;
        if (continuation instanceof HoverableNode$emitEnter$1) {
            hoverableNode$emitEnter$1 = (HoverableNode$emitEnter$1) continuation;
            int i6 = hoverableNode$emitEnter$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                hoverableNode$emitEnter$1.label = i6 - Integer.MIN_VALUE;
                Object obj = hoverableNode$emitEnter$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = hoverableNode$emitEnter$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.hoverInteraction == null) {
                        HoverInteraction$Enter hoverInteraction$Enter2 = new HoverInteraction$Enter();
                        MutableInteractionSource mutableInteractionSource = this.interactionSource;
                        hoverableNode$emitEnter$1.L$0 = this;
                        hoverableNode$emitEnter$1.L$1 = hoverInteraction$Enter2;
                        hoverableNode$emitEnter$1.label = 1;
                        if (mutableInteractionSource.emit(hoverInteraction$Enter2, hoverableNode$emitEnter$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        hoverableNode = this;
                        hoverInteraction$Enter = hoverInteraction$Enter2;
                    }
                    return Unit.INSTANCE;
                }
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                hoverInteraction$Enter = (HoverInteraction$Enter) hoverableNode$emitEnter$1.L$1;
                hoverableNode = (HoverableNode) hoverableNode$emitEnter$1.L$0;
                ResultKt.throwOnFailure(obj);
                hoverableNode.hoverInteraction = hoverInteraction$Enter;
                return Unit.INSTANCE;
            }
        }
        hoverableNode$emitEnter$1 = new HoverableNode$emitEnter$1(this, continuation);
        Object obj2 = hoverableNode$emitEnter$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = hoverableNode$emitEnter$1.label;
        if (i5 != 0) {
        }
        hoverableNode.hoverInteraction = hoverInteraction$Enter;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emitExit(Continuation<? super Unit> continuation) {
        HoverableNode$emitExit$1 hoverableNode$emitExit$1;
        int i5;
        HoverableNode hoverableNode;
        if (continuation instanceof HoverableNode$emitExit$1) {
            hoverableNode$emitExit$1 = (HoverableNode$emitExit$1) continuation;
            int i6 = hoverableNode$emitExit$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                hoverableNode$emitExit$1.label = i6 - Integer.MIN_VALUE;
                Object obj = hoverableNode$emitExit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = hoverableNode$emitExit$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    HoverInteraction$Enter hoverInteraction$Enter = this.hoverInteraction;
                    if (hoverInteraction$Enter != null) {
                        HoverInteraction$Exit hoverInteraction$Exit = new HoverInteraction$Exit(hoverInteraction$Enter);
                        MutableInteractionSource mutableInteractionSource = this.interactionSource;
                        hoverableNode$emitExit$1.L$0 = this;
                        hoverableNode$emitExit$1.label = 1;
                        if (mutableInteractionSource.emit(hoverInteraction$Exit, hoverableNode$emitExit$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        hoverableNode = this;
                    }
                    return Unit.INSTANCE;
                }
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                hoverableNode = (HoverableNode) hoverableNode$emitExit$1.L$0;
                ResultKt.throwOnFailure(obj);
                hoverableNode.hoverInteraction = null;
                return Unit.INSTANCE;
            }
        }
        hoverableNode$emitExit$1 = new HoverableNode$emitExit$1(this, continuation);
        Object obj2 = hoverableNode$emitExit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = hoverableNode$emitExit$1.label;
        if (i5 != 0) {
        }
        hoverableNode.hoverInteraction = null;
        return Unit.INSTANCE;
    }

    private final void tryEmitExit() {
        HoverInteraction$Enter hoverInteraction$Enter = this.hoverInteraction;
        if (hoverInteraction$Enter != null) {
            this.interactionSource.tryEmit(new HoverInteraction$Exit(hoverInteraction$Enter));
            this.hoverInteraction = null;
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        tryEmitExit();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        tryEmitExit();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo91onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        if (pass == PointerEventPass.Main) {
            int type = pointerEvent.getType();
            PointerEventType.Companion companion = PointerEventType.INSTANCE;
            if (PointerEventType.m1859equalsimpl0(type, companion.m1860getEnter7fucELk())) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new HoverableNode$onPointerEvent$1(this, null), 3, null);
            } else if (PointerEventType.m1859equalsimpl0(type, companion.m1861getExit7fucELk())) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new HoverableNode$onPointerEvent$2(this, null), 3, null);
            }
        }
    }

    public final void updateInteractionSource(MutableInteractionSource interactionSource) {
        if (Intrinsics.areEqual(this.interactionSource, interactionSource)) {
            return;
        }
        tryEmitExit();
        this.interactionSource = interactionSource;
    }
}
