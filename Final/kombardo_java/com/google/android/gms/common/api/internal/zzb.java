package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzb implements Runnable {
    final /* synthetic */ LifecycleCallback zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzc zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(zzc zzcVar, LifecycleCallback lifecycleCallback, String str) {
        this.zza = lifecycleCallback;
        this.zzb = str;
        this.zzc = zzcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        zzc zzcVar = this.zzc;
        i5 = zzcVar.zzb;
        if (i5 > 0) {
            LifecycleCallback lifecycleCallback = this.zza;
            bundle = zzcVar.zzc;
            if (bundle != null) {
                String str = this.zzb;
                bundle3 = zzcVar.zzc;
                bundle2 = bundle3.getBundle(str);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.onCreate(bundle2);
        }
        i6 = this.zzc.zzb;
        if (i6 >= 2) {
            this.zza.onStart();
        }
        i7 = this.zzc.zzb;
        if (i7 >= 3) {
            this.zza.onResume();
        }
        i8 = this.zzc.zzb;
        if (i8 >= 4) {
            this.zza.onStop();
        }
        i9 = this.zzc.zzb;
        if (i9 >= 5) {
            this.zza.onDestroy();
        }
    }
}
