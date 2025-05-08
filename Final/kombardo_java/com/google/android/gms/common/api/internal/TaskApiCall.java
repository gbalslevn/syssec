package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT> {
    private final Feature[] zaa;
    private final boolean zab;
    private final int zac;

    /* loaded from: classes.dex */
    public static class Builder<A extends Api.AnyClient, ResultT> {
        private RemoteCall zaa;
        private Feature[] zac;
        private boolean zab = true;
        private int zad = 0;

        /* synthetic */ Builder(zacw zacwVar) {
        }

        public TaskApiCall<A, ResultT> build() {
            Preconditions.checkArgument(this.zaa != null, "execute parameter required");
            return new zacv(this, this.zac, this.zab, this.zad);
        }

        public Builder<A, ResultT> run(RemoteCall<A, TaskCompletionSource<ResultT>> remoteCall) {
            this.zaa = remoteCall;
            return this;
        }

        public Builder<A, ResultT> setAutoResolveMissingFeatures(boolean z5) {
            this.zab = z5;
            return this;
        }

        public Builder<A, ResultT> setFeatures(Feature... featureArr) {
            this.zac = featureArr;
            return this;
        }

        public Builder<A, ResultT> setMethodKey(int i5) {
            this.zad = i5;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TaskApiCall(Feature[] featureArr, boolean z5, int i5) {
        this.zaa = featureArr;
        boolean z6 = false;
        if (featureArr != null && z5) {
            z6 = true;
        }
        this.zab = z6;
        this.zac = i5;
    }

    public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> builder() {
        return new Builder<>(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void doExecute(A a5, TaskCompletionSource<ResultT> taskCompletionSource);

    public boolean shouldAutoResolveMissingFeatures() {
        return this.zab;
    }

    public final int zaa() {
        return this.zac;
    }

    public final Feature[] zab() {
        return this.zaa;
    }
}
