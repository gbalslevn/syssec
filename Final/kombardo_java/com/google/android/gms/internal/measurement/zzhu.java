package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import androidx.collection.ArrayMap;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public abstract class zzhu {
    private static final ArrayMap<String, Uri> zza = new ArrayMap<>();

    public static synchronized Uri zza(String str) {
        Uri uri;
        synchronized (zzhu.class) {
            ArrayMap<String, Uri> arrayMap = zza;
            uri = arrayMap.get(str);
            if (uri == null) {
                uri = Uri.parse("content://com.google.android.gms.phenotype/" + Uri.encode(str));
                arrayMap.put(str, uri);
            }
        }
        return uri;
    }

    public static String zza(Context context, String str) {
        if (!str.contains("#")) {
            return str + "#" + BuildConfig.FLAVOR + context.getPackageName();
        }
        throw new IllegalArgumentException("The passed in package cannot already have a subpackage: " + str);
    }

    public static boolean zza(String str, String str2) {
        if (str.equals("eng") || str.equals("userdebug")) {
            return str2.contains("dev-keys") || str2.contains("test-keys");
        }
        return false;
    }
}
