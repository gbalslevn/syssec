package androidx.room;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteCompat$Api19Impl;
import androidx.sqlite.db.SupportSQLiteCompat$Api23Impl;
import androidx.sqlite.db.SupportSQLiteCompat$Api29Impl;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u001e\u001f B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0097\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00018\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Landroidx/room/AutoClosingRoomOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Landroidx/room/DelegatingOpenHelper;", "delegate", "Landroidx/room/AutoCloser;", "autoCloser", "<init>", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper;Landroidx/room/AutoCloser;)V", BuildConfig.FLAVOR, "enabled", BuildConfig.FLAVOR, "setWriteAheadLoggingEnabled", "(Z)V", "close", "()V", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "getDelegate", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Landroidx/room/AutoCloser;", "Landroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;", "autoClosingDb", "Landroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;", BuildConfig.FLAVOR, "getDatabaseName", "()Ljava/lang/String;", "databaseName", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getWritableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "AutoClosingSupportSQLiteDatabase", "AutoClosingSupportSqliteStatement", "KeepAliveCursor", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    public final AutoCloser autoCloser;
    private final AutoClosingSupportSQLiteDatabase autoClosingDb;
    private final SupportSQLiteOpenHelper delegate;

    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0017J\u0017\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0015\u0010\u0019J!\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0017¢\u0006\u0004\b\u0015\u0010\u001cJE\u0010&\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\t2\u0012\u0010%\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010$\u0018\u00010#H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b(\u0010)J)\u0010(\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0010\u0010*\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010$0#H\u0016¢\u0006\u0004\b(\u0010+J\u000f\u0010,\u001a\u00020\u0006H\u0016¢\u0006\u0004\b,\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010-R\u0014\u0010.\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0014R\u0016\u00101\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00102\u001a\u00020\u00128WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0014R(\u00107\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t04\u0018\u0001038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00068"}, d2 = {"Landroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "Landroidx/room/AutoCloser;", "autoCloser", "<init>", "(Landroidx/room/AutoCloser;)V", BuildConfig.FLAVOR, "pokeOpen", "()V", BuildConfig.FLAVOR, "sql", "Landroidx/sqlite/db/SupportSQLiteStatement;", "compileStatement", "(Ljava/lang/String;)Landroidx/sqlite/db/SupportSQLiteStatement;", "beginTransaction", "beginTransactionNonExclusive", "endTransaction", "setTransactionSuccessful", BuildConfig.FLAVOR, "inTransaction", "()Z", "query", "Landroid/database/Cursor;", "(Ljava/lang/String;)Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "(Landroidx/sqlite/db/SupportSQLiteQuery;)Landroid/database/Cursor;", "Landroid/os/CancellationSignal;", "cancellationSignal", "(Landroidx/sqlite/db/SupportSQLiteQuery;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "table", BuildConfig.FLAVOR, "conflictAlgorithm", "Landroid/content/ContentValues;", "values", "whereClause", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "whereArgs", "update", "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "execSQL", "(Ljava/lang/String;)V", "bindArgs", "(Ljava/lang/String;[Ljava/lang/Object;)V", "close", "Landroidx/room/AutoCloser;", "isOpen", "getPath", "()Ljava/lang/String;", "path", "isWriteAheadLoggingEnabled", BuildConfig.FLAVOR, "Landroid/util/Pair;", "getAttachedDbs", "()Ljava/util/List;", "attachedDbs", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class AutoClosingSupportSQLiteDatabase implements SupportSQLiteDatabase {
        private final AutoCloser autoCloser;

        public AutoClosingSupportSQLiteDatabase(AutoCloser autoCloser) {
            Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
            this.autoCloser = autoCloser;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransaction() {
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransaction();
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionNonExclusive() {
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionNonExclusive();
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.autoCloser.closeDatabaseIfOpen();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public SupportSQLiteStatement compileStatement(String sql) {
            Intrinsics.checkNotNullParameter(sql, "sql");
            return new AutoClosingSupportSqliteStatement(sql, this.autoCloser);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void endTransaction() {
            if (this.autoCloser.getDelegateDatabase() == null) {
                throw new IllegalStateException("End transaction called but delegateDb is null");
            }
            try {
                SupportSQLiteDatabase delegateDatabase = this.autoCloser.getDelegateDatabase();
                Intrinsics.checkNotNull(delegateDatabase);
                delegateDatabase.endTransaction();
            } finally {
                this.autoCloser.decrementCountAndScheduleClose();
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(final String sql) {
            Intrinsics.checkNotNullParameter(sql, "sql");
            this.autoCloser.executeRefCountingFunction(new Function1<SupportSQLiteDatabase, Object>() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(SupportSQLiteDatabase db) {
                    Intrinsics.checkNotNullParameter(db, "db");
                    db.execSQL(sql);
                    return null;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public List<Pair<String, String>> getAttachedDbs() {
            return (List) this.autoCloser.executeRefCountingFunction(new Function1<SupportSQLiteDatabase, List<? extends Pair<String, String>>>() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1
                @Override // kotlin.jvm.functions.Function1
                public final List<Pair<String, String>> invoke(SupportSQLiteDatabase obj) {
                    Intrinsics.checkNotNullParameter(obj, "obj");
                    return obj.getAttachedDbs();
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public String getPath() {
            return (String) this.autoCloser.executeRefCountingFunction(new Function1<SupportSQLiteDatabase, String>() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$path$1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(SupportSQLiteDatabase obj) {
                    Intrinsics.checkNotNullParameter(obj, "obj");
                    return obj.getPath();
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean inTransaction() {
            if (this.autoCloser.getDelegateDatabase() == null) {
                return false;
            }
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isOpen() {
            SupportSQLiteDatabase delegateDatabase = this.autoCloser.getDelegateDatabase();
            if (delegateDatabase == null) {
                return false;
            }
            return delegateDatabase.isOpen();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isWriteAheadLoggingEnabled() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(new Function1<SupportSQLiteDatabase, Boolean>() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isWriteAheadLoggingEnabled$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SupportSQLiteDatabase db) {
                    Intrinsics.checkNotNullParameter(db, "db");
                    return Boolean.valueOf(db.isWriteAheadLoggingEnabled());
                }
            })).booleanValue();
        }

        public final void pokeOpen() {
            this.autoCloser.executeRefCountingFunction(new Function1<SupportSQLiteDatabase, Object>() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pokeOpen$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(SupportSQLiteDatabase it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return null;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(String query) {
            Intrinsics.checkNotNullParameter(query, "query");
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(query), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setTransactionSuccessful() {
            Unit unit;
            SupportSQLiteDatabase delegateDatabase = this.autoCloser.getDelegateDatabase();
            if (delegateDatabase != null) {
                delegateDatabase.setTransactionSuccessful();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int update(final String table, final int conflictAlgorithm, final ContentValues values, final String whereClause, final Object[] whereArgs) {
            Intrinsics.checkNotNullParameter(table, "table");
            Intrinsics.checkNotNullParameter(values, "values");
            return ((Number) this.autoCloser.executeRefCountingFunction(new Function1<SupportSQLiteDatabase, Integer>() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$update$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Integer invoke(SupportSQLiteDatabase db) {
                    Intrinsics.checkNotNullParameter(db, "db");
                    return Integer.valueOf(db.update(table, conflictAlgorithm, values, whereClause, whereArgs));
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(final String sql, final Object[] bindArgs) {
            Intrinsics.checkNotNullParameter(sql, "sql");
            Intrinsics.checkNotNullParameter(bindArgs, "bindArgs");
            this.autoCloser.executeRefCountingFunction(new Function1<SupportSQLiteDatabase, Object>() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(SupportSQLiteDatabase db) {
                    Intrinsics.checkNotNullParameter(db, "db");
                    db.execSQL(sql, bindArgs);
                    return null;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(SupportSQLiteQuery query) {
            Intrinsics.checkNotNullParameter(query, "query");
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(query), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(SupportSQLiteQuery query, CancellationSignal cancellationSignal) {
            Intrinsics.checkNotNullParameter(query, "query");
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(query, cancellationSignal), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010!\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u001bH\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010$\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010'J\u001f\u0010)\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010+R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010,R(\u0010/\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00130-j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0013`.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00061"}, d2 = {"Landroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement;", "Landroidx/sqlite/db/SupportSQLiteStatement;", BuildConfig.FLAVOR, "sql", "Landroidx/room/AutoCloser;", "autoCloser", "<init>", "(Ljava/lang/String;Landroidx/room/AutoCloser;)V", "T", "Lkotlin/Function1;", "block", "executeSqliteStatementWithRefCount", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "supportSQLiteStatement", BuildConfig.FLAVOR, "doBinds", "(Landroidx/sqlite/db/SupportSQLiteStatement;)V", BuildConfig.FLAVOR, "bindIndex", BuildConfig.FLAVOR, "value", "saveBinds", "(ILjava/lang/Object;)V", "close", "()V", "executeUpdateDelete", "()I", BuildConfig.FLAVOR, "executeInsert", "()J", "index", "bindNull", "(I)V", "bindLong", "(IJ)V", BuildConfig.FLAVOR, "bindDouble", "(ID)V", "bindString", "(ILjava/lang/String;)V", BuildConfig.FLAVOR, "bindBlob", "(I[B)V", "Ljava/lang/String;", "Landroidx/room/AutoCloser;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "binds", "Ljava/util/ArrayList;", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    private static final class AutoClosingSupportSqliteStatement implements SupportSQLiteStatement {
        private final AutoCloser autoCloser;
        private final ArrayList<Object> binds;
        private final String sql;

        public AutoClosingSupportSqliteStatement(String sql, AutoCloser autoCloser) {
            Intrinsics.checkNotNullParameter(sql, "sql");
            Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
            this.sql = sql;
            this.autoCloser = autoCloser;
            this.binds = new ArrayList<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void doBinds(SupportSQLiteStatement supportSQLiteStatement) {
            Iterator<T> it = this.binds.iterator();
            int i5 = 0;
            while (it.hasNext()) {
                it.next();
                int i6 = i5 + 1;
                if (i5 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Object obj = this.binds.get(i5);
                if (obj == null) {
                    supportSQLiteStatement.bindNull(i6);
                } else if (obj instanceof Long) {
                    supportSQLiteStatement.bindLong(i6, ((Number) obj).longValue());
                } else if (obj instanceof Double) {
                    supportSQLiteStatement.bindDouble(i6, ((Number) obj).doubleValue());
                } else if (obj instanceof String) {
                    supportSQLiteStatement.bindString(i6, (String) obj);
                } else if (obj instanceof byte[]) {
                    supportSQLiteStatement.bindBlob(i6, (byte[]) obj);
                }
                i5 = i6;
            }
        }

        private final <T> T executeSqliteStatementWithRefCount(final Function1<? super SupportSQLiteStatement, ? extends T> block) {
            return (T) this.autoCloser.executeRefCountingFunction(new Function1<SupportSQLiteDatabase, T>() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final T invoke(SupportSQLiteDatabase db) {
                    String str;
                    Intrinsics.checkNotNullParameter(db, "db");
                    str = AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement.this.sql;
                    SupportSQLiteStatement compileStatement = db.compileStatement(str);
                    AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement.this.doBinds(compileStatement);
                    return block.invoke(compileStatement);
                }
            });
        }

        private final void saveBinds(int bindIndex, Object value) {
            int size;
            int i5 = bindIndex - 1;
            if (i5 >= this.binds.size() && (size = this.binds.size()) <= i5) {
                while (true) {
                    this.binds.add(null);
                    if (size == i5) {
                        break;
                    } else {
                        size++;
                    }
                }
            }
            this.binds.set(i5, value);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindBlob(int index, byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            saveBinds(index, value);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindDouble(int index, double value) {
            saveBinds(index, Double.valueOf(value));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindLong(int index, long value) {
            saveBinds(index, Long.valueOf(value));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindNull(int index) {
            saveBinds(index, null);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindString(int index, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            saveBinds(index, value);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long executeInsert() {
            return ((Number) executeSqliteStatementWithRefCount(new Function1<SupportSQLiteStatement, Long>() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeInsert$1
                @Override // kotlin.jvm.functions.Function1
                public final Long invoke(SupportSQLiteStatement obj) {
                    Intrinsics.checkNotNullParameter(obj, "obj");
                    return Long.valueOf(obj.executeInsert());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public int executeUpdateDelete() {
            return ((Number) executeSqliteStatementWithRefCount(new Function1<SupportSQLiteStatement, Integer>() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeUpdateDelete$1
                @Override // kotlin.jvm.functions.Function1
                public final Integer invoke(SupportSQLiteStatement obj) {
                    Intrinsics.checkNotNullParameter(obj, "obj");
                    return Integer.valueOf(obj.executeUpdateDelete());
                }
            })).intValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J!\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u0007H\u0097\u0001J\u0019\u0010\u000f\u001a\n \r*\u0004\u0018\u00010\u00100\u00102\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u0010\u0011\u001a\u00020\nH\u0096\u0001J\u0019\u0010\u0012\u001a\u00020\n2\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010\u00130\u0013H\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\n2\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010\u00130\u0013H\u0096\u0001J\u0019\u0010\u0015\u001a\n \r*\u0004\u0018\u00010\u00130\u00132\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J4\u0010\u0016\u001a(\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00130\u0013 \r*\u0014\u0012\u000e\b\u0001\u0012\n \r*\u0004\u0018\u00010\u00130\u0013\u0018\u00010\u00170\u0017H\u0096\u0001¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u001c\u001a\n \r*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J\u0011\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010 \u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010!\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\b\u0010#\u001a\u00020$H\u0017J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020$0&H\u0017J\t\u0010'\u001a\u00020\nH\u0096\u0001J\u0011\u0010(\u001a\u00020)2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0019\u0010*\u001a\n \r*\u0004\u0018\u00010\u00130\u00132\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010+\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u0010,\u001a\u00020-H\u0096\u0001J\t\u0010.\u001a\u00020-H\u0096\u0001J\t\u0010/\u001a\u00020-H\u0096\u0001J\t\u00100\u001a\u00020-H\u0096\u0001J\t\u00101\u001a\u00020-H\u0096\u0001J\t\u00102\u001a\u00020-H\u0096\u0001J\u0011\u00103\u001a\u00020-2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u00104\u001a\u00020-2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u00105\u001a\u00020-H\u0096\u0001J\t\u00106\u001a\u00020-H\u0096\u0001J\t\u00107\u001a\u00020-H\u0096\u0001J\u0011\u00108\u001a\u00020-2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u00109\u001a\u00020-H\u0096\u0001J\u0019\u0010:\u001a\u00020\u00072\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010;0;H\u0096\u0001J\u0019\u0010<\u001a\u00020\u00072\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010=0=H\u0096\u0001J\t\u0010>\u001a\u00020-H\u0097\u0001J!\u0010?\u001a\n \r*\u0004\u0018\u00010\u001d0\u001d2\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J\u0010\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u001dH\u0017J)\u0010B\u001a\u00020\u00072\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010C0C2\u000e\u0010\u000b\u001a\n \r*\u0004\u0018\u00010$0$H\u0096\u0001J\u001e\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020C2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020$0&H\u0017J\u0019\u0010G\u001a\u00020\u00072\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010;0;H\u0096\u0001J\u0019\u0010H\u001a\u00020\u00072\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010=0=H\u0096\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Landroidx/room/AutoClosingRoomOpenHelper$KeepAliveCursor;", "Landroid/database/Cursor;", "delegate", "autoCloser", "Landroidx/room/AutoCloser;", "(Landroid/database/Cursor;Landroidx/room/AutoCloser;)V", "close", BuildConfig.FLAVOR, "copyStringToBuffer", "p0", BuildConfig.FLAVOR, "p1", "Landroid/database/CharArrayBuffer;", "kotlin.jvm.PlatformType", "deactivate", "getBlob", BuildConfig.FLAVOR, "getColumnCount", "getColumnIndex", BuildConfig.FLAVOR, "getColumnIndexOrThrow", "getColumnName", "getColumnNames", BuildConfig.FLAVOR, "()[Ljava/lang/String;", "getCount", "getDouble", BuildConfig.FLAVOR, "getExtras", "Landroid/os/Bundle;", "getFloat", BuildConfig.FLAVOR, "getInt", "getLong", BuildConfig.FLAVOR, "getNotificationUri", "Landroid/net/Uri;", "getNotificationUris", BuildConfig.FLAVOR, "getPosition", "getShort", BuildConfig.FLAVOR, "getString", "getType", "getWantsAllOnMoveCalls", BuildConfig.FLAVOR, "isAfterLast", "isBeforeFirst", "isClosed", "isFirst", "isLast", "isNull", "move", "moveToFirst", "moveToLast", "moveToNext", "moveToPosition", "moveToPrevious", "registerContentObserver", "Landroid/database/ContentObserver;", "registerDataSetObserver", "Landroid/database/DataSetObserver;", "requery", "respond", "setExtras", "extras", "setNotificationUri", "Landroid/content/ContentResolver;", "setNotificationUris", "cr", "uris", "unregisterContentObserver", "unregisterDataSetObserver", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    private static final class KeepAliveCursor implements Cursor {
        private final AutoCloser autoCloser;
        private final Cursor delegate;

        public KeepAliveCursor(Cursor delegate, AutoCloser autoCloser) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
            this.delegate = delegate;
            this.autoCloser = autoCloser;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
            this.autoCloser.decrementCountAndScheduleClose();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int p02, CharArrayBuffer p12) {
            this.delegate.copyStringToBuffer(p02, p12);
        }

        @Override // android.database.Cursor
        @Deprecated
        public void deactivate() {
            this.delegate.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int p02) {
            return this.delegate.getBlob(p02);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.delegate.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String p02) {
            return this.delegate.getColumnIndex(p02);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String p02) {
            return this.delegate.getColumnIndexOrThrow(p02);
        }

        @Override // android.database.Cursor
        public String getColumnName(int p02) {
            return this.delegate.getColumnName(p02);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.delegate.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.delegate.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int p02) {
            return this.delegate.getDouble(p02);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.delegate.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int p02) {
            return this.delegate.getFloat(p02);
        }

        @Override // android.database.Cursor
        public int getInt(int p02) {
            return this.delegate.getInt(p02);
        }

        @Override // android.database.Cursor
        public long getLong(int p02) {
            return this.delegate.getLong(p02);
        }

        @Override // android.database.Cursor
        public Uri getNotificationUri() {
            return SupportSQLiteCompat$Api19Impl.getNotificationUri(this.delegate);
        }

        @Override // android.database.Cursor
        public List<Uri> getNotificationUris() {
            return SupportSQLiteCompat$Api29Impl.getNotificationUris(this.delegate);
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.delegate.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int p02) {
            return this.delegate.getShort(p02);
        }

        @Override // android.database.Cursor
        public String getString(int p02) {
            return this.delegate.getString(p02);
        }

        @Override // android.database.Cursor
        public int getType(int p02) {
            return this.delegate.getType(p02);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.delegate.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.delegate.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.delegate.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.delegate.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.delegate.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.delegate.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int p02) {
            return this.delegate.isNull(p02);
        }

        @Override // android.database.Cursor
        public boolean move(int p02) {
            return this.delegate.move(p02);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.delegate.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.delegate.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.delegate.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int p02) {
            return this.delegate.moveToPosition(p02);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.delegate.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver p02) {
            this.delegate.registerContentObserver(p02);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver p02) {
            this.delegate.registerDataSetObserver(p02);
        }

        @Override // android.database.Cursor
        @Deprecated
        public boolean requery() {
            return this.delegate.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle p02) {
            return this.delegate.respond(p02);
        }

        @Override // android.database.Cursor
        public void setExtras(Bundle extras) {
            Intrinsics.checkNotNullParameter(extras, "extras");
            SupportSQLiteCompat$Api23Impl.setExtras(this.delegate, extras);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver p02, Uri p12) {
            this.delegate.setNotificationUri(p02, p12);
        }

        @Override // android.database.Cursor
        public void setNotificationUris(ContentResolver cr, List<? extends Uri> uris) {
            Intrinsics.checkNotNullParameter(cr, "cr");
            Intrinsics.checkNotNullParameter(uris, "uris");
            SupportSQLiteCompat$Api29Impl.setNotificationUris(this.delegate, cr, uris);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver p02) {
            this.delegate.unregisterContentObserver(p02);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver p02) {
            this.delegate.unregisterDataSetObserver(p02);
        }
    }

    public AutoClosingRoomOpenHelper(SupportSQLiteOpenHelper delegate, AutoCloser autoCloser) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
        this.delegate = delegate;
        this.autoCloser = autoCloser;
        autoCloser.init(getDelegate());
        this.autoClosingDb = new AutoClosingSupportSQLiteDatabase(autoCloser);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.autoClosingDb.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    /* renamed from: getDatabaseName */
    public String getName() {
        return this.delegate.getName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    public SupportSQLiteOpenHelper getDelegate() {
        return this.delegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        this.autoClosingDb.pokeOpen();
        return this.autoClosingDb;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean enabled) {
        this.delegate.setWriteAheadLoggingEnabled(enabled);
    }
}
