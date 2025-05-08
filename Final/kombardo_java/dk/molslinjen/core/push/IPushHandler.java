package dk.molslinjen.core.push;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\t\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0005H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/core/push/IPushHandler;", BuildConfig.FLAVOR, "setPushEnabled", BuildConfig.FLAVOR, "allowNotifications", BuildConfig.FLAVOR, "setup", "context", "Landroid/content/Context;", "updatePushSubscriptions", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPushEnabled", "openedNotification", "intent", "Landroid/content/Intent;", "setToken", "token", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IPushHandler {
    boolean isPushEnabled();

    void openedNotification(Intent intent);

    void setPushEnabled(boolean allowNotifications);

    void setToken(String token);

    void setup(Context context);

    Object updatePushSubscriptions(Continuation<? super Unit> continuation);
}
