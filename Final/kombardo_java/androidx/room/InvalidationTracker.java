package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 i2\u00020\u0001:\u0004ijklBS\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0004\u0012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t\"\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J'\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t2\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\tH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010!\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u001f\u0010 J'\u0010)\u001a\u00020\r2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%H\u0000¢\u0006\u0004\b'\u0010(J\u0017\u0010,\u001a\u00020\r2\u0006\u0010+\u001a\u00020*H\u0017¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\r2\u0006\u0010+\u001a\u00020*H\u0017¢\u0006\u0004\b.\u0010-J\u000f\u00102\u001a\u00020/H\u0000¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u00020\rH\u0016¢\u0006\u0004\b3\u0010\u000fJ#\u00105\u001a\u00020\r2\u0012\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t\"\u00020\u0005H\u0007¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0010H\u0000¢\u0006\u0004\b7\u0010 J\u000f\u00108\u001a\u00020\rH\u0000¢\u0006\u0004\b7\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u00109\u001a\u0004\b:\u0010;R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010<R&\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010<R&\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b=\u0010<\u001a\u0004\b>\u0010?R\"\u0010@\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010DR\u001a\u0010F\u001a\u00020E8GX\u0087\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR$\u0010M\u001a\u0004\u0018\u00010L8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR&\u0010[\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020Z0Y8\u0000X\u0081\u0004¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u0018\u0010`\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010b\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010d\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010cR\u001a\u0010f\u001a\u00020e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bf\u0010g\u0012\u0004\bh\u0010\u000f¨\u0006m"}, d2 = {"Landroidx/room/InvalidationTracker;", BuildConfig.FLAVOR, "Landroidx/room/RoomDatabase;", "database", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "shadowTablesMap", BuildConfig.FLAVOR, "viewTables", BuildConfig.FLAVOR, "tableNames", "<init>", "(Landroidx/room/RoomDatabase;Ljava/util/Map;Ljava/util/Map;[Ljava/lang/String;)V", BuildConfig.FLAVOR, "onAutoCloseCallback", "()V", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "db", BuildConfig.FLAVOR, "tableId", "stopTrackingTable", "(Landroidx/sqlite/db/SupportSQLiteDatabase;I)V", "startTrackingTable", "names", "resolveViews", "([Ljava/lang/String;)[Ljava/lang/String;", "Landroidx/room/AutoCloser;", "autoCloser", "setAutoCloser$room_runtime_release", "(Landroidx/room/AutoCloser;)V", "setAutoCloser", "internalInit$room_runtime_release", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "internalInit", "Landroid/content/Context;", "context", "name", "Landroid/content/Intent;", "serviceIntent", "startMultiInstanceInvalidation$room_runtime_release", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "startMultiInstanceInvalidation", "Landroidx/room/InvalidationTracker$Observer;", "observer", "addObserver", "(Landroidx/room/InvalidationTracker$Observer;)V", "removeObserver", BuildConfig.FLAVOR, "ensureInitialization$room_runtime_release", "()Z", "ensureInitialization", "refreshVersionsAsync", "tables", "notifyObserversByTableNames", "([Ljava/lang/String;)V", "syncTriggers$room_runtime_release", "syncTriggers", "Landroidx/room/RoomDatabase;", "getDatabase$room_runtime_release", "()Landroidx/room/RoomDatabase;", "Ljava/util/Map;", "tableIdLookup", "getTableIdLookup$room_runtime_release", "()Ljava/util/Map;", "tablesNames", "[Ljava/lang/String;", "getTablesNames$room_runtime_release", "()[Ljava/lang/String;", "Landroidx/room/AutoCloser;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pendingRefresh", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getPendingRefresh", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Z", "Landroidx/sqlite/db/SupportSQLiteStatement;", "cleanupStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "getCleanupStatement$room_runtime_release", "()Landroidx/sqlite/db/SupportSQLiteStatement;", "setCleanupStatement$room_runtime_release", "(Landroidx/sqlite/db/SupportSQLiteStatement;)V", "Landroidx/room/InvalidationTracker$ObservedTableTracker;", "observedTableTracker", "Landroidx/room/InvalidationTracker$ObservedTableTracker;", "Landroidx/room/InvalidationLiveDataContainer;", "invalidationLiveDataContainer", "Landroidx/room/InvalidationLiveDataContainer;", "Landroidx/arch/core/internal/SafeIterableMap;", "Landroidx/room/InvalidationTracker$ObserverWrapper;", "observerMap", "Landroidx/arch/core/internal/SafeIterableMap;", "getObserverMap$room_runtime_release", "()Landroidx/arch/core/internal/SafeIterableMap;", "Landroidx/room/MultiInstanceInvalidationClient;", "multiInstanceInvalidationClient", "Landroidx/room/MultiInstanceInvalidationClient;", "syncTriggersLock", "Ljava/lang/Object;", "trackerLock", "Ljava/lang/Runnable;", "refreshRunnable", "Ljava/lang/Runnable;", "getRefreshRunnable$annotations", "Companion", "ObservedTableTracker", "Observer", "ObserverWrapper", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class InvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    private AutoCloser autoCloser;
    private volatile SupportSQLiteStatement cleanupStatement;
    private final RoomDatabase database;
    private volatile boolean initialized;
    private final InvalidationLiveDataContainer invalidationLiveDataContainer;
    private MultiInstanceInvalidationClient multiInstanceInvalidationClient;
    private final ObservedTableTracker observedTableTracker;
    private final SafeIterableMap<Observer, ObserverWrapper> observerMap;
    private final AtomicBoolean pendingRefresh;
    public final Runnable refreshRunnable;
    private final Map<String, String> shadowTablesMap;
    private final Object syncTriggersLock;
    private final Map<String, Integer> tableIdLookup;
    private final String[] tablesNames;
    private final Object trackerLock;
    private final Map<String, Set<String>> viewTables;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String[] TRIGGERS = {"UPDATE", "DELETE", "INSERT"};

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011¨\u0006\u0018"}, d2 = {"Landroidx/room/InvalidationTracker$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "tableName", "triggerType", "getTriggerName$room_runtime_release", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getTriggerName", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "database", BuildConfig.FLAVOR, "beginTransactionInternal$room_runtime_release", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "beginTransactionInternal", "CREATE_TRACKING_TABLE_SQL", "Ljava/lang/String;", "INVALIDATED_COLUMN_NAME", "TABLE_ID_COLUMN_NAME", BuildConfig.FLAVOR, "TRIGGERS", "[Ljava/lang/String;", "UPDATE_TABLE_NAME", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void beginTransactionInternal$room_runtime_release(SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            if (database.isWriteAheadLoggingEnabled()) {
                database.beginTransactionNonExclusive();
            } else {
                database.beginTransaction();
            }
        }

        public final String getTriggerName$room_runtime_release(String tableName, String triggerType) {
            Intrinsics.checkNotNullParameter(tableName, "tableName");
            Intrinsics.checkNotNullParameter(triggerType, "triggerType");
            return "`room_table_modification_trigger_" + tableName + '_' + triggerType + '`';
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\u0018\n\u0002\b\f\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\n\u0010\u0007\u001a\u00020\u0006\"\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\b2\n\u0010\u0007\u001a\u00020\u0006\"\u00020\u0002¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/room/InvalidationTracker$ObservedTableTracker;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "tableCount", "<init>", "(I)V", BuildConfig.FLAVOR, "tableIds", BuildConfig.FLAVOR, "onAdded", "([I)Z", "onRemoved", BuildConfig.FLAVOR, "resetTriggerState", "()V", "getTablesToSync", "()[I", BuildConfig.FLAVOR, "tableObservers", "[J", "getTableObservers", "()[J", BuildConfig.FLAVOR, "triggerStates", "[Z", "triggerStateChanges", "[I", "needsSync", "Z", "getNeedsSync", "()Z", "setNeedsSync", "(Z)V", "Companion", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class ObservedTableTracker {
        private boolean needsSync;
        private final long[] tableObservers;
        private final int[] triggerStateChanges;
        private final boolean[] triggerStates;

        public ObservedTableTracker(int i5) {
            this.tableObservers = new long[i5];
            this.triggerStates = new boolean[i5];
            this.triggerStateChanges = new int[i5];
        }

        public final int[] getTablesToSync() {
            synchronized (this) {
                try {
                    if (!this.needsSync) {
                        return null;
                    }
                    long[] jArr = this.tableObservers;
                    int length = jArr.length;
                    int i5 = 0;
                    int i6 = 0;
                    while (i5 < length) {
                        int i7 = i6 + 1;
                        int i8 = 1;
                        boolean z5 = jArr[i5] > 0;
                        boolean[] zArr = this.triggerStates;
                        if (z5 != zArr[i6]) {
                            int[] iArr = this.triggerStateChanges;
                            if (!z5) {
                                i8 = 2;
                            }
                            iArr[i6] = i8;
                        } else {
                            this.triggerStateChanges[i6] = 0;
                        }
                        zArr[i6] = z5;
                        i5++;
                        i6 = i7;
                    }
                    this.needsSync = false;
                    return (int[]) this.triggerStateChanges.clone();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean onAdded(int... tableIds) {
            boolean z5;
            Intrinsics.checkNotNullParameter(tableIds, "tableIds");
            synchronized (this) {
                try {
                    z5 = false;
                    for (int i5 : tableIds) {
                        long[] jArr = this.tableObservers;
                        long j5 = jArr[i5];
                        jArr[i5] = 1 + j5;
                        if (j5 == 0) {
                            this.needsSync = true;
                            z5 = true;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z5;
        }

        public final boolean onRemoved(int... tableIds) {
            boolean z5;
            Intrinsics.checkNotNullParameter(tableIds, "tableIds");
            synchronized (this) {
                try {
                    z5 = false;
                    for (int i5 : tableIds) {
                        long[] jArr = this.tableObservers;
                        long j5 = jArr[i5];
                        jArr[i5] = j5 - 1;
                        if (j5 == 1) {
                            this.needsSync = true;
                            z5 = true;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z5;
        }

        public final void resetTriggerState() {
            synchronized (this) {
                Arrays.fill(this.triggerStates, false);
                this.needsSync = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Landroidx/room/InvalidationTracker$Observer;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "tables", "<init>", "([Ljava/lang/String;)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "onInvalidated", "(Ljava/util/Set;)V", "[Ljava/lang/String;", "getTables$room_runtime_release", "()[Ljava/lang/String;", BuildConfig.FLAVOR, "isRemote$room_runtime_release", "()Z", "isRemote", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static abstract class Observer {
        private final String[] tables;

        public Observer(String[] tables) {
            Intrinsics.checkNotNullParameter(tables, "tables");
            this.tables = tables;
        }

        /* renamed from: getTables$room_runtime_release, reason: from getter */
        public final String[] getTables() {
            return this.tables;
        }

        public boolean isRemote$room_runtime_release() {
            return false;
        }

        public abstract void onInvalidated(Set<String> tables);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0011\u001a\u00020\u000e2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Landroidx/room/InvalidationTracker$ObserverWrapper;", BuildConfig.FLAVOR, "Landroidx/room/InvalidationTracker$Observer;", "observer", BuildConfig.FLAVOR, "tableIds", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "tableNames", "<init>", "(Landroidx/room/InvalidationTracker$Observer;[I[Ljava/lang/String;)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "invalidatedTablesIds", BuildConfig.FLAVOR, "notifyByTableInvalidStatus$room_runtime_release", "(Ljava/util/Set;)V", "notifyByTableInvalidStatus", "tables", "notifyByTableNames$room_runtime_release", "([Ljava/lang/String;)V", "notifyByTableNames", "Landroidx/room/InvalidationTracker$Observer;", "getObserver$room_runtime_release", "()Landroidx/room/InvalidationTracker$Observer;", "[I", "getTableIds$room_runtime_release", "()[I", "[Ljava/lang/String;", "singleTableSet", "Ljava/util/Set;", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class ObserverWrapper {
        private final Observer observer;
        private final Set<String> singleTableSet;
        private final int[] tableIds;
        private final String[] tableNames;

        public ObserverWrapper(Observer observer, int[] tableIds, String[] tableNames) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            Intrinsics.checkNotNullParameter(tableIds, "tableIds");
            Intrinsics.checkNotNullParameter(tableNames, "tableNames");
            this.observer = observer;
            this.tableIds = tableIds;
            this.tableNames = tableNames;
            this.singleTableSet = !(tableNames.length == 0) ? SetsKt.setOf(tableNames[0]) : SetsKt.emptySet();
            if (tableIds.length != tableNames.length) {
                throw new IllegalStateException("Check failed.");
            }
        }

        /* renamed from: getTableIds$room_runtime_release, reason: from getter */
        public final int[] getTableIds() {
            return this.tableIds;
        }

        public final void notifyByTableInvalidStatus$room_runtime_release(Set<Integer> invalidatedTablesIds) {
            Set<String> emptySet;
            Intrinsics.checkNotNullParameter(invalidatedTablesIds, "invalidatedTablesIds");
            int[] iArr = this.tableIds;
            int length = iArr.length;
            if (length != 0) {
                int i5 = 0;
                if (length != 1) {
                    Set createSetBuilder = SetsKt.createSetBuilder();
                    int[] iArr2 = this.tableIds;
                    int length2 = iArr2.length;
                    int i6 = 0;
                    while (i5 < length2) {
                        int i7 = i6 + 1;
                        if (invalidatedTablesIds.contains(Integer.valueOf(iArr2[i5]))) {
                            createSetBuilder.add(this.tableNames[i6]);
                        }
                        i5++;
                        i6 = i7;
                    }
                    emptySet = SetsKt.build(createSetBuilder);
                } else {
                    emptySet = invalidatedTablesIds.contains(Integer.valueOf(iArr[0])) ? this.singleTableSet : SetsKt.emptySet();
                }
            } else {
                emptySet = SetsKt.emptySet();
            }
            if (emptySet.isEmpty()) {
                return;
            }
            this.observer.onInvalidated(emptySet);
        }

        public final void notifyByTableNames$room_runtime_release(String[] tables) {
            Set<String> emptySet;
            Intrinsics.checkNotNullParameter(tables, "tables");
            int length = this.tableNames.length;
            if (length == 0) {
                emptySet = SetsKt.emptySet();
            } else if (length == 1) {
                int length2 = tables.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length2) {
                        emptySet = SetsKt.emptySet();
                        break;
                    } else {
                        if (StringsKt.equals(tables[i5], this.tableNames[0], true)) {
                            emptySet = this.singleTableSet;
                            break;
                        }
                        i5++;
                    }
                }
            } else {
                Set createSetBuilder = SetsKt.createSetBuilder();
                for (String str : tables) {
                    for (String str2 : this.tableNames) {
                        if (StringsKt.equals(str2, str, true)) {
                            createSetBuilder.add(str2);
                        }
                    }
                }
                emptySet = SetsKt.build(createSetBuilder);
            }
            if (emptySet.isEmpty()) {
                return;
            }
            this.observer.onInvalidated(emptySet);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InvalidationTracker(RoomDatabase database, Map<String, String> shadowTablesMap, Map<String, Set<String>> viewTables, String... tableNames) {
        String str;
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(shadowTablesMap, "shadowTablesMap");
        Intrinsics.checkNotNullParameter(viewTables, "viewTables");
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        this.database = database;
        this.shadowTablesMap = shadowTablesMap;
        this.viewTables = viewTables;
        this.pendingRefresh = new AtomicBoolean(false);
        this.observedTableTracker = new ObservedTableTracker(tableNames.length);
        this.invalidationLiveDataContainer = new InvalidationLiveDataContainer(database);
        this.observerMap = new SafeIterableMap<>();
        this.syncTriggersLock = new Object();
        this.trackerLock = new Object();
        this.tableIdLookup = new LinkedHashMap();
        int length = tableNames.length;
        String[] strArr = new String[length];
        for (int i5 = 0; i5 < length; i5++) {
            String str2 = tableNames[i5];
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str2.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            this.tableIdLookup.put(lowerCase, Integer.valueOf(i5));
            String str3 = this.shadowTablesMap.get(tableNames[i5]);
            if (str3 != null) {
                Intrinsics.checkNotNullExpressionValue(US, "US");
                str = str3.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            if (str != null) {
                lowerCase = str;
            }
            strArr[i5] = lowerCase;
        }
        this.tablesNames = strArr;
        for (Map.Entry<String, String> entry : this.shadowTablesMap.entrySet()) {
            String value = entry.getValue();
            Locale US2 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US2, "US");
            String lowerCase2 = value.toLowerCase(US2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            if (this.tableIdLookup.containsKey(lowerCase2)) {
                String key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(US2, "US");
                String lowerCase3 = key.toLowerCase(US2);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
                Map<String, Integer> map = this.tableIdLookup;
                map.put(lowerCase3, MapsKt.getValue(map, lowerCase2));
            }
        }
        this.refreshRunnable = new Runnable() { // from class: androidx.room.InvalidationTracker$refreshRunnable$1
            private final Set<Integer> checkUpdatedTable() {
                InvalidationTracker invalidationTracker = InvalidationTracker.this;
                Set createSetBuilder = SetsKt.createSetBuilder();
                Cursor query$default = RoomDatabase.query$default(invalidationTracker.getDatabase(), new SimpleSQLiteQuery("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"), null, 2, null);
                try {
                    Cursor cursor = query$default;
                    while (cursor.moveToNext()) {
                        createSetBuilder.add(Integer.valueOf(cursor.getInt(0)));
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(query$default, null);
                    Set<Integer> build = SetsKt.build(createSetBuilder);
                    if (!build.isEmpty()) {
                        if (InvalidationTracker.this.getCleanupStatement() == null) {
                            throw new IllegalStateException("Required value was null.");
                        }
                        SupportSQLiteStatement cleanupStatement = InvalidationTracker.this.getCleanupStatement();
                        if (cleanupStatement == null) {
                            throw new IllegalArgumentException("Required value was null.");
                        }
                        cleanupStatement.executeUpdateDelete();
                    }
                    return build;
                } finally {
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:30:0x0080, code lost:
            
                if (r0 != null) goto L26;
             */
            /* JADX WARN: Code restructure failed: missing block: B:31:0x0082, code lost:
            
                r0.decrementCountAndScheduleClose();
             */
            /* JADX WARN: Code restructure failed: missing block: B:33:0x00c7, code lost:
            
                if (r2.isEmpty() != false) goto L59;
             */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x00c9, code lost:
            
                r0 = r4.this$0.getObserverMap$room_runtime_release();
                r1 = r4.this$0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:35:0x00d1, code lost:
            
                monitor-enter(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:0x00d2, code lost:
            
                r1 = r1.getObserverMap$room_runtime_release().iterator();
             */
            /* JADX WARN: Code restructure failed: missing block: B:39:0x00de, code lost:
            
                if (r1.hasNext() == false) goto L69;
             */
            /* JADX WARN: Code restructure failed: missing block: B:40:0x00e0, code lost:
            
                ((androidx.room.InvalidationTracker.ObserverWrapper) ((java.util.Map.Entry) r1.next()).getValue()).notifyByTableInvalidStatus$room_runtime_release(r2);
             */
            /* JADX WARN: Code restructure failed: missing block: B:42:0x00f2, code lost:
            
                r1 = kotlin.Unit.INSTANCE;
             */
            /* JADX WARN: Code restructure failed: missing block: B:43:0x00f4, code lost:
            
                monitor-exit(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:46:0x00f0, code lost:
            
                r1 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:48:0x00f7, code lost:
            
                throw r1;
             */
            /* JADX WARN: Code restructure failed: missing block: B:49:0x00f8, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:62:0x00a6, code lost:
            
                if (r0 == null) goto L44;
             */
            /* JADX WARN: Code restructure failed: missing block: B:66:0x00bd, code lost:
            
                if (r0 == null) goto L44;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Set<Integer> emptySet;
                AutoCloser autoCloser;
                AutoCloser autoCloser2;
                AutoCloser autoCloser3;
                AutoCloser autoCloser4;
                Lock closeLock$room_runtime_release = InvalidationTracker.this.getDatabase().getCloseLock$room_runtime_release();
                closeLock$room_runtime_release.lock();
                try {
                    try {
                        if (!InvalidationTracker.this.ensureInitialization$room_runtime_release()) {
                            if (autoCloser2 != null) {
                                return;
                            } else {
                                return;
                            }
                        }
                        if (!InvalidationTracker.this.getPendingRefresh().compareAndSet(true, false)) {
                            closeLock$room_runtime_release.unlock();
                            autoCloser4 = InvalidationTracker.this.autoCloser;
                            if (autoCloser4 != null) {
                                autoCloser4.decrementCountAndScheduleClose();
                                return;
                            }
                            return;
                        }
                        if (InvalidationTracker.this.getDatabase().inTransaction()) {
                            closeLock$room_runtime_release.unlock();
                            autoCloser3 = InvalidationTracker.this.autoCloser;
                            if (autoCloser3 != null) {
                                autoCloser3.decrementCountAndScheduleClose();
                                return;
                            }
                            return;
                        }
                        SupportSQLiteDatabase writableDatabase = InvalidationTracker.this.getDatabase().getOpenHelper().getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            emptySet = checkUpdatedTable();
                            writableDatabase.setTransactionSuccessful();
                            closeLock$room_runtime_release.unlock();
                            autoCloser = InvalidationTracker.this.autoCloser;
                        } finally {
                            writableDatabase.endTransaction();
                        }
                    } finally {
                        closeLock$room_runtime_release.unlock();
                        autoCloser2 = InvalidationTracker.this.autoCloser;
                        if (autoCloser2 != null) {
                            autoCloser2.decrementCountAndScheduleClose();
                        }
                    }
                } catch (SQLiteException e5) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e5);
                    emptySet = SetsKt.emptySet();
                    closeLock$room_runtime_release.unlock();
                    autoCloser = InvalidationTracker.this.autoCloser;
                } catch (IllegalStateException e6) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e6);
                    emptySet = SetsKt.emptySet();
                    closeLock$room_runtime_release.unlock();
                    autoCloser = InvalidationTracker.this.autoCloser;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAutoCloseCallback() {
        synchronized (this.trackerLock) {
            this.initialized = false;
            this.observedTableTracker.resetTriggerState();
            SupportSQLiteStatement supportSQLiteStatement = this.cleanupStatement;
            if (supportSQLiteStatement != null) {
                supportSQLiteStatement.close();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final String[] resolveViews(String[] names) {
        Set createSetBuilder = SetsKt.createSetBuilder();
        for (String str : names) {
            Map<String, Set<String>> map = this.viewTables;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                Map<String, Set<String>> map2 = this.viewTables;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase2 = str.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                Set<String> set = map2.get(lowerCase2);
                Intrinsics.checkNotNull(set);
                createSetBuilder.addAll(set);
            } else {
                createSetBuilder.add(str);
            }
        }
        return (String[]) SetsKt.build(createSetBuilder).toArray(new String[0]);
    }

    private final void startTrackingTable(SupportSQLiteDatabase db, int tableId) {
        db.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + tableId + ", 0)");
        String str = this.tablesNames[tableId];
        for (String str2 : TRIGGERS) {
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + INSTANCE.getTriggerName$room_runtime_release(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE " + UPDATE_TABLE_NAME + " SET " + INVALIDATED_COLUMN_NAME + " = 1 WHERE " + TABLE_ID_COLUMN_NAME + " = " + tableId + " AND " + INVALIDATED_COLUMN_NAME + " = 0; END";
            Intrinsics.checkNotNullExpressionValue(str3, "StringBuilder().apply(builderAction).toString()");
            db.execSQL(str3);
        }
    }

    private final void stopTrackingTable(SupportSQLiteDatabase db, int tableId) {
        String str = this.tablesNames[tableId];
        for (String str2 : TRIGGERS) {
            String str3 = "DROP TRIGGER IF EXISTS " + INSTANCE.getTriggerName$room_runtime_release(str, str2);
            Intrinsics.checkNotNullExpressionValue(str3, "StringBuilder().apply(builderAction).toString()");
            db.execSQL(str3);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void addObserver(Observer observer) {
        ObserverWrapper putIfAbsent;
        Intrinsics.checkNotNullParameter(observer, "observer");
        String[] resolveViews = resolveViews(observer.getTables());
        ArrayList arrayList = new ArrayList(resolveViews.length);
        for (String str : resolveViews) {
            Map<String, Integer> map = this.tableIdLookup;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Integer num = map.get(lowerCase);
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
            arrayList.add(num);
        }
        int[] intArray = CollectionsKt.toIntArray(arrayList);
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, intArray, resolveViews);
        synchronized (this.observerMap) {
            putIfAbsent = this.observerMap.putIfAbsent(observer, observerWrapper);
        }
        if (putIfAbsent == null && this.observedTableTracker.onAdded(Arrays.copyOf(intArray, intArray.length))) {
            syncTriggers$room_runtime_release();
        }
    }

    public final boolean ensureInitialization$room_runtime_release() {
        if (!this.database.isOpenInternal()) {
            return false;
        }
        if (!this.initialized) {
            this.database.getOpenHelper().getWritableDatabase();
        }
        if (this.initialized) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    /* renamed from: getCleanupStatement$room_runtime_release, reason: from getter */
    public final SupportSQLiteStatement getCleanupStatement() {
        return this.cleanupStatement;
    }

    /* renamed from: getDatabase$room_runtime_release, reason: from getter */
    public final RoomDatabase getDatabase() {
        return this.database;
    }

    public final SafeIterableMap<Observer, ObserverWrapper> getObserverMap$room_runtime_release() {
        return this.observerMap;
    }

    public final AtomicBoolean getPendingRefresh() {
        return this.pendingRefresh;
    }

    public final Map<String, Integer> getTableIdLookup$room_runtime_release() {
        return this.tableIdLookup;
    }

    public final void internalInit$room_runtime_release(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        synchronized (this.trackerLock) {
            if (this.initialized) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            database.execSQL("PRAGMA temp_store = MEMORY;");
            database.execSQL("PRAGMA recursive_triggers='ON';");
            database.execSQL(CREATE_TRACKING_TABLE_SQL);
            syncTriggers$room_runtime_release(database);
            this.cleanupStatement = database.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");
            this.initialized = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void notifyObserversByTableNames(String... tables) {
        Intrinsics.checkNotNullParameter(tables, "tables");
        synchronized (this.observerMap) {
            try {
                Iterator<Map.Entry<K, V>> it = this.observerMap.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Intrinsics.checkNotNullExpressionValue(entry, "(observer, wrapper)");
                    Observer observer = (Observer) entry.getKey();
                    ObserverWrapper observerWrapper = (ObserverWrapper) entry.getValue();
                    if (!observer.isRemote$room_runtime_release()) {
                        observerWrapper.notifyByTableNames$room_runtime_release(tables);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void refreshVersionsAsync() {
        if (this.pendingRefresh.compareAndSet(false, true)) {
            AutoCloser autoCloser = this.autoCloser;
            if (autoCloser != null) {
                autoCloser.incrementCountAndEnsureDbIsOpen();
            }
            this.database.getQueryExecutor().execute(this.refreshRunnable);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void removeObserver(Observer observer) {
        ObserverWrapper remove;
        Intrinsics.checkNotNullParameter(observer, "observer");
        synchronized (this.observerMap) {
            remove = this.observerMap.remove(observer);
        }
        if (remove != null) {
            ObservedTableTracker observedTableTracker = this.observedTableTracker;
            int[] tableIds = remove.getTableIds();
            if (observedTableTracker.onRemoved(Arrays.copyOf(tableIds, tableIds.length))) {
                syncTriggers$room_runtime_release();
            }
        }
    }

    public final void setAutoCloser$room_runtime_release(AutoCloser autoCloser) {
        Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
        this.autoCloser = autoCloser;
        autoCloser.setAutoCloseCallback(new Runnable() { // from class: M.c
            @Override // java.lang.Runnable
            public final void run() {
                InvalidationTracker.this.onAutoCloseCallback();
            }
        });
    }

    public final void startMultiInstanceInvalidation$room_runtime_release(Context context, String name, Intent serviceIntent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(serviceIntent, "serviceIntent");
        this.multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, name, serviceIntent, this, this.database.getQueryExecutor());
    }

    public final void syncTriggers$room_runtime_release(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        if (database.inTransaction()) {
            return;
        }
        try {
            Lock closeLock$room_runtime_release = this.database.getCloseLock$room_runtime_release();
            closeLock$room_runtime_release.lock();
            try {
                synchronized (this.syncTriggersLock) {
                    int[] tablesToSync = this.observedTableTracker.getTablesToSync();
                    if (tablesToSync == null) {
                        return;
                    }
                    INSTANCE.beginTransactionInternal$room_runtime_release(database);
                    try {
                        int length = tablesToSync.length;
                        int i5 = 0;
                        int i6 = 0;
                        while (i5 < length) {
                            int i7 = tablesToSync[i5];
                            int i8 = i6 + 1;
                            if (i7 == 1) {
                                startTrackingTable(database, i6);
                            } else if (i7 == 2) {
                                stopTrackingTable(database, i6);
                            }
                            i5++;
                            i6 = i8;
                        }
                        database.setTransactionSuccessful();
                        database.endTransaction();
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        database.endTransaction();
                        throw th;
                    }
                }
            } finally {
                closeLock$room_runtime_release.unlock();
            }
        } catch (SQLiteException e5) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e5);
        } catch (IllegalStateException e6) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e6);
        }
    }

    public final void syncTriggers$room_runtime_release() {
        if (this.database.isOpenInternal()) {
            syncTriggers$room_runtime_release(this.database.getOpenHelper().getWritableDatabase());
        }
    }
}
