package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import androidx.room.AutoClosingRoomOpenHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfw$zza;
import com.google.android.gms.internal.measurement.zzfw$zzb;
import com.google.android.gms.internal.measurement.zzfw$zzc;
import com.google.android.gms.internal.measurement.zzfw$zze;
import com.google.android.gms.internal.measurement.zzgf$zzf;
import com.google.android.gms.internal.measurement.zzgf$zzh;
import com.google.android.gms.internal.measurement.zzgf$zzj;
import com.google.android.gms.internal.measurement.zzgf$zzk;
import com.google.android.gms.internal.measurement.zzgf$zzm;
import com.google.android.gms.internal.measurement.zzgf$zzp;
import com.google.android.gms.internal.measurement.zzkg;
import com.google.android.gms.measurement.internal.zzjj;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzar extends zzot {
    private final zzaz zzm;
    private final zzoh zzn;
    private static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    static final String[] zza = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;"};
    private static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;"};
    private static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzj = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private static final String[] zzk = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    private static final String[] zzl = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzar(zzou zzouVar) {
        super(zzouVar);
        this.zzn = new zzoh(zzb());
        this.zzm = new zzaz(this, zza(), "google_app_measurement.db");
    }

    private final String zzap() {
        long currentTimeMillis = zzb().currentTimeMillis();
        Locale locale = Locale.US;
        zzlu zzluVar = zzlu.GOOGLE_SIGNAL;
        Integer valueOf = Integer.valueOf(zzluVar.zza());
        Long valueOf2 = Long.valueOf(currentTimeMillis);
        Long zza2 = zzbn.zzan.zza(null);
        zza2.longValue();
        return "(" + String.format(locale, "(upload_type = %d AND ABS(creation_timestamp - %d) > %d)", valueOf, valueOf2, zza2) + " OR " + String.format(locale, "(upload_type != %d AND ABS(creation_timestamp - %d) > %d)", Integer.valueOf(zzluVar.zza()), Long.valueOf(currentTimeMillis), Long.valueOf(zzai.zzm())) + ")";
    }

    private final int zzr(String str) {
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        try {
            int zzb2 = zze().zzb(str, zzbn.zzv);
            if (zzb2 <= 0) {
                return 0;
            }
            return f_().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(zzb2)});
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error deleting over the limit queued batches. appId", zzgo.zza(str), e5);
            return 0;
        }
    }

    public final long c_() {
        Cursor cursor = null;
        try {
            try {
                cursor = f_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return -1L;
                }
                long j5 = cursor.getLong(0);
                cursor.close();
                return j5;
            } catch (SQLiteException e5) {
                zzj().zzg().zza("Error querying raw events", e5);
                if (cursor != null) {
                    cursor.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long d_() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    public final long e_() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SQLiteDatabase f_() {
        zzv();
        try {
            return this.zzm.getWritableDatabase();
        } catch (SQLiteException e5) {
            zzj().zzr().zza("Error opening database", e5);
            throw e5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003f  */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String g_() {
        Throwable th;
        Cursor cursor;
        ?? f_ = f_();
        try {
            try {
                cursor = f_.rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
                try {
                    if (!cursor.moveToFirst()) {
                        cursor.close();
                        return null;
                    }
                    String string = cursor.getString(0);
                    cursor.close();
                    return string;
                } catch (SQLiteException e5) {
                    e = e5;
                    zzj().zzg().zza("Database error getting next bundle app id", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (f_ != 0) {
                    f_.close();
                }
                throw th;
            }
        } catch (SQLiteException e6) {
            e = e6;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            f_ = 0;
            if (f_ != 0) {
            }
            throw th;
        }
    }

    public final boolean zzaa() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzab() {
        return zza().getDatabasePath("google_app_measurement.db").exists();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long zzb(String str, String str2) {
        long zza2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzv();
        zzam();
        SQLiteDatabase f_ = f_();
        f_.beginTransaction();
        long j5 = 0;
        try {
            try {
                zza2 = zza("select " + str2 + " from app2 where app_id=?", new String[]{str}, -1L);
                if (zza2 == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (f_.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        zzj().zzg().zza("Failed to insert column (got -1). appId", zzgo.zza(str), str2);
                        return -1L;
                    }
                    zza2 = 0;
                }
            } catch (SQLiteException e5) {
                e = e5;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + zza2));
                if (f_.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                    zzj().zzg().zza("Failed to update column (got 0). appId", zzgo.zza(str), str2);
                    return -1L;
                }
                f_.setTransactionSuccessful();
                return zza2;
            } catch (SQLiteException e6) {
                long j6 = zza2;
                e = e6;
                j5 = j6;
                zzj().zzg().zza("Error inserting column. appId", zzgo.zza(str), str2, e);
                f_.endTransaction();
                return j5;
            }
        } finally {
            f_.endTransaction();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzot
    protected final boolean zzc() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01d0 A[Catch: all -> 0x00b6, SQLiteException -> 0x00ba, TryCatch #1 {SQLiteException -> 0x00ba, blocks: (B:5:0x008a, B:10:0x0094, B:12:0x00ae, B:13:0x00bd, B:15:0x00d3, B:16:0x00db, B:18:0x011d, B:22:0x0127, B:25:0x0171, B:27:0x01a0, B:31:0x01aa, B:34:0x01c5, B:36:0x01d0, B:37:0x01e2, B:39:0x01ee, B:40:0x01f7, B:42:0x01ff, B:45:0x0208, B:47:0x0235, B:49:0x0241, B:50:0x0253, B:52:0x025b, B:55:0x0264, B:58:0x027c, B:61:0x02a6, B:63:0x02b1, B:64:0x02bc, B:66:0x02c4, B:67:0x02cf, B:69:0x02e4, B:71:0x02ec, B:72:0x02f3, B:74:0x02fc, B:78:0x029c, B:79:0x0271, B:82:0x0278, B:85:0x01c1, B:87:0x016c), top: B:4:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01ee A[Catch: all -> 0x00b6, SQLiteException -> 0x00ba, TryCatch #1 {SQLiteException -> 0x00ba, blocks: (B:5:0x008a, B:10:0x0094, B:12:0x00ae, B:13:0x00bd, B:15:0x00d3, B:16:0x00db, B:18:0x011d, B:22:0x0127, B:25:0x0171, B:27:0x01a0, B:31:0x01aa, B:34:0x01c5, B:36:0x01d0, B:37:0x01e2, B:39:0x01ee, B:40:0x01f7, B:42:0x01ff, B:45:0x0208, B:47:0x0235, B:49:0x0241, B:50:0x0253, B:52:0x025b, B:55:0x0264, B:58:0x027c, B:61:0x02a6, B:63:0x02b1, B:64:0x02bc, B:66:0x02c4, B:67:0x02cf, B:69:0x02e4, B:71:0x02ec, B:72:0x02f3, B:74:0x02fc, B:78:0x029c, B:79:0x0271, B:82:0x0278, B:85:0x01c1, B:87:0x016c), top: B:4:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ff A[Catch: all -> 0x00b6, SQLiteException -> 0x00ba, TryCatch #1 {SQLiteException -> 0x00ba, blocks: (B:5:0x008a, B:10:0x0094, B:12:0x00ae, B:13:0x00bd, B:15:0x00d3, B:16:0x00db, B:18:0x011d, B:22:0x0127, B:25:0x0171, B:27:0x01a0, B:31:0x01aa, B:34:0x01c5, B:36:0x01d0, B:37:0x01e2, B:39:0x01ee, B:40:0x01f7, B:42:0x01ff, B:45:0x0208, B:47:0x0235, B:49:0x0241, B:50:0x0253, B:52:0x025b, B:55:0x0264, B:58:0x027c, B:61:0x02a6, B:63:0x02b1, B:64:0x02bc, B:66:0x02c4, B:67:0x02cf, B:69:0x02e4, B:71:0x02ec, B:72:0x02f3, B:74:0x02fc, B:78:0x029c, B:79:0x0271, B:82:0x0278, B:85:0x01c1, B:87:0x016c), top: B:4:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0235 A[Catch: all -> 0x00b6, SQLiteException -> 0x00ba, TryCatch #1 {SQLiteException -> 0x00ba, blocks: (B:5:0x008a, B:10:0x0094, B:12:0x00ae, B:13:0x00bd, B:15:0x00d3, B:16:0x00db, B:18:0x011d, B:22:0x0127, B:25:0x0171, B:27:0x01a0, B:31:0x01aa, B:34:0x01c5, B:36:0x01d0, B:37:0x01e2, B:39:0x01ee, B:40:0x01f7, B:42:0x01ff, B:45:0x0208, B:47:0x0235, B:49:0x0241, B:50:0x0253, B:52:0x025b, B:55:0x0264, B:58:0x027c, B:61:0x02a6, B:63:0x02b1, B:64:0x02bc, B:66:0x02c4, B:67:0x02cf, B:69:0x02e4, B:71:0x02ec, B:72:0x02f3, B:74:0x02fc, B:78:0x029c, B:79:0x0271, B:82:0x0278, B:85:0x01c1, B:87:0x016c), top: B:4:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x025b A[Catch: all -> 0x00b6, SQLiteException -> 0x00ba, TryCatch #1 {SQLiteException -> 0x00ba, blocks: (B:5:0x008a, B:10:0x0094, B:12:0x00ae, B:13:0x00bd, B:15:0x00d3, B:16:0x00db, B:18:0x011d, B:22:0x0127, B:25:0x0171, B:27:0x01a0, B:31:0x01aa, B:34:0x01c5, B:36:0x01d0, B:37:0x01e2, B:39:0x01ee, B:40:0x01f7, B:42:0x01ff, B:45:0x0208, B:47:0x0235, B:49:0x0241, B:50:0x0253, B:52:0x025b, B:55:0x0264, B:58:0x027c, B:61:0x02a6, B:63:0x02b1, B:64:0x02bc, B:66:0x02c4, B:67:0x02cf, B:69:0x02e4, B:71:0x02ec, B:72:0x02f3, B:74:0x02fc, B:78:0x029c, B:79:0x0271, B:82:0x0278, B:85:0x01c1, B:87:0x016c), top: B:4:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02b1 A[Catch: all -> 0x00b6, SQLiteException -> 0x00ba, TryCatch #1 {SQLiteException -> 0x00ba, blocks: (B:5:0x008a, B:10:0x0094, B:12:0x00ae, B:13:0x00bd, B:15:0x00d3, B:16:0x00db, B:18:0x011d, B:22:0x0127, B:25:0x0171, B:27:0x01a0, B:31:0x01aa, B:34:0x01c5, B:36:0x01d0, B:37:0x01e2, B:39:0x01ee, B:40:0x01f7, B:42:0x01ff, B:45:0x0208, B:47:0x0235, B:49:0x0241, B:50:0x0253, B:52:0x025b, B:55:0x0264, B:58:0x027c, B:61:0x02a6, B:63:0x02b1, B:64:0x02bc, B:66:0x02c4, B:67:0x02cf, B:69:0x02e4, B:71:0x02ec, B:72:0x02f3, B:74:0x02fc, B:78:0x029c, B:79:0x0271, B:82:0x0278, B:85:0x01c1, B:87:0x016c), top: B:4:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02c4 A[Catch: all -> 0x00b6, SQLiteException -> 0x00ba, TryCatch #1 {SQLiteException -> 0x00ba, blocks: (B:5:0x008a, B:10:0x0094, B:12:0x00ae, B:13:0x00bd, B:15:0x00d3, B:16:0x00db, B:18:0x011d, B:22:0x0127, B:25:0x0171, B:27:0x01a0, B:31:0x01aa, B:34:0x01c5, B:36:0x01d0, B:37:0x01e2, B:39:0x01ee, B:40:0x01f7, B:42:0x01ff, B:45:0x0208, B:47:0x0235, B:49:0x0241, B:50:0x0253, B:52:0x025b, B:55:0x0264, B:58:0x027c, B:61:0x02a6, B:63:0x02b1, B:64:0x02bc, B:66:0x02c4, B:67:0x02cf, B:69:0x02e4, B:71:0x02ec, B:72:0x02f3, B:74:0x02fc, B:78:0x029c, B:79:0x0271, B:82:0x0278, B:85:0x01c1, B:87:0x016c), top: B:4:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02e4 A[Catch: all -> 0x00b6, SQLiteException -> 0x00ba, TryCatch #1 {SQLiteException -> 0x00ba, blocks: (B:5:0x008a, B:10:0x0094, B:12:0x00ae, B:13:0x00bd, B:15:0x00d3, B:16:0x00db, B:18:0x011d, B:22:0x0127, B:25:0x0171, B:27:0x01a0, B:31:0x01aa, B:34:0x01c5, B:36:0x01d0, B:37:0x01e2, B:39:0x01ee, B:40:0x01f7, B:42:0x01ff, B:45:0x0208, B:47:0x0235, B:49:0x0241, B:50:0x0253, B:52:0x025b, B:55:0x0264, B:58:0x027c, B:61:0x02a6, B:63:0x02b1, B:64:0x02bc, B:66:0x02c4, B:67:0x02cf, B:69:0x02e4, B:71:0x02ec, B:72:0x02f3, B:74:0x02fc, B:78:0x029c, B:79:0x0271, B:82:0x0278, B:85:0x01c1, B:87:0x016c), top: B:4:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02fc A[Catch: all -> 0x00b6, SQLiteException -> 0x00ba, TRY_LEAVE, TryCatch #1 {SQLiteException -> 0x00ba, blocks: (B:5:0x008a, B:10:0x0094, B:12:0x00ae, B:13:0x00bd, B:15:0x00d3, B:16:0x00db, B:18:0x011d, B:22:0x0127, B:25:0x0171, B:27:0x01a0, B:31:0x01aa, B:34:0x01c5, B:36:0x01d0, B:37:0x01e2, B:39:0x01ee, B:40:0x01f7, B:42:0x01ff, B:45:0x0208, B:47:0x0235, B:49:0x0241, B:50:0x0253, B:52:0x025b, B:55:0x0264, B:58:0x027c, B:61:0x02a6, B:63:0x02b1, B:64:0x02bc, B:66:0x02c4, B:67:0x02cf, B:69:0x02e4, B:71:0x02ec, B:72:0x02f3, B:74:0x02fc, B:78:0x029c, B:79:0x0271, B:82:0x0278, B:85:0x01c1, B:87:0x016c), top: B:4:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x029c A[Catch: all -> 0x00b6, SQLiteException -> 0x00ba, TryCatch #1 {SQLiteException -> 0x00ba, blocks: (B:5:0x008a, B:10:0x0094, B:12:0x00ae, B:13:0x00bd, B:15:0x00d3, B:16:0x00db, B:18:0x011d, B:22:0x0127, B:25:0x0171, B:27:0x01a0, B:31:0x01aa, B:34:0x01c5, B:36:0x01d0, B:37:0x01e2, B:39:0x01ee, B:40:0x01f7, B:42:0x01ff, B:45:0x0208, B:47:0x0235, B:49:0x0241, B:50:0x0253, B:52:0x025b, B:55:0x0264, B:58:0x027c, B:61:0x02a6, B:63:0x02b1, B:64:0x02bc, B:66:0x02c4, B:67:0x02cf, B:69:0x02e4, B:71:0x02ec, B:72:0x02f3, B:74:0x02fc, B:78:0x029c, B:79:0x0271, B:82:0x0278, B:85:0x01c1, B:87:0x016c), top: B:4:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0271 A[Catch: all -> 0x00b6, SQLiteException -> 0x00ba, TryCatch #1 {SQLiteException -> 0x00ba, blocks: (B:5:0x008a, B:10:0x0094, B:12:0x00ae, B:13:0x00bd, B:15:0x00d3, B:16:0x00db, B:18:0x011d, B:22:0x0127, B:25:0x0171, B:27:0x01a0, B:31:0x01aa, B:34:0x01c5, B:36:0x01d0, B:37:0x01e2, B:39:0x01ee, B:40:0x01f7, B:42:0x01ff, B:45:0x0208, B:47:0x0235, B:49:0x0241, B:50:0x0253, B:52:0x025b, B:55:0x0264, B:58:0x027c, B:61:0x02a6, B:63:0x02b1, B:64:0x02bc, B:66:0x02c4, B:67:0x02cf, B:69:0x02e4, B:71:0x02ec, B:72:0x02f3, B:74:0x02fc, B:78:0x029c, B:79:0x0271, B:82:0x0278, B:85:0x01c1, B:87:0x016c), top: B:4:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c1 A[Catch: all -> 0x00b6, SQLiteException -> 0x00ba, TryCatch #1 {SQLiteException -> 0x00ba, blocks: (B:5:0x008a, B:10:0x0094, B:12:0x00ae, B:13:0x00bd, B:15:0x00d3, B:16:0x00db, B:18:0x011d, B:22:0x0127, B:25:0x0171, B:27:0x01a0, B:31:0x01aa, B:34:0x01c5, B:36:0x01d0, B:37:0x01e2, B:39:0x01ee, B:40:0x01f7, B:42:0x01ff, B:45:0x0208, B:47:0x0235, B:49:0x0241, B:50:0x0253, B:52:0x025b, B:55:0x0264, B:58:0x027c, B:61:0x02a6, B:63:0x02b1, B:64:0x02bc, B:66:0x02c4, B:67:0x02cf, B:69:0x02e4, B:71:0x02ec, B:72:0x02f3, B:74:0x02fc, B:78:0x029c, B:79:0x0271, B:82:0x0278, B:85:0x01c1, B:87:0x016c), top: B:4:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x016c A[Catch: all -> 0x00b6, SQLiteException -> 0x00ba, TryCatch #1 {SQLiteException -> 0x00ba, blocks: (B:5:0x008a, B:10:0x0094, B:12:0x00ae, B:13:0x00bd, B:15:0x00d3, B:16:0x00db, B:18:0x011d, B:22:0x0127, B:25:0x0171, B:27:0x01a0, B:31:0x01aa, B:34:0x01c5, B:36:0x01d0, B:37:0x01e2, B:39:0x01ee, B:40:0x01f7, B:42:0x01ff, B:45:0x0208, B:47:0x0235, B:49:0x0241, B:50:0x0253, B:52:0x025b, B:55:0x0264, B:58:0x027c, B:61:0x02a6, B:63:0x02b1, B:64:0x02bc, B:66:0x02c4, B:67:0x02cf, B:69:0x02e4, B:71:0x02ec, B:72:0x02f3, B:74:0x02fc, B:78:0x029c, B:79:0x0271, B:82:0x0278, B:85:0x01c1, B:87:0x016c), top: B:4:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x032e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzh zzd(String str) {
        Cursor cursor;
        boolean z5;
        boolean z6;
        Boolean valueOf;
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        Cursor cursor2 = null;
        try {
            cursor = f_().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "admob_app_id", "dynamite_version", "safelisted_events", "ga_app_id", "session_stitching_token", "sgtm_upload_enabled", "target_os_version", "session_stitching_token_hash", "ad_services_version", "unmatched_first_open_without_ad_id", "npa_metadata_value", "attribution_eligibility_status", "sgtm_preview_key", "dma_consent_state", "daily_realtime_dcu_count", "bundle_delivery_index", "serialized_npa_metadata", "unmatched_pfo", "unmatched_uwa", "ad_campaign_info", "client_upload_eligibility"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (!cursor.moveToFirst()) {
                        cursor.close();
                        return null;
                    }
                    zzh zzhVar = new zzh(this.zzg.zzk(), str);
                    zzjj zzb2 = this.zzg.zzb(str);
                    zzjj.zza zzaVar = zzjj.zza.ANALYTICS_STORAGE;
                    if (zzb2.zza(zzaVar)) {
                        zzhVar.zzb(cursor.getString(0));
                    }
                    zzhVar.zzf(cursor.getString(1));
                    if (this.zzg.zzb(str).zza(zzjj.zza.AD_STORAGE)) {
                        zzhVar.zzh(cursor.getString(2));
                    }
                    zzhVar.zzq(cursor.getLong(3));
                    zzhVar.zzr(cursor.getLong(4));
                    zzhVar.zzp(cursor.getLong(5));
                    zzhVar.zzd(cursor.getString(6));
                    zzhVar.zzc(cursor.getString(7));
                    zzhVar.zzn(cursor.getLong(8));
                    zzhVar.zzk(cursor.getLong(9));
                    if (!cursor.isNull(10) && cursor.getInt(10) == 0) {
                        z5 = false;
                        zzhVar.zzb(z5);
                        zzhVar.zzj(cursor.getLong(11));
                        zzhVar.zzh(cursor.getLong(12));
                        zzhVar.zzg(cursor.getLong(13));
                        zzhVar.zze(cursor.getLong(14));
                        zzhVar.zzd(cursor.getLong(15));
                        zzhVar.zzm(cursor.getLong(16));
                        zzhVar.zzb(!cursor.isNull(17) ? -2147483648L : cursor.getInt(17));
                        zzhVar.zze(cursor.getString(18));
                        zzhVar.zzf(cursor.getLong(19));
                        zzhVar.zzi(cursor.getLong(20));
                        zzhVar.zzg(cursor.getString(21));
                        if (!cursor.isNull(23) && cursor.getInt(23) == 0) {
                            z6 = false;
                            zzhVar.zza(z6);
                            zzhVar.zza(cursor.getString(24));
                            zzhVar.zzl(!cursor.isNull(25) ? 0L : cursor.getLong(25));
                            if (!cursor.isNull(26)) {
                                zzhVar.zza(Arrays.asList(cursor.getString(26).split(",", -1)));
                            }
                            if (this.zzg.zzb(str).zza(zzaVar)) {
                                zzhVar.zzj(cursor.getString(28));
                            }
                            zzhVar.zzc(cursor.isNull(29) && cursor.getInt(29) != 0);
                            zzhVar.zzo(cursor.getLong(39));
                            zzhVar.zzk(cursor.getString(36));
                            zzhVar.zzt(cursor.getLong(30));
                            zzhVar.zzs(cursor.getLong(31));
                            if (com.google.android.gms.internal.measurement.zzoy.zza() && zze().zze(str, zzbn.zzcp)) {
                                zzhVar.zza(cursor.getInt(32));
                                zzhVar.zzc(cursor.getLong(35));
                            }
                            zzhVar.zzd(cursor.isNull(33) && cursor.getInt(33) != 0);
                            if (cursor.isNull(34)) {
                                valueOf = Boolean.valueOf(cursor.getInt(34) != 0);
                            } else {
                                valueOf = null;
                            }
                            zzhVar.zza(valueOf);
                            zzhVar.zzd(cursor.getInt(37));
                            zzhVar.zzc(cursor.getInt(38));
                            zzhVar.zzi(!cursor.isNull(40) ? BuildConfig.FLAVOR : (String) Preconditions.checkNotNull(cursor.getString(40)));
                            if (!cursor.isNull(41)) {
                                zzhVar.zza(Long.valueOf(cursor.getLong(41)));
                            }
                            if (!cursor.isNull(42)) {
                                zzhVar.zzb(Long.valueOf(cursor.getLong(42)));
                            }
                            zzhVar.zza(cursor.getBlob(43));
                            if (zze().zze(str, zzbn.zzcj) && !cursor.isNull(44)) {
                                zzhVar.zzb(cursor.getInt(44));
                            }
                            zzhVar.zzao();
                            if (cursor.moveToNext()) {
                                zzj().zzg().zza("Got multiple records for app, expected one. appId", zzgo.zza(str));
                            }
                            cursor.close();
                            return zzhVar;
                        }
                        z6 = true;
                        zzhVar.zza(z6);
                        zzhVar.zza(cursor.getString(24));
                        zzhVar.zzl(!cursor.isNull(25) ? 0L : cursor.getLong(25));
                        if (!cursor.isNull(26)) {
                        }
                        if (this.zzg.zzb(str).zza(zzaVar)) {
                        }
                        zzhVar.zzc(cursor.isNull(29) && cursor.getInt(29) != 0);
                        zzhVar.zzo(cursor.getLong(39));
                        zzhVar.zzk(cursor.getString(36));
                        zzhVar.zzt(cursor.getLong(30));
                        zzhVar.zzs(cursor.getLong(31));
                        if (com.google.android.gms.internal.measurement.zzoy.zza()) {
                            zzhVar.zza(cursor.getInt(32));
                            zzhVar.zzc(cursor.getLong(35));
                        }
                        zzhVar.zzd(cursor.isNull(33) && cursor.getInt(33) != 0);
                        if (cursor.isNull(34)) {
                        }
                        zzhVar.zza(valueOf);
                        zzhVar.zzd(cursor.getInt(37));
                        zzhVar.zzc(cursor.getInt(38));
                        zzhVar.zzi(!cursor.isNull(40) ? BuildConfig.FLAVOR : (String) Preconditions.checkNotNull(cursor.getString(40)));
                        if (!cursor.isNull(41)) {
                        }
                        if (!cursor.isNull(42)) {
                        }
                        zzhVar.zza(cursor.getBlob(43));
                        if (zze().zze(str, zzbn.zzcj)) {
                            zzhVar.zzb(cursor.getInt(44));
                        }
                        zzhVar.zzao();
                        if (cursor.moveToNext()) {
                        }
                        cursor.close();
                        return zzhVar;
                    }
                    z5 = true;
                    zzhVar.zzb(z5);
                    zzhVar.zzj(cursor.getLong(11));
                    zzhVar.zzh(cursor.getLong(12));
                    zzhVar.zzg(cursor.getLong(13));
                    zzhVar.zze(cursor.getLong(14));
                    zzhVar.zzd(cursor.getLong(15));
                    zzhVar.zzm(cursor.getLong(16));
                    zzhVar.zzb(!cursor.isNull(17) ? -2147483648L : cursor.getInt(17));
                    zzhVar.zze(cursor.getString(18));
                    zzhVar.zzf(cursor.getLong(19));
                    zzhVar.zzi(cursor.getLong(20));
                    zzhVar.zzg(cursor.getString(21));
                    if (!cursor.isNull(23)) {
                        z6 = false;
                        zzhVar.zza(z6);
                        zzhVar.zza(cursor.getString(24));
                        zzhVar.zzl(!cursor.isNull(25) ? 0L : cursor.getLong(25));
                        if (!cursor.isNull(26)) {
                        }
                        if (this.zzg.zzb(str).zza(zzaVar)) {
                        }
                        zzhVar.zzc(cursor.isNull(29) && cursor.getInt(29) != 0);
                        zzhVar.zzo(cursor.getLong(39));
                        zzhVar.zzk(cursor.getString(36));
                        zzhVar.zzt(cursor.getLong(30));
                        zzhVar.zzs(cursor.getLong(31));
                        if (com.google.android.gms.internal.measurement.zzoy.zza()) {
                        }
                        zzhVar.zzd(cursor.isNull(33) && cursor.getInt(33) != 0);
                        if (cursor.isNull(34)) {
                        }
                        zzhVar.zza(valueOf);
                        zzhVar.zzd(cursor.getInt(37));
                        zzhVar.zzc(cursor.getInt(38));
                        zzhVar.zzi(!cursor.isNull(40) ? BuildConfig.FLAVOR : (String) Preconditions.checkNotNull(cursor.getString(40)));
                        if (!cursor.isNull(41)) {
                        }
                        if (!cursor.isNull(42)) {
                        }
                        zzhVar.zza(cursor.getBlob(43));
                        if (zze().zze(str, zzbn.zzcj)) {
                        }
                        zzhVar.zzao();
                        if (cursor.moveToNext()) {
                        }
                        cursor.close();
                        return zzhVar;
                    }
                    z6 = true;
                    zzhVar.zza(z6);
                    zzhVar.zza(cursor.getString(24));
                    zzhVar.zzl(!cursor.isNull(25) ? 0L : cursor.getLong(25));
                    if (!cursor.isNull(26)) {
                    }
                    if (this.zzg.zzb(str).zza(zzaVar)) {
                    }
                    zzhVar.zzc(cursor.isNull(29) && cursor.getInt(29) != 0);
                    zzhVar.zzo(cursor.getLong(39));
                    zzhVar.zzk(cursor.getString(36));
                    zzhVar.zzt(cursor.getLong(30));
                    zzhVar.zzs(cursor.getLong(31));
                    if (com.google.android.gms.internal.measurement.zzoy.zza()) {
                    }
                    zzhVar.zzd(cursor.isNull(33) && cursor.getInt(33) != 0);
                    if (cursor.isNull(34)) {
                    }
                    zzhVar.zza(valueOf);
                    zzhVar.zzd(cursor.getInt(37));
                    zzhVar.zzc(cursor.getInt(38));
                    zzhVar.zzi(!cursor.isNull(40) ? BuildConfig.FLAVOR : (String) Preconditions.checkNotNull(cursor.getString(40)));
                    if (!cursor.isNull(41)) {
                    }
                    if (!cursor.isNull(42)) {
                    }
                    zzhVar.zza(cursor.getBlob(43));
                    if (zze().zze(str, zzbn.zzcj)) {
                    }
                    zzhVar.zzao();
                    if (cursor.moveToNext()) {
                    }
                    cursor.close();
                    return zzhVar;
                } catch (SQLiteException e5) {
                    e = e5;
                    zzj().zzg().zza("Error querying app. appId", zzgo.zza(str), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e6) {
            e = e6;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x005a: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:28:0x005a */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzat zze(String str) {
        Cursor cursor;
        Cursor cursor2;
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        Cursor cursor3 = null;
        try {
            try {
                cursor = f_().query("apps", new String[]{"remote_config", "config_last_modified_time", "e_tag"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (!cursor.moveToFirst()) {
                        cursor.close();
                        return null;
                    }
                    byte[] blob = cursor.getBlob(0);
                    String string = cursor.getString(1);
                    String string2 = cursor.getString(2);
                    if (cursor.moveToNext()) {
                        zzj().zzg().zza("Got multiple records for app config, expected one. appId", zzgo.zza(str));
                    }
                    if (blob == null) {
                        cursor.close();
                        return null;
                    }
                    zzat zzatVar = new zzat(blob, string, string2);
                    cursor.close();
                    return zzatVar;
                } catch (SQLiteException e5) {
                    e = e5;
                    zzj().zzg().zza("Error querying remote config. appId", zzgo.zza(str), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor3 = cursor2;
                if (cursor3 != null) {
                    cursor3.close();
                }
                throw th;
            }
        } catch (SQLiteException e6) {
            e = e6;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor3 != null) {
            }
            throw th;
        }
    }

    public final zzbd zzf(String str) {
        Preconditions.checkNotNull(str);
        zzv();
        zzam();
        return zzbd.zza(zza("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, BuildConfig.FLAVOR));
    }

    public final zzjj zzg(String str) {
        Preconditions.checkNotNull(str);
        zzv();
        zzam();
        return zzjj.zzb(zza("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, BuildConfig.FLAVOR));
    }

    public final zzjj zzh(String str) {
        Preconditions.checkNotNull(str);
        zzv();
        zzam();
        zzjj zzjjVar = (zzjj) zza("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{str}, new zzaw() { // from class: com.google.android.gms.measurement.internal.zzaq
            @Override // com.google.android.gms.measurement.internal.zzaw
            public final Object zza(Cursor cursor) {
                zzjj zza2;
                zza2 = zzjj.zza(cursor.getString(0), cursor.getInt(1));
                return zza2;
            }
        });
        return zzjjVar == null ? zzjj.zza : zzjjVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzpi zzi(String str) {
        Cursor cursor;
        Cursor cursor2;
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        Cursor cursor3 = null;
        if (!zze().zza(zzbn.zzch)) {
            return null;
        }
        if (zze().zza(zzbn.zzcj)) {
            List<zzpi> zza2 = zza(str, zzop.zza(zzlu.GOOGLE_SIGNAL), 1);
            if (zza2.isEmpty()) {
                return null;
            }
            return zza2.get(0);
        }
        try {
            cursor = f_().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", "creation_timestamp", "associated_row_id"}, "app_id=? AND NOT " + zzap(), new String[]{str}, null, null, "creation_timestamp ASC", "1");
            try {
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return null;
                }
                cursor2 = cursor;
                try {
                    zzpi zza3 = zza(str, cursor.getLong(0), cursor.getBlob(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5), cursor.getInt(6), cursor.getLong(7), cursor.getLong(8));
                    cursor2.close();
                    return zza3;
                } catch (SQLiteException e5) {
                    e = e5;
                    cursor = cursor2;
                    try {
                        zzj().zzg().zza("Error to querying MeasurementBatch from upload_queue. appId", str, e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        cursor3 = cursor;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor3 = cursor2;
                    if (cursor3 != null) {
                    }
                    throw th;
                }
            } catch (SQLiteException e6) {
                e = e6;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
            }
        } catch (SQLiteException e7) {
            e = e7;
            cursor = null;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final List<zzog> zzj(String str) {
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = f_().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str}, null, null, "rowid", null);
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return arrayList;
                }
                do {
                    String string = cursor.getString(0);
                    if (string == null) {
                        string = BuildConfig.FLAVOR;
                    }
                    arrayList.add(new zzog(string, cursor.getLong(1), cursor.getInt(2)));
                } while (cursor.moveToNext());
                cursor.close();
                return arrayList;
            } catch (SQLiteException e5) {
                zzj().zzg().zza("Error querying trigger uris. appId", zzgo.zza(str), e5);
                List<zzog> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<zzpo> zzk(String str) {
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = f_().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return arrayList;
                }
                do {
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    if (string2 == null) {
                        string2 = BuildConfig.FLAVOR;
                    }
                    String str2 = string2;
                    long j5 = cursor.getLong(2);
                    Object zza2 = zza(cursor, 3);
                    if (zza2 == null) {
                        zzj().zzg().zza("Read invalid user property value, ignoring it. appId", zzgo.zza(str));
                    } else {
                        arrayList.add(new zzpo(str, str2, string, j5, zza2));
                    }
                } while (cursor.moveToNext());
                cursor.close();
                return arrayList;
            } catch (SQLiteException e5) {
                zzj().zzg().zza("Error querying user properties. appId", zzgo.zza(str), e5);
                List<zzpo> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<Integer, zzgf$zzm> zzl(String str) {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor query = f_().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, zzgf$zzm> emptyMap = Collections.emptyMap();
                    query.close();
                    return emptyMap;
                }
                ArrayMap arrayMap = new ArrayMap();
                do {
                    int i5 = query.getInt(0);
                    try {
                        arrayMap.put(Integer.valueOf(i5), (zzgf$zzm) ((com.google.android.gms.internal.measurement.zzkg) ((zzgf$zzm.zza) zzpj.zza(zzgf$zzm.zze(), query.getBlob(1))).zzaj()));
                    } catch (IOException e5) {
                        zzj().zzg().zza("Failed to merge filter results. appId, audienceId, error", zzgo.zza(str), Integer.valueOf(i5), e5);
                    }
                } while (query.moveToNext());
                query.close();
                return arrayMap;
            } catch (SQLiteException e6) {
                zzj().zzg().zza("Database error querying filter results. appId", zzgo.zza(str), e6);
                Map<Integer, zzgf$zzm> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<Integer, List<zzfw$zzb>> zzm(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor query = f_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, List<zzfw$zzb>> emptyMap = Collections.emptyMap();
                    query.close();
                    return emptyMap;
                }
                do {
                    try {
                        zzfw$zzb zzfw_zzb = (zzfw$zzb) ((com.google.android.gms.internal.measurement.zzkg) ((zzfw$zzb.zza) zzpj.zza(zzfw$zzb.zzc(), query.getBlob(1))).zzaj());
                        if (zzfw_zzb.zzk()) {
                            int i5 = query.getInt(0);
                            List list = (List) arrayMap.get(Integer.valueOf(i5));
                            if (list == null) {
                                list = new ArrayList();
                                arrayMap.put(Integer.valueOf(i5), list);
                            }
                            list.add(zzfw_zzb);
                        }
                    } catch (IOException e5) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzgo.zza(str), e5);
                    }
                } while (query.moveToNext());
                query.close();
                return arrayMap;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e6) {
            zzj().zzg().zza("Database error querying filters. appId", zzgo.zza(str), e6);
            Map<Integer, List<zzfw$zzb>> emptyMap2 = Collections.emptyMap();
            if (0 != 0) {
                cursor.close();
            }
            return emptyMap2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<Integer, List<Integer>> zzn(String str) {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = f_().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
                if (!rawQuery.moveToFirst()) {
                    Map<Integer, List<Integer>> emptyMap = Collections.emptyMap();
                    rawQuery.close();
                    return emptyMap;
                }
                do {
                    int i5 = rawQuery.getInt(0);
                    List list = (List) arrayMap.get(Integer.valueOf(i5));
                    if (list == null) {
                        list = new ArrayList();
                        arrayMap.put(Integer.valueOf(i5), list);
                    }
                    list.add(Integer.valueOf(rawQuery.getInt(1)));
                } while (rawQuery.moveToNext());
                rawQuery.close();
                return arrayMap;
            } catch (SQLiteException e5) {
                zzj().zzg().zza("Database error querying scoped filters. appId", zzgo.zza(str), e5);
                Map<Integer, List<Integer>> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zzo(String str) {
        zzbh zzd2;
        zzj("events_snapshot", str);
        Cursor cursor = null;
        try {
            try {
                cursor = f_().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return;
                }
                do {
                    String string = cursor.getString(0);
                    if (string != null && (zzd2 = zzd(str, string)) != null) {
                        zza("events_snapshot", zzd2);
                    }
                } while (cursor.moveToNext());
                cursor.close();
            } catch (SQLiteException e5) {
                zzj().zzg().zza("Error creating snapshot. appId", zzgo.zza(str), e5);
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzp(String str) {
        boolean z5;
        zzbh zzc2;
        ArrayList arrayList = new ArrayList(Arrays.asList("name", "lifetime_count"));
        zzbh zzd2 = zzd(str, "_f");
        zzbh zzd3 = zzd(str, "_v");
        zzj("events", str);
        boolean z6 = false;
        Cursor cursor = null;
        try {
            cursor = f_().query("events_snapshot", (String[]) arrayList.toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
            if (!cursor.moveToFirst()) {
                cursor.close();
                if (zzd2 != null) {
                    zza("events", zzd2);
                } else if (zzd3 != null) {
                    zza("events", zzd3);
                }
                zzj("events_snapshot", str);
                return;
            }
            boolean z7 = false;
            z5 = false;
            do {
                try {
                    String string = cursor.getString(0);
                    if (cursor.getLong(1) >= 1) {
                        if ("_f".equals(string)) {
                            z7 = true;
                        } else if ("_v".equals(string)) {
                            z5 = true;
                        }
                    }
                    if (string != null && (zzc2 = zzc("events_snapshot", str, string)) != null) {
                        zza("events", zzc2);
                    }
                } catch (SQLiteException e5) {
                    e = e5;
                    z6 = z7;
                    try {
                        zzj().zzg().zza("Error querying snapshot. appId", zzgo.zza(str), e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (!z6 && zzd2 != null) {
                            zza("events", zzd2);
                        } else if (!z5 && zzd3 != null) {
                            zza("events", zzd3);
                        }
                        zzj("events_snapshot", str);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (z6 && zzd2 != null) {
                            zza("events", zzd2);
                        } else if (!z5 && zzd3 != null) {
                            zza("events", zzd3);
                        }
                        zzj("events_snapshot", str);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z6 = z7;
                    if (cursor != null) {
                    }
                    if (z6) {
                    }
                    if (!z5) {
                        zza("events", zzd3);
                    }
                    zzj("events_snapshot", str);
                    throw th;
                }
            } while (cursor.moveToNext());
            cursor.close();
            if (!z7 && zzd2 != null) {
                zza("events", zzd2);
            } else if (!z5 && zzd3 != null) {
                zza("events", zzd3);
            }
            zzj("events_snapshot", str);
        } catch (SQLiteException e6) {
            e = e6;
            z5 = false;
        } catch (Throwable th3) {
            th = th3;
            z5 = false;
        }
    }

    public final void zzq() {
        zzam();
        f_().beginTransaction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzw() {
        int delete;
        zzv();
        zzam();
        if (zzab()) {
            long zza2 = zzo().zza.zza();
            long elapsedRealtime = zzb().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza2) > zzai.zzo()) {
                zzo().zza.zza(elapsedRealtime);
                zzv();
                zzam();
                if (!zzab() || (delete = f_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzb().currentTimeMillis()), String.valueOf(zzai.zzm())})) <= 0) {
                    return;
                }
                zzj().zzq().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    public final void zzx() {
        zzam();
        f_().setTransactionSuccessful();
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x002e: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:30:0x002e */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bundle zzc(String str) {
        Cursor cursor;
        Cursor cursor2;
        zzv();
        zzam();
        Cursor cursor3 = null;
        try {
            try {
                cursor = f_().rawQuery("select parameters from default_event_params where app_id=?", new String[]{str});
                try {
                    if (!cursor.moveToFirst()) {
                        zzj().zzq().zza("Default event parameters not found");
                        cursor.close();
                        return null;
                    }
                    try {
                        zzgf$zzf zzgf_zzf = (zzgf$zzf) ((com.google.android.gms.internal.measurement.zzkg) ((zzgf$zzf.zza) zzpj.zza(zzgf$zzf.zze(), cursor.getBlob(0))).zzaj());
                        h_();
                        Bundle zza2 = zzpj.zza(zzgf_zzf.zzh());
                        cursor.close();
                        return zza2;
                    } catch (IOException e5) {
                        zzj().zzg().zza("Failed to retrieve default event parameters. appId", zzgo.zza(str), e5);
                        cursor.close();
                        return null;
                    }
                } catch (SQLiteException e6) {
                    e = e6;
                    zzj().zzg().zza("Error selecting default event parameters", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor3 = cursor2;
                if (cursor3 != null) {
                    cursor3.close();
                }
                throw th;
            }
        } catch (SQLiteException e7) {
            e = e7;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor3 != null) {
            }
            throw th;
        }
    }

    public final int zza(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzv();
        zzam();
        try {
            return f_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error deleting conditional property", zzgo.zza(str), zzi().zzc(str2), e5);
            return 0;
        }
    }

    public final boolean zzq(String str) {
        if (!zze().zza(zzbn.zzch)) {
            return false;
        }
        if (zze().zza(zzbn.zzcj)) {
            zzlu[] zzluVarArr = {zzlu.GOOGLE_SIGNAL};
            ArrayList arrayList = new ArrayList(1);
            for (int i5 = 0; i5 <= 0; i5++) {
                arrayList.add(Integer.valueOf(zzluVarArr[0].zza()));
            }
            String zzb2 = zzb(arrayList);
            String zzap = zzap();
            StringBuilder sb = new StringBuilder("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?");
            sb.append(zzb2);
            sb.append(" AND NOT ");
            sb.append(zzap);
            return zzb(sb.toString(), new String[]{str}) != 0;
        }
        String zzap2 = zzap();
        StringBuilder sb2 = new StringBuilder("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=? AND NOT ");
        sb2.append(zzap2);
        return zzb(sb2.toString(), new String[]{str}) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<Integer, List<zzfw$zzb>> zzf(String str, String str2) {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor query = f_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, List<zzfw$zzb>> emptyMap = Collections.emptyMap();
                    query.close();
                    return emptyMap;
                }
                do {
                    try {
                        zzfw$zzb zzfw_zzb = (zzfw$zzb) ((com.google.android.gms.internal.measurement.zzkg) ((zzfw$zzb.zza) zzpj.zza(zzfw$zzb.zzc(), query.getBlob(1))).zzaj());
                        int i5 = query.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i5));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i5), list);
                        }
                        list.add(zzfw_zzb);
                    } catch (IOException e5) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzgo.zza(str), e5);
                    }
                } while (query.moveToNext());
                query.close();
                return arrayMap;
            } catch (SQLiteException e6) {
                zzj().zzg().zza("Database error querying filters. appId", zzgo.zza(str), e6);
                Map<Integer, List<zzfw$zzb>> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<Integer, List<zzfw$zze>> zzg(String str, String str2) {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor query = f_().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, List<zzfw$zze>> emptyMap = Collections.emptyMap();
                    query.close();
                    return emptyMap;
                }
                do {
                    try {
                        zzfw$zze zzfw_zze = (zzfw$zze) ((com.google.android.gms.internal.measurement.zzkg) ((zzfw$zze.zza) zzpj.zza(zzfw$zze.zzc(), query.getBlob(1))).zzaj());
                        int i5 = query.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i5));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i5), list);
                        }
                        list.add(zzfw_zze);
                    } catch (IOException e5) {
                        zzj().zzg().zza("Failed to merge filter", zzgo.zza(str), e5);
                    }
                } while (query.moveToNext());
                query.close();
                return arrayMap;
            } catch (SQLiteException e6) {
                zzj().zzg().zza("Database error querying filters. appId", zzgo.zza(str), e6);
                Map<Integer, List<zzfw$zze>> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zzh(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzv();
        zzam();
        try {
            f_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error deleting user property. appId", zzgo.zza(str), zzi().zzc(str2), e5);
        }
    }

    public final void zzr() {
        zzam();
        f_().endTransaction();
    }

    public final long zza(String str) {
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        try {
            return f_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zze().zzb(str, zzbn.zzp))))});
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error deleting over the limit events. appId", zzgo.zza(str), e5);
            return 0L;
        }
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x005b: MOVE (r8 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:33:0x005b */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzag zzc(String str, String str2) {
        Cursor cursor;
        Cursor cursor2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzv();
        zzam();
        Cursor cursor3 = null;
        try {
            try {
                cursor = f_().query("conditional_properties", new String[]{"origin", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursor.moveToFirst()) {
                        cursor.close();
                        return null;
                    }
                    String string = cursor.getString(0);
                    if (string == null) {
                        string = BuildConfig.FLAVOR;
                    }
                    String str3 = string;
                    Object zza2 = zza(cursor, 1);
                    boolean z5 = cursor.getInt(2) != 0;
                    String string2 = cursor.getString(3);
                    long j5 = cursor.getLong(4);
                    zzpj h_ = h_();
                    byte[] blob = cursor.getBlob(5);
                    Parcelable.Creator<zzbl> creator = zzbl.CREATOR;
                    zzag zzagVar = new zzag(str, str3, new zzpm(str2, cursor.getLong(8), zza2, str3), cursor.getLong(6), z5, string2, (zzbl) h_.zza(blob, creator), j5, (zzbl) h_().zza(cursor.getBlob(7), creator), cursor.getLong(9), (zzbl) h_().zza(cursor.getBlob(10), creator));
                    if (cursor.moveToNext()) {
                        zzj().zzg().zza("Got multiple records for conditional property, expected one", zzgo.zza(str), zzi().zzc(str2));
                    }
                    cursor.close();
                    return zzagVar;
                } catch (SQLiteException e5) {
                    e = e5;
                    zzj().zzg().zza("Error querying conditional property", zzgo.zza(str), zzi().zzc(str2), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor3 = cursor2;
                if (cursor3 != null) {
                    cursor3.close();
                }
                throw th;
            }
        } catch (SQLiteException e6) {
            e = e6;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor3 != null) {
            }
            throw th;
        }
    }

    private final void zzj(String str, String str2) {
        Preconditions.checkNotEmpty(str2);
        zzv();
        zzam();
        try {
            f_().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error deleting snapshot. appId", zzgo.zza(str2), e5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzpo zze(String str, String str2) {
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzv();
        zzam();
        Cursor cursor2 = null;
        try {
            cursor = f_().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                try {
                    if (!cursor.moveToFirst()) {
                        cursor.close();
                        return null;
                    }
                    long j5 = cursor.getLong(0);
                    Object zza2 = zza(cursor, 1);
                    if (zza2 == null) {
                        cursor.close();
                        return null;
                    }
                    zzpo zzpoVar = new zzpo(str, cursor.getString(2), str2, j5, zza2);
                    if (cursor.moveToNext()) {
                        zzj().zzg().zza("Got multiple records for user property, expected one. appId", zzgo.zza(str));
                    }
                    cursor.close();
                    return zzpoVar;
                } catch (SQLiteException e5) {
                    e = e5;
                    zzj().zzg().zza("Error querying user property. appId", zzgo.zza(str), zzi().zzc(str2), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e6) {
            e = e6;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    public final long zza(zzgf$zzk zzgf_zzk) {
        zzv();
        zzam();
        Preconditions.checkNotNull(zzgf_zzk);
        Preconditions.checkNotEmpty(zzgf_zzk.zzab());
        byte[] zzce = zzgf_zzk.zzce();
        long zza2 = h_().zza(zzce);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzgf_zzk.zzab());
        contentValues.put("metadata_fingerprint", Long.valueOf(zza2));
        contentValues.put("metadata", zzce);
        try {
            f_().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return zza2;
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error storing raw event metadata. appId", zzgo.zza(zzgf_zzk.zzab()), e5);
            throw e5;
        }
    }

    public final boolean zzi(String str, String str2) {
        return zzb("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0;
    }

    public final long zzb(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = f_().rawQuery(str, strArr);
                if (rawQuery.moveToFirst()) {
                    long j5 = rawQuery.getLong(0);
                    rawQuery.close();
                    return j5;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e5) {
                zzj().zzg().zza("Database error", str, e5);
                throw e5;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long zza(String str, zzgf$zzj zzgf_zzj, String str2, Map<String, String> map, zzlu zzluVar, Long l5) {
        int delete;
        zzv();
        zzam();
        Preconditions.checkNotNull(zzgf_zzj);
        Preconditions.checkNotEmpty(str);
        if (!zze().zza(zzbn.zzch)) {
            return -1L;
        }
        zzv();
        zzam();
        if (zzab()) {
            long zza2 = zzo().zzb.zza();
            long elapsedRealtime = zzb().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza2) > zzai.zzo()) {
                zzo().zzb.zza(elapsedRealtime);
                zzv();
                zzam();
                if (zzab() && (delete = f_().delete("upload_queue", zzap(), new String[0])) > 0) {
                    zzj().zzq().zza("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(delete));
                }
                if (zze().zza(zzbn.zzcj)) {
                    zzr(str);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(entry.getKey() + "=" + entry.getValue());
        }
        byte[] zzce = zzgf_zzj.zzce();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("measurement_batch", zzce);
        contentValues.put("upload_uri", str2);
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        if (size > 0) {
            sb.append((CharSequence) arrayList.get(0));
            int i5 = 1;
            while (i5 < size) {
                sb.append((CharSequence) "\r\n");
                Object obj = arrayList.get(i5);
                i5++;
                sb.append((CharSequence) obj);
            }
        }
        contentValues.put("upload_headers", sb.toString());
        contentValues.put("upload_type", Integer.valueOf(zzluVar.zza()));
        contentValues.put("creation_timestamp", Long.valueOf(zzb().currentTimeMillis()));
        contentValues.put("retry_count", (Integer) 0);
        if (l5 != null) {
            contentValues.put("associated_row_id", l5);
        }
        try {
            long insert = f_().insert("upload_queue", null, contentValues);
            if (insert == -1) {
                zzj().zzg().zza("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
            }
            return insert;
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error storing MeasurementBatch to upload_queue. appId", str, e5);
            return -1L;
        }
    }

    private final zzgf$zzk zzb(String str, long j5) {
        zzgf$zzk zzgf_zzk;
        Cursor query;
        Cursor cursor = null;
        try {
            try {
                query = f_().query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str, Long.toString(j5)}, null, null, "rowid", "2");
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    if (!query.moveToFirst()) {
                        zzj().zzg().zza("Raw event metadata record is missing. appId", zzgo.zza(str));
                        query.close();
                        return null;
                    }
                    try {
                        zzgf$zzk zzgf_zzk2 = (zzgf$zzk) ((com.google.android.gms.internal.measurement.zzkg) ((zzgf$zzk.zza) zzpj.zza(zzgf$zzk.zzx(), query.getBlob(0))).zzaj());
                        try {
                            if (query.moveToNext()) {
                                zzj().zzr().zza("Get multiple raw event metadata records, expected one. appId", zzgo.zza(str));
                            }
                            query.close();
                            query.close();
                            return zzgf_zzk2;
                        } catch (SQLiteException e5) {
                            cursor = query;
                            zzgf_zzk = zzgf_zzk2;
                            e = e5;
                            zzj().zzg().zza("Data loss. Error selecting raw event. appId", zzgo.zza(str), e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return zzgf_zzk;
                        }
                    } catch (IOException e6) {
                        zzj().zzg().zza("Data loss. Failed to merge raw event metadata. appId", zzgo.zza(str), e6);
                        query.close();
                        return null;
                    }
                } catch (SQLiteException e7) {
                    e = e7;
                    cursor = query;
                    zzgf_zzk = null;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e8) {
            e = e8;
            zzgf_zzk = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final zzbh zzc(String str, String str2, String str3) {
        Cursor cursor;
        Boolean bool;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        zzv();
        zzam();
        AutoClosingRoomOpenHelper.KeepAliveCursor keepAliveCursor = 0;
        try {
            try {
                cursor = f_().query(str, (String[]) new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count")).toArray(new String[0]), "app_id=? and name=?", new String[]{str2, str3}, null, null, null);
                try {
                    if (!cursor.moveToFirst()) {
                        cursor.close();
                        return null;
                    }
                    long j5 = cursor.getLong(0);
                    long j6 = cursor.getLong(1);
                    long j7 = cursor.getLong(2);
                    long j8 = cursor.isNull(3) ? 0L : cursor.getLong(3);
                    Long valueOf = cursor.isNull(4) ? null : Long.valueOf(cursor.getLong(4));
                    Long valueOf2 = cursor.isNull(5) ? null : Long.valueOf(cursor.getLong(5));
                    Long valueOf3 = cursor.isNull(6) ? null : Long.valueOf(cursor.getLong(6));
                    if (cursor.isNull(7)) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(cursor.getLong(7) == 1);
                    }
                    zzbh zzbhVar = new zzbh(str2, str3, j5, j6, cursor.isNull(8) ? 0L : cursor.getLong(8), j7, j8, valueOf, valueOf2, valueOf3, bool);
                    if (cursor.moveToNext()) {
                        zzj().zzg().zza("Got multiple records for event aggregates, expected one. appId", zzgo.zza(str2));
                    }
                    cursor.close();
                    return zzbhVar;
                } catch (SQLiteException e5) {
                    e = e5;
                    zzj().zzg().zza("Error querying events. appId", zzgo.zza(str2), zzi().zza(str3), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                keepAliveCursor = "current_bundle_count";
                if (keepAliveCursor != 0) {
                    keepAliveCursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e6) {
            e = e6;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (keepAliveCursor != 0) {
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String zzb(long j5) {
        Cursor cursor;
        zzv();
        zzam();
        Cursor cursor2 = null;
        try {
            try {
                cursor = f_().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j5)});
                try {
                    if (!cursor.moveToFirst()) {
                        zzj().zzq().zza("No expired configs for apps with pending events");
                        cursor.close();
                        return null;
                    }
                    String string = cursor.getString(0);
                    cursor.close();
                    return string;
                } catch (SQLiteException e5) {
                    e = e5;
                    zzj().zzg().zza("Error selecting expired configs", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = j5;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e6) {
            e = e6;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    public final zzbh zzd(String str, String str2) {
        return zzc("events", str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zza(String str, String[] strArr, long j5) {
        Cursor cursor = null;
        try {
            try {
                cursor = f_().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    long j6 = cursor.getLong(0);
                    cursor.close();
                    return j6;
                }
                cursor.close();
                return j5;
            } catch (SQLiteException e5) {
                zzj().zzg().zza("Database error", str, e5);
                throw e5;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static String zzb(List<Integer> list) {
        if (list.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        return String.format(" AND (upload_type IN (%s))", TextUtils.join(", ", list));
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a6, code lost:
    
        zzj().zzg().zza("Read more than the max allowed user properties, ignoring excess", java.lang.Integer.valueOf(com.adjust.sdk.Constants.ONE_SECOND));
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<zzpo> zzb(String str, String str2, String str3) {
        String str4;
        ArrayList arrayList;
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        ArrayList arrayList2 = new ArrayList();
        Cursor cursor = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                arrayList = new ArrayList(3);
            } catch (SQLiteException e5) {
                e = e5;
            }
            try {
                arrayList.add(str);
                StringBuilder sb = new StringBuilder("app_id=?");
                if (TextUtils.isEmpty(str2)) {
                    str4 = str2;
                } else {
                    str4 = str2;
                    try {
                        arrayList.add(str4);
                        sb.append(" and origin=?");
                    } catch (SQLiteException e6) {
                        e = e6;
                        zzj().zzg().zza("(2)Error querying user properties", zzgo.zza(str), str4, e);
                        List<zzpo> emptyList = Collections.emptyList();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return emptyList;
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    arrayList.add(str3 + "*");
                    sb.append(" and name glob ?");
                }
                cursor = f_().query("user_attributes", new String[]{"name", "set_timestamp", "value", "origin"}, sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), null, null, "rowid", "1001");
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return arrayList2;
                }
                while (true) {
                    if (arrayList2.size() >= 1000) {
                        break;
                    }
                    String string = cursor.getString(0);
                    long j5 = cursor.getLong(1);
                    try {
                        Object zza2 = zza(cursor, 2);
                        String string2 = cursor.getString(3);
                        if (zza2 == null) {
                            try {
                                zzj().zzg().zza("(2)Read invalid user property value, ignoring it", zzgo.zza(str), string2, str3);
                            } catch (SQLiteException e7) {
                                e = e7;
                                str4 = string2;
                                zzj().zzg().zza("(2)Error querying user properties", zzgo.zza(str), str4, e);
                                List<zzpo> emptyList2 = Collections.emptyList();
                                if (cursor != null) {
                                }
                                return emptyList2;
                            }
                        } else {
                            arrayList2.add(new zzpo(str, string2, string, j5, zza2));
                        }
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        str4 = string2;
                    } catch (SQLiteException e8) {
                        e = e8;
                    }
                }
                cursor.close();
                return arrayList2;
            } catch (SQLiteException e9) {
                e = e9;
                str4 = str2;
                zzj().zzg().zza("(2)Error querying user properties", zzgo.zza(str), str4, e);
                List<zzpo> emptyList22 = Collections.emptyList();
                if (cursor != null) {
                }
                return emptyList22;
            }
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0032: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:30:0x0032 */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<zzgf$zzf, Long> zza(String str, Long l5) {
        Cursor cursor;
        Cursor cursor2;
        zzv();
        zzam();
        Cursor cursor3 = null;
        try {
            try {
                cursor = f_().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l5)});
                try {
                    if (!cursor.moveToFirst()) {
                        zzj().zzq().zza("Main event not found");
                        cursor.close();
                        return null;
                    }
                    try {
                        Pair<zzgf$zzf, Long> create = Pair.create((zzgf$zzf) ((com.google.android.gms.internal.measurement.zzkg) ((zzgf$zzf.zza) zzpj.zza(zzgf$zzf.zze(), cursor.getBlob(0))).zzaj()), Long.valueOf(cursor.getLong(1)));
                        cursor.close();
                        return create;
                    } catch (IOException e5) {
                        zzj().zzg().zza("Failed to merge main event. appId, eventId", zzgo.zza(str), l5, e5);
                        cursor.close();
                        return null;
                    }
                } catch (SQLiteException e6) {
                    e = e6;
                    zzj().zzg().zza("Error selecting main event", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor3 = cursor2;
                if (cursor3 != null) {
                    cursor3.close();
                }
                throw th;
            }
        } catch (SQLiteException e7) {
            e = e7;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor3 != null) {
            }
            throw th;
        }
    }

    public final zzas zza(long j5, String str, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11) {
        return zza(j5, str, 1L, false, false, z7, false, z9, z10, z11);
    }

    public final zzas zza(long j5, String str, long j6, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11) {
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        String[] strArr = {str};
        zzas zzasVar = new zzas();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase f_ = f_();
                Cursor query = f_.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    zzj().zzr().zza("Not updating daily counts, app is not known. appId", zzgo.zza(str));
                    query.close();
                    return zzasVar;
                }
                if (query.getLong(0) == j5) {
                    zzasVar.zzb = query.getLong(1);
                    zzasVar.zza = query.getLong(2);
                    zzasVar.zzc = query.getLong(3);
                    zzasVar.zzd = query.getLong(4);
                    zzasVar.zze = query.getLong(5);
                    zzasVar.zzf = query.getLong(6);
                    zzasVar.zzg = query.getLong(7);
                }
                if (z5) {
                    zzasVar.zzb += j6;
                }
                if (z6) {
                    zzasVar.zza += j6;
                }
                if (z7) {
                    zzasVar.zzc += j6;
                }
                if (z8) {
                    zzasVar.zzd += j6;
                }
                if (z9) {
                    zzasVar.zze += j6;
                }
                if (z10) {
                    zzasVar.zzf += j6;
                }
                if (z11) {
                    zzasVar.zzg += j6;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j5));
                contentValues.put("daily_public_events_count", Long.valueOf(zzasVar.zza));
                contentValues.put("daily_events_count", Long.valueOf(zzasVar.zzb));
                contentValues.put("daily_conversions_count", Long.valueOf(zzasVar.zzc));
                contentValues.put("daily_error_events_count", Long.valueOf(zzasVar.zzd));
                contentValues.put("daily_realtime_events_count", Long.valueOf(zzasVar.zze));
                contentValues.put("daily_realtime_dcu_count", Long.valueOf(zzasVar.zzf));
                contentValues.put("daily_registered_triggers_count", Long.valueOf(zzasVar.zzg));
                f_.update("apps", contentValues, "app_id=?", strArr);
                query.close();
                return zzasVar;
            } catch (SQLiteException e5) {
                zzj().zzg().zza("Error updating daily counts. appId", zzgo.zza(str), e5);
                if (0 != 0) {
                    cursor.close();
                }
                return zzasVar;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(Long l5) {
        zzv();
        zzam();
        Preconditions.checkNotNull(l5);
        if (zze().zza(zzbn.zzch) && zzab()) {
            if (zzb("SELECT COUNT(1) FROM upload_queue WHERE rowid = " + l5 + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                zzj().zzr().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                f_().execSQL("UPDATE upload_queue SET retry_count = retry_count + 1 WHERE rowid = " + l5 + " AND retry_count < 2147483647");
            } catch (SQLiteException e5) {
                zzj().zzg().zza("Error incrementing retry count. error", e5);
            }
        }
    }

    public final void zzb(String str, zzjj zzjjVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjjVar);
        zzv();
        zzam();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzjjVar.zzf());
        contentValues.put("consent_source", Integer.valueOf(zzjjVar.zza()));
        zza("consent_settings", "app_id", contentValues);
    }

    private final boolean zzb(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzam();
        zzv();
        SQLiteDatabase f_ = f_();
        try {
            long zzb2 = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zze().zzb(str, zzbn.zzap)));
            if (zzb2 <= max) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < list.size(); i5++) {
                Integer num = list.get(i5);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String str2 = "(" + TextUtils.join(",", arrayList) + ")";
            StringBuilder sb = new StringBuilder("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb.append(str2);
            sb.append(" order by rowid desc limit -1 offset ?)");
            return f_.delete("audience_filter_values", sb.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Database error querying filters. appId", zzgo.zza(str), e5);
            return false;
        }
    }

    private final zzpi zza(String str, long j5, byte[] bArr, String str2, String str3, int i5, int i6, long j6, long j7) {
        zzlu zzluVar;
        if (TextUtils.isEmpty(str2)) {
            zzj().zzc().zza("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            zzgf$zzj.zzb zzbVar = (zzgf$zzj.zzb) zzpj.zza(zzgf$zzj.zzb(), bArr);
            zzlu[] values = zzlu.values();
            int length = values.length;
            int i7 = 0;
            while (true) {
                if (i7 < length) {
                    zzluVar = values[i7];
                    if (zzluVar.zza() == i5) {
                        break;
                    }
                    i7++;
                } else {
                    zzluVar = zzlu.UNKNOWN;
                    break;
                }
            }
            if (zzluVar != zzlu.GOOGLE_SIGNAL && zzluVar != zzlu.GOOGLE_SIGNAL_PENDING && i6 > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<zzgf$zzk> it = zzbVar.zzd().iterator();
                while (it.hasNext()) {
                    zzgf$zzk.zza zzch = it.next().zzch();
                    zzch.zzi(i6);
                    arrayList.add((zzgf$zzk) ((com.google.android.gms.internal.measurement.zzkg) zzch.zzaj()));
                }
                zzbVar.zzb();
                zzbVar.zza(arrayList);
            }
            HashMap hashMap = new HashMap();
            if (str3 != null) {
                String[] split = str3.split("\r\n");
                int length2 = split.length;
                int i8 = 0;
                while (true) {
                    if (i8 >= length2) {
                        break;
                    }
                    String str4 = split[i8];
                    if (str4.isEmpty()) {
                        break;
                    }
                    String[] split2 = str4.split("=", 2);
                    if (split2.length != 2) {
                        zzj().zzg().zza("Invalid upload header: ", str4);
                        break;
                    }
                    hashMap.put(split2[0], split2[1]);
                    i8++;
                }
            }
            return new zzph().zzc(j5).zza((zzgf$zzj) ((com.google.android.gms.internal.measurement.zzkg) zzbVar.zzaj())).zza(str2).zza(hashMap).zza(zzluVar).zzb(j6).zza(j7).zza();
        } catch (IOException e5) {
            zzj().zzg().zza("Failed to queued MeasurementBatch from upload_queue. appId", str, e5);
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0091: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:25:0x0091 */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzpi zza(long j5) {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3 = null;
        if (!zze().zza(zzbn.zzcj)) {
            return null;
        }
        zzv();
        zzam();
        try {
            try {
                cursor = f_().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", "creation_timestamp", "associated_row_id"}, "rowId=?", new String[]{String.valueOf(j5)}, null, null, null, "1");
                try {
                    if (!cursor.moveToFirst()) {
                        cursor.close();
                        return null;
                    }
                    zzpi zza2 = zza((String) Preconditions.checkNotNull(cursor.getString(1)), j5, cursor.getBlob(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5), cursor.getInt(6), cursor.getLong(7), cursor.getLong(8));
                    cursor.close();
                    return zza2;
                } catch (SQLiteException e5) {
                    e = e5;
                    zzj().zzg().zza("Error to querying MeasurementBatch from upload_queue. rowId", Long.valueOf(j5), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor3 = cursor2;
                if (cursor3 != null) {
                    cursor3.close();
                }
                throw th;
            }
        } catch (SQLiteException e6) {
            e = e6;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor3 != null) {
            }
            throw th;
        }
    }

    private final Object zza(Cursor cursor, int i5) {
        int type = cursor.getType(i5);
        if (type == 0) {
            zzj().zzg().zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i5));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i5));
        }
        if (type == 3) {
            return cursor.getString(i5);
        }
        if (type != 4) {
            zzj().zzg().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        zzj().zzg().zza("Loaded invalid blob type value, ignoring it");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <T> T zza(String str, String[] strArr, zzaw<T> zzawVar) {
        Cursor cursor;
        ?? r02 = 0;
        try {
            try {
                cursor = f_().rawQuery(str, strArr);
                try {
                    if (!cursor.moveToFirst()) {
                        zzj().zzq().zza("No data found");
                        cursor.close();
                        return null;
                    }
                    T zza2 = zzawVar.zza(cursor);
                    cursor.close();
                    return zza2;
                } catch (SQLiteException e5) {
                    e = e5;
                    zzj().zzg().zza("Error querying database.", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r02 = str;
                if (r02 != 0) {
                    r02.close();
                }
                throw th;
            }
        } catch (SQLiteException e6) {
            e = e6;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (r02 != 0) {
            }
            throw th;
        }
    }

    private final String zza(String str, String[] strArr, String str2) {
        Cursor cursor = null;
        try {
            try {
                cursor = f_().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    String string = cursor.getString(0);
                    cursor.close();
                    return string;
                }
                cursor.close();
                return str2;
            } catch (SQLiteException e5) {
                zzj().zzg().zza("Database error", str, e5);
                throw e5;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<Pair<zzgf$zzk, Long>> zza(String str, int i5, int i6) {
        byte[] zzc2;
        long j5;
        long j6;
        zzv();
        zzam();
        int i7 = 1;
        Preconditions.checkArgument(i5 > 0);
        Preconditions.checkArgument(i6 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor query = f_().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i5));
                if (!query.moveToFirst()) {
                    List<Pair<zzgf$zzk, Long>> emptyList = Collections.emptyList();
                    query.close();
                    return emptyList;
                }
                ArrayList arrayList = new ArrayList();
                int i8 = 0;
                while (true) {
                    long j7 = query.getLong(0);
                    try {
                        zzc2 = h_().zzc(query.getBlob(i7));
                    } catch (IOException e5) {
                        zzj().zzg().zza("Failed to unzip queued bundle. appId", zzgo.zza(str), e5);
                    }
                    if (!arrayList.isEmpty() && zzc2.length + i8 > i6) {
                        break;
                    }
                    try {
                        zzgf$zzk.zza zzaVar = (zzgf$zzk.zza) zzpj.zza(zzgf$zzk.zzx(), zzc2);
                        if (!arrayList.isEmpty()) {
                            zzgf$zzk zzgf_zzk = (zzgf$zzk) ((Pair) arrayList.get(0)).first;
                            zzgf$zzk zzgf_zzk2 = (zzgf$zzk) ((com.google.android.gms.internal.measurement.zzkg) zzaVar.zzaj());
                            if (!zzgf_zzk.zzag().equals(zzgf_zzk2.zzag()) || !zzgf_zzk.zzaf().equals(zzgf_zzk2.zzaf()) || zzgf_zzk.zzaw() != zzgf_zzk2.zzaw() || !zzgf_zzk.zzah().equals(zzgf_zzk2.zzah())) {
                                break;
                            }
                            Iterator<zzgf$zzp> it = zzgf_zzk.zzau().iterator();
                            while (true) {
                                j5 = -1;
                                if (!it.hasNext()) {
                                    j6 = -1;
                                    break;
                                }
                                zzgf$zzp next = it.next();
                                if ("_npa".equals(next.zzg())) {
                                    j6 = next.zzc();
                                    break;
                                }
                            }
                            Iterator<zzgf$zzp> it2 = zzgf_zzk2.zzau().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                zzgf$zzp next2 = it2.next();
                                if ("_npa".equals(next2.zzg())) {
                                    j5 = next2.zzc();
                                    break;
                                }
                            }
                            if (j6 != j5) {
                                break;
                            }
                        }
                        if (!query.isNull(2)) {
                            zzaVar.zzi(query.getInt(2));
                        }
                        i8 += zzc2.length;
                        arrayList.add(Pair.create((zzgf$zzk) ((com.google.android.gms.internal.measurement.zzkg) zzaVar.zzaj()), Long.valueOf(j7)));
                    } catch (IOException e6) {
                        zzj().zzg().zza("Failed to merge queued bundle. appId", zzgo.zza(str), e6);
                    }
                    if (!query.moveToNext() || i8 > i6) {
                        break;
                    }
                    i7 = 1;
                }
                query.close();
                return arrayList;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e7) {
            zzj().zzg().zza("Error querying bundles. appId", zzgo.zza(str), e7);
            List<Pair<zzgf$zzk, Long>> emptyList2 = Collections.emptyList();
            if (0 != 0) {
                cursor.close();
            }
            return emptyList2;
        }
    }

    public final List<zzag> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3 + "*");
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        zzj().zzg().zza("Read more than the max allowed conditional properties, ignoring extra", java.lang.Integer.valueOf(com.adjust.sdk.Constants.ONE_SECOND));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<zzag> zza(String str, String[] strArr) {
        zzv();
        zzam();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = f_().query("conditional_properties", new String[]{"app_id", "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", "1001");
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return arrayList;
                }
                while (true) {
                    if (arrayList.size() >= 1000) {
                        break;
                    }
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    String string3 = cursor.getString(2);
                    Object zza2 = zza(cursor, 3);
                    boolean z5 = cursor.getInt(4) != 0;
                    String string4 = cursor.getString(5);
                    long j5 = cursor.getLong(6);
                    zzpj h_ = h_();
                    byte[] blob = cursor.getBlob(7);
                    Parcelable.Creator<zzbl> creator = zzbl.CREATOR;
                    zzbl zzblVar = (zzbl) h_.zza(blob, creator);
                    arrayList.add(new zzag(string, string2, new zzpm(string3, cursor.getLong(10), zza2, string2), cursor.getLong(8), z5, string4, zzblVar, j5, (zzbl) h_().zza(cursor.getBlob(9), creator), cursor.getLong(11), (zzbl) h_().zza(cursor.getBlob(12), creator)));
                    if (!cursor.moveToNext()) {
                        break;
                    }
                }
                cursor.close();
                return arrayList;
            } catch (SQLiteException e5) {
                zzj().zzg().zza("Error querying conditional user property value", e5);
                List<zzag> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<zzpi> zza(String str, zzop zzopVar, int i5) {
        if (!zze().zza(zzbn.zzcj)) {
            return Collections.emptyList();
        }
        Preconditions.checkNotEmpty(str);
        zzv();
        zzam();
        Cursor cursor = null;
        try {
            try {
                cursor = f_().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", "creation_timestamp", "associated_row_id"}, "app_id=?" + zzb(zzopVar.zza) + " AND NOT " + zzap(), new String[]{str}, null, null, "creation_timestamp ASC", i5 > 0 ? String.valueOf(i5) : null);
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    zzpi zza2 = zza(str, cursor.getLong(0), cursor.getBlob(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5), cursor.getInt(6), cursor.getLong(7), cursor.getLong(8));
                    if (zza2 != null) {
                        arrayList.add(zza2);
                    }
                }
                cursor.close();
                return arrayList;
            } catch (SQLiteException e5) {
                zzj().zzg().zza("Error to querying MeasurementBatch from upload_queue. appId", str, e5);
                List<zzpi> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zza(String str, Long l5, String str2, Bundle bundle) {
        zzax zzaxVar;
        zzgf$zzk zzb2;
        String str3 = str;
        Preconditions.checkNotNull(bundle);
        zzv();
        zzam();
        if (zze().zza(zzbn.zzcz) && l5 != null) {
            zzaxVar = new zzax(this, str3, l5.longValue());
        } else {
            zzaxVar = new zzax(this, str3);
        }
        zzax zzaxVar2 = zzaxVar;
        List<zzav> zza2 = zzaxVar2.zza();
        while (!zza2.isEmpty()) {
            for (zzav zzavVar : zza2) {
                if (!TextUtils.isEmpty(str2) && (zzb2 = zzb(str3, zzavVar.zzb)) != null) {
                    Iterator<zzgf$zzp> it = zzb2.zzau().iterator();
                    while (it.hasNext()) {
                        if (it.next().zzg().equals(str2)) {
                            break;
                        }
                    }
                }
                zzpj h_ = h_();
                zzgf$zzf zzgf_zzf = zzavVar.zzd;
                Bundle bundle2 = new Bundle();
                for (zzgf$zzh zzgf_zzh : zzgf_zzf.zzh()) {
                    if (zzgf_zzh.zzj()) {
                        bundle2.putDouble(zzgf_zzh.zzg(), zzgf_zzh.zza());
                    } else if (zzgf_zzh.zzk()) {
                        bundle2.putFloat(zzgf_zzh.zzg(), zzgf_zzh.zzb());
                    } else if (zzgf_zzh.zzl()) {
                        bundle2.putLong(zzgf_zzh.zzg(), zzgf_zzh.zzd());
                    } else if (zzgf_zzh.zzn()) {
                        bundle2.putString(zzgf_zzh.zzg(), zzgf_zzh.zzh());
                    } else if (!zzgf_zzh.zzi().isEmpty()) {
                        bundle2.putParcelableArray(zzgf_zzh.zzg(), zzpj.zzb(zzgf_zzh.zzi()));
                    } else {
                        h_.zzj().zzg().zza("Unexpected parameter type for parameter", zzgf_zzh);
                    }
                }
                String string = bundle2.getString("_o");
                bundle2.remove("_o");
                String zzg = zzgf_zzf.zzg();
                if (string == null) {
                    string = BuildConfig.FLAVOR;
                }
                zzgs zzgsVar = new zzgs(zzg, string, bundle2, zzgf_zzf.zzd());
                zzs().zza(zzgsVar.zzc, bundle);
                zza(zzavVar.zza, new zzbe(this.zzu, zzgsVar.zzb, str, zzavVar.zzd.zzg(), zzavVar.zzd.zzd(), zzavVar.zzd.zzc(), zzgsVar.zzc), zzavVar.zzb, zzavVar.zzc);
                str3 = str;
            }
            zza2 = zzaxVar2.zza();
            str3 = str;
        }
    }

    public final void zza(Long l5) {
        zzv();
        zzam();
        Preconditions.checkNotNull(l5);
        if (zze().zza(zzbn.zzch)) {
            try {
                if (f_().delete("upload_queue", "rowid=?", new String[]{String.valueOf(l5)}) != 1) {
                    zzj().zzr().zza("Deleted fewer rows from upload_queue than expected");
                }
            } catch (SQLiteException e5) {
                zzj().zzg().zza("Failed to delete a MeasurementBatch in a upload_queue table", e5);
                throw e5;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(List<Long> list) {
        zzv();
        zzam();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzab()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (zzb("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                zzj().zzr().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                f_().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e5) {
                zzj().zzg().zza("Error incrementing retry count. error", e5);
            }
        }
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(String str, List<zzfw$zza> list) {
        boolean z5;
        boolean z6;
        Preconditions.checkNotNull(list);
        for (int i5 = 0; i5 < list.size(); i5++) {
            zzfw$zza.zza zzch = list.get(i5).zzch();
            if (zzch.zza() != 0) {
                for (int i6 = 0; i6 < zzch.zza(); i6++) {
                    zzfw$zzb.zza zzch2 = zzch.zza(i6).zzch();
                    zzfw$zzb.zza zzaVar = (zzfw$zzb.zza) ((zzkg.zza) zzch2.clone());
                    String zzb2 = zzjp.zzb(zzch2.zzb());
                    if (zzb2 != null) {
                        zzaVar.zza(zzb2);
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    for (int i7 = 0; i7 < zzch2.zza(); i7++) {
                        zzfw$zzc zza2 = zzch2.zza(i7);
                        String zza3 = zzjo.zza(zza2.zze());
                        if (zza3 != null) {
                            zzaVar.zza(i7, (zzfw$zzc) ((com.google.android.gms.internal.measurement.zzkg) zza2.zzch().zza(zza3).zzaj()));
                            z6 = true;
                        }
                    }
                    if (z6) {
                        zzfw$zza.zza zza4 = zzch.zza(i6, zzaVar);
                        list.set(i5, (zzfw$zza) ((com.google.android.gms.internal.measurement.zzkg) zza4.zzaj()));
                        zzch = zza4;
                    }
                }
            }
            if (zzch.zzb() != 0) {
                for (int i8 = 0; i8 < zzch.zzb(); i8++) {
                    zzfw$zze zzb3 = zzch.zzb(i8);
                    String zza5 = zzjr.zza(zzb3.zze());
                    if (zza5 != null) {
                        zzch = zzch.zza(i8, zzb3.zzch().zza(zza5));
                        list.set(i5, (zzfw$zza) ((com.google.android.gms.internal.measurement.zzkg) zzch.zzaj()));
                    }
                }
            }
        }
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase f_ = f_();
        f_.beginTransaction();
        try {
            zzam();
            zzv();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase f_2 = f_();
            f_2.delete("property_filters", "app_id=?", new String[]{str});
            f_2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzfw$zza zzfw_zza : list) {
                zzam();
                zzv();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzfw_zza);
                if (!zzfw_zza.zzg()) {
                    zzj().zzr().zza("Audience with no ID. appId", zzgo.zza(str));
                } else {
                    int zza6 = zzfw_zza.zza();
                    Iterator<zzfw$zzb> it = zzfw_zza.zze().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().zzl()) {
                                zzj().zzr().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzgo.zza(str), Integer.valueOf(zza6));
                                break;
                            }
                        } else {
                            Iterator<zzfw$zze> it2 = zzfw_zza.zzf().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().zzi()) {
                                        zzj().zzr().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzgo.zza(str), Integer.valueOf(zza6));
                                        break;
                                    }
                                } else {
                                    Iterator<zzfw$zzb> it3 = zzfw_zza.zze().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!zza(str, zza6, it3.next())) {
                                                z5 = false;
                                                break;
                                            }
                                        } else {
                                            z5 = true;
                                            break;
                                        }
                                    }
                                    if (z5) {
                                        Iterator<zzfw$zze> it4 = zzfw_zza.zzf().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!zza(str, zza6, it4.next())) {
                                                    z5 = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z5) {
                                        zzam();
                                        zzv();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase f_3 = f_();
                                        f_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(zza6)});
                                        f_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(zza6)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzfw$zza zzfw_zza2 : list) {
                arrayList.add(zzfw_zza2.zzg() ? Integer.valueOf(zzfw_zza2.zza()) : null);
            }
            zzb(str, arrayList);
            f_.setTransactionSuccessful();
            f_.endTransaction();
        } catch (Throwable th) {
            f_.endTransaction();
            throw th;
        }
    }

    public final void zza(zzh zzhVar, boolean z5, boolean z6) {
        Preconditions.checkNotNull(zzhVar);
        zzv();
        zzam();
        String zzac = zzhVar.zzac();
        Preconditions.checkNotNull(zzac);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzac);
        if (z5) {
            contentValues.put("app_instance_id", (String) null);
        } else if (this.zzg.zzb(zzac).zza(zzjj.zza.ANALYTICS_STORAGE)) {
            contentValues.put("app_instance_id", zzhVar.zzad());
        }
        contentValues.put("gmp_app_id", zzhVar.zzah());
        if (this.zzg.zzb(zzac).zza(zzjj.zza.AD_STORAGE)) {
            contentValues.put("resettable_device_id_hash", zzhVar.zzaj());
        }
        contentValues.put("last_bundle_index", Long.valueOf(zzhVar.zzt()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzhVar.zzu()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzhVar.zzs()));
        contentValues.put("app_version", zzhVar.zzaf());
        contentValues.put("app_store", zzhVar.zzae());
        contentValues.put("gmp_version", Long.valueOf(zzhVar.zzq()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzhVar.zzn()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzhVar.zzar()));
        contentValues.put("day", Long.valueOf(zzhVar.zzm()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzhVar.zzk()));
        contentValues.put("daily_events_count", Long.valueOf(zzhVar.zzj()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzhVar.zzh()));
        contentValues.put("config_fetched_time", Long.valueOf(zzhVar.zzg()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzhVar.zzp()));
        contentValues.put("app_version_int", Long.valueOf(zzhVar.zze()));
        contentValues.put("firebase_instance_id", zzhVar.zzag());
        contentValues.put("daily_error_events_count", Long.valueOf(zzhVar.zzi()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzhVar.zzl()));
        contentValues.put("health_monitor_sample", zzhVar.zzai());
        contentValues.put("android_id", (Long) 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzhVar.zzaq()));
        contentValues.put("admob_app_id", zzhVar.zzaa());
        contentValues.put("dynamite_version", Long.valueOf(zzhVar.zzo()));
        if (this.zzg.zzb(zzac).zza(zzjj.zza.ANALYTICS_STORAGE)) {
            contentValues.put("session_stitching_token", zzhVar.zzal());
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzhVar.zzat()));
        contentValues.put("target_os_version", Long.valueOf(zzhVar.zzw()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzhVar.zzv()));
        if (com.google.android.gms.internal.measurement.zzoy.zza() && zze().zze(zzac, zzbn.zzcp)) {
            contentValues.put("ad_services_version", Integer.valueOf(zzhVar.zza()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(zzhVar.zzf()));
        }
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(zzhVar.zzau()));
        contentValues.put("npa_metadata_value", zzhVar.zzx());
        contentValues.put("bundle_delivery_index", Long.valueOf(zzhVar.zzr()));
        contentValues.put("sgtm_preview_key", zzhVar.zzam());
        contentValues.put("dma_consent_state", Integer.valueOf(zzhVar.zzd()));
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(zzhVar.zzc()));
        contentValues.put("serialized_npa_metadata", zzhVar.zzak());
        if (zze().zze(zzac, zzbn.zzcj)) {
            contentValues.put("client_upload_eligibility", Integer.valueOf(zzhVar.zzb()));
        }
        List<String> zzan = zzhVar.zzan();
        if (zzan != null) {
            if (zzan.isEmpty()) {
                zzj().zzr().zza("Safelisted events should not be an empty list. appId", zzac);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzan));
            }
        }
        if (com.google.android.gms.internal.measurement.zzog.zza() && zze().zza(zzbn.zzce) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        contentValues.put("unmatched_pfo", zzhVar.zzy());
        contentValues.put("unmatched_uwa", zzhVar.zzz());
        contentValues.put("ad_campaign_info", zzhVar.zzav());
        try {
            SQLiteDatabase f_ = f_();
            if (f_.update("apps", contentValues, "app_id = ?", new String[]{zzac}) == 0 && f_.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update app (got -1). appId", zzgo.zza(zzac));
            }
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error storing app. appId", zzgo.zza(zzac), e5);
        }
    }

    public final void zza(String str, zzbd zzbdVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzbdVar);
        zzv();
        zzam();
        zzjj zzh2 = zzh(str);
        zzjj zzjjVar = zzjj.zza;
        if (zzh2 == zzjjVar) {
            zzb(str, zzjjVar);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", zzbdVar.zzf());
        zza("consent_settings", "app_id", contentValues);
    }

    public final void zza(zzbh zzbhVar) {
        zza("events", zzbhVar);
    }

    private final void zza(String str, zzbh zzbhVar) {
        Preconditions.checkNotNull(zzbhVar);
        zzv();
        zzam();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbhVar.zza);
        contentValues.put("name", zzbhVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzbhVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzbhVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbhVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbhVar.zzg));
        contentValues.put("last_bundled_day", zzbhVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzbhVar.zzi);
        contentValues.put("last_sampling_rate", zzbhVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzbhVar.zze));
        Boolean bool = zzbhVar.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (f_().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update event aggregates (got -1). appId", zzgo.zza(zzbhVar.zza));
            }
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error storing event aggregates. appId", zzgo.zza(zzbhVar.zza), e5);
        }
    }

    private final void zza(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase f_ = f_();
            if (contentValues.getAsString(str2) == null) {
                zzj().zzm().zza("Value of the primary key is not set.", zzgo.zza(str2));
                return;
            }
            if (f_.update(str, contentValues, str2 + " = ?", new String[]{r1}) == 0 && f_.insertWithOnConflict(str, null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update table (got -1). key", zzgo.zza(str), zzgo.zza(str2));
            }
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error storing into table. key", zzgo.zza(str), zzgo.zza(str2), e5);
        }
    }

    public final void zza(String str, zzjj zzjjVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjjVar);
        zzv();
        zzam();
        zzb(str, zzh(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", zzjjVar.zzf());
        zza("consent_settings", "app_id", contentValues);
    }

    public final boolean zza(zzgf$zzk zzgf_zzk, boolean z5) {
        zzv();
        zzam();
        Preconditions.checkNotNull(zzgf_zzk);
        Preconditions.checkNotEmpty(zzgf_zzk.zzab());
        Preconditions.checkState(zzgf_zzk.zzbm());
        zzw();
        long currentTimeMillis = zzb().currentTimeMillis();
        if (zzgf_zzk.zzn() < currentTimeMillis - zzai.zzm() || zzgf_zzk.zzn() > zzai.zzm() + currentTimeMillis) {
            zzj().zzr().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzgo.zza(zzgf_zzk.zzab()), Long.valueOf(currentTimeMillis), Long.valueOf(zzgf_zzk.zzn()));
        }
        try {
            byte[] zzb2 = h_().zzb(zzgf_zzk.zzce());
            zzj().zzq().zza("Saving bundle, size", Integer.valueOf(zzb2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzgf_zzk.zzab());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzgf_zzk.zzn()));
            contentValues.put("data", zzb2);
            contentValues.put("has_realtime", Integer.valueOf(z5 ? 1 : 0));
            if (zzgf_zzk.zzbt()) {
                contentValues.put("retry_count", Integer.valueOf(zzgf_zzk.zzg()));
            }
            try {
                if (f_().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzj().zzg().zza("Failed to insert bundle (got -1). appId", zzgo.zza(zzgf_zzk.zzab()));
                return false;
            } catch (SQLiteException e5) {
                zzj().zzg().zza("Error storing bundle. appId", zzgo.zza(zzgf_zzk.zzab()), e5);
                return false;
            }
        } catch (IOException e6) {
            zzj().zzg().zza("Data loss. Failed to serialize bundle. appId", zzgo.zza(zzgf_zzk.zzab()), e6);
            return false;
        }
    }

    private final boolean zza(String str, int i5, zzfw$zzb zzfw_zzb) {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzfw_zzb);
        if (zzfw_zzb.zzf().isEmpty()) {
            zzj().zzr().zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzgo.zza(str), Integer.valueOf(i5), String.valueOf(zzfw_zzb.zzl() ? Integer.valueOf(zzfw_zzb.zzb()) : null));
            return false;
        }
        byte[] zzce = zzfw_zzb.zzce();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i5));
        contentValues.put("filter_id", zzfw_zzb.zzl() ? Integer.valueOf(zzfw_zzb.zzb()) : null);
        contentValues.put("event_name", zzfw_zzb.zzf());
        contentValues.put("session_scoped", zzfw_zzb.zzm() ? Boolean.valueOf(zzfw_zzb.zzj()) : null);
        contentValues.put("data", zzce);
        try {
            if (f_().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert event filter (got -1). appId", zzgo.zza(str));
            return true;
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error storing event filter. appId", zzgo.zza(str), e5);
            return false;
        }
    }

    private final boolean zza(String str, int i5, zzfw$zze zzfw_zze) {
        zzam();
        zzv();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzfw_zze);
        if (zzfw_zze.zze().isEmpty()) {
            zzj().zzr().zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzgo.zza(str), Integer.valueOf(i5), String.valueOf(zzfw_zze.zzi() ? Integer.valueOf(zzfw_zze.zza()) : null));
            return false;
        }
        byte[] zzce = zzfw_zze.zzce();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i5));
        contentValues.put("filter_id", zzfw_zze.zzi() ? Integer.valueOf(zzfw_zze.zza()) : null);
        contentValues.put("property_name", zzfw_zze.zze());
        contentValues.put("session_scoped", zzfw_zze.zzj() ? Boolean.valueOf(zzfw_zze.zzh()) : null);
        contentValues.put("data", zzce);
        try {
            if (f_().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert property filter (got -1). appId", zzgo.zza(str));
            return false;
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error storing property filter. appId", zzgo.zza(str), e5);
            return false;
        }
    }

    public final boolean zza(zzbe zzbeVar, long j5, boolean z5) {
        zzv();
        zzam();
        Preconditions.checkNotNull(zzbeVar);
        Preconditions.checkNotEmpty(zzbeVar.zza);
        byte[] zzce = h_().zza(zzbeVar).zzce();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbeVar.zza);
        contentValues.put("name", zzbeVar.zzb);
        contentValues.put("timestamp", Long.valueOf(zzbeVar.zzd));
        contentValues.put("metadata_fingerprint", Long.valueOf(j5));
        contentValues.put("data", zzce);
        contentValues.put("realtime", Integer.valueOf(z5 ? 1 : 0));
        try {
            if (f_().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert raw event (got -1). appId", zzgo.zza(zzbeVar.zza));
            return false;
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error storing raw event. appId", zzgo.zza(zzbeVar.zza), e5);
            return false;
        }
    }

    public final boolean zza(String str, zzog zzogVar) {
        zzv();
        zzam();
        Preconditions.checkNotNull(zzogVar);
        Preconditions.checkNotEmpty(str);
        long currentTimeMillis = zzb().currentTimeMillis();
        long j5 = zzogVar.zzb;
        zzfx<Long> zzfxVar = zzbn.zzbp;
        if (j5 < currentTimeMillis - zzfxVar.zza(null).longValue() || zzogVar.zzb > zzfxVar.zza(null).longValue() + currentTimeMillis) {
            zzj().zzr().zza("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzgo.zza(str), Long.valueOf(currentTimeMillis), Long.valueOf(zzogVar.zzb));
        }
        zzj().zzq().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzogVar.zza);
        contentValues.put("source", Integer.valueOf(zzogVar.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(zzogVar.zzb));
        try {
            if (f_().insert("trigger_uris", null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert trigger URI (got -1). appId", zzgo.zza(str));
            return false;
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error storing trigger URI. appId", zzgo.zza(str), e5);
            return false;
        }
    }

    public final boolean zza(String str, Long l5, long j5, zzgf$zzf zzgf_zzf) {
        zzv();
        zzam();
        Preconditions.checkNotNull(zzgf_zzf);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l5);
        byte[] zzce = zzgf_zzf.zzce();
        zzj().zzq().zza("Saving complex main event, appId, data size", zzi().zza(str), Integer.valueOf(zzce.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l5);
        contentValues.put("children_to_process", Long.valueOf(j5));
        contentValues.put("main_event", zzce);
        try {
            if (f_().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert complex main event (got -1). appId", zzgo.zza(str));
            return false;
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error storing complex main event. appId", zzgo.zza(str), e5);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(String str, long j5) {
        if (!zze().zza(zzbn.zzcz) && zzb().currentTimeMillis() > 15000 + j5) {
            return false;
        }
        try {
            if (zza("select count(*) from raw_events where app_id=? and timestamp >= ? and name not like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j5)}, 0L) > 0) {
                return false;
            }
            return zza("select count(*) from raw_events where app_id=? and timestamp >= ? and name like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j5)}, 0L) > 0;
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error checking backfill conditions", e5);
            return false;
        }
    }

    public final boolean zza(zzag zzagVar) {
        Preconditions.checkNotNull(zzagVar);
        zzv();
        zzam();
        String str = zzagVar.zza;
        Preconditions.checkNotNull(str);
        if (zze(str, zzagVar.zzc.zza) == null && zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzagVar.zzb);
        contentValues.put("name", zzagVar.zzc.zza);
        zza(contentValues, "value", Preconditions.checkNotNull(zzagVar.zzc.zza()));
        contentValues.put("active", Boolean.valueOf(zzagVar.zze));
        contentValues.put("trigger_event_name", zzagVar.zzf);
        contentValues.put("trigger_timeout", Long.valueOf(zzagVar.zzh));
        zzs();
        contentValues.put("timed_out_event", zzpn.zza((Parcelable) zzagVar.zzg));
        contentValues.put("creation_timestamp", Long.valueOf(zzagVar.zzd));
        zzs();
        contentValues.put("triggered_event", zzpn.zza((Parcelable) zzagVar.zzi));
        contentValues.put("triggered_timestamp", Long.valueOf(zzagVar.zzc.zzb));
        contentValues.put("time_to_live", Long.valueOf(zzagVar.zzj));
        zzs();
        contentValues.put("expired_event", zzpn.zza((Parcelable) zzagVar.zzk));
        try {
            if (f_().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert/update conditional user property (got -1)", zzgo.zza(str));
            return true;
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error storing conditional user property", zzgo.zza(str), e5);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(String str, Bundle bundle) {
        zzv();
        zzam();
        byte[] zzce = h_().zza(new zzbe(this.zzu, BuildConfig.FLAVOR, str, "dep", 0L, 0L, bundle)).zzce();
        zzj().zzq().zza("Saving default event parameters, appId, data size", zzi().zza(str), Integer.valueOf(zzce.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", zzce);
        try {
            if (f_().insertWithOnConflict("default_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert default event parameters (got -1). appId", zzgo.zza(str));
            return false;
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error storing default event parameters. appId", zzgo.zza(str), e5);
            return false;
        }
    }

    private final boolean zza(long j5, zzbe zzbeVar, long j6, boolean z5) {
        zzv();
        zzam();
        Preconditions.checkNotNull(zzbeVar);
        Preconditions.checkNotEmpty(zzbeVar.zza);
        byte[] zzce = h_().zza(zzbeVar).zzce();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbeVar.zza);
        contentValues.put("name", zzbeVar.zzb);
        contentValues.put("timestamp", Long.valueOf(zzbeVar.zzd));
        contentValues.put("metadata_fingerprint", Long.valueOf(j6));
        contentValues.put("data", zzce);
        contentValues.put("realtime", Integer.valueOf(z5 ? 1 : 0));
        try {
            long update = f_().update("raw_events", contentValues, "rowid = ?", new String[]{String.valueOf(j5)});
            if (update == 1) {
                return true;
            }
            zzj().zzg().zza("Failed to update raw event. appId, updatedRows", zzgo.zza(zzbeVar.zza), Long.valueOf(update));
            return false;
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error updating raw event. appId", zzgo.zza(zzbeVar.zza), e5);
            return false;
        }
    }

    public final boolean zza(zzpo zzpoVar) {
        Preconditions.checkNotNull(zzpoVar);
        zzv();
        zzam();
        if (zze(zzpoVar.zza, zzpoVar.zzc) == null) {
            if (zzpn.zzg(zzpoVar.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzpoVar.zza}) >= zze().zza(zzpoVar.zza, zzbn.zzaq, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(zzpoVar.zzc) && zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzpoVar.zza, zzpoVar.zzb}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzpoVar.zza);
        contentValues.put("origin", zzpoVar.zzb);
        contentValues.put("name", zzpoVar.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzpoVar.zzd));
        zza(contentValues, "value", zzpoVar.zze);
        try {
            if (f_().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert/update user property (got -1). appId", zzgo.zza(zzpoVar.zza));
            return true;
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error storing user property. appId", zzgo.zza(zzpoVar.zza), e5);
            return true;
        }
    }
}
