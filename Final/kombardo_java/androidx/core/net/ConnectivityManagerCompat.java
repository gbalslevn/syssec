package androidx.core.net;

import android.net.ConnectivityManager;

/* loaded from: classes.dex */
public abstract class ConnectivityManagerCompat {
    @Deprecated
    public static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
        return connectivityManager.isActiveNetworkMetered();
    }
}
