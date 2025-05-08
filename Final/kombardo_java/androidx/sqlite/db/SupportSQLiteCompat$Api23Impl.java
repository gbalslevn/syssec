package androidx.sqlite.db;

import android.database.Cursor;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"androidx/sqlite/db/SupportSQLiteCompat$Api23Impl", BuildConfig.FLAVOR, "<init>", "()V", "Landroid/database/Cursor;", "cursor", "Landroid/os/Bundle;", "extras", BuildConfig.FLAVOR, "setExtras", "(Landroid/database/Cursor;Landroid/os/Bundle;)V", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SupportSQLiteCompat$Api23Impl {
    public static final SupportSQLiteCompat$Api23Impl INSTANCE = new SupportSQLiteCompat$Api23Impl();

    private SupportSQLiteCompat$Api23Impl() {
    }

    public static final void setExtras(Cursor cursor, Bundle extras) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Intrinsics.checkNotNullParameter(extras, "extras");
        cursor.setExtras(extras);
    }
}
