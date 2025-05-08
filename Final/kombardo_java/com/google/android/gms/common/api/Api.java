package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

/* loaded from: classes.dex */
public final class Api<O extends ApiOptions> {
    private final AbstractClientBuilder zaa;
    private final ClientKey zab;
    private final String zac;

    /* loaded from: classes.dex */
    public static abstract class AbstractClientBuilder<T extends Client, O> extends BaseClientBuilder<T, O> {
        @Deprecated
        public T buildClient(Context context, Looper looper, ClientSettings clientSettings, O o5, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return buildClient(context, looper, clientSettings, (ClientSettings) o5, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
        }

        public T buildClient(Context context, Looper looper, ClientSettings clientSettings, O o5, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* loaded from: classes.dex */
    public interface AnyClient {
    }

    /* loaded from: classes.dex */
    public static class AnyClientKey<C extends AnyClient> {
    }

    /* loaded from: classes.dex */
    public interface ApiOptions {
        public static final NoOptions NO_OPTIONS = new NoOptions(null);

        /* loaded from: classes.dex */
        public static final class NoOptions implements ApiOptions {
            /* synthetic */ NoOptions(zaa zaaVar) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class BaseClientBuilder<T extends AnyClient, O> {
    }

    /* loaded from: classes.dex */
    public interface Client extends AnyClient {
        void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks);

        void disconnect();

        void disconnect(String str);

        Feature[] getAvailableFeatures();

        String getEndpointPackageName();

        String getLastDisconnectMessage();

        int getMinApkVersion();

        void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set);

        Set<Scope> getScopesForConnectionlessNonSignIn();

        boolean isConnected();

        boolean isConnecting();

        void onUserSignOut(BaseGmsClient.SignOutCallbacks signOutCallbacks);

        boolean requiresGooglePlayServices();

        boolean requiresSignIn();
    }

    /* loaded from: classes.dex */
    public static final class ClientKey<C extends Client> extends AnyClientKey<C> {
    }

    public <C extends Client> Api(String str, AbstractClientBuilder<C, O> abstractClientBuilder, ClientKey<C> clientKey) {
        Preconditions.checkNotNull(abstractClientBuilder, "Cannot construct an Api with a null ClientBuilder");
        Preconditions.checkNotNull(clientKey, "Cannot construct an Api with a null ClientKey");
        this.zac = str;
        this.zaa = abstractClientBuilder;
        this.zab = clientKey;
    }

    public final AbstractClientBuilder zaa() {
        return this.zaa;
    }

    public final String zad() {
        return this.zac;
    }
}
