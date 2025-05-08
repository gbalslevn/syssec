package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class ListenerHolder<L> {
    private final Executor zaa;
    private volatile Object zab;
    private volatile ListenerKey zac;

    /* loaded from: classes.dex */
    public static final class ListenerKey<L> {
        private final Object zaa;
        private final String zab;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ListenerKey(L l5, String str) {
            this.zaa = l5;
            this.zab = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            return this.zaa == listenerKey.zaa && this.zab.equals(listenerKey.zab);
        }

        public int hashCode() {
            return (System.identityHashCode(this.zaa) * 31) + this.zab.hashCode();
        }

        public String toIdString() {
            return this.zab + "@" + System.identityHashCode(this.zaa);
        }
    }

    /* loaded from: classes.dex */
    public interface Notifier<L> {
        void notifyListener(L l5);

        void onNotifyListenerFailed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListenerHolder(Looper looper, L l5, String str) {
        this.zaa = new HandlerExecutor(looper);
        this.zab = Preconditions.checkNotNull(l5, "Listener must not be null");
        this.zac = new ListenerKey(l5, Preconditions.checkNotEmpty(str));
    }

    public void clear() {
        this.zab = null;
        this.zac = null;
    }

    public ListenerKey<L> getListenerKey() {
        return this.zac;
    }

    public void notifyListener(final Notifier<? super L> notifier) {
        Preconditions.checkNotNull(notifier, "Notifier must not be null");
        this.zaa.execute(new Runnable() { // from class: com.google.android.gms.common.api.internal.zacb
            @Override // java.lang.Runnable
            public final void run() {
                ListenerHolder.this.zaa(notifier);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zaa(Notifier notifier) {
        Object obj = this.zab;
        if (obj == null) {
            notifier.onNotifyListenerFailed();
            return;
        }
        try {
            notifier.notifyListener(obj);
        } catch (RuntimeException e5) {
            notifier.onNotifyListenerFailed();
            throw e5;
        }
    }
}
