package androidx.compose.ui.scrollcapture;

import android.graphics.Point;
import android.view.ScrollCaptureTarget;
import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRectKt;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScopeKt;
import org.conscrypt.BuildConfig;
import r.e;
import r.g;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0007J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/scrollcapture/ScrollCapture;", "Landroidx/compose/ui/scrollcapture/ComposeScrollCaptureCallback$ScrollCaptureSessionListener;", "()V", "<set-?>", BuildConfig.FLAVOR, "scrollCaptureInProgress", "getScrollCaptureInProgress", "()Z", "setScrollCaptureInProgress", "(Z)V", "scrollCaptureInProgress$delegate", "Landroidx/compose/runtime/MutableState;", "onScrollCaptureSearch", BuildConfig.FLAVOR, "view", "Landroid/view/View;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "targets", "Ljava/util/function/Consumer;", "Landroid/view/ScrollCaptureTarget;", "onSessionEnded", "onSessionStarted", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScrollCapture implements ComposeScrollCaptureCallback.ScrollCaptureSessionListener {

    /* renamed from: scrollCaptureInProgress$delegate, reason: from kotlin metadata */
    private final MutableState scrollCaptureInProgress;

    public ScrollCapture() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.scrollCaptureInProgress = mutableStateOf$default;
    }

    private final void setScrollCaptureInProgress(boolean z5) {
        this.scrollCaptureInProgress.setValue(Boolean.valueOf(z5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getScrollCaptureInProgress() {
        return ((Boolean) this.scrollCaptureInProgress.getValue()).booleanValue();
    }

    public final void onScrollCaptureSearch(View view, SemanticsOwner semanticsOwner, CoroutineContext coroutineContext, Consumer<ScrollCaptureTarget> targets) {
        MutableVector mutableVector = new MutableVector(new ScrollCaptureCandidate[16], 0);
        ScrollCapture_androidKt.visitScrollCaptureCandidates$default(semanticsOwner.getUnmergedRootSemanticsNode(), 0, new ScrollCapture$onScrollCaptureSearch$1(mutableVector), 2, null);
        mutableVector.sortWith(ComparisonsKt.compareBy(new Function1<ScrollCaptureCandidate, Comparable<?>>() { // from class: androidx.compose.ui.scrollcapture.ScrollCapture$onScrollCaptureSearch$2
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(ScrollCaptureCandidate scrollCaptureCandidate) {
                return Integer.valueOf(scrollCaptureCandidate.getDepth());
            }
        }, new Function1<ScrollCaptureCandidate, Comparable<?>>() { // from class: androidx.compose.ui.scrollcapture.ScrollCapture$onScrollCaptureSearch$3
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(ScrollCaptureCandidate scrollCaptureCandidate) {
                return Integer.valueOf(scrollCaptureCandidate.getViewportBoundsInWindow().getHeight());
            }
        }));
        ScrollCaptureCandidate scrollCaptureCandidate = (ScrollCaptureCandidate) (mutableVector.isEmpty() ? null : mutableVector.getContent()[mutableVector.getSize() - 1]);
        if (scrollCaptureCandidate == null) {
            return;
        }
        ComposeScrollCaptureCallback composeScrollCaptureCallback = new ComposeScrollCaptureCallback(scrollCaptureCandidate.getNode(), scrollCaptureCandidate.getViewportBoundsInWindow(), CoroutineScopeKt.CoroutineScope(coroutineContext), this);
        Rect boundsInRoot = LayoutCoordinatesKt.boundsInRoot(scrollCaptureCandidate.getCoordinates());
        long m2654getTopLeftnOccac = scrollCaptureCandidate.getViewportBoundsInWindow().m2654getTopLeftnOccac();
        ScrollCaptureTarget a5 = g.a(view, RectHelper_androidKt.toAndroidRect(IntRectKt.roundToIntRect(boundsInRoot)), new Point(IntOffset.m2640getXimpl(m2654getTopLeftnOccac), IntOffset.m2641getYimpl(m2654getTopLeftnOccac)), e.a(composeScrollCaptureCallback));
        a5.setScrollBounds(RectHelper_androidKt.toAndroidRect(scrollCaptureCandidate.getViewportBoundsInWindow()));
        targets.accept(a5);
    }

    @Override // androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.ScrollCaptureSessionListener
    public void onSessionEnded() {
        setScrollCaptureInProgress(false);
    }

    @Override // androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.ScrollCaptureSessionListener
    public void onSessionStarted() {
        setScrollCaptureInProgress(true);
    }
}
