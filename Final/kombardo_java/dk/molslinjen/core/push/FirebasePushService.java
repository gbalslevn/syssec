package dk.molslinjen.core.push;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BundleKt;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import dagger.hilt.android.EntryPointAccessors;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.managers.notification.INotificationManager;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.global.navigation.MainActivity;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.AgillicReportId;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/core/push/FirebasePushService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "<init>", "()V", "getNotificationManager", "Ldk/molslinjen/domain/managers/notification/INotificationManager;", "getPushHandler", "Ldk/molslinjen/core/push/IPushHandler;", "onMessageReceived", BuildConfig.FLAVOR, "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "sendNotification", Constants.IntentExtra.ReportId, BuildConfig.FLAVOR, "(Lcom/google/firebase/messaging/RemoteMessage;Ljava/lang/Integer;)V", "onNewToken", "token", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FirebasePushService extends FirebaseMessagingService {
    private final INotificationManager getNotificationManager() {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return ((NotificationManagerEntryPoint) EntryPointAccessors.fromApplication(applicationContext, NotificationManagerEntryPoint.class)).getNotificationManager();
    }

    private final IPushHandler getPushHandler() {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return ((PushHandlerEntryPoint) EntryPointAccessors.fromApplication(applicationContext, PushHandlerEntryPoint.class)).getPushHandler();
    }

    private final void sendNotification(RemoteMessage remoteMessage, Integer reportId) {
        RemoteMessage.Notification notification = remoteMessage.getNotification();
        if (notification == null) {
            return;
        }
        Intent putExtras = new Intent(this, (Class<?>) MainActivity.class).addFlags(268435456).putExtras(BundleKt.bundleOf(TuplesKt.to(Constants.IntentExtra.ReportId, reportId), TuplesKt.to(Constants.IntentExtra.PushTitle, notification.getTitle()), TuplesKt.to(Constants.IntentExtra.PushBody, notification.getBody()), TuplesKt.to(Constants.IntentExtra.PushTagKey, remoteMessage.getData().get(Constants.IntentExtra.PushTagKey)), TuplesKt.to(Constants.IntentExtra.PushTagValue, remoteMessage.getData().get(Constants.IntentExtra.PushTagValue))));
        Intrinsics.checkNotNullExpressionValue(putExtras, "putExtras(...)");
        PendingIntent activity = PendingIntent.getActivity(this, 0, putExtras, 201326592);
        String channelId = notification.getChannelId();
        if (channelId == null) {
            channelId = reportId != null ? "Marketing" : "Default";
        }
        int i5 = reportId != null ? R.string.permission_marketing_notification_title : R.string.permission_notification_title;
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(this, channelId).setSmallIcon(2131165365).setContentTitle(notification.getTitle()).setContentText(notification.getBody()).setAutoCancel(true);
        if (!notification.getDefaultSound()) {
            String sound = notification.getSound();
            defaultUri = sound != null ? Uri.parse(sound) : null;
        }
        NotificationCompat.Builder contentIntent = autoCancel.setSound(defaultUri).setContentIntent(activity);
        Intrinsics.checkNotNullExpressionValue(contentIntent, "setContentIntent(...)");
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        notificationManager.createNotificationChannel(new NotificationChannel(channelId, getApplicationContext().getString(i5), 3));
        notificationManager.notify(Random.INSTANCE.nextInt(), contentIntent.build());
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        Logger.log$default(Logger.INSTANCE, "Notification received in foreground: " + remoteMessage.getData(), "FirebasePushService", 0, 4, null);
        if (remoteMessage.getNotification() != null) {
            String str = remoteMessage.getData().get(Constants.IntentExtra.AgillicReportId);
            AgillicReportId agillicReportId = (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? null : new AgillicReportId(intOrNull.intValue());
            sendNotification(remoteMessage, agillicReportId != null ? Integer.valueOf(agillicReportId.getValue()) : null);
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        super.onNewToken(token);
        getNotificationManager().setToken(token);
        getPushHandler().setToken(token);
    }
}
