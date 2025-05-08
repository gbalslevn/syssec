package androidx.core.os;

import android.content.Context;
import android.os.UserManager;

/* loaded from: classes.dex */
public abstract class UserManagerCompat {

    /* loaded from: classes.dex */
    static class Api24Impl {
        static boolean isUserUnlocked(Context context) {
            return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
        }
    }

    public static boolean isUserUnlocked(Context context) {
        return Api24Impl.isUserUnlocked(context);
    }
}
