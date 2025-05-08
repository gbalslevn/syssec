package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.sun.jna.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0001:B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u000fJ\u001f\u0010 \u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0010H$¢\u0006\u0004\b%\u0010\u0013J\u0017\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020&H\u0004¢\u0006\u0004\b(\u0010)R\u001a\u0010\u0003\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u00100R\u0016\u00101\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00106R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00106R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00107R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00106R\u0019\u0010\n\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\n\u00107\u001a\u0004\b8\u00109¨\u0006;"}, d2 = {"Lcom/facebook/internal/PlatformServiceClient;", "Landroid/content/ServiceConnection;", "Landroid/content/Context;", "context", BuildConfig.FLAVOR, "requestMessage", "replyMessage", "protocolVersion", BuildConfig.FLAVOR, "applicationId", "nonce", "<init>", "(Landroid/content/Context;IIILjava/lang/String;Ljava/lang/String;)V", BuildConfig.FLAVOR, "sendMessage", "()V", "Landroid/os/Bundle;", "result", Callback.METHOD_NAME, "(Landroid/os/Bundle;)V", "Lcom/facebook/internal/PlatformServiceClient$CompletedListener;", "listener", "setCompletedListener", "(Lcom/facebook/internal/PlatformServiceClient$CompletedListener;)V", BuildConfig.FLAVOR, "start", "()Z", "cancel", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "service", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "data", "populateRequestBundle", "Landroid/os/Message;", "message", "handleMessage", "(Landroid/os/Message;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Lcom/facebook/internal/PlatformServiceClient$CompletedListener;", "running", "Z", "Landroid/os/Messenger;", "sender", "Landroid/os/Messenger;", "I", "Ljava/lang/String;", "getNonce", "()Ljava/lang/String;", "CompletedListener", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class PlatformServiceClient implements ServiceConnection {
    private final String applicationId;
    private final Context context;
    private final Handler handler;
    private CompletedListener listener;
    private final String nonce;
    private final int protocolVersion;
    private final int replyMessage;
    private final int requestMessage;
    private boolean running;
    private Messenger sender;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/PlatformServiceClient$CompletedListener;", BuildConfig.FLAVOR, "completed", BuildConfig.FLAVOR, "result", "Landroid/os/Bundle;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public interface CompletedListener {
        void completed(Bundle result);
    }

    public PlatformServiceClient(Context context, int i5, int i6, int i7, String applicationId, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext != null ? applicationContext : context;
        this.requestMessage = i5;
        this.replyMessage = i6;
        this.applicationId = applicationId;
        this.protocolVersion = i7;
        this.nonce = str;
        this.handler = new Handler() { // from class: com.facebook.internal.PlatformServiceClient.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        Intrinsics.checkNotNullParameter(message, "message");
                        PlatformServiceClient.this.handleMessage(message);
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                }
            }
        };
    }

    private final void callback(Bundle result) {
        if (this.running) {
            this.running = false;
            CompletedListener completedListener = this.listener;
            if (completedListener == null) {
                return;
            }
            completedListener.completed(result);
        }
    }

    private final void sendMessage() {
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.extra.APPLICATION_ID", this.applicationId);
        String str = this.nonce;
        if (str != null) {
            bundle.putString("com.facebook.platform.extra.NONCE", str);
        }
        populateRequestBundle(bundle);
        Message obtain = Message.obtain((Handler) null, this.requestMessage);
        obtain.arg1 = this.protocolVersion;
        obtain.setData(bundle);
        obtain.replyTo = new Messenger(this.handler);
        try {
            Messenger messenger = this.sender;
            if (messenger == null) {
                return;
            }
            messenger.send(obtain);
        } catch (RemoteException unused) {
            callback(null);
        }
    }

    public final void cancel() {
        this.running = false;
    }

    protected final Context getContext() {
        return this.context;
    }

    protected final void handleMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.what == this.replyMessage) {
            Bundle data = message.getData();
            if (data.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
                callback(null);
            } else {
                callback(data);
            }
            try {
                this.context.unbindService(this);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(service, "service");
        this.sender = new Messenger(service);
        sendMessage();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.sender = null;
        try {
            this.context.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        callback(null);
    }

    protected abstract void populateRequestBundle(Bundle data);

    public final void setCompletedListener(CompletedListener listener) {
        this.listener = listener;
    }

    public final boolean start() {
        synchronized (this) {
            boolean z5 = false;
            if (this.running) {
                return false;
            }
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            if (NativeProtocol.getLatestAvailableProtocolVersionForService(this.protocolVersion) == -1) {
                return false;
            }
            Intent createPlatformServiceIntent = NativeProtocol.createPlatformServiceIntent(getContext());
            if (createPlatformServiceIntent != null) {
                z5 = true;
                this.running = true;
                getContext().bindService(createPlatformServiceIntent, this, 1);
            }
            return z5;
        }
    }
}
