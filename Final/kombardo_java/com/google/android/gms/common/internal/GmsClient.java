package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class GmsClient<T extends IInterface> extends BaseGmsClient<T> implements Api.Client {
    private static volatile Executor zaa;
    private final ClientSettings zab;
    private final Set zac;
    private final Account zad;

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public GmsClient(Context context, Looper looper, int i5, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, i5, clientSettings, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
    }

    private final Set zaa(Set set) {
        Set<Scope> validateScopes = validateScopes(set);
        Iterator<Scope> it = validateScopes.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return validateScopes;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Account getAccount() {
        return this.zad;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected Executor getBindServiceExecutor() {
        return null;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final Set<Scope> getScopes() {
        return this.zac;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        return requiresSignIn() ? this.zac : Collections.emptySet();
    }

    protected Set<Scope> validateScopes(Set<Scope> set) {
        return set;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GmsClient(Context context, Looper looper, int i5, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, GmsClientSupervisor.getInstance(context), GoogleApiAvailability.getInstance(), i5, clientSettings, (ConnectionCallbacks) Preconditions.checkNotNull(connectionCallbacks), (OnConnectionFailedListener) Preconditions.checkNotNull(onConnectionFailedListener));
    }

    protected GmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailability googleApiAvailability, int i5, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, gmsClientSupervisor, googleApiAvailability, i5, connectionCallbacks == null ? null : new zah(connectionCallbacks), onConnectionFailedListener == null ? null : new zai(onConnectionFailedListener), clientSettings.zac());
        this.zab = clientSettings;
        this.zad = clientSettings.getAccount();
        this.zac = zaa(clientSettings.getAllRequestedScopes());
    }
}
