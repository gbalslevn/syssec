package androidx.compose.foundation.lazy.layout;

import android.view.Choreographer;
import android.view.Display;
import android.view.View;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0001\u0018\u0000 \u001c2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u001c\u001dB\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0011H\u0016R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/lazy/layout/AndroidPrefetchScheduler;", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "Landroidx/compose/runtime/RememberObserver;", "Ljava/lang/Runnable;", "Landroid/view/Choreographer$FrameCallback;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "choreographer", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "frameStartTimeNanos", BuildConfig.FLAVOR, "isActive", BuildConfig.FLAVOR, "prefetchRequests", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "prefetchScheduled", "doFrame", BuildConfig.FLAVOR, "frameTimeNanos", "onAbandoned", "onForgotten", "onRemembered", "run", "schedulePrefetch", "prefetchRequest", "Companion", "PrefetchRequestScopeImpl", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidPrefetchScheduler implements PrefetchScheduler, RememberObserver, Runnable, Choreographer.FrameCallback {
    private static long frameIntervalNs;
    private long frameStartTimeNanos;
    private boolean isActive;
    private boolean prefetchScheduled;
    private final View view;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final MutableVector<PrefetchRequest> prefetchRequests = new MutableVector<>(new PrefetchRequest[16], 0);
    private final Choreographer choreographer = Choreographer.getInstance();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/lazy/layout/AndroidPrefetchScheduler$Companion;", BuildConfig.FLAVOR, "()V", "frameIntervalNs", BuildConfig.FLAVOR, "calculateFrameIntervalIfNeeded", BuildConfig.FLAVOR, "view", "Landroid/view/View;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
        
            if (r5 >= 30.0f) goto L11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void calculateFrameIntervalIfNeeded(View view) {
            float f5;
            if (AndroidPrefetchScheduler.frameIntervalNs == 0) {
                Display display = view.getDisplay();
                if (!view.isInEditMode() && display != null) {
                    f5 = display.getRefreshRate();
                }
                f5 = 60.0f;
                AndroidPrefetchScheduler.frameIntervalNs = 1000000000 / f5;
            }
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/lazy/layout/AndroidPrefetchScheduler$PrefetchRequestScopeImpl;", "Landroidx/compose/foundation/lazy/layout/PrefetchRequestScope;", "nextFrameTimeNs", BuildConfig.FLAVOR, "(J)V", "availableTimeNanos", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class PrefetchRequestScopeImpl implements PrefetchRequestScope {
        private final long nextFrameTimeNs;

        public PrefetchRequestScopeImpl(long j5) {
            this.nextFrameTimeNs = j5;
        }

        @Override // androidx.compose.foundation.lazy.layout.PrefetchRequestScope
        public long availableTimeNanos() {
            return Math.max(0L, this.nextFrameTimeNs - System.nanoTime());
        }
    }

    public AndroidPrefetchScheduler(View view) {
        this.view = view;
        INSTANCE.calculateFrameIntervalIfNeeded(view);
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long frameTimeNanos) {
        if (this.isActive) {
            this.frameStartTimeNanos = frameTimeNanos;
            this.view.post(this);
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        this.isActive = false;
        this.view.removeCallbacks(this);
        this.choreographer.removeFrameCallback(this);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        this.isActive = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.prefetchRequests.isEmpty() || !this.prefetchScheduled || !this.isActive || this.view.getWindowVisibility() != 0) {
            this.prefetchScheduled = false;
            return;
        }
        PrefetchRequestScopeImpl prefetchRequestScopeImpl = new PrefetchRequestScopeImpl(this.frameStartTimeNanos + frameIntervalNs);
        boolean z5 = false;
        while (this.prefetchRequests.isNotEmpty() && !z5) {
            if (prefetchRequestScopeImpl.availableTimeNanos() <= 0 || this.prefetchRequests.getContent()[0].execute(prefetchRequestScopeImpl)) {
                z5 = true;
            } else {
                this.prefetchRequests.removeAt(0);
            }
        }
        if (z5) {
            this.choreographer.postFrameCallback(this);
        } else {
            this.prefetchScheduled = false;
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.PrefetchScheduler
    public void schedulePrefetch(PrefetchRequest prefetchRequest) {
        this.prefetchRequests.add(prefetchRequest);
        if (this.prefetchScheduled) {
            return;
        }
        this.prefetchScheduled = true;
        this.view.post(this);
    }
}
