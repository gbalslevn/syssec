package dk.molslinjen.core.push;

import android.content.Context;
import android.content.Intent;
import dk.molslinjen.domain.providers.IPushHandlerProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\u0011\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\u000e\u0010\u0014\u001a\u00020\tH\u0096A¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/core/push/PushHandlerProvider;", "Ldk/molslinjen/domain/providers/IPushHandlerProvider;", "Ldk/molslinjen/core/push/IPushHandler;", "pushHandler", "<init>", "(Ldk/molslinjen/core/push/IPushHandler;)V", "isPushEnabled", BuildConfig.FLAVOR, "openedNotification", BuildConfig.FLAVOR, "intent", "Landroid/content/Intent;", "setPushEnabled", "allowNotifications", "setToken", "token", BuildConfig.FLAVOR, "setup", "context", "Landroid/content/Context;", "updatePushSubscriptions", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PushHandlerProvider implements IPushHandlerProvider, IPushHandler {
    private final IPushHandler pushHandler;

    public PushHandlerProvider(IPushHandler pushHandler) {
        Intrinsics.checkNotNullParameter(pushHandler, "pushHandler");
        this.pushHandler = pushHandler;
    }

    @Override // dk.molslinjen.domain.providers.IPushHandlerProvider, dk.molslinjen.core.push.IPushHandler
    public boolean isPushEnabled() {
        return this.pushHandler.isPushEnabled();
    }

    @Override // dk.molslinjen.core.push.IPushHandler
    public void openedNotification(Intent intent) {
        this.pushHandler.openedNotification(intent);
    }

    @Override // dk.molslinjen.core.push.IPushHandler
    public void setPushEnabled(boolean allowNotifications) {
        this.pushHandler.setPushEnabled(allowNotifications);
    }

    @Override // dk.molslinjen.core.push.IPushHandler
    public void setToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.pushHandler.setToken(token);
    }

    @Override // dk.molslinjen.core.push.IPushHandler
    public void setup(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.pushHandler.setup(context);
    }

    @Override // dk.molslinjen.core.push.IPushHandler
    public Object updatePushSubscriptions(Continuation<? super Unit> continuation) {
        return this.pushHandler.updatePushSubscriptions(continuation);
    }
}
