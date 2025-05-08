package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.TransformEvent;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.Channel;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a<\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tH\u0082@¢\u0006\u0002\u0010\u000b\u001a<\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004H\u0007\u001a&\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004¨\u0006\u0012"}, d2 = {"detectZoom", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "panZoomLock", BuildConfig.FLAVOR, "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "canPan", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "lockRotationOnZoomPan", "enabled", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TransformableKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x029b, code lost:
    
        if (r5 != 0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x029d, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01f0, code lost:
    
        if (r13.invoke(androidx.compose.ui.geometry.Offset.m1328boximpl(r1)).booleanValue() != false) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x011c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0273 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0143 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02a2 A[EDGE_INSN: B:97:0x02a2->B:96:0x02a2 BREAK  A[LOOP:0: B:13:0x028d->B:16:0x029f], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0274 -> B:12:0x0280). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object detectZoom(AwaitPointerEventScope awaitPointerEventScope, boolean z5, Channel<TransformEvent> channel, Function1<? super Offset, Boolean> function1, Continuation<? super Unit> continuation) {
        TransformableKt$detectZoom$1 transformableKt$detectZoom$1;
        Object obj;
        Object coroutine_suspended;
        int i5;
        AwaitPointerEventScope awaitPointerEventScope2;
        Channel<TransformEvent> channel2;
        Function1<? super Offset, Boolean> function12;
        boolean z6;
        float f5;
        long j5;
        int i6;
        int i7;
        float f6;
        float f7;
        AwaitPointerEventScope awaitPointerEventScope3;
        float f8;
        Channel<TransformEvent> channel3;
        int size;
        int i8;
        int i9;
        TransformableKt$detectZoom$1 transformableKt$detectZoom$12;
        int i10;
        int i11;
        float f9;
        long j6;
        int i12;
        int i13;
        Object awaitPointerEvent;
        boolean z7;
        PointerEvent pointerEvent;
        float f10;
        float f11;
        int i14;
        Channel<TransformEvent> channel4;
        float f12;
        int i15;
        long j7;
        float f13;
        float f14;
        int size2;
        int i16;
        int size3;
        int i17;
        int size4;
        int i18;
        if (continuation instanceof TransformableKt$detectZoom$1) {
            transformableKt$detectZoom$1 = (TransformableKt$detectZoom$1) continuation;
            int i19 = transformableKt$detectZoom$1.label;
            if ((i19 & Integer.MIN_VALUE) != 0) {
                transformableKt$detectZoom$1.label = i19 - Integer.MIN_VALUE;
                obj = transformableKt$detectZoom$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = transformableKt$detectZoom$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    long m1349getZeroF1C5BW0 = Offset.INSTANCE.m1349getZeroF1C5BW0();
                    float touchSlop = awaitPointerEventScope.getViewConfiguration().getTouchSlop();
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    transformableKt$detectZoom$1.L$0 = awaitPointerEventScope2;
                    channel2 = channel;
                    transformableKt$detectZoom$1.L$1 = channel2;
                    function12 = function1;
                    transformableKt$detectZoom$1.L$2 = function12;
                    z6 = z5;
                    transformableKt$detectZoom$1.Z$0 = z6;
                    transformableKt$detectZoom$1.F$0 = 0.0f;
                    transformableKt$detectZoom$1.F$1 = 1.0f;
                    transformableKt$detectZoom$1.J$0 = m1349getZeroF1C5BW0;
                    transformableKt$detectZoom$1.I$0 = 0;
                    transformableKt$detectZoom$1.F$2 = touchSlop;
                    transformableKt$detectZoom$1.I$1 = 0;
                    transformableKt$detectZoom$1.label = 1;
                    if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, transformableKt$detectZoom$1, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    f5 = touchSlop;
                    j5 = m1349getZeroF1C5BW0;
                    i6 = 0;
                    i7 = 0;
                    f6 = 1.0f;
                    f7 = 0.0f;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i20 = transformableKt$detectZoom$1.I$2;
                            i14 = transformableKt$detectZoom$1.I$1;
                            f11 = transformableKt$detectZoom$1.F$2;
                            i12 = transformableKt$detectZoom$1.I$0;
                            j6 = transformableKt$detectZoom$1.J$0;
                            float f15 = transformableKt$detectZoom$1.F$1;
                            float f16 = transformableKt$detectZoom$1.F$0;
                            boolean z8 = transformableKt$detectZoom$1.Z$0;
                            pointerEvent = (PointerEvent) transformableKt$detectZoom$1.L$3;
                            function12 = (Function1) transformableKt$detectZoom$1.L$2;
                            Channel<TransformEvent> channel5 = (Channel) transformableKt$detectZoom$1.L$1;
                            awaitPointerEventScope3 = (AwaitPointerEventScope) transformableKt$detectZoom$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            z7 = z8;
                            f8 = f16;
                            channel4 = channel5;
                            f10 = f15;
                            i13 = i20;
                            awaitPointerEvent = obj;
                            List<PointerInputChange> changes = ((PointerEvent) awaitPointerEvent).getChanges();
                            size3 = changes.size();
                            TransformableKt$detectZoom$1 transformableKt$detectZoom$13 = transformableKt$detectZoom$1;
                            i17 = 0;
                            while (true) {
                                if (i17 >= size3) {
                                    break;
                                }
                                if (changes.get(i17).isConsumed()) {
                                    break;
                                }
                                i17++;
                            }
                            boolean z9 = false;
                            if (i13 == 0 && !z9) {
                                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                                size4 = changes2.size();
                                for (i18 = 0; i18 < size4; i18++) {
                                    if (changes2.get(i18).getPressed()) {
                                        transformableKt$detectZoom$1 = transformableKt$detectZoom$13;
                                        i6 = i14;
                                        f5 = f11;
                                        i7 = i12;
                                        j5 = j6;
                                        f6 = f10;
                                        f7 = f8;
                                        awaitPointerEventScope2 = awaitPointerEventScope3;
                                        z6 = z7;
                                        channel2 = channel4;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        i6 = transformableKt$detectZoom$1.I$1;
                        f5 = transformableKt$detectZoom$1.F$2;
                        i7 = transformableKt$detectZoom$1.I$0;
                        j5 = transformableKt$detectZoom$1.J$0;
                        f6 = transformableKt$detectZoom$1.F$1;
                        float f17 = transformableKt$detectZoom$1.F$0;
                        boolean z10 = transformableKt$detectZoom$1.Z$0;
                        Function1<? super Offset, Boolean> function13 = (Function1) transformableKt$detectZoom$1.L$2;
                        Channel<TransformEvent> channel6 = (Channel) transformableKt$detectZoom$1.L$1;
                        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) transformableKt$detectZoom$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        z6 = z10;
                        f8 = f17;
                        channel3 = channel6;
                        awaitPointerEventScope3 = awaitPointerEventScope4;
                        function12 = function13;
                        PointerEvent pointerEvent2 = (PointerEvent) obj;
                        List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                        size = changes3.size();
                        int i21 = i6;
                        i8 = 0;
                        while (true) {
                            if (i8 >= size) {
                                i9 = 0;
                                break;
                            }
                            if (changes3.get(i8).isConsumed()) {
                                i9 = 1;
                                break;
                            }
                            i8++;
                        }
                        if (i9 != 0) {
                            float calculateZoom = TransformGestureDetectorKt.calculateZoom(pointerEvent2);
                            float calculateRotation = TransformGestureDetectorKt.calculateRotation(pointerEvent2);
                            transformableKt$detectZoom$12 = transformableKt$detectZoom$1;
                            i10 = i9;
                            long calculatePan = TransformGestureDetectorKt.calculatePan(pointerEvent2);
                            if (i7 == 0) {
                                f6 *= calculateZoom;
                                f8 += calculateRotation;
                                j5 = Offset.m1342plusMKHz9U(j5, calculatePan);
                                int i22 = i7;
                                float calculateCentroidSize = TransformGestureDetectorKt.calculateCentroidSize(pointerEvent2, false);
                                f12 = calculateRotation;
                                float abs = Math.abs(1 - f6) * calculateCentroidSize;
                                float abs2 = Math.abs(((3.1415927f * f8) * calculateCentroidSize) / 180.0f);
                                float m1335getDistanceimpl = Offset.m1335getDistanceimpl(j5);
                                if (abs > f5 || abs2 > f5 || (m1335getDistanceimpl > f5 && function12.invoke(Offset.m1328boximpl(calculatePan)).booleanValue())) {
                                    i11 = (!z6 || abs2 >= f5) ? 0 : 1;
                                    channel3.mo3767trySendJP2dKIU(TransformEvent.TransformStarted.INSTANCE);
                                    i7 = 1;
                                } else {
                                    i11 = i21;
                                    i7 = i22;
                                }
                            } else {
                                f12 = calculateRotation;
                                i11 = i21;
                            }
                            if (i7 == 0) {
                                i15 = i7;
                                j7 = j5;
                            } else {
                                if (i11 != 0) {
                                    f14 = 0.0f;
                                    f13 = 0.0f;
                                } else {
                                    f13 = f12;
                                    f14 = 0.0f;
                                }
                                if (f13 != f14) {
                                    i15 = i7;
                                    j7 = j5;
                                } else if (calculateZoom == 1.0f) {
                                    i15 = i7;
                                    j7 = j5;
                                    if (!Offset.m1334equalsimpl0(calculatePan, Offset.INSTANCE.m1349getZeroF1C5BW0())) {
                                    }
                                    List<PointerInputChange> changes4 = pointerEvent2.getChanges();
                                    size2 = changes4.size();
                                    for (i16 = 0; i16 < size2; i16++) {
                                        PointerInputChange pointerInputChange = changes4.get(i16);
                                        if (PointerEventKt.positionChanged(pointerInputChange)) {
                                            pointerInputChange.consume();
                                        }
                                    }
                                } else {
                                    i15 = i7;
                                    j7 = j5;
                                }
                                channel3.mo3767trySendJP2dKIU(new TransformEvent.TransformDelta(calculateZoom, calculatePan, f13, null));
                                List<PointerInputChange> changes42 = pointerEvent2.getChanges();
                                size2 = changes42.size();
                                while (i16 < size2) {
                                }
                            }
                            i12 = i15;
                            f9 = f6;
                            j6 = j7;
                        } else {
                            transformableKt$detectZoom$12 = transformableKt$detectZoom$1;
                            i10 = i9;
                            channel3.mo3767trySendJP2dKIU(TransformEvent.TransformStopped.INSTANCE);
                            i11 = i21;
                            f9 = f6;
                            j6 = j5;
                            i12 = i7;
                        }
                        PointerEventPass pointerEventPass = PointerEventPass.Final;
                        TransformableKt$detectZoom$1 transformableKt$detectZoom$14 = transformableKt$detectZoom$12;
                        transformableKt$detectZoom$14.L$0 = awaitPointerEventScope3;
                        transformableKt$detectZoom$14.L$1 = channel3;
                        transformableKt$detectZoom$14.L$2 = function12;
                        transformableKt$detectZoom$14.L$3 = pointerEvent2;
                        transformableKt$detectZoom$14.Z$0 = z6;
                        transformableKt$detectZoom$14.F$0 = f8;
                        transformableKt$detectZoom$14.F$1 = f9;
                        transformableKt$detectZoom$14.J$0 = j6;
                        transformableKt$detectZoom$14.I$0 = i12;
                        transformableKt$detectZoom$14.F$2 = f5;
                        transformableKt$detectZoom$14.I$1 = i11;
                        i13 = i10;
                        transformableKt$detectZoom$14.I$2 = i13;
                        transformableKt$detectZoom$14.label = 3;
                        awaitPointerEvent = awaitPointerEventScope3.awaitPointerEvent(pointerEventPass, transformableKt$detectZoom$14);
                        if (awaitPointerEvent != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        z7 = z6;
                        pointerEvent = pointerEvent2;
                        Channel<TransformEvent> channel7 = channel3;
                        f10 = f9;
                        transformableKt$detectZoom$1 = transformableKt$detectZoom$14;
                        f11 = f5;
                        i14 = i11;
                        channel4 = channel7;
                        List<PointerInputChange> changes5 = ((PointerEvent) awaitPointerEvent).getChanges();
                        size3 = changes5.size();
                        TransformableKt$detectZoom$1 transformableKt$detectZoom$132 = transformableKt$detectZoom$1;
                        i17 = 0;
                        while (true) {
                            if (i17 >= size3) {
                            }
                            i17++;
                        }
                        boolean z92 = false;
                        if (i13 == 0) {
                            List<PointerInputChange> changes22 = pointerEvent.getChanges();
                            size4 = changes22.size();
                            while (i18 < size4) {
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    i6 = transformableKt$detectZoom$1.I$1;
                    f5 = transformableKt$detectZoom$1.F$2;
                    i7 = transformableKt$detectZoom$1.I$0;
                    j5 = transformableKt$detectZoom$1.J$0;
                    f6 = transformableKt$detectZoom$1.F$1;
                    f7 = transformableKt$detectZoom$1.F$0;
                    boolean z11 = transformableKt$detectZoom$1.Z$0;
                    Function1<? super Offset, Boolean> function14 = (Function1) transformableKt$detectZoom$1.L$2;
                    channel2 = (Channel) transformableKt$detectZoom$1.L$1;
                    AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) transformableKt$detectZoom$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    z6 = z11;
                    function12 = function14;
                    awaitPointerEventScope2 = awaitPointerEventScope5;
                }
                transformableKt$detectZoom$1.L$0 = awaitPointerEventScope2;
                transformableKt$detectZoom$1.L$1 = channel2;
                transformableKt$detectZoom$1.L$2 = function12;
                transformableKt$detectZoom$1.L$3 = null;
                transformableKt$detectZoom$1.Z$0 = z6;
                transformableKt$detectZoom$1.F$0 = f7;
                transformableKt$detectZoom$1.F$1 = f6;
                transformableKt$detectZoom$1.J$0 = j5;
                transformableKt$detectZoom$1.I$0 = i7;
                transformableKt$detectZoom$1.F$2 = f5;
                transformableKt$detectZoom$1.I$1 = i6;
                transformableKt$detectZoom$1.label = 2;
                obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, transformableKt$detectZoom$1, 1, null);
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                AwaitPointerEventScope awaitPointerEventScope6 = awaitPointerEventScope2;
                f8 = f7;
                channel3 = channel2;
                awaitPointerEventScope3 = awaitPointerEventScope6;
                PointerEvent pointerEvent22 = (PointerEvent) obj;
                List<PointerInputChange> changes32 = pointerEvent22.getChanges();
                size = changes32.size();
                int i212 = i6;
                i8 = 0;
                while (true) {
                    if (i8 >= size) {
                    }
                    i8++;
                }
                if (i9 != 0) {
                }
                PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                TransformableKt$detectZoom$1 transformableKt$detectZoom$142 = transformableKt$detectZoom$12;
                transformableKt$detectZoom$142.L$0 = awaitPointerEventScope3;
                transformableKt$detectZoom$142.L$1 = channel3;
                transformableKt$detectZoom$142.L$2 = function12;
                transformableKt$detectZoom$142.L$3 = pointerEvent22;
                transformableKt$detectZoom$142.Z$0 = z6;
                transformableKt$detectZoom$142.F$0 = f8;
                transformableKt$detectZoom$142.F$1 = f9;
                transformableKt$detectZoom$142.J$0 = j6;
                transformableKt$detectZoom$142.I$0 = i12;
                transformableKt$detectZoom$142.F$2 = f5;
                transformableKt$detectZoom$142.I$1 = i11;
                i13 = i10;
                transformableKt$detectZoom$142.I$2 = i13;
                transformableKt$detectZoom$142.label = 3;
                awaitPointerEvent = awaitPointerEventScope3.awaitPointerEvent(pointerEventPass2, transformableKt$detectZoom$142);
                if (awaitPointerEvent != coroutine_suspended) {
                }
            }
        }
        transformableKt$detectZoom$1 = new TransformableKt$detectZoom$1(continuation);
        obj = transformableKt$detectZoom$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = transformableKt$detectZoom$1.label;
        if (i5 != 0) {
        }
        transformableKt$detectZoom$1.L$0 = awaitPointerEventScope2;
        transformableKt$detectZoom$1.L$1 = channel2;
        transformableKt$detectZoom$1.L$2 = function12;
        transformableKt$detectZoom$1.L$3 = null;
        transformableKt$detectZoom$1.Z$0 = z6;
        transformableKt$detectZoom$1.F$0 = f7;
        transformableKt$detectZoom$1.F$1 = f6;
        transformableKt$detectZoom$1.J$0 = j5;
        transformableKt$detectZoom$1.I$0 = i7;
        transformableKt$detectZoom$1.F$2 = f5;
        transformableKt$detectZoom$1.I$1 = i6;
        transformableKt$detectZoom$1.label = 2;
        obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, transformableKt$detectZoom$1, 1, null);
        if (obj != coroutine_suspended) {
        }
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, boolean z5, boolean z6) {
        return transformable(modifier, transformableState, new Function1<Offset, Boolean>() { // from class: androidx.compose.foundation.gestures.TransformableKt$transformable$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Offset offset) {
                return m246invokek4lQ0M(offset.getPackedValue());
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final Boolean m246invokek4lQ0M(long j5) {
                return Boolean.TRUE;
            }
        }, z5, z6);
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z5, boolean z6, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        if ((i5 & 4) != 0) {
            z6 = true;
        }
        return transformable(modifier, transformableState, z5, z6);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, Function1<? super Offset, Boolean> function1, boolean z5, boolean z6) {
        return modifier.then(new TransformableElement(transformableState, function1, z5, z6));
    }
}
