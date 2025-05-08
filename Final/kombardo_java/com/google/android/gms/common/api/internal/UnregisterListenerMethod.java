package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public abstract class UnregisterListenerMethod<A extends Api.AnyClient, L> {
    private final ListenerHolder.ListenerKey zaa;

    /* JADX INFO: Access modifiers changed from: protected */
    public UnregisterListenerMethod(ListenerHolder.ListenerKey<L> listenerKey) {
        this.zaa = listenerKey;
    }

    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.zaa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void unregisterListener(A a5, TaskCompletionSource<Boolean> taskCompletionSource);
}
