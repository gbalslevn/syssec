package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo$State;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.NetworkRequestCompat;
import com.sdk.growthbook.utils.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes.dex */
public final class WorkSpecDao_Impl implements WorkSpecDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkSpec> __insertionAdapterOfWorkSpec;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfIncrementGeneration;
    private final SharedSQLiteStatement __preparedStmtOfIncrementPeriodCount;
    private final SharedSQLiteStatement __preparedStmtOfIncrementWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfMarkWorkSpecScheduled;
    private final SharedSQLiteStatement __preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast;
    private final SharedSQLiteStatement __preparedStmtOfResetScheduledState;
    private final SharedSQLiteStatement __preparedStmtOfResetWorkSpecNextScheduleTimeOverride;
    private final SharedSQLiteStatement __preparedStmtOfResetWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfSetCancelledState;
    private final SharedSQLiteStatement __preparedStmtOfSetLastEnqueueTime;
    private final SharedSQLiteStatement __preparedStmtOfSetNextScheduleTimeOverride;
    private final SharedSQLiteStatement __preparedStmtOfSetOutput;
    private final SharedSQLiteStatement __preparedStmtOfSetState;
    private final SharedSQLiteStatement __preparedStmtOfSetStopReason;
    private final EntityDeletionOrUpdateAdapter<WorkSpec> __updateAdapterOfWorkSpec;

    public WorkSpecDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfWorkSpec = new EntityInsertionAdapter<WorkSpec>(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`next_schedule_time_override`,`next_schedule_time_override_generation`,`stop_reason`,`trace_tag`,`required_network_type`,`required_network_request`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) {
                supportSQLiteStatement.bindString(1, workSpec.id);
                WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(2, WorkTypeConverters.stateToInt(workSpec.state));
                supportSQLiteStatement.bindString(3, workSpec.workerClassName);
                supportSQLiteStatement.bindString(4, workSpec.inputMergerClassName);
                supportSQLiteStatement.bindBlob(5, Data.toByteArrayInternalV1(workSpec.input));
                supportSQLiteStatement.bindBlob(6, Data.toByteArrayInternalV1(workSpec.output));
                supportSQLiteStatement.bindLong(7, workSpec.initialDelay);
                supportSQLiteStatement.bindLong(8, workSpec.intervalDuration);
                supportSQLiteStatement.bindLong(9, workSpec.flexDuration);
                supportSQLiteStatement.bindLong(10, workSpec.runAttemptCount);
                supportSQLiteStatement.bindLong(11, WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
                supportSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
                supportSQLiteStatement.bindLong(13, workSpec.lastEnqueueTime);
                supportSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
                supportSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
                supportSQLiteStatement.bindLong(16, workSpec.expedited ? 1L : 0L);
                supportSQLiteStatement.bindLong(17, WorkTypeConverters.outOfQuotaPolicyToInt(workSpec.outOfQuotaPolicy));
                supportSQLiteStatement.bindLong(18, workSpec.getPeriodCount());
                supportSQLiteStatement.bindLong(19, workSpec.getGeneration());
                supportSQLiteStatement.bindLong(20, workSpec.getNextScheduleTimeOverride());
                supportSQLiteStatement.bindLong(21, workSpec.getNextScheduleTimeOverrideGeneration());
                supportSQLiteStatement.bindLong(22, workSpec.getStopReason());
                if (workSpec.getTraceTag() == null) {
                    supportSQLiteStatement.bindNull(23);
                } else {
                    supportSQLiteStatement.bindString(23, workSpec.getTraceTag());
                }
                Constraints constraints = workSpec.constraints;
                supportSQLiteStatement.bindLong(24, WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
                supportSQLiteStatement.bindBlob(25, WorkTypeConverters.fromNetworkRequest$work_runtime_release(constraints.getRequiredNetworkRequestCompat()));
                supportSQLiteStatement.bindLong(26, constraints.getRequiresCharging() ? 1L : 0L);
                supportSQLiteStatement.bindLong(27, constraints.getRequiresDeviceIdle() ? 1L : 0L);
                supportSQLiteStatement.bindLong(28, constraints.getRequiresBatteryNotLow() ? 1L : 0L);
                supportSQLiteStatement.bindLong(29, constraints.getRequiresStorageNotLow() ? 1L : 0L);
                supportSQLiteStatement.bindLong(30, constraints.getContentTriggerUpdateDelayMillis());
                supportSQLiteStatement.bindLong(31, constraints.getContentTriggerMaxDelayMillis());
                supportSQLiteStatement.bindBlob(32, WorkTypeConverters.setOfTriggersToByteArray(constraints.getContentUriTriggers()));
            }
        };
        this.__updateAdapterOfWorkSpec = new EntityDeletionOrUpdateAdapter<WorkSpec>(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`next_schedule_time_override` = ?,`next_schedule_time_override_generation` = ?,`stop_reason` = ?,`trace_tag` = ?,`required_network_type` = ?,`required_network_request` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) {
                supportSQLiteStatement.bindString(1, workSpec.id);
                WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(2, WorkTypeConverters.stateToInt(workSpec.state));
                supportSQLiteStatement.bindString(3, workSpec.workerClassName);
                supportSQLiteStatement.bindString(4, workSpec.inputMergerClassName);
                supportSQLiteStatement.bindBlob(5, Data.toByteArrayInternalV1(workSpec.input));
                supportSQLiteStatement.bindBlob(6, Data.toByteArrayInternalV1(workSpec.output));
                supportSQLiteStatement.bindLong(7, workSpec.initialDelay);
                supportSQLiteStatement.bindLong(8, workSpec.intervalDuration);
                supportSQLiteStatement.bindLong(9, workSpec.flexDuration);
                supportSQLiteStatement.bindLong(10, workSpec.runAttemptCount);
                supportSQLiteStatement.bindLong(11, WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
                supportSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
                supportSQLiteStatement.bindLong(13, workSpec.lastEnqueueTime);
                supportSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
                supportSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
                supportSQLiteStatement.bindLong(16, workSpec.expedited ? 1L : 0L);
                supportSQLiteStatement.bindLong(17, WorkTypeConverters.outOfQuotaPolicyToInt(workSpec.outOfQuotaPolicy));
                supportSQLiteStatement.bindLong(18, workSpec.getPeriodCount());
                supportSQLiteStatement.bindLong(19, workSpec.getGeneration());
                supportSQLiteStatement.bindLong(20, workSpec.getNextScheduleTimeOverride());
                supportSQLiteStatement.bindLong(21, workSpec.getNextScheduleTimeOverrideGeneration());
                supportSQLiteStatement.bindLong(22, workSpec.getStopReason());
                if (workSpec.getTraceTag() == null) {
                    supportSQLiteStatement.bindNull(23);
                } else {
                    supportSQLiteStatement.bindString(23, workSpec.getTraceTag());
                }
                Constraints constraints = workSpec.constraints;
                supportSQLiteStatement.bindLong(24, WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
                supportSQLiteStatement.bindBlob(25, WorkTypeConverters.fromNetworkRequest$work_runtime_release(constraints.getRequiredNetworkRequestCompat()));
                supportSQLiteStatement.bindLong(26, constraints.getRequiresCharging() ? 1L : 0L);
                supportSQLiteStatement.bindLong(27, constraints.getRequiresDeviceIdle() ? 1L : 0L);
                supportSQLiteStatement.bindLong(28, constraints.getRequiresBatteryNotLow() ? 1L : 0L);
                supportSQLiteStatement.bindLong(29, constraints.getRequiresStorageNotLow() ? 1L : 0L);
                supportSQLiteStatement.bindLong(30, constraints.getContentTriggerUpdateDelayMillis());
                supportSQLiteStatement.bindLong(31, constraints.getContentTriggerMaxDelayMillis());
                supportSQLiteStatement.bindBlob(32, WorkTypeConverters.setOfTriggersToByteArray(constraints.getContentUriTriggers()));
                supportSQLiteStatement.bindString(33, workSpec.id);
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.__preparedStmtOfSetState = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET state=? WHERE id=?";
            }
        };
        this.__preparedStmtOfSetCancelledState = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET stop_reason = CASE WHEN state=1 THEN 1 ELSE -256 END, state=5 WHERE id=?";
            }
        };
        this.__preparedStmtOfIncrementPeriodCount = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET period_count=period_count+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfSetOutput = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.__preparedStmtOfSetLastEnqueueTime = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET last_enqueue_time=? WHERE id=?";
            }
        };
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.10
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.__preparedStmtOfSetNextScheduleTimeOverride = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.11
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET next_schedule_time_override=? WHERE id=?";
            }
        };
        this.__preparedStmtOfResetWorkSpecNextScheduleTimeOverride = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.12
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET next_schedule_time_override=9223372036854775807 WHERE (id=? AND next_schedule_time_override_generation=?)";
            }
        };
        this.__preparedStmtOfMarkWorkSpecScheduled = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.13
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.__preparedStmtOfResetScheduledState = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.14
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.15
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
        this.__preparedStmtOfIncrementGeneration = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.16
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET generation=generation+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfSetStopReason = new SharedSQLiteStatement(roomDatabase) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.17
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET stop_reason=? WHERE id=?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int countNonFinishedContentUriTriggerWorkers() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            return query.moveToFirst() ? query.getInt(0) : 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void delete(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDelete.acquire();
        acquire.bindString(1, str);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfDelete.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getAllEligibleWorkSpecsForScheduling(int i5) {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i6;
        boolean z5;
        String string;
        int i7;
        int i8;
        boolean z6;
        int i9;
        boolean z7;
        int i10;
        boolean z8;
        int i11;
        boolean z9;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?", 1);
        acquire.bindLong(1, i5);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, Constants.ID_ATTRIBUTE_KEY);
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "trace_tag");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "required_network_request");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int i12 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                String string2 = query.getString(columnIndexOrThrow);
                WorkInfo$State intToState = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                String string3 = query.getString(columnIndexOrThrow3);
                String string4 = query.getString(columnIndexOrThrow4);
                Data fromByteArray = Data.fromByteArray(query.getBlob(columnIndexOrThrow5));
                Data fromByteArray2 = Data.fromByteArray(query.getBlob(columnIndexOrThrow6));
                long j5 = query.getLong(columnIndexOrThrow7);
                long j6 = query.getLong(columnIndexOrThrow8);
                long j7 = query.getLong(columnIndexOrThrow9);
                int i13 = query.getInt(columnIndexOrThrow10);
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow11));
                long j8 = query.getLong(columnIndexOrThrow12);
                long j9 = query.getLong(columnIndexOrThrow13);
                int i14 = i12;
                long j10 = query.getLong(i14);
                int i15 = columnIndexOrThrow;
                int i16 = columnIndexOrThrow15;
                long j11 = query.getLong(i16);
                columnIndexOrThrow15 = i16;
                int i17 = columnIndexOrThrow16;
                if (query.getInt(i17) != 0) {
                    columnIndexOrThrow16 = i17;
                    i6 = columnIndexOrThrow17;
                    z5 = true;
                } else {
                    columnIndexOrThrow16 = i17;
                    i6 = columnIndexOrThrow17;
                    z5 = false;
                }
                OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i6));
                columnIndexOrThrow17 = i6;
                int i18 = columnIndexOrThrow18;
                int i19 = query.getInt(i18);
                columnIndexOrThrow18 = i18;
                int i20 = columnIndexOrThrow19;
                int i21 = query.getInt(i20);
                columnIndexOrThrow19 = i20;
                int i22 = columnIndexOrThrow20;
                long j12 = query.getLong(i22);
                columnIndexOrThrow20 = i22;
                int i23 = columnIndexOrThrow21;
                int i24 = query.getInt(i23);
                columnIndexOrThrow21 = i23;
                int i25 = columnIndexOrThrow22;
                int i26 = query.getInt(i25);
                columnIndexOrThrow22 = i25;
                int i27 = columnIndexOrThrow23;
                if (query.isNull(i27)) {
                    columnIndexOrThrow23 = i27;
                    i7 = columnIndexOrThrow24;
                    string = null;
                } else {
                    string = query.getString(i27);
                    columnIndexOrThrow23 = i27;
                    i7 = columnIndexOrThrow24;
                }
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(i7));
                columnIndexOrThrow24 = i7;
                int i28 = columnIndexOrThrow25;
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(query.getBlob(i28));
                columnIndexOrThrow25 = i28;
                int i29 = columnIndexOrThrow26;
                if (query.getInt(i29) != 0) {
                    columnIndexOrThrow26 = i29;
                    i8 = columnIndexOrThrow27;
                    z6 = true;
                } else {
                    columnIndexOrThrow26 = i29;
                    i8 = columnIndexOrThrow27;
                    z6 = false;
                }
                if (query.getInt(i8) != 0) {
                    columnIndexOrThrow27 = i8;
                    i9 = columnIndexOrThrow28;
                    z7 = true;
                } else {
                    columnIndexOrThrow27 = i8;
                    i9 = columnIndexOrThrow28;
                    z7 = false;
                }
                if (query.getInt(i9) != 0) {
                    columnIndexOrThrow28 = i9;
                    i10 = columnIndexOrThrow29;
                    z8 = true;
                } else {
                    columnIndexOrThrow28 = i9;
                    i10 = columnIndexOrThrow29;
                    z8 = false;
                }
                if (query.getInt(i10) != 0) {
                    columnIndexOrThrow29 = i10;
                    i11 = columnIndexOrThrow30;
                    z9 = true;
                } else {
                    columnIndexOrThrow29 = i10;
                    i11 = columnIndexOrThrow30;
                    z9 = false;
                }
                long j13 = query.getLong(i11);
                columnIndexOrThrow30 = i11;
                int i30 = columnIndexOrThrow31;
                long j14 = query.getLong(i30);
                columnIndexOrThrow31 = i30;
                int i31 = columnIndexOrThrow32;
                columnIndexOrThrow32 = i31;
                arrayList.add(new WorkSpec(string2, intToState, string3, string4, fromByteArray, fromByteArray2, j5, j6, j7, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z6, z7, z8, z9, j13, j14, WorkTypeConverters.byteArrayToSetOfTriggers(query.getBlob(i31))), i13, intToBackoffPolicy, j8, j9, j10, j11, z5, intToOutOfQuotaPolicy, i19, i21, j12, i24, i26, string));
                columnIndexOrThrow = i15;
                i12 = i14;
            }
            query.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getEligibleWorkForScheduling(int i5) {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i6;
        boolean z5;
        String string;
        int i7;
        int i8;
        boolean z6;
        int i9;
        boolean z7;
        int i10;
        boolean z8;
        int i11;
        boolean z9;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))", 1);
        acquire.bindLong(1, i5);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, Constants.ID_ATTRIBUTE_KEY);
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "trace_tag");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "required_network_request");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int i12 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                String string2 = query.getString(columnIndexOrThrow);
                WorkInfo$State intToState = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                String string3 = query.getString(columnIndexOrThrow3);
                String string4 = query.getString(columnIndexOrThrow4);
                Data fromByteArray = Data.fromByteArray(query.getBlob(columnIndexOrThrow5));
                Data fromByteArray2 = Data.fromByteArray(query.getBlob(columnIndexOrThrow6));
                long j5 = query.getLong(columnIndexOrThrow7);
                long j6 = query.getLong(columnIndexOrThrow8);
                long j7 = query.getLong(columnIndexOrThrow9);
                int i13 = query.getInt(columnIndexOrThrow10);
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow11));
                long j8 = query.getLong(columnIndexOrThrow12);
                long j9 = query.getLong(columnIndexOrThrow13);
                int i14 = i12;
                long j10 = query.getLong(i14);
                int i15 = columnIndexOrThrow;
                int i16 = columnIndexOrThrow15;
                long j11 = query.getLong(i16);
                columnIndexOrThrow15 = i16;
                int i17 = columnIndexOrThrow16;
                if (query.getInt(i17) != 0) {
                    columnIndexOrThrow16 = i17;
                    i6 = columnIndexOrThrow17;
                    z5 = true;
                } else {
                    columnIndexOrThrow16 = i17;
                    i6 = columnIndexOrThrow17;
                    z5 = false;
                }
                OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i6));
                columnIndexOrThrow17 = i6;
                int i18 = columnIndexOrThrow18;
                int i19 = query.getInt(i18);
                columnIndexOrThrow18 = i18;
                int i20 = columnIndexOrThrow19;
                int i21 = query.getInt(i20);
                columnIndexOrThrow19 = i20;
                int i22 = columnIndexOrThrow20;
                long j12 = query.getLong(i22);
                columnIndexOrThrow20 = i22;
                int i23 = columnIndexOrThrow21;
                int i24 = query.getInt(i23);
                columnIndexOrThrow21 = i23;
                int i25 = columnIndexOrThrow22;
                int i26 = query.getInt(i25);
                columnIndexOrThrow22 = i25;
                int i27 = columnIndexOrThrow23;
                if (query.isNull(i27)) {
                    columnIndexOrThrow23 = i27;
                    i7 = columnIndexOrThrow24;
                    string = null;
                } else {
                    string = query.getString(i27);
                    columnIndexOrThrow23 = i27;
                    i7 = columnIndexOrThrow24;
                }
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(i7));
                columnIndexOrThrow24 = i7;
                int i28 = columnIndexOrThrow25;
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(query.getBlob(i28));
                columnIndexOrThrow25 = i28;
                int i29 = columnIndexOrThrow26;
                if (query.getInt(i29) != 0) {
                    columnIndexOrThrow26 = i29;
                    i8 = columnIndexOrThrow27;
                    z6 = true;
                } else {
                    columnIndexOrThrow26 = i29;
                    i8 = columnIndexOrThrow27;
                    z6 = false;
                }
                if (query.getInt(i8) != 0) {
                    columnIndexOrThrow27 = i8;
                    i9 = columnIndexOrThrow28;
                    z7 = true;
                } else {
                    columnIndexOrThrow27 = i8;
                    i9 = columnIndexOrThrow28;
                    z7 = false;
                }
                if (query.getInt(i9) != 0) {
                    columnIndexOrThrow28 = i9;
                    i10 = columnIndexOrThrow29;
                    z8 = true;
                } else {
                    columnIndexOrThrow28 = i9;
                    i10 = columnIndexOrThrow29;
                    z8 = false;
                }
                if (query.getInt(i10) != 0) {
                    columnIndexOrThrow29 = i10;
                    i11 = columnIndexOrThrow30;
                    z9 = true;
                } else {
                    columnIndexOrThrow29 = i10;
                    i11 = columnIndexOrThrow30;
                    z9 = false;
                }
                long j13 = query.getLong(i11);
                columnIndexOrThrow30 = i11;
                int i30 = columnIndexOrThrow31;
                long j14 = query.getLong(i30);
                columnIndexOrThrow31 = i30;
                int i31 = columnIndexOrThrow32;
                columnIndexOrThrow32 = i31;
                arrayList.add(new WorkSpec(string2, intToState, string3, string4, fromByteArray, fromByteArray2, j5, j6, j7, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z6, z7, z8, z9, j13, j14, WorkTypeConverters.byteArrayToSetOfTriggers(query.getBlob(i31))), i13, intToBackoffPolicy, j8, j9, j10, j11, z5, intToOutOfQuotaPolicy, i19, i21, j12, i24, i26, string));
                columnIndexOrThrow = i15;
                i12 = i14;
            }
            query.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getEligibleWorkForSchedulingWithContentUris() {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i5;
        boolean z5;
        String string;
        int i6;
        int i7;
        boolean z6;
        int i8;
        boolean z7;
        int i9;
        boolean z8;
        int i10;
        boolean z9;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, Constants.ID_ATTRIBUTE_KEY);
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "trace_tag");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "required_network_request");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int i11 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                String string2 = query.getString(columnIndexOrThrow);
                WorkInfo$State intToState = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                String string3 = query.getString(columnIndexOrThrow3);
                String string4 = query.getString(columnIndexOrThrow4);
                Data fromByteArray = Data.fromByteArray(query.getBlob(columnIndexOrThrow5));
                Data fromByteArray2 = Data.fromByteArray(query.getBlob(columnIndexOrThrow6));
                long j5 = query.getLong(columnIndexOrThrow7);
                long j6 = query.getLong(columnIndexOrThrow8);
                long j7 = query.getLong(columnIndexOrThrow9);
                int i12 = query.getInt(columnIndexOrThrow10);
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow11));
                long j8 = query.getLong(columnIndexOrThrow12);
                long j9 = query.getLong(columnIndexOrThrow13);
                int i13 = i11;
                long j10 = query.getLong(i13);
                int i14 = columnIndexOrThrow;
                int i15 = columnIndexOrThrow15;
                long j11 = query.getLong(i15);
                columnIndexOrThrow15 = i15;
                int i16 = columnIndexOrThrow16;
                if (query.getInt(i16) != 0) {
                    columnIndexOrThrow16 = i16;
                    i5 = columnIndexOrThrow17;
                    z5 = true;
                } else {
                    columnIndexOrThrow16 = i16;
                    i5 = columnIndexOrThrow17;
                    z5 = false;
                }
                OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i5));
                columnIndexOrThrow17 = i5;
                int i17 = columnIndexOrThrow18;
                int i18 = query.getInt(i17);
                columnIndexOrThrow18 = i17;
                int i19 = columnIndexOrThrow19;
                int i20 = query.getInt(i19);
                columnIndexOrThrow19 = i19;
                int i21 = columnIndexOrThrow20;
                long j12 = query.getLong(i21);
                columnIndexOrThrow20 = i21;
                int i22 = columnIndexOrThrow21;
                int i23 = query.getInt(i22);
                columnIndexOrThrow21 = i22;
                int i24 = columnIndexOrThrow22;
                int i25 = query.getInt(i24);
                columnIndexOrThrow22 = i24;
                int i26 = columnIndexOrThrow23;
                if (query.isNull(i26)) {
                    columnIndexOrThrow23 = i26;
                    i6 = columnIndexOrThrow24;
                    string = null;
                } else {
                    string = query.getString(i26);
                    columnIndexOrThrow23 = i26;
                    i6 = columnIndexOrThrow24;
                }
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(i6));
                columnIndexOrThrow24 = i6;
                int i27 = columnIndexOrThrow25;
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(query.getBlob(i27));
                columnIndexOrThrow25 = i27;
                int i28 = columnIndexOrThrow26;
                if (query.getInt(i28) != 0) {
                    columnIndexOrThrow26 = i28;
                    i7 = columnIndexOrThrow27;
                    z6 = true;
                } else {
                    columnIndexOrThrow26 = i28;
                    i7 = columnIndexOrThrow27;
                    z6 = false;
                }
                if (query.getInt(i7) != 0) {
                    columnIndexOrThrow27 = i7;
                    i8 = columnIndexOrThrow28;
                    z7 = true;
                } else {
                    columnIndexOrThrow27 = i7;
                    i8 = columnIndexOrThrow28;
                    z7 = false;
                }
                if (query.getInt(i8) != 0) {
                    columnIndexOrThrow28 = i8;
                    i9 = columnIndexOrThrow29;
                    z8 = true;
                } else {
                    columnIndexOrThrow28 = i8;
                    i9 = columnIndexOrThrow29;
                    z8 = false;
                }
                if (query.getInt(i9) != 0) {
                    columnIndexOrThrow29 = i9;
                    i10 = columnIndexOrThrow30;
                    z9 = true;
                } else {
                    columnIndexOrThrow29 = i9;
                    i10 = columnIndexOrThrow30;
                    z9 = false;
                }
                long j13 = query.getLong(i10);
                columnIndexOrThrow30 = i10;
                int i29 = columnIndexOrThrow31;
                long j14 = query.getLong(i29);
                columnIndexOrThrow31 = i29;
                int i30 = columnIndexOrThrow32;
                columnIndexOrThrow32 = i30;
                arrayList.add(new WorkSpec(string2, intToState, string3, string4, fromByteArray, fromByteArray2, j5, j6, j7, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z6, z7, z8, z9, j13, j14, WorkTypeConverters.byteArrayToSetOfTriggers(query.getBlob(i30))), i12, intToBackoffPolicy, j8, j9, j10, j11, z5, intToOutOfQuotaPolicy, i18, i20, j12, i23, i25, string));
                columnIndexOrThrow = i14;
                i11 = i13;
            }
            query.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<Data> getInputsFromPrerequisites(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        acquire.bindString(1, str);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(Data.fromByteArray(query.getBlob(0)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getRecentlyCompletedWork(long j5) {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i5;
        boolean z5;
        String string;
        int i6;
        int i7;
        boolean z6;
        int i8;
        boolean z7;
        int i9;
        boolean z8;
        int i10;
        boolean z9;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", 1);
        acquire.bindLong(1, j5);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, Constants.ID_ATTRIBUTE_KEY);
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "trace_tag");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "required_network_request");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int i11 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                String string2 = query.getString(columnIndexOrThrow);
                WorkInfo$State intToState = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                String string3 = query.getString(columnIndexOrThrow3);
                String string4 = query.getString(columnIndexOrThrow4);
                Data fromByteArray = Data.fromByteArray(query.getBlob(columnIndexOrThrow5));
                Data fromByteArray2 = Data.fromByteArray(query.getBlob(columnIndexOrThrow6));
                long j6 = query.getLong(columnIndexOrThrow7);
                long j7 = query.getLong(columnIndexOrThrow8);
                long j8 = query.getLong(columnIndexOrThrow9);
                int i12 = query.getInt(columnIndexOrThrow10);
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow11));
                long j9 = query.getLong(columnIndexOrThrow12);
                long j10 = query.getLong(columnIndexOrThrow13);
                int i13 = i11;
                long j11 = query.getLong(i13);
                int i14 = columnIndexOrThrow;
                int i15 = columnIndexOrThrow15;
                long j12 = query.getLong(i15);
                columnIndexOrThrow15 = i15;
                int i16 = columnIndexOrThrow16;
                if (query.getInt(i16) != 0) {
                    columnIndexOrThrow16 = i16;
                    i5 = columnIndexOrThrow17;
                    z5 = true;
                } else {
                    columnIndexOrThrow16 = i16;
                    i5 = columnIndexOrThrow17;
                    z5 = false;
                }
                OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i5));
                columnIndexOrThrow17 = i5;
                int i17 = columnIndexOrThrow18;
                int i18 = query.getInt(i17);
                columnIndexOrThrow18 = i17;
                int i19 = columnIndexOrThrow19;
                int i20 = query.getInt(i19);
                columnIndexOrThrow19 = i19;
                int i21 = columnIndexOrThrow20;
                long j13 = query.getLong(i21);
                columnIndexOrThrow20 = i21;
                int i22 = columnIndexOrThrow21;
                int i23 = query.getInt(i22);
                columnIndexOrThrow21 = i22;
                int i24 = columnIndexOrThrow22;
                int i25 = query.getInt(i24);
                columnIndexOrThrow22 = i24;
                int i26 = columnIndexOrThrow23;
                if (query.isNull(i26)) {
                    columnIndexOrThrow23 = i26;
                    i6 = columnIndexOrThrow24;
                    string = null;
                } else {
                    string = query.getString(i26);
                    columnIndexOrThrow23 = i26;
                    i6 = columnIndexOrThrow24;
                }
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(i6));
                columnIndexOrThrow24 = i6;
                int i27 = columnIndexOrThrow25;
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(query.getBlob(i27));
                columnIndexOrThrow25 = i27;
                int i28 = columnIndexOrThrow26;
                if (query.getInt(i28) != 0) {
                    columnIndexOrThrow26 = i28;
                    i7 = columnIndexOrThrow27;
                    z6 = true;
                } else {
                    columnIndexOrThrow26 = i28;
                    i7 = columnIndexOrThrow27;
                    z6 = false;
                }
                if (query.getInt(i7) != 0) {
                    columnIndexOrThrow27 = i7;
                    i8 = columnIndexOrThrow28;
                    z7 = true;
                } else {
                    columnIndexOrThrow27 = i7;
                    i8 = columnIndexOrThrow28;
                    z7 = false;
                }
                if (query.getInt(i8) != 0) {
                    columnIndexOrThrow28 = i8;
                    i9 = columnIndexOrThrow29;
                    z8 = true;
                } else {
                    columnIndexOrThrow28 = i8;
                    i9 = columnIndexOrThrow29;
                    z8 = false;
                }
                if (query.getInt(i9) != 0) {
                    columnIndexOrThrow29 = i9;
                    i10 = columnIndexOrThrow30;
                    z9 = true;
                } else {
                    columnIndexOrThrow29 = i9;
                    i10 = columnIndexOrThrow30;
                    z9 = false;
                }
                long j14 = query.getLong(i10);
                columnIndexOrThrow30 = i10;
                int i29 = columnIndexOrThrow31;
                long j15 = query.getLong(i29);
                columnIndexOrThrow31 = i29;
                int i30 = columnIndexOrThrow32;
                columnIndexOrThrow32 = i30;
                arrayList.add(new WorkSpec(string2, intToState, string3, string4, fromByteArray, fromByteArray2, j6, j7, j8, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z6, z7, z8, z9, j14, j15, WorkTypeConverters.byteArrayToSetOfTriggers(query.getBlob(i30))), i12, intToBackoffPolicy, j9, j10, j11, j12, z5, intToOutOfQuotaPolicy, i18, i20, j13, i23, i25, string));
                columnIndexOrThrow = i14;
                i11 = i13;
            }
            query.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getRunningWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i5;
        boolean z5;
        String string;
        int i6;
        int i7;
        boolean z6;
        int i8;
        boolean z7;
        int i9;
        boolean z8;
        int i10;
        boolean z9;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, Constants.ID_ATTRIBUTE_KEY);
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "trace_tag");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "required_network_request");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int i11 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                String string2 = query.getString(columnIndexOrThrow);
                WorkInfo$State intToState = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                String string3 = query.getString(columnIndexOrThrow3);
                String string4 = query.getString(columnIndexOrThrow4);
                Data fromByteArray = Data.fromByteArray(query.getBlob(columnIndexOrThrow5));
                Data fromByteArray2 = Data.fromByteArray(query.getBlob(columnIndexOrThrow6));
                long j5 = query.getLong(columnIndexOrThrow7);
                long j6 = query.getLong(columnIndexOrThrow8);
                long j7 = query.getLong(columnIndexOrThrow9);
                int i12 = query.getInt(columnIndexOrThrow10);
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow11));
                long j8 = query.getLong(columnIndexOrThrow12);
                long j9 = query.getLong(columnIndexOrThrow13);
                int i13 = i11;
                long j10 = query.getLong(i13);
                int i14 = columnIndexOrThrow;
                int i15 = columnIndexOrThrow15;
                long j11 = query.getLong(i15);
                columnIndexOrThrow15 = i15;
                int i16 = columnIndexOrThrow16;
                if (query.getInt(i16) != 0) {
                    columnIndexOrThrow16 = i16;
                    i5 = columnIndexOrThrow17;
                    z5 = true;
                } else {
                    columnIndexOrThrow16 = i16;
                    i5 = columnIndexOrThrow17;
                    z5 = false;
                }
                OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i5));
                columnIndexOrThrow17 = i5;
                int i17 = columnIndexOrThrow18;
                int i18 = query.getInt(i17);
                columnIndexOrThrow18 = i17;
                int i19 = columnIndexOrThrow19;
                int i20 = query.getInt(i19);
                columnIndexOrThrow19 = i19;
                int i21 = columnIndexOrThrow20;
                long j12 = query.getLong(i21);
                columnIndexOrThrow20 = i21;
                int i22 = columnIndexOrThrow21;
                int i23 = query.getInt(i22);
                columnIndexOrThrow21 = i22;
                int i24 = columnIndexOrThrow22;
                int i25 = query.getInt(i24);
                columnIndexOrThrow22 = i24;
                int i26 = columnIndexOrThrow23;
                if (query.isNull(i26)) {
                    columnIndexOrThrow23 = i26;
                    i6 = columnIndexOrThrow24;
                    string = null;
                } else {
                    string = query.getString(i26);
                    columnIndexOrThrow23 = i26;
                    i6 = columnIndexOrThrow24;
                }
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(i6));
                columnIndexOrThrow24 = i6;
                int i27 = columnIndexOrThrow25;
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(query.getBlob(i27));
                columnIndexOrThrow25 = i27;
                int i28 = columnIndexOrThrow26;
                if (query.getInt(i28) != 0) {
                    columnIndexOrThrow26 = i28;
                    i7 = columnIndexOrThrow27;
                    z6 = true;
                } else {
                    columnIndexOrThrow26 = i28;
                    i7 = columnIndexOrThrow27;
                    z6 = false;
                }
                if (query.getInt(i7) != 0) {
                    columnIndexOrThrow27 = i7;
                    i8 = columnIndexOrThrow28;
                    z7 = true;
                } else {
                    columnIndexOrThrow27 = i7;
                    i8 = columnIndexOrThrow28;
                    z7 = false;
                }
                if (query.getInt(i8) != 0) {
                    columnIndexOrThrow28 = i8;
                    i9 = columnIndexOrThrow29;
                    z8 = true;
                } else {
                    columnIndexOrThrow28 = i8;
                    i9 = columnIndexOrThrow29;
                    z8 = false;
                }
                if (query.getInt(i9) != 0) {
                    columnIndexOrThrow29 = i9;
                    i10 = columnIndexOrThrow30;
                    z9 = true;
                } else {
                    columnIndexOrThrow29 = i9;
                    i10 = columnIndexOrThrow30;
                    z9 = false;
                }
                long j13 = query.getLong(i10);
                columnIndexOrThrow30 = i10;
                int i29 = columnIndexOrThrow31;
                long j14 = query.getLong(i29);
                columnIndexOrThrow31 = i29;
                int i30 = columnIndexOrThrow32;
                columnIndexOrThrow32 = i30;
                arrayList.add(new WorkSpec(string2, intToState, string3, string4, fromByteArray, fromByteArray2, j5, j6, j7, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z6, z7, z8, z9, j13, j14, WorkTypeConverters.byteArrayToSetOfTriggers(query.getBlob(i30))), i12, intToBackoffPolicy, j8, j9, j10, j11, z5, intToOutOfQuotaPolicy, i18, i20, j12, i23, i25, string));
                columnIndexOrThrow = i14;
                i11 = i13;
            }
            query.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getScheduledWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i5;
        boolean z5;
        String string;
        int i6;
        int i7;
        boolean z6;
        int i8;
        boolean z7;
        int i9;
        boolean z8;
        int i10;
        boolean z9;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, Constants.ID_ATTRIBUTE_KEY);
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "trace_tag");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "required_network_request");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int i11 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                String string2 = query.getString(columnIndexOrThrow);
                WorkInfo$State intToState = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                String string3 = query.getString(columnIndexOrThrow3);
                String string4 = query.getString(columnIndexOrThrow4);
                Data fromByteArray = Data.fromByteArray(query.getBlob(columnIndexOrThrow5));
                Data fromByteArray2 = Data.fromByteArray(query.getBlob(columnIndexOrThrow6));
                long j5 = query.getLong(columnIndexOrThrow7);
                long j6 = query.getLong(columnIndexOrThrow8);
                long j7 = query.getLong(columnIndexOrThrow9);
                int i12 = query.getInt(columnIndexOrThrow10);
                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow11));
                long j8 = query.getLong(columnIndexOrThrow12);
                long j9 = query.getLong(columnIndexOrThrow13);
                int i13 = i11;
                long j10 = query.getLong(i13);
                int i14 = columnIndexOrThrow;
                int i15 = columnIndexOrThrow15;
                long j11 = query.getLong(i15);
                columnIndexOrThrow15 = i15;
                int i16 = columnIndexOrThrow16;
                if (query.getInt(i16) != 0) {
                    columnIndexOrThrow16 = i16;
                    i5 = columnIndexOrThrow17;
                    z5 = true;
                } else {
                    columnIndexOrThrow16 = i16;
                    i5 = columnIndexOrThrow17;
                    z5 = false;
                }
                OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i5));
                columnIndexOrThrow17 = i5;
                int i17 = columnIndexOrThrow18;
                int i18 = query.getInt(i17);
                columnIndexOrThrow18 = i17;
                int i19 = columnIndexOrThrow19;
                int i20 = query.getInt(i19);
                columnIndexOrThrow19 = i19;
                int i21 = columnIndexOrThrow20;
                long j12 = query.getLong(i21);
                columnIndexOrThrow20 = i21;
                int i22 = columnIndexOrThrow21;
                int i23 = query.getInt(i22);
                columnIndexOrThrow21 = i22;
                int i24 = columnIndexOrThrow22;
                int i25 = query.getInt(i24);
                columnIndexOrThrow22 = i24;
                int i26 = columnIndexOrThrow23;
                if (query.isNull(i26)) {
                    columnIndexOrThrow23 = i26;
                    i6 = columnIndexOrThrow24;
                    string = null;
                } else {
                    string = query.getString(i26);
                    columnIndexOrThrow23 = i26;
                    i6 = columnIndexOrThrow24;
                }
                NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(i6));
                columnIndexOrThrow24 = i6;
                int i27 = columnIndexOrThrow25;
                NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(query.getBlob(i27));
                columnIndexOrThrow25 = i27;
                int i28 = columnIndexOrThrow26;
                if (query.getInt(i28) != 0) {
                    columnIndexOrThrow26 = i28;
                    i7 = columnIndexOrThrow27;
                    z6 = true;
                } else {
                    columnIndexOrThrow26 = i28;
                    i7 = columnIndexOrThrow27;
                    z6 = false;
                }
                if (query.getInt(i7) != 0) {
                    columnIndexOrThrow27 = i7;
                    i8 = columnIndexOrThrow28;
                    z7 = true;
                } else {
                    columnIndexOrThrow27 = i7;
                    i8 = columnIndexOrThrow28;
                    z7 = false;
                }
                if (query.getInt(i8) != 0) {
                    columnIndexOrThrow28 = i8;
                    i9 = columnIndexOrThrow29;
                    z8 = true;
                } else {
                    columnIndexOrThrow28 = i8;
                    i9 = columnIndexOrThrow29;
                    z8 = false;
                }
                if (query.getInt(i9) != 0) {
                    columnIndexOrThrow29 = i9;
                    i10 = columnIndexOrThrow30;
                    z9 = true;
                } else {
                    columnIndexOrThrow29 = i9;
                    i10 = columnIndexOrThrow30;
                    z9 = false;
                }
                long j13 = query.getLong(i10);
                columnIndexOrThrow30 = i10;
                int i29 = columnIndexOrThrow31;
                long j14 = query.getLong(i29);
                columnIndexOrThrow31 = i29;
                int i30 = columnIndexOrThrow32;
                columnIndexOrThrow32 = i30;
                arrayList.add(new WorkSpec(string2, intToState, string3, string4, fromByteArray, fromByteArray2, j5, j6, j7, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z6, z7, z8, z9, j13, j14, WorkTypeConverters.byteArrayToSetOfTriggers(query.getBlob(i30))), i12, intToBackoffPolicy, j8, j9, j10, j11, z5, intToOutOfQuotaPolicy, i18, i20, j12, i23, i25, string));
                columnIndexOrThrow = i14;
                i11 = i13;
            }
            query.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkInfo$State getState(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT state FROM workspec WHERE id=?", 1);
        acquire.bindString(1, str);
        this.__db.assertNotSuspendingTransaction();
        WorkInfo$State workInfo$State = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            if (query.moveToFirst()) {
                Integer valueOf = query.isNull(0) ? null : Integer.valueOf(query.getInt(0));
                if (valueOf != null) {
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    workInfo$State = WorkTypeConverters.intToState(valueOf.intValue());
                }
            }
            return workInfo$State;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getUnfinishedWorkWithName(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        acquire.bindString(1, str);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec getWorkSpec(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        WorkSpec workSpec;
        int i5;
        boolean z5;
        String string;
        int i6;
        int i7;
        boolean z6;
        int i8;
        boolean z7;
        int i9;
        boolean z8;
        int i10;
        boolean z9;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE id=?", 1);
        acquire.bindString(1, str);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, Constants.ID_ATTRIBUTE_KEY);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "trace_tag");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "required_network_request");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                if (query.moveToFirst()) {
                    String string2 = query.getString(columnIndexOrThrow);
                    WorkInfo$State intToState = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    String string3 = query.getString(columnIndexOrThrow3);
                    String string4 = query.getString(columnIndexOrThrow4);
                    Data fromByteArray = Data.fromByteArray(query.getBlob(columnIndexOrThrow5));
                    Data fromByteArray2 = Data.fromByteArray(query.getBlob(columnIndexOrThrow6));
                    long j5 = query.getLong(columnIndexOrThrow7);
                    long j6 = query.getLong(columnIndexOrThrow8);
                    long j7 = query.getLong(columnIndexOrThrow9);
                    int i11 = query.getInt(columnIndexOrThrow10);
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow11));
                    long j8 = query.getLong(columnIndexOrThrow12);
                    long j9 = query.getLong(columnIndexOrThrow13);
                    long j10 = query.getLong(columnIndexOrThrow14);
                    long j11 = query.getLong(columnIndexOrThrow15);
                    if (query.getInt(columnIndexOrThrow16) != 0) {
                        i5 = columnIndexOrThrow17;
                        z5 = true;
                    } else {
                        i5 = columnIndexOrThrow17;
                        z5 = false;
                    }
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(i5));
                    int i12 = query.getInt(columnIndexOrThrow18);
                    int i13 = query.getInt(columnIndexOrThrow19);
                    long j12 = query.getLong(columnIndexOrThrow20);
                    int i14 = query.getInt(columnIndexOrThrow21);
                    int i15 = query.getInt(columnIndexOrThrow22);
                    if (query.isNull(columnIndexOrThrow23)) {
                        i6 = columnIndexOrThrow24;
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow23);
                        i6 = columnIndexOrThrow24;
                    }
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(i6));
                    NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(query.getBlob(columnIndexOrThrow25));
                    if (query.getInt(columnIndexOrThrow26) != 0) {
                        i7 = columnIndexOrThrow27;
                        z6 = true;
                    } else {
                        i7 = columnIndexOrThrow27;
                        z6 = false;
                    }
                    if (query.getInt(i7) != 0) {
                        i8 = columnIndexOrThrow28;
                        z7 = true;
                    } else {
                        i8 = columnIndexOrThrow28;
                        z7 = false;
                    }
                    if (query.getInt(i8) != 0) {
                        i9 = columnIndexOrThrow29;
                        z8 = true;
                    } else {
                        i9 = columnIndexOrThrow29;
                        z8 = false;
                    }
                    if (query.getInt(i9) != 0) {
                        i10 = columnIndexOrThrow30;
                        z9 = true;
                    } else {
                        i10 = columnIndexOrThrow30;
                        z9 = false;
                    }
                    workSpec = new WorkSpec(string2, intToState, string3, string4, fromByteArray, fromByteArray2, j5, j6, j7, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z6, z7, z8, z9, query.getLong(i10), query.getLong(columnIndexOrThrow31), WorkTypeConverters.byteArrayToSetOfTriggers(query.getBlob(columnIndexOrThrow32))), i11, intToBackoffPolicy, j8, j9, j10, j11, z5, intToOutOfQuotaPolicy, i12, i13, j12, i14, i15, string);
                } else {
                    workSpec = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return workSpec;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        acquire.bindString(1, str);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new WorkSpec.IdAndState(query.getString(0), WorkTypeConverters.intToState(query.getInt(1))));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public Flow<Boolean> hasUnfinishedWorkFlow() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"workspec"}, new Callable<Boolean>() { // from class: androidx.work.impl.model.WorkSpecDao_Impl.25
            protected void finalize() {
                acquire.release();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() {
                Boolean bool;
                Cursor query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, false, null);
                try {
                    if (query.moveToFirst()) {
                        bool = Boolean.valueOf(query.getInt(0) != 0);
                    } else {
                        bool = Boolean.FALSE;
                    }
                    query.close();
                    return bool;
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
        });
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void incrementPeriodCount(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfIncrementPeriodCount.acquire();
        acquire.bindString(1, str);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfIncrementPeriodCount.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int incrementWorkSpecRunAttemptCount(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.acquire();
        acquire.bindString(1, str);
        try {
            this.__db.beginTransaction();
            try {
                int executeUpdateDelete = acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                return executeUpdateDelete;
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void insertWorkSpec(WorkSpec workSpec) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWorkSpec.insert(workSpec);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int markWorkSpecScheduled(String str, long j5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfMarkWorkSpecScheduled.acquire();
        acquire.bindLong(1, j5);
        acquire.bindString(2, str);
        try {
            this.__db.beginTransaction();
            try {
                int executeUpdateDelete = acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                return executeUpdateDelete;
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfMarkWorkSpecScheduled.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int resetScheduledState() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetScheduledState.acquire();
        try {
            this.__db.beginTransaction();
            try {
                int executeUpdateDelete = acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                return executeUpdateDelete;
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfResetScheduledState.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void resetWorkSpecNextScheduleTimeOverride(String str, int i5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetWorkSpecNextScheduleTimeOverride.acquire();
        acquire.bindString(1, str);
        acquire.bindLong(2, i5);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfResetWorkSpecNextScheduleTimeOverride.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int resetWorkSpecRunAttemptCount(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetWorkSpecRunAttemptCount.acquire();
        acquire.bindString(1, str);
        try {
            this.__db.beginTransaction();
            try {
                int executeUpdateDelete = acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                return executeUpdateDelete;
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfResetWorkSpecRunAttemptCount.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int setCancelledState(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetCancelledState.acquire();
        acquire.bindString(1, str);
        try {
            this.__db.beginTransaction();
            try {
                int executeUpdateDelete = acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                return executeUpdateDelete;
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfSetCancelledState.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setLastEnqueueTime(String str, long j5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetLastEnqueueTime.acquire();
        acquire.bindLong(1, j5);
        acquire.bindString(2, str);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfSetLastEnqueueTime.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setOutput(String str, Data data) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetOutput.acquire();
        acquire.bindBlob(1, Data.toByteArrayInternalV1(data));
        acquire.bindString(2, str);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfSetOutput.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int setState(WorkInfo$State workInfo$State, String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetState.acquire();
        acquire.bindLong(1, WorkTypeConverters.stateToInt(workInfo$State));
        acquire.bindString(2, str);
        try {
            this.__db.beginTransaction();
            try {
                int executeUpdateDelete = acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                return executeUpdateDelete;
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfSetState.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setStopReason(String str, int i5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetStopReason.acquire();
        acquire.bindLong(1, i5);
        acquire.bindString(2, str);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfSetStopReason.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void updateWorkSpec(WorkSpec workSpec) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfWorkSpec.handle(workSpec);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
