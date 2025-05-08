package com.google.firebase.messaging;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.messaging.Constants;
import java.util.Map;

/* loaded from: classes2.dex */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new RemoteMessageCreator();
    Bundle bundle;
    private Map<String, String> data;
    private Notification notification;

    /* loaded from: classes2.dex */
    public static class Notification {
        private final String body;
        private final String[] bodyLocArgs;
        private final String bodyLocKey;
        private final String channelId;
        private final String clickAction;
        private final String color;
        private final boolean defaultLightSettings;
        private final boolean defaultSound;
        private final boolean defaultVibrateTimings;
        private final Long eventTime;
        private final String icon;
        private final String imageUrl;
        private final int[] lightSettings;
        private final Uri link;
        private final boolean localOnly;
        private final Integer notificationCount;
        private final Integer notificationPriority;
        private final String sound;
        private final boolean sticky;
        private final String tag;
        private final String ticker;
        private final String title;
        private final String[] titleLocArgs;
        private final String titleLocKey;
        private final long[] vibrateTimings;
        private final Integer visibility;

        private static String[] getLocalizationArgs(NotificationParams notificationParams, String str) {
            Object[] localizationArgsForKey = notificationParams.getLocalizationArgsForKey(str);
            if (localizationArgsForKey == null) {
                return null;
            }
            String[] strArr = new String[localizationArgsForKey.length];
            for (int i5 = 0; i5 < localizationArgsForKey.length; i5++) {
                strArr[i5] = String.valueOf(localizationArgsForKey[i5]);
            }
            return strArr;
        }

        public String getBody() {
            return this.body;
        }

        public String getChannelId() {
            return this.channelId;
        }

        public boolean getDefaultSound() {
            return this.defaultSound;
        }

        public String getSound() {
            return this.sound;
        }

        public String getTitle() {
            return this.title;
        }

        private Notification(NotificationParams notificationParams) {
            this.title = notificationParams.getString("gcm.n.title");
            this.titleLocKey = notificationParams.getLocalizationResourceForKey("gcm.n.title");
            this.titleLocArgs = getLocalizationArgs(notificationParams, "gcm.n.title");
            this.body = notificationParams.getString("gcm.n.body");
            this.bodyLocKey = notificationParams.getLocalizationResourceForKey("gcm.n.body");
            this.bodyLocArgs = getLocalizationArgs(notificationParams, "gcm.n.body");
            this.icon = notificationParams.getString("gcm.n.icon");
            this.sound = notificationParams.getSoundResourceName();
            this.tag = notificationParams.getString("gcm.n.tag");
            this.color = notificationParams.getString("gcm.n.color");
            this.clickAction = notificationParams.getString("gcm.n.click_action");
            this.channelId = notificationParams.getString("gcm.n.android_channel_id");
            this.link = notificationParams.getLink();
            this.imageUrl = notificationParams.getString("gcm.n.image");
            this.ticker = notificationParams.getString("gcm.n.ticker");
            this.notificationPriority = notificationParams.getInteger("gcm.n.notification_priority");
            this.visibility = notificationParams.getInteger("gcm.n.visibility");
            this.notificationCount = notificationParams.getInteger("gcm.n.notification_count");
            this.sticky = notificationParams.getBoolean("gcm.n.sticky");
            this.localOnly = notificationParams.getBoolean("gcm.n.local_only");
            this.defaultSound = notificationParams.getBoolean("gcm.n.default_sound");
            this.defaultVibrateTimings = notificationParams.getBoolean("gcm.n.default_vibrate_timings");
            this.defaultLightSettings = notificationParams.getBoolean("gcm.n.default_light_settings");
            this.eventTime = notificationParams.getLong("gcm.n.event_time");
            this.lightSettings = notificationParams.getLightSettings();
            this.vibrateTimings = notificationParams.getVibrateTimings();
        }
    }

    public RemoteMessage(Bundle bundle) {
        this.bundle = bundle;
    }

    public Map<String, String> getData() {
        if (this.data == null) {
            this.data = Constants.MessagePayloadKeys.extractDeveloperDefinedPayload(this.bundle);
        }
        return this.data;
    }

    public Notification getNotification() {
        if (this.notification == null && NotificationParams.isNotification(this.bundle)) {
            this.notification = new Notification(new NotificationParams(this.bundle));
        }
        return this.notification;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        RemoteMessageCreator.writeToParcel(this, parcel, i5);
    }
}
