package androidx.compose.ui.input.pointer;

import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInteropFilter;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\tH\u0016J*\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\tH\u0002R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"androidx/compose/ui/input/pointer/PointerInteropFilter$pointerInputFilter$1", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "shareWithSiblings", BuildConfig.FLAVOR, "getShareWithSiblings", "()Z", "state", "Landroidx/compose/ui/input/pointer/PointerInteropFilter$DispatchToViewState;", "dispatchToView", BuildConfig.FLAVOR, "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "onCancel", "onPointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "reset", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PointerInteropFilter$pointerInputFilter$1 extends PointerInputFilter {
    private PointerInteropFilter.DispatchToViewState state = PointerInteropFilter.DispatchToViewState.Unknown;
    final /* synthetic */ PointerInteropFilter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PointerInteropFilter$pointerInputFilter$1(PointerInteropFilter pointerInteropFilter) {
        this.this$0 = pointerInteropFilter;
    }

    private final void dispatchToView(PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (changes.get(i5).isConsumed()) {
                if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
                    LayoutCoordinates layoutCoordinates = getLayoutCoordinates();
                    if (layoutCoordinates == null) {
                        throw new IllegalStateException("layoutCoordinates not set");
                    }
                    long mo1951localToRootMKHz9U = layoutCoordinates.mo1951localToRootMKHz9U(Offset.INSTANCE.m1349getZeroF1C5BW0());
                    final PointerInteropFilter pointerInteropFilter = this.this$0;
                    PointerInteropUtils_androidKt.m1894toCancelMotionEventScoped4ec7I(pointerEvent, mo1951localToRootMKHz9U, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$dispatchToView$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(MotionEvent motionEvent) {
                            invoke2(motionEvent);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(MotionEvent motionEvent) {
                            PointerInteropFilter.this.getOnTouchEvent().invoke(motionEvent);
                        }
                    });
                }
                this.state = PointerInteropFilter.DispatchToViewState.NotDispatching;
                return;
            }
        }
        LayoutCoordinates layoutCoordinates2 = getLayoutCoordinates();
        if (layoutCoordinates2 == null) {
            throw new IllegalStateException("layoutCoordinates not set");
        }
        long mo1951localToRootMKHz9U2 = layoutCoordinates2.mo1951localToRootMKHz9U(Offset.INSTANCE.m1349getZeroF1C5BW0());
        final PointerInteropFilter pointerInteropFilter2 = this.this$0;
        PointerInteropUtils_androidKt.m1895toMotionEventScoped4ec7I(pointerEvent, mo1951localToRootMKHz9U2, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$dispatchToView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MotionEvent motionEvent) {
                invoke2(motionEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MotionEvent motionEvent) {
                PointerInteropFilter.DispatchToViewState dispatchToViewState;
                if (motionEvent.getActionMasked() == 0) {
                    PointerInteropFilter$pointerInputFilter$1 pointerInteropFilter$pointerInputFilter$1 = PointerInteropFilter$pointerInputFilter$1.this;
                    if (pointerInteropFilter2.getOnTouchEvent().invoke(motionEvent).booleanValue()) {
                        dispatchToViewState = PointerInteropFilter.DispatchToViewState.Dispatching;
                    } else {
                        dispatchToViewState = PointerInteropFilter.DispatchToViewState.NotDispatching;
                    }
                    pointerInteropFilter$pointerInputFilter$1.state = dispatchToViewState;
                    return;
                }
                pointerInteropFilter2.getOnTouchEvent().invoke(motionEvent);
            }
        });
        if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
            int size2 = changes.size();
            for (int i6 = 0; i6 < size2; i6++) {
                changes.get(i6).consume();
            }
            InternalPointerEvent internalPointerEvent = pointerEvent.getInternalPointerEvent();
            if (internalPointerEvent == null) {
                return;
            }
            internalPointerEvent.setSuppressMovementConsumption(!this.this$0.getDisallowIntercept());
        }
    }

    private final void reset() {
        this.state = PointerInteropFilter.DispatchToViewState.Unknown;
        this.this$0.setDisallowIntercept$ui_release(false);
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    public boolean getShareWithSiblings() {
        return true;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    public void onCancel() {
        if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
            long uptimeMillis = SystemClock.uptimeMillis();
            final PointerInteropFilter pointerInteropFilter = this.this$0;
            PointerInteropUtils_androidKt.emptyCancelMotionEventScope(uptimeMillis, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$onCancel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MotionEvent motionEvent) {
                    invoke2(motionEvent);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MotionEvent motionEvent) {
                    PointerInteropFilter.this.getOnTouchEvent().invoke(motionEvent);
                }
            });
            reset();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    /* renamed from: onPointerEvent-H0pRuoY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo1893onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        boolean z5;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        if (!this.this$0.getDisallowIntercept()) {
            int size = changes.size();
            for (int i5 = 0; i5 < size; i5++) {
                PointerInputChange pointerInputChange = changes.get(i5);
                if (!PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange) && !PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                }
            }
            z5 = false;
            if (this.state != PointerInteropFilter.DispatchToViewState.NotDispatching) {
                if (pass == PointerEventPass.Initial && z5) {
                    dispatchToView(pointerEvent);
                }
                if (pass == PointerEventPass.Final && !z5) {
                    dispatchToView(pointerEvent);
                }
            }
            if (pass != PointerEventPass.Final) {
                int size2 = changes.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    if (!PointerEventKt.changedToUpIgnoreConsumed(changes.get(i6))) {
                        return;
                    }
                }
                reset();
                return;
            }
            return;
        }
        z5 = true;
        if (this.state != PointerInteropFilter.DispatchToViewState.NotDispatching) {
        }
        if (pass != PointerEventPass.Final) {
        }
    }
}
