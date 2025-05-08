package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zak;

/* loaded from: classes.dex */
final class zacr implements Runnable {
    final /* synthetic */ zak zaa;
    final /* synthetic */ zact zab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zacr(zact zactVar, zak zakVar) {
        this.zab = zactVar;
        this.zaa = zakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zact.zad(this.zab, this.zaa);
    }
}
