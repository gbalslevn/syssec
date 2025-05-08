package coil.content;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import coil.RealImageLoader;
import coil.network.EmptyNetworkObserver;
import coil.network.NetworkObserver;
import coil.network.NetworkObserverKt;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\rJ\u0017\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\rR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001bR.\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00030\u00030\u001c8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0004\u0010\u001e\u0012\u0004\b!\u0010\r\u001a\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0011\u0010\u0017\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0017\u0010*¨\u0006,"}, d2 = {"Lcoil/util/SystemCallbacks;", "Landroid/content/ComponentCallbacks2;", "Lcoil/network/NetworkObserver$Listener;", "Lcoil/RealImageLoader;", "imageLoader", "Landroid/content/Context;", "context", BuildConfig.FLAVOR, "isNetworkObserverEnabled", "<init>", "(Lcoil/RealImageLoader;Landroid/content/Context;Z)V", BuildConfig.FLAVOR, "register", "()V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", BuildConfig.FLAVOR, "level", "onTrimMemory", "(I)V", "onLowMemory", "isOnline", "onConnectivityChange", "(Z)V", "shutdown", "Landroid/content/Context;", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "getImageLoader$coil_base_release", "()Ljava/lang/ref/WeakReference;", "getImageLoader$coil_base_release$annotations", "Lcoil/network/NetworkObserver;", "networkObserver", "Lcoil/network/NetworkObserver;", "_isOnline", "Z", "Ljava/util/concurrent/atomic/AtomicBoolean;", "_isShutdown", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Z", "Companion", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SystemCallbacks implements ComponentCallbacks2, NetworkObserver.Listener {
    private static final String OFFLINE = "OFFLINE";
    private static final String ONLINE = "ONLINE";
    private static final String TAG = "NetworkObserver";
    private volatile boolean _isOnline;
    private final AtomicBoolean _isShutdown;
    private final Context context;
    private final WeakReference<RealImageLoader> imageLoader;
    private final NetworkObserver networkObserver;

    public SystemCallbacks(RealImageLoader realImageLoader, Context context, boolean z5) {
        this.context = context;
        this.imageLoader = new WeakReference<>(realImageLoader);
        NetworkObserver NetworkObserver = z5 ? NetworkObserverKt.NetworkObserver(context, this, realImageLoader.getLogger()) : new EmptyNetworkObserver();
        this.networkObserver = NetworkObserver;
        this._isOnline = NetworkObserver.isOnline();
        this._isShutdown = new AtomicBoolean(false);
    }

    /* renamed from: isOnline, reason: from getter */
    public final boolean get_isOnline() {
        return this._isOnline;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        if (this.imageLoader.get() == null) {
            shutdown();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // coil.network.NetworkObserver.Listener
    public void onConnectivityChange(boolean isOnline) {
        RealImageLoader realImageLoader = this.imageLoader.get();
        Unit unit = null;
        if (realImageLoader != null) {
            Logger logger = realImageLoader.getLogger();
            if (logger != null && logger.getLevel() <= 4) {
                logger.log(TAG, 4, isOnline ? ONLINE : OFFLINE, null);
            }
            this._isOnline = isOnline;
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            shutdown();
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        onTrimMemory(80);
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        RealImageLoader realImageLoader = this.imageLoader.get();
        Unit unit = null;
        if (realImageLoader != null) {
            Logger logger = realImageLoader.getLogger();
            if (logger != null && logger.getLevel() <= 2) {
                logger.log(TAG, 2, "trimMemory, level=" + level, null);
            }
            realImageLoader.onTrimMemory$coil_base_release(level);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            shutdown();
        }
    }

    public final void register() {
        this.context.registerComponentCallbacks(this);
    }

    public final void shutdown() {
        if (this._isShutdown.getAndSet(true)) {
            return;
        }
        this.context.unregisterComponentCallbacks(this);
        this.networkObserver.shutdown();
    }
}
