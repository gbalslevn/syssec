package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.google.common.base.Optional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzht {

    /* loaded from: classes.dex */
    public static class zza {
        private static volatile Optional<zzhr> zza;

        public static Optional<zzhr> zza(Context context) {
            Optional<zzhr> zza2;
            Optional<zzhr> optional = zza;
            if (optional == null) {
                synchronized (zza.class) {
                    try {
                        optional = zza;
                        if (optional == null) {
                            new zzht();
                            if (zzhu.zza(Build.TYPE, Build.TAGS)) {
                                if (zzhg.zza() && !context.isDeviceProtectedStorage()) {
                                    context = context.createDeviceProtectedStorageContext();
                                }
                                zza2 = zzht.zza(context);
                            } else {
                                zza2 = Optional.absent();
                            }
                            zza = zza2;
                            optional = zza2;
                        }
                    } finally {
                    }
                }
            }
            return optional;
        }
    }

    private static zzhr zza(Context context, File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
                HashMap hashMap = new HashMap();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String[] split = readLine.split(" ", 3);
                        if (split.length != 3) {
                            Log.e("HermeticFileOverrides", "Invalid: " + readLine);
                        } else {
                            String zza2 = zza(split[0]);
                            String decode = Uri.decode(zza(split[1]));
                            String str = (String) hashMap.get(split[2]);
                            if (str == null) {
                                String zza3 = zza(split[2]);
                                str = Uri.decode(zza3);
                                if (str.length() < 1024 || str == zza3) {
                                    hashMap.put(zza3, str);
                                }
                            }
                            SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) simpleArrayMap.get(zza2);
                            if (simpleArrayMap2 == null) {
                                simpleArrayMap2 = new SimpleArrayMap();
                                simpleArrayMap.put(zza2, simpleArrayMap2);
                            }
                            simpleArrayMap2.put(decode, str);
                        }
                    } else {
                        Log.w("HermeticFileOverrides", "Parsed " + String.valueOf(file) + " for Android package " + context.getPackageName());
                        zzhm zzhmVar = new zzhm(simpleArrayMap);
                        bufferedReader.close();
                        return zzhmVar;
                    }
                }
            } finally {
            }
        } catch (IOException e5) {
            throw new RuntimeException(e5);
        }
    }

    private static Optional<File> zzb(Context context) {
        try {
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            return file.exists() ? Optional.of(file) : Optional.absent();
        } catch (RuntimeException e5) {
            Log.e("HermeticFileOverrides", "no data dir", e5);
            return Optional.absent();
        }
    }

    static Optional<zzhr> zza(Context context) {
        Optional<zzhr> absent;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            Optional<File> zzb = zzb(context);
            if (zzb.isPresent()) {
                absent = Optional.of(zza(context, zzb.get()));
            } else {
                absent = Optional.absent();
            }
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return absent;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    private static final String zza(String str) {
        return new String(str);
    }
}
