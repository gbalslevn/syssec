package androidx.sqlite.db;

import android.app.ActivityManager;
import android.database.Cursor;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"androidx/sqlite/db/SupportSQLiteCompat$Api19Impl", BuildConfig.FLAVOR, "<init>", "()V", "Landroid/database/Cursor;", "cursor", "Landroid/net/Uri;", "getNotificationUri", "(Landroid/database/Cursor;)Landroid/net/Uri;", "Landroid/app/ActivityManager;", "activityManager", BuildConfig.FLAVOR, "isLowRamDevice", "(Landroid/app/ActivityManager;)Z", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SupportSQLiteCompat$Api19Impl {
    public static final SupportSQLiteCompat$Api19Impl INSTANCE = new SupportSQLiteCompat$Api19Impl();

    private SupportSQLiteCompat$Api19Impl() {
    }

    public static final Uri getNotificationUri(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Uri notificationUri = cursor.getNotificationUri();
        Intrinsics.checkNotNullExpressionValue(notificationUri, "cursor.notificationUri");
        return notificationUri;
    }

    public static final boolean isLowRamDevice(ActivityManager activityManager) {
        Intrinsics.checkNotNullParameter(activityManager, "activityManager");
        return activityManager.isLowRamDevice();
    }
}
