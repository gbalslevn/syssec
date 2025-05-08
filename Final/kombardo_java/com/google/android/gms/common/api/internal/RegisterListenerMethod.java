package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {
    private final ListenerHolder zaa;
    private final Feature[] zab;
    private final boolean zac;
    private final int zad;

    /* JADX INFO: Access modifiers changed from: protected */
    public RegisterListenerMethod(ListenerHolder<L> listenerHolder, Feature[] featureArr, boolean z5, int i5) {
        this.zaa = listenerHolder;
        this.zab = featureArr;
        this.zac = z5;
        this.zad = i5;
    }

    public void clearListener() {
        this.zaa.clear();
    }

    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.zaa.getListenerKey();
    }

    public Feature[] getRequiredFeatures() {
        return this.zab;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void registerListener(A a5, TaskCompletionSource<Void> taskCompletionSource);

    public final int zaa() {
        return this.zad;
    }

    public final boolean zab() {
        return this.zac;
    }
}
