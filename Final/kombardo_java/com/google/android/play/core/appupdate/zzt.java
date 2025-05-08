package com.google.android.play.core.appupdate;

import android.content.Context;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzt {
    private final Context zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(Context context) {
        this.zza = context;
    }

    private static long zzb(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j5 = 0;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                j5 += zzb(file2);
            }
        }
        return j5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zza() {
        return zzb(new File(this.zza.getFilesDir(), "assetpacks"));
    }
}
