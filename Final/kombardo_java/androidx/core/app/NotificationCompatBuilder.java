package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.session.a;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {
    private RemoteViews mBigContentView;
    private final Notification.Builder mBuilder;
    private final NotificationCompat.Builder mBuilderCompat;
    private RemoteViews mContentView;
    private final Context mContext;
    private int mGroupAlertBehavior;
    private RemoteViews mHeadsUpContentView;
    private final List<Bundle> mActionExtrasList = new ArrayList();
    private final Bundle mExtras = new Bundle();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api20Impl {
        static Notification.Builder addAction(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        static Notification.Action.Builder addExtras(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        static Notification.Action.Builder addRemoteInput(Notification.Action.Builder builder, android.app.RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        static Notification.Action build(Notification.Action.Builder builder) {
            return builder.build();
        }

        static Notification.Builder setGroup(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        static Notification.Builder setGroupSummary(Notification.Builder builder, boolean z5) {
            return builder.setGroupSummary(z5);
        }

        static Notification.Builder setLocalOnly(Notification.Builder builder, boolean z5) {
            return builder.setLocalOnly(z5);
        }

        static Notification.Builder setSortKey(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    /* loaded from: classes.dex */
    static class Api21Impl {
        static Notification.Builder addPerson(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        static Notification.Builder setCategory(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        static Notification.Builder setColor(Notification.Builder builder, int i5) {
            return builder.setColor(i5);
        }

        static Notification.Builder setPublicVersion(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        static Notification.Builder setSound(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        static Notification.Builder setVisibility(Notification.Builder builder, int i5) {
            return builder.setVisibility(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api23Impl {
        static Notification.Action.Builder createBuilder(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        static Notification.Builder setLargeIcon(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        static Notification.Builder setSmallIcon(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api24Impl {
        static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder builder, boolean z5) {
            return builder.setAllowGeneratedReplies(z5);
        }

        static Notification.Builder setCustomBigContentView(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        static Notification.Builder setCustomContentView(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        static Notification.Builder setCustomHeadsUpContentView(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        static Notification.Builder setRemoteInputHistory(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    /* loaded from: classes.dex */
    static class Api26Impl {
        static Notification.Builder createBuilder(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        static Notification.Builder setBadgeIconType(Notification.Builder builder, int i5) {
            return builder.setBadgeIconType(i5);
        }

        static Notification.Builder setColorized(Notification.Builder builder, boolean z5) {
            return builder.setColorized(z5);
        }

        static Notification.Builder setGroupAlertBehavior(Notification.Builder builder, int i5) {
            return builder.setGroupAlertBehavior(i5);
        }

        static Notification.Builder setSettingsText(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        static Notification.Builder setShortcutId(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        static Notification.Builder setTimeoutAfter(Notification.Builder builder, long j5) {
            return builder.setTimeoutAfter(j5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api28Impl {
        static Notification.Action.Builder setSemanticAction(Notification.Action.Builder builder, int i5) {
            return builder.setSemanticAction(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api29Impl {
        static Notification.Builder setAllowSystemGeneratedContextualActions(Notification.Builder builder, boolean z5) {
            return builder.setAllowSystemGeneratedContextualActions(z5);
        }

        static Notification.Builder setBubbleMetadata(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        static Notification.Action.Builder setContextual(Notification.Action.Builder builder, boolean z5) {
            return builder.setContextual(z5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api31Impl {
        static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder builder, boolean z5) {
            return builder.setAuthenticationRequired(z5);
        }

        static Notification.Builder setForegroundServiceBehavior(Notification.Builder builder, int i5) {
            return builder.setForegroundServiceBehavior(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotificationCompatBuilder(NotificationCompat.Builder builder) {
        int i5;
        this.mBuilderCompat = builder;
        Context context = builder.mContext;
        this.mContext = context;
        Notification.Builder createBuilder = Api26Impl.createBuilder(context, builder.mChannelId);
        this.mBuilder = createBuilder;
        Notification notification = builder.mNotification;
        createBuilder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.mTickerView).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(builder.mContentTitle).setContentText(builder.mContentText).setContentInfo(builder.mContentInfo).setContentIntent(builder.mContentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(builder.mFullScreenIntent, (notification.flags & 128) != 0).setNumber(builder.mNumber).setProgress(builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate);
        IconCompat iconCompat = builder.mLargeIcon;
        Api23Impl.setLargeIcon(createBuilder, iconCompat == null ? null : iconCompat.toIcon(context));
        createBuilder.setSubText(builder.mSubText).setUsesChronometer(builder.mUseChronometer).setPriority(builder.mPriority);
        Iterator<NotificationCompat.Action> it = builder.mActions.iterator();
        while (it.hasNext()) {
            addAction(it.next());
        }
        Bundle bundle = builder.mExtras;
        if (bundle != null) {
            this.mExtras.putAll(bundle);
        }
        int i6 = Build.VERSION.SDK_INT;
        this.mContentView = builder.mContentView;
        this.mBigContentView = builder.mBigContentView;
        this.mBuilder.setShowWhen(builder.mShowWhen);
        Api20Impl.setLocalOnly(this.mBuilder, builder.mLocalOnly);
        Api20Impl.setGroup(this.mBuilder, builder.mGroupKey);
        Api20Impl.setSortKey(this.mBuilder, builder.mSortKey);
        Api20Impl.setGroupSummary(this.mBuilder, builder.mGroupSummary);
        this.mGroupAlertBehavior = builder.mGroupAlertBehavior;
        Api21Impl.setCategory(this.mBuilder, builder.mCategory);
        Api21Impl.setColor(this.mBuilder, builder.mColor);
        Api21Impl.setVisibility(this.mBuilder, builder.mVisibility);
        Api21Impl.setPublicVersion(this.mBuilder, builder.mPublicVersion);
        Api21Impl.setSound(this.mBuilder, notification.sound, notification.audioAttributes);
        List combineLists = i6 < 28 ? combineLists(getPeople(builder.mPersonList), builder.mPeople) : builder.mPeople;
        if (combineLists != null && !combineLists.isEmpty()) {
            Iterator it2 = combineLists.iterator();
            while (it2.hasNext()) {
                Api21Impl.addPerson(this.mBuilder, (String) it2.next());
            }
        }
        this.mHeadsUpContentView = builder.mHeadsUpContentView;
        if (builder.mInvisibleActions.size() > 0) {
            Bundle bundle2 = builder.getExtras().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i7 = 0; i7 < builder.mInvisibleActions.size(); i7++) {
                bundle4.putBundle(Integer.toString(i7), NotificationCompatJellybean.getBundleForAction(builder.mInvisibleActions.get(i7)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            builder.getExtras().putBundle("android.car.EXTENSIONS", bundle2);
            this.mExtras.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i8 = Build.VERSION.SDK_INT;
        Object obj = builder.mSmallIcon;
        if (obj != null) {
            Api23Impl.setSmallIcon(this.mBuilder, obj);
        }
        this.mBuilder.setExtras(builder.mExtras);
        Api24Impl.setRemoteInputHistory(this.mBuilder, builder.mRemoteInputHistory);
        RemoteViews remoteViews = builder.mContentView;
        if (remoteViews != null) {
            Api24Impl.setCustomContentView(this.mBuilder, remoteViews);
        }
        RemoteViews remoteViews2 = builder.mBigContentView;
        if (remoteViews2 != null) {
            Api24Impl.setCustomBigContentView(this.mBuilder, remoteViews2);
        }
        RemoteViews remoteViews3 = builder.mHeadsUpContentView;
        if (remoteViews3 != null) {
            Api24Impl.setCustomHeadsUpContentView(this.mBuilder, remoteViews3);
        }
        Api26Impl.setBadgeIconType(this.mBuilder, builder.mBadgeIcon);
        Api26Impl.setSettingsText(this.mBuilder, builder.mSettingsText);
        Api26Impl.setShortcutId(this.mBuilder, builder.mShortcutId);
        Api26Impl.setTimeoutAfter(this.mBuilder, builder.mTimeout);
        Api26Impl.setGroupAlertBehavior(this.mBuilder, builder.mGroupAlertBehavior);
        if (builder.mColorizedSet) {
            Api26Impl.setColorized(this.mBuilder, builder.mColorized);
        }
        if (!TextUtils.isEmpty(builder.mChannelId)) {
            this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        if (i8 >= 28) {
            Iterator<Object> it3 = builder.mPersonList.iterator();
            if (it3.hasNext()) {
                a.a(it3.next());
                throw null;
            }
        }
        if (i8 >= 29) {
            Api29Impl.setAllowSystemGeneratedContextualActions(this.mBuilder, builder.mAllowSystemGeneratedContextualActions);
            Api29Impl.setBubbleMetadata(this.mBuilder, NotificationCompat.BubbleMetadata.toPlatform(null));
        }
        if (i8 >= 31 && (i5 = builder.mFgsDeferBehavior) != 0) {
            Api31Impl.setForegroundServiceBehavior(this.mBuilder, i5);
        }
        if (builder.mSilent) {
            if (this.mBuilderCompat.mGroupSummary) {
                this.mGroupAlertBehavior = 2;
            } else {
                this.mGroupAlertBehavior = 1;
            }
            this.mBuilder.setVibrate(null);
            this.mBuilder.setSound(null);
            int i9 = notification.defaults & (-4);
            notification.defaults = i9;
            this.mBuilder.setDefaults(i9);
            if (TextUtils.isEmpty(this.mBuilderCompat.mGroupKey)) {
                Api20Impl.setGroup(this.mBuilder, "silent");
            }
            Api26Impl.setGroupAlertBehavior(this.mBuilder, this.mGroupAlertBehavior);
        }
    }

    private void addAction(NotificationCompat.Action action) {
        IconCompat iconCompat = action.getIconCompat();
        Notification.Action.Builder createBuilder = Api23Impl.createBuilder(iconCompat != null ? iconCompat.toIcon() : null, action.getTitle(), action.getActionIntent());
        if (action.getRemoteInputs() != null) {
            for (android.app.RemoteInput remoteInput : RemoteInput.fromCompat(action.getRemoteInputs())) {
                Api20Impl.addRemoteInput(createBuilder, remoteInput);
            }
        }
        Bundle bundle = action.getExtras() != null ? new Bundle(action.getExtras()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        int i5 = Build.VERSION.SDK_INT;
        Api24Impl.setAllowGeneratedReplies(createBuilder, action.getAllowGeneratedReplies());
        bundle.putInt("android.support.action.semanticAction", action.getSemanticAction());
        if (i5 >= 28) {
            Api28Impl.setSemanticAction(createBuilder, action.getSemanticAction());
        }
        if (i5 >= 29) {
            Api29Impl.setContextual(createBuilder, action.isContextual());
        }
        if (i5 >= 31) {
            Api31Impl.setAuthenticationRequired(createBuilder, action.isAuthenticationRequired());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", action.getShowsUserInterface());
        Api20Impl.addExtras(createBuilder, bundle);
        Api20Impl.addAction(this.mBuilder, Api20Impl.build(createBuilder));
    }

    private static List<String> combineLists(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        ArraySet arraySet = new ArraySet(list.size() + list2.size());
        arraySet.addAll(list);
        arraySet.addAll(list2);
        return new ArrayList(arraySet);
    }

    private static List<String> getPeople(List<Object> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Object> it = list.iterator();
        if (!it.hasNext()) {
            return arrayList;
        }
        a.a(it.next());
        throw null;
    }

    public Notification build() {
        Bundle extras;
        RemoteViews makeHeadsUpContentView;
        RemoteViews makeBigContentView;
        NotificationCompat.Style style = this.mBuilderCompat.mStyle;
        if (style != null) {
            style.apply(this);
        }
        RemoteViews makeContentView = style != null ? style.makeContentView(this) : null;
        Notification buildInternal = buildInternal();
        if (makeContentView != null) {
            buildInternal.contentView = makeContentView;
        } else {
            RemoteViews remoteViews = this.mBuilderCompat.mContentView;
            if (remoteViews != null) {
                buildInternal.contentView = remoteViews;
            }
        }
        if (style != null && (makeBigContentView = style.makeBigContentView(this)) != null) {
            buildInternal.bigContentView = makeBigContentView;
        }
        if (style != null && (makeHeadsUpContentView = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this)) != null) {
            buildInternal.headsUpContentView = makeHeadsUpContentView;
        }
        if (style != null && (extras = NotificationCompat.getExtras(buildInternal)) != null) {
            style.addCompatExtras(extras);
        }
        return buildInternal;
    }

    protected Notification buildInternal() {
        return this.mBuilder.build();
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder getBuilder() {
        return this.mBuilder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context getContext() {
        return this.mContext;
    }
}
