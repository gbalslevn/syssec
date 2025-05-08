package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", BuildConfig.FLAVOR, "Landroidx/compose/ui/node/LayoutNode;", "root", "<init>", "(Landroidx/compose/ui/node/LayoutNode;)V", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "positionCalculator", BuildConfig.FLAVOR, "isInBounds", "Landroidx/compose/ui/input/pointer/ProcessResult;", "process-BIzXfog", "(Landroidx/compose/ui/input/pointer/PointerInputEvent;Landroidx/compose/ui/input/pointer/PositionCalculator;Z)I", "process", BuildConfig.FLAVOR, "processCancel", "()V", "clearPreviouslyHitModifierNodes", "Landroidx/compose/ui/node/LayoutNode;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/input/pointer/HitPathTracker;", "hitPathTracker", "Landroidx/compose/ui/input/pointer/HitPathTracker;", "Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer;", "pointerInputChangeEventProducer", "Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer;", "Landroidx/compose/ui/node/HitTestResult;", "hitResult", "Landroidx/compose/ui/node/HitTestResult;", "isProcessing", "Z", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PointerInputEventProcessor {
    private final HitPathTracker hitPathTracker;
    private boolean isProcessing;
    private final LayoutNode root;
    private final PointerInputChangeEventProducer pointerInputChangeEventProducer = new PointerInputChangeEventProducer();
    private final HitTestResult hitResult = new HitTestResult();

    public PointerInputEventProcessor(LayoutNode layoutNode) {
        this.root = layoutNode;
        this.hitPathTracker = new HitPathTracker(layoutNode.getCoordinates());
    }

    public final void clearPreviouslyHitModifierNodes() {
        this.hitPathTracker.clearPreviouslyHitModifierNodeCache();
    }

    /* renamed from: process-BIzXfog, reason: not valid java name */
    public final int m1892processBIzXfog(PointerInputEvent pointerEvent, PositionCalculator positionCalculator, boolean isInBounds) {
        boolean z5;
        if (this.isProcessing) {
            return PointerInputEventProcessorKt.ProcessResult(false, false);
        }
        boolean z6 = true;
        try {
            this.isProcessing = true;
            InternalPointerEvent produce = this.pointerInputChangeEventProducer.produce(pointerEvent, positionCalculator);
            int size = produce.getChanges().size();
            for (int i5 = 0; i5 < size; i5++) {
                PointerInputChange valueAt = produce.getChanges().valueAt(i5);
                if (!valueAt.getPressed() && !valueAt.getPreviousPressed()) {
                }
                z5 = false;
                break;
            }
            z5 = true;
            int size2 = produce.getChanges().size();
            for (int i6 = 0; i6 < size2; i6++) {
                PointerInputChange valueAt2 = produce.getChanges().valueAt(i6);
                if (z5 || PointerEventKt.changedToDownIgnoreConsumed(valueAt2)) {
                    LayoutNode.m1999hitTestM_7yMNQ$ui_release$default(this.root, valueAt2.getPosition(), this.hitResult, PointerType.m1904equalsimpl0(valueAt2.getType(), PointerType.INSTANCE.m1910getTouchT8wyACA()), false, 8, null);
                    if (!this.hitResult.isEmpty()) {
                        this.hitPathTracker.m1847addHitPathQJqDSyo(valueAt2.getId(), this.hitResult, PointerEventKt.changedToDownIgnoreConsumed(valueAt2));
                        this.hitResult.clear();
                    }
                }
            }
            this.hitPathTracker.removeDetachedPointerInputNodes();
            boolean dispatchChanges = this.hitPathTracker.dispatchChanges(produce, isInBounds);
            if (!produce.getSuppressMovementConsumption()) {
                int size3 = produce.getChanges().size();
                for (int i7 = 0; i7 < size3; i7++) {
                    PointerInputChange valueAt3 = produce.getChanges().valueAt(i7);
                    if (PointerEventKt.positionChangedIgnoreConsumed(valueAt3) && valueAt3.isConsumed()) {
                        break;
                    }
                }
            }
            z6 = false;
            int ProcessResult = PointerInputEventProcessorKt.ProcessResult(dispatchChanges, z6);
            this.isProcessing = false;
            return ProcessResult;
        } catch (Throwable th) {
            this.isProcessing = false;
            throw th;
        }
    }

    public final void processCancel() {
        if (this.isProcessing) {
            return;
        }
        this.pointerInputChangeEventProducer.clear();
        this.hitPathTracker.processCancel();
    }
}
