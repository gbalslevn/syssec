package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/CompositionObserverHolder;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/tooling/CompositionObserver;", "observer", BuildConfig.FLAVOR, "root", "<init>", "(Landroidx/compose/runtime/tooling/CompositionObserver;Z)V", "Landroidx/compose/runtime/tooling/CompositionObserver;", "getObserver", "()Landroidx/compose/runtime/tooling/CompositionObserver;", "setObserver", "(Landroidx/compose/runtime/tooling/CompositionObserver;)V", "Z", "getRoot", "()Z", "setRoot", "(Z)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CompositionObserverHolder {
    private CompositionObserver observer;
    private boolean root;

    public CompositionObserverHolder(CompositionObserver compositionObserver, boolean z5) {
        this.root = z5;
    }

    public final CompositionObserver getObserver() {
        return null;
    }

    public final boolean getRoot() {
        return this.root;
    }

    public final void setObserver(CompositionObserver compositionObserver) {
    }

    public /* synthetic */ CompositionObserverHolder(CompositionObserver compositionObserver, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : compositionObserver, (i5 & 2) != 0 ? false : z5);
    }
}
