package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;

@Deprecated
/* loaded from: classes.dex */
public abstract class BundleCompat {
    @Deprecated
    public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        bundle.putBinder(str, iBinder);
    }
}
