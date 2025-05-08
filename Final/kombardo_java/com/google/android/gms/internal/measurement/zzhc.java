package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzhc implements zzhe {
    @Override // com.google.android.gms.internal.measurement.zzhe
    public final String zza(ContentResolver contentResolver, String str) {
        Uri uri = zzgw.zza;
        ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        try {
            if (acquireUnstableContentProviderClient != null) {
                try {
                    Cursor query = acquireUnstableContentProviderClient.query(uri, null, null, new String[]{str}, null);
                    try {
                        if (query != null) {
                            if (query.moveToFirst()) {
                                String string = query.getString(1);
                                query.close();
                                return string;
                            }
                            query.close();
                            acquireUnstableContentProviderClient.release();
                            return null;
                        }
                        throw new zzhd("ContentProvider query returned null cursor");
                    } catch (Throwable th) {
                        if (query != null) {
                            try {
                                query.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (RemoteException e5) {
                    throw new zzhd("ContentProvider query failed", e5);
                }
            }
            throw new zzhd("Unable to acquire ContentProviderClient");
        } finally {
            acquireUnstableContentProviderClient.release();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhe
    public final <T extends Map<String, String>> T zza(ContentResolver contentResolver, String[] strArr, zzhb<T> zzhbVar) {
        Uri uri = zzgw.zzb;
        ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        if (acquireUnstableContentProviderClient != null) {
            try {
                try {
                    Cursor query = acquireUnstableContentProviderClient.query(uri, null, null, strArr, null);
                    try {
                        if (query != null) {
                            T zza = zzhbVar.zza(query.getCount());
                            while (query.moveToNext()) {
                                zza.put(query.getString(0), query.getString(1));
                            }
                            if (query.isAfterLast()) {
                                query.close();
                                return zza;
                            }
                            throw new zzhd("Cursor read incomplete (ContentProvider dead?)");
                        }
                        throw new zzhd("ContentProvider query returned null cursor");
                    } catch (Throwable th) {
                        if (query != null) {
                            try {
                                query.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (RemoteException e5) {
                    throw new zzhd("ContentProvider query failed", e5);
                }
            } finally {
                acquireUnstableContentProviderClient.release();
            }
        }
        throw new zzhd("Unable to acquire ContentProviderClient");
    }
}
