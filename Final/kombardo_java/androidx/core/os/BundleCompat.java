package androidx.core.os;

import android.os.Build;
import android.os.Bundle;

/* loaded from: classes.dex */
public abstract class BundleCompat {

    /* loaded from: classes.dex */
    static class Api33Impl {
        static <T> T getParcelable(Bundle bundle, String str, Class<T> cls) {
            return (T) bundle.getParcelable(str, cls);
        }
    }

    public static <T> T getParcelable(Bundle bundle, String str, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return (T) Api33Impl.getParcelable(bundle, str, cls);
        }
        T t5 = (T) bundle.getParcelable(str);
        if (cls.isInstance(t5)) {
            return t5;
        }
        return null;
    }
}
