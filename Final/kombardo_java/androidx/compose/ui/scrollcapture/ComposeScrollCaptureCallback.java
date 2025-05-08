package androidx.compose.ui.scrollcapture;

import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.CancellationSignal;
import android.view.ScrollCaptureCallback;
import android.view.ScrollCaptureSession;
import android.view.Surface;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.unit.IntRect;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.NonCancellable;
import org.conscrypt.BuildConfig;
import r.AbstractC0733a;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0001*B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001a\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ5\u0010\u000f\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00142\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b\u000f\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010!R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\"R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006+"}, d2 = {"Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback;", "Landroid/view/ScrollCaptureCallback;", "Landroidx/compose/ui/semantics/SemanticsNode;", "node", "Landroidx/compose/ui/unit/IntRect;", "viewportBoundsInWindow", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;", "listener", "<init>", "(Landroidx/compose/ui/semantics/SemanticsNode;Landroidx/compose/ui/unit/IntRect;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;)V", "Landroid/view/ScrollCaptureSession;", "session", "captureArea", "onScrollCaptureImageRequest", "(Landroid/view/ScrollCaptureSession;Landroidx/compose/ui/unit/IntRect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/os/CancellationSignal;", "signal", "Ljava/util/function/Consumer;", "Landroid/graphics/Rect;", "onReady", BuildConfig.FLAVOR, "onScrollCaptureSearch", "(Landroid/os/CancellationSignal;Ljava/util/function/Consumer;)V", "Ljava/lang/Runnable;", "onScrollCaptureStart", "(Landroid/view/ScrollCaptureSession;Landroid/os/CancellationSignal;Ljava/lang/Runnable;)V", "onComplete", "(Landroid/view/ScrollCaptureSession;Landroid/os/CancellationSignal;Landroid/graphics/Rect;Ljava/util/function/Consumer;)V", "onScrollCaptureEnd", "(Ljava/lang/Runnable;)V", "Landroidx/compose/ui/semantics/SemanticsNode;", "Landroidx/compose/ui/unit/IntRect;", "Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/scrollcapture/RelativeScroller;", "scrollTracker", "Landroidx/compose/ui/scrollcapture/RelativeScroller;", BuildConfig.FLAVOR, "requestCount", "I", "ScrollCaptureSessionListener", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposeScrollCaptureCallback implements ScrollCaptureCallback {
    private final CoroutineScope coroutineScope;
    private final ScrollCaptureSessionListener listener;
    private final SemanticsNode node;
    private int requestCount;
    private final RelativeScroller scrollTracker;
    private final IntRect viewportBoundsInWindow;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;", BuildConfig.FLAVOR, "onSessionEnded", BuildConfig.FLAVOR, "onSessionStarted", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface ScrollCaptureSessionListener {
        void onSessionEnded();

        void onSessionStarted();
    }

    public ComposeScrollCaptureCallback(SemanticsNode semanticsNode, IntRect intRect, CoroutineScope coroutineScope, ScrollCaptureSessionListener scrollCaptureSessionListener) {
        this.node = semanticsNode;
        this.viewportBoundsInWindow = intRect;
        this.listener = scrollCaptureSessionListener;
        this.coroutineScope = CoroutineScopeKt.plus(coroutineScope, DisableAnimationMotionDurationScale.INSTANCE);
        this.scrollTracker = new RelativeScroller(intRect.getHeight(), new ComposeScrollCaptureCallback$scrollTracker$1(this, null));
    }

    public void onScrollCaptureEnd(Runnable onReady) {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, NonCancellable.INSTANCE, null, new ComposeScrollCaptureCallback$onScrollCaptureEnd$1(this, onReady, null), 2, null);
    }

    public void onScrollCaptureImageRequest(ScrollCaptureSession session, CancellationSignal signal, Rect captureArea, Consumer<Rect> onComplete) {
        ComposeScrollCaptureCallback_androidKt.launchWithCancellationSignal(this.coroutineScope, signal, new ComposeScrollCaptureCallback$onScrollCaptureImageRequest$1(this, session, captureArea, onComplete, null));
    }

    public void onScrollCaptureSearch(CancellationSignal signal, Consumer<Rect> onReady) {
        onReady.accept(RectHelper_androidKt.toAndroidRect(this.viewportBoundsInWindow));
    }

    public void onScrollCaptureStart(ScrollCaptureSession session, CancellationSignal signal, Runnable onReady) {
        this.scrollTracker.reset();
        this.requestCount = 0;
        this.listener.onSessionStarted();
        onReady.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0096 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onScrollCaptureImageRequest(ScrollCaptureSession scrollCaptureSession, IntRect intRect, Continuation<? super IntRect> continuation) {
        ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2 composeScrollCaptureCallback$onScrollCaptureImageRequest$2;
        Object coroutine_suspended;
        int i5;
        int top;
        int bottom;
        ComposeScrollCaptureCallback composeScrollCaptureCallback;
        ComposeScrollCaptureCallback$onScrollCaptureImageRequest$3 composeScrollCaptureCallback$onScrollCaptureImageRequest$3;
        IntRect intRect2;
        int i6;
        ComposeScrollCaptureCallback composeScrollCaptureCallback2;
        ScrollCaptureSession scrollCaptureSession2;
        int i7;
        int mapOffsetToViewport;
        int mapOffsetToViewport2;
        Surface surface;
        Surface surface2;
        BlendMode blendMode;
        Surface surface3;
        if (continuation instanceof ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2) {
            composeScrollCaptureCallback$onScrollCaptureImageRequest$2 = (ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2) continuation;
            int i8 = composeScrollCaptureCallback$onScrollCaptureImageRequest$2.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                composeScrollCaptureCallback$onScrollCaptureImageRequest$2.label = i8 - Integer.MIN_VALUE;
                Object obj = composeScrollCaptureCallback$onScrollCaptureImageRequest$2.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = composeScrollCaptureCallback$onScrollCaptureImageRequest$2.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    top = intRect.getTop();
                    bottom = intRect.getBottom();
                    RelativeScroller relativeScroller = this.scrollTracker;
                    composeScrollCaptureCallback$onScrollCaptureImageRequest$2.L$0 = this;
                    composeScrollCaptureCallback$onScrollCaptureImageRequest$2.L$1 = scrollCaptureSession;
                    composeScrollCaptureCallback$onScrollCaptureImageRequest$2.L$2 = intRect;
                    composeScrollCaptureCallback$onScrollCaptureImageRequest$2.I$0 = top;
                    composeScrollCaptureCallback$onScrollCaptureImageRequest$2.I$1 = bottom;
                    composeScrollCaptureCallback$onScrollCaptureImageRequest$2.label = 1;
                    if (relativeScroller.scrollRangeIntoView(top, bottom, composeScrollCaptureCallback$onScrollCaptureImageRequest$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    composeScrollCaptureCallback = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i7 = composeScrollCaptureCallback$onScrollCaptureImageRequest$2.I$1;
                        i6 = composeScrollCaptureCallback$onScrollCaptureImageRequest$2.I$0;
                        intRect2 = (IntRect) composeScrollCaptureCallback$onScrollCaptureImageRequest$2.L$2;
                        ScrollCaptureSession a5 = AbstractC0733a.a(composeScrollCaptureCallback$onScrollCaptureImageRequest$2.L$1);
                        composeScrollCaptureCallback2 = (ComposeScrollCaptureCallback) composeScrollCaptureCallback$onScrollCaptureImageRequest$2.L$0;
                        ResultKt.throwOnFailure(obj);
                        scrollCaptureSession2 = a5;
                        mapOffsetToViewport = composeScrollCaptureCallback2.scrollTracker.mapOffsetToViewport(i6);
                        mapOffsetToViewport2 = composeScrollCaptureCallback2.scrollTracker.mapOffsetToViewport(i7);
                        IntRect copy$default = IntRect.copy$default(intRect2, 0, mapOffsetToViewport, 0, mapOffsetToViewport2, 5, null);
                        if (mapOffsetToViewport != mapOffsetToViewport2) {
                            return IntRect.INSTANCE.getZero();
                        }
                        NodeCoordinator findCoordinatorToGetBounds$ui_release = composeScrollCaptureCallback2.node.findCoordinatorToGetBounds$ui_release();
                        if (findCoordinatorToGetBounds$ui_release != null) {
                            surface = scrollCaptureSession2.getSurface();
                            Canvas lockHardwareCanvas = surface.lockHardwareCanvas();
                            try {
                                blendMode = BlendMode.CLEAR;
                                lockHardwareCanvas.drawColor(0, blendMode);
                                androidx.compose.ui.graphics.Canvas Canvas = AndroidCanvas_androidKt.Canvas(lockHardwareCanvas);
                                Canvas.translate(-copy$default.getLeft(), -copy$default.getTop());
                                findCoordinatorToGetBounds$ui_release.draw(Canvas, null);
                                surface3 = scrollCaptureSession2.getSurface();
                                surface3.unlockCanvasAndPost(lockHardwareCanvas);
                                return copy$default.translate(0, MathKt.roundToInt(composeScrollCaptureCallback2.scrollTracker.getScrollAmount()));
                            } catch (Throwable th) {
                                surface2 = scrollCaptureSession2.getSurface();
                                surface2.unlockCanvasAndPost(lockHardwareCanvas);
                                throw th;
                            }
                        }
                        throw new IllegalStateException("Could not find coordinator for semantics node.");
                    }
                    int i9 = composeScrollCaptureCallback$onScrollCaptureImageRequest$2.I$1;
                    int i10 = composeScrollCaptureCallback$onScrollCaptureImageRequest$2.I$0;
                    IntRect intRect3 = (IntRect) composeScrollCaptureCallback$onScrollCaptureImageRequest$2.L$2;
                    ScrollCaptureSession a6 = AbstractC0733a.a(composeScrollCaptureCallback$onScrollCaptureImageRequest$2.L$1);
                    composeScrollCaptureCallback = (ComposeScrollCaptureCallback) composeScrollCaptureCallback$onScrollCaptureImageRequest$2.L$0;
                    ResultKt.throwOnFailure(obj);
                    top = i10;
                    intRect = intRect3;
                    bottom = i9;
                    scrollCaptureSession = a6;
                }
                composeScrollCaptureCallback$onScrollCaptureImageRequest$3 = new Function1<Long, Unit>() { // from class: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$3
                    public final void invoke(long j5) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Long l5) {
                        invoke(l5.longValue());
                        return Unit.INSTANCE;
                    }
                };
                composeScrollCaptureCallback$onScrollCaptureImageRequest$2.L$0 = composeScrollCaptureCallback;
                composeScrollCaptureCallback$onScrollCaptureImageRequest$2.L$1 = scrollCaptureSession;
                composeScrollCaptureCallback$onScrollCaptureImageRequest$2.L$2 = intRect;
                composeScrollCaptureCallback$onScrollCaptureImageRequest$2.I$0 = top;
                composeScrollCaptureCallback$onScrollCaptureImageRequest$2.I$1 = bottom;
                composeScrollCaptureCallback$onScrollCaptureImageRequest$2.label = 2;
                if (MonotonicFrameClockKt.withFrameNanos(composeScrollCaptureCallback$onScrollCaptureImageRequest$3, composeScrollCaptureCallback$onScrollCaptureImageRequest$2) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                intRect2 = intRect;
                i6 = top;
                composeScrollCaptureCallback2 = composeScrollCaptureCallback;
                scrollCaptureSession2 = scrollCaptureSession;
                i7 = bottom;
                mapOffsetToViewport = composeScrollCaptureCallback2.scrollTracker.mapOffsetToViewport(i6);
                mapOffsetToViewport2 = composeScrollCaptureCallback2.scrollTracker.mapOffsetToViewport(i7);
                IntRect copy$default2 = IntRect.copy$default(intRect2, 0, mapOffsetToViewport, 0, mapOffsetToViewport2, 5, null);
                if (mapOffsetToViewport != mapOffsetToViewport2) {
                }
            }
        }
        composeScrollCaptureCallback$onScrollCaptureImageRequest$2 = new ComposeScrollCaptureCallback$onScrollCaptureImageRequest$2(this, continuation);
        Object obj2 = composeScrollCaptureCallback$onScrollCaptureImageRequest$2.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = composeScrollCaptureCallback$onScrollCaptureImageRequest$2.label;
        if (i5 != 0) {
        }
        composeScrollCaptureCallback$onScrollCaptureImageRequest$3 = new Function1<Long, Unit>() { // from class: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback$onScrollCaptureImageRequest$3
            public final void invoke(long j5) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l5) {
                invoke(l5.longValue());
                return Unit.INSTANCE;
            }
        };
        composeScrollCaptureCallback$onScrollCaptureImageRequest$2.L$0 = composeScrollCaptureCallback;
        composeScrollCaptureCallback$onScrollCaptureImageRequest$2.L$1 = scrollCaptureSession;
        composeScrollCaptureCallback$onScrollCaptureImageRequest$2.L$2 = intRect;
        composeScrollCaptureCallback$onScrollCaptureImageRequest$2.I$0 = top;
        composeScrollCaptureCallback$onScrollCaptureImageRequest$2.I$1 = bottom;
        composeScrollCaptureCallback$onScrollCaptureImageRequest$2.label = 2;
        if (MonotonicFrameClockKt.withFrameNanos(composeScrollCaptureCallback$onScrollCaptureImageRequest$3, composeScrollCaptureCallback$onScrollCaptureImageRequest$2) != coroutine_suspended) {
        }
    }
}
