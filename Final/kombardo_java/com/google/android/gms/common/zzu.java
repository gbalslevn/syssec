package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class zzu extends zzw {
    private final Callable zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzu(Callable callable, zzv zzvVar) {
        super();
        this.zze = callable;
    }

    @Override // com.google.android.gms.common.zzw
    final String zza() {
        try {
            return (String) this.zze.call();
        } catch (Exception e5) {
            throw new RuntimeException(e5);
        }
    }
}
