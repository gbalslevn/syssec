package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u000b\b\u0007\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0006J\u001f\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\nH\u0016¢\u0006\u0004\b \u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010!\u001a\u0004\b\"\u0010#R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010$R\u001a\u0010&\u001a\u00020%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010'\u0012\u0004\b(\u0010\u000eR\u001a\u0010*\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010+\u0012\u0004\b,\u0010\u000eR\"\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010/\u0012\u0004\b0\u0010\u000eR\"\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u00102\u0012\u0004\b3\u0010\u000eR\u001a\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\f\n\u0004\b5\u00106\u0012\u0004\b7\u0010\u000eR$\u00109\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00038\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b9\u0010!\u001a\u0004\b:\u0010#R\u0014\u0010=\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006?"}, d2 = {"Landroidx/room/RoomSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteProgram;", BuildConfig.FLAVOR, "capacity", "<init>", "(I)V", BuildConfig.FLAVOR, "query", "initArgCount", BuildConfig.FLAVOR, "init", "(Ljava/lang/String;I)V", "release", "()V", "statement", "bindTo", "(Landroidx/sqlite/db/SupportSQLiteProgram;)V", "index", "bindNull", BuildConfig.FLAVOR, "value", "bindLong", "(IJ)V", BuildConfig.FLAVOR, "bindDouble", "(ID)V", "bindString", "(ILjava/lang/String;)V", BuildConfig.FLAVOR, "bindBlob", "(I[B)V", "close", "I", "getCapacity", "()I", "Ljava/lang/String;", BuildConfig.FLAVOR, "longBindings", "[J", "getLongBindings$annotations", BuildConfig.FLAVOR, "doubleBindings", "[D", "getDoubleBindings$annotations", BuildConfig.FLAVOR, "stringBindings", "[Ljava/lang/String;", "getStringBindings$annotations", "blobBindings", "[[B", "getBlobBindings$annotations", BuildConfig.FLAVOR, "bindingTypes", "[I", "getBindingTypes$annotations", "<set-?>", "argCount", "getArgCount", "getSql", "()Ljava/lang/String;", "sql", "Companion", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    private static final int BLOB = 5;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    private static final int STRING = 4;
    private int argCount;
    private final int[] bindingTypes;
    public final byte[][] blobBindings;
    private final int capacity;
    public final double[] doubleBindings;
    public final long[] longBindings;
    private volatile String query;
    public final String[] stringBindings;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final TreeMap<Integer, RoomSQLiteQuery> queryPool = new TreeMap<>();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\r\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\f\u0010\u0003R\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u0014"}, d2 = {"Landroidx/room/RoomSQLiteQuery$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "query", BuildConfig.FLAVOR, "argumentCount", "Landroidx/room/RoomSQLiteQuery;", "acquire", "(Ljava/lang/String;I)Landroidx/room/RoomSQLiteQuery;", BuildConfig.FLAVOR, "prunePoolLocked$room_runtime_release", "prunePoolLocked", "BLOB", "I", "DOUBLE", "LONG", "NULL", "STRING", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoomSQLiteQuery acquire(String query, int argumentCount) {
            Intrinsics.checkNotNullParameter(query, "query");
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            synchronized (treeMap) {
                Map.Entry<Integer, RoomSQLiteQuery> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(argumentCount));
                if (ceilingEntry == null) {
                    Unit unit = Unit.INSTANCE;
                    RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(argumentCount, null);
                    roomSQLiteQuery.init(query, argumentCount);
                    return roomSQLiteQuery;
                }
                treeMap.remove(ceilingEntry.getKey());
                RoomSQLiteQuery sqliteQuery = ceilingEntry.getValue();
                sqliteQuery.init(query, argumentCount);
                Intrinsics.checkNotNullExpressionValue(sqliteQuery, "sqliteQuery");
                return sqliteQuery;
            }
        }

        public final void prunePoolLocked$room_runtime_release() {
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            if (treeMap.size() <= 15) {
                return;
            }
            int size = treeMap.size() - 10;
            Iterator<Integer> it = treeMap.descendingKeySet().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "queryPool.descendingKeySet().iterator()");
            while (true) {
                int i5 = size - 1;
                if (size <= 0) {
                    return;
                }
                it.next();
                it.remove();
                size = i5;
            }
        }

        private Companion() {
        }
    }

    public /* synthetic */ RoomSQLiteQuery(int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5);
    }

    public static final RoomSQLiteQuery acquire(String str, int i5) {
        return INSTANCE.acquire(str, i5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int index, byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.bindingTypes[index] = 5;
        this.blobBindings[index] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int index, double value) {
        this.bindingTypes[index] = 3;
        this.doubleBindings[index] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int index, long value) {
        this.bindingTypes[index] = 2;
        this.longBindings[index] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int index) {
        this.bindingTypes[index] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int index, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.bindingTypes[index] = 4;
        this.stringBindings[index] = value;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        int argCount = getArgCount();
        if (1 > argCount) {
            return;
        }
        int i5 = 1;
        while (true) {
            int i6 = this.bindingTypes[i5];
            if (i6 == 1) {
                statement.bindNull(i5);
            } else if (i6 == 2) {
                statement.bindLong(i5, this.longBindings[i5]);
            } else if (i6 == 3) {
                statement.bindDouble(i5, this.doubleBindings[i5]);
            } else if (i6 == 4) {
                String str = this.stringBindings[i5];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                statement.bindString(i5, str);
            } else if (i6 == 5) {
                byte[] bArr = this.blobBindings[i5];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                statement.bindBlob(i5, bArr);
            }
            if (i5 == argCount) {
                return;
            } else {
                i5++;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public int getArgCount() {
        return this.argCount;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    /* renamed from: getSql */
    public String getQuery() {
        String str = this.query;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    public final void init(String query, int initArgCount) {
        Intrinsics.checkNotNullParameter(query, "query");
        this.query = query;
        this.argCount = initArgCount;
    }

    public final void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = queryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.capacity), this);
            INSTANCE.prunePoolLocked$room_runtime_release();
            Unit unit = Unit.INSTANCE;
        }
    }

    private RoomSQLiteQuery(int i5) {
        this.capacity = i5;
        int i6 = i5 + 1;
        this.bindingTypes = new int[i6];
        this.longBindings = new long[i6];
        this.doubleBindings = new double[i6];
        this.stringBindings = new String[i6];
        this.blobBindings = new byte[i6];
    }
}
