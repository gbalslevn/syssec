package androidx.core.app;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class NotificationCompatJellybean {
    private static final String KEY_ACTION_INTENT = "actionIntent";
    private static final String KEY_ALLOWED_DATA_TYPES = "allowedDataTypes";
    private static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
    private static final String KEY_CHOICES = "choices";
    private static final String KEY_DATA_ONLY_REMOTE_INPUTS = "dataOnlyRemoteInputs";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_ICON = "icon";
    private static final String KEY_LABEL = "label";
    private static final String KEY_REMOTE_INPUTS = "remoteInputs";
    private static final String KEY_RESULT_KEY = "resultKey";
    private static final String KEY_SEMANTIC_ACTION = "semanticAction";
    private static final String KEY_SHOWS_USER_INTERFACE = "showsUserInterface";
    private static final String KEY_TITLE = "title";
    private static Field sActionIconField;
    private static Field sActionIntentField;
    private static Field sActionTitleField;
    private static boolean sActionsAccessFailed;
    private static Field sActionsField;
    private static Field sExtrasField;
    private static boolean sExtrasFieldAccessFailed;
    private static final Object sExtrasLock = new Object();
    private static final Object sActionsLock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle getBundleForAction(NotificationCompat.Action action) {
        Bundle bundle = new Bundle();
        IconCompat iconCompat = action.getIconCompat();
        bundle.putInt(KEY_ICON, iconCompat != null ? iconCompat.getResId() : 0);
        bundle.putCharSequence("title", action.getTitle());
        bundle.putParcelable(KEY_ACTION_INTENT, action.getActionIntent());
        Bundle bundle2 = action.getExtras() != null ? new Bundle(action.getExtras()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        bundle.putBundle(KEY_EXTRAS, bundle2);
        bundle.putParcelableArray(KEY_REMOTE_INPUTS, toBundleArray(action.getRemoteInputs()));
        bundle.putBoolean(KEY_SHOWS_USER_INTERFACE, action.getShowsUserInterface());
        bundle.putInt(KEY_SEMANTIC_ACTION, action.getSemanticAction());
        return bundle;
    }

    private static Bundle toBundle(RemoteInput remoteInput) {
        new Bundle();
        throw null;
    }

    private static Bundle[] toBundleArray(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i5 = 0; i5 < remoteInputArr.length; i5++) {
            RemoteInput remoteInput = remoteInputArr[i5];
            bundleArr[i5] = toBundle(null);
        }
        return bundleArr;
    }
}
