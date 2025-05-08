package dagger.hilt.android.internal.lifecycle;

import android.support.v4.media.session.a;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.ThreadUtil;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class RetainedLifecycleImpl implements ActivityRetainedLifecycle, ViewModelLifecycle {
    private final Set<Object> listeners = new HashSet();
    private boolean onClearedDispatched = false;

    public void dispatchOnCleared() {
        ThreadUtil.ensureMainThread();
        this.onClearedDispatched = true;
        Iterator<Object> it = this.listeners.iterator();
        if (it.hasNext()) {
            a.a(it.next());
            throw null;
        }
    }
}
