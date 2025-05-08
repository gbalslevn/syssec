package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a/\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\n\u001a\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/room/RoomDatabase;", "db", "Landroidx/sqlite/db/SupportSQLiteQuery;", "sqLiteQuery", BuildConfig.FLAVOR, "maybeCopy", "Landroid/os/CancellationSignal;", "signal", "Landroid/database/Cursor;", "query", "(Landroidx/room/RoomDatabase;Landroidx/sqlite/db/SupportSQLiteQuery;ZLandroid/os/CancellationSignal;)Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", BuildConfig.FLAVOR, "dropFtsSyncTriggers", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "Ljava/io/File;", "databaseFile", BuildConfig.FLAVOR, "readVersion", "(Ljava/io/File;)I", "room-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DBUtil {
    public static final void dropFtsSyncTriggers(SupportSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        List createListBuilder = CollectionsKt.createListBuilder();
        Cursor query = db.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        try {
            Cursor cursor = query;
            while (cursor.moveToNext()) {
                createListBuilder.add(cursor.getString(0));
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(query, null);
            for (String triggerName : CollectionsKt.build(createListBuilder)) {
                Intrinsics.checkNotNullExpressionValue(triggerName, "triggerName");
                if (StringsKt.startsWith$default(triggerName, "room_fts_content_sync_", false, 2, (Object) null)) {
                    db.execSQL("DROP TRIGGER IF EXISTS " + triggerName);
                }
            }
        } finally {
        }
    }

    public static final Cursor query(RoomDatabase db, SupportSQLiteQuery sqLiteQuery, boolean z5, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(sqLiteQuery, "sqLiteQuery");
        Cursor query = db.query(sqLiteQuery, cancellationSignal);
        if (!z5 || !(query instanceof AbstractWindowedCursor)) {
            return query;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) query;
        int count = abstractWindowedCursor.getCount();
        return (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count ? CursorUtil.copyAndClose(query) : query;
    }

    public static final int readVersion(File databaseFile) {
        Intrinsics.checkNotNullParameter(databaseFile, "databaseFile");
        FileChannel channel = new FileInputStream(databaseFile).getChannel();
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(allocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            allocate.rewind();
            int i5 = allocate.getInt();
            CloseableKt.closeFinally(channel, null);
            return i5;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(channel, th);
                throw th2;
            }
        }
    }
}
