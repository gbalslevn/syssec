package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.wrappers.AttributionSourceWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class BaseGmsClient<T extends IInterface> {
    private volatile String zzA;
    private volatile AttributionSourceWrapper zzB;
    private ConnectionResult zzC;
    private boolean zzD;
    private volatile zzk zzE;
    zzv zza;
    final Handler zzb;
    protected ConnectionProgressReportCallbacks zzc;
    protected AtomicInteger zzd;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private volatile String zzk;
    private final Context zzl;
    private final Looper zzm;
    private final GmsClientSupervisor zzn;
    private final GoogleApiAvailabilityLight zzo;
    private final Object zzp;
    private final Object zzq;
    private IGmsServiceBroker zzr;
    private IInterface zzs;
    private final ArrayList zzt;
    private zze zzu;
    private int zzv;
    private final BaseConnectionCallbacks zzw;
    private final BaseOnConnectionFailedListener zzx;
    private final int zzy;
    private final String zzz;
    private static final Feature[] zze = new Feature[0];
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};

    /* loaded from: classes.dex */
    public interface BaseConnectionCallbacks {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i5);
    }

    /* loaded from: classes.dex */
    public interface BaseOnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    /* loaded from: classes.dex */
    public interface ConnectionProgressReportCallbacks {
        void onReportServiceBinding(ConnectionResult connectionResult);
    }

    /* loaded from: classes.dex */
    protected class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        public LegacyClientCallbackAdapter() {
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public final void onReportServiceBinding(ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                baseGmsClient.getRemoteService(null, baseGmsClient.getScopes());
            } else if (BaseGmsClient.this.zzx != null) {
                BaseGmsClient.this.zzx.onConnectionFailed(connectionResult);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface SignOutCallbacks {
        void onSignOutComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BaseGmsClient(Context context, Looper looper, int i5, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this(context, looper, r3, r4, i5, baseConnectionCallbacks, baseOnConnectionFailedListener, str);
        GmsClientSupervisor gmsClientSupervisor = GmsClientSupervisor.getInstance(context);
        GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
        Preconditions.checkNotNull(baseConnectionCallbacks);
        Preconditions.checkNotNull(baseOnConnectionFailedListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzj(BaseGmsClient baseGmsClient, zzk zzkVar) {
        baseGmsClient.zzE = zzkVar;
        if (baseGmsClient.usesClientTelemetry()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzkVar.zzd;
            RootTelemetryConfigManager.getInstance().zza(connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.zza());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzk(BaseGmsClient baseGmsClient, int i5) {
        int i6;
        int i7;
        synchronized (baseGmsClient.zzp) {
            i6 = baseGmsClient.zzv;
        }
        if (i6 == 3) {
            baseGmsClient.zzD = true;
            i7 = 5;
        } else {
            i7 = 4;
        }
        Handler handler = baseGmsClient.zzb;
        handler.sendMessage(handler.obtainMessage(i7, baseGmsClient.zzd.get(), 16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean zzn(BaseGmsClient baseGmsClient, int i5, int i6, IInterface iInterface) {
        synchronized (baseGmsClient.zzp) {
            try {
                if (baseGmsClient.zzv != i5) {
                    return false;
                }
                baseGmsClient.zzp(i6, iInterface);
                return true;
            } finally {
            }
        }
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
        	at java.base/java.util.BitSet.or(BitSet.java:945)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:759)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:838)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:711)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    static /* bridge */ /* synthetic */ boolean zzo(com.google.android.gms.common.internal.BaseGmsClient r2) {
        /*
            boolean r0 = r2.zzD
            r1 = 0
            if (r0 == 0) goto L6
            goto L24
        L6:
            java.lang.String r0 = r2.getServiceDescriptor()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L11
            goto L24
        L11:
            java.lang.String r0 = r2.getLocalStartServiceAction()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L1c
            goto L24
        L1c:
            java.lang.String r2 = r2.getServiceDescriptor()     // Catch: java.lang.ClassNotFoundException -> L24
            java.lang.Class.forName(r2)     // Catch: java.lang.ClassNotFoundException -> L24
            r1 = 1
        L24:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.BaseGmsClient.zzo(com.google.android.gms.common.internal.BaseGmsClient):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zzp(int i5, IInterface iInterface) {
        zzv zzvVar;
        Preconditions.checkArgument((i5 == 4) == (iInterface != null));
        synchronized (this.zzp) {
            try {
                this.zzv = i5;
                this.zzs = iInterface;
                Bundle bundle = null;
                if (i5 == 1) {
                    zze zzeVar = this.zzu;
                    if (zzeVar != null) {
                        GmsClientSupervisor gmsClientSupervisor = this.zzn;
                        String zzb = this.zza.zzb();
                        Preconditions.checkNotNull(zzb);
                        gmsClientSupervisor.zzc(zzb, this.zza.zza(), 4225, zzeVar, zze(), this.zza.zzc());
                        this.zzu = null;
                    }
                } else if (i5 == 2 || i5 == 3) {
                    zze zzeVar2 = this.zzu;
                    if (zzeVar2 != null && (zzvVar = this.zza) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + zzvVar.zzb() + " on " + zzvVar.zza());
                        GmsClientSupervisor gmsClientSupervisor2 = this.zzn;
                        String zzb2 = this.zza.zzb();
                        Preconditions.checkNotNull(zzb2);
                        gmsClientSupervisor2.zzc(zzb2, this.zza.zza(), 4225, zzeVar2, zze(), this.zza.zzc());
                        this.zzd.incrementAndGet();
                    }
                    zze zzeVar3 = new zze(this, this.zzd.get());
                    this.zzu = zzeVar3;
                    zzv zzvVar2 = (this.zzv != 3 || getLocalStartServiceAction() == null) ? new zzv(getStartServicePackage(), getStartServiceAction(), false, 4225, getUseDynamicLookup()) : new zzv(getContext().getPackageName(), getLocalStartServiceAction(), true, 4225, false);
                    this.zza = zzvVar2;
                    if (zzvVar2.zzc() && getMinApkVersion() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.zza.zzb())));
                    }
                    GmsClientSupervisor gmsClientSupervisor3 = this.zzn;
                    String zzb3 = this.zza.zzb();
                    Preconditions.checkNotNull(zzb3);
                    ConnectionResult zza = gmsClientSupervisor3.zza(new zzo(zzb3, this.zza.zza(), 4225, this.zza.zzc()), zzeVar3, zze(), getBindServiceExecutor());
                    if (!zza.isSuccess()) {
                        Log.w("GmsClient", "unable to connect to service: " + this.zza.zzb() + " on " + this.zza.zza());
                        int errorCode = zza.getErrorCode() == -1 ? 16 : zza.getErrorCode();
                        if (zza.getResolution() != null) {
                            bundle = new Bundle();
                            bundle.putParcelable("pendingIntent", zza.getResolution());
                        }
                        zzl(errorCode, bundle, this.zzd.get());
                    }
                } else if (i5 == 4) {
                    Preconditions.checkNotNull(iInterface);
                    onConnectedLocked(iInterface);
                }
            } finally {
            }
        }
    }

    public void checkAvailabilityAndConnect() {
        int isGooglePlayServicesAvailable = this.zzo.isGooglePlayServicesAvailable(this.zzl, getMinApkVersion());
        if (isGooglePlayServicesAvailable == 0) {
            connect(new LegacyClientCallbackAdapter());
        } else {
            zzp(1, null);
            triggerNotAvailable(new LegacyClientCallbackAdapter(), isGooglePlayServicesAvailable, null);
        }
    }

    protected final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.zzc = connectionProgressReportCallbacks;
        zzp(2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T createServiceInterface(IBinder iBinder);

    public void disconnect() {
        this.zzd.incrementAndGet();
        synchronized (this.zzt) {
            try {
                int size = this.zzt.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ((zzc) this.zzt.get(i5)).zzf();
                }
                this.zzt.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        zzp(1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean enableLocalFallback() {
        return false;
    }

    public Account getAccount() {
        return null;
    }

    public Feature[] getApiFeatures() {
        return zze;
    }

    public final Feature[] getAvailableFeatures() {
        zzk zzkVar = this.zzE;
        if (zzkVar == null) {
            return null;
        }
        return zzkVar.zzb;
    }

    protected Executor getBindServiceExecutor() {
        return null;
    }

    public Bundle getConnectionHint() {
        return null;
    }

    public final Context getContext() {
        return this.zzl;
    }

    public String getEndpointPackageName() {
        zzv zzvVar;
        if (!isConnected() || (zzvVar = this.zza) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return zzvVar.zza();
    }

    public int getGCoreServiceId() {
        return this.zzy;
    }

    protected Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    public String getLastDisconnectMessage() {
        return this.zzk;
    }

    protected String getLocalStartServiceAction() {
        return null;
    }

    public abstract int getMinApkVersion();

    public void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        String str = Build.VERSION.SDK_INT < 31 ? this.zzA : this.zzA;
        int i5 = this.zzy;
        int i6 = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        Scope[] scopeArr = GetServiceRequest.zza;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.zzb;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i5, i6, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.zzf = this.zzl.getPackageName();
        getServiceRequest.zzi = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.zzh = (Scope[]) set.toArray(new Scope[0]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            getServiceRequest.zzj = account;
            if (iAccountAccessor != null) {
                getServiceRequest.zzg = iAccountAccessor.asBinder();
            }
        } else if (requiresAccount()) {
            getServiceRequest.zzj = getAccount();
        }
        getServiceRequest.zzk = zze;
        getServiceRequest.zzl = getApiFeatures();
        if (usesClientTelemetry()) {
            getServiceRequest.zzo = true;
        }
        try {
            synchronized (this.zzq) {
                try {
                    IGmsServiceBroker iGmsServiceBroker = this.zzr;
                    if (iGmsServiceBroker != null) {
                        iGmsServiceBroker.getService(new zzd(this, this.zzd.get()), getServiceRequest);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } finally {
                }
            }
        } catch (DeadObjectException e5) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e5);
            triggerConnectionSuspended(3);
        } catch (RemoteException e6) {
            e = e6;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        } catch (SecurityException e7) {
            throw e7;
        } catch (RuntimeException e8) {
            e = e8;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        }
    }

    protected Set<Scope> getScopes() {
        return Collections.emptySet();
    }

    public final T getService() {
        T t5;
        synchronized (this.zzp) {
            try {
                if (this.zzv == 5) {
                    throw new DeadObjectException();
                }
                checkConnected();
                IInterface iInterface = this.zzs;
                Preconditions.checkNotNull(iInterface, "Client is connected but service is null");
                t5 = (T) iInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        return t5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String getServiceDescriptor();

    protected abstract String getStartServiceAction();

    protected String getStartServicePackage() {
        return "com.google.android.gms";
    }

    public ConnectionTelemetryConfiguration getTelemetryConfiguration() {
        zzk zzkVar = this.zzE;
        if (zzkVar == null) {
            return null;
        }
        return zzkVar.zzd;
    }

    protected boolean getUseDynamicLookup() {
        return getMinApkVersion() >= 211700000;
    }

    public boolean hasConnectionInfo() {
        return this.zzE != null;
    }

    public boolean isConnected() {
        boolean z5;
        synchronized (this.zzp) {
            z5 = this.zzv == 4;
        }
        return z5;
    }

    public boolean isConnecting() {
        boolean z5;
        synchronized (this.zzp) {
            int i5 = this.zzv;
            z5 = true;
            if (i5 != 2 && i5 != 3) {
                z5 = false;
            }
        }
        return z5;
    }

    protected void onConnectedLocked(T t5) {
        this.zzh = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzi = connectionResult.getErrorCode();
        this.zzj = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onConnectionSuspended(int i5) {
        this.zzf = i5;
        this.zzg = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPostInitHandler(int i5, IBinder iBinder, Bundle bundle, int i6) {
        this.zzb.sendMessage(this.zzb.obtainMessage(1, i6, -1, new zzf(this, i5, iBinder, bundle)));
    }

    public void onUserSignOut(SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.onSignOutComplete();
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    public void setAttributionTag(String str) {
        this.zzA = str;
    }

    public void triggerConnectionSuspended(int i5) {
        this.zzb.sendMessage(this.zzb.obtainMessage(6, this.zzd.get(), i5));
    }

    protected void triggerNotAvailable(ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i5, PendingIntent pendingIntent) {
        Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.zzc = connectionProgressReportCallbacks;
        this.zzb.sendMessage(this.zzb.obtainMessage(3, this.zzd.get(), i5, pendingIntent));
    }

    public boolean usesClientTelemetry() {
        return false;
    }

    protected final String zze() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzl(int i5, Bundle bundle, int i6) {
        this.zzb.sendMessage(this.zzb.obtainMessage(7, i6, -1, new zzg(this, i5, bundle)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseGmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i5, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzC = null;
        this.zzD = false;
        this.zzE = null;
        this.zzd = new AtomicInteger(0);
        Preconditions.checkNotNull(context, "Context must not be null");
        this.zzl = context;
        Preconditions.checkNotNull(looper, "Looper must not be null");
        this.zzm = looper;
        Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzn = gmsClientSupervisor;
        Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zzo = googleApiAvailabilityLight;
        this.zzb = new zzb(this, looper);
        this.zzy = i5;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = str;
    }

    public void disconnect(String str) {
        this.zzk = str;
        disconnect();
    }
}
